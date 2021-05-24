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
public class ItemOrder {

    @NotNull
    private Long itemOrderId;
}
