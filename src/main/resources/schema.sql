

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for Groups
-- ----------------------------
DROP TABLE IF EXISTS `Groups`;
CREATE TABLE `Groups` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `name` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `doamin` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

-- ----------------------------
-- Records of Groups
-- ----------------------------
BEGIN;
INSERT INTO `Groups` VALUES (1, 'rh1', 'a1.rh.co');
INSERT INTO `Groups` VALUES (2, 'rh2', 'a2.rh.co');
INSERT INTO `Groups` VALUES (3, 'rh3', 'a3.rh.co');
COMMIT;

SET FOREIGN_KEY_CHECKS = 1;
