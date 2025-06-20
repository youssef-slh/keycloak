package com.dgsg.integration.vouchers.exception;

import com.dgsg.integration.vouchers.dto.BaseResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.Optional;

@RestControllerAdvice
public class ExceptionHandlerAdvice {

    @ExceptionHandler(BaseException.class)
    public ResponseEntity<BaseResponse> baseResponseHandler(BaseException exception) {
        return ResponseEntity.badRequest()
                .body(new BaseResponse<Optional>(exception.code.getCode(), exception.code.getMessage(),
                        Optional.empty()));

    }
}
