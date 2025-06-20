package com.dgsg.integration.vouchers.reporsitory;

import com.dgsg.integration.vouchers.model.DGSGService;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ServiceRepository extends JpaRepository<DGSGService, Long> {
    // Example: Find active services by category
    List<DGSGService> findByCategoryIdAndActiveTrue(Long categoryId);
}
