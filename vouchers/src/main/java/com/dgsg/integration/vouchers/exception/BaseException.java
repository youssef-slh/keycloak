package com.dgsg.integration.vouchers.exception;

import com.dgsg.integration.vouchers.enums.ResponseCode;

public class BaseException extends RuntimeException{

    ResponseCode code;

    public BaseException(ResponseCode code) {
        super(code.getMessage());
        this.code=code;
    }
}
