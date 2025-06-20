package com.dgsg.integration.vouchers.controller;

import com.dgsg.integration.vouchers.model.VoucherStatusHistory;
import com.dgsg.integration.vouchers.service.VoucherStatusHistoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/voucher-status-history")
public class VoucherStatusHistoryController {

    private final VoucherStatusHistoryService historyService;

    @PostMapping
    public VoucherStatusHistory save(@RequestBody VoucherStatusHistory history) {
        return historyService.save(history);
    }

    @GetMapping("/{id}")
    public VoucherStatusHistory getById(@PathVariable Long id) {
        return historyService.getById(id).orElse(null);
    }

    @GetMapping
    public List<VoucherStatusHistory> getAll() {
        return historyService.getAll();
    }

    @GetMapping("/voucher/{voucherId}")
    public List<VoucherStatusHistory> getByVoucherId(@PathVariable Long voucherId) {
        return historyService.getByVoucherId(voucherId);
    }
}
