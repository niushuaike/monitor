package com.micropower.manager.utils;

import com.micropower.manager.model.po.RawData;
import freemarker.core.ReturnInstruction;
import org.apache.commons.io.IOUtils;

import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.function.Consumer;
import java.util.stream.Stream;

/**
 * Created by oliver on 2017/9/1.
 */
public class ParseDataUtil {

    /**
     * 解析当前最近的一条数据
     *
     * @throws Exception
     */
    public static RawData parseRecentOneData(String filePath) throws IOException {

        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMdd");
        String filename = "/"+dateFormat.format(new Date()) + ".data";
        List<String> br = IOUtils.readLines(new FileReader(filePath + filename));
        Stream<String> stream = br.stream();
        Stream<String> sorted = stream.sorted((String o1, String o2) -> {
            return -1;
        });
        Optional<String> first = sorted.findFirst();
        String s = first.get();
        RawData rawData = getRawData(s);
        return rawData;
    }

    public static List<RawData> parseRecentListData(Integer dataNum, String filePath) throws IOException {
        List<RawData> list = new ArrayList<>();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMdd");
        String filename = "/"+dateFormat.format(new Date()) + ".data";
        List<String> br = IOUtils.readLines(new FileReader(filePath + filename));
        long time = 0;
        for (int i = (br.size() - 1); i >= 0; i--) {
            if (dataNum > 0) {
                RawData rawData = getRawData(br.get(i));
                long time2 = rawData.getDate().getTime();
                if (time == 0) {
                    time = time2 - 2 * 60 * 1000;
                    list.add(rawData);
                    dataNum -= 1;
                } else if (Math.abs(time - time2) <= 1000) {
                    time = time2 - 2 * 60 * 1000;
                    list.add(rawData);
                    dataNum -= 1;
                }
                int m = 1;
            } else {
                break;
            }
        }
        return list;
    }

    private static RawData getRawData(String s) {
        RawData rawData = new RawData();
        String[] split = s.split("\t");
        SimpleDateFormat forma = new SimpleDateFormat("yyyyMMddHHmmss");
        try {
            rawData.setDate(forma.parse(split[0]));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        String[] split1 = split[1].split(" ");
        rawData.setVoltage(split1[0]);
        rawData.setCurrent1(split1[1]);
        rawData.setCurrent2(split1[2]);
        rawData.setTemperature(split1[3]);
        rawData.setHumidity(split1[4]);
        rawData.setVoltageHigh(split1[5]);
        rawData.setVoltageLow(split1[6]);
        rawData.setCurrent1High(split1[7]);
        rawData.setCurrent2High(split1[8]);
        rawData.setTemperatureHigh(split1[9]);
        rawData.setHumidityHigh(split1[10]);
        rawData.setFrontGate(split1[11]);
        rawData.setFlood(split1[12]);
        rawData.setInfrared(split1[13]);
        rawData.setSmoke(split1[14]);
        rawData.setBackGate(split1[15]);
        return rawData;
    }

    public static Map<String, String> getDeviceStatus(RawData rawData) {
        Map<String, String> map = new HashMap<>();
        if ("0".equals(rawData.getFrontGate())) {
            map.put("frontGate", "关");
        } else if ("1".equals(rawData.getFrontGate())) {
            map.put("frontGate", "开");
        }
        if ("0".equals(rawData.getBackGate())) {
            map.put("backGate", "关");
        } else if ("1".equals(rawData.getBackGate())) {
            map.put("backGate", "开");
        }

        if ("0".equals(rawData.getSmoke())) {
            map.put("smoke", "正常");
        } else if ("1".equals(rawData.getSmoke())) {
            map.put("smoke", "告警");
        }
        if ("0".equals(rawData.getInfrared())) {
            map.put("infrared", "正常");
        } else if ("1".equals(rawData.getInfrared())) {
            map.put("infrared", "告警");
        }
        if ("0".equals(rawData.getFlood())) {
            map.put("flood", "正常");
        } else if ("1".equals(rawData.getFlood())) {
            map.put("flood", "告警");
        }
        map.put("temperature", rawData.getTemperature() + "℃");
        map.put("humidity", rawData.getHumidity() + "%");
        map.put("voltage", rawData.getVoltage() + "V");
        map.put("current1", rawData.getCurrent1() + "A");
        return map;
    }

    private static RawData getTHRawData(String s) {
        RawData rawData = new RawData();
        String[] split = s.split("\t");
        SimpleDateFormat forma = new SimpleDateFormat("yyyyMMddHHmmss");
        try {
            rawData.setDate(forma.parse(split[0]));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        String[] split1 = split[1].split(" ");
        rawData.setTemperature(split1[3]);
        rawData.setHumidity(split1[4]);
        return rawData;
    }

    public static Date str2date(String timeStr) {
        try {
            return new SimpleDateFormat("yyyyMMddHHmmss").parse(timeStr);
        } catch (ParseException e) {
            return null;
        }
    }

    public static String date2str(Date date) {
        return new SimpleDateFormat("yyyyMMddHHmmss").format(date);
    }


}
