CREATE SCHEMA hbr_employees;

USE hbr_employees;

DROP TABLE IF EXISTS `employee`;

CREATE TABLE employee (
  id int(11) NOT NULL AUTO_INCREMENT,
  first_name varchar(45) DEFAULT NULL,
  last_name varchar(45) DEFAULT NULL,
  company varchar(45) DEFAULT NULL,
  PRIMARY KEY (id)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;