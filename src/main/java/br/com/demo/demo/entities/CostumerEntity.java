package br.com.demo.demo.entities;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Builder
@Table(name = "costumer")
public class CostumerEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "COSTUMER_ID", nullable = false)
    private Long costumerId;

    @Column(name = "NAME", nullable = false)
    private String name;

    @Column(name = "CPF", nullable = false)
    private String cpf;

    @Column(name = "BIRTHDATE", nullable = false)
    private Date birthDate;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "address_id", referencedColumnName = "ADDRESS_ID")
    private AddressEntity addressEntity;

    @OneToMany(fetch = FetchType.LAZY)
    @JoinColumn(name = "telephone_id", referencedColumnName = "TELEPHONE_ID")
    private TelephoneEntity telephoneEntity;

    @OneToMany(fetch = FetchType.LAZY)
    @JoinColumn(name = "email_id", referencedColumnName = "EMAIL_ID")
    private EmailEntity emailEntity;

    @OneToMany(fetch = FetchType.LAZY)
    @JoinColumn(name = "order_id", referencedColumnName = "ORDER_ID")
    private OrderEntity order;
}
