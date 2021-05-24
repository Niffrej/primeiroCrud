package br.com.demo.demo.entities;

import br.com.demo.demo.enums.TypeProduct;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Builder
@Table(name = "product")
public class ProductEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "PRODUCT_ID", nullable = false)
    private Long productId;

    @Column(name = "NAME", nullable = false)
    private String name;

    @Column(name = "TYPE_PRODUCT", nullable = false)
    private TypeProduct typeProduct;

    @Column(name = "VALUE_PRODUCT", nullable = false)
    private Double valueProduct;

    @OneToMany
    private OrderEntity order;
}
