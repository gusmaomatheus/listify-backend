CREATE TABLE users (
    id SERIAL PRIMARY KEY,
    first_name VARCHAR(30) NOT NULL,
    last_name VARCHAR(60) NOT NULL,
    username VARCHAR(20) NOT NULL UNIQUE,
    password VARCHAR(32) NOT NULL
);