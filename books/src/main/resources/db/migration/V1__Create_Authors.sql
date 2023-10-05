CREATE TABLE author (
    id BIGINT NOT NULL AUTO_INCREMENT,
    name VARCHAR(100) NOT NULL,
    location VARCHAR(100) DEFAULT NULL,
    birth INT(4) DEFAULT NULL,
    active TINYINT DEFAULT 1,
    PRIMARY KEY(id)
)