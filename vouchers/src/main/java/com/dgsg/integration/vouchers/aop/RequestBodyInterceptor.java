package com.dgsg.integration.vouchers.aop;

import com.dgsg.integration.vouchers.dto.VoucherDTO;
import com.dgsg.integration.vouchers.enums.Status;
import com.dgsg.integration.vouchers.exception.ServiceNotFoundException;
import com.dgsg.integration.vouchers.service.GDGSService;
import com.dgsg.integration.vouchers.service.ValidationService;
import lombok.RequiredArgsConstructor;
import org.springframework.core.MethodParameter;
import org.springframework.http.HttpInputMessage;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.RequestBodyAdvice;

import java.io.IOException;
import java.lang.reflect.Type;

@Component
@ControllerAdvice
@RequiredArgsConstructor
public class RequestBodyInterceptor implements RequestBodyAdvice {
    private final ValidationService validationService;
    private final GDGSService service;

    @Override
    public boolean supports(MethodParameter methodParameter, Type targetType, Class<? extends HttpMessageConverter<?>> converterType) {
        return VoucherDTO.class.isAssignableFrom(methodParameter.getParameterType());
    }

    @Override
    public HttpInputMessage beforeBodyRead(HttpInputMessage inputMessage, MethodParameter parameter, Type targetType, Class<? extends HttpMessageConverter<?>> converterType) throws IOException {
        return inputMessage;
    }

    @Override
    public Object afterBodyRead(Object body, HttpInputMessage inputMessage, MethodParameter parameter, Type targetType, Class<? extends HttpMessageConverter<?>> converterType) {
        if (body instanceof VoucherDTO request) {
            validationService.validateRequest(request);
            adjustVoucherDetails(request);
        }
        return body;
    }

    @Override
    public Object handleEmptyBody(Object body, HttpInputMessage inputMessage, MethodParameter parameter, Type targetType, Class<? extends HttpMessageConverter<?>> converterType) {
        return body;
    }

    private void adjustVoucherDetails(VoucherDTO voucher) {

        var srvc = service.getById(voucher.getServiceId())
                .orElseThrow(() -> new ServiceNotFoundException());

        voucher.setAmount(srvc.getAmount());
        if (voucher.isFastTransaction()) {
            voucher.setFastTransactionAmount(srvc.getFastTransactionAmount());
        }
        voucher.setCurrency(srvc.getCurrency());
        voucher.setService(srvc);
        voucher.setStatus(Status.NOT_USED);
    }
}
