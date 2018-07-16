-- MySQL dump 10.13  Distrib 5.7.17, for Win64 (x86_64)
--
-- Host: localhost    Database: mobile
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
-- Table structure for table `device`
--

DROP TABLE IF EXISTS `device`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `device` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `brand` varchar(45) COLLATE utf8_unicode_ci NOT NULL,
  `name` varchar(45) COLLATE utf8_unicode_ci NOT NULL,
  `color` varchar(45) COLLATE utf8_unicode_ci NOT NULL,
  `memory` varchar(45) COLLATE utf8_unicode_ci NOT NULL,
  `infor` tinytext COLLATE utf8_unicode_ci NOT NULL,
  `quantity` int(11) NOT NULL,
  `status` varchar(45) COLLATE utf8_unicode_ci NOT NULL,
  `price` int(11) NOT NULL,
  `image` varchar(45) COLLATE utf8_unicode_ci NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=50 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `device`
--

LOCK TABLES `device` WRITE;
/*!40000 ALTER TABLE `device` DISABLE KEYS */;
INSERT INTO `device` VALUES (35,'apple','iphone 7','black','32G','Công ngh&#7879; màn hình:LED-backlit IPS LCD &#272;&#7897; phân gi&#7843;i: HD (1334 x 750 Pixels) Màn hình r&#7897;ng: 4.7\" M&#7863;t kính c&#7843;m &#7913;ng: Kính oleophobic (ion c&#432;&#7901;ng l&#7921;c)',1,'Available',21000000,'ip7-black.png'),(36,'apple','iphone 7 plus','red','128G','Công ngh&#7879; màn hình:LED-backlit IPS LCD &#272;&#7897; phân gi&#7843;i: HD (1334 x 750 Pixels) Màn hình r&#7897;ng: 4.7\" M&#7863;t kính c&#7843;m &#7913;ng: Kính oleophobic (ion c&#432;&#7901;ng l&#7921;c)',0,'Unvailable',21099999,'ip7plus-red.png'),(37,'samsung','galaxy note 8','black','32G','Công ngh&#7879; màn hình:LED-backlit IPS LCD &#272;&#7897; phân gi&#7843;i: HD (1334 x 750 Pixels) Màn hình r&#7897;ng: 4.7\" M&#7863;t kính c&#7843;m &#7913;ng: Kính oleophobic (ion c&#432;&#7901;ng l&#7921;c)',79,'available',98000000,'ss-note8-black.png'),(38,'samsung','galaxy s8 plus','black','64G','Công ngh&#7879; màn hình:LED-backlit IPS LCD &#272;&#7897; phân gi&#7843;i: HD (1334 x 750 Pixels) Màn hình r&#7897;ng: 4.7\" M&#7863;t kính c&#7843;m &#7913;ng: Kính oleophobic (ion c&#432;&#7901;ng l&#7921;c)',72,'available',76000000,'ss-s8plus-black.png'),(39,'apple','iphone X','black','128G','asmdmnmsadsamdjlk',212,'available',210000000,'ipx-black.png'),(42,'apple','iphone 7 plus','black','32G','asmdmnmsadsamdjlk',421,'available',43000000,'ip7plus-black.png'),(43,'apple','iphone 7 plus','gold','32G','asmdmnmsadsamdjlk',21,'available',210000000,'ip7plus-gold.png'),(44,'apple','iphone 7 plus','white','128G','sadsad',546,'available',999999999,'ip7plus-white.png'),(45,'apple','iphone7 ','gold','32G','sadsad',31,'available',67000000,'ip7-gold.png'),(46,'apple','iphone 7','white','32G','asmdmnmsadsamdjlk',42,'available',43000000,'ip7-white.png'),(47,'apple','iphone 7','red','128G','asmdmnmsadsamdjlk',64,'available',320000000,'ip7.png'),(48,'apple','iphone 5s','black','32G','anhdjsadjsakjdhj',212,'available',432000000,'ip5s.png'),(49,'apple','iphone 5s','gold','32G','sadsad',765,'available',12000000,'ip5s.png');
/*!40000 ALTER TABLE `device` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `invoice`
--

DROP TABLE IF EXISTS `invoice`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `invoice` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `id_device` int(11) NOT NULL,
  `qty` int(11) NOT NULL,
  `total` int(11) NOT NULL,
  `name_customer` varchar(30) COLLATE utf8_unicode_ci NOT NULL,
  `phone_customer` varchar(15) COLLATE utf8_unicode_ci NOT NULL,
  `address_customer` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  `date` varchar(20) COLLATE utf8_unicode_ci NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_invoice_device` (`id_device`),
  CONSTRAINT `fk_invoice_device` FOREIGN KEY (`id_device`) REFERENCES `device` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=134 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `invoice`
--

LOCK TABLES `invoice` WRITE;
/*!40000 ALTER TABLE `invoice` DISABLE KEYS */;
INSERT INTO `invoice` VALUES (94,36,1,21099999,'TRAN KHANH TUAN','0987654321','District 7','18/06/2018 11:42:18'),(95,35,1,21000000,'TRAN KHANH TUAN','0987654321','District 7','18/06/2018 11:43:17'),(96,38,1,76000000,'TRAN KHANH TUAN','0987654321','District 7','18/06/2018 11:43:34'),(97,36,1,21099999,'TRAN KHANH TUAN','0987654321','District 7','18/06/2018 11:45:50'),(98,36,1,21099999,'TRAN KHANH TUAN','0987654321','District 7','18/06/2018 11:51:54'),(99,36,1,21099999,'TRAN KHANH TUAN','0987654321','District 7','18/06/2018 12:29:15'),(100,36,1,21099999,'TRAN KHANH TUAN','0987654321','District 7','18/06/2018 12:30:15'),(101,37,1,98000000,'TRAN KHANH TUAN','0987654321','District 7','18/06/2018 13:44:07'),(102,38,1,76000000,'TRAN KHANH TUAN','0987654321','District 7','18/06/2018 13:44:47'),(103,35,1,21000000,'TRAN KHANH TUAN','0987654321','District 7','18/06/2018 13:46:34'),(104,36,1,21099999,'TRAN KHANH TUAN','0987654321','District 7','18/06/2018 13:48:27'),(105,36,1,21099999,'TRAN KHANH TUAN','0987654321','District 7','18/06/2018 13:52:18'),(106,36,1,21099999,'TRAN KHANH TUAN','0987654321','District 7','18/06/2018 13:54:33'),(107,36,1,21099999,'TRAN KHANH TUAN','0987654321','District 7','18/06/2018 13:55:50'),(108,45,1,67000000,'TRAN KHANH TUAN','0987654321','District 7','18/06/2018 13:58:07'),(109,37,1,98000000,'TRAN KHANH TUAN','0987654321','District 7','18/06/2018 13:59:06'),(110,37,1,98000000,'TRAN KHANH TUAN','0987654321','District 7','18/06/2018 14:05:38'),(111,37,1,98000000,'TRAN KHANH TUAN','0987654321','District 7','18/06/2018 14:07:22'),(112,36,1,21099999,'TRAN KHANH TUAN','0987654321','District 7','18/06/2018 14:10:22'),(113,37,1,98000000,'TRAN KHANH TUAN','0987654321','District 7','18/06/2018 14:20:24'),(114,37,1,98000000,'TRAN KHANH TUAN','0987654321','District 7','18/06/2018 14:21:20'),(115,37,1,98000000,'TRAN KHANH TUAN','0987654321','District 7','18/06/2018 14:29:54'),(116,38,1,76000000,'TRAN KHANH TUAN','0987654321','District 7','18/06/2018 14:31:36'),(117,36,1,21099999,'TRAN KHANH TUAN','0987654321','District 7','18/06/2018 14:33:31'),(118,36,1,21099999,'TRAN KHANH TUAN','0987654321','District 7','18/06/2018 14:33:58'),(119,36,1,21099999,'TRAN KHANH TUAN','0987654321','District 7','18/06/2018 14:34:38'),(120,36,1,21099999,'TRAN KHANH TUAN','0987654321','District 7','18/06/2018 14:35:14'),(121,37,1,98000000,'TRAN KHANH TUAN','0987654321','District 7','18/06/2018 14:35:57'),(122,36,1,21099999,'TRAN KHANH TUAN','0987654321','District 7','18/06/2018 14:36:35'),(123,37,1,98000000,'TRAN KHANH TUAN','0987654321','District 7','18/06/2018 14:38:02'),(124,36,1,21099999,'TRAN KHANH TUAN','0987654321','District 7','18/06/2018 14:38:54'),(125,37,1,98000000,'TRAN KHANH TUAN','0987654321','District 7','18/06/2018 14:41:13'),(126,36,1,21099999,'TRAN KHANH TUAN','0987654321','District 7','18/06/2018 14:42:45'),(127,36,1,21099999,'TRAN KHANH TUAN','0987654321','District 7','21/06/2018 09:09:58'),(128,46,1,43000000,'TRAN KHANH TUAN','0987654321','District 7','21/06/2018 10:30:48'),(129,36,1,21099999,'TRAN KHANH TUAN','0987654321','District 7','22/06/2018 10:15:20'),(130,36,1,21099999,'TRAN KHANH TUAN','0987654321','District 7','22/06/2018 10:15:47'),(131,47,1,320000000,'TRAN KHANH TUAN','0987654321','District 7','22/06/2018 15:11:59'),(132,35,1,21000000,'TRAN KHANH TUAN','0987654321','District 7','10/07/2018 09:36:54'),(133,35,1,21000000,'TRAN KHANH TUAN','0987654321','District 7','10/07/2018 10:39:02');
/*!40000 ALTER TABLE `invoice` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2018-07-11 13:48:42
