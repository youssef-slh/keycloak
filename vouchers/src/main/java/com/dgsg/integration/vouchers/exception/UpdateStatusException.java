package com.dgsg.integration.vouchers.exception;

import com.dgsg.integration.vouchers.enums.ResponseCode;

public class UpdateStatusException extends BaseException{

    public UpdateStatusException() {
        super(ResponseCode.UPDATE_STATUS_EXCEPTION);
    }
}
