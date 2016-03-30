DROP TABLE IF EXISTS buildings;
DROP TABLE IF EXISTS admin;
DROP TABLE IF EXISTS customer;
DROP DATABASE IF EXISTS polygon;
CREATE DATABASE polygon;
USE polygon;

CREATE TABLE buildings(
Building_name INT(10) NOT NULL,
Building_status VARCHAR(10),
Room_id INT(10) NOT NULL,
Building_type VARCHAR(10),
adress VARCHAR(10),
year INT(10),
postnumber INT(10),
city VARCHAR(10),
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