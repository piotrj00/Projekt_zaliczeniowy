CREATE TABLE job_offer
(
    job_offer_id        SERIAL          NOT NULL,
    positions           VARCHAR(32)     NOT NULL,
    description         TEXT,
    requirements        TEXT,
    employment_type     VARCHAR(64)     NOT NULL,
    salary              NUMERIC(8,2)    NOT NULL,
    date_add            TIMESTAMP,
    company_id          INT             NOT NULL,
    job_criteria_id     INT             NOT NULL,
    PRIMARY KEY (job_offer_id),
      CONSTRAINT fk_company_id
            FOREIGN KEY (company_id)
                REFERENCES company (company_id),
      CONSTRAINT fk_job_criteria_id
            FOREIGN KEY (job_criteria_id)
                REFERENCES job_criteria (job_criteria_id)
);