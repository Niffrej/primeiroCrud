package br.com.demo.demo.services;

import br.com.demo.demo.entities.PaymentEntity;
import br.com.demo.demo.models.Payment;
import br.com.demo.demo.models.mapper.PaymentMapper;
import br.com.demo.demo.repositories.PaymentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PaymentService {
    @Autowired
    private PaymentRepository paymentRepository;

    public Payment create(Payment payment) {
        PaymentEntity paymentEntity = PaymentMapper.marshall(payment);
        PaymentEntity persistenceEntity = paymentRepository.save(paymentEntity);
        return PaymentMapper.unmarshall(persistenceEntity);
    }

    public Payment update(Payment payment) {
        PaymentEntity paymentEntity = PaymentMapper.marshall(payment);
        PaymentEntity ModifiedEntity = paymentRepository.save(paymentEntity);
        return PaymentMapper.unmarshall(ModifiedEntity);
    }

    public void delete(Long idPayment) { paymentRepository.deleteById(idPayment); }

    public Payment findById(Long idPayment) {
        PaymentEntity paymentEntity= paymentRepository.findById(idPayment).get();
        Payment payment = PaymentMapper.unmarshall(paymentEntity);
        return payment;
    }

    public List<Payment> findAll() { return new ArrayList<>(PaymentMapper.unmarshall(paymentRepository.findAll()));}
}

