-- --------------------------------------------------------
-- Host:                         127.0.0.1
-- Server version:               5.1.72-community - MySQL Community Server (GPL)
-- Server OS:                    Win32
-- HeidiSQL Version:             9.4.0.5125
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;


-- Dumping database structure for procurement2
CREATE DATABASE IF NOT EXISTS `procurement2` /*!40100 DEFAULT CHARACTER SET latin1 */;
USE `procurement2`;

-- Dumping structure for table procurement2.address
CREATE TABLE IF NOT EXISTS `address` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `line1` varchar(50) NOT NULL DEFAULT '0',
  `line2` varchar(50) NOT NULL DEFAULT '0',
  `line3` varchar(50) NOT NULL DEFAULT '0',
  `city` varchar(50) NOT NULL DEFAULT '0',
  `pincode` varchar(50) NOT NULL DEFAULT '0',
  `state` varchar(50) NOT NULL DEFAULT '0',
  `country` varchar(50) NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Dumping data for table procurement2.address: ~0 rows (approximately)
DELETE FROM `address`;
/*!40000 ALTER TABLE `address` DISABLE KEYS */;
/*!40000 ALTER TABLE `address` ENABLE KEYS */;

-- Dumping structure for table procurement2.addresses
CREATE TABLE IF NOT EXISTS `addresses` (
  `address_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `addres_line1` varchar(255) DEFAULT NULL,
  `addres_line2` varchar(255) DEFAULT NULL,
  `addres_line3` varchar(255) DEFAULT NULL,
  `city` varchar(255) DEFAULT NULL,
  `country` varchar(255) DEFAULT NULL,
  `state` varchar(255) DEFAULT NULL,
  `zipcode` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`address_id`)
) ENGINE=InnoDB AUTO_INCREMENT=20 DEFAULT CHARSET=latin1;

-- Dumping data for table procurement2.addresses: ~10 rows (approximately)
DELETE FROM `addresses`;
/*!40000 ALTER TABLE `addresses` DISABLE KEYS */;
INSERT INTO `addresses` (`address_id`, `addres_line1`, `addres_line2`, `addres_line3`, `city`, `country`, `state`, `zipcode`) VALUES
	(1, 'Address1', NULL, NULL, NULL, NULL, NULL, NULL),
	(2, '4444444444444', NULL, NULL, NULL, NULL, NULL, NULL),
	(11, '', NULL, NULL, NULL, NULL, NULL, NULL),
	(12, 'Mumbai', NULL, NULL, NULL, NULL, NULL, NULL),
	(13, 'Mumbai', NULL, NULL, NULL, NULL, NULL, NULL),
	(14, 'Goregaon', NULL, NULL, NULL, NULL, NULL, NULL),
	(15, 'UP', NULL, NULL, NULL, NULL, NULL, NULL),
	(16, 'Mumbai', NULL, NULL, NULL, NULL, NULL, NULL),
	(17, 'Mumbai', NULL, NULL, NULL, NULL, NULL, NULL),
	(18, 'sdfsdf', NULL, NULL, NULL, NULL, NULL, NULL),
	(19, 'Mumbai', NULL, NULL, NULL, NULL, NULL, NULL);
/*!40000 ALTER TABLE `addresses` ENABLE KEYS */;

-- Dumping structure for table procurement2.app_menu
CREATE TABLE IF NOT EXISTS `app_menu` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) NOT NULL,
  `url` varchar(50) DEFAULT NULL,
  `description` varchar(500) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=latin1;

-- Dumping data for table procurement2.app_menu: ~5 rows (approximately)
DELETE FROM `app_menu`;
/*!40000 ALTER TABLE `app_menu` DISABLE KEYS */;
INSERT INTO `app_menu` (`id`, `name`, `url`, `description`) VALUES
	(1, 'Project_Add Project', '/addProject', NULL),
	(2, 'User_Register User', '/newUser', NULL),
	(3, 'Report', '/report', NULL),
	(4, 'Project_Edit Project', '/editProject', NULL),
	(5, 'User_Search User', '/searchUser', NULL);
/*!40000 ALTER TABLE `app_menu` ENABLE KEYS */;

-- Dumping structure for table procurement2.app_project
CREATE TABLE IF NOT EXISTS `app_project` (
  `project_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `project_name` varchar(100) NOT NULL,
  `sub_division_name` varchar(100) NOT NULL,
  `start_date` date NOT NULL,
  `end_date` date NOT NULL,
  `project_address` varchar(500) NOT NULL,
  `remarks` varchar(1000) DEFAULT NULL,
  `contact_person_name` varchar(100) NOT NULL,
  `contact_person_email` varchar(100) NOT NULL,
  `contact_person_phone` varchar(30) NOT NULL,
  `project_client_name` varchar(100) NOT NULL,
  `project_client_email` varchar(100) NOT NULL,
  `project_client_phone` varchar(30) NOT NULL,
  `architect_name` varchar(100) NOT NULL,
  `architect_email` varchar(100) NOT NULL,
  `architect_phone` varchar(30) NOT NULL,
  `structural_name` varchar(100) NOT NULL,
  `structural_email` varchar(100) NOT NULL,
  `structural_phone` varchar(30) NOT NULL,
  `project_status` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`project_id`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=latin1;

-- Dumping data for table procurement2.app_project: ~3 rows (approximately)
DELETE FROM `app_project`;
/*!40000 ALTER TABLE `app_project` DISABLE KEYS */;
INSERT INTO `app_project` (`project_id`, `project_name`, `sub_division_name`, `start_date`, `end_date`, `project_address`, `remarks`, `contact_person_name`, `contact_person_email`, `contact_person_phone`, `project_client_name`, `project_client_email`, `project_client_phone`, `architect_name`, `architect_email`, `architect_phone`, `structural_name`, `structural_email`, `structural_phone`, `project_status`) VALUES
	(1, 'demo', 'demo', '2017-01-31', '2017-12-31', 'bhayandar', '', 'vivek', 'a@b', '992', 'vivek_c', 'a_c@b', '9920c', 'vivek_a', 'a_a@b', '9920a', 'vivek_s', 'a_a@b', '9920c', 'Open'),
	(2, 'Test1', 'Test2', '2017-12-01', '2017-12-02', 'Test4', 'Test3', 'Test5', 'Test7', '222222222', 'Test8', 'test10', '2222222', 'Test11', 'Test33', '222222222', 'Test', 'Testww', '22222222', 'Open'),
	(11, 'Test1234', 'Test1234', '2018-03-15', '2018-03-14', 'sdfsdf', 'sdfsdf', 'sdf', 'Test@gmail.com', '24234', 'sdfsdf', 'Test@gamil.com', '352453425', 'dsfsdf', 'Test@gmail.com', '34234234', '324234', 'test@gmail.com', '3244234', 'Open');
/*!40000 ALTER TABLE `app_project` ENABLE KEYS */;

-- Dumping structure for table procurement2.app_user
CREATE TABLE IF NOT EXISTS `app_user` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `first_name` varchar(100) NOT NULL,
  `middle_name` varchar(100) DEFAULT NULL,
  `last_name` varchar(100) NOT NULL,
  `mobile_number` varchar(30) NOT NULL,
  `alternate_number` varchar(30) DEFAULT NULL,
  `email` varchar(100) NOT NULL,
  `address` varchar(500) NOT NULL,
  `sso_id` varchar(30) NOT NULL,
  `password` varchar(100) NOT NULL,
  `retype_password` varchar(100) NOT NULL,
  `user_status` varchar(100) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `sso_id` (`sso_id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;

-- Dumping data for table procurement2.app_user: ~2 rows (approximately)
DELETE FROM `app_user`;
/*!40000 ALTER TABLE `app_user` DISABLE KEYS */;
INSERT INTO `app_user` (`id`, `first_name`, `middle_name`, `last_name`, `mobile_number`, `alternate_number`, `email`, `address`, `sso_id`, `password`, `retype_password`, `user_status`) VALUES
	(1, 'Sam', NULL, 'Smith', '9999999999', NULL, 'samy@xyz.com', 'Thane (West)', 'sam', '$2a$10$4eqIF5s/ewJwHK1p8lqlFOEm2QIA0S8g6./Lok.pQxqcxaBZYChRm', '$2a$10$4eqIF5s/ewJwHK1p8lqlFOEm2QIA0S8g6./Lok.pQxqcxaBZYChRm', 'Active'),
	(2, 'Harshad', 'P', 'Gaikwad', '7208733078', '7208733078', 'Test@gmail.com', 'Test', 'windows', '$2a$10$nIklQjVzZJ/DPi3NmZ0.W.atbOY6jNEMjHXKyRgh9KL3pq4IikxYO', 'windows', 'Active');
/*!40000 ALTER TABLE `app_user` ENABLE KEYS */;

-- Dumping structure for table procurement2.app_user_project
CREATE TABLE IF NOT EXISTS `app_user_project` (
  `user_id` bigint(20) NOT NULL,
  `project_id` bigint(20) NOT NULL,
  PRIMARY KEY (`user_id`,`project_id`),
  KEY `FK_APP_PROJECT` (`project_id`),
  CONSTRAINT `FK_APP_PROJECT` FOREIGN KEY (`project_id`) REFERENCES `app_project` (`project_id`),
  CONSTRAINT `FK_APP_USER_PROJECT` FOREIGN KEY (`user_id`) REFERENCES `app_user` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Dumping data for table procurement2.app_user_project: ~1 rows (approximately)
DELETE FROM `app_user_project`;
/*!40000 ALTER TABLE `app_user_project` DISABLE KEYS */;
INSERT INTO `app_user_project` (`user_id`, `project_id`) VALUES
	(1, 2);
/*!40000 ALTER TABLE `app_user_project` ENABLE KEYS */;

-- Dumping structure for table procurement2.app_user_user_profile
CREATE TABLE IF NOT EXISTS `app_user_user_profile` (
  `user_id` bigint(20) NOT NULL,
  `user_profile_id` bigint(20) NOT NULL,
  PRIMARY KEY (`user_id`,`user_profile_id`),
  KEY `FK_USER_PROFILE` (`user_profile_id`),
  CONSTRAINT `FK_APP_USER` FOREIGN KEY (`user_id`) REFERENCES `app_user` (`id`),
  CONSTRAINT `FK_USER_PROFILE` FOREIGN KEY (`user_profile_id`) REFERENCES `user_profile` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Dumping data for table procurement2.app_user_user_profile: ~2 rows (approximately)
DELETE FROM `app_user_user_profile`;
/*!40000 ALTER TABLE `app_user_user_profile` DISABLE KEYS */;
INSERT INTO `app_user_user_profile` (`user_id`, `user_profile_id`) VALUES
	(1, 2),
	(2, 2);
/*!40000 ALTER TABLE `app_user_user_profile` ENABLE KEYS */;

-- Dumping structure for table procurement2.banks
CREATE TABLE IF NOT EXISTS `banks` (
  `bank_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `bank_name` varchar(255) NOT NULL,
  PRIMARY KEY (`bank_id`),
  UNIQUE KEY `UK_pm44fp6lf4gf4qj7tr4a2b5iq` (`bank_name`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=latin1;

-- Dumping data for table procurement2.banks: ~5 rows (approximately)
DELETE FROM `banks`;
/*!40000 ALTER TABLE `banks` DISABLE KEYS */;
INSERT INTO `banks` (`bank_id`, `bank_name`) VALUES
	(9, 'CITI'),
	(1, 'HDFC'),
	(2, 'IDBI'),
	(10, 'PNB'),
	(8, 'SBI');
/*!40000 ALTER TABLE `banks` ENABLE KEYS */;

-- Dumping structure for table procurement2.bank_branches
CREATE TABLE IF NOT EXISTS `bank_branches` (
  `bank_branch_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `branch_ifsc` varchar(255) NOT NULL,
  `branch_name` varchar(255) DEFAULT NULL,
  `bank_id` bigint(20) NOT NULL,
  PRIMARY KEY (`bank_branch_id`),
  UNIQUE KEY `UK_6nh10p2j20pm9ubh9y02pg9jd` (`branch_ifsc`),
  KEY `FK_t6dd43rlm0a81h59dbiq1vie6` (`bank_id`),
  CONSTRAINT `FK_t6dd43rlm0a81h59dbiq1vie6` FOREIGN KEY (`bank_id`) REFERENCES `banks` (`bank_id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;

-- Dumping data for table procurement2.bank_branches: ~3 rows (approximately)
DELETE FROM `bank_branches`;
/*!40000 ALTER TABLE `bank_branches` DISABLE KEYS */;
INSERT INTO `bank_branches` (`bank_branch_id`, `branch_ifsc`, `branch_name`, `bank_id`) VALUES
	(1, '123456789', 'Goregaon', 1),
	(2, '987654321', 'Malad', 1),
	(3, '1111111111', 'Dadar', 1);
/*!40000 ALTER TABLE `bank_branches` ENABLE KEYS */;

-- Dumping structure for table procurement2.customer
CREATE TABLE IF NOT EXISTS `customer` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `firstname` varchar(50) NOT NULL DEFAULT '0',
  `lastname` varchar(50) NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=152 DEFAULT CHARSET=utf8;

-- Dumping data for table procurement2.customer: ~16 rows (approximately)
DELETE FROM `customer`;
/*!40000 ALTER TABLE `customer` DISABLE KEYS */;
INSERT INTO `customer` (`id`, `firstname`, `lastname`) VALUES
	(1, 'Mark', 'Pollack'),
	(11, 'Juergen', 'Hoeller'),
	(21, 'Mark', 'Fisher'),
	(31, 'Rod', 'Johnson'),
	(41, 'David', 'Syer'),
	(51, 'Gunnar', 'Hillert'),
	(61, 'Dave', 'McCrory'),
	(71, 'Josh', 'Long'),
	(81, 'Patrick', 'Chanezon'),
	(91, 'Andy', 'Piper'),
	(101, 'Eric', 'Bottard'),
	(111, 'Chris', 'Richardson'),
	(121, 'Raja', 'Rao'),
	(131, 'Rajdeep', 'Dua'),
	(141, 'Monica', 'Wilkinson'),
	(151, 'Mark', 'Pollack');
/*!40000 ALTER TABLE `customer` ENABLE KEYS */;

-- Dumping structure for function procurement2.fun_splitString
DELIMITER //
CREATE DEFINER=`root`@`localhost` FUNCTION `fun_splitString`(
	`x` VARCHAR(255),
	`delim` VARCHAR(12),
	`pos` INT



) RETURNS varchar(255) CHARSET latin1
RETURN REPLACE(SUBSTRING(SUBSTRING_INDEX(x, delim, pos),
       LENGTH(SUBSTRING_INDEX(x, delim, pos -1)) + 1),
       delim, '')//
DELIMITER ;

-- Dumping structure for table procurement2.grade
CREATE TABLE IF NOT EXISTS `grade` (
  `grade_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `grade_name` varchar(50) NOT NULL DEFAULT '0',
  PRIMARY KEY (`grade_id`),
  UNIQUE KEY `grade_name` (`grade_name`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Dumping data for table procurement2.grade: ~0 rows (approximately)
DELETE FROM `grade`;
/*!40000 ALTER TABLE `grade` DISABLE KEYS */;
/*!40000 ALTER TABLE `grade` ENABLE KEYS */;

-- Dumping structure for table procurement2.grades
CREATE TABLE IF NOT EXISTS `grades` (
  `gradeId` bigint(20) NOT NULL AUTO_INCREMENT,
  `gradeDesc` varchar(255) DEFAULT NULL,
  `gradeName` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`gradeId`),
  UNIQUE KEY `UK_2vae5uan65j1no7nhe7rdcxai` (`gradeName`)
) ENGINE=InnoDB AUTO_INCREMENT=24 DEFAULT CHARSET=latin1;

-- Dumping data for table procurement2.grades: ~23 rows (approximately)
DELETE FROM `grades`;
/*!40000 ALTER TABLE `grades` DISABLE KEYS */;
INSERT INTO `grades` (`gradeId`, `gradeDesc`, `gradeName`) VALUES
	(1, 'PPC', 'PPC'),
	(2, 'OPC33', 'OPC33'),
	(3, 'OPC43', 'OPC43'),
	(4, 'OPC53 ', 'OPC53 '),
	(5, 'M20', 'M20'),
	(6, 'M25', 'M25'),
	(7, 'M30', 'M30'),
	(8, 'M35', 'M35'),
	(9, 'M40', 'M40'),
	(10, 'M45', 'M45'),
	(11, 'M50', 'M50'),
	(12, 'd6mm', 'd6mm'),
	(13, 'd8mm', 'd8mm'),
	(14, 'd12mm', 'd12mm'),
	(15, 'd16mm', 'd16mm'),
	(16, 'd20mm', 'd20mm'),
	(17, 'd25mm', 'd25mm'),
	(18, 'd32mm', 'd32mm'),
	(19, 'inch4', 'inch4'),
	(20, 'inch6', 'inch6'),
	(21, 'M1', 'M1'),
	(22, 'M2', 'M2'),
	(23, 'N/A', 'N/A');
/*!40000 ALTER TABLE `grades` ENABLE KEYS */;

-- Dumping structure for table procurement2.grade_units
CREATE TABLE IF NOT EXISTS `grade_units` (
  `gradeId` bigint(20) NOT NULL,
  `unitId` bigint(20) NOT NULL,
  KEY `FK_o3i419mew5lrv02fhig9p9no9` (`unitId`),
  KEY `FK_i7wmxwdyl2t83btjf4yvhgiw7` (`gradeId`),
  CONSTRAINT `FK_i7wmxwdyl2t83btjf4yvhgiw7` FOREIGN KEY (`gradeId`) REFERENCES `grades` (`gradeId`),
  CONSTRAINT `FK_o3i419mew5lrv02fhig9p9no9` FOREIGN KEY (`unitId`) REFERENCES `units` (`unitId`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Dumping data for table procurement2.grade_units: ~23 rows (approximately)
DELETE FROM `grade_units`;
/*!40000 ALTER TABLE `grade_units` DISABLE KEYS */;
INSERT INTO `grade_units` (`gradeId`, `unitId`) VALUES
	(1, 1),
	(2, 1),
	(3, 1),
	(4, 1),
	(5, 2),
	(6, 2),
	(7, 2),
	(8, 2),
	(9, 2),
	(10, 2),
	(11, 2),
	(12, 3),
	(13, 3),
	(14, 3),
	(15, 3),
	(16, 3),
	(17, 3),
	(18, 3),
	(19, 4),
	(20, 4),
	(21, 5),
	(22, 5),
	(23, 6);
/*!40000 ALTER TABLE `grade_units` ENABLE KEYS */;

-- Dumping structure for table procurement2.item
CREATE TABLE IF NOT EXISTS `item` (
  `item_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `item_name` varchar(50) NOT NULL,
  PRIMARY KEY (`item_id`),
  UNIQUE KEY `item_name` (`item_name`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Dumping data for table procurement2.item: ~0 rows (approximately)
DELETE FROM `item`;
/*!40000 ALTER TABLE `item` DISABLE KEYS */;
/*!40000 ALTER TABLE `item` ENABLE KEYS */;

-- Dumping structure for table procurement2.items
CREATE TABLE IF NOT EXISTS `items` (
  `itemId` bigint(20) NOT NULL AUTO_INCREMENT,
  `itemDesc` varchar(255) DEFAULT NULL,
  `itemName` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`itemId`),
  UNIQUE KEY `UK_ix851y7kx79s8w5kg2bixd9xi` (`itemName`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=latin1;

-- Dumping data for table procurement2.items: ~6 rows (approximately)
DELETE FROM `items`;
/*!40000 ALTER TABLE `items` DISABLE KEYS */;
INSERT INTO `items` (`itemId`, `itemDesc`, `itemName`) VALUES
	(1, 'Cement', 'Cement'),
	(2, 'RMC', 'RMC'),
	(3, 'Steel', 'Steel'),
	(4, 'Blocks', 'Blocks'),
	(5, 'Aggregates', 'Aggregates'),
	(6, 'Sand', 'Sand');
/*!40000 ALTER TABLE `items` ENABLE KEYS */;

-- Dumping structure for table procurement2.item_grades
CREATE TABLE IF NOT EXISTS `item_grades` (
  `itemId` bigint(20) NOT NULL,
  `gradeId` bigint(20) NOT NULL,
  KEY `FK_cnmb2osfpdbmhjnrugbggdbd3` (`gradeId`),
  KEY `FK_j7m8wreyi9r3iscqe1yqam3hf` (`itemId`),
  CONSTRAINT `FK_cnmb2osfpdbmhjnrugbggdbd3` FOREIGN KEY (`gradeId`) REFERENCES `grades` (`gradeId`),
  CONSTRAINT `FK_j7m8wreyi9r3iscqe1yqam3hf` FOREIGN KEY (`itemId`) REFERENCES `items` (`itemId`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Dumping data for table procurement2.item_grades: ~23 rows (approximately)
DELETE FROM `item_grades`;
/*!40000 ALTER TABLE `item_grades` DISABLE KEYS */;
INSERT INTO `item_grades` (`itemId`, `gradeId`) VALUES
	(1, 1),
	(1, 2),
	(1, 3),
	(1, 4),
	(2, 5),
	(2, 6),
	(2, 7),
	(2, 8),
	(2, 9),
	(2, 10),
	(2, 11),
	(3, 12),
	(3, 13),
	(3, 14),
	(3, 15),
	(3, 16),
	(3, 17),
	(3, 18),
	(4, 19),
	(4, 20),
	(5, 21),
	(5, 22),
	(6, 23);
/*!40000 ALTER TABLE `item_grades` ENABLE KEYS */;

-- Dumping structure for table procurement2.item_quantity
CREATE TABLE IF NOT EXISTS `item_quantity` (
  `quantity_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `quantity_name` varchar(50) NOT NULL DEFAULT '0',
  PRIMARY KEY (`quantity_id`),
  UNIQUE KEY `quantity_name` (`quantity_name`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Dumping data for table procurement2.item_quantity: ~0 rows (approximately)
DELETE FROM `item_quantity`;
/*!40000 ALTER TABLE `item_quantity` DISABLE KEYS */;
/*!40000 ALTER TABLE `item_quantity` ENABLE KEYS */;

-- Dumping structure for table procurement2.item_requisition
CREATE TABLE IF NOT EXISTS `item_requisition` (
  `item_req_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `item_id` bigint(20) NOT NULL DEFAULT '0',
  `grade_id` bigint(20) NOT NULL DEFAULT '0',
  `usedfor` varchar(50) NOT NULL DEFAULT '0',
  `quantity_id` bigint(20) NOT NULL DEFAULT '0',
  `unit_id` bigint(20) NOT NULL DEFAULT '0',
  `size_id` bigint(20) NOT NULL DEFAULT '0',
  `requisition_id` varchar(50) NOT NULL DEFAULT '0',
  PRIMARY KEY (`item_req_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Dumping data for table procurement2.item_requisition: ~0 rows (approximately)
DELETE FROM `item_requisition`;
/*!40000 ALTER TABLE `item_requisition` DISABLE KEYS */;
/*!40000 ALTER TABLE `item_requisition` ENABLE KEYS */;

-- Dumping structure for table procurement2.item_size
CREATE TABLE IF NOT EXISTS `item_size` (
  `size_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `size_name` varchar(50) NOT NULL,
  PRIMARY KEY (`size_id`),
  UNIQUE KEY `size_name` (`size_name`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Dumping data for table procurement2.item_size: ~0 rows (approximately)
DELETE FROM `item_size`;
/*!40000 ALTER TABLE `item_size` DISABLE KEYS */;
/*!40000 ALTER TABLE `item_size` ENABLE KEYS */;

-- Dumping structure for table procurement2.item_unit
CREATE TABLE IF NOT EXISTS `item_unit` (
  `unit_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `unit_name` varchar(50) NOT NULL,
  PRIMARY KEY (`unit_id`),
  UNIQUE KEY `unit_name` (`unit_name`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Dumping data for table procurement2.item_unit: ~0 rows (approximately)
DELETE FROM `item_unit`;
/*!40000 ALTER TABLE `item_unit` DISABLE KEYS */;
/*!40000 ALTER TABLE `item_unit` ENABLE KEYS */;

-- Dumping structure for table procurement2.notes
CREATE TABLE IF NOT EXISTS `notes` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `content` varchar(255) DEFAULT NULL,
  `created_at` datetime NOT NULL,
  `title` varchar(255) DEFAULT NULL,
  `updated_at` datetime NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=12 DEFAULT CHARSET=utf8;

-- Dumping data for table procurement2.notes: 2 rows
DELETE FROM `notes`;
/*!40000 ALTER TABLE `notes` DISABLE KEYS */;
INSERT INTO `notes` (`id`, `content`, `created_at`, `title`, `updated_at`) VALUES
	(1, 'Test', '2018-03-12 12:41:11', 'First Book', '2018-03-12 12:41:11'),
	(11, 'Test2', '2018-03-12 10:52:13', 'First Book2', '2018-03-12 10:52:13');
/*!40000 ALTER TABLE `notes` ENABLE KEYS */;

-- Dumping structure for table procurement2.persistent_logins
CREATE TABLE IF NOT EXISTS `persistent_logins` (
  `username` varchar(64) NOT NULL,
  `series` varchar(64) NOT NULL,
  `token` varchar(64) NOT NULL,
  `last_used` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`series`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Dumping data for table procurement2.persistent_logins: ~0 rows (approximately)
DELETE FROM `persistent_logins`;
/*!40000 ALTER TABLE `persistent_logins` DISABLE KEYS */;
/*!40000 ALTER TABLE `persistent_logins` ENABLE KEYS */;

-- Dumping structure for table procurement2.project_requisitions
CREATE TABLE IF NOT EXISTS `project_requisitions` (
  `requisitionId` bigint(20) NOT NULL AUTO_INCREMENT,
  `requisitionCreatedDate` datetime DEFAULT NULL,
  `requisitionDateOfGeneration` date DEFAULT NULL,
  `requisitionExpectedDelivery` date DEFAULT NULL,
  `requisitionJustification` varchar(255) DEFAULT NULL,
  `requisitionRequestedBY` varchar(255) DEFAULT NULL,
  `requisitionStatus` varchar(255) DEFAULT NULL,
  `requisitionUpdatedDate` datetime DEFAULT NULL,
  `project_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`requisitionId`),
  KEY `FK_project_requisitions_app_project` (`project_id`),
  CONSTRAINT `FK_project_requisitions_app_project` FOREIGN KEY (`project_id`) REFERENCES `app_project` (`project_id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=latin1;

-- Dumping data for table procurement2.project_requisitions: ~7 rows (approximately)
DELETE FROM `project_requisitions`;
/*!40000 ALTER TABLE `project_requisitions` DISABLE KEYS */;
INSERT INTO `project_requisitions` (`requisitionId`, `requisitionCreatedDate`, `requisitionDateOfGeneration`, `requisitionExpectedDelivery`, `requisitionJustification`, `requisitionRequestedBY`, `requisitionStatus`, `requisitionUpdatedDate`, `project_id`) VALUES
	(2, NULL, '2018-04-30', '2018-04-25', 'ttttt', 'vaibhav', 'ACTIVE', '2018-05-06 18:45:18', 11),
	(3, '2018-04-24 22:04:55', '2018-04-25', '2018-04-25', 'Test', 'Harshad', 'ACTIVE', '2018-04-24 22:04:55', 2),
	(4, '2018-04-24 23:48:07', '2018-04-27', '2018-04-25', 'Test', 'Harshad', 'ACTIVE', '2018-04-24 23:48:07', 1),
	(7, NULL, '2018-05-30', '2018-05-01', 'tEST1234', 'Harshad123456', 'ACTIVE', '2018-05-01 18:06:33', 1),
	(8, '2018-05-01 18:08:17', '2018-05-30', '2018-05-01', 'Test', 'may', 'ACTIVE', '2018-05-01 18:08:17', 11),
	(9, NULL, '2018-05-06', '2018-05-05', 'wwwwwwwwwwwwwww', 'qqqqqqqqqqqq', 'ACTIVE', '2018-05-01 18:25:20', 11),
	(10, '2018-05-20 15:27:13', '2018-05-20', '2018-05-01', 'Tete', 'Harshad', 'ACTIVE', '2018-05-20 15:27:14', 11);
/*!40000 ALTER TABLE `project_requisitions` ENABLE KEYS */;

-- Dumping structure for table procurement2.purchase_order
CREATE TABLE IF NOT EXISTS `purchase_order` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `po_number` varchar(50) DEFAULT NULL,
  `request_quotation_id` varchar(50) DEFAULT NULL,
  `total` varchar(50) DEFAULT NULL,
  `comment` varchar(50) DEFAULT NULL,
  `status` varchar(50) DEFAULT NULL,
  `created_date` varchar(50) DEFAULT NULL,
  `updated_date` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Dumping data for table procurement2.purchase_order: ~0 rows (approximately)
DELETE FROM `purchase_order`;
/*!40000 ALTER TABLE `purchase_order` DISABLE KEYS */;
/*!40000 ALTER TABLE `purchase_order` ENABLE KEYS */;

-- Dumping structure for table procurement2.requestquotations
CREATE TABLE IF NOT EXISTS `requestquotations` (
  `requestQuotationId` bigint(20) NOT NULL AUTO_INCREMENT,
  `comments` varchar(255) DEFAULT NULL,
  `createdDate` datetime DEFAULT NULL,
  `lastDateOfRFQSubmission` date DEFAULT NULL,
  `requestQuotationDeliveryDate` date DEFAULT NULL,
  `requestQuotationStatus` varchar(255) DEFAULT NULL,
  `updatedDate` datetime DEFAULT NULL,
  `projectRequisition_requisitionId` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`requestQuotationId`),
  KEY `FK_h11yq2jt3fmdwgniyw9f3yr1e` (`projectRequisition_requisitionId`),
  CONSTRAINT `FK_h11yq2jt3fmdwgniyw9f3yr1e` FOREIGN KEY (`projectRequisition_requisitionId`) REFERENCES `project_requisitions` (`requisitionId`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=latin1;

-- Dumping data for table procurement2.requestquotations: ~0 rows (approximately)
DELETE FROM `requestquotations`;
/*!40000 ALTER TABLE `requestquotations` DISABLE KEYS */;
INSERT INTO `requestquotations` (`requestQuotationId`, `comments`, `createdDate`, `lastDateOfRFQSubmission`, `requestQuotationDeliveryDate`, `requestQuotationStatus`, `updatedDate`, `projectRequisition_requisitionId`) VALUES
	(9, 'Test With Ine', '2018-06-09 17:22:13', '2018-06-12', '2018-06-30', 'ACTIVE', '2018-06-09 17:22:13', 2),
	(10, 'Test With Ine', '2018-06-09 17:22:13', '2018-06-12', '2018-06-30', 'ACTIVE', '2018-06-09 17:22:13', 4),
	(11, 'Testing', '2018-06-09 19:56:47', '2018-06-14', '2018-06-30', 'ACTIVE', '2018-06-09 19:56:47', 9),
	(12, 'Testing', '2018-06-09 19:56:47', '2018-06-14', '2018-06-30', 'ACTIVE', '2018-06-09 19:56:47', 10);
/*!40000 ALTER TABLE `requestquotations` ENABLE KEYS */;

-- Dumping structure for table procurement2.requestquotationvendorrates
CREATE TABLE IF NOT EXISTS `requestquotationvendorrates` (
  `requestQuotationVendorRateId` bigint(20) NOT NULL AUTO_INCREMENT,
  `comment` varchar(255) DEFAULT NULL,
  `createdDate` datetime DEFAULT NULL,
  `materialRate` decimal(19,2) DEFAULT NULL,
  `rate` decimal(19,2) DEFAULT NULL,
  `updatedDate` datetime DEFAULT NULL,
  `requisitionItem_requisitionItemId` bigint(20) DEFAULT NULL,
  `requestQuotationVendor_requestQuotationVendorId` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`requestQuotationVendorRateId`),
  KEY `FK_pnjnd4pmj7dbgx1fo7oyypr7h` (`requisitionItem_requisitionItemId`),
  KEY `FK_ci4vru0p77w3b5l6ukmer1k1a` (`requestQuotationVendor_requestQuotationVendorId`),
  CONSTRAINT `FK_ci4vru0p77w3b5l6ukmer1k1a` FOREIGN KEY (`requestQuotationVendor_requestQuotationVendorId`) REFERENCES `requestquotationvendors` (`requestQuotationVendorId`),
  CONSTRAINT `FK_pnjnd4pmj7dbgx1fo7oyypr7h` FOREIGN KEY (`requisitionItem_requisitionItemId`) REFERENCES `requisitionitems` (`requisitionItemId`)
) ENGINE=InnoDB AUTO_INCREMENT=55 DEFAULT CHARSET=latin1;

-- Dumping data for table procurement2.requestquotationvendorrates: ~0 rows (approximately)
DELETE FROM `requestquotationvendorrates`;
/*!40000 ALTER TABLE `requestquotationvendorrates` DISABLE KEYS */;
INSERT INTO `requestquotationvendorrates` (`requestQuotationVendorRateId`, `comment`, `createdDate`, `materialRate`, `rate`, `updatedDate`, `requisitionItem_requisitionItemId`, `requestQuotationVendor_requestQuotationVendorId`) VALUES
	(39, 'PROC TEST New', '2018-06-09 17:22:13', 1111.00, 2222.00, '2018-06-09 17:22:13', 3, 22),
	(40, 'PROC TEST New', '2018-06-09 17:22:13', 1111.00, 2222.00, '2018-06-09 17:22:13', 4, 22),
	(41, 'PROC TEST New', '2018-06-09 17:22:13', 1111.00, 2222.00, '2018-06-09 17:22:13', 3, 23),
	(42, 'PROC TEST New', '2018-06-09 17:22:13', 1111.00, 2222.00, '2018-06-09 17:22:13', 4, 23),
	(43, 'PROC TEST New', '2018-06-09 17:22:13', 1111.00, 2222.00, '2018-06-09 17:22:13', 6, 24),
	(44, 'PROC TEST New', '2018-06-09 17:22:13', 1111.00, 2222.00, '2018-06-09 17:22:13', 7, 24),
	(45, 'PROC TEST New', '2018-06-09 17:22:13', 1111.00, 2222.00, '2018-06-09 17:22:13', 6, 25),
	(46, 'PROC TEST New', '2018-06-09 17:22:13', 1111.00, 2222.00, '2018-06-09 17:22:13', 7, 25),
	(47, 'PROC TEST New', '2018-06-09 19:56:47', 1111.00, 2222.00, '2018-06-09 19:56:47', 14, 26),
	(48, 'PROC TEST New', '2018-06-09 19:56:47', 1111.00, 2222.00, '2018-06-09 19:56:47', 15, 26),
	(49, 'PROC TEST New', '2018-06-09 19:56:47', 1111.00, 2222.00, '2018-06-09 19:56:47', 14, 27),
	(50, 'PROC TEST New', '2018-06-09 19:56:47', 1111.00, 2222.00, '2018-06-09 19:56:47', 15, 27),
	(51, 'PROC TEST New', '2018-06-09 19:56:48', 1111.00, 2222.00, '2018-06-09 19:56:48', 16, 28),
	(52, 'PROC TEST New', '2018-06-09 19:56:48', 1111.00, 2222.00, '2018-06-09 19:56:48', 17, 28),
	(53, 'PROC TEST New', '2018-06-09 19:56:48', 1111.00, 2222.00, '2018-06-09 19:56:48', 16, 29),
	(54, 'PROC TEST New', '2018-06-09 19:56:48', 1111.00, 2222.00, '2018-06-09 19:56:48', 17, 29);
/*!40000 ALTER TABLE `requestquotationvendorrates` ENABLE KEYS */;

-- Dumping structure for table procurement2.requestquotationvendors
CREATE TABLE IF NOT EXISTS `requestquotationvendors` (
  `requestQuotationVendorId` bigint(20) NOT NULL AUTO_INCREMENT,
  `commment` varchar(255) DEFAULT NULL,
  `createdDate` datetime DEFAULT NULL,
  `status` varchar(255) DEFAULT NULL,
  `updatedDate` datetime DEFAULT NULL,
  `requestQuotation_requestQuotationId` bigint(20) DEFAULT NULL,
  `vendor_vendor_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`requestQuotationVendorId`),
  KEY `FK_8lhugg0742cu194pj5hndsger` (`requestQuotation_requestQuotationId`),
  KEY `FK_cbiofjks1gjtpli63e96rtcg` (`vendor_vendor_id`),
  CONSTRAINT `FK_8lhugg0742cu194pj5hndsger` FOREIGN KEY (`requestQuotation_requestQuotationId`) REFERENCES `requestquotations` (`requestQuotationId`),
  CONSTRAINT `FK_cbiofjks1gjtpli63e96rtcg` FOREIGN KEY (`vendor_vendor_id`) REFERENCES `vendors` (`vendor_id`)
) ENGINE=InnoDB AUTO_INCREMENT=30 DEFAULT CHARSET=latin1;

-- Dumping data for table procurement2.requestquotationvendors: ~0 rows (approximately)
DELETE FROM `requestquotationvendors`;
/*!40000 ALTER TABLE `requestquotationvendors` DISABLE KEYS */;
INSERT INTO `requestquotationvendors` (`requestQuotationVendorId`, `commment`, `createdDate`, `status`, `updatedDate`, `requestQuotation_requestQuotationId`, `vendor_vendor_id`) VALUES
	(22, 'Test', '2018-06-09 17:22:13', 'ACTIVE', '2018-06-09 17:22:13', 9, 6),
	(23, 'Test', '2018-06-09 17:22:13', 'ACTIVE', '2018-06-09 17:22:13', 9, 7),
	(24, 'Test', '2018-06-09 17:22:13', 'ACTIVE', '2018-06-09 17:22:13', 10, 6),
	(25, 'Test', '2018-06-09 17:22:13', 'ACTIVE', '2018-06-09 17:22:13', 10, 7),
	(26, 'Test', '2018-06-09 19:56:47', 'ACTIVE', '2018-06-09 19:56:47', 11, 6),
	(27, 'Test', '2018-06-09 19:56:47', 'ACTIVE', '2018-06-09 19:56:47', 11, 7),
	(28, 'Test', '2018-06-09 19:56:48', 'ACTIVE', '2018-06-09 19:56:48', 12, 6),
	(29, 'Test', '2018-06-09 19:56:48', 'ACTIVE', '2018-06-09 19:56:48', 12, 7);
/*!40000 ALTER TABLE `requestquotationvendors` ENABLE KEYS */;

-- Dumping structure for table procurement2.request_quotation
CREATE TABLE IF NOT EXISTS `request_quotation` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `quatation_number` bigint(20) NOT NULL DEFAULT '0',
  `request_requisition_vendor_rate_id` bigint(20) NOT NULL DEFAULT '0',
  `comment` varchar(50) NOT NULL DEFAULT '0',
  `status` varchar(50) NOT NULL DEFAULT '0',
  `created_date` varchar(50) NOT NULL DEFAULT '0',
  `updated_date` varchar(50) NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Dumping data for table procurement2.request_quotation: ~0 rows (approximately)
DELETE FROM `request_quotation`;
/*!40000 ALTER TABLE `request_quotation` DISABLE KEYS */;
/*!40000 ALTER TABLE `request_quotation` ENABLE KEYS */;

-- Dumping structure for table procurement2.request_requisition_vendor
CREATE TABLE IF NOT EXISTS `request_requisition_vendor` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `requisition_vendor_group_id` varchar(50) DEFAULT NULL,
  `requisition_id` varchar(50) DEFAULT NULL,
  `vendor_id` bigint(20) DEFAULT NULL,
  `last_date_RFQ` varchar(50) DEFAULT NULL,
  `delivery_date` varchar(50) DEFAULT NULL,
  `status` varchar(50) DEFAULT NULL,
  `comment` varchar(50) DEFAULT NULL,
  `created_date` varchar(50) DEFAULT NULL,
  `updated_date` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Dumping data for table procurement2.request_requisition_vendor: ~0 rows (approximately)
DELETE FROM `request_requisition_vendor`;
/*!40000 ALTER TABLE `request_requisition_vendor` DISABLE KEYS */;
/*!40000 ALTER TABLE `request_requisition_vendor` ENABLE KEYS */;

-- Dumping structure for table procurement2.requisition
CREATE TABLE IF NOT EXISTS `requisition` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `requisition_no` varchar(50) NOT NULL DEFAULT '',
  `req_date_of_generation` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `req_expected_delivery` varchar(50) NOT NULL,
  `req_request_by` varchar(50) NOT NULL,
  `project_id` bigint(20) NOT NULL,
  `req_justification` varchar(50) NOT NULL,
  `req_status_id` bigint(20) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `requisition_no` (`requisition_no`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Dumping data for table procurement2.requisition: ~0 rows (approximately)
DELETE FROM `requisition`;
/*!40000 ALTER TABLE `requisition` DISABLE KEYS */;
/*!40000 ALTER TABLE `requisition` ENABLE KEYS */;

-- Dumping structure for table procurement2.requisitionitems
CREATE TABLE IF NOT EXISTS `requisitionitems` (
  `requisitionItemId` bigint(20) NOT NULL AUTO_INCREMENT,
  `checked` bit(1) NOT NULL,
  `createdDate` datetime DEFAULT NULL,
  `quantity` bigint(20) NOT NULL,
  `updatedDate` datetime DEFAULT NULL,
  `usedFor` varchar(255) DEFAULT NULL,
  `gradeId` bigint(20) DEFAULT NULL,
  `itemId` bigint(20) DEFAULT NULL,
  `projectRequisitionId` bigint(20) DEFAULT NULL,
  `unitId` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`requisitionItemId`),
  KEY `FK_o3b4m9vm0cva7r3pdvn0spfgm` (`gradeId`),
  KEY `FK_cgbkcknbw4du7krggf4s9roh4` (`itemId`),
  KEY `FK_k5kmbx4f4uwswb6pdsptmaqmo` (`projectRequisitionId`),
  KEY `FK_4nkdcs8ribhpchyghwcdsistp` (`unitId`),
  CONSTRAINT `FK_4nkdcs8ribhpchyghwcdsistp` FOREIGN KEY (`unitId`) REFERENCES `units` (`unitId`),
  CONSTRAINT `FK_cgbkcknbw4du7krggf4s9roh4` FOREIGN KEY (`itemId`) REFERENCES `items` (`itemId`),
  CONSTRAINT `FK_k5kmbx4f4uwswb6pdsptmaqmo` FOREIGN KEY (`projectRequisitionId`) REFERENCES `project_requisitions` (`requisitionId`),
  CONSTRAINT `FK_o3b4m9vm0cva7r3pdvn0spfgm` FOREIGN KEY (`gradeId`) REFERENCES `grades` (`gradeId`)
) ENGINE=InnoDB AUTO_INCREMENT=18 DEFAULT CHARSET=latin1;

-- Dumping data for table procurement2.requisitionitems: ~12 rows (approximately)
DELETE FROM `requisitionitems`;
/*!40000 ALTER TABLE `requisitionitems` DISABLE KEYS */;
INSERT INTO `requisitionitems` (`requisitionItemId`, `checked`, `createdDate`, `quantity`, `updatedDate`, `usedFor`, `gradeId`, `itemId`, `projectRequisitionId`, `unitId`) VALUES
	(3, b'1', NULL, 1, NULL, 'Used For RMC', 1, 1, 2, 1),
	(4, b'1', NULL, 2, NULL, 'Used For STEEL', 1, 1, 2, 1),
	(6, b'1', '2018-04-24 22:04:56', 1, '2018-04-24 22:04:56', 'tTEst', 14, 1, 4, 1),
	(7, b'1', '2018-04-24 23:48:07', 1, '2018-04-24 23:48:07', 'Used For RMC', 14, 1, 4, 1),
	(10, b'1', NULL, 10, NULL, 'Used For RMC', 14, 1, 7, 1),
	(11, b'1', NULL, 12, NULL, 'Used For STEEL', 14, 1, 7, 1),
	(12, b'1', NULL, 11, NULL, 'Used For SAND', 6, 6, 7, 3),
	(13, b'1', '2018-05-01 18:08:17', 10, '2018-05-01 18:08:17', 'Used For RMC', 14, 1, 8, 1),
	(14, b'1', NULL, 1, NULL, 'Used For CEMENT', 14, 1, 9, 1),
	(15, b'1', NULL, 2, NULL, 'Used For STEEL', 14, 3, 9, 5),
	(16, b'1', '2018-05-20 15:27:14', 1, '2018-05-20 15:27:14', 'Used For RMC', 14, 1, 10, 1),
	(17, b'1', '2018-05-20 15:27:14', 2, '2018-05-20 15:27:14', 'Used For STEEL', 2, 3, 10, 5);
/*!40000 ALTER TABLE `requisitionitems` ENABLE KEYS */;

-- Dumping structure for procedure procurement2.sp_createQuotation
DELIMITER //
CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_createQuotation`(
	IN `requisitionId` BIGINT,
	IN `lastDateOfRFQSubmission` DATE,
	IN `requestQuotationDeliveryDate` DATE,
	IN `requestQuotationStatus` VARCHAR(50),
	IN `comments` VARCHAR(50),
	IN `vendorIds` VARCHAR(50),
	IN `operationType` VARCHAR(50),
	OUT `resultCode` BIGINT
)
BEGIN
DECLARE num INT;
	DECLARE vendorId BIGINT;
	DECLARE requestQuotation_requestQuotationId BIGINT;
  	DECLARE my_string  VARCHAR(255);
  	DECLARE requestquotationvendorId BIGINT;
  	SET num = 1;
  
 

	-- select operationType;
	IF operationType = 'CREATE_QUOTATION' THEN 
	INSERT INTO requestquotations (comments, createdDate, lastDateOfRFQSubmission, requestQuotationDeliveryDate,requestQuotationStatus, updatedDate, projectRequisition_requisitionId) VALUES (comments, NOW(), lastDateOfRFQSubmission, requestQuotationDeliveryDate, requestQuotationStatus, NOW(), requisitionId);
	
	 	SELECT LAST_INSERT_ID() into resultCode;
	 set requestQuotation_requestQuotationId =resultCode;
	 
	 	
	 	 WHILE num  <= 2 DO
	 	 
	 	 	SELECT fun_splitString(vendorIds, '||', num) into my_string;
    		select vendor_id from vendors where vendor_name = my_string into vendorId;
    			INSERT INTO requestquotationvendors (status, requestQuotation_requestQuotationId, vendor_vendor_id, commment, createdDate, updatedDate) VALUES ('ACTIVE',requestQuotation_requestQuotationId ,vendorId , 'Test', NOW(), NOW());
    		SELECT LAST_INSERT_ID() into requestquotationvendorId;
    
		 CALL sp_requestQuotationVendorRates(requisitionId, requestquotationvendorId, 'PROC TEST New', '1111', '2222');
		 	
		 
			SET  num = num + 1;
  		END WHILE;
	
	ELSE
	
	set resultCode = 99;
	
	END IF;
END//
DELIMITER ;

-- Dumping structure for procedure procurement2.sp_requestQuotationVendorRates
DELIMITER //
CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_requestQuotationVendorRates`(
	IN `requisition_Id` BIGINT,
	IN `requestQuotationVendorId` BIGINT,
	IN `comment` CHAR(50),
	IN `materialRate` DECIMAL(10,0),
	IN `rate` DECIMAL(10,0)
)
BEGIN
-- Use Cursor To Fetch RequisitionItem Data and iterate it

	DECLARE finished INTEGER DEFAULT 0;
   DECLARE reuisition_ItemId BIGINT DEFAULT 0;
   -- DECLARE val1 BIGINT;
   -- set val1= requisition_Id;
   DECLARE reuisitionItemIds CURSOR FOR  select requisitionItemId from requisitionitems where projectRequisitionId=requisition_Id and checked=1;
   DECLARE CONTINUE HANDLER FOR NOT FOUND SET finished = 1;
   
   select requisition_Id;
   OPEN reuisitionItemIds;
   
   get_reuisitionItemIds: LOOP
   FETCH reuisitionItemIds INTO reuisition_ItemId;
         IF finished THEN
               LEAVE get_reuisitionItemIds;
         END IF;
   select reuisition_ItemId;
                    
	INSERT INTO requestquotationvendorrates (requestQuotationVendor_requestQuotationVendorId, comment, createdDate, materialRate, rate, updatedDate
	, requisitionItem_requisitionItemId) VALUES 
				(requestquotationvendorId, comment, NOW(), materialRate, rate, NOW(), reuisition_ItemId);
                 
   END LOOP get_reuisitionItemIds;
    
   CLOSE reuisitionItemIds;
	
-- End Cursor
END//
DELIMITER ;

-- Dumping structure for table procurement2.student
CREATE TABLE IF NOT EXISTS `student` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `FIRST_NAME` varchar(255) NOT NULL,
  `LAST_NAME` varchar(255) NOT NULL,
  `SECTION` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=32 DEFAULT CHARSET=utf8;

-- Dumping data for table procurement2.student: ~3 rows (approximately)
DELETE FROM `student`;
/*!40000 ALTER TABLE `student` DISABLE KEYS */;
INSERT INTO `student` (`id`, `FIRST_NAME`, `LAST_NAME`, `SECTION`) VALUES
	(1, 'Sam', 'Disilva', 'Maths'),
	(21, 'Peter', 'Pan', 'Physics'),
	(31, 'Bill', 'Laurent', 'ARTS');
/*!40000 ALTER TABLE `student` ENABLE KEYS */;

-- Dumping structure for table procurement2.units
CREATE TABLE IF NOT EXISTS `units` (
  `unitId` bigint(20) NOT NULL AUTO_INCREMENT,
  `unitDesc` varchar(255) DEFAULT NULL,
  `unitName` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`unitId`),
  UNIQUE KEY `UK_j9t6byk2g2epy55tpmfu8b9i3` (`unitName`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=latin1;

-- Dumping data for table procurement2.units: ~6 rows (approximately)
DELETE FROM `units`;
/*!40000 ALTER TABLE `units` DISABLE KEYS */;
INSERT INTO `units` (`unitId`, `unitDesc`, `unitName`) VALUES
	(1, 'bags', 'bags'),
	(2, 'cum', 'cum'),
	(3, 'kg', 'kg'),
	(4, 'sqm', 'sqm'),
	(5, 'brass', 'brass'),
	(6, 'N/A', 'N/A');
/*!40000 ALTER TABLE `units` ENABLE KEYS */;

-- Dumping structure for table procurement2.user
CREATE TABLE IF NOT EXISTS `user` (
  `id` int(11) DEFAULT NULL,
  `first_name` varchar(30) DEFAULT NULL,
  `last_name` varchar(30) DEFAULT NULL,
  `email` varchar(30) DEFAULT NULL,
  `phone` varchar(30) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- Dumping data for table procurement2.user: ~1 rows (approximately)
DELETE FROM `user`;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` (`id`, `first_name`, `last_name`, `email`, `phone`) VALUES
	(1, 'ankush', 'thakur', 'beingjavaguy@gmail.com', '8987676754');
/*!40000 ALTER TABLE `user` ENABLE KEYS */;

-- Dumping structure for table procurement2.userprofile_menu
CREATE TABLE IF NOT EXISTS `userprofile_menu` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `profile_id` bigint(20) NOT NULL DEFAULT '0',
  `menu_id` bigint(20) NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`),
  KEY `FK_userprofile_menu_user_profile` (`profile_id`),
  KEY `FK_userprofile_menu_app_menu` (`menu_id`),
  CONSTRAINT `FK_userprofile_menu_app_menu` FOREIGN KEY (`menu_id`) REFERENCES `app_menu` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `FK_userprofile_menu_user_profile` FOREIGN KEY (`profile_id`) REFERENCES `user_profile` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=latin1;

-- Dumping data for table procurement2.userprofile_menu: ~4 rows (approximately)
DELETE FROM `userprofile_menu`;
/*!40000 ALTER TABLE `userprofile_menu` DISABLE KEYS */;
INSERT INTO `userprofile_menu` (`id`, `profile_id`, `menu_id`) VALUES
	(1, 1, 2),
	(3, 2, 2),
	(5, 2, 1),
	(6, 2, 3);
/*!40000 ALTER TABLE `userprofile_menu` ENABLE KEYS */;

-- Dumping structure for table procurement2.user_profile
CREATE TABLE IF NOT EXISTS `user_profile` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `type` varchar(30) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `type` (`type`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;

-- Dumping data for table procurement2.user_profile: ~3 rows (approximately)
DELETE FROM `user_profile`;
/*!40000 ALTER TABLE `user_profile` DISABLE KEYS */;
INSERT INTO `user_profile` (`id`, `type`) VALUES
	(2, 'ADMIN'),
	(3, 'DBA'),
	(1, 'USER');
/*!40000 ALTER TABLE `user_profile` ENABLE KEYS */;

-- Dumping structure for table procurement2.vendors
CREATE TABLE IF NOT EXISTS `vendors` (
  `vendor_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `bank_account_number` varchar(255) DEFAULT NULL,
  `bank_branch_ifsc` varchar(255) DEFAULT NULL,
  `bank_branch_name` varchar(255) DEFAULT NULL,
  `bank_name` varchar(255) DEFAULT NULL,
  `contact_person_alternate_phone_no` varchar(255) DEFAULT NULL,
  `contact_person_email` varchar(255) DEFAULT NULL,
  `contact_person_mobile` varchar(255) DEFAULT NULL,
  `contact_person_name` varchar(255) DEFAULT NULL,
  `serviceRendered_GoodsSupplied` varchar(255) DEFAULT NULL,
  `vendor_gst_number` varchar(255) DEFAULT NULL,
  `vendor_name` varchar(255) DEFAULT NULL,
  `vendor_nickName` varchar(255) DEFAULT NULL,
  `address_id` bigint(20) DEFAULT NULL,
  `vendor_type_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`vendor_id`),
  KEY `FK_vendors_vendortypes` (`vendor_type_id`),
  KEY `FK_vendors_addresses` (`address_id`),
  CONSTRAINT `FK_vendors_addresses` FOREIGN KEY (`address_id`) REFERENCES `addresses` (`address_id`),
  CONSTRAINT `FK_vendors_vendortypes` FOREIGN KEY (`vendor_type_id`) REFERENCES `vendortypes` (`vendorType_id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=latin1;

-- Dumping data for table procurement2.vendors: ~3 rows (approximately)
DELETE FROM `vendors`;
/*!40000 ALTER TABLE `vendors` DISABLE KEYS */;
INSERT INTO `vendors` (`vendor_id`, `bank_account_number`, `bank_branch_ifsc`, `bank_branch_name`, `bank_name`, `contact_person_alternate_phone_no`, `contact_person_email`, `contact_person_mobile`, `contact_person_name`, `serviceRendered_GoodsSupplied`, `vendor_gst_number`, `vendor_name`, `vendor_nickName`, `address_id`, `vendor_type_id`) VALUES
	(6, '50231346679', 'HDFC40001', 'Malad - West', 'HDFC', '87564210', 'Test@gmail.com', '987654321', 'Karan', 'Servicess', 'GST1235976423', 'A', 'Mahalakshmi', 16, 2),
	(7, '50000301258', 'IDFC0041', 'Goregoan', 'AXIS', '02228406825', 'karan@gmail.com', '0000000000000', 'Harshad', 'Servicess', 'GST1254789', 'B', 'Balaji', 17, 2),
	(8, 'dfsf', '345345', '345345', 'sdfsf', '345', '345', '345', '34534', '345345', '345345345', 'C', 'sdfsf', 18, 1),
	(9, '7878646456', '215478896532', '8888888888', 'IDFC', '02228406825', 'karan@gmail.com', '333333333333', 'Vaibhav', '77777777777', '66666666666', 'Test', 'Test', 19, 2);
/*!40000 ALTER TABLE `vendors` ENABLE KEYS */;

-- Dumping structure for table procurement2.vendortypes
CREATE TABLE IF NOT EXISTS `vendortypes` (
  `vendorType_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `vendorType_name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`vendorType_id`),
  UNIQUE KEY `UK_9g65j9ooid5ji81uy7w7j61b8` (`vendorType_name`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;

-- Dumping data for table procurement2.vendortypes: ~2 rows (approximately)
DELETE FROM `vendortypes`;
/*!40000 ALTER TABLE `vendortypes` DISABLE KEYS */;
INSERT INTO `vendortypes` (`vendorType_id`, `vendorType_name`) VALUES
	(2, 'Goods'),
	(1, 'Services');
/*!40000 ALTER TABLE `vendortypes` ENABLE KEYS */;

-- Dumping structure for table procurement2.vendor_bank_profiles
CREATE TABLE IF NOT EXISTS `vendor_bank_profiles` (
  `vendor_bank_profile_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `bank_account_number` varchar(255) DEFAULT NULL,
  `bank_branch_id` bigint(20) NOT NULL,
  `vendor_id` bigint(20) NOT NULL,
  PRIMARY KEY (`vendor_bank_profile_id`),
  KEY `FK_6hy7n1lhm6s1pxrilb3sv7gt9` (`bank_branch_id`),
  KEY `FK_4xxmy9l2bvyuqe6npeqjjp4me` (`vendor_id`),
  CONSTRAINT `FK_4xxmy9l2bvyuqe6npeqjjp4me` FOREIGN KEY (`vendor_id`) REFERENCES `vendors` (`vendor_id`),
  CONSTRAINT `FK_6hy7n1lhm6s1pxrilb3sv7gt9` FOREIGN KEY (`bank_branch_id`) REFERENCES `bank_branches` (`bank_branch_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Dumping data for table procurement2.vendor_bank_profiles: ~0 rows (approximately)
DELETE FROM `vendor_bank_profiles`;
/*!40000 ALTER TABLE `vendor_bank_profiles` DISABLE KEYS */;
/*!40000 ALTER TABLE `vendor_bank_profiles` ENABLE KEYS */;

-- Dumping structure for table procurement2.vendor_profile
CREATE TABLE IF NOT EXISTS `vendor_profile` (
  `vendor_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `vendor_name` varchar(50) NOT NULL DEFAULT '0',
  `vendor_nickname` varchar(50) NOT NULL DEFAULT '0',
  `vendor_address_id` bigint(20) NOT NULL DEFAULT '0',
  `vendor_bank_id` bigint(20) NOT NULL DEFAULT '0',
  `gstNumber` varchar(50) NOT NULL DEFAULT '0',
  `vendor_type_id` bigint(20) NOT NULL DEFAULT '0',
  `contact_person_name` varchar(50) NOT NULL DEFAULT '0',
  `contact_person_email` varchar(50) NOT NULL DEFAULT '0',
  `contact_person_mobile` varchar(50) NOT NULL DEFAULT '0',
  `contact_person_alternate_number` varchar(50) NOT NULL DEFAULT '0',
  PRIMARY KEY (`vendor_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Dumping data for table procurement2.vendor_profile: ~0 rows (approximately)
DELETE FROM `vendor_profile`;
/*!40000 ALTER TABLE `vendor_profile` DISABLE KEYS */;
/*!40000 ALTER TABLE `vendor_profile` ENABLE KEYS */;

-- Dumping structure for table procurement2.vendor_types
CREATE TABLE IF NOT EXISTS `vendor_types` (
  `vendor_type_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `vendor_type_name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`vendor_type_id`),
  UNIQUE KEY `UK_cdavmvfuntp91yy59x0jjjbgq` (`vendor_type_name`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- Dumping data for table procurement2.vendor_types: ~2 rows (approximately)
DELETE FROM `vendor_types`;
/*!40000 ALTER TABLE `vendor_types` DISABLE KEYS */;
INSERT INTO `vendor_types` (`vendor_type_id`, `vendor_type_name`) VALUES
	(1, 'Goods'),
	(2, 'Services');
/*!40000 ALTER TABLE `vendor_types` ENABLE KEYS */;

/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
