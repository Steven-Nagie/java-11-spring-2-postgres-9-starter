CREATE SCHEMA IF NOT EXISTS broccoli_tinder;

SET SCHEMA 'broccoli_tinder';

CREATE TABLE users(
    id BIGSERIAL NOT NULL PRIMARY KEY,
    username TEXT NOT NULL
);
