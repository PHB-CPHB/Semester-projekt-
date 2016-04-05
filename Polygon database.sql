DROP DATABASE IF EXISTS polygon;
CREATE DATABASE polygon;
USE polygon;
DROP TABLE IF EXISTS buildings;
DROP TABLE IF EXISTS admin;
DROP TABLE IF EXISTS customer;


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
primary key (building_id)
);

CREATE TABLE login(
username VARCHAR(10),
password VARCHAR(10),
user_id INT(10) NOT NULL AUTO_INCREMENT,
user_role VARCHAR(10),
primary key (user_id, username)
);


INSERT INTO buildings (building_id, building_name, building_status, building_type, building_adress, building_year, building_zipcode, building_city, building_areasize) VALUES (1, 'Olivers bygning', 'I stand', 'Hus', 'Kappa 123', 1978, 3240, 'Metrocity', 70);

INSERT INTO login (username, password, user_role) VALUES ('Oliver', '123', 'admin');
INSERT INTO login (username, password, user_role) VALUES ('Tim', '1234', 'admin');
INSERT INTO login (username, password, user_role) VALUES ('Phillip', '12345', 'customer');
INSERT INTO login (username, password, user_role) VALUES ('Michael', '123456', 'admin');
select * from login;
