package br.com.demo.demo.models;

import br.com.demo.demo.enums.TypeTelephone;
import com.sun.istack.NotNull;
import lombok.*;

import javax.persistence.Entity;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Builder
public class Telephone {

    @NotNull
    private Long telephoneId;
    @NotNull
    private String desc;
    @NotNull
    private TypeTelephone typeTelephone;
}
