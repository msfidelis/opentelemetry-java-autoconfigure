CREATE TABLE review (
    id BIGINT NOT NULL AUTO_INCREMENT,
    id_book BIGINT NOT NULL,
    review TEXT,
    rate FLOAT,
    active TINYINT DEFAULT 1,
    PRIMARY KEY(id)
)