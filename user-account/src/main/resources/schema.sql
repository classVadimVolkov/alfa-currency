DROP TABLE IF EXISTS account;
DROP SEQUENCE IF EXISTS account_seq;

CREATE SEQUENCE account_seq START WITH 100000 INCREMENT BY 1;

CREATE TABLE account
(
    id       INTEGER PRIMARY KEY DEFAULT nextval('account_seq') NOT NULL,
    user_id  INTEGER                                            NOT NULL,
    balance  DECIMAL(16, 2)      DEFAULT 0                      NOT NULL,
    currency VARCHAR                                            NOT NULL,
    FOREIGN KEY user_id REFERENCES users(id) ON DELETE CASCADE
);

DROP TABLE IF EXISTS users;
DROP SEQUENCE IF EXISTS user_seq;

CREATE TABLE users
(
    id         INTEGER PRIMARY KEY DEFAULT nextval('user_seq') NOT NULL,
    first_name VARCHAR                                         NOT NULL,
    last_name  VARCHAR                                         NOT NULL,
    email      VARCHAR                                         NOT NULL,
    login      VARCHAR                                         NOT NULL,
    password   VARCHAR                                         NOT NULL,
    user_role  VARCHAR                                         NOT NULL,
    UNIQUE(email),
    UNIQUE(login)
);