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
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
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

    public ScheduleMonitorRunnable() {
    }

    @Override
    public void run() {
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

        //门开的时候修改派工状态为维修中
        List<Warnlog> dispachers = warnLogService.getDispacth();
        if (dispachers.size() > 0) {
            if ("1".equals(rawData.getFrontGate())) {
                Integer wheregate = 1;
                String s = updateStatus2Repair(dispachers, wheregate);
                statusmap.put("repairpicture", s);

            } else if ("1".equals(rawData.getBackGate())) {
                Integer wheregate = 2;
                String s = updateStatus2Repair(dispachers, wheregate);
                statusmap.put("repairpicture", s);
            }
        }


        try {
            if ("1".equals(rawData.getFrontGate())) {
                Integer warntype = 3;
                boolean flag = isWarnCurrentType(warntype);
                if (flag) {
                    SimpleDateFormat picdateFormat = new SimpleDateFormat("yyyyMMdd-HHmmss");
                    String realPath = servletContext.getRealPath("/source/picture");
                    String picture_url = realPath + "/" + picdateFormat.format(new Date()) + "-1.jpeg";
                    String picture_urlcu = "source/picture/" + picdateFormat.format(new Date()) + "-1.jpeg";
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
                    servletContext.setAttribute("warnFrontGate", "告警！" + description);
                    warninfo.append(description);
                }
            }
            if ("1".equals(rawData.getBackGate())) {
                Integer warntype = 11;
                boolean flag = isWarnCurrentType(warntype);
                if (flag) {
                    SimpleDateFormat picdateFormat = new SimpleDateFormat("yyyyMMdd-HHmmss");
                    String realPath = servletContext.getRealPath("/source/picture");
                    String picture_url = realPath + "/" + picdateFormat.format(new Date()) + "-2.jpeg";
                    String picture_urlcu = "source/picture/" + picdateFormat.format(new Date()) + "-2.jpeg";
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

                    servletContext.setAttribute("warnBackGate", "告警！后门打开");
                    warninfo.append("告警！后门打开;");
                }
            }

            if ("1".equals(rawData.getSmoke())) {
                Integer warntype = 8;
                boolean flag = isWarnCurrentType(warntype);
                if (flag) {
                    String description = "烟感异常";
                    Warnlog warnlog = new Warnlog();
                    warnlog.setWarnDescription(description);
                    warnlog.setWarnType(8);
                    warnlog.setWarnState(0);
                    warnlog.setWarnTime(new Date());
                    warnLogService.create(warnlog);
                    servletContext.setAttribute("warnSmoke", "告警！烟感异常");
                    warninfo.append(description);
                }
            }

            if ("1".equals(rawData.getInfrared())) {
                Integer warntype = 7;
                boolean flag = isWarnCurrentType(warntype);
                if (flag) {
                    String description = "红外异常";
                    Warnlog warnlog = new Warnlog();
                    warnlog.setWarnDescription(description);
                    warnlog.setWarnType(7);
                    warnlog.setWarnState(0);
                    warnlog.setWarnTime(new Date());
                    warnLogService.create(warnlog);
                    servletContext.setAttribute("warnInfrared", "告警！红外异常;");
                    warninfo.append(description);
                }
            }

            if ("1".equals(rawData.getFlood())) {
                Integer warntype = 6;
                boolean flag = isWarnCurrentType(warntype);
                if (flag) {
                    String description = "水浸异常";
                    Warnlog warnlog = new Warnlog();
                    warnlog.setWarnDescription(description);
                    warnlog.setWarnType(6);
                    warnlog.setWarnState(0);
                    warnlog.setWarnTime(new Date());
                    warnLogService.create(warnlog);
                    servletContext.setAttribute("warnFlood", "告警！水浸异常;");
                    warninfo.append(description);
                }
            }

            alarmthresholdService = SpringUtil.getBean("alarmthresholdServiceImpl");
            Alarmthreshold alarmthreshold = alarmthresholdService.queryOnlyOne();

            Float temperature = Float.parseFloat(rawData.getTemperature());

            if (temperature > Float.parseFloat(alarmthreshold.getJgWdMax()) || temperature < Float.parseFloat(alarmthreshold.getJgWdMin())) {
                Integer warntype = 1;
                boolean flag = isWarnCurrentType(warntype);
                if (flag) {
                    String description = "当前温度为" + temperature + "℃，正常温度在" + alarmthreshold.getJgWdMin() + "℃到" + alarmthreshold.getJgWdMax() + "℃之间。";
                    Warnlog warnlog = new Warnlog();
                    warnlog.setWarnDescription(description);
                    warnlog.setWarnType(1);
                    warnlog.setWarnState(0);
                    warnlog.setWarnTime(new Date());
                    warnLogService.create(warnlog);
                    servletContext.setAttribute("warnTemperature", "告警！温度异常");
                    statusmap.put("temperaturestatus", "1");
                    warninfo.append(description);
                }
            }


            Float humidity = Float.parseFloat(rawData.getHumidity());

            if (humidity > Float.parseFloat(alarmthreshold.getJgSdMax()) || humidity < Float.parseFloat(alarmthreshold.getJgSdMin())) {
                Integer warntype = 2;
                boolean flag = isWarnCurrentType(warntype);
                if (flag) {
                    String description = "当前湿度为" + humidity + "%，正常湿度在" + alarmthreshold.getJgSdMin() + "%到" + alarmthreshold.getJgSdMax() + "%之间。";
                    Warnlog warnlog = new Warnlog();
                    warnlog.setWarnDescription(description);
                    warnlog.setWarnType(2);
                    warnlog.setWarnState(0);
                    warnlog.setWarnTime(new Date());
                    warnLogService.create(warnlog);
                    servletContext.setAttribute("warnHumidity", "告警！湿度异常");
                    warninfo.append(description);
                    statusmap.put("humiditystatus", "1");
                }
            }

            if (!ysjOneStart) {
                if ("0".equals(startStatus[2])) {
                    ysjOneStart = true;
                    long ysjOneStartTime = 1000 * (Integer) servletContext.getAttribute("ysjOneStartTime");
                    ysjOneStartWarnTime = new Date(new Date().getTime() + ysjOneStartTime);
                }
            } else {
                if ("1".equals(startStatus[2])) {
                    if (ysjOneStartWarnTime != null && new Date().after(ysjOneStartWarnTime)) {
                        ysjOneStartWarnTime = null;
                        //正常判断
                        Float ysjOne = Float.parseFloat(rawDataP.getYsjOne());
                        if (ysjOne > Float.parseFloat(alarmthreshold.getYsjOneGjMax()) || ysjOne < Float.parseFloat(alarmthreshold.getYsjOneGjMin())) {
                            Integer warntype = 13;
                            boolean flag = isWarnCurrentType(warntype);
                            if (flag) {
                                String description = "告警压缩机1电流为" + ysjOne + "A，正常电流在" + alarmthreshold.getYsjOneGjMin() + "A到" + alarmthreshold.getYsjOneGjMax() + "A之间。";
                                Warnlog warnlog = new Warnlog();
                                warnlog.setWarnDescription(description);
                                warnlog.setWarnType(warntype);
                                warnlog.setWarnState(0);
                                warnlog.setWarnTime(new Date());
                                warnLogService.create(warnlog);
                                servletContext.setAttribute("ysjOneGj", "告警！压缩机1电流异常");
                                warninfo.append(description);
                            }
                        } else if (ysjOne > Float.parseFloat(alarmthreshold.getYsjOneYjMax()) && ysjOne < Float.parseFloat(alarmthreshold.getYsjOneGjMax()) || ysjOne > Float.parseFloat(alarmthreshold.getYsjOneGjMin()) && ysjOne < Float.parseFloat(alarmthreshold.getYsjOneYjMin())) {
                            Integer warntype = 12;
                            boolean flag = isWarnCurrentType(warntype);
                            if (flag) {
                                String description = "预警压缩机1电流为" + ysjOne + "A，正常电流在" + alarmthreshold.getYsjOneYjMin() + "A到" + alarmthreshold.getYsjOneYjMax() + "A之间。";
                                Warnlog warnlog = new Warnlog();
                                warnlog.setWarnDescription(description);
                                warnlog.setWarnType(warntype);
                                warnlog.setWarnState(0);
                                warnlog.setWarnTime(new Date());
                                warnLogService.create(warnlog);
                                servletContext.setAttribute("ysjOneYj", "预警！压缩机1电流异常");
                                warninfo.append(description);
                            }
                        }
                    }
                } else {
                    ysjOneStart = false;
                }
            }

            if (!ysjTwoStart) {
                if ("0".equals(startStatus[2])) {
                    ysjTwoStart = true;
                    long ysjOneStartTime = 1000 * (Integer) servletContext.getAttribute("ysjTwoStartTime");
                    ysjTwoStartWarnTime = new Date(new Date().getTime() + ysjOneStartTime);
                }
            } else {
                if ("1".equals(startStatus[2])) {
                    if (ysjTwoStartWarnTime != null && new Date().after(ysjTwoStartWarnTime)) {
                        ysjTwoStartWarnTime = null;
                        //正常判断
                        Float ysjTwo = Float.parseFloat(rawDataP.getYsjTwo());
                        if (ysjTwo > Float.parseFloat(alarmthreshold.getYsjTwoGjMax()) || ysjTwo < Float.parseFloat(alarmthreshold.getYsjTwoGjMin())) {
                            Integer warntype = 27;
                            boolean flag = isWarnCurrentType(warntype);
                            if (flag) {
                                String description = "告警压缩机2电流为" + ysjTwo + "A，正常电流在" + alarmthreshold.getYsjTwoGjMin() + "A到" + alarmthreshold.getYsjTwoGjMax() + "A之间。";
                                Warnlog warnlog = new Warnlog();
                                warnlog.setWarnDescription(description);
                                warnlog.setWarnType(warntype);
                                warnlog.setWarnState(0);
                                warnlog.setWarnTime(new Date());
                                warnLogService.create(warnlog);
                                servletContext.setAttribute("ysjTwoGj", "告警！压缩机2电流异常");
                                warninfo.append(description);
                            }
                        } else if (ysjTwo < Float.parseFloat(alarmthreshold.getYsjTwoGjMax()) && ysjTwo > Float.parseFloat(alarmthreshold.getYsjTwoYjMax()) || ysjTwo < Float.parseFloat(alarmthreshold.getYsjTwoYjMin()) && ysjTwo > Float.parseFloat(alarmthreshold.getYsjTwoGjMin())) {
                            Integer warntype = 26;
                            boolean flag = isWarnCurrentType(warntype);
                            if (flag) {
                                String description = "预警压缩机2电流为" + ysjTwo + "A，正常电流在" + alarmthreshold.getYsjTwoYjMin() + "A到" + alarmthreshold.getYsjTwoYjMax() + "A之间。";
                                Warnlog warnlog = new Warnlog();
                                warnlog.setWarnDescription(description);
                                warnlog.setWarnType(warntype);
                                warnlog.setWarnState(0);
                                warnlog.setWarnTime(new Date());
                                warnLogService.create(warnlog);
                                servletContext.setAttribute("ysjTwoYj", "预警！压缩机2电流异常");
                                warninfo.append(description);
                            }
                        }
                    }
                } else {
                    ysjTwoStart = false;
                }
            }


            Float lxfjOne = Float.parseFloat(rawDataP.getLxfjOne());
            if (lxfjOne > Float.parseFloat(alarmthreshold.getLxfjOneGjMax()) || lxfjOne < Float.parseFloat(alarmthreshold.getLxfjOneGjMin())) {
                Integer warntype = 15;
                boolean flag = isWarnCurrentType(warntype);
                if (flag) {
                    String description = "告警离心风机1电流为" + lxfjOne + "A，正常电流在" + alarmthreshold.getLxfjOneGjMax() + "A到" + alarmthreshold.getLxfjOneGjMin() + "A之间。";
                    Warnlog warnlog = new Warnlog();
                    warnlog.setWarnDescription(description);
                    warnlog.setWarnType(warntype);
                    warnlog.setWarnState(0);
                    warnlog.setWarnTime(new Date());
                    warnLogService.create(warnlog);
                    servletContext.setAttribute("lxfjOneGj", "告警！离心风机1异常");
                    warninfo.append(description);
                }
            } else if (lxfjOne < Float.parseFloat(alarmthreshold.getLxfjOneGjMax()) && lxfjOne > Float.parseFloat(alarmthreshold.getLxfjOneYjMax()) || lxfjOne > Float.parseFloat(alarmthreshold.getLxfjOneGjMin()) && lxfjOne < Float.parseFloat(alarmthreshold.getLxfjOneYjMin())) {
                Integer warntype = 14;
                boolean flag = isWarnCurrentType(warntype);
                if (flag) {
                    String description = "预警离心风机1电流为" + lxfjOne + "A，正常电流在" + alarmthreshold.getLxfjOneYjMax() + "A到" + alarmthreshold.getLxfjOneYjMin() + "A之间。";
                    Warnlog warnlog = new Warnlog();
                    warnlog.setWarnDescription(description);
                    warnlog.setWarnType(warntype);
                    warnlog.setWarnState(0);
                    warnlog.setWarnTime(new Date());
                    warnLogService.create(warnlog);
                    servletContext.setAttribute("lxfjOneYj", "预警！离心风机1异常");
                    warninfo.append(description);
                }
            }

            Float lxfTwo = Float.parseFloat(rawDataP.getLxfjTwo());
            if (lxfTwo > Float.parseFloat(alarmthreshold.getLxfjTwoGjMax()) || lxfTwo < Float.parseFloat(alarmthreshold.getLxfjTwoGjMin())) {
                Integer warntype = 17;
                boolean flag = isWarnCurrentType(warntype);
                if (flag) {
                    String description = "告警离心风机2电流为" + lxfTwo + "A，正常电流在" + alarmthreshold.getLxfjTwoGjMax() + "A到" + alarmthreshold.getLxfjTwoGjMin() + "A之间。";
                    Warnlog warnlog = new Warnlog();
                    warnlog.setWarnDescription(description);
                    warnlog.setWarnType(warntype);
                    warnlog.setWarnState(0);
                    warnlog.setWarnTime(new Date());
                    warnLogService.create(warnlog);
                    servletContext.setAttribute("lxfTwoGj", "告警！离心风机2异常");
                    warninfo.append(description);
                }
            } else if (lxfTwo < Float.parseFloat(alarmthreshold.getLxfjTwoGjMax()) && lxfTwo > Float.parseFloat(alarmthreshold.getLxfjTwoYjMax()) || lxfTwo < Float.parseFloat(alarmthreshold.getLxfjTwoYjMin()) && lxfTwo > Float.parseFloat(alarmthreshold.getLxfjTwoGjMin())) {
                Integer warntype = 16;
                boolean flag = isWarnCurrentType(warntype);
                if (flag) {
                    String description = "预警离心风机2电流为" + lxfTwo + "A，正常电流在" + alarmthreshold.getLxfjTwoYjMax() + "A到" + alarmthreshold.getLxfjTwoYjMin() + "A之间。";
                    Warnlog warnlog = new Warnlog();
                    warnlog.setWarnDescription(description);
                    warnlog.setWarnType(warntype);
                    warnlog.setWarnState(0);
                    warnlog.setWarnTime(new Date());
                    warnLogService.create(warnlog);
                    servletContext.setAttribute("lxfTwoYj", "预警！离心风机2异常");
                    warninfo.append(description);
                }
            }

            Float srfj = Float.parseFloat(rawDataP.getSrfj());
            if (srfj > Float.parseFloat(alarmthreshold.getSrfjGjMax()) || srfj < Float.parseFloat(alarmthreshold.getSrfjGjMin())) {
                Integer warntype = 19;
                boolean flag = isWarnCurrentType(warntype);
                if (flag) {
                    String description = "告警散热风机电流为" + srfj + "A，正常电流在" + alarmthreshold.getSrfjGjMin() + "A到" + alarmthreshold.getSrfjGjMax() + "A之间。";
                    Warnlog warnlog = new Warnlog();
                    warnlog.setWarnDescription(description);
                    warnlog.setWarnType(warntype);
                    warnlog.setWarnState(0);
                    warnlog.setWarnTime(new Date());
                    warnLogService.create(warnlog);
                    servletContext.setAttribute("srfjGj", "告警！散热风机异常");
                    warninfo.append(description);
                }
            } else if (srfj > Float.parseFloat(alarmthreshold.getSrfjGjMax()) && srfj > Float.parseFloat(alarmthreshold.getSrfjYjMax()) || srfj < Float.parseFloat(alarmthreshold.getSrfjYjMin()) && srfj > Float.parseFloat(alarmthreshold.getSrfjGjMin())) {
                Integer warntype = 18;
                boolean flag = isWarnCurrentType(warntype);
                if (flag) {
                    String description = "预警散热风机电流为" + srfj + "A，正常电流在" + alarmthreshold.getSrfjYjMin() + "A到" + alarmthreshold.getSrfjYjMax() + "A之间。";
                    Warnlog warnlog = new Warnlog();
                    warnlog.setWarnDescription(description);
                    warnlog.setWarnType(warntype);
                    warnlog.setWarnState(0);
                    warnlog.setWarnTime(new Date());
                    warnLogService.create(warnlog);
                    servletContext.setAttribute("srfjYj", "预警！散热风机异常");
                    warninfo.append(description);
                }
            }

            Float xufj = Float.parseFloat(rawDataP.getXhfj());
            if (xufj > Float.parseFloat(alarmthreshold.getXhfjGjMax()) || xufj < Float.parseFloat(alarmthreshold.getXhfjGjMin())) {
                Integer warntype = 21;
                boolean flag = isWarnCurrentType(warntype);
                if (flag) {
                    String description = "告警循环风机电流为" + xufj + "A，正常电流在" + alarmthreshold.getXhfjGjMin() + "A到" + alarmthreshold.getXhfjGjMax() + "A之间。";
                    Warnlog warnlog = new Warnlog();
                    warnlog.setWarnDescription(description);
                    warnlog.setWarnType(warntype);
                    warnlog.setWarnState(0);
                    warnlog.setWarnTime(new Date());
                    warnLogService.create(warnlog);
                    servletContext.setAttribute("xufjGj", "告警！循环风机异常");
                    warninfo.append(description);
                }
            } else if (xufj < Float.parseFloat(alarmthreshold.getXhfjGjMax()) && xufj > Float.parseFloat(alarmthreshold.getXhfjYjMax()) || xufj < Float.parseFloat(alarmthreshold.getXhfjYjMin()) && xufj > Float.parseFloat(alarmthreshold.getXhfjGjMin())) {
                Integer warntype = 20;
                boolean flag = isWarnCurrentType(warntype);
                if (flag) {
                    String description = "预警循环风机电流为" + xufj + "A，正常电流在" + alarmthreshold.getXhfjYjMin() + "A到" + alarmthreshold.getXhfjYjMax() + "A之间。";
                    Warnlog warnlog = new Warnlog();
                    warnlog.setWarnDescription(description);
                    warnlog.setWarnType(warntype);
                    warnlog.setWarnState(0);
                    warnlog.setWarnTime(new Date());
                    warnLogService.create(warnlog);
                    servletContext.setAttribute("xufjYj", "预警！循环风机异常");
                    warninfo.append(description);
                }
            }

            Float xnwd = Float.parseFloat(rawDataP.getXnwd());

            if (xnwd > Float.parseFloat(alarmthreshold.getXnwdGjMax()) || xnwd < Float.parseFloat(alarmthreshold.getXnwdGjMin())) {
                Integer warntype = 23;
                boolean flag = isWarnCurrentType(warntype);
                if (flag) {
                    String description = "告警箱内温度为" + xnwd + "℃，正常温度在" + alarmthreshold.getXnwdGjMin() + "℃到" + alarmthreshold.getXnwdGjMax() + "℃之间。";
                    Warnlog warnlog = new Warnlog();
                    warnlog.setWarnDescription(description);
                    warnlog.setWarnType(warntype);
                    warnlog.setWarnState(0);
                    warnlog.setWarnTime(new Date());
                    warnLogService.create(warnlog);
                    servletContext.setAttribute("xnwdGj", "告警！箱内温度异常");
                    warninfo.append(description);
                }
            } else if (xnwd < Float.parseFloat(alarmthreshold.getXnwdGjMax()) && xnwd > Float.parseFloat(alarmthreshold.getXnwdYjMax()) || xnwd < Float.parseFloat(alarmthreshold.getXnwdYjMin()) && xnwd > Float.parseFloat(alarmthreshold.getXnwdGjMin())) {
                Integer warntype = 22;
                boolean flag = isWarnCurrentType(warntype);
                if (flag) {
                    String description = "预警箱内温度为" + xnwd + "℃，正常温度在" + alarmthreshold.getXnwdYjMin() + "℃到" + alarmthreshold.getXnwdYjMax() + "℃之间。";
                    Warnlog warnlog = new Warnlog();
                    warnlog.setWarnDescription(description);
                    warnlog.setWarnType(warntype);
                    warnlog.setWarnState(0);
                    warnlog.setWarnTime(new Date());
                    warnLogService.create(warnlog);
                    servletContext.setAttribute("xnwdYj", "预警！箱内温度异常");
                    warninfo.append(description);
                }
            }

            Float hjkz = Float.parseFloat(rawDataP.getHjkz());

            if (hjkz > Float.parseFloat(alarmthreshold.getHjkzGjMax()) || hjkz < Float.parseFloat(alarmthreshold.getHjkzGjMin())) {
                Integer warntype = 25;
                boolean flag = isWarnCurrentType(warntype);
                if (flag) {
                    String description = "告警环境控制温度为" + hjkz + "℃，正常温度在" + alarmthreshold.getJgWdMin() + "℃到" + alarmthreshold.getJgWdMax() + "℃之间。";
                    Warnlog warnlog = new Warnlog();
                    warnlog.setWarnDescription(description);
                    warnlog.setWarnType(warntype);
                    warnlog.setWarnState(0);
                    warnlog.setWarnTime(new Date());
                    warnLogService.create(warnlog);
                    servletContext.setAttribute("hjkzGj", "告警！环境控制温度异常");
                    warninfo.append(description);
                }
            } else if (hjkz < Float.parseFloat(alarmthreshold.getHjkzGjMax()) && hjkz > Float.parseFloat(alarmthreshold.getHjkzYjMax()) || hjkz < Float.parseFloat(alarmthreshold.getHjkzYjMin()) && hjkz > Float.parseFloat(alarmthreshold.getHjkzGjMin())) {
                Integer warntype = 24;
                boolean flag = isWarnCurrentType(warntype);
                if (flag) {
                    String description = "预警环境控制温度为" + hjkz + "℃，正常温度在" + alarmthreshold.getJgWdMin() + "℃到" + alarmthreshold.getJgWdMax() + "℃之间。";
                    Warnlog warnlog = new Warnlog();
                    warnlog.setWarnDescription(description);
                    warnlog.setWarnType(warntype);
                    warnlog.setWarnState(0);
                    warnlog.setWarnTime(new Date());
                    warnLogService.create(warnlog);
                    servletContext.setAttribute("hjkzYj", "预警！环境控制温度异常");
                    warninfo.append(description);
                }
            }

        } catch (Exception e) {
            System.out.println("创建数据库链接异常！");
            e.printStackTrace();
        }
        // TODO: 2017/9/17 在此上传服务器数据，状态信息 和 告警信息
        statusmap.put("warninfo", warninfo.toString());
        String machinecode = (String) servletContext.getAttribute("machinecode");
        String deviceAddress = (String) servletContext.getAttribute("deviceAddress");
        String controlmodal = (String) servletContext.getAttribute("controlmodal");
        Device device = new Device();
        if (StringUtils.isEmpty(machinecode) || "null".equals(machinecode)) {
            device = deviceService.querySelfDevice(1);
            machinecode = device.getMachinecode();
            deviceAddress = device.getDeviceAddress();
            controlmodal = device.getControlmode();
            servletContext.setAttribute("deviceAddress", deviceAddress);
            servletContext.setAttribute("controlmodal", controlmodal);
        }
        statusmap.put("machinecode", machinecode + "");
        statusmap.put("deviceAddress", deviceAddress + "");
        statusmap.put("controlmode", controlmodal + "");
        String statusstr = JSON.toJSONString(statusmap);

        String returndata = PostUtil.post("code=" + statusstr, servletContext.getAttribute("main_control_ip") + "/bms/device/save.action");
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
                if (warnState == 0 || warnState == 1 || warnState == 2 || warnState == 3) {
                    flag = false;
                }
            }
        }
        return flag;
    }

    @Transactional
    private String updateStatus2Repair(List<Warnlog> dispachers, Integer wheregate) {
        SimpleDateFormat picdateFormat = new SimpleDateFormat("yyyyMMdd-HHmmss");
        String picture_url = "source/picture/" + picdateFormat.format(new Date()) + "-" + wheregate + ".jpeg";
        String picture_urlpz = servletContext.getRealPath("/source/picture") + "/" + picdateFormat.format(new Date()) + "-" + wheregate + ".jpeg";
        //拍照
        try {
            Process exec = Runtime.getRuntime().exec("ffmpeg -loglevel panic -f video4linux2 -i /dev/video" + wheregate + " -vframes 1 " + picture_urlpz);
            InputStream inputStream = exec.getInputStream();
            exec.waitFor();
        } catch (Exception e) {
            System.out.println("照片异常");
        }

        String ids = "";
        for (Warnlog warnlog : dispachers) {
            Map<String, String> map = new HashMap<>();
            map.put("warnstate", "2");
            map.put("id", "" + warnlog.getId());
            warnLogService.updateWarnLogStatus(map);
            ids += warnlog.getId() + ",";
        }

        String returnstr = PostUtil.post("ids=" + ids + "&picture_url=" + picture_url, "http://192.168.199.111:8080/bms/device/insertPic.action");
        if ("no".equals(returnstr) || "error".equals(JSON.parseObject(returnstr).getString("data"))) {
            int i = 1 / 0;
        }
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
