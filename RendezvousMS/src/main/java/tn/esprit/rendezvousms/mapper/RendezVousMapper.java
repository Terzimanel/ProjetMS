package tn.esprit.rendezvousms.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import tn.esprit.dto.RendezVousDto;
import tn.esprit.rendezvousms.entity.RendezVous;

@Mapper(componentModel = "spring")

public interface RendezVousMapper {
    RendezVousMapper INSTANCE = Mappers.getMapper(RendezVousMapper.class);

    RendezVousDto RendezVousToRendezVousDto(RendezVous rendezVous);

    RendezVous RendezVousDtoToRendezVous(RendezVousDto rendezVousDto);
}
