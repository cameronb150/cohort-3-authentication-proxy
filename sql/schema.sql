CREATE TABLE users (
    user_id bigserial NOT NULL PRIMARY KEY,
        username text NOT NULL UNIQUE,
        email_address text NOT NULL UNIQUE,
        password text NOT NULL,
        enabled boolean NOT NULL
);

CREATE TYPE role AS Enum('USER', 'ADMIN');

CREATE TABLE user_roles (
    user_id bigserial NOT NULL,
        role_name role NOT NULL,
        PRIMARY KEY(user_id, role_name),
        CONSTRAINT fk_user_roles FOREIGN KEY(user_id) REFERENCES users(user_id)
);