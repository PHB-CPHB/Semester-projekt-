DROP DATABASE IF EXISTS polygon;
CREATE DATABASE polygon;
USE polygon;
DROP TABLE IF EXISTS buildings;
DROP TABLE IF EXISTS login;


CREATE TABLE login(
username VARCHAR(10),
password VARCHAR(10),
user_id INT(10),
user_role VARCHAR(10),
user_firm VARCHAR (10),
primary key (user_firm)
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
primary key (building_id),
FOREIGN KEY (building_firm) 
REFERENCES login(user_firm)
);


INSERT INTO buildings (building_name, building_status, building_type, building_adress, building_year, building_zipcode, building_city, building_areasize, building_firm) VALUES ('Olivers bygning', 'I stand', 'Hus', 'Kappa 123', 1978, 3240, 'Metrocity', 70, 'PC');
INSERT INTO buildings (building_name, building_status, building_type, building_adress, building_year, building_zipcode, building_city, building_areasize, building_firm) VALUES ('Tim bygning', 'I stand', 'Hus', 'Kappa 123', 1978, 3240, 'Metrocity', 70, 'PC');
INSERT INTO buildings (building_name, building_status, building_type, building_adress, building_year, building_zipcode, building_city, building_areasize, building_firm) VALUES ('Michael bygning', 'I stand', 'Hus', 'Kappa 123', 1978, 3240, 'Metrocity', 70, 'ABE');
INSERT INTO buildings (building_name, building_status, building_type, building_adress, building_year, building_zipcode, building_city, building_areasize, building_firm) VALUES ('Phillip bygning', 'I stand', 'Hus', 'Kappa 123', 1978, 3240, 'Metrocity', 70, 'ABE');

INSERT INTO login (username, password, user_id, user_role, user_firm) VALUES ('Oliver', '123', 1, 'admin', 'Polygon');
INSERT INTO login (username, password, user_id, user_role, user_firm) VALUES ('Tim', '1234', 2, 'admin', 'Polygon');
INSERT INTO login (username, password, user_id, user_role, user_firm) VALUES ('Phillip', '12345', 3, 'customer', 'ABE');
INSERT INTO login (username, password, user_id, user_role, user_firm) VALUES ('Michael', '123456', 4, 'admin', 'Polygon');
INSERT INTO login (username, password, user_id, user_role, user_firm) VALUES ('Brink', '123', 5, 'customer', 'PC');

select * from login;
SELECT * FROM login WHERE username = 'Oliver';