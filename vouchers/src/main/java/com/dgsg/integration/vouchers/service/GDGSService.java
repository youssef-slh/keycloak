package com.dgsg.integration.vouchers.service;

import com.dgsg.integration.vouchers.model.DGSGService;
import com.dgsg.integration.vouchers.reporsitory.ServiceRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class GDGSService {

    private final ServiceRepository serviceRepository;

    public DGSGService save(DGSGService service) {
        return serviceRepository.save(service);
    }

    public Optional<DGSGService> getById(Long id) {
        return serviceRepository.findById(id);
    }

    public List<DGSGService> getAll() {
        return serviceRepository.findAll();
    }

    public List<DGSGService> getByCategoryId(Long categoryId) {
        return serviceRepository.findByCategoryIdAndActiveTrue(categoryId);
    }
}
