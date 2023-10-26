USE DATABASE capstone;
CREATE TABLE users (
    username varchar(255) not null,
    password varchar(255) not null,
    enabled boolean,
    PRIMARY KEY ( username )
);
CREATE TABLE authorities (
    username varchar(255) not null,
    authority varchar(255) not null,
    FOREIGN KEY ( users ) REFERENCES users (username, password, enabled)
);
