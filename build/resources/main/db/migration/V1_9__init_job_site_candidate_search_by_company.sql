CREATE TABLE candidate_search_by_company
(
    candidate_search_by_company_id      SERIAL NOT NULL,
    skills                              VARCHAR(32) NOT NULL,
    experienceLevel                     VARCHAR(32) NOT NULL,
    education                           VARCHAR(32) NOT NULL,
    location                            VARCHAR(32) NOT NULL,
    company_id                          INT         NOT NULL,
    PRIMARY KEY (candidate_search_by_company_id),
    CONSTRAINT fk_company_id
        FOREIGN KEY (company_id)
            REFERENCES company (company_id)
);