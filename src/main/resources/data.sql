CREATE SEQUENCE hibernate_sequence
    start with 2
    increment by 1
    cycle;
CREATE table companies
(
    id       int primary key,
    name     varchar(255),
    address  varchar(255),
    open int,
    close int
);
CREATE table reservations
(
    id           int primary key,
    name         varchar(255),
    phone_number varchar(255),
    email        varchar(255)
);
create table services
(
    id          int primary key,
    name        varchar(255),
    description varchar(255),
    duration    int,
    comp_id     int
);
create table ser_res
(
    ser_id int,

    res_id int
);
INSERT INTO COMPANIES (id, name, address, open,close)
VALUES (0, 'Mosoda', 'Debrecen',6,20);
INSERT INTO reservations (id, name, phone_number, email)
VALUES (0, 'Csaba', '456174895641', 'igen@dasw');
INSERT INTO services (id, name, description, duration, comp_id)
VALUES (0, 'Gyors Mosas', 'gyors mosas', 5, 0);
INSERT INTO services (id, name, description, duration, comp_id)
VALUES (1, 'Lassu mosasa', 'lassu mosas', 10, 0);
INSERT INTO ser_res (ser_id, res_id)
VALUES (0,0);