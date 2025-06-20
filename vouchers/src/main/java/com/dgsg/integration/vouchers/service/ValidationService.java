package com.dgsg.integration.vouchers.service;

import com.dgsg.integration.vouchers.dto.VoucherDTO;

public interface ValidationService {
    void validateRequest(VoucherDTO request);
}
