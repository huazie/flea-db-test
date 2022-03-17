/*
Navicat MySQL Data Transfer

Source Server         : Flea
Source Server Version : 50538
Source Host           : localhost:3306
Source Database       : fleajpatest

Target Server Type    : MYSQL
Target Server Version : 50538
File Encoding         : 65001

Date: 2022-03-17 15:49:23
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `student`
-- ----------------------------
DROP TABLE IF EXISTS `student`;
CREATE TABLE `student` (
  `stu_id` int(10) NOT NULL AUTO_INCREMENT COMMENT '学生编号',
  `stu_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL COMMENT '学生姓名',
  `stu_age` tinyint(4) NOT NULL COMMENT '学生年龄',
  `stu_sex` tinyint(2) NOT NULL COMMENT '学生性别（1：男 2：女）',
  `stu_state` tinyint(2) NOT NULL COMMENT '学生状态（0：删除 1：在用）',
  PRIMARY KEY (`stu_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
