package com.micropower.manager.utils;

import com.alibaba.fastjson.JSON;
import com.lycheeframework.core.common.util.SpringUtil;
import com.micropower.manager.model.po.*;
import com.micropower.manager.service.AlarmthresholdService;
import com.micropower.manager.service.DeviceService;
import com.micropower.manager.service.WarnLogService;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.WebResource;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import javax.servlet.ServletContext;
import java.io.*;
import java.net.InetAddress;
import java.net.URLEncoder;
import java.net.UnknownHostException;
import java.sql.PreparedStatement;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by niushuaike on 2017/9/19.
 */
@Component
public class ScheduleMonitorRunnable implements Runnable {

    private SimpleDateFormat warntimeformat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    @Autowired
    private AlarmthresholdService alarmthresholdService;

    @Autowired
    private WarnLogService warnLogService;

    @Autowired
    private DeviceService deviceService;

    @Autowired
    private ServletContext servletContext;

    private boolean isDispatcher = false;

    private boolean ysjOneStart = false;
    private Date ysjOneStartWarnTime;

    private boolean ysjTwoStart = false;
    private Date ysjTwoStartWarnTime;

    private boolean lxfjOneStart = false;
    private Date lxfjOneStartWarnTime;

    private boolean lxfjTwoStart = false;
    private Date lxfjTwoStartWarnTime;

    private boolean srfjStart = false;
    private Date srfjStartWarnTime;

    private boolean xhfjStart = false;
    private Date xhfjStartWarnTime;

    private boolean hjkzStart = false;
    private Date hjkzStartWarnTime;

    private boolean xnwdStart = false;
    private Date xnwdStartWarnTime;

    private String mainControlIp;

    public ScheduleMonitorRunnable() {
    }

    @Override
    public void run() {

        boolean isNormal = true;

        //实时解析文件
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMdd");
        String file = dateFormat.format(new Date()) + ".data";
        RawData rawData = null;
        RawDataP rawDataP = null;
        try {
            rawData = ParseDataUtil.parseRecentOneData((String) servletContext.getAttribute("cabinet_data_path"));
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            rawDataP = PParseDataUtil.parseRecentOneData((String) servletContext.getAttribute("labor_data_path"));
        } catch (IOException e) {
            e.printStackTrace();
        }

        char[] startStatus = rawDataP.getSbktzt().toCharArray();

        //返回大后台数据，状态信息和告警信息
        Map<String, String> statusmap = new HashMap<>();
        StringBuffer warninfo = new StringBuffer();
        statusmap = OxConvertUtil.obj2Map(rawData);
        Map<String, String> laborstatus = OxConvertUtil.obj2Map(rawDataP);
        statusmap.putAll(laborstatus);

        //初始化告警状态
        statusmap.put("humiditystatus", "0");
        statusmap.put("temperaturestatus", "0");

        statusmap.put("ysjOneStatus", "0");
        statusmap.put("ysjTwoStatus", "0");
        statusmap.put("srfjStatus", "0");

        statusmap.put("lxfjOneStatus", "0");
        statusmap.put("lxfjTwoStatus", "0");
        statusmap.put("xhfjStatus", "0");
        statusmap.put("hjkzStatus", "0");


        servletContext.setAttribute("warnFrontGate", "");
        servletContext.setAttribute("warnBackGate", "");
        servletContext.setAttribute("warnSmoke", "");
        servletContext.setAttribute("warnInfrared", "");
        servletContext.setAttribute("warnFlood", "");

        servletContext.setAttribute("warnHumiditystatus", "");
        servletContext.setAttribute("xnwdStatus", "");

        servletContext.setAttribute("ysjOneStatus", "");
        servletContext.setAttribute("ysjTwoStatus", "");
        servletContext.setAttribute("srfjStatus", "");

        servletContext.setAttribute("lxfjOneStatus", "");
        servletContext.setAttribute("lxfjTwoStatus", "");
        servletContext.setAttribute("xhfjStatus", "");
        servletContext.setAttribute("hjkzStatus", "");


        //门开的时候修改派工状态为维修中
        List<Warnlog> dispachers = warnLogService.getDispacth();
        if (dispachers.size() > 0) {
            if ("1".equals(rawData.getFrontGate())) {
                Integer wheregate = 1;
                String s = updateStatus2Repair(dispachers, wheregate);
                isDispatcher = true;
                statusmap.put("repairpicture", s);

            } else if ("1".equals(rawData.getBackGate())) {
                Integer wheregate = 2;
                String s = updateStatus2Repair(dispachers, wheregate);
                isDispatcher = true;
                statusmap.put("repairpicture", s);
            }
        }

        try {
            if ("1".equals(rawData.getFrontGate())) {
                isNormal = false;
                Integer warntype = 3;
                servletContext.setAttribute("warnFrontGate", "告警！前门打开");
                boolean flag = isWarnCurrentDoor();
                boolean warnCurrentType = isWarnCurrentType(3);
                if (warnCurrentType) {

                    if (flag) {
                        SimpleDateFormat picdateFormat = new SimpleDateFormat("yyyyMMdd-HHmmss");
                        String realPath = servletContext.getRealPath("/source/picture");
                        String format = picdateFormat.format(new Date());
                        String picture_url = realPath + "/" + format + "-1.jpeg";
                        String picture_urlcu = "source/picture/" + format + "-1.jpeg";
                        try {
                            Process exec = Runtime.getRuntime().exec("ffmpeg -loglevel panic -f video4linux2 -i /dev/video0 -vframes 1 " + picture_url);
                            InputStream inputStream = exec.getInputStream();
                            exec.waitFor();
                        } catch (Exception e) {
                            System.out.println("照相异常！");
                        }
                        String description = "前门打开;";
                        Warnlog warnlog = new Warnlog();
                        warnlog.setPictureUrl(picture_urlcu);
                        warnlog.setWarnDescription(description);
                        warnlog.setWarnType(3);
                        warnlog.setWarnState(0);
                        warnlog.setWarnTime(new Date());
                        warnLogService.create(warnlog);
                        warninfo.append(warntype + "-" + description);
                    }
                }
            }
            if ("1".equals(rawData.getBackGate())) {
                isNormal = false;
                servletContext.setAttribute("warnBackGate", "告警！后门打开");
                Integer warntype = 11;
                boolean flag = isWarnCurrentDoor();
                boolean warnCurrentType = isWarnCurrentType(11);
                if (warnCurrentType) {
                    if (flag) {
                        SimpleDateFormat picdateFormat = new SimpleDateFormat("yyyyMMdd-HHmmss");
                        String realPath = servletContext.getRealPath("/source/picture");
                        String format = picdateFormat.format(new Date());
                        String picture_url = realPath + "/" + format + "-2.jpeg";
                        String picture_urlcu = "source/picture/" + format + "-2.jpeg";
                        try {
                            Process exec = Runtime.getRuntime().exec("ffmpeg -loglevel panic -f video4linux2 -i /dev/video1 -vframes 1 " + picture_url);
                            InputStream inputStream = exec.getInputStream();
                            exec.waitFor();
                        } catch (Exception e) {
                            System.out.println("照相异常！");
                        }

                        String description = "后门打开;";
                        Warnlog warnlog = new Warnlog();
                        warnlog.setPictureUrl(picture_urlcu);
                        warnlog.setWarnDescription(description);
                        warnlog.setWarnType(11);
                        warnlog.setWarnState(0);
                        warnlog.setWarnTime(new Date());
                        warnLogService.create(warnlog);
                        warninfo.append(warntype + "-" + "后门打开;");
                    }
                }
            }

            if ("1".equals(rawData.getSmoke())) {
                isNormal = false;
                Integer warntype = 8;
                servletContext.setAttribute("warnSmoke", "告警！烟感异常");
                boolean flag = isWarnCurrentType(warntype);
                String description = "烟感异常;";
                if (flag) {
                    warninfo.append(warntype + "-" + description);
                    Warnlog warnlog = new Warnlog();
                    warnlog.setWarnDescription(description);
                    warnlog.setWarnType(8);
                    warnlog.setWarnState(0);
                    warnlog.setWarnTime(new Date());
                    warnLogService.create(warnlog);
                }
            }

            if ("1".equals(rawData.getInfrared())) {
                isNormal = false;
                Integer warntype = 7;
                servletContext.setAttribute("warnInfrared", "告警！红外异常;");
                boolean flag = isWarnCurrentType(warntype);
                String description = "红外异常";
                if (flag) {
                    warninfo.append(warntype + "-" + description);
                    Warnlog warnlog = new Warnlog();
                    warnlog.setWarnDescription(description);
                    warnlog.setWarnType(7);
                    warnlog.setWarnState(0);
                    warnlog.setWarnTime(new Date());
                    warnLogService.create(warnlog);
                }
            }

            if ("1".equals(rawData.getFlood())) {
                isNormal = false;
                Integer warntype = 6;
                servletContext.setAttribute("warnFlood", "告警！水浸异常;");
                boolean flag = isWarnCurrentType(warntype);
                String description = "水浸异常";
                if (flag) {
                    warninfo.append(warntype + "-" + description);
                    Warnlog warnlog = new Warnlog();
                    warnlog.setWarnDescription(description);
                    warnlog.setWarnType(6);
                    warnlog.setWarnState(0);
                    warnlog.setWarnTime(new Date());
                    warnLogService.create(warnlog);
                }
            }

            alarmthresholdService = SpringUtil.getBean("alarmthresholdServiceImpl");
            Alarmthreshold alarmthreshold = alarmthresholdService.queryByThresholdtype("0");

            Float temperature = Float.parseFloat(rawData.getTemperature());

            if (temperature > Float.parseFloat(alarmthreshold.getGnWdGjMax()) || temperature < Float.parseFloat(alarmthreshold.getGnWdGjMin())) {
                isNormal = false;
                Integer warntype = 23;
                servletContext.setAttribute("xnwdStatus", "告警！柜内温度异常");
                boolean flag = isWarnCurrentType(warntype);
                statusmap.put("temperaturestatus", "1");
                String description = "柜内温度为" + temperature + "℃，正常温度在" + alarmthreshold.getGnWdGjMin() + "℃到" + alarmthreshold.getGnWdGjMax() + "℃之间;";
                if (flag) {
                    warninfo.append(warntype + "-" + description);
                    Warnlog warnlog = new Warnlog();
                    warnlog.setWarnDescription(description);
                    warnlog.setWarnType(warntype);
                    warnlog.setWarnState(0);
                    warnlog.setWarnTime(new Date());
                    warnLogService.create(warnlog);
                }
            }

            Float humidity = Float.parseFloat(rawData.getHumidity());

            if (humidity > Float.parseFloat(alarmthreshold.getGnSdGjMax()) || humidity < Float.parseFloat(alarmthreshold.getGnSdGjMin())) {
                isNormal = false;
                Integer warntype = 2;
                boolean flag = isWarnCurrentType(warntype);
                servletContext.setAttribute("warnHumiditystatus", "告警！湿度异常");
                String description = "当前湿度为" + humidity + "，正常湿度在" + alarmthreshold.getGnSdGjMin() + "到" + alarmthreshold.getGnSdGjMax() + "之间;";
                statusmap.put("humiditystatus", "1");
                if (flag) {
                    warninfo.append(warntype + "-" + description);
                    Warnlog warnlog = new Warnlog();
                    warnlog.setWarnDescription(description);
                    warnlog.setWarnType(2);
                    warnlog.setWarnState(0);
                    warnlog.setWarnTime(new Date());
                    warnLogService.create(warnlog);
                }
            }

            if (!ysjOneStart) {
                if ("1".equals(startStatus[1] + "")) {
                    ysjOneStart = true;
                    long ysjOneStartTime = 1000 * Integer.parseInt((String) servletContext.getAttribute("ysjOneStartTime"));
                    ysjOneStartWarnTime = new Date(new Date().getTime() + ysjOneStartTime);
                }
            } else {
                if ("1".equals(startStatus[2] + "")) {
                    if (ysjOneStartWarnTime != null && new Date().after(ysjOneStartWarnTime)) {
                        //正常判断
                        Float ysjOne = Float.parseFloat(rawDataP.getYsjOne());
                        if (ysjOne > Float.parseFloat(alarmthreshold.getYsjOneGjMax()) || ysjOne < Float.parseFloat(alarmthreshold.getYsjOneGjMin())) {
                            isNormal = false;
                            Integer warntype = 13;
                            servletContext.setAttribute("ysjOneStatus", "告警！压缩机1电流异常;");
                            boolean flag = isWarnCurrentType(warntype);
                            String description = "告警压缩机1电流为" + ysjOne + "A，正常电流在" + alarmthreshold.getYsjOneGjMin() + "A到" + alarmthreshold.getYsjOneGjMax() + "A之间;";
                            statusmap.put("ysjOneStatus", "1");
                            if (flag) {
                                warninfo.append(warntype + "-" + description);
                                Warnlog warnlog = new Warnlog();
                                warnlog.setWarnDescription(description);
                                warnlog.setWarnType(warntype);
                                warnlog.setWarnState(0);
                                warnlog.setWarnTime(new Date());
                                warnLogService.create(warnlog);
                            }
                        } else if (ysjOne > Float.parseFloat(alarmthreshold.getYsjOneYjMax()) && ysjOne < Float.parseFloat(alarmthreshold.getYsjOneGjMax()) || ysjOne > Float.parseFloat(alarmthreshold.getYsjOneGjMin()) && ysjOne < Float.parseFloat(alarmthreshold.getYsjOneYjMin())) {
                            isNormal = false;
                            Integer warntype = 12;
                            servletContext.setAttribute("ysjOneStatus", "预警！压缩机1电流异常;");
                            boolean flag = isWarnCurrentType(warntype);
                            String description = "预警压缩机1电流为" + ysjOne + "A，正常电流在" + alarmthreshold.getYsjOneYjMin() + "A到" + alarmthreshold.getYsjOneYjMax() + "A之间;";
                            statusmap.put("ysjOneStatus", "2");
                            if (flag) {
                                warninfo.append(warntype + "-" + description);
                                Warnlog warnlog = new Warnlog();
                                warnlog.setWarnDescription(description);
                                warnlog.setWarnType(warntype);
                                warnlog.setWarnState(0);
                                warnlog.setWarnTime(new Date());
                                warnLogService.create(warnlog);
                            }
                        }
                    }
                } else {
                    ysjOneStart = false;
                }
            }

            if (!ysjTwoStart) {
                if ("1".equals(startStatus[2] + "")) {
                    ysjTwoStart = true;
                    long ysjOneStartTime = 1000 * Integer.parseInt((String) servletContext.getAttribute("ysjTwoStartTime"));
                    ysjTwoStartWarnTime = new Date(new Date().getTime() + ysjOneStartTime);
                }
            } else {
                if ("1".equals(startStatus[2] + "")) {
                    if (ysjTwoStartWarnTime != null && new Date().after(ysjTwoStartWarnTime)) {
                        //正常判断
                        Float ysjTwo = Float.parseFloat(rawDataP.getYsjTwo());
                        if (ysjTwo > Float.parseFloat(alarmthreshold.getYsjTwoGjMax()) || ysjTwo < Float.parseFloat(alarmthreshold.getYsjTwoGjMin())) {
                            isNormal = false;
                            Integer warntype = 27;
                            servletContext.setAttribute("ysjTwoStatus", "告警！压缩机2电流异常;");
                            boolean flag = isWarnCurrentType(warntype);
                            String description = "告警压缩机2电流为" + ysjTwo + "A，正常电流在" + alarmthreshold.getYsjTwoGjMin() + "A到" + alarmthreshold.getYsjTwoGjMax() + "A之间;";
                            statusmap.put("ysjTwoStatus", "1");
                            if (flag) {
                                warninfo.append(warntype + "-" + description);
                                Warnlog warnlog = new Warnlog();
                                warnlog.setWarnDescription(description);
                                warnlog.setWarnType(warntype);
                                warnlog.setWarnState(0);
                                warnlog.setWarnTime(new Date());
                                warnLogService.create(warnlog);
                            }
                        } else if (ysjTwo < Float.parseFloat(alarmthreshold.getYsjTwoGjMax()) && ysjTwo > Float.parseFloat(alarmthreshold.getYsjTwoYjMax()) || ysjTwo < Float.parseFloat(alarmthreshold.getYsjTwoYjMin()) && ysjTwo > Float.parseFloat(alarmthreshold.getYsjTwoGjMin())) {
                            isNormal = false;
                            Integer warntype = 26;
                            servletContext.setAttribute("ysjTwoStatus", "预警！压缩机2电流异常;");
                            boolean flag = isWarnCurrentType(warntype);
                            String description = "预警压缩机2电流为" + ysjTwo + "A，正常电流在" + alarmthreshold.getYsjTwoYjMin() + "A到" + alarmthreshold.getYsjTwoYjMax() + "A之间;";
                            statusmap.put("ysjTwoStatus", "2");
                            if (flag) {
                                warninfo.append(warntype + "-" + description);
                                Warnlog warnlog = new Warnlog();
                                warnlog.setWarnDescription(description);
                                warnlog.setWarnType(warntype);
                                warnlog.setWarnState(0);
                                warnlog.setWarnTime(new Date());
                                warnLogService.create(warnlog);
                            }
                        }
                    }
                } else {
                    ysjTwoStart = false;
                }
            }


            Float lxfjOne = Float.parseFloat(rawDataP.getLxfjOne());
            if (lxfjOne > Float.parseFloat(alarmthreshold.getLxfjOneGjMax()) || lxfjOne < Float.parseFloat(alarmthreshold.getLxfjOneGjMin())) {
                isNormal = false;
                Integer warntype = 15;
                servletContext.setAttribute("lxfjOneStatus", "告警！离心风机1异常;");
                boolean flag = isWarnCurrentType(warntype);
                String description = "告警离心风机1电流为" + lxfjOne + "A，正常电流在" + alarmthreshold.getLxfjOneGjMax() + "A到" + alarmthreshold.getLxfjOneGjMin() + "A之间;";
                statusmap.put("lxfjOneStatus", "1");
                if (flag) {
                    warninfo.append(warntype + "-" + description);
                    Warnlog warnlog = new Warnlog();
                    warnlog.setWarnDescription(description);
                    warnlog.setWarnType(warntype);
                    warnlog.setWarnState(0);
                    warnlog.setWarnTime(new Date());
                    warnLogService.create(warnlog);
                }
            } else if (lxfjOne < Float.parseFloat(alarmthreshold.getLxfjOneGjMax()) && lxfjOne > Float.parseFloat(alarmthreshold.getLxfjOneYjMax()) || lxfjOne > Float.parseFloat(alarmthreshold.getLxfjOneGjMin()) && lxfjOne < Float.parseFloat(alarmthreshold.getLxfjOneYjMin())) {
                isNormal = false;
                Integer warntype = 14;
                servletContext.setAttribute("lxfjOneStatus", "预警！离心风机1异常;");
                boolean flag = isWarnCurrentType(warntype);
                String description = "预警离心风机1电流为" + lxfjOne + "A，正常电流在" + alarmthreshold.getLxfjOneYjMax() + "A到" + alarmthreshold.getLxfjOneYjMin() + "A之间;";
                statusmap.put("lxfjOneStatus", "2");
                if (flag) {
                    warninfo.append(warntype + "-" + description);
                    Warnlog warnlog = new Warnlog();
                    warnlog.setWarnDescription(description);
                    warnlog.setWarnType(warntype);
                    warnlog.setWarnState(0);
                    warnlog.setWarnTime(new Date());
                    warnLogService.create(warnlog);
                }
            }

            Float lxfTwo = Float.parseFloat(rawDataP.getLxfjTwo());
            if (lxfTwo > Float.parseFloat(alarmthreshold.getLxfjTwoGjMax()) || lxfTwo < Float.parseFloat(alarmthreshold.getLxfjTwoGjMin())) {
                isNormal = false;
                Integer warntype = 17;
                servletContext.setAttribute("lxfjTwoStatus", "告警！离心风机2异常;");
                boolean flag = isWarnCurrentType(warntype);
                String description = "告警离心风机2电流为" + lxfTwo + "A，正常电流在" + alarmthreshold.getLxfjTwoGjMax() + "A到" + alarmthreshold.getLxfjTwoGjMin() + "A之间;";
                statusmap.put("lxfjTwoStatus", "1");
                if (flag) {
                    warninfo.append(warntype + "-" + description);
                    Warnlog warnlog = new Warnlog();
                    warnlog.setWarnDescription(description);
                    warnlog.setWarnType(warntype);
                    warnlog.setWarnState(0);
                    warnlog.setWarnTime(new Date());
                    warnLogService.create(warnlog);
                }
            } else if (lxfTwo < Float.parseFloat(alarmthreshold.getLxfjTwoGjMax()) && lxfTwo > Float.parseFloat(alarmthreshold.getLxfjTwoYjMax()) || lxfTwo < Float.parseFloat(alarmthreshold.getLxfjTwoYjMin()) && lxfTwo > Float.parseFloat(alarmthreshold.getLxfjTwoGjMin())) {
                isNormal = false;
                Integer warntype = 16;
                servletContext.setAttribute("lxfjTwoStatus", "预警！离心风机2异常;");
                boolean flag = isWarnCurrentType(warntype);
                String description = "预警离心风机2电流为" + lxfTwo + "A，正常电流在" + alarmthreshold.getLxfjTwoYjMax() + "A到" + alarmthreshold.getLxfjTwoYjMin() + "A之间;";
                statusmap.put("lxfjTwoStatus", "2");
                if (flag) {
                    warninfo.append(warntype + "-" + description);
                    Warnlog warnlog = new Warnlog();
                    warnlog.setWarnDescription(description);
                    warnlog.setWarnType(warntype);
                    warnlog.setWarnState(0);
                    warnlog.setWarnTime(new Date());
                    warnLogService.create(warnlog);
                }
            }

            Float srfj = Float.parseFloat(rawDataP.getSrfj());
            if (srfj > Float.parseFloat(alarmthreshold.getSrfjGjMax()) || srfj < Float.parseFloat(alarmthreshold.getSrfjGjMin())) {
                isNormal = false;
                servletContext.setAttribute("srfjStatus", "告警！散热风机异常;");
                Integer warntype = 19;
                boolean flag = isWarnCurrentType(warntype);
                String description = "告警散热风机电流为" + srfj + "A，正常电流在" + alarmthreshold.getSrfjGjMin() + "A到" + alarmthreshold.getSrfjGjMax() + "A之间;";
                statusmap.put("srfjStatus", "1");
                if (flag) {
                    warninfo.append(warntype + "-" + description);
                    Warnlog warnlog = new Warnlog();
                    warnlog.setWarnDescription(description);
                    warnlog.setWarnType(warntype);
                    warnlog.setWarnState(0);
                    warnlog.setWarnTime(new Date());
                    warnLogService.create(warnlog);
                }
            } else if (srfj < Float.parseFloat(alarmthreshold.getSrfjGjMax()) && srfj > Float.parseFloat(alarmthreshold.getSrfjYjMax()) || srfj < Float.parseFloat(alarmthreshold.getSrfjYjMin()) && srfj > Float.parseFloat(alarmthreshold.getSrfjGjMin())) {
                isNormal = false;
                Integer warntype = 18;
                servletContext.setAttribute("srfjStatus", "预警！散热风机异常;");
                boolean flag = isWarnCurrentType(warntype);
                String description = "预警散热风机电流为" + srfj + "A，正常电流在" + alarmthreshold.getSrfjYjMin() + "A到" + alarmthreshold.getSrfjYjMax() + "A之间;";
                statusmap.put("srfjStatus", "2");
                if (flag) {
                    warninfo.append(warntype + "-" + description);
                    Warnlog warnlog = new Warnlog();
                    warnlog.setWarnDescription(description);
                    warnlog.setWarnType(warntype);
                    warnlog.setWarnState(0);
                    warnlog.setWarnTime(new Date());
                    warnLogService.create(warnlog);
                }
            }

            Float xufj = Float.parseFloat(rawDataP.getXhfj());
            if (xufj > Float.parseFloat(alarmthreshold.getXhfjGjMax()) || xufj < Float.parseFloat(alarmthreshold.getXhfjGjMin())) {
                isNormal = false;
                Integer warntype = 21;
                servletContext.setAttribute("xhfjStatus", "告警！循环风机异常;");
                boolean flag = isWarnCurrentType(warntype);
                String description = "告警循环风机电流为" + xufj + "A，正常电流在" + alarmthreshold.getXhfjGjMin() + "A到" + alarmthreshold.getXhfjGjMax() + "A之间;";
                statusmap.put("xhfjStatus", "1");
                if (flag) {
                    warninfo.append(warntype + "-" + description);
                    Warnlog warnlog = new Warnlog();
                    warnlog.setWarnDescription(description);
                    warnlog.setWarnType(warntype);
                    warnlog.setWarnState(0);
                    warnlog.setWarnTime(new Date());
                    warnLogService.create(warnlog);
                }
            } else if (xufj < Float.parseFloat(alarmthreshold.getXhfjGjMax()) && xufj > Float.parseFloat(alarmthreshold.getXhfjYjMax()) || xufj < Float.parseFloat(alarmthreshold.getXhfjYjMin()) && xufj > Float.parseFloat(alarmthreshold.getXhfjGjMin())) {
                isNormal = false;
                Integer warntype = 20;
                servletContext.setAttribute("xhfjStatus", "预警！循环风机异常;");
                boolean flag = isWarnCurrentType(warntype);
                String description = "预警循环风机电流为" + xufj + "A，正常电流在" + alarmthreshold.getXhfjYjMin() + "A到" + alarmthreshold.getXhfjYjMax() + "A之间;";
                statusmap.put("xhfjStatus", "2");
                if (flag) {
                    warninfo.append(warntype + "-" + description);
                    Warnlog warnlog = new Warnlog();
                    warnlog.setWarnDescription(description);
                    warnlog.setWarnType(warntype);
                    warnlog.setWarnState(0);
                    warnlog.setWarnTime(new Date());
                    warnLogService.create(warnlog);
                }
            }

            Float hjkz = Float.parseFloat(rawDataP.getHjkz());

            if (hjkz > Float.parseFloat(alarmthreshold.getHjkzGjMax()) || hjkz < Float.parseFloat(alarmthreshold.getHjkzGjMin())) {
                isNormal = false;
                servletContext.setAttribute("hjkzStatus", "告警！环境控制温度异常;");
                Integer warntype = 25;
                boolean flag = isWarnCurrentType(warntype);
                String description = "告警环境控制温度为" + hjkz + "℃，正常温度在" + alarmthreshold.getHjkzGjMin() + "℃到" + alarmthreshold.getHjkzGjMax() + "℃之间;";
                statusmap.put("hjkzStatus", "1");
                if (flag) {
                    warninfo.append(warntype + "-" + description);
                    Warnlog warnlog = new Warnlog();
                    warnlog.setWarnDescription(description);
                    warnlog.setWarnType(warntype);
                    warnlog.setWarnState(0);
                    warnlog.setWarnTime(new Date());
                    warnLogService.create(warnlog);
                }
            } else if (hjkz < Float.parseFloat(alarmthreshold.getHjkzGjMax()) && hjkz > Float.parseFloat(alarmthreshold.getHjkzYjMax()) || hjkz < Float.parseFloat(alarmthreshold.getHjkzYjMin()) && hjkz > Float.parseFloat(alarmthreshold.getHjkzGjMin())) {
                isNormal = false;
                Integer warntype = 24;
                boolean flag = isWarnCurrentType(warntype);
                servletContext.setAttribute("hjkzStatus", "预警！环境控制温度异常;");
                String description = "预警环境控制温度为" + hjkz + "℃，正常温度在" + alarmthreshold.getHjkzYjMin() + "℃到" + alarmthreshold.getHjkzGjMax() + "℃之间;";
                statusmap.put("hjkzStatus", "2");
                if (flag) {
                    warninfo.append(warntype + "-" + description);
                    Warnlog warnlog = new Warnlog();
                    warnlog.setWarnDescription(description);
                    warnlog.setWarnType(warntype);
                    warnlog.setWarnState(0);
                    warnlog.setWarnTime(new Date());
                    warnLogService.create(warnlog);
                }
            }
        } catch (Exception e) {
            System.out.println("创建数据库链接异常！");
            e.printStackTrace();
        }

        //如果有维修的情况下，当前全部正常，则将所有维修日志改为完工
        if (isDispatcher) {
            if (isNormal) {
                List<Warnlog> warnlogByType = warnLogService.getWarnlogByStatus(2);
                for (Warnlog warnlog : warnlogByType) {
                    Map<String, String> map = new HashMap<>();
                    map.put("id", "" + warnlog.getId());
                    map.put("warnstate", "3");
                    SimpleDateFormat dateFormat1 = new SimpleDateFormat("yyyy-MM-dd hh:mm:SS");
                    map.put("completeTime", dateFormat1.format(new Date()));
                    warnLogService.updateWarnLogStatus(map);
                }
                isDispatcher = false;
            }
        }


        // TODO: 2017/9/17 在此上传服务器数据，状态信息 和 告警信息
        statusmap.put("warninfo", warninfo.toString());
        Device device = deviceService.querySelfDevice(1);
        //机器码
        String machinecode = (String) servletContext.getAttribute("machinecode");
        if (StringUtils.isEmpty(machinecode)) {
            machinecode = device.getMachinecode();
        }

        //设备编号
        String deviceAddress = device.getDeviceAddress();
        //控制模式
        String controlmodal = device.getControlmode();

        //局端IP

        mainControlIp = device.getMainControlIp();

        statusmap.put("machinecode", machinecode + "");
        statusmap.put("deviceAddress", deviceAddress + "");
        statusmap.put("controlmode", controlmodal + "");
        String statusstr = JSON.toJSONString(statusmap);

        String returndata = PostUtil.post("code=" + statusstr, mainControlIp + "/bms/device/save.action");
        if (StringUtils.isEmpty(machinecode) || machinecode.equals("null")) {
            String data = (String) JSON.parseObject(returndata).get("data");
            servletContext.setAttribute("machinecode", data);
            try {
                String hostAddress = InetAddress.getLocalHost().getHostAddress();
                device.setDeviceIp(hostAddress);
            } catch (UnknownHostException e) {
                e.printStackTrace();
            }
            device.setMachinecode(data);
            deviceService.update(device);
        }
        System.out.println(statusstr);
    }

    private boolean isWarnCurrentType(Integer warntype) {
        List<Warnlog> currentTypeWarnlogs = warnLogService.getWarnlogByType(warntype);

        boolean flag = true;
        if (currentTypeWarnlogs.size() > 0) {
            for (Warnlog warnlog : currentTypeWarnlogs) {
                Integer warnState = warnlog.getWarnState();
                if (warnState == 0 || warnState == 1 || warnState == 2) {
                    flag = false;
                }
            }
        }
        return flag;
    }

    private boolean isWarnCurrentDoor() {
        List<Warnlog> currentTypeWarnlogs = warnLogService.getWarnlogDoor();

        if (currentTypeWarnlogs.size() > 0) {
            return false;

        } else {
            return true;
        }
    }

    @Transactional
    private String updateStatus2Repair(List<Warnlog> dispachers, Integer wheregate) {
        SimpleDateFormat picdateFormat = new SimpleDateFormat("yyyyMMdd-HHmmss");
        String realPath = servletContext.getRealPath("/source/picture");
        String format = picdateFormat.format(new Date());
        String picture_url = realPath + "/" + format + "-" + wheregate + ".jpeg";
        String picture_urlcu = "source/picture/" + format + "-" + wheregate + ".jpeg";
        if (wheregate == 1) {
            try {
                Process exec = Runtime.getRuntime().exec("ffmpeg -loglevel panic -f video4linux2 -i /dev/video0 -vframes 1 " + picture_url);
                InputStream inputStream = exec.getInputStream();
                exec.waitFor();
            } catch (Exception e) {
                System.out.println("照相异常！");
            }

        } else {
            try {
                Process exec = Runtime.getRuntime().exec("ffmpeg -loglevel panic -f video4linux2 -i /dev/video1 -vframes 1 " + picture_url);
                InputStream inputStream = exec.getInputStream();
                exec.waitFor();
            } catch (Exception e) {
                System.out.println("照相异常！");
            }
        }

        String ids = "";
        for (Warnlog warnlog : dispachers) {
            Map<String, String> map = new HashMap<>();
            map.put("warnstate", "2");
            map.put("id", "" + warnlog.getId());
            warnLogService.updateWarnLogStatus(map);
            ids += warnlog.getId() + ",";
        }

        String returnstr = PostUtil.post("ids=" + ids + "&picture_url=" + picture_urlcu, mainControlIp + "/bms/device/insertPic.action");
        return picture_url;
    }

    private boolean getDispacherStatus() {
        List<Warnlog> list = warnLogService.getDispacth();
        boolean flag = false;
        if (list.size() > 0) {
            flag = true;
        }
        return flag;
    }

}
