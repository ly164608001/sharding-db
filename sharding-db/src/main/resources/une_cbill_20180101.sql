/*
Navicat MySQL Data Transfer

Source Server         : 172.16.100.*
Source Server Version : 80018
Source Host           : localhost:3306
Source Database       : db0

Target Server Type    : MYSQL
Target Server Version : 80018
File Encoding         : 65001

Date: 2019-10-23 20:21:46
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for une_cbill_20180101
-- ----------------------------
DROP TABLE IF EXISTS `une_cbill_20180101`;
CREATE TABLE `une_cbill_20180101` (
  `id` bigint(20) NOT NULL,
  `agencode` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '单位编码',
  `date` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '日期',
  `no` varchar(10) DEFAULT NULL COMMENT '票号',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
SET FOREIGN_KEY_CHECKS=1;
