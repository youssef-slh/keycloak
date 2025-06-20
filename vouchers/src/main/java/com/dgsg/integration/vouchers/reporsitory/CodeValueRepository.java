package com.dgsg.integration.vouchers.reporsitory;

import com.dgsg.integration.vouchers.model.CodeValue;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CodeValueRepository extends JpaRepository<CodeValue, Long> {
    List<CodeValue> findByCodeId(Long codeId);
}
