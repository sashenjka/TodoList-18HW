CREATE TABLE IF NOT EXISTS users (
    username VARCHAR(50) PRIMARY KEY,
    password VARCHAR(100),
    enabled BOOLEAN
);

CREATE TABLE IF NOT EXISTS authorities (
    username VARCHAR(50),
    authority VARCHAR(50),
    FOREIGN KEY (username) REFERENCES users (username)
);

INSERT INTO users (username, password, enabled) VALUES ('jdbcDefault', '{bcrypt}$2a$10$OepW.vVkbDmcDeIkZ2GG/OY9BseFtVJzElzDoUWV5WnZ5Id2WhfCm', true);
INSERT INTO authorities (username, authority) VALUES ('jdbcDefault', 'ROLE_USER');