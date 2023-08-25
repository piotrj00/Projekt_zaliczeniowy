package pl.project.infrastructure.database.repository.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.mapstruct.ReportingPolicy;
import pl.project.domain.Candidate;
import pl.project.domain.CandidateSearch;
import pl.project.infrastructure.database.entity.CandidateEntity;
import pl.project.infrastructure.database.entity.CandidateSearchEntity;

import java.util.Set;
import java.util.stream.Collectors;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface CandidateEntityMapper {

    @Mapping(target = "address.candidate", ignore = true)
    @Mapping(target = "candidateCV.candidate", ignore = true)
    @Mapping(source = "candidateSearch", target = "candidateSearch", qualifiedByName = "mapCandidateSearch")
    Candidate mapFromEntity(CandidateEntity entity);

    @Named("mapCandidateSearch")
    default Set<CandidateSearch> mapCandidateSearch(Set<CandidateSearchEntity> entities) {
        return entities.stream().map(this::mapFromEntity).collect(Collectors.toSet());
    }

    @Mapping(target = "positions", ignore = true)
    @Mapping(target = "skills", ignore = true)
    @Mapping(target = "experienceLevel", ignore = true)
    @Mapping(target = "location", ignore = true)
    CandidateSearch mapFromEntity(CandidateSearchEntity entity);

    @Mapping(target = "candidateCV", ignore = true)
    CandidateEntity mapToEntity(Candidate candidate);
}
