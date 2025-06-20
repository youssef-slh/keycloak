package com.dgsg.integration.vouchers.service.mapper;

import com.dgsg.integration.vouchers.dto.VoucherDTO;
import com.dgsg.integration.vouchers.model.Voucher;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface VoucherMapper {
    VoucherMapper INSTANCE = Mappers.getMapper(VoucherMapper.class);
    Voucher toEntity(VoucherDTO voucher);
}
