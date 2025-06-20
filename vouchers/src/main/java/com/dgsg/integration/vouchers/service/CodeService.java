package com.dgsg.integration.vouchers.service;

import com.dgsg.integration.vouchers.model.Code;
import com.dgsg.integration.vouchers.reporsitory.CodeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CodeService {

    private final CodeRepository codeRepository;

    public Code save(Code code) {
        return codeRepository.save(code);
    }

    public Optional<Code> getById(Long id) {
        return codeRepository.findById(id);
    }

    public List<Code> getAll() {
        return codeRepository.findAll();
    }
}
