package com.micropower.manager.utils;

import com.micropower.manager.model.po.RawData;
import freemarker.core.ReturnInstruction;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

/**
 * Created by oliver on 2017/9/1.
 */
public class ParseDataUtil {

    public static RawData parseRecentOneData(String fileName) throws Exception {

        BufferedReader br = new BufferedReader(new FileReader(new File(Constant.DATAPATH + fileName)));
        Stream<String> stream = br.lines();
        Stream<String> sorted = stream.sorted((String o1, String o2) -> {
            return -1;
        });
        Optional<String> first = sorted.findFirst();
        String s = first.get();
        RawData rawData = getRawData(s);

        return rawData;
    }

    public static List<RawData> parseRecentListData(Integer dataNum,Integer minper,String filename){

        return null;
    }

    private static RawData getRawData(String s) throws ParseException {
        RawData rawData = new RawData();
        String[] split = s.split("\t");
        SimpleDateFormat forma = new SimpleDateFormat("yyyyMMddHHmmss");
        rawData.setDate(forma.parse(split[0]));
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

    public static Date str2date(String timeStr){
        try {
            return new SimpleDateFormat("yyyyMMddHHmmss").parse(timeStr);
        } catch (ParseException e) {
            return null;
        }
    }

    public static String date2str(Date date) {
        return new SimpleDateFormat("yyyyMMddHHmmss").format(date);
    }


    public static void main(String[] args) throws Exception {
    }


}
