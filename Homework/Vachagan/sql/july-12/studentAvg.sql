-- MySQL dump 10.13  Distrib 5.7.18, for Linux (x86_64)
--
-- Host: localhost    Database: ITC8
-- ------------------------------------------------------
-- Server version	5.7.18-0ubuntu0.16.04.1

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
-- Table structure for table `score`
--

DROP TABLE IF EXISTS `score`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `score` (
  `scId` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `stId` int(10) unsigned NOT NULL,
  `suId` int(10) unsigned NOT NULL,
  `score` int(10) unsigned NOT NULL,
  PRIMARY KEY (`scId`),
  KEY `stId` (`stId`),
  KEY `suId` (`suId`),
  CONSTRAINT `score_ibfk_1` FOREIGN KEY (`stId`) REFERENCES `student` (`stId`),
  CONSTRAINT `score_ibfk_2` FOREIGN KEY (`suId`) REFERENCES `subject` (`suId`)
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `score`
--

LOCK TABLES `score` WRITE;
/*!40000 ALTER TABLE `score` DISABLE KEYS */;
INSERT INTO `score` VALUES (1,1,1,80),(2,1,2,85),(3,1,3,90),(4,1,4,100),(5,2,1,60),(6,2,2,90),(7,2,3,40),(8,2,4,90),(9,3,1,100),(10,3,2,90),(11,3,3,70),(12,3,4,90),(13,4,1,65),(14,4,2,90),(15,4,3,80),(16,4,4,100),(17,1,1,60),(18,1,1,100),(19,2,1,60),(20,3,1,100);
/*!40000 ALTER TABLE `score` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `student`
--

DROP TABLE IF EXISTS `student`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `student` (
  `stId` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `name` varchar(30) DEFAULT NULL,
  `surname` varchar(40) DEFAULT NULL,
  PRIMARY KEY (`stId`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `student`
--

LOCK TABLES `student` WRITE;
/*!40000 ALTER TABLE `student` DISABLE KEYS */;
INSERT INTO `student` VALUES (1,'Vachagan','Hovhannisyan'),(2,'Ruben','Ghalayan'),(3,'Smbat','Torosyan'),(4,'Artak','Hakobyan');
/*!40000 ALTER TABLE `student` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Temporary table structure for view `studentsAvg`
--

DROP TABLE IF EXISTS `studentsAvg`;
/*!50001 DROP VIEW IF EXISTS `studentsAvg`*/;
SET @saved_cs_client     = @@character_set_client;
SET character_set_client = utf8;
/*!50001 CREATE VIEW `studentsAvg` AS SELECT 
 1 AS `name`,
 1 AS `avg(score)`,
 1 AS `count(score)`*/;
SET character_set_client = @saved_cs_client;

--
-- Table structure for table `subject`
--

DROP TABLE IF EXISTS `subject`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `subject` (
  `suId` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `title` varchar(30) DEFAULT NULL,
  PRIMARY KEY (`suId`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `subject`
--

LOCK TABLES `subject` WRITE;
/*!40000 ALTER TABLE `subject` DISABLE KEYS */;
INSERT INTO `subject` VALUES (1,'C++'),(2,'Python'),(3,'Javascript'),(4,'Bash');
/*!40000 ALTER TABLE `subject` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Temporary table structure for view `tablescore`
--

DROP TABLE IF EXISTS `tablescore`;
/*!50001 DROP VIEW IF EXISTS `tablescore`*/;
SET @saved_cs_client     = @@character_set_client;
SET character_set_client = utf8;
/*!50001 CREATE VIEW `tablescore` AS SELECT 
 1 AS `title`,
 1 AS `maxscore`,
 1 AS `minscore`,
 1 AS `avgscore`*/;
SET character_set_client = @saved_cs_client;

--
-- Final view structure for view `studentsAvg`
--

/*!50001 DROP VIEW IF EXISTS `studentsAvg`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8 */;
/*!50001 SET character_set_results     = utf8 */;
/*!50001 SET collation_connection      = utf8_general_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`root`@`localhost` SQL SECURITY DEFINER */
/*!50001 VIEW `studentsAvg` AS select `student`.`name` AS `name`,avg(`score`.`score`) AS `avg(score)`,count(`score`.`score`) AS `count(score)` from (`student` join `score`) where (`score`.`stId` = `student`.`stId`) group by `student`.`name` */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;

--
-- Final view structure for view `tablescore`
--

/*!50001 DROP VIEW IF EXISTS `tablescore`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8 */;
/*!50001 SET character_set_results     = utf8 */;
/*!50001 SET collation_connection      = utf8_general_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`root`@`localhost` SQL SECURITY DEFINER */
/*!50001 VIEW `tablescore` AS select `subject`.`title` AS `title`,max(`score`.`score`) AS `maxscore`,min(`score`.`score`) AS `minscore`,avg(`score`.`score`) AS `avgscore` from ((`score` join `student`) join `subject`) where ((`score`.`stId` = `student`.`stId`) and (`score`.`suId` = `subject`.`suId`)) group by `subject`.`title` */;
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

-- Dump completed on 2017-07-18 11:38:07
