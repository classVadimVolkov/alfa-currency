DROP TABLE IF EXISTS rate;
DROP SEQUENCE IF EXISTS rate_seq;

CREATE SEQUENCE rate_seq START WITH 100000 INCREMENT BY 1;

CREATE TABLE rate
(
    id            INTEGER PRIMARY KEY DEFAULT nextval('rate_seq') NOT NULL,
    sell_rate     DECIMAL(10, 6)                                 NOT NULL,
    sell_iso      VARCHAR(10)                                   NOT NULL,
    sell_code     INTEGER                                       NOT NULL,
    buy_rate      DECIMAL(10, 6)                                 NOT NULL,
    buy_iso       VARCHAR(10)                                   NOT NULL,
    buy_code      INTEGER                                       NOT NULL,
    quantity      INTEGER                                       NOT NULL,
    currency_name VARCHAR,
    rate_date     DATE                                          NOT NULL,
    created_at    TIMESTAMP(6)        DEFAULT current_timestamp NOT NULL,
    updated_at    TIMESTAMP(6)
);
