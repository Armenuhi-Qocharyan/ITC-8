-- MySQL dump 10.13  Distrib 5.7.18, for Linux (x86_64)
--
-- Host: localhost    Database: imforms
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
-- Table structure for table `elements`
--

DROP TABLE IF EXISTS `elements`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `elements` (
  `element_id` int(11) NOT NULL AUTO_INCREMENT,
  `element_title` varchar(30) NOT NULL,
  PRIMARY KEY (`element_id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `elements`
--

LOCK TABLES `elements` WRITE;
/*!40000 ALTER TABLE `elements` DISABLE KEYS */;
INSERT INTO `elements` VALUES (1,'fullName'),(2,'email'),(3,'address'),(4,'birthday'),(5,'work');
/*!40000 ALTER TABLE `elements` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Temporary table structure for view `filledForms`
--

DROP TABLE IF EXISTS `filledForms`;
/*!50001 DROP VIEW IF EXISTS `filledForms`*/;
SET @saved_cs_client     = @@character_set_client;
SET character_set_client = utf8;
/*!50001 CREATE VIEW `filledForms` AS SELECT 
 1 AS `User`,
 1 AS `Form`,
 1 AS `Count`*/;
SET character_set_client = @saved_cs_client;

--
-- Table structure for table `filled_forms`
--

DROP TABLE IF EXISTS `filled_forms`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `filled_forms` (
  `fill_id` int(11) NOT NULL AUTO_INCREMENT,
  `form_id` int(11) NOT NULL,
  `user_id` int(11) NOT NULL,
  `filled_json` varchar(255) NOT NULL,
  PRIMARY KEY (`fill_id`),
  KEY `form_id` (`form_id`),
  KEY `user_id` (`user_id`),
  CONSTRAINT `filled_forms_ibfk_1` FOREIGN KEY (`form_id`) REFERENCES `forms` (`form_id`),
  CONSTRAINT `filled_forms_ibfk_2` FOREIGN KEY (`user_id`) REFERENCES `users` (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `filled_forms`
--

LOCK TABLES `filled_forms` WRITE;
/*!40000 ALTER TABLE `filled_forms` DISABLE KEYS */;
INSERT INTO `filled_forms` VALUES (1,1,1,'\"1\":[\"Mane\", \"Antonyan\"],\"2\":\"maneantonyan@gmail.com\",\"4\":\"14.05.00\",\"3\":\"Armenia,Lori,Vanadzor,...\"'),(2,1,1,'{\"1\":[\"Name\",\"Surname\"],\"2\":\"Email@email.com\",\"4\":\"DD.MM.YY\",\"3\":\"Some Address\"}'),(3,1,2,'{\"1\":[\"Name\",\"Surname\"],\"2\":\"Email@email.com\",\"4\":\"DD.MM.YY\",\"3\":\"Some Address\"}');
/*!40000 ALTER TABLE `filled_forms` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `forms`
--

DROP TABLE IF EXISTS `forms`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `forms` (
  `form_id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) NOT NULL,
  `content_json` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`form_id`),
  KEY `user_id` (`user_id`),
  CONSTRAINT `forms_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `users` (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `forms`
--

LOCK TABLES `forms` WRITE;
/*!40000 ALTER TABLE `forms` DISABLE KEYS */;
INSERT INTO `forms` VALUES (1,1,'{\"1\":[\"First Name\",\"Last Name\"],\"2\":\"Email\",\"4\":\"Birthday\",\"3\":\"Address\"}'),(2,2,'{\"1\":[\"First Name\",\"Last Name\"],\"2\":\"Email\",\"4\":\"Birthday\",\"3\":\"Address\"}');
/*!40000 ALTER TABLE `forms` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Temporary table structure for view `imforms`
--

DROP TABLE IF EXISTS `imforms`;
/*!50001 DROP VIEW IF EXISTS `imforms`*/;
SET @saved_cs_client     = @@character_set_client;
SET character_set_client = utf8;
/*!50001 CREATE VIEW `imforms` AS SELECT 
 1 AS `User`,
 1 AS `Form`,
 1 AS `Count`*/;
SET character_set_client = @saved_cs_client;

--
-- Table structure for table `users`
--

DROP TABLE IF EXISTS `users`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `users` (
  `user_id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(30) NOT NULL,
  `user_email` varchar(40) NOT NULL,
  `password` varchar(50) NOT NULL,
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `users`
--

LOCK TABLES `users` WRITE;
/*!40000 ALTER TABLE `users` DISABLE KEYS */;
INSERT INTO `users` VALUES (1,'Mary','Antonyan','RootRoot'),(2,'example','example@example.com','Example');
/*!40000 ALTER TABLE `users` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Final view structure for view `filledForms`
--

/*!50001 DROP VIEW IF EXISTS `filledForms`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8 */;
/*!50001 SET character_set_results     = utf8 */;
/*!50001 SET collation_connection      = utf8_general_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`root`@`localhost` SQL SECURITY DEFINER */
/*!50001 VIEW `filledForms` AS select `u`.`username` AS `User`,`f`.`content_json` AS `Form`,count(`ff`.`filled_json`) AS `Count` from ((`users` `u` join `forms` `f`) join `filled_forms` `ff`) where ((`u`.`user_id` = `f`.`user_id`) and (`u`.`user_id` = `ff`.`user_id`) and (`f`.`form_id` = `ff`.`form_id`)) group by `User`,`Form` */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;

--
-- Final view structure for view `imforms`
--

/*!50001 DROP VIEW IF EXISTS `imforms`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8 */;
/*!50001 SET character_set_results     = utf8 */;
/*!50001 SET collation_connection      = utf8_general_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`root`@`localhost` SQL SECURITY DEFINER */
/*!50001 VIEW `imforms` AS select `u`.`username` AS `User`,`f`.`content_json` AS `Form`,count(`ff`.`filled_json`) AS `Count` from ((`users` `u` join `forms` `f` on((`u`.`user_id` = `f`.`user_id`))) join `filled_forms` `ff`) where ((`ff`.`user_id` = `u`.`user_id`) and (`ff`.`form_id` = `f`.`form_id`)) group by `User`,`Form` */;
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

-- Dump completed on 2017-07-13  0:17:16
