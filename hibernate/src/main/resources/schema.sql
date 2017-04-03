drop table if EXISTS TB_CAR;
CREATE TABLE TB_CAR(
                car_id   INT NOT NULL AUTO_INCREMENT,
                name VARCHAR (20) NOT NULL,
                wheels_id INT (20) NOT NULL,
                engine_id INT (20) NOT NULL,
                PRIMARY KEY (car_id),
                UNIQUE KEY wheels_id (wheels_id),
                UNIQUE KEY engine_id (engine_id)
        );
drop table if EXISTS TB_ENGINE;
CREATE TABLE TB_ENGINE(
                engine_id   INT NOT NULL AUTO_INCREMENT,
                capacity DOUBLE (20) NOT NULL,
                PRIMARY KEY (engine_id)
        );
drop table if EXISTS TB_TYRES;
CREATE TABLE TB_TYRES(
                tyres_id   INT NOT NULL AUTO_INCREMENT,
                size INT (20) NOT NULL,
                name VARCHAR (20) NOT NULL,
                PRIMARY KEY (tyres_id)
        );
drop table if EXISTS TB_WHEELS;
CREATE TABLE TB_WHEELS(
                wheels_id INT NOT NULL AUTO_INCREMENT,
                car_id INT NOT NULL,
                tyres_id INT (20),
                PRIMARY KEY (wheels_id),
                UNIQUE KEY tyres_id (tyres_id)
        );