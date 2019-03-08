PRAGMA foreign_keys=OFF;
BEGIN TRANSACTION;
CREATE TABLE books(title TEXT NOT NULL PRIMARY KEY, pages INTEGER);
INSERT INTO "books" VALUES('Java for students',300);
INSERT INTO "books" VALUES('Java for professors',25);
INSERT INTO "books" VALUES('SQL for beginners',150);
INSERT INTO "books" VALUES('SQL for professionals',400);
INSERT INTO "books" VALUES('Birds - the coolest animals',834);
COMMIT;
