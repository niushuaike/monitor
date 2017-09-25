/*
Navicat MySQL Data Transfer

Source Server         : 152
Source Server Version : 50623
Source Host           : 192.168.199.152:3306
Source Database       : monitor

Target Server Type    : MYSQL
Target Server Version : 50623
File Encoding         : 65001

Date: 2017-09-25 09:57:16
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for alarmthreshold
-- ----------------------------
DROP TABLE IF EXISTS `alarmthreshold`;
CREATE TABLE `alarmthreshold` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `jg_wd_min` varchar(10) DEFAULT NULL COMMENT '机柜温度报警阈值最小值',
  `jg_wd_max` varchar(10) DEFAULT NULL COMMENT '机柜温度报警阈值最大值',
  `jg_sd_min` varchar(10) DEFAULT NULL COMMENT '机柜湿度报警阈值最小值',
  `jg_sd_max` varchar(10) DEFAULT NULL COMMENT '机柜湿度报警阈值最大值',
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
  `xnwd_yj_min` varchar(10) DEFAULT '' COMMENT '内温度预警最小值箱',
  `xnwd_yj_max` varchar(10) DEFAULT NULL COMMENT '箱内温度预警最大值',
  `xnwd_gj_min` varchar(10) DEFAULT NULL COMMENT '箱内温度告警最小值',
  `xnwd_gj_max` varchar(10) DEFAULT NULL COMMENT '箱内温度告警最大值',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of alarmthreshold
-- ----------------------------
INSERT INTO `alarmthreshold` VALUES ('1', '0', '60', '10', '95', '1', '5', '1', '5', '0.05', '1', '0.05', '1', '0.05', '1', '0.05', '1', '0', '50', '1', '5', '1', '5', '0.05', '1', '0.05', '1', '0.05', '1', '0.05', '1', '0', '50', '0', '50', '0', '50');

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
  PRIMARY KEY (`mid`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of cabinetparamter
-- ----------------------------
INSERT INTO `cabinetparamter` VALUES ('1', '26', '9', '0', '30', '10', '0', '2', '10', '30', '20', '20', '15', '10', '1', '5', '1', '5', '1', '1', '0.05', '1', '0.05', '1', '0.05', '1', '0.05', 'dsadsa');

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
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=69 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of device
-- ----------------------------
INSERT INTO `device` VALUES ('52', '温湿度对对对', '192.168.199.105', '', '10', '1', '1', '10', '0', '', '1', 'nsk', '123', '河南省 漯河市 召陵区 是的范德萨 ', '1506151276107626100', '1');
INSERT INTO `device` VALUES ('68', 'asdf', 'asdf', 'asdf', '3', '5', '', '', '0', '', '2', 'sdf', 'g', '', '', '');

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
) ENGINE=InnoDB AUTO_INCREMENT=775 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of reportstatus
-- ----------------------------
INSERT INTO `reportstatus` VALUES ('700', '2017-09-22-11:42:00', '27.3℃', '79.1%', '开', '关', '正常', '正常', '正常', '[{\"pingstatus\":\"无法检测\",\"devicename\":\"小米地方干部吃饭是个\",\"hardware\":\"无法检测\"},{\"pingstatus\":\"无法检测\",\"devicename\":\"的说法都是\",\"hardware\":\"无法检测\"}]', '');
INSERT INTO `reportstatus` VALUES ('701', '2017-09-22-11:43:00', '27.3℃', '79.1%', '开', '关', '正常', '正常', '正常', '[{\"pingstatus\":\"无法检测\",\"devicename\":\"小米地方干部吃饭是个\",\"hardware\":\"无法检测\"},{\"pingstatus\":\"无法检测\",\"devicename\":\"的说法都是\",\"hardware\":\"无法检测\"}]', '');
INSERT INTO `reportstatus` VALUES ('702', '2017-09-22-11:44:00', '27.3℃', '79.1%', '开', '关', '正常', '正常', '正常', '[{\"pingstatus\":\"无法检测\",\"devicename\":\"小米地方干部吃饭是个\",\"hardware\":\"无法检测\"},{\"pingstatus\":\"无法检测\",\"devicename\":\"的说法都是\",\"hardware\":\"无法检测\"}]', '');
INSERT INTO `reportstatus` VALUES ('703', '2017-09-22-11:45:00', '27.3℃', '79.1%', '开', '关', '正常', '正常', '正常', '[{\"pingstatus\":\"无法检测\",\"devicename\":\"小米地方干部吃饭是个\",\"hardware\":\"无法检测\"},{\"pingstatus\":\"无法检测\",\"devicename\":\"的说法都是\",\"hardware\":\"无法检测\"}]', '');
INSERT INTO `reportstatus` VALUES ('704', '2017-09-22-11:46:00', '27.3℃', '79.1%', '开', '关', '正常', '正常', '正常', '[{\"pingstatus\":\"无法检测\",\"devicename\":\"小米地方干部吃饭是个\",\"hardware\":\"无法检测\"},{\"pingstatus\":\"无法检测\",\"devicename\":\"的说法都是\",\"hardware\":\"无法检测\"}]', '');
INSERT INTO `reportstatus` VALUES ('705', '2017-09-22-11:47:00', '27.3℃', '79.1%', '开', '关', '正常', '正常', '正常', '[{\"pingstatus\":\"无法检测\",\"devicename\":\"小米地方干部吃饭是个\",\"hardware\":\"无法检测\"},{\"pingstatus\":\"无法检测\",\"devicename\":\"的说法都是\",\"hardware\":\"无法检测\"}]', '');
INSERT INTO `reportstatus` VALUES ('706', '2017-09-22-11:48:00', '27.3℃', '79.1%', '开', '关', '正常', '正常', '正常', '[{\"pingstatus\":\"无法检测\",\"devicename\":\"小米地方干部吃饭是个\",\"hardware\":\"无法检测\"},{\"pingstatus\":\"无法检测\",\"devicename\":\"的说法都是\",\"hardware\":\"无法检测\"}]', '');
INSERT INTO `reportstatus` VALUES ('707', '2017-09-22-11:49:00', '27.3℃', '79.1%', '开', '关', '正常', '正常', '正常', '[{\"pingstatus\":\"无法检测\",\"devicename\":\"小米地方干部吃饭是个\",\"hardware\":\"无法检测\"},{\"pingstatus\":\"无法检测\",\"devicename\":\"的说法都是\",\"hardware\":\"无法检测\"}]', '');
INSERT INTO `reportstatus` VALUES ('708', '2017-09-22-11:50:00', '27.3℃', '79.1%', '开', '关', '正常', '正常', '正常', '[{\"pingstatus\":\"无法检测\",\"devicename\":\"小米地方干部吃饭是个\",\"hardware\":\"无法检测\"},{\"pingstatus\":\"无法检测\",\"devicename\":\"的说法都是\",\"hardware\":\"无法检测\"}]', '');
INSERT INTO `reportstatus` VALUES ('709', '2017-09-22-11:51:00', '27.3℃', '79.1%', '开', '关', '正常', '正常', '正常', '[{\"pingstatus\":\"无法检测\",\"devicename\":\"小米地方干部吃饭是个\",\"hardware\":\"无法检测\"},{\"pingstatus\":\"无法检测\",\"devicename\":\"的说法都是\",\"hardware\":\"无法检测\"}]', '');
INSERT INTO `reportstatus` VALUES ('710', '2017-09-22-11:52:00', '27.3℃', '79.1%', '开', '关', '正常', '正常', '正常', '[{\"pingstatus\":\"无法检测\",\"devicename\":\"小米地方干部吃饭是个\",\"hardware\":\"无法检测\"},{\"pingstatus\":\"无法检测\",\"devicename\":\"的说法都是\",\"hardware\":\"无法检测\"}]', '');
INSERT INTO `reportstatus` VALUES ('711', '2017-09-22-11:53:00', '27.3℃', '79.1%', '开', '关', '正常', '正常', '正常', '[{\"pingstatus\":\"无法检测\",\"devicename\":\"小米地方干部吃饭是个\",\"hardware\":\"无法检测\"},{\"pingstatus\":\"无法检测\",\"devicename\":\"的说法都是\",\"hardware\":\"无法检测\"}]', '');
INSERT INTO `reportstatus` VALUES ('712', '2017-09-22-11:54:00', '27.3℃', '79.1%', '开', '关', '正常', '正常', '正常', '[{\"pingstatus\":\"无法检测\",\"devicename\":\"小米地方干部吃饭是个\",\"hardware\":\"无法检测\"},{\"pingstatus\":\"无法检测\",\"devicename\":\"的说法都是\",\"hardware\":\"无法检测\"}]', '');
INSERT INTO `reportstatus` VALUES ('713', '2017-09-22-11:55:00', '27.3℃', '79.1%', '开', '关', '正常', '正常', '正常', '[{\"pingstatus\":\"无法检测\",\"devicename\":\"小米地方干部吃饭是个\",\"hardware\":\"无法检测\"},{\"pingstatus\":\"无法检测\",\"devicename\":\"的说法都是\",\"hardware\":\"无法检测\"}]', '');
INSERT INTO `reportstatus` VALUES ('714', '2017-09-22-11:56:00', '27.3℃', '79.1%', '开', '关', '正常', '正常', '正常', '[{\"pingstatus\":\"无法检测\",\"devicename\":\"小米地方干部吃饭是个\",\"hardware\":\"无法检测\"},{\"pingstatus\":\"无法检测\",\"devicename\":\"的说法都是\",\"hardware\":\"无法检测\"}]', '');
INSERT INTO `reportstatus` VALUES ('715', '2017-09-22-11:57:00', '27.3℃', '79.1%', '开', '关', '正常', '正常', '正常', '[{\"pingstatus\":\"无法检测\",\"devicename\":\"小米地方干部吃饭是个\",\"hardware\":\"无法检测\"},{\"pingstatus\":\"无法检测\",\"devicename\":\"的说法都是\",\"hardware\":\"无法检测\"}]', '');
INSERT INTO `reportstatus` VALUES ('716', '2017-09-22-11:58:00', '27.3℃', '79.1%', '开', '关', '正常', '正常', '正常', '[{\"pingstatus\":\"无法检测\",\"devicename\":\"小米地方干部吃饭是个\",\"hardware\":\"无法检测\"},{\"pingstatus\":\"无法检测\",\"devicename\":\"的说法都是\",\"hardware\":\"无法检测\"}]', '');
INSERT INTO `reportstatus` VALUES ('717', '2017-09-22-11:59:00', '27.3℃', '79.1%', '开', '关', '正常', '正常', '正常', '[{\"pingstatus\":\"无法检测\",\"devicename\":\"小米地方干部吃饭是个\",\"hardware\":\"无法检测\"},{\"pingstatus\":\"无法检测\",\"devicename\":\"的说法都是\",\"hardware\":\"无法检测\"}]', '');
INSERT INTO `reportstatus` VALUES ('718', '2017-09-22-12:00:00', '27.3℃', '79.1%', '开', '关', '正常', '正常', '正常', '[{\"pingstatus\":\"无法检测\",\"devicename\":\"小米地方干部吃饭是个\",\"hardware\":\"无法检测\"},{\"pingstatus\":\"无法检测\",\"devicename\":\"的说法都是\",\"hardware\":\"无法检测\"}]', '');
INSERT INTO `reportstatus` VALUES ('719', '2017-09-22-12:01:00', '27.3℃', '79.1%', '开', '关', '正常', '正常', '正常', '[{\"pingstatus\":\"无法检测\",\"devicename\":\"小米地方干部吃饭是个\",\"hardware\":\"无法检测\"},{\"pingstatus\":\"无法检测\",\"devicename\":\"的说法都是\",\"hardware\":\"无法检测\"}]', '');
INSERT INTO `reportstatus` VALUES ('720', '2017-09-22-12:02:00', '27.3℃', '79.1%', '开', '关', '正常', '正常', '正常', '[{\"pingstatus\":\"无法检测\",\"devicename\":\"小米地方干部吃饭是个\",\"hardware\":\"无法检测\"},{\"pingstatus\":\"无法检测\",\"devicename\":\"的说法都是\",\"hardware\":\"无法检测\"}]', '');
INSERT INTO `reportstatus` VALUES ('721', '2017-09-22-12:03:00', '27.3℃', '79.1%', '开', '关', '正常', '正常', '正常', '[{\"pingstatus\":\"无法检测\",\"devicename\":\"小米地方干部吃饭是个\",\"hardware\":\"无法检测\"},{\"pingstatus\":\"无法检测\",\"devicename\":\"的说法都是\",\"hardware\":\"无法检测\"}]', '');
INSERT INTO `reportstatus` VALUES ('722', '2017-09-22-12:04:00', '27.3℃', '79.1%', '开', '关', '正常', '正常', '正常', '[{\"pingstatus\":\"无法检测\",\"devicename\":\"小米地方干部吃饭是个\",\"hardware\":\"无法检测\"},{\"pingstatus\":\"无法检测\",\"devicename\":\"的说法都是\",\"hardware\":\"无法检测\"}]', '');
INSERT INTO `reportstatus` VALUES ('723', '2017-09-22-12:05:00', '27.3℃', '79.1%', '开', '关', '正常', '正常', '正常', '[{\"pingstatus\":\"无法检测\",\"devicename\":\"小米地方干部吃饭是个\",\"hardware\":\"无法检测\"},{\"pingstatus\":\"无法检测\",\"devicename\":\"的说法都是\",\"hardware\":\"无法检测\"}]', '');
INSERT INTO `reportstatus` VALUES ('724', '2017-09-22-12:06:00', '27.3℃', '79.1%', '开', '关', '正常', '正常', '正常', '[{\"pingstatus\":\"无法检测\",\"devicename\":\"小米地方干部吃饭是个\",\"hardware\":\"无法检测\"},{\"pingstatus\":\"无法检测\",\"devicename\":\"的说法都是\",\"hardware\":\"无法检测\"}]', '');
INSERT INTO `reportstatus` VALUES ('725', '2017-09-22-12:07:00', '27.3℃', '79.1%', '开', '关', '正常', '正常', '正常', '[{\"pingstatus\":\"无法检测\",\"devicename\":\"小米地方干部吃饭是个\",\"hardware\":\"无法检测\"},{\"pingstatus\":\"无法检测\",\"devicename\":\"的说法都是\",\"hardware\":\"无法检测\"}]', '');
INSERT INTO `reportstatus` VALUES ('726', '2017-09-22-12:08:00', '27.3℃', '79.1%', '开', '关', '正常', '正常', '正常', '[{\"pingstatus\":\"无法检测\",\"devicename\":\"小米地方干部吃饭是个\",\"hardware\":\"无法检测\"},{\"pingstatus\":\"无法检测\",\"devicename\":\"的说法都是\",\"hardware\":\"无法检测\"}]', '');
INSERT INTO `reportstatus` VALUES ('727', '2017-09-22-12:09:00', '27.3℃', '79.1%', '开', '关', '正常', '正常', '正常', '[{\"pingstatus\":\"无法检测\",\"devicename\":\"小米地方干部吃饭是个\",\"hardware\":\"无法检测\"},{\"pingstatus\":\"无法检测\",\"devicename\":\"的说法都是\",\"hardware\":\"无法检测\"}]', '');
INSERT INTO `reportstatus` VALUES ('728', '2017-09-22-12:10:00', '27.3℃', '79.1%', '开', '关', '正常', '正常', '正常', '[{\"pingstatus\":\"无法检测\",\"devicename\":\"小米地方干部吃饭是个\",\"hardware\":\"无法检测\"},{\"pingstatus\":\"无法检测\",\"devicename\":\"的说法都是\",\"hardware\":\"无法检测\"}]', '');
INSERT INTO `reportstatus` VALUES ('729', '2017-09-22-12:11:00', '27.3℃', '79.1%', '开', '关', '正常', '正常', '正常', '[{\"pingstatus\":\"无法检测\",\"devicename\":\"小米地方干部吃饭是个\",\"hardware\":\"无法检测\"},{\"pingstatus\":\"无法检测\",\"devicename\":\"的说法都是\",\"hardware\":\"无法检测\"}]', '');
INSERT INTO `reportstatus` VALUES ('730', '2017-09-22-12:12:00', '27.3℃', '79.1%', '开', '关', '正常', '正常', '正常', '[{\"pingstatus\":\"无法检测\",\"devicename\":\"小米地方干部吃饭是个\",\"hardware\":\"无法检测\"},{\"pingstatus\":\"无法检测\",\"devicename\":\"的说法都是\",\"hardware\":\"无法检测\"}]', '');
INSERT INTO `reportstatus` VALUES ('731', '2017-09-22-12:13:00', '27.3℃', '79.1%', '开', '关', '正常', '正常', '正常', '[{\"pingstatus\":\"无法检测\",\"devicename\":\"小米地方干部吃饭是个\",\"hardware\":\"无法检测\"},{\"pingstatus\":\"无法检测\",\"devicename\":\"的说法都是\",\"hardware\":\"无法检测\"}]', '');
INSERT INTO `reportstatus` VALUES ('732', '2017-09-22-12:14:00', '27.3℃', '79.1%', '开', '关', '正常', '正常', '正常', '[{\"pingstatus\":\"无法检测\",\"devicename\":\"小米地方干部吃饭是个\",\"hardware\":\"无法检测\"},{\"pingstatus\":\"无法检测\",\"devicename\":\"的说法都是\",\"hardware\":\"无法检测\"}]', '');
INSERT INTO `reportstatus` VALUES ('733', '2017-09-22-12:15:00', '27.3℃', '79.1%', '开', '关', '正常', '正常', '正常', '[{\"pingstatus\":\"无法检测\",\"devicename\":\"小米地方干部吃饭是个\",\"hardware\":\"无法检测\"},{\"pingstatus\":\"无法检测\",\"devicename\":\"的说法都是\",\"hardware\":\"无法检测\"}]', '');
INSERT INTO `reportstatus` VALUES ('734', '2017-09-22-12:16:00', '27.3℃', '79.1%', '开', '关', '正常', '正常', '正常', '[{\"pingstatus\":\"无法检测\",\"devicename\":\"小米地方干部吃饭是个\",\"hardware\":\"无法检测\"},{\"pingstatus\":\"无法检测\",\"devicename\":\"的说法都是\",\"hardware\":\"无法检测\"}]', '');
INSERT INTO `reportstatus` VALUES ('735', '2017-09-22-12:17:00', '27.3℃', '79.1%', '开', '关', '正常', '正常', '正常', '[{\"pingstatus\":\"无法检测\",\"devicename\":\"小米地方干部吃饭是个\",\"hardware\":\"无法检测\"},{\"pingstatus\":\"无法检测\",\"devicename\":\"的说法都是\",\"hardware\":\"无法检测\"}]', '');
INSERT INTO `reportstatus` VALUES ('736', '2017-09-22-12:18:00', '27.3℃', '79.1%', '开', '关', '正常', '正常', '正常', '[{\"pingstatus\":\"无法检测\",\"devicename\":\"小米地方干部吃饭是个\",\"hardware\":\"无法检测\"},{\"pingstatus\":\"无法检测\",\"devicename\":\"的说法都是\",\"hardware\":\"无法检测\"}]', '');
INSERT INTO `reportstatus` VALUES ('737', '2017-09-22-12:19:00', '27.3℃', '79.1%', '开', '关', '正常', '正常', '正常', '[{\"pingstatus\":\"无法检测\",\"devicename\":\"小米地方干部吃饭是个\",\"hardware\":\"无法检测\"},{\"pingstatus\":\"无法检测\",\"devicename\":\"的说法都是\",\"hardware\":\"无法检测\"}]', '');
INSERT INTO `reportstatus` VALUES ('738', '2017-09-22-12:20:00', '27.3℃', '79.1%', '开', '关', '正常', '正常', '正常', '[{\"pingstatus\":\"无法检测\",\"devicename\":\"小米地方干部吃饭是个\",\"hardware\":\"无法检测\"},{\"pingstatus\":\"无法检测\",\"devicename\":\"的说法都是\",\"hardware\":\"无法检测\"}]', '');
INSERT INTO `reportstatus` VALUES ('739', '2017-09-22-12:21:00', '27.3℃', '79.1%', '开', '关', '正常', '正常', '正常', '[{\"pingstatus\":\"无法检测\",\"devicename\":\"小米地方干部吃饭是个\",\"hardware\":\"无法检测\"},{\"pingstatus\":\"无法检测\",\"devicename\":\"的说法都是\",\"hardware\":\"无法检测\"}]', '');
INSERT INTO `reportstatus` VALUES ('740', '2017-09-22-12:22:00', '27.3℃', '79.1%', '开', '关', '正常', '正常', '正常', '[{\"pingstatus\":\"无法检测\",\"devicename\":\"小米地方干部吃饭是个\",\"hardware\":\"无法检测\"},{\"pingstatus\":\"无法检测\",\"devicename\":\"的说法都是\",\"hardware\":\"无法检测\"}]', '');
INSERT INTO `reportstatus` VALUES ('741', '2017-09-22-12:23:00', '27.3℃', '79.1%', '开', '关', '正常', '正常', '正常', '[{\"pingstatus\":\"无法检测\",\"devicename\":\"小米地方干部吃饭是个\",\"hardware\":\"无法检测\"},{\"pingstatus\":\"无法检测\",\"devicename\":\"的说法都是\",\"hardware\":\"无法检测\"}]', '');
INSERT INTO `reportstatus` VALUES ('742', '2017-09-22-12:24:00', '27.3℃', '79.1%', '开', '关', '正常', '正常', '正常', '[{\"pingstatus\":\"无法检测\",\"devicename\":\"小米地方干部吃饭是个\",\"hardware\":\"无法检测\"},{\"pingstatus\":\"无法检测\",\"devicename\":\"的说法都是\",\"hardware\":\"无法检测\"}]', '');
INSERT INTO `reportstatus` VALUES ('743', '2017-09-22-12:25:00', '27.3℃', '79.1%', '开', '关', '正常', '正常', '正常', '[{\"pingstatus\":\"无法检测\",\"devicename\":\"小米地方干部吃饭是个\",\"hardware\":\"无法检测\"},{\"pingstatus\":\"无法检测\",\"devicename\":\"的说法都是\",\"hardware\":\"无法检测\"}]', '');
INSERT INTO `reportstatus` VALUES ('744', '2017-09-22-12:26:00', '27.3℃', '79.1%', '开', '关', '正常', '正常', '正常', '[{\"pingstatus\":\"无法检测\",\"devicename\":\"小米地方干部吃饭是个\",\"hardware\":\"无法检测\"},{\"pingstatus\":\"无法检测\",\"devicename\":\"的说法都是\",\"hardware\":\"无法检测\"}]', '');
INSERT INTO `reportstatus` VALUES ('745', '2017-09-22-12:27:00', '27.3℃', '79.1%', '开', '关', '正常', '正常', '正常', '[{\"pingstatus\":\"无法检测\",\"devicename\":\"小米地方干部吃饭是个\",\"hardware\":\"无法检测\"},{\"pingstatus\":\"无法检测\",\"devicename\":\"的说法都是\",\"hardware\":\"无法检测\"}]', '');
INSERT INTO `reportstatus` VALUES ('746', '2017-09-22-12:28:00', '27.3℃', '79.1%', '开', '关', '正常', '正常', '正常', '[{\"pingstatus\":\"无法检测\",\"devicename\":\"小米地方干部吃饭是个\",\"hardware\":\"无法检测\"},{\"pingstatus\":\"无法检测\",\"devicename\":\"的说法都是\",\"hardware\":\"无法检测\"}]', '');
INSERT INTO `reportstatus` VALUES ('747', '2017-09-22-12:29:00', '27.3℃', '79.1%', '开', '关', '正常', '正常', '正常', '[{\"pingstatus\":\"无法检测\",\"devicename\":\"小米地方干部吃饭是个\",\"hardware\":\"无法检测\"},{\"pingstatus\":\"无法检测\",\"devicename\":\"的说法都是\",\"hardware\":\"无法检测\"}]', '');
INSERT INTO `reportstatus` VALUES ('748', '2017-09-22-12:30:00', '27.3℃', '79.1%', '开', '关', '正常', '正常', '正常', '[{\"pingstatus\":\"无法检测\",\"devicename\":\"小米地方干部吃饭是个\",\"hardware\":\"无法检测\"},{\"pingstatus\":\"无法检测\",\"devicename\":\"的说法都是\",\"hardware\":\"无法检测\"}]', '');
INSERT INTO `reportstatus` VALUES ('749', '2017-09-22-12:31:00', '27.3℃', '79.1%', '开', '关', '正常', '正常', '正常', '[{\"pingstatus\":\"无法检测\",\"devicename\":\"小米地方干部吃饭是个\",\"hardware\":\"无法检测\"},{\"pingstatus\":\"无法检测\",\"devicename\":\"的说法都是\",\"hardware\":\"无法检测\"}]', '');
INSERT INTO `reportstatus` VALUES ('750', '2017-09-22-12:32:00', '27.3℃', '79.1%', '开', '关', '正常', '正常', '正常', '[{\"pingstatus\":\"无法检测\",\"devicename\":\"小米地方干部吃饭是个\",\"hardware\":\"无法检测\"},{\"pingstatus\":\"无法检测\",\"devicename\":\"的说法都是\",\"hardware\":\"无法检测\"}]', '');
INSERT INTO `reportstatus` VALUES ('751', '2017-09-22-12:33:00', '27.3℃', '79.1%', '开', '关', '正常', '正常', '正常', '[{\"pingstatus\":\"无法检测\",\"devicename\":\"小米地方干部吃饭是个\",\"hardware\":\"无法检测\"},{\"pingstatus\":\"无法检测\",\"devicename\":\"的说法都是\",\"hardware\":\"无法检测\"}]', '');
INSERT INTO `reportstatus` VALUES ('752', '2017-09-22-12:34:00', '27.3℃', '79.1%', '开', '关', '正常', '正常', '正常', '[{\"pingstatus\":\"无法检测\",\"devicename\":\"小米地方干部吃饭是个\",\"hardware\":\"无法检测\"},{\"pingstatus\":\"无法检测\",\"devicename\":\"的说法都是\",\"hardware\":\"无法检测\"}]', '');
INSERT INTO `reportstatus` VALUES ('753', '2017-09-22-12:35:00', '27.3℃', '79.1%', '开', '关', '正常', '正常', '正常', '[{\"pingstatus\":\"无法检测\",\"devicename\":\"小米地方干部吃饭是个\",\"hardware\":\"无法检测\"},{\"pingstatus\":\"无法检测\",\"devicename\":\"的说法都是\",\"hardware\":\"无法检测\"}]', '');
INSERT INTO `reportstatus` VALUES ('754', '2017-09-22-12:36:00', '27.3℃', '79.1%', '开', '关', '正常', '正常', '正常', '[{\"pingstatus\":\"无法检测\",\"devicename\":\"小米地方干部吃饭是个\",\"hardware\":\"无法检测\"},{\"pingstatus\":\"无法检测\",\"devicename\":\"的说法都是\",\"hardware\":\"无法检测\"}]', '');
INSERT INTO `reportstatus` VALUES ('755', '2017-09-22-12:37:00', '27.3℃', '79.1%', '开', '关', '正常', '正常', '正常', '[{\"pingstatus\":\"无法检测\",\"devicename\":\"小米地方干部吃饭是个\",\"hardware\":\"无法检测\"},{\"pingstatus\":\"无法检测\",\"devicename\":\"的说法都是\",\"hardware\":\"无法检测\"}]', '');
INSERT INTO `reportstatus` VALUES ('756', '2017-09-22-12:38:00', '27.3℃', '79.1%', '开', '关', '正常', '正常', '正常', '[{\"pingstatus\":\"无法检测\",\"devicename\":\"小米地方干部吃饭是个\",\"hardware\":\"无法检测\"},{\"pingstatus\":\"无法检测\",\"devicename\":\"的说法都是\",\"hardware\":\"无法检测\"}]', '');
INSERT INTO `reportstatus` VALUES ('757', '2017-09-22-12:39:00', '27.3℃', '79.1%', '开', '关', '正常', '正常', '正常', '[{\"pingstatus\":\"无法检测\",\"devicename\":\"小米地方干部吃饭是个\",\"hardware\":\"无法检测\"},{\"pingstatus\":\"无法检测\",\"devicename\":\"的说法都是\",\"hardware\":\"无法检测\"}]', '');
INSERT INTO `reportstatus` VALUES ('758', '2017-09-22-12:40:00', '27.3℃', '79.1%', '开', '关', '正常', '正常', '正常', '[{\"pingstatus\":\"无法检测\",\"devicename\":\"小米地方干部吃饭是个\",\"hardware\":\"无法检测\"},{\"pingstatus\":\"无法检测\",\"devicename\":\"的说法都是\",\"hardware\":\"无法检测\"}]', '');
INSERT INTO `reportstatus` VALUES ('759', '2017-09-22-12:41:00', '27.3℃', '79.1%', '开', '关', '正常', '正常', '正常', '[{\"pingstatus\":\"无法检测\",\"devicename\":\"小米地方干部吃饭是个\",\"hardware\":\"无法检测\"},{\"pingstatus\":\"无法检测\",\"devicename\":\"的说法都是\",\"hardware\":\"无法检测\"}]', '');
INSERT INTO `reportstatus` VALUES ('760', '2017-09-22-12:42:00', '27.3℃', '79.1%', '开', '关', '正常', '正常', '正常', '[{\"pingstatus\":\"无法检测\",\"devicename\":\"小米地方干部吃饭是个\",\"hardware\":\"无法检测\"},{\"pingstatus\":\"无法检测\",\"devicename\":\"的说法都是\",\"hardware\":\"无法检测\"}]', '');
INSERT INTO `reportstatus` VALUES ('761', '2017-09-22-12:43:00', '27.3℃', '79.1%', '开', '关', '正常', '正常', '正常', '[{\"pingstatus\":\"无法检测\",\"devicename\":\"小米地方干部吃饭是个\",\"hardware\":\"无法检测\"},{\"pingstatus\":\"无法检测\",\"devicename\":\"的说法都是\",\"hardware\":\"无法检测\"}]', '');
INSERT INTO `reportstatus` VALUES ('762', '2017-09-22-12:44:00', '27.3℃', '79.1%', '开', '关', '正常', '正常', '正常', '[{\"pingstatus\":\"无法检测\",\"devicename\":\"小米地方干部吃饭是个\",\"hardware\":\"无法检测\"},{\"pingstatus\":\"无法检测\",\"devicename\":\"的说法都是\",\"hardware\":\"无法检测\"}]', '');
INSERT INTO `reportstatus` VALUES ('763', '2017-09-22-12:45:00', '27.3℃', '79.1%', '开', '关', '正常', '正常', '正常', '[{\"pingstatus\":\"无法检测\",\"devicename\":\"小米地方干部吃饭是个\",\"hardware\":\"无法检测\"},{\"pingstatus\":\"无法检测\",\"devicename\":\"的说法都是\",\"hardware\":\"无法检测\"}]', '');
INSERT INTO `reportstatus` VALUES ('764', '2017-09-22-12:46:00', '27.3℃', '79.1%', '开', '关', '正常', '正常', '正常', '[{\"pingstatus\":\"无法检测\",\"devicename\":\"小米地方干部吃饭是个\",\"hardware\":\"无法检测\"},{\"pingstatus\":\"无法检测\",\"devicename\":\"的说法都是\",\"hardware\":\"无法检测\"}]', '');
INSERT INTO `reportstatus` VALUES ('765', '2017-09-22-12:47:00', '27.3℃', '79.1%', '开', '关', '正常', '正常', '正常', '[{\"pingstatus\":\"无法检测\",\"devicename\":\"小米地方干部吃饭是个\",\"hardware\":\"无法检测\"},{\"pingstatus\":\"无法检测\",\"devicename\":\"的说法都是\",\"hardware\":\"无法检测\"}]', '');
INSERT INTO `reportstatus` VALUES ('766', '2017-09-22-12:48:00', '27.3℃', '79.1%', '开', '关', '正常', '正常', '正常', '[{\"pingstatus\":\"无法检测\",\"devicename\":\"小米地方干部吃饭是个\",\"hardware\":\"无法检测\"},{\"pingstatus\":\"无法检测\",\"devicename\":\"的说法都是\",\"hardware\":\"无法检测\"}]', '');
INSERT INTO `reportstatus` VALUES ('767', '2017-09-22-12:49:00', '27.3℃', '79.1%', '开', '关', '正常', '正常', '正常', '[{\"pingstatus\":\"无法检测\",\"devicename\":\"小米地方干部吃饭是个\",\"hardware\":\"无法检测\"},{\"pingstatus\":\"无法检测\",\"devicename\":\"的说法都是\",\"hardware\":\"无法检测\"}]', '');
INSERT INTO `reportstatus` VALUES ('768', '2017-09-22-12:50:00', '27.3℃', '79.1%', '开', '关', '正常', '正常', '正常', '[{\"pingstatus\":\"无法检测\",\"devicename\":\"小米地方干部吃饭是个\",\"hardware\":\"无法检测\"},{\"pingstatus\":\"无法检测\",\"devicename\":\"的说法都是\",\"hardware\":\"无法检测\"}]', '');
INSERT INTO `reportstatus` VALUES ('769', '2017-09-22-12:51:00', '27.3℃', '79.1%', '开', '关', '正常', '正常', '正常', '[{\"pingstatus\":\"无法检测\",\"devicename\":\"小米地方干部吃饭是个\",\"hardware\":\"无法检测\"},{\"pingstatus\":\"无法检测\",\"devicename\":\"的说法都是\",\"hardware\":\"无法检测\"}]', '');
INSERT INTO `reportstatus` VALUES ('770', '2017-09-22-12:52:13', '27.3℃', '79.1%', '开', '关', '正常', '正常', '正常', '[{\"pingstatus\":\"无法检测\",\"devicename\":\"小米地方干部吃饭是个\",\"hardware\":\"无法检测\"},{\"pingstatus\":\"无法检测\",\"devicename\":\"的说法都是\",\"hardware\":\"无法检测\"}]', '');
INSERT INTO `reportstatus` VALUES ('771', '2017-09-22-12:53:02', '27.3℃', '79.1%', '开', '关', '正常', '正常', '正常', '[{\"pingstatus\":\"无法检测\",\"devicename\":\"小米地方干部吃饭是个\",\"hardware\":\"无法检测\"},{\"pingstatus\":\"无法检测\",\"devicename\":\"的说法都是\",\"hardware\":\"无法检测\"}]', '');
INSERT INTO `reportstatus` VALUES ('772', '2017-09-22-12:54:34', '27.3℃', '79.1%', '开', '关', '正常', '正常', '正常', '[{\"pingstatus\":\"无法检测\",\"devicename\":\"小米地方干部吃饭是个\",\"hardware\":\"无法检测\"},{\"pingstatus\":\"无法检测\",\"devicename\":\"的说法都是\",\"hardware\":\"无法检测\"}]', '');

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
  `deltaTime` varchar(2) DEFAULT NULL COMMENT '间隔时间',
  `lastTime` varchar(50) DEFAULT NULL COMMENT '最近保存时间',
  `lastData` varchar(1000) DEFAULT NULL COMMENT '最近数据',
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COMMENT='定时保存设置';

-- ----------------------------
-- Records of saveconfig
-- ----------------------------
INSERT INTO `saveconfig` VALUES ('1', '定时保存配置', '02:00', '24:00', '1', '20170811-1722', '温度:29.7℃,湿度:50.5%,前门:关,水浸:正常,红外:正常,烟感:正常,后门:关。');

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
) ENGINE=MyISAM AUTO_INCREMENT=25 DEFAULT CHARSET=utf8 COMMENT='用户表';

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
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=13475 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of warnlog
-- ----------------------------
INSERT INTO `warnlog` VALUES ('13473', '7', '红外异常', null, '2017-09-24 15:23:16', '3', null);
INSERT INTO `warnlog` VALUES ('13474', '15', '告警离心风机1电流为1.4A，正常电流在1A到0.05A之间。', null, '2017-09-24 16:29:38', '3', null);
INSERT INTO `warnlog` VALUES ('13471', '21', '告警循环风机电流为1.8A，正常电流在0.05A到1A之间。', null, '2017-09-24 14:56:39', '3', null);
INSERT INTO `warnlog` VALUES ('13472', '23', '告警箱内温度为88.0℃，正常温度在0℃到50℃之间。', null, '2017-09-24 14:56:39', '3', null);
INSERT INTO `warnlog` VALUES ('13470', '19', '告警散热风机电流为1.7A，正常电流在0.05A到1A之间。', null, '2017-09-24 14:56:39', '3', null);
INSERT INTO `warnlog` VALUES ('13469', '17', '告警离心风机2电流为1.5A，正常电流在1A到0.05A之间。', null, '2017-09-24 14:56:39', '3', null);
INSERT INTO `warnlog` VALUES ('13468', '15', '告警离心风机1电流为1.4A，正常电流在1A到0.05A之间。', null, '2017-09-24 14:56:39', '4', null);
INSERT INTO `warnlog` VALUES ('13467', '2', '当前湿度为82.0%，正常湿度在10%到70%之间。', null, '2017-09-24 14:56:39', '3', null);
INSERT INTO `warnlog` VALUES ('13466', '3', '前门打开;', 'source/picture/20170924-145638-1.jpeg', '2017-09-24 14:56:38', '3', null);

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
) ENGINE=MyISAM AUTO_INCREMENT=14 DEFAULT CHARSET=utf8 COMMENT='告警时段设置';

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
INSERT INTO `warntype` VALUES ('1', '温度报警');
INSERT INTO `warntype` VALUES ('2', '湿度报警');
INSERT INTO `warntype` VALUES ('3', '前门报警');
INSERT INTO `warntype` VALUES ('4', '服务器告警');
INSERT INTO `warntype` VALUES ('5', '冻结报警');
INSERT INTO `warntype` VALUES ('6', '水浸报警');
INSERT INTO `warntype` VALUES ('7', '红外报警');
INSERT INTO `warntype` VALUES ('8', '烟感报警');
INSERT INTO `warntype` VALUES ('9', '机组告警');
INSERT INTO `warntype` VALUES ('10', '短信告警');
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
INSERT INTO `warntype` VALUES ('22', '箱内温度预警');
INSERT INTO `warntype` VALUES ('23', '箱内温度报警');
INSERT INTO `warntype` VALUES ('24', '环境温度预警');
INSERT INTO `warntype` VALUES ('25', '环境温度报警');
INSERT INTO `warntype` VALUES ('26', '压缩机2电流预警');
INSERT INTO `warntype` VALUES ('27', '压缩机2电流报警');
