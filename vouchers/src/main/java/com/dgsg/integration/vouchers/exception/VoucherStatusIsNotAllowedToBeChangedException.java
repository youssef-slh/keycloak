package com.dgsg.integration.vouchers.exception;

import com.dgsg.integration.vouchers.enums.ResponseCode;

public class VoucherStatusIsNotAllowedToBeChangedException extends BaseException{

    public VoucherStatusIsNotAllowedToBeChangedException() {
        super(ResponseCode.VOUCHER_STATUS_IS_NOT_ALLOWED_TO_BE_CHANGED);
    }
}
