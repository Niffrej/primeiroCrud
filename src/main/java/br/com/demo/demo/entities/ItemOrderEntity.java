package br.com.demo.demo.entities;

import lombok.*;

import javax.persistence.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Builder
@Table(name = "costumerProduct")
public class ItemOrderEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ITEM_ORDER_ID", nullable = false)
    private Long itemOrderId;

    @ManyToOne
    private OrderEntity orderEntity;

    @ManyToOne
    private CostumerEntity costumerEntity;
}
