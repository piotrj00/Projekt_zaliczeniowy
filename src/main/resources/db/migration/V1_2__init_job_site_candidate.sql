CREATE TABLE candidate
(
    candidate_id            SERIAL      NOT NULL,
    name                    VARCHAR(32) NOT NULL,
    surname                 VARCHAR(32) NOT NULL,
    email                   VARCHAR(32) NOT NULL,
    phone                   VARCHAR(32) NOT NULL,
    candidate_address_id    INT         NOT NULL,
    PRIMARY KEY (candidate_id),
    UNIQUE (email),
    CONSTRAINT fk_candidate_candidate_address
        FOREIGN KEY (candidate_address_id)
            REFERENCES candidate_address (candidate_address_id)
);