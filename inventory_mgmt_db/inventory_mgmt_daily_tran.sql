-- MySQL dump 10.13  Distrib 5.7.17, for Win64 (x86_64)
--
-- Host: localhost    Database: inventory_mgmt
-- ------------------------------------------------------
-- Server version	5.7.17-log

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
-- Table structure for table `daily_tran`
--

DROP TABLE IF EXISTS `daily_tran`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `daily_tran` (
  `tran_id` int(11) NOT NULL AUTO_INCREMENT,
  `agent_id` int(11) NOT NULL,
  `tran_dt` datetime DEFAULT NULL,
  `total_vol_bought` double DEFAULT NULL,
  `approved_pdt_vol` double DEFAULT NULL,
  `reject1_vol` double DEFAULT NULL,
  `reject2_vol` double DEFAULT NULL,
  `leaf_issued_vol` double DEFAULT NULL,
  `tobacco_issued_vol` double DEFAULT NULL,
  `tran_type` char(1) DEFAULT NULL,
  `payment_id` int(11) DEFAULT NULL,
  `updated_by` varchar(45) DEFAULT NULL,
  `updated_on` datetime DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`tran_id`,`agent_id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `daily_tran`
--

LOCK TABLES `daily_tran` WRITE;
/*!40000 ALTER TABLE `daily_tran` DISABLE KEYS */;
INSERT INTO `daily_tran` VALUES (1,1,'2018-04-01 00:00:00',NULL,12,NULL,NULL,100,100,'O',1,'admin','2017-04-16 00:21:02'),(2,1,'2018-04-04 00:00:00',0,10000,0,0,NULL,NULL,'I',NULL,'admin','2017-04-16 00:22:09'),(3,1,'2018-04-04 00:00:00',0,900,0,0,NULL,NULL,'I',NULL,'admin','2017-04-16 02:54:41'),(4,1,'2017-11-04 00:00:00',0,200,0,0,NULL,NULL,'I',NULL,'admin','2017-04-16 02:57:27'),(5,1,'2017-04-16 00:00:00',0,10000,0,0,NULL,NULL,'I',NULL,'admin','2017-04-16 03:00:53'),(6,1,'2017-04-10 00:00:00',0,10000,0,0,NULL,NULL,'I',NULL,'admin','2017-04-16 03:02:33');
/*!40000 ALTER TABLE `daily_tran` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2017-06-15 10:03:54
