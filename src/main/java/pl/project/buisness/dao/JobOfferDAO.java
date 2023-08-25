package pl.project.buisness.dao;

import pl.project.domain.JobCriteria;
import pl.project.domain.JobOffer;

import java.util.List;
import java.util.Optional;

public interface JobOfferDAO {

    Optional<JobOffer> findByPositions(String positions);

    //jak by nie działało to tzreba będzie przenieść pole location do JobbOffer
    Optional<JobCriteria> findByLocation(String location);

    List<JobOffer> findAll();


}
