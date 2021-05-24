package br.com.demo.demo.entities;

import br.com.demo.demo.enums.TypeTelephone;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Builder
@Table(name = "telephone")
public class TelephoneEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "TELEPHONE_ID", nullable = false)
    private Long telephoneId;

    @Column(name = "DESC", nullable = false, length = 14)
    private String desc;

    @Column(name = "TYPE", nullable = false, length = 14)
    private TypeTelephone typeTelephone;

    @OneToMany
    private CostumerEntity costumerEntity;
}
