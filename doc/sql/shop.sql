/*
 Navicat Premium Data Transfer

 Source Server         : localhost
 Source Server Type    : MySQL
 Source Server Version : 80018
 Source Host           : localhost:3306
 Source Schema         : shop

 Target Server Type    : MySQL
 Target Server Version : 80018
 File Encoding         : 65001

 Date: 13/04/2020 11:47:48
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for sys_menu
-- ----------------------------
DROP TABLE IF EXISTS `sys_menu`;
CREATE TABLE `sys_menu`  (
  `id` int(5) NOT NULL AUTO_INCREMENT COMMENT '自增主键',
  `name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '菜单名',
  `ename` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '菜单英文名',
  `url` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '菜单URL',
  `icon` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '菜单图标',
  `parent_id` int(5) NOT NULL COMMENT '父菜单id',
  `create_time` datetime(0) NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` datetime(0) NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '更新时间',
  `del_flag` tinyint(1) NOT NULL DEFAULT 0 COMMENT '删除标识：0 未删除 1 已删除',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 8 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '菜单（权限）表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_menu
-- ----------------------------
INSERT INTO `sys_menu` VALUES (1, '用户管理', 'UserManagements', '', 'iconfont icon-user', 0, '2020-04-01 16:07:19', '2020-04-07 02:37:57', 0);
INSERT INTO `sys_menu` VALUES (2, '用户列表', 'UserList', '/users', 'el-icon-menu', 1, '2020-04-01 16:10:23', '2020-04-07 02:33:18', 0);
INSERT INTO `sys_menu` VALUES (3, '权限管理', 'PermissionManage', NULL, 'iconfont icon-tijikongjian', 0, '2020-04-01 16:13:45', '2020-04-07 02:38:13', 0);
INSERT INTO `sys_menu` VALUES (4, '角色列表', 'RoleList', '/roles', 'el-icon-menu', 3, '2020-04-01 16:14:44', '2020-04-07 02:33:18', 0);
INSERT INTO `sys_menu` VALUES (5, '菜单列表', 'MenuList', '/menus', 'el-icon-menu', 3, '2020-04-01 16:16:16', '2020-04-07 02:33:20', 0);
INSERT INTO `sys_menu` VALUES (6, '分配权限', 'AssignPermission', '/permission', 'el-icon-menu', 3, '2020-04-01 16:18:28', '2020-04-07 02:33:21', 0);

-- ----------------------------
-- Table structure for sys_role
-- ----------------------------
DROP TABLE IF EXISTS `sys_role`;
CREATE TABLE `sys_role`  (
  `id` int(5) NOT NULL AUTO_INCREMENT COMMENT '自增主键',
  `name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '角色名',
  `ename` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '角色英文名',
  `create_time` datetime(0) NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` datetime(0) NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '更新时间',
  `del_flag` tinyint(1) NOT NULL DEFAULT 0 COMMENT '删除标识：0 未删除 1 已删除',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 4 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '角色表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_role
-- ----------------------------
INSERT INTO `sys_role` VALUES (1, '管理员', 'admin', '2020-04-01 16:21:09', '2020-04-01 16:21:09', 0);
INSERT INTO `sys_role` VALUES (2, '开发者', 'development', '2020-04-01 16:21:51', '2020-04-01 16:21:51', 0);
INSERT INTO `sys_role` VALUES (3, '测试者', 'test', '2020-04-01 16:23:48', '2020-04-01 16:23:48', 0);
INSERT INTO `sys_role` VALUES (4, '访客', 'guester', '2020-04-01 23:40:22', '2020-04-01 23:48:39', 0);

-- ----------------------------
-- Table structure for sys_role_menu
-- ----------------------------
DROP TABLE IF EXISTS `sys_role_menu`;
CREATE TABLE `sys_role_menu`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '自增主键',
  `role_id` int(5) NOT NULL COMMENT '角色id',
  `menu_id` int(5) NOT NULL COMMENT '菜单id',
  `create_time` datetime(0) NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` datetime(0) NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '更新时间',
  `del_flag` tinyint(1) NOT NULL DEFAULT 0 COMMENT '删除标识：0 未删除 1 已删除',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 6 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '角色菜单（权限）关联表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_role_menu
-- ----------------------------
INSERT INTO `sys_role_menu` VALUES (1, 1, 1, '2020-04-01 16:23:07', '2020-04-01 16:23:07', 0);
INSERT INTO `sys_role_menu` VALUES (2, 1, 2, '2020-04-01 16:23:11', '2020-04-01 16:23:11', 0);
INSERT INTO `sys_role_menu` VALUES (3, 1, 3, '2020-04-01 16:23:14', '2020-04-01 16:23:14', 0);
INSERT INTO `sys_role_menu` VALUES (4, 1, 4, '2020-04-01 16:23:20', '2020-04-01 16:23:20', 0);
INSERT INTO `sys_role_menu` VALUES (5, 1, 5, '2020-04-01 16:23:31', '2020-04-01 16:23:31', 0);
INSERT INTO `sys_role_menu` VALUES (6, 1, 6, '2020-04-01 16:23:43', '2020-04-01 16:23:43', 0);

-- ----------------------------
-- Table structure for sys_user
-- ----------------------------
DROP TABLE IF EXISTS `sys_user`;
CREATE TABLE `sys_user`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '自增主键',
  `username` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '用户名',
  `password` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '密码',
  `create_time` datetime(0) NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` datetime(0) NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '更新时间',
  `del_flag` tinyint(1) NOT NULL DEFAULT 0 COMMENT '删除标识：0 未删除 1 已删除',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 8 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '用户表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_user
-- ----------------------------
INSERT INTO `sys_user` VALUES (1, 'admin', '{bcrypt}$2a$10$z3NpWIaH3vM7iZ.OP4CCv./M3.2S0Cfys5HpQx2SVTpiS3DVlcbmO', '2020-03-31 16:29:13', '2020-03-31 16:29:36', 0);
INSERT INTO `sys_user` VALUES (2, 'development', '{bcrypt}$2a$10$z3NpWIaH3vM7iZ.OP4CCv./M3.2S0Cfys5HpQx2SVTpiS3DVlcbmO', '2020-04-01 18:15:31', '2020-04-01 22:24:56', 0);
INSERT INTO `sys_user` VALUES (4, 'tester', '{bcrypt}$2a$10$ntfWGCWvFYy9w0acFX7NpOPAQFWUm.Z3Q68hQJRRcBPOgIDk7aKOy', '2020-04-01 22:29:15', '2020-04-01 23:37:16', 0);
INSERT INTO `sys_user` VALUES (5, 'manager', '{bcrypt}$2a$10$w3r5XCvRijNl6XhMlq3v5.iXbZ03qOwuWvlsJIEOqXjF3cGbG1V3S', '2020-04-08 01:51:22', '2020-04-08 01:51:22', 0);
INSERT INTO `sys_user` VALUES (6, 'costemer', '{bcrypt}$2a$10$g/vnqiB9UbXflBUX1R4Jx.LZdu0oT2MZ51.vtTlsrnA4LaXQbFjHi', '2020-04-08 01:52:20', '2020-04-08 01:52:20', 0);
INSERT INTO `sys_user` VALUES (7, 'sadsad', '{bcrypt}$2a$10$jQtkjQvJMBMkblGn1eHg3er4sPJ0grQKQJU05xjquBhJ36OjTXV0u', '2020-04-08 01:53:27', '2020-04-08 01:53:27', 0);
INSERT INTO `sys_user` VALUES (8, 'asdsad', '{bcrypt}$2a$10$gj/7veIdu7kYRSX8dkMtcOF1NFVoSkhJXWGLoNgxkmaH3qMJMCJo2', '2020-04-08 01:54:12', '2020-04-08 01:54:12', 0);

-- ----------------------------
-- Table structure for sys_user_role
-- ----------------------------
DROP TABLE IF EXISTS `sys_user_role`;
CREATE TABLE `sys_user_role`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '自增主键',
  `user_id` bigint(20) NOT NULL COMMENT '用户id',
  `role_id` int(5) NOT NULL COMMENT '角色id',
  `create_time` datetime(0) NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` datetime(0) NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '更新时间',
  `del_flag` tinyint(1) NOT NULL DEFAULT 0 COMMENT '删除标识：0 未删除 1 已删除',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '用户角色关联表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_user_role
-- ----------------------------
INSERT INTO `sys_user_role` VALUES (1, 1, 1, '2020-04-01 16:22:57', '2020-04-01 16:22:57', 0);

SET FOREIGN_KEY_CHECKS = 1;
