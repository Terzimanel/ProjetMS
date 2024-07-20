package tn.esprit.msmatierecommand.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;
import lombok.experimental.FieldDefaults;


import java.io.Serializable;
import java.time.LocalDateTime;

@Entity
@Data
@Getter @Setter @ToString
@AllArgsConstructor @NoArgsConstructor @Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class RendezVous implements Serializable {

    @Id
    @Setter(AccessLevel.NONE)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDateTime date;
    private String lieu;
    private String patientId;
    private String medecin;


}
