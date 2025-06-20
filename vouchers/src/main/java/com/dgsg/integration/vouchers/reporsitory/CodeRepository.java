package com.dgsg.integration.vouchers.reporsitory;

import com.dgsg.integration.vouchers.model.Code;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CodeRepository extends JpaRepository<Code, Long> {
    // You can add custom methods here
}
