package com.dgsg.integration.vouchers.model;

import com.dgsg.integration.vouchers.enums.Currency;
import com.dgsg.integration.vouchers.enums.Status;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Setter
@Getter
@Entity
@Table(name = "VOUCHERS")
@EntityListeners(AuditingEntityListener.class)
public class Voucher {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String barcode;
    private Long externalId;

    private String firstName;
    private String lastName;
    private String fatherName;
    private String motherName;

    private String firstNameAr;
    private String lastNameAr;
    private String fatherNameAr;
    private String motherNameAr;

    private String phoneNumber;
    private LocalDate dateOfBirth;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "service_id")
    private DGSGService service;

    private BigDecimal amount;
    private BigDecimal fastTransactionAmount;
    @Enumerated(EnumType.STRING)
    private Currency currency;
    @Enumerated(EnumType.STRING)
    private Status status;

    @CreatedDate
    @Column(name = "creation_date" ,nullable = false,updatable = false)
    private LocalDateTime creationDate;

    @LastModifiedDate
    @JsonIgnore
    @Column(name = "last_update_date",insertable = false)
    private LocalDateTime lastUpdateDate;
}
