package com.postgreSQLdemo.postgreSQL.controller;

import com.postgreSQLdemo.postgreSQL.service.ImageDataService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@RequestMapping("/image")
@Slf4j
public class ImageDataController {

    private ImageDataService imageDataService;

    public ImageDataController(ImageDataService imageDataService) {
        this.imageDataService = imageDataService;
    }

    @PostMapping("/upload")
    public ResponseEntity<?> imageUpload(@RequestParam("image") MultipartFile image) throws IOException {
        String dbUploadedImage = imageDataService.uploadImage(image);
        log.info("Image uploaded...");
        return ResponseEntity.status(HttpStatus.OK).body(dbUploadedImage);
    }

    @GetMapping("/download/{imageName}")
    public ResponseEntity<?> imageDownload(@PathVariable String imageName) {
        byte[] downloadedImage = imageDataService.downloadImage(imageName);
        log.info("Image downloaded...");
        return ResponseEntity.status(HttpStatus.OK).contentType(MediaType.IMAGE_GIF).body(downloadedImage);
    }

}
