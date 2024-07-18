package tn.esprit.patientms.entity;

import lombok.*;
import lombok.experimental.FieldDefaults;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "patients")
@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder

public class Patient {
    @Id
    private String id;
    private String nom;
    private int age;
    private String sexe;
    private String historiqueMedical;


}