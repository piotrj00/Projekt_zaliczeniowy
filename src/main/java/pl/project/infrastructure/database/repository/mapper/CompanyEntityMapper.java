package pl.project.infrastructure.database.repository.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;
import pl.project.domain.Company;
import pl.project.infrastructure.database.entity.CompanyEntity;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface CompanyEntityMapper {

    @Mapping(target = "address.company", ignore = true)
    Company mapFromEntity(CompanyEntity entity);
    CompanyEntity mapToEntity(Company company);
}
