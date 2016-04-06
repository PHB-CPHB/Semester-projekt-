DROP DATABASE IF EXISTS polygon;
CREATE DATABASE polygon;
USE polygon;
DROP TABLE IF EXISTS buildings;
DROP TABLE IF EXISTS login;
CREATE TABLE login(
username VARCHAR(10),
password VARCHAR(10),
user_id INT(10) AUTO_INCREMENT,
user_role VARCHAR(10),
user_firm VARCHAR (10),
primary key (user_id)
);
CREATE TABLE buildings(
building_id INT(10) NOT NULL AUTO_INCREMENT,
building_name VARCHAR(45),
building_status VARCHAR(145),
building_type VARCHAR(145),
building_adress VARCHAR(45),
building_year INT(10),
building_zipcode INT(10),
building_city VARCHAR(45),
building_areasize INT(10),
building_firm VARCHAR(10) NOT NULL,
building_firm_id INT(10),
primary key (building_id),
FOREIGN KEY (building_firm_id) 
REFERENCES login(user_id)
);
INSERT INTO login (username, password, user_role, user_firm) VALUES ('Oliver', '123', 'admin', 'Polygon1');
INSERT INTO login (username, password, user_role, user_firm) VALUES ('Tim', '1234', 'admin', 'Polygon');
INSERT INTO login (username, password, user_role, user_firm) VALUES ('Phillip', '12345', 'customer', 'ABE');
INSERT INTO login (username, password, user_role, user_firm) VALUES ('Michael', '123456', 'admin', 'Polygon2');
INSERT INTO login (username, password, user_role, user_firm) VALUES ('Brink', '123', 'customer', 'PC');
INSERT INTO buildings (building_name, building_status, building_type, building_adress, building_year, building_zipcode, building_city, building_areasize, building_firm, building_firm_id) VALUES ('Olivers bygning', 'I stand', 'Hus', 'Kappa 123', 1978, 3240, 'Metrocity', 70, 'PC', 1);
INSERT INTO buildings (building_name, building_status, building_type, building_adress, building_year, building_zipcode, building_city, building_areasize, building_firm, building_firm_id) VALUES ('Olivers bygning', 'I stand', 'Hus', 'Kappa 123', 1978, 3240, 'Metrocity', 70, 'PC', 1);
INSERT INTO buildings (building_name, building_status, building_type, building_adress, building_year, building_zipcode, building_city, building_areasize, building_firm, building_firm_id) VALUES ('Olivers bygning', 'I stand', 'Hus', 'Kappa 123', 1978, 3240, 'Metrocity', 70, 'PC', 2);
INSERT INTO buildings (building_name, building_status, building_type, building_adress, building_year, building_zipcode, building_city, building_areasize, building_firm, building_firm_id) VALUES ('Olivers bygning', 'I stand', 'Hus', 'Kappa 123', 1978, 3240, 'Metrocity', 70, 'PC', 2);
INSERT INTO buildings (building_name, building_status, building_type, building_adress, building_year, building_zipcode, building_city, building_areasize, building_firm, building_firm_id) VALUES ('Olivers bygning', 'I stand', 'Hus', 'Kappa 123', 1978, 3240, 'Metrocity', 70, 'PC', 3);
INSERT INTO buildings (building_name, building_status, building_type, building_adress, building_year, building_zipcode, building_city, building_areasize, building_firm, building_firm_id) VALUES ('Olivers bygning', 'I stand', 'Hus', 'Kappa 123', 1978, 3240, 'Metrocity', 70, 'PC', 3);
INSERT INTO buildings (building_name, building_status, building_type, building_adress, building_year, building_zipcode, building_city, building_areasize, building_firm, building_firm_id) VALUES ('Olivers bygning', 'I stand', 'Hus', 'Kappa 123', 1978, 3240, 'Metrocity', 70, 'PC', 4);
INSERT INTO buildings (building_name, building_status, building_type, building_adress, building_year, building_zipcode, building_city, building_areasize, building_firm, building_firm_id) VALUES ('Olivers bygning', 'I stand', 'Hus', 'Kappa 123', 1978, 3240, 'Metrocity', 70, 'PC', 4);
select * FROM buildings Where building_firm_id = 1;