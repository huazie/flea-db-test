/*
Navicat MySQL Data Transfer

Source Server         : Flea
Source Server Version : 50538
Source Host           : localhost:3306
Source Database       : fleaorder1

Target Server Type    : MYSQL
Target Server Version : 50538
File Encoding         : 65001

Date: 2022-03-17 15:51:16
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
-- Records of old_order
-- ----------------------------

-- ----------------------------
-- Table structure for `old_order_attr`
-- ----------------------------
DROP TABLE IF EXISTS `old_order_attr`;
CREATE TABLE `old_order_attr` (
  `attr_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '属性编号',
  `order_id` int(11) NOT NULL COMMENT '订单编号',
  `attr_code` varchar(50) NOT NULL COMMENT '属性码',
  `attr_value` varchar(3000) NOT NULL COMMENT '属性值',
  `create_date` datetime NOT NULL COMMENT '创建时间',
  `remarks` varchar(4000) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`attr_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of old_order_attr
-- ----------------------------

-- ----------------------------
-- Table structure for `order_0`
-- ----------------------------
DROP TABLE IF EXISTS `order_0`;
CREATE TABLE `order_0` (
  `order_id` int(11) NOT NULL COMMENT '订单编号',
  `order_name` varchar(255) DEFAULT NULL COMMENT '订单名称',
  `order_price` bigint(20) NOT NULL DEFAULT '0' COMMENT '订单价格（单位：分）',
  `order_date` datetime NOT NULL COMMENT '下单时间',
  `order_state` tinyint(4) NOT NULL DEFAULT '0' COMMENT '订单状态（0：初始 1：待支付 2：待发货 3：待收货 4：完结）',
  PRIMARY KEY (`order_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for `order_2`
-- ----------------------------
DROP TABLE IF EXISTS `order_2`;
CREATE TABLE `order_2` (
  `order_id` int(11) NOT NULL COMMENT '订单编号',
  `order_name` varchar(255) DEFAULT NULL COMMENT '订单名称',
  `order_price` bigint(20) NOT NULL DEFAULT '0' COMMENT '订单价格（单位：分）',
  `order_date` datetime NOT NULL COMMENT '下单时间',
  `order_state` tinyint(4) NOT NULL DEFAULT '0' COMMENT '订单状态（0：初始 1：待支付 2：待发货 3：待收货 4：完结）',
  PRIMARY KEY (`order_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of order_2
-- ----------------------------

-- ----------------------------
-- Table structure for `order_4`
-- ----------------------------
DROP TABLE IF EXISTS `order_4`;
CREATE TABLE `order_4` (
  `order_id` int(11) NOT NULL COMMENT '订单编号',
  `order_name` varchar(255) DEFAULT NULL COMMENT '订单名称',
  `order_price` bigint(20) NOT NULL DEFAULT '0' COMMENT '订单价格（单位：分）',
  `order_date` datetime NOT NULL COMMENT '下单时间',
  `order_state` tinyint(4) NOT NULL DEFAULT '0' COMMENT '订单状态（0：初始 1：待支付 2：待发货 3：待收货 4：完结）',
  PRIMARY KEY (`order_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of order_4
-- ----------------------------

-- ----------------------------
-- Table structure for `order_6`
-- ----------------------------
DROP TABLE IF EXISTS `order_6`;
CREATE TABLE `order_6` (
  `order_id` int(11) NOT NULL COMMENT '订单编号',
  `order_name` varchar(255) DEFAULT NULL COMMENT '订单名称',
  `order_price` bigint(20) NOT NULL DEFAULT '0' COMMENT '订单价格（单位：分）',
  `order_date` datetime NOT NULL COMMENT '下单时间',
  `order_state` tinyint(4) NOT NULL DEFAULT '0' COMMENT '订单状态（0：初始 1：待支付 2：待发货 3：待收货 4：完结）',
  PRIMARY KEY (`order_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of order_6
-- ----------------------------

-- ----------------------------
-- Table structure for `order_8`
-- ----------------------------
DROP TABLE IF EXISTS `order_8`;
CREATE TABLE `order_8` (
  `order_id` int(11) NOT NULL COMMENT '订单编号',
  `order_name` varchar(255) DEFAULT NULL COMMENT '订单名称',
  `order_price` bigint(20) NOT NULL DEFAULT '0' COMMENT '订单价格（单位：分）',
  `order_date` datetime NOT NULL COMMENT '下单时间',
  `order_state` tinyint(4) NOT NULL DEFAULT '0' COMMENT '订单状态（0：初始 1：待支付 2：待发货 3：待收货 4：完结）',
  PRIMARY KEY (`order_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of order_8
-- ----------------------------

-- ----------------------------
-- Table structure for `order_attr_0`
-- ----------------------------
DROP TABLE IF EXISTS `order_attr_0`;
CREATE TABLE `order_attr_0` (
  `attr_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '属性编号',
  `order_id` int(11) NOT NULL COMMENT '订单编号',
  `attr_code` varchar(50) NOT NULL COMMENT '属性码',
  `attr_value` varchar(3000) NOT NULL COMMENT '属性值',
  `create_date` datetime NOT NULL COMMENT '创建时间',
  `remarks` varchar(4000) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`attr_id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for `order_attr_2`
-- ----------------------------
DROP TABLE IF EXISTS `order_attr_2`;
CREATE TABLE `order_attr_2` (
  `attr_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '属性编号',
  `order_id` int(11) NOT NULL COMMENT '订单编号',
  `attr_code` varchar(50) NOT NULL COMMENT '属性码',
  `attr_value` varchar(3000) NOT NULL COMMENT '属性值',
  `create_date` datetime NOT NULL COMMENT '创建时间',
  `remarks` varchar(4000) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`attr_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of order_attr_2
-- ----------------------------

-- ----------------------------
-- Table structure for `order_attr_4`
-- ----------------------------
DROP TABLE IF EXISTS `order_attr_4`;
CREATE TABLE `order_attr_4` (
  `attr_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '属性编号',
  `order_id` int(11) NOT NULL COMMENT '订单编号',
  `attr_code` varchar(50) NOT NULL COMMENT '属性码',
  `attr_value` varchar(3000) NOT NULL COMMENT '属性值',
  `create_date` datetime NOT NULL COMMENT '创建时间',
  `remarks` varchar(4000) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`attr_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of order_attr_4
-- ----------------------------

-- ----------------------------
-- Table structure for `order_attr_6`
-- ----------------------------
DROP TABLE IF EXISTS `order_attr_6`;
CREATE TABLE `order_attr_6` (
  `attr_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '属性编号',
  `order_id` int(11) NOT NULL COMMENT '订单编号',
  `attr_code` varchar(50) NOT NULL COMMENT '属性码',
  `attr_value` varchar(3000) NOT NULL COMMENT '属性值',
  `create_date` datetime NOT NULL COMMENT '创建时间',
  `remarks` varchar(4000) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`attr_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of order_attr_6
-- ----------------------------

-- ----------------------------
-- Table structure for `order_attr_8`
-- ----------------------------
DROP TABLE IF EXISTS `order_attr_8`;
CREATE TABLE `order_attr_8` (
  `attr_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '属性编号',
  `order_id` int(11) NOT NULL COMMENT '订单编号',
  `attr_code` varchar(50) NOT NULL COMMENT '属性码',
  `attr_value` varchar(3000) NOT NULL COMMENT '属性值',
  `create_date` datetime NOT NULL COMMENT '创建时间',
  `remarks` varchar(4000) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`attr_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of order_attr_8
-- ----------------------------
