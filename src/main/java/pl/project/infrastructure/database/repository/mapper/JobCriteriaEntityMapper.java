package pl.project.infrastructure.database.repository.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import pl.project.domain.JobCriteria;
import pl.project.infrastructure.database.entity.JobCriteriaEntity;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface JobCriteriaEntityMapper {

    JobCriteria mapFromEntity(JobCriteriaEntity entity);

    JobCriteriaEntity mapToEntity(JobCriteria jobCriteria);
}
