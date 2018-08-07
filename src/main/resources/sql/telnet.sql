/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50096
Source Host           : localhost:3306
Source Database       : telnet

Target Server Type    : MYSQL
Target Server Version : 50096
File Encoding         : 65001

Date: 2018-08-07 18:45:18
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for telnet_resource
-- ----------------------------
DROP TABLE IF EXISTS `telnet_resource`;
CREATE TABLE `telnet_resource` (
  `id` int(11) NOT NULL auto_increment,
  `name` varchar(255) default NULL,
  `parentid` int(255) default NULL,
  `url` varchar(255) default NULL,
  `icon` varchar(255) default NULL,
  `permission` varchar(255) default NULL,
  `create_time` datetime default NULL,
  `disabled` int(255) default NULL,
  `sort` int(255) default NULL,
  `type` int(255) default NULL,
  `ext1` varchar(255) default NULL,
  `ext2` varchar(255) default NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of telnet_resource
-- ----------------------------

-- ----------------------------
-- Table structure for telnet_role
-- ----------------------------
DROP TABLE IF EXISTS `telnet_role`;
CREATE TABLE `telnet_role` (
  `id` int(11) NOT NULL auto_increment,
  `name` varchar(255) default NULL,
  `create_time` datetime default NULL,
  `description` varchar(255) default NULL,
  `disabled` int(255) default NULL,
  `ext1` varchar(255) default NULL,
  `ext2` varchar(255) default NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of telnet_role
-- ----------------------------

-- ----------------------------
-- Table structure for telnet_role_resource
-- ----------------------------
DROP TABLE IF EXISTS `telnet_role_resource`;
CREATE TABLE `telnet_role_resource` (
  `id` int(11) NOT NULL,
  `roleid` int(11) default NULL,
  `resourceid` int(11) default NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of telnet_role_resource
-- ----------------------------

-- ----------------------------
-- Table structure for telnet_user
-- ----------------------------
DROP TABLE IF EXISTS `telnet_user`;
CREATE TABLE `telnet_user` (
  `id` int(11) NOT NULL auto_increment,
  `username` varchar(255) default NULL,
  `realname` varchar(255) default NULL,
  `password` varchar(255) default NULL,
  `phoneNumber` varchar(11) default NULL,
  `disabeld` varchar(255) default '0',
  `idNumber` varchar(20) default NULL,
  `create_time` datetime default NULL,
  `address` varchar(255) default NULL,
  `sex` varchar(255) default NULL,
  `ext1` varchar(255) default NULL,
  `ext2` varchar(255) default NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of telnet_user
-- ----------------------------
INSERT INTO `telnet_user` VALUES ('5', '脾气很好的钢铁侠', '周华生', '3M6L4UCL3A7UUSIPVHNMVDKU2L', '18256198871', '0', '340823199505315612', '2018-08-07 10:42:05', null, '1', null, null);

-- ----------------------------
-- Table structure for telnet_user_role
-- ----------------------------
DROP TABLE IF EXISTS `telnet_user_role`;
CREATE TABLE `telnet_user_role` (
  `id` int(11) NOT NULL auto_increment,
  `uid` int(11) default NULL,
  `rid` int(11) default NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of telnet_user_role
-- ----------------------------
INSERT INTO `telnet_user_role` VALUES ('5', null, '3');
