CREATE TABLE company
(
    company_id          SERIAL NOT NULL,
    name                VARCHAR(32) NOT NULL,
    phone               VARCHAR(32) NOT NULL,
    email               VARCHAR(32) NOT NULL,
    contact_person      VARCHAR(32) NOT NULL,
    company_address_id  INT         NOT NULL,
    PRIMARY KEY (company_id),
    UNIQUE (email),
    CONSTRAINT fk_company_address_id
        FOREIGN KEY (company_address_id)
            REFERENCES company_address (company_address_id)
);