/*
 Navicat Premium Data Transfer

 Source Server         : 本地mysql
 Source Server Type    : MySQL
 Source Server Version : 50154
 Source Host           : localhost:3306
 Source Schema         : ssm

 Target Server Type    : MySQL
 Target Server Version : 50154
 File Encoding         : 65001

 Date: 28/08/2019 16:53:15
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for menu
-- ----------------------------
DROP TABLE IF EXISTS `menu`;
CREATE TABLE `menu`  (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `name` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `pid` int(10) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 8 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of menu
-- ----------------------------
INSERT INTO `menu` VALUES (1, '系统设置', 0);
INSERT INTO `menu` VALUES (2, '销售管理', 0);
INSERT INTO `menu` VALUES (3, '修改密码', 1);
INSERT INTO `menu` VALUES (4, '添加用户', 1);
INSERT INTO `menu` VALUES (5, '销售人员新增', 2);
INSERT INTO `menu` VALUES (6, '销售人员删除', 2);
INSERT INTO `menu` VALUES (7, '配置权限', 1);

SET FOREIGN_KEY_CHECKS = 1;
