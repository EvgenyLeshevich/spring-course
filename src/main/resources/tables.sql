CREATE TABLE employees
(
    id         BIGSERIAL PRIMARY KEY,
    name       VARCHAR(15),
    surname    VARCHAR(25),
    department VARCHAR(20),
    salary     INTEGER
);


-----------------------------------
-- one-to-one
CREATE TABLE details
(
    id           BIGSERIAL PRIMARY KEY,
    city         VARCHAR(15),
    phone_number VARCHAR(25),
    email        VARCHAR(30)
);

CREATE TABLE employees
(
    id         BIGSERIAL PRIMARY KEY,
    name       VARCHAR(15),
    surname    VARCHAR(25),
    department VARCHAR(20),
    salary     INTEGER,
    details_id BIGINT,
    FOREIGN KEY (details_id) REFERENCES details (id)
);


----------------------------
-- one-to-many
CREATE TABLE departments
(
    id         BIGSERIAL PRIMARY KEY,
    name       VARCHAR(15),
    max_salary INTEGER,
    min_salary INTEGER
);

CREATE TABLE employees
(
    id            BIGSERIAL PRIMARY KEY,
    name          VARCHAR(15),
    surname       VARCHAR(25),
    salary        INTEGER,
    department_id BIGINT,
    FOREIGN KEY (department_id) REFERENCES departments (id)
);


-----------------------------------
-- many-to-many
CREATE TABLE children (
    id BIGSERIAL PRIMARY KEY,
    name VARCHAR(15),
    age INTEGER
);

CREATE TABLE section (
    id BIGSERIAL PRIMARY KEY,
    name VARCHAR(15)
);

CREATE TABLE child_section (
    child_id BIGINT,
    section_id BIGINT,
    PRIMARY KEY (child_id, section_id),
    FOREIGN KEY (child_id) REFERENCES children(id),
    FOREIGN KEY (section_id) REFERENCES section(id)
)