package pl.project.infrastructure.database.repository.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;
import pl.project.domain.JobOffer;
import pl.project.infrastructure.database.entity.JobOfferEntity;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface JobOfferEntityMapper {
    @Mapping(target = "company", ignore = true)
    JobOffer mapFromEntity(JobOfferEntity entity);

    JobOfferEntity mapToEntity(JobOffer jobOffer);
}
