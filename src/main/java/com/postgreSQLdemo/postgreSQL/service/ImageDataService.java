package com.postgreSQLdemo.postgreSQL.service;

import com.postgreSQLdemo.postgreSQL.entity.ImageData;
import com.postgreSQLdemo.postgreSQL.repository.ImageDataRepository;
import com.postgreSQLdemo.postgreSQL.util.FileManageUtil;
import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Optional;

@Service
@Slf4j
public class ImageDataService {

    private ImageDataRepository imageDataRepository;

    public ImageDataService(ImageDataRepository imageDataRepository) {
        this.imageDataRepository = imageDataRepository;
    }

    @Transactional
    public String uploadImage(MultipartFile image) throws IOException {

        ImageData imageData = imageDataRepository.save(ImageData
                .builder()
                .imageName(image.getOriginalFilename())
                .fileType(image.getContentType())
                .imageData(FileManageUtil.compressFile(image.getBytes()))
                .build());

        log.info("Image compressed...");

        if (imageData == null) {
            log.info("Image is NULL...");
            return "Image NOT uploaded successfully: " + image.getOriginalFilename();
        }

        return "Image uploaded successfully: " + image.getOriginalFilename();
    }

    @Transactional
    public byte[] downloadImage(String imageName) {
        Optional<ImageData> imageData = imageDataRepository.findByImageName(imageName);
        log.info("Image found...");
        byte[] image = FileManageUtil.decompressFile(imageData.get().getImageData());
        log.info("Image decompressed...");
        return image;
    }
}
