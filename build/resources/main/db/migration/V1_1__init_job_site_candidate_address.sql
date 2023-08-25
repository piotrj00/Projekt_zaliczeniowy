CREATE TABLE candidate_address
(
    candidate_address_id    SERIAL      NOT NULL,
    country                 VARCHAR(32) NOT NULL,
    city                    VARCHAR(32) NOT NULL,
    postal_code             VARCHAR(32) NOT NULL,
    address                 VARCHAR(32) NOT NULL,
    PRIMARY KEY (candidate_address_id)
);