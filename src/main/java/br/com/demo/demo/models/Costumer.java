package br.com.demo.demo.models;

import com.sun.istack.NotNull;
import lombok.*;

import javax.persistence.Entity;
import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Builder
public class Costumer {

    @NotNull
    private Long costumerId;
    @NotNull
    private String name;
    @NotNull
    private String cpf;
    @NotNull
    private Date birthDate;
}
