package com.sagar.lotse.util;

import com.sagar.lotse.common.constant.CommonMessages;
import com.sagar.lotse.exception.DataNotFoundException;
import com.sagar.lotse.pojo.common.response.GlobalApiResponse;
import org.springframework.dao.InvalidDataAccessResourceUsageException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.net.MalformedURLException;

@RestControllerAdvice
public class GlobalExceptionHandler implements CommonMessages {

    @ExceptionHandler(NullPointerException.class)
    public ResponseEntity<GlobalApiResponse> handleNullPointerException(NullPointerException e) {
        return ResponseEntity.ok(GlobalApiResponse.builder()
                .data(null)
                .message(SOMETHING_WENT_WRONG)
                .status(false)
                .build());
    }

    @ExceptionHandler(InvocationTargetException.class)
    public ResponseEntity<GlobalApiResponse> handleInvocationTargetException(InvocationTargetException e) {
        return ResponseEntity.ok(GlobalApiResponse.builder()
                .data(null)
                .message(e.getMessage())
                .status(false)
                .build());
    }

    @ExceptionHandler(InvalidDataAccessResourceUsageException.class)
    public ResponseEntity<GlobalApiResponse> handleInvalidDataAccessResourceUsageException(InvalidDataAccessResourceUsageException e) {
        return ResponseEntity.ok(GlobalApiResponse.builder()
                .data(null)
                .message(e.getMessage())
                .status(false)
                .build());
    }

//    @ExceptionHandler(RuntimeException.class)
//    public ResponseEntity<GlobalApiResponse> handleRuntimeException(RuntimeException e) {
//        return ResponseEntity.ok(GlobalApiResponse.builder()
//                .data(null)
//                .message(e.getMessage())
//                .status(false)
//                .build());
//    }

    @ExceptionHandler(IOException.class)
    public ResponseEntity<GlobalApiResponse> handleIOException(IOException e) {
        return ResponseEntity.ok(GlobalApiResponse.builder()
                .data(null)
                .message(e.getMessage())
                .status(false)
                .build());
    }

    @ExceptionHandler(MalformedURLException.class)
    public ResponseEntity<GlobalApiResponse> handleMalformedURLException(MalformedURLException e) {
        return ResponseEntity.ok(GlobalApiResponse.builder()
                .data(null)
                .message(e.getMessage())
                .status(false)
                .build());
    }

    @ExceptionHandler(DataNotFoundException.class)
    public ResponseEntity<GlobalApiResponse> handleDataNotFoundException(DataNotFoundException e) {
        return ResponseEntity.ok(GlobalApiResponse
                .builder()
                .data(null)
                .message(e.getMessage())
                .status(false)
                .build());
    }
}