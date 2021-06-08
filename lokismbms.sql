/*
 Navicat Premium Data Transfer

 Source Server         : loki
 Source Server Type    : MySQL
 Source Server Version : 80023
 Source Host           : localhost:3306
 Source Schema         : lokismbms

 Target Server Type    : MySQL
 Target Server Version : 80023
 File Encoding         : 65001

 Date: 09/06/2021 00:46:23
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for cart
-- ----------------------------
DROP TABLE IF EXISTS `cart`;
CREATE TABLE `cart`  (
  `Uid` int NOT NULL,
  `Gid` int NULL DEFAULT NULL
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of cart
-- ----------------------------
INSERT INTO `cart` VALUES (1, 2);
INSERT INTO `cart` VALUES (1, 15);
INSERT INTO `cart` VALUES (3, 1);
INSERT INTO `cart` VALUES (3, 2);
INSERT INTO `cart` VALUES (3, 15);

-- ----------------------------
-- Table structure for goods
-- ----------------------------
DROP TABLE IF EXISTS `goods`;
CREATE TABLE `goods`  (
  `Gid` int NOT NULL,
  `Gprice` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `Gname` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `Gurl` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `Glist_id` int NOT NULL,
  `Gdesc` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`Gid`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of goods
-- ----------------------------
INSERT INTO `goods` VALUES (1, '399.9', '迪卡侬7号篮球 ', 'http://pngimg.com/uploads/basketball/basketball_PNG1094.png', 1, '这款标准尺寸的7号球适合室内外使用，适用于13岁及以上男性.\r\n\r\n这款7号篮球适用于男孩和成人男性. 聚氨酯外壳，手感良好.FIBA认证版本有售.');
INSERT INTO `goods` VALUES (2, '39', 'Butterfly乒乓球', 'https://img14.360buyimg.com/n1/s546x546_jfs/t1/122208/5/12831/75677/5f631887Ea0a497a1/dc25f8a3a1926d45.jpg', 1, '正中品质乒乓球三星级比赛训练用球多球40+新料白色黄色ppq高弹耐打 萨达乒乓球-10个装-白色');
INSERT INTO `goods` VALUES (3, '749', 'adidas跑鞋', 'https://img.adidas.com.hk/resources/2021/4/28/1619610167842682_500X500.JPG', 2, '还没来得及写呢');
INSERT INTO `goods` VALUES (4, '499', '卡西欧运动手表', 'http://pngimg.com/uploads/watches/watches_PNG101453.png', 5, '还没来得及写呢');
INSERT INTO `goods` VALUES (5, '49', '李宁运动短袖', 'https://img14.360buyimg.com/n0/jfs/t1/21438/11/12424/107478/5c987840E1789c24b/33c28351c54543a6.jpg', 2, '还没来得及写呢');
INSERT INTO `goods` VALUES (6, '129', 'arena泳镜', 'https://img14.360buyimg.com/n0/jfs/t1/94692/21/12504/335890/5e494129Efd4d8649/704f3c1a233f7dda.jpg', 3, '还没来得及写呢');
INSERT INTO `goods` VALUES (7, '78', '李宁泳裤', 'https://img14.360buyimg.com/n0/jfs/t1/66805/9/5492/344674/5d397b5cE758d2c79/70ed518365db20f7.jpg', 3, '还没来得及写呢');
INSERT INTO `goods` VALUES (8, '1999', '华为智选跑步机', 'https://img14.360buyimg.com/n1/s546x546_jfs/t1/192752/28/4264/172244/60a68940Ea577c4e5/f7d20f19f8c32132.jpg', 2, '还没来得及写呢');
INSERT INTO `goods` VALUES (9, ' 3298', 'GoPro9', 'http://pngimg.com/uploads/gopro/gopro_PNG102046.png', 5, '还没来得及写呢');
INSERT INTO `goods` VALUES (10, '3499', 'DJI Pocket2', 'https://img14.360buyimg.com/n1/s546x546_jfs/t1/125577/6/18823/28999/5fb5f781E8461a8a8/d14ece3d93ec7e8b.jpg', 5, '还没来得及写呢');
INSERT INTO `goods` VALUES (11, '449', '锐步(Reebok)哑铃', 'https://img14.360buyimg.com/n1/s546x546_jfs/t1/115236/8/11103/149334/5ef95a3bE4d9d7c1d/be22564d431c635a.jpg', 4, '还没来得及写呢');
INSERT INTO `goods` VALUES (12, '158', '军哥7号篮球', 'https://img14.360buyimg.com/n0/jfs/t1/161210/36/1443/173789/5ff665f1E40fca477/e4d6196475dadfcd.jpg', 1, '室内室外篮球通用七号成人比赛训练篮球礼物 绿精灵白沟');
INSERT INTO `goods` VALUES (13, '268', 'CUPPa 斯诺克比赛用球', 'https://img14.360buyimg.com/n0/jfs/t9322/199/652518550/404452/4f9b1032/59acb179N2328ddde.jpg', 1, '比赛专用斯诺克球子 桌球水晶台球用品');
INSERT INTO `goods` VALUES (14, '14900', 'Kevin Deroo S1', 'https://img14.360buyimg.com/n0/jfs/t1/5811/14/621/74349/5b921efcEa673c3a1/2e40bc27af930cbf.jpg', 1, '加拿大迪鹿斯诺克Kevin Deroo S1全黑檀枫木斯诺克台球杆通小头水晶漆路');
INSERT INTO `goods` VALUES (15, '199', '世达（star）足球', 'https://img14.360buyimg.com/n0/jfs/t1/145853/24/13170/159236/5fa217c2Ecaebca83/7cbbe16afc666200.jpg', 1, '世达（star）SB375F 成人手缝训练足球足球 PU手缝足球 竞技用球 ( FIFA认证 ) 5号球');
INSERT INTO `goods` VALUES (16, '299', 'FIFA认证足球', 'https://img14.360buyimg.com/n0/jfs/t1/64227/25/9506/225027/5d721dd8E90ae49ca/19398d7b54e70b80.jpg', 1, 'Train火车头 FIFA认证足球 PU折边胶粘 标准5号比赛足球 火车FKS532');

-- ----------------------------
-- Table structure for goods_list
-- ----------------------------
DROP TABLE IF EXISTS `goods_list`;
CREATE TABLE `goods_list`  (
  `Lid` int NOT NULL,
  `Lname` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`Lid`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of goods_list
-- ----------------------------
INSERT INTO `goods_list` VALUES (1, '球类用品');
INSERT INTO `goods_list` VALUES (2, '跑步用品');
INSERT INTO `goods_list` VALUES (3, '游泳用品');
INSERT INTO `goods_list` VALUES (4, '健身用品');
INSERT INTO `goods_list` VALUES (5, '电子数码');

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`  (
  `Uid` int NOT NULL,
  `username` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `pwd` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `Uname` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  PRIMARY KEY (`Uid`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES (1, 'admin', '123456', '系统管理员');
INSERT INTO `user` VALUES (2, 'wangzhe', '123456', '王哲');
INSERT INTO `user` VALUES (3, '1', '1', '测试');

SET FOREIGN_KEY_CHECKS = 1;
