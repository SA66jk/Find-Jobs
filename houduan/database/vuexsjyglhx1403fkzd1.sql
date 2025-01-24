/*
Navicat MySQL Data Transfer

Source Server         : localhost_3307
Source Server Version : 50562
Source Host           : localhost:3307
Source Database       : vuexsjyglhx1403fkzd1

Target Server Type    : MYSQL
Target Server Version : 50562
File Encoding         : 65001

Date: 2024-12-06 23:44:35
*/

SET FOREIGN_KEY_CHECKS=0;
-- ----------------------------
-- Table structure for `bianhuantu`
-- ----------------------------
DROP TABLE IF EXISTS `bianhuantu`;
CREATE TABLE `bianhuantu` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `mingcheng` varchar(50) DEFAULT NULL,
  `tupian` varchar(50) DEFAULT NULL,
  `addtime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=gb2312;

-- ----------------------------
-- Records of bianhuantu
-- ----------------------------
INSERT INTO `bianhuantu` VALUES ('2', 'Cname', '/files/download/93', '2024-12-06 13:39:17');
INSERT INTO `bianhuantu` VALUES ('3', 'Nname', '/files/download/48', '2024-12-06 13:39:17');
INSERT INTO `bianhuantu` VALUES ('4', 'Qname', '/files/download/94', '2024-12-06 13:39:17');

-- ----------------------------
-- Table structure for `collect`
-- ----------------------------
DROP TABLE IF EXISTS `collect`;
CREATE TABLE `collect` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) DEFAULT NULL,
  `shangpinxinxiID` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=27 DEFAULT CHARSET=latin1 ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of collect
-- ----------------------------
INSERT INTO `collect` VALUES ('22', '11', '3');
INSERT INTO `collect` VALUES ('24', '11', '4');
INSERT INTO `collect` VALUES ('26', '11', '2');

-- ----------------------------
-- Table structure for `file`
-- ----------------------------
DROP TABLE IF EXISTS `file`;
CREATE TABLE `file` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `originName` varchar(255) DEFAULT NULL,
  `fileName` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=95 DEFAULT CHARSET=gb2312;

-- ----------------------------
-- Records of file
-- ----------------------------
INSERT INTO `file` VALUES ('1', 'bht1.jpg', 'bht1.jpg');
INSERT INTO `file` VALUES ('2', 'bht2.jpg', 'bht2.jpg');
INSERT INTO `file` VALUES ('3', 'bht3.jpg', 'bht3.jpg');
INSERT INTO `file` VALUES ('4', 'bht4.jpg', 'bht4.jpg');
INSERT INTO `file` VALUES ('5', 'bht5.jpg', 'bht5.jpg');
INSERT INTO `file` VALUES ('6', 'qiyexinxi1.jpg', 'qiyexinxi1.jpg');
INSERT INTO `file` VALUES ('7', 'qiyexinxi2.jpg', 'qiyexinxi2.jpg');
INSERT INTO `file` VALUES ('8', 'qiyexinxi3.jpg', 'qiyexinxi3.jpg');
INSERT INTO `file` VALUES ('9', 'qiyexinxi4.jpg', 'qiyexinxi4.jpg');
INSERT INTO `file` VALUES ('10', 'qiyexinxi5.jpg', 'qiyexinxi5.jpg');
INSERT INTO `file` VALUES ('11', 'qiyexinxi6.jpg', 'qiyexinxi6.jpg');
INSERT INTO `file` VALUES ('12', 'qiyexinxi7.jpg', 'qiyexinxi7.jpg');
INSERT INTO `file` VALUES ('13', 'qiyexinxi8.jpg', 'qiyexinxi8.jpg');
INSERT INTO `file` VALUES ('14', 'qiyexinxi9.jpg', 'qiyexinxi9.jpg');
INSERT INTO `file` VALUES ('15', 'qiyexinxi10.jpg', 'qiyexinxi10.jpg');
INSERT INTO `file` VALUES ('16', 'yonghuxinxi1.jpg', 'yonghuxinxi1.jpg');
INSERT INTO `file` VALUES ('17', 'yonghuxinxi2.jpg', 'yonghuxinxi2.jpg');
INSERT INTO `file` VALUES ('18', 'yonghuxinxi3.jpg', 'yonghuxinxi3.jpg');
INSERT INTO `file` VALUES ('19', 'yonghuxinxi4.jpg', 'yonghuxinxi4.jpg');
INSERT INTO `file` VALUES ('20', 'yonghuxinxi5.jpg', 'yonghuxinxi5.jpg');
INSERT INTO `file` VALUES ('21', 'yonghuxinxi6.jpg', 'yonghuxinxi6.jpg');
INSERT INTO `file` VALUES ('22', 'yonghuxinxi7.jpg', 'yonghuxinxi7.jpg');
INSERT INTO `file` VALUES ('23', 'yonghuxinxi8.jpg', 'yonghuxinxi8.jpg');
INSERT INTO `file` VALUES ('24', 'yonghuxinxi9.jpg', 'yonghuxinxi9.jpg');
INSERT INTO `file` VALUES ('25', 'yonghuxinxi10.jpg', 'yonghuxinxi10.jpg');
INSERT INTO `file` VALUES ('26', 'gangweixinxi1.jpg', 'gangweixinxi1.jpg');
INSERT INTO `file` VALUES ('27', 'gangweixinxi2.jpg', 'gangweixinxi2.jpg');
INSERT INTO `file` VALUES ('28', 'gangweixinxi3.jpg', 'gangweixinxi3.jpg');
INSERT INTO `file` VALUES ('29', 'gangweixinxi4.jpg', 'gangweixinxi4.jpg');
INSERT INTO `file` VALUES ('30', 'gangweixinxi5.jpg', 'gangweixinxi5.jpg');
INSERT INTO `file` VALUES ('31', 'gangweixinxi6.jpg', 'gangweixinxi6.jpg');
INSERT INTO `file` VALUES ('32', 'gangweixinxi7.jpg', 'gangweixinxi7.jpg');
INSERT INTO `file` VALUES ('33', 'gangweixinxi8.jpg', 'gangweixinxi8.jpg');
INSERT INTO `file` VALUES ('34', 'gangweixinxi9.jpg', 'gangweixinxi9.jpg');
INSERT INTO `file` VALUES ('35', 'gangweixinxi10.jpg', 'gangweixinxi10.jpg');
INSERT INTO `file` VALUES ('36', 'jianlixinxi1.jpg', 'jianlixinxi1.jpg');
INSERT INTO `file` VALUES ('37', 'jianlixinxi2.jpg', 'jianlixinxi2.jpg');
INSERT INTO `file` VALUES ('38', 'jianlixinxi3.jpg', 'jianlixinxi3.jpg');
INSERT INTO `file` VALUES ('39', 'jianlixinxi4.jpg', 'jianlixinxi4.jpg');
INSERT INTO `file` VALUES ('40', 'jianlixinxi5.jpg', 'jianlixinxi5.jpg');
INSERT INTO `file` VALUES ('41', 'jianlixinxi6.jpg', 'jianlixinxi6.jpg');
INSERT INTO `file` VALUES ('42', 'jianlixinxi7.jpg', 'jianlixinxi7.jpg');
INSERT INTO `file` VALUES ('43', 'jianlixinxi8.jpg', 'jianlixinxi8.jpg');
INSERT INTO `file` VALUES ('44', 'jianlixinxi9.jpg', 'jianlixinxi9.jpg');
INSERT INTO `file` VALUES ('45', 'jianlixinxi10.jpg', 'jianlixinxi10.jpg');
INSERT INTO `file` VALUES ('46', '25f547eb7e3a5e851c9cd859fb6e706f.jpg', '25f547eb7e3a5e851c9cd859fb6e706f1711088991091.jpg');
INSERT INTO `file` VALUES ('47', '350.jpg', '3501711088996658.jpg');
INSERT INTO `file` VALUES ('48', 'R-C (3).jpg', 'R-C (3)1711089000809.jpg');
INSERT INTO `file` VALUES ('49', 'R-C (4).jpg', 'R-C (4)1711089009799.jpg');
INSERT INTO `file` VALUES ('50', '1.jpg', '11711089023067.jpg');
INSERT INTO `file` VALUES ('51', '1BEAA53E-B0EB-3FB7-DCE8-B3D66A5D6771.jpg', '1BEAA53E-B0EB-3FB7-DCE8-B3D66A5D67711711089051415.jpg');
INSERT INTO `file` VALUES ('52', 'R-C (1).jpg', 'R-C (1)1711089055715.jpg');
INSERT INTO `file` VALUES ('53', 'R-C (2).jpg', 'R-C (2)1711089059726.jpg');
INSERT INTO `file` VALUES ('54', 'R-C (3).jpg', 'R-C (3)1711089063349.jpg');
INSERT INTO `file` VALUES ('55', 'R-C.jpg', 'R-C1711089066538.jpg');
INSERT INTO `file` VALUES ('56', '1.jpg', '11711089092755.jpg');
INSERT INTO `file` VALUES ('57', '2.jpg', '21711089097036.jpg');
INSERT INTO `file` VALUES ('58', '32970343_091921272129_2.jpg', '32970343_091921272129_21711089104545.jpg');
INSERT INTO `file` VALUES ('59', '32970343_093203285129_2.jpg', '32970343_093203285129_21711089107928.jpg');
INSERT INTO `file` VALUES ('60', 'R-C.jpg', 'R-C1711089118050.jpg');
INSERT INTO `file` VALUES ('61', '1BEAA53E-B0EB-3FB7-DCE8-B3D66A5D6771.jpg', '1BEAA53E-B0EB-3FB7-DCE8-B3D66A5D67711711089158624.jpg');
INSERT INTO `file` VALUES ('62', 'R-C (1).jpg', 'R-C (1)1711089162935.jpg');
INSERT INTO `file` VALUES ('63', 'R-C (2).jpg', 'R-C (2)1711089167111.jpg');
INSERT INTO `file` VALUES ('64', 'R-C (3).jpg', 'R-C (3)1711089170709.jpg');
INSERT INTO `file` VALUES ('65', 'R-C.jpg', 'R-C1711089174845.jpg');
INSERT INTO `file` VALUES ('66', 'R-C (2).jpg', 'R-C (2)1711089299864.jpg');
INSERT INTO `file` VALUES ('67', 'be295b4c2b54ed98e5f7d92b441ac227.jpg', 'be295b4c2b54ed98e5f7d92b441ac2271711089306021.jpg');
INSERT INTO `file` VALUES ('68', 'ed616c42c606555032c63e518e95e6b1.jpg', 'ed616c42c606555032c63e518e95e6b11711089312607.jpg');
INSERT INTO `file` VALUES ('69', 'ed616c42c606555032c63e518e95e6b1.jpg', 'ed616c42c606555032c63e518e95e6b11711089322772.jpg');
INSERT INTO `file` VALUES ('70', 'R-C (2).jpg', 'R-C (2)1711089329387.jpg');
INSERT INTO `file` VALUES ('71', 'R-C (3).jpg', 'R-C (3)1711089334410.jpg');
INSERT INTO `file` VALUES ('72', 'true.jpg', 'true1711089339319.jpg');
INSERT INTO `file` VALUES ('73', 'R-C (2).jpg', 'R-C (2)1711089345090.jpg');
INSERT INTO `file` VALUES ('74', 'R-C (3).jpg', 'R-C (3)1711089350730.jpg');
INSERT INTO `file` VALUES ('75', 'R-C (2).jpg', 'R-C (2)1711089357370.jpg');
INSERT INTO `file` VALUES ('76', '11.zip', '111711090328365.zip');
INSERT INTO `file` VALUES ('77', '11.zip', '111711094423889.zip');
INSERT INTO `file` VALUES ('78', '11.zip', '111711094427967.zip');
INSERT INTO `file` VALUES ('79', '11.zip', '111711094431665.zip');
INSERT INTO `file` VALUES ('80', '11.zip', '111711094436954.zip');
INSERT INTO `file` VALUES ('81', '11.zip', '111711094441928.zip');
INSERT INTO `file` VALUES ('82', '11.zip', '111711094531689.zip');
INSERT INTO `file` VALUES ('83', 'CvyGsGUPh6.jpg', 'CvyGsGUPh61711605576480.jpg');
INSERT INTO `file` VALUES ('84', 'R-C (1).jpg', 'R-C (1)1711605600838.jpg');
INSERT INTO `file` VALUES ('85', 'OIP-C (2).jpg', 'OIP-C (2)1711605606280.jpg');
INSERT INTO `file` VALUES ('86', '11.zip', '111711606175828.zip');
INSERT INTO `file` VALUES ('87', '1.jpg', '11711607913123.jpg');
INSERT INTO `file` VALUES ('88', 'R-C (3).jpg', 'R-C (3)1711607916891.jpg');
INSERT INTO `file` VALUES ('89', '350.jpg', '3501711607918851.jpg');
INSERT INTO `file` VALUES ('90', '3.jpg', '31733463897530.jpg');
INSERT INTO `file` VALUES ('91', '3.jpg', '31733464403923.jpg');
INSERT INTO `file` VALUES ('92', '5.jpg', '51733464443741.jpg');
INSERT INTO `file` VALUES ('93', 'bg.jpg', 'bg1733498982778.jpg');
INSERT INTO `file` VALUES ('94', '21.jpg', '211733498992612.jpg');

-- ----------------------------
-- Table structure for `gangweixinxi`
-- ----------------------------
DROP TABLE IF EXISTS `gangweixinxi`;
CREATE TABLE `gangweixinxi` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `gangweimingcheng` varchar(50) DEFAULT NULL,
  `gongzuodidian` varchar(50) DEFAULT NULL,
  `gongzuoshijian` varchar(50) DEFAULT NULL,
  `xuqiurenshu` varchar(50) DEFAULT NULL,
  `xinzi` varchar(50) DEFAULT NULL,
  `gangweimiaoshu` varchar(500) DEFAULT NULL,
  `tupian` varchar(50) DEFAULT NULL,
  `qiyehao` varchar(50) DEFAULT NULL,
  `qiyemingcheng` varchar(50) DEFAULT NULL,
  `fuzeren` varchar(50) DEFAULT NULL,
  `lianxidianhua` varchar(50) DEFAULT NULL,
  `addtime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=gb2312;

-- ----------------------------
-- Records of gangweixinxi
-- ----------------------------
INSERT INTO `gangweixinxi` VALUES ('2', 'Cashier', '139 Hebin East Road', '2024-4-7', '49', '3200', '1', '/files/download/66', '016', 'Miss Limited', '026', '13544655202', '2024-12-06 13:39:42');
INSERT INTO `gangweixinxi` VALUES ('3', 'nurse', '27 Fuxing Street', '2024-4-10', '16', '3500', '', '/files/download/67', '005', 'Jointown Pharmaceutical Group Co., Ltd', '017', '13910215489', '2024-12-06 13:39:42');
INSERT INTO `gangweixinxi` VALUES ('4', 'programmer', '22 Taixing Road', '2024-4-15', '14', '4000', '', '/files/download/68', '013', 'Jointown Pharmaceutical Group Co., Ltd', '003', '18759640002', '2024-12-06 13:39:42');
INSERT INTO `gangweixinxi` VALUES ('5', 'teacher', '99 Dongcheng Road', '2024-4-18', '16', '3300', '', '/files/download/69', '020', 'Jointown Pharmaceutical Group Co., Ltd', '007', '13052154877', '2024-12-06 13:39:42');
INSERT INTO `gangweixinxi` VALUES ('6', 'Salesman', 'Room 201, Building 11, Fangcheng Liyuan', '2024-4-7', '55', '2500', '', '/files/download/70', '011', 'Miss Limited', '002', '13769548711', '2024-12-06 13:39:42');
INSERT INTO `gangweixinxi` VALUES ('7', 'doctor', '73 Jiefang Road', '2024-4-7', '65', '3000', '', '/files/download/71', '033', 'Cangnan Instrument Co., Ltd', '022', '17505772420', '2024-12-06 13:39:42');
INSERT INTO `gangweixinxi` VALUES ('8', 'guide', '22 Kaiming Road', '2024-3-1', '65', '5000', '', '/files/download/72', '001', 'Cangnan Instrument Co., Ltd', '019', '13623256544', '2024-12-06 13:39:42');

-- ----------------------------
-- Table structure for `guanliyuan`
-- ----------------------------
DROP TABLE IF EXISTS `guanliyuan`;
CREATE TABLE `guanliyuan` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `yonghuming` varchar(50) DEFAULT NULL,
  `mima` varchar(50) DEFAULT NULL,
  `status` varchar(10) DEFAULT '0',
  `level` varchar(10) DEFAULT '管理员',
  `addtime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=gb2312;

-- ----------------------------
-- Records of guanliyuan
-- ----------------------------
INSERT INTO `guanliyuan` VALUES ('1', 'admin', '21232f297a57a5a743894a0e4a801fc3', '0', '管理员', '2024-12-06 13:39:52');

-- ----------------------------
-- Table structure for `jianlitoudi`
-- ----------------------------
DROP TABLE IF EXISTS `jianlitoudi`;
CREATE TABLE `jianlitoudi` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `gangweimingcheng` varchar(50) DEFAULT NULL,
  `gongzuoshijian` varchar(50) DEFAULT NULL,
  `qiyehao` varchar(50) DEFAULT NULL,
  `qiyemingcheng` varchar(50) DEFAULT NULL,
  `fuzeren` varchar(50) DEFAULT NULL,
  `yonghuming` varchar(50) DEFAULT NULL,
  `xingming` varchar(50) DEFAULT NULL,
  `shouji` varchar(50) DEFAULT NULL,
  `jianliwenjian` varchar(50) DEFAULT NULL,
  `issh` varchar(100) DEFAULT 'Awaiting review',
  `shhf` varchar(200) DEFAULT NULL,
  `addtime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=gb2312;

-- ----------------------------
-- Records of jianlitoudi
-- ----------------------------
INSERT INTO `jianlitoudi` VALUES ('2', 'compere', '2024-4-2', '001', 'Miss Limited', '001', '001', 'Chen Guibai', '17706641413', '/files/download/76', 'Passed', 'The interview was successful', '2024-12-06 13:39:58');
INSERT INTO `jianlitoudi` VALUES ('3', 'nurse', '2024-4-10', '005', 'Jointown Pharmaceutical Group Co., L', '017', '001', 'Chen Guibai', '17706641413', '/files/download/82', 'Passed', 'sadasd', '2024-12-06 13:39:58');
INSERT INTO `jianlitoudi` VALUES ('4', 'programmer', '2024-4-15', '013', '九Miss Limited', '003', '001', 'Chen Guibai', '17706641413', '/files/download/86', 'Passed', 'Let\'s get an interview', '2024-12-06 13:39:58');
INSERT INTO `jianlitoudi` VALUES ('6', 'programmer', '2024-4-15', '013', 'Miss Limited', '003', '001', 'Chen Guibai', '17706641413', null, 'Noreviewed', null, '2024-12-06 13:39:58');
INSERT INTO `jianlitoudi` VALUES ('7', 'Cashier', '2024-4-7', '016', 'Cangnan Instrument Co., Ltd', '026', '001', 'Chen Guibai', '17706641413', '/files/download/90', 'reviewed', null, '2024-12-06 13:44:58');
INSERT INTO `jianlitoudi` VALUES ('8', 'Cashier', '2024-4-7', '016', 'Cangnan Instrument Co., Ltd', '026', '001', 'Chen Guibai', '17706641413', '/files/download/91', 'reviewed', null, '2024-12-06 13:53:24');

-- ----------------------------
-- Table structure for `jianlixinxi`
-- ----------------------------
DROP TABLE IF EXISTS `jianlixinxi`;
CREATE TABLE `jianlixinxi` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `jianlibianhao` varchar(50) DEFAULT NULL,
  `xingming` varchar(50) DEFAULT NULL,
  `xingbie` varchar(50) DEFAULT NULL,
  `shouji` varchar(50) DEFAULT NULL,
  `zhuanye` varchar(50) DEFAULT NULL,
  `zhaopian` varchar(50) DEFAULT NULL,
  `gerenjianjie` varchar(500) DEFAULT NULL,
  `yonghuming` varchar(50) DEFAULT NULL,
  `wenjian` varchar(50) DEFAULT NULL,
  `addtime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=gb2312;

-- ----------------------------
-- Records of jianlixinxi
-- ----------------------------
INSERT INTO `jianlixinxi` VALUES ('3', '322231305199622', 'Huang Xingyang', '0', '13748589658', 'literature', '/files/download/62', 'No problem', '008', '/files/download/77', '2024-12-06 13:40:03');
INSERT INTO `jianlixinxi` VALUES ('4', '322232617293855', 'Harden', '1', '13159863241', 'pedagogy', '/files/download/64', 'not', '003', '/files/download/78', '2024-12-06 13:40:03');
INSERT INTO `jianlixinxi` VALUES ('5', '322233694888820', 'Si Xiance', '1', '13623256544', 'jurisprudence', '/files/download/61', 'not', '016', '/files/download/79', '2024-12-06 13:40:03');
INSERT INTO `jianlixinxi` VALUES ('7', '322234342873581', 'Yu Shaoqing', '1', '13587835380', 'engineering', '/files/download/63', 'No problem', '005', '/files/download/80', '2024-12-06 13:40:03');
INSERT INTO `jianlixinxi` VALUES ('11', '322231639697880', 'Luhan', '1', '13910215489', 'Military science', '/files/download/65', 'No problem', '001', '/files/download/81', '2024-12-06 13:40:03');

-- ----------------------------
-- Table structure for `liuyanban`
-- ----------------------------
DROP TABLE IF EXISTS `liuyanban`;
CREATE TABLE `liuyanban` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `yonghuming` varchar(50) DEFAULT NULL,
  `cheng` varchar(50) DEFAULT NULL,
  `touxiang` varchar(50) DEFAULT NULL,
  `biaoti` varchar(50) DEFAULT NULL,
  `neirong` varchar(500) DEFAULT NULL,
  `huifu` varchar(500) DEFAULT NULL,
  `status` varchar(10) DEFAULT '0',
  `addtime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `parent` int(11) DEFAULT '0',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=40 DEFAULT CHARSET=utf8mb4 ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of liuyanban
-- ----------------------------

-- ----------------------------
-- Table structure for `pinglun`
-- ----------------------------
DROP TABLE IF EXISTS `pinglun`;
CREATE TABLE `pinglun` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `pinglunneirong` varchar(500) DEFAULT NULL,
  `pingfen` varchar(50) DEFAULT NULL,
  `biao` varchar(50) DEFAULT NULL,
  `pinglunren` varchar(50) DEFAULT NULL,
  `addtime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `shujuid` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=43 DEFAULT CHARSET=gb2312;

-- ----------------------------
-- Records of pinglun
-- ----------------------------

-- ----------------------------
-- Table structure for `qiyexinxi`
-- ----------------------------
DROP TABLE IF EXISTS `qiyexinxi`;
CREATE TABLE `qiyexinxi` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `qiyehao` varchar(50) DEFAULT NULL,
  `mima` varchar(50) DEFAULT NULL,
  `qiyemingcheng` varchar(50) DEFAULT NULL,
  `qiyedizhi` varchar(50) DEFAULT NULL,
  `qiyezhaopian` varchar(50) DEFAULT NULL,
  `fuzeren` varchar(50) DEFAULT NULL,
  `lianxidianhua` varchar(50) DEFAULT NULL,
  `qiyejianjie` varchar(500) DEFAULT NULL,
  `level` varchar(10) DEFAULT '企业',
  `addtime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=gb2312;

-- ----------------------------
-- Records of qiyexinxi
-- ----------------------------
INSERT INTO `qiyexinxi` VALUES ('2', '005', 'dc5c7986daef50c1e02ab09b442ee34f', 'Wallace Ltd', '11 Longxiang Road', '/files/download/58', '009', '13159863241', 'not', '企业', '2024-12-06 13:40:20');
INSERT INTO `qiyexinxi` VALUES ('3', '009', 'dc5c7986daef50c1e02ab09b442ee34f', 'Cangnan Instrument Co., Ltd', '22 Taixing Road', '/files/download/57', '019', '13769548711', 'Not yet', '企业', '2024-12-06 13:40:20');
INSERT INTO `qiyexinxi` VALUES ('9', '011', 'dc5c7986daef50c1e02ab09b442ee34f', 'Wallace Ltd', '22 Kaiming Road', '/files/download/56', '008', '13910215489', 'abc', '企业', '2024-12-06 13:40:20');
INSERT INTO `qiyexinxi` VALUES ('10', '003', 'dc5c7986daef50c1e02ab09b442ee34f', 'Shanghai Pharmaceutical Co., Ltd', '22 Kaiming Road', '/files/download/59', '013', '13748589658', 'not', '企业', '2024-12-06 13:40:20');
INSERT INTO `qiyexinxi` VALUES ('11', '001', 'dc5c7986daef50c1e02ab09b442ee34f', 'Shanghai Pharmaceutical Co., Ltd', '11 Longxiang Road', '/files/download/60', '001', '17505772420', 'not', '企业', '2024-12-06 13:40:20');

-- ----------------------------
-- Table structure for `xiaoxitongzhi`
-- ----------------------------
DROP TABLE IF EXISTS `xiaoxitongzhi`;
CREATE TABLE `xiaoxitongzhi` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `gangweimingcheng` varchar(50) DEFAULT NULL,
  `yonghuming` varchar(50) DEFAULT NULL,
  `xingming` varchar(50) DEFAULT NULL,
  `biaoti` varchar(50) DEFAULT NULL,
  `neirong` varchar(500) DEFAULT NULL,
  `tongzhishijian` datetime DEFAULT NULL,
  `qiyehao` varchar(50) DEFAULT NULL,
  `fuzeren` varchar(50) DEFAULT NULL,
  `lianxidianhua` varchar(50) DEFAULT NULL,
  `addtime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=gb2312;

-- ----------------------------
-- Records of xiaoxitongzhi
-- ----------------------------
INSERT INTO `xiaoxitongzhi` VALUES ('2', 'compere', '001', 'Chen Guibai', 'Onboarding Notices', 'Congratulations on passing the interview, please bring the relevant documents to our company next Monday', '2024-04-11 03:54:50', '001', '001', '17505772420', '2024-12-06 13:40:26');
INSERT INTO `xiaoxitongzhi` VALUES ('3', 'compere', '001', 'Chen Guibai', '1', '1', '2024-12-06 01:48:42', '001', '001', '17505772420', '2024-12-06 13:48:43');

-- ----------------------------
-- Table structure for `xinwentongzhi`
-- ----------------------------
DROP TABLE IF EXISTS `xinwentongzhi`;
CREATE TABLE `xinwentongzhi` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `biaoti` varchar(50) DEFAULT NULL,
  `leibie` varchar(50) DEFAULT NULL,
  `neirong` longtext,
  `dianjilv` varchar(50) DEFAULT NULL,
  `dianzan_d` int(11) DEFAULT '0',
  `dianzan_c` int(11) DEFAULT '0',
  `addtime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=37 DEFAULT CHARSET=gb2312;

-- ----------------------------
-- Records of xinwentongzhi
-- ----------------------------
INSERT INTO `xinwentongzhi` VALUES ('21', 'Report on the application', 'Career guidance', '<div align=\"center\">\n<div align=\"center\">\n<div align=\"center\">Report on the application for holding the 2010 \"Sports Festival\" series of activities in Qianku Town</div>\n<div align=\"center\">&nbsp;</div>\n<div align=\"center\">Qianku Town People\'s Government:</div>\n<div align=\"center\">In order to fully implement the \"Decision of the Zhejiang Provincial People\'s Government on Further Strengthening Sports Work and Accelerating the Development of Sports\" and \"Regulations on National Fitness\", further promote the work of rural sports, extensively carry out national fitness activities in towns (townships) with strong sports, continuously enrich the cultural and sports life of the rural masses, promote the construction of a new socialist countryside, and welcome the arrival of the second \"National Fitness Day\" in the country with practical actions. According to the requirements of the relevant documents of the city and county this year, the following sports competitions will be organized by the town sports federation, and the leaders will be asked to verify and approve the funds for the activities.</div>\n<div align=\"center\">1. Basketball games in town-level administrative villages</div>\n<div align=\"center\">1. There are a total of 44 villages (residences) in Qianku Town, and a \"3-a-side\" half-court basketball game is held, which lasts for about 2 days. (Conducted in early June)</div>\n<div align=\"center\">2. It is divided into divisions, with 10-16 staff and referees.</div>\n<div align=\"center\">3. Budget: 2,000 yuan for equipment, 3,000 yuan for staff and referees, 1,000 yuan for other expenses, a total of 6,000 yuan.</div>\n<div align=\"center\">2. Participate in the Cangnan County Provincial Sports Strong Town Basketball League, with a total of 11 teams.</div>\n<div align=\"center\">1. Set up a town team (14 people in total),</div>\n<div align=\"center\">2. The location is in Alum Mountain, and it will be carried out in early July.</div>\n<div align=\"center\">3. Budget: 4,000 yuan for travel expenses, 4,000 yuan for competition clothing, a total of 8,000 yuan.</div>\n<div align=\"center\">3. The annual goalball competition for the elderly, this year it is the turn of Qianku Town to host, a total of 8 teams, the organizers only entertain the game for one day of lunch and referee (10 people) subsidy, according to the town of 10 people, the meal fee is 500 yuan / meal and the referee fee is 100 yuan / day, a total of 6,000 yuan.</div>\n<div align=\"center\">Fourth, the team to participate in the national fitness regional linkage - sports activities in southern Zhejiang.</div>\n<div align=\"center\">Fifth, the city\'s provincial sports strong town (township) - town (township) mayor fun games (September).</div>\n<div align=\"center\">Sixth, to meet the provincial sports town spot check.</div>\n<div align=\"center\">7. The representative teams of the associations and clubs of the town participate in relevant sports competitions at the county and municipal levels.</div>\n<div align=\"center\">&nbsp;</div>\n<div align=\"center\">Qianku Town Sports Federation</div>\n<div align=\"center\">&nbsp; &nbsp; May 2010</div>\n</div>\n</div>', '74', '0', '0', '2024-12-06 13:40:30');
INSERT INTO `xinwentongzhi` VALUES ('22', 'Wenzhou does a good job in the \"last mile\"', 'Innovation and entrepreneurship', '<P>　　一名干部至少结对一家企业，解决政府服务企业“最后一公里”问题，由此改善温州经济发展软环境――这是我市9月9日在振兴实体经济动员大会之后紧接着推出的一项工作部署，而且这项工作不是“一阵风”，而是长期性的。市委组织部在部署会上透露，干部结对企业开展服务并形成长效制度，这在全国是一项创举。</P>\r\n<P>　　这个长效机制，简单地说，就是在现有的“万名干部进万企解万难”行动（<SPAN style=\"FONT-FAMILY: 楷体, 楷体_GB2312\"><FONT face=\"\">下称“三万”行动</FONT></SPAN>）基础上，凡有纳税的企业今后都要有一名公务员联系，即“驻企服务员”，凡是这家企业需要到机关部门办事的，都交给这名“服务员”帮办。据了解，我市将约有3万名来自市、县（<SPAN style=\"FONT-FAMILY: 楷体, 楷体_GB2312\"><FONT face=\"\">市、区</FONT></SPAN>）、镇（<SPAN style=\"FONT-FAMILY: 楷体, 楷体_GB2312\"><FONT face=\"\">街道</FONT></SPAN>）、社区的干部，进驻10多万家企业“安营扎寨”，助力振兴实体经济。</P>\r\n<P>　　面临新形势，温州经济发展中一直以来累积的结构性、素质性问题亟待解决，市委、市政府把振兴实体经济作为温州赶超发展的首要任务，于年中开始了 “三万”行动。行动正式开展以来，初步梳理出企业难题约1.4万个，据统计，截至9月9日已化解难题4789个，化解率为33.7%。</P>\r\n<P>　　而此次推出的驻企服务员制度，是“三万”行动的“升级版”，目的是建立长效机制，更好地帮助企业解决最迫切且应由政府解决的发展难题，无缝对接政府服务企业的“最后一公里”。相比“三万”行动，驻企服务员工作在干部数、结对企业数上都有“升级”。结对企业数从原先的1万多家增加到10万多家，在保持既有结对关系的基础上，结对人数也相应增加，同时，按照“一对一、一对多”原则，部分干部结对的企业数也有所增加。</P>\r\n<P>　　驻企服务员如何为企业服务？《温州市驻企服务员制度》规定，他们的主要任务是：把各项扶企政策送到企业，当好“宣传员”；为企业提供项目代办服务，当好“代办员”；为企业化解难题，当好“协管员”；对部门、干部服务企业等情况开展效能监察，当好“监督员”，帮助企业化解发展中遇到的困难和难题。</P>\r\n<P> Hearing the introduction of this long-term system, Xu Jianzhong, chairman of Ouhai Dongyi Leather Company, was more down-to-earth, he said: \"First of all, the \'30,000\' action was carried out, from the enterprise to reflect the problem, to the cadres took the initiative to dock many times, and then to the city to hold a special problem assignment meeting, really in the enterprise to share worries.\" Now, the implementation of the waiter system in the enterprise, so that the cadres pair the enterprise from the phased work into a long-term mechanism, it can be seen that Wenzhou to improve the soft environment is definitely not a \'gust of wind\', we are more confident in the development. ”</P>', '7', '0', '0', '2024-12-06 13:40:30');

-- ----------------------------
-- Table structure for `yonghuxinxi`
-- ----------------------------
DROP TABLE IF EXISTS `yonghuxinxi`;
CREATE TABLE `yonghuxinxi` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `yonghuming` varchar(50) DEFAULT NULL,
  `xingming` varchar(50) DEFAULT NULL,
  `xingbie` varchar(50) DEFAULT NULL,
  `mima` varchar(50) DEFAULT NULL,
  `shouji` varchar(50) DEFAULT NULL,
  `shenfenzheng` varchar(50) DEFAULT NULL,
  `touxiang` varchar(50) DEFAULT NULL,
  `beizhu` varchar(50) DEFAULT NULL,
  `level` varchar(10) DEFAULT '用户',
  `addtime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=gb2312;

-- ----------------------------
-- Records of yonghuxinxi
-- ----------------------------
INSERT INTO `yonghuxinxi` VALUES ('2', '017', 'Ho Yongkang', '0', 'dc5c7986daef50c1e02ab09b442ee34f', '17505772420', '330327198501020300', '/files/download/51', 'No problem', '用户', '2024-12-06 13:40:35');
INSERT INTO `yonghuxinxi` VALUES ('3', '004', 'Teng Shaohua', '0', 'dc5c7986daef50c1e02ab09b442ee34f', '13623256544', '33032719900723568X', '/files/download/54', 'abc', '用户', '2024-12-06 13:40:35');
INSERT INTO `yonghuxinxi` VALUES ('6', '007', 'Zhao Ziyin', '1', 'dc5c7986daef50c1e02ab09b442ee34f', '13184865998', '330327198708070789', '/files/download/53', 'ok', '用户', '2024-12-06 13:40:35');
INSERT INTO `yonghuxinxi` VALUES ('8', '009', 'Wu Zhaobin', '0', 'dc5c7986daef50c1e02ab09b442ee34f', '13025896548', '330327185403060589', '/files/download/52', 'No problem', '用户', '2024-12-06 13:40:35');
INSERT INTO `yonghuxinxi` VALUES ('11', '001', 'Chen Guibai', '1', 'dc5c7986daef50c1e02ab09b442ee34f', '17706641413', '330327198811020456', '/files/download/55', 'No problem', '用户', '2024-12-06 13:40:35');
