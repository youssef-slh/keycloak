package com.dgsg.integration.vouchers.dto;

import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.Optional;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
public record BaseResponse<T>(String code, String message, Optional<T> data) {
}
