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
public class Address {

    @NotNull
    private Integer addressId;
    @NotNull
    private String country;
    @NotNull
    private String city;
    @NotNull
    private String street;
    @NotNull
    private String zipCode;

}
