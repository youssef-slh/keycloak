package com.dgsg.integration.vouchers.reporsitory;

import com.dgsg.integration.vouchers.enums.Status;
import com.dgsg.integration.vouchers.model.Voucher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Repository
public interface VoucherRepository extends JpaRepository<Voucher, Long> {
    // You can add custom query methods here
    Optional<Voucher> findByExternalId(Long id);

    Optional<Voucher> findByBarcode(String id);

    @Query("""
            select v from Voucher v where v.creationDate between :from and :to
            """)
    List<Voucher> findBetweenDates(@Param("from") LocalDateTime from, @Param("to") LocalDateTime to);

    @Modifying
    @Query("""
            update Voucher set status= :status where id= :id
            """)
    int changeStatus(@Param("id") Long id, @Param("status") Status status);
}
