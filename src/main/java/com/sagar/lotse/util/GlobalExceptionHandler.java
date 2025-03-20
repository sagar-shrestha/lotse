package com.sagar.lotse.util;

import com.sagar.lotse.common.constant.CommonMessages;
import com.sagar.lotse.pojo.common.GlobalApiResponse;
import org.springframework.dao.InvalidDataAccessResourceUsageException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.lang.reflect.InvocationTargetException;

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
}