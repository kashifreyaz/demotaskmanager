create database testtaskmanager;

use testtaskmanager;

CREATE TABLE `priority` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `value` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


CREATE TABLE `label` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;



CREATE TABLE `task` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `status` int(11) DEFAULT NULL,
  `task_date` datetime DEFAULT NULL,
  `label_id` bigint(20) DEFAULT NULL,
  `priority_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKcvxhsvaa4b0eqvoknwdjoqb8e` (`label_id`),
  KEY `FK23pwolpebddlvnpucweas18g0` (`priority_id`),
  CONSTRAINT `FK23pwolpebddlvnpucweas18g0` FOREIGN KEY (`priority_id`) REFERENCES `priority` (`id`),
  CONSTRAINT `FKcvxhsvaa4b0eqvoknwdjoqb8e` FOREIGN KEY (`label_id`) REFERENCES `label` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
