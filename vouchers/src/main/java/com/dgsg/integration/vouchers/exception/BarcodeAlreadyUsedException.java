package com.dgsg.integration.vouchers.exception;

import com.dgsg.integration.vouchers.enums.ResponseCode;

public class BarcodeAlreadyUsedException extends BaseException{

    public BarcodeAlreadyUsedException() {
        super(ResponseCode.BARCODE_ALREADY_USED);
    }
}
