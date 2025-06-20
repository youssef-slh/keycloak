package com.dgsg.integration.vouchers.controller;

import com.dgsg.integration.vouchers.model.CodeValue;
import com.dgsg.integration.vouchers.service.CodeValueService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/code-values")
public class CodeValueController {

    private final CodeValueService codeValueService;

    @PostMapping
    public CodeValue save(@RequestBody CodeValue codeValue) {
        return codeValueService.save(codeValue);
    }

    @GetMapping("/{id}")
    public CodeValue getById(@PathVariable Long id) {
        return codeValueService.getById(id).orElse(null);
    }

    @GetMapping
    public List<CodeValue> getAll() {
        return codeValueService.getAll();
    }

    @GetMapping("/code/{codeId}")
    public List<CodeValue> getByCodeId(@PathVariable Long codeId) {
        return codeValueService.getByCodeId(codeId);
    }
}
