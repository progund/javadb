PRAGMA foreign_keys=OFF;
BEGIN TRANSACTION;
CREATE TABLE user(user_id INTEGER NOT NULL PRIMARY KEY, username TEXT NOT NULL UNIQUE, real_name TEXT NOT NULL);
INSERT INTO "user" VALUES(1,'rikard','Rikard Fröberg');
INSERT INTO "user" VALUES(2,'henrik','Henrik Sandklef');
CREATE TABLE login(user_id REFERENCES user(user_id) NOT NULL, password TEXT NOT NULL, PRIMARY KEY(user_id, password));
INSERT INTO "login" VALUES(1,'sikrit');
INSERT INTO "login" VALUES(2,'letmein');
COMMIT;
