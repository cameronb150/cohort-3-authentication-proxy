-- password: P@ss4P@ssw0rd
INSERT INTO users(username, email_address, password, enabled)
VALUES('user', 'user@example.com', '$2a$16$hGnj/E9o.M07qtAZCDkNFee83NwXrsxedR6LSp4e5ZX4HptSQ2Btq', TRUE);

INSERT INTO user_roles (user_id, role_name)
VALUES (1, 'USER'::role);