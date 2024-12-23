
-- Dumping database structure for works
DROP DATABASE IF EXISTS `week4`;
CREATE DATABASE IF NOT EXISTS `week4` /*!40100 DEFAULT CHARACTER SET latin1 COLLATE latin1_swedish_ci */;
USE `week4`;

-- Dumping structure for table works.address
DROP TABLE IF EXISTS `address`;
CREATE TABLE IF NOT EXISTS `address` (
  `id` uuid NOT NULL,
  `street` varchar(150) DEFAULT NULL,
  `city` varchar(50) DEFAULT NULL,
  `country` smallint(6) DEFAULT NULL CHECK (`country` between 0 and 201),
  `number` varchar(20) DEFAULT NULL,
  `zipcode` varchar(7) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_swedish_ci;

-- Dumping data for table works.address: ~2 rows (approximately)
DELETE FROM `address`;
INSERT INTO `address` (`id`, `street`, `city`, `country`, `number`, `zipcode`) VALUES
	('f1fd5b76-0491-476e-ac85-1a613d25b24e', 'NVQ', 'sg', 1, '11', '5345643'),
	('2536442d-8a32-4acf-9dfc-7a4e25edb329', 'NVQ', 'sg', 1, '11', '5345643');

-- Dumping structure for table works.candidate
DROP TABLE IF EXISTS `candidate`;
CREATE TABLE IF NOT EXISTS `candidate` (
    `id` uuid NOT NULL,
    `dob` timestamp NOT NULL,
    `email` varchar(255) NOT NULL,
    `last_name` varchar(255) NOT NULL,
    `middle_name` varchar(255) NOT NULL,
    `first_name` varchar(255) NOT NULL,
    `phone` varchar(15) NOT NULL,
    `address` uuid NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK_qfut8ruekode092nlkipgl09g` (`email`),
  UNIQUE KEY `UK_9i5yt1gvm0chg5e10qkns7tll` (`phone`),
  UNIQUE KEY `UK_m8qhlm4wu215gr34dhxp0dour` (`address`),
  CONSTRAINT `FKa8gnyyhbb2qnhp94grci1n0o9` FOREIGN KEY (`address`) REFERENCES `address` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_swedish_ci;

-- Dumping data for table works.candidate: ~0 rows (approximately)
DELETE FROM `candidate`;


-- Dumping structure for table works.skill
DROP TABLE IF EXISTS `skill`;
CREATE TABLE IF NOT EXISTS `skill` (
  `skill_id` uuid NOT NULL,
  `skill_description` varchar(255) DEFAULT NULL,
  `skill_name` varchar(255) DEFAULT NULL,
  `type` tinyint(4) DEFAULT NULL CHECK (`type` between 0 and 2),
  PRIMARY KEY (`skill_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_swedish_ci;

-- Dumping data for table works.skill: ~0 rows (approximately)
DELETE FROM `skill`;

-- Dumping structure for table works.candidate_skill
DROP TABLE IF EXISTS `candidate_skill`;
CREATE TABLE IF NOT EXISTS `candidate_skill` (
  `more_infos` varchar(1000) DEFAULT NULL,
  `skill_level` tinyint(4) NOT NULL CHECK (`skill_level` between 0 and 2),
  `skill_id` uuid NOT NULL,
  `can_id` uuid NOT NULL,
  PRIMARY KEY (`can_id`,`skill_id`),
  KEY `FKb7cxhiqhcah7c20a2cdlvr1f8` (`skill_id`),
  CONSTRAINT `FKb0m5tm3fi0upa3b3kjx3vrlxs` FOREIGN KEY (`can_id`) REFERENCES `candidate` (`id`),
  CONSTRAINT `FKb7cxhiqhcah7c20a2cdlvr1f8` FOREIGN KEY (`skill_id`) REFERENCES `skill` (`skill_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_swedish_ci;

-- Dumping data for table works.candidate_skill: ~0 rows (approximately)
DELETE FROM `candidate_skill`;

-- Dumping structure for table works.company
DROP TABLE IF EXISTS `company`;
CREATE TABLE IF NOT EXISTS `company` (
  `comp_id` uuid NOT NULL,
  `about` varchar(2000) DEFAULT NULL,
  `email` varchar(255) NOT NULL,
  `comp_name` varchar(255) NOT NULL,
  `phone` varchar(255) NOT NULL,
  `web_url` varchar(255) DEFAULT NULL,
  `address` uuid NOT NULL,
  PRIMARY KEY (`comp_id`),
  UNIQUE KEY `UK_rvp2hunsq4sgmpxe3a7i1ym3m` (`address`),
  CONSTRAINT `FKd5occp4cjwihejbxdbpvkp5tv` FOREIGN KEY (`address`) REFERENCES `address` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_swedish_ci;

-- Dumping data for table works.company: ~0 rows (approximately)
DELETE FROM `company`;

-- Dumping structure for table works.job
DROP TABLE IF EXISTS `job`;
CREATE TABLE IF NOT EXISTS `job` (
  `job_id` uuid NOT NULL,
  `job_desc` varchar(2000) NOT NULL,
  `job_name` varchar(255) NOT NULL,
  `company` uuid DEFAULT NULL,
  PRIMARY KEY (`job_id`),
  KEY `FKbaqlvluu78phmo9ld89um7wnm` (`company`),
  CONSTRAINT `FKbaqlvluu78phmo9ld89um7wnm` FOREIGN KEY (`company`) REFERENCES `company` (`comp_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_swedish_ci;

-- Dumping data for table works.job: ~0 rows (approximately)
DELETE FROM `job`;

-- Dumping structure for table works.job_skill
DROP TABLE IF EXISTS `job_skill`;
CREATE TABLE IF NOT EXISTS `job_skill` (
  `more_infos` varchar(1000) DEFAULT NULL,
  `skill_level` tinyint(4) NOT NULL CHECK (`skill_level` between 0 and 2),
  `job_id` uuid NOT NULL,
  `skill_id` uuid NOT NULL,
  PRIMARY KEY (`job_id`,`skill_id`),
  KEY `FKj33qbbf3vk1lvhqpcosnh54u1` (`skill_id`),
  CONSTRAINT `FK9ix4wg520ii2gu2felxdhdup6` FOREIGN KEY (`job_id`) REFERENCES `job` (`job_id`),
  CONSTRAINT `FKj33qbbf3vk1lvhqpcosnh54u1` FOREIGN KEY (`skill_id`) REFERENCES `skill` (`skill_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_swedish_ci;

-- Dumping data for table works.job_skill: ~0 rows (approximately)
DELETE FROM `job_skill`;