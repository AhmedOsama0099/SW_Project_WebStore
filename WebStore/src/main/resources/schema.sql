CREATE TABLE users
(
 userName varchar(100) NOT NULL,
 email varchar(100) NOT NULL,
 pw varchar(100) NOT NULL,
 PRIMARY KEY (userName)
);
CREATE TABLE buyer
(
userName varchar(100) NOT NULL,
 FOREIGN KEY (userName) REFERENCES users(userName)
 ON DELETE CASCADE
);

CREATE TABLE admin
(
 userName varchar(100) NOT NULL,
 FOREIGN KEY (userName) REFERENCES users(userName)
 ON DELETE CASCADE
);

CREATE TABLE store_owner
(
userName varchar(100) NOT NULL,
 FOREIGN KEY (userName) REFERENCES users(userName)
 ON DELETE CASCADE
);