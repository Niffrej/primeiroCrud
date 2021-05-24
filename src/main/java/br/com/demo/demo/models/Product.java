package br.com.demo.demo.models;

import br.com.demo.demo.enums.TypeProduct;
import com.sun.istack.NotNull;
import lombok.*;

import javax.persistence.Entity;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Builder
public class Product {

    @NotNull
    private Long productId;
    @NotNull
    private String name;
    @NotNull
    private TypeProduct typeProduct;
    @NotNull
    private Double valueProduct;
}
