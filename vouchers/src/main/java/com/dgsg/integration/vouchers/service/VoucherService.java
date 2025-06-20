package com.dgsg.integration.vouchers.service;

import com.dgsg.integration.vouchers.dto.StatusResponse;
import com.dgsg.integration.vouchers.dto.VoucherDTO;
import com.dgsg.integration.vouchers.enums.Status;
import com.dgsg.integration.vouchers.exception.InvalidRequestException;
import com.dgsg.integration.vouchers.exception.UpdateStatusException;
import com.dgsg.integration.vouchers.exception.VoucherNotFoundException;
import com.dgsg.integration.vouchers.exception.VoucherStatusIsNotAllowedToBeChangedException;
import com.dgsg.integration.vouchers.model.Voucher;
import com.dgsg.integration.vouchers.reporsitory.VoucherRepository;
import com.dgsg.integration.vouchers.service.mapper.VoucherMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;
import java.util.Optional;

@Slf4j
@Service
@Transactional
@RequiredArgsConstructor
public class VoucherService {

    private final VoucherRepository voucherRepository;

    public Voucher save(VoucherDTO voucher) {
        var vcr = VoucherMapper.INSTANCE.toEntity(voucher);
        return voucherRepository.save(vcr);
    }

    public Optional<Voucher> getByExternalId(Long id) {
        return voucherRepository.findByExternalId(id);
    }

    public Optional<Voucher> getByBarcode(String barcode) {
        return voucherRepository.findByBarcode(barcode);
    }

    public Voucher getById(Long id) {
        return voucherRepository.findById(id).orElseThrow(() -> new VoucherNotFoundException());
    }

    public List<Voucher> getAll(LocalDate from, LocalDate to) {
        if (to.isBefore(from)) {
            throw new InvalidRequestException();
        }
        return voucherRepository.findBetweenDates(LocalDateTime.of(from, LocalTime.of(0,0)),
                LocalDateTime.of(to.plusDays(1), LocalTime.of(0,0)));
    }

    public void changeStatus(final Long id, final Status status) {
        Voucher voucher = getById(id);
        if (!voucher.getStatus().canTransitionTo(status)) {
            throw new VoucherStatusIsNotAllowedToBeChangedException();
        }
        try {
            voucher.setStatus(status);
        } catch (Exception exception) {
            log.error("error while updating status [{}]", exception.getMessage());
            throw new UpdateStatusException();
        }
    }

    public StatusResponse checkStatus(final Long id) {
        Voucher voucher = getById(id);
        return new StatusResponse(voucher.getStatus());
    }
}
