package br.com.demo.demo.models;

import br.com.demo.demo.enums.TypePayment;
import com.sun.istack.NotNull;
import lombok.*;

import javax.persistence.Entity;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Builder
public class Payment {

    @NotNull
    private Long paymentId;
    @NotNull
    private TypePayment typePayment;
}
