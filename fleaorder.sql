/*
Navicat MySQL Data Transfer

Source Server         : Flea
Source Server Version : 50538
Source Host           : localhost:3306
Source Database       : fleaorder

Target Server Type    : MYSQL
Target Server Version : 50538
File Encoding         : 65001

Date: 2022-03-17 15:48:21
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `flea_id_generator`
-- ----------------------------
DROP TABLE IF EXISTS `flea_id_generator`;
CREATE TABLE `flea_id_generator` (
  `id_generator_key` varchar(50) NOT NULL COMMENT 'ID生成器的键【即主键生成策略的键值名称】',
  `id_generator_value` bigint(20) NOT NULL COMMENT 'ID生成器的值【即主键生成的值】',
  UNIQUE KEY `UNIQUE_KEY` (`id_generator_key`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of flea_id_generator
-- ----------------------------
INSERT INTO `flea_id_generator` VALUES ('pk_old_order', '999999999');
INSERT INTO `flea_id_generator` VALUES ('pk_order', '999999999');

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
-- Table structure for `order`
-- ----------------------------
DROP TABLE IF EXISTS `order`;
CREATE TABLE `order` (
  `order_id` int(11) NOT NULL COMMENT '订单编号',
  `order_name` varchar(255) DEFAULT NULL COMMENT '订单名称',
  `order_price` bigint(20) NOT NULL DEFAULT '0' COMMENT '订单价格（单位：分）',
  `order_date` datetime NOT NULL COMMENT '下单时间',
  `order_state` tinyint(4) NOT NULL DEFAULT '0' COMMENT '订单状态（0：初始 1：待支付 2：待发货 3：待收货 4：完结）',
  PRIMARY KEY (`order_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of order
-- ----------------------------

-- ----------------------------
-- Table structure for `order_attr`
-- ----------------------------
DROP TABLE IF EXISTS `order_attr`;
CREATE TABLE `order_attr` (
  `attr_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '属性编号',
  `order_id` int(11) NOT NULL COMMENT '订单编号',
  `attr_code` varchar(50) NOT NULL COMMENT '属性码',
  `attr_value` varchar(3000) NOT NULL COMMENT '属性值',
  `create_date` datetime NOT NULL COMMENT '创建时间',
  `remarks` varchar(4000) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`attr_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of order_attr
-- ----------------------------
