CREATE DATABASE  IF NOT EXISTS `sayone_online_cource` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `sayone_online_cource`;
-- MySQL dump 10.13  Distrib 5.6.17, for Win32 (x86)
--
-- Host: 127.0.0.1    Database: sayone_online_cource
-- ------------------------------------------------------
-- Server version	5.5.29-log

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `country`
--

DROP TABLE IF EXISTS `country`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `country` (
  `id` int(11) NOT NULL,
  `name` varchar(45) DEFAULT NULL,
  `code` varchar(45) DEFAULT NULL,
  `currency` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `country`
--

LOCK TABLES `country` WRITE;
/*!40000 ALTER TABLE `country` DISABLE KEYS */;
INSERT INTO `country` VALUES (1,'India','IND','INR'),(2,'US','US','USD'),(3,'Australia','AUD','DOLLER'),(4,'Brazil','BRL','Real');
/*!40000 ALTER TABLE `country` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `course`
--

DROP TABLE IF EXISTS `course`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `course` (
  `id` int(11) NOT NULL,
  `name` varchar(45) DEFAULT NULL,
  `description` varchar(45) DEFAULT NULL,
  `duration_in_months` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `course`
--

LOCK TABLES `course` WRITE;
/*!40000 ALTER TABLE `course` DISABLE KEYS */;
INSERT INTO `course` VALUES (1,'Angular','Beginers guide to angular',2),(2,'Spring Boor','Beginers guide to spring boot',3),(3,'Spring MVC','Beginers guide to spring MVC',2);
/*!40000 ALTER TABLE `course` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `course_component_value`
--

DROP TABLE IF EXISTS `course_component_value`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `course_component_value` (
  `id` int(11) NOT NULL,
  `component_value_id` int(11) DEFAULT NULL,
  `course_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_COURSE_ID_idx` (`course_id`),
  KEY `FK_COMPONENT_ID_idx` (`component_value_id`),
  CONSTRAINT `FK_COMPONENT_ID` FOREIGN KEY (`component_value_id`) REFERENCES `price_component_value` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `FK_COURSE_ID` FOREIGN KEY (`course_id`) REFERENCES `course` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `course_component_value`
--

LOCK TABLES `course_component_value` WRITE;
/*!40000 ALTER TABLE `course_component_value` DISABLE KEYS */;
INSERT INTO `course_component_value` VALUES (1,1,1),(2,2,1),(3,3,1),(4,4,1),(5,5,1),(6,6,2);
/*!40000 ALTER TABLE `course_component_value` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `price_component_value`
--

DROP TABLE IF EXISTS `price_component_value`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `price_component_value` (
  `id` int(11) NOT NULL,
  `country_id` int(11) DEFAULT NULL,
  `component_id` int(11) DEFAULT NULL,
  `value` decimal(24,12) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_PRICE_COMPONENT_ID_idx` (`component_id`),
  KEY `FK_COUNTRY_COUNTRY_ID_idx` (`country_id`),
  CONSTRAINT `FK_COUNTRY_COUNTRY_ID` FOREIGN KEY (`country_id`) REFERENCES `country` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `FK_PRICE_COMPONENT_ID` FOREIGN KEY (`component_id`) REFERENCES `price_components` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `price_component_value`
--

LOCK TABLES `price_component_value` WRITE;
/*!40000 ALTER TABLE `price_component_value` DISABLE KEYS */;
INSERT INTO `price_component_value` VALUES (1,1,1,18.250000000000),(2,1,2,140.750000000000),(3,2,3,10.250000000000),(4,2,1,8.110000000000),(5,2,2,200.750000000000),(6,2,1,57.200000000000);
/*!40000 ALTER TABLE `price_component_value` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `price_components`
--

DROP TABLE IF EXISTS `price_components`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `price_components` (
  `id` int(11) NOT NULL,
  `name` varchar(45) DEFAULT NULL,
  `type` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `price_components`
--

LOCK TABLES `price_components` WRITE;
/*!40000 ALTER TABLE `price_components` DISABLE KEYS */;
INSERT INTO `price_components` VALUES (1,'tax','percentage'),(2,'base_price','fixed'),(3,'conversion_fee','fixed');
/*!40000 ALTER TABLE `price_components` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `price_strategies`
--

DROP TABLE IF EXISTS `price_strategies`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `price_strategies` (
  `id` int(11) NOT NULL,
  `name` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `price_strategies`
--

LOCK TABLES `price_strategies` WRITE;
/*!40000 ALTER TABLE `price_strategies` DISABLE KEYS */;
INSERT INTO `price_strategies` VALUES (1,'subscription'),(2,'free'),(3,'one_time_payment');
/*!40000 ALTER TABLE `price_strategies` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `strategies_option`
--

DROP TABLE IF EXISTS `strategies_option`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `strategies_option` (
  `id` int(11) NOT NULL,
  `course_id` int(11) DEFAULT NULL,
  `duration_in_months` int(11) DEFAULT NULL,
  `price_strategy_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_STRATEGY_ID_idx` (`price_strategy_id`),
  KEY `FK_COURSE_COURSE_ID` (`course_id`),
  CONSTRAINT `FK_STRATEGY_ID` FOREIGN KEY (`price_strategy_id`) REFERENCES `price_strategies` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `FK_COURSE_COURSE_ID` FOREIGN KEY (`course_id`) REFERENCES `course` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `strategies_option`
--

LOCK TABLES `strategies_option` WRITE;
/*!40000 ALTER TABLE `strategies_option` DISABLE KEYS */;
INSERT INTO `strategies_option` VALUES (1,1,6,1),(2,1,6,3);
/*!40000 ALTER TABLE `strategies_option` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2020-11-06 17:53:14
