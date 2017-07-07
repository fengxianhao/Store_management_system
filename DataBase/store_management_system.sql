/*
Navicat MySQL Data Transfer

Source Server         : text
Source Server Version : 50622
Source Host           : localhost:3306
Source Database       : store_management_system

Target Server Type    : MYSQL
Target Server Version : 50622
File Encoding         : 65001

Date: 2016-06-14 22:18:38
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `deliver`
-- ----------------------------
DROP TABLE IF EXISTS `deliver`;
CREATE TABLE `deliver` (
  `AddressID` int(11) NOT NULL AUTO_INCREMENT,
  `OrdersID` int(11) DEFAULT NULL,
  `Address` varchar(30) NOT NULL,
  `Startdate` datetime NOT NULL,
  `deliveryDate` datetime NOT NULL,
  `EmployeeID` int(11) NOT NULL,
  PRIMARY KEY (`AddressID`),
  KEY `fk2_employeeID` (`EmployeeID`),
  KEY `fk1_ordersID` (`OrdersID`),
  CONSTRAINT `fk1_ordersID` FOREIGN KEY (`OrdersID`) REFERENCES `orders` (`ordersID`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of deliver
-- ----------------------------

-- ----------------------------
-- Table structure for `employee`
-- ----------------------------
DROP TABLE IF EXISTS `employee`;
CREATE TABLE `employee` (
  `EmployeeID` int(11) NOT NULL AUTO_INCREMENT,
  `Ename` varchar(10) NOT NULL,
  `Sex` varchar(2) NOT NULL,
  `Age` int(11) NOT NULL,
  `Position` varchar(10) NOT NULL,
  `IDcard` varchar(20) NOT NULL,
  `phone` varchar(20) NOT NULL,
  `Address` varchar(30) NOT NULL,
  `cDate` varchar(20) NOT NULL,
  `Number` varchar(8) DEFAULT NULL,
  `Pwd` varchar(20) DEFAULT NULL,
  `PowerID` int(11) DEFAULT NULL,
  PRIMARY KEY (`EmployeeID`),
  KEY `fk_power` (`PowerID`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of employee
-- ----------------------------
INSERT INTO `employee` VALUES ('2', '杨玉娟', '女', '23', '仓库管理员', '420116199513145206', '18986466949', '武汉', '16-5-5', 'cashier', '123456', '0');
INSERT INTO `employee` VALUES ('4', '彭益清', '男', '20', '送货员', '420116199605123222', '18986469898', '黄冈', '16-5-12', 'admin', '123456', '0');
INSERT INTO `employee` VALUES ('7', '詹宇鹏', '男', '19', '快递员', '42011619960609591X', '15902703144', '湖职东区1栋304', '16-5-16 上午8:16', '', '', '0');

-- ----------------------------
-- Table structure for `goods`
-- ----------------------------
DROP TABLE IF EXISTS `goods`;
CREATE TABLE `goods` (
  `GoodsID` int(11) NOT NULL DEFAULT '0',
  `GName` varchar(30) DEFAULT NULL,
  `Price` double(8,0) DEFAULT NULL,
  `Type` varchar(20) DEFAULT NULL,
  `StorageID` int(11) DEFAULT NULL,
  `StorageNumber` int(11) DEFAULT NULL,
  `StorageDate` varchar(20) DEFAULT NULL,
  `Charge` varchar(10) DEFAULT NULL,
  `StockNumber` int(11) DEFAULT NULL,
  PRIMARY KEY (`GoodsID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of goods
-- ----------------------------
INSERT INTO `goods` VALUES ('1', '小米4', '2599', '电子产品', '60', '2100', '2016-05-16', '雷国庆', '1000');
INSERT INTO `goods` VALUES ('2', 'iphone6s', '4699', '电子产品', '2', '800', '2016-04-28', '雷国庆', '800');
INSERT INTO `goods` VALUES ('3', '华为meta8', '3699', '电子产品', '3', '600', '2016-04-28', '雷国庆', '600');
INSERT INTO `goods` VALUES ('4', '魅蓝matel', '1099', '电子产品', '4', '800', '2016-04-28', '雷国庆', '800');
INSERT INTO `goods` VALUES ('5', '荣耀5X', '1099', '电子产品', '5', '900', '2016-04-28', '雷国庆', '900');
INSERT INTO `goods` VALUES ('6', '格力空调', '3299', '生活电器', '6', '1100', '2016-04-28', '雷国庆', '110');
INSERT INTO `goods` VALUES ('7', '美的电风扇', '199', '生活电器', '7', '900', '2016-04-28', '雷国庆', '900');
INSERT INTO `goods` VALUES ('8', '美的电饭煲', '299', '生活电器', '8', '500', '2016-04-28', '雷国庆', '500');
INSERT INTO `goods` VALUES ('9', '老板油烟机', '1999', '生活电器', '9', '200', '2016-04-28', '雷国庆', '200');
INSERT INTO `goods` VALUES ('10', '海尔电冰箱', '2999', '生活电器', '6001', '10000', '2016-05-10', '雷国庆', '100');
INSERT INTO `goods` VALUES ('11', '黑人牙膏', '13', '生活用品', '1000', '20000', '2016-05-09', '雷国庆', '500');
INSERT INTO `goods` VALUES ('12', '海飞丝洗发精', '24', '生活用品', '12', '850', '2016-04-28', '雷国庆', '850');
INSERT INTO `goods` VALUES ('13', '欧莱雅洁面乳', '26', '生活用品', '13', '123', '2016-04-28', '雷国庆', '123');
INSERT INTO `goods` VALUES ('14', '舒肤佳香皂', '3', '生活用品', '14', '450', '2016-04-28', '雷国庆', '450');
INSERT INTO `goods` VALUES ('15', '蓝月亮洗衣液', '21', '生活用品', '15', '120', '2016-05-30', '雷国庆', '620');
INSERT INTO `goods` VALUES ('16', '欧莱雅男士', '22', '生活用品', '16', '520', '2016-04-28', '雷国庆', '520');
INSERT INTO `goods` VALUES ('17', '荣耀5C', '1098', '电子产品', '17', '600', '2016-04-30', '雷国庆', '600');
INSERT INTO `goods` VALUES ('18', '妮维雅', '22', '生活用品', '18', '1000', '2016-04-30', '雷国庆', '1000');
INSERT INTO `goods` VALUES ('19', '海尔洗衣机', '1200', '生活电器', '19', '1000', '2016-04-28', '雷国庆', '1000');
INSERT INTO `goods` VALUES ('21', '飘柔', '10', '生活用品', null, null, null, null, '800');
INSERT INTO `goods` VALUES ('22', '康师傅矿泉水', '1', '饮料食品', null, null, null, null, null);
INSERT INTO `goods` VALUES ('23', '盼盼法式小面包', '5', '饮料食品', null, null, null, null, null);

-- ----------------------------
-- Table structure for `orders`
-- ----------------------------
DROP TABLE IF EXISTS `orders`;
CREATE TABLE `orders` (
  `ordersID` int(11) NOT NULL AUTO_INCREMENT,
  `ordersDate` datetime NOT NULL,
  `year` varchar(10) NOT NULL,
  `month` varchar(2) NOT NULL,
  `amount` decimal(10,2) DEFAULT NULL,
  `vipID` int(11) DEFAULT NULL,
  PRIMARY KEY (`ordersID`),
  KEY `fk_vipID` (`vipID`),
  CONSTRAINT `fk_vipID` FOREIGN KEY (`vipID`) REFERENCES `vip` (`VIPID`) ON DELETE SET NULL ON UPDATE SET NULL
) ENGINE=InnoDB AUTO_INCREMENT=47 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of orders
-- ----------------------------
INSERT INTO `orders` VALUES ('1', '2013-01-01 19:00:00', '2013', '1', '27.00', '1');
INSERT INTO `orders` VALUES ('2', '2013-02-13 08:58:59', '2013', '2', '1099.00', null);
INSERT INTO `orders` VALUES ('3', '2013-03-03 11:00:00', '2013', '3', '3299.00', null);
INSERT INTO `orders` VALUES ('4', '2013-04-12 10:28:50', '2013', '4', '66.00', null);
INSERT INTO `orders` VALUES ('5', '2013-05-12 12:00:31', '2013', '5', '2699.00', null);
INSERT INTO `orders` VALUES ('6', '2013-06-11 12:03:17', '2013', '6', '27417.00', null);
INSERT INTO `orders` VALUES ('7', '2013-07-20 19:31:56', '2013', '7', '1999.00', null);
INSERT INTO `orders` VALUES ('8', '2013-08-24 20:00:08', '2013', '8', '23.00', null);
INSERT INTO `orders` VALUES ('9', '2013-09-28 20:01:22', '2013', '9', '1143.00', null);
INSERT INTO `orders` VALUES ('10', '2013-10-29 08:56:45', '2013', '10', '2699.00', null);
INSERT INTO `orders` VALUES ('11', '2013-11-11 08:56:57', '2013', '11', '7398.00', null);
INSERT INTO `orders` VALUES ('12', '2013-12-12 08:57:12', '2013', '12', '2022.00', null);
INSERT INTO `orders` VALUES ('13', '2014-01-17 09:08:18', '2014', '1', '271188.00', null);
INSERT INTO `orders` VALUES ('14', '2014-02-25 09:09:48', '2014', '2', '1318800.00', null);
INSERT INTO `orders` VALUES ('15', '2014-03-22 09:13:39', '2014', '3', '110.00', null);
INSERT INTO `orders` VALUES ('16', '2014-04-13 09:15:41', '2014', '4', '5871.00', null);
INSERT INTO `orders` VALUES ('17', '2014-05-13 09:16:01', '2014', '5', '2998.00', null);
INSERT INTO `orders` VALUES ('18', '2014-06-13 09:16:27', '2014', '6', '35412.00', null);
INSERT INTO `orders` VALUES ('19', '2014-07-13 09:16:48', '2014', '7', '63606.00', null);
INSERT INTO `orders` VALUES ('20', '2014-08-13 09:17:34', '2014', '8', '4723.00', null);
INSERT INTO `orders` VALUES ('21', '2014-09-13 09:18:24', '2014', '9', '9446.00', null);
INSERT INTO `orders` VALUES ('22', '2014-10-13 09:18:34', '2014', '10', '9446.00', null);
INSERT INTO `orders` VALUES ('23', '2014-11-13 09:18:44', '2014', '11', '4699.00', null);
INSERT INTO `orders` VALUES ('24', '2014-12-13 09:18:48', '2014', '12', '4699.00', null);
INSERT INTO `orders` VALUES ('25', '2015-01-13 09:18:52', '2015', '1', '4699.00', null);
INSERT INTO `orders` VALUES ('26', '2015-02-13 09:18:56', '2015', '2', '4699.00', null);
INSERT INTO `orders` VALUES ('27', '2015-03-13 09:19:12', '2015', '3', '9398.00', null);
INSERT INTO `orders` VALUES ('28', '2015-04-13 09:19:17', '2015', '4', '9398.00', null);
INSERT INTO `orders` VALUES ('29', '2015-05-13 09:19:27', '2015', '5', '3699.00', null);
INSERT INTO `orders` VALUES ('30', '2015-06-13 09:19:38', '2015', '6', '5698.00', null);
INSERT INTO `orders` VALUES ('31', '2015-07-13 09:19:57', '2015', '7', '5497.00', null);
INSERT INTO `orders` VALUES ('32', '2015-08-13 09:20:12', '2015', '8', '32487.00', null);
INSERT INTO `orders` VALUES ('33', '2015-09-13 09:21:04', '2015', '9', '5451.00', null);
INSERT INTO `orders` VALUES ('34', '2015-10-13 09:21:14', '2015', '10', '2452.00', null);
INSERT INTO `orders` VALUES ('35', '2015-11-13 09:21:23', '2015', '11', '3828.00', null);
INSERT INTO `orders` VALUES ('36', '2015-12-13 09:21:33', '2015', '12', '4127.00', null);
INSERT INTO `orders` VALUES ('37', '2016-01-13 09:21:40', '2016', '1', '4105.00', null);
INSERT INTO `orders` VALUES ('38', '2016-02-13 09:21:47', '2016', '2', '2686.00', null);
INSERT INTO `orders` VALUES ('39', '2016-03-13 09:21:55', '2016', '3', '3486.00', null);
INSERT INTO `orders` VALUES ('40', '2016-04-13 09:22:08', '2016', '4', '2387.00', null);
INSERT INTO `orders` VALUES ('41', '2016-05-13 09:22:14', '2016', '5', '2372.00', null);
INSERT INTO `orders` VALUES ('42', '2016-05-16 00:06:27', '2016', '5', '1099.00', null);
INSERT INTO `orders` VALUES ('43', '2016-05-16 00:37:21', '2016', '5', '4699.00', null);
INSERT INTO `orders` VALUES ('44', '2016-05-16 01:03:56', '2016', '5', '2999.00', null);
INSERT INTO `orders` VALUES ('45', '2016-05-16 09:22:30', '2016', '5', '22.00', null);
INSERT INTO `orders` VALUES ('46', '2016-05-16 09:24:22', '2016', '5', '24.00', null);

-- ----------------------------
-- Table structure for `ordersdetil`
-- ----------------------------
DROP TABLE IF EXISTS `ordersdetil`;
CREATE TABLE `ordersdetil` (
  `ordersDetilID` int(11) NOT NULL AUTO_INCREMENT,
  `ordersID` int(11) DEFAULT NULL,
  `goodsID` int(11) DEFAULT NULL,
  `number` int(11) DEFAULT NULL,
  `allprice` decimal(10,2) DEFAULT NULL,
  PRIMARY KEY (`ordersDetilID`),
  KEY `fk_goodsID` (`goodsID`),
  KEY `fk_ordersID` (`ordersID`),
  CONSTRAINT `fk_goodsID` FOREIGN KEY (`goodsID`) REFERENCES `goods` (`GoodsID`),
  CONSTRAINT `fk_ordersID` FOREIGN KEY (`ordersID`) REFERENCES `orders` (`ordersID`) ON DELETE SET NULL ON UPDATE SET NULL
) ENGINE=InnoDB AUTO_INCREMENT=153 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of ordersdetil
-- ----------------------------
INSERT INTO `ordersdetil` VALUES ('1', '1', '11', '3', '27.00');
INSERT INTO `ordersdetil` VALUES ('2', '3', '5', '1', '1099.00');
INSERT INTO `ordersdetil` VALUES ('3', '3', '6', '1', '3299.00');
INSERT INTO `ordersdetil` VALUES ('4', '4', '16', '3', '66.00');
INSERT INTO `ordersdetil` VALUES ('5', '4', '10', '1', '2999.00');
INSERT INTO `ordersdetil` VALUES ('6', '4', '11', '1', '13.00');
INSERT INTO `ordersdetil` VALUES ('7', '4', '16', '1', '22.00');
INSERT INTO `ordersdetil` VALUES ('8', '4', '2', '1', '4699.00');
INSERT INTO `ordersdetil` VALUES ('9', '5', '1', '1', '2699.00');
INSERT INTO `ordersdetil` VALUES ('10', '6', '1', '2', '5398.00');
INSERT INTO `ordersdetil` VALUES ('11', '6', '9', '1', '1999.00');
INSERT INTO `ordersdetil` VALUES ('12', '6', '1', '1', '2699.00');
INSERT INTO `ordersdetil` VALUES ('13', '6', '2', '3', '14097.00');
INSERT INTO `ordersdetil` VALUES ('14', '6', '9', '1', '1999.00');
INSERT INTO `ordersdetil` VALUES ('15', '6', '13', '1', '25.00');
INSERT INTO `ordersdetil` VALUES ('16', '6', '19', '1', '1200.00');
INSERT INTO `ordersdetil` VALUES ('17', '7', '9', '1', '1999.00');
INSERT INTO `ordersdetil` VALUES ('18', '8', '18', '1', '23.00');
INSERT INTO `ordersdetil` VALUES ('19', '9', '18', '1', '22.00');
INSERT INTO `ordersdetil` VALUES ('20', '9', '16', '1', '22.00');
INSERT INTO `ordersdetil` VALUES ('21', '9', '17', '1', '1099.00');
INSERT INTO `ordersdetil` VALUES ('22', '10', '1', '1', '2699.00');
INSERT INTO `ordersdetil` VALUES ('23', '11', '1', '1', '2699.00');
INSERT INTO `ordersdetil` VALUES ('24', '11', '2', '1', '4699.00');
INSERT INTO `ordersdetil` VALUES ('25', '12', '9', '1', '1999.00');
INSERT INTO `ordersdetil` VALUES ('26', '12', '18', '1', '23.00');
INSERT INTO `ordersdetil` VALUES ('27', '13', '12', '12', '288.00');
INSERT INTO `ordersdetil` VALUES ('28', '13', '1', '100', '269900.00');
INSERT INTO `ordersdetil` VALUES ('29', '14', '19', '1099', '1318800.00');
INSERT INTO `ordersdetil` VALUES ('30', '15', '16', '5', '110.00');
INSERT INTO `ordersdetil` VALUES ('31', '16', '12', '1', '24.00');
INSERT INTO `ordersdetil` VALUES ('32', '16', '13', '1', '25.00');
INSERT INTO `ordersdetil` VALUES ('33', '16', '14', '1', '3.00');
INSERT INTO `ordersdetil` VALUES ('34', '16', '15', '1', '21.00');
INSERT INTO `ordersdetil` VALUES ('35', '16', '17', '1', '1099.00');
INSERT INTO `ordersdetil` VALUES ('36', '16', '2', '1', '4699.00');
INSERT INTO `ordersdetil` VALUES ('37', '17', '8', '1', '299.00');
INSERT INTO `ordersdetil` VALUES ('38', '17', '1', '1', '2699.00');
INSERT INTO `ordersdetil` VALUES ('39', '18', '13', '13', '325.00');
INSERT INTO `ordersdetil` VALUES ('40', '18', '1', '13', '35087.00');
INSERT INTO `ordersdetil` VALUES ('41', '19', '1', '13', '35087.00');
INSERT INTO `ordersdetil` VALUES ('42', '19', '2', '6', '28194.00');
INSERT INTO `ordersdetil` VALUES ('43', '20', '2', '1', '4699.00');
INSERT INTO `ordersdetil` VALUES ('44', '20', '12', '1', '24.00');
INSERT INTO `ordersdetil` VALUES ('45', '21', '13', '2', '50.00');
INSERT INTO `ordersdetil` VALUES ('46', '21', '1', '2', '5398.00');
INSERT INTO `ordersdetil` VALUES ('47', '21', '9', '2', '3998.00');
INSERT INTO `ordersdetil` VALUES ('48', '22', '13', '2', '50.00');
INSERT INTO `ordersdetil` VALUES ('49', '22', '1', '2', '5398.00');
INSERT INTO `ordersdetil` VALUES ('50', '22', '9', '2', '3998.00');
INSERT INTO `ordersdetil` VALUES ('51', '23', '2', '1', '4699.00');
INSERT INTO `ordersdetil` VALUES ('52', '24', '2', '1', '4699.00');
INSERT INTO `ordersdetil` VALUES ('53', '25', '2', '1', '4699.00');
INSERT INTO `ordersdetil` VALUES ('54', '26', '2', '1', '4699.00');
INSERT INTO `ordersdetil` VALUES ('55', '27', '2', '1', '4699.00');
INSERT INTO `ordersdetil` VALUES ('56', '27', '2', '1', '4699.00');
INSERT INTO `ordersdetil` VALUES ('57', '28', '2', '1', '4699.00');
INSERT INTO `ordersdetil` VALUES ('58', '28', '2', '1', '4699.00');
INSERT INTO `ordersdetil` VALUES ('59', '29', '3', '1', '3699.00');
INSERT INTO `ordersdetil` VALUES ('60', '30', '3', '1', '3699.00');
INSERT INTO `ordersdetil` VALUES ('61', '30', '9', '1', '1999.00');
INSERT INTO `ordersdetil` VALUES ('62', '31', '6', '1', '3299.00');
INSERT INTO `ordersdetil` VALUES ('63', '31', '5', '1', '1099.00');
INSERT INTO `ordersdetil` VALUES ('64', '31', '5', '1', '1099.00');
INSERT INTO `ordersdetil` VALUES ('65', '32', '5', '1', '1099.00');
INSERT INTO `ordersdetil` VALUES ('66', '32', '5', '1', '1099.00');
INSERT INTO `ordersdetil` VALUES ('67', '32', '1', '10', '26990.00');
INSERT INTO `ordersdetil` VALUES ('68', '33', '16', '1', '22.00');
INSERT INTO `ordersdetil` VALUES ('69', '33', '17', '1', '1099.00');
INSERT INTO `ordersdetil` VALUES ('70', '33', '18', '1', '22.00');
INSERT INTO `ordersdetil` VALUES ('71', '33', '19', '1', '1200.00');
INSERT INTO `ordersdetil` VALUES ('72', '33', '18', '1', '23.00');
INSERT INTO `ordersdetil` VALUES ('73', '33', '15', '1', '21.00');
INSERT INTO `ordersdetil` VALUES ('74', '33', '14', '1', '3.00');
INSERT INTO `ordersdetil` VALUES ('75', '33', '13', '1', '25.00');
INSERT INTO `ordersdetil` VALUES ('76', '33', '12', '1', '24.00');
INSERT INTO `ordersdetil` VALUES ('77', '33', '11', '1', '13.00');
INSERT INTO `ordersdetil` VALUES ('78', '33', '10', '1', '2999.00');
INSERT INTO `ordersdetil` VALUES ('79', '34', '16', '1', '22.00');
INSERT INTO `ordersdetil` VALUES ('80', '34', '17', '1', '1099.00');
INSERT INTO `ordersdetil` VALUES ('81', '34', '18', '1', '22.00');
INSERT INTO `ordersdetil` VALUES ('82', '34', '19', '1', '1200.00');
INSERT INTO `ordersdetil` VALUES ('83', '34', '18', '1', '23.00');
INSERT INTO `ordersdetil` VALUES ('84', '34', '15', '1', '21.00');
INSERT INTO `ordersdetil` VALUES ('85', '34', '14', '1', '3.00');
INSERT INTO `ordersdetil` VALUES ('86', '34', '13', '1', '25.00');
INSERT INTO `ordersdetil` VALUES ('87', '34', '12', '1', '24.00');
INSERT INTO `ordersdetil` VALUES ('88', '34', '11', '1', '13.00');
INSERT INTO `ordersdetil` VALUES ('89', '35', '17', '1', '1099.00');
INSERT INTO `ordersdetil` VALUES ('90', '35', '18', '1', '22.00');
INSERT INTO `ordersdetil` VALUES ('91', '35', '19', '1', '1200.00');
INSERT INTO `ordersdetil` VALUES ('92', '35', '18', '1', '23.00');
INSERT INTO `ordersdetil` VALUES ('93', '35', '15', '1', '21.00');
INSERT INTO `ordersdetil` VALUES ('94', '35', '14', '1', '3.00');
INSERT INTO `ordersdetil` VALUES ('95', '35', '13', '1', '25.00');
INSERT INTO `ordersdetil` VALUES ('96', '35', '12', '1', '24.00');
INSERT INTO `ordersdetil` VALUES ('97', '35', '11', '1', '13.00');
INSERT INTO `ordersdetil` VALUES ('98', '36', '17', '1', '1099.00');
INSERT INTO `ordersdetil` VALUES ('99', '36', '18', '1', '22.00');
INSERT INTO `ordersdetil` VALUES ('100', '36', '19', '1', '1200.00');
INSERT INTO `ordersdetil` VALUES ('101', '36', '18', '1', '23.00');
INSERT INTO `ordersdetil` VALUES ('102', '36', '15', '1', '21.00');
INSERT INTO `ordersdetil` VALUES ('103', '36', '14', '1', '3.00');
INSERT INTO `ordersdetil` VALUES ('104', '36', '13', '1', '25.00');
INSERT INTO `ordersdetil` VALUES ('105', '36', '12', '1', '24.00');
INSERT INTO `ordersdetil` VALUES ('106', '36', '11', '1', '13.00');
INSERT INTO `ordersdetil` VALUES ('107', '36', '8', '1', '299.00');
INSERT INTO `ordersdetil` VALUES ('108', '37', '17', '1', '1099.00');
INSERT INTO `ordersdetil` VALUES ('109', '37', '19', '1', '1200.00');
INSERT INTO `ordersdetil` VALUES ('110', '37', '18', '1', '23.00');
INSERT INTO `ordersdetil` VALUES ('111', '37', '15', '1', '21.00');
INSERT INTO `ordersdetil` VALUES ('112', '37', '14', '1', '3.00');
INSERT INTO `ordersdetil` VALUES ('113', '37', '13', '1', '25.00');
INSERT INTO `ordersdetil` VALUES ('114', '37', '12', '1', '24.00');
INSERT INTO `ordersdetil` VALUES ('115', '37', '11', '1', '13.00');
INSERT INTO `ordersdetil` VALUES ('116', '37', '8', '1', '299.00');
INSERT INTO `ordersdetil` VALUES ('117', '38', '17', '1', '1099.00');
INSERT INTO `ordersdetil` VALUES ('118', '38', '19', '1', '1200.00');
INSERT INTO `ordersdetil` VALUES ('119', '38', '18', '1', '23.00');
INSERT INTO `ordersdetil` VALUES ('120', '38', '14', '1', '3.00');
INSERT INTO `ordersdetil` VALUES ('121', '38', '13', '1', '25.00');
INSERT INTO `ordersdetil` VALUES ('122', '38', '12', '1', '24.00');
INSERT INTO `ordersdetil` VALUES ('123', '38', '11', '1', '13.00');
INSERT INTO `ordersdetil` VALUES ('124', '38', '8', '1', '299.00');
INSERT INTO `ordersdetil` VALUES ('125', '39', '17', '1', '1099.00');
INSERT INTO `ordersdetil` VALUES ('126', '39', '19', '1', '1200.00');
INSERT INTO `ordersdetil` VALUES ('127', '39', '18', '1', '23.00');
INSERT INTO `ordersdetil` VALUES ('128', '39', '14', '1', '3.00');
INSERT INTO `ordersdetil` VALUES ('129', '39', '13', '1', '25.00');
INSERT INTO `ordersdetil` VALUES ('130', '39', '12', '1', '24.00');
INSERT INTO `ordersdetil` VALUES ('131', '39', '11', '1', '13.00');
INSERT INTO `ordersdetil` VALUES ('132', '40', '19', '1', '1200.00');
INSERT INTO `ordersdetil` VALUES ('133', '40', '18', '1', '23.00');
INSERT INTO `ordersdetil` VALUES ('134', '40', '14', '1', '3.00');
INSERT INTO `ordersdetil` VALUES ('135', '40', '13', '1', '25.00');
INSERT INTO `ordersdetil` VALUES ('136', '40', '12', '1', '24.00');
INSERT INTO `ordersdetil` VALUES ('137', '40', '11', '1', '13.00');
INSERT INTO `ordersdetil` VALUES ('138', '40', '4', '1', '1099.00');
INSERT INTO `ordersdetil` VALUES ('139', '41', '19', '1', '1200.00');
INSERT INTO `ordersdetil` VALUES ('140', '41', '18', '1', '23.00');
INSERT INTO `ordersdetil` VALUES ('141', '41', '13', '1', '25.00');
INSERT INTO `ordersdetil` VALUES ('142', '41', '12', '1', '24.00');
INSERT INTO `ordersdetil` VALUES ('143', '41', '11', '1', '13.00');
INSERT INTO `ordersdetil` VALUES ('144', '41', '4', '1', '1099.00');
INSERT INTO `ordersdetil` VALUES ('145', '42', '4', '1', '1099.00');
INSERT INTO `ordersdetil` VALUES ('146', '43', '2', '1', '4699.00');
INSERT INTO `ordersdetil` VALUES ('147', '44', '10', '1', '2999.00');
INSERT INTO `ordersdetil` VALUES ('148', '45', '16', '1', '22.00');
INSERT INTO `ordersdetil` VALUES ('149', '46', '12', '1', '24.00');
INSERT INTO `ordersdetil` VALUES ('150', '46', '1', '1', '2599.00');
INSERT INTO `ordersdetil` VALUES ('151', '46', '2', '1', '4699.00');
INSERT INTO `ordersdetil` VALUES ('152', '46', '1', '1', '2599.00');

-- ----------------------------
-- Table structure for `power`
-- ----------------------------
DROP TABLE IF EXISTS `power`;
CREATE TABLE `power` (
  `powerID` int(11) NOT NULL AUTO_INCREMENT,
  `do` varchar(20) NOT NULL,
  PRIMARY KEY (`powerID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of power
-- ----------------------------

-- ----------------------------
-- Table structure for `vip`
-- ----------------------------
DROP TABLE IF EXISTS `vip`;
CREATE TABLE `vip` (
  `VIPID` int(11) NOT NULL AUTO_INCREMENT,
  `VName` varchar(10) NOT NULL,
  `Sex` varchar(2) DEFAULT NULL,
  `Age` int(11) DEFAULT NULL,
  `IDcard` varchar(20) DEFAULT NULL,
  `phone` varchar(20) NOT NULL,
  `Address` varchar(30) DEFAULT NULL,
  `cDate` date NOT NULL,
  `number` varchar(20) NOT NULL,
  `Live` int(11) DEFAULT NULL,
  PRIMARY KEY (`VIPID`),
  KEY `vip_ibfk_1` (`Live`),
  CONSTRAINT `vip_ibfk_1` FOREIGN KEY (`Live`) REFERENCES `viplive` (`Live`) ON DELETE SET NULL ON UPDATE SET NULL
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of vip
-- ----------------------------
INSERT INTO `vip` VALUES ('1', '郭智勇', '男', '18', '420116199704013017', '18986466949', '应城', '2016-05-04', '123456', '1');
INSERT INTO `vip` VALUES ('2', '石定坤', '男', '19', '420116198989898912', '15569874520', '河南安阳', '2016-05-04', '123457', '1');
INSERT INTO `vip` VALUES ('3', '袁凯', '男', '19', '420226199504601301', '13396541023', '应城', '2016-05-04', '123458', '1');
INSERT INTO `vip` VALUES ('6', '雷国庆', '男', '20', '420116199704013017', '18071465072', '武汉黄陂', '2016-05-12', '123461', '1');
INSERT INTO `vip` VALUES ('7', '沈小波', '男', '42', '422201197409030811', '13986460493', '竹园小区4栋4042', '2016-05-16', '9898989', '1');

-- ----------------------------
-- Table structure for `viplive`
-- ----------------------------
DROP TABLE IF EXISTS `viplive`;
CREATE TABLE `viplive` (
  `Live` int(11) NOT NULL,
  `Discount` decimal(3,2) NOT NULL,
  PRIMARY KEY (`Live`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of viplive
-- ----------------------------
INSERT INTO `viplive` VALUES ('1', '0.50');
