package com.dgsg.integration.vouchers.service;

import com.dgsg.integration.vouchers.model.CodeValue;
import com.dgsg.integration.vouchers.reporsitory.CodeValueRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CodeValueService {

    private final CodeValueRepository codeValueRepository;

    public CodeValue save(CodeValue codeValue) {
        return codeValueRepository.save(codeValue);
    }

    public Optional<CodeValue> getById(Long id) {
        return codeValueRepository.findById(id);
    }

    public List<CodeValue> getAll() {
        return codeValueRepository.findAll();
    }

    public List<CodeValue> getByCodeId(Long codeId) {
        return codeValueRepository.findByCodeId(codeId);
    }
}
