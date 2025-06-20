package com.dgsg.integration.vouchers.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Setter
@Getter
@Entity
@Table(name = "VOUCHERS_STATUS_HISTORY")
public class VoucherStatusHistory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "voucher_id")
    private Voucher voucher;

    private String status;
    private String userId;
    private String reason;
    private LocalDateTime creationDate;
}
