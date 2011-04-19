-- MySQL Administrator dump 1.4
--
-- ------------------------------------------------------
-- Server version	5.0.51b-community-nt


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;


--
-- Create schema library
--

CREATE DATABASE IF NOT EXISTS library;
USE library;

--
-- Definition of table `role`
--

DROP TABLE IF EXISTS `role`;
CREATE TABLE `role` (
  `roleId` int(11) NOT NULL auto_increment,
  `createDate` datetime default NULL,
  `roleActive` bit(1) NOT NULL,
  `roleDesc` varchar(255) default NULL,
  `roleName` varchar(255) default NULL,
  `checked` bit(1) default NULL,
  PRIMARY KEY  (`roleId`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=gbk;

--
-- Dumping data for table `role`
--

/*!40000 ALTER TABLE `role` DISABLE KEYS */;
INSERT INTO `role` (`roleId`,`createDate`,`roleActive`,`roleDesc`,`roleName`,`checked`) VALUES 
 (1,'2011-04-09 00:00:00',0x01,'拥有系统所有权限','超级管理员',NULL),
 (2,'2011-04-20 00:44:02',0x01,NULL,'管理员1',NULL),
 (3,'2011-04-20 00:44:52',0x01,NULL,'管理员2',NULL),
 (4,'2011-04-20 00:45:22',0x01,NULL,'管理员3',NULL),
 (5,'2011-04-20 00:45:45',0x01,NULL,'管理员4',NULL),
 (6,'2011-04-20 00:46:10',0x01,NULL,'管理员5',NULL);
/*!40000 ALTER TABLE `role` ENABLE KEYS */;


--
-- Definition of table `user`
--

DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `userId` bigint(20) NOT NULL auto_increment,
  `createDate` datetime default NULL,
  `password` varchar(255) default NULL,
  `userAccount` varchar(255) default NULL,
  `userActive` bit(1) default NULL,
  `userName` varchar(255) default NULL,
  `deptId` bigint(20) default NULL,
  PRIMARY KEY  (`userId`),
  KEY `FK285FEB6064F874` (`deptId`),
  CONSTRAINT `FK285FEB6064F874` FOREIGN KEY (`deptId`) REFERENCES `department` (`deptId`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=gbk;

--
-- Dumping data for table `user`
--

/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` (`userId`,`createDate`,`password`,`userAccount`,`userActive`,`userName`,`deptId`) VALUES 
 (1,'2011-04-04 00:00:00','123','admin',0x01,'admin',2),
 (2,'2011-04-20 01:14:22','123','shuai',0x01,'shuai',2),
 (3,'2011-04-20 01:14:24','123','zhichun',0x01,'zhichun',2);
/*!40000 ALTER TABLE `user` ENABLE KEYS */;


--
-- Definition of table `userrole`
--

DROP TABLE IF EXISTS `userrole`;
CREATE TABLE `userrole` (
  `userId` bigint(20) NOT NULL,
  `roleId` int(11) NOT NULL,
  KEY `FKF3F76701E1DCD909` (`roleId`),
  KEY `FKF3F76701E7322E73` (`userId`),
  CONSTRAINT `FKF3F76701E1DCD909` FOREIGN KEY (`roleId`) REFERENCES `role` (`roleId`),
  CONSTRAINT `FKF3F76701E7322E73` FOREIGN KEY (`userId`) REFERENCES `user` (`userId`)
) ENGINE=InnoDB DEFAULT CHARSET=gbk;

--
-- Dumping data for table `userrole`
--

/*!40000 ALTER TABLE `userrole` DISABLE KEYS */;
INSERT INTO `userrole` (`userId`,`roleId`) VALUES 
 (2,2),
 (2,3),
 (1,1),
 (3,4);
/*!40000 ALTER TABLE `userrole` ENABLE KEYS */;




/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
