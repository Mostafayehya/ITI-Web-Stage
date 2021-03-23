-- MySQL Administrator dump 1.4
--
-- ------------------------------------------------------
-- Server version	5.0.51b-community-nt


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;


--
-- Create schema biddingschema
--

CREATE DATABASE IF NOT EXISTS biddingschema;
USE biddingschema;

--
-- Definition of table `buyer`
--

DROP TABLE IF EXISTS `buyer`;
CREATE TABLE `buyer` (
  `id` int(11) NOT NULL auto_increment,
  `value` varchar(150) NOT NULL,
  `user_id` int(11) NOT NULL,
  PRIMARY KEY  (`id`),
  UNIQUE KEY `user_id_UNIQUE` (`user_id`),
  KEY `fk_buyer_user1_idx` (`user_id`),
  CONSTRAINT `fk_buyer_user1` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `buyer`
--

/*!40000 ALTER TABLE `buyer` DISABLE KEYS */;
/*!40000 ALTER TABLE `buyer` ENABLE KEYS */;


--
-- Definition of table `buyer_bid_product`
--

DROP TABLE IF EXISTS `buyer_bid_product`;
CREATE TABLE `buyer_bid_product` (
  `buyer_id` int(11) NOT NULL,
  `product_id` int(11) NOT NULL,
  `date` date NOT NULL,
  `amount` float NOT NULL,
  `quantity` int(11) NOT NULL,
  PRIMARY KEY  (`buyer_id`,`product_id`),
  KEY `fk_buyer_has_product_product1_idx` (`product_id`),
  KEY `fk_buyer_has_product_buyer1_idx` (`buyer_id`),
  CONSTRAINT `fk_buyer_has_product_buyer1` FOREIGN KEY (`buyer_id`) REFERENCES `buyer` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_buyer_has_product_product1` FOREIGN KEY (`product_id`) REFERENCES `product` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `buyer_bid_product`
--

/*!40000 ALTER TABLE `buyer_bid_product` DISABLE KEYS */;
/*!40000 ALTER TABLE `buyer_bid_product` ENABLE KEYS */;


--
-- Definition of table `buyer_buy_product`
--

DROP TABLE IF EXISTS `buyer_buy_product`;
CREATE TABLE `buyer_buy_product` (
  `buyer_id` int(11) NOT NULL,
  `product_id` int(11) NOT NULL,
  `payment_date` date NOT NULL,
  `amount` float NOT NULL,
  `quantity` int(11) NOT NULL,
  PRIMARY KEY  (`buyer_id`,`product_id`),
  KEY `fk_buyer_has_product_product2_idx` (`product_id`),
  KEY `fk_buyer_has_product_buyer2_idx` (`buyer_id`),
  CONSTRAINT `fk_buyer_has_product_buyer2` FOREIGN KEY (`buyer_id`) REFERENCES `buyer` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_buyer_has_product_product2` FOREIGN KEY (`product_id`) REFERENCES `product` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `buyer_buy_product`
--

/*!40000 ALTER TABLE `buyer_buy_product` DISABLE KEYS */;
/*!40000 ALTER TABLE `buyer_buy_product` ENABLE KEYS */;


--
-- Definition of table `category`
--

DROP TABLE IF EXISTS `category`;
CREATE TABLE `category` (
  `id` int(11) NOT NULL auto_increment,
  `value` varchar(45) NOT NULL,
  `description` varchar(150) default NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `category`
--

/*!40000 ALTER TABLE `category` DISABLE KEYS */;
/*!40000 ALTER TABLE `category` ENABLE KEYS */;


--
-- Definition of table `product`
--

DROP TABLE IF EXISTS `product`;
CREATE TABLE `product` (
  `id` int(11) NOT NULL auto_increment,
  `name` varchar(45) NOT NULL,
  `description` varchar(150) default NULL,
  `manufacturing_name` varchar(100) NOT NULL,
  `manufacturing_date` date NOT NULL,
  `expiration_date` date default NULL,
  `seller_id` int(11) default NULL,
  `quantity` int(11) NOT NULL,
  `offered_date` date NOT NULL,
  `finish_date` date NOT NULL,
  PRIMARY KEY  (`id`),
  KEY `fk_product_seller1_idx` (`seller_id`),
  CONSTRAINT `fk_product_seller1` FOREIGN KEY (`seller_id`) REFERENCES `seller` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `product`
--

/*!40000 ALTER TABLE `product` DISABLE KEYS */;
/*!40000 ALTER TABLE `product` ENABLE KEYS */;


--
-- Definition of table `product_has_category`
--

DROP TABLE IF EXISTS `product_has_category`;
CREATE TABLE `product_has_category` (
  `product_id` int(11) NOT NULL,
  `category_id` int(11) NOT NULL,
  PRIMARY KEY  (`product_id`,`category_id`),
  KEY `fk_product_has_category_category1_idx` (`category_id`),
  KEY `fk_product_has_category_product1_idx` (`product_id`),
  CONSTRAINT `fk_product_has_category_category1` FOREIGN KEY (`category_id`) REFERENCES `category` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_product_has_category_product1` FOREIGN KEY (`product_id`) REFERENCES `product` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `product_has_category`
--

/*!40000 ALTER TABLE `product_has_category` DISABLE KEYS */;
/*!40000 ALTER TABLE `product_has_category` ENABLE KEYS */;


--
-- Definition of table `seller`
--

DROP TABLE IF EXISTS `seller`;
CREATE TABLE `seller` (
  `id` int(11) NOT NULL,
  `value` varchar(100) NOT NULL,
  PRIMARY KEY  (`id`),
  KEY `fk_email_user_idx` (`id`),
  CONSTRAINT `fk_email_user` FOREIGN KEY (`id`) REFERENCES `user` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `seller`
--

/*!40000 ALTER TABLE `seller` DISABLE KEYS */;
/*!40000 ALTER TABLE `seller` ENABLE KEYS */;


--
-- Definition of table `user`
--

DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` int(11) NOT NULL auto_increment,
  `email` varchar(50) NOT NULL,
  `address` varchar(150) NOT NULL,
  `phone` varchar(45) default NULL,
  `mobile` varchar(45) default NULL,
  `date_of_birth` date default NULL,
  `registration_date` date NOT NULL,
  `user_name` varchar(45) NOT NULL,
  `password` varchar(45) NOT NULL,
  `full_name` varchar(100) default NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `user`
--

/*!40000 ALTER TABLE `user` DISABLE KEYS */;
/*!40000 ALTER TABLE `user` ENABLE KEYS */;




/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
