package com.dgsg.integration.vouchers.controller;

import com.dgsg.integration.vouchers.model.DGSGService;
import com.dgsg.integration.vouchers.service.GDGSService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/services")
public class ServiceController {

    private final GDGSService gdgsService;

    @PostMapping
    public DGSGService save(@RequestBody DGSGService service) {
        return gdgsService.save(service);
    }

    @GetMapping("/{id}")
    public DGSGService getById(@PathVariable Long id) {
        return gdgsService.getById(id).orElse(null);
    }

    @GetMapping
    public List<DGSGService> getAll() {
        return gdgsService.getAll();
    }

    @GetMapping("/category/{categoryId}")
    public List<DGSGService> getByCategory(@PathVariable Long categoryId) {
        return gdgsService.getByCategoryId(categoryId);
    }
}
