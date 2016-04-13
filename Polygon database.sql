DROP DATABASE IF EXISTS polygon;
CREATE DATABASE polygon;
USE polygon;
DROP TABLE IF EXISTS login;
DROP TABLE IF EXISTS firm;
DROP TABLE IF EXISTS Zip;
DROP TABLE IF EXISTS buildings;
CREATE TABLE login(
username VARCHAR(10) UNIQUE,
password VARCHAR(10),
user_id INT(10) AUTO_INCREMENT,
user_role VARCHAR(10),
user_firm VARCHAR (10),
primary key (user_id)
);
CREATE TABLE Zip(
zipcode INT(10),
city VARCHAR(45),
primary key (zipcode)
);
CREATE TABLE firm(
firm_name VARCHAR(10) UNIQUE,
firm_leader_id INT(10),
firm_id INT(10) NOT NULL AUTO_INCREMENT,
PRIMARY key (firm_id),
FOREIGN KEY (firm_leader_id) 
REFERENCES login(user_id)
);
CREATE TABLE buildings(
building_id INT(10) NOT NULL AUTO_INCREMENT,
building_name VARCHAR(45),
building_status VARCHAR(145),
building_type VARCHAR(145),
building_adress VARCHAR(45),
building_year INT(10),
building_zipcode INT(10),
building_areasize INT(10),
building_parcel_no VARCHAR(10),
building_floor VARCHAR(10),
building_firm_id INT(10),
primary key (building_id),
FOREIGN KEY (building_zipcode) 
REFERENCES Zip(zipcode),
FOREIGN KEY (building_firm_id) 
REFERENCES firm(firm_id)
);
INSERT INTO Zip (zipcode, city) 
VALUES (1000, "Ballerup");
INSERT INTO Zip (zipcode, city) 
VALUES (2000, "København");
INSERT INTO Zip (zipcode, city) 
VALUES (3000, "København N");
INSERT INTO Zip (zipcode, city) 
VALUES (4000, "Metrocity");
INSERT INTO Zip (zipcode, city) 
VALUES (5000, "København S");
INSERT INTO Zip (zipcode, city) 
VALUES (6000, "København Ø");
INSERT INTO Zip (zipcode, city) 
VALUES (7000, "København V");
INSERT INTO Zip (zipcode, city) 
VALUES (8000, "Lyngby");
INSERT INTO Zip (zipcode, city)
VALUES (9000, "Tisserup");
INSERT INTO login (username, password, user_role, user_firm) 
VALUES ('Oliver', '123', 'admin', 'Polygon1');
INSERT INTO login (username, password, user_role, user_firm) 
VALUES ('Tim', '1234', 'admin', 'Polygon');
INSERT INTO login (username, password, user_role, user_firm) 
VALUES ('Phillip', '12345', 'customer', 'ABE');
INSERT INTO login (username, password, user_role, user_firm) 
VALUES ('Michael', '123456', 'admin', 'Polygon2');
INSERT INTO login (username, password, user_role, user_firm) 
VALUES ('Brink', '123', 'customer', 'PC');
INSERT INTO firm (firm_name, firm_leader_id) VALUES ('Polygon1', 1);
INSERT INTO firm (firm_name, firm_leader_id) VALUES ('Polygon', 2);
INSERT INTO firm (firm_name, firm_leader_id) VALUES ('ABE', 3);
INSERT INTO firm (firm_name, firm_leader_id) VALUES ('Polygon2', 4);
INSERT INTO firm (firm_name, firm_leader_id) VALUES ('PC', 5);
INSERT INTO buildings (building_name, building_status, building_type, building_adress, building_year, building_zipcode, building_areasize, building_parcel_no, building_floor, building_firm_id)
VALUES ('Olivers bygning', 'I stand', 'Hus', 'Kappa 123', 1992, 1000, 70, '123', '1', 1);
INSERT INTO buildings (building_name, building_status, building_type, building_adress, building_year, building_zipcode, building_areasize, building_parcel_no, building_floor, building_firm_id) 
VALUES ('Olivers bygning', 'I stand', 'Hus', 'Kappa 123', 1992, 2000, 70, '123', '1', 1);
INSERT INTO buildings (building_name, building_status, building_type, building_adress, building_year, building_zipcode, building_areasize, building_parcel_no, building_floor, building_firm_id) 
VALUES ('Olivers bygning', 'I stand', 'Hus', 'Kappa 123', 1992, 3000, 70, '123', '1', 2);
INSERT INTO buildings (building_name, building_status, building_type, building_adress, building_year, building_zipcode, building_areasize, building_parcel_no, building_floor, building_firm_id) 
VALUES ('Olivers bygning', 'I stand', 'Hus', 'Kappa 123', 1992, 4000, 70, '123', '1', 2);
INSERT INTO buildings (building_name, building_status, building_type, building_adress, building_year, building_zipcode, building_areasize, building_parcel_no, building_floor, building_firm_id) 
VALUES ('Olivers bygning', 'I stand', 'Hus', 'Kappa 123', 1992, 5000, 70, '123', '1', 3);
INSERT INTO buildings (building_name, building_status, building_type, building_adress, building_year, building_zipcode, building_areasize, building_parcel_no, building_floor, building_firm_id)
VALUES ('Olivers bygning', 'I stand', 'Hus', 'Kappa 123', 1992, 6000, 70, '123', '1', 3);
INSERT INTO buildings (building_name, building_status, building_type, building_adress, building_year, building_zipcode, building_areasize, building_parcel_no, building_floor, building_firm_id)
VALUES ('Olivers bygning', 'I stand', 'Hus', 'Kappa 123', 1992, 7000, 70, '123', '1', 4);
INSERT INTO buildings (building_name, building_status, building_type, building_adress, building_year, building_zipcode, building_areasize, building_parcel_no, building_floor, building_firm_id) 
VALUES ('Olivers bygning', 'I stand', 'Hus', 'Kappa 123', 1992, 8000, 70, '123', '1', 4);
INSERT INTO buildings (building_name, building_status, building_type, building_adress, building_year, building_zipcode, building_areasize, building_parcel_no, building_floor, building_firm_id) 
VALUES ('Olivers bygning', 'I stand', 'Hus', 'Kappa 123', 1992, 9000, 70, '123', '1', 4);
select buildings.building_id, buildings.building_status, buildings.building_type, buildings.building_year, buildings.building_areasize, buildings.building_name, buildings.building_adress, buildings.building_floor, buildings.building_zipcode, firm.firm_name FROM buildings INNER JOIN firm ON buildings.building_firm_id = firm.firm_id Where building_firm_id = 1 ;
SELECT firm.firm_id FROM firm INNER JOIN login ON login.user_id = firm.firm_leader_id WHERE login.user_id = 2;
SELECT buildings.building_id FROM buildings INNER JOIN login ON login.user_id = firm.firm_leader_id INNER JOIN firm ON firm.firm_id = buildings.building_firm_id WHERE user_id = 2;
Select * from login;
select * from firm;