package com.dgsg.integration.vouchers.exception;

import com.dgsg.integration.vouchers.enums.ResponseCode;

public class InvalidRequestException extends BaseException{

    public InvalidRequestException() {
        super(ResponseCode.INVALID_REQUEST);
    }
}
