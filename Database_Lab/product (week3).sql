-- DROP DATABASE `www_week3`
-- Dumping database structure for productdb
CREATE DATABASE IF NOT EXISTS `productdb` /*!40100 DEFAULT CHARACTER SET latin1 COLLATE latin1_swedish_ci */;
USE `www_week3`;

-- Dumping structure for table productdb.product
DROP TABLE IF EXISTS `product`;
CREATE TABLE IF NOT EXISTS `product` (
  `product_id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(150) NOT NULL,
  `description` text NOT NULL,
  `img_path` varchar(250) DEFAULT NULL,
  `status` int(11),
  PRIMARY KEY (`product_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_swedish_ci;

-- Data exporting was unselected.

-- Dumping structure for table productdb.product_price
DROP TABLE IF EXISTS `product_price`;
CREATE TABLE IF NOT EXISTS `product_price` (
  `price_id` int(11) NOT NULL AUTO_INCREMENT,
  `product_id` int(11) NOT NULL,
  `apply_date` datetime NOT NULL DEFAULT current_timestamp(),
  `value` double NOT NULL DEFAULT 0 COMMENT 'the price',
  `note` text DEFAULT NULL,
  PRIMARY KEY (`price_id`),
  CONSTRAINT `FK_product_price_product` FOREIGN KEY (`product_id`) REFERENCES `product` (`product_id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_swedish_ci;

