package com.dgsg.integration.vouchers.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum ResponseCode {
    SUCCESS("0", "success"),
    SERVICE_NOT_FOUND("1", "Service not found."),
    BARCODE_ALREADY_USED("2", "Barcode already used."),
    EXTERNAL_ID_ALREADY_USED("3", "External ID already used."),
    UPDATE_STATUS_EXCEPTION("4", "unable to update voucher status, please contact your administrator."),
    VOUCHER_NOT_FOUND_EXCEPTION("5", "voucher not found."),
    VOUCHER_STATUS_IS_NOT_ALLOWED_TO_BE_CHANGED("6", "unable to change voucher status."),
    INVALID_REQUEST("7", "your request is not valid.");

    private final String code;
    private final String message;
}
