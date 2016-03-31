DROP DATABASE IF EXISTS polygon;
CREATE DATABASE polygon;
USE polygon;
DROP TABLE IF EXISTS buildings;
DROP TABLE IF EXISTS admin;
DROP TABLE IF EXISTS customer;


CREATE TABLE buildings(
building_name VARCHAR(45),
building_status VARCHAR(145),
building_type VARCHAR(145),
adress VARCHAR(45),
year INT(10),
postnumber INT(10),
city VARCHAR(45),
areasize INT(10)
);

CREATE TABLE admin(
ausername VARCHAR(10),
apassword VARCHAR(10)
);

CREATE TABLE customer(
cusername VARCHAR(10),
cpassword VARCHAR(10),
customer_id INT(10)
);

INSERT INTO buildings (building_name, building_status, building_type, adress, year, postnumber, city, areasize) VALUES ('Olivers bygning', 'I stand', 'Hus', 'Kappa 123', 1978, 3240, 'Metrocity', 70);

INSERT INTO admin (ausername, apassword) VALUES ('Oliver', '123');
INSERT INTO admin (ausername, apassword) VALUES ('Tim', '1234');
INSERT INTO admin (ausername, apassword) VALUES ('Phillip', '12345');
INSERT INTO admin (ausername, apassword) VALUES ('Michael', '123456');

INSERT INTO customer (cusername, cpassword, customer_id) VALUES ('bob', 'bob', 1);
INSERT INTO customer (cusername, cpassword, customer_id) VALUES ('Kaj', 'Kaj', 2);