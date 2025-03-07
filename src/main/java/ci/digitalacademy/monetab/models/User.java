package ci.digitalacademy.monetab.models;


import jakarta.persistence.*;
import lombok.*;

import java.time.Instant;
@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor


@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false,name = "pseudo",unique = true)
    private String pseudo;

    @Column(nullable = false,name = "password")
    private String password;

    @Column(nullable = false,name = "creation_date")
    private Instant creationDate;

    @OneToOne
    @JoinColumn(name = "id_address")
    private Address address;




}
