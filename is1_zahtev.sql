-- MySQL dump 10.13  Distrib 8.0.18, for Win64 (x86_64)
--
-- Host: localhost    Database: is1
-- ------------------------------------------------------
-- Server version	8.0.18

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
-- Table structure for table `zahtev`
--

DROP TABLE IF EXISTS `zahtev`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `zahtev` (
  `idZahteva` int(11) NOT NULL AUTO_INCREMENT,
  `jmbg` varchar(13) NOT NULL,
  `ime` varchar(45) NOT NULL,
  `prezime` varchar(45) NOT NULL,
  `imeMajke` varchar(45) NOT NULL,
  `prezimeMajke` varchar(45) NOT NULL,
  `imeOca` varchar(45) NOT NULL,
  `prezimeOca` varchar(45) NOT NULL,
  `pol` varchar(45) NOT NULL,
  `datumRodjenja` varchar(45) NOT NULL,
  `nacionalnost` varchar(45) NOT NULL,
  `profesija` varchar(45) NOT NULL,
  `bracnoStanje` varchar(45) NOT NULL,
  `opstina` varchar(45) NOT NULL,
  `ulica` varchar(45) NOT NULL,
  `brojUlice` varchar(45) NOT NULL,
  `status` varchar(45) NOT NULL,
  `brojZahteva` varchar(12) NOT NULL,
  PRIMARY KEY (`idZahteva`),
  UNIQUE KEY `brojZahteva_UNIQUE` (`brojZahteva`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci; --COLLATE=utf8mb4_0900_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `zahtev`
--

LOCK TABLES `zahtev` WRITE;
/*!40000 ALTER TABLE `zahtev` DISABLE KEYS */;
INSERT INTO `zahtev` VALUES (1,'2311943849261','Andjela','Popovic','Nikolina','Stefanovic','Vuk','Stojanovic','zenski','1943-11-23','srpska','lekar','ozenjen/udata','Stari Grad','Desanke Maksimovic','12','urucen','170850000001'),(2,'2710987069117','Kristina','Stefanovic','Marija','Krstic','Marko','Markovic','zenski','1987-10-27','neizjasnjen','veterinar','ozenjen/udata','Vracar','Vladike N. Velimirovica','13','urucen','170850000002'),(3,'1709927774278','Milos','Stojanovic','Dragana','Petrovic','Marko','Stefanovic','muski','1927-09-17','italijanska','student','razveden/a','Nis','Kneza Milosa','13','urucen','170850000003'),(4,'0202922404315','Aleksandar','Stojanovic','Kristina','Nikolic','Vuk','Stefanovic','muski','1922-02-02','italijanska','postar','razveden/a','Vracar','Jovana J. Zmaja','29','urucen','170850000004'),(5,'0208942674406','Aleksandar','Stojanovic','Kristina','Petrovic','Vuk','Petrovic','muski','1942-08-02','hrvatska','lekar','razveden/a','Arandjelovac','Jovana J. Zmaja','27','urucen','170850000005'),(6,'1208952582953','Dusan','Nikolic','Kristina','Nikolic','Milos','Nikolic','muski','1952-08-12','francuska','vodoinstalater','ozenjen/udata','Arandjelovac','Kneza Milosa','10','urucen','170850000006'),(7,'2611966181423','Igor','Krstic','Nikolina','Stojanovic','Marko','Petrovic','muski','1966-11-26','nemacka','policajac','udovac/udovica','Subotica','Cara Dusana','18','urucen','170850000007'),(8,'0202922963284','Dusan','Jovanovic','Danijela','Petrovic','Nikola','Nikolic','muski','1922-02-02','hrvatska','stolar','udovac/udovica','Subotica','Vladike N. Velimirovica','2','urucen','170850000008'),(9,'1011980707640','Tamara','Cosic','Dragana','Markovic','Dusan','Cosic','zenski','1980-11-10','francuska','vodoinstalater','razveden/a','Vracar','Cara Dusana','10','urucen','170850000009'),(10,'2811968768226','Jovana','Popovic','Andjela','Popovic','Aleksandar','Krstic','zenski','1968-11-28','nemacka','mehanicar','razveden/a','Nis','Jovana J. Zmaja','27','urucen','170850000010'),(11,'1205962363320','Vuk','Pesic','Maja','Nikolic','Vuk','Krstic','muski','1962-05-12','engleska','bez profesije','ozenjen/udata','Arandjelovac','Desanke Maksimovic','29','urucen','170850000011'),(12,'2202942751647','Igor','Cosic','Kristina','Nikolic','Marko','Stojanovic','muski','1942-02-22','srpska','lekar','udovac/udovica','Kragujevac','Desanke Maksimovic','6','urucen','170850000012'),(13,'1008940892877','Igor','Petrovic','Maja','Stefanovic','Nikola','Popovic','muski','1940-08-10','engleska','vodoinstalater','udovac/udovica','Kragujevac','Desanke Maksimovic','8','urucen','170850000013'),(14,'0209962724848','Ognjen','Stefanovic','Andjela','Stojanovic','Milos','Stojanovic','muski','1962-09-02','srpska','postar','ozenjen/udata','Novi Pazar','Desanke Maksimovic','23','urucen','170850000014'),(15,'1305923024823','Nikola','Jovanovic','Dragana','Popovic','Marko','Stojanovic','muski','1923-05-13','madjarska','vodoinstalater','ozenjen/udata','Novi Sad','Kralja Milana','6','urucen','170850000015');
/*!40000 ALTER TABLE `zahtev` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2020-02-01 23:19:06
