package br.com.demo.demo.entities;

import br.com.demo.demo.enums.TypePayment;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Builder
@Table(name = "payment")
public class PaymentEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "PAYMENT_ID", nullable = false)
    private Long paymentId;

    @Column(name = "typePayment", nullable = false)
    private TypePayment typePayment;

    @ManyToOne
    private ProductEntity productEntity;

}
