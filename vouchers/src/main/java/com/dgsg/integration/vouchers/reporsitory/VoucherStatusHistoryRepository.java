package com.dgsg.integration.vouchers.reporsitory;

import com.dgsg.integration.vouchers.model.VoucherStatusHistory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VoucherStatusHistoryRepository extends JpaRepository<VoucherStatusHistory, Long> {
    List<VoucherStatusHistory> findByVoucherId(Long voucherId);
}
