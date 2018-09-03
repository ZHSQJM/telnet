/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50096
Source Host           : localhost:3306
Source Database       : telnet

Target Server Type    : MYSQL
Target Server Version : 50096
File Encoding         : 65001

Date: 2018-08-28 14:33:46
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for telnet_account
-- ----------------------------
DROP TABLE IF EXISTS `telnet_account`;
CREATE TABLE `telnet_account` (
  `id` int(11) NOT NULL auto_increment,
  `website` varchar(255) default NULL,
  `webname` varchar(255) default NULL,
  `username` varchar(255) default NULL,
  `nickname` varchar(255) default NULL,
  `phone` varchar(255) default NULL,
  `password` varchar(255) default NULL,
  `createtime` datetime default NULL,
  `updatetime` datetime default NULL,
  `userid` int(11) default NULL,
  `email` varchar(255) default NULL,
  `disabled` varchar(255) default NULL,
  `ext1` varchar(255) default NULL,
  `ext2` varchar(255) default NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of telnet_account
-- ----------------------------

-- ----------------------------
-- Table structure for telnet_image
-- ----------------------------
DROP TABLE IF EXISTS `telnet_image`;
CREATE TABLE `telnet_image` (
  `id` int(11) NOT NULL auto_increment,
  `userid` int(11) default NULL,
  `name` varchar(255) default NULL,
  `url` varchar(255) default NULL,
  `createtime` datetime default NULL,
  `updatetime` datetime default NULL,
  `disable` int(255) default NULL,
  `ext1` varchar(255) default NULL,
  `ext2` varchar(255) default NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of telnet_image
-- ----------------------------

-- ----------------------------
-- Table structure for telnet_loginlog
-- ----------------------------
DROP TABLE IF EXISTS `telnet_loginlog`;
CREATE TABLE `telnet_loginlog` (
  `id` int(11) NOT NULL auto_increment,
  `loginid` int(11) default NULL,
  `loginname` varchar(255) default NULL,
  `logintime` datetime default NULL,
  `loginip` varchar(255) default NULL,
  `ext1` varchar(255) default NULL,
  `ext2` varchar(255) default NULL,
  `disable` int(255) default NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of telnet_loginlog
-- ----------------------------

-- ----------------------------
-- Table structure for telnet_permission
-- ----------------------------
DROP TABLE IF EXISTS `telnet_permission`;
CREATE TABLE `telnet_permission` (
  `id` int(11) NOT NULL auto_increment,
  `name` varchar(255) default NULL COMMENT '资源名称',
  `icon` varchar(255) default NULL,
  `perms` varchar(255) default NULL,
  `resUrl` varchar(255) default NULL COMMENT '资源url',
  `type` int(11) default NULL COMMENT '资源类型   1:菜单    2：按钮',
  `parentId` int(11) default NULL COMMENT '父资源',
  `sort` int(11) default NULL COMMENT '排序',
  `createtime` datetime default NULL,
  `updatetime` datetime default NULL,
  `ext1` varchar(255) default NULL,
  `ext2` varchar(255) default NULL,
  `disable` int(255) default NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=40 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of telnet_permission
-- ----------------------------
INSERT INTO `telnet_permission` VALUES ('1', '系统设置', ' fe-settings', 'sys:sys', '#', '1', '0', '2', '2018-08-22 14:30:47', '2018-08-22 14:30:49', null, null, '0');
INSERT INTO `telnet_permission` VALUES ('2', '用户管理', null, 'sys:user', '/sys/userlist', '1', '1', '3', '2018-08-22 14:30:53', '2018-08-22 14:30:55', null, null, '0');
INSERT INTO `telnet_permission` VALUES ('3', '角色管理', null, 'sys:role', '/sys/rolelist', '1', '1', '4', '2018-08-22 14:30:47', '2018-08-22 14:30:47', null, null, '0');
INSERT INTO `telnet_permission` VALUES ('4', '资源管理', null, 'sys:per', '/sys/perlist', '1', '1', '5', '2018-08-22 14:30:47', '2018-08-22 14:30:47', null, null, '0');
INSERT INTO `telnet_permission` VALUES ('5', '添加用户', null, 'user:add', '/user/add', '2', '2', '6', '2018-08-22 14:30:47', '2018-08-22 14:30:47', null, null, '1');
INSERT INTO `telnet_permission` VALUES ('6', '删除用户', null, 'user:del', '/user/delete', '2', '2', '7', '2018-08-22 14:30:47', '2018-08-22 14:30:47', null, null, '0');
INSERT INTO `telnet_permission` VALUES ('7', '添加角色', null, 'role:add', '/role/add', '2', '3', '8', '2018-08-22 14:30:47', '2018-08-22 14:30:47', null, null, '0');
INSERT INTO `telnet_permission` VALUES ('8', '删除角色', null, 'role:del', '/role/delete', '2', '3', '9', '2018-08-22 14:30:47', '2018-08-22 14:30:47', null, null, '0');
INSERT INTO `telnet_permission` VALUES ('9', '添加资源', null, 'per:add', '/perm/add', '2', '4', '10', '2018-08-22 14:30:47', '2018-08-22 14:30:47', null, null, '0');
INSERT INTO `telnet_permission` VALUES ('10', '删除资源', null, 'per:del', '/perm/delete', '2', '4', '11', '2018-08-22 14:30:47', '2018-08-22 14:30:47', null, null, '0');
INSERT INTO `telnet_permission` VALUES ('11', '分配角色', null, 'per:role', '/users/saveUserRoles', '2', '2', '12', '2018-08-22 14:30:47', '2018-08-22 14:30:47', null, null, '0');
INSERT INTO `telnet_permission` VALUES ('12', '分配权限', null, 'role:saveper', '/role/saveRolePer', '2', '3', '13', '2018-08-22 14:30:47', '2018-08-22 14:30:47', null, null, '0');
INSERT INTO `telnet_permission` VALUES ('13', '账号管理', 'fe-bar-chart', 'self:acc', '/sys/acclist', '1', '0', '14', '2018-08-22 14:30:47', '2018-08-22 14:30:47', null, null, '0');
INSERT INTO `telnet_permission` VALUES ('14', '首页', ' fe-home', 'sys:ind', '/index', '1', '0', '1', '2018-08-22 14:30:47', '2018-08-22 14:30:47', null, null, '0');
INSERT INTO `telnet_permission` VALUES ('15', '查看用户角色', null, 'user:role', '/user/getRole', '2', '1', '15', '2018-08-22 14:30:47', '2018-08-22 14:30:47', null, null, '0');
INSERT INTO `telnet_permission` VALUES ('16', '获取用户信息', null, 'user:user', '/user/getUser', '2', '1', '16', '2018-08-22 14:30:47', '2018-08-22 14:30:47', null, null, '0');
INSERT INTO `telnet_permission` VALUES ('17', '更新用户', null, 'user:update', ' /user/update', '2', '1', '17', '2018-08-22 14:30:47', '2018-08-22 14:30:47', null, null, '0');
INSERT INTO `telnet_permission` VALUES ('18', '角色权限', null, 'role:per', '/role/permissions', '2', '1', '18', '2018-08-22 14:30:47', '2018-08-22 14:30:47', null, null, '0');
INSERT INTO `telnet_permission` VALUES ('19', '更新角色', null, 'role:update', '/role/update', '2', '3', '19', '2018-08-22 16:45:35', '2018-08-22 16:45:35', null, null, '0');
INSERT INTO `telnet_permission` VALUES ('20', '更新权限', null, 'per:update', '/perm/update', '2', '3', '20', '2018-08-22 17:09:30', '2018-08-22 17:09:32', null, null, '0');
INSERT INTO `telnet_permission` VALUES ('21', '加载左侧菜单', null, 'per:loadMenu', '/per/loadMenu', '2', '4', '21', '2018-08-22 17:14:49', '2018-08-22 17:14:51', null, null, '0');
INSERT INTO `telnet_permission` VALUES ('22', '账号管理', 'fe-bar-chart', 'self:useracc', '/sys/selflist', '1', '0', '22', '2018-08-23 08:06:47', '2018-08-23 08:06:50', null, null, '0');
INSERT INTO `telnet_permission` VALUES ('23', '账号添加', null, 'acc:add', '/account/add', '2', '22', '23', '2018-08-23 09:32:57', '2018-08-23 09:32:59', null, null, '0');
INSERT INTO `telnet_permission` VALUES ('24', '获取用户列表', null, 'user:list', '/user/getAllUsers', '2', '2', '24', '2018-08-23 15:25:35', '2018-08-23 15:25:38', null, null, '0');
INSERT INTO `telnet_permission` VALUES ('25', '获取角色列表', null, 'role:list', '/role/getAllRoles', '2', '3', '25', '2018-08-24 10:37:09', '2018-08-24 10:37:13', null, null, '0');
INSERT INTO `telnet_permission` VALUES ('26', '获取资源列表', null, 'per:list', '/perm/getAllPerms', '2', '4', '26', '2018-08-24 10:37:16', '2018-08-24 10:37:19', null, null, '0');
INSERT INTO `telnet_permission` VALUES ('27', '获取账号列表', null, 'acc:list', '/account/list', '2', '13', '27', '2018-08-24 10:37:22', '2018-08-24 10:37:24', null, null, '0');
INSERT INTO `telnet_permission` VALUES ('28', '根据用户查找用户的账号', null, 'acc:sel', '/account/userlist', '2', '22', '28', '2018-08-24 10:37:28', '2018-08-24 10:37:30', null, null, '0');
INSERT INTO `telnet_permission` VALUES ('29', '恢复角色', null, 'role:huifu', '/role/huifu', '2', '3', '29', '2018-08-24 16:38:16', '2018-08-24 16:38:18', null, null, '0');
INSERT INTO `telnet_permission` VALUES ('30', '首页访问量', null, 'index:page', '/index/pageview', '2', '14', '30', '2018-08-24 17:38:27', '2018-08-24 17:38:31', null, null, '0');
INSERT INTO `telnet_permission` VALUES ('31', 'PDF预览', null, 'pdf:look', 'pdf:list', '1', '0', '31', '2018-08-24 20:29:13', '2018-08-24 20:29:15', null, null, '0');
INSERT INTO `telnet_permission` VALUES ('32', '恢复用户', null, 'user:huifu', 'user/huifu', '2', '2', '32', '2018-08-27 11:22:41', '2018-08-27 11:22:43', null, null, '0');
INSERT INTO `telnet_permission` VALUES ('33', '图片管理', null, 'photo:list', '/sys/photo', '1', '0', '33', '2018-08-27 11:22:38', '2018-08-27 11:22:40', null, null, '0');
INSERT INTO `telnet_permission` VALUES ('34', '记事本', null, 'text:list', '/sys/text', '1', '0', '34', '2018-08-27 11:23:22', '2018-08-27 11:23:25', null, null, '0');
INSERT INTO `telnet_permission` VALUES ('35', '新增图片', null, 'photo:add', 'photo/add', '2', '33', '35', '2018-08-27 11:36:19', '2018-08-27 11:36:20', null, null, '0');
INSERT INTO `telnet_permission` VALUES ('36', '新增记事', null, 'text:add', '/text/add', '2', '34', '36', '2018-08-27 14:46:54', '2018-08-27 14:46:56', null, null, '0');
INSERT INTO `telnet_permission` VALUES ('37', '获取所有的记录', null, 'text:getall', '/text/getall', '2', '34', '37', '2018-08-27 15:22:59', '2018-08-27 15:23:01', null, null, '0');
INSERT INTO `telnet_permission` VALUES ('38', '删除记事本', null, 'text:del', '/text/del', '2', '34', '38', '2018-08-27 16:18:14', '2018-08-27 16:18:11', null, null, '0');
INSERT INTO `telnet_permission` VALUES ('39', '获取所有的用户，不分页', null, 'user:nolist', '/user/getall', '2', '2', '39', '2018-08-28 11:13:21', '2018-08-28 11:13:23', null, null, '0');

-- ----------------------------
-- Table structure for telnet_reqlog
-- ----------------------------
DROP TABLE IF EXISTS `telnet_reqlog`;
CREATE TABLE `telnet_reqlog` (
  `id` int(11) NOT NULL auto_increment,
  `requrl` varchar(255) default NULL,
  `way` varchar(255) default NULL,
  `method` varchar(255) default NULL,
  `code` varchar(255) default NULL,
  `time` bigint(20) default NULL,
  `username` varchar(255) default NULL,
  `ip` varchar(255) default NULL,
  `ext1` varchar(255) default NULL,
  `ext2` varchar(255) default NULL,
  `reqtime` datetime default NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of telnet_reqlog
-- ----------------------------

-- ----------------------------
-- Table structure for telnet_role
-- ----------------------------
DROP TABLE IF EXISTS `telnet_role`;
CREATE TABLE `telnet_role` (
  `id` int(11) NOT NULL auto_increment,
  `rolename` varchar(255) default NULL,
  `roledesc` varchar(255) default NULL,
  `createtime` datetime default NULL,
  `disable` int(255) default NULL,
  `updatetime` datetime default NULL,
  `ext1` varchar(255) default NULL,
  `ext2` varchar(255) default NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of telnet_role
-- ----------------------------
INSERT INTO `telnet_role` VALUES ('1', '超级管理员', '超级管理员', '2018-08-24 09:00:09', '0', '2018-08-24 09:00:18', null, null);
INSERT INTO `telnet_role` VALUES ('2', '普通用户', '普通用户', '2018-08-24 09:00:12', '0', '2018-08-24 09:00:21', null, null);
INSERT INTO `telnet_role` VALUES ('3', '管理员', '管理员11', '2018-08-24 09:00:15', '0', '2018-08-25 22:20:46', null, null);
INSERT INTO `telnet_role` VALUES ('4', '测试角色', '这是测试的一个角色，无权限', '2018-08-22 14:50:41', '0', '2018-08-25 21:33:50', null, null);

-- ----------------------------
-- Table structure for telnet_role_permission
-- ----------------------------
DROP TABLE IF EXISTS `telnet_role_permission`;
CREATE TABLE `telnet_role_permission` (
  `id` int(11) NOT NULL auto_increment,
  `roleId` int(11) NOT NULL,
  `disable` int(255) default NULL,
  `resourcesId` int(11) NOT NULL,
  `createtime` datetime default NULL,
  `updatetime` datetime default NULL,
  `ext1` varchar(255) default NULL,
  `ext2` varchar(255) default NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=49 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of telnet_role_permission
-- ----------------------------
INSERT INTO `telnet_role_permission` VALUES ('1', '1', '0', '1', null, null, null, null);
INSERT INTO `telnet_role_permission` VALUES ('2', '1', '0', '2', null, null, null, null);
INSERT INTO `telnet_role_permission` VALUES ('3', '1', '0', '3', null, null, null, null);
INSERT INTO `telnet_role_permission` VALUES ('4', '1', '0', '4', null, null, null, null);
INSERT INTO `telnet_role_permission` VALUES ('5', '1', '1', '5', null, null, null, null);
INSERT INTO `telnet_role_permission` VALUES ('6', '1', '0', '6', null, null, null, null);
INSERT INTO `telnet_role_permission` VALUES ('7', '1', '0', '7', null, null, null, null);
INSERT INTO `telnet_role_permission` VALUES ('8', '1', '0', '8', null, null, null, null);
INSERT INTO `telnet_role_permission` VALUES ('9', '1', '0', '9', null, null, null, null);
INSERT INTO `telnet_role_permission` VALUES ('10', '1', '0', '10', null, null, null, null);
INSERT INTO `telnet_role_permission` VALUES ('11', '1', '0', '11', null, null, null, null);
INSERT INTO `telnet_role_permission` VALUES ('12', '1', '0', '12', null, null, null, null);
INSERT INTO `telnet_role_permission` VALUES ('13', '1', '0', '13', null, null, null, null);
INSERT INTO `telnet_role_permission` VALUES ('14', '1', '0', '14', null, null, null, null);
INSERT INTO `telnet_role_permission` VALUES ('15', '1', '0', '15', null, null, null, null);
INSERT INTO `telnet_role_permission` VALUES ('16', '1', '0', '16', null, null, null, null);
INSERT INTO `telnet_role_permission` VALUES ('17', '1', '0', '17', null, null, null, null);
INSERT INTO `telnet_role_permission` VALUES ('18', '1', '0', '18', null, null, null, null);
INSERT INTO `telnet_role_permission` VALUES ('19', '1', '0', '19', null, null, null, null);
INSERT INTO `telnet_role_permission` VALUES ('20', '1', '0', '20', null, null, null, null);
INSERT INTO `telnet_role_permission` VALUES ('21', '1', '0', '21', null, null, null, null);
INSERT INTO `telnet_role_permission` VALUES ('22', '2', '0', '22', null, null, null, null);
INSERT INTO `telnet_role_permission` VALUES ('23', '2', '0', '14', null, null, null, null);
INSERT INTO `telnet_role_permission` VALUES ('24', '2', '0', '23', null, null, null, null);
INSERT INTO `telnet_role_permission` VALUES ('25', '1', '0', '23', null, null, null, null);
INSERT INTO `telnet_role_permission` VALUES ('26', '1', '0', '24', null, null, null, null);
INSERT INTO `telnet_role_permission` VALUES ('27', '1', '0', '25', null, null, null, null);
INSERT INTO `telnet_role_permission` VALUES ('28', '1', '0', '26', null, null, null, null);
INSERT INTO `telnet_role_permission` VALUES ('29', '1', '0', '27', null, null, null, null);
INSERT INTO `telnet_role_permission` VALUES ('30', '2', '0', '21', null, null, null, null);
INSERT INTO `telnet_role_permission` VALUES ('31', '2', '0', '28', null, null, null, null);
INSERT INTO `telnet_role_permission` VALUES ('32', '2', '1', '1', null, null, null, null);
INSERT INTO `telnet_role_permission` VALUES ('33', '1', '0', '29', null, null, null, null);
INSERT INTO `telnet_role_permission` VALUES ('34', '1', '0', '30', null, null, null, null);
INSERT INTO `telnet_role_permission` VALUES ('35', '1', '0', '32', null, null, null, null);
INSERT INTO `telnet_role_permission` VALUES ('36', '1', '0', '33', null, null, null, null);
INSERT INTO `telnet_role_permission` VALUES ('37', '1', '0', '34', null, null, null, null);
INSERT INTO `telnet_role_permission` VALUES ('38', '1', '0', '35', null, null, null, null);
INSERT INTO `telnet_role_permission` VALUES ('39', '1', '1', '31', null, null, null, null);
INSERT INTO `telnet_role_permission` VALUES ('40', '1', '0', '36', null, null, null, null);
INSERT INTO `telnet_role_permission` VALUES ('41', '1', '0', '37', null, null, null, null);
INSERT INTO `telnet_role_permission` VALUES ('42', '1', '0', '38', null, null, null, null);
INSERT INTO `telnet_role_permission` VALUES ('43', '2', '0', '36', null, null, null, null);
INSERT INTO `telnet_role_permission` VALUES ('44', '2', '0', '37', null, null, null, null);
INSERT INTO `telnet_role_permission` VALUES ('45', '2', '0', '38', null, null, null, null);
INSERT INTO `telnet_role_permission` VALUES ('46', '2', '0', '33', null, null, null, null);
INSERT INTO `telnet_role_permission` VALUES ('47', '2', '0', '34', null, null, null, null);
INSERT INTO `telnet_role_permission` VALUES ('48', '1', '0', '39', null, null, null, null);

-- ----------------------------
-- Table structure for telnet_text
-- ----------------------------
DROP TABLE IF EXISTS `telnet_text`;
CREATE TABLE `telnet_text` (
  `id` int(11) NOT NULL auto_increment,
  `createtime` varchar(255) default NULL,
  `text` text,
  `userid` int(11) NOT NULL,
  `ext1` varchar(255) default NULL,
  `ext2` varchar(255) default NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of telnet_text
-- ----------------------------
INSERT INTO `telnet_text` VALUES ('2', '2018-08-27', '123123133123123', '2', null, null);
INSERT INTO `telnet_text` VALUES ('3', '2018-08-28', '1：接入实验室\n2:上传页面接口\n3:接入运输车', '2', null, null);
INSERT INTO `telnet_text` VALUES ('5', '2018-08-28', '13213', '1', null, null);
INSERT INTO `telnet_text` VALUES ('6', '2018-08-28', '啊啊啊', '3', null, null);
INSERT INTO `telnet_text` VALUES ('7', '2018-08-27', '恶趣味111', '1', null, null);

-- ----------------------------
-- Table structure for telnet_user
-- ----------------------------
DROP TABLE IF EXISTS `telnet_user`;
CREATE TABLE `telnet_user` (
  `id` int(11) NOT NULL auto_increment,
  `username` varchar(33) default NULL,
  `password` varchar(33) default NULL,
  `enable` int(10) default '1' COMMENT '是否启用',
  `phone` varchar(255) default NULL,
  `idcard` varchar(255) default NULL,
  `realname` varchar(255) default NULL,
  `sex` int(255) default NULL,
  `salt` varchar(255) default NULL,
  `email` varchar(255) default NULL,
  `address` varchar(255) default NULL,
  `createtime` datetime default NULL,
  `updatetime` datetime default NULL,
  `ext1` varchar(255) default NULL,
  `ext2` varchar(255) default NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of telnet_user
-- ----------------------------

-- ----------------------------
-- Table structure for telnet_user_role
-- ----------------------------
DROP TABLE IF EXISTS `telnet_user_role`;
CREATE TABLE `telnet_user_role` (
  `id` int(11) NOT NULL auto_increment,
  `userId` int(11) default NULL,
  `disable` int(255) default NULL,
  `roleId` int(11) default NULL,
  `createtime` datetime default NULL,
  `updatetime` datetime default NULL,
  `ext1` varchar(255) default NULL,
  `ext2` varchar(255) default NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of telnet_user_role
-- ----------------------------
INSERT INTO `telnet_user_role` VALUES ('1', '1', '0', '1', null, null, null, null);
INSERT INTO `telnet_user_role` VALUES ('2', '2', '0', '2', null, null, null, null);
INSERT INTO `telnet_user_role` VALUES ('3', '3', '0', '2', '2018-08-23 21:07:16', '2018-08-23 21:07:18', null, null);

-- ----------------------------
-- Procedure structure for init_shiro_demo
-- ----------------------------
DROP PROCEDURE IF EXISTS `init_shiro_demo`;
DELIMITER ;;
CREATE DEFINER=`root`@`%` PROCEDURE `init_shiro_demo`()
BEGIN	
/*
SQLyog 企业版 - MySQL GUI v7.14 
MySQL - 5.6.16-log : Database - 
*********************************************************************
*/
/*表结构插入*/
DROP TABLE IF EXISTS `u_permission`;
CREATE TABLE `u_permission` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `url` varchar(256) DEFAULT NULL COMMENT 'url地址',
  `name` varchar(64) DEFAULT NULL COMMENT 'url描述',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=utf8;
/*Table structure for table `u_role` */
DROP TABLE IF EXISTS `u_role`;
CREATE TABLE `u_role` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(32) DEFAULT NULL COMMENT '角色名称',
  `type` varchar(10) DEFAULT NULL COMMENT '角色类型',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;
/*Table structure for table `u_role_permission` */
DROP TABLE IF EXISTS `u_role_permission`;
CREATE TABLE `u_role_permission` (
  `rid` bigint(20) DEFAULT NULL COMMENT '角色ID',
  `pid` bigint(20) DEFAULT NULL COMMENT '权限ID'
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*Table structure for table `u_user` */
DROP TABLE IF EXISTS `u_user`;
CREATE TABLE `u_user` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `nickname` varchar(20) DEFAULT NULL COMMENT '用户昵称',
  `email` varchar(128) DEFAULT NULL COMMENT '邮箱|登录帐号',
  `pswd` varchar(32) DEFAULT NULL COMMENT '密码',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `last_login_time` datetime DEFAULT NULL COMMENT '最后登录时间',
  `status` bigint(1) DEFAULT '1' COMMENT '1:有效，0:禁止登录',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8;
/*Table structure for table `u_user_role` */
DROP TABLE IF EXISTS `u_user_role`;
CREATE TABLE `u_user_role` (
  `uid` bigint(20) DEFAULT NULL COMMENT '用户ID',
  `rid` bigint(20) DEFAULT NULL COMMENT '角色ID'
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*
SQLyog 企业版 - MySQL GUI v7.14 
MySQL - 5.6.16-log : Database - i_wenyiba_com
*********************************************************************
*/
/*所有的表数据插入*/
/*Data for the table `u_permission` */
insert  into `u_permission`(`id`,`url`,`name`) values (4,'/permission/index.shtml','权限列表'),(6,'/permission/addPermission.shtml','权限添加'),(7,'/permission/deletePermissionById.shtml','权限删除'),(8,'/member/list.shtml','用户列表'),(9,'/member/online.shtml','在线用户'),(10,'/member/changeSessionStatus.shtml','用户Session踢出'),(11,'/member/forbidUserById.shtml','用户激活&禁止'),(12,'/member/deleteUserById.shtml','用户删除'),(13,'/permission/addPermission2Role.shtml','权限分配'),(14,'/role/clearRoleByUserIds.shtml','用户角色分配清空'),(15,'/role/addRole2User.shtml','角色分配保存'),(16,'/role/deleteRoleById.shtml','角色列表删除'),(17,'/role/addRole.shtml','角色列表添加'),(18,'/role/index.shtml','角色列表'),(19,'/permission/allocation.shtml','权限分配'),(20,'/role/allocation.shtml','角色分配');
/*Data for the table `u_role` */
insert  into `u_role`(`id`,`name`,`type`) values (1,'系统管理员','888888'),(3,'权限角色','100003'),(4,'用户中心','100002');
/*Data for the table `u_role_permission` */
insert  into `u_role_permission`(`rid`,`pid`) values (4,8),(4,9),(4,10),(4,11),(4,12),(3,4),(3,6),(3,7),(3,13),(3,14),(3,15),(3,16),(3,17),(3,18),(3,19),(3,20),(1,4),(1,6),(1,7),(1,8),(1,9),(1,10),(1,11),(1,12),(1,13),(1,14),(1,15),(1,16),(1,17),(1,18),(1,19),(1,20);
/*Data for the table `u_user` */
insert  into `u_user`(`id`,`nickname`,`email`,`pswd`,`create_time`,`last_login_time`,`status`) values (1,'管理员','admin','9c3250081c7b1f5c6cbb8096e3e1cd04','2016-06-16 11:15:33','2016-06-16 11:24:10',1),(11,'soso','8446666@qq.com','d57ffbe486910dd5b26d0167d034f9ad','2016-05-26 20:50:54','2016-06-16 11:24:35',1),(12,'8446666','8446666','4afdc875a67a55528c224ce088be2ab8','2016-05-27 22:34:19','2016-06-15 17:03:16',1);
/*Data for the table `u_user_role` */
insert  into `u_user_role`(`uid`,`rid`) values (12,4),(11,3),(11,4),(1,1);
   
    END
;;
DELIMITER ;
