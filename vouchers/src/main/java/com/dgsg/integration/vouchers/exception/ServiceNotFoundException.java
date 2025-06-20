package com.dgsg.integration.vouchers.exception;

import com.dgsg.integration.vouchers.enums.ResponseCode;

public class ServiceNotFoundException extends BaseException{

    public ServiceNotFoundException() {
        super(ResponseCode.SERVICE_NOT_FOUND);
    }
}
