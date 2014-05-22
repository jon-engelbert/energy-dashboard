-- MySQL dump 10.13  Distrib 5.5.9, for Win32 (x86)
--
-- Host: localhost    Database: energy
-- ------------------------------------------------------
-- Server version	5.5.15

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
-- Current Database: `energy`
--

CREATE DATABASE /*!32312 IF NOT EXISTS*/ `energy` /*!40100 DEFAULT CHARACTER SET latin1 */;

USE `energy`;

--
-- Table structure for table `bills`
--

DROP TABLE IF EXISTS `bills`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `bills` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `fiscalYear` int(11) DEFAULT NULL,
  `fiscalMonth` int(11) DEFAULT NULL,
  `dateStart` date DEFAULT NULL,
  `dateEnd` date DEFAULT NULL,
  `readStart` int(11) DEFAULT NULL,
  `readEnd` int(11) DEFAULT NULL,
  `amount` float NOT NULL COMMENT 'kwh of electricity, or btu of gas, or ccf of water.  Same as Usage',
  `cost` decimal(10,2) NOT NULL COMMENT 'invoice total',
  `internalID` varchar(45) DEFAULT NULL,
  `pdf_id` int(11) DEFAULT NULL,
  `meters_id` int(11) NOT NULL,
  `multiplier` float DEFAULT NULL COMMENT 'Perhaps used to calculate the amount?- I don''t think that this is used in pricing calculations.',
  `demand` float DEFAULT NULL COMMENT 'on-peak demand power, charged at high rate',
  `peakDemand` float DEFAULT NULL COMMENT 'on-peak demand power, charged at high rate',
  `powerFactor` float DEFAULT NULL COMMENT 'sometimes there is a penalty for poor power factor',
  `kva` float DEFAULT NULL,
  `loadFactor` float DEFAULT NULL,
  `costDemand` decimal(10,2) DEFAULT NULL COMMENT 'cost resulting from peak demand power usage',
  `costUsage` decimal(10,2) DEFAULT NULL COMMENT 'cost for using the amount field or "usage"',
  `costDistDemand` decimal(10,2) DEFAULT NULL COMMENT 'charge for distribution of peak demand power',
  `costDistUsage` decimal(10,2) DEFAULT NULL COMMENT 'charge for distribution of energy usage (not multiplier)',
  `surchargeAsPercent` decimal(10,2) DEFAULT NULL COMMENT 'sum of all surcharges based on a percent of usage',
  `taxAmount` decimal(10,2) DEFAULT NULL COMMENT 'tax amount in $, for tax rate divide total charges by tax amount.\n',
  `surchargeFixed` decimal(10,2) DEFAULT NULL COMMENT 'sum of fixed surcharges',
  `usageThreshold` int(11) DEFAULT NULL COMMENT 'amount of usage above which the price is "CostAboveThreshold" (for natural gas?)',
  `CostAboveThreshold` decimal(10,2) DEFAULT NULL COMMENT 'The cost for usage in excess of "CostAboveThreshold" (for natural gas?)',
  `OffPeakEnergy` int(11) DEFAULT NULL,
  `OffPeakDiscount` decimal(10,2) DEFAULT NULL,
  `IsBasedOnOriginalModel` tinyint(1) DEFAULT NULL COMMENT 'If true, then this bill is NOT based on actual meter readings, but based on predictions from the original building model based in part on HDD and CDD.',
  PRIMARY KEY (`id`),
  KEY `fk_bills_pdf` (`pdf_id`),
  KEY `fk_bills_meters1` (`meters_id`)
) ENGINE=InnoDB AUTO_INCREMENT=167 DEFAULT CHARSET=latin1 ROW_FORMAT=COMPACT;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `bills`
--

LOCK TABLES `bills` WRITE;
/*!40000 ALTER TABLE `bills` DISABLE KEYS */;
INSERT INTO `bills` VALUES (69,2009,1,'2008-08-08','2008-09-08',NULL,NULL,18000,99.00,'1234926025_2009_1',NULL,1,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0),(70,2009,10,'2009-05-11','2009-06-09',NULL,NULL,16200,99.00,'1234926025_2009_10',NULL,1,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0),(71,2009,11,'2009-06-09','2009-07-09',NULL,NULL,17400,99.00,'1234926025_2009_11',NULL,1,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0),(72,2009,12,'2009-07-09','2009-08-10',NULL,NULL,18600,99.00,'1234926025_2009_12',NULL,1,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0),(73,2009,2,'2008-09-08','2008-10-07',NULL,NULL,17400,99.00,'1234926025_2009_2',NULL,1,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0),(74,2009,3,'2008-10-07','2008-11-06',NULL,NULL,20400,99.00,'1234926025_2009_3',NULL,1,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0),(75,2009,4,'2008-11-06','2008-12-10',NULL,NULL,27000,99.00,'1234926025_2009_4',NULL,1,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0),(76,2009,5,'2008-12-10','2009-01-09',NULL,NULL,22200,99.00,'1234926025_2009_5',NULL,1,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0),(77,2009,6,'2009-01-09','2009-02-06',NULL,NULL,25200,99.00,'1234926025_2009_6',NULL,1,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0),(78,2009,7,'2009-02-06','2009-03-10',NULL,NULL,25200,99.00,'1234926025_2009_7',NULL,1,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0),(79,2009,8,'2009-03-10','2009-04-08',NULL,NULL,23400,99.00,'1234926025_2009_8',NULL,1,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0),(80,2009,9,'2009-04-08','2009-05-11',NULL,NULL,22200,99.00,'1234926025_2009_9',NULL,1,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0),(81,2010,1,'2009-08-10','2009-09-09',NULL,NULL,18000,99.00,'1234926025_2010_1',NULL,1,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,1),(82,2010,10,'2010-05-11','2010-06-09',NULL,NULL,13800,99.00,'1234926025_2010_10',NULL,1,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,1),(83,2010,11,'2010-06-10','2010-07-11',NULL,NULL,15600,99.00,'1234926025_2010_11',NULL,1,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,1),(84,2010,12,'2010-07-11','2010-08-09',NULL,NULL,15600,99.00,'1234926025_2010_12',NULL,1,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,1),(85,2010,2,'2009-09-09','2009-10-08',NULL,NULL,16800,99.00,'1234926025_2010_2',NULL,1,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,1),(86,2010,3,'2009-10-08','2009-11-09',NULL,NULL,20400,99.00,'1234926025_2010_3',NULL,1,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,1),(87,2010,4,'2009-11-09','2009-12-09',NULL,NULL,22200,99.00,'1234926025_2010_4',NULL,1,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,1),(88,2010,5,'2009-12-09','2010-01-11',NULL,NULL,27600,99.00,'1234926025_2010_5',NULL,1,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,1),(89,2010,6,'2010-01-11','2010-02-08',NULL,NULL,24000,99.00,'1234926025_2010_6',NULL,1,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,1),(90,2010,7,'2010-02-09','2010-03-10',NULL,NULL,27000,99.00,'1234926025_2010_7',NULL,1,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,1),(91,2010,8,'2010-03-11','2010-04-11',NULL,NULL,18000,99.00,'1234926025_2010_8',NULL,1,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,1),(92,2010,9,'2010-04-12','2010-05-10',NULL,NULL,13800,99.00,'1234926025_2010_9',NULL,1,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,1),(93,2009,1,'2008-08-01','2008-09-02',NULL,NULL,21,99.00,'1455584_2009_1',NULL,2,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0),(94,2009,10,'2009-05-04','2009-06-03',NULL,NULL,20,99.00,'1455584_2009_10',NULL,2,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0),(95,2009,11,'2009-06-03','2009-07-02',NULL,NULL,19,99.00,'1455584_2009_11',NULL,2,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0),(96,2009,12,'2009-07-02','2009-08-04',NULL,NULL,11,99.00,'1455584_2009_12',NULL,2,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0),(97,2009,2,'2008-09-02','2008-09-30',NULL,NULL,18,99.00,'1455584_2009_2',NULL,2,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0),(98,2009,3,'2008-09-30','2008-10-29',NULL,NULL,507,99.00,'1455584_2009_3',NULL,2,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0),(99,2009,4,'2008-10-29','2008-12-01',NULL,NULL,255,99.00,'1455584_2009_4',NULL,2,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0),(100,2009,5,'2008-12-01','2009-01-02',NULL,NULL,330,99.00,'1455584_2009_5',NULL,2,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0),(101,2009,6,'2009-01-02','2009-02-02',NULL,NULL,7298,99.00,'1455584_2009_6',NULL,2,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0),(102,2009,7,'2009-02-02','2009-03-04',NULL,NULL,2841,99.00,'1455584_2009_7',NULL,2,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0),(103,2009,8,'2009-03-04','2009-04-03',NULL,NULL,3012,99.00,'1455584_2009_8',NULL,2,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0),(104,2009,9,'2009-04-03','2009-05-04',NULL,NULL,1414,99.00,'1455584_2009_9',NULL,2,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0),(105,2010,1,'2009-08-04','2009-09-02',NULL,NULL,1,99.00,'1455584_2010_1',NULL,2,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,1),(106,2010,10,'2010-05-05','2010-06-02',NULL,NULL,10,99.00,'1455584_2010_10',NULL,2,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,1),(107,2010,11,'2010-06-02','2010-07-01',NULL,NULL,30,99.00,'1455584_2010_11',NULL,2,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,1),(108,2010,12,'2010-07-01','2010-08-01',NULL,NULL,0,0.00,'1455584_2010_12',NULL,2,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,1),(109,2010,2,'2009-09-02','2009-10-01',NULL,NULL,0,99.00,'1455584_2010_2',NULL,2,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,1),(110,2010,3,'2009-10-01','2009-10-30',NULL,NULL,343,99.00,'1455584_2010_3',NULL,2,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,1),(111,2010,4,'2009-10-30','2009-12-02',NULL,NULL,1324,99.00,'1455584_2010_4',NULL,2,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,1),(112,2010,5,'2009-12-02','2010-01-07',NULL,NULL,2295,99.00,'1455584_2010_5',NULL,2,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,1),(113,2010,6,'2010-01-07','2010-02-02',NULL,NULL,4190,99.00,'1455584_2010_6',NULL,2,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,1),(114,2010,7,'2010-02-02','2010-03-03',NULL,NULL,6540,99.00,'1455584_2010_7',NULL,2,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,1),(115,2010,8,'2010-03-03','2010-04-05',NULL,NULL,2390,99.00,'1455584_2010_8',NULL,2,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,1),(116,2010,9,'2010-04-05','2010-05-05',NULL,NULL,20,99.00,'1455584_2010_9',NULL,2,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,1),(118,2009,1,'2008-07-29','2008-08-27',NULL,NULL,9.38,92.00,'47668233_2009_1',NULL,11,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0),(119,2009,10,'2009-04-29','2009-05-31',NULL,NULL,37.52,76.00,'47668233_2009_10',NULL,11,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0),(120,2009,11,'2009-05-31','2009-06-29',NULL,NULL,10.72,39.00,'47668233_2009_11',NULL,11,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0),(121,2009,12,'2009-06-29','2009-07-29',NULL,NULL,9.38,37.00,'47668233_2009_12',NULL,11,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0),(122,2009,2,'2008-08-27','2008-09-28',NULL,NULL,8.04,90.00,'47668233_2009_2',NULL,11,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0),(123,2009,3,'2008-09-28','2008-10-27',NULL,NULL,73.7,99.00,'47668233_2009_3',NULL,11,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0),(124,2009,4,'2008-10-27','2008-11-25',NULL,NULL,367.16,99.00,'47668233_2009_4',NULL,11,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0),(125,2009,5,'2008-11-25','2008-12-30',NULL,NULL,834.82,99.00,'47668233_2009_5',NULL,11,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0),(126,2009,6,'2008-12-30','2009-02-01',NULL,NULL,1113.54,99.00,'47668233_2009_6',NULL,11,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0),(127,2009,7,'2009-02-01','2009-03-02',NULL,NULL,714.22,99.00,'47668233_2009_7',NULL,11,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0),(128,2009,8,'2009-03-02','2009-03-31',NULL,NULL,443.54,99.00,'47668233_2009_8',NULL,11,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0),(129,2009,9,'2009-03-31','2009-04-29',NULL,NULL,217.08,99.00,'47668233_2009_9',NULL,11,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0),(130,2010,1,'2009-07-29','2009-08-27',NULL,NULL,14.74,44.00,'47668233_2010_1',NULL,11,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,1),(131,2010,10,'2010-04-28','2010-05-27',NULL,NULL,22.78,56.00,'47668233_2010_10',NULL,11,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,1),(132,2010,11,'2010-05-27','2010-06-28',NULL,NULL,81.74,99.00,'47668233_2010_11',NULL,11,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,1),(133,2010,12,'2010-06-28','2010-07-28',NULL,NULL,10.72,39.00,'47668233_2010_12',NULL,11,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,1),(134,2010,2,'2009-08-27','2009-09-28',NULL,NULL,5.36,32.00,'47668233_2010_2',NULL,11,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,1),(135,2010,3,'2009-09-28','2009-10-27',NULL,NULL,124.62,99.00,'47668233_2010_3',NULL,11,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,1),(136,2010,4,'2009-10-27','2009-11-29',NULL,NULL,314.9,99.00,'47668233_2010_4',NULL,11,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,1),(137,2010,5,'2009-11-29','2009-12-30',NULL,NULL,897.8,99.00,'47668233_2010_5',NULL,11,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,1),(138,2010,6,'2009-12-30','2010-01-31',NULL,NULL,1072,99.00,'47668233_2010_6',NULL,11,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,1),(139,2010,7,'2010-01-31','2010-03-01',NULL,NULL,1058.6,99.00,'47668233_2010_7',NULL,11,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,1),(140,2010,8,'2010-03-01','2010-03-30',NULL,NULL,542.7,99.00,'47668233_2010_8',NULL,11,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,1),(141,2010,9,'2010-03-30','2010-04-28',NULL,NULL,99.16,99.00,'47668233_2010_9',NULL,11,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,1),(142,2009,1,'2008-07-30','2008-08-28',NULL,NULL,149964,99.00,'777999851_2009_1',NULL,14,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0),(143,2009,10,'2009-04-30','2009-05-30',NULL,NULL,143289,99.00,'777999851_2009_10',NULL,14,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0),(144,2009,11,'2009-05-30','2009-06-30',NULL,NULL,47856,99.00,'777999851_2009_11',NULL,14,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0),(145,2009,12,'2009-06-30','2009-07-30',NULL,NULL,54209,99.00,'777999851_2009_12',NULL,14,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0),(146,2009,2,'2008-08-28','2008-09-27',NULL,NULL,169741,99.00,'777999851_2009_2',NULL,14,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0),(147,2009,3,'2008-09-27','2008-10-28',NULL,NULL,157799,99.00,'777999851_2009_3',NULL,14,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0),(148,2009,4,'2008-10-28','2008-11-26',NULL,NULL,147015,99.00,'777999851_2009_4',NULL,14,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0),(149,2009,5,'2008-11-26','2008-12-31',NULL,NULL,168785,99.00,'777999851_2009_5',NULL,14,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0),(150,2009,6,'2008-12-31','2009-01-31',NULL,NULL,163171,99.00,'777999851_2009_6',NULL,14,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0),(151,2009,7,'2009-01-31','2009-03-03',NULL,NULL,151903,99.00,'777999851_2009_7',NULL,14,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0),(152,2009,8,'2009-03-03','2009-04-01',NULL,NULL,134545,99.00,'777999851_2009_8',NULL,14,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0),(153,2009,9,'2009-04-01','2009-04-30',NULL,NULL,139339,99.00,'777999851_2009_9',NULL,14,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0),(154,2010,1,'2009-07-30','2009-08-28',NULL,NULL,116961,99.00,'777999851_2010_1',NULL,14,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,1),(155,2010,10,'2010-04-29','2010-05-28',NULL,NULL,138590,99.00,'777999851_2010_10',NULL,14,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,1),(156,2010,11,'2010-05-28','2010-06-29',NULL,NULL,206292,99.00,'777999851_2010_11',NULL,14,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,1),(157,2010,12,'2010-06-29','2010-07-29',NULL,NULL,207402,99.00,'777999851_2010_12',NULL,14,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,1),(158,2010,2,'2009-08-28','2009-09-29',NULL,NULL,77525,99.00,'777999851_2010_2',NULL,14,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,1),(159,2010,3,'2009-09-29','2009-10-28',NULL,NULL,131024,99.00,'777999851_2010_3',NULL,14,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,1),(160,2010,4,'2009-10-28','2009-11-30',NULL,NULL,156651,99.00,'777999851_2010_4',NULL,14,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,1),(161,2010,5,'2009-11-30','2009-12-31',NULL,NULL,180868,99.00,'777999851_2010_5',NULL,14,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,1),(162,2010,6,'2009-12-31','2010-02-01',NULL,NULL,166523,99.00,'777999851_2010_6',NULL,14,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,1),(163,2010,7,'2010-02-01','2010-03-02',NULL,NULL,170980,99.00,'777999851_2010_7',NULL,14,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,1),(164,2010,8,'2010-03-02','2010-03-31',NULL,NULL,164650,99.00,'777999851_2010_8',NULL,14,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,1),(165,2010,9,'2010-03-31','2010-04-29',NULL,NULL,163498,99.00,'777999851_2010_9',NULL,14,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,1),(166,0,0,'2011-01-01','2011-01-15',NULL,NULL,1234,123.00,'0',NULL,1,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL);
/*!40000 ALTER TABLE `bills` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `circuit`
--

DROP TABLE IF EXISTS `circuit`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `circuit` (
  `idCircuit` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(45) DEFAULT NULL,
  `EndUseDescription` varchar(45) DEFAULT NULL,
  `IsInput` tinyint(1) DEFAULT NULL,
  `Phase` int(11) DEFAULT NULL,
  `Panel_idPanel` int(11) NOT NULL,
  `multiCircuitMeter_idmultiCircuitMeter` int(11) DEFAULT NULL,
  `meterBranchNo` int(11) DEFAULT '-1',
  `zones_idzones` int(11) DEFAULT NULL,
  `endusecategory_idEndUseCategory` int(11) NOT NULL,
  `equipment_idEquipment` int(11) NOT NULL,
  `isMultipleZones` tinyint(1) DEFAULT NULL,
  `isMultipleEndUses` tinyint(1) DEFAULT NULL,
  `isMultipleEquipments` tinyint(1) DEFAULT NULL,
  PRIMARY KEY (`idCircuit`),
  KEY `fk_Circuit_Panel1` (`Panel_idPanel`),
  KEY `fk_Circuit_multiCircuitMeter1` (`multiCircuitMeter_idmultiCircuitMeter`),
  KEY `fk_circuit_zones1` (`zones_idzones`),
  KEY `fk_circuit_endusecategory1` (`endusecategory_idEndUseCategory`),
  KEY `fk_circuit_equipment1` (`equipment_idEquipment`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `circuit`
--

LOCK TABLES `circuit` WRITE;
/*!40000 ALTER TABLE `circuit` DISABLE KEYS */;
INSERT INTO `circuit` VALUES (1,NULL,NULL,1,2,4,1,1234,3,3,1,NULL,NULL,NULL),(2,NULL,NULL,1,2,4,1,1234,3,3,1,NULL,NULL,NULL),(3,'testname',NULL,1,2,4,1,1234,3,2,1,NULL,NULL,NULL),(4,'testname2',NULL,1,3,2,1,1234,1,1,1,NULL,NULL,NULL),(5,'testname2',NULL,0,1,6,2,1234,6,3,1,NULL,NULL,NULL);
/*!40000 ALTER TABLE `circuit` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `circuit_has_endusecategory`
--

DROP TABLE IF EXISTS `circuit_has_endusecategory`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `circuit_has_endusecategory` (
  `Circuit_idCircuit` int(11) NOT NULL,
  `EndUseCategory_idEndUseCategory` int(11) NOT NULL,
  `percent` int(11) DEFAULT NULL,
  PRIMARY KEY (`Circuit_idCircuit`,`EndUseCategory_idEndUseCategory`),
  KEY `fk_Circuit_has_EndUseCategory_EndUseCategory1` (`EndUseCategory_idEndUseCategory`),
  KEY `fk_Circuit_has_EndUseCategory_Circuit1` (`Circuit_idCircuit`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `circuit_has_endusecategory`
--

LOCK TABLES `circuit_has_endusecategory` WRITE;
/*!40000 ALTER TABLE `circuit_has_endusecategory` DISABLE KEYS */;
/*!40000 ALTER TABLE `circuit_has_endusecategory` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `circuit_has_equipment`
--

DROP TABLE IF EXISTS `circuit_has_equipment`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `circuit_has_equipment` (
  `Circuit_idCircuit` int(11) NOT NULL,
  `Equipment_idEquipment` int(11) NOT NULL,
  `percent` int(11) DEFAULT NULL,
  PRIMARY KEY (`Circuit_idCircuit`,`Equipment_idEquipment`),
  KEY `fk_Circuit_has_Equipment_Equipment1` (`Equipment_idEquipment`),
  KEY `fk_Circuit_has_Equipment_Circuit1` (`Circuit_idCircuit`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `circuit_has_equipment`
--

LOCK TABLES `circuit_has_equipment` WRITE;
/*!40000 ALTER TABLE `circuit_has_equipment` DISABLE KEYS */;
/*!40000 ALTER TABLE `circuit_has_equipment` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `circuit_has_zones`
--

DROP TABLE IF EXISTS `circuit_has_zones`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `circuit_has_zones` (
  `Circuit_idCircuit` int(11) NOT NULL,
  `zones_idzones` int(11) NOT NULL,
  `percent` int(11) DEFAULT NULL,
  PRIMARY KEY (`Circuit_idCircuit`,`zones_idzones`),
  KEY `fk_Circuit_has_zones_zones1` (`zones_idzones`),
  KEY `fk_Circuit_has_zones_Circuit1` (`Circuit_idCircuit`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `circuit_has_zones`
--

LOCK TABLES `circuit_has_zones` WRITE;
/*!40000 ALTER TABLE `circuit_has_zones` DISABLE KEYS */;
/*!40000 ALTER TABLE `circuit_has_zones` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `client`
--

DROP TABLE IF EXISTS `client`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `client` (
  `idClient` int(11) NOT NULL AUTO_INCREMENT,
  `Name` varchar(45) DEFAULT NULL,
  `PercentMaxLightSetting` int(11) DEFAULT NULL COMMENT 'Percent of maximum lighting, proposed or current (updated when new settings are accepted)',
  `PercentMaxLightOriginal` int(11) DEFAULT NULL COMMENT 'percent of maximum lighting, original (before retrofit)',
  `origSetpointCoolOcc` int(11) DEFAULT NULL COMMENT 'original cooling setpoint for occupied intervals',
  `origSetpointCoolUnocc` int(11) DEFAULT NULL COMMENT 'original cooling setpoint for unoccupied intervals',
  `origSetpointHeatOcc` int(11) DEFAULT NULL COMMENT 'original heating setpoint for occupied intervals',
  `origSetpointHeatUnocc` int(11) DEFAULT NULL COMMENT 'original heating setpoint for unoccupied intervals',
  `setpointCoolOcc` int(11) DEFAULT NULL COMMENT 'cooling setpoint for occupied intervals',
  `setpointHeatOcc` int(11) DEFAULT NULL COMMENT 'heating setpoint for occupied intervals',
  `setpointHeatUnocc` int(11) DEFAULT NULL COMMENT 'heating setpoint for unoccupied intervals',
  `setpointCoolUnocc` int(11) DEFAULT NULL COMMENT 'cooling setpoint for unoccupied intervals',
  PRIMARY KEY (`idClient`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `client`
--

LOCK TABLES `client` WRITE;
/*!40000 ALTER TABLE `client` DISABLE KEYS */;
INSERT INTO `client` VALUES (1,'McKinley',100,100,75,82,72,62,75,72,62,82),(2,'Walmart',1,2,5,3,6,4,9,10,8,7);
/*!40000 ALTER TABLE `client` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `delivery`
--

DROP TABLE IF EXISTS `delivery`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `delivery` (
  `idDelivery` int(11) NOT NULL AUTO_INCREMENT,
  `amount` varchar(45) NOT NULL,
  `date` date NOT NULL,
  `cost` int(11) DEFAULT NULL,
  `bills_id` int(11) NOT NULL,
  PRIMARY KEY (`idDelivery`),
  KEY `fk_Delivery_bills1` (`bills_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='deliveries and pickups';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `delivery`
--

LOCK TABLES `delivery` WRITE;
/*!40000 ALTER TABLE `delivery` DISABLE KEYS */;
/*!40000 ALTER TABLE `delivery` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `endusecategory`
--

DROP TABLE IF EXISTS `endusecategory`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `endusecategory` (
  `idEndUseCategory` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(45) DEFAULT NULL,
  `parentCategory` int(11) DEFAULT NULL,
  PRIMARY KEY (`idEndUseCategory`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `endusecategory`
--

LOCK TABLES `endusecategory` WRITE;
/*!40000 ALTER TABLE `endusecategory` DISABLE KEYS */;
INSERT INTO `endusecategory` VALUES (1,'HVAC',NULL),(2,'Lighting',NULL),(3,'Plug Loads',NULL),(4,'Miscellaneous',NULL);
/*!40000 ALTER TABLE `endusecategory` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `energy`
--

DROP TABLE IF EXISTS `energy`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `energy` (
  `idEnergy` int(11) NOT NULL AUTO_INCREMENT,
  `lightPowerBaseOcc` int(11) DEFAULT NULL COMMENT 'the base light power during occupied times.  Actually, max power during occupied times (in kW)',
  `lightPowerBaseUnOcc` int(11) DEFAULT NULL COMMENT 'the base light power during unoccupied times. (Max power during unoccupied times) (in kW)',
  `PercentMaxLightSetting` int(11) DEFAULT NULL COMMENT 'Percent of maximum lighting, proposed or current?  This is updated when the new setting is accepted.',
  `PercentMaxLightOriginal` int(10) unsigned DEFAULT NULL COMMENT 'percent of maximum lighting, original (probably 100%)',
  `IsOnWhenDark` tinyint(1) DEFAULT NULL COMMENT 'For lights, on when dark outside',
  `IsWholeBuilding` tinyint(1) DEFAULT NULL COMMENT 'If true, then this energy record is for a whole building (not a sub-zone)',
  `origSetpointCoolOcc` int(11) DEFAULT NULL COMMENT 'original cooling setpoint for occupied times',
  `origSetpointCoolUnocc` int(11) DEFAULT NULL COMMENT 'original cooling setpoint for unoccupied times',
  `origSetpointHeatOcc` int(11) DEFAULT NULL COMMENT 'original heating setpoint for occupied times',
  `origSetpointHeatUnocc` int(11) DEFAULT NULL COMMENT 'original heating setpoint for unoccupied times',
  `setpointCoolOcc` int(11) DEFAULT NULL COMMENT 'current setpoint, cooling, occupied',
  `setpointHeatOcc` int(11) DEFAULT NULL COMMENT 'current setpoint, heating, occupied',
  `sites_id` int(11) NOT NULL COMMENT 'the Site this belongs to (if idzones is NULL, then the complete building)',
  `zones_idzones` int(11) DEFAULT NULL COMMENT 'the zone this belongs to (or NULL if the whole building/site)',
  `endusecategory_idEndUseCategory` int(11) DEFAULT NULL COMMENT 'the end-use this energy date is for... lighting, hvac, plug-load, unknown',
  `HeatEnergySens` int(11) DEFAULT NULL COMMENT 'change in BTU per degree change in setpoint (obsolete?)',
  `CoolEnergySens` int(11) DEFAULT NULL COMMENT 'change in kwh per degree change in setpoint (obsolete?)',
  `schedule_idschedule` int(11) NOT NULL COMMENT 'The schedule for occupied/unoccupied hours each day',
  `setpointHeatUnocc` int(11) DEFAULT NULL COMMENT 'current setpoint, heating, unoccupied',
  `setpointCoolUnocc` int(11) DEFAULT NULL COMMENT 'current setpoint, cooling, unoccupied',
  `OldBTUperHDD` int(11) DEFAULT NULL COMMENT 'BTU per HDD, for the original building (pre-contract)',
  `OldKWHperCDD` int(11) DEFAULT NULL COMMENT 'KWH per CDD, for the original building pre-retrofit (pre-contract)',
  `isOverride` tinyint(1) DEFAULT NULL COMMENT 'Do the setpoints for the zone or building override the higher level building or enterprise?',
  `client_idClient` int(11) NOT NULL,
  `OldOtherBTU` int(11) DEFAULT NULL COMMENT 'Other gas use per year in BTU, not temperature dependent (e.g. DHW), at least not AS temperature dependent, pre-contract',
  `OldOtherKwh` int(11) DEFAULT NULL COMMENT 'Other electric use per year in kwh, not temperature dependent and not lights (e.g. plug loads), pre-contract',
  `newBTUperHDD` int(11) DEFAULT NULL COMMENT 'BTU per HDD, for the original building post-contract',
  `newKwhperCDD` int(11) DEFAULT NULL COMMENT 'KWH per CDD, for the original building post-contract',
  `newOtherBTU` int(11) DEFAULT NULL COMMENT 'Other gas use per year in BTU, not temperature dependent (e.g. DHW), at least not AS temperature dependent, post-contract',
  `newOtherKwh` int(11) DEFAULT NULL COMMENT 'Other electric use per year in kwh, not temperature dependent and not lights (e.g. plug loads), post-contract',
  `CDDtoDate` int(11) DEFAULT NULL COMMENT 'cooling degree days up to DateForDegreeDays',
  `HDDtoDate` int(11) DEFAULT NULL COMMENT 'cooling degree days up to DateForDegreeDays',
  `DateForDegreeDays` date DEFAULT NULL COMMENT 'Date at which degree days (to date) were most recently stored',
  `baseHeatEnergyAnnual` int(11) DEFAULT NULL COMMENT 'the heat energy consumed in a typical year (in BTU)',
  `baseCoolEnergyAnnual` int(11) DEFAULT NULL COMMENT 'the cooling energy consumed in a typical year (in kWH)',
  PRIMARY KEY (`idEnergy`),
  UNIQUE KEY `endusecategory_idEndUseCategory_UNIQUE` (`endusecategory_idEndUseCategory`,`sites_id`,`zones_idzones`),
  KEY `fk_Energy_sites1` (`sites_id`),
  KEY `fk_Energy_zones1` (`zones_idzones`),
  KEY `fk_Energy_endusecategory1` (`endusecategory_idEndUseCategory`),
  KEY `fk_Energy_schedule1` (`schedule_idschedule`),
  KEY `fk_Energy_client1` (`client_idClient`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `energy`
--

LOCK TABLES `energy` WRITE;
/*!40000 ALTER TABLE `energy` DISABLE KEYS */;
INSERT INTO `energy` VALUES (1,50,7,100,100,0,1,75,82,72,62,75,72,1,NULL,2,NULL,NULL,1,62,82,50,500,0,1,10000,150000,47,420,9500,140000,NULL,NULL,NULL,NULL,NULL),(2,60,13,100,100,0,1,75,82,72,62,75,72,2,NULL,3,NULL,NULL,1,62,82,60,600,0,1,8000,100000,50,500,8500,100000,NULL,NULL,NULL,NULL,NULL),(3,50,7,100,100,0,1,75,80,70,60,73,70,3,3,2,NULL,NULL,1,60,80,60,500,0,1,10000,150000,47,420,9500,140000,NULL,NULL,NULL,NULL,100),(4,50,7,100,100,0,1,75,80,70,60,74,71,4,2,2,NULL,NULL,1,50,80,60,500,0,1,10000,150000,49,420,9600,135000,NULL,NULL,NULL,NULL,101),(5,50,8,99,99,0,1,76,81,69,59,70,72,5,2,2,NULL,NULL,1,55,79,63,450,0,1,9900,135000,55,480,9500,130000,NULL,NULL,NULL,NULL,100),(6,1,2,3,4,0,1,7,8,0,1,7,2,6,3,2,4,5,1,3,9,6,2,0,1,7,3,8,4,9,5,9,9,NULL,8,102);
/*!40000 ALTER TABLE `energy` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `equipment`
--

DROP TABLE IF EXISTS `equipment`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `equipment` (
  `idEquipment` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(45) DEFAULT NULL,
  `type` varchar(45) DEFAULT NULL,
  `wattsMax` int(11) DEFAULT NULL,
  PRIMARY KEY (`idEquipment`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `equipment`
--

LOCK TABLES `equipment` WRITE;
/*!40000 ALTER TABLE `equipment` DISABLE KEYS */;
INSERT INTO `equipment` VALUES (1,'blower','hvac',10000);
/*!40000 ALTER TABLE `equipment` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `financial`
--

DROP TABLE IF EXISTS `financial`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `financial` (
  `idtable1` int(11) NOT NULL,
  `fixedExpense` int(11) DEFAULT NULL COMMENT 'For an enterprise, the sunk (fixed) expenses',
  `annualExpense` int(11) DEFAULT NULL COMMENT 'For the enterprise, annual recurring expenses',
  `startDate` datetime DEFAULT NULL COMMENT 'The start date for the contract\n',
  `annualElectricSavings` int(11) DEFAULT NULL COMMENT 'Predicted annual electric savings for the enterprise (in kWH)',
  `annualGasSavings` int(11) DEFAULT NULL COMMENT 'predicted annual gas savings for the enterprise (in BTU)',
  `pricePerKWh` float DEFAULT NULL COMMENT 'average price per kwh of energy for the enterprise',
  `pricePerBTU` float DEFAULT NULL COMMENT 'average price per btu for the enterprise',
  `client_idClient` int(11) NOT NULL COMMENT 'The enterprise (client)',
  `savingsToDateElectric` int(11) DEFAULT NULL COMMENT 'based on real bills, the electricity savings up to the savingsCalcDate (in kWH)\n',
  `savingsToDateGas` int(11) DEFAULT NULL COMMENT 'based on real bills, the gas savings up to the savingsCalcDate (in BTU)\n',
  `savingsCalcDate` datetime DEFAULT NULL COMMENT 'The date at which the savings have been solidly calculated (see savingsToDateElectric and ...Gas).  After this date, savings are more approximate.',
  PRIMARY KEY (`idtable1`),
  KEY `fk_financial_client1` (`client_idClient`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `financial`
--

LOCK TABLES `financial` WRITE;
/*!40000 ALTER TABLE `financial` DISABLE KEYS */;
INSERT INTO `financial` VALUES (1,1000000,10000,'2008-12-31 17:29:48',NULL,NULL,0.09,1.1,1,0,0,'2008-12-29 10:27:58'),(2,100000,1000,'2009-12-31 00:00:00',0,0,0.09,1.1,2,0,0,NULL);
/*!40000 ALTER TABLE `financial` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `groups`
--

DROP TABLE IF EXISTS `groups`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `groups` (
  `group_id` int(10) NOT NULL AUTO_INCREMENT,
  `group_name` varchar(20) NOT NULL,
  `group_desc` varchar(200) DEFAULT NULL,
  PRIMARY KEY (`group_id`)
) ENGINE=MyISAM AUTO_INCREMENT=5 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `groups`
--

LOCK TABLES `groups` WRITE;
/*!40000 ALTER TABLE `groups` DISABLE KEYS */;
INSERT INTO `groups` VALUES (1,'NEW','New User, No assigned Client'),(2,'USER','Regular User'),(3,'ADMIN','Can alter a clients site'),(4,'SUPER','Can alter an enterprise and assign users to client');
/*!40000 ALTER TABLE `groups` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `hdd_cdd`
--

DROP TABLE IF EXISTS `hdd_cdd`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `hdd_cdd` (
  `idHDD` int(11) NOT NULL AUTO_INCREMENT,
  `startDate` date DEFAULT NULL,
  `endDate` date DEFAULT NULL,
  `HDD` int(11) DEFAULT NULL,
  `CDD` int(11) DEFAULT NULL,
  `baseTemperature` int(11) DEFAULT NULL,
  `WeatherStation_idWeatherStation` int(11) NOT NULL,
  `tempAvg` int(11) DEFAULT NULL,
  `tempHi` int(11) DEFAULT NULL,
  `tempLo` int(11) DEFAULT NULL,
  PRIMARY KEY (`idHDD`),
  KEY `fk_hdd_WeatherStation1` (`WeatherStation_idWeatherStation`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `hdd_cdd`
--

LOCK TABLES `hdd_cdd` WRITE;
/*!40000 ALTER TABLE `hdd_cdd` DISABLE KEYS */;
/*!40000 ALTER TABLE `hdd_cdd` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `meters`
--

DROP TABLE IF EXISTS `meters`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `meters` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `accountNum` varchar(40) NOT NULL,
  `providerName` varchar(50) NOT NULL,
  `fuelType` varchar(20) NOT NULL,
  `vendorID` varchar(30) NOT NULL,
  `textID` varchar(30) NOT NULL,
  `sites_id` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_meters_sites1` (`sites_id`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `meters`
--

LOCK TABLES `meters` WRITE;
/*!40000 ALTER TABLE `meters` DISABLE KEYS */;
INSERT INTO `meters` VALUES (1,'7070-9500888','DTE','Electric','vID','1234926025',2),(2,'6666','DTE','Natural Gas','vID','1455584',2),(4,'A 222 2676 2873 11','DTE','Electric','vID','1980TM',3),(6,'5555','DTE','Electric','vID','226099',5),(7,'2000 4627 7253','DTE','Electric','vID','227976',5),(8,'4444','DTE','Electric','vID','252902 (224075)',5),(9,'7777','Consumers Energy','Natural Gas','vID','4234RT29/ 042-34',2),(14,'69705-01404','DTE','Electric','vID','777999851',1),(15,'11','ab','Electric','vID','ab11',7);
/*!40000 ALTER TABLE `meters` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `multicircuitmeter`
--

DROP TABLE IF EXISTS `multicircuitmeter`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `multicircuitmeter` (
  `idmultiCircuitMeter` int(11) NOT NULL AUTO_INCREMENT,
  `MACaddress` varchar(45) DEFAULT NULL,
  `sites_id` int(11) NOT NULL,
  PRIMARY KEY (`idmultiCircuitMeter`),
  KEY `fk_multiCircuitMeter_sites1` (`sites_id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `multicircuitmeter`
--

LOCK TABLES `multicircuitmeter` WRITE;
/*!40000 ALTER TABLE `multicircuitmeter` DISABLE KEYS */;
INSERT INTO `multicircuitmeter` VALUES (1,'121364',1),(2,'434252',2),(3,'686536622',1),(4,'2353479',2);
/*!40000 ALTER TABLE `multicircuitmeter` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `panel`
--

DROP TABLE IF EXISTS `panel`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `panel` (
  `idPanel` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(45) DEFAULT NULL,
  `sites_id` int(11) NOT NULL,
  `parentCircuit_id` int(11) DEFAULT NULL,
  `parent_idPanel` int(11) DEFAULT NULL,
  PRIMARY KEY (`idPanel`),
  KEY `fk_Panel_sites1` (`sites_id`),
  KEY `fk_panel_circuit1` (`parentCircuit_id`),
  KEY `fk_panel_panel1` (`parent_idPanel`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `panel`
--

LOCK TABLES `panel` WRITE;
/*!40000 ALTER TABLE `panel` DISABLE KEYS */;
INSERT INTO `panel` VALUES (2,'main panel',1,NULL,NULL),(3,'mcc',2,NULL,NULL),(4,'lot lighting',1,NULL,NULL),(5,'chiller',2,NULL,NULL),(6,'mechanical room',2,NULL,NULL);
/*!40000 ALTER TABLE `panel` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `pcbills`
--

DROP TABLE IF EXISTS `pcbills`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `pcbills` (
  `id` int(11) NOT NULL,
  `dateStart` date DEFAULT NULL,
  `dateEnd` date DEFAULT NULL,
  `amount` float NOT NULL COMMENT 'kwh of electricity, or btu of gas, or ccf of water.  Same as Usage',
  `cost` decimal(10,2) NOT NULL COMMENT 'invoice total',
  `pdf_id` int(11) DEFAULT NULL,
  `sites_id` int(11) NOT NULL,
  `IsBasedOnOriginalModel` tinyint(1) DEFAULT NULL COMMENT 'If true, then this bill is NOT based on actual meter readings, but based on predictions from the original building model based in part on HDD and CDD.',
  `fuel_type` varchar(20) DEFAULT 'electric',
  PRIMARY KEY (`id`),
  KEY `fk_bills_pdf` (`pdf_id`),
  KEY `fk_bills_meters1` (`sites_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 ROW_FORMAT=COMPACT;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `pcbills`
--

LOCK TABLES `pcbills` WRITE;
/*!40000 ALTER TABLE `pcbills` DISABLE KEYS */;
INSERT INTO `pcbills` VALUES (69,'2008-08-08','2008-09-08',18000,99.00,NULL,1,0,NULL),(70,'2009-05-11','2009-06-09',16200,99.00,NULL,1,0,NULL),(71,'2009-06-09','2009-07-09',17400,99.00,NULL,1,0,NULL),(72,'2009-07-09','2009-08-10',18600,99.00,NULL,1,0,NULL),(73,'2008-09-08','2008-10-07',17400,99.00,NULL,1,0,NULL),(74,'2008-10-07','2008-11-06',20400,99.00,NULL,1,0,NULL),(75,'2008-11-06','2008-12-10',27000,99.00,NULL,1,0,NULL),(76,'2008-12-10','2009-01-09',22200,99.00,NULL,1,0,NULL),(77,'2009-01-09','2009-02-06',25200,99.00,NULL,1,0,NULL),(78,'2009-02-06','2009-03-10',25200,99.00,NULL,1,0,NULL),(79,'2009-03-10','2009-04-08',23400,99.00,NULL,1,0,NULL),(80,'2009-04-08','2009-05-11',22200,99.00,NULL,1,0,NULL),(81,'2009-08-10','2009-09-09',18000,99.00,NULL,1,1,NULL),(82,'2010-05-11','2010-06-09',13800,99.00,NULL,1,1,NULL),(83,'2010-06-10','2010-07-11',15600,99.00,NULL,1,1,NULL),(84,'2010-07-11','2010-08-09',15600,99.00,NULL,1,1,NULL),(85,'2009-09-09','2009-10-08',16800,99.00,NULL,1,1,NULL),(86,'2009-10-08','2009-11-09',20400,99.00,NULL,1,1,NULL),(87,'2009-11-09','2009-12-09',22200,99.00,NULL,1,1,NULL),(88,'2009-12-09','2010-01-11',27600,99.00,NULL,1,1,NULL),(89,'2010-01-11','2010-02-08',24000,99.00,NULL,1,1,NULL),(90,'2010-02-09','2010-03-10',27000,99.00,NULL,1,1,NULL),(91,'2010-03-11','2010-04-11',18000,99.00,NULL,1,1,NULL),(92,'2010-04-12','2010-05-10',13800,99.00,NULL,1,1,NULL),(93,'2008-08-01','2008-09-02',21,99.00,NULL,2,0,NULL),(94,'2009-05-04','2009-06-03',20,99.00,NULL,2,0,NULL),(95,'2009-06-03','2009-07-02',19,99.00,NULL,2,0,NULL),(96,'2009-07-02','2009-08-04',11,99.00,NULL,2,0,NULL),(97,'2008-09-02','2008-09-30',18,99.00,NULL,2,0,NULL),(98,'2008-09-30','2008-10-29',507,99.00,NULL,2,0,NULL),(99,'2008-10-29','2008-12-01',255,99.00,NULL,2,0,NULL),(100,'2008-12-01','2009-01-02',330,99.00,NULL,2,0,NULL),(101,'2009-01-02','2009-02-02',7298,99.00,NULL,2,0,NULL),(102,'2009-02-02','2009-03-04',2841,99.00,NULL,2,0,NULL),(103,'2009-03-04','2009-04-03',3012,99.00,NULL,2,0,NULL),(104,'2009-04-03','2009-05-04',1414,99.00,NULL,2,0,NULL),(105,'2009-08-04','2009-09-02',1,99.00,NULL,2,1,NULL),(106,'2010-05-05','2010-06-02',10,99.00,NULL,2,1,NULL),(107,'2010-06-02','2010-07-01',30,99.00,NULL,2,1,NULL),(108,'2010-07-01','2010-08-01',0,0.00,NULL,2,1,NULL),(109,'2009-09-02','2009-10-01',0,99.00,NULL,2,1,NULL),(110,'2009-10-01','2009-10-30',343,99.00,NULL,2,1,NULL),(111,'2009-10-30','2009-12-02',1324,99.00,NULL,2,1,NULL),(112,'2009-12-02','2010-01-07',2295,99.00,NULL,2,1,NULL),(113,'2010-01-07','2010-02-02',4190,99.00,NULL,2,1,NULL),(114,'2010-02-02','2010-03-03',6540,99.00,NULL,2,1,NULL),(115,'2010-03-03','2010-04-05',2390,99.00,NULL,2,1,NULL),(116,'2010-04-05','2010-05-05',20,99.00,NULL,2,1,NULL),(118,'2008-07-29','2008-08-27',9.38,92.00,NULL,11,0,NULL),(119,'2009-04-29','2009-05-31',37.52,76.00,NULL,11,0,NULL),(120,'2009-05-31','2009-06-29',10.72,39.00,NULL,11,0,NULL),(121,'2009-06-29','2009-07-29',9.38,37.00,NULL,11,0,NULL),(122,'2008-08-27','2008-09-28',8.04,90.00,NULL,11,0,NULL),(123,'2008-09-28','2008-10-27',73.7,99.00,NULL,11,0,NULL),(124,'2008-10-27','2008-11-25',367.16,99.00,NULL,11,0,NULL),(125,'2008-11-25','2008-12-30',834.82,99.00,NULL,11,0,NULL),(126,'2008-12-30','2009-02-01',1113.54,99.00,NULL,11,0,NULL),(127,'2009-02-01','2009-03-02',714.22,99.00,NULL,11,0,NULL),(128,'2009-03-02','2009-03-31',443.54,99.00,NULL,11,0,NULL),(129,'2009-03-31','2009-04-29',217.08,99.00,NULL,11,0,NULL),(130,'2009-07-29','2009-08-27',14.74,44.00,NULL,11,1,NULL),(131,'2010-04-28','2010-05-27',22.78,56.00,NULL,11,1,NULL),(132,'2010-05-27','2010-06-28',81.74,99.00,NULL,11,1,NULL),(133,'2010-06-28','2010-07-28',10.72,39.00,NULL,11,1,NULL),(134,'2009-08-27','2009-09-28',5.36,32.00,NULL,11,1,NULL),(135,'2009-09-28','2009-10-27',124.62,99.00,NULL,11,1,NULL),(136,'2009-10-27','2009-11-29',314.9,99.00,NULL,11,1,NULL),(137,'2009-11-29','2009-12-30',897.8,99.00,NULL,11,1,NULL),(138,'2009-12-30','2010-01-31',1072,99.00,NULL,11,1,NULL),(139,'2010-01-31','2010-03-01',1058.6,99.00,NULL,11,1,NULL),(140,'2010-03-01','2010-03-30',542.7,99.00,NULL,11,1,NULL),(141,'2010-03-30','2010-04-28',99.16,99.00,NULL,11,1,NULL),(142,'2008-07-30','2008-08-28',149964,99.00,NULL,14,0,NULL),(143,'2009-04-30','2009-05-30',143289,99.00,NULL,14,0,NULL),(144,'2009-05-30','2009-06-30',47856,99.00,NULL,14,0,NULL),(145,'2009-06-30','2009-07-30',54209,99.00,NULL,14,0,NULL),(146,'2008-08-28','2008-09-27',169741,99.00,NULL,14,0,NULL),(147,'2008-09-27','2008-10-28',157799,99.00,NULL,14,0,NULL),(148,'2008-10-28','2008-11-26',147015,99.00,NULL,14,0,NULL),(149,'2008-11-26','2008-12-31',168785,99.00,NULL,14,0,NULL),(150,'2008-12-31','2009-01-31',163171,99.00,NULL,14,0,NULL),(151,'2009-01-31','2009-03-03',151903,99.00,NULL,14,0,NULL),(152,'2009-03-03','2009-04-01',134545,99.00,NULL,14,0,NULL),(153,'2009-04-01','2009-04-30',139339,99.00,NULL,14,0,NULL),(154,'2009-07-30','2009-08-28',116961,99.00,NULL,14,1,NULL),(155,'2010-04-29','2010-05-28',138590,99.00,NULL,14,1,NULL),(156,'2010-05-28','2010-06-29',206292,99.00,NULL,14,1,NULL),(157,'2010-06-29','2010-07-29',207402,99.00,NULL,14,1,NULL),(158,'2009-08-28','2009-09-29',77525,99.00,NULL,14,1,NULL),(159,'2009-09-29','2009-10-28',131024,99.00,NULL,14,1,NULL),(160,'2009-10-28','2009-11-30',156651,99.00,NULL,14,1,NULL),(161,'2009-11-30','2009-12-31',180868,99.00,NULL,14,1,NULL),(162,'2009-12-31','2010-02-01',166523,99.00,NULL,14,1,NULL),(163,'2010-02-01','2010-03-02',170980,99.00,NULL,14,1,NULL),(164,'2010-03-02','2010-03-31',164650,99.00,NULL,14,1,NULL),(165,'2010-03-31','2010-04-29',163498,99.00,NULL,14,1,NULL),(166,'2011-01-01','2011-01-15',1234,123.00,NULL,1,NULL,NULL);
/*!40000 ALTER TABLE `pcbills` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `pdf`
--

DROP TABLE IF EXISTS `pdf`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `pdf` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `filename` varchar(255) NOT NULL,
  `filesize` bigint(20) NOT NULL,
  `filetype` varchar(45) NOT NULL,
  `content` longblob NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 ROW_FORMAT=COMPACT COMMENT='pdf of bills';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `pdf`
--

LOCK TABLES `pdf` WRITE;
/*!40000 ALTER TABLE `pdf` DISABLE KEYS */;
/*!40000 ALTER TABLE `pdf` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `realtimedata`
--

DROP TABLE IF EXISTS `realtimedata`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `realtimedata` (
  `idrealTimeData` int(11) NOT NULL,
  `truePower` float DEFAULT NULL,
  `apparentPower` float DEFAULT NULL,
  `timestamp` datetime DEFAULT NULL,
  `Energy` float DEFAULT NULL,
  `apparentEnergy` float DEFAULT NULL,
  `Circuit_idCircuit` int(11) NOT NULL,
  PRIMARY KEY (`idrealTimeData`),
  KEY `fk_realTimeData_Circuit1` (`Circuit_idCircuit`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `realtimedata`
--

LOCK TABLES `realtimedata` WRITE;
/*!40000 ALTER TABLE `realtimedata` DISABLE KEYS */;
/*!40000 ALTER TABLE `realtimedata` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `schedule`
--

DROP TABLE IF EXISTS `schedule`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `schedule` (
  `idschedule` int(11) NOT NULL AUTO_INCREMENT,
  `Client_idClient` int(11) DEFAULT NULL,
  `MonHours` int(11) DEFAULT NULL COMMENT '# hours occupied on Monday',
  `TuesHours` int(11) DEFAULT NULL,
  `WedHours` int(11) DEFAULT NULL,
  `ThHours` int(11) DEFAULT NULL,
  `FriHours` int(11) DEFAULT NULL,
  `SatHours` int(11) DEFAULT NULL,
  `SunHours` int(11) DEFAULT NULL,
  `IsOnWhenDark` tinyint(1) DEFAULT NULL,
  `name` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`idschedule`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `schedule`
--

LOCK TABLES `schedule` WRITE;
/*!40000 ALTER TABLE `schedule` DISABLE KEYS */;
INSERT INTO `schedule` VALUES (1,1,12,12,12,12,12,8,12,0,'ymca');
/*!40000 ALTER TABLE `schedule` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sites`
--

DROP TABLE IF EXISTS `sites`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `sites` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(100) NOT NULL,
  `address1` varchar(100) DEFAULT NULL,
  `nPeople` int(11) DEFAULT NULL,
  `squarefeet` int(11) DEFAULT NULL,
  `address2` varchar(45) DEFAULT NULL,
  `city` varchar(45) DEFAULT NULL,
  `state` varchar(45) DEFAULT NULL,
  `zipcode` varchar(45) DEFAULT NULL,
  `Client_idClient` int(11) NOT NULL,
  `startDate` date DEFAULT NULL COMMENT 'The start date for the contract',
  `WeatherStationid` int(11) DEFAULT NULL,
  `lightPowerBaseOcc` int(11) DEFAULT NULL COMMENT 'the base light power during occupied times.  Actually, max power during occupied times (in kW)',
  `lightPowerBaseUnOcc` int(11) DEFAULT NULL COMMENT 'the base light power during unoccupied times. (Max power during unoccupied times) (in kW)',
  `PercentMaxLightSetting` int(11) DEFAULT NULL COMMENT 'Percent of maximum lighting, proposed or current?  This is updated when the new setting is accepted.',
  `PercentMaxLightOriginal` int(10) unsigned DEFAULT NULL COMMENT 'percent of maximum lighting, original (probably 100%)',
  `IsOnWhenDark` tinyint(1) DEFAULT NULL COMMENT 'For lights, on when dark outside',
  `IsWholeBuilding` tinyint(1) DEFAULT NULL COMMENT 'If true, then this energy record is for a whole building (not a sub-zone)',
  `origSetpointCoolOcc` int(11) DEFAULT NULL COMMENT 'original cooling setpoint for occupied times',
  `origSetpointCoolUnocc` int(11) DEFAULT NULL COMMENT 'original cooling setpoint for unoccupied times',
  `origSetpointHeatOcc` int(11) DEFAULT NULL COMMENT 'original heating setpoint for occupied times',
  `origSetpointHeatUnocc` int(11) DEFAULT NULL COMMENT 'original heating setpoint for unoccupied times',
  `setpointCoolOcc` int(11) DEFAULT NULL COMMENT 'current setpoint, cooling, occupied',
  `setpointHeatOcc` int(11) DEFAULT NULL COMMENT 'current setpoint, heating, occupied',
  `HeatEnergySens` int(11) DEFAULT NULL COMMENT 'change in BTU per degree change in setpoint (obsolete?)',
  `CoolEnergySens` int(11) DEFAULT NULL COMMENT 'change in kwh per degree change in setpoint (obsolete?)',
  `schedule_idschedule` int(11) NOT NULL COMMENT 'The schedule for occupied/unoccupied hours each day',
  `setpointHeatUnocc` int(11) DEFAULT NULL COMMENT 'current setpoint, heating, unoccupied',
  `setpointCoolUnocc` int(11) DEFAULT NULL COMMENT 'current setpoint, cooling, unoccupied',
  `OldBTUperHDD` int(11) DEFAULT NULL COMMENT 'BTU per HDD, for the original building (pre-contract)',
  `OldKWHperCDD` int(11) DEFAULT NULL COMMENT 'KWH per CDD, for the original building pre-retrofit (pre-contract)',
  `isOverride` tinyint(1) DEFAULT NULL COMMENT 'Do the setpoints for the zone or building override the higher level building or enterprise?',
  `OldOtherBTU` int(11) DEFAULT NULL COMMENT 'Other gas use per year in BTU, not temperature dependent (e.g. DHW), at least not AS temperature dependent, pre-contract',
  `OldOtherKwh` int(11) DEFAULT NULL COMMENT 'Other electric use per year in kwh, not temperature dependent and not lights (e.g. plug loads), pre-contract',
  `newBTUperHDD` int(11) DEFAULT NULL COMMENT 'BTU per HDD, for the original building post-contract',
  `newKwhperCDD` int(11) DEFAULT NULL COMMENT 'KWH per CDD, for the original building post-contract',
  `newOtherBTU` int(11) DEFAULT NULL COMMENT 'Other gas use per year in BTU, not temperature dependent (e.g. DHW), at least not AS temperature dependent, post-contract',
  `newOtherKwh` int(11) DEFAULT NULL COMMENT 'Other electric use per year in kwh, not temperature dependent and not lights (e.g. plug loads), post-contract',
  PRIMARY KEY (`id`),
  UNIQUE KEY `siteID` (`id`),
  KEY `fk_sites_Client1` (`Client_idClient`),
  KEY `fk_sites_WeatherStation1` (`WeatherStationid`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=latin1 ROW_FORMAT=COMPACT;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sites`
--

LOCK TABLES `sites` WRITE;
/*!40000 ALTER TABLE `sites` DISABLE KEYS */;
INSERT INTO `sites` VALUES (1,'Office B','address1',200,80000,'address2','Some Township','XY','55111',1,'2008-12-31',1,100,15,100,100,0,1,75,82,72,62,75,72,0,0,1,62,82,50,500,0,10000,150000,47,420,9500,140000),(2,'Plant A','address1',200,80000,'address2','Some Township','XY','55111',1,'2008-12-31',1,60,13,100,100,0,1,75,82,72,62,75,72,NULL,NULL,1,62,82,60,600,0,8000,100000,50,500,8500,100000),(3,'Office C','address1',200,80000,'address2','Some Township','XY','55111',1,'2008-12-31',1,50,7,100,100,0,1,75,80,70,60,73,70,NULL,NULL,1,60,80,60,500,0,10000,150000,47,420,9500,140000),(4,'test','test12345',123,12314,'tewt131','allwn','3424','18103',1,'2008-12-31',1,50,7,100,100,0,1,75,80,70,60,74,71,NULL,NULL,1,50,80,60,500,0,10000,150000,49,420,9600,135000),(5,'Warehouse E','address1',200,80000,'address2','Some Township','XY','55112',1,'2008-12-31',1,50,8,99,99,0,1,76,81,69,59,70,72,NULL,NULL,1,55,79,63,450,0,9900,135000,55,480,9500,130000),(6,'ymca','wash',200,80000,'and 1s2','ann arbor','mi','48103',1,'2008-12-31',1,80,9,99,99,0,1,76,81,69,59,70,72,0,0,1,55,79,63,450,0,9900,135000,55,480,9500,130000),(7,'abtest','a',1,2,'b','c','d','0',1,NULL,1,3,4,5,6,0,1,7,8,11,12,9,13,0,0,1,14,10,15,19,0,16,20,17,21,18,22);
/*!40000 ALTER TABLE `sites` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `users`
--

DROP TABLE IF EXISTS `users`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `users` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `User_Password` varchar(45) DEFAULT NULL,
  `Email` varchar(128) DEFAULT NULL,
  `User_Name` varchar(45) DEFAULT NULL,
  `Client_idClient` int(11) DEFAULT NULL,
  `isAdmin` tinyint(1) DEFAULT '0',
  `isEmailPolicy` tinyint(1) DEFAULT '0',
  `isEmailAlert` tinyint(1) DEFAULT '0',
  `isSuperUser` tinyint(1) DEFAULT '0',
  PRIMARY KEY (`id`),
  KEY `fk_Users_Client1` (`Client_idClient`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `users`
--

LOCK TABLES `users` WRITE;
/*!40000 ALTER TABLE `users` DISABLE KEYS */;
INSERT INTO `users` VALUES (1,'','thien@beigebag.com','thien',1,1,1,1,1),(2,'098F6BCD4621D373CADE4E832627B4F6','jon@beigebag.com','jon',1,1,0,1,1),(3,'','xander@test.com','xander',1,1,0,1,0);
/*!40000 ALTER TABLE `users` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Temporary table structure for view `v_user_role`
--

DROP TABLE IF EXISTS `v_user_role`;
/*!50001 DROP VIEW IF EXISTS `v_user_role`*/;
SET @saved_cs_client     = @@character_set_client;
SET character_set_client = utf8;
/*!50001 CREATE TABLE `v_user_role` (
  `user_name` varchar(45),
  `user_password` varchar(45),
  `group_name` varchar(20)
) ENGINE=MyISAM */;
SET character_set_client = @saved_cs_client;

--
-- Table structure for table `v_user_role_new`
--

DROP TABLE IF EXISTS `v_user_role_new`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `v_user_role_new` (
  `user_name` varchar(45) NOT NULL DEFAULT '',
  `user_password` varchar(45) DEFAULT NULL,
  `role_name` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`user_name`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `v_user_role_new`
--

LOCK TABLES `v_user_role_new` WRITE;
/*!40000 ALTER TABLE `v_user_role_new` DISABLE KEYS */;
INSERT INTO `v_user_role_new` VALUES ('jon','098F6BCD4621D373CADE4E832627B4F6','USER'),('thien','098F6BCD4621D373CADE4E832627B4F6','USER');
/*!40000 ALTER TABLE `v_user_role_new` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `weatherstation`
--

DROP TABLE IF EXISTS `weatherstation`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `weatherstation` (
  `idWeatherStation` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(20) DEFAULT NULL COMMENT 'Weather station ID, such as KARB for ann arbor airport\n',
  `HDDannual` int(11) DEFAULT NULL COMMENT 'HDD for a typical year with "baseTemp" degree base temperature',
  `CDDannual` int(11) DEFAULT NULL COMMENT 'CDD for a typical year with ''basetemp'' degree base temperature',
  `HDDsens` float DEFAULT NULL COMMENT 'The first derivative of annualHDD vs. base temperature, centered around base=65.  e.g. if HDD65 is 4000 and HDDsens is 100 and the new base is 66, then HDD will be 4100',
  `HDDsens2` float DEFAULT NULL COMMENT 'The second derivative of annualHDD vs. base temperature, centered around base=65.  e.g. if HDD65 is 4000 and HDDsens is 100 and HDDsens2 is 10 and the new base is 66, then HDD will be 4110.',
  `CDDsens` float DEFAULT NULL COMMENT 'The first derivative of annualCDD vs. base temperature, centered around base=65. e.g. if CDD65 is 4000 and CDDsens is -100 and the new base is 66, then CDD will be 3900',
  `CDDsens2` float DEFAULT NULL COMMENT 'The second derivative of annualCDD vs. base temperature, centered around base=65',
  `baseTemp` int(11) DEFAULT NULL COMMENT 'used for annual HDD/CDD calculations',
  PRIMARY KEY (`idWeatherStation`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `weatherstation`
--

LOCK TABLES `weatherstation` WRITE;
/*!40000 ALTER TABLE `weatherstation` DISABLE KEYS */;
INSERT INTO `weatherstation` VALUES (1,'karb',5508,1362,240,6,-125.2,5.8,60),(2,'wkrp',2500,2000,25,3,20,2,60);
/*!40000 ALTER TABLE `weatherstation` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `zones`
--

DROP TABLE IF EXISTS `zones`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `zones` (
  `idzones` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) NOT NULL,
  `sites_id` int(11) NOT NULL,
  `nPeople` int(11) DEFAULT NULL COMMENT 'typical # people in the zone',
  `squareFeet` int(11) DEFAULT NULL COMMENT 'zone area',
  `parent_idzones` int(11) DEFAULT NULL,
  PRIMARY KEY (`idzones`),
  UNIQUE KEY `idzones_UNIQUE` (`idzones`),
  KEY `fk_zones_sites1` (`sites_id`),
  KEY `fk_zones_zones1` (`parent_idzones`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `zones`
--

LOCK TABLES `zones` WRITE;
/*!40000 ALTER TABLE `zones` DISABLE KEYS */;
INSERT INTO `zones` VALUES (1,'1st floor',1,101,20000,NULL),(3,'exercise floor',1,245,3000,NULL),(4,'pool',2,100,2500,NULL),(5,'offices',2,53,1000,NULL),(6,'test',2,1,100,2);
/*!40000 ALTER TABLE `zones` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Current Database: `energy`
--

USE `energy`;

--
-- Final view structure for view `v_user_role`
--

/*!50001 DROP TABLE IF EXISTS `v_user_role`*/;
/*!50001 DROP VIEW IF EXISTS `v_user_role`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8 */;
/*!50001 SET character_set_results     = utf8 */;
/*!50001 SET collation_connection      = utf8_general_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`root`@`localhost` SQL SECURITY DEFINER */
/*!50001 VIEW `v_user_role` AS select `u`.`User_Name` AS `user_name`,`u`.`User_Password` AS `user_password`,`g`.`group_name` AS `group_name` from (`users` `u` join `groups` `g` on((`u`.`isAdmin` = `g`.`group_id`))) */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2012-03-04 15:27:09
