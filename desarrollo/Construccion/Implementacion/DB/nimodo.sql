-- MySQL dump 10.13  Distrib 8.0.18, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: nimodo
-- ------------------------------------------------------
-- Server version	5.7.26

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
-- Table structure for table `alternativa`
--

DROP TABLE IF EXISTS `alternativa`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `alternativa` (
  `idalternativa` int(11) NOT NULL AUTO_INCREMENT,
  `descripcion` varchar(45) NOT NULL,
  `success` double NOT NULL,
  `idpregunta` int(11) NOT NULL,
  PRIMARY KEY (`idalternativa`),
  KEY `fk_alternativa_pregunta1_idx` (`idpregunta`),
  CONSTRAINT `fk_alternativa_pregunta1` FOREIGN KEY (`idpregunta`) REFERENCES `pregunta` (`idpregunta`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=451 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `alternativa`
--

LOCK TABLES `alternativa` WRITE;
/*!40000 ALTER TABLE `alternativa` DISABLE KEYS */;
INSERT INTO `alternativa` VALUES (1,'3',1,1),(2,'2',0,1),(3,'4',0,1),(4,'6',1,2),(5,'8',0,2),(6,'7',0,2),(7,'12',1,3),(8,'8',0,3),(9,'7',0,3),(10,'12',0,4),(11,'17',1,4),(12,'16',0,4),(13,'12',0,5),(14,'22',1,5),(15,'20',0,5),(16,'42',0,6),(17,'44',1,6),(18,'40',0,6),(19,'Segundo',0,7),(20,'Primero',0,7),(21,'Tercero',1,7),(22,'Segundo',0,8),(23,'Primero',1,8),(24,'Tercero',0,8),(25,'Segundo',0,9),(26,'Primero',1,9),(27,'Tercero',0,9),(28,'4',0,10),(29,'6',1,10),(30,'8',0,10),(31,'4',0,11),(32,'16',1,11),(33,'8',0,11),(34,'10',0,12),(35,'20',1,12),(36,'15',0,12),(37,'25',0,13),(38,'50',1,13),(39,'70',0,13),(40,'100',0,14),(41,'50',1,14),(42,'70',0,14),(43,'10',0,15),(44,'20',1,15),(45,'30',0,15),(46,'Manuel',1,16),(47,'Juan',0,16),(48,'Ambos',0,16),(49,'Manuel',1,17),(50,'Juan',0,17),(51,'Ambos',0,17),(52,'Raúl',1,18),(53,'María',0,18),(54,'Ninguno',0,18),(55,'No',0,19),(56,'Sí',1,19),(57,'Talvez',0,19),(58,'No',0,20),(59,'Sí',1,20),(60,'Talvez',0,20),(61,'No',0,21),(62,'Sí',1,21),(63,'Talvez',0,21),(64,'5',1,22),(65,'2',0,22),(66,'4',0,22),(67,'6',1,23),(68,'2',0,23),(69,'4',0,23),(70,'17',1,24),(71,'7',0,24),(72,'13',0,24),(73,'85',1,25),(74,'75',0,25),(75,'76',0,25),(76,'77',1,26),(77,'75',0,26),(78,'76',0,26),(79,'67',1,27),(80,'65',0,27),(81,'66',0,27),(82,'10',0,28),(83,'8',0,28),(84,'5',1,28),(85,'5',0,29),(86,'8',0,29),(87,'10',1,29),(88,'13',0,30),(89,'18',0,30),(90,'23',1,30),(91,'40',1,31),(92,'60',0,31),(93,'70',0,31),(94,'55',1,32),(95,'60',0,32),(96,'70',0,32),(97,'32',1,33),(98,'30',0,33),(99,'22',0,33),(100,'2',0,34),(101,'1',1,34),(102,'3',0,34),(103,'5',0,35),(104,'2',1,35),(105,'3',0,35),(106,'11',0,36),(107,'10',1,36),(108,'20',0,36),(109,'1234abcd',0,37),(110,'12abc',0,37),(111,'123abc',1,37),(112,'1234abcde',0,38),(113,'12abc',0,38),(114,'1234abcd',1,38),(115,'58ef',0,39),(116,'567efg',0,39),(117,'56789efghi',1,39),(118,'25 m',0,40),(119,'20 m',0,40),(120,'14 m',1,40),(121,'30 m',0,41),(122,'60 m',0,41),(123,'40 m',1,41),(124,'42 m',0,42),(125,'50 m',0,42),(126,'52 m',1,42),(127,'Un Carro',0,43),(128,'Una Moto',1,43),(129,'Ninguno',0,43),(130,'Un Avión',0,44),(131,'Un Carro',1,44),(132,'Ninguno',0,44),(133,'Moto y avión',0,45),(134,'Carro y moto',1,45),(135,'Carro',0,45),(136,'3',0,46),(137,'6',1,46),(138,'4',0,46),(139,'6',0,47),(140,'12',1,47),(141,'8',0,47),(142,'6',0,48),(143,'18',1,48),(144,'12',0,48),(145,'6 m',1,49),(146,'3 m',0,49),(147,'9 m',0,49),(148,'9 m',1,50),(149,'12 m',0,50),(150,'6 m',0,50),(151,'S/ 6.00',1,51),(152,'S/ 5.00',0,51),(153,'S/ 8.00',0,51),(154,'Un perro',0,52),(155,'Un gato',1,52),(156,'Ninguno',0,52),(157,'Un gato',0,53),(158,'Un perro',1,53),(159,'Ninguno',0,53),(160,'El gato y el perro',0,54),(161,'El perro y el pato',1,54),(162,'El gato y el pato',0,54),(163,'40',0,55),(164,'30',0,55),(165,'20',1,55),(166,'100',0,56),(167,'40',0,56),(168,'160',1,56),(169,'60 m',0,57),(170,'40 m',0,57),(171,'70 m',1,57),(172,'En nada',0,58),(173,'Son cuadrados',1,58),(174,'Son triángulos',0,58),(175,'En nada',0,59),(176,'Son rectángulos',0,59),(177,'Son triángulos',1,59),(178,'Son triángulos',0,60),(179,'Son rectángulos',0,60),(180,'Son cuadriláteros',1,60),(181,'Piña',1,61),(182,'Plátano',0,61),(183,'Durazno',0,61),(184,'Pera',1,62),(185,'Plátano',0,62),(186,'Durazno',0,62),(187,'Pera y plátano',1,63),(188,'Plátano y durazno',0,63),(189,'Durazno y piña',0,63),(190,'4',0,64),(191,'2',0,64),(192,'6',1,64),(193,'Siempre',0,65),(194,'Nunca',0,65),(195,'A veces',1,65),(196,'Siempre',0,66),(197,'Nunca',0,66),(198,'A veces',1,66),(199,'Tenis',0,67),(200,'Natación',0,67),(201,'Baloncesto',1,67),(202,'Tenis',0,68),(203,'Natación',0,68),(204,'Baloncesto',1,68),(205,'Tenis y natación',0,69),(206,'Natación y tenis',0,69),(207,'Fútbol y baloncesto',1,69),(208,'8 goles',1,70),(209,'6 goles',0,70),(210,'5 goles',0,70),(211,'16 goles',1,71),(212,'8 goles',0,71),(213,'10 goles',0,71),(214,'11 goles',1,72),(215,'12 goles',0,72),(216,'10 goles',0,72),(217,'12 días',0,73),(218,'8 días',0,73),(219,'9 días',1,73),(220,'12 días',0,74),(221,'9 días',0,74),(222,'4 días',1,74),(223,'8 días',0,75),(224,'21 días',0,75),(225,'12 días',1,75),(226,'3',1,76),(227,'2',0,76),(228,'4',0,76),(229,'6',1,77),(230,'8',0,77),(231,'7',0,77),(232,'12',1,78),(233,'8',0,78),(234,'7',0,78),(235,'12',0,79),(236,'17',1,79),(237,'16',0,79),(238,'12',0,80),(239,'22',1,80),(240,'20',0,80),(241,'42',0,81),(242,'44',1,81),(243,'40',0,81),(244,'Segundo',0,82),(245,'Primero',0,82),(246,'Tercero',1,82),(247,'Segundo',0,83),(248,'Primero',1,83),(249,'Tercero',0,83),(250,'Segundo',0,84),(251,'Primero',1,84),(252,'Tercero',0,84),(253,'4',0,85),(254,'6',1,85),(255,'8',0,85),(256,'4',0,86),(257,'16',1,86),(258,'8',0,86),(259,'10',0,87),(260,'20',1,87),(261,'15',0,87),(262,'25 m',0,88),(263,'50 m',1,88),(264,'70 m',0,88),(265,'100 m',0,89),(266,'50 m',1,89),(267,'70 m',0,89),(268,'10',0,90),(269,'20',1,90),(270,'30',0,90),(271,'Manuel',1,91),(272,'Juan',0,91),(273,'Ambos',0,91),(274,'Manuel',1,92),(275,'Juan',0,92),(276,'Ambos',0,92),(277,'Raúl',1,93),(278,'María',0,93),(279,'Ninguno',0,93),(280,'No',0,94),(281,'Si',1,94),(282,'Talvez',0,94),(283,'No',0,95),(284,'Si',1,95),(285,'Talvez',0,95),(286,'No',0,96),(287,'Sí',1,96),(288,'Talvez',0,96),(289,'5',1,97),(290,'2',0,97),(291,'4',0,97),(292,'6',1,98),(293,'2',0,98),(294,'4',0,98),(295,'17',1,99),(296,'7',0,99),(297,'13',0,99),(298,'85',1,100),(299,'75',0,100),(300,'76',0,100),(301,'77',1,101),(302,'75',0,101),(303,'76',0,101),(304,'67',1,102),(305,'65',0,102),(306,'66',0,102),(307,'10',0,103),(308,'8',0,103),(309,'5',1,103),(310,'5',0,104),(311,'8',0,104),(312,'10',1,104),(313,'13',0,105),(314,'18',0,105),(315,'23',1,105),(316,'40',1,106),(317,'60',0,106),(318,'70',0,106),(319,'55',1,107),(320,'60',0,107),(321,'70',0,107),(322,'32',1,108),(323,'30',0,108),(324,'22',0,108),(325,'2',0,109),(326,'1',1,109),(327,'3',0,109),(328,'5',0,110),(329,'2',1,110),(330,'3',0,110),(331,'11',0,111),(332,'10',1,111),(333,'20',0,111),(334,'1234abcd',0,112),(335,'12abc',0,112),(336,'123abc',1,112),(337,'123ab',0,113),(338,'12abc',0,113),(339,'1234abcd',1,113),(340,'58ef',0,114),(341,'567efg',0,114),(342,'56789efghi',1,114),(343,'25 m',0,115),(344,'20 m',0,115),(345,'14 m',1,115),(346,'30 m',0,116),(347,'60 m',0,116),(348,'40 m',1,116),(349,'42 m',0,117),(350,'50 m',0,117),(351,'52 m',1,117),(352,'Un Carro',0,118),(353,'Una Moto',1,118),(354,'Ninguno',0,118),(355,'Un Avión',0,119),(356,'Un Carro',1,119),(357,'Ninguno',0,119),(358,'Moto y avión',0,120),(359,'Carro y moto',1,120),(360,'Carro',0,120),(361,'3',0,121),(362,'6',1,121),(363,'4',0,121),(364,'6',0,122),(365,'12',1,122),(366,'8',0,122),(367,'6',0,123),(368,'18',1,123),(369,'12',0,123),(370,'6 m',1,124),(371,'3 m',0,124),(372,'9 m',0,124),(373,'9 m',1,125),(374,'12 m',0,125),(375,'6 m',0,125),(376,'S/ 6.00',1,126),(377,'S/ 5.00',0,126),(378,'S/ 8.00',0,126),(379,'El Perro',0,127),(380,'El Gato',1,127),(381,'Ninguno',0,127),(382,'El Gato',0,128),(383,'El Perro',1,128),(384,'Ninguno',0,128),(385,'El gato y el perro',0,129),(386,'El perro y el pato',1,129),(387,'El gato y el pato',0,129),(388,'40',0,130),(389,'30',0,130),(390,'20',1,130),(391,'100',0,131),(392,'40',0,131),(393,'160',1,131),(394,'60 m',0,132),(395,'40 m',0,132),(396,'70 m',1,132),(397,'En nada',0,133),(398,'Son cuadrados',1,133),(399,'Son triángulos',0,133),(400,'En nada',0,134),(401,'Son rectángulos',0,134),(402,'Son triángulos',1,134),(403,'Son triángulos',0,135),(404,'Son rectángulos',0,135),(405,'Son cuadriláteros',1,135),(406,'Piña',1,136),(407,'Plátano',0,136),(408,'Durazno',0,136),(409,'Pera',1,137),(410,'Plátano',0,137),(411,'Durazno',0,137),(412,'Pera y plátano',1,138),(413,'Plátano y durazno',0,138),(414,'Durazno y piña',0,138),(415,'4',0,139),(416,'2',0,139),(417,'6',1,139),(418,'Siempre',0,140),(419,'Nunca',0,140),(420,'A veces',1,140),(421,'Siempre',0,141),(422,'Nunca',0,141),(423,'A veces',1,141),(424,'Tenis',0,142),(425,'Natación',0,142),(426,'Baloncesto',1,142),(427,'Tenis',0,143),(428,'Natación',0,143),(429,'Baloncesto',1,143),(430,'Tenis y natación',0,144),(431,'Natación y tenis',0,144),(432,'Fútbol y baloncesto',1,144),(433,'8 goles',1,145),(434,'6 goles',0,145),(435,'5 goles',0,145),(436,'16 goles',1,146),(437,'8 goles',0,146),(438,'10 goles',0,146),(439,'11 goles',1,147),(440,'12 goles',0,147),(441,'10 goles',0,147),(442,'12 días',0,148),(443,'8 días',0,148),(444,'9 días',1,148),(445,'12 días',0,149),(446,'9 días',0,149),(447,'4 días',1,149),(448,'6 días',0,150),(449,'21 días',0,150),(450,'12 días',1,150);
/*!40000 ALTER TABLE `alternativa` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `apariencia`
--

DROP TABLE IF EXISTS `apariencia`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `apariencia` (
  `idapariencia` int(11) NOT NULL AUTO_INCREMENT,
  `dni` varchar(8) NOT NULL,
  `idlookandfeel` int(11) NOT NULL,
  PRIMARY KEY (`idapariencia`),
  KEY `fk_apariencia_lookandfeel1_idx` (`idlookandfeel`),
  KEY `fk_apariencia_persona1_idx` (`dni`),
  CONSTRAINT `fk_apariencia_lookandfeel1` FOREIGN KEY (`idlookandfeel`) REFERENCES `lookandfeel` (`idlookandfeel`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `fk_apariencia_persona1` FOREIGN KEY (`dni`) REFERENCES `persona` (`dni`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `apariencia`
--

LOCK TABLES `apariencia` WRITE;
/*!40000 ALTER TABLE `apariencia` DISABLE KEYS */;
INSERT INTO `apariencia` VALUES (1,'73475373',2),(2,'12345678',2);
/*!40000 ALTER TABLE `apariencia` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `area`
--

DROP TABLE IF EXISTS `area`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `area` (
  `idarea` int(11) NOT NULL AUTO_INCREMENT,
  `area` varchar(45) NOT NULL,
  `descripcion` varchar(45) NOT NULL,
  PRIMARY KEY (`idarea`),
  UNIQUE KEY `area_UNIQUE` (`area`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `area`
--

LOCK TABLES `area` WRITE;
/*!40000 ALTER TABLE `area` DISABLE KEYS */;
INSERT INTO `area` VALUES (1,'Matemática','Area curricular de Matemática');
/*!40000 ALTER TABLE `area` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `audio`
--

DROP TABLE IF EXISTS `audio`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `audio` (
  `idaudio` int(11) NOT NULL AUTO_INCREMENT,
  `audio` varchar(100) NOT NULL,
  `idpregunta` int(11) NOT NULL,
  PRIMARY KEY (`idaudio`),
  KEY `fk_audio_pregunta1_idx` (`idpregunta`),
  CONSTRAINT `fk_audio_pregunta1` FOREIGN KEY (`idpregunta`) REFERENCES `pregunta` (`idpregunta`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=76 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `audio`
--

LOCK TABLES `audio` WRITE;
/*!40000 ALTER TABLE `audio` DISABLE KEYS */;
INSERT INTO `audio` VALUES (1,'C:\\wamp64\\www\\Nimodo\\NimodoStudent\\pdo\\audio\\76.ogg',76),(2,'C:\\wamp64\\www\\Nimodo\\NimodoStudent\\pdo\\audio\\77.ogg',77),(3,'C:\\wamp64\\www\\Nimodo\\NimodoStudent\\pdo\\audio\\78.ogg',78),(4,'C:\\wamp64\\www\\Nimodo\\NimodoStudent\\pdo\\audio\\79.ogg',79),(5,'C:\\wamp64\\www\\Nimodo\\NimodoStudent\\pdo\\audio\\80.ogg',80),(6,'C:\\wamp64\\www\\Nimodo\\NimodoStudent\\pdo\\audio\\81.ogg',81),(7,'C:\\wamp64\\www\\Nimodo\\NimodoStudent\\pdo\\audio\\82.ogg',82),(8,'C:\\wamp64\\www\\Nimodo\\NimodoStudent\\pdo\\audio\\83.ogg',83),(9,'C:\\wamp64\\www\\Nimodo\\NimodoStudent\\pdo\\audio\\84.ogg',84),(10,'C:\\wamp64\\www\\Nimodo\\NimodoStudent\\pdo\\audio\\85.ogg',85),(11,'C:\\wamp64\\www\\Nimodo\\NimodoStudent\\pdo\\audio\\86.ogg',86),(12,'C:\\wamp64\\www\\Nimodo\\NimodoStudent\\pdo\\audio\\87.ogg',87),(13,'C:\\wamp64\\www\\Nimodo\\NimodoStudent\\pdo\\audio\\88.ogg',88),(14,'C:\\wamp64\\www\\Nimodo\\NimodoStudent\\pdo\\audio\\89.ogg',89),(15,'C:\\wamp64\\www\\Nimodo\\NimodoStudent\\pdo\\audio\\90.ogg',90),(16,'C:\\wamp64\\www\\Nimodo\\NimodoStudent\\pdo\\audio\\91.ogg',91),(17,'C:\\wamp64\\www\\Nimodo\\NimodoStudent\\pdo\\audio\\92.ogg',92),(18,'C:\\wamp64\\www\\Nimodo\\NimodoStudent\\pdo\\audio\\93.ogg',93),(19,'C:\\wamp64\\www\\Nimodo\\NimodoStudent\\pdo\\audio\\94.ogg',94),(20,'C:\\wamp64\\www\\Nimodo\\NimodoStudent\\pdo\\audio\\95.ogg',95),(21,'C:\\wamp64\\www\\Nimodo\\NimodoStudent\\pdo\\audio\\96.ogg',96),(22,'C:\\wamp64\\www\\Nimodo\\NimodoStudent\\pdo\\audio\\97.ogg',97),(23,'C:\\wamp64\\www\\Nimodo\\NimodoStudent\\pdo\\audio\\98.ogg',98),(24,'C:\\wamp64\\www\\Nimodo\\NimodoStudent\\pdo\\audio\\99.ogg',99),(25,'C:\\wamp64\\www\\Nimodo\\NimodoStudent\\pdo\\audio\\100.ogg',100),(26,'C:\\wamp64\\www\\Nimodo\\NimodoStudent\\pdo\\audio\\101.ogg',101),(27,'C:\\wamp64\\www\\Nimodo\\NimodoStudent\\pdo\\audio\\102.ogg',102),(28,'C:\\wamp64\\www\\Nimodo\\NimodoStudent\\pdo\\audio\\103.ogg',103),(29,'C:\\wamp64\\www\\Nimodo\\NimodoStudent\\pdo\\audio\\104.ogg',104),(30,'C:\\wamp64\\www\\Nimodo\\NimodoStudent\\pdo\\audio\\105.ogg',105),(31,'C:\\wamp64\\www\\Nimodo\\NimodoStudent\\pdo\\audio\\106.ogg',106),(32,'C:\\wamp64\\www\\Nimodo\\NimodoStudent\\pdo\\audio\\107.ogg',107),(33,'C:\\wamp64\\www\\Nimodo\\NimodoStudent\\pdo\\audio\\108.ogg',108),(34,'C:\\wamp64\\www\\Nimodo\\NimodoStudent\\pdo\\audio\\109.ogg',109),(35,'C:\\wamp64\\www\\Nimodo\\NimodoStudent\\pdo\\audio\\110.ogg',110),(36,'C:\\wamp64\\www\\Nimodo\\NimodoStudent\\pdo\\audio\\111.ogg',111),(37,'C:\\wamp64\\www\\Nimodo\\NimodoStudent\\pdo\\audio\\112.ogg',112),(38,'C:\\wamp64\\www\\Nimodo\\NimodoStudent\\pdo\\audio\\113.ogg',113),(39,'C:\\wamp64\\www\\Nimodo\\NimodoStudent\\pdo\\audio\\114.ogg',114),(40,'C:\\wamp64\\www\\Nimodo\\NimodoStudent\\pdo\\audio\\115.ogg',115),(41,'C:\\wamp64\\www\\Nimodo\\NimodoStudent\\pdo\\audio\\116.ogg',116),(42,'C:\\wamp64\\www\\Nimodo\\NimodoStudent\\pdo\\audio\\117.ogg',117),(43,'C:\\wamp64\\www\\Nimodo\\NimodoStudent\\pdo\\audio\\118.ogg',118),(44,'C:\\wamp64\\www\\Nimodo\\NimodoStudent\\pdo\\audio\\119.ogg',119),(45,'C:\\wamp64\\www\\Nimodo\\NimodoStudent\\pdo\\audio\\120.ogg',120),(46,'C:\\wamp64\\www\\Nimodo\\NimodoStudent\\pdo\\audio\\121.ogg',121),(47,'C:\\wamp64\\www\\Nimodo\\NimodoStudent\\pdo\\audio\\122.ogg',122),(48,'C:\\wamp64\\www\\Nimodo\\NimodoStudent\\pdo\\audio\\123.ogg',123),(49,'C:\\wamp64\\www\\Nimodo\\NimodoStudent\\pdo\\audio\\124.ogg',124),(50,'C:\\wamp64\\www\\Nimodo\\NimodoStudent\\pdo\\audio\\125.ogg',125),(51,'C:\\wamp64\\www\\Nimodo\\NimodoStudent\\pdo\\audio\\126.ogg',126),(52,'C:\\wamp64\\www\\Nimodo\\NimodoStudent\\pdo\\audio\\127.ogg',127),(53,'C:\\wamp64\\www\\Nimodo\\NimodoStudent\\pdo\\audio\\128.ogg',128),(54,'C:\\wamp64\\www\\Nimodo\\NimodoStudent\\pdo\\audio\\129.ogg',129),(55,'C:\\wamp64\\www\\Nimodo\\NimodoStudent\\pdo\\audio\\130.ogg',130),(56,'C:\\wamp64\\www\\Nimodo\\NimodoStudent\\pdo\\audio\\131.ogg',131),(57,'C:\\wamp64\\www\\Nimodo\\NimodoStudent\\pdo\\audio\\132.ogg',132),(58,'C:\\wamp64\\www\\Nimodo\\NimodoStudent\\pdo\\audio\\133.ogg',133),(59,'C:\\wamp64\\www\\Nimodo\\NimodoStudent\\pdo\\audio\\134.ogg',134),(60,'C:\\wamp64\\www\\Nimodo\\NimodoStudent\\pdo\\audio\\135.ogg',135),(61,'C:\\wamp64\\www\\Nimodo\\NimodoStudent\\pdo\\audio\\136.ogg',136),(62,'C:\\wamp64\\www\\Nimodo\\NimodoStudent\\pdo\\audio\\137.ogg',137),(63,'C:\\wamp64\\www\\Nimodo\\NimodoStudent\\pdo\\audio\\138.ogg',138),(64,'C:\\wamp64\\www\\Nimodo\\NimodoStudent\\pdo\\audio\\139.ogg',139),(65,'C:\\wamp64\\www\\Nimodo\\NimodoStudent\\pdo\\audio\\140.ogg',140),(66,'C:\\wamp64\\www\\Nimodo\\NimodoStudent\\pdo\\audio\\141.ogg',141),(67,'C:\\wamp64\\www\\Nimodo\\NimodoStudent\\pdo\\audio\\142.ogg',142),(68,'C:\\wamp64\\www\\Nimodo\\NimodoStudent\\pdo\\audio\\143.ogg',143),(69,'C:\\wamp64\\www\\Nimodo\\NimodoStudent\\pdo\\audio\\144.ogg',144),(70,'C:\\wamp64\\www\\Nimodo\\NimodoStudent\\pdo\\audio\\145.ogg',145),(71,'C:\\wamp64\\www\\Nimodo\\NimodoStudent\\pdo\\audio\\146.ogg',146),(72,'C:\\wamp64\\www\\Nimodo\\NimodoStudent\\pdo\\audio\\147.ogg',147),(73,'C:\\wamp64\\www\\Nimodo\\NimodoStudent\\pdo\\audio\\148.ogg',148),(74,'C:\\wamp64\\www\\Nimodo\\NimodoStudent\\pdo\\audio\\149.ogg',149),(75,'C:\\wamp64\\www\\Nimodo\\NimodoStudent\\pdo\\audio\\150.ogg',150);
/*!40000 ALTER TABLE `audio` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `aula`
--

DROP TABLE IF EXISTS `aula`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `aula` (
  `idaula` int(11) NOT NULL AUTO_INCREMENT,
  `idgrado` int(11) NOT NULL,
  `idseccion` int(11) NOT NULL,
  PRIMARY KEY (`idaula`),
  UNIQUE KEY `idAulaUnique` (`idgrado`,`idseccion`),
  KEY `fk_aula_grado1_idx` (`idgrado`),
  KEY `fk_aula_seccion1_idx` (`idseccion`),
  CONSTRAINT `fk_aula_grado1` FOREIGN KEY (`idgrado`) REFERENCES `grado` (`idgrado`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `fk_aula_seccion1` FOREIGN KEY (`idseccion`) REFERENCES `seccion` (`idseccion`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `aula`
--

LOCK TABLES `aula` WRITE;
/*!40000 ALTER TABLE `aula` DISABLE KEYS */;
INSERT INTO `aula` VALUES (1,2,4);
/*!40000 ALTER TABLE `aula` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `calificacion`
--

DROP TABLE IF EXISTS `calificacion`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `calificacion` (
  `idcalificacion` int(11) NOT NULL AUTO_INCREMENT,
  `calificacion` int(11) NOT NULL,
  `idevaluacion_tradicional` int(11) NOT NULL,
  PRIMARY KEY (`idcalificacion`),
  KEY `fk_calificacion_evaluacion_tradicional1_idx` (`idevaluacion_tradicional`),
  CONSTRAINT `fk_calificacion_evaluacion_tradicional1` FOREIGN KEY (`idevaluacion_tradicional`) REFERENCES `evaluacion_tradicional` (`idevaluacion_tradicional`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=101 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `calificacion`
--

LOCK TABLES `calificacion` WRITE;
/*!40000 ALTER TABLE `calificacion` DISABLE KEYS */;
INSERT INTO `calificacion` VALUES (1,12,1),(2,14,1),(3,13,1),(4,15,1),(5,11,2),(6,12,2),(7,13,2),(8,11,2),(9,13,3),(10,14,3),(11,15,3),(12,15,3),(13,14,4),(14,13,4),(15,15,4),(16,15,4),(17,12,5),(18,12,5),(19,13,5),(20,13,5),(21,11,6),(22,10,6),(23,9,6),(24,12,6),(25,13,7),(26,14,7),(27,15,7),(28,15,7),(29,14,8),(30,15,8),(31,16,8),(32,15,8),(33,12,9),(34,14,9),(35,13,9),(36,15,9),(37,15,10),(38,13,10),(39,14,10),(40,14,10),(41,11,11),(42,11,11),(43,9,11),(44,10,11),(45,12,12),(46,14,12),(47,13,12),(48,13,12),(49,14,13),(50,14,13),(51,15,13),(52,15,13),(53,13,14),(54,12,14),(55,14,14),(56,13,14),(57,12,15),(58,14,15),(59,14,15),(60,12,15),(61,15,16),(62,16,16),(63,15,16),(64,16,16),(65,12,17),(66,13,17),(67,14,17),(68,14,17),(69,13,18),(70,13,18),(71,15,18),(72,14,18),(73,14,19),(74,13,19),(75,13,19),(76,12,19),(77,15,20),(78,15,20),(79,16,20),(80,16,20),(81,14,21),(82,14,21),(83,13,21),(84,14,21),(85,12,22),(86,13,22),(87,12,22),(88,12,22),(89,11,23),(90,10,23),(91,11,23),(92,11,23),(93,14,24),(94,15,24),(95,13,24),(96,14,24),(97,12,25),(98,13,25),(99,14,25),(100,15,25);
/*!40000 ALTER TABLE `calificacion` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `capacidad`
--

DROP TABLE IF EXISTS `capacidad`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `capacidad` (
  `idcapacidad` int(11) NOT NULL AUTO_INCREMENT,
  `capacidad` varchar(200) NOT NULL,
  `descripcion` varchar(200) NOT NULL,
  PRIMARY KEY (`idcapacidad`),
  UNIQUE KEY `capacidad_UNIQUE` (`capacidad`)
) ENGINE=InnoDB AUTO_INCREMENT=18 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `capacidad`
--

LOCK TABLES `capacidad` WRITE;
/*!40000 ALTER TABLE `capacidad` DISABLE KEYS */;
INSERT INTO `capacidad` VALUES (1,'Matemática - Competencia 1 - Capacidad 1','Traduce cantidades a expresiones numéricas.'),(2,'Matemática - Competencia 1 - Capacidad 2','Comunica su comprensión sobre los números y las operaciones.'),(3,'Matemática - Competencia 1 - Capacidad 3','Usa estrategias y procedimientos de estimación y cálculo.'),(4,'Matemática - Competencia 1 - Capacidad 4','Argumenta afirmaciones sobre las relaciones numéricas y las operaciones.'),(5,'Matemática - Competencia 2 - Capacidad 1','Traduce datos y condiciones a expresiones algebraicas y gráficas.'),(6,'Matemática - Competencia 2 - Capacidad 2','Comunica su comprensión sobre las relaciones algebraicas.'),(7,'Matemática - Competencia 2 - Capacidad 3','Usa estrategias y procedimientos para encontrar equivalencias y reglas generales.'),(8,'Matemática - Competencia 2 - Capacidad 4','Argumenta afirmaciones sobre relaciones de cambio y equivalencia.'),(9,'Matemática - Competencia 3 - Capacidad 1','Modela objetos con formas geométricas y sus transformaciones.'),(10,'Matemática - Competencia 3 - Capacidad 2','Comunica su comprensión sobre las formas y relaciones geométricas.'),(11,'Matemática - Competencia 3 - Capacidad 3','Usa estrategias y procedimientos para orientarse en el espacio.'),(12,'Matemática - Competencia 3 - Capacidad 4','Argumenta afirmaciones sobre relaciones geométricas.'),(13,'Matemática - Competencia 4 - Capacidad 1','Representa datos con gráficos y medidas estadísticas o probabilísticas.'),(14,'Matemática - Competencia 4 - Capacidad 2','Comunica su comprensión de los conceptos estadísticos y probabilísticos.'),(15,'Matemática - Competencia 4 - Capacidad 3','Usa estrategias y procedimientos para recopilar y procesar datos.'),(17,'Matemática - Competencia 4 - Capacidad 4','Sustenta conclusiones o decisiones con base en la información obtenida.');
/*!40000 ALTER TABLE `capacidad` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `competencia`
--

DROP TABLE IF EXISTS `competencia`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `competencia` (
  `idcompetencia` int(11) NOT NULL AUTO_INCREMENT,
  `competencia` varchar(100) NOT NULL,
  `descripcion` varchar(100) NOT NULL,
  PRIMARY KEY (`idcompetencia`),
  UNIQUE KEY `competencia_UNIQUE` (`competencia`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `competencia`
--

LOCK TABLES `competencia` WRITE;
/*!40000 ALTER TABLE `competencia` DISABLE KEYS */;
INSERT INTO `competencia` VALUES (1,'Matemática - Competencia 1','Resuelve problemas de cantidad.'),(2,'Matemática - Competencia 2','Resuelve problemas de regularidad, equivalencia y cambio.'),(3,'Matemática - Competencia 3','Resuelve problemas de forma, movimiento y localización.'),(4,'Matemática - Competencia 4','Resuelve problemas de gestión de datos e incertidumbre.');
/*!40000 ALTER TABLE `competencia` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `desempenio`
--

DROP TABLE IF EXISTS `desempenio`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `desempenio` (
  `iddesempenio` int(11) NOT NULL AUTO_INCREMENT,
  `desempenio` varchar(200) NOT NULL,
  `descripcion` varchar(500) NOT NULL,
  `iddocente_aula` int(11) NOT NULL,
  PRIMARY KEY (`iddesempenio`),
  UNIQUE KEY `idDesempeñoUnique` (`desempenio`,`iddocente_aula`),
  KEY `fk_desempeño_docente_aula1_idx` (`iddocente_aula`),
  CONSTRAINT `fk_indicador_docente_aula1` FOREIGN KEY (`iddocente_aula`) REFERENCES `docente_aula` (`iddocente_aula`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=26 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `desempenio`
--

LOCK TABLES `desempenio` WRITE;
/*!40000 ALTER TABLE `desempenio` DISABLE KEYS */;
INSERT INTO `desempenio` VALUES (1,'Matemática - Desempeño 1','Establece relaciones entre datos y una o más acciones de agregar, quitar, avanzar, retroceder, juntar, separar, comparar e igualar cantidades, y las transforma en expresiones numéricas (modelo) de adición o sustracción con números naturales de hasta dos cifras.',1),(2,'Matemática - Desempeño 2','Expresa con diversas representaciones y lenguaje numérico (números, signos y expresiones verbales) su comprensión de la decena como nueva unidad en el sistema de numeración decimal y el valor posicional de una cifra en números de hasta dos cifras.',1),(3,'Matemática - Desempeño 3','Expresa con diversas representaciones y lenguaje	numérico (números, signos y expresiones verbales) su comprensión del número como ordinal al ordenar objetos hasta el vigésimo lugar, de la comparación entre números y de las operaciones de adición y sustracción, el doble y la mitad, con números de hasta dos cifras.',1),(4,'Matemática - Desempeño 4','Emplea estrategias y procedimientos como los siguientes:\n-	Estrategias heurísticas.\n-	Estrategias de cálculo mental,	como las descomposiciones aditivas o el uso de analogías (70 + 20; 70 + 9, completar a la decena más cercana, usar dobles, sumar en vez de restar, uso de la conmutatividad).\n-	Procedimientos de cálculo, como sumas o restas con y sin canjes.\n-	Estrategias de comparación, que incluyen el uso del tablero cien y otros.\n',1),(5,'Matemática - Desempeño 5','Compara en forma vivencial y concreta la masa de objetos usando unidades no convencionales, y mide el tiempo usando unidades convencionales (días, horarios semanales).',1),(6,'Matemática - Desempeño 6','Realiza afirmaciones sobre la comparación de números naturales y de la decena, y las explica con material concreto.',1),(7,'Matemática - Desempeño 7','Realiza afirmaciones sobre por qué debe sumar o restar en un problema y las explica; así también, explica su proceso de resolución y los resultados obtenidos.',1),(8,'Matemática - Desempeño 8','Establece relaciones de equivalencias entre dos grupos de hasta veinte objetos y las trasforma en igualdades que contienen adiciones o sustracciones.',1),(9,'Matemática - Desempeño 9','Establece relaciones entre los datos que se repiten (objetos, colores, diseños, sonidos o movimientos) o entre cantidades que aumentan o disminuyen regularmente, y los transforma en patrones de repetición o patrones aditivos.',1),(10,'Matemática - Desempeño 10','Expresa, con lenguaje cotidiano y representaciones concretas o dibujos, su comprensión de la equivalencia como equilibrio o igualdad entre dos colecciones o cantidades.',1),(11,'Matemática - Desempeño 11','Describe, usando lenguaje cotidiano y representaciones concretas y dibujos, el patrón de repetición (con dos criterios perceptuales), y cómo aumentan o disminuyen los números en un patrón aditivo con números de hasta 2 cifras.',1),(12,'Matemática - Desempeño 12','Emplea estrategias heurísticas y estrategias de cálculo (el conteo o la descomposición aditiva) para encontrar equivalencias, mantener la igualdad (“equilibrio”) o crear, continuar y completar patrones. Ejemplo: El estudiante podría decir: “Si tú tienes tres frutas y yo cinco, ¿qué podemos hacer para que cada uno tenga el mismo número de frutas?”.',1),(13,'Matemática - Desempeño 13','Explica lo que debe hacer para mantener el “equilibrio” o la igualdad, y cómo continúa el patrón y las semejanzas que encuentra en dos versiones del mismo patrón, con base en ejemplos concretos. Así también, explica su proceso de resolución. Ejemplo: El estudiante podría decir: “El collar lleva dos hojas, tres frutos secos, una concha, una y otra vez; y los bloques van dos rojos, tres azules y uno blanco, una y otra vez; ambos se forman así: dos, luego tres, luego uno”.',1),(14,'Matemática - Desempeño 14','Establece relaciones entre las características de los objetos del entorno, las asocia y representa con formas geométricas tridimensionales (cuerpos que ruedan y no ruedan) y bidimensionales (cuadrado, rectángulo, círculo, triángulo), así como con las medidas de su longitud (largo y ancho).',1),(15,'Matemática - Desempeño 15','Establece relaciones entre los datos de ubicación y recorrido de objetos y personas del entorno, y los expresa con material concreto y bosquejos o gráficos, posiciones y desplazamientos, teniendo en cuenta puntos de referencia en las cuadrículas.',1),(16,'Matemática - Desempeño 16','Expresa con material concreto y dibujos su comprensión sobre algún elemento de las formas tridimensionales (número de puntas, número de caras, formas de sus caras) y bidimensionales (número de lados, vértices, lados curvos y rectos). Asimismo, describe si los objetos ruedan, se sostienen, no se sostienen o tienen puntas o esquinas usando lenguaje cotidiano y algunos términos geométricos.',1),(17,'Matemática - Desempeño 17','Expresa con material concreto su comprensión sobre la medida de la longitud al determinar cuántas veces es más largo un objeto con relación a otro. Expresa también que el objeto mantiene su longitud a pesar de sufrir transformaciones como romper, enrollar o flexionar (conservación de la longitud). Ejemplo: El estudiante, luego de enrollar y desenrollar sorbetes de diferentes tamaños, los ordena por su longitud, desde el más largo hasta el más corto, y viceversa.',1),(18,'Matemática - Desempeño 18','Expresa con material concreto, bosquejos o gráficos los desplazamientos y posiciones de objetos o personas con relación a un punto de referencia; hace uso de expresiones como “sube”, “entra”, “hacia adelante”, “hacia arriba”, “a la derecha”, “por el borde”, “en frente de”, etc., apoyándose con códigos de flechas.',1),(19,'Matemática - Desempeño 19','Emplea estrategias, recursos y procedimientos basados en la manipulación y visualización, para construir objetos y medir su longitud usando unidades no convencionales (manos, pasos, pies, etc.).',1),(20,'Matemática - Desempeño 20','Hace afirmaciones sobre las semejanzas y diferencias entre las formas geométricas, y las explica con ejemplos concretos y con base en sus conocimientos matemáticos. Asimismo, explica el proceso seguido. Ejemplo: El estudiante afirma que todas las figuras que tienen tres lados son triángulos o que una forma geométrica sigue siendo la misma aunque cambie de posición.',1),(21,'Matemática - Desempeño 21','Representa	las características y el comportamiento de datos cualitativos (por ejemplo, color de los ojos: pardos, negros; plato favorito: cebiche, arroz con pollo, etc.) de una población, a través de	pictogramas horizontales (el símbolo representa una o dos unidades) y gráficos de barras verticales simples (sin escala), en situaciones cotidianas de su interés personal o de sus pares.',1),(22,'Matemática - Desempeño 22','Expresa la ocurrencia de acontecimientos cotidianos usando las nociones “posible” e “imposible”.',1),(23,'Matemática - Desempeño 23','Lee información contenida en tablas de frecuencia simple (conteo simple), pictogramas horizontales y gráficos de barras verticales simples; indica la mayor o menor frecuencia y compara los datos, los cuales representa con material concreto y gráfico.',1),(24,'Matemática - Desempeño 24','Recopila datos mediante preguntas y el empleo de procedimientos y recursos (material concreto y otros); los procesa y organiza en listas de datos o tablas de frecuencia simple (conteo simple) para describirlos.',1),(25,'Matemática - Desempeño 25','Toma decisiones sencillas y las explica a partir de la información obtenida.',1);
/*!40000 ALTER TABLE `desempenio` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `docente_aula`
--

DROP TABLE IF EXISTS `docente_aula`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `docente_aula` (
  `iddocente_aula` int(11) NOT NULL AUTO_INCREMENT,
  `fecha` varchar(45) NOT NULL,
  `idperfil` int(11) NOT NULL,
  `idaula` int(11) NOT NULL,
  PRIMARY KEY (`iddocente_aula`),
  KEY `fk_docenteAula_perfil1_idx` (`idperfil`),
  KEY `fk_docenteAula_aula1_idx` (`idaula`),
  CONSTRAINT `fk_docenteAula_aula1` FOREIGN KEY (`idaula`) REFERENCES `aula` (`idaula`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `fk_docenteAula_perfil1` FOREIGN KEY (`idperfil`) REFERENCES `perfil` (`idperfil`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `docente_aula`
--

LOCK TABLES `docente_aula` WRITE;
/*!40000 ALTER TABLE `docente_aula` DISABLE KEYS */;
INSERT INTO `docente_aula` VALUES (1,'11/03/2020',3,1);
/*!40000 ALTER TABLE `docente_aula` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `estilo`
--

DROP TABLE IF EXISTS `estilo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `estilo` (
  `idestilo` int(11) NOT NULL AUTO_INCREMENT,
  `estilo` varchar(45) NOT NULL,
  `descripcion` varchar(45) NOT NULL,
  PRIMARY KEY (`idestilo`),
  UNIQUE KEY `estilo_UNIQUE` (`estilo`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `estilo`
--

LOCK TABLES `estilo` WRITE;
/*!40000 ALTER TABLE `estilo` DISABLE KEYS */;
INSERT INTO `estilo` VALUES (1,'Visual','Estilo de aprendizaje visual'),(2,'Auditiva','Estilo de aprendizaje auditiva');
/*!40000 ALTER TABLE `estilo` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `estudiante_matricula`
--

DROP TABLE IF EXISTS `estudiante_matricula`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `estudiante_matricula` (
  `idestudiante_matricula` int(11) NOT NULL AUTO_INCREMENT,
  `fecha` varchar(45) NOT NULL,
  `idperfil` int(11) NOT NULL,
  `idaula` int(11) NOT NULL,
  PRIMARY KEY (`idestudiante_matricula`),
  KEY `fk_estudianteMatricula_perfil1_idx` (`idperfil`),
  KEY `fk_estudianteMatricula_aula1_idx` (`idaula`),
  CONSTRAINT `fk_estudianteMatricula_aula1` FOREIGN KEY (`idaula`) REFERENCES `aula` (`idaula`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `fk_estudianteMatricula_perfil1` FOREIGN KEY (`idperfil`) REFERENCES `perfil` (`idperfil`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=26 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `estudiante_matricula`
--

LOCK TABLES `estudiante_matricula` WRITE;
/*!40000 ALTER TABLE `estudiante_matricula` DISABLE KEYS */;
INSERT INTO `estudiante_matricula` VALUES (1,'11/03/2020',4,1),(2,'11/03/2020',5,1),(3,'11/03/2020',6,1),(4,'11/03/2020',7,1),(5,'11/03/2020',8,1),(6,'11/03/2020',9,1),(7,'11/03/2020',10,1),(8,'11/03/2020',11,1),(9,'11/03/2020',12,1),(10,'11/03/2020',13,1),(11,'11/03/2020',14,1),(12,'11/03/2020',15,1),(13,'11/03/2020',16,1),(14,'11/03/2020',17,1),(15,'11/03/2020',18,1),(16,'11/03/2020',19,1),(17,'11/03/2020',20,1),(18,'11/03/2020',21,1),(19,'11/03/2020',22,1),(20,'11/03/2020',23,1),(21,'11/03/2020',24,1),(22,'11/03/2020',25,1),(23,'11/03/2020',26,1),(24,'11/03/2020',27,1),(25,'11/03/2020',28,1);
/*!40000 ALTER TABLE `estudiante_matricula` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `evaluacion_adaptativa`
--

DROP TABLE IF EXISTS `evaluacion_adaptativa`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `evaluacion_adaptativa` (
  `idevaluacion_adaptativa` int(11) NOT NULL AUTO_INCREMENT,
  `fecha` varchar(45) NOT NULL,
  `idcompetencia` int(11) NOT NULL,
  `idperiodo` int(11) NOT NULL,
  `idarea` int(11) NOT NULL,
  `idestudiante_matricula` int(11) NOT NULL,
  `iddocente_aula` int(11) NOT NULL,
  PRIMARY KEY (`idevaluacion_adaptativa`),
  UNIQUE KEY `idEvaluacionUnique` (`iddocente_aula`,`idestudiante_matricula`,`idperiodo`,`idarea`,`idcompetencia`),
  KEY `fk_evaluacion_adaptativa_estudianteMatricula1_idx` (`idestudiante_matricula`),
  KEY `fk_evaluacion_adaptativa_docente_aula1_idx` (`iddocente_aula`),
  KEY `fk_evaluacion_adaptativa_periodo1_idx` (`idperiodo`),
  KEY `fk_evaluacion_adaptativa_area1_idx` (`idarea`),
  KEY `fk_evaluacion_adaptativa_competencia1_idx` (`idcompetencia`),
  CONSTRAINT `fk_evaluacion_adaptativa_area1` FOREIGN KEY (`idarea`) REFERENCES `area` (`idarea`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `fk_evaluacion_adaptativa_competencia1` FOREIGN KEY (`idcompetencia`) REFERENCES `competencia` (`idcompetencia`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `fk_evaluacion_adaptativa_docente_aula1` FOREIGN KEY (`iddocente_aula`) REFERENCES `docente_aula` (`iddocente_aula`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `fk_evaluacion_adaptativa_estudianteMatricula1` FOREIGN KEY (`idestudiante_matricula`) REFERENCES `estudiante_matricula` (`idestudiante_matricula`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `fk_evaluacion_adaptativa_periodo1` FOREIGN KEY (`idperiodo`) REFERENCES `periodo` (`idperiodo`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=99 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `evaluacion_adaptativa`
--

LOCK TABLES `evaluacion_adaptativa` WRITE;
/*!40000 ALTER TABLE `evaluacion_adaptativa` DISABLE KEYS */;
INSERT INTO `evaluacion_adaptativa` VALUES (1,'07/06/2020',1,1,1,1,1),(2,'14/06/2020',2,1,1,1,1),(3,'21/06/2020',3,1,1,1,1),(4,'28/06/2020',4,1,1,1,1),(5,'07/06/2020',1,1,1,2,1),(7,'14/06/2020',2,1,1,2,1),(8,'21/06/2020',3,1,1,2,1),(9,'28/06/2020',4,1,1,2,1),(10,'07/06/2020',1,1,1,3,1),(11,'14/06/2020',2,1,1,3,1),(12,'21/06/2020',3,1,1,3,1),(13,'28/06/2020',4,1,1,3,1),(14,'07/06/2020',1,1,1,4,1),(15,'14/06/2020',2,1,1,4,1),(16,'21/06/2020',3,1,1,4,1),(17,'28/06/2020',4,1,1,4,1),(18,'07/06/2020',1,1,1,5,1),(19,'14/06/2020',2,1,1,5,1),(20,'21/06/2020',3,1,1,5,1),(21,'28/06/2020',4,1,1,5,1),(22,'07/06/2020',1,1,1,6,1),(23,'14/06/2020',2,1,1,6,1),(24,'21/06/2020',3,1,1,6,1),(25,'28/06/2020',4,1,1,6,1),(26,'07/06/2020',1,1,1,7,1),(27,'14/06/2020',2,1,1,7,1),(28,'21/06/2020',3,1,1,7,1),(29,'28/06/2020',4,1,1,7,1),(30,'07/06/2020',1,1,1,8,1),(31,'14/06/2020',2,1,1,8,1),(32,'21/06/2020',3,1,1,8,1),(33,'28/06/2020',4,1,1,8,1),(34,'07/06/2020',1,1,1,9,1),(35,'14/06/2020',2,1,1,9,1),(36,'21/06/2020',3,1,1,9,1),(37,'28/06/2020',4,1,1,9,1),(38,'07/06/2020',1,1,1,10,1),(39,'14/06/2020',2,1,1,10,1),(40,'21/06/2020',3,1,1,10,1),(41,'28/06/2020',4,1,1,10,1),(43,'07/06/2020',1,1,1,11,1),(44,'14/06/2020',2,1,1,11,1),(45,'21/06/2020',3,1,1,11,1),(46,'28/06/2020',4,1,1,11,1),(47,'07/06/2020',1,1,1,12,1),(48,'14/06/2020',2,1,1,12,1),(49,'21/06/2020',3,1,1,12,1),(50,'28/06/2020',4,1,1,12,1),(51,'07/06/2020',1,1,1,13,1),(52,'14/06/2020',2,1,1,13,1),(53,'21/06/2020',3,1,1,13,1),(54,'28/06/2020',4,1,1,13,1),(55,'07/06/2020',1,1,1,14,1),(56,'07/06/2020',1,1,1,15,1),(57,'14/06/2020',2,1,1,15,1),(58,'21/06/2020',3,1,1,15,1),(59,'28/06/2020',4,1,1,15,1),(60,'07/06/2020',1,1,1,16,1),(61,'14/06/2020',2,1,1,16,1),(62,'21/06/2020',3,1,1,16,1),(63,'28/06/2020',4,1,1,16,1),(64,'07/06/2020',1,1,1,17,1),(65,'14/06/2020',2,1,1,17,1),(66,'21/06/2020',3,1,1,17,1),(67,'28/06/2020',4,1,1,17,1),(68,'07/06/2020',1,1,1,18,1),(69,'14/06/2020',2,1,1,18,1),(70,'21/06/2020',3,1,1,18,1),(71,'28/06/2020',4,1,1,18,1),(72,'07/06/2020',1,1,1,19,1),(73,'14/06/2020',2,1,1,19,1),(74,'21/06/2020',3,1,1,19,1),(75,'28/06/2020',4,1,1,19,1),(76,'07/06/2020',1,1,1,20,1),(77,'14/06/2020',2,1,1,20,1),(78,'21/06/2020',3,1,1,20,1),(79,'28/06/2020',4,1,1,20,1),(80,'07/06/2020',1,1,1,21,1),(81,'14/06/2020',2,1,1,21,1),(82,'21/06/2020',3,1,1,21,1),(83,'28/06/2020',4,1,1,21,1),(84,'07/06/2020',1,1,1,22,1),(85,'14/06/2020',2,1,1,22,1),(86,'21/06/2020',3,1,1,22,1),(87,'28/06/2020',4,1,1,22,1),(88,'07/06/2020',1,1,1,23,1),(89,'14/06/2020',2,1,1,23,1),(90,'21/06/2020',3,1,1,23,1),(91,'28/06/2020',4,1,1,23,1),(92,'07/06/2020',1,1,1,24,1),(93,'14/06/2020',2,1,1,24,1),(94,'21/06/2020',3,1,1,24,1),(95,'28/06/2020',4,1,1,24,1),(96,'14/06/2020',2,1,1,14,1),(97,'21/06/2020',3,1,1,14,1),(98,'28/06/2020',4,1,1,14,1);
/*!40000 ALTER TABLE `evaluacion_adaptativa` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `evaluacion_tradicional`
--

DROP TABLE IF EXISTS `evaluacion_tradicional`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `evaluacion_tradicional` (
  `idevaluacion_tradicional` int(11) NOT NULL AUTO_INCREMENT,
  `fecha` varchar(45) NOT NULL,
  `idperiodo` int(11) NOT NULL,
  `idarea` int(11) NOT NULL,
  `idestudiante_matricula` int(11) NOT NULL,
  `iddocente_aula` int(11) NOT NULL,
  PRIMARY KEY (`idevaluacion_tradicional`),
  UNIQUE KEY `idEvaluacionUnique` (`fecha`,`idperiodo`,`idarea`,`idestudiante_matricula`,`iddocente_aula`),
  KEY `fk_evaluacion_tradicional_area1_idx` (`idarea`),
  KEY `fk_evaluacion_tradicional_estudianteMatricula1_idx` (`idestudiante_matricula`),
  KEY `fk_evaluacion_tradicional_docenteAula1_idx` (`iddocente_aula`),
  KEY `fk_evaluacion_tradicional_periodo1_idx` (`idperiodo`),
  CONSTRAINT `fk_evaluacion_tradicional_area1` FOREIGN KEY (`idarea`) REFERENCES `area` (`idarea`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `fk_evaluacion_tradicional_docenteAula1` FOREIGN KEY (`iddocente_aula`) REFERENCES `docente_aula` (`iddocente_aula`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `fk_evaluacion_tradicional_estudianteMatricula1` FOREIGN KEY (`idestudiante_matricula`) REFERENCES `estudiante_matricula` (`idestudiante_matricula`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `fk_evaluacion_tradicional_periodo1` FOREIGN KEY (`idperiodo`) REFERENCES `periodo` (`idperiodo`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=26 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `evaluacion_tradicional`
--

LOCK TABLES `evaluacion_tradicional` WRITE;
/*!40000 ALTER TABLE `evaluacion_tradicional` DISABLE KEYS */;
INSERT INTO `evaluacion_tradicional` VALUES (1,'31/05/2020',1,1,1,1),(2,'31/05/2020',1,1,2,1),(3,'31/05/2020',1,1,3,1),(4,'31/05/2020',1,1,4,1),(5,'31/05/2020',1,1,5,1),(6,'31/05/2020',1,1,6,1),(7,'31/05/2020',1,1,7,1),(8,'31/05/2020',1,1,8,1),(9,'31/05/2020',1,1,9,1),(10,'31/05/2020',1,1,10,1),(11,'31/05/2020',1,1,11,1),(12,'31/05/2020',1,1,12,1),(13,'31/05/2020',1,1,13,1),(14,'31/05/2020',1,1,14,1),(15,'31/05/2020',1,1,15,1),(16,'31/05/2020',1,1,16,1),(17,'31/05/2020',1,1,17,1),(18,'31/05/2020',1,1,18,1),(19,'31/05/2020',1,1,19,1),(20,'31/05/2020',1,1,20,1),(21,'31/05/2020',1,1,21,1),(22,'31/05/2020',1,1,22,1),(23,'31/05/2020',1,1,23,1),(24,'31/05/2020',1,1,24,1),(25,'31/05/2020',1,1,25,1);
/*!40000 ALTER TABLE `evaluacion_tradicional` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `grado`
--

DROP TABLE IF EXISTS `grado`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `grado` (
  `idgrado` int(11) NOT NULL AUTO_INCREMENT,
  `grado` varchar(45) NOT NULL,
  `descripcion` varchar(45) NOT NULL,
  PRIMARY KEY (`idgrado`),
  UNIQUE KEY `grado_UNIQUE` (`grado`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `grado`
--

LOCK TABLES `grado` WRITE;
/*!40000 ALTER TABLE `grado` DISABLE KEYS */;
INSERT INTO `grado` VALUES (1,'Primer grado','Primer grado de primaria'),(2,'Segundo grado','Segundo grado de primaria'),(3,'Tercer grado','Tercer grado de primaria'),(5,'Cuarto grado','Cuarto grado de primaria'),(6,'Quinto grado','Quinto grado de primaria'),(7,'Sexto grado','Sexto grado de primaria');
/*!40000 ALTER TABLE `grado` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `imagen`
--

DROP TABLE IF EXISTS `imagen`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `imagen` (
  `idimagen` int(11) NOT NULL AUTO_INCREMENT,
  `imagen` varchar(100) NOT NULL,
  `idpregunta` int(11) NOT NULL,
  PRIMARY KEY (`idimagen`),
  KEY `fk_imagen_pregunta1_idx` (`idpregunta`),
  CONSTRAINT `fk_imagen_pregunta1` FOREIGN KEY (`idpregunta`) REFERENCES `pregunta` (`idpregunta`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=79 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `imagen`
--

LOCK TABLES `imagen` WRITE;
/*!40000 ALTER TABLE `imagen` DISABLE KEYS */;
INSERT INTO `imagen` VALUES (1,'C:\\wamp64\\www\\Nimodo\\NimodoStudent\\pdo\\images\\26.png',26),(2,'C:\\wamp64\\www\\Nimodo\\NimodoStudent\\pdo\\images\\32.png',32),(3,'C:\\wamp64\\www\\Nimodo\\NimodoStudent\\pdo\\images\\38.png',38),(4,'C:\\wamp64\\www\\Nimodo\\NimodoStudent\\pdo\\images\\41.png',41),(5,'C:\\wamp64\\www\\Nimodo\\NimodoStudent\\pdo\\images\\44.png',44),(6,'C:\\wamp64\\www\\Nimodo\\NimodoStudent\\pdo\\images\\47.png',47),(7,'C:\\wamp64\\www\\Nimodo\\NimodoStudent\\pdo\\images\\53.png',53),(8,'C:\\wamp64\\www\\Nimodo\\NimodoStudent\\pdo\\images\\59.png',59),(9,'C:\\wamp64\\www\\Nimodo\\NimodoStudent\\pdo\\images\\62.png',62),(10,'C:\\wamp64\\www\\Nimodo\\NimodoStudent\\pdo\\images\\65.png',65),(11,'C:\\wamp64\\www\\Nimodo\\NimodoStudent\\pdo\\images\\68.png',68),(12,'C:\\wamp64\\www\\Nimodo\\NimodoStudent\\pdo\\images\\71.png',71),(13,'C:\\wamp64\\www\\Nimodo\\NimodoStudent\\pdo\\images\\74.png',74),(14,'C:\\wamp64\\www\\Nimodo\\NimodoStudent\\pdo\\images\\101.png',101),(15,'C:\\wamp64\\www\\Nimodo\\NimodoStudent\\pdo\\images\\107.png',107),(16,'C:\\wamp64\\www\\Nimodo\\NimodoStudent\\pdo\\images\\113.png',113),(17,'C:\\wamp64\\www\\Nimodo\\NimodoStudent\\pdo\\images\\116.png',116),(18,'C:\\wamp64\\www\\Nimodo\\NimodoStudent\\pdo\\images\\119.png',119),(19,'C:\\wamp64\\www\\Nimodo\\NimodoStudent\\pdo\\images\\122.png',122),(20,'C:\\wamp64\\www\\Nimodo\\NimodoStudent\\pdo\\images\\128.png',128),(21,'C:\\wamp64\\www\\Nimodo\\NimodoStudent\\pdo\\images\\134.png',134),(22,'C:\\wamp64\\www\\Nimodo\\NimodoStudent\\pdo\\images\\137.png',137),(23,'C:\\wamp64\\www\\Nimodo\\NimodoStudent\\pdo\\images\\140.png',140),(24,'C:\\wamp64\\www\\Nimodo\\NimodoStudent\\pdo\\images\\143.png',143),(25,'C:\\wamp64\\www\\Nimodo\\NimodoStudent\\pdo\\images\\146.png',146),(26,'C:\\wamp64\\www\\Nimodo\\NimodoStudent\\pdo\\images\\149.png',149),(27,'C:\\wamp64\\www\\Nimodo\\NimodoStudent\\pdo\\images\\25.png',25),(28,'C:\\wamp64\\www\\Nimodo\\NimodoStudent\\pdo\\images\\31.png',31),(29,'C:\\wamp64\\www\\Nimodo\\NimodoStudent\\pdo\\images\\37.png',37),(30,'C:\\wamp64\\www\\Nimodo\\NimodoStudent\\pdo\\images\\40.png',40),(31,'C:\\wamp64\\www\\Nimodo\\NimodoStudent\\pdo\\images\\43.png',43),(32,'C:\\wamp64\\www\\Nimodo\\NimodoStudent\\pdo\\images\\46.png',46),(33,'C:\\wamp64\\www\\Nimodo\\NimodoStudent\\pdo\\images\\52.png',52),(34,'C:\\wamp64\\www\\Nimodo\\NimodoStudent\\pdo\\images\\58.png',58),(35,'C:\\wamp64\\www\\Nimodo\\NimodoStudent\\pdo\\images\\61.png',61),(36,'C:\\wamp64\\www\\Nimodo\\NimodoStudent\\pdo\\images\\64.png',64),(37,'C:\\wamp64\\www\\Nimodo\\NimodoStudent\\pdo\\images\\67.png',67),(38,'C:\\wamp64\\www\\Nimodo\\NimodoStudent\\pdo\\images\\70.png',70),(39,'C:\\wamp64\\www\\Nimodo\\NimodoStudent\\pdo\\images\\73.png',73),(40,'C:\\wamp64\\www\\Nimodo\\NimodoStudent\\pdo\\images\\100.png',100),(41,'C:\\wamp64\\www\\Nimodo\\NimodoStudent\\pdo\\images\\106.png',106),(42,'C:\\wamp64\\www\\Nimodo\\NimodoStudent\\pdo\\images\\112.png',112),(43,'C:\\wamp64\\www\\Nimodo\\NimodoStudent\\pdo\\images\\115.png',115),(44,'C:\\wamp64\\www\\Nimodo\\NimodoStudent\\pdo\\images\\118.png',118),(45,'C:\\wamp64\\www\\Nimodo\\NimodoStudent\\pdo\\images\\121.png',121),(46,'C:\\wamp64\\www\\Nimodo\\NimodoStudent\\pdo\\images\\127.png',127),(47,'C:\\wamp64\\www\\Nimodo\\NimodoStudent\\pdo\\images\\133.png',133),(48,'C:\\wamp64\\www\\Nimodo\\NimodoStudent\\pdo\\images\\136.png',136),(49,'C:\\wamp64\\www\\Nimodo\\NimodoStudent\\pdo\\images\\139.png',139),(50,'C:\\wamp64\\www\\Nimodo\\NimodoStudent\\pdo\\images\\142.png',142),(51,'C:\\wamp64\\www\\Nimodo\\NimodoStudent\\pdo\\images\\145.png',145),(52,'C:\\wamp64\\www\\Nimodo\\NimodoStudent\\pdo\\images\\148.png',148),(53,'C:\\wamp64\\www\\Nimodo\\NimodoStudent\\pdo\\images\\27.png',27),(54,'C:\\wamp64\\www\\Nimodo\\NimodoStudent\\pdo\\images\\33.png',33),(55,'C:\\wamp64\\www\\Nimodo\\NimodoStudent\\pdo\\images\\39.png',39),(56,'C:\\wamp64\\www\\Nimodo\\NimodoStudent\\pdo\\images\\42.png',42),(57,'C:\\wamp64\\www\\Nimodo\\NimodoStudent\\pdo\\images\\45.png',45),(58,'C:\\wamp64\\www\\Nimodo\\NimodoStudent\\pdo\\images\\48.png',48),(59,'C:\\wamp64\\www\\Nimodo\\NimodoStudent\\pdo\\images\\54.png',54),(60,'C:\\wamp64\\www\\Nimodo\\NimodoStudent\\pdo\\images\\60.png',60),(61,'C:\\wamp64\\www\\Nimodo\\NimodoStudent\\pdo\\images\\63.png',63),(62,'C:\\wamp64\\www\\Nimodo\\NimodoStudent\\pdo\\images\\66.png',66),(63,'C:\\wamp64\\www\\Nimodo\\NimodoStudent\\pdo\\images\\69.png',69),(64,'C:\\wamp64\\www\\Nimodo\\NimodoStudent\\pdo\\images\\72.png',72),(65,'C:\\wamp64\\www\\Nimodo\\NimodoStudent\\pdo\\images\\75.png',75),(66,'C:\\wamp64\\www\\Nimodo\\NimodoStudent\\pdo\\images\\102.png',102),(67,'C:\\wamp64\\www\\Nimodo\\NimodoStudent\\pdo\\images\\108.png',108),(68,'C:\\wamp64\\www\\Nimodo\\NimodoStudent\\pdo\\images\\114.png',114),(69,'C:\\wamp64\\www\\Nimodo\\NimodoStudent\\pdo\\images\\117.png',117),(70,'C:\\wamp64\\www\\Nimodo\\NimodoStudent\\pdo\\images\\120.png',120),(71,'C:\\wamp64\\www\\Nimodo\\NimodoStudent\\pdo\\images\\123.png',123),(72,'C:\\wamp64\\www\\Nimodo\\NimodoStudent\\pdo\\images\\129.png',129),(73,'C:\\wamp64\\www\\Nimodo\\NimodoStudent\\pdo\\images\\135.png',135),(74,'C:\\wamp64\\www\\Nimodo\\NimodoStudent\\pdo\\images\\138.png',138),(75,'C:\\wamp64\\www\\Nimodo\\NimodoStudent\\pdo\\images\\141.png',141),(76,'C:\\wamp64\\www\\Nimodo\\NimodoStudent\\pdo\\images\\144.png',144),(77,'C:\\wamp64\\www\\Nimodo\\NimodoStudent\\pdo\\images\\147.png',147),(78,'C:\\wamp64\\www\\Nimodo\\NimodoStudent\\pdo\\images\\150.png',150);
/*!40000 ALTER TABLE `imagen` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `lookandfeel`
--

DROP TABLE IF EXISTS `lookandfeel`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `lookandfeel` (
  `idlookandfeel` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(20) NOT NULL,
  `codigo` varchar(60) NOT NULL,
  `color` varchar(7) NOT NULL,
  PRIMARY KEY (`idlookandfeel`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `lookandfeel`
--

LOCK TABLES `lookandfeel` WRITE;
/*!40000 ALTER TABLE `lookandfeel` DISABLE KEYS */;
INSERT INTO `lookandfeel` VALUES (1,'Metal','javax.swing.plaf.metal.MetalLookAndFeel','#C9EAF8'),(2,'Windows','com.sun.java.swing.plaf.windows.WindowsLookAndFeel','#B3F8CE'),(3,'Windows Classic','com.sun.java.swing.plaf.windows.WindowsClassicLookAndFeel','#E8D4FD');
/*!40000 ALTER TABLE `lookandfeel` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `matriz`
--

DROP TABLE IF EXISTS `matriz`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `matriz` (
  `idmatriz` int(11) NOT NULL AUTO_INCREMENT,
  `idarea` int(11) NOT NULL,
  `idcompetencia` int(11) NOT NULL,
  `idcapacidad` int(11) NOT NULL,
  `iddesempenio` int(11) NOT NULL,
  `iddocente_aula` int(11) NOT NULL,
  `primer_bimestre` double NOT NULL,
  `segundo_bimestre` double NOT NULL,
  `tercer_bimestre` double NOT NULL,
  `cuarto_bimestre` double NOT NULL,
  `tiempo` int(11) NOT NULL,
  PRIMARY KEY (`idmatriz`),
  UNIQUE KEY `idMatrizUnique` (`idarea`,`idcompetencia`,`idcapacidad`,`iddesempenio`,`iddocente_aula`),
  UNIQUE KEY `idMatrizIndicadorUnique` (`iddesempenio`),
  KEY `fk_matriz_area1_idx` (`idarea`),
  KEY `fk_matriz_competencia1_idx` (`idcompetencia`),
  KEY `fk_matriz_capacidad1_idx` (`idcapacidad`),
  KEY `fk_matriz_indicador1_idx` (`iddesempenio`),
  KEY `fk_matriz_docente_aula1_idx` (`iddocente_aula`),
  CONSTRAINT `fk_matriz_area1` FOREIGN KEY (`idarea`) REFERENCES `area` (`idarea`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `fk_matriz_capacidad1` FOREIGN KEY (`idcapacidad`) REFERENCES `capacidad` (`idcapacidad`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `fk_matriz_competencia1` FOREIGN KEY (`idcompetencia`) REFERENCES `competencia` (`idcompetencia`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `fk_matriz_docente_aula1` FOREIGN KEY (`iddocente_aula`) REFERENCES `docente_aula` (`iddocente_aula`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `fk_matriz_indicador1` FOREIGN KEY (`iddesempenio`) REFERENCES `desempenio` (`iddesempenio`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=26 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `matriz`
--

LOCK TABLES `matriz` WRITE;
/*!40000 ALTER TABLE `matriz` DISABLE KEYS */;
INSERT INTO `matriz` VALUES (1,1,1,1,1,1,0,0,0,0,7200),(2,1,1,2,2,1,0,0,0,0,7200),(3,1,1,2,3,1,0,0,0,0,7200),(4,1,1,3,4,1,0,0,0,0,7200),(5,1,1,3,5,1,0,0,0,0,7200),(6,1,1,4,6,1,0,0,0,0,7200),(7,1,1,4,7,1,0,0,0,0,7200),(8,1,2,5,8,1,0,0,0,0,7200),(9,1,2,5,9,1,0,0,0,0,7200),(10,1,2,6,10,1,0,0,0,0,7200),(11,1,2,6,11,1,0,0,0,0,7200),(12,1,2,7,12,1,0,0,0,0,7200),(13,1,2,8,13,1,0,0,0,0,7200),(14,1,3,9,14,1,0,0,0,0,7200),(15,1,3,9,15,1,0,0,0,0,7200),(16,1,3,10,16,1,0,0,0,0,7200),(17,1,3,10,17,1,0,0,0,0,7200),(18,1,3,10,18,1,0,0,0,0,7200),(19,1,3,11,19,1,0,0,0,0,7200),(20,1,3,12,20,1,0,0,0,0,7200),(21,1,4,13,21,1,1,0,0,0,7200),(22,1,4,14,22,1,1,0,0,0,7200),(23,1,4,15,23,1,1,0,0,0,7200),(24,1,4,15,24,1,1,0,0,0,7200),(25,1,4,17,25,1,1,0,0,0,7200);
/*!40000 ALTER TABLE `matriz` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `nivel`
--

DROP TABLE IF EXISTS `nivel`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `nivel` (
  `idnivel` int(11) NOT NULL AUTO_INCREMENT,
  `nivel` varchar(45) NOT NULL,
  `descripcion` varchar(45) NOT NULL,
  PRIMARY KEY (`idnivel`),
  UNIQUE KEY `nivel_UNIQUE` (`nivel`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `nivel`
--

LOCK TABLES `nivel` WRITE;
/*!40000 ALTER TABLE `nivel` DISABLE KEYS */;
INSERT INTO `nivel` VALUES (1,'En Inicio','Nivel de logro en inicio'),(2,'En Proceso','Nivel de logro en proceso'),(3,'Satisfactorio','Nivel de logro satisfactorio');
/*!40000 ALTER TABLE `nivel` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `perfil`
--

DROP TABLE IF EXISTS `perfil`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `perfil` (
  `idperfil` int(11) NOT NULL AUTO_INCREMENT,
  `dni` varchar(8) NOT NULL,
  `idrol` int(11) NOT NULL,
  PRIMARY KEY (`idperfil`),
  UNIQUE KEY `idPerfilUnique` (`dni`,`idrol`),
  KEY `fk_perfil_rol_idx` (`idrol`),
  KEY `fk_perfil_persona1_idx` (`dni`),
  CONSTRAINT `fk_perfil_persona1` FOREIGN KEY (`dni`) REFERENCES `persona` (`dni`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `fk_perfil_rol` FOREIGN KEY (`idrol`) REFERENCES `rol` (`idrol`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=29 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `perfil`
--

LOCK TABLES `perfil` WRITE;
/*!40000 ALTER TABLE `perfil` DISABLE KEYS */;
INSERT INTO `perfil` VALUES (28,'11111111',4),(2,'12345678',2),(3,'12345678',3),(6,'61605790',4),(24,'62227322',4),(20,'62227333',4),(12,'62227342',4),(10,'62227345',4),(7,'62227348',4),(23,'62336105',4),(26,'62336107',4),(8,'62336110',4),(15,'62336114',4),(27,'62336139',4),(21,'62336148',4),(22,'62391962',4),(25,'62445260',4),(17,'63120390',4),(4,'63410150',4),(9,'63410153',4),(16,'63410156',4),(14,'63410176',4),(13,'63410180',4),(19,'63410184',4),(18,'63410189',4),(5,'63410191',4),(1,'73475373',1),(11,'77545415',4);
/*!40000 ALTER TABLE `perfil` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `periodo`
--

DROP TABLE IF EXISTS `periodo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `periodo` (
  `idperiodo` int(11) NOT NULL AUTO_INCREMENT,
  `periodo` varchar(45) NOT NULL,
  `fecha_inicio` varchar(45) NOT NULL,
  `fecha_fin` varchar(45) NOT NULL,
  PRIMARY KEY (`idperiodo`),
  UNIQUE KEY `idPeriodoUnique` (`periodo`,`fecha_inicio`,`fecha_fin`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `periodo`
--

LOCK TABLES `periodo` WRITE;
/*!40000 ALTER TABLE `periodo` DISABLE KEYS */;
INSERT INTO `periodo` VALUES (4,'Cuarto Bimestre','21/10/2020','20/12/2020'),(1,'Primer Bimestre','11/03/2020','03/05/2020'),(2,'Segundo Bimestre','06/05/2020','26/07/2020'),(3,'Tercer Bimestre','12/08/2020','18/10/2020');
/*!40000 ALTER TABLE `periodo` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `persona`
--

DROP TABLE IF EXISTS `persona`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `persona` (
  `dni` varchar(8) NOT NULL,
  `nombres` varchar(45) NOT NULL,
  `apellidos` varchar(45) NOT NULL,
  `user` varchar(45) NOT NULL,
  `password` varchar(45) NOT NULL,
  PRIMARY KEY (`dni`),
  UNIQUE KEY `user_UNIQUE` (`user`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `persona`
--

LOCK TABLES `persona` WRITE;
/*!40000 ALTER TABLE `persona` DISABLE KEYS */;
INSERT INTO `persona` VALUES ('11111111','Estudiante Demo','Estudiante Demo','demo','12345'),('12345678','César Dalmiro','Flores Gutierrez','dflores','12345'),('61605790','Roy Angel','Huaman Guizado','rhuaman','df5tto'),('62227322','Jonas','Gutierrez Obregon','jgutierrez','xgk1w9'),('62227333','Samuel','Navarro Aquise','snavarro','vrh5rc'),('62227342','Diana','Guizado Garcia','dguizado','t4vzlk'),('62227345','Eloy','Chipana Huanca','echipana','jkz1o1'),('62227348','Guido Rodrigo','Casafranca Caceres','gcasafranca','5mprxb'),('62336105','Jazmin','Guizado Caceres','jguizado','f33bbq'),('62336107','Brith Angelica','Perez Huaman','bperez','5k6ydg'),('62336110','Zenaida','Casafranca Pillaca','zcasafranca','8x3ets'),('62336114','Rony Guillermo','Gutierrez Casafranca','rgutierrez','9b3df3'),('62336139','Yasuri','Pezo Quispe','ypezo','3x2ul8'),('62336148','Lismen Sayuri','Caceres Villano','lcaceres','unfs69'),('62391962','Juan Carlos','Chilengano Rivera','jchilengano','m9uutg'),('62445260','Junior','Huacre Ramos','jhuacre','n6414t'),('63120390',' Eloy','Huacre Ramos','ehuacre','3k12xz'),('63410150','Yulios','Arango Cruz','yarango','bt1yqg'),('63410153','Raida','Chipana Guizado','rchipana','8fdklh'),('63410156','Odilia','Herhuai Gutierrez','oherhuai','y2yoko'),('63410176','Santos','Guizado Gutierrez','sguizado','28aprm'),('63410180','Briseth','Guizado Gutierrez','bguizado','jk5akf'),('63410184','Nilda','Muñoz Huanca','nmuñoz','btx3nc'),('63410189','Jeremy Jherson','Huanca Perez','jhuanca','g7vrxp'),('63410191','Dean','Caceres Guizado','dcaceres','x5n5hn'),('73475373','Jhancarlo F.','Silva Ochoa','jsilva','1003920102'),('77545415','Victor Hugo','Chipana Muñoz','vchipana','fno4wd');
/*!40000 ALTER TABLE `persona` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `pregunta`
--

DROP TABLE IF EXISTS `pregunta`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `pregunta` (
  `idpregunta` int(11) NOT NULL AUTO_INCREMENT,
  `descripcion` varchar(250) NOT NULL,
  `descuido` double NOT NULL,
  `adivinanza` double NOT NULL,
  `idnivel` int(11) NOT NULL,
  `idestilo` int(11) NOT NULL,
  `idmatriz` int(11) NOT NULL,
  `idperiodo` int(11) NOT NULL,
  `iddocente_aula` int(11) NOT NULL,
  PRIMARY KEY (`idpregunta`),
  UNIQUE KEY `idPreguntaUnique` (`descripcion`,`idnivel`,`idestilo`,`idmatriz`,`idperiodo`,`iddocente_aula`),
  KEY `fk_pregunta_nivel1_idx` (`idnivel`),
  KEY `fk_pregunta_estilo1_idx` (`idestilo`),
  KEY `fk_pregunta_matriz1_idx` (`idmatriz`),
  KEY `fk_pregunta_periodo1_idx` (`idperiodo`),
  KEY `fk_pregunta_docente_aula1_idx` (`iddocente_aula`),
  CONSTRAINT `fk_pregunta_docente_aula1` FOREIGN KEY (`iddocente_aula`) REFERENCES `docente_aula` (`iddocente_aula`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `fk_pregunta_estilo1` FOREIGN KEY (`idestilo`) REFERENCES `estilo` (`idestilo`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `fk_pregunta_matriz1` FOREIGN KEY (`idmatriz`) REFERENCES `matriz` (`idmatriz`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `fk_pregunta_nivel1` FOREIGN KEY (`idnivel`) REFERENCES `nivel` (`idnivel`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `fk_pregunta_periodo1` FOREIGN KEY (`idperiodo`) REFERENCES `periodo` (`idperiodo`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=151 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `pregunta`
--

LOCK TABLES `pregunta` WRITE;
/*!40000 ALTER TABLE `pregunta` DISABLE KEYS */;
INSERT INTO `pregunta` VALUES (1,'Pedro tiene 1 gato y 2 perros. ¿Cuántos animales tiene en total Pedro?',0.1,0.3333,1,1,1,1,1),(2,'Pedro tiene 2 ovejas y 4 gallinas. ¿Cuántos animales tiene en total Pedro?',0.15,0.3333,2,1,1,1,1),(3,'Denis tiene 7 ovejas y 5 gallinas. ¿Cuántos animales tiene en total Denis?',0.2,0.3333,3,1,1,1,1),(4,'En una granja hay una docena de cuyes grandes y 5 cuyes pequeños. ¿Cuántos cuyes en total hay en la granja?',0.1,0.3333,1,1,2,1,1),(5,'En una granja hay una docena de cuyes grandes y una decena de cuyes pequeños. ¿Cuántos cuyes en total hay en la granja?',0.15,0.3333,2,1,2,1,1),(6,'En una granja hay dos docenas de gallinas blancas y dos decenas de gallinas rojas. ¿Cuántas gallinas en total hay en la granja?',0.2,0.3333,3,1,2,1,1),(7,'Carlos, Manuel y José compitieron en una carrera. Manuel está en primer lugar y Carlos llegó después. ¿En qué puesto llegó José?',0.1,0.3333,1,1,3,1,1),(8,'Carlos, Manuel y José compitieron en una carrera. Manuel quedó en segundo lugar y después de él llegó Carlos. ¿En qué puesto llegó José?',0.15,0.3333,2,1,3,1,1),(9,'Miguel, Ángel y Pablo compitieron en una carrera. Miguel llegó último después de Pablo. ¿En qué puesto llegó Ángel?',0.2,0.3333,3,1,3,1,1),(10,'Si 1 plátano equivale a 2 manzanas. ¿A cuántas manzanas  equivalen tres plátanos? ',0.1,0.3333,1,1,4,1,1),(11,'Si 1 plátano equivale a 2 manzanas y 1 manzana equivale a 4 uvas. ¿A cuántas uvas equivalen dos plátanos?',0.15,0.3333,2,1,4,1,1),(12,'Si 1 billete de S/ 100.00 equivale a 10 billetes de S/ 10.00. ¿A cuántos billetes de S/. 10.00 equivale un billete de S/ 200.00?',0.2,0.3333,3,1,4,1,1),(13,'José, un estudiante del segundo grado, recorre 100 metros en 4 minutos. ¿Cuántos metros recorrerá en 2 minutos?',0.1,0.3333,1,1,5,1,1),(14,'José, un estudiante del segundo grado, recorre 150 metros en 6 minutos. ¿Cuántos metros recorrerá en 2 minutos?',0.15,0.3333,2,1,5,1,1),(15,'Don Pedro escarba 5 huachos de papa en 30 minutos. ¿Cuántos huachos de papa escarbará en dos horas?',0.2,0.3333,3,1,5,1,1),(16,'Juan tiene 2 decenas de cuyes y Manuel 25 cuyes. ¿Quién tiene mayor cantidad de cuyes?',0.1,0.3333,1,1,6,1,1),(17,'Juan tiene 5 decenas de cuyes y Manuel 55 cuyes. ¿Quién tiene mayor cantidad de cuyes?',0.15,0.3333,2,1,6,1,1),(18,'Raúl tiene 10 decenas de choclos y María 70 choclos. ¿Quién tiene mayor cantidad de choclos?',0.2,0.3333,3,1,6,1,1),(19,'Ernesto dice que después de haber recibido un sol de propina durante 2 días, ahora tiene 2 soles. ¿Estás de acuerdo con la afirmación de Ernesto?',0.1,0.3333,1,1,7,1,1),(20,'Edgar dice que después de haber recibido un sol de propina durante cinco días, ahora tiene 5 soles. ¿Estás de acuerdo con la afirmación de Edgar?',0.15,0.3333,2,1,7,1,1),(21,'Margot dice que después de haber juntado su propina de S/ 2.00 diarios durante 10 días, ahora tiene  S/ 20.00 soles. ¿Estás de acuerdo con la afirmación de Margot?',0.2,0.3333,3,1,7,1,1),(22,'Si Pablo tiene 10 años y Pedro tiene 5. ¿Cuántos años le falta a Pedro para tener la edad de Pablo?',0.1,0.3333,1,1,8,1,1),(23,'Si Manuel tiene 14 años y María tiene 8. ¿Cuántos años le falta a María para tener la edad de Manuel?',0.15,0.3333,2,1,8,1,1),(24,'Si Percy tiene 24 años y José tiene 7. ¿Cuántos años le falta a José para tener la edad de Percy?',0.2,0.3333,3,1,8,1,1),(25,'¿Qué número sigue en la secuencia?',0.1,0.3333,1,1,9,1,1),(26,'¿Qué número sigue en la secuencia ?',0.15,0.3333,2,1,9,1,1),(27,'¿Qué número sigue en la secuencia  ?',0.2,0.3333,3,1,9,1,1),(28,'De la chacra de Don Juan lograron escarbar 10 sacos de papa, de la chacra de Don Fausto lograron escarbar la mitad de lo que escarbó Don Juan. ¿Cuántos sacos de papa tendría que escarbar Don Fausto para tener la misma cantidad que Don Juan?',0.1,0.3333,1,1,10,1,1),(29,'De la chacra de Don Pepe lograron escarbar 20 sacos de papa, de la chacra de Don Agustín lograron escarbar la mitad de lo que escarbó Don Pepe. ¿Cuántos sacos de papa tendría que escarbar Don Agustín para tener la misma cantidad que Don Pepe?',0.15,0.3333,2,1,10,1,1),(30,'En el techado de la casa de Don Mauro utilizaron 46 calaminas, en el techado de la casa de Don Agustín utilizaron la mitad de lo que utilizó Don Mauro. ¿Cuántas calaminas menos utilizaron en el techado de la casa de Don Agustín?',0.2,0.3333,3,1,10,1,1),(31,'¿Qué número es el que falta en la secuencia?',0.1,0.3333,1,1,11,1,1),(32,'¿Qué número es el que falta en la secuencia ?',0.15,0.3333,2,1,11,1,1),(33,'¿Qué número es el que falta en la secuencia  ?',0.2,0.3333,3,1,11,1,1),(34,'Si Pedro tiene 5 juguetes y Saúl tiene 3. ¿Cuántos juguetes tendría que darle Pedro a Saúl  para que ambos tengan la misma cantidad?',0.1,0.3333,1,1,12,1,1),(35,'Si Pedro tiene 11 juguetes y Saúl tiene 7. ¿Cuántos juguetes debe darle Pedro a Saul para que ambos tengan la misma cantidad?',0.15,0.3333,2,1,12,1,1),(36,'Si Jaimito tiene 37 juguetes y Carlos tiene 17. ¿Cuántos juguetes tendría que darle Jaimito a Carlos para que ambos tengan la misma cantidad?',0.2,0.3333,3,1,12,1,1),(37,'¿Qué sigue en la secuencia?',0.1,0.3333,1,1,13,1,1),(38,'¿Qué sigue en la secuencia ?',0.15,0.3333,2,1,13,1,1),(39,'¿Qué sigue en la secuencia  ?',0.2,0.3333,3,1,13,1,1),(40,'¿Cuál es el perímetro del rectángulo?',0.1,0.3333,1,1,14,1,1),(41,'¿Cuál es el perímetro del rectángulo ?',0.15,0.3333,2,1,14,1,1),(42,'¿Cuál es el perímetro del rectángulo  ?',0.2,0.3333,3,1,14,1,1),(43,'Observa el dibujo y responde: ¿Qué juguete está a la izquierda del niño?',0.1,0.3333,1,1,15,1,1),(44,'Observa el dibujo y responde: ¿Qué juguete está a la derecha del niño?',0.15,0.3333,2,1,15,1,1),(45,'Observa el dibujo y responde: ¿Qué juguetes están a la derecha del niño?',0.2,0.3333,3,1,15,1,1),(46,'¿Cuántas caras tiene este cubo?',0.1,0.3333,1,1,16,1,1),(47,'¿Cuántas caras en total hay en los 2 cubos?',0.15,0.3333,2,1,16,1,1),(48,'¿Cuántas caras en total hay en los 3 cubos?',0.2,0.3333,3,1,16,1,1),(49,'César compra una soga de 3 metros y Saúl  compra una soga dos veces más larga que la de César. ¿Cuánto mide la soga que compró Saúl?',0.1,0.3333,1,1,17,1,1),(50,'Carlos compra una soga de 3 metros y Jorge compra una soga tres veces más larga que la de Carlos. ¿Cuánto mide la soga que compró Jorge?',0.15,0.3333,2,1,17,1,1),(51,'Carlos compra una soga de 3 metros a 1 sol cada metro y Jorge compra una soga dos veces más larga que la de Carlos al mismo precio por metro. ¿Cuánto pagará Jorge por la soga que compró?',0.2,0.3333,3,1,17,1,1),(52,'Observa la imagen: ¿Quién se encuentra delante de la persona?',0.1,0.3333,1,1,18,1,1),(53,'Observa la imagen: ¿Quién se encuentra detrás de la persona?',0.15,0.3333,2,1,18,1,1),(54,'Observa la imagen: ¿Qué animales se encuentran detrás de la persona?',0.2,0.3333,3,1,18,1,1),(55,'De la casa de Jorge a la casa de Ana hay 10 pasos. ¿Cuántos pasos tiene que dar Jorge para ir y regresar?',0.1,0.3333,1,1,19,1,1),(56,'De la casa de Jorge a la casa de Ana hay 80 pasos. ¿Cuántos pasos tiene que dar Jorge para ir y regresar?',0.15,0.3333,2,1,19,1,1),(57,'De la escuela a la casa de Isaías hay 35 m. ¿Cuántos metros habrá para hacer el recorrido de ida y vuelta?',0.2,0.3333,3,1,19,1,1),(58,'¿En qué se parecen estas figuras ?',0.1,0.3333,1,1,20,1,1),(59,'¿En qué se parecen estas figuras?',0.15,0.3333,2,1,20,1,1),(60,'¿En qué se parecen estas figuras  ?',0.2,0.3333,3,1,20,1,1),(61,'Observa el siguiente cuadro: ¿Cuál es la fruta que no les gusta a los alumnos del segundo grado?',0.1,0.3333,1,1,21,1,1),(62,'Observa el siguiente cuadro: ¿Cuál es la fruta más preferida por los alumnos de la escuela?',0.15,0.3333,2,1,21,1,1),(63,'Observa el siguiente cuadro: ¿Cuáles son las frutas más preferidas por los alumnos de la escuela?',0.2,0.3333,3,1,21,1,1),(64,'Se tiene, en una bolsa, caramelos de colores. Si se saca, un caramelo a la vez de la bolsa: Cuantas veces saldrá un caramelo rojo…',0.1,0.3333,1,1,22,1,1),(65,'Se tiene en una bolsa caramelos de colores. Si se saca, sin mirar, un caramelo de la bolsa: Saldrá un caramelo rojo…',0.15,0.3333,2,1,22,1,1),(66,'Se tiene un dado. Al tirar el dado saldrá el número seis…',0.2,0.3333,3,1,22,1,1),(67,'En el aula del segundo grado se preguntó por el deporte favorito de los estudiantes: ¿Cuál es el deporte que menos se practica en el aula del segundo grado?',0.1,0.3333,1,1,23,1,1),(68,'En el aula del segundo grado se preguntó por el deporte favorito de los estudiantes: ¿Cuál es el deporte menos favorito en el aula?',0.15,0.3333,2,1,23,1,1),(69,'En el aula del segundo grado se preguntó por el deporte favorito de los estudiantes: ¿Cuál es el deporte más y menos favorito en el aula?',0.2,0.3333,3,1,23,1,1),(70,'Observa el gráfico: ¿Cuántos goles se anotaron en los dos partidos?',0.1,0.3333,1,1,24,1,1),(71,'Observa el gráfico: ¿Cuántos goles se anotaron en los cuatro partidos?',0.15,0.3333,2,1,24,1,1),(72,'Observa el gráfico: ¿Cuántos goles se anotaron entre el primer y el tercer partido?',0.2,0.3333,3,1,24,1,1),(73,'Observa el grafico: ¿Cuántos días del mes de noviembre habrá nubes y sol?',0.1,0.3333,1,1,25,1,1),(74,'Observa el grafico: Si deseo salir a correr al campo sin mojarme, ¿Cuántos días del mes de noviembre no podré utilizar?',0.15,0.3333,2,1,25,1,1),(75,'Observa el grafico: Si deseo aprovechar los días para hacer secar mi ropa, ¿Cuántos días del mes de noviembre podré utilizar?',0.2,0.3333,3,1,25,1,1),(76,'Pedro tiene 1 gato y 2 perros. ¿Cuántos animales tiene en total Pedro?',0.1,0.3333,1,2,1,1,1),(77,'Pedro tiene 2 ovejas y 4 gallinas. ¿Cuántos animales tiene en total Pedro?',0.15,0.3333,2,2,1,1,1),(78,'Denis tiene 7 ovejas y 5 gallinas. ¿Cuántos animales tiene en total Denis?',0.2,0.3333,3,2,1,1,1),(79,'En una granja hay una docena de cuyes grandes y 5 cuyes pequeños. ¿Cuántos cuyes en total hay en la granja?',0.1,0.3333,1,2,2,1,1),(80,'En una granja hay una docena de cuyes grandes y una decena de cuyes pequeños. ¿Cuántos cuyes en total hay en la granja? ',0.15,0.3333,2,2,2,1,1),(81,'En una granja hay dos docenas de gallinas blancas y dos decenas de gallinas rojas. ¿Cuántas gallinas en total hay en la granja?',0.2,0.3333,3,2,2,1,1),(82,'Carlos, Manuel y José compitieron en una carrera. Manuel está en primer lugar y Carlos llegó después. ¿En qué puesto llegó José?',0.1,0.3333,1,2,3,1,1),(83,'Carlos, Manuel y José compitieron en una carrera. Manuel quedó en segundo lugar y después de él llegó Carlos. ¿En qué puesto llegó José?',0.15,0.3333,2,2,3,1,1),(84,'Miguel, Ángel y Pablo compitieron en una carrera. Miguel llegó último después de Pablo. ¿En qué puesto llegó Ángel?',0.2,0.3333,3,2,3,1,1),(85,'Si 1 plátano equivale a 2 manzanas. ¿A cuántas manzanas  equivalen tres plátanos?',0.1,0.3333,1,2,4,1,1),(86,'Si 1 plátano equivale a 2 manzanas y 1 manzana equivale a 4 uvas. ¿A cuántas uvas equivalen dos plátanos?',0.15,0.3333,2,2,4,1,1),(87,'Si 1 billete de S/ 100.00 equivale a 10 billetes de S/ 10.00. ¿A cuántos billetes de S/. 10.00 equivale un billete de S/ 200.00?',0.2,0.3333,3,2,4,1,1),(88,'José, un estudiante del segundo grado, recorre 100 metros en 4 minutos. ¿Cuántos metros recorrerá en 2 minutos?',0.1,0.3333,1,2,5,1,1),(89,'José, un estudiante del segundo grado, recorre 150 metros en 6 minutos. ¿Cuántos metros recorrerá en 2 minutos?',0.15,0.3333,2,2,5,1,1),(90,'Don Pedro escarba 5 huachos de papa en 30 minutos. ¿Cuántos huachos de papa escarbará en dos horas?',0.2,0.3333,3,2,5,1,1),(91,'Juan tiene 2 decenas de cuyes y Manuel 25 cuyes. ¿Quién tiene mayor cantidad de cuyes?',0.1,0.3333,1,2,6,1,1),(92,'Juan tiene 5 decenas de cuyes y Manuel 55 cuyes. ¿Quién tiene mayor cantidad de cuyes?',0.15,0.3333,2,2,6,1,1),(93,'Raúl tiene 10 decenas de choclos y María 70 choclos. ¿Quién tiene mayor cantidad de choclos?',0.2,0.3333,3,2,6,1,1),(94,'Ernesto dice que después de haber recibido un sol de propina durante 2 días, ahora tiene 2 soles. ¿Estás de acuerdo con la afirmación de Ernesto?',0.1,0.3333,1,2,7,1,1),(95,'Edgar dice que después de haber recibido un sol de propina durante cinco días, ahora tiene 5 soles. ¿Estás de acuerdo con la afirmación de Edgar?',0.15,0.3333,2,2,7,1,1),(96,'Margot dice que después de haber juntado su propina de S/ 2.00 diarios durante 10 días, ahora tiene  S/ 20.00 soles. ¿Estás de acuerdo con la afirmación de Margot?',0.2,0.3333,3,2,7,1,1),(97,'Si Pablo tiene 10 años y Pedro tiene 5. ¿Cuántos años le falta a Pedro para tener la edad de Pablo?',0.1,0.3333,1,2,8,1,1),(98,'Si Manuel tiene 14 años y María tiene 8. ¿Cuántos años le falta a María para tener la edad de Manuel?',0.15,0.3333,2,2,8,1,1),(99,'Si Percy tiene 24 años y José tiene 7. ¿Cuántos años le falta a José para tener la edad de Percy?',0.2,0.3333,3,2,8,1,1),(100,'¿Qué número sigue en la secuencia ?',0.1,0.3333,1,2,9,1,1),(101,'¿Qué número sigue en la secuencia?',0.15,0.3333,2,2,9,1,1),(102,'¿Qué número sigue en la secuencia  ?',0.2,0.3333,3,2,9,1,1),(103,'De la chacra de Don Juan lograron escarbar 10 sacos de papa, de la chacra de Don Fausto lograron escarbar la mitad de lo que escarbó Don Juan. ¿Cuántos sacos de papa tendría que escarbar Don Fausto para tener la misma cantidad que Don Juan?',0.1,0.3333,1,2,10,1,1),(104,'De la chacra de Don Pepe lograron escarbar 20 sacos de papa, de la chacra de Don Agustín lograron escarbar la mitad de lo que escarbó Don Pepe. ¿Cuántos sacos de papa tendría que escarbar Don Agustín para tener la misma cantidad que Don Pepe?',0.15,0.3333,2,2,10,1,1),(105,'En el techado de la casa de Don Mauro utilizaron 46 calaminas, en el techado de la casa de Don Agustín utilizaron la mitad de lo que utilizó Don Mauro. ¿Cuántas calaminas menos utilizaron en el techado de la casa de Don Agustín?',0.2,0.3333,3,2,10,1,1),(106,'¿Qué número es el que falta en la secuencia ?',0.1,0.3333,1,2,11,1,1),(107,'¿Qué número es el que falta en la secuencia?',0.15,0.3333,2,2,11,1,1),(108,'¿Qué número es el que falta en la secuencia  ?',0.2,0.3333,3,2,11,1,1),(109,'Si Pedro tiene 5 juguetes y Saúl tiene 3. ¿Cuántos juguetes tendría que darle Pedro a Saúl  para que ambos tengan la misma cantidad?',0.1,0.3333,1,2,12,1,1),(110,'Si Pedro tiene 11 juguetes y Saúl tiene 7. ¿Cuántos juguetes debe darle Pedro a Saul para que ambos tengan la misma cantidad?',0.15,0.3333,2,2,12,1,1),(111,'Si Jaimito tiene 37 juguetes y Carlos tiene 17. ¿Cuántos juguetes tendría que darle Jaimito a Carlos  para que ambos tengan la misma cantidad?',0.2,0.3333,3,2,12,1,1),(112,'¿Qué sigue en la secuencia ? ',0.1,0.3333,1,2,13,1,1),(113,'¿Qué sigue en la secuencia?',0.15,0.3333,2,2,13,1,1),(114,'¿Qué sigue en la secuencia  ? ',0.2,0.3333,3,2,13,1,1),(115,'¿Cuál es el perímetro del rectángulo ?',0.1,0.3333,1,2,14,1,1),(116,'¿Cuál es el perímetro del rectángulo?',0.15,0.3333,2,2,14,1,1),(117,'¿Cuál es el perímetro del rectángulo  ?',0.2,0.3333,3,2,14,1,1),(118,'Observa el dibujo y responde: ¿Qué juguete está a la izquierda del niño?',0.1,0.3333,1,2,15,1,1),(119,'Observa el dibujo y responde: ¿Qué juguete está a la derecha del niño?',0.15,0.3333,2,2,15,1,1),(120,'Observa el dibujo y responde: ¿Qué juguetes están a la derecha del niño?',0.2,0.3333,3,2,15,1,1),(121,'¿Cuántas caras tiene este cubo?',0.1,0.3333,1,2,16,1,1),(122,'¿Cuántas caras en total hay en los 2 cubos?',0.15,0.3333,2,2,16,1,1),(123,'¿Cuántas caras en total hay en los 3 cubos?',0.2,0.3333,3,2,16,1,1),(124,'César compra una soga de 3 metros y Saúl  compra una soga dos veces más larga que la de César. ¿Cuánto mide la soga que compró Saúl?',0.1,0.3333,1,2,17,1,1),(125,'Carlos compra una soga de 3 metros y Jorge compra una soga tres veces más larga que la de Carlos. ¿Cuánto mide la soga que compró Jorge?',0.15,0.3333,2,2,17,1,1),(126,'Carlos compra una soga de 3 metros a 1 sol cada metro y Jorge compra una soga dos veces más larga que la de Carlos al mismo precio por metro. ¿Cuánto pagará Jorge por la soga que compró?',0.2,0.3333,3,2,17,1,1),(127,'Observa la imagen: ¿Quién se encuentra delante de la persona?',0.1,0.3333,1,2,18,1,1),(128,'Observa la imagen: ¿Quién se encuentra detrás de la persona?',0.15,0.3333,2,2,18,1,1),(129,'Observa la imagen: ¿Qué animales se encuentran detrás de la persona?',0.2,0.3333,3,2,18,1,1),(130,'De la casa de Jorge a la casa de Ana hay 10 pasos. 	¿Cuántos pasos tiene que dar Jorge para ir y regresar? ',0.1,0.3333,1,2,19,1,1),(131,'De la casa de Jorge a la casa de Ana hay 80 pasos. ¿Cuántos pasos tiene que dar Jorge para ir y regresar? ',0.15,0.3333,2,2,19,1,1),(132,'De la escuela a la casa de Isaías hay 35 metros. ¿Cuántos metros habrá para  hacer el recorrido de ida y vuelta?',0.2,0.3333,3,2,19,1,1),(133,'¿En qué se parecen estas figuras ?',0.1,0.3333,1,2,20,1,1),(134,'¿En qué se parecen estas figuras?',0.15,0.3333,2,2,20,1,1),(135,'¿En qué se parecen estas figuras  ?',0.2,0.3333,3,2,20,1,1),(136,'Observa el siguiente cuadro: ¿Cuál es la fruta que no les gusta a los alumnos del segundo grado?',0.1,0.3333,1,2,21,1,1),(137,'Observa el siguiente cuadro: ¿Cuál es la fruta más preferida por los alumnos de la escuela?',0.15,0.3333,2,2,21,1,1),(138,'Observa el siguiente cuadro: ¿Cuáles son las frutas más preferidas por los alumnos de la escuela?',0.2,0.3333,3,2,21,1,1),(139,'Se tiene, en una bolsa, caramelos de colores. Si se saca, un caramelo a la vez de la bolsa: Cuantas veces saldrá un caramelo rojo…',0.1,0.3333,1,2,22,1,1),(140,'Se tiene en una bolsa caramelos de colores. Si se saca, sin mirar, un caramelo de la bolsa: Saldrá un caramelo rojo…',0.15,0.3333,2,2,22,1,1),(141,'Se tiene un dado. Al tirar el dado saldrá el número seis…',0.2,0.3333,3,2,22,1,1),(142,'En el aula del segundo grado se preguntó por el deporte favorito de los estudiantes: ¿Cuál es el deporte que menos se practica en el aula del segundo grado?',0.1,0.3333,1,2,23,1,1),(143,'En el aula del segundo grado se preguntó por el deporte favorito de los estudiantes: ¿Cuál es el deporte menos favorito en el aula?',0.15,0.3333,2,2,23,1,1),(144,'En el aula del segundo grado se preguntó por el deporte favorito de los estudiantes: ¿Cuál es el deporte más y menos favorito en el aula?',0.2,0.3333,3,2,23,1,1),(145,'Observa el gráfico: ¿Cuántos goles se anotaron en los dos partidos?',0.1,0.3333,1,2,24,1,1),(146,'Observa el gráfico: ¿Cuántos goles se anotaron en los cuatro partidos?',0.15,0.3333,2,2,24,1,1),(147,'Observa el gráfico: ¿Cuántos goles se anotaron entre el primer y el tercer partido?',0.2,0.3333,3,2,24,1,1),(148,'Observa el grafico: ¿Cuántos días del mes de noviembre habrá nubes y sol?',0.1,0.3333,1,2,25,1,1),(149,'Observa el grafico: Si deseo salir a correr al campo sin mojarme, ¿Cuántos días del mes de noviembre no podré utilizar?',0.15,0.3333,2,2,25,1,1),(150,'Observa el grafico: Si deseo aprovechar los días para hacer secar mi ropa, ¿Cuántos días del mes de noviembre podré utilizar?',0.2,0.3333,3,2,25,1,1);
/*!40000 ALTER TABLE `pregunta` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `resultado`
--

DROP TABLE IF EXISTS `resultado`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `resultado` (
  `idresultado` int(11) NOT NULL AUTO_INCREMENT,
  `idevaluacion_adaptativa` int(11) NOT NULL,
  `idalternativa` int(11) NOT NULL,
  `conocimiento_aposteriori` double NOT NULL,
  `tiempo` int(11) NOT NULL,
  PRIMARY KEY (`idresultado`),
  KEY `fk_resultado_evaluacion_adaptativa1_idx` (`idevaluacion_adaptativa`),
  KEY `fk_resultado_alternativa1_idx` (`idalternativa`),
  CONSTRAINT `fk_resultado_alternativa1` FOREIGN KEY (`idalternativa`) REFERENCES `alternativa` (`idalternativa`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `fk_resultado_evaluacion_adaptativa1` FOREIGN KEY (`idevaluacion_adaptativa`) REFERENCES `evaluacion_adaptativa` (`idevaluacion_adaptativa`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=1816 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `resultado`
--

LOCK TABLES `resultado` WRITE;
/*!40000 ALTER TABLE `resultado` DISABLE KEYS */;
INSERT INTO `resultado` VALUES (1,1,32,0.7928,272),(2,1,44,0.7826,297),(3,1,4,0.7928,205),(4,1,266,0.7928,276),(5,1,35,0.7826,183),(6,1,59,0.7928,225),(7,1,52,0.7826,236),(8,1,248,0.7928,283),(9,1,256,0.2523,249),(10,1,268,0.3103,293),(11,1,62,0.7826,258),(12,1,16,0.3103,190),(13,1,14,0.7928,196),(14,1,42,0.2523,187),(15,1,242,0.7826,250),(16,1,251,0.7826,225),(17,1,49,0.7928,274),(18,1,7,0.7826,236),(19,2,67,0.8561,255),(20,2,70,0.8485,226),(21,2,73,0.863,263),(22,2,78,0.3443,298),(23,2,303,0.3443,242),(24,2,314,0.4118,214),(25,2,86,0.3443,242),(26,2,312,0.8561,226),(27,2,89,0.4118,184),(28,2,94,0.8561,263),(29,2,97,0.8485,181),(30,2,107,0.8485,254),(31,2,112,0.3443,267),(32,2,339,0.8561,231),(33,2,342,0.8485,255),(34,2,104,0.8561,242),(35,3,121,0.2947,222),(36,3,120,0.8337,284),(37,3,131,0.8257,295),(38,3,134,0.8168,281),(39,3,141,0.2947,299),(40,3,373,0.8257,190),(41,3,150,0.2947,194),(42,3,376,0.8168,180),(43,3,346,0.2947,214),(44,3,177,0.8257,192),(45,3,165,0.8337,216),(46,3,391,0.2947,282),(47,3,386,0.8168,183),(48,3,383,0.8257,206),(49,3,180,0.8168,263),(50,3,366,0.2947,236),(51,3,137,0.8337,292),(52,3,166,0.2947,288),(53,4,185,0.403,225),(54,4,420,0.8844,279),(55,4,409,0.8844,260),(56,4,423,0.8781,242),(57,4,412,0.8781,211),(58,4,214,0.8781,226),(59,4,436,0.8844,275),(60,4,432,0.8781,239),(61,4,440,0.4737,269),(62,4,429,0.8844,288),(63,4,220,0.403,292),(64,4,447,0.8844,255),(65,4,450,0.8781,297),(66,5,1,0.7675,261),(67,5,237,0.1549,194),(68,5,7,0.7458,204),(69,5,26,0.7458,216),(70,5,30,0.1549,250),(71,5,38,0.7675,260),(72,5,51,0.2157,210),(73,5,41,0.7571,290),(74,5,23,0.7571,240),(75,5,4,0.7571,228),(76,5,255,0.1549,200),(77,5,21,0.7675,214),(78,5,281,0.7675,248),(79,5,270,0.2683,259),(80,5,284,0.7571,211),(81,5,274,0.7571,298),(82,5,12,0.1549,273),(83,5,45,0.2683,253),(84,5,46,0.7675,224),(85,5,277,0.7458,261),(86,5,287,0.7458,290),(87,7,67,0.7928,207),(88,7,295,0.7826,186),(89,7,72,0.3103,209),(90,7,304,0.7826,267),(91,7,314,0.3103,244),(92,7,301,0.7928,200),(93,7,312,0.7928,288),(94,7,89,0.3103,259),(95,7,112,0.2523,211),(96,7,87,0.7928,298),(97,7,104,0.7928,275),(98,7,94,0.7928,262),(99,7,331,0.3103,265),(100,7,341,0.3103,198),(101,7,339,0.7928,215),(102,7,117,0.7826,259),(103,7,106,0.3103,189),(104,7,97,0.7826,187),(105,8,123,0.8257,267),(106,8,351,0.8168,194),(107,8,141,0.2947,189),(108,8,124,0.3578,260),(109,8,359,0.8168,275),(110,8,366,0.2947,251),(111,8,137,0.8337,213),(112,8,161,0.8168,209),(113,8,150,0.2947,184),(114,8,158,0.8257,195),(115,8,169,0.3578,203),(116,8,177,0.8257,206),(117,8,356,0.8257,201),(118,8,179,0.3578,287),(119,8,168,0.8257,252),(120,8,145,0.8337,298),(121,8,375,0.2947,272),(122,8,404,0.3578,246),(123,8,394,0.3578,193),(124,9,181,0.7675,247),(125,9,192,0.7675,197),(126,9,195,0.7571,261),(127,9,184,0.7571,254),(128,9,413,0.2683,267),(129,9,198,0.7458,231),(130,9,188,0.2683,254),(131,9,201,0.7675,238),(132,9,213,0.2157,204),(133,9,438,0.2157,208),(134,9,207,0.7458,204),(135,9,221,0.2157,298),(136,9,219,0.7675,296),(137,9,447,0.7571,247),(138,9,450,0.7458,244),(139,9,208,0.7675,260),(140,9,204,0.7571,224),(141,10,4,0.8257,243),(142,10,14,0.8257,201),(143,10,243,0.3578,297),(144,10,7,0.8168,299),(145,10,16,0.3578,262),(146,10,23,0.8257,194),(147,10,36,0.3578,201),(148,10,26,0.8168,205),(149,10,261,0.3578,200),(150,10,269,0.8168,283),(151,10,287,0.8168,237),(152,10,53,0.3578,234),(153,10,274,0.8257,237),(154,10,278,0.3578,262),(155,10,32,0.8257,258),(156,10,61,0.3578,286),(157,10,49,0.8257,194),(158,10,42,0.2947,252),(159,10,59,0.8257,217),(160,10,266,0.8257,228),(161,11,71,0.4118,266),(162,11,67,0.8561,188),(163,11,295,0.8485,282),(164,11,304,0.8485,263),(165,11,301,0.8561,250),(166,11,312,0.8561,238),(167,11,330,0.3443,218),(168,11,105,0.3443,278),(169,11,322,0.8485,275),(170,11,315,0.8485,201),(171,11,341,0.4118,199),(172,11,101,0.863,291),(173,11,116,0.4118,278),(174,11,114,0.8561,294),(175,11,319,0.8561,298),(176,12,123,0.8844,267),(177,12,351,0.8781,220),(178,12,356,0.8844,197),(179,12,124,0.4737,223),(180,12,359,0.8781,185),(181,12,150,0.403,277),(182,12,365,0.8844,246),(183,12,145,0.8901,181),(184,12,158,0.8844,186),(185,12,169,0.4737,285),(186,12,368,0.8781,289),(187,12,394,0.4737,247),(188,12,179,0.4737,266),(189,12,404,0.4737,250),(190,12,375,0.403,231),(191,12,177,0.8844,184),(192,12,161,0.8781,245),(193,12,168,0.8844,213),(194,13,184,0.8844,230),(195,13,188,0.4737,291),(196,13,420,0.8844,185),(197,13,432,0.8781,191),(198,13,412,0.8781,298),(199,13,438,0.403,217),(200,13,213,0.403,209),(201,13,429,0.8844,292),(202,13,222,0.8844,253),(203,13,208,0.8901,289),(204,13,225,0.8781,224),(205,13,423,0.8781,274),(206,14,4,0.8561,238),(207,14,24,0.3443,267),(208,14,17,0.8485,281),(209,14,32,0.8561,261),(210,14,250,0.4118,244),(211,14,7,0.8485,213),(212,14,14,0.8561,233),(213,14,41,0.8561,185),(214,14,27,0.4118,247),(215,14,44,0.8485,218),(216,14,248,0.8561,248),(217,14,62,0.8485,245),(218,14,50,0.3443,263),(219,14,46,0.863,237),(220,14,275,0.3443,295),(221,14,59,0.8561,182),(222,14,35,0.8485,287),(223,15,67,0.8257,187),(224,15,295,0.8168,214),(225,15,301,0.8257,290),(226,15,312,0.8257,225),(227,15,95,0.2947,273),(228,15,71,0.3578,232),(229,15,90,0.8168,239),(230,15,108,0.3578,278),(231,15,304,0.8168,211),(232,15,332,0.8168,240),(233,15,314,0.3578,225),(234,15,340,0.3578,186),(235,15,91,0.8337,274),(236,15,114,0.8257,233),(237,15,339,0.8257,241),(238,15,104,0.8257,287),(239,15,115,0.3578,251),(240,15,320,0.2947,291),(241,16,123,0.8844,241),(242,16,126,0.8781,232),(243,16,131,0.8844,217),(244,16,134,0.8781,288),(245,16,150,0.403,207),(246,16,143,0.8781,191),(247,16,140,0.8844,232),(248,16,145,0.8901,246),(249,16,168,0.8844,193),(250,16,169,0.4737,245),(251,16,402,0.8844,188),(252,16,161,0.8781,225),(253,16,405,0.8781,219),(254,16,396,0.8781,201),(255,16,375,0.403,245),(256,16,158,0.8844,280),(257,17,187,0.8781,205),(258,17,195,0.8844,206),(259,17,215,0.4737,193),(260,17,427,0.403,245),(261,17,413,0.4737,187),(262,17,201,0.8901,220),(263,17,222,0.8844,199),(264,17,447,0.8844,234),(265,17,439,0.8781,232),(266,17,224,0.4737,239),(267,17,211,0.8844,275),(268,17,198,0.8781,200),(269,17,409,0.8844,194),(270,17,449,0.4737,268),(271,17,185,0.403,299),(272,17,202,0.403,230),(273,18,4,0.7928,274),(274,18,238,0.2523,216),(275,18,7,0.7826,280),(276,18,10,0.1837,288),(277,18,23,0.7928,261),(278,18,235,0.1837,220),(279,18,26,0.7826,214),(280,18,32,0.7928,193),(281,18,35,0.7826,219),(282,18,267,0.2523,296),(283,18,49,0.7928,245),(284,18,53,0.3103,233),(285,18,42,0.2523,208),(286,18,62,0.7826,243),(287,18,286,0.3103,249),(288,18,277,0.7826,294),(289,18,284,0.7928,263),(290,18,13,0.2523,214),(291,18,38,0.802,180),(292,19,69,0.2523,277),(293,19,76,0.7928,265),(294,19,294,0.2523,272),(295,19,64,0.802,223),(296,19,312,0.7928,200),(297,19,89,0.3103,229),(298,19,319,0.7928,205),(299,19,83,0.1837,238),(300,19,80,0.3103,232),(301,19,117,0.7826,228),(302,19,304,0.7826,224),(303,19,314,0.3103,214),(304,19,323,0.3103,299),(305,19,86,0.2523,271),(306,19,329,0.7928,236),(307,19,114,0.7928,269),(308,19,309,0.802,294),(309,19,105,0.2523,201),(310,19,107,0.7826,265),(311,19,97,0.7826,259),(312,19,331,0.3103,279),(313,20,348,0.8257,280),(314,20,359,0.8168,221),(315,20,144,0.3578,283),(316,20,121,0.2947,294),(317,20,356,0.8257,277),(318,20,377,0.3578,284),(319,20,351,0.8168,249),(320,20,364,0.2947,292),(321,20,369,0.3578,252),(322,20,158,0.8257,283),(323,20,150,0.2947,197),(324,20,161,0.8168,277),(325,20,405,0.8168,215),(326,20,171,0.8168,260),(327,20,140,0.8257,196),(328,20,395,0.3578,220),(329,20,151,0.8168,291),(330,20,402,0.8257,213),(331,20,166,0.2947,210),(332,20,373,0.8257,194),(333,20,393,0.8257,236),(334,20,176,0.2947,258),(335,21,185,0.2947,242),(336,21,181,0.8337,217),(337,21,429,0.8257,257),(338,21,203,0.2947,291),(339,21,410,0.2947,225),(340,21,432,0.8168,272),(341,21,193,0.2947,225),(342,21,438,0.2947,206),(343,21,418,0.2947,257),(344,21,215,0.3578,204),(345,21,192,0.8337,268),(346,21,446,0.2947,269),(347,21,221,0.2947,198),(348,21,211,0.8257,205),(349,21,219,0.8337,210),(350,21,439,0.8168,216),(351,22,1,0.7675,227),(352,22,4,0.7571,265),(353,22,8,0.2683,185),(354,22,11,0.7675,267),(355,22,233,0.2683,201),(356,22,13,0.2157,221),(357,22,238,0.2157,282),(358,22,250,0.2683,286),(359,22,46,0.7675,243),(360,22,38,0.7675,256),(361,22,21,0.7675,210),(362,22,29,0.7675,182),(363,22,49,0.7571,299),(364,22,42,0.2157,248),(365,22,258,0.2157,241),(366,22,281,0.7675,242),(367,22,23,0.7571,267),(368,22,287,0.7458,268),(369,22,33,0.2157,197),(370,22,277,0.7458,201),(371,22,267,0.2157,195),(372,22,53,0.2683,270),(373,22,25,0.2683,186),(374,22,59,0.7571,257),(375,22,283,0.2157,268),(376,22,61,0.2683,226),(377,23,73,0.7297,228),(378,23,80,0.2308,241),(379,23,76,0.7183,181),(380,23,67,0.7183,201),(381,23,71,0.2308,239),(382,23,312,0.7183,252),(383,23,106,0.2308,201),(384,23,296,0.2308,271),(385,23,309,0.7297,289),(386,23,316,0.7297,294),(387,23,305,0.2308,260),(388,23,111,0.7297,199),(389,23,341,0.2308,234),(390,23,104,0.7183,234),(391,23,113,0.1837,244),(392,23,331,0.2308,298),(393,23,315,0.7059,297),(394,23,116,0.2308,252),(395,23,96,0.1837,268),(396,23,64,0.7297,244),(397,23,82,0.1304,192),(398,23,91,0.7297,251),(399,23,320,0.1837,217),(400,23,339,0.7183,230),(401,23,101,0.7297,278),(402,24,120,0.6884,239),(403,24,123,0.676,262),(404,24,350,0.1971,250),(405,24,125,0.1971,243),(406,24,128,0.6884,244),(407,24,131,0.676,272),(408,24,368,0.6626,289),(409,24,137,0.6884,285),(410,24,140,0.676,216),(411,24,373,0.676,247),(412,24,144,0.1971,246),(413,24,152,0.1971,269),(414,24,173,0.6884,266),(415,24,134,0.6626,181),(416,24,377,0.1971,245),(417,24,148,0.676,223),(418,24,392,0.1555,279),(419,24,155,0.6884,264),(420,24,161,0.6626,263),(421,24,177,0.676,184),(422,24,370,0.6884,268),(423,24,179,0.1971,206),(424,24,158,0.676,247),(425,24,405,0.6626,274),(426,24,167,0.1555,291),(427,24,165,0.6884,289),(428,25,184,0.7928,235),(429,25,187,0.7826,205),(430,25,198,0.7826,221),(431,25,205,0.3103,268),(432,25,204,0.7928,218),(433,25,195,0.7928,186),(434,25,432,0.7826,295),(435,25,445,0.2523,215),(436,25,436,0.7928,208),(437,25,221,0.2523,296),(438,25,219,0.802,277),(439,25,439,0.7826,274),(440,26,4,0.8257,198),(441,26,239,0.8257,186),(442,26,13,0.2947,237),(443,26,257,0.8257,287),(444,26,241,0.3578,264),(445,26,7,0.8168,235),(446,26,251,0.8168,286),(447,26,17,0.8168,262),(448,26,27,0.3578,230),(449,26,266,0.8257,265),(450,26,23,0.8257,294),(451,26,270,0.3578,216),(452,26,44,0.8168,216),(453,26,260,0.8168,210),(454,26,53,0.3578,182),(455,26,284,0.8257,299),(456,26,277,0.8168,247),(457,26,287,0.8168,238),(458,26,49,0.8257,227),(459,27,67,0.8561,199),(460,27,70,0.8485,216),(461,27,310,0.3443,259),(462,27,76,0.8561,189),(463,27,79,0.8485,187),(464,27,83,0.2592,265),(465,27,331,0.4118,184),(466,27,85,0.3443,265),(467,27,113,0.3443,190),(468,27,319,0.8561,297),(469,27,322,0.8485,213),(470,27,107,0.8485,194),(471,27,339,0.8561,230),(472,27,309,0.863,229),(473,27,329,0.8561,232),(474,27,342,0.8485,254),(475,28,121,0.403,234),(476,28,348,0.8844,188),(477,28,365,0.8844,254),(478,28,359,0.8781,247),(479,28,351,0.8781,253),(480,28,150,0.403,182),(481,28,368,0.8781,292),(482,28,375,0.403,211),(483,28,383,0.8844,199),(484,28,386,0.8781,261),(485,28,393,0.8844,249),(486,28,356,0.8844,241),(487,28,395,0.4737,236),(488,28,177,0.8844,235),(489,28,179,0.4737,247),(490,28,169,0.4737,190),(491,28,405,0.8781,226),(492,28,168,0.8844,222),(493,28,370,0.8901,210),(494,28,147,0.3103,283),(495,29,185,0.403,205),(496,29,182,0.3103,194),(497,29,406,0.8901,254),(498,29,420,0.8844,229),(499,29,410,0.403,281),(500,29,429,0.8844,258),(501,29,423,0.8781,224),(502,29,206,0.4737,248),(503,29,431,0.4737,225),(504,29,204,0.8844,282),(505,29,440,0.4737,274),(506,29,222,0.8844,184),(507,29,215,0.4737,238),(508,29,224,0.4737,297),(509,29,450,0.8781,189),(510,29,211,0.8844,196),(511,30,4,0.8561,189),(512,30,17,0.8485,258),(513,30,14,0.8561,263),(514,30,23,0.8561,198),(515,30,251,0.8485,220),(516,30,257,0.8561,287),(517,30,260,0.8485,192),(518,30,27,0.4118,239),(519,30,43,0.4118,279),(520,30,62,0.8485,215),(521,30,266,0.8561,258),(522,30,52,0.8485,185),(523,30,41,0.8561,290),(524,30,49,0.8561,196),(525,30,268,0.4118,248),(526,30,59,0.8561,192),(527,30,7,0.8485,235),(528,31,67,0.8844,258),(529,31,70,0.8781,245),(530,31,86,0.403,230),(531,31,76,0.8844,194),(532,31,311,0.403,180),(533,31,79,0.8781,218),(534,31,308,0.3103,208),(535,31,341,0.4737,283),(536,31,83,0.3103,214),(537,31,97,0.8781,239),(538,31,94,0.8844,212),(539,31,117,0.8781,244),(540,31,112,0.403,242),(541,31,107,0.8781,257),(542,31,339,0.8844,221),(543,31,104,0.8844,230),(544,32,356,0.9107,265),(545,32,365,0.9107,297),(546,32,351,0.9057,230),(547,32,152,0.5454,277),(548,32,359,0.9057,235),(549,32,125,0.5454,241),(550,32,383,0.9107,281),(551,32,386,0.9057,221),(552,32,148,0.9107,282),(553,32,165,0.9153,285),(554,32,180,0.9057,240),(555,32,368,0.9057,245),(556,32,177,0.9107,282),(557,32,375,0.4737,213),(558,32,376,0.9057,241),(559,32,123,0.9107,223),(560,32,391,0.4737,291),(561,32,166,0.4737,207),(562,33,184,0.8844,183),(563,33,187,0.8781,190),(564,33,195,0.8844,180),(565,33,200,0.3103,231),(566,33,198,0.8781,272),(567,33,428,0.403,206),(568,33,437,0.403,232),(569,33,426,0.8901,205),(570,33,211,0.8844,226),(571,33,440,0.4737,293),(572,33,221,0.403,208),(573,33,450,0.8781,298),(574,33,215,0.4737,286),(575,33,203,0.403,194),(576,33,447,0.8844,251),(577,34,4,0.7928,215),(578,34,7,0.7826,221),(579,34,17,0.7826,238),(580,34,241,0.3103,187),(581,34,260,0.7826,239),(582,34,268,0.3103,294),(583,34,13,0.2523,291),(584,34,26,0.7826,233),(585,34,266,0.7928,189),(586,34,44,0.7826,268),(587,34,284,0.7928,190),(588,34,49,0.7928,288),(589,34,23,0.7928,289),(590,34,53,0.3103,240),(591,34,257,0.7928,230),(592,34,31,0.2523,211),(593,34,239,0.7928,264),(594,34,277,0.7826,225),(595,34,287,0.7826,235),(596,35,70,0.8485,278),(597,35,67,0.8561,226),(598,35,77,0.3443,192),(599,35,73,0.863,182),(600,35,84,0.863,235),(601,35,302,0.3443,287),(602,35,94,0.8561,271),(603,35,310,0.3443,274),(604,35,85,0.3443,216),(605,35,98,0.4118,276),(606,35,323,0.4118,271),(607,35,341,0.4118,188),(608,35,116,0.4118,264),(609,35,107,0.8485,297),(610,35,114,0.8561,230),(611,35,104,0.8561,280),(612,36,122,0.2947,250),(613,36,347,0.2947,186),(614,36,133,0.3578,202),(615,36,131,0.8257,232),(616,36,148,0.8257,212),(617,36,359,0.8168,263),(618,36,152,0.3578,217),(619,36,141,0.2947,195),(620,36,402,0.8257,222),(621,36,166,0.2947,187),(622,36,391,0.2947,288),(623,36,161,0.8168,298),(624,36,365,0.8257,284),(625,36,176,0.2947,188),(626,36,405,0.8168,224),(627,36,120,0.8337,218),(628,36,144,0.3578,195),(629,36,165,0.8337,221),(630,36,158,0.8257,299),(631,36,369,0.3578,253),(632,36,377,0.3578,267),(633,36,137,0.8337,233),(634,37,185,0.403,266),(635,37,410,0.403,289),(636,37,181,0.8901,184),(637,37,195,0.8844,195),(638,37,203,0.403,201),(639,37,423,0.8781,201),(640,37,201,0.8901,299),(641,37,215,0.4737,192),(642,37,428,0.403,204),(643,37,450,0.8781,223),(644,37,222,0.8844,282),(645,37,440,0.4737,282),(646,37,211,0.8844,220),(647,37,196,0.4737,273),(648,37,224,0.4737,246),(649,38,7,0.8781,192),(650,38,4,0.8844,239),(651,38,238,0.403,279),(652,38,13,0.403,215),(653,38,235,0.3103,260),(654,38,23,0.8844,192),(655,38,26,0.8781,201),(656,38,32,0.8844,210),(657,38,36,0.4737,224),(658,38,266,0.8844,268),(659,38,269,0.8781,210),(660,38,260,0.8781,262),(661,38,277,0.8781,223),(662,38,274,0.8844,225),(663,38,284,0.8844,238),(664,38,10,0.3103,292),(665,38,62,0.8781,287),(666,38,286,0.4737,217),(667,39,67,0.8257,244),(668,39,70,0.8168,228),(669,39,86,0.2947,189),(670,39,76,0.8257,280),(671,39,79,0.8168,251),(672,39,84,0.8337,196),(673,39,319,0.8257,244),(674,39,104,0.8257,290),(675,39,323,0.3578,260),(676,39,97,0.8168,210),(677,39,332,0.8168,290),(678,39,311,0.2947,237),(679,39,108,0.3578,214),(680,39,114,0.8257,259),(681,39,95,0.2947,194),(682,39,337,0.2947,210),(683,39,117,0.8168,246),(684,40,121,0.3443,261),(685,40,346,0.3443,227),(686,40,134,0.8485,251),(687,40,120,0.863,232),(688,40,143,0.8485,189),(689,40,140,0.8561,265),(690,40,131,0.8561,298),(691,40,373,0.8561,236),(692,40,376,0.8485,185),(693,40,383,0.8561,238),(694,40,386,0.8485,291),(695,40,402,0.8561,281),(696,40,149,0.3443,192),(697,40,393,0.8561,257),(698,40,396,0.8485,248),(699,40,405,0.8485,249),(700,41,420,0.8561,277),(701,41,423,0.8485,181),(702,41,412,0.8485,212),(703,41,188,0.4118,294),(704,41,213,0.3443,257),(705,41,221,0.3443,180),(706,41,450,0.8485,268),(707,41,429,0.8561,221),(708,41,438,0.3443,200),(709,41,432,0.8485,237),(710,41,208,0.863,246),(711,41,447,0.8561,295),(712,41,184,0.8561,277),(735,43,1,0.7675,278),(736,43,7,0.7458,218),(737,43,11,0.7675,278),(738,43,4,0.7571,275),(739,43,18,0.2683,198),(740,43,242,0.7458,185),(741,43,251,0.7458,232),(742,43,35,0.7458,261),(743,43,246,0.7675,272),(744,43,271,0.7675,233),(745,43,257,0.7571,248),(746,43,38,0.7675,202),(747,43,248,0.7571,286),(748,43,269,0.7458,242),(749,43,14,0.7571,253),(750,43,254,0.7675,197),(751,43,41,0.7571,244),(752,43,59,0.7571,288),(753,43,45,0.2683,246),(754,43,62,0.7458,268),(755,43,277,0.7458,261),(756,43,274,0.7571,282),(757,43,281,0.7675,284),(758,43,261,0.2683,234),(759,43,283,0.2157,218),(760,44,64,0.7675,286),(761,44,73,0.7675,198),(762,44,301,0.7571,269),(763,44,67,0.7571,290),(764,44,309,0.7675,182),(765,44,312,0.7571,182),(766,44,315,0.7458,261),(767,44,304,0.7458,297),(768,44,319,0.7571,242),(769,44,94,0.7571,218),(770,44,77,0.2157,265),(771,44,323,0.2683,209),(772,44,103,0.2157,270),(773,44,101,0.7675,262),(774,44,316,0.7675,281),(775,44,342,0.7458,278),(776,44,332,0.7458,206),(777,44,339,0.7571,214),(778,44,98,0.2683,233),(779,44,70,0.7458,181),(780,44,336,0.7675,227),(781,44,329,0.7571,252),(782,45,120,0.6884,236),(783,45,121,0.1555,203),(784,45,348,0.676,205),(785,45,356,0.676,196),(786,45,353,0.6884,265),(787,45,359,0.6626,274),(788,45,351,0.6626,237),(789,45,368,0.6626,259),(790,45,371,0.1093,246),(791,45,365,0.676,232),(792,45,362,0.6884,202),(793,45,373,0.676,211),(794,45,149,0.1555,230),(795,45,145,0.6884,294),(796,45,383,0.676,202),(797,45,376,0.6626,267),(798,45,177,0.676,269),(799,45,386,0.6626,204),(800,45,173,0.6884,232),(801,45,392,0.1555,207),(802,45,179,0.1971,239),(803,45,167,0.1555,233),(804,45,405,0.6626,229),(805,45,165,0.6884,222),(806,45,390,0.6884,204),(807,45,380,0.6884,253),(808,46,181,0.7297,191),(809,46,412,0.7059,218),(810,46,409,0.7183,295),(811,46,417,0.7297,239),(812,46,420,0.7183,208),(813,46,426,0.7297,225),(814,46,423,0.7059,278),(815,46,431,0.2308,256),(816,46,185,0.1837,224),(817,46,208,0.7297,252),(818,46,212,0.1837,246),(819,46,444,0.7297,252),(820,46,225,0.7059,184),(821,46,447,0.7183,183),(822,46,207,0.7059,263),(823,46,429,0.7183,182),(824,46,449,0.2308,264),(825,46,439,0.7059,191),(826,46,436,0.7183,184),(827,47,4,0.7928,244),(828,47,7,0.7826,210),(829,47,13,0.2523,215),(830,47,239,0.7928,225),(831,47,242,0.7826,259),(832,47,257,0.7928,280),(833,47,251,0.7826,283),(834,47,248,0.7928,235),(835,47,36,0.3103,226),(836,47,41,0.7928,201),(837,47,287,0.7826,229),(838,47,261,0.3103,199),(839,47,32,0.7928,207),(840,47,284,0.7928,219),(841,47,277,0.7826,252),(842,47,49,0.7928,261),(843,47,45,0.3103,211),(844,47,270,0.3103,289),(845,47,53,0.3103,233),(846,48,67,0.8561,197),(847,48,70,0.8485,186),(848,48,302,0.3443,239),(849,48,77,0.3443,294),(850,48,73,0.863,294),(851,48,85,0.3443,247),(852,48,320,0.3443,253),(853,48,98,0.4118,182),(854,48,312,0.8561,289),(855,48,94,0.8561,200),(856,48,106,0.4118,271),(857,48,342,0.8485,293),(858,48,323,0.4118,195),(859,48,339,0.8561,232),(860,48,332,0.8485,235),(861,48,315,0.8485,260),(862,48,104,0.8561,255),(863,49,121,0.2947,271),(864,49,348,0.8257,253),(865,49,376,0.8168,228),(866,49,368,0.8168,280),(867,49,356,0.8257,257),(868,49,351,0.8168,222),(869,49,373,0.8257,238),(870,49,383,0.8257,183),(871,49,386,0.8168,221),(872,49,395,0.3578,217),(873,49,168,0.8257,199),(874,49,176,0.2947,242),(875,49,404,0.3578,274),(876,49,402,0.8257,184),(877,49,392,0.2947,236),(878,49,170,0.3578,288),(879,49,365,0.8257,272),(880,49,359,0.8168,273),(881,49,180,0.8168,209),(882,50,185,0.2947,244),(883,50,409,0.8257,255),(884,50,420,0.8257,201),(885,50,428,0.2947,260),(886,50,412,0.8168,236),(887,50,425,0.2179,299),(888,50,200,0.2179,206),(889,50,436,0.8257,273),(890,50,423,0.8168,288),(891,50,203,0.2947,277),(892,50,213,0.2947,181),(893,50,447,0.8257,215),(894,50,449,0.3578,189),(895,50,439,0.8168,200),(896,50,225,0.8168,211),(897,51,49,0.8561,237),(898,51,4,0.8561,210),(899,51,38,0.863,238),(900,51,260,0.8485,220),(901,51,16,0.4118,283),(902,51,252,0.4118,297),(903,51,32,0.8561,294),(904,51,27,0.4118,240),(905,51,36,0.4118,215),(906,51,23,0.8561,255),(907,51,53,0.4118,287),(908,51,42,0.3443,212),(909,51,277,0.8485,217),(910,51,284,0.8561,228),(911,51,7,0.8485,269),(912,51,287,0.8485,200),(913,51,267,0.3443,214),(914,51,241,0.4118,247),(915,51,14,0.8561,252),(916,52,67,0.8561,299),(917,52,80,0.4118,277),(918,52,76,0.8561,268),(919,52,312,0.8561,289),(920,52,86,0.3443,180),(921,52,305,0.4118,292),(922,52,70,0.8485,219),(923,52,94,0.8561,238),(924,52,89,0.4118,193),(925,52,113,0.3443,272),(926,52,332,0.8485,197),(927,52,111,0.863,191),(928,52,322,0.8485,261),(929,52,314,0.4118,271),(930,52,329,0.8561,233),(931,52,338,0.3443,251),(932,52,98,0.4118,215),(933,53,123,0.8844,222),(934,53,131,0.8844,244),(935,53,134,0.8781,212),(936,53,126,0.8781,228),(937,53,137,0.8901,284),(938,53,366,0.403,276),(939,53,141,0.403,188),(940,53,146,0.3103,252),(941,53,374,0.403,233),(942,53,149,0.403,191),(943,53,386,0.8781,272),(944,53,370,0.8901,209),(945,53,165,0.8901,246),(946,53,176,0.403,264),(947,53,402,0.8844,241),(948,53,167,0.403,190),(949,53,392,0.403,248),(950,53,405,0.8781,209),(951,53,383,0.8844,199),(952,54,184,0.8844,268),(953,54,195,0.8844,282),(954,54,202,0.403,264),(955,54,421,0.4737,255),(956,54,187,0.8781,261),(957,54,429,0.8844,199),(958,54,432,0.8781,234),(959,54,446,0.403,230),(960,54,221,0.403,228),(961,54,439,0.8781,229),(962,54,219,0.8901,240),(963,54,436,0.8844,292),(964,54,196,0.4737,278),(965,55,4,0.8257,295),(966,55,233,0.3578,299),(967,55,8,0.3578,272),(968,55,239,0.8257,240),(969,55,13,0.2947,285),(970,55,242,0.8168,241),(971,55,252,0.3578,252),(972,55,33,0.2947,196),(973,55,26,0.8168,244),(974,55,248,0.8257,289),(975,55,284,0.8257,255),(976,55,266,0.8257,188),(977,55,287,0.8168,193),(978,55,41,0.8257,298),(979,55,45,0.3578,213),(980,55,257,0.8257,190),(981,55,270,0.3578,210),(982,55,274,0.8257,260),(983,55,50,0.2947,211),(984,55,260,0.8168,292),(985,55,277,0.8168,245),(986,56,4,0.7928,250),(987,56,8,0.3103,296),(988,56,14,0.7928,267),(989,56,233,0.3103,228),(990,56,27,0.3103,237),(991,56,242,0.7826,281),(992,56,18,0.3103,231),(993,56,266,0.7928,212),(994,56,23,0.7928,267),(995,56,248,0.7928,237),(996,56,275,0.2523,283),(997,56,252,0.3103,243),(998,56,260,0.7826,267),(999,56,271,0.802,263),(1000,56,33,0.2523,294),(1001,56,284,0.7928,219),(1002,56,47,0.1837,234),(1003,56,257,0.7928,293),(1004,56,269,0.7826,183),(1005,56,50,0.2523,296),(1006,56,287,0.7826,229),(1007,57,67,0.8561,275),(1008,57,77,0.3443,229),(1009,57,301,0.8561,218),(1010,57,70,0.8485,185),(1011,57,304,0.8485,287),(1012,57,310,0.3443,180),(1013,57,85,0.3443,180),(1014,57,309,0.863,260),(1015,57,332,0.8485,298),(1016,57,319,0.8561,251),(1017,57,322,0.8485,259),(1018,57,329,0.8561,200),(1019,57,116,0.4118,245),(1020,57,114,0.8561,284),(1021,57,338,0.3443,223),(1022,57,342,0.8485,284),(1023,57,83,0.2592,290),(1024,58,351,0.8485,255),(1025,58,356,0.8561,186),(1026,58,140,0.8561,182),(1027,58,143,0.8485,254),(1028,58,366,0.3443,261),(1029,58,150,0.3443,201),(1030,58,373,0.8561,245),(1031,58,348,0.8561,278),(1032,58,386,0.8485,196),(1033,58,395,0.4118,286),(1034,58,171,0.8485,262),(1035,58,359,0.8485,229),(1036,58,376,0.8485,258),(1037,58,176,0.3443,264),(1038,58,393,0.8561,204),(1039,58,405,0.8485,247),(1040,58,121,0.3443,283),(1041,58,383,0.8561,212),(1042,58,402,0.8561,229),(1043,59,184,0.7928,292),(1044,59,196,0.3103,189),(1045,59,195,0.7928,208),(1046,59,200,0.1837,255),(1047,59,423,0.7826,187),(1048,59,202,0.2523,190),(1049,59,436,0.7928,289),(1050,59,222,0.7928,294),(1051,59,439,0.7826,261),(1052,59,426,0.802,204),(1053,59,427,0.2523,255),(1054,59,450,0.7826,203),(1055,59,446,0.2523,270),(1056,59,187,0.7826,278),(1057,59,224,0.3103,239),(1058,60,4,0.8844,263),(1059,60,7,0.8781,255),(1060,60,13,0.403,268),(1061,60,239,0.8844,231),(1062,60,26,0.8781,250),(1063,60,252,0.4737,219),(1064,60,261,0.4737,242),(1065,60,35,0.8781,214),(1066,60,274,0.8844,242),(1067,60,248,0.8844,227),(1068,60,42,0.403,189),(1069,60,277,0.8781,281),(1070,60,266,0.8844,260),(1071,60,257,0.8844,237),(1072,60,284,0.8844,184),(1073,60,242,0.8781,228),(1074,60,269,0.8781,246),(1075,60,31,0.403,208),(1076,60,287,0.8781,198),(1077,61,67,0.9107,266),(1078,61,70,0.9057,274),(1079,61,302,0.4737,232),(1080,61,77,0.4737,236),(1081,61,86,0.4737,266),(1082,61,73,0.9153,279),(1083,61,323,0.5454,259),(1084,61,98,0.5454,236),(1085,61,319,0.9107,180),(1086,61,315,0.9057,213),(1087,61,312,0.9107,185),(1088,61,108,0.5454,184),(1089,61,104,0.9107,266),(1090,61,332,0.9057,197),(1091,61,342,0.9057,205),(1092,61,94,0.9107,213),(1093,61,339,0.9107,229),(1094,62,121,0.403,284),(1095,62,351,0.8781,275),(1096,62,368,0.8781,180),(1097,62,359,0.8781,213),(1098,62,150,0.403,187),(1099,62,365,0.8844,196),(1100,62,147,0.3103,197),(1101,62,356,0.8844,296),(1102,62,383,0.8844,189),(1103,62,393,0.8844,198),(1104,62,165,0.8901,200),(1105,62,375,0.403,184),(1106,62,348,0.8844,219),(1107,62,370,0.8901,204),(1108,62,395,0.4737,260),(1109,62,386,0.8781,228),(1110,62,405,0.8781,259),(1111,62,176,0.403,273),(1112,62,170,0.4737,244),(1113,62,402,0.8844,181),(1114,62,167,0.403,194),(1115,63,184,0.9107,206),(1116,63,423,0.9057,227),(1117,63,187,0.9057,296),(1118,63,197,0.5454,217),(1119,63,429,0.9107,218),(1120,63,437,0.4737,219),(1121,63,195,0.9107,221),(1122,63,212,0.4737,227),(1123,63,208,0.9153,250),(1124,63,432,0.9057,229),(1125,63,225,0.9057,295),(1126,63,221,0.4737,208),(1127,63,449,0.5454,292),(1128,63,447,0.9107,256),(1129,64,4,0.7928,184),(1130,64,14,0.7928,291),(1131,64,7,0.7826,201),(1132,64,27,0.3103,274),(1133,64,23,0.7928,184),(1134,64,261,0.3103,239),(1135,64,269,0.7826,182),(1136,64,18,0.3103,211),(1137,64,62,0.7826,289),(1138,64,36,0.3103,231),(1139,64,251,0.7826,188),(1140,64,52,0.7826,265),(1141,64,42,0.2523,181),(1142,64,32,0.7928,249),(1143,64,241,0.3103,243),(1144,64,274,0.7928,248),(1145,64,59,0.7928,289),(1146,64,278,0.3103,241),(1147,64,266,0.7928,239),(1148,64,257,0.7928,248),(1149,65,68,0.2947,182),(1150,65,305,0.3578,186),(1151,65,314,0.3578,285),(1152,65,80,0.3578,286),(1153,65,77,0.2947,233),(1154,65,90,0.8168,207),(1155,65,320,0.2947,236),(1156,65,104,0.8257,218),(1157,65,64,0.8337,280),(1158,65,91,0.8337,285),(1159,65,108,0.3578,245),(1160,65,312,0.8257,268),(1161,65,341,0.3578,264),(1162,65,333,0.3578,297),(1163,65,113,0.2947,230),(1164,65,339,0.8257,280),(1165,65,117,0.8168,247),(1166,65,301,0.8257,295),(1167,65,293,0.2947,272),(1168,65,95,0.2947,256),(1169,66,122,0.3443,243),(1170,66,126,0.8485,225),(1171,66,350,0.4118,297),(1172,66,135,0.4118,227),(1173,66,359,0.8485,265),(1174,66,365,0.8561,183),(1175,66,369,0.4118,259),(1176,66,376,0.8485,284),(1177,66,144,0.4118,185),(1178,66,373,0.8561,211),(1179,66,131,0.8561,279),(1180,66,167,0.3443,180),(1181,66,383,0.8561,203),(1182,66,162,0.4118,254),(1183,66,402,0.8561,202),(1184,66,158,0.8561,267),(1185,66,141,0.3443,267),(1186,66,387,0.4118,194),(1187,66,149,0.3443,187),(1188,66,393,0.8561,251),(1189,66,137,0.863,237),(1190,66,395,0.4118,208),(1191,66,348,0.8561,229),(1192,66,169,0.4118,299),(1193,66,405,0.8485,227),(1194,67,184,0.8561,258),(1195,67,413,0.4118,267),(1196,67,196,0.4118,219),(1197,67,428,0.3443,196),(1198,67,188,0.4118,220),(1199,67,195,0.8561,290),(1200,67,423,0.8485,212),(1201,67,440,0.4118,207),(1202,67,225,0.8485,299),(1203,67,215,0.4118,294),(1204,67,211,0.8561,231),(1205,67,436,0.8561,293),(1206,67,449,0.4118,191),(1207,67,206,0.4118,217),(1208,67,204,0.8561,290),(1209,67,432,0.8485,218),(1210,67,221,0.3443,238),(1211,67,447,0.8561,197),(1212,68,4,0.8257,291),(1213,68,233,0.3578,282),(1214,68,8,0.3578,197),(1215,68,27,0.3578,279),(1216,68,13,0.2947,223),(1217,68,248,0.8257,299),(1218,68,23,0.8257,242),(1219,68,33,0.2947,214),(1220,68,36,0.3578,241),(1221,68,252,0.3578,225),(1222,68,274,0.8257,298),(1223,68,261,0.3578,237),(1224,68,278,0.3578,190),(1225,68,59,0.8257,260),(1226,68,287,0.8168,267),(1227,68,242,0.8168,214),(1228,68,266,0.8257,289),(1229,68,52,0.8168,221),(1230,68,239,0.8257,258),(1231,68,257,0.8257,287),(1232,68,269,0.8168,201),(1233,68,61,0.3578,281),(1234,69,295,0.8168,222),(1235,69,67,0.8257,288),(1236,69,304,0.8168,190),(1237,69,71,0.3578,227),(1238,69,86,0.2947,224),(1239,69,84,0.8337,218),(1240,69,99,0.3578,199),(1241,69,319,0.8257,239),(1242,69,301,0.8257,256),(1243,69,332,0.8168,221),(1244,69,95,0.2947,238),(1245,69,323,0.3578,186),(1246,69,106,0.3578,235),(1247,69,116,0.3578,276),(1248,69,104,0.8257,216),(1249,69,338,0.2947,271),(1250,69,114,0.8257,246),(1251,69,342,0.8168,195),(1252,69,311,0.2947,258),(1253,69,328,0.2947,241),(1254,70,122,0.403,214),(1255,70,348,0.8844,244),(1256,70,131,0.8844,239),(1257,70,126,0.8781,242),(1258,70,350,0.4737,272),(1259,70,135,0.4737,293),(1260,70,359,0.8781,190),(1261,70,150,0.403,208),(1262,70,365,0.8844,251),(1263,70,375,0.403,290),(1264,70,383,0.8844,236),(1265,70,368,0.8781,211),(1266,70,170,0.4737,244),(1267,70,165,0.8901,246),(1268,70,370,0.8901,277),(1269,70,146,0.3103,187),(1270,70,395,0.4737,245),(1271,70,393,0.8844,200),(1272,70,166,0.403,285),(1273,70,176,0.403,244),(1274,70,402,0.8844,266),(1275,70,386,0.8781,256),(1276,70,405,0.8781,262),(1277,71,185,0.3443,202),(1278,71,187,0.8485,243),(1279,71,196,0.4118,270),(1280,71,413,0.4118,278),(1281,71,423,0.8485,239),(1282,71,431,0.4118,262),(1283,71,429,0.8561,250),(1284,71,211,0.8561,243),(1285,71,215,0.4118,247),(1286,71,440,0.4118,283),(1287,71,225,0.8485,216),(1288,71,449,0.4118,247),(1289,71,220,0.3443,247),(1290,71,206,0.4118,276),(1291,71,447,0.8561,294),(1292,71,204,0.8561,185),(1293,71,409,0.8561,182),(1294,71,195,0.8561,251),(1295,72,8,0.4118,252),(1296,72,233,0.4118,283),(1297,72,4,0.8561,200),(1298,72,239,0.8561,289),(1299,72,243,0.4118,264),(1300,72,23,0.8561,232),(1301,72,13,0.3443,268),(1302,72,17,0.8485,185),(1303,72,266,0.8561,257),(1304,72,42,0.3443,270),(1305,72,284,0.8561,239),(1306,72,269,0.8485,285),(1307,72,29,0.863,248),(1308,72,275,0.3443,284),(1309,72,26,0.8485,213),(1310,72,258,0.3443,233),(1311,72,53,0.4118,184),(1312,72,62,0.8485,240),(1313,72,286,0.4118,189),(1314,72,49,0.8561,246),(1315,72,33,0.3443,199),(1316,72,277,0.8485,279),(1317,73,71,0.3578,218),(1318,73,302,0.2947,270),(1319,73,77,0.2947,238),(1320,73,73,0.8337,278),(1321,73,86,0.2947,214),(1322,73,295,0.8168,255),(1323,73,314,0.3578,292),(1324,73,96,0.2947,236),(1325,73,89,0.3578,203),(1326,73,319,0.8257,206),(1327,73,312,0.8257,202),(1328,73,104,0.8257,291),(1329,73,323,0.3578,267),(1330,73,114,0.8257,244),(1331,73,97,0.8168,195),(1332,73,108,0.3578,264),(1333,73,116,0.3578,274),(1334,73,333,0.3578,238),(1335,73,342,0.8168,265),(1336,73,67,0.8257,273),(1337,74,122,0.2947,226),(1338,74,347,0.2947,211),(1339,74,133,0.3578,279),(1340,74,141,0.2947,299),(1341,74,359,0.8168,198),(1342,74,366,0.2947,230),(1343,74,362,0.8337,218),(1344,74,145,0.8337,297),(1345,74,158,0.8257,251),(1346,74,180,0.8168,265),(1347,74,161,0.8168,231),(1348,74,374,0.2947,258),(1349,74,395,0.3578,257),(1350,74,131,0.8257,292),(1351,74,138,0.2179,227),(1352,74,168,0.8257,278),(1353,74,150,0.2947,246),(1354,74,402,0.8257,298),(1355,74,404,0.3578,293),(1356,74,170,0.3578,226),(1357,74,176,0.2947,273),(1358,74,120,0.8337,227),(1359,75,184,0.7928,215),(1360,75,419,0.2523,293),(1361,75,195,0.7928,239),(1362,75,412,0.7826,215),(1363,75,188,0.3103,258),(1364,75,196,0.3103,185),(1365,75,421,0.3103,288),(1366,75,204,0.7928,184),(1367,75,430,0.3103,198),(1368,75,206,0.3103,216),(1369,75,224,0.3103,266),(1370,75,439,0.7826,221),(1371,75,436,0.7928,208),(1372,75,447,0.7928,273),(1373,75,449,0.3103,281),(1374,75,213,0.2523,245),(1375,75,222,0.7928,281),(1376,76,4,0.8844,208),(1377,76,7,0.8781,219),(1378,76,13,0.403,249),(1379,76,251,0.8781,247),(1380,76,12,0.3103,269),(1381,76,266,0.8844,264),(1382,76,32,0.8844,292),(1383,76,236,0.8901,207),(1384,76,269,0.8781,296),(1385,76,238,0.403,281),(1386,76,258,0.403,296),(1387,76,50,0.403,297),(1388,76,35,0.8781,257),(1389,76,248,0.8844,291),(1390,76,287,0.8781,225),(1391,76,47,0.3103,271),(1392,76,275,0.403,221),(1393,76,284,0.8844,190),(1394,76,42,0.403,186),(1395,76,271,0.8901,261),(1396,77,67,0.8844,285),(1397,77,70,0.8781,299),(1398,77,310,0.403,183),(1399,77,95,0.403,274),(1400,77,319,0.8844,242),(1401,77,84,0.8901,286),(1402,77,76,0.8844,243),(1403,77,114,0.8844,256),(1404,77,104,0.8844,211),(1405,77,330,0.403,188),(1406,77,107,0.8781,205),(1407,77,115,0.4737,241),(1408,77,342,0.8781,250),(1409,77,79,0.8781,184),(1410,77,85,0.403,192),(1411,77,322,0.8781,184),(1412,78,122,0.4737,247),(1413,78,348,0.9107,219),(1414,78,359,0.9057,255),(1415,78,351,0.9057,278),(1416,78,150,0.4737,282),(1417,78,368,0.9057,236),(1418,78,383,0.9107,234),(1419,78,356,0.9107,241),(1420,78,375,0.4737,281),(1421,78,393,0.9107,221),(1422,78,170,0.5454,280),(1423,78,395,0.5454,279),(1424,78,147,0.375,215),(1425,78,167,0.4737,255),(1426,78,370,0.9153,292),(1427,78,176,0.4737,231),(1428,78,386,0.9057,180),(1429,78,165,0.9153,225),(1430,78,365,0.9107,245),(1431,78,402,0.9107,211),(1432,78,405,0.9057,217),(1433,79,184,0.9107,231),(1434,79,187,0.9057,283),(1435,79,421,0.5454,263),(1436,79,196,0.5454,243),(1437,79,207,0.9057,208),(1438,79,204,0.9107,208),(1439,79,436,0.9107,198),(1440,79,428,0.4737,264),(1441,79,420,0.9107,266),(1442,79,447,0.9107,196),(1443,79,450,0.9057,203),(1444,79,193,0.4737,206),(1445,79,215,0.5454,201),(1446,79,213,0.4737,287),(1447,79,440,0.5454,251),(1448,80,8,0.4118,293),(1449,80,13,0.3443,250),(1450,80,4,0.8561,273),(1451,80,239,0.8561,273),(1452,80,248,0.8561,204),(1453,80,242,0.8485,223),(1454,80,233,0.4118,280),(1455,80,26,0.8485,270),(1456,80,267,0.3443,291),(1457,80,252,0.4118,182),(1458,80,260,0.8485,296),(1459,80,33,0.3443,233),(1460,80,257,0.8561,297),(1461,80,52,0.8485,203),(1462,80,49,0.8561,267),(1463,80,42,0.3443,263),(1464,80,38,0.863,295),(1465,80,61,0.4118,226),(1466,80,59,0.8561,261),(1467,80,287,0.8485,288),(1468,81,68,0.3443,196),(1469,81,293,0.3443,253),(1470,81,76,0.8561,219),(1471,81,87,0.8561,233),(1472,81,79,0.8485,287),(1473,81,64,0.863,275),(1474,81,89,0.4118,293),(1475,81,322,0.8485,298),(1476,81,314,0.4118,271),(1477,81,108,0.4118,240),(1478,81,319,0.8561,287),(1479,81,333,0.4118,254),(1480,81,95,0.3443,188),(1481,81,329,0.8561,197),(1482,81,113,0.3443,200),(1483,81,103,0.3443,189),(1484,81,117,0.8485,243),(1485,81,339,0.8561,188),(1486,81,101,0.863,228),(1487,81,341,0.4118,238),(1488,82,122,0.2947,286),(1489,82,348,0.8257,253),(1490,82,349,0.3578,186),(1491,82,369,0.3578,192),(1492,82,131,0.8257,181),(1493,82,149,0.2947,229),(1494,82,158,0.8257,259),(1495,82,373,0.8257,268),(1496,82,144,0.3578,223),(1497,82,376,0.8168,211),(1498,82,402,0.8257,285),(1499,82,405,0.8168,212),(1500,82,134,0.8168,225),(1501,82,383,0.8257,267),(1502,82,176,0.2947,199),(1503,82,140,0.8257,215),(1504,82,395,0.3578,254),(1505,82,170,0.3578,286),(1506,82,168,0.8257,209),(1507,82,387,0.3578,206),(1508,82,126,0.8168,182),(1509,82,162,0.3578,190),(1510,83,184,0.8561,184),(1511,83,188,0.4118,247),(1512,83,413,0.4118,224),(1513,83,423,0.8485,278),(1514,83,420,0.8561,257),(1515,83,440,0.4118,232),(1516,83,428,0.3443,289),(1517,83,193,0.3443,285),(1518,83,432,0.8485,221),(1519,83,204,0.8561,266),(1520,83,211,0.8561,207),(1521,83,224,0.4118,255),(1522,83,222,0.8561,196),(1523,83,215,0.4118,232),(1524,83,436,0.8561,230),(1525,83,206,0.4118,236),(1526,83,449,0.4118,268),(1527,84,7,0.7826,291),(1528,84,13,0.2523,190),(1529,84,238,0.2523,216),(1530,84,11,0.802,288),(1531,84,36,0.3103,214),(1532,84,23,0.7928,224),(1533,84,32,0.7928,257),(1534,84,261,0.3103,271),(1535,84,26,0.7826,242),(1536,84,41,0.7928,299),(1537,84,45,0.3103,187),(1538,84,270,0.3103,297),(1539,84,62,0.7826,225),(1540,84,53,0.3103,253),(1541,84,59,0.7928,251),(1542,84,49,0.7928,272),(1543,84,278,0.3103,268),(1544,84,4,0.7928,183),(1545,85,67,0.8257,250),(1546,85,71,0.3578,242),(1547,85,296,0.3578,237),(1548,85,76,0.8257,240),(1549,85,79,0.8168,266),(1550,85,320,0.2947,271),(1551,85,312,0.8257,217),(1552,85,95,0.2947,289),(1553,85,315,0.8168,214),(1554,85,91,0.8337,223),(1555,85,329,0.8257,253),(1556,85,103,0.2947,255),(1557,85,113,0.2947,295),(1558,85,107,0.8168,250),(1559,85,341,0.3578,263),(1560,85,333,0.3578,227),(1561,85,116,0.3578,243),(1562,85,339,0.8257,193),(1563,85,86,0.2947,254),(1564,86,121,0.2523,232),(1565,86,120,0.802,296),(1566,86,131,0.7928,204),(1567,86,346,0.2523,272),(1568,86,134,0.7826,288),(1569,86,141,0.2523,281),(1570,86,138,0.1837,201),(1571,86,148,0.7928,180),(1572,86,362,0.802,199),(1573,86,393,0.7928,232),(1574,86,383,0.7928,222),(1575,86,374,0.2523,193),(1576,86,405,0.7826,199),(1577,86,179,0.3103,197),(1578,86,395,0.3103,285),(1579,86,165,0.802,253),(1580,86,166,0.2523,188),(1581,86,376,0.7826,202),(1582,86,386,0.7826,224),(1583,86,177,0.7928,294),(1584,86,152,0.3103,218),(1585,86,366,0.2523,228),(1586,86,170,0.3103,264),(1587,87,184,0.7928,295),(1588,87,413,0.3103,223),(1589,87,188,0.3103,249),(1590,87,193,0.2523,237),(1591,87,420,0.7928,215),(1592,87,206,0.3103,265),(1593,87,422,0.3103,218),(1594,87,198,0.7826,195),(1595,87,204,0.7928,218),(1596,87,431,0.3103,287),(1597,87,222,0.7928,201),(1598,87,215,0.3103,283),(1599,87,224,0.3103,230),(1600,87,450,0.7826,200),(1601,87,211,0.7928,211),(1602,87,441,0.3103,233),(1603,88,4,0.7571,190),(1604,88,1,0.7675,273),(1605,88,7,0.7458,212),(1606,88,11,0.7675,262),(1607,88,29,0.7675,212),(1608,88,41,0.7571,293),(1609,88,35,0.7458,250),(1610,88,245,0.1549,268),(1611,88,274,0.7571,249),(1612,88,277,0.7458,223),(1613,88,46,0.7675,265),(1614,88,272,0.1549,194),(1615,88,238,0.2157,197),(1616,88,281,0.7675,182),(1617,88,38,0.7675,219),(1618,88,50,0.2157,208),(1619,88,32,0.7571,280),(1620,88,45,0.2683,195),(1621,88,283,0.2157,275),(1622,88,62,0.7458,211),(1623,88,20,0.1549,246),(1624,88,13,0.2157,260),(1625,88,269,0.7458,218),(1626,88,59,0.7571,212),(1627,89,64,0.7297,186),(1628,89,70,0.7059,192),(1629,89,79,0.7059,181),(1630,89,309,0.7297,226),(1631,89,91,0.7297,250),(1632,89,83,0.1304,228),(1633,89,314,0.2308,290),(1634,89,73,0.7297,186),(1635,89,97,0.7059,199),(1636,89,105,0.1837,217),(1637,89,114,0.7183,268),(1638,89,312,0.7183,227),(1639,89,332,0.7059,231),(1640,89,336,0.7297,252),(1641,89,90,0.7059,229),(1642,89,94,0.7183,286),(1643,89,338,0.1837,285),(1644,89,117,0.7059,224),(1645,89,101,0.7297,284),(1646,89,329,0.7183,290),(1647,89,76,0.7183,254),(1648,89,67,0.7183,299),(1649,90,119,0.1549,273),(1650,90,345,0.7675,247),(1651,90,353,0.7675,195),(1652,90,348,0.7571,252),(1653,90,356,0.7571,217),(1654,90,369,0.2683,225),(1655,90,359,0.7458,255),(1656,90,351,0.7458,260),(1657,90,146,0.1549,196),(1658,90,380,0.7675,217),(1659,90,362,0.7675,275),(1660,90,382,0.2157,266),(1661,90,390,0.7675,284),(1662,90,177,0.7571,279),(1663,90,365,0.7571,203),(1664,90,158,0.7571,199),(1665,90,163,0.1549,283),(1666,90,396,0.7458,238),(1667,90,376,0.7458,240),(1668,90,373,0.7571,267),(1669,90,161,0.7458,271),(1670,90,393,0.7571,216),(1671,90,370,0.7675,286),(1672,90,180,0.7458,202),(1673,90,401,0.2157,291),(1674,90,143,0.7458,266),(1675,90,398,0.7675,238),(1676,91,181,0.7675,289),(1677,91,191,0.1549,272),(1678,91,184,0.7571,270),(1679,91,420,0.7571,195),(1680,91,201,0.7675,184),(1681,91,207,0.7458,236),(1682,91,417,0.7675,287),(1683,91,209,0.1549,266),(1684,91,433,0.7675,248),(1685,91,204,0.7571,223),(1686,91,214,0.7458,267),(1687,91,441,0.2683,208),(1688,91,436,0.7571,255),(1689,91,219,0.7675,193),(1690,91,225,0.7458,218),(1691,91,222,0.7571,289),(1692,91,187,0.7458,212),(1693,91,423,0.7458,213),(1694,91,425,0.1549,206),(1695,92,4,0.8561,291),(1696,92,13,0.3443,258),(1697,92,7,0.8485,195),(1698,92,238,0.3443,220),(1699,92,236,0.863,297),(1700,92,12,0.2592,241),(1701,92,257,0.8561,213),(1702,92,251,0.8485,244),(1703,92,260,0.8485,237),(1704,92,42,0.3443,234),(1705,92,248,0.8561,237),(1706,92,277,0.8485,261),(1707,92,49,0.8561,256),(1708,92,38,0.863,274),(1709,92,62,0.8485,264),(1710,92,53,0.4118,277),(1711,92,284,0.8561,250),(1712,92,286,0.4118,198),(1713,92,267,0.3443,259),(1714,93,67,0.8844,240),(1715,93,70,0.8781,202),(1716,93,76,0.8844,191),(1717,93,90,0.8781,245),(1718,93,86,0.403,195),(1719,93,314,0.4737,257),(1720,93,312,0.8844,239),(1721,93,103,0.403,203),(1722,93,95,0.403,200),(1723,93,101,0.8901,287),(1724,93,328,0.403,257),(1725,93,322,0.8781,203),(1726,93,319,0.8844,261),(1727,93,114,0.8844,237),(1728,93,117,0.8781,182),(1729,93,79,0.8781,220),(1730,94,123,0.8257,209),(1731,94,356,0.8257,288),(1732,94,125,0.3578,230),(1733,94,359,0.8168,185),(1734,94,365,0.8257,256),(1735,94,149,0.2947,265),(1736,94,351,0.8168,216),(1737,94,375,0.2947,182),(1738,94,370,0.8337,282),(1739,94,402,0.8257,284),(1740,94,170,0.3578,234),(1741,94,405,0.8168,218),(1742,94,176,0.2947,288),(1743,94,386,0.8168,204),(1744,94,165,0.8337,294),(1745,94,383,0.8257,277),(1746,94,147,0.2179,283),(1747,94,368,0.8168,245),(1748,94,167,0.2947,274),(1749,94,395,0.3578,296),(1750,94,393,0.8257,195),(1751,95,184,0.8561,229),(1752,95,193,0.3443,216),(1753,95,423,0.8485,293),(1754,95,432,0.8485,235),(1755,95,215,0.4118,196),(1756,95,420,0.8561,293),(1757,95,187,0.8485,297),(1758,95,447,0.8561,267),(1759,95,440,0.4118,221),(1760,95,433,0.863,205),(1761,95,213,0.3443,261),(1762,95,450,0.8485,231),(1763,95,209,0.2592,269),(1764,95,429,0.8561,191),(1765,95,436,0.8561,288),(1766,96,70,0.7826,287),(1767,96,67,0.7928,231),(1768,96,77,0.2523,192),(1769,96,301,0.7928,285),(1770,96,312,0.7928,269),(1771,96,304,0.7826,271),(1772,96,314,0.3103,207),(1773,96,89,0.3103,240),(1774,96,86,0.2523,238),(1775,96,83,0.1837,251),(1776,96,309,0.802,198),(1777,96,332,0.7826,258),(1778,96,322,0.7826,236),(1779,96,329,0.7928,183),(1780,96,319,0.7928,225),(1781,96,339,0.7928,238),(1782,96,341,0.3103,294),(1783,96,117,0.7826,295),(1784,97,123,0.8561,251),(1785,97,131,0.8561,270),(1786,97,141,0.3443,256),(1787,97,126,0.8485,251),(1788,97,373,0.8561,267),(1789,97,368,0.8485,238),(1790,97,365,0.8561,290),(1791,97,151,0.8485,277),(1792,97,158,0.8561,291),(1793,97,134,0.8485,285),(1794,97,377,0.4118,209),(1795,97,161,0.8485,210),(1796,97,166,0.3443,201),(1797,97,393,0.8561,277),(1798,97,394,0.4118,201),(1799,97,402,0.8561,192),(1800,97,169,0.4118,258),(1801,97,405,0.8485,252),(1802,98,184,0.8257,266),(1803,98,187,0.8168,231),(1804,98,420,0.8257,259),(1805,98,193,0.2947,258),(1806,98,423,0.8168,295),(1807,98,212,0.2947,238),(1808,98,208,0.8337,205),(1809,98,201,0.8337,209),(1810,98,448,0.3578,209),(1811,98,222,0.8257,197),(1812,98,427,0.2947,258),(1813,98,223,0.3578,237),(1814,98,437,0.2947,190),(1815,98,202,0.2947,260);
/*!40000 ALTER TABLE `resultado` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `rol`
--

DROP TABLE IF EXISTS `rol`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `rol` (
  `idrol` int(11) NOT NULL AUTO_INCREMENT,
  `rol` varchar(45) NOT NULL,
  `descripcion` varchar(45) NOT NULL,
  PRIMARY KEY (`idrol`),
  UNIQUE KEY `rol_UNIQUE` (`rol`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `rol`
--

LOCK TABLES `rol` WRITE;
/*!40000 ALTER TABLE `rol` DISABLE KEYS */;
INSERT INTO `rol` VALUES (1,'Ingeniero','Administrador del Sistema'),(2,'Director','Director de la Escuela'),(3,'Docente','Docente de la Escuela'),(4,'Estudiante','Estudiante de la Escuela');
/*!40000 ALTER TABLE `rol` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `seccion`
--

DROP TABLE IF EXISTS `seccion`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `seccion` (
  `idseccion` int(11) NOT NULL AUTO_INCREMENT,
  `seccion` varchar(45) NOT NULL,
  `descripcion` varchar(45) NOT NULL,
  PRIMARY KEY (`idseccion`),
  UNIQUE KEY `seccion_UNIQUE` (`seccion`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `seccion`
--

LOCK TABLES `seccion` WRITE;
/*!40000 ALTER TABLE `seccion` DISABLE KEYS */;
INSERT INTO `seccion` VALUES (1,'A','Sección A'),(2,'B','Sección B'),(3,'C','Sección C'),(4,'Unica','Sección Única');
/*!40000 ALTER TABLE `seccion` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping events for database 'nimodo'
--

--
-- Dumping routines for database 'nimodo'
--
/*!50003 DROP PROCEDURE IF EXISTS `alternativaCreate` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `alternativaCreate`(IN `_descripcion` VARCHAR(45), IN `_success` BOOLEAN, IN `_idpregunta` INT)
BEGIN

INSERT INTO alternativa VALUES (null,_descripcion,_success,_idpregunta);

END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `alternativaRead` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `alternativaRead`()
BEGIN

SELECT * FROM alternativa;

END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `alternativaUpdate` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `alternativaUpdate`(IN `_descripcion` VARCHAR(45), IN `_success` BOOLEAN, IN `_idalternativa` INT)
BEGIN

UPDATE  alternativa SET  descripcion = _descripcion, success = _success WHERE  idalternativa = _idalternativa;

END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `aparienciaRead` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `aparienciaRead`(IN `_dni` VARCHAR(8))
BEGIN

/*SELECT * FROM apariencia;*/

select l.nombre,l.codigo,l.color from persona per join apariencia a  on per.dni = a.dni join lookandfeel l on a.idlookandfeel = l.idlookandfeel and per.dni = _dni;

END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `aparienciaUpdate` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `aparienciaUpdate`(IN `_dni` VARCHAR(8), IN `_look` VARCHAR(20))
BEGIN

UPDATE  apariencia set idlookandfeel = (select idlookandfeel from lookandfeel where nombre = _look) where dni = _dni;

END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `areaCreate` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `areaCreate`(IN `_area` VARCHAR(45), IN `_descripcion` VARCHAR(45))
BEGIN

INSERT INTO area VALUES (null,_area,_descripcion);

END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `areaDelete` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `areaDelete`(IN `_id_area` INT)
BEGIN

DELETE FROM area WHERE idarea = _id_area;

END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `areaRead` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `areaRead`()
BEGIN


SELECT * FROM area;


END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `areaUpdate` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `areaUpdate`(IN `_area` VARCHAR(45), IN `_descripcion` VARCHAR(45), IN `_id_area` INT)
BEGIN

UPDATE  area SET  area = _area, descripcion = _descripcion WHERE  idarea = _id_area;

END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `audioCreate` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `audioCreate`(IN `_audio` VARCHAR(100), IN `_idpregunta` INT)
BEGIN

INSERT INTO audio VALUES (null,_audio,_idpregunta);

END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `audioRead` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `audioRead`()
BEGIN

SELECT * FROM audio;

END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `aulaCreate` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `aulaCreate`(IN `_idGrado` INT, IN `_idSeccion` INT)
BEGIN

INSERT INTO aula VALUES (null,_idGrado,_idSeccion);

END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `aulaDelete` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `aulaDelete`(IN `_id_aula` INT)
BEGIN

DELETE FROM aula WHERE idaula = _id_aula;

END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `aulaGradoRead` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = '' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `aulaGradoRead`()
BEGIN

select distinct g.grado from aula a join grado g on a.idgrado = g.idgrado join seccion s on a.idseccion = s.idseccion order by g.idgrado;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `aulaRead` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `aulaRead`()
BEGIN

SELECT * FROM aula;

END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `aulaSeccionRead` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `aulaSeccionRead`(IN `_grado` VARCHAR(45))
BEGIN

select s.seccion from aula a join grado g on a.idgrado = g.idgrado join seccion s on a.idseccion = s.idseccion and g.grado = _grado order by s.idseccion;

END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `aulaUpdate` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `aulaUpdate`(IN `_id_grado` INT, IN `_id_seccion` INT, IN `_id_aula` INT)
BEGIN

UPDATE  aula SET  idgrado = _id_grado, idseccion = _id_seccion WHERE  idaula = _id_aula;

END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `calificacionCreate` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `calificacionCreate`(IN `_calificacion` INT, IN `_idevaluacion_tradicional` INT)
BEGIN

INSERT INTO calificacion VALUES (null,_calificacion,_idevaluacion_tradicional);

END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `capacidadCreate` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `capacidadCreate`(IN `_capacidad` VARCHAR(200), IN `_descripcion` VARCHAR(200))
BEGIN

INSERT INTO capacidad VALUES (null,_capacidad,_descripcion);

END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `capacidadDelete` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `capacidadDelete`(IN `_id_capacidad` INT)
BEGIN

DELETE FROM capacidad WHERE idcapacidad = _id_capacidad;

END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `capacidadRead` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `capacidadRead`()
BEGIN

	select * from capacidad;

END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `capacidadUpdate` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `capacidadUpdate`(IN `_capacidad` VARCHAR(200), IN `_descripcion` VARCHAR(200), IN `_id_capacidad` INT)
BEGIN

UPDATE  capacidad SET  capacidad = _capacidad, descripcion = _descripcion WHERE  idcapacidad = _id_capacidad;

END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `competenciaCreate` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `competenciaCreate`(IN `_competencia` VARCHAR(200), IN `_descripcion` VARCHAR(200))
BEGIN

/*INSERT INTO competencia VALUES (null,_competencia,_descripcion,false,false,false,false);*/

INSERT INTO competencia VALUES (null,_competencia,_descripcion);

END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `competenciaDelete` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `competenciaDelete`(IN `_id_competencia` INT)
BEGIN

DELETE FROM competencia WHERE idcompetencia = _id_competencia;

END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `competenciaRead` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `competenciaRead`()
BEGIN

	select * from competencia;

END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `competenciaUpdate` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `competenciaUpdate`(IN `_competencia` VARCHAR(200), IN `_descripcion` VARCHAR(200), IN `_id_competencia` INT)
BEGIN

UPDATE  competencia SET  competencia = _competencia, descripcion = _descripcion WHERE  idcompetencia = _id_competencia;

END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `desempeñoCreate` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `desempeñoCreate`(IN `_desempenio` VARCHAR(200), IN `_descripcion` VARCHAR(500), IN `_idAulaDocente` INT)
BEGIN

INSERT INTO desempenio VALUES (null,_desempenio,_descripcion,_idAulaDocente);

END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `desempeñoDelete` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `desempeñoDelete`(IN `_id_desempenio` INT)
BEGIN

DELETE FROM desempenio WHERE iddesempenio = _id_desempenio;

END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `desempeñoRead` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `desempeñoRead`()
BEGIN

	select * from desempenio order by iddesempenio;

END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `desempeñoUpdate` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `desempeñoUpdate`(IN `_desempenio` VARCHAR(200), IN `_descripcion` VARCHAR(500), IN `_id_desempenio` INT)
BEGIN

UPDATE  desempenio SET  desempenio = _desempenio, descripcion = _descripcion WHERE  iddesempenio = _id_desempenio;

END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `docenteAulaCreate` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `docenteAulaCreate`(IN `_fecha` VARCHAR(45), IN `_idperfil` INT, IN `_idaula` INT)
BEGIN

INSERT INTO docente_aula VALUES (null,_fecha,_idperfil,_idaula);

END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `docenteAulaDelete` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `docenteAulaDelete`(IN `_iddocente_aula` INT)
BEGIN

/*get current year*/

DECLARE _fecha VARCHAR(4);

set _fecha = (select year(curdate()));

/*query*/

DELETE FROM docente_aula WHERE iddocente_aula = _iddocente_aula and (SELECT EXTRACT(YEAR FROM (SELECT STR_TO_DATE(fecha, '%d/%m/%Y')))) = _fecha;

END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `docenteConAulaRead` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `docenteConAulaRead`()
BEGIN

select per.dni,per.nombres,per.apellidos, m.grado,m.seccion,m.iddocente_aula from persona per join perfil perf on per.dni = perf.dni join rol r on perf.idrol = r.idrol and r.rol = 'Docente' join 

(select m.iddocente_aula,m.idperfil,g.grado,s.seccion from docente_aula m join aula a on m.idaula = a.idaula join grado g on a.idgrado = g.idgrado join seccion s on a.idseccion = s.idseccion and (SELECT EXTRACT(YEAR FROM (SELECT STR_TO_DATE(m.fecha, '%d/%m/%Y')))) = (select year(curdate()))) m on perf.idperfil = m.idperfil;

END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `docenteRead` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `docenteRead`()
BEGIN

select per.dni, per.nombres, per.apellidos, per.user, per.password from persona per join perfil perf on per.dni = perf.dni join rol r on perf.idrol = r.idrol and r.rol = 'Docente';

END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `docenteSinAulaRead` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `docenteSinAulaRead`()
BEGIN

select per.dni,per.nombres,per.apellidos,perf.idperfil from persona per join perfil perf on per.dni = perf.dni join rol r on perf.idrol = r.idrol and r.rol = 'Docente' and perf.idperfil not in 

(select m.idperfil from docente_aula m join aula a on m.idaula = a.idaula join grado g on a.idgrado = g.idgrado join seccion s on a.idseccion = s.idseccion and (SELECT EXTRACT(YEAR FROM (SELECT STR_TO_DATE(m.fecha, '%d/%m/%Y')))) = (select year(curdate())));

END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `estiloCreate` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `estiloCreate`(IN `_estilo` VARCHAR(45), IN `_descripcion` VARCHAR(45))
BEGIN

INSERT INTO estilo VALUES (null,_estilo,_descripcion);

END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `estiloDelete` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `estiloDelete`(IN `_id_estilo` INT)
BEGIN

DELETE FROM estilo WHERE idestilo = _id_estilo;

END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `estiloRead` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `estiloRead`()
BEGIN

SELECT * FROM estilo;

END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `estiloUpdate` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `estiloUpdate`(IN `_estilo` VARCHAR(45), IN `_descripcion` VARCHAR(45), IN `_id_estilo` INT)
BEGIN

UPDATE  estilo SET  estilo = _estilo, descripcion = _descripcion WHERE  idestilo = _id_estilo;

END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `estudianteConMatriculaRead` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_unicode_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = '' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `estudianteConMatriculaRead`()
BEGIN

select per.dni,per.nombres,per.apellidos, m.grado,m.seccion,m.idestudiante_matricula,m.idaula from persona per join perfil perf on per.dni = perf.dni join rol r on perf.idrol = r.idrol and r.rol = 'Estudiante' join 

(select m.idestudiante_matricula,m.idperfil,g.grado,s.seccion,a.idaula from estudiante_matricula m join aula a on m.idaula = a.idaula join grado g on a.idgrado = g.idgrado join seccion s on a.idseccion = s.idseccion and (SELECT EXTRACT(YEAR FROM (SELECT STR_TO_DATE(m.fecha, '%d/%m/%Y')))) = (select year(curdate()))) m on perf.idperfil = m.idperfil;

END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `estudianteMatriculaCreate` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `estudianteMatriculaCreate`(IN `_fecha` VARCHAR(45), IN `_idperfil` INT, IN `_idaula` INT)
BEGIN

INSERT INTO estudiante_matricula VALUES (null,_fecha,_idperfil,_idaula);

END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `estudianteMatriculaDelete` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `estudianteMatriculaDelete`(IN `_idestudiante_matricula` INT)
BEGIN

/*get current year*/

DECLARE _fecha VARCHAR(4);

set _fecha = (select year(curdate()));

/*query*/

DELETE FROM estudiante_matricula WHERE idestudiante_matricula = _idestudiante_matricula and (SELECT EXTRACT(YEAR FROM (SELECT STR_TO_DATE(fecha, '%d/%m/%Y')))) = _fecha;

END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `estudianteRead` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `estudianteRead`()
BEGIN

select per.dni, per.nombres, per.apellidos, per.user, per.password from persona per join perfil perf on per.dni = perf.dni join rol r on perf.idrol = r.idrol and r.rol = 'Estudiante';

END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `estudianteSinMatriculaRead` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `estudianteSinMatriculaRead`()
BEGIN

select per.dni,per.nombres,per.apellidos,perf.idperfil from persona per join perfil perf on per.dni = perf.dni join rol r on perf.idrol = r.idrol and r.rol = 'Estudiante' and perf.idperfil not in 

(select m.idperfil from estudiante_matricula m join aula a on m.idaula = a.idaula join grado g on a.idgrado = g.idgrado join seccion s on a.idseccion = s.idseccion and (SELECT EXTRACT(YEAR FROM (SELECT STR_TO_DATE(m.fecha, '%d/%m/%Y')))) = (select year(curdate())));

END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `evaluacionAdaptativaCreate` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `evaluacionAdaptativaCreate`(IN `_idcompetencia` INT, IN `_idperiodo` INT, IN `_idarea` INT, IN `_idestudiante_matricula` INT, IN `_iddocente_aula` INT, OUT `_idevaluacion_adaptativa` INT(11))
BEGIN

INSERT INTO evaluacion_adaptativa VALUES (null,(SELECT DATE_FORMAT((select curdate()), "%d/%m/%Y")),_idcompetencia,_idperiodo,_idarea,_idestudiante_matricula,_iddocente_aula);

SET _idevaluacion_adaptativa = LAST_INSERT_ID();

END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `evaluacionAdaptativaDelete` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `evaluacionAdaptativaDelete`(IN `_idevaluacion_adaptativa` INT)
BEGIN

DELETE FROM evaluacion_adaptativa WHERE idevaluacion_adaptativa = _idevaluacion_adaptativa;

END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `evaluacionAdaptativaPreguntaAlternativaRead` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `evaluacionAdaptativaPreguntaAlternativaRead`(IN `_periodo` VARCHAR(45), IN `_iddocente_aula` INT, IN `_competencia` VARCHAR(45))
BEGIN

select pre.idpregunta,pre.descripcion,pre.apriori,pre.descuido,pre.adivinanza,pre.idnivel,pre.idestilo,pre.idmatriz,pre.idperiodo,pre.iddocente_aula,alt.idalternativa,alt.descripcion,alt.success from alternativa alt join pregunta pre on alt.idpregunta = pre.idpregunta  join estilo e on pre.idestilo = e.idestilo join periodo p on pre.idperiodo = p.idperiodo join docente_aula da on pre.iddocente_aula = da.iddocente_aula join matriz m on pre.idmatriz = m.idmatriz join desempenio d on m.iddesempenio = d.iddesempenio join capacidad cap on m.idcapacidad = cap.idcapacidad join competencia comp on m.idcompetencia = comp.idcompetencia join area a on m.idarea = a.idarea and p.periodo = _periodo and (SELECT EXTRACT(YEAR FROM (SELECT STR_TO_DATE(p.fecha_inicio, '%d/%m/%Y')))) = (select year(curdate())) and da.iddocente_aula = _iddocente_aula and comp.competencia = _competencia order by pre.idpregunta,alt.idalternativa asc;

END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `evaluacionAdaptativaPreguntaAreaRead` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `evaluacionAdaptativaPreguntaAreaRead`(IN `_idestudiante_matricula` INT, IN `_iddocente_aula` INT, IN `_area` VARCHAR(45), IN `_periodo` VARCHAR(45))
BEGIN

select ea.idevaluacion_adaptativa,ea.fecha,r.idalternativa,r.conocimiento_aposteriori,r.tiempo from evaluacion_adaptativa ea join resultado r on ea.idevaluacion_adaptativa = r.idevaluacion_adaptativa join area a on ea.idarea = a.idarea join periodo p on ea.idperiodo = p.idperiodo and ea.idestudiante_matricula = _idestudiante_matricula and ea.iddocente_aula = _iddocente_aula and a.area = _area and p.periodo = _periodo;

END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `evaluacionAdaptativaPreguntaRead` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `evaluacionAdaptativaPreguntaRead`(IN `_periodo` VARCHAR(45), IN `_iddocente_aula` INT, IN `_competencia` VARCHAR(45))
BEGIN

select pre.idpregunta,pre.descripcion,pre.descuido,pre.adivinanza,pre.idnivel,pre.idestilo,pre.idmatriz,pre.idperiodo,pre.iddocente_aula from pregunta pre join estilo e on pre.idestilo = e.idestilo join periodo p on pre.idperiodo = p.idperiodo join docente_aula da on pre.iddocente_aula = da.iddocente_aula join matriz m on pre.idmatriz = m.idmatriz join desempenio d on m.iddesempenio = d.iddesempenio join capacidad cap on m.idcapacidad = cap.idcapacidad join competencia comp on m.idcompetencia = comp.idcompetencia join area a on m.idarea = a.idarea and p.periodo = _periodo and (SELECT EXTRACT(YEAR FROM (SELECT STR_TO_DATE(p.fecha_inicio, '%d/%m/%Y')))) = (select year(curdate())) and da.iddocente_aula = _iddocente_aula and comp.competencia = _competencia order by pre.descuido asc;

/*select * from pregunta pre join periodo p on pre.idperiodo = p.idperiodo join matriz m on pre.idmatriz = m.idmatriz join competencia comp on m.idcompetencia = comp.idcompetencia join (select da.iddocente_aula,per.nombres from persona per join perfil perf on per.dni = perf.dni join docente_aula da on perf.idperfil = da.idperfil)da on m.iddocente_aula = da.iddocente_aula and (SELECT EXTRACT(YEAR FROM (SELECT STR_TO_DATE(p.fecha_inicio, '%d/%m/%Y')))) = (select year(curdate())) and da.iddocente_aula = '4' and comp.competencia = 'Matematica-Competencia 2' and p.periodo = 'Primer Bimestre';*/

END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `evaluacionAdaptativaRead` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `evaluacionAdaptativaRead`(IN `_idestudiante_matricula` INT, IN `_iddocente_aula` INT, IN `_area` VARCHAR(45), IN `_periodo` VARCHAR(45))
BEGIN

/*select * from evaluacion_adaptativa;*/

select ea.idevaluacion_adaptativa,a.area,c.competencia,p.periodo,ea.fecha from evaluacion_adaptativa ea join area a join competencia c join periodo p on ea.idarea = a.idarea and ea.idcompetencia = c.idcompetencia and ea.idperiodo = p.idperiodo and ea.idestudiante_matricula = _idestudiante_matricula and ea.iddocente_aula = _iddocente_aula and a.area = _area and p.periodo = _periodo;

END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `evaluacionTradicionalCalificacionEstudianteRead` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `evaluacionTradicionalCalificacionEstudianteRead`(IN `_dni` VARCHAR(8), IN `_periodo` VARCHAR(45), IN `_area` VARCHAR(45), IN `_fecha` VARCHAR(45))
BEGIN

select et.idevaluacion_tradicional,c.calificacion  from persona per join perfil perf on per.dni = perf.dni join docente_aula ad on perf.idperfil = ad.idperfil join (select * from evaluacion_tradicional where (SELECT EXTRACT(YEAR FROM (SELECT STR_TO_DATE(fecha, '%d/%m/%Y')))) = (select year(curdate()))) et on ad.iddocente_aula = et.iddocente_aula join periodo p on et.idperiodo = p.idperiodo join area a on et.idarea = a.idarea join calificacion c on et.idevaluacion_tradicional = c.idevaluacion_tradicional and per.dni = _dni  and p.periodo = _periodo  and a.area = _area and et.fecha = _fecha;

END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `evaluacionTradicionalCreate` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `evaluacionTradicionalCreate`(IN `_fecha` VARCHAR(45), IN `_idperiodo` INT, IN `_idarea` INT, IN `_idestudiante_matricula` INT, IN `_iddocente_aula` INT, OUT `_idevaluacion_tradicional` INT(11))
BEGIN

INSERT INTO evaluacion_tradicional VALUES (null,_fecha,_idperiodo,_idarea,_idestudiante_matricula,_iddocente_aula);

SET _idevaluacion_tradicional = LAST_INSERT_ID();

END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `evaluacionTradicionalDelete` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `evaluacionTradicionalDelete`(IN `_idevaluacion_tradicional` INT)
BEGIN

DELETE FROM evaluacion_tradicional where idevaluacion_tradicional = _idevaluacion_tradicional;

END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `evaluacionTradicionalEstudianteRead` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `evaluacionTradicionalEstudianteRead`(IN `_dni` VARCHAR(8), IN `_periodo` VARCHAR(45), IN `_area` VARCHAR(45), IN `_fecha` VARCHAR(45))
BEGIN

/*select et.idevaluacion_tradicional,et.fecha,et.idperiodo,et.idestudiante_matricula,et.iddocente_aula  from persona per join perfil perf on per.dni = perf.dni join docente_aula ad on perf.idperfil = ad.idperfil join (select * from evaluacion_tradicional where (SELECT EXTRACT(YEAR FROM (SELECT STR_TO_DATE(fecha, '%d/%m/%Y')))) = (select year(curdate()))) et on ad.iddocente_aula = et.iddocente_aula join periodo p on et.idperiodo = p.idperiodo join area a on et.idarea = a.idarea and per.dni = _dni  and p.periodo = _periodo  and a.area = _area and et.fecha = _fecha;*/

select per.dni,per.nombres,per.apellidos,et.idevaluacion_tradicional,et.idarea,et.idperiodo from persona per join perfil perf on per.dni = perf.dni join estudiante_matricula em on perf.idperfil = em.idperfil join (

select et.idevaluacion_tradicional,idestudiante_matricula,a.idarea,p.idperiodo  from persona per join perfil perf on per.dni = perf.dni join docente_aula ad on perf.idperfil = ad.idperfil join (select * from evaluacion_tradicional where (SELECT EXTRACT(YEAR FROM (SELECT STR_TO_DATE(fecha, '%d/%m/%Y')))) = (select year(curdate()))) et on ad.iddocente_aula = et.iddocente_aula join periodo p on et.idperiodo = p.idperiodo join area a on et.idarea = a.idarea and per.dni = _dni  and p.periodo = _periodo and a.area = _area and et.fecha = _fecha) et on em.idestudiante_matricula = et.idestudiante_matricula;

END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `evaluacionTradicionalFechaRead` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `evaluacionTradicionalFechaRead`(IN `_dni` VARCHAR(8), IN `_periodo` VARCHAR(45), IN `_area` VARCHAR(45))
BEGIN

select distinct et.fecha  from persona per join perfil perf on per.dni = perf.dni join docente_aula ad on perf.idperfil = ad.idperfil join (select * from evaluacion_tradicional where (SELECT EXTRACT(YEAR FROM (SELECT STR_TO_DATE(fecha, '%d/%m/%Y')))) = (select year(curdate()))) et on ad.iddocente_aula = et.iddocente_aula join periodo p on et.idperiodo = p.idperiodo join area a on et.idarea = a.idarea and per.dni = _dni  and p.periodo = _periodo  and a.area = _area;

END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `gradoCreate` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `gradoCreate`(IN `_grado` VARCHAR(45), IN `_descripcion` VARCHAR(45))
BEGIN

INSERT INTO grado VALUES (null,_grado,_descripcion);

END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `gradoDelete` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `gradoDelete`(IN `_id_grado` VARCHAR(45))
BEGIN

DELETE FROM grado WHERE idgrado = _id_grado;

END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `gradoRead` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `gradoRead`()
BEGIN

SELECT * FROM grado;

END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `gradoUpdate` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `gradoUpdate`(IN `_grado` VARCHAR(45), IN `_descripcion` VARCHAR(45), IN `_id_grado` VARCHAR(45))
BEGIN

UPDATE  grado SET  grado = _grado, descripcion = _descripcion WHERE  idgrado = _id_grado;

END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `imagenCreate` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `imagenCreate`(IN `_imagen` VARCHAR(100), IN `_idpregunta` INT)
BEGIN

INSERT INTO imagen VALUES (null,_imagen,_idpregunta);

END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `imagenRead` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `imagenRead`()
BEGIN

SELECT * FROM imagen;

END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `init` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = '' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `init`()
BEGIN
/*insertamos lookandfeel
INSERT INTO `lookandfeel` (`idlookandfeel`, `nombre`, `codigo`, `color`) VALUES (NULL, 'Metal', 'javax.swing.plaf.metal.MetalLookAndFeel', '#C9EAF8'), (NULL, 'Windows', 'com.sun.java.swing.plaf.windows.WindowsLookAndFeel', '#B3F8CE'), (NULL, 'Windows Classic', 'com.sun.java.swing.plaf.windows.WindowsClassicLookAndFeel', '#E8D4FD');
/*insertamos personas por defecto
INSERT INTO `persona` (`dni`, `nombres`, `apellidos`, `user`, `password`) VALUES ('73475373', 'Jhancarlo F.', 'Silva Ochoa', 'jsilva', '1003920102'), ('12345678', 'César Dalmiro', 'Flores Gutierrez', 'dflores', '1122334455');
/*insertamos apariencia por persona
INSERT INTO `apariencia` (`idapariencia`, `dni`, `idlookandfeel`) VALUES (NULL, '73475373', '2'), (NULL, '12345678', '2');
/*insertamos roles
INSERT INTO `rol` (`idrol`, `rol`, `descripcion`) VALUES (NULL, 'Ingeniero', 'Administrador del Sistema'), (NULL, 'Director', 'Director de la Escuela'), (NULL, 'Docente', 'Docente de la Escuela'), (NULL, 'Estudiante', 'Estudiante de la Escuela');
/*insertamos perfiles
INSERT INTO `perfil` (`idperfil`, `dni`, `idrol`) VALUES (NULL, '73475373', '1'), (NULL, '12345678', '2'), (NULL, '12345678', '3');
*/
UPDATE `docente_aula` SET `fecha`= '11/03/2020';
UPDATE `estudiante_matricula` SET `fecha`= '11/03/2020';
UPDATE `evaluacion_adaptativa` SET `fecha`= '07/06/2020' WHERE `idcompetencia` = 1;
UPDATE `evaluacion_adaptativa` SET `fecha`= '14/06/2020' WHERE `idcompetencia` = 2;
UPDATE `evaluacion_adaptativa` SET `fecha`= '21/06/2020' WHERE `idcompetencia` = 3;
UPDATE `evaluacion_adaptativa` SET `fecha`= '28/06/2020' WHERE `idcompetencia` = 4;
UPDATE `evaluacion_tradicional` SET `fecha`= '31/05/2020';
UPDATE `periodo` SET `fecha_inicio`= '11/03/2020',`fecha_fin`= '03/05/2020' WHERE `idperiodo` = 1;
UPDATE `periodo` SET `fecha_inicio`= '06/05/2020',`fecha_fin`= '26/07/2020' WHERE `idperiodo` = 2;
UPDATE `periodo` SET `fecha_inicio`= '12/08/2020',`fecha_fin`= '18/10/2020' WHERE `idperiodo` = 3;
UPDATE `periodo` SET `fecha_inicio`= '21/10/2020',`fecha_fin`= '20/12/2020' WHERE `idperiodo` = 4;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `lookandfeelRead` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `lookandfeelRead`()
BEGIN

SELECT * FROM lookandfeel;

END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `matrizAreaRead` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `matrizAreaRead`(IN `_idDocenteAula` INT)
BEGIN

select distinct a.idarea,a.area,a.descripcion from area a join matriz m on a.idarea = m.idarea join desempenio d on m.iddesempenio = d.iddesempenio and d.iddocente_aula = _idDocenteAula;

END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `matrizCapacidadCompetenciaRead` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `matrizCapacidadCompetenciaRead`(IN `_area` VARCHAR(45), IN `_competencia` VARCHAR(45), IN `_iddocente_aula` INT)
BEGIN

select distinct cap.capacidad,cap.idcapacidad,cap.descripcion from matriz m join area a on m.idarea = a.idarea join competencia comp on m.idcompetencia = comp.idcompetencia join capacidad cap on m.idcapacidad = cap.idcapacidad and a.area = _area and comp.competencia = _competencia and m.iddocente_aula = _iddocente_aula;

END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `matrizCompetenciaAreaDocenteRead` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `matrizCompetenciaAreaDocenteRead`(IN `_area` VARCHAR(45), IN `_iddocente_aula` INT)
BEGIN

/*select distinct comp.competencia,comp.idcompetencia,m.primer_bimestre,m.segundo_bimestre,m.tercer_bimestre,m.cuarto_bimestre from matriz m join area a on m.idarea = a.idarea join competencia comp on m.idcompetencia = comp.idcompetencia and a.area = _area;*/

select distinct comp.competencia,comp.idcompetencia,comp.descripcion,a.idarea from matriz m join competencia comp on m.idcompetencia = comp.idcompetencia join area a on m.idarea = a.idarea and a.area = _area and m.iddocente_aula = _iddocente_aula;



END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `matrizCompetenciaBimestreRead` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `matrizCompetenciaBimestreRead`(IN `_idcompetencia` INT, IN `_iddocente_aula` INT)
BEGIN

select distinct idcompetencia,primer_bimestre,segundo_bimestre,tercer_bimestre,cuarto_bimestre from matriz where idcompetencia = _idcompetencia and iddocente_aula = _iddocente_aula;

END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `matrizCompetenciaBimestreUpdate` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `matrizCompetenciaBimestreUpdate`(IN `_idcompetencia` INT, IN `_iddocente_aula` INT, IN `_primer_bimestre` BOOLEAN, IN `_segundo_bimestre` BOOLEAN, IN `_tercer_bimestre` BOOLEAN, IN `_cuarto_bimestre` BOOLEAN)
BEGIN

UPDATE  matriz SET  primer_bimestre = _primer_bimestre, segundo_bimestre = _segundo_bimestre, tercer_bimestre = _tercer_bimestre, cuarto_bimestre = _cuarto_bimestre WHERE  idcompetencia = _idcompetencia and iddocente_aula = _iddocente_aula;

END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `matrizCompetenciaTiempoRead` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `matrizCompetenciaTiempoRead`(IN `_idcompetencia` INT, IN `_iddocente_aula` INT)
BEGIN

select distinct idcompetencia,tiempo from matriz where idcompetencia = _idcompetencia and iddocente_aula = _iddocente_aula;

END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `matrizCompetenciaTiempoUpdate` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `matrizCompetenciaTiempoUpdate`(IN `_iddocente_aula` INT, IN `_tiempo` INT)
BEGIN

UPDATE  matriz SET  tiempo = _tiempo WHERE  iddocente_aula = _iddocente_aula;

END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `matrizCreate` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `matrizCreate`(IN `_idarea` INT, IN `_idcompetencia` INT, IN `_idcapacidad` INT, IN `_iddesempenio` INT, IN `_idDocenteAula` INT)
BEGIN

    INSERT INTO matriz VALUES (null,_idarea,_idcompetencia,_idcapacidad,_iddesempenio,_idDocenteAula,false,false,false,false,1800);

END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `matrizDelete` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `matrizDelete`(IN `_idmatriz` INT)
BEGIN	

	DELETE FROM matriz WHERE idmatriz = _idmatriz;

END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `matrizDesempeñoCapacidadRead` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `matrizDesempeñoCapacidadRead`(IN `_area` VARCHAR(45), IN `_competencia` VARCHAR(45), IN `_capacidad` VARCHAR(45), IN `_iddocente_aula` INT)
BEGIN

select distinct d.desempenio,d.iddesempenio,d.descripcion from matriz m join area a on m.idarea = a.idarea join competencia comp on m.idcompetencia = comp.idcompetencia join capacidad cap on m.idcapacidad = cap.idcapacidad join desempenio d on m.iddesempenio = d.iddesempenio and a.area = _area and comp.competencia = _competencia and cap.capacidad = _capacidad and m.iddocente_aula = _iddocente_aula;

END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `matrizRead` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `matrizRead`()
BEGIN

	select * from matriz;

END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `matrizUpdate` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `matrizUpdate`(IN `_idarea` INT, IN `_idcompetencia` INT, `_idcapacidad` INT, IN `_iddesempenio` INT, IN `_iddocente_aula` INT, IN `_idmatriz` INT)
BEGIN	   

	UPDATE  matriz SET  idarea = _idarea, idcompetencia = _idcompetencia, idcapacidad = _idcapacidad, iddesempenio = _iddesempenio, iddocente_aula = _iddocente_aula  WHERE  idmatriz = _idmatriz;

END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `nivelCreate` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `nivelCreate`(IN `_nivel` VARCHAR(45), IN `_descripcion` VARCHAR(45))
BEGIN

INSERT INTO nivel VALUES (null,_nivel,_descripcion);

END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `nivelDelete` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `nivelDelete`(IN `_id_nivel` INT)
BEGIN

DELETE FROM nivel WHERE idnivel = _id_nivel;

END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `nivelRead` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `nivelRead`()
BEGIN

SELECT * FROM nivel;

END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `nivelUpdate` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `nivelUpdate`(IN `_nivel` VARCHAR(45), IN `_descripcion` VARCHAR(45), IN `_id_nivel` INT)
BEGIN

UPDATE  nivel SET  nivel = _nivel, descripcion = _descripcion WHERE  idnivel = _id_nivel;

END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `periodoCreate` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `periodoCreate`(IN `_periodo` VARCHAR(45), IN `_fecha_inicio` VARCHAR(45), IN `_fecha_fin` VARCHAR(45))
BEGIN

INSERT INTO periodo VALUES (null,_periodo,_fecha_inicio,_fecha_fin);

END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `periodoDelete` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `periodoDelete`(IN `_id_periodo` INT)
BEGIN

DELETE FROM periodo WHERE idperiodo = _id_periodo;

END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `periodoRead` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `periodoRead`()
BEGIN

SELECT * FROM periodo WHERE (SELECT EXTRACT(YEAR FROM (SELECT STR_TO_DATE(fecha_inicio, '%d/%m/%Y')))) = (select year(curdate())) order by idperiodo ASC;

END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `periodoUpdate` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `periodoUpdate`(IN `_periodo` VARCHAR(45), IN `_fecha_inicio` VARCHAR(45), IN `_fecha_fin` VARCHAR(45), IN `_id_periodo` INT)
BEGIN

UPDATE  periodo SET  periodo = _periodo, fecha_inicio = _fecha_inicio, fecha_fin = _fecha_fin WHERE  idperiodo = _id_periodo;

END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `personaCreate` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `personaCreate`(IN `_dni` VARCHAR(8), IN `_nombres` VARCHAR(45), IN `_apellidos` VARCHAR(45), IN `_user` VARCHAR(45), IN `_password` VARCHAR(45), IN `_rol` VARCHAR(45))
BEGIN

	IF _rol='Docente' THEN

	   INSERT INTO persona VALUES ( _dni,_nombres,_apellidos,_user,_password);

       INSERT INTO perfil VALUES (null,_dni,(select idrol from rol where rol = _rol));

       INSERT INTO apariencia VALUES (null,_dni,(select idlookandfeel from lookandfeel where nombre = 'Metal'));

	END IF;

    IF _rol='Estudiante' THEN

	   INSERT INTO persona VALUES ( _dni,_nombres,_apellidos,_user,_password);

       INSERT INTO perfil VALUES (null,_dni,(select idrol from rol where rol = _rol));

	END IF;

END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `personaDelete` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `personaDelete`(IN `_dni` VARCHAR(8))
BEGIN

DELETE FROM persona WHERE dni = _dni;

END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `personaUpdate` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `personaUpdate`(IN `_dni` VARCHAR(8), IN `_nombres` VARCHAR(45), IN `_apellidos` VARCHAR(45), IN `_user` VARCHAR(45), IN `_password` VARCHAR(45), IN `_id_dni` VARCHAR(8))
BEGIN

UPDATE  persona SET  dni = _dni, nombres = _nombres, apellidos = _apellidos, user = _user, password = _password WHERE  dni = _id_dni;

END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `preguntaCreate` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = '' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `preguntaCreate`(IN `_descripcion` VARCHAR(250), IN `_descuido` DOUBLE, IN `_adivinanza` DOUBLE, IN `_idnivel` INT, IN `_idestilo` INT, IN `_idmatriz` INT, IN `_idperiodo` INT, IN `_iddocente_aula` INT, OUT `_idpregunta` INT(11))
BEGIN

INSERT INTO pregunta VALUES (null,_descripcion,_descuido,_adivinanza,_idnivel,_idestilo,_idmatriz,_idperiodo,_iddocente_aula);

SET _idpregunta = LAST_INSERT_ID();

END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `preguntaDelete` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `preguntaDelete`(IN `_idpregunta` INT)
BEGIN

DELETE FROM pregunta WHERE idpregunta = _idpregunta;

END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `preguntaEstiloRead` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `preguntaEstiloRead`(IN `_estilo` VARCHAR(45), IN `_idDocenteAula` INT)
BEGIN

IF _estilo='Auditiva'THEN

	/*SELECT * FROM pregunta pre join estilo es on pre.idestilo = es.idestilo and es.estilo = _estilo;*/

	SELECT * FROM pregunta pre join periodo p on pre.idperiodo = p.idperiodo join estilo es on pre.idestilo = es.idestilo join docente_aula da on pre.iddocente_aula = da.iddocente_aula and (SELECT EXTRACT(YEAR FROM (SELECT STR_TO_DATE(p.fecha_inicio, '%d/%m/%Y')))) = (select year(curdate())) and es.estilo = _estilo and da.iddocente_aula = _idDocenteAula order by pre.idpregunta asc;  



END IF;

IF _estilo='Visual'THEN

	/*SELECT * FROM pregunta pre join estilo es on pre.idestilo = es.idestilo and es.estilo = _estilo;*/

	SELECT * FROM pregunta pre join periodo p on pre.idperiodo = p.idperiodo join estilo es on pre.idestilo = es.idestilo join docente_aula da on pre.iddocente_aula = da.iddocente_aula and (SELECT EXTRACT(YEAR FROM (SELECT STR_TO_DATE(p.fecha_inicio, '%d/%m/%Y')))) = (select year(curdate())) and es.estilo = _estilo and da.iddocente_aula = _idDocenteAula order by pre.idpregunta asc;  



END IF;

END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `preguntaRead` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `preguntaRead`()
BEGIN

select * from pregunta;

END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `preguntaReadForCompetencia` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = '' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `preguntaReadForCompetencia`()
BEGIN
select p.idpregunta,p.descripcion,e.estilo,n.nivel,m.competencia,m.capacidad,m.desempenio from pregunta p join (select m.idmatriz,c.competencia,cap.capacidad,d.desempenio from matriz m join competencia c on m.idcompetencia = c.idcompetencia join capacidad cap on m.idcapacidad = cap.idcapacidad join desempenio d on m.iddesempenio = d.iddesempenio)m join estilo e join nivel n on p.idmatriz = m.idmatriz and p.idestilo = e.idestilo and n.idnivel = p.idnivel order by p.idpregunta asc;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `preguntaUpdate` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = '' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `preguntaUpdate`(IN `_descripcion` VARCHAR(250), IN `_descuido` DOUBLE, IN `_adivinanza` DOUBLE, IN `_idnivel` INT, IN `_idestilo` INT, IN `_idmatriz` INT, IN `_idperiodo` INT, IN `_idpregunta` INT)
BEGIN

UPDATE  pregunta SET  descripcion = _descripcion, descuido = _descuido, adivinanza = _adivinanza, idnivel = _idnivel, idestilo = _idestilo, idmatriz = _idmatriz, idperiodo = _idperiodo WHERE  idpregunta = _idpregunta;

END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `resultadoCreate` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `resultadoCreate`(IN `_idevaluacion_adaptativa` INT, IN `_idalternativa` INT, IN `_conocimiento_aposteriori` DOUBLE, IN `_tiempo` INT)
BEGIN

INSERT INTO resultado VALUES (null,_idevaluacion_adaptativa,_idalternativa,_conocimiento_aposteriori,_tiempo);

END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `resultadoRead` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = '' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `resultadoRead`()
BEGIN
select * from resultado;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `resultadoUpdate` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = '' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `resultadoUpdate`(in _id int)
BEGIN
UPDATE resultado SET tiempo = FLOOR(180 + (RAND() * 120)) WHERE idresultado = _id;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `seccionCreate` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `seccionCreate`(IN `_seccion` VARCHAR(45), IN `_descripcion` VARCHAR(45))
BEGIN

INSERT INTO seccion VALUES (null,_seccion,_descripcion);

END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `seccionDelete` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `seccionDelete`(IN `_id_seccion` VARCHAR(45))
BEGIN

DELETE FROM seccion WHERE idseccion = _id_seccion;

END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `seccionRead` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `seccionRead`()
BEGIN

SELECT * FROM seccion;

END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `seccionUpdate` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `seccionUpdate`(IN `_seccion` VARCHAR(45), IN `_descripcion` VARCHAR(45), IN `_id_seccion` VARCHAR(45))
BEGIN

UPDATE  seccion SET  seccion = _seccion, descripcion = _descripcion WHERE  idseccion = _id_seccion;

END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `validarLogin` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `validarLogin`(IN `_user` VARCHAR(45), IN `_password` VARCHAR(45))
BEGIN

select per.dni, per.nombres, per.apellidos, per.user, per.password, perf.idperfil, r.rol from persona per join perfil perf on per.dni = perf.dni join rol r on perf.idrol = r.idrol and per.user = _user and per.password = _password;

END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2020-02-09 10:57:25
