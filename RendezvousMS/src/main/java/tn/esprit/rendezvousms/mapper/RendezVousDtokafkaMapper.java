package tn.esprit.rendezvousms.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import tn.esprit.dto.RendezVousDtokafka;
import tn.esprit.rendezvousms.entity.RendezVous;
@Mapper(componentModel = "spring")
public interface RendezVousDtokafkaMapper {



    RendezVousDtokafkaMapper INSTANCE = Mappers.getMapper(RendezVousDtokafkaMapper.class);

        RendezVousDtokafka rendezVousToRendezVousDtoKafka(RendezVous rendezVous);

        RendezVous rendezVousDtoKafkaToRendezVous(RendezVousDtokafka rendezVousDtoKafka);

}
