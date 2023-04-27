DROP TABLE IF EXISTS account;
DROP SEQUENCE IF EXISTS account_seq;

CREATE SEQUENCE account_seq START WITH 100000 INCREMENT BY 1;

CREATE TABLE account
(
    id       INTEGER PRIMARY KEY DEFAULT nextval('account_seq') NOT NULL,
    user_id  INTEGER                                            NOT NULL,
    balance  DECIMAL(16, 2)      default 0                      NOT NULL,
    currency VARCHAR                                            NOT NULL,
    FOREIGN KEY user_id REFERENCES users(id) ON DELETE CASCADE
)