CREATE SCHEMA IF NOT EXISTS security;

SET SCHEMA 'security';

CREATE TABLE IF NOT EXISTS users(
    id BIGSERIAL NOT NULL PRIMARY KEY,
    username TEXT NOT NULL
);
