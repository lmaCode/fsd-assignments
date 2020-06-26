-- --------------------------------------------------------
-- 主机:                           localhost
-- 服务器版本:                        8.0.13 - MySQL Community Server - GPL
-- 服务器操作系统:                      Win64
-- HeidiSQL 版本:                  9.5.0.5196
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;


-- 导出 sba 的数据库结构
CREATE DATABASE IF NOT EXISTS `sba` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_bin */;
USE `sba`;

-- 导出  表 sba.t_mentor_calendar 结构
CREATE TABLE IF NOT EXISTS `t_mentor_calendar` (
  `id` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NOT NULL,
  `mentor_id` varchar(50) COLLATE utf8mb4_bin DEFAULT NULL,
  `mentor_name` varchar(50) COLLATE utf8mb4_bin DEFAULT NULL,
  `training_date` date DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin;

-- 数据导出被取消选择。
-- 导出  表 sba.t_mentor_skill 结构
CREATE TABLE IF NOT EXISTS `t_mentor_skill` (
  `id` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NOT NULL,
  `skill_id` varchar(50) COLLATE utf8mb4_bin DEFAULT NULL,
  `skill_name` varchar(50) COLLATE utf8mb4_bin DEFAULT NULL,
  `mentor_id` varchar(50) COLLATE utf8mb4_bin DEFAULT NULL,
  `mentor_name` varchar(50) COLLATE utf8mb4_bin DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin;

-- 数据导出被取消选择。
-- 导出  表 sba.t_payment 结构
CREATE TABLE IF NOT EXISTS `t_payment` (
  `id` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NOT NULL,
  `training_id` varchar(50) COLLATE utf8mb4_bin DEFAULT NULL,
  `skill_id` varchar(50) COLLATE utf8mb4_bin DEFAULT NULL,
  `skill_name` varchar(50) COLLATE utf8mb4_bin DEFAULT NULL,
  `mentor_id` varchar(50) COLLATE utf8mb4_bin DEFAULT NULL,
  `mentor_name` varchar(50) COLLATE utf8mb4_bin DEFAULT NULL,
  `amount` decimal(10,0) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin;

-- 数据导出被取消选择。
-- 导出  表 sba.t_technology 结构
CREATE TABLE IF NOT EXISTS `t_technology` (
  `id` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NOT NULL,
  `skill_name` varchar(50) COLLATE utf8mb4_bin DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin;

-- 数据导出被取消选择。
-- 导出  表 sba.t_training 结构
CREATE TABLE IF NOT EXISTS `t_training` (
  `id` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NOT NULL,
  `skill_id` varchar(50) COLLATE utf8mb4_bin DEFAULT NULL,
  `skill_name` varchar(50) COLLATE utf8mb4_bin DEFAULT NULL,
  `mentor_id` varchar(50) COLLATE utf8mb4_bin DEFAULT NULL,
  `mentor_name` varchar(50) COLLATE utf8mb4_bin DEFAULT NULL,
  `fees` decimal(10,0) DEFAULT NULL,
  `start_date` date DEFAULT NULL,
  `end_date` date DEFAULT NULL,
  `status` varchar(50) COLLATE utf8mb4_bin DEFAULT NULL,
  `progress` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin;

-- 数据导出被取消选择。
-- 导出  表 sba.t_user 结构
CREATE TABLE IF NOT EXISTS `t_user` (
  `id` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NOT NULL,
  `email` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NOT NULL,
  `pwd` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NOT NULL,
  `role` varchar(20) COLLATE utf8mb4_bin NOT NULL,
  `experience` int(11) DEFAULT NULL,
  `amount` decimal(10,0) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `username` (`email`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin;

-- 数据导出被取消选择。
-- 导出  表 sba.t_user_training 结构
CREATE TABLE IF NOT EXISTS `t_user_training` (
  `id` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NOT NULL,
  `user_id` varchar(50) COLLATE utf8mb4_bin NOT NULL,
  `user_name` varchar(50) COLLATE utf8mb4_bin NOT NULL,
  `mentor_id` varchar(50) COLLATE utf8mb4_bin DEFAULT NULL,
  `mentor_name` varchar(50) COLLATE utf8mb4_bin DEFAULT NULL,
  `training_id` varchar(50) COLLATE utf8mb4_bin DEFAULT NULL,
  `status` varchar(50) COLLATE utf8mb4_bin DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin;

-- 数据导出被取消选择。
/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
