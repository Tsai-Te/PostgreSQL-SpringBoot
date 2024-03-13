package com.postgreSQLdemo.postgreSQL.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/employee")
@Slf4j
public class EmployeeController {

    @GetMapping("/{employeeId}")
    public ResponseEntity<?> findEmployeeByEmployeeId(@PathVariable Long employeeId) {
        log.info("Employee found...");
        return ResponseEntity.status(HttpStatus.OK).body(employeeId);
    }
}
