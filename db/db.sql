-- MySQL dump 10.13  Distrib 5.7.17, for Win64 (x86_64)
--
-- Host: localhost    Database: projectmanagment
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
-- Table structure for table `members`
--

DROP TABLE IF EXISTS `members`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `members` (
  `Validity` int(11) NOT NULL,
  `IdTeam` int(11) NOT NULL,
  `Member` int(11) NOT NULL,
  PRIMARY KEY (`IdTeam`,`Member`),
  KEY `Member` (`Member`),
  CONSTRAINT `members_ibfk_1` FOREIGN KEY (`IdTeam`) REFERENCES `team` (`IdTeam`),
  CONSTRAINT `members_ibfk_2` FOREIGN KEY (`Member`) REFERENCES `user` (`IdUser`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `members`
--

LOCK TABLES `members` WRITE;
/*!40000 ALTER TABLE `members` DISABLE KEYS */;
INSERT INTO `members` VALUES (1,1,1),(1,1,2),(1,1,3),(1,1,4),(1,11,4),(1,11,5),(1,11,6),(1,11,7),(1,12,1),(1,12,5),(1,13,5),(1,13,6),(1,13,7),(1,13,8),(1,13,9);
/*!40000 ALTER TABLE `members` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `permission`
--

DROP TABLE IF EXISTS `permission`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `permission` (
  `IdPermission` int(11) NOT NULL AUTO_INCREMENT,
  `NamePermission` varchar(255) NOT NULL,
  `Validity` int(11) NOT NULL,
  PRIMARY KEY (`IdPermission`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `permission`
--

LOCK TABLES `permission` WRITE;
/*!40000 ALTER TABLE `permission` DISABLE KEYS */;
/*!40000 ALTER TABLE `permission` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `permissionrole`
--

DROP TABLE IF EXISTS `permissionrole`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `permissionrole` (
  `IdRole` int(11) NOT NULL,
  `IdPermission` int(11) NOT NULL,
  `validity` tinyint(4) NOT NULL,
  PRIMARY KEY (`IdRole`,`IdPermission`),
  KEY `IdPermission` (`IdPermission`),
  CONSTRAINT `permissionrole_ibfk_1` FOREIGN KEY (`IdRole`) REFERENCES `role` (`IdRole`),
  CONSTRAINT `permissionrole_ibfk_2` FOREIGN KEY (`IdPermission`) REFERENCES `permission` (`IdPermission`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `permissionrole`
--

LOCK TABLES `permissionrole` WRITE;
/*!40000 ALTER TABLE `permissionrole` DISABLE KEYS */;
/*!40000 ALTER TABLE `permissionrole` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `priority`
--

DROP TABLE IF EXISTS `priority`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `priority` (
  `IdPriority` int(11) NOT NULL AUTO_INCREMENT,
  `NamePriority` varchar(255) NOT NULL,
  `Validity` int(11) NOT NULL,
  PRIMARY KEY (`IdPriority`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `priority`
--

LOCK TABLES `priority` WRITE;
/*!40000 ALTER TABLE `priority` DISABLE KEYS */;
INSERT INTO `priority` VALUES (1,'Low',1),(2,'Medium',1),(3,'High',1);
/*!40000 ALTER TABLE `priority` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `project`
--

DROP TABLE IF EXISTS `project`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `project` (
  `IdProject` int(11) NOT NULL AUTO_INCREMENT,
  `NameProject` varchar(255) NOT NULL,
  `Client` varchar(255) NOT NULL,
  `Description` varchar(255) NOT NULL,
  `StartDate` date NOT NULL,
  `EndDate` date NOT NULL,
  `CreatedBy` int(11) NOT NULL,
  `Validity` int(11) NOT NULL,
  `IdTeam` int(11) NOT NULL,
  `IdStatus` int(11) NOT NULL,
  PRIMARY KEY (`IdProject`),
  KEY `IdTeam` (`IdTeam`),
  KEY `IdStatus` (`IdStatus`),
  KEY `project_ibfk_3_idx` (`CreatedBy`),
  CONSTRAINT `project_ibfk_1` FOREIGN KEY (`IdTeam`) REFERENCES `team` (`IdTeam`),
  CONSTRAINT `project_ibfk_2` FOREIGN KEY (`IdStatus`) REFERENCES `status` (`IdStatus`),
  CONSTRAINT `project_ibfk_3` FOREIGN KEY (`CreatedBy`) REFERENCES `user` (`IdUser`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=22 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `project`
--

LOCK TABLES `project` WRITE;
/*!40000 ALTER TABLE `project` DISABLE KEYS */;
INSERT INTO `project` VALUES (1,'TestProject','TestProject','TestProject','2018-03-21','2018-03-30',1,1,1,3),(2,'tes222','tesstba','test2','2018-03-22','2018-03-30',1,0,11,4),(3,'tesba2','tesstba2','testba2','2018-03-22','2018-03-30',1,0,1,4),(4,'ttt','ttt','ttt','2018-03-23','2018-03-30',1,0,1,4),(5,'vffsgv','dfsb','dfsbsdf','2018-03-23','2018-03-28',5,0,1,2),(6,'rrt','rrt','rrt','2018-03-23','2018-03-26',1,0,1,2),(7,'ssss','sss','sssss','2018-03-23','2018-03-27',1,0,1,2),(8,'ff','ff','fff','2018-03-23','2018-03-26',1,0,1,1),(9,'fgfg','zfgzfg','fzgzfgzfg','2018-03-20','2018-03-27',1,0,1,2),(10,'srtth','sdhg','shd','2018-03-27','2018-03-28',1,0,2,4),(11,'gg','gg','gg','2018-03-28','2018-03-29',1,0,3,2),(12,'test1','acaCA','DACAC','2018-03-28','2018-03-29',1,0,1,4),(13,'t2','t2','t2','2018-03-28','2018-03-30',1,0,1,4),(14,'GeneralTest','GeneralTest','GeneralTest','2018-03-29','2018-03-31',1,0,1,4),(16,'Final ','Final test','Final ','2018-03-30','2018-03-31',1,0,11,4),(17,'todaytest','todaytest','todayTest','2018-04-03','2018-04-05',1,1,1,2),(18,'Demo','demo','Demo','2018-04-03','2018-04-05',1,1,1,1),(19,'today','to','to','2018-04-06','2018-04-24',5,1,1,2),(20,'aaaa','aaa','aaaa','2018-04-06','2018-04-13',1,1,1,2),(21,'LastTest','LastTest','LastTest','2018-04-11','2018-04-13',1,1,11,2);
/*!40000 ALTER TABLE `project` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `requirment`
--

DROP TABLE IF EXISTS `requirment`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `requirment` (
  `IdRequirment` int(11) NOT NULL AUTO_INCREMENT,
  `NameRequirment` varchar(255) NOT NULL,
  `Description` varchar(2000) NOT NULL,
  `Validity` int(11) NOT NULL,
  `IdStatus` int(11) NOT NULL,
  `IdPriority` int(11) NOT NULL,
  `IdProject` int(11) NOT NULL,
  PRIMARY KEY (`IdRequirment`),
  KEY `IdStatus` (`IdStatus`),
  KEY `IdPriority` (`IdPriority`),
  KEY `IdProject` (`IdProject`),
  CONSTRAINT `requirment_ibfk_1` FOREIGN KEY (`IdStatus`) REFERENCES `status` (`IdStatus`),
  CONSTRAINT `requirment_ibfk_2` FOREIGN KEY (`IdPriority`) REFERENCES `priority` (`IdPriority`),
  CONSTRAINT `requirment_ibfk_3` FOREIGN KEY (`IdProject`) REFERENCES `project` (`IdProject`)
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `requirment`
--

LOCK TABLES `requirment` WRITE;
/*!40000 ALTER TABLE `requirment` DISABLE KEYS */;
INSERT INTO `requirment` VALUES (1,'TestReq','testreq',1,1,1,1),(2,'newReq','requirement',1,2,2,1),(3,'newReqnb','bhnb',0,4,1,1),(4,'bum','bum',0,4,2,1),(5,'tdhadth','sgsgs',0,4,1,1),(6,'DSFs','sdf',1,2,1,2),(7,'adfdvaDvd','SDvDSvSDvS',0,4,1,1),(8,'asddas','asddasdasd',1,2,1,3),(9,'daghasg','asfgasga',1,3,1,3),(10,'sasasas','asasas',0,4,1,1),(11,'dolandv','sdfgdshdsgh',0,4,1,1),(12,'test','test',0,4,1,1),(13,'GeneralTest','GeneralTest',1,2,1,14),(14,'todaytest','todaytest',0,4,1,1),(15,'tani','tnai',0,4,1,1),(16,'Final test Requirement','Final test Requirement',1,3,1,16),(17,'todayRequirement','Requirement',1,3,1,17),(18,'DemoReq','DemoReq',1,2,1,18),(19,'LastTest','LastTest',1,2,1,21),(20,'adfaf','asfasfasf',0,4,1,21);
/*!40000 ALTER TABLE `requirment` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `role`
--

DROP TABLE IF EXISTS `role`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `role` (
  `IdRole` int(11) NOT NULL AUTO_INCREMENT,
  `NameRole` varchar(255) NOT NULL,
  `Description` varchar(255) NOT NULL,
  `Validity` int(11) NOT NULL,
  PRIMARY KEY (`IdRole`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `role`
--

LOCK TABLES `role` WRITE;
/*!40000 ALTER TABLE `role` DISABLE KEYS */;
INSERT INTO `role` VALUES (1,'Project Manager','Test',1),(2,'Team Leader','test',1),(3,'Developer','test',1),(4,'Business Analyst','test',1);
/*!40000 ALTER TABLE `role` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `status`
--

DROP TABLE IF EXISTS `status`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `status` (
  `IdStatus` int(11) NOT NULL AUTO_INCREMENT,
  `NameStatus` varchar(255) NOT NULL,
  `Validity` int(11) NOT NULL,
  PRIMARY KEY (`IdStatus`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `status`
--

LOCK TABLES `status` WRITE;
/*!40000 ALTER TABLE `status` DISABLE KEYS */;
INSERT INTO `status` VALUES (1,'Waiting BA',1),(2,'In Progress',1),(3,'Assigned',1),(4,'Done',1);
/*!40000 ALTER TABLE `status` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `task`
--

DROP TABLE IF EXISTS `task`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `task` (
  `IdTask` int(11) NOT NULL AUTO_INCREMENT,
  `NameTask` varchar(255) NOT NULL,
  `Description` varchar(255) NOT NULL,
  `StartDate` date NOT NULL,
  `EndDate` date NOT NULL,
  `CreatedBy` int(11) NOT NULL,
  `AssignedTo` int(11) NOT NULL,
  `IdPriority` int(11) NOT NULL,
  `IdStatus` int(11) NOT NULL,
  `IdRequirment` int(11) NOT NULL,
  `Validity` tinyint(4) NOT NULL,
  PRIMARY KEY (`IdTask`),
  KEY `IdPriority` (`IdPriority`),
  KEY `IdStatus` (`IdStatus`),
  KEY `IdRequirment` (`IdRequirment`),
  KEY `tasl_ibfk_4_idx` (`AssignedTo`),
  CONSTRAINT `task_ibfk_1` FOREIGN KEY (`IdPriority`) REFERENCES `priority` (`IdPriority`),
  CONSTRAINT `task_ibfk_2` FOREIGN KEY (`IdStatus`) REFERENCES `status` (`IdStatus`),
  CONSTRAINT `task_ibfk_3` FOREIGN KEY (`IdRequirment`) REFERENCES `requirment` (`IdRequirment`),
  CONSTRAINT `tasl_ibfk_4` FOREIGN KEY (`AssignedTo`) REFERENCES `user` (`IdUser`)
) ENGINE=InnoDB AUTO_INCREMENT=23 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `task`
--

LOCK TABLES `task` WRITE;
/*!40000 ALTER TABLE `task` DISABLE KEYS */;
INSERT INTO `task` VALUES (2,'Test Task','Test Task','2018-03-26','2018-03-30',0,3,2,2,1,1),(3,'t2','t2','2018-03-26','2018-03-28',2,3,1,4,1,1),(4,'doland','doland','2018-03-27','2018-03-28',2,3,1,2,1,1),(5,'create','dfghi','2018-03-28','2018-03-14',2,3,1,1,3,1),(6,'update','b','2018-03-21','2018-03-22',2,3,1,2,1,1),(7,'delete','DAF','2018-03-28','2018-03-29',0,3,1,4,1,1),(8,'test','VSD','2018-03-13','2018-03-16',2,3,1,2,1,1),(9,'ikub','bf','2018-03-29','2018-03-30',2,3,1,2,1,1),(10,'test2','tttttt','2018-03-28','2018-03-30',0,3,2,4,1,1),(11,'tttttttt','ttttttt','2018-03-28','2018-03-30',2,3,1,2,1,0),(12,'strdhj','strh','2018-03-28','2018-03-29',2,3,1,2,2,0),(13,'now','ZV','2018-03-28','2018-03-29',2,3,1,1,1,1),(14,'crud','test','2018-03-29','2018-03-30',2,3,1,4,6,1),(15,'tesk test','tesk test','2018-03-29','2018-03-30',2,7,1,2,8,1),(16,'GeneralTest','GeneralTest','2018-03-29','2018-03-31',2,3,1,4,13,1),(17,'test','test','2018-03-29','2018-03-30',2,3,1,3,6,1),(18,'FInalTestTask','FInalTestTaskk','2018-03-30','2018-03-31',2,3,2,4,16,1),(19,'todayTask','todayTask','2018-04-03','2018-04-04',2,3,2,4,17,1),(20,'task','task','2018-04-03','2018-04-04',2,3,1,2,6,1),(21,'DemoTask','DemoTask','2018-04-03','2018-04-05',2,3,2,4,18,1),(22,'lastTest','lastTest','2018-04-11','2018-04-13',0,9,2,2,19,1);
/*!40000 ALTER TABLE `task` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `team`
--

DROP TABLE IF EXISTS `team`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `team` (
  `IdTeam` int(11) NOT NULL AUTO_INCREMENT,
  `NameTeam` varchar(255) NOT NULL,
  `Validity` int(11) NOT NULL,
  PRIMARY KEY (`IdTeam`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `team`
--

LOCK TABLES `team` WRITE;
/*!40000 ALTER TABLE `team` DISABLE KEYS */;
INSERT INTO `team` VALUES (1,'Team Test',1),(2,'tt',0),(10,'ikub',0),(11,'doland12',1),(12,'sot',0),(13,'LastTest',1);
/*!40000 ALTER TABLE `team` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user` (
  `IdUser` int(11) NOT NULL AUTO_INCREMENT,
  `NameUser` varchar(255) NOT NULL,
  `Email` varchar(255) NOT NULL,
  `Validity` int(11) NOT NULL,
  `Password` varchar(255) NOT NULL,
  `IdRole` int(11) NOT NULL,
  PRIMARY KEY (`IdUser`),
  UNIQUE KEY `Email` (`Email`),
  KEY `IdRole` (`IdRole`),
  CONSTRAINT `user_ibfk_1` FOREIGN KEY (`IdRole`) REFERENCES `role` (`IdRole`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES (1,'TestPM','PM',1,'TestPM',1),(2,'TestTL','TL',1,'TestTL',2),(3,'TestDEV','DEV',1,'TestDEV',3),(4,'TestBA','BA',1,'TestBA',4),(5,'TestPM2','PM2',1,'TestPM2',1),(6,'TestTL2','TL2',1,'TestTL2',2),(7,'TestDEV2','DEV2',1,'TestDEV2',3),(8,'TestBA2','BA2',1,'TestBA2',4),(9,'TestDEV3','DEV3',1,'TestDEV3',3);
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2018-04-11  9:39:53
