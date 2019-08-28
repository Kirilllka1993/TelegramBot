package com.example.myproject.exception;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;
import java.util.NoSuchElementException;

@RestControllerAdvice
public class MyExceptionHandler {


    @ExceptionHandler({NoSuchElementException.class})
    public ResponseEntity<CustomErrorResponce> absentOfTown() {
        CustomErrorResponce errors = new CustomErrorResponce(LocalDateTime.now(), 500, "Town Not found");
        return new ResponseEntity<>(errors, new HttpHeaders(), HttpStatus.valueOf(errors.getStatus()));
    }

    @ExceptionHandler({RepidNameOfTownException.class})
    public ResponseEntity<CustomErrorResponce> repidNameOfTown() {
        CustomErrorResponce errors = new CustomErrorResponce(LocalDateTime.now(), 500, "Such town is present");
        return new ResponseEntity<>(errors, new HttpHeaders(), HttpStatus.valueOf(errors.getStatus()));
    }
}
