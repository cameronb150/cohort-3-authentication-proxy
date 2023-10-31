CREATE ROLE capstone_read;
GRANT SELECT, INSERT, DELETE ON users TO capstone_read;
GRANT SELECT, INSERT, DELETE ON user_roles TO capstone_read;
GRANT capstone_read to capstone_user;