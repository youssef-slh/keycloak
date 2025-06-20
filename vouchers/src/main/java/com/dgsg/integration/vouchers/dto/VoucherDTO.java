package com.dgsg.integration.vouchers.dto;

import com.dgsg.integration.vouchers.enums.Currency;
import com.dgsg.integration.vouchers.enums.Status;
import com.dgsg.integration.vouchers.model.DGSGService;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.annotation.Nulls;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Transient;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;

@Setter
@Getter
@Builder
public class VoucherDTO {

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
    private Long serviceId;
    @JsonIgnore
    private BigDecimal amount;
    @JsonIgnore
    private BigDecimal fastTransactionAmount;
    private Currency currency;
    @Transient
    @JsonIgnore
    private DGSGService service;
    private boolean isFastTransaction;
    @JsonSetter(nulls = Nulls.SKIP)
    private Status status = Status.NOT_USED;
}
