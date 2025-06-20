package com.dgsg.integration.vouchers.service;

import com.dgsg.integration.vouchers.model.VoucherStatusHistory;
import com.dgsg.integration.vouchers.reporsitory.VoucherStatusHistoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class VoucherStatusHistoryService {

    private final VoucherStatusHistoryRepository historyRepository;

    public VoucherStatusHistory save(VoucherStatusHistory history) {
        return historyRepository.save(history);
    }

    public Optional<VoucherStatusHistory> getById(Long id) {
        return historyRepository.findById(id);
    }

    public List<VoucherStatusHistory> getAll() {
        return historyRepository.findAll();
    }

    public List<VoucherStatusHistory> getByVoucherId(Long voucherId) {
        return historyRepository.findByVoucherId(voucherId);
    }
}
