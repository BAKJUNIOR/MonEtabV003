package ci.digitalacademy.monetab.services.dto;

import lombok.Data;

import java.time.Instant;

@Data
public class UserDTO {

    private Long id;
    private String pseudo;
    private String password;
    private Instant creationDate;
    private Long addressId;  // Utilisé pour la relation avec Address
}
