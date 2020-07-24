
CREATE DATABASE IF NOT EXISTS `social-web-app-db`;
USE `social-web-app-db`;


--表 social-web-app-db.users
CREATE TABLE IF NOT EXISTS `users` (
  `user_id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(256) COLLATE utf8mb4_bin DEFAULT NULL,
  `email` varchar(256) COLLATE utf8mb4_bin DEFAULT NULL,
  `password` varchar(256) COLLATE utf8mb4_bin DEFAULT NULL,
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin;

DELETE FROM `users`;
INSERT INTO `users` (`user_id`, `username`, `email`, `password`) VALUES
	(1, 'A', 'A@test.com', '123456');
INSERT INTO `users` (`user_id`, `username`, `email`, `password`) VALUES
	(2, 'B', 'B@test.com', '123456');
INSERT INTO `users` (`user_id`, `username`, `email`, `password`) VALUES
	(3, 'C', 'C@test.com', '123456');
INSERT INTO `users` (`user_id`, `username`, `email`, `password`) VALUES
	(4, 'D', 'D@test.com', '123456');
INSERT INTO `users` (`user_id`, `username`, `email`, `password`) VALUES
	(5, 'E', 'E@test.com', '123456');
INSERT INTO `users` (`user_id`, `username`, `email`, `password`) VALUES
	(6, 'F', 'F@test.com', '123456');
INSERT INTO `users` (`user_id`, `username`, `email`, `password`) VALUES
	(7, 'G', 'G@test.com', '123456');
	
--表 social-web-app-db.relationship
CREATE TABLE IF NOT EXISTS `relationship` (
  `user_one_id` int(11) NOT NULL,
  `user_two_id` int(11) NOT NULL,
  `status` tinyint(4) DEFAULT NULL COMMENT '0-Pending,1-Accepted,2-Declined,3-Blocked',
  `action_user_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`user_one_id`,`user_two_id`),
  KEY `FK_relationship_users_2` (`user_two_id`),
  KEY `FK_relationship_users_3` (`action_user_id`),
  CONSTRAINT `FK_relationship_users` FOREIGN KEY (`user_one_id`) REFERENCES `users` (`user_id`),
  CONSTRAINT `FK_relationship_users_2` FOREIGN KEY (`user_two_id`) REFERENCES `users` (`user_id`),
  CONSTRAINT `FK_relationship_users_3` FOREIGN KEY (`action_user_id`) REFERENCES `users` (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin;


DELETE FROM `relationship`;
INSERT INTO `relationship` (`user_one_id`, `user_two_id`, `status`, `action_user_id`) VALUES
	(1, 2, 1, 1);
INSERT INTO `relationship` (`user_one_id`, `user_two_id`, `status`, `action_user_id`) VALUES
	(1, 3, 1, 3);
INSERT INTO `relationship` (`user_one_id`, `user_two_id`, `status`, `action_user_id`) VALUES
	(1, 4, 1, 4);
INSERT INTO `relationship` (`user_one_id`, `user_two_id`, `status`, `action_user_id`) VALUES
	(1, 5, 0, 5);
INSERT INTO `relationship` (`user_one_id`, `user_two_id`, `status`, `action_user_id`) VALUES
	(1, 6, 3, 1);
INSERT INTO `relationship` (`user_one_id`, `user_two_id`, `status`, `action_user_id`) VALUES
	(1, 7, 0, 1);
INSERT INTO `relationship` (`user_one_id`, `user_two_id`, `status`, `action_user_id`) VALUES
	(2, 3, 1, 2);
INSERT INTO `relationship` (`user_one_id`, `user_two_id`, `status`, `action_user_id`) VALUES
	(2, 4, 1, 4);
INSERT INTO `relationship` (`user_one_id`, `user_two_id`, `status`, `action_user_id`) VALUES
	(3, 5, 1, 3);
	