CREATE TABLE job_criteria
(
    job_criteria_id     SERIAL NOT NULL,
    skills              VARCHAR(32) NOT NULL,
    experience_level    VARCHAR(32) NOT NULL,
    location            VARCHAR(32) NOT NULL,
    company_id          INT         NOT NULL,
    PRIMARY KEY (job_criteria_id),
      CONSTRAINT fk_company_id
            FOREIGN KEY (company_id)
                REFERENCES company (company_id)
);