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
public class Email {

    @NotNull
    private Integer emailId;
    @NotNull
    private String email;
    @NotNull
    private String emailRescue;

}
