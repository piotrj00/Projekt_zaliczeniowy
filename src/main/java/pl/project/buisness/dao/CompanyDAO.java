package pl.project.buisness.dao;

import pl.project.domain.Company;

import java.util.Optional;

public interface CompanyDAO {

    Optional<Company> findByName(String name);

    Company saveCompany(Company company);

    void saveJobCriteria(Company company);

    void saveJobOffer(Company company);

}
