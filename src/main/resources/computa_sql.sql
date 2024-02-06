/*
 Navicat Premium Data Transfer

 Source Server         : local_mariadb
 Source Server Type    : MariaDB
 Source Server Version : 110102
 Source Host           : localhost:3306
 Source Schema         : computa_git

 Target Server Type    : MariaDB
 Target Server Version : 110102
 File Encoding         : 65001

 Date: 06/02/2024 14:33:40
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

CREATE DATABASE computa_test;
USE computa_test;

-- ----------------------------
-- Table structure for cpu
-- ----------------------------
DROP TABLE IF EXISTS `cpu`;
CREATE TABLE `cpu`  (
  `l2` int(11) NULL DEFAULT NULL,
  `l3` int(11) NULL DEFAULT NULL,
  `pcie` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `basic_clock` int(11) NULL DEFAULT NULL,
  `cal_sys` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `cooler` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `cores` int(11) NULL DEFAULT NULL,
  `factory` int(11) NULL DEFAULT NULL,
  `gen` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `gpu` bit(1) NULL DEFAULT NULL,
  `gpu_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `gpu_speed` int(11) NULL DEFAULT NULL,
  `kinds` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `max_clock` int(11) NULL DEFAULT NULL,
  `mem_ch` int(11) NULL DEFAULT NULL,
  `mem_clock` int(11) NULL DEFAULT NULL,
  `mem_size` int(11) NULL DEFAULT NULL,
  `package_form` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `reldate` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `socket` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `threads` int(11) NULL DEFAULT NULL,
  `id` bigint(20) NOT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  CONSTRAINT `FKhjvorea8fb1lfyck60aq56vo5` FOREIGN KEY (`id`) REFERENCES `product` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of cpu
-- ----------------------------

-- ----------------------------
-- Table structure for gpu
-- ----------------------------
DROP TABLE IF EXISTS `gpu`;
CREATE TABLE `gpu`  (
  `hdcp` bit(1) NULL DEFAULT NULL,
  `hdr` bit(1) NULL DEFAULT NULL,
  `chip_company` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `chipset` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `disp4k` bit(1) NULL DEFAULT NULL,
  `disp8k` bit(1) NULL DEFAULT NULL,
  `displayport` int(11) NULL DEFAULT NULL,
  `fancooler` bit(1) NULL DEFAULT NULL,
  `fancount` int(11) NULL DEFAULT NULL,
  `heatpipe` bit(1) NULL DEFAULT NULL,
  `interface_gpu` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `kinds` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `kudaprocess` int(11) NULL DEFAULT NULL,
  `max_moniter` int(11) NULL DEFAULT NULL,
  `maxpower` int(11) NULL DEFAULT NULL,
  `mem_bus` int(11) NULL DEFAULT NULL,
  `mem_kind` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `mem_size` int(11) NULL DEFAULT NULL,
  `protectheat` bit(1) NULL DEFAULT NULL,
  `vram` int(11) NULL DEFAULT NULL,
  `width` int(11) NULL DEFAULT NULL,
  `zerofan` bit(1) NULL DEFAULT NULL,
  `id` bigint(20) NOT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  CONSTRAINT `FKd1s9c36icv8t7qicpoq81uqnw` FOREIGN KEY (`id`) REFERENCES `product` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of gpu
-- ----------------------------

-- ----------------------------
-- Table structure for hdd
-- ----------------------------
DROP TABLE IF EXISTS `hdd`;
CREATE TABLE `hdd`  (
  `buffersize` double NULL DEFAULT NULL,
  `diskformsize` double NULL DEFAULT NULL,
  `disksize` double NULL DEFAULT NULL,
  `hddinterface` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `kinds` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `record` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `rotatecount` double NULL DEFAULT NULL,
  `sendspeed` double NULL DEFAULT NULL,
  `sound` double NULL DEFAULT NULL,
  `thick` double NULL DEFAULT NULL,
  `id` bigint(20) NOT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  CONSTRAINT `FKegpixo5fq4kw5sk6oliha2jmu` FOREIGN KEY (`id`) REFERENCES `product` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of hdd
-- ----------------------------

-- ----------------------------
-- Table structure for motherboard
-- ----------------------------
DROP TABLE IF EXISTS `motherboard`;
CREATE TABLE `motherboard`  (
  `backusb2` bit(1) NULL DEFAULT NULL,
  `backusb3` bit(1) NULL DEFAULT NULL,
  `dp` bit(1) NULL DEFAULT NULL,
  `d-sub` bit(1) NULL DEFAULT NULL,
  `dvi` bit(1) NULL DEFAULT NULL,
  `hdmi` bit(1) NULL DEFAULT NULL,
  `lan_chip` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `lan_speed` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `m2` bit(1) NULL DEFAULT NULL,
  `m2count` int(11) NULL DEFAULT NULL,
  `m2form2242` bit(1) NULL DEFAULT NULL,
  `m2form2260` bit(1) NULL DEFAULT NULL,
  `m2form2280` bit(1) NULL DEFAULT NULL,
  `nvme` bit(1) NULL DEFAULT NULL,
  `pci` bit(1) NULL DEFAULT NULL,
  `pcislot` int(11) NULL DEFAULT NULL,
  `pcie` bit(1) NULL DEFAULT NULL,
  `pcie3` bit(1) NULL DEFAULT NULL,
  `pcie4` bit(1) NULL DEFAULT NULL,
  `pciex1` int(11) NULL DEFAULT NULL,
  `pciex16` int(11) NULL DEFAULT NULL,
  `rj45` bit(1) NULL DEFAULT NULL,
  `rj45count` int(11) NULL DEFAULT NULL,
  `sata` bit(1) NULL DEFAULT NULL,
  `sata3` bit(1) NULL DEFAULT NULL,
  `sata3count` int(11) NULL DEFAULT NULL,
  `usb2` int(11) NULL DEFAULT NULL,
  `usb3` int(11) NULL DEFAULT NULL,
  `vga` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `audiochipset` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `back_audio` bit(1) NULL DEFAULT NULL,
  `chipset` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `cpu_count` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `form_factor` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `kinds` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `mem_chan` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `mem_kind` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `mem_max` int(11) NULL DEFAULT NULL,
  `mem_slots` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `mem_speed` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `socket` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `id` bigint(20) NOT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  CONSTRAINT `FK426q3lkgc49elfrqh30ywmq7j` FOREIGN KEY (`id`) REFERENCES `product` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of motherboard
-- ----------------------------

-- ----------------------------
-- Table structure for pc_case
-- ----------------------------
DROP TABLE IF EXISTS `pc_case`;
CREATE TABLE `pc_case`  (
  `ledfan` int(11) NULL DEFAULT NULL,
  `usb` bit(1) NULL DEFAULT NULL,
  `usb3` bit(1) NULL DEFAULT NULL,
  `backsize` double NULL DEFAULT NULL,
  `basic_atx` bit(1) NULL DEFAULT NULL,
  `bay6` int(11) NULL DEFAULT NULL,
  `bay8` int(11) NULL DEFAULT NULL,
  `coolfan` int(11) NULL DEFAULT NULL,
  `depth` double NULL DEFAULT NULL,
  `form_factor` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `frontpan` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `frontsize` double NULL DEFAULT NULL,
  `kinds` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `micro_atx` bit(1) NULL DEFAULT NULL,
  `mini-itx` bit(1) NULL DEFAULT NULL,
  `power` bit(1) NULL DEFAULT NULL,
  `saver` int(11) NULL DEFAULT NULL,
  `sidepan` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `size` int(11) NULL DEFAULT NULL,
  `upsize` double NULL DEFAULT NULL,
  `width` double NULL DEFAULT NULL,
  `id` bigint(20) NOT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  CONSTRAINT `FK7c563g3s8f9468ryg28n6wy2j` FOREIGN KEY (`id`) REFERENCES `product` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of pc_case
-- ----------------------------

-- ----------------------------
-- Table structure for pc_power
-- ----------------------------
DROP TABLE IF EXISTS `pc_power`;
CREATE TABLE `pc_power`  (
  `dc12` double NULL DEFAULT NULL,
  `dc12m` double NULL DEFAULT NULL,
  `dc3` double NULL DEFAULT NULL,
  `dc5` double NULL DEFAULT NULL,
  `dc5sb` double NULL DEFAULT NULL,
  `ide4` int(11) NULL DEFAULT NULL,
  `pci8` int(11) NULL DEFAULT NULL,
  `pfc` double NULL DEFAULT NULL,
  `sata` int(11) NULL DEFAULT NULL,
  `sata3` int(11) NULL DEFAULT NULL,
  `barring` int(11) NULL DEFAULT NULL,
  `cable` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `capacity12v` double NULL DEFAULT NULL,
  `cooling_count` int(11) NULL DEFAULT NULL,
  `depth` double NULL DEFAULT NULL,
  `kind` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `mainpower` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `output12v` double NULL DEFAULT NULL,
  `plus80` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `rated` double NULL DEFAULT NULL,
  `subpower` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `id` bigint(20) NOT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  CONSTRAINT `FKmvacnpputx2ot9ssg0tk5ndmg` FOREIGN KEY (`id`) REFERENCES `product` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of pc_power
-- ----------------------------

-- ----------------------------
-- Table structure for product
-- ----------------------------
DROP TABLE IF EXISTS `product`;
CREATE TABLE `product`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `company` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `detail` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `fullname` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `price` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `product_type` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of product
-- ----------------------------

-- ----------------------------
-- Table structure for product_comment_images
-- ----------------------------
DROP TABLE IF EXISTS `product_comment_images`;
CREATE TABLE `product_comment_images`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `url` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `product_comment_id` bigint(20) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `FKilaqmmnf9wab39p7br120fpoa`(`product_comment_id`) USING BTREE,
  CONSTRAINT `FKilaqmmnf9wab39p7br120fpoa` FOREIGN KEY (`product_comment_id`) REFERENCES `product_comments` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of product_comment_images
-- ----------------------------

-- ----------------------------
-- Table structure for product_comments
-- ----------------------------
DROP TABLE IF EXISTS `product_comments`;
CREATE TABLE `product_comments`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `content` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `created_date` datetime(6) NULL DEFAULT NULL,
  `parent_id` bigint(20) NULL DEFAULT NULL,
  `product_id` bigint(20) NULL DEFAULT NULL,
  `user_id` bigint(20) NOT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `FKdh0yrg2ww5acujtot2cc0pulg`(`parent_id`) USING BTREE,
  INDEX `FKh4dk46lpqxf9ctll1py5qpuw7`(`product_id`) USING BTREE,
  INDEX `FKgl4kke0pjaht09vx7wilce0n0`(`user_id`) USING BTREE,
  CONSTRAINT `FKdh0yrg2ww5acujtot2cc0pulg` FOREIGN KEY (`parent_id`) REFERENCES `product_comments` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `FKgl4kke0pjaht09vx7wilce0n0` FOREIGN KEY (`user_id`) REFERENCES `users` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `FKh4dk46lpqxf9ctll1py5qpuw7` FOREIGN KEY (`product_id`) REFERENCES `product` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of product_comments
-- ----------------------------

-- ----------------------------
-- Table structure for product_images
-- ----------------------------
DROP TABLE IF EXISTS `product_images`;
CREATE TABLE `product_images`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `url` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `product_id` bigint(20) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `FKi8jnqq05sk5nkma3pfp3ylqrt`(`product_id`) USING BTREE,
  CONSTRAINT `FKi8jnqq05sk5nkma3pfp3ylqrt` FOREIGN KEY (`product_id`) REFERENCES `product` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of product_images
-- ----------------------------

-- ----------------------------
-- Table structure for qna_comment
-- ----------------------------
DROP TABLE IF EXISTS `qna_comment`;
CREATE TABLE `qna_comment`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `content` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `parent_id` bigint(20) NULL DEFAULT NULL,
  `created_date` datetime(6) NULL DEFAULT NULL,
  `updated_date` datetime(6) NULL DEFAULT NULL,
  `user_id` bigint(20) NULL DEFAULT NULL,
  `seq` bigint(20) NOT NULL,
  `level` int(11) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `FKnxl9910gubwx88wtq7ceqg15p`(`parent_id`) USING BTREE,
  INDEX `FKsxtysvilnwgolq9kb7ahkk27s`(`user_id`) USING BTREE,
  INDEX `FK2k6xrmq04d493q60yotq25e1w`(`seq`) USING BTREE,
  CONSTRAINT `FKnxl9910gubwx88wtq7ceqg15p` FOREIGN KEY (`parent_id`) REFERENCES `qna_comment` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `FKsxtysvilnwgolq9kb7ahkk27s` FOREIGN KEY (`user_id`) REFERENCES `users` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `FK2k6xrmq04d493q60yotq25e1w` FOREIGN KEY (`seq`) REFERENCES `qnalist` (`seq`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 32 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of qna_comment
-- ----------------------------
INSERT INTO `qna_comment` VALUES (24, 'Test', NULL, '2024-02-06 13:27:52.540000', '2024-02-06 13:27:52.540000', 2, 2, 0);
INSERT INTO `qna_comment` VALUES (25, 'reply to test', 24, '2024-02-06 13:28:02.534000', '2024-02-06 13:28:02.534000', 2, 2, 1);
INSERT INTO `qna_comment` VALUES (26, 'parent comment 2', NULL, '2024-02-06 13:32:16.234000', '2024-02-06 13:32:16.234000', 2, 2, 0);
INSERT INTO `qna_comment` VALUES (27, 'reply to parent comment 2', 26, '2024-02-06 13:32:47.782000', '2024-02-06 13:32:47.782000', 2, 2, 1);
INSERT INTO `qna_comment` VALUES (28, 'reply to test parent comment', 24, '2024-02-06 13:33:05.517000', '2024-02-06 13:33:05.517000', 2, 2, 1);
INSERT INTO `qna_comment` VALUES (29, 'test', NULL, '2024-02-06 13:45:44.272000', '2024-02-06 13:45:44.272000', 2, 2, 0);
INSERT INTO `qna_comment` VALUES (30, 'reply to test\'s test', 25, '2024-02-06 14:06:42.260000', '2024-02-06 14:06:42.260000', 2, 2, 2);
INSERT INTO `qna_comment` VALUES (31, 'test', NULL, '2024-02-06 14:07:08.507000', '2024-02-06 14:07:08.507000', 2, 2, 0);

-- ----------------------------
-- Table structure for qnalist
-- ----------------------------
DROP TABLE IF EXISTS `qnalist`;
CREATE TABLE `qnalist`  (
  `seq` bigint(20) NOT NULL AUTO_INCREMENT,
  `cnt` bigint(20) NULL DEFAULT 0,
  `content` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `create_date` date NULL DEFAULT current_timestamp,
  `file_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `qna_lev` bigint(20) NULL DEFAULT NULL,
  `qna_ref` bigint(20) NULL DEFAULT NULL,
  `qna_seq` bigint(20) NULL DEFAULT NULL,
  `title` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `writer` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  PRIMARY KEY (`seq`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 3 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of qnalist
-- ----------------------------
INSERT INTO `qnalist` VALUES (2, 0, '123123', '2024-02-06', NULL, 0, 2, 0, '1111111', 'user01');

-- ----------------------------
-- Table structure for ram
-- ----------------------------
DROP TABLE IF EXISTS `ram`;
CREATE TABLE `ram`  (
  `clock` double NULL DEFAULT NULL,
  `kind` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `mem_form` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `mem_size` double NULL DEFAULT NULL,
  `module_type` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `rams` int(11) NULL DEFAULT NULL,
  `id` bigint(20) NOT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  CONSTRAINT `FK8esh81pbxnajqa2a7uscu2kqx` FOREIGN KEY (`id`) REFERENCES `product` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of ram
-- ----------------------------

-- ----------------------------
-- Table structure for roles
-- ----------------------------
DROP TABLE IF EXISTS `roles`;
CREATE TABLE `roles`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `UK_ofx66keruapi6vyqpv6f2or37`(`name`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of roles
-- ----------------------------
INSERT INTO `roles` VALUES (1, 'ROLE_USER');

-- ----------------------------
-- Table structure for ssd
-- ----------------------------
DROP TABLE IF EXISTS `ssd`;
CREATE TABLE `ssd`  (
  `formfactor` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `kind` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `mem_type` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `nand` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `ram` bit(1) NULL DEFAULT NULL,
  `size` double NULL DEFAULT NULL,
  `ssd_interface` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `id` bigint(20) NOT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  CONSTRAINT `FK7ihxio9vbg9ma2hhpb1ny3d4k` FOREIGN KEY (`id`) REFERENCES `product` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of ssd
-- ----------------------------

-- ----------------------------
-- Table structure for used_product_images
-- ----------------------------
DROP TABLE IF EXISTS `used_product_images`;
CREATE TABLE `used_product_images`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `url` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `used_product_id` bigint(20) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `FKofwue6ltwr10ouiidbsw1wi0w`(`used_product_id`) USING BTREE,
  CONSTRAINT `FKofwue6ltwr10ouiidbsw1wi0w` FOREIGN KEY (`used_product_id`) REFERENCES `usedproduct` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of used_product_images
-- ----------------------------

-- ----------------------------
-- Table structure for used_product_list
-- ----------------------------
DROP TABLE IF EXISTS `used_product_list`;
CREATE TABLE `used_product_list`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `used_product_id` bigint(20) NOT NULL,
  `user_id` bigint(20) NOT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `FKt4c1bb166uo8b34eqlaa9a0s7`(`used_product_id`) USING BTREE,
  INDEX `FK1vy99csre7mu4hwx1ku191l21`(`user_id`) USING BTREE,
  CONSTRAINT `FK1vy99csre7mu4hwx1ku191l21` FOREIGN KEY (`user_id`) REFERENCES `users` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `FKt4c1bb166uo8b34eqlaa9a0s7` FOREIGN KEY (`used_product_id`) REFERENCES `product` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of used_product_list
-- ----------------------------

-- ----------------------------
-- Table structure for usedproduct
-- ----------------------------
DROP TABLE IF EXISTS `usedproduct`;
CREATE TABLE `usedproduct`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `item_detail` tinytext CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `item_name` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `item_sell_status` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `price` int(11) NOT NULL,
  `reg_date_time` datetime(6) NOT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of usedproduct
-- ----------------------------

-- ----------------------------
-- Table structure for users
-- ----------------------------
DROP TABLE IF EXISTS `users`;
CREATE TABLE `users`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `email` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `nickname` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `password` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `phone` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `ssid` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `username` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `reportcount` int(11) NOT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `UK_6dotkott2kjsp8vw4d0m25fb7`(`email`) USING BTREE,
  UNIQUE INDEX `UK_2ty1xmrrgtn89xt7kyxx6ta7h`(`nickname`) USING BTREE,
  UNIQUE INDEX `UK_r43af9ap4edm43mmtq01oddj6`(`username`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 3 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of users
-- ----------------------------
INSERT INTO `users` VALUES (1, 'abc@test.com', 'abc', 'abc', '$2a$10$Q7TpP6McSbeF0N2bvVWwUupZIIxh/23j.A8hCLh60N8PV8gY2g1pK', '01012341234', '111111-1111111', 'abc', 0);
INSERT INTO `users` VALUES (2, 'user01@test.com', 'aaa', 'user01', '$2a$10$UyIY3MfJXL512V.zyGevKepxAdM.YdO.qetTdejAcgvnjXQJFcrGK', '11111111111', '123123-1231231', 'user01', 0);

-- ----------------------------
-- Table structure for users_roles
-- ----------------------------
DROP TABLE IF EXISTS `users_roles`;
CREATE TABLE `users_roles`  (
  `user_id` bigint(20) NOT NULL,
  `role_id` bigint(20) NOT NULL,
  INDEX `FKj6m8fwv7oqv74fcehir1a9ffy`(`role_id`) USING BTREE,
  INDEX `FK2o0jvgh89lemvvo17cbqvdxaa`(`user_id`) USING BTREE,
  CONSTRAINT `FK2o0jvgh89lemvvo17cbqvdxaa` FOREIGN KEY (`user_id`) REFERENCES `users` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `FKj6m8fwv7oqv74fcehir1a9ffy` FOREIGN KEY (`role_id`) REFERENCES `roles` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of users_roles
-- ----------------------------
INSERT INTO `users_roles` VALUES (1, 1);
INSERT INTO `users_roles` VALUES (2, 1);

-- ----------------------------
-- Table structure for wishlist
-- ----------------------------
DROP TABLE IF EXISTS `wishlist`;
CREATE TABLE `wishlist`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `product_id` bigint(20) NOT NULL,
  `user_id` bigint(20) NOT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `FKqchevbfw5wq0f4uqacns02rp7`(`product_id`) USING BTREE,
  INDEX `FKtrd6335blsefl2gxpb8lr0gr7`(`user_id`) USING BTREE,
  CONSTRAINT `FKqchevbfw5wq0f4uqacns02rp7` FOREIGN KEY (`product_id`) REFERENCES `product` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `FKtrd6335blsefl2gxpb8lr0gr7` FOREIGN KEY (`user_id`) REFERENCES `users` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of wishlist
-- ----------------------------

SET FOREIGN_KEY_CHECKS = 1;
