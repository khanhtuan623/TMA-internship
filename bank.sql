-- MySQL dump 10.13  Distrib 5.7.17, for Win64 (x86_64)
--
-- Host: localhost    Database: bank
-- ------------------------------------------------------
-- Server version	5.7.21-log

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
-- Table structure for table `account`
--

DROP TABLE IF EXISTS `account`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `account` (
  `name` varchar(30) COLLATE utf8_unicode_ci NOT NULL,
  `number_card` bigint(12) NOT NULL,
  `cvc` int(4) NOT NULL,
  `balance` bigint(100) NOT NULL,
  `exp_date` varchar(10) COLLATE utf8_unicode_ci NOT NULL,
  `number_account` bigint(12) NOT NULL,
  PRIMARY KEY (`number_account`,`number_card`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `account`
--

LOCK TABLES `account` WRITE;
/*!40000 ALTER TABLE `account` DISABLE KEYS */;
INSERT INTO `account` VALUES ('TRAN KHANH TUAN',1234123412341234,1234,752277051953,'02/2222',123456789012),('TRAN HOANG PHONG',9876543211234567,1234,9999999999,'06/2022',151156545641);
/*!40000 ALTER TABLE `account` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `hibernate_sequence`
--

DROP TABLE IF EXISTS `hibernate_sequence`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `hibernate_sequence` (
  `next_val` bigint(20) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `hibernate_sequence`
--

LOCK TABLES `hibernate_sequence` WRITE;
/*!40000 ALTER TABLE `hibernate_sequence` DISABLE KEYS */;
INSERT INTO `hibernate_sequence` VALUES (52);
/*!40000 ALTER TABLE `hibernate_sequence` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `history`
--

DROP TABLE IF EXISTS `history`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `history` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(45) COLLATE utf8_unicode_ci NOT NULL,
  `number_card` bigint(12) NOT NULL,
  `balance` bigint(100) NOT NULL,
  `cvc` int(4) NOT NULL,
  `exp_date` varchar(10) COLLATE utf8_unicode_ci NOT NULL,
  `number_account` bigint(12) NOT NULL,
  `status` varchar(45) COLLATE utf8_unicode_ci NOT NULL,
  `exchange` varchar(5) COLLATE utf8_unicode_ci NOT NULL,
  `price` bigint(100) NOT NULL,
  `refund_price_available` bigint(100) NOT NULL,
  `date_payment` varchar(45) COLLATE utf8_unicode_ci NOT NULL,
  PRIMARY KEY (`id`,`number_account`),
  KEY `fk_his_ac_idx1` (`name`),
  KEY `fk_his_ac_number_card_idx` (`number_card`),
  KEY `fk_his_ac_cvc_idx` (`cvc`)
) ENGINE=InnoDB AUTO_INCREMENT=157 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `history`
--

LOCK TABLES `history` WRITE;
/*!40000 ALTER TABLE `history` DISABLE KEYS */;
INSERT INTO `history` VALUES (32,'TRAN KHANH TUAN',1234123412341234,999349111156,1234,'02/2222',123456789012,'success','-',644450780,580009549,'12/07/2018 11:41:21'),(39,'TRAN KHANH TUAN',1234123412341234,998704699040,1234,'02/2222',123456789012,'success','+',6444,0,'12/07/2018 11:53:57'),(40,'TRAN KHANH TUAN',1234123412341234,998704705484,1234,'02/2222',123456789012,'success','+',64441231,0,'12/07/2018 11:59:16'),(41,'TRAN KHANH TUAN',1234123412341234,998769146715,1234,'02/2222',123456789012,'success','+',64441231211231,0,'12/07/2018 12:00:31'),(42,'TRAN KHANH TUAN',1234123412341234,998769146715,1234,'02/2222',123456789012,'success','+',64441231211231,0,'12/07/2018 12:04:43'),(43,'TRAN KHANH TUAN',1234123412341234,998769146715,1234,'02/2222',123456789012,'success','-',123122780,123122780,'12/07/2018 12:05:23'),(44,'TRAN KHANH TUAN',1234123412341234,998646023935,1234,'02/2222',123456789012,'success','-',123122732180,123122732180,'12/07/2018 12:05:27'),(45,'TRAN KHANH TUAN',1234123412341234,875523291755,1234,'02/2222',123456789012,'success','-',123123123123,123123116679,'12/07/2018 12:05:31'),(46,'TRAN KHANH TUAN',1234123412341234,752400168632,1234,'02/2222',123456789012,'fail [ balance < price ]','null',1231231231212,0,'12/07/2018 12:05:56'),(47,'TRAN KHANH TUAN',123411223412341234,0,1234,'02/2222',0,'fail [check info account]','null',1231231231212,0,'12/07/2018 12:06:36'),(48,'TRAN KHANH TUAN',1234123412341234,752400168632,1234,'02/2222',123456789012,'fail [ balance < price ]','null',1231231231212,0,'12/07/2018 12:06:43'),(49,'TRAN KHANH TUAN',1234123412341234,752400168632,1234,'02/2222',123456789012,'success','-',123123123,123123123,'12/07/2018 12:06:51'),(50,'TRAN KHANH TUAN',1234123412341234,752277045509,1234,'02/2222',123456789012,'success','+',64441231211231,0,'12/07/2018 12:07:16'),(51,'TRAN KHANH TUAN',1234123412341234,752277045509,1234,'02/2222',123456789012,'success','+',6444,0,'12/07/2018 12:07:21');
/*!40000 ALTER TABLE `history` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2018-07-12 13:01:04
