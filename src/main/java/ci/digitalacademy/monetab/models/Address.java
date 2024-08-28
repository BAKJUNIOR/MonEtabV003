package ci.digitalacademy.monetab.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column( name = "compagny")
    private String compagny;


    @Column( name = "city")
    private String city;

    @Column( name = "street")
    private String street;

    @OneToOne(mappedBy = "address")
    private User user;


}