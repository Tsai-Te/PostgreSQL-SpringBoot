package com.postgreSQLdemo.postgreSQL.repository;

import com.postgreSQLdemo.postgreSQL.entity.ImageData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ImageDataRepository extends JpaRepository<ImageData, Long> {

    Optional<ImageData> findByImageName(String imageName);
}
