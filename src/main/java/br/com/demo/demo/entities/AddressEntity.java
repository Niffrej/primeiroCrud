package br.com.demo.demo.entities;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Builder
@Table(name = "address")
public class AddressEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ADDRESS_ID", nullable = false)
    private Integer addressId;

    @Column(name = "COUNTRY_ID", nullable = false, length = 25)
    private String country;

    @Column(name = "CITY", nullable = false, length = 25)
    private String city;

    @Column(name = "STREET", nullable = false, length = 50)
    private String street;

    @Column(name = "ZIP_CODE", nullable = false, length = 8)
    private String zipCode;

    @OneToMany
    private CostumerEntity costumerEntity;
}
