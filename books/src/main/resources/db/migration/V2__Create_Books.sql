CREATE TABLE book (
    id BIGINT NOT NULL AUTO_INCREMENT,
    name VARCHAR(100) NOT NULL,
    year INT(4) DEFAULT NULL,
    author_id BIGINT NOT NULL,
    active TINYINT DEFAULT 1,

    PRIMARY KEY(id),
    FOREIGN KEY (author_id) REFERENCES author(id)
)