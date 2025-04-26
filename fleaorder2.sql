/*
Navicat MySQL Data Transfer

Source Server         : Flea
Source Server Version : 50538
Source Host           : localhost:3306
Source Database       : fleaorder2

Target Server Type    : MYSQL
Target Server Version : 50538
File Encoding         : 65001

Date: 2022-03-17 15:51:22
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `old_order`
-- ----------------------------
DROP TABLE IF EXISTS `old_order`;
CREATE TABLE `old_order` (
  `order_id` int(11) NOT NULL COMMENT '订单编号',
  `order_name` varchar(255) DEFAULT NULL COMMENT '订单名称',
  `order_price` bigint(20) NOT NULL DEFAULT '0' COMMENT '订单价格（单位：分）',
  `order_date` datetime NOT NULL COMMENT '下单时间',
  `order_state` tinyint(4) NOT NULL DEFAULT '0' COMMENT '订单状态（0：初始 1：待支付 2：待发货 3：待收货 4：完结）',
  PRIMARY KEY (`order_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for `old_order_attr`
-- ----------------------------
DROP TABLE IF EXISTS `old_order_attr`;
CREATE TABLE `old_order_attr` (
  `attr_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '属性编号',
  `order_id` int(11) NOT NULL COMMENT '订单编号',
  `attr_code` varchar(50) NOT NULL COMMENT '属性码',
  `attr_value` varchar(3000) NOT NULL COMMENT '属性值',
  `create_date` date NOT NULL COMMENT '创建时间',
  `remarks` varchar(4000) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`attr_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for `order_1`
-- ----------------------------
DROP TABLE IF EXISTS `order_1`;
CREATE TABLE `order_1` (
  `order_id` int(11) NOT NULL COMMENT '订单编号',
  `order_name` varchar(255) DEFAULT NULL COMMENT '订单名称',
  `order_price` bigint(20) NOT NULL DEFAULT '0' COMMENT '订单价格（单位：分）',
  `order_date` datetime NOT NULL COMMENT '下单时间',
  `order_state` tinyint(4) NOT NULL DEFAULT '0' COMMENT '订单状态（0：初始 1：待支付 2：待发货 3：待收货 4：完结）',
  PRIMARY KEY (`order_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of order_1
-- ----------------------------

-- ----------------------------
-- Table structure for `order_3`
-- ----------------------------
DROP TABLE IF EXISTS `order_3`;
CREATE TABLE `order_3` (
  `order_id` int(11) NOT NULL COMMENT '订单编号',
  `order_name` varchar(255) DEFAULT NULL COMMENT '订单名称',
  `order_price` bigint(20) NOT NULL DEFAULT '0' COMMENT '订单价格（单位：分）',
  `order_date` datetime NOT NULL COMMENT '下单时间',
  `order_state` tinyint(4) NOT NULL DEFAULT '0' COMMENT '订单状态（0：初始 1：待支付 2：待发货 3：待收货 4：完结）',
  PRIMARY KEY (`order_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for `order_5`
-- ----------------------------
DROP TABLE IF EXISTS `order_5`;
CREATE TABLE `order_5` (
  `order_id` int(11) NOT NULL COMMENT '订单编号',
  `order_name` varchar(255) DEFAULT NULL COMMENT '订单名称',
  `order_price` bigint(20) NOT NULL DEFAULT '0' COMMENT '订单价格（单位：分）',
  `order_date` datetime NOT NULL COMMENT '下单时间',
  `order_state` tinyint(4) NOT NULL DEFAULT '0' COMMENT '订单状态（0：初始 1：待支付 2：待发货 3：待收货 4：完结）',
  PRIMARY KEY (`order_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of order_5
-- ----------------------------

-- ----------------------------
-- Table structure for `order_7`
-- ----------------------------
DROP TABLE IF EXISTS `order_7`;
CREATE TABLE `order_7` (
  `order_id` int(11) NOT NULL COMMENT '订单编号',
  `order_name` varchar(255) DEFAULT NULL COMMENT '订单名称',
  `order_price` bigint(20) NOT NULL DEFAULT '0' COMMENT '订单价格（单位：分）',
  `order_date` datetime NOT NULL COMMENT '下单时间',
  `order_state` tinyint(4) NOT NULL DEFAULT '0' COMMENT '订单状态（0：初始 1：待支付 2：待发货 3：待收货 4：完结）',
  PRIMARY KEY (`order_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of order_7
-- ----------------------------

-- ----------------------------
-- Table structure for `order_9`
-- ----------------------------
DROP TABLE IF EXISTS `order_9`;
CREATE TABLE `order_9` (
  `order_id` int(11) NOT NULL COMMENT '订单编号',
  `order_name` varchar(255) DEFAULT NULL COMMENT '订单名称',
  `order_price` bigint(20) NOT NULL DEFAULT '0' COMMENT '订单价格（单位：分）',
  `order_date` datetime NOT NULL COMMENT '下单时间',
  `order_state` tinyint(4) NOT NULL DEFAULT '0' COMMENT '订单状态（0：初始 1：待支付 2：待发货 3：待收货 4：完结）',
  PRIMARY KEY (`order_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of order_9
-- ----------------------------

-- ----------------------------
-- Table structure for `order_attr_1`
-- ----------------------------
DROP TABLE IF EXISTS `order_attr_1`;
CREATE TABLE `order_attr_1` (
  `attr_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '属性编号',
  `order_id` int(11) NOT NULL COMMENT '订单编号',
  `attr_code` varchar(50) NOT NULL COMMENT '属性码',
  `attr_value` varchar(3000) NOT NULL COMMENT '属性值',
  `create_date` datetime NOT NULL COMMENT '创建时间',
  `remarks` varchar(4000) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`attr_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of order_attr_1
-- ----------------------------

-- ----------------------------
-- Table structure for `order_attr_3`
-- ----------------------------
DROP TABLE IF EXISTS `order_attr_3`;
CREATE TABLE `order_attr_3` (
  `attr_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '属性编号',
  `order_id` int(11) NOT NULL COMMENT '订单编号',
  `attr_code` varchar(50) NOT NULL COMMENT '属性码',
  `attr_value` varchar(3000) NOT NULL COMMENT '属性值',
  `create_date` datetime NOT NULL COMMENT '创建时间',
  `remarks` varchar(4000) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`attr_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of order_attr_3
-- ----------------------------

-- ----------------------------
-- Table structure for `order_attr_5`
-- ----------------------------
DROP TABLE IF EXISTS `order_attr_5`;
CREATE TABLE `order_attr_5` (
  `attr_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '属性编号',
  `order_id` int(11) NOT NULL COMMENT '订单编号',
  `attr_code` varchar(50) NOT NULL COMMENT '属性码',
  `attr_value` varchar(3000) NOT NULL COMMENT '属性值',
  `create_date` datetime NOT NULL COMMENT '创建时间',
  `remarks` varchar(4000) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`attr_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of order_attr_5
-- ----------------------------

-- ----------------------------
-- Table structure for `order_attr_7`
-- ----------------------------
DROP TABLE IF EXISTS `order_attr_7`;
CREATE TABLE `order_attr_7` (
  `attr_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '属性编号',
  `order_id` int(11) NOT NULL COMMENT '订单编号',
  `attr_code` varchar(50) NOT NULL COMMENT '属性码',
  `attr_value` varchar(3000) NOT NULL COMMENT '属性值',
  `create_date` datetime NOT NULL COMMENT '创建时间',
  `remarks` varchar(4000) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`attr_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of order_attr_7
-- ----------------------------

-- ----------------------------
-- Table structure for `order_attr_9`
-- ----------------------------
DROP TABLE IF EXISTS `order_attr_9`;
CREATE TABLE `order_attr_9` (
  `attr_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '属性编号',
  `order_id` int(11) NOT NULL COMMENT '订单编号',
  `attr_code` varchar(50) NOT NULL COMMENT '属性码',
  `attr_value` varchar(3000) NOT NULL COMMENT '属性值',
  `create_date` datetime NOT NULL COMMENT '创建时间',
  `remarks` varchar(4000) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`attr_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of order_attr_9
-- ----------------------------
