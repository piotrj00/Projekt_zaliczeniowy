CREATE TABLE candidate_search
(
    candidate_search_id     SERIAL NOT NULL,
    positions               VARCHAR(32) NOT NULL,
    skills                  VARCHAR(32) NOT NULL,
    experienceLevel         VARCHAR(32) NOT NULL,
    location                VARCHAR(32) NOT NULL,
    candidate_id            INT         NOT NULL,
    PRIMARY KEY (candidate_search_id),
    CONSTRAINT fk_candidate_id
        FOREIGN KEY (candidate_id)
            REFERENCES candidate (candidate_id)
);