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
@Table(name = "telephone")
public class EmailEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "EMAIL", nullable = false)
    private Integer emailId;

    @Column(name = "EMAIL", nullable = false, length = 14)
    private String email;

    @Column(name = "EMAIL_RESCUE", nullable = false, length = 14)
    private String emailRescue;

    @ManyToOne
    private CostumerEntity costumerEntity;
}
