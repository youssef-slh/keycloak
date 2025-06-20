package com.dgsg.integration.vouchers.model;

import com.dgsg.integration.vouchers.enums.Currency;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Setter
@Getter
@Entity
@Table(name = "SERVICES")
public class DGSGService {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private CodeValue category;

    private BigDecimal amount;
    private BigDecimal fastTransactionAmount;

    @Enumerated(EnumType.STRING)
    private Currency currency;
    private Boolean active = true;
    private String client;
}
