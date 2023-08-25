CREATE TABLE candidate_CV
(
    candidate_CV_id     SERIAL      NOT NULL,
    experience_level    VARCHAR(32) NOT NULL,
    technology          VARCHAR(32) NOT NULL,
    education           VARCHAR(32) NOT NULL,
    candidate_photo     BYTEA,
    available           BOOLEAN     NOT NULL,
    candidate_id        INT         NOT NULL,
    PRIMARY KEY (candidate_CV_id),
    CONSTRAINT fk_candidate_CV_candidate
    FOREIGN KEY (candidate_id)
    REFERENCES candidate (candidate_id)
);