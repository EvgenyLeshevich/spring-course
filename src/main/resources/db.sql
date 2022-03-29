CREATE TABLE employees
(
    id         BIGSERIAL PRIMARY KEY,
    name       VARCHAR(15),
    surname    VARCHAR(25),
    department VARCHAR(20),
    salary     INTEGER
);

INSERT INTO employees(name, surname, department, salary)
VALUES ('Evgeniy', 'L', 'IT', 900),
       ('Nina', 'L', 'Sales', 750),
       ('Katya', 'K', 'HR', 700);