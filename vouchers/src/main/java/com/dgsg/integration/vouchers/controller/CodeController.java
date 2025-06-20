package com.dgsg.integration.vouchers.controller;

import com.dgsg.integration.vouchers.model.Code;
import com.dgsg.integration.vouchers.service.CodeService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/codes")
public class CodeController {

    private final CodeService codeService;

    @PostMapping
    public Code save(@RequestBody Code code) {
        return codeService.save(code);
    }

    @GetMapping("/{id}")
    public Code getById(@PathVariable Long id) {
        return codeService.getById(id).orElse(null);
    }

    @GetMapping
    public List<Code> getAll() {
        return codeService.getAll();
    }
}
