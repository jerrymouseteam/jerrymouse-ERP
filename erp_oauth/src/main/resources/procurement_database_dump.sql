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


-- Dumping database structure for procurement
CREATE DATABASE IF NOT EXISTS `procurement` /*!40100 DEFAULT CHARACTER SET latin1 */;
USE `procurement`;

-- Dumping structure for table procurement.address
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

-- Dumping data for table procurement.address: ~0 rows (approximately)
DELETE FROM `address`;
/*!40000 ALTER TABLE `address` DISABLE KEYS */;
/*!40000 ALTER TABLE `address` ENABLE KEYS */;

-- Dumping structure for table procurement.addresses
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
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;

-- Dumping data for table procurement.addresses: ~1 rows (approximately)
DELETE FROM `addresses`;
/*!40000 ALTER TABLE `addresses` DISABLE KEYS */;
INSERT INTO `addresses` (`address_id`, `addres_line1`, `addres_line2`, `addres_line3`, `city`, `country`, `state`, `zipcode`) VALUES
	(1, 'Address1', NULL, NULL, NULL, NULL, NULL, NULL);
/*!40000 ALTER TABLE `addresses` ENABLE KEYS */;

-- Dumping structure for table procurement.app_menu
CREATE TABLE IF NOT EXISTS `app_menu` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) NOT NULL,
  `url` varchar(50) DEFAULT NULL,
  `description` varchar(500) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=latin1;

-- Dumping data for table procurement.app_menu: ~5 rows (approximately)
DELETE FROM `app_menu`;
/*!40000 ALTER TABLE `app_menu` DISABLE KEYS */;
INSERT INTO `app_menu` (`id`, `name`, `url`, `description`) VALUES
	(1, 'Project_Add Project', '/addProject', NULL),
	(2, 'User_Register User', '/newUser', NULL),
	(3, 'Report', '/report', NULL),
	(4, 'Project_Edit Project', '/editProject', NULL),
	(5, 'User_Search User', '/searchUser', NULL);
/*!40000 ALTER TABLE `app_menu` ENABLE KEYS */;

-- Dumping structure for table procurement.app_project
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
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;

-- Dumping data for table procurement.app_project: ~2 rows (approximately)
DELETE FROM `app_project`;
/*!40000 ALTER TABLE `app_project` DISABLE KEYS */;
INSERT INTO `app_project` (`project_id`, `project_name`, `sub_division_name`, `start_date`, `end_date`, `project_address`, `remarks`, `contact_person_name`, `contact_person_email`, `contact_person_phone`, `project_client_name`, `project_client_email`, `project_client_phone`, `architect_name`, `architect_email`, `architect_phone`, `structural_name`, `structural_email`, `structural_phone`, `project_status`) VALUES
	(1, 'demo', 'demo', '2017-01-31', '2017-12-31', 'bhayandar', '', 'vivek', 'a@b', '992', 'vivek_c', 'a_c@b', '9920c', 'vivek_a', 'a_a@b', '9920a', 'vivek_s', 'a_a@b', '9920c', 'Open'),
	(2, 'Test1', 'Test2', '2017-12-01', '2017-12-02', 'Test4', 'Test3', 'Test5', 'Test7', '222222222', 'Test8', 'test10', '2222222', 'Test11', 'Test33', '222222222', 'Test', 'Testww', '22222222', 'Open');
/*!40000 ALTER TABLE `app_project` ENABLE KEYS */;

-- Dumping structure for table procurement.app_user
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

-- Dumping data for table procurement.app_user: ~2 rows (approximately)
DELETE FROM `app_user`;
/*!40000 ALTER TABLE `app_user` DISABLE KEYS */;
INSERT INTO `app_user` (`id`, `first_name`, `middle_name`, `last_name`, `mobile_number`, `alternate_number`, `email`, `address`, `sso_id`, `password`, `retype_password`, `user_status`) VALUES
	(1, 'Sam', NULL, 'Smith', '9999999999', NULL, 'samy@xyz.com', 'Thane (West)', 'sam', '$2a$10$4eqIF5s/ewJwHK1p8lqlFOEm2QIA0S8g6./Lok.pQxqcxaBZYChRm', '$2a$10$4eqIF5s/ewJwHK1p8lqlFOEm2QIA0S8g6./Lok.pQxqcxaBZYChRm', 'Active'),
	(2, 'Harshad', 'P', 'Gaikwad', '7208733078', '7208733078', 'Test@gmail.com', 'Test', 'windows', '$2a$10$nIklQjVzZJ/DPi3NmZ0.W.atbOY6jNEMjHXKyRgh9KL3pq4IikxYO', 'windows', 'Active');
/*!40000 ALTER TABLE `app_user` ENABLE KEYS */;

-- Dumping structure for table procurement.app_user_project
CREATE TABLE IF NOT EXISTS `app_user_project` (
  `user_id` bigint(20) NOT NULL,
  `project_id` bigint(20) NOT NULL,
  PRIMARY KEY (`user_id`,`project_id`),
  KEY `FK_APP_PROJECT` (`project_id`),
  CONSTRAINT `FK_APP_PROJECT` FOREIGN KEY (`project_id`) REFERENCES `app_project` (`project_id`),
  CONSTRAINT `FK_APP_USER_PROJECT` FOREIGN KEY (`user_id`) REFERENCES `app_user` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Dumping data for table procurement.app_user_project: ~1 rows (approximately)
DELETE FROM `app_user_project`;
/*!40000 ALTER TABLE `app_user_project` DISABLE KEYS */;
INSERT INTO `app_user_project` (`user_id`, `project_id`) VALUES
	(1, 2);
/*!40000 ALTER TABLE `app_user_project` ENABLE KEYS */;

-- Dumping structure for table procurement.app_user_user_profile
CREATE TABLE IF NOT EXISTS `app_user_user_profile` (
  `user_id` bigint(20) NOT NULL,
  `user_profile_id` bigint(20) NOT NULL,
  PRIMARY KEY (`user_id`,`user_profile_id`),
  KEY `FK_USER_PROFILE` (`user_profile_id`),
  CONSTRAINT `FK_APP_USER` FOREIGN KEY (`user_id`) REFERENCES `app_user` (`id`),
  CONSTRAINT `FK_USER_PROFILE` FOREIGN KEY (`user_profile_id`) REFERENCES `user_profile` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Dumping data for table procurement.app_user_user_profile: ~2 rows (approximately)
DELETE FROM `app_user_user_profile`;
/*!40000 ALTER TABLE `app_user_user_profile` DISABLE KEYS */;
INSERT INTO `app_user_user_profile` (`user_id`, `user_profile_id`) VALUES
	(1, 2),
	(2, 2);
/*!40000 ALTER TABLE `app_user_user_profile` ENABLE KEYS */;

-- Dumping structure for table procurement.banks
CREATE TABLE IF NOT EXISTS `banks` (
  `bank_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `bank_name` varchar(255) NOT NULL,
  PRIMARY KEY (`bank_id`),
  UNIQUE KEY `UK_pm44fp6lf4gf4qj7tr4a2b5iq` (`bank_name`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=latin1;

-- Dumping data for table procurement.banks: ~5 rows (approximately)
DELETE FROM `banks`;
/*!40000 ALTER TABLE `banks` DISABLE KEYS */;
INSERT INTO `banks` (`bank_id`, `bank_name`) VALUES
	(9, 'CITI'),
	(1, 'HDFC'),
	(2, 'IDBI'),
	(10, 'PNB'),
	(8, 'SBI');
/*!40000 ALTER TABLE `banks` ENABLE KEYS */;

-- Dumping structure for table procurement.bank_branches
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

-- Dumping data for table procurement.bank_branches: ~3 rows (approximately)
DELETE FROM `bank_branches`;
/*!40000 ALTER TABLE `bank_branches` DISABLE KEYS */;
INSERT INTO `bank_branches` (`bank_branch_id`, `branch_ifsc`, `branch_name`, `bank_id`) VALUES
	(1, '123456789', 'Goregaon', 1),
	(2, '987654321', 'Malad', 1),
	(3, '1111111111', 'Dadar', 1);
/*!40000 ALTER TABLE `bank_branches` ENABLE KEYS */;

-- Dumping structure for table procurement.grade
CREATE TABLE IF NOT EXISTS `grade` (
  `grade_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `grade_name` varchar(50) NOT NULL DEFAULT '0',
  PRIMARY KEY (`grade_id`),
  UNIQUE KEY `grade_name` (`grade_name`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Dumping data for table procurement.grade: ~0 rows (approximately)
DELETE FROM `grade`;
/*!40000 ALTER TABLE `grade` DISABLE KEYS */;
/*!40000 ALTER TABLE `grade` ENABLE KEYS */;

-- Dumping structure for table procurement.item
CREATE TABLE IF NOT EXISTS `item` (
  `item_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `item_name` varchar(50) NOT NULL,
  PRIMARY KEY (`item_id`),
  UNIQUE KEY `item_name` (`item_name`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Dumping data for table procurement.item: ~0 rows (approximately)
DELETE FROM `item`;
/*!40000 ALTER TABLE `item` DISABLE KEYS */;
/*!40000 ALTER TABLE `item` ENABLE KEYS */;

-- Dumping structure for table procurement.item_quantity
CREATE TABLE IF NOT EXISTS `item_quantity` (
  `quantity_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `quantity_name` varchar(50) NOT NULL DEFAULT '0',
  PRIMARY KEY (`quantity_id`),
  UNIQUE KEY `quantity_name` (`quantity_name`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Dumping data for table procurement.item_quantity: ~0 rows (approximately)
DELETE FROM `item_quantity`;
/*!40000 ALTER TABLE `item_quantity` DISABLE KEYS */;
/*!40000 ALTER TABLE `item_quantity` ENABLE KEYS */;

-- Dumping structure for table procurement.item_requisition
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

-- Dumping data for table procurement.item_requisition: ~0 rows (approximately)
DELETE FROM `item_requisition`;
/*!40000 ALTER TABLE `item_requisition` DISABLE KEYS */;
/*!40000 ALTER TABLE `item_requisition` ENABLE KEYS */;

-- Dumping structure for table procurement.item_size
CREATE TABLE IF NOT EXISTS `item_size` (
  `size_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `size_name` varchar(50) NOT NULL,
  PRIMARY KEY (`size_id`),
  UNIQUE KEY `size_name` (`size_name`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Dumping data for table procurement.item_size: ~0 rows (approximately)
DELETE FROM `item_size`;
/*!40000 ALTER TABLE `item_size` DISABLE KEYS */;
/*!40000 ALTER TABLE `item_size` ENABLE KEYS */;

-- Dumping structure for table procurement.item_unit
CREATE TABLE IF NOT EXISTS `item_unit` (
  `unit_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `unit_name` varchar(50) NOT NULL,
  PRIMARY KEY (`unit_id`),
  UNIQUE KEY `unit_name` (`unit_name`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Dumping data for table procurement.item_unit: ~0 rows (approximately)
DELETE FROM `item_unit`;
/*!40000 ALTER TABLE `item_unit` DISABLE KEYS */;
/*!40000 ALTER TABLE `item_unit` ENABLE KEYS */;

-- Dumping structure for table procurement.persistent_logins
CREATE TABLE IF NOT EXISTS `persistent_logins` (
  `username` varchar(64) NOT NULL,
  `series` varchar(64) NOT NULL,
  `token` varchar(64) NOT NULL,
  `last_used` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`series`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Dumping data for table procurement.persistent_logins: ~0 rows (approximately)
DELETE FROM `persistent_logins`;
/*!40000 ALTER TABLE `persistent_logins` DISABLE KEYS */;
/*!40000 ALTER TABLE `persistent_logins` ENABLE KEYS */;

-- Dumping structure for table procurement.purchase_order
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

-- Dumping data for table procurement.purchase_order: ~0 rows (approximately)
DELETE FROM `purchase_order`;
/*!40000 ALTER TABLE `purchase_order` DISABLE KEYS */;
/*!40000 ALTER TABLE `purchase_order` ENABLE KEYS */;

-- Dumping structure for table procurement.request_quotation
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

-- Dumping data for table procurement.request_quotation: ~0 rows (approximately)
DELETE FROM `request_quotation`;
/*!40000 ALTER TABLE `request_quotation` DISABLE KEYS */;
/*!40000 ALTER TABLE `request_quotation` ENABLE KEYS */;

-- Dumping structure for table procurement.request_requisition_vendor
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

-- Dumping data for table procurement.request_requisition_vendor: ~0 rows (approximately)
DELETE FROM `request_requisition_vendor`;
/*!40000 ALTER TABLE `request_requisition_vendor` DISABLE KEYS */;
/*!40000 ALTER TABLE `request_requisition_vendor` ENABLE KEYS */;

-- Dumping structure for table procurement.requisition
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

-- Dumping data for table procurement.requisition: ~0 rows (approximately)
DELETE FROM `requisition`;
/*!40000 ALTER TABLE `requisition` DISABLE KEYS */;
/*!40000 ALTER TABLE `requisition` ENABLE KEYS */;

-- Dumping structure for table procurement.userprofile_menu
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

-- Dumping data for table procurement.userprofile_menu: ~4 rows (approximately)
DELETE FROM `userprofile_menu`;
/*!40000 ALTER TABLE `userprofile_menu` DISABLE KEYS */;
INSERT INTO `userprofile_menu` (`id`, `profile_id`, `menu_id`) VALUES
	(1, 1, 2),
	(3, 2, 2),
	(5, 2, 1),
	(6, 2, 3);
/*!40000 ALTER TABLE `userprofile_menu` ENABLE KEYS */;

-- Dumping structure for table procurement.user_profile
CREATE TABLE IF NOT EXISTS `user_profile` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `type` varchar(30) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `type` (`type`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;

-- Dumping data for table procurement.user_profile: ~3 rows (approximately)
DELETE FROM `user_profile`;
/*!40000 ALTER TABLE `user_profile` DISABLE KEYS */;
INSERT INTO `user_profile` (`id`, `type`) VALUES
	(2, 'ADMIN'),
	(3, 'DBA'),
	(1, 'USER');
/*!40000 ALTER TABLE `user_profile` ENABLE KEYS */;

-- Dumping structure for table procurement.vendors
CREATE TABLE IF NOT EXISTS `vendors` (
  `vendor_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `contact_person_alternate_phone_no` varchar(255) DEFAULT NULL,
  `contact_person_email` varchar(255) DEFAULT NULL,
  `contact_person_mobile` varchar(255) DEFAULT NULL,
  `contact_person_name` varchar(255) DEFAULT NULL,
  `vendor_gst_number` varchar(255) DEFAULT NULL,
  `vendor_name` varchar(255) DEFAULT NULL,
  `vendor_nickName` varchar(255) DEFAULT NULL,
  `address_id` bigint(20) DEFAULT NULL,
  `vendor_type_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`vendor_id`),
  KEY `FK_1qu4pvdfu17ohbv437xl1rkfi` (`address_id`),
  KEY `FK_hlafp7ubifnodhm9yh9sh5uce` (`vendor_type_id`),
  CONSTRAINT `FK_1qu4pvdfu17ohbv437xl1rkfi` FOREIGN KEY (`address_id`) REFERENCES `addresses` (`address_id`),
  CONSTRAINT `FK_hlafp7ubifnodhm9yh9sh5uce` FOREIGN KEY (`vendor_type_id`) REFERENCES `vendor_types` (`vendor_type_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Dumping data for table procurement.vendors: ~0 rows (approximately)
DELETE FROM `vendors`;
/*!40000 ALTER TABLE `vendors` DISABLE KEYS */;
/*!40000 ALTER TABLE `vendors` ENABLE KEYS */;

-- Dumping structure for table procurement.vendor_bank_profiles
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

-- Dumping data for table procurement.vendor_bank_profiles: ~0 rows (approximately)
DELETE FROM `vendor_bank_profiles`;
/*!40000 ALTER TABLE `vendor_bank_profiles` DISABLE KEYS */;
/*!40000 ALTER TABLE `vendor_bank_profiles` ENABLE KEYS */;

-- Dumping structure for table procurement.vendor_profile
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

-- Dumping data for table procurement.vendor_profile: ~0 rows (approximately)
DELETE FROM `vendor_profile`;
/*!40000 ALTER TABLE `vendor_profile` DISABLE KEYS */;
/*!40000 ALTER TABLE `vendor_profile` ENABLE KEYS */;

-- Dumping structure for table procurement.vendor_types
CREATE TABLE IF NOT EXISTS `vendor_types` (
  `vendor_type_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `vendor_type_name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`vendor_type_id`),
  UNIQUE KEY `UK_cdavmvfuntp91yy59x0jjjbgq` (`vendor_type_name`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;

-- Dumping data for table procurement.vendor_types: ~2 rows (approximately)
DELETE FROM `vendor_types`;
/*!40000 ALTER TABLE `vendor_types` DISABLE KEYS */;
INSERT INTO `vendor_types` (`vendor_type_id`, `vendor_type_name`) VALUES
	(1, 'Goods'),
	(2, 'Services');
/*!40000 ALTER TABLE `vendor_types` ENABLE KEYS */;

/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
