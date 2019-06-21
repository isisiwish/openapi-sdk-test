/*
 Navicat Premium Data Transfer

 Source Server         : 10.255.242.132-测试库
 Source Server Type    : MySQL
 Source Server Version : 50172
 Source Host           : 10.255.242.132:3306
 Source Schema         : AutoTestDB

 Target Server Type    : MySQL
 Target Server Version : 50172
 File Encoding         : 65001

 Date: 20/06/2019 21:09:16
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for open_api_sdk_test_case_id
-- ----------------------------
DROP TABLE IF EXISTS `open_api_sdk_test_case_id`;
CREATE TABLE `open_api_sdk_test_case_id`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `case_id` int(11) NULL DEFAULT NULL,
  `case_desc` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `ip` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `create_time` datetime NULL DEFAULT NULL,
  `update_time` datetime NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `unique_index_case_id`(`case_id`, `ip`) USING BTREE
) ENGINE = MyISAM AUTO_INCREMENT = 0 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for open_api_sdk_test_log
-- ----------------------------
DROP TABLE IF EXISTS `open_api_sdk_test_log`;
CREATE TABLE `open_api_sdk_test_log`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `method` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `ip` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `original_sdk` longtext CHARACTER SET utf8 COLLATE utf8_general_ci NULL,
  `original_yapi` longtext CHARACTER SET utf8 COLLATE utf8_general_ci NULL,
  `create_time` datetime NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = MyISAM AUTO_INCREMENT = 0 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

SET FOREIGN_KEY_CHECKS = 1;
