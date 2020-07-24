
CREATE DATABASE IF NOT EXISTS `social-web-app-db`;
USE `social-web-app-db`;

--表 social-web-app-db.t_user 
CREATE TABLE IF NOT EXISTS `t_user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `first_name` varchar(50) COLLATE utf8mb4_bin NOT NULL,
  `last_name` varchar(50) COLLATE utf8mb4_bin NOT NULL,
  `user_name` varchar(50) COLLATE utf8mb4_bin NOT NULL,
  `password` varchar(50) COLLATE utf8mb4_bin NOT NULL,
  `location` varchar(500) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin DEFAULT NULL COMMENT 'Location Details',
  `status` varchar(2) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NOT NULL COMMENT '1:normal,2:suspend',
  `source` varchar(2) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin DEFAULT NULL COMMENT '1:Twitter,2:Facebook',
  `del_flag` varchar(2) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NOT NULL COMMENT '0:normal,1:deleted',
  `create_by` int(11) NOT NULL,
  `create_time` datetime NOT NULL,
  `update_by` int(11) DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `user_name` (`user_name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin COMMENT='User';

--表 social-web-app-db.t_user_setting
CREATE TABLE IF NOT EXISTS `t_user_setting` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) NOT NULL,
  `notify_followers` varchar(2) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NOT NULL COMMENT 'Notification of Followers.0:open,1:closed',
  `notify_comments` varchar(2) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NOT NULL COMMENT 'Notification of Comments.0:open,1:closed',
  `del_flag` varchar(2) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NOT NULL COMMENT '0:Normal,1:Deleted',
  `create_by` int(11) NOT NULL,
  `create_time` datetime NOT NULL,
  `update_by` int(11) DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_t_user_setting_t_user` (`user_id`),
  CONSTRAINT `FK_t_user_setting_t_user` FOREIGN KEY (`user_id`) REFERENCES `t_user` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin COMMENT='User setting';

--表 social-web-app-db.t_post 
CREATE TABLE IF NOT EXISTS `t_post` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `categorize` varchar(2) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NOT NULL COMMENT 'Categorize type code',
  `author_id` int(11) NOT NULL,
  `content` varchar(2000) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NOT NULL,
  `del_flag` varchar(2) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NOT NULL COMMENT '0:normal,1:deleted',
  `create_by` int(11) NOT NULL,
  `create_time` datetime NOT NULL,
  `update_by` int(11) DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_t_post_t_user` (`author_id`),
  CONSTRAINT `FK_t_post_t_user` FOREIGN KEY (`author_id`) REFERENCES `t_user` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin COMMENT='Post';

--表 social-web-app-db.t_post_tag
CREATE TABLE IF NOT EXISTS `t_post_tag` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `post_id` int(11) NOT NULL,
  `tag` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NOT NULL,
  `del_flag` varchar(2) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NOT NULL COMMENT '0:normal,1:deleted',
  `create_by` int(11) NOT NULL,
  `create_time` datetime NOT NULL,
  `update_by` int(11) DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_t_post_tag_t_post` (`post_id`),
  CONSTRAINT `FK_t_post_tag_t_post` FOREIGN KEY (`post_id`) REFERENCES `t_post` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin COMMENT='Post tags';

--表 social-web-app-db.t_comment
CREATE TABLE IF NOT EXISTS `t_comment` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `comment_type` varchar(2) COLLATE utf8mb4_bin NOT NULL DEFAULT '0' COMMENT '1:post comment,2:comment comment',
  `post_id` int(11) NOT NULL,
  `comment_id` int(11) DEFAULT NULL COMMENT 'Comment for someone''s comment',
  `writer_id` int(11) NOT NULL,
  `content` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NOT NULL,
  `del_flag` varchar(2) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NOT NULL COMMENT '0:normal,1:deleted',
  `create_by` int(11) NOT NULL,
  `create_time` datetime NOT NULL,
  `update_by` int(11) DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_t_comment_t_post` (`post_id`),
  KEY `FK_t_comment_t_comment` (`comment_id`),
  KEY `FK_t_comment_t_user` (`writer_id`),
  CONSTRAINT `FK_t_comment_t_comment` FOREIGN KEY (`comment_id`) REFERENCES `t_comment` (`id`),
  CONSTRAINT `FK_t_comment_t_post` FOREIGN KEY (`post_id`) REFERENCES `t_post` (`id`),
  CONSTRAINT `FK_t_comment_t_user` FOREIGN KEY (`writer_id`) REFERENCES `t_user` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin COMMENT='Comment';

--表 social-web-app-db.t_favorite
CREATE TABLE IF NOT EXISTS `t_favorite` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `post_id` int(11) NOT NULL,
  `user_id` int(11) NOT NULL,
  `del_flag` varchar(2) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NOT NULL COMMENT '0:normal,1:deleted',
  `create_by` int(11) NOT NULL,
  `create_time` datetime NOT NULL,
  `update_by` int(11) DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_t_favorite_t_post` (`post_id`),
  KEY `FK_t_favorite_t_user` (`user_id`),
  CONSTRAINT `FK_t_favorite_t_post` FOREIGN KEY (`post_id`) REFERENCES `t_post` (`id`),
  CONSTRAINT `FK_t_favorite_t_user` FOREIGN KEY (`user_id`) REFERENCES `t_user` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin COMMENT='Favorite post';

--表 social-web-app-db.t_follow
CREATE TABLE IF NOT EXISTS `t_follow` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `follow_user_id` int(11) NOT NULL COMMENT 'The user id someone is following',
  `user_id` int(11) NOT NULL,
  `del_flag` varchar(2) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NOT NULL COMMENT '0:normal,1:deleted',
  `create_by` int(11) NOT NULL,
  `create_time` datetime NOT NULL,
  `update_by` int(11) DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_t_follow_t_user` (`follow_user_id`),
  KEY `FK_t_follow_t_user_2` (`user_id`),
  CONSTRAINT `FK_t_follow_t_user` FOREIGN KEY (`follow_user_id`) REFERENCES `t_user` (`id`),
  CONSTRAINT `FK_t_follow_t_user_2` FOREIGN KEY (`user_id`) REFERENCES `t_user` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin COMMENT='Follow relationship';
