-- MySQL dump 10.13  Distrib 8.0.29, for Win64 (x86_64)
--
-- Host: localhost    Database: sistema_negocio
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
-- Table structure for table `administrador`
--

DROP TABLE IF EXISTS `administrador`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `administrador` (
  `admin_codigo` int NOT NULL AUTO_INCREMENT,
  `admin_usuario` varchar(25) NOT NULL,
  `admin_password` varchar(25) NOT NULL,
  `admin_nombre` varchar(25) NOT NULL,
  `admin_apellido` varchar(25) NOT NULL,
  PRIMARY KEY (`admin_codigo`),
  UNIQUE KEY `admin_usuario_UNIQUE` (`admin_usuario`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `administrador`
--

LOCK TABLES `administrador` WRITE;
/*!40000 ALTER TABLE `administrador` DISABLE KEYS */;
INSERT INTO `administrador` VALUES (1,'dk','1234567','eun','ads'),(2,'dkdk','123456','eu','k');
/*!40000 ALTER TABLE `administrador` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `cliente`
--

DROP TABLE IF EXISTS `cliente`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `cliente` (
  `cli_codigo` int NOT NULL AUTO_INCREMENT,
  `cli_nombre` varchar(20) DEFAULT NULL,
  `cli_apellido` varchar(15) DEFAULT NULL,
  `cli_telefono` varchar(15) DEFAULT NULL,
  `cli_correo` varchar(30) DEFAULT NULL,
  `ven_codigo` int NOT NULL,
  PRIMARY KEY (`cli_codigo`,`ven_codigo`),
  KEY `fk_cliente_empleado1_idx` (`ven_codigo`),
  CONSTRAINT `fk_cliente_empleado1` FOREIGN KEY (`ven_codigo`) REFERENCES `vendedor` (`ven_codigo`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cliente`
--

LOCK TABLES `cliente` WRITE;
/*!40000 ALTER TABLE `cliente` DISABLE KEYS */;
INSERT INTO `cliente` VALUES (1,'Diego','Per','123241','fasjdi@gm.com',1);
/*!40000 ALTER TABLE `cliente` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `local`
--

DROP TABLE IF EXISTS `local`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `local` (
  `loc_codigo` int NOT NULL AUTO_INCREMENT,
  `loc_descripcion` varchar(35) DEFAULT NULL,
  `neg_codigo` int NOT NULL,
  PRIMARY KEY (`loc_codigo`),
  KEY `fk_local_negocio1_idx` (`neg_codigo`),
  CONSTRAINT `fk_local_negocio1` FOREIGN KEY (`neg_codigo`) REFERENCES `negocio` (`neg_codigo`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `local`
--

LOCK TABLES `local` WRITE;
/*!40000 ALTER TABLE `local` DISABLE KEYS */;
INSERT INTO `local` VALUES (1,'Asuncion',11),(2,'CDE',12);
/*!40000 ALTER TABLE `local` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `negocio`
--

DROP TABLE IF EXISTS `negocio`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `negocio` (
  `neg_codigo` int NOT NULL AUTO_INCREMENT,
  `neg_descripcion` varchar(35) DEFAULT NULL,
  `pais_codigo` int NOT NULL,
  PRIMARY KEY (`neg_codigo`),
  UNIQUE KEY `neg_descripcion_UNIQUE` (`neg_descripcion`),
  KEY `fk_negocio_pais_idx` (`pais_codigo`),
  CONSTRAINT `fk_negocio_pais` FOREIGN KEY (`pais_codigo`) REFERENCES `pais` (`pais_codigo`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `negocio`
--

LOCK TABLES `negocio` WRITE;
/*!40000 ALTER TABLE `negocio` DISABLE KEYS */;
INSERT INTO `negocio` VALUES (11,'Stock',10),(12,'Biggie',12);
/*!40000 ALTER TABLE `negocio` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `pais`
--

DROP TABLE IF EXISTS `pais`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `pais` (
  `pais_codigo` int NOT NULL AUTO_INCREMENT,
  `pais_descripcion` varchar(30) DEFAULT NULL,
  PRIMARY KEY (`pais_codigo`),
  UNIQUE KEY `pais_descripcion_UNIQUE` (`pais_descripcion`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `pais`
--

LOCK TABLES `pais` WRITE;
/*!40000 ALTER TABLE `pais` DISABLE KEYS */;
INSERT INTO `pais` VALUES (12,'Colombia'),(10,'Paraguay');
/*!40000 ALTER TABLE `pais` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `vendedor`
--

DROP TABLE IF EXISTS `vendedor`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `vendedor` (
  `ven_codigo` int NOT NULL AUTO_INCREMENT,
  `ven_cedula` varchar(10) DEFAULT NULL,
  `ven_nombre` varchar(20) DEFAULT NULL,
  `ven_apellido` varchar(15) DEFAULT NULL,
  `ven_telefono` varchar(45) DEFAULT NULL,
  `ven_correo` varchar(30) DEFAULT NULL,
  `loc_codigo` int NOT NULL,
  PRIMARY KEY (`ven_codigo`),
  KEY `fk_empleado_local1_idx` (`loc_codigo`),
  CONSTRAINT `fk_empleado_local1` FOREIGN KEY (`loc_codigo`) REFERENCES `local` (`loc_codigo`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `vendedor`
--

LOCK TABLES `vendedor` WRITE;
/*!40000 ALTER TABLE `vendedor` DISABLE KEYS */;
INSERT INTO `vendedor` VALUES (1,'2321341','Pope','Perez','443-312','fadf@gm.com',1),(2,'4123','adf','asdf','1234','asdfas',2);
/*!40000 ALTER TABLE `vendedor` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2022-07-05 21:14:04
