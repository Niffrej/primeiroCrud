package br.com.demo.demo.models.mapper;

import br.com.demo.demo.validations.NullSafe;
import br.com.demo.demo.entities.PaymentEntity;
import br.com.demo.demo.models.Payment;

import java.util.Collection;
import java.util.Collections;
import java.util.stream.Collectors;

public class PaymentMapper {

    public static Collection<Payment> unmarshall(Collection<PaymentEntity> entities) {
        return NullSafe.of(entities).getOrDefault(Collections.emptyList()).stream().map(entity -> PaymentMapper.unmarshall(entity))
                .collect(Collectors.toList());
    }

    public static Collection<PaymentEntity> marshall(Collection<Payment> models) {
        return NullSafe.of(models).getOrDefault(Collections.emptyList()).stream().map(PaymentMapper::marshall)
                .collect(Collectors.toList());
    }

    public static Payment unmarshall(PaymentEntity entity){
        return Payment.builder().build();
    }

    public static PaymentEntity marshall(Payment model){
        return PaymentEntity.builder().build();
    }
}
