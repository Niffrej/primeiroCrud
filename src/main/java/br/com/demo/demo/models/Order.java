package br.com.demo.demo.models;

import com.sun.istack.NotNull;
import lombok.*;

import javax.persistence.Entity;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Builder
public class Order {

    @NotNull
    private Long orderId;
    @NotNull
    private Integer quantity;
    @NotNull
    private Double value;
}
