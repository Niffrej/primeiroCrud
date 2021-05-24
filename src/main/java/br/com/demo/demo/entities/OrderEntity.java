package br.com.demo.demo.entities;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Builder
@Table(name = "costumerProduct")
public class OrderEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "COSTUMER_PRODUCT_ID", nullable = false)
    private Long orderId;

    @Column(name = "QUANTITY", nullable = false)
    private Integer quantity;

    @Column(name = "VALUE", nullable = false)
    private Double value;

    @ManyToOne
    private CostumerEntity costumerEntity;

    @ManyToOne
    private ProductEntity productEntity;

    @ManyToOne
    private PaymentEntity paymentEntity;

    @OneToMany
    private ItemOrderEntity itemOrder;
}
