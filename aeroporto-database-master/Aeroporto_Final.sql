-- MySQL dump 10.13  Distrib 8.0.17, for Win64 (x86_64)
--
-- Host: localhost    Database: aeroporto
-- ------------------------------------------------------
-- Server version	8.0.17

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `aeroporto`
--

DROP TABLE IF EXISTS `aeroporto`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `aeroporto` (
  `IDAEROPORTO` varchar(9) NOT NULL,
  `NOMEAEROPORTO` varchar(100) NOT NULL,
  PRIMARY KEY (`IDAEROPORTO`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `aeroporto`
--

LOCK TABLES `aeroporto` WRITE;
/*!40000 ALTER TABLE `aeroporto` DISABLE KEYS */;
INSERT INTO `aeroporto` VALUES ('032150154','Aeroporto de Bras├¡lia'),('123456789','Aeroporto Salgado Filho'),('444555666','Aeroporto Santos Dumont'),('555666993','Aeroporto de Guarulhos');
/*!40000 ALTER TABLE `aeroporto` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `aviao`
--

DROP TABLE IF EXISTS `aviao`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `aviao` (
  `IDAVIAO` int(5) NOT NULL,
  `TIPOAVIAO` varchar(20) DEFAULT NULL,
  `NUMEROASSENTOS` int(11) DEFAULT NULL,
  `NUMEROVOO` int(4) NOT NULL,
  PRIMARY KEY (`IDAVIAO`),
  KEY `NUMEROVOO` (`NUMEROVOO`),
  CONSTRAINT `aviao_ibfk_1` FOREIGN KEY (`NUMEROVOO`) REFERENCES `voo` (`NUMERO`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `aviao`
--

LOCK TABLES `aviao` WRITE;
/*!40000 ALTER TABLE `aviao` DISABLE KEYS */;
INSERT INTO `aviao` VALUES (13245,'Boing 737',150,142),(45321,'Airbus 787',300,3054),(54654,'Boing 547',200,260),(78989,'Boing 767',250,1251);
/*!40000 ALTER TABLE `aviao` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `cidade`
--

DROP TABLE IF EXISTS `cidade`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `cidade` (
  `IDCIDADE` int(4) NOT NULL,
  `PAIS` varchar(15) NOT NULL,
  `NOMECIDADE` varchar(20) NOT NULL,
  PRIMARY KEY (`IDCIDADE`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cidade`
--

LOCK TABLES `cidade` WRITE;
/*!40000 ALTER TABLE `cidade` DISABLE KEYS */;
INSERT INTO `cidade` VALUES (1236,'Brasil','Rio de Janeiro'),(1594,'Brasil','Brasília'),(1687,'Brasil','Porto Alegre'),(4554,'Argentina','Buenos Aieres');
/*!40000 ALTER TABLE `cidade` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `comissario`
--

DROP TABLE IF EXISTS `comissario`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `comissario` (
  `IDCOMISSARIO` int(6) NOT NULL,
  `IDFUNC` int(3) NOT NULL,
  PRIMARY KEY (`IDCOMISSARIO`),
  KEY `IDFUNC` (`IDFUNC`),
  CONSTRAINT `comissario_ibfk_1` FOREIGN KEY (`IDFUNC`) REFERENCES `funcionario` (`IDFUNCIONARIO`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `comissario`
--

LOCK TABLES `comissario` WRITE;
/*!40000 ALTER TABLE `comissario` DISABLE KEYS */;
INSERT INTO `comissario` VALUES (301412,132),(976839,321),(103640,425),(897635,785);
/*!40000 ALTER TABLE `comissario` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `companhiaaerea`
--

DROP TABLE IF EXISTS `companhiaaerea`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `companhiaaerea` (
  `IDCOMPANHIA` varchar(8) NOT NULL,
  `NOMECOMP` varchar(30) NOT NULL,
  `CNPJ` char(9) NOT NULL,
  `TELEFONE` char(8) NOT NULL,
  `EMAIL` char(30) NOT NULL,
  PRIMARY KEY (`IDCOMPANHIA`),
  UNIQUE KEY `CNPJ` (`CNPJ`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `companhiaaerea`
--

LOCK TABLES `companhiaaerea` WRITE;
/*!40000 ALTER TABLE `companhiaaerea` DISABLE KEYS */;
INSERT INTO `companhiaaerea` VALUES ('01384130','QATAR Airlines','711654987','34565494','qairlines@gmail.com'),('12345678','LATAM','321165432','98724542','latam@gmail.com'),('35435435','Azul','321335013','31243655','azul@gmail.com'),('39334535','GOL','968636344','99886563','gol@gmail.com');
/*!40000 ALTER TABLE `companhiaaerea` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `funcionario`
--

DROP TABLE IF EXISTS `funcionario`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `funcionario` (
  `IDFUNCIONARIO` int(3) NOT NULL,
  `PNOME` varchar(15) NOT NULL,
  `MNOME` char(1) DEFAULT NULL,
  `SNOME` varchar(15) NOT NULL,
  `DOCUMENTO` char(12) NOT NULL,
  `IDIOMA` char(20) DEFAULT NULL,
  `SEXO` char(1) DEFAULT NULL,
  `TIPO` char(15) DEFAULT NULL,
  `COMPANHIA` varchar(8) NOT NULL,
  PRIMARY KEY (`IDFUNCIONARIO`),
  UNIQUE KEY `DOCUMENTO` (`DOCUMENTO`),
  KEY `COMPANHIA` (`COMPANHIA`),
  CONSTRAINT `funcionario_ibfk_1` FOREIGN KEY (`COMPANHIA`) REFERENCES `companhiaaerea` (`IDCOMPANHIA`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `funcionario`
--

LOCK TABLES `funcionario` WRITE;
/*!40000 ALTER TABLE `funcionario` DISABLE KEYS */;
INSERT INTO `funcionario` VALUES (5,'Anita','T','Hall','987654321123','Português','F','Piloto','39334535'),(23,'Charles','F','Corona','357946351236','Português','M','Piloto','12345678'),(56,'James','K','Garza','313545211236','Alemão','M','Piloto','01384130'),(132,'Janice','A','Rodriguez','135525113314','Espanhol','F','Comissária','39334535'),(321,'Tia','C','Gaines','376491372763','Inglês','F','Comissário','12345678'),(425,'James','K','Garza','456324143141','Português','M','Comissário','01384130'),(686,'Robert ','A','Thomas','322103354546','Português','M','Piloto','35435435'),(785,'Joseph','E','Lui','111222333444','Português','M','Comissário','35435435');
/*!40000 ALTER TABLE `funcionario` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `passageiro`
--

DROP TABLE IF EXISTS `passageiro`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `passageiro` (
  `IDPASSAGEIRO` int(6) NOT NULL,
  `PNOME` varchar(15) NOT NULL,
  `MNOME` char(1) DEFAULT NULL,
  `SNOME` varchar(15) NOT NULL,
  `PASSAPORTE` varchar(11) NOT NULL,
  `IDADE` int(2) DEFAULT NULL,
  `NVOOP` int(4) NOT NULL,
  PRIMARY KEY (`PASSAPORTE`),
  KEY `NVOOP` (`NVOOP`),
  CONSTRAINT `passageiro_ibfk_1` FOREIGN KEY (`NVOOP`) REFERENCES `voo` (`NUMERO`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `passageiro`
--

LOCK TABLES `passageiro` WRITE;
/*!40000 ALTER TABLE `passageiro` DISABLE KEYS */;
INSERT INTO `passageiro` VALUES (532996,'Terrence','D','Sheehan','12345678-XX',29,260),(369012,'Jerry','S','McGuire','13543713-US',61,1251),(204603,'Mildred','D','Shute','26423469-AR',37,260),(241030,'John','S','Corn','32156541-BR',55,260),(130341,'Daniel','M','Cowans','39548437-BR',79,142),(3164,'Mary','K','Riley','54764631-EU',75,3054);
/*!40000 ALTER TABLE `passageiro` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `piloto`
--

DROP TABLE IF EXISTS `piloto`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `piloto` (
  `IDPILOTO` int(6) NOT NULL,
  `HORASVOO` int(11) NOT NULL,
  `IDFUNC` int(3) NOT NULL,
  PRIMARY KEY (`IDPILOTO`),
  KEY `IDFUNC` (`IDFUNC`),
  CONSTRAINT `piloto_ibfk_1` FOREIGN KEY (`IDFUNC`) REFERENCES `funcionario` (`IDFUNCIONARIO`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `piloto`
--

LOCK TABLES `piloto` WRITE;
/*!40000 ALTER TABLE `piloto` DISABLE KEYS */;
INSERT INTO `piloto` VALUES (183462,2000,5),(236520,5000,23),(315482,4000,56),(365312,7000,686);
/*!40000 ALTER TABLE `piloto` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `trecho`
--

DROP TABLE IF EXISTS `trecho`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `trecho` (
  `IDTRECHO` int(4) NOT NULL,
  `NVOO` int(4) NOT NULL,
  `IDA` int(5) NOT NULL,
  `IDP` int(6) NOT NULL,
  `IDC` int(6) NOT NULL,
  `IDAERO` varchar(9) NOT NULL,
  PRIMARY KEY (`IDTRECHO`),
  KEY `NVOO` (`NVOO`),
  KEY `IDA` (`IDA`),
  KEY `IDP` (`IDP`),
  KEY `IDC` (`IDC`),
  KEY `IDAERO` (`IDAERO`),
  CONSTRAINT `trecho_ibfk_1` FOREIGN KEY (`NVOO`) REFERENCES `voo` (`NUMERO`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `trecho_ibfk_2` FOREIGN KEY (`IDA`) REFERENCES `aviao` (`IDAVIAO`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `trecho_ibfk_3` FOREIGN KEY (`IDP`) REFERENCES `piloto` (`IDPILOTO`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `trecho_ibfk_4` FOREIGN KEY (`IDC`) REFERENCES `comissario` (`IDCOMISSARIO`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `trecho_ibfk_5` FOREIGN KEY (`IDAERO`) REFERENCES `aeroporto` (`IDAEROPORTO`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `trecho`
--

LOCK TABLES `trecho` WRITE;
/*!40000 ALTER TABLE `trecho` DISABLE KEYS */;
INSERT INTO `trecho` VALUES (1234,260,54654,183462,301412,'444555666'),(4635,1251,78989,236520,103640,'123456789'),(6556,142,13245,315482,976839,'555666993'),(9835,3054,45321,365312,897635,'032150154');
/*!40000 ALTER TABLE `trecho` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `voo`
--

DROP TABLE IF EXISTS `voo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `voo` (
  `NUMERO` int(4) NOT NULL,
  PRIMARY KEY (`NUMERO`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `voo`
--

LOCK TABLES `voo` WRITE;
/*!40000 ALTER TABLE `voo` DISABLE KEYS */;
INSERT INTO `voo` VALUES (142),(260),(1251),(3054);
/*!40000 ALTER TABLE `voo` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2019-11-30 20:00:28
