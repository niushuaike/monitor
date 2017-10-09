/*
Navicat MySQL Data Transfer

Source Server         : mysql
Source Server Version : 50716
Source Host           : localhost:3306
Source Database       : monitor

Target Server Type    : MYSQL
Target Server Version : 50716
File Encoding         : 65001

Date: 2017-10-09 09:41:29
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for alarmthreshold
-- ----------------------------
DROP TABLE IF EXISTS `alarmthreshold`;
CREATE TABLE `alarmthreshold` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `gn_wd_yj_min` varchar(10) DEFAULT NULL COMMENT '柜内温度预警阈值最小值',
  `gn_wd_yj_max` varchar(10) DEFAULT NULL COMMENT '柜内温度预警阈值最大值',
  `gn_wd_gj_min` varchar(10) DEFAULT NULL COMMENT '柜内温度告警阈值最小值',
  `gn_wd_gj_max` varchar(10) DEFAULT NULL COMMENT '柜内温度告警阈值最大值',
  `gn_sd_yj_min` varchar(10) DEFAULT NULL COMMENT '柜内湿度预警阈值最小值',
  `gn_sd_yj_max` varchar(10) DEFAULT NULL COMMENT '柜内湿度预警阈值最大值',
  `gn_sd_gj_min` varchar(10) DEFAULT NULL COMMENT '柜内湿度告警阈值最小值',
  `gn_sd_gj_max` varchar(10) DEFAULT NULL COMMENT '柜内湿度告警阈值最大值',
  `ysj_one_yj_min` varchar(10) DEFAULT NULL COMMENT '压缩机1电流预警阈值最小值',
  `ysj_one_yj_max` varchar(10) DEFAULT NULL COMMENT '压缩机1电流预警阈值最大值',
  `ysj_two_yj_min` varchar(10) DEFAULT NULL COMMENT '压缩机2电流预警阈值最小值',
  `ysj_two_yj_max` varchar(10) DEFAULT NULL COMMENT '压缩机2电流预警阈值最大值',
  `lxfj_one_yj_min` varchar(10) DEFAULT NULL COMMENT '离心风机1电流预警阈值最小值',
  `lxfj_one_yj_max` varchar(10) DEFAULT NULL COMMENT '离心风机1电流预警阈值最大值',
  `lxfj_two_yj_min` varchar(10) DEFAULT NULL COMMENT '离心风机2电流预警阈值最小值',
  `lxfj_two_yj_max` varchar(10) DEFAULT NULL COMMENT '离心风机2电流预警阈值最大值',
  `srfj_yj_min` varchar(10) DEFAULT NULL COMMENT '散热风机电流预警阈值最小值',
  `srfj_yj_max` varchar(10) DEFAULT NULL COMMENT '散热风机电流预警阈值最大值',
  `xhfj_yj_min` varchar(10) DEFAULT NULL COMMENT '循环风机电流预警阈值最小值',
  `xhfj_yj_max` varchar(10) DEFAULT NULL COMMENT '循环风机电流预警阈值最大值',
  `hjkz_yj_min` varchar(10) DEFAULT NULL COMMENT '环境控制温度预警阈值最小值',
  `hjkz_yj_max` varchar(10) DEFAULT NULL COMMENT '环境控制温度预警阈值最大值',
  `ysj_one_gj_min` varchar(10) DEFAULT NULL COMMENT '压缩机1电流告警阈值最小值',
  `ysj_one_gj_max` varchar(10) DEFAULT NULL COMMENT '压缩机1电流告警阈值最大值',
  `ysj_two_gj_min` varchar(10) DEFAULT NULL COMMENT '压缩机2电流告警阈值最小值',
  `ysj_two_gj_max` varchar(10) DEFAULT NULL COMMENT '压缩机2电流告警阈值最大值',
  `lxfj_one_gj_min` varchar(10) DEFAULT NULL COMMENT '离心风机1电流告警阈值最小值',
  `lxfj_one_gj_max` varchar(10) DEFAULT NULL COMMENT '离心风机1电流告警阈值最大值',
  `lxfj_two_gj_min` varchar(10) DEFAULT NULL COMMENT '离心风机2电流告警阈值最小值',
  `lxfj_two_gj_max` varchar(10) DEFAULT NULL COMMENT '离心风机2电流告警阈值最大值',
  `srfj_gj_min` varchar(10) DEFAULT NULL COMMENT '散热风机电流告警阈值最小值',
  `srfj_gj_max` varchar(10) DEFAULT NULL COMMENT '散热风机电流告警阈值最大值',
  `xhfj_gj_min` varchar(10) DEFAULT NULL COMMENT '循环风机电流告警阈值最小值',
  `xhfj_gj_max` varchar(10) DEFAULT NULL COMMENT '循环风机电流告警阈值最大值',
  `hjkz_gj_min` varchar(10) DEFAULT NULL COMMENT '环境控制温度告警阈值最小值',
  `hjkz_gj_max` varchar(10) DEFAULT NULL COMMENT '环境控制温度告警阈值最大值',
  `thresholdtype` varchar(10) DEFAULT NULL COMMENT '阈值类型：0，当前；1，设定值',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of alarmthreshold
-- ----------------------------
INSERT INTO `alarmthreshold` VALUES ('1', '1', '40', '0', '40', '10', '70', '0', '70', '0', '3', '0', '3', '0', '3', '0', '3', '0', '0.2', '0', '3', '0', '50', '0', '5', '0', '5', '0', '5', '0', '5', '0', '5', '0', '5', '0', '50', '0');
INSERT INTO `alarmthreshold` VALUES ('2', '1', '40', '0', '40', '10', '70', '0', '90', '0', '3', '0', '3', '0', '3', '0', '3', '0', '3', '0', '3', '0', '50', '0', '5', '0', '5', '0', '5', '0', '5', '0', '5', '0', '5', '0', '50', '1');

-- ----------------------------
-- Table structure for cabinetparamter
-- ----------------------------
DROP TABLE IF EXISTS `cabinetparamter`;
CREATE TABLE `cabinetparamter` (
  `mid` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '机柜参数主键',
  `temp_setting` varchar(10) DEFAULT NULL COMMENT '温度设定值',
  `temp_difference` varchar(10) DEFAULT NULL COMMENT '温度回差',
  `probe_correction` varchar(10) DEFAULT NULL COMMENT '库温探头校正',
  `envl_control_temperature` varchar(10) DEFAULT NULL COMMENT '环境控制温度',
  `env_control_backlash` varchar(10) DEFAULT NULL COMMENT '环境控制回差',
  `env_probe_correction` varchar(10) DEFAULT NULL COMMENT '环境探头校正',
  `com_con_strat_time` varchar(10) DEFAULT NULL COMMENT '压缩机连续开机时间',
  `com_protection_time` varchar(10) DEFAULT NULL COMMENT '压缩机保护时间',
  `iae_delay_time` varchar(10) DEFAULT NULL COMMENT '内外循环切换延时时间',
  `tem_fault_start_time` varchar(10) DEFAULT NULL COMMENT '温度传感器故障开机时间',
  `tem_fault_end_time` varchar(10) DEFAULT NULL COMMENT '温度传感器故障停机时间',
  `open_tem` varchar(10) DEFAULT NULL COMMENT '开门温度',
  `open_difference` varchar(10) DEFAULT NULL COMMENT '开门回差',
  `control_mode` varchar(10) DEFAULT NULL COMMENT '控制方式',
  `com_current_one_top` varchar(10) DEFAULT NULL COMMENT '压缩机1电流上限',
  `com_current_one_down` varchar(10) DEFAULT NULL COMMENT '压缩机1电流下限',
  `com_current_two_top` varchar(10) DEFAULT NULL COMMENT '压缩机2电流上限',
  `com_current_two_down` varchar(10) DEFAULT NULL COMMENT '压缩机2电流下限',
  `cen_current_one_top` varchar(10) DEFAULT NULL COMMENT '离心风机1电流上限',
  `cen_current_one_down` varchar(10) DEFAULT NULL COMMENT '离心风机1电流下限',
  `cen_current_two_top` varchar(10) DEFAULT NULL COMMENT '离心风机2电流上限',
  `cen_current_two_down` varchar(10) DEFAULT NULL COMMENT '离心风机2电流下限',
  `dissipate_current_top` varchar(10) DEFAULT NULL COMMENT '散热风机电流上限',
  `dissipate_current_down` varchar(10) DEFAULT NULL COMMENT '散热风机电流下限',
  `loop_current_top` varchar(10) DEFAULT NULL COMMENT '循环风机电流上限',
  `loop_current_down` varchar(10) DEFAULT NULL COMMENT '循环风机电流下限',
  `address` varchar(100) DEFAULT NULL COMMENT '通讯地址',
  `parametertype` varchar(10) DEFAULT NULL COMMENT '参数类型：0，设置值；1，恢复默认设置值',
  PRIMARY KEY (`mid`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of cabinetparamter
-- ----------------------------
INSERT INTO `cabinetparamter` VALUES ('1', '26', '9', '0', '30', '10', '0', '2', '10', '30', '20', '20', '15', '10', '1', '5', '1', '5', '1', '1', '0.05', '1', '0.05', '1', '0.05', '1', '0.05', '1', '0');
INSERT INTO `cabinetparamter` VALUES ('2', '26', '9', '0', '30', '10', '0', '2', '10', '30', '20', '20', '15', '10', null, '5', '1', '5', '1', '1', '0.05', '1', '0.05', '1', '0.05', '1', '0.05', null, '1');

-- ----------------------------
-- Table structure for device
-- ----------------------------
DROP TABLE IF EXISTS `device`;
CREATE TABLE `device` (
  `id` int(20) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `device_name` varchar(50) NOT NULL COMMENT '主机名',
  `device_ip` varchar(20) DEFAULT NULL COMMENT 'IP地址',
  `device_port` varchar(200) DEFAULT NULL COMMENT '主机端口',
  `timeperiod` int(20) NOT NULL COMMENT '告警时段id',
  `warnstyleid` varchar(50) NOT NULL COMMENT '告警方式ID',
  `users` varchar(200) DEFAULT NULL COMMENT '通知用户',
  `intervaltime` varchar(20) NOT NULL COMMENT '告警间隔时间',
  `isPause` tinyint(1) unsigned DEFAULT NULL,
  `endPausetime` varchar(50) DEFAULT NULL,
  `device_type` tinyint(1) NOT NULL COMMENT '设备类型：2，普通；3，海康；4，大华',
  `login_name` varchar(50) DEFAULT NULL,
  `login_passwd` varchar(50) DEFAULT NULL,
  `device_address` varchar(255) DEFAULT NULL,
  `machinecode` varchar(255) DEFAULT NULL,
  `controlmode` varchar(255) DEFAULT NULL,
  `maincontrolip` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=81 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of device
-- ----------------------------
INSERT INTO `device` VALUES ('52', '温湿度对对对', '192.168.199.105', '', '10', '5', '', '', '0', '', '1', '', '', 'windows', '1507284057219894100', '', 'http://192.168.199.111:8080');
INSERT INTO `device` VALUES ('80', 'xiaomi ', '192.168.199.244', '', '3', '5', '', '', '0', '', '2', '', '', '', '', '', null);

-- ----------------------------
-- Table structure for msgqueue
-- ----------------------------
DROP TABLE IF EXISTS `msgqueue`;
CREATE TABLE `msgqueue` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `msgType` int(4) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=195 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of msgqueue
-- ----------------------------

-- ----------------------------
-- Table structure for msgtype
-- ----------------------------
DROP TABLE IF EXISTS `msgtype`;
CREATE TABLE `msgtype` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `msgType` varchar(20) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=15 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of msgtype
-- ----------------------------
INSERT INTO `msgtype` VALUES ('1', '过压告警');
INSERT INTO `msgtype` VALUES ('2', '欠压告警');
INSERT INTO `msgtype` VALUES ('3', '过流1告警');
INSERT INTO `msgtype` VALUES ('5', '温度告警');
INSERT INTO `msgtype` VALUES ('6', '湿度告警');
INSERT INTO `msgtype` VALUES ('7', '前门告警');
INSERT INTO `msgtype` VALUES ('8', '水浸告警');
INSERT INTO `msgtype` VALUES ('9', '红外告警');
INSERT INTO `msgtype` VALUES ('10', '烟感告警');
INSERT INTO `msgtype` VALUES ('11', '关键设备告警');
INSERT INTO `msgtype` VALUES ('12', '后门告警');
INSERT INTO `msgtype` VALUES ('4', '过流2告警');

-- ----------------------------
-- Table structure for reportstatus
-- ----------------------------
DROP TABLE IF EXISTS `reportstatus`;
CREATE TABLE `reportstatus` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `statusno` varchar(255) DEFAULT NULL COMMENT '格式：年月日-时分',
  `temperature` varchar(255) DEFAULT NULL,
  `humidity` varchar(255) DEFAULT NULL,
  `frontGate` varchar(255) DEFAULT NULL,
  `backGate` varchar(255) DEFAULT NULL,
  `smoke` varchar(255) DEFAULT NULL,
  `flood` varchar(255) DEFAULT NULL,
  `infrared` varchar(255) DEFAULT NULL,
  `devicestatus` varchar(255) DEFAULT NULL COMMENT 'json数组存储',
  `warninfo` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=990 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of reportstatus
-- ----------------------------
INSERT INTO `reportstatus` VALUES ('798', '2017-09-30-13:00:16', '27.3℃', '79.1%', '关', '关', '正常', '正常', '正常', '[{\"pingstatus\":\"正常\",\"devicename\":\"小米1\"}]', '');
INSERT INTO `reportstatus` VALUES ('799', '2017-09-30-13:02:00', '27.3℃', '79.1%', '关', '关', '正常', '正常', '正常', '[{\"pingstatus\":\"正常\",\"devicename\":\"小米1\"}]', '');
INSERT INTO `reportstatus` VALUES ('800', '2017-09-30-13:04:00', '27.3℃', '79.1%', '关', '关', '正常', '正常', '正常', '[{\"pingstatus\":\"正常\",\"devicename\":\"小米1\"}]', '');
INSERT INTO `reportstatus` VALUES ('801', '2017-09-30-13:06:00', '27.3℃', '79.1%', '关', '关', '正常', '正常', '正常', '[{\"pingstatus\":\"正常\",\"devicename\":\"小米1\"}]', '');
INSERT INTO `reportstatus` VALUES ('802', '2017-09-30-13:08:00', '27.3℃', '79.1%', '关', '关', '正常', '正常', '正常', '[{\"pingstatus\":\"正常\",\"devicename\":\"小米1\"}]', '');
INSERT INTO `reportstatus` VALUES ('803', '2017-09-30-13:10:00', '27.3℃', '79.1%', '关', '关', '正常', '正常', '正常', '[{\"pingstatus\":\"正常\",\"devicename\":\"小米1\"}]', '');
INSERT INTO `reportstatus` VALUES ('804', '2017-09-30-13:12:00', '27.3℃', '79.1%', '关', '关', '正常', '正常', '正常', '[{\"pingstatus\":\"正常\",\"devicename\":\"小米1\"}]', '');
INSERT INTO `reportstatus` VALUES ('805', '2017-09-30-13:15:25', '27.3℃', '79.1%', '关', '关', '正常', '正常', '正常', '[{\"pingstatus\":\"正常\",\"devicename\":\"小米1\"}]', '');
INSERT INTO `reportstatus` VALUES ('806', '2017-09-30-13:16:00', '27.3℃', '79.1%', '关', '关', '正常', '正常', '正常', '[{\"pingstatus\":\"正常\",\"devicename\":\"小米1\"}]', '');
INSERT INTO `reportstatus` VALUES ('807', '2017-09-30-13:18:00', '27.3℃', '79.1%', '关', '关', '正常', '正常', '正常', '[{\"pingstatus\":\"正常\",\"devicename\":\"小米1\"}]', '');
INSERT INTO `reportstatus` VALUES ('808', '2017-09-30-13:20:00', '27.3℃', '79.1%', '关', '关', '正常', '正常', '正常', '[{\"pingstatus\":\"正常\",\"devicename\":\"小米1\"}]', '');
INSERT INTO `reportstatus` VALUES ('809', '2017-09-30-13:22:00', '27.3℃', '79.1%', '关', '关', '正常', '正常', '正常', '[{\"pingstatus\":\"正常\",\"devicename\":\"小米1\"}]', '');
INSERT INTO `reportstatus` VALUES ('810', '2017-09-30-13:24:00', '27.3℃', '79.1%', '关', '关', '正常', '正常', '正常', '[{\"pingstatus\":\"正常\",\"devicename\":\"小米1\"}]', '');
INSERT INTO `reportstatus` VALUES ('811', '2017-09-30-13:26:45', '27.3℃', '79.1%', '关', '关', '正常', '正常', '正常', '[{\"pingstatus\":\"正常\",\"devicename\":\"小米1\"}]', '');
INSERT INTO `reportstatus` VALUES ('812', '2017-09-30-13:28:00', '27.3℃', '79.1%', '关', '关', '正常', '正常', '正常', '[{\"pingstatus\":\"正常\",\"devicename\":\"小米1\"}]', '');
INSERT INTO `reportstatus` VALUES ('813', '2017-09-30-13:30:00', '27.3℃', '79.1%', '关', '关', '正常', '正常', '正常', '[{\"pingstatus\":\"正常\",\"devicename\":\"小米1\"}]', '');
INSERT INTO `reportstatus` VALUES ('814', '2017-09-30-13:32:00', '27.3℃', '79.1%', '关', '关', '正常', '正常', '正常', '[{\"pingstatus\":\"正常\",\"devicename\":\"小米1\"}]', '');
INSERT INTO `reportstatus` VALUES ('815', '2017-09-30-13:34:00', '27.3℃', '79.1%', '关', '关', '正常', '正常', '正常', '[{\"pingstatus\":\"正常\",\"devicename\":\"小米1\"}]', '');
INSERT INTO `reportstatus` VALUES ('816', '2017-09-30-13:36:00', '27.3℃', '79.1%', '关', '关', '正常', '正常', '正常', '[{\"pingstatus\":\"正常\",\"devicename\":\"小米1\"}]', '');
INSERT INTO `reportstatus` VALUES ('817', '2017-09-30-13:38:00', '27.3℃', '79.1%', '关', '关', '正常', '正常', '正常', '[{\"pingstatus\":\"正常\",\"devicename\":\"小米1\"}]', '');
INSERT INTO `reportstatus` VALUES ('818', '2017-09-30-13:40:00', '27.3℃', '79.1%', '关', '关', '正常', '正常', '正常', '[{\"pingstatus\":\"正常\",\"devicename\":\"小米1\"}]', '');
INSERT INTO `reportstatus` VALUES ('819', '2017-09-30-13:42:00', '27.3℃', '79.1%', '关', '关', '正常', '正常', '正常', '[{\"pingstatus\":\"正常\",\"devicename\":\"小米1\"}]', '');
INSERT INTO `reportstatus` VALUES ('820', '2017-09-30-13:44:00', '27.3℃', '79.1%', '关', '关', '正常', '正常', '正常', '[{\"pingstatus\":\"正常\",\"devicename\":\"小米1\"}]', '');
INSERT INTO `reportstatus` VALUES ('821', '2017-09-30-13:47:06', '27.3℃', '79.1%', '关', '关', '正常', '正常', '正常', '[{\"pingstatus\":\"正常\",\"devicename\":\"小米1\"}]', '');
INSERT INTO `reportstatus` VALUES ('822', '2017-09-30-13:52:28', '27.3℃', '79.1%', '关', '关', '正常', '正常', '正常', '[{\"pingstatus\":\"正常\",\"devicename\":\"小米1\"}]', '');
INSERT INTO `reportstatus` VALUES ('823', '2017-09-30-13:56:10', '27.3℃', '79.1%', '关', '关', '正常', '正常', '正常', '[{\"pingstatus\":\"正常\",\"devicename\":\"小米1\"}]', '');
INSERT INTO `reportstatus` VALUES ('824', '2017-09-30-14:00:00', '27.3℃', '79.1%', '关', '关', '正常', '正常', '正常', '[{\"pingstatus\":\"正常\",\"devicename\":\"小米1\"}]', '');
INSERT INTO `reportstatus` VALUES ('825', '2017-09-30-14:02:36', '27.3℃', '79.1%', '关', '关', '正常', '正常', '正常', '[{\"pingstatus\":\"正常\",\"devicename\":\"小米1\"}]', '');
INSERT INTO `reportstatus` VALUES ('826', '2017-09-30-14:04:00', '27.3℃', '79.1%', '关', '关', '正常', '正常', '正常', '[{\"pingstatus\":\"正常\",\"devicename\":\"小米1\"}]', '');
INSERT INTO `reportstatus` VALUES ('827', '2017-09-30-14:06:00', '27.3℃', '79.1%', '关', '关', '正常', '正常', '正常', '[{\"pingstatus\":\"正常\",\"devicename\":\"小米1\"}]', '');
INSERT INTO `reportstatus` VALUES ('828', '2017-09-30-14:10:08', '27.3℃', '79.1%', '关', '关', '正常', '正常', '正常', '[{\"devicename\":\"小米1\"}]', '');
INSERT INTO `reportstatus` VALUES ('829', '2017-09-30-14:12:27', '27.3℃', '79.1%', '关', '关', '正常', '正常', '正常', '[{\"pingstatus\":\"正常\",\"devicename\":\"小米1\"}]', '');
INSERT INTO `reportstatus` VALUES ('830', '2017-09-30-14:14:01', '27.3℃', '79.1%', '关', '关', '正常', '正常', '正常', '[{\"pingstatus\":\"正常\",\"devicename\":\"小米1\"}]', '');
INSERT INTO `reportstatus` VALUES ('831', '2017-09-30-14:16:00', '27.3℃', '79.1%', '关', '关', '正常', '正常', '正常', '[{\"pingstatus\":\"正常\",\"devicename\":\"小米1\"}]', '');
INSERT INTO `reportstatus` VALUES ('832', '2017-09-30-14:18:14', '27.3℃', '79.1%', '关', '关', '正常', '正常', '正常', '[{\"pingstatus\":\"正常\",\"devicename\":\"小米1\"}]', '14015,');
INSERT INTO `reportstatus` VALUES ('833', '2017-09-30-14:20:10', '27.3℃', '79.1%', '关', '关', '正常', '正常', '正常', '[{\"pingstatus\":\"正常\",\"devicename\":\"小米1\"}]', '14015,');
INSERT INTO `reportstatus` VALUES ('834', '2017-09-30-14:22:01', '27.3℃', '79.1%', '关', '关', '正常', '正常', '正常', '[{\"pingstatus\":\"正常\",\"devicename\":\"小米1\"}]', '14015,');
INSERT INTO `reportstatus` VALUES ('835', '2017-09-30-14:24:00', '27.3℃', '79.1%', '关', '关', '正常', '正常', '正常', '[{\"pingstatus\":\"正常\",\"devicename\":\"小米1\"}]', '14018,14017,14016,');
INSERT INTO `reportstatus` VALUES ('836', '2017-09-30-14:26:00', '27.3℃', '79.1%', '关', '关', '正常', '正常', '正常', '[{\"pingstatus\":\"正常\",\"devicename\":\"小米1\"}]', '14018,14017,14016,');
INSERT INTO `reportstatus` VALUES ('837', '2017-09-30-14:28:00', '27.3℃', '79.1%', '关', '关', '正常', '正常', '正常', '[{\"pingstatus\":\"正常\",\"devicename\":\"小米1\"}]', '14018,14017,14016,');
INSERT INTO `reportstatus` VALUES ('838', '2017-09-30-14:30:00', '27.3℃', '79.1%', '关', '关', '正常', '正常', '正常', '[{\"pingstatus\":\"正常\",\"devicename\":\"小米1\"}]', '14018,14017,14016,');
INSERT INTO `reportstatus` VALUES ('839', '2017-09-30-14:32:00', '27.3℃', '79.1%', '关', '关', '正常', '正常', '正常', '[{\"pingstatus\":\"正常\",\"devicename\":\"小米1\"}]', '14018,14017,14016,');
INSERT INTO `reportstatus` VALUES ('840', '2017-09-30-14:34:00', '27.3℃', '79.1%', '关', '关', '正常', '正常', '正常', '[{\"pingstatus\":\"正常\",\"devicename\":\"小米1\"}]', '14018,14017,14016,');
INSERT INTO `reportstatus` VALUES ('841', '2017-09-30-14:36:00', '27.3℃', '79.1%', '关', '关', '正常', '正常', '正常', '[{\"pingstatus\":\"正常\",\"devicename\":\"小米1\"}]', '14018,14017,14016,');
INSERT INTO `reportstatus` VALUES ('842', '2017-09-30-14:38:00', '27.3℃', '79.1%', '关', '关', '正常', '正常', '正常', '[{\"pingstatus\":\"正常\",\"devicename\":\"小米1\"}]', '14018,14017,14016,');
INSERT INTO `reportstatus` VALUES ('843', '2017-09-30-14:40:18', '27.3℃', '79.1%', '关', '关', '正常', '正常', '正常', '[{\"pingstatus\":\"正常\",\"devicename\":\"小米1\"}]', '14018,14017,14016,');
INSERT INTO `reportstatus` VALUES ('844', '2017-09-30-14:42:00', '27.3℃', '79.1%', '关', '关', '正常', '正常', '正常', '[{\"pingstatus\":\"正常\",\"devicename\":\"小米1\"}]', '14018,14017,14016,');
INSERT INTO `reportstatus` VALUES ('845', '2017-09-30-14:44:00', '27.3℃', '79.1%', '关', '关', '正常', '正常', '正常', '[{\"pingstatus\":\"正常\",\"devicename\":\"小米1\"}]', '14018,14017,14016,');
INSERT INTO `reportstatus` VALUES ('846', '2017-09-30-14:46:00', '27.3℃', '79.1%', '关', '关', '正常', '正常', '正常', '[{\"pingstatus\":\"正常\",\"devicename\":\"小米1\"}]', '14018,14017,14016,');
INSERT INTO `reportstatus` VALUES ('847', '2017-09-30-14:48:00', '27.3℃', '79.1%', '关', '关', '正常', '正常', '正常', '[{\"pingstatus\":\"正常\",\"devicename\":\"小米1\"}]', '14018,14017,14016,');
INSERT INTO `reportstatus` VALUES ('848', '2017-09-30-14:50:00', '27.3℃', '79.1%', '关', '关', '正常', '正常', '正常', '[{\"pingstatus\":\"正常\",\"devicename\":\"小米1\"}]', '14018,14017,14016,');
INSERT INTO `reportstatus` VALUES ('849', '2017-09-30-14:52:00', '27.3℃', '79.1%', '关', '关', '正常', '正常', '正常', '[{\"pingstatus\":\"正常\",\"devicename\":\"小米1\"}]', '14018,14017,14016,');
INSERT INTO `reportstatus` VALUES ('850', '2017-09-30-14:54:00', '27.3℃', '79.1%', '关', '关', '正常', '正常', '正常', '[{\"pingstatus\":\"正常\",\"devicename\":\"小米1\"}]', '14018,14017,14016,');
INSERT INTO `reportstatus` VALUES ('851', '2017-09-30-14:56:00', '27.3℃', '79.1%', '关', '关', '正常', '正常', '正常', '[{\"pingstatus\":\"正常\",\"devicename\":\"小米1\"}]', '14018,14017,14016,');
INSERT INTO `reportstatus` VALUES ('852', '2017-09-30-14:58:00', '27.3℃', '79.1%', '关', '关', '正常', '正常', '正常', '[{\"pingstatus\":\"正常\",\"devicename\":\"小米1\"}]', '14018,14017,14016,');
INSERT INTO `reportstatus` VALUES ('853', '2017-10-05-14:16:00', '27.3℃', '79.1%', '关', '关', '正常', '正常', '正常', '[{\"pingstatus\":\"正常\",\"devicename\":\"小米1\"}]', '');
INSERT INTO `reportstatus` VALUES ('854', '2017-10-05-14:18:00', '27.3℃', '79.1%', '关', '关', '正常', '正常', '正常', '[{\"pingstatus\":\"正常\",\"devicename\":\"小米1\"}]', '');
INSERT INTO `reportstatus` VALUES ('855', '2017-10-05-14:20:00', '27.3℃', '79.1%', '关', '关', '正常', '正常', '正常', '[{\"pingstatus\":\"正常\",\"devicename\":\"小米1\"}]', '');
INSERT INTO `reportstatus` VALUES ('856', '2017-10-05-14:22:00', '27.3℃', '79.1%', '关', '关', '正常', '正常', '正常', '[{\"pingstatus\":\"正常\",\"devicename\":\"小米1\"}]', '');
INSERT INTO `reportstatus` VALUES ('857', '2017-10-05-14:24:00', '27.3℃', '79.1%', '关', '关', '正常', '正常', '正常', '[{\"pingstatus\":\"正常\",\"devicename\":\"小米1\"}]', '');
INSERT INTO `reportstatus` VALUES ('858', '2017-10-05-14:26:00', '27.3℃', '79.1%', '关', '关', '正常', '正常', '正常', '[{\"pingstatus\":\"正常\",\"devicename\":\"小米1\"}]', '');
INSERT INTO `reportstatus` VALUES ('859', '2017-10-05-14:28:00', '27.3℃', '79.1%', '关', '关', '正常', '正常', '正常', '[{\"pingstatus\":\"正常\",\"devicename\":\"小米1\"}]', '');
INSERT INTO `reportstatus` VALUES ('860', '2017-10-05-14:30:00', '27.3℃', '79.1%', '关', '关', '正常', '正常', '正常', '[{\"pingstatus\":\"正常\",\"devicename\":\"小米1\"}]', '');
INSERT INTO `reportstatus` VALUES ('861', '2017-10-05-14:32:00', '27.3℃', '79.1%', '关', '关', '正常', '正常', '正常', '[{\"pingstatus\":\"正常\",\"devicename\":\"小米1\"}]', '');
INSERT INTO `reportstatus` VALUES ('862', '2017-10-05-14:34:00', '27.3℃', '79.1%', '关', '关', '正常', '正常', '正常', '[{\"pingstatus\":\"正常\",\"devicename\":\"小米1\"}]', '');
INSERT INTO `reportstatus` VALUES ('863', '2017-10-05-14:36:00', '27.3℃', '79.1%', '关', '关', '正常', '正常', '正常', '[{\"pingstatus\":\"正常\",\"devicename\":\"小米1\"}]', '');
INSERT INTO `reportstatus` VALUES ('864', '2017-10-05-14:38:00', '27.3℃', '79.1%', '关', '关', '正常', '正常', '正常', '[{\"pingstatus\":\"正常\",\"devicename\":\"小米1\"}]', '');
INSERT INTO `reportstatus` VALUES ('865', '2017-10-05-14:40:00', '27.3℃', '79.1%', '关', '关', '正常', '正常', '正常', '[{\"pingstatus\":\"正常\",\"devicename\":\"小米1\"}]', '');
INSERT INTO `reportstatus` VALUES ('866', '2017-10-05-14:42:00', '27.3℃', '79.1%', '关', '关', '正常', '正常', '正常', '[{\"pingstatus\":\"正常\",\"devicename\":\"小米1\"}]', '');
INSERT INTO `reportstatus` VALUES ('867', '2017-10-05-14:44:00', '27.3℃', '79.1%', '关', '关', '正常', '正常', '正常', '[{\"pingstatus\":\"正常\",\"devicename\":\"小米1\"}]', '');
INSERT INTO `reportstatus` VALUES ('868', '2017-10-05-14:46:00', '27.3℃', '79.1%', '关', '关', '正常', '正常', '正常', '[{\"pingstatus\":\"正常\",\"devicename\":\"小米1\"}]', '');
INSERT INTO `reportstatus` VALUES ('869', '2017-10-05-14:48:00', '27.3℃', '79.1%', '关', '关', '正常', '正常', '正常', '[{\"pingstatus\":\"正常\",\"devicename\":\"小米1\"}]', '');
INSERT INTO `reportstatus` VALUES ('870', '2017-10-05-14:50:04', '27.3℃', '79.1%', '关', '关', '正常', '正常', '正常', '[{\"pingstatus\":\"正常\",\"devicename\":\"小米1\"}]', '');
INSERT INTO `reportstatus` VALUES ('871', '2017-10-05-14:52:00', '27.3℃', '79.1%', '关', '关', '正常', '正常', '正常', '[{\"pingstatus\":\"正常\",\"devicename\":\"小米1\"}]', '');
INSERT INTO `reportstatus` VALUES ('872', '2017-10-05-14:54:00', '27.3℃', '79.1%', '关', '关', '正常', '正常', '正常', '[{\"pingstatus\":\"正常\",\"devicename\":\"小米1\"}]', '');
INSERT INTO `reportstatus` VALUES ('873', '2017-10-05-14:56:00', '27.3℃', '79.1%', '关', '关', '正常', '正常', '正常', '[{\"pingstatus\":\"正常\",\"devicename\":\"小米1\"}]', '');
INSERT INTO `reportstatus` VALUES ('874', '2017-10-05-14:58:00', '27.3℃', '79.1%', '关', '关', '正常', '正常', '正常', '[{\"pingstatus\":\"正常\",\"devicename\":\"小米1\"}]', '');
INSERT INTO `reportstatus` VALUES ('875', '2017-10-06-11:15:35', '27.3℃', '79.1%', '关', '关', '正常', '正常', '正常', '[{\"pingstatus\":\"正常\",\"devicename\":\"小米1\"}]', '');
INSERT INTO `reportstatus` VALUES ('876', '2017-10-06-11:16:00', '27.3℃', '79.1%', '关', '关', '正常', '正常', '正常', '[{\"pingstatus\":\"正常\",\"devicename\":\"小米1\"}]', '');
INSERT INTO `reportstatus` VALUES ('877', '2017-10-06-11:18:00', '27.3℃', '79.1%', '关', '关', '正常', '正常', '正常', '[{\"pingstatus\":\"正常\",\"devicename\":\"小米1\"}]', '');
INSERT INTO `reportstatus` VALUES ('878', '2017-10-06-11:20:03', '27.3℃', '79.1%', '关', '关', '正常', '正常', '正常', '[{\"pingstatus\":\"正常\",\"devicename\":\"小米1\"}]', '');
INSERT INTO `reportstatus` VALUES ('879', '2017-10-06-11:22:00', '27.3℃', '79.1%', '关', '关', '正常', '正常', '正常', '[{\"pingstatus\":\"正常\",\"devicename\":\"小米1\"}]', '');
INSERT INTO `reportstatus` VALUES ('880', '2017-10-06-11:24:00', '27.3℃', '79.1%', '关', '关', '正常', '正常', '正常', '[{\"pingstatus\":\"正常\",\"devicename\":\"小米1\"}]', '');
INSERT INTO `reportstatus` VALUES ('881', '2017-10-06-11:26:00', '27.3℃', '79.1%', '关', '关', '正常', '正常', '正常', '[{\"pingstatus\":\"正常\",\"devicename\":\"小米1\"}]', '');
INSERT INTO `reportstatus` VALUES ('882', '2017-10-06-11:28:00', '27.3℃', '79.1%', '关', '关', '正常', '正常', '正常', '[{\"pingstatus\":\"正常\",\"devicename\":\"小米1\"}]', '');
INSERT INTO `reportstatus` VALUES ('883', '2017-10-06-11:30:00', '27.3℃', '79.1%', '关', '关', '正常', '正常', '正常', '[{\"pingstatus\":\"正常\",\"devicename\":\"小米1\"}]', '');
INSERT INTO `reportstatus` VALUES ('884', '2017-10-06-11:32:00', '27.3℃', '79.1%', '关', '关', '正常', '正常', '正常', '[{\"pingstatus\":\"正常\",\"devicename\":\"小米1\"}]', '');
INSERT INTO `reportstatus` VALUES ('885', '2017-10-06-11:34:00', '27.3℃', '79.1%', '关', '关', '正常', '正常', '正常', '[{\"pingstatus\":\"正常\",\"devicename\":\"小米1\"}]', '');
INSERT INTO `reportstatus` VALUES ('886', '2017-10-06-11:36:00', '27.3℃', '79.1%', '关', '关', '正常', '正常', '正常', '[{\"pingstatus\":\"正常\",\"devicename\":\"小米1\"}]', '');
INSERT INTO `reportstatus` VALUES ('887', '2017-10-06-11:38:00', '27.3℃', '79.1%', '关', '关', '正常', '正常', '正常', '[{\"pingstatus\":\"正常\",\"devicename\":\"小米1\"}]', '');
INSERT INTO `reportstatus` VALUES ('888', '2017-10-06-11:40:00', '27.3℃', '79.1%', '关', '关', '正常', '正常', '正常', '[{\"pingstatus\":\"正常\",\"devicename\":\"小米1\"}]', '');
INSERT INTO `reportstatus` VALUES ('889', '2017-10-06-11:42:00', '27.3℃', '79.1%', '关', '关', '正常', '正常', '正常', '[{\"pingstatus\":\"正常\",\"devicename\":\"小米1\"}]', '');
INSERT INTO `reportstatus` VALUES ('890', '2017-10-06-11:44:00', '27.3℃', '79.1%', '关', '关', '正常', '正常', '正常', '[{\"pingstatus\":\"正常\",\"devicename\":\"小米1\"}]', '');
INSERT INTO `reportstatus` VALUES ('891', '2017-10-06-11:46:00', '27.3℃', '79.1%', '关', '关', '正常', '正常', '正常', '[{\"pingstatus\":\"正常\",\"devicename\":\"小米1\"}]', '');
INSERT INTO `reportstatus` VALUES ('892', '2017-10-06-11:48:00', '27.3℃', '79.1%', '关', '关', '正常', '正常', '正常', '[{\"pingstatus\":\"正常\",\"devicename\":\"小米1\"}]', '');
INSERT INTO `reportstatus` VALUES ('893', '2017-10-06-11:50:00', '27.3℃', '79.1%', '关', '关', '正常', '正常', '正常', '[{\"pingstatus\":\"正常\",\"devicename\":\"小米1\"}]', '');
INSERT INTO `reportstatus` VALUES ('894', '2017-10-06-11:52:00', '27.3℃', '79.1%', '关', '关', '正常', '正常', '正常', '[{\"pingstatus\":\"正常\",\"devicename\":\"小米1\"}]', '');
INSERT INTO `reportstatus` VALUES ('895', '2017-10-06-11:54:00', '27.3℃', '79.1%', '关', '关', '正常', '正常', '正常', '[{\"pingstatus\":\"正常\",\"devicename\":\"小米1\"}]', '');
INSERT INTO `reportstatus` VALUES ('896', '2017-10-06-11:56:00', '27.3℃', '79.1%', '关', '关', '正常', '正常', '正常', '[{\"pingstatus\":\"正常\",\"devicename\":\"小米1\"}]', '');
INSERT INTO `reportstatus` VALUES ('897', '2017-10-06-11:58:00', '27.3℃', '79.1%', '关', '关', '正常', '正常', '正常', '[{\"pingstatus\":\"正常\",\"devicename\":\"小米1\"}]', '');
INSERT INTO `reportstatus` VALUES ('898', '2017-10-06-12:00:00', '27.3℃', '79.1%', '关', '关', '正常', '正常', '正常', '[{\"pingstatus\":\"正常\",\"devicename\":\"小米1\"}]', '');
INSERT INTO `reportstatus` VALUES ('899', '2017-10-06-12:02:00', '27.3℃', '79.1%', '关', '关', '正常', '正常', '正常', '[{\"pingstatus\":\"正常\",\"devicename\":\"小米1\"}]', '');
INSERT INTO `reportstatus` VALUES ('900', '2017-10-06-12:04:00', '27.3℃', '79.1%', '关', '关', '正常', '正常', '正常', '[{\"pingstatus\":\"正常\",\"devicename\":\"小米1\"}]', '');
INSERT INTO `reportstatus` VALUES ('901', '2017-10-06-12:06:00', '27.3℃', '79.1%', '关', '关', '正常', '正常', '正常', '[{\"pingstatus\":\"正常\",\"devicename\":\"小米1\"}]', '');
INSERT INTO `reportstatus` VALUES ('902', '2017-10-06-12:08:00', '27.3℃', '79.1%', '关', '关', '正常', '正常', '正常', '[{\"pingstatus\":\"正常\",\"devicename\":\"小米1\"}]', '');
INSERT INTO `reportstatus` VALUES ('903', '2017-10-06-12:10:00', '27.3℃', '79.1%', '关', '关', '正常', '正常', '正常', '[{\"pingstatus\":\"正常\",\"devicename\":\"小米1\"}]', '');
INSERT INTO `reportstatus` VALUES ('904', '2017-10-06-12:12:00', '27.3℃', '79.1%', '关', '关', '正常', '正常', '正常', '[{\"pingstatus\":\"正常\",\"devicename\":\"小米1\"}]', '');
INSERT INTO `reportstatus` VALUES ('905', '2017-10-06-12:14:00', '27.3℃', '79.1%', '关', '关', '正常', '正常', '正常', '[{\"pingstatus\":\"正常\",\"devicename\":\"小米1\"}]', '');
INSERT INTO `reportstatus` VALUES ('906', '2017-10-06-12:16:00', '27.3℃', '79.1%', '关', '关', '正常', '正常', '正常', '[{\"pingstatus\":\"正常\",\"devicename\":\"小米1\"}]', '');
INSERT INTO `reportstatus` VALUES ('907', '2017-10-06-12:18:00', '27.3℃', '79.1%', '关', '关', '正常', '正常', '正常', '[{\"pingstatus\":\"正常\",\"devicename\":\"小米1\"}]', '');
INSERT INTO `reportstatus` VALUES ('908', '2017-10-06-12:20:00', '27.3℃', '79.1%', '关', '关', '正常', '正常', '正常', '[{\"pingstatus\":\"正常\",\"devicename\":\"小米1\"}]', '');
INSERT INTO `reportstatus` VALUES ('909', '2017-10-06-12:22:00', '27.3℃', '79.1%', '关', '关', '正常', '正常', '正常', '[{\"pingstatus\":\"正常\",\"devicename\":\"小米1\"}]', '');
INSERT INTO `reportstatus` VALUES ('910', '2017-10-06-12:24:00', '27.3℃', '79.1%', '关', '关', '正常', '正常', '正常', '[{\"pingstatus\":\"正常\",\"devicename\":\"小米1\"}]', '');
INSERT INTO `reportstatus` VALUES ('911', '2017-10-06-12:26:00', '27.3℃', '79.1%', '关', '关', '正常', '正常', '正常', '[{\"pingstatus\":\"正常\",\"devicename\":\"小米1\"}]', '');
INSERT INTO `reportstatus` VALUES ('912', '2017-10-06-12:28:00', '27.3℃', '79.1%', '关', '关', '正常', '正常', '正常', '[{\"pingstatus\":\"正常\",\"devicename\":\"小米1\"}]', '');
INSERT INTO `reportstatus` VALUES ('913', '2017-10-06-12:30:00', '27.3℃', '79.1%', '关', '关', '正常', '正常', '正常', '[{\"pingstatus\":\"正常\",\"devicename\":\"小米1\"}]', '');
INSERT INTO `reportstatus` VALUES ('914', '2017-10-06-12:32:00', '27.3℃', '79.1%', '关', '关', '正常', '正常', '正常', '[{\"pingstatus\":\"正常\",\"devicename\":\"小米1\"}]', '');
INSERT INTO `reportstatus` VALUES ('915', '2017-10-06-12:34:00', '27.3℃', '79.1%', '关', '关', '正常', '正常', '正常', '[{\"pingstatus\":\"正常\",\"devicename\":\"小米1\"}]', '');
INSERT INTO `reportstatus` VALUES ('916', '2017-10-06-12:36:00', '27.3℃', '79.1%', '关', '关', '正常', '正常', '正常', '[{\"pingstatus\":\"正常\",\"devicename\":\"小米1\"}]', '');
INSERT INTO `reportstatus` VALUES ('917', '2017-10-06-12:38:00', '27.3℃', '79.1%', '关', '关', '正常', '正常', '正常', '[{\"pingstatus\":\"正常\",\"devicename\":\"小米1\"}]', '');
INSERT INTO `reportstatus` VALUES ('918', '2017-10-06-12:40:00', '27.3℃', '79.1%', '关', '关', '正常', '正常', '正常', '[{\"pingstatus\":\"正常\",\"devicename\":\"小米1\"}]', '');
INSERT INTO `reportstatus` VALUES ('919', '2017-10-06-12:42:00', '27.3℃', '79.1%', '关', '关', '正常', '正常', '正常', '[{\"pingstatus\":\"正常\",\"devicename\":\"小米1\"}]', '');
INSERT INTO `reportstatus` VALUES ('920', '2017-10-06-12:44:00', '27.3℃', '79.1%', '关', '关', '正常', '正常', '正常', '[{\"pingstatus\":\"正常\",\"devicename\":\"小米1\"}]', '');
INSERT INTO `reportstatus` VALUES ('921', '2017-10-06-12:46:00', '27.3℃', '79.1%', '关', '关', '正常', '正常', '正常', '[{\"pingstatus\":\"正常\",\"devicename\":\"小米1\"}]', '');
INSERT INTO `reportstatus` VALUES ('922', '2017-10-06-12:48:00', '27.3℃', '79.1%', '关', '关', '正常', '正常', '正常', '[{\"pingstatus\":\"正常\",\"devicename\":\"小米1\"}]', '');
INSERT INTO `reportstatus` VALUES ('923', '2017-10-06-12:50:00', '27.3℃', '79.1%', '关', '关', '正常', '正常', '正常', '[{\"pingstatus\":\"正常\",\"devicename\":\"小米1\"}]', '');
INSERT INTO `reportstatus` VALUES ('924', '2017-10-06-12:52:00', '27.3℃', '79.1%', '关', '关', '正常', '正常', '正常', '[{\"pingstatus\":\"正常\",\"devicename\":\"小米1\"}]', '');
INSERT INTO `reportstatus` VALUES ('925', '2017-10-06-12:54:00', '27.3℃', '79.1%', '关', '关', '正常', '正常', '正常', '[{\"pingstatus\":\"正常\",\"devicename\":\"小米1\"}]', '');
INSERT INTO `reportstatus` VALUES ('926', '2017-10-06-12:56:00', '27.3℃', '79.1%', '关', '关', '正常', '正常', '正常', '[{\"pingstatus\":\"正常\",\"devicename\":\"小米1\"}]', '');
INSERT INTO `reportstatus` VALUES ('927', '2017-10-06-12:58:00', '27.3℃', '79.1%', '关', '关', '正常', '正常', '正常', '[{\"pingstatus\":\"正常\",\"devicename\":\"小米1\"}]', '');
INSERT INTO `reportstatus` VALUES ('928', '2017-10-06-13:00:00', '27.3℃', '79.1%', '关', '关', '正常', '正常', '正常', '[{\"pingstatus\":\"正常\",\"devicename\":\"小米1\"}]', '');
INSERT INTO `reportstatus` VALUES ('929', '2017-10-06-13:02:00', '27.3℃', '79.1%', '关', '关', '正常', '正常', '正常', '[{\"pingstatus\":\"正常\",\"devicename\":\"小米1\"}]', '');
INSERT INTO `reportstatus` VALUES ('930', '2017-10-06-13:04:00', '27.3℃', '79.1%', '关', '关', '正常', '正常', '正常', '[{\"pingstatus\":\"正常\",\"devicename\":\"小米1\"}]', '');
INSERT INTO `reportstatus` VALUES ('931', '2017-10-06-13:06:00', '27.3℃', '79.1%', '关', '关', '正常', '正常', '正常', '[{\"pingstatus\":\"正常\",\"devicename\":\"小米1\"}]', '');
INSERT INTO `reportstatus` VALUES ('932', '2017-10-06-13:08:00', '27.3℃', '79.1%', '关', '关', '正常', '正常', '正常', '[{\"pingstatus\":\"正常\",\"devicename\":\"小米1\"}]', '');
INSERT INTO `reportstatus` VALUES ('933', '2017-10-06-13:10:00', '27.3℃', '79.1%', '关', '关', '正常', '正常', '正常', '[{\"pingstatus\":\"正常\",\"devicename\":\"小米1\"}]', '');
INSERT INTO `reportstatus` VALUES ('934', '2017-10-06-13:12:00', '27.3℃', '79.1%', '关', '关', '正常', '正常', '正常', '[{\"pingstatus\":\"正常\",\"devicename\":\"小米1\"}]', '');
INSERT INTO `reportstatus` VALUES ('935', '2017-10-06-13:14:00', '27.3℃', '79.1%', '关', '关', '正常', '正常', '正常', '[{\"pingstatus\":\"正常\",\"devicename\":\"小米1\"}]', '');
INSERT INTO `reportstatus` VALUES ('936', '2017-10-06-13:16:00', '27.3℃', '79.1%', '关', '关', '正常', '正常', '正常', '[{\"pingstatus\":\"正常\",\"devicename\":\"小米1\"}]', '');
INSERT INTO `reportstatus` VALUES ('937', '2017-10-06-13:18:00', '27.3℃', '79.1%', '关', '关', '正常', '正常', '正常', '[{\"pingstatus\":\"正常\",\"devicename\":\"小米1\"}]', '');
INSERT INTO `reportstatus` VALUES ('938', '2017-10-06-13:20:00', '27.3℃', '79.1%', '关', '关', '正常', '正常', '正常', '[{\"pingstatus\":\"正常\",\"devicename\":\"小米1\"}]', '');
INSERT INTO `reportstatus` VALUES ('939', '2017-10-06-13:22:00', '27.3℃', '79.1%', '关', '关', '正常', '正常', '正常', '[{\"pingstatus\":\"正常\",\"devicename\":\"小米1\"}]', '');
INSERT INTO `reportstatus` VALUES ('940', '2017-10-06-13:24:00', '27.3℃', '79.1%', '关', '关', '正常', '正常', '正常', '[{\"pingstatus\":\"正常\",\"devicename\":\"小米1\"}]', '');
INSERT INTO `reportstatus` VALUES ('941', '2017-10-06-13:26:00', '27.3℃', '79.1%', '关', '关', '正常', '正常', '正常', '[{\"pingstatus\":\"正常\",\"devicename\":\"小米1\"}]', '');
INSERT INTO `reportstatus` VALUES ('942', '2017-10-06-13:28:00', '27.3℃', '79.1%', '关', '关', '正常', '正常', '正常', '[{\"pingstatus\":\"正常\",\"devicename\":\"小米1\"}]', '');
INSERT INTO `reportstatus` VALUES ('943', '2017-10-06-13:30:00', '27.3℃', '79.1%', '关', '关', '正常', '正常', '正常', '[{\"pingstatus\":\"正常\",\"devicename\":\"小米1\"}]', '');
INSERT INTO `reportstatus` VALUES ('944', '2017-10-06-13:32:00', '27.3℃', '79.1%', '关', '关', '正常', '正常', '正常', '[{\"pingstatus\":\"正常\",\"devicename\":\"小米1\"}]', '');
INSERT INTO `reportstatus` VALUES ('945', '2017-10-06-13:34:00', '27.3℃', '79.1%', '关', '关', '正常', '正常', '正常', '[{\"pingstatus\":\"正常\",\"devicename\":\"小米1\"}]', '');
INSERT INTO `reportstatus` VALUES ('946', '2017-10-06-13:36:00', '27.3℃', '79.1%', '关', '关', '正常', '正常', '正常', '[{\"pingstatus\":\"正常\",\"devicename\":\"小米1\"}]', '');
INSERT INTO `reportstatus` VALUES ('947', '2017-10-06-13:38:00', '27.3℃', '79.1%', '关', '关', '正常', '正常', '正常', '[{\"pingstatus\":\"正常\",\"devicename\":\"小米1\"}]', '');
INSERT INTO `reportstatus` VALUES ('948', '2017-10-06-13:40:00', '27.3℃', '79.1%', '关', '关', '正常', '正常', '正常', '[{\"pingstatus\":\"正常\",\"devicename\":\"小米1\"}]', '');
INSERT INTO `reportstatus` VALUES ('949', '2017-10-06-13:42:00', '27.3℃', '79.1%', '关', '关', '正常', '正常', '正常', '[{\"pingstatus\":\"正常\",\"devicename\":\"小米1\"}]', '');
INSERT INTO `reportstatus` VALUES ('950', '2017-10-06-13:44:00', '27.3℃', '79.1%', '关', '关', '正常', '正常', '正常', '[{\"pingstatus\":\"正常\",\"devicename\":\"小米1\"}]', '');
INSERT INTO `reportstatus` VALUES ('951', '2017-10-06-13:46:00', '27.3℃', '79.1%', '关', '关', '正常', '正常', '正常', '[{\"pingstatus\":\"正常\",\"devicename\":\"小米1\"}]', '');
INSERT INTO `reportstatus` VALUES ('952', '2017-10-06-13:48:00', '27.3℃', '79.1%', '关', '关', '正常', '正常', '正常', '[{\"pingstatus\":\"正常\",\"devicename\":\"小米1\"}]', '');
INSERT INTO `reportstatus` VALUES ('953', '2017-10-06-13:50:00', '27.3℃', '79.1%', '关', '关', '正常', '正常', '正常', '[{\"pingstatus\":\"正常\",\"devicename\":\"小米1\"}]', '');
INSERT INTO `reportstatus` VALUES ('954', '2017-10-06-13:52:00', '27.3℃', '79.1%', '关', '关', '正常', '正常', '正常', '[{\"pingstatus\":\"正常\",\"devicename\":\"小米1\"}]', '');
INSERT INTO `reportstatus` VALUES ('955', '2017-10-06-13:54:00', '27.3℃', '79.1%', '关', '关', '正常', '正常', '正常', '[{\"pingstatus\":\"正常\",\"devicename\":\"小米1\"}]', '14023,');
INSERT INTO `reportstatus` VALUES ('956', '2017-10-06-13:56:00', '27.3℃', '79.1%', '关', '关', '正常', '正常', '正常', '[{\"pingstatus\":\"正常\",\"devicename\":\"小米1\"}]', '14024,14023,');
INSERT INTO `reportstatus` VALUES ('957', '2017-10-06-13:58:00', '27.3℃', '79.1%', '关', '关', '正常', '正常', '正常', '[{\"pingstatus\":\"正常\",\"devicename\":\"小米1\"}]', '14025,14024,14023,');
INSERT INTO `reportstatus` VALUES ('958', '2017-10-06-14:00:00', '27.3℃', '79.1%', '关', '关', '正常', '正常', '正常', '[{\"pingstatus\":\"正常\",\"devicename\":\"小米1\"}]', '14025,14024,14023,');
INSERT INTO `reportstatus` VALUES ('959', '2017-10-06-14:02:00', '27.3℃', '79.1%', '关', '关', '正常', '正常', '正常', '[{\"pingstatus\":\"正常\",\"devicename\":\"小米1\"}]', '14025,14024,14023,');
INSERT INTO `reportstatus` VALUES ('960', '2017-10-06-14:04:00', '27.3℃', '79.1%', '关', '关', '正常', '正常', '正常', '[{\"pingstatus\":\"正常\",\"devicename\":\"小米1\"}]', '14025,14024,14023,');
INSERT INTO `reportstatus` VALUES ('961', '2017-10-06-14:06:00', '27.3℃', '79.1%', '关', '关', '正常', '正常', '正常', '[{\"pingstatus\":\"正常\",\"devicename\":\"小米1\"}]', '14025,14024,14023,');
INSERT INTO `reportstatus` VALUES ('962', '2017-10-06-14:08:00', '27.3℃', '79.1%', '关', '关', '正常', '正常', '正常', '[{\"pingstatus\":\"正常\",\"devicename\":\"小米1\"}]', '14025,14024,14023,');
INSERT INTO `reportstatus` VALUES ('963', '2017-10-06-14:10:00', '27.3℃', '79.1%', '关', '关', '正常', '正常', '正常', '[{\"pingstatus\":\"正常\",\"devicename\":\"小米1\"}]', '14025,14024,14023,');
INSERT INTO `reportstatus` VALUES ('964', '2017-10-06-14:12:00', '27.3℃', '79.1%', '关', '关', '正常', '正常', '正常', '[{\"pingstatus\":\"正常\",\"devicename\":\"小米1\"}]', '14025,14024,14023,');
INSERT INTO `reportstatus` VALUES ('965', '2017-10-06-14:14:00', '27.3℃', '79.1%', '关', '关', '正常', '正常', '正常', '[{\"pingstatus\":\"正常\",\"devicename\":\"小米1\"}]', '14025,14024,14023,');
INSERT INTO `reportstatus` VALUES ('966', '2017-10-06-14:16:00', '27.3℃', '79.1%', '关', '关', '正常', '正常', '正常', '[{\"pingstatus\":\"正常\",\"devicename\":\"小米1\"}]', '14025,14024,14023,');
INSERT INTO `reportstatus` VALUES ('967', '2017-10-06-14:18:00', '27.3℃', '79.1%', '关', '关', '正常', '正常', '正常', '[{\"pingstatus\":\"正常\",\"devicename\":\"小米1\"}]', '14028,14027,14026,');
INSERT INTO `reportstatus` VALUES ('968', '2017-10-06-14:20:00', '27.3℃', '79.1%', '关', '关', '正常', '正常', '正常', '[{\"pingstatus\":\"正常\",\"devicename\":\"小米1\"}]', '14028,14027,14026,');
INSERT INTO `reportstatus` VALUES ('969', '2017-10-06-14:22:00', '27.3℃', '79.1%', '关', '关', '正常', '正常', '正常', '[{\"pingstatus\":\"正常\",\"devicename\":\"小米1\"}]', '14028,14027,14026,');
INSERT INTO `reportstatus` VALUES ('970', '2017-10-06-14:24:00', '27.3℃', '79.1%', '关', '关', '正常', '正常', '正常', '[{\"pingstatus\":\"正常\",\"devicename\":\"小米1\"}]', '14028,14027,14026,');
INSERT INTO `reportstatus` VALUES ('971', '2017-10-06-14:26:00', '27.3℃', '79.1%', '关', '关', '正常', '正常', '正常', '[{\"pingstatus\":\"正常\",\"devicename\":\"小米1\"}]', '14028,14027,14026,');
INSERT INTO `reportstatus` VALUES ('972', '2017-10-06-14:28:00', '27.3℃', '79.1%', '关', '关', '正常', '正常', '正常', '[{\"pingstatus\":\"正常\",\"devicename\":\"小米1\"}]', '14028,14027,14026,');
INSERT INTO `reportstatus` VALUES ('973', '2017-10-06-14:30:00', '27.3℃', '79.1%', '关', '关', '正常', '正常', '正常', '[{\"pingstatus\":\"正常\",\"devicename\":\"小米1\"}]', '14028,14027,14026,');
INSERT INTO `reportstatus` VALUES ('974', '2017-10-06-14:32:00', '27.3℃', '79.1%', '关', '关', '正常', '正常', '正常', '[{\"pingstatus\":\"正常\",\"devicename\":\"小米1\"}]', '14028,14027,14026,');
INSERT INTO `reportstatus` VALUES ('975', '2017-10-06-14:34:00', '27.3℃', '79.1%', '关', '关', '正常', '正常', '正常', '[{\"pingstatus\":\"正常\",\"devicename\":\"小米1\"}]', '14028,14027,14026,');
INSERT INTO `reportstatus` VALUES ('976', '2017-10-06-14:36:00', '27.3℃', '79.1%', '关', '关', '正常', '正常', '正常', '[{\"pingstatus\":\"正常\",\"devicename\":\"小米1\"}]', '14028,14027,14026,');
INSERT INTO `reportstatus` VALUES ('977', '2017-10-06-14:38:00', '27.3℃', '79.1%', '关', '关', '正常', '正常', '正常', '[{\"pingstatus\":\"正常\",\"devicename\":\"小米1\"}]', '');
INSERT INTO `reportstatus` VALUES ('978', '2017-10-06-14:40:00', '27.3℃', '79.1%', '关', '关', '正常', '正常', '正常', '[{\"pingstatus\":\"正常\",\"devicename\":\"小米1\"}]', '');
INSERT INTO `reportstatus` VALUES ('979', '2017-10-06-14:42:00', '27.3℃', '79.1%', '关', '关', '正常', '正常', '正常', '[{\"pingstatus\":\"正常\",\"devicename\":\"小米1\"}]', '14029,');
INSERT INTO `reportstatus` VALUES ('980', '2017-10-06-14:44:00', '27.3℃', '79.1%', '关', '关', '正常', '正常', '正常', '[{\"pingstatus\":\"正常\",\"devicename\":\"小米1\"}]', '14030,14029,');
INSERT INTO `reportstatus` VALUES ('981', '2017-10-06-14:46:00', '27.3℃', '79.1%', '关', '关', '正常', '正常', '正常', '[{\"pingstatus\":\"正常\",\"devicename\":\"小米1\"}]', '14030,14029,');
INSERT INTO `reportstatus` VALUES ('982', '2017-10-06-14:48:00', '27.3℃', '79.1%', '关', '关', '正常', '正常', '正常', '[{\"pingstatus\":\"正常\",\"devicename\":\"小米1\"}]', '14031,14030,14029,');
INSERT INTO `reportstatus` VALUES ('983', '2017-10-06-14:50:00', '27.3℃', '79.1%', '关', '关', '正常', '正常', '正常', '[{\"pingstatus\":\"正常\",\"devicename\":\"小米1\"}]', '14031,14030,14029,');
INSERT INTO `reportstatus` VALUES ('984', '2017-10-06-14:52:00', '27.3℃', '79.1%', '关', '关', '正常', '正常', '正常', '[{\"pingstatus\":\"正常\",\"devicename\":\"小米1\"}]', '14031,14030,14029,');
INSERT INTO `reportstatus` VALUES ('985', '2017-10-06-14:54:00', '27.3℃', '79.1%', '关', '关', '正常', '正常', '正常', '[{\"pingstatus\":\"正常\",\"devicename\":\"小米1\"}]', '14031,14030,14029,');
INSERT INTO `reportstatus` VALUES ('986', '2017-10-06-14:56:00', '27.3℃', '79.1%', '关', '关', '正常', '正常', '正常', '[{\"pingstatus\":\"正常\",\"devicename\":\"小米1\"}]', '14031,14030,14029,');
INSERT INTO `reportstatus` VALUES ('987', '2017-10-06-14:58:00', '27.3℃', '79.1%', '关', '关', '正常', '正常', '正常', '[{\"pingstatus\":\"正常\",\"devicename\":\"小米1\"}]', '14035,14034,14033,14032,');
INSERT INTO `reportstatus` VALUES ('988', '2017-10-08-13:00:00', '27.3℃', '79.1%', '开', '关', '正常', '正常', '正常', '[{\"pingstatus\":\"异常\",\"devicename\":\"xiaomi \"}]', '');
INSERT INTO `reportstatus` VALUES ('989', '2017-10-08-14:00:00', '27.3℃', '79.1%', '开', '关', '正常', '正常', '正常', '[{\"pingstatus\":\"异常\",\"devicename\":\"xiaomi \"}]', '');

-- ----------------------------
-- Table structure for role
-- ----------------------------
DROP TABLE IF EXISTS `role`;
CREATE TABLE `role` (
  `id` int(20) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `code` varchar(50) NOT NULL COMMENT '角色code',
  `rolename` varchar(100) NOT NULL COMMENT '角色名称',
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=5 DEFAULT CHARSET=utf8 COMMENT='角色表';

-- ----------------------------
-- Records of role
-- ----------------------------
INSERT INTO `role` VALUES ('1', 'superadmin', '超级管理员');
INSERT INTO `role` VALUES ('2', 'admin', '普通管理员');

-- ----------------------------
-- Table structure for saveconfig
-- ----------------------------
DROP TABLE IF EXISTS `saveconfig`;
CREATE TABLE `saveconfig` (
  `id` int(20) NOT NULL AUTO_INCREMENT,
  `save_config_title` varchar(50) NOT NULL COMMENT '定时保存名称',
  `startTime` varchar(50) DEFAULT NULL COMMENT '起始时间',
  `endTime` varchar(50) DEFAULT NULL COMMENT '结束时间',
  `deltaTime` varchar(10) DEFAULT NULL COMMENT '间隔时间',
  `lastTime` varchar(50) DEFAULT NULL COMMENT '最近保存时间',
  `lastData` varchar(1000) DEFAULT NULL COMMENT '最近数据',
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COMMENT='定时保存设置';

-- ----------------------------
-- Records of saveconfig
-- ----------------------------
INSERT INTO `saveconfig` VALUES ('1', '定时保存配置', '09:00', '14:00', '1', '20170811-1722', '温度:29.7℃,湿度:50.5%,前门:关,水浸:正常,红外:正常,烟感:正常,后门:关。');

-- ----------------------------
-- Table structure for threshold
-- ----------------------------
DROP TABLE IF EXISTS `threshold`;
CREATE TABLE `threshold` (
  `id` int(20) NOT NULL AUTO_INCREMENT COMMENT '阈值id',
  `code` varchar(50) NOT NULL COMMENT '阈值code',
  `thresholdname` varchar(50) NOT NULL COMMENT '阈值名称',
  `min` int(20) NOT NULL COMMENT '最小值',
  `max` int(20) NOT NULL COMMENT '最大值',
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COMMENT='阈值';

-- ----------------------------
-- Records of threshold
-- ----------------------------
INSERT INTO `threshold` VALUES ('1', 'temperature_threshold', '温度阈值', '0', '40');
INSERT INTO `threshold` VALUES ('2', 'humidity_threshold', '湿度阈值', '10', '70');

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` int(20) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `role` int(20) NOT NULL COMMENT '角色code',
  `username` varchar(50) NOT NULL COMMENT '用户名称',
  `password` char(40) NOT NULL COMMENT '用户密码',
  `realname` varchar(50) NOT NULL COMMENT '真是姓名',
  `email` varchar(50) NOT NULL COMMENT '邮箱地址',
  `phone` varchar(20) NOT NULL COMMENT '联系电话',
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=28 DEFAULT CHARSET=utf8 COMMENT='用户表';

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('1', '1', 'nsk', '1234', '超级管理员', 'wanleiltx@126.com', '18768132743');

-- ----------------------------
-- Table structure for warnlog
-- ----------------------------
DROP TABLE IF EXISTS `warnlog`;
CREATE TABLE `warnlog` (
  `id` int(20) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `warn_type` int(20) NOT NULL COMMENT '告警类型',
  `warn_description` varchar(200) DEFAULT NULL COMMENT '告警描述',
  `picture_url` varchar(200) DEFAULT NULL COMMENT '图片地址',
  `warn_time` datetime NOT NULL COMMENT '告警时间',
  `warn_state` tinyint(4) NOT NULL COMMENT '告警状态',
  `operation_detail` varchar(200) DEFAULT NULL,
  `complete_time` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=14059 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of warnlog
-- ----------------------------
INSERT INTO `warnlog` VALUES ('14058', '18', '预警散热风机电流为0.8A，正常电流在0A到0.2A之间;', null, '2017-10-08 17:15:02', '0', null, null);
INSERT INTO `warnlog` VALUES ('14057', '2', '当前湿度为79.1，正常湿度在0到70之间;', null, '2017-10-08 17:15:02', '0', null, null);
INSERT INTO `warnlog` VALUES ('14056', '3', '前门打开;', 'source/picture/20171008-171502-1.jpeg', '2017-10-08 17:15:02', '0', null, null);

-- ----------------------------
-- Table structure for warnstyle
-- ----------------------------
DROP TABLE IF EXISTS `warnstyle`;
CREATE TABLE `warnstyle` (
  `id` int(20) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `warnstylename` varchar(20) NOT NULL COMMENT '告警名称',
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=6 DEFAULT CHARSET=utf8 COMMENT='告警类型';

-- ----------------------------
-- Records of warnstyle
-- ----------------------------
INSERT INTO `warnstyle` VALUES ('1', '邮件告警');
INSERT INTO `warnstyle` VALUES ('4', '冻结告警');
INSERT INTO `warnstyle` VALUES ('3', '声光告警');
INSERT INTO `warnstyle` VALUES ('2', '短信告警');
INSERT INTO `warnstyle` VALUES ('5', '禁止告警');

-- ----------------------------
-- Table structure for warntimeperiod
-- ----------------------------
DROP TABLE IF EXISTS `warntimeperiod`;
CREATE TABLE `warntimeperiod` (
  `id` int(20) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `timeperiodname` varchar(50) NOT NULL,
  `Sunday` varchar(20) NOT NULL COMMENT '周日',
  `Monday` varchar(20) NOT NULL COMMENT '周一',
  `Tuesday` varchar(20) NOT NULL COMMENT '周二',
  `Wednesday` varchar(20) NOT NULL COMMENT '周三',
  `Thursday` varchar(20) NOT NULL COMMENT '周四',
  `Friday` varchar(20) NOT NULL COMMENT '周五',
  `Saturday` varchar(20) NOT NULL COMMENT '周六',
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=22 DEFAULT CHARSET=utf8 COMMENT='告警时段设置';

-- ----------------------------
-- Records of warntimeperiod
-- ----------------------------
INSERT INTO `warntimeperiod` VALUES ('3', '全时间段', '00:00-23:59', '00:00-23:59', '00:00-23:59', '00:00-23:59', '00:00-23:59', '00:00-23:59', '00:00-23:59');
INSERT INTO `warntimeperiod` VALUES ('10', '工作时间段', '10:00-10:00', '08:10-12:10', '07:30-17:30', '00:00-23:59', '16:45-16:30', '16:00-16:59', '16:00-16:59');

-- ----------------------------
-- Table structure for warntype
-- ----------------------------
DROP TABLE IF EXISTS `warntype`;
CREATE TABLE `warntype` (
  `id` int(20) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `warntypename` varchar(20) NOT NULL COMMENT '告警类型',
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=28 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of warntype
-- ----------------------------
INSERT INTO `warntype` VALUES ('2', '湿度报警');
INSERT INTO `warntype` VALUES ('3', '前门报警');
INSERT INTO `warntype` VALUES ('5', '冻结告警');
INSERT INTO `warntype` VALUES ('6', '水浸报警');
INSERT INTO `warntype` VALUES ('7', '红外报警');
INSERT INTO `warntype` VALUES ('8', '烟感报警');
INSERT INTO `warntype` VALUES ('11', '后门报警');
INSERT INTO `warntype` VALUES ('12', '压缩机1电流预警');
INSERT INTO `warntype` VALUES ('13', '压缩机1电流报警');
INSERT INTO `warntype` VALUES ('14', '离心风机1电流预警');
INSERT INTO `warntype` VALUES ('15', '离心风机1电流报警');
INSERT INTO `warntype` VALUES ('16', '离心风机2电流预警');
INSERT INTO `warntype` VALUES ('17', '离心风机2电流报警');
INSERT INTO `warntype` VALUES ('18', '散热风机电流预警');
INSERT INTO `warntype` VALUES ('19', '散热风机电流报警');
INSERT INTO `warntype` VALUES ('20', '循环风机电流预警');
INSERT INTO `warntype` VALUES ('21', '循环风机电流报警');
INSERT INTO `warntype` VALUES ('22', '柜内温度预警');
INSERT INTO `warntype` VALUES ('23', '柜内温度报警');
INSERT INTO `warntype` VALUES ('24', '环境温度预警');
INSERT INTO `warntype` VALUES ('25', '环境温度报警');
INSERT INTO `warntype` VALUES ('26', '压缩机2电流预警');
INSERT INTO `warntype` VALUES ('27', '压缩机2电流报警');
