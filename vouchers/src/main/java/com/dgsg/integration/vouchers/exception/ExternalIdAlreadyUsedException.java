package com.dgsg.integration.vouchers.exception;

import com.dgsg.integration.vouchers.enums.ResponseCode;

public class ExternalIdAlreadyUsedException extends BaseException{

    public ExternalIdAlreadyUsedException() {
        super(ResponseCode.EXTERNAL_ID_ALREADY_USED);
    }
}
