-- MySQL dump 10.13  Distrib 5.7.14, for Win64 (x86_64)
--
-- Host: localhost    Database: educator
-- ------------------------------------------------------
-- Server version	5.7.14

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
-- Current Database: `educator`
--

/*!40000 DROP DATABASE IF EXISTS `educator`*/;

CREATE DATABASE /*!32312 IF NOT EXISTS*/ `educator` /*!40100 DEFAULT CHARACTER SET latin1 */;

USE `educator`;

--
-- Table structure for table `account`
--

DROP TABLE IF EXISTS `account`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `account` (
  `C1` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `C2` varchar(225) DEFAULT NULL,
  `C3` varchar(225) DEFAULT NULL,
  `C4` varchar(225) DEFAULT NULL,
  `C5` varchar(225) DEFAULT NULL,
  `C6` varchar(225) DEFAULT NULL,
  `C7` varchar(225) DEFAULT NULL,
  `C8` varchar(225) DEFAULT NULL,
  UNIQUE KEY `C1` (`C1`)
) ENGINE=MyISAM AUTO_INCREMENT=5 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `account`
--

LOCK TABLES `account` WRITE;
/*!40000 ALTER TABLE `account` DISABLE KEYS */;
INSERT INTO `account` VALUES (1,'KAMRANQADEER','Installer','kamran.qadeer.26@gmail.com','0344-4200515','kamran9808kk','Deactive','Active'),(2,'NASIR','Admin','nasir@gmail.com','0344-4200515','kamrankk','Active','Active'),(3,'KAMRANKK','User','kk@gmail.com','0212-1221212','kamrankk','Deactive','Active'),(4,'AMJAD','User','amjad@gamilc.om','0344-4200515','kamrankk','Deactive','Active');
/*!40000 ALTER TABLE `account` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `attendance`
--

DROP TABLE IF EXISTS `attendance`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `attendance` (
  `C0` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `C1` varchar(225) DEFAULT NULL,
  `C2` varchar(225) DEFAULT NULL,
  `C3` varchar(225) DEFAULT NULL,
  `C4` varchar(225) DEFAULT NULL,
  `C5` varchar(225) DEFAULT NULL,
  `C6` varchar(225) DEFAULT NULL,
  `C7` varchar(225) DEFAULT NULL,
  `C8` varchar(225) DEFAULT NULL,
  `C9` varchar(225) DEFAULT NULL,
  UNIQUE KEY `C0` (`C0`)
) ENGINE=MyISAM AUTO_INCREMENT=10 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `attendance`
--

LOCK TABLES `attendance` WRITE;
/*!40000 ALTER TABLE `attendance` DISABLE KEYS */;
INSERT INTO `attendance` VALUES (1,'17:14:00','14','January','2021','2112','Nasir Anjum','Play Group','P','Non'),(2,'17:14:00','14','January','2021','2','Hina Zubair','Play Group','P','Non'),(3,'17:15:04','14','January','2021','21','Huma Zubair','Nursery','P','Non'),(4,'10:00:07','15','January','2021','2112','Nasir Anjum','Play Group','P','Non'),(5,'10:00:07','15','January','2021','2','Hina Zubair','Play Group','P','Non'),(6,'10:21:42','15','January','2021','21','Huma Zubair','Nursery','P','Non'),(7,'10:29:13','15','January','2021','1121','Hamza Khan','One 1','L','Non');
/*!40000 ALTER TABLE `attendance` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `book`
--

DROP TABLE IF EXISTS `book`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `book` (
  `C0` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `C1` varchar(225) DEFAULT NULL,
  `C2` varchar(225) DEFAULT NULL,
  `C3` varchar(225) DEFAULT NULL,
  `C4` varchar(225) DEFAULT NULL,
  `C5` varchar(225) DEFAULT NULL,
  `C6` varchar(225) DEFAULT NULL,
  UNIQUE KEY `C0` (`C0`)
) ENGINE=MyISAM AUTO_INCREMENT=26 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `book`
--

LOCK TABLES `book` WRITE;
/*!40000 ALTER TABLE `book` DISABLE KEYS */;
INSERT INTO `book` VALUES (25,'15','Nursery','Easy Math','Khoker','Its Easy For Students','2');
/*!40000 ALTER TABLE `book` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `classdetails`
--

DROP TABLE IF EXISTS `classdetails`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `classdetails` (
  `C0` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `C1` varchar(225) DEFAULT NULL,
  `C2` varchar(225) DEFAULT NULL,
  `C3` varchar(225) DEFAULT NULL,
  `C4` varchar(225) DEFAULT NULL,
  `C5` varchar(225) DEFAULT NULL,
  `C6` varchar(225) DEFAULT NULL,
  UNIQUE KEY `C0` (`C0`)
) ENGINE=MyISAM AUTO_INCREMENT=16 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `classdetails`
--

LOCK TABLES `classdetails` WRITE;
/*!40000 ALTER TABLE `classdetails` DISABLE KEYS */;
INSERT INTO `classdetails` VALUES (15,'Nursery','Math','212','100','40','5-Kamran Qadeer');
/*!40000 ALTER TABLE `classdetails` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `classes`
--

DROP TABLE IF EXISTS `classes`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `classes` (
  `C1` varchar(225) DEFAULT NULL,
  `C2` varchar(225) DEFAULT NULL,
  `C3` varchar(225) DEFAULT NULL,
  `C4` varchar(225) DEFAULT NULL,
  `C5` varchar(225) DEFAULT NULL,
  `C6` varchar(225) DEFAULT NULL,
  `C7` varchar(225) DEFAULT NULL,
  `C8` varchar(225) DEFAULT NULL,
  `C9` varchar(225) DEFAULT NULL,
  `C10` varchar(225) DEFAULT NULL,
  UNIQUE KEY `C1` (`C1`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `classes`
--

LOCK TABLES `classes` WRITE;
/*!40000 ALTER TABLE `classes` DISABLE KEYS */;
INSERT INTO `classes` VALUES ('Play Group','Not Yet','1000','1000','2000','1500','4000','1000','500','11000.0'),('Nursery','Not Yet','1000','2000','3000','2000','1000','1000','500','10500.0'),('K G','Not Yet','0','0','0','0','0','0','0','0'),('One 1','Not Yet','0','0','0','0','0','0','0','0'),('Two 2','Not Yet','0','0','0','0','0','0','0','0'),('Three 3','Not Yet','0','0','0','0','0','0','0','0'),('Four 4','Not Yet','0','0','0','0','0','0','0','0'),('Five 5','Not Yet','0','0','0','0','0','0','0','0'),('Six 6','Not Yet','0','0','0','0','0','0','0','0'),('Seven 7','Not Yet','0','0','0','0','0','0','0','0'),('Eight 8','Not Yet','0','0','0','0','0','0','0','0'),('Nine 9','Not Yet','0','0','0','0','0','0','0','0'),('Ten 10','Not Yet','0','0','0','0','0','0','0','0');
/*!40000 ALTER TABLE `classes` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `classfee`
--

DROP TABLE IF EXISTS `classfee`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `classfee` (
  `C1` varchar(225) DEFAULT NULL,
  `C2` varchar(225) DEFAULT NULL,
  `C3` varchar(225) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `classfee`
--

LOCK TABLES `classfee` WRITE;
/*!40000 ALTER TABLE `classfee` DISABLE KEYS */;
/*!40000 ALTER TABLE `classfee` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `employ`
--

DROP TABLE IF EXISTS `employ`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `employ` (
  `C1` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `C2` varchar(225) DEFAULT NULL,
  `C3` varchar(225) DEFAULT NULL,
  `C4` varchar(225) DEFAULT NULL,
  `C5` varchar(225) DEFAULT NULL,
  `C6` varchar(225) DEFAULT NULL,
  `C7` varchar(225) DEFAULT NULL,
  `C8` varchar(225) DEFAULT NULL,
  `C9` varchar(225) DEFAULT NULL,
  `C10` varchar(225) DEFAULT NULL,
  `C11` varchar(225) DEFAULT NULL,
  UNIQUE KEY `C1` (`C1`)
) ENGINE=MyISAM AUTO_INCREMENT=9 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `employ`
--

LOCK TABLES `employ` WRITE;
/*!40000 ALTER TABLE `employ` DISABLE KEYS */;
INSERT INTO `employ` VALUES (4,'07-January-2021','Kiran Qadeer','Islam','Fe-Male','Teacher','30000','kiran@gmail.com','0344-3982928','3829382938293','kldjsalkdjasldjasljddklajskldjasldj'),(2,'06-January-2021','Amna Ahmmad','Islam','Fe-Male','Teacher','2000','amna@gmail.com','0344-3923818','8371298379873','djklasdkljaldj'),(6,'08-January-2021','Juanid Ahmmad','Islam','Male','Teacher','6000','amna@gmail.com','0344-3923818','8371298379873','djklasdkljaldj'),(5,'07-January-2021','Kamran Qadeer','Islam','Male','Teacher','50000','Kamran.qadeer.26@gmail.com','0344-4200515','2817287182712','jkhjdhaskjhdskaj871983712'),(7,'08-January-2021','Zubair Ahammad','Islam','Male','Teacher','30000','kiran@gmail.com','0344-3982928','3829382938293','kldjsalkdjasldjasljddklajskldjasldj'),(8,'08-January-2021','Faiza Kanwal','Islam','Fe-Male','Teacher','30000','kiran@gmail.com','0344-3982928','3829382938293','kldjsalkdjasldjasljddklajskldjasldj');
/*!40000 ALTER TABLE `employ` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `employdetails`
--

DROP TABLE IF EXISTS `employdetails`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `employdetails` (
  `C1` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `C2` varchar(225) NOT NULL,
  `C3` varchar(225) NOT NULL,
  `C4` varchar(225) NOT NULL,
  `C5` varchar(225) NOT NULL,
  `C6` varchar(225) NOT NULL,
  UNIQUE KEY `C1` (`C1`)
) ENGINE=MyISAM AUTO_INCREMENT=8 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `employdetails`
--

LOCK TABLES `employdetails` WRITE;
/*!40000 ALTER TABLE `employdetails` DISABLE KEYS */;
INSERT INTO `employdetails` VALUES (2,'5','BSSE Engineering ','IIUI','Complete','87 %'),(6,'3','MS Islamyat','Open University Isalamabd','Complete','93 %'),(7,'8','Doctor','Shafa Internation','Complete','81 %');
/*!40000 ALTER TABLE `employdetails` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `employsalary`
--

DROP TABLE IF EXISTS `employsalary`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `employsalary` (
  `C1` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `C2` varchar(225) DEFAULT NULL,
  `C3` varchar(225) DEFAULT NULL,
  `C4` varchar(225) DEFAULT NULL,
  `C5` varchar(225) DEFAULT NULL,
  `C6` varchar(225) DEFAULT NULL,
  `C7` varchar(225) DEFAULT NULL,
  `C8` varchar(225) DEFAULT NULL,
  `C9` varchar(225) DEFAULT NULL,
  `C10` varchar(225) DEFAULT NULL,
  `C11` varchar(225) DEFAULT NULL,
  `C12` varchar(225) DEFAULT NULL,
  `C13` varchar(225) DEFAULT NULL,
  `C14` varchar(225) DEFAULT NULL,
  `C15` varchar(225) DEFAULT NULL,
  UNIQUE KEY `C1` (`C1`)
) ENGINE=MyISAM AUTO_INCREMENT=7 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `employsalary`
--

LOCK TABLES `employsalary` WRITE;
/*!40000 ALTER TABLE `employsalary` DISABLE KEYS */;
INSERT INTO `employsalary` VALUES (1,'08','January','2021','4','30000','Don','0','0','0','0','Punctual and good performance','0','30000','.0'),(2,'08','January','2021','2','2000','Some','0','0','0','0','Punctual and good performance','0','1000','1000.0'),(3,'08','January','2021','5','50000','Some','0','0','0','0','Good','0','20000','30000.0'),(4,'08','January','2021','6','60000','Some','0','0','0','0','Punctual and good performance','0','2000','58000.0'),(5,'08','January','2021','7','30000','Not','0','0','0','0','0','0','0','30000'),(6,'08','January','2021','8','30000','Some','0','0','0','0','Punctual and good performance','0','10000','20000.0');
/*!40000 ALTER TABLE `employsalary` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `feestructure`
--

DROP TABLE IF EXISTS `feestructure`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `feestructure` (
  `C0` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `C1` varchar(225) DEFAULT NULL,
  `C2` varchar(225) DEFAULT NULL,
  `C3` varchar(225) DEFAULT NULL,
  `C4` varchar(225) DEFAULT NULL,
  `C5` varchar(225) DEFAULT NULL,
  `C6` varchar(225) DEFAULT NULL,
  `C7` varchar(225) DEFAULT NULL,
  `C8` varchar(225) DEFAULT NULL,
  `C9` varchar(225) DEFAULT NULL,
  `C10` varchar(225) DEFAULT NULL,
  `C11` varchar(225) DEFAULT NULL,
  `C12` varchar(225) DEFAULT NULL,
  `C13` varchar(225) DEFAULT NULL,
  `C14` varchar(225) DEFAULT NULL,
  UNIQUE KEY `C0` (`C0`)
) ENGINE=MyISAM AUTO_INCREMENT=92 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `feestructure`
--

LOCK TABLES `feestructure` WRITE;
/*!40000 ALTER TABLE `feestructure` DISABLE KEYS */;
INSERT INTO `feestructure` VALUES (79,'12','January','2021','21','Lab Chargers Fee','0','0','0','0','0','0','0','Not',NULL),(78,'12','January','2021','21','Examination Fee','0','0','0','0','0','0','0','Not',NULL),(77,'12','January','2021','21','Registration Fee','0','0','0','0','0','0','0','Not',NULL),(76,'12','January','2021','21','Tuition Fee','0','0','0','0','0','0','0','Not',NULL),(73,'12','January','2021','21','Annual Fund','0','0','0','0','0','0','0','Not',NULL),(74,'12','January','2021','21','Sunmmer Task','0','0','0','0','0','0','0','Not',NULL),(75,'12','January','2021','21','Monthly Fee','0','0','0','0','0','0','0','Not',NULL),(80,'12','January','2021','2','Annual Fund','1000','10.0','100','0','900.0','900','.0','Don','13/January/2021'),(81,'12','January','2021','2','Sunmmer Task','1000','.0','0','0','1000.0','1000','.0','Don','13/January/2021'),(82,'12','January','2021','2','Monthly Fee','2000','.0','0','0','2000.0','2000','.0','Don','13/January/2021'),(83,'12','January','2021','2','Tuition Fee','1500','.0','0','0','1500.0','1500','.0','Don','13/January/2021'),(84,'12','January','2021','2','Registration Fee','4000','.0','0','0','4000.0','4000','.0','Don','13/January/2021'),(85,'12','January','2021','2','Examination Fee','1000','.0','0','0','1000.0','10000','0','Don','13/January/2021'),(86,'12','January','2021','2','Lab Chargers Fee','500','.0','0','0','500.0','500','.0','Don','13/January/2021'),(89,'13','January','2021','2','Annual Fund','1000','10.0','100','0','900.0','900','.0','Don','13/January/2021'),(91,'14','January','2021','2112','Monthly Fee','1000','.0','0','0','1000.0','1000','.0','Don','15/January/2021');
/*!40000 ALTER TABLE `feestructure` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `student`
--

DROP TABLE IF EXISTS `student`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `student` (
  `C1` varchar(225) NOT NULL,
  `C2` varchar(225) DEFAULT NULL,
  `C3` varchar(225) DEFAULT NULL,
  `C4` varchar(225) DEFAULT NULL,
  `C5` varchar(225) DEFAULT NULL,
  `C6` varchar(225) DEFAULT NULL,
  `C7` varchar(225) DEFAULT NULL,
  `C8` varchar(225) DEFAULT NULL,
  `C9` varchar(225) DEFAULT NULL,
  `C10` varchar(225) DEFAULT NULL,
  `C11` varchar(225) DEFAULT NULL,
  `C12` varchar(225) DEFAULT NULL,
  `C13` varchar(225) DEFAULT NULL,
  `C14` varchar(225) DEFAULT NULL,
  `C15` varchar(225) DEFAULT NULL,
  `C16` varchar(225) DEFAULT NULL,
  `C17` varchar(225) DEFAULT NULL,
  `C18` varchar(225) DEFAULT NULL,
  `C19` varchar(225) DEFAULT NULL,
  `C20` varchar(225) DEFAULT NULL,
  `C21` varchar(225) DEFAULT NULL,
  PRIMARY KEY (`C1`),
  UNIQUE KEY `C1` (`C1`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `student`
--

LOCK TABLES `student` WRITE;
/*!40000 ALTER TABLE `student` DISABLE KEYS */;
INSERT INTO `student` VALUES ('21','8219837','Huma Zubair','03/January/2008','Pakistan','Islam','Qurshi','Male','8974983472','Nursery','Non','Zubair','8974349284798','Wah Cantt','non','zubair@gmail.com','0344-8974238','0344-3749287','Urdu','12/January/2021','Not'),('2','12121212','Hina Zubair','04/January/2013','Pakistan','Islam','Pakist','Male','non','Play Group','Non','Zubair Ahmmad','8731897312897','Wah Cantt','non','zubair@gmail.com','0344-8320981','0344-9821093','urdu','12/January/2021','Don'),('1121','81821098','Hamza Khan','06/January/2006','Pakistan','Islam','Qurshi','Male','Jina Hall','One 1','Non','Khan Ali','3128798738912','Dhamyal Camp','non','khan@gamil.com','0344-9378921','0344-2389721','Pashto Urdu English','14/January/2021','Don'),('273','38721897','Sohail Asghar','11/January/2007','Pakistan','Islam','Pakhtoon','Male','IIUI','Ten 10','Non','Ashgar','8372891791287','Pindi','non','sohail2898@gmail.com','0344-8371289','0344-3829173','Pashto','03/January/2019','Don'),('2112','23123','Nasir Anjum','14/January/2021','Pakistan','Islam','non','Male','non','Play Group','Non','Anjum','3872189893721','Dhamyl','non','Anjhum@gamil.com','0344-8738217','0344-2897238','non','01/January/2020','Don');
/*!40000 ALTER TABLE `student` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `subject`
--

DROP TABLE IF EXISTS `subject`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `subject` (
  `C1` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `C2` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `C3` varchar(225) DEFAULT NULL,
  `C4` varchar(225) DEFAULT NULL,
  `C5` varchar(225) DEFAULT NULL,
  `C6` varchar(225) DEFAULT NULL,
  UNIQUE KEY `C1` (`C1`)
) ENGINE=MyISAM AUTO_INCREMENT=22 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `subject`
--

LOCK TABLES `subject` WRITE;
/*!40000 ALTER TABLE `subject` DISABLE KEYS */;
INSERT INTO `subject` VALUES (21,'2021-01-05 09:33:39','Computer 10th','computer301','100','40'),(3,'2021-01-03 13:08:59','Computer','Computer_1','100','40'),(17,'2021-01-04 05:58:33','Urdu','123','200','100'),(18,'2021-01-04 06:01:08','UrduB','urduB123131','200','200'),(20,'2021-01-04 06:11:35','Mathamatics','math30','100','40');
/*!40000 ALTER TABLE `subject` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2021-01-15 17:59:15
