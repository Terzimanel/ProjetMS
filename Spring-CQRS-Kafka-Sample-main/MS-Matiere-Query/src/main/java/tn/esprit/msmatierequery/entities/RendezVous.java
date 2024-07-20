package tn.esprit.msmatierequery.entities;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;
import java.time.LocalDateTime;

@Document
@Data
@Getter @Setter
@AllArgsConstructor @NoArgsConstructor @Builder
//@FieldDefaults(level = AccessLevel.NONE)
public class RendezVous implements Serializable {

    @Id
    @Setter(AccessLevel.NONE)
    private Long id;
    private LocalDateTime date;
    private String lieu;
    private String patientId;
    private String medecin;


}
