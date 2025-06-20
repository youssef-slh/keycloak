package com.dgsg.integration.vouchers.exception;

import com.dgsg.integration.vouchers.enums.ResponseCode;

public class VoucherNotFoundException extends BaseException{

    public VoucherNotFoundException() {
        super(ResponseCode.VOUCHER_NOT_FOUND_EXCEPTION);
    }
}
