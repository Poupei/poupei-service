CREATE TABLE IF NOT EXISTS user_account (
    user_id VARCHAR(36) PRIMARY KEY NOT NULL,
    name VARCHAR(45) NOT NULL,
    email VARCHAR(45) NOT NULL,
    password VARCHAR(45) NOT NULL,
    limit_spend DOUBLE NOT NULL,
    duedate DATE NULL
);

CREATE TABLE IF NOT EXISTS bank (
    bank_id VARCHAR(36) PRIMARY KEY NOT NULL,
    name VARCHAR(45) NOT NULL,
    code VARCHAR(45) NOT NULL,
    logo VARCHAR(45) NOT NULL
);

CREATE TABLE IF NOT EXISTS bank_account (
    bank_account_id VARCHAR(36) PRIMARY KEY NOT NULL,
    user_id VARCHAR(36) NOT NULL,
    bank_id VARCHAR(36) NOT NULL,
    name VARCHAR(45) NOT NULL,
    FOREIGN KEY (user_id)
    REFERENCES user_account(user_id),
    FOREIGN KEY (bank_id)
    REFERENCES bank(bank_id)
);

CREATE TABLE IF NOT EXISTS card (
    card_id VARCHAR(36) NOT NULL,
    account_id VARCHAR(36) NOT NULL,
    nickname VARCHAR(45) NOT NULL,
    type VARCHAR(45) NOT NULL,
    PRIMARY KEY (card_id),
    FOREIGN KEY (account_id)
    REFERENCES bank_account(bank_account_id)
);

CREATE TABLE IF NOT EXISTS transaction_account (
    transaction_id VARCHAR(36) PRIMARY KEY NOT NULL,
    user_id VARCHAR(36) NOT NULL,
    method VARCHAR(45) NOT NULL,
    type INT NOT NULL,
    transaction_value DOUBLE NOT NULL,
    datetime DATETIME NOT NULL,
    account_id VARCHAR(26) NOT NULL,
    card_id VARCHAR(26) NOT NULL,
    description VARCHAR(100) NOT NULL,
    installment INT NOT NULL,
    max_installment INT NOT NULL,
    FOREIGN KEY (card_id)
    REFERENCES card(card_id),
    FOREIGN KEY (account_id)
    REFERENCES bank_account(bank_account_id),
    FOREIGN KEY (user_id)
    REFERENCES user_account(user_id)
);