package com.dgsg.integration.vouchers.controller;

import com.dgsg.integration.vouchers.dto.BaseResponse;
import com.dgsg.integration.vouchers.enums.ResponseCode;

import java.util.Optional;

public interface ResponseHandler<T> {
    default BaseResponse success() {
        return new BaseResponse(ResponseCode.SUCCESS.getCode(), ResponseCode.SUCCESS.getMessage(), Optional.empty());
    }

    default BaseResponse success(T data) {
        return new BaseResponse(ResponseCode.SUCCESS.getCode(), ResponseCode.SUCCESS.getMessage(), Optional.of(data));
    }
}
