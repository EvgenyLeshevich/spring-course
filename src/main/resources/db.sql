CREATE TABLE users
(
    username VARCHAR(15) PRIMARY KEY,
    password VARCHAR(100),
    enabled  BOOLEAN
);

CREATE TABLE authorities
(
    username  VARCHAR(15),
    authority VARCHAR(25),
    FOREIGN KEY (username) REFERENCES users (username)
);

INSERT INTO users (username, password, enabled)
VALUES ('evgeniy', '{noop}evgeniy', true),
       ('nina', '{noop}nina', true),
       ('ivan', '{noop}ivan', true);

INSERT INTO authorities (username, authority)
VALUES ('evgeniy', 'ROLE_EMPLOYEE'),
       ('nina', 'ROLE_HR'),
       ('ivan', 'ROLE_HR'),
       ('ivan', 'ROLE_MANAGER');

UPDATE users SET password = '{bcrypt}$2a$10$vIz2emmlTJKy6MNL5dIoyetAnBlES5pa7jE.dg/BSMYy/hal756fq' where username = 'evgeniy';
UPDATE users SET password = '{bcrypt}$2a$10$94gN/bHBiasF7fOHUMq1n.aHf6anFUGBd9mPoHOrIQfHq6ndRpBSa' where username = 'nina';
UPDATE users SET password = '{bcrypt}$2a$10$tMHFxT5IJ/vTdd6u19mqOOA.mOZ1Zs8DeYqD65m783JxBnCnM8YnW' where username = 'ivan';

