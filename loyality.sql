-- --------------------------------------------------------
-- Host:                         127.0.0.1
-- Server version:               10.2.8-MariaDB - mariadb.org binary distribution
-- Server OS:                    Win64
-- HeidiSQL Version:             9.4.0.5125
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;


-- Dumping database structure for loyality
DROP DATABASE IF EXISTS `loyality`;
CREATE DATABASE IF NOT EXISTS `loyality` /*!40100 DEFAULT CHARACTER SET latin1 */;
USE `loyality`;

-- Dumping structure for table loyality.account
DROP TABLE IF EXISTS `account`;
CREATE TABLE IF NOT EXISTS `account` (
  `ACCOUNT_ID` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `ACCOUNT_NUMBER` varchar(50) NOT NULL,
  `ACCOUNT_USER_NAME` varchar(50) NOT NULL,
  `ACCOUNT_PASSWORD` varchar(100) NOT NULL,
  `ACCOUNT_EXPIRY` datetime DEFAULT NULL,
  `CREATED_BY` varchar(50) NOT NULL,
  `MODIFIED_BY` varchar(50) NOT NULL,
  PRIMARY KEY (`ACCOUNT_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC COMMENT='Table to store the account information';

-- Dumping data for table loyality.account: ~0 rows (approximately)
DELETE FROM `account`;
/*!40000 ALTER TABLE `account` DISABLE KEYS */;
/*!40000 ALTER TABLE `account` ENABLE KEYS */;

-- Dumping structure for table loyality.account_shopping_cart
DROP TABLE IF EXISTS `account_shopping_cart`;
CREATE TABLE IF NOT EXISTS `account_shopping_cart` (
  `account_shopping_cart_id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `account_id` int(10) unsigned NOT NULL DEFAULT 0,
  `cart_id` int(10) unsigned NOT NULL DEFAULT 0,
  `status` enum('ACTIVE','INACTIVE') NOT NULL DEFAULT 'ACTIVE',
  PRIMARY KEY (`account_shopping_cart_id`),
  KEY `FK_account_shopping_cart_account` (`account_id`),
  KEY `FK_account_shopping_cart_shopping_cart` (`cart_id`),
  CONSTRAINT `FK_account_shopping_cart_account` FOREIGN KEY (`account_id`) REFERENCES `account` (`ACCOUNT_ID`),
  CONSTRAINT `FK_account_shopping_cart_shopping_cart` FOREIGN KEY (`cart_id`) REFERENCES `shopping_cart` (`cart_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Dumping data for table loyality.account_shopping_cart: ~0 rows (approximately)
DELETE FROM `account_shopping_cart`;
/*!40000 ALTER TABLE `account_shopping_cart` DISABLE KEYS */;
/*!40000 ALTER TABLE `account_shopping_cart` ENABLE KEYS */;

-- Dumping structure for table loyality.biometric
DROP TABLE IF EXISTS `biometric`;
CREATE TABLE IF NOT EXISTS `biometric` (
  `BIOMETRIC_ID` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `BIOMETRIC_FILENAME` varchar(50) NOT NULL COMMENT 'will hold only the the filename (not absolute path)',
  `BIOMETRIC_TYPE_ID` int(11) unsigned NOT NULL,
  `CREATED_BY` varchar(50) NOT NULL,
  `MODIFIED_BY` varchar(50) NOT NULL,
  `TEMPLATE` longblob DEFAULT NULL,
  `STATUS` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`BIOMETRIC_ID`),
  KEY `FK_biometric_biometric_type` (`BIOMETRIC_TYPE_ID`),
  CONSTRAINT `FK_biometric_biometric_type` FOREIGN KEY (`BIOMETRIC_TYPE_ID`) REFERENCES `biometric_type` (`BIOMERTIC_TYPE_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC COMMENT='reviewd items will go in this table\r\n';

-- Dumping data for table loyality.biometric: ~0 rows (approximately)
DELETE FROM `biometric`;
/*!40000 ALTER TABLE `biometric` DISABLE KEYS */;
/*!40000 ALTER TABLE `biometric` ENABLE KEYS */;

-- Dumping structure for table loyality.biometric_type
DROP TABLE IF EXISTS `biometric_type`;
CREATE TABLE IF NOT EXISTS `biometric_type` (
  `BIOMERTIC_TYPE_ID` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `BIOMETRIC_TYPE_VAL` varchar(50) NOT NULL,
  `BIOMETRIC_TYPE_DESC` varchar(255) NOT NULL,
  `CREATED_BY` varchar(50) NOT NULL,
  `MODIFIED_BY` varchar(50) NOT NULL,
  PRIMARY KEY (`BIOMERTIC_TYPE_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

-- Dumping data for table loyality.biometric_type: ~0 rows (approximately)
DELETE FROM `biometric_type`;
/*!40000 ALTER TABLE `biometric_type` DISABLE KEYS */;
/*!40000 ALTER TABLE `biometric_type` ENABLE KEYS */;

-- Dumping structure for table loyality.category
DROP TABLE IF EXISTS `category`;
CREATE TABLE IF NOT EXISTS `category` (
  `category_id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `category_name` varchar(50) NOT NULL DEFAULT '0',
  `category_type_id` int(11) unsigned NOT NULL DEFAULT 0,
  `category_esc` int(11) NOT NULL DEFAULT 0,
  `status` enum('ACTIVE','INACTIVE') NOT NULL DEFAULT 'ACTIVE',
  `created_by` varchar(50) NOT NULL,
  `modified_by` varchar(50) NOT NULL,
  PRIMARY KEY (`category_id`),
  KEY `FK_category_category_type` (`category_type_id`),
  CONSTRAINT `FK_category_category_type` FOREIGN KEY (`category_type_id`) REFERENCES `category_type` (`category_type_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Dumping data for table loyality.category: ~0 rows (approximately)
DELETE FROM `category`;
/*!40000 ALTER TABLE `category` DISABLE KEYS */;
/*!40000 ALTER TABLE `category` ENABLE KEYS */;

-- Dumping structure for table loyality.category_type
DROP TABLE IF EXISTS `category_type`;
CREATE TABLE IF NOT EXISTS `category_type` (
  `category_type_id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `category_type_val` varchar(50) NOT NULL DEFAULT '0',
  `category_name` varchar(50) NOT NULL DEFAULT '0',
  `status` enum('ACTIVE','INACTIVE') NOT NULL DEFAULT 'ACTIVE',
  `created_by` varchar(50) NOT NULL,
  `modified_by` varchar(50) NOT NULL,
  PRIMARY KEY (`category_type_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Dumping data for table loyality.category_type: ~0 rows (approximately)
DELETE FROM `category_type`;
/*!40000 ALTER TABLE `category_type` DISABLE KEYS */;
/*!40000 ALTER TABLE `category_type` ENABLE KEYS */;

-- Dumping structure for table loyality.discount_type
DROP TABLE IF EXISTS `discount_type`;
CREATE TABLE IF NOT EXISTS `discount_type` (
  `discount_type_id` int(11) NOT NULL AUTO_INCREMENT,
  `discount_type_name` varchar(50) NOT NULL DEFAULT '0',
  `bonus_points` int(10) unsigned NOT NULL DEFAULT 50 COMMENT 'default bonus points',
  `discount_type_desc` varchar(50) NOT NULL DEFAULT '0',
  `status` enum('ACTIVE','INACTIVE') NOT NULL DEFAULT 'ACTIVE',
  `created_by` varchar(50) NOT NULL DEFAULT '0',
  `modified_by` varchar(50) NOT NULL DEFAULT '0',
  PRIMARY KEY (`discount_type_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Dumping data for table loyality.discount_type: ~0 rows (approximately)
DELETE FROM `discount_type`;
/*!40000 ALTER TABLE `discount_type` DISABLE KEYS */;
/*!40000 ALTER TABLE `discount_type` ENABLE KEYS */;

-- Dumping structure for table loyality.invoice
DROP TABLE IF EXISTS `invoice`;
CREATE TABLE IF NOT EXISTS `invoice` (
  `invoice_id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `invoice_dt` date NOT NULL,
  `total` bigint(20) NOT NULL,
  `transaction_id` int(10) unsigned NOT NULL,
  `invoice_detail` varchar(50) NOT NULL COMMENT 'a json? to fill in the data using mustache',
  PRIMARY KEY (`invoice_id`),
  KEY `FK__transaction` (`transaction_id`),
  CONSTRAINT `FK__transaction` FOREIGN KEY (`transaction_id`) REFERENCES `transaction` (`transaction_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Dumping data for table loyality.invoice: ~0 rows (approximately)
DELETE FROM `invoice`;
/*!40000 ALTER TABLE `invoice` DISABLE KEYS */;
/*!40000 ALTER TABLE `invoice` ENABLE KEYS */;

-- Dumping structure for table loyality.location
DROP TABLE IF EXISTS `location`;
CREATE TABLE IF NOT EXISTS `location` (
  `LOCATION_ID` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `LOCATION_NAME` varchar(50) NOT NULL,
  `LOCATION_DESC` varchar(100) NOT NULL,
  `LATITUDE` double NOT NULL,
  `LONGITUDE` double NOT NULL,
  `CREATED_BY` varchar(50) NOT NULL,
  `MODIFIED_BY` varchar(50) DEFAULT NULL,
  `STATUS` enum('ACTIVE','INACTIVE','DELETED') NOT NULL DEFAULT 'ACTIVE',
  PRIMARY KEY (`LOCATION_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC COMMENT='Holds the details of the confirgured locations. Shares a one-to-many mapping with Edge table and many-to-one mapping with zone table';

-- Dumping data for table loyality.location: ~0 rows (approximately)
DELETE FROM `location`;
/*!40000 ALTER TABLE `location` DISABLE KEYS */;
/*!40000 ALTER TABLE `location` ENABLE KEYS */;

-- Dumping structure for table loyality.loyality
DROP TABLE IF EXISTS `loyality`;
CREATE TABLE IF NOT EXISTS `loyality` (
  `loyality_id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `loyality_type_id` int(11) unsigned NOT NULL,
  `loyality_name` varchar(50) NOT NULL,
  `status` enum('ACTIVE','INACTIVE') NOT NULL DEFAULT 'ACTIVE',
  `created_by` varchar(50) NOT NULL,
  `modified_by` varchar(50) NOT NULL,
  PRIMARY KEY (`loyality_id`),
  KEY `FK_loyality_loyality` (`loyality_type_id`),
  CONSTRAINT `FK_loyality_loyality` FOREIGN KEY (`loyality_type_id`) REFERENCES `loyality` (`loyality_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Dumping data for table loyality.loyality: ~0 rows (approximately)
DELETE FROM `loyality`;
/*!40000 ALTER TABLE `loyality` DISABLE KEYS */;
/*!40000 ALTER TABLE `loyality` ENABLE KEYS */;

-- Dumping structure for table loyality.loyality_type
DROP TABLE IF EXISTS `loyality_type`;
CREATE TABLE IF NOT EXISTS `loyality_type` (
  `loyality_type_id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `loyality_type_value` varchar(50) NOT NULL,
  `loyality_type_desc` varchar(50) NOT NULL,
  `status` enum('ACTIVE','INACTIVE') NOT NULL DEFAULT 'ACTIVE',
  `create_by` varchar(50) NOT NULL,
  `modified_by` varchar(50) NOT NULL,
  PRIMARY KEY (`loyality_type_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Dumping data for table loyality.loyality_type: ~0 rows (approximately)
DELETE FROM `loyality_type`;
/*!40000 ALTER TABLE `loyality_type` DISABLE KEYS */;
/*!40000 ALTER TABLE `loyality_type` ENABLE KEYS */;

-- Dumping structure for table loyality.offers
DROP TABLE IF EXISTS `offers`;
CREATE TABLE IF NOT EXISTS `offers` (
  `Offer_id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `discount_type` int(10) NOT NULL DEFAULT 0,
  `offer_name` varchar(50) NOT NULL DEFAULT '0',
  `offer_desc` varchar(50) NOT NULL DEFAULT '0',
  `status` enum('ACTIVE','INACTIVE') NOT NULL DEFAULT 'ACTIVE',
  `created_by` varchar(50) NOT NULL DEFAULT '0',
  `modified_by` varchar(50) NOT NULL DEFAULT '0',
  PRIMARY KEY (`Offer_id`),
  KEY `FK_offers_discount_type` (`discount_type`),
  CONSTRAINT `FK_offers_discount_type` FOREIGN KEY (`discount_type`) REFERENCES `discount_type` (`discount_type_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Dumping data for table loyality.offers: ~0 rows (approximately)
DELETE FROM `offers`;
/*!40000 ALTER TABLE `offers` DISABLE KEYS */;
/*!40000 ALTER TABLE `offers` ENABLE KEYS */;

-- Dumping structure for table loyality.offer_product
DROP TABLE IF EXISTS `offer_product`;
CREATE TABLE IF NOT EXISTS `offer_product` (
  `product_offer_id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `product_id` int(10) unsigned NOT NULL DEFAULT 0,
  `offer_id` int(10) unsigned NOT NULL DEFAULT 0,
  `create_by` varchar(50) NOT NULL DEFAULT '0',
  `modified_by` varchar(50) NOT NULL DEFAULT '0',
  PRIMARY KEY (`product_offer_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Dumping data for table loyality.offer_product: ~0 rows (approximately)
DELETE FROM `offer_product`;
/*!40000 ALTER TABLE `offer_product` DISABLE KEYS */;
/*!40000 ALTER TABLE `offer_product` ENABLE KEYS */;

-- Dumping structure for table loyality.person
DROP TABLE IF EXISTS `person`;
CREATE TABLE IF NOT EXISTS `person` (
  `PERSON_ID` int(11) unsigned NOT NULL,
  `PERSON_LOYALITY_CARD_NUMBER` varchar(50) DEFAULT NULL COMMENT 'he may opt for caard / may not',
  `FIRSTNAME` varchar(50) NOT NULL,
  `LASTNAME` varchar(50) NOT NULL,
  `DATE_OF_BIRTH` date DEFAULT NULL,
  `STATUS` enum('ACTIVE','INACTIVE','DELETED') NOT NULL DEFAULT 'ACTIVE',
  `HAS_SHARED_MEDIA` enum('YES','NO') NOT NULL DEFAULT 'NO',
  `CREATED_BY` varchar(50) NOT NULL,
  `MODIFIED_BY` varchar(50) NOT NULL,
  `MIDDLENAME` varchar(50) DEFAULT NULL,
  `EMAIL` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`PERSON_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC COMMENT='information related to person who are enrolled';

-- Dumping data for table loyality.person: ~0 rows (approximately)
DELETE FROM `person`;
/*!40000 ALTER TABLE `person` DISABLE KEYS */;
/*!40000 ALTER TABLE `person` ENABLE KEYS */;

-- Dumping structure for table loyality.person_account
DROP TABLE IF EXISTS `person_account`;
CREATE TABLE IF NOT EXISTS `person_account` (
  `PERSON_ACCOUNT_MAPPING` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `PERSON_ID` int(11) unsigned NOT NULL DEFAULT 0,
  `ACCOUNT_ID` int(11) unsigned NOT NULL,
  `CREATED_BY` varchar(50) NOT NULL,
  `MODIFIED_BY` varchar(50) NOT NULL,
  `STATUS` enum('ACTIVE','INACTIVE') NOT NULL DEFAULT 'ACTIVE',
  PRIMARY KEY (`PERSON_ACCOUNT_MAPPING`),
  KEY `FK_person_account_person` (`PERSON_ID`),
  KEY `FK_person_account_account` (`ACCOUNT_ID`),
  CONSTRAINT `FK_person_account_account` FOREIGN KEY (`ACCOUNT_ID`) REFERENCES `account` (`ACCOUNT_ID`),
  CONSTRAINT `FK_person_account_person` FOREIGN KEY (`PERSON_ID`) REFERENCES `person` (`PERSON_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC COMMENT='table to store the person account mapping';

-- Dumping data for table loyality.person_account: ~0 rows (approximately)
DELETE FROM `person_account`;
/*!40000 ALTER TABLE `person_account` DISABLE KEYS */;
/*!40000 ALTER TABLE `person_account` ENABLE KEYS */;

-- Dumping structure for table loyality.person_biometric
DROP TABLE IF EXISTS `person_biometric`;
CREATE TABLE IF NOT EXISTS `person_biometric` (
  `PEROSN_BIOMETRIC_ID` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `PERSON_ID` int(11) unsigned NOT NULL,
  `BIOMETRIC_ID` int(11) unsigned NOT NULL,
  `CREATED_BY` varchar(50) NOT NULL,
  `MODIFIED_BY` varchar(50) NOT NULL,
  `STATUS` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`PEROSN_BIOMETRIC_ID`),
  KEY `FK_person_biometric_person` (`PERSON_ID`),
  KEY `FK_person_biometric_biometric` (`BIOMETRIC_ID`),
  CONSTRAINT `FK_person_biometric_biometric` FOREIGN KEY (`BIOMETRIC_ID`) REFERENCES `biometric` (`BIOMETRIC_ID`),
  CONSTRAINT `FK_person_biometric_person` FOREIGN KEY (`PERSON_ID`) REFERENCES `person` (`PERSON_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC COMMENT='Mapping bw/ person and biometric';

-- Dumping data for table loyality.person_biometric: ~0 rows (approximately)
DELETE FROM `person_biometric`;
/*!40000 ALTER TABLE `person_biometric` DISABLE KEYS */;
/*!40000 ALTER TABLE `person_biometric` ENABLE KEYS */;

-- Dumping structure for table loyality.person_loyality
DROP TABLE IF EXISTS `person_loyality`;
CREATE TABLE IF NOT EXISTS `person_loyality` (
  `person_loyality_id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `person_id` int(11) unsigned NOT NULL,
  `loyality_id` int(11) unsigned NOT NULL,
  `status` enum('ACTIVE','INACTIVE') NOT NULL DEFAULT 'ACTIVE',
  `created_by` varchar(50) NOT NULL,
  `modified_by` varchar(50) NOT NULL,
  PRIMARY KEY (`person_loyality_id`),
  KEY `FK_person_loyality_person` (`person_id`),
  KEY `FK_person_loyality_loyality` (`loyality_id`),
  CONSTRAINT `FK_person_loyality_loyality` FOREIGN KEY (`loyality_id`) REFERENCES `loyality` (`loyality_id`),
  CONSTRAINT `FK_person_loyality_person` FOREIGN KEY (`person_id`) REFERENCES `person` (`PERSON_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Dumping data for table loyality.person_loyality: ~0 rows (approximately)
DELETE FROM `person_loyality`;
/*!40000 ALTER TABLE `person_loyality` DISABLE KEYS */;
/*!40000 ALTER TABLE `person_loyality` ENABLE KEYS */;

-- Dumping structure for table loyality.person_transaction
DROP TABLE IF EXISTS `person_transaction`;
CREATE TABLE IF NOT EXISTS `person_transaction` (
  `person_transaction_id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `product_id` int(10) unsigned NOT NULL DEFAULT 0,
  `person_id` int(10) unsigned NOT NULL DEFAULT 0,
  `transaction_id` int(10) unsigned NOT NULL DEFAULT 0,
  PRIMARY KEY (`person_transaction_id`),
  KEY `FK_person_transaction_product` (`product_id`),
  KEY `FK_person_transaction_person` (`person_id`),
  KEY `FK_person_transaction_transaction` (`transaction_id`),
  CONSTRAINT `FK_person_transaction_person` FOREIGN KEY (`person_id`) REFERENCES `person` (`PERSON_ID`),
  CONSTRAINT `FK_person_transaction_product` FOREIGN KEY (`product_id`) REFERENCES `product` (`product_id`),
  CONSTRAINT `FK_person_transaction_transaction` FOREIGN KEY (`transaction_id`) REFERENCES `transaction` (`transaction_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COMMENT='Not kept any status colmn here as, this is been update at the time of transaction';

-- Dumping data for table loyality.person_transaction: ~0 rows (approximately)
DELETE FROM `person_transaction`;
/*!40000 ALTER TABLE `person_transaction` DISABLE KEYS */;
/*!40000 ALTER TABLE `person_transaction` ENABLE KEYS */;

-- Dumping structure for table loyality.product
DROP TABLE IF EXISTS `product`;
CREATE TABLE IF NOT EXISTS `product` (
  `product_id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `product_price` int(11) unsigned NOT NULL DEFAULT 0,
  `product_qr_code` int(11) unsigned NOT NULL DEFAULT 0,
  `product_type_id` int(11) unsigned NOT NULL DEFAULT 0,
  `product_name` int(11) unsigned NOT NULL DEFAULT 0,
  `product_desc` int(11) unsigned NOT NULL DEFAULT 0,
  `product_mfr_dt` date NOT NULL,
  `product_expiry_dt` date NOT NULL,
  PRIMARY KEY (`product_id`),
  KEY `FK_product_product_type` (`product_type_id`),
  CONSTRAINT `FK_product_product_type` FOREIGN KEY (`product_type_id`) REFERENCES `product_type` (`product_type_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Dumping data for table loyality.product: ~0 rows (approximately)
DELETE FROM `product`;
/*!40000 ALTER TABLE `product` DISABLE KEYS */;
/*!40000 ALTER TABLE `product` ENABLE KEYS */;

-- Dumping structure for table loyality.product_store
DROP TABLE IF EXISTS `product_store`;
CREATE TABLE IF NOT EXISTS `product_store` (
  `product_store_id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `product_id` int(10) unsigned NOT NULL,
  `store_id` int(10) unsigned NOT NULL,
  `status` enum('ACTIVE','INACTIVE') NOT NULL,
  `create_by` varchar(50) NOT NULL,
  `modified_by` varchar(50) NOT NULL,
  PRIMARY KEY (`product_store_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Dumping data for table loyality.product_store: ~0 rows (approximately)
DELETE FROM `product_store`;
/*!40000 ALTER TABLE `product_store` DISABLE KEYS */;
/*!40000 ALTER TABLE `product_store` ENABLE KEYS */;

-- Dumping structure for table loyality.product_type
DROP TABLE IF EXISTS `product_type`;
CREATE TABLE IF NOT EXISTS `product_type` (
  `product_type_id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `product_type_val` varchar(50) NOT NULL DEFAULT '0',
  `product_type_name` varchar(50) NOT NULL DEFAULT '0',
  `product_type_desc` varchar(50) NOT NULL DEFAULT '0',
  `status` enum('ACTIVE','INACTIVE') NOT NULL DEFAULT 'ACTIVE',
  PRIMARY KEY (`product_type_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Dumping data for table loyality.product_type: ~0 rows (approximately)
DELETE FROM `product_type`;
/*!40000 ALTER TABLE `product_type` DISABLE KEYS */;
/*!40000 ALTER TABLE `product_type` ENABLE KEYS */;

-- Dumping structure for table loyality.shopping_cart
DROP TABLE IF EXISTS `shopping_cart`;
CREATE TABLE IF NOT EXISTS `shopping_cart` (
  `cart_id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `cart_name` varchar(50) NOT NULL DEFAULT '0',
  `clear_cart` int(11) NOT NULL DEFAULT 0 COMMENT 'clear cart if not purchansed in some number provided here',
  `status` enum('ACTIVE','INACTIVE') NOT NULL DEFAULT 'ACTIVE',
  PRIMARY KEY (`cart_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Dumping data for table loyality.shopping_cart: ~0 rows (approximately)
DELETE FROM `shopping_cart`;
/*!40000 ALTER TABLE `shopping_cart` DISABLE KEYS */;
/*!40000 ALTER TABLE `shopping_cart` ENABLE KEYS */;

-- Dumping structure for table loyality.stores
DROP TABLE IF EXISTS `stores`;
CREATE TABLE IF NOT EXISTS `stores` (
  `store_id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `store_name` varchar(50) NOT NULL DEFAULT '0',
  `store_type_id` int(10) unsigned NOT NULL DEFAULT 0,
  `status` enum('ACTIVE','INACTIVE') NOT NULL DEFAULT 'ACTIVE',
  `address` varchar(3000) NOT NULL,
  `create_by` varchar(50) NOT NULL,
  `modifiel_by` varchar(50) NOT NULL,
  PRIMARY KEY (`store_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Dumping data for table loyality.stores: ~0 rows (approximately)
DELETE FROM `stores`;
/*!40000 ALTER TABLE `stores` DISABLE KEYS */;
/*!40000 ALTER TABLE `stores` ENABLE KEYS */;

-- Dumping structure for table loyality.store_location
DROP TABLE IF EXISTS `store_location`;
CREATE TABLE IF NOT EXISTS `store_location` (
  `store_location_id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `store_id` int(10) unsigned NOT NULL DEFAULT 0,
  `location_id` int(10) unsigned NOT NULL DEFAULT 0,
  `status` enum('ACTIVE','INACTIVE') NOT NULL DEFAULT 'ACTIVE',
  `created_by` varchar(50) NOT NULL,
  `modified_by` varchar(50) NOT NULL,
  PRIMARY KEY (`store_location_id`),
  KEY `FK_store_location_stores` (`store_id`),
  KEY `FK_store_location_location` (`location_id`),
  CONSTRAINT `FK_store_location_location` FOREIGN KEY (`location_id`) REFERENCES `location` (`LOCATION_ID`),
  CONSTRAINT `FK_store_location_stores` FOREIGN KEY (`store_id`) REFERENCES `stores` (`store_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Dumping data for table loyality.store_location: ~0 rows (approximately)
DELETE FROM `store_location`;
/*!40000 ALTER TABLE `store_location` DISABLE KEYS */;
/*!40000 ALTER TABLE `store_location` ENABLE KEYS */;

-- Dumping structure for table loyality.transaction
DROP TABLE IF EXISTS `transaction`;
CREATE TABLE IF NOT EXISTS `transaction` (
  `transaction_id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `transaction_name` varchar(50) NOT NULL DEFAULT '0',
  `transaction_type_id` int(10) unsigned NOT NULL DEFAULT 0,
  `points_left` bigint(20) unsigned NOT NULL DEFAULT 0,
  `transaction_dt` datetime NOT NULL DEFAULT current_timestamp() ON UPDATE current_timestamp(),
  `isRedeeming` enum('YES','NO') NOT NULL DEFAULT 'NO',
  `created_by` varchar(50) NOT NULL,
  PRIMARY KEY (`transaction_id`),
  KEY `FK_transaction_transaction_type` (`transaction_type_id`),
  CONSTRAINT `FK_transaction_transaction_type` FOREIGN KEY (`transaction_type_id`) REFERENCES `transaction_type` (`transaction_type_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Dumping data for table loyality.transaction: ~0 rows (approximately)
DELETE FROM `transaction`;
/*!40000 ALTER TABLE `transaction` DISABLE KEYS */;
/*!40000 ALTER TABLE `transaction` ENABLE KEYS */;

-- Dumping structure for table loyality.transaction_type
DROP TABLE IF EXISTS `transaction_type`;
CREATE TABLE IF NOT EXISTS `transaction_type` (
  `transaction_type_id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `transaction_type_val` varchar(50) NOT NULL DEFAULT '0',
  `transaction_type_name` varchar(50) NOT NULL DEFAULT '0',
  `status` varchar(50) NOT NULL DEFAULT '0' COMMENT 'to actitve/inactie some types',
  `created_by` varchar(50) NOT NULL DEFAULT '0',
  `modified_by` varchar(50) NOT NULL DEFAULT '0',
  PRIMARY KEY (`transaction_type_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COMMENT='transation of tyepe cash/poiints /wallets/cheque/card';

-- Dumping data for table loyality.transaction_type: ~0 rows (approximately)
DELETE FROM `transaction_type`;
/*!40000 ALTER TABLE `transaction_type` DISABLE KEYS */;
/*!40000 ALTER TABLE `transaction_type` ENABLE KEYS */;

-- Dumping structure for table loyality.user
DROP TABLE IF EXISTS `user`;
CREATE TABLE IF NOT EXISTS `user` (
  `USER_ID` varchar(40) NOT NULL,
  `USER_NAME` varchar(80) NOT NULL,
  `START_DATE` datetime NOT NULL,
  `END_DATE` datetime NOT NULL,
  `STATUS` varchar(12) NOT NULL,
  `AUTH_TYPE` varchar(1) DEFAULT NULL,
  `CREATED_BY` varchar(40) DEFAULT NULL,
  `MODIFIED_BY` varchar(40) DEFAULT NULL,
  `EMAIL_ADDRESS` varchar(200) DEFAULT NULL,
  `CONTACT_NO` varchar(15) DEFAULT NULL,
  `ORGANIZATION` varchar(40) DEFAULT NULL,
  `FIRST_NAME` varchar(45) DEFAULT NULL,
  `LAST_NAME` varchar(45) DEFAULT NULL,
  `IS_DELETED` tinyint(1) DEFAULT 0,
  PRIMARY KEY (`USER_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 ROW_FORMAT=DYNAMIC;

-- Dumping data for table loyality.user: ~0 rows (approximately)
DELETE FROM `user`;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
/*!40000 ALTER TABLE `user` ENABLE KEYS */;

-- Dumping structure for table loyality.user_function
DROP TABLE IF EXISTS `user_function`;
CREATE TABLE IF NOT EXISTS `user_function` (
  `FUNCTION_ID` varchar(40) NOT NULL,
  `DESCRIPTION` varchar(80) NOT NULL,
  `CATEGORY` varchar(40) DEFAULT NULL,
  PRIMARY KEY (`FUNCTION_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 ROW_FORMAT=DYNAMIC;

-- Dumping data for table loyality.user_function: ~0 rows (approximately)
DELETE FROM `user_function`;
/*!40000 ALTER TABLE `user_function` DISABLE KEYS */;
/*!40000 ALTER TABLE `user_function` ENABLE KEYS */;

-- Dumping structure for table loyality.user_password
DROP TABLE IF EXISTS `user_password`;
CREATE TABLE IF NOT EXISTS `user_password` (
  `USER_ID` varchar(40) NOT NULL,
  `PASSWORD` varchar(90) DEFAULT NULL,
  `LAST_LOGIN_DATE` datetime DEFAULT NULL,
  `RETRY_COUNT` int(10) unsigned DEFAULT 0,
  `MODIFIED_DATE` datetime DEFAULT NULL,
  `PREVIOUS_PASSWORD` varchar(90) DEFAULT NULL,
  PRIMARY KEY (`USER_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 ROW_FORMAT=DYNAMIC;

-- Dumping data for table loyality.user_password: ~0 rows (approximately)
DELETE FROM `user_password`;
/*!40000 ALTER TABLE `user_password` DISABLE KEYS */;
/*!40000 ALTER TABLE `user_password` ENABLE KEYS */;

-- Dumping structure for table loyality.user_role
DROP TABLE IF EXISTS `user_role`;
CREATE TABLE IF NOT EXISTS `user_role` (
  `ROLE_ID` varchar(16) NOT NULL,
  `USER_ID` varchar(40) NOT NULL,
  PRIMARY KEY (`ROLE_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 ROW_FORMAT=DYNAMIC;

-- Dumping data for table loyality.user_role: ~0 rows (approximately)
DELETE FROM `user_role`;
/*!40000 ALTER TABLE `user_role` DISABLE KEYS */;
/*!40000 ALTER TABLE `user_role` ENABLE KEYS */;

-- Dumping structure for table loyality.zone
DROP TABLE IF EXISTS `zone`;
CREATE TABLE IF NOT EXISTS `zone` (
  `ZONE_ID` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `ZONE_NAME` varchar(50) NOT NULL,
  `ZONE_DESC` varchar(100) NOT NULL,
  `CREATED_BY` varchar(50) NOT NULL,
  `MODIFIED_BY` varchar(50) DEFAULT NULL,
  `STATUS` enum('ACTIVE','INACTIVE','DELETED') NOT NULL DEFAULT 'ACTIVE',
  PRIMARY KEY (`ZONE_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC COMMENT='Holds the details of the confirgured zones. Shares a one-to-many mapping with location table';

-- Dumping data for table loyality.zone: ~0 rows (approximately)
DELETE FROM `zone`;
/*!40000 ALTER TABLE `zone` DISABLE KEYS */;
/*!40000 ALTER TABLE `zone` ENABLE KEYS */;

-- Dumping structure for table loyality.zone_location
DROP TABLE IF EXISTS `zone_location`;
CREATE TABLE IF NOT EXISTS `zone_location` (
  `ZONE_LOCATION_ID` int(11) NOT NULL AUTO_INCREMENT,
  `ZONE_ID` int(11) NOT NULL,
  `LOCATION_ID` int(11) NOT NULL,
  `CREATED_BY` varchar(50) NOT NULL,
  `MODIFIED_BY` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`ZONE_LOCATION_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC COMMENT='Zone-Lcoation Mapping table';

-- Dumping data for table loyality.zone_location: ~0 rows (approximately)
DELETE FROM `zone_location`;
/*!40000 ALTER TABLE `zone_location` DISABLE KEYS */;
/*!40000 ALTER TABLE `zone_location` ENABLE KEYS */;

/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
