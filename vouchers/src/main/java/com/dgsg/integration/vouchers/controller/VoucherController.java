package com.dgsg.integration.vouchers.controller;

import com.dgsg.integration.vouchers.dto.BaseResponse;
import com.dgsg.integration.vouchers.dto.VoucherDTO;
import com.dgsg.integration.vouchers.enums.Status;
import com.dgsg.integration.vouchers.model.Voucher;
import com.dgsg.integration.vouchers.service.VoucherService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/vouchers")
public class VoucherController implements ResponseHandler {

    private final VoucherService voucherService;

    @PostMapping
    public Voucher save(@RequestBody VoucherDTO voucher) {
        return voucherService.save(voucher);
    }

    @GetMapping("/{id}")
    public Voucher getById(@PathVariable Long id) {
        return voucherService.getById(id);
    }

    @GetMapping
    public ResponseEntity<BaseResponse> getAll(@RequestParam("from") LocalDate from, @RequestParam("to") LocalDate to) {
        return ResponseEntity.ok(success(voucherService.getAll(from, to)));
    }

    @PatchMapping("/{id}/status/{status}")
    public ResponseEntity<BaseResponse> updateStatus(@PathVariable Long id, @PathVariable Status status) {
        this.voucherService.changeStatus(id, status);
        return ResponseEntity.ok(success());
    }

    @GetMapping("/{id}/status")
    public ResponseEntity<BaseResponse> checkStatus(@PathVariable Long id) {
        return ResponseEntity.ok(success(this.voucherService.checkStatus(id)));
    }
}
