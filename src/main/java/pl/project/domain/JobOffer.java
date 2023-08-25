package pl.project.domain;

import lombok.*;

import java.math.BigDecimal;
import java.time.OffsetDateTime;

@With
@Value
@Builder
@EqualsAndHashCode(of = "jobOfferId")
@ToString(of =
        {"jobOfferId", "positions", "description", "requirements", "employmentType", "salary", "dateAdd"})
public class JobOffer {
    Integer jobOfferId;

    String positions;

    String description;

    String requirements;

    String employmentType;

    BigDecimal salary;

    OffsetDateTime dateAdd;

    Company company;

    JobCriteria jobCriteria;
}
