package pl.project.infrastructure.database.repository.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;
import pl.project.domain.CandidateCV;
import pl.project.infrastructure.database.entity.CandidateCVEntity;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface CandidateCVEntityMapper {

    @Mapping(target = "candidate.candidateCV", ignore = true)
    CandidateCV mapFromEntity(CandidateCVEntity entity);

    @Mapping(target = "candidate", ignore = true)
    CandidateCVEntity mapToEntity(CandidateCV candidateCV);

}
