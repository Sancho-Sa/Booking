-- MySQL dump 10.13  Distrib 8.0.29, for Win64 (x86_64)
--
-- Host: localhost    Database: flight_booking
-- ------------------------------------------------------
-- Server version	8.0.29

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `airport`
--

DROP TABLE IF EXISTS `airport`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `airport` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(45) NOT NULL,
  `town_id` int NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_airport_town_idx` (`town_id`),
  CONSTRAINT `fk_airport_town` FOREIGN KEY (`town_id`) REFERENCES `town` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=37 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `airport`
--

LOCK TABLES `airport` WRITE;
/*!40000 ALTER TABLE `airport` DISABLE KEYS */;
INSERT INTO `airport` VALUES (1,'Amsterdam Airport Schiphol',1),(2,'Antonio Carlos Jobim International Airport',24),(3,'Cairo International Airport',7),(4,'Changi Airport ',28),(5,'Charles De Gaulle Airport ',23),(6,'Domodedovo Airport ',18),(7,'Dubai International Airport ',10),(8,'Dulles International Airport ',32),(9,'El Prat Airport ',5),(10,'Eleftherios Venizelos Airport ',2),(11,'Fiumicino Airport ',25),(12,'Franz Josef Strauss Airport ',19),(13,'Geneva International Airport ',11),(14,'Guarulhos International Airport ',26),(15,'Hazrat Shahjalal International Airport ',9),(16,'Indira Gandhi International Airport ',20),(17,'Istanbul Airport ',12),(18,'Istanbul Sabiha Gokcen International Airport ',12),(19,'John F Kennedy International Airport ',21),(20,'Kansai International Airport ',22),(21,'Kingsford Smith Airport ',29),(22,'London Gatwick Airport ',14),(23,'London Heathrow Airport ',14),(24,'Los Angeles International Airport ',15),(25,'Malpensa Airport ',17),(26,'Melbourne Tullamarine Airport ',16),(27,'Mohammed V International Airport ',8),(28,'Newark Liberty International Airport ',21),(29,'Ngurah Rai International Airport ',3),(30,'Nikola Tesla Airport ',6),(31,'Sarajevo International Airport ',27),(32,'Soekarno-Hatta International Airport ',13),(33,'Suvarnabhumi International Airport ',4),(34,'Tokyo Haneda Airport ',30),(35,'Tokyo Narita International Airport ',30),(36,'Zagreb Airport ',31);
/*!40000 ALTER TABLE `airport` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `clazz`
--

DROP TABLE IF EXISTS `clazz`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `clazz` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(45) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `clazz`
--

LOCK TABLES `clazz` WRITE;
/*!40000 ALTER TABLE `clazz` DISABLE KEYS */;
INSERT INTO `clazz` VALUES (1,'Economy class'),(2,'Business class'),(3,'First class');
/*!40000 ALTER TABLE `clazz` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `cost`
--

DROP TABLE IF EXISTS `cost`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `cost` (
  `id` int NOT NULL AUTO_INCREMENT,
  `flight_id` int NOT NULL,
  `passengers_id` int NOT NULL,
  `class_id` int NOT NULL,
  `quantity` int NOT NULL,
  `amount` decimal(6,2) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_cost_passengers_idx` (`passengers_id`),
  KEY `fk_cost_class_idx` (`class_id`),
  KEY `fk_cost_flight_idx` (`flight_id`),
  CONSTRAINT `fk_cost_class` FOREIGN KEY (`class_id`) REFERENCES `clazz` (`id`),
  CONSTRAINT `fk_cost_flight` FOREIGN KEY (`flight_id`) REFERENCES `flight` (`id`),
  CONSTRAINT `fk_cost_passengers` FOREIGN KEY (`passengers_id`) REFERENCES `passengers` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cost`
--

LOCK TABLES `cost` WRITE;
/*!40000 ALTER TABLE `cost` DISABLE KEYS */;
/*!40000 ALTER TABLE `cost` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `country`
--

DROP TABLE IF EXISTS `country`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `country` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(45) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=26 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `country`
--

LOCK TABLES `country` WRITE;
/*!40000 ALTER TABLE `country` DISABLE KEYS */;
INSERT INTO `country` VALUES (1,'Australia'),(2,'Bangladesh'),(3,'Bosnia and Herzegovina'),(4,'Brazil'),(5,'Croatia'),(6,'Egypt'),(7,'France'),(8,'Germany'),(9,'Greece'),(10,'India'),(11,'Indonesia'),(12,'Italy'),(13,'Japan'),(14,'Morocco'),(15,'Netherladns'),(16,'Russia'),(17,'Serbia'),(18,'Singapore'),(19,'Spain'),(20,'Switzerland'),(21,'Thailand'),(22,'Turkey'),(23,'United Arab Emirates'),(24,'United Kingdom'),(25,'United States');
/*!40000 ALTER TABLE `country` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `flight`
--

DROP TABLE IF EXISTS `flight`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `flight` (
  `id` int NOT NULL AUTO_INCREMENT,
  `departureAirport` varchar(255) NOT NULL,
  `arrivalAirport` varchar(255) NOT NULL,
  `departureDate` date NOT NULL,
  `user_creator_id` int NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_flight_user_idx` (`user_creator_id`),
  KEY `fk_from_idx` (`departureAirport`),
  KEY `fk_flight_town2_idx` (`arrivalAirport`),
  CONSTRAINT `fk_flight_user` FOREIGN KEY (`user_creator_id`) REFERENCES `users` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `flight`
--

LOCK TABLES `flight` WRITE;
/*!40000 ALTER TABLE `flight` DISABLE KEYS */;
INSERT INTO `flight` VALUES (1,'Dubai','Tokyo','2022-07-31',6);
/*!40000 ALTER TABLE `flight` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `passengers`
--

DROP TABLE IF EXISTS `passengers`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `passengers` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(45) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `passengers`
--

LOCK TABLES `passengers` WRITE;
/*!40000 ALTER TABLE `passengers` DISABLE KEYS */;
INSERT INTO `passengers` VALUES (1,'Adult'),(2,'Children');
/*!40000 ALTER TABLE `passengers` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `privilege`
--

DROP TABLE IF EXISTS `privilege`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `privilege` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(45) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `privilege`
--

LOCK TABLES `privilege` WRITE;
/*!40000 ALTER TABLE `privilege` DISABLE KEYS */;
INSERT INTO `privilege` VALUES (1,'Client'),(2,'Manager'),(3,'Administrator');
/*!40000 ALTER TABLE `privilege` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `town`
--

DROP TABLE IF EXISTS `town`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `town` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(45) NOT NULL,
  `country_id` int NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_town_country_idx` (`country_id`),
  CONSTRAINT `fk_town_country` FOREIGN KEY (`country_id`) REFERENCES `country` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=33 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `town`
--

LOCK TABLES `town` WRITE;
/*!40000 ALTER TABLE `town` DISABLE KEYS */;
INSERT INTO `town` VALUES (1,'Amsterdam',15),(2,'Athens',9),(3,'Bali',11),(4,'Bangkok',21),(5,'Barcelona',19),(6,'Belgrade',17),(7,'Cairo',6),(8,'Casablanca',14),(9,'Dhaka',2),(10,'Dubai',23),(11,'Geneva',20),(12,'Istanbul',22),(13,'Jakarta',11),(14,'London',24),(15,'Los Angeles',25),(16,'Melbourne',1),(17,'Milan',12),(18,'Moscow',16),(19,'Munich',8),(20,'New Delhi',10),(21,'New York',25),(22,'Osaka',13),(23,'Paris',7),(24,'Rio de Jeneiro',4),(25,'Rome',12),(26,'Sao Paulo',4),(27,'Sarajevo',3),(28,'Singapore',18),(29,'Sydney',1),(30,'Tokyo',13),(31,'Zagreb',5),(32,'Washington D. C.',25);
/*!40000 ALTER TABLE `town` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `users`
--

DROP TABLE IF EXISTS `users`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `users` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(255) NOT NULL,
  `surname` varchar(255) NOT NULL,
  `username` varchar(255) NOT NULL,
  `password` varchar(255) NOT NULL,
  `email` varchar(255) NOT NULL,
  `country_id` int NOT NULL,
  `privilege_id` int NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `email_UNIQUE` (`email`),
  UNIQUE KEY `username_UNIQUE` (`username`),
  KEY `fk_user_privilege_idx` (`privilege_id`),
  KEY `fk_user_country_idx` (`country_id`),
  CONSTRAINT `fk_user_country` FOREIGN KEY (`country_id`) REFERENCES `country` (`id`),
  CONSTRAINT `fk_user_privilege` FOREIGN KEY (`privilege_id`) REFERENCES `privilege` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `users`
--

LOCK TABLES `users` WRITE;
/*!40000 ALTER TABLE `users` DISABLE KEYS */;
INSERT INTO `users` VALUES (6,'administrator','admin','administrator','PBKDF2WithHmacSHA256:2048:CcYh6LvV1y1HcsSclICLqaBrG4g8GaYJUdO4s51Hkvs=:xUA0cyz/j7IBgdx3CDnYblCbPQHeT0R0HMqDxalaZZQ=','admin@admin.com',3,3),(7,'Sanel','Sancho','Sancho','PBKDF2WithHmacSHA256:2048:rYO7Ebir+sgcc46r3FxWzhiu8E4C/nbzfM9zDCDEiGs=:U6b6wNKQwR0cnGH5kERi5tI4tMj1bGwOl4ro21+MHYY=','sancho@hotmail.com',3,1);
/*!40000 ALTER TABLE `users` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2022-07-21 22:57:15
