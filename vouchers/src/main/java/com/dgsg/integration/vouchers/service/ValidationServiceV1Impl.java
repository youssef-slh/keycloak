package com.dgsg.integration.vouchers.service;

import com.dgsg.integration.vouchers.dto.VoucherDTO;
import com.dgsg.integration.vouchers.exception.BarcodeAlreadyUsedException;
import com.dgsg.integration.vouchers.exception.ExternalIdAlreadyUsedException;
import com.dgsg.integration.vouchers.model.Voucher;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Slf4j
@Service
@RequiredArgsConstructor
public class ValidationServiceV1Impl implements ValidationService {

    private final VoucherService voucherService;

    @Override
    public void validateRequest(VoucherDTO request) {

        Optional<Voucher> voucherByExternalId = voucherService.getByExternalId(request.getExternalId());

        if(voucherByExternalId.isPresent()){
            throw new ExternalIdAlreadyUsedException();
        }

        Optional<Voucher> voucherByBarcode = voucherService.getByBarcode(request.getBarcode());

        if(voucherByBarcode.isPresent()){
            throw new BarcodeAlreadyUsedException();
        }
    }
}
