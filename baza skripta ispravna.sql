create schema trellofa;
use trellofa;

CREATE TABLE `app_keys` (
  `key` char(32) NOT NULL,
  PRIMARY KEY (`key`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;


CREATE TABLE `membershiptype` (
  `id` int NOT NULL AUTO_INCREMENT,
  `Type` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `organization` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `display_name` varchar(255) DEFAULT NULL,
  `description` varchar(255) DEFAULT NULL,
  `invited` tinyint(1) DEFAULT NULL,
  `url` varchar(255) DEFAULT NULL,
  `website` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `member` (
  `id` int NOT NULL AUTO_INCREMENT,
  `username` varchar(255) DEFAULT NULL,
  `fullname` varchar(255) DEFAULT NULL,
  `avatar_source` varchar(255) DEFAULT NULL,
  `bio` varchar(255) DEFAULT NULL,
  `initials` varchar(45) DEFAULT NULL,
  `member_type` varchar(255) DEFAULT NULL,
  `url` varchar(255) DEFAULT NULL,
  `confirmed` tinyint(1) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `role` tinyint DEFAULT NULL,
  `status` tinyint DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `board` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `description` mediumtext,
  `closed` tinyint(1) DEFAULT NULL,
  `pinned` tinyint(1) DEFAULT NULL,
  `url` varchar(255) DEFAULT NULL,
  `invited` tinyint(1) DEFAULT NULL,
  `short_url` varchar(150) DEFAULT NULL,
  `subscribed` tinyint(1) DEFAULT NULL,
  `date_last_activity` datetime DEFAULT NULL,
  `date_last_view` datetime DEFAULT NULL,
  `short_link` varchar(150) DEFAULT NULL,
  `id_organization` int NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_Board_Organization1` (`id_organization`),
  CONSTRAINT `fk_Board_Organization1` FOREIGN KEY (`id_organization`) REFERENCES `organization` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `board_has_members` (
  `id` int NOT NULL AUTO_INCREMENT,
  `id_board` int NOT NULL,
  `id_member` int NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_Board_has_Members_Board1` (`id_board`),
  KEY `fk_Board_has_Members_Member1` (`id_member`),
  CONSTRAINT `fk_Board_has_Members_Board1` FOREIGN KEY (`id_board`) REFERENCES `board` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `fk_Board_has_Members_Member1` FOREIGN KEY (`id_member`) REFERENCES `member` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `list` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `closed` tinyint(1) DEFAULT NULL,
  `pos` int DEFAULT NULL,
  `subscribed` tinyint(1) DEFAULT NULL,
  `id_board` int NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_List_Board1` (`id_board`),
  CONSTRAINT `fk_List_Board1` FOREIGN KEY (`id_board`) REFERENCES `board` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `card` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(100) DEFAULT NULL,
  `description` mediumtext,
  `url` varchar(255) DEFAULT NULL,
  `due` date DEFAULT NULL,
  `due_complete` tinyint(1) DEFAULT NULL,
  `closed` tinyint(1) DEFAULT NULL,
  `date_last_activity` date DEFAULT NULL,
  `id_short` varchar(150) DEFAULT NULL,
  `pos` bigint DEFAULT NULL,
  `short_link` varchar(150) DEFAULT NULL,
  `short_url` varchar(150) DEFAULT NULL,
  `subscribed` tinyint(1) DEFAULT NULL,
  `id_list` int NOT NULL,
  `dnd_index` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_Card_List1` (`id_list`),
  CONSTRAINT `fk_Card_List1` FOREIGN KEY (`id_list`) REFERENCES `list` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB  DEFAULT CHARSET=utf8;

CREATE TABLE `label` (
  `id` int NOT NULL AUTO_INCREMENT,
  `color` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `text` mediumtext,
  `id_member` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `label_member_id_fk` (`id_member`),
  CONSTRAINT `label_member_id_fk` FOREIGN KEY (`id_member`) REFERENCES `member` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


CREATE TABLE `card_has_labels` (
  `id` int NOT NULL AUTO_INCREMENT,
  `id_card` int DEFAULT NULL,
  `id_label` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `card_has_labels_card_id_fk` (`id_card`),
  KEY `card_has_labels_label_id_fk` (`id_label`),
  CONSTRAINT `card_has_labels_card_id_fk` FOREIGN KEY (`id_card`) REFERENCES `card` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `card_has_labels_label_id_fk` FOREIGN KEY (`id_label`) REFERENCES `label` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE `comment` (
  `id` int NOT NULL AUTO_INCREMENT,
  `text` mediumtext,
  `date` date DEFAULT NULL,
  `id_card` int NOT NULL,
  `id_member` int NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_Comment_Card1` (`id_card`),
  KEY `fk_Comment_Member1` (`id_member`),
  CONSTRAINT `fk_Comment_Card1` FOREIGN KEY (`id_card`) REFERENCES `card` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `fk_Comment_Member1` FOREIGN KEY (`id_member`) REFERENCES `member` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB  DEFAULT CHARSET=utf8;

CREATE TABLE `invitation` (
  `id` int NOT NULL AUTO_INCREMENT,
  `id_board` int NOT NULL,
  `id_member` int NOT NULL,
  `sender` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_invitatinos_of_board` (`id_board`),
  KEY `fk_invitations_member` (`id_member`),
  CONSTRAINT `fk_invitatinos_of_board` FOREIGN KEY (`id_board`) REFERENCES `board` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `fk_invitations_member` FOREIGN KEY (`id_member`) REFERENCES `member` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;






CREATE TABLE `members_on_cards` (
  `id` int NOT NULL AUTO_INCREMENT,
  `id_member` int DEFAULT NULL,
  `id_card` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `Members_on_cards_Card` (`id_card`),
  KEY `Members_on_cards_Member` (`id_member`),
  CONSTRAINT `Members_on_cards_Card` FOREIGN KEY (`id_card`) REFERENCES `card` (`id`),
  CONSTRAINT `Members_on_cards_Member` FOREIGN KEY (`id_member`) REFERENCES `member` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `membership` (
  `id` int NOT NULL AUTO_INCREMENT,
  `id_organization` int NOT NULL,
  `id_member` int NOT NULL,
  `id_membership_type` int NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_Membership_Organization` (`id_organization`),
  KEY `fk_Membership_Member1` (`id_member`),
  KEY `fk_Membership_MembershipType1` (`id_membership_type`),
  CONSTRAINT `fk_Membership_Member1` FOREIGN KEY (`id_member`) REFERENCES `member` (`id`) ON DELETE CASCADE,
  CONSTRAINT `fk_Membership_MembershipType1` FOREIGN KEY (`id_membership_type`) REFERENCES `membershiptype` (`id`) ON DELETE CASCADE,
  CONSTRAINT `fk_Membership_Organization` FOREIGN KEY (`id_organization`) REFERENCES `organization` (`id`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;




CREATE TABLE `attachment` (
  `id` int NOT NULL AUTO_INCREMENT,
  `bytes` int DEFAULT NULL,
  `date` date DEFAULT NULL,
  `is_upload` tinyint(1) DEFAULT NULL,
  `mime_type` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `url` varchar(255) DEFAULT NULL,
  `id_member` int NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_Attachment_Member1` (`id_member`),
  CONSTRAINT `fk_Attachment_Member1` FOREIGN KEY (`id_member`) REFERENCES `member` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;



insert into `organization`(`name`) values ("prva organizacija");
insert into `app_keys` (`key`) values ("a93kn10buenalpwrn5ax9f7er093mqlw");
