package com.micropower.manager.utils;

import com.micropower.manager.model.po.RawData;
import com.micropower.manager.model.po.RawDataP;
import org.apache.commons.io.IOUtils;

import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by niushuaike on 2017/9/22.
 */
public class PParseDataUtil {

    /**
     * 解析当前最近的一条数据
     *
     * @throws Exception
     */
    public static RawDataP parseRecentOneData(String filePath) throws IOException {

        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMdd");
        String filename = "/"+dateFormat.format(new Date()) + "P.data";
        List<String> br = IOUtils.readLines(new FileReader(filePath + filename));
        String s = br.get(br.size() - 1);

        return parseOneDataP(s);
    }

    private static RawDataP parseOneDataP(String s) {
        RawDataP rawDataP = new RawDataP();
        String[] split = s.split(",");
        rawDataP.setDate(split[0]);
        rawDataP.setXnwd(split[1]);
        rawDataP.setHjkz(split[2]);
        rawDataP.setYsjOne(split[3]);
        rawDataP.setYsjTwo(split[4]);
        rawDataP.setLxfjOne(split[5]);
        rawDataP.setLxfjTwo(split[6]);
        rawDataP.setSrfj(split[7]);
        rawDataP.setXhfj(split[8]);
        rawDataP.setGzzt(split[9]);
        rawDataP.setSbktzt(split[10]);
        return rawDataP;
    }

    public static List<RawDataP> parseRecentListData(int dataNum, String cabinet_data_path) throws IOException, ParseException {
        List<RawDataP> list = new ArrayList<>();
        SimpleDateFormat fileNameFormat = new SimpleDateFormat("yyyyMMdd");
        SimpleDateFormat dataDateFormat = new SimpleDateFormat("yyyyMMddhhmmSS");
        String filename = "/"+fileNameFormat.format(new Date()) + "P.data";
        List<String> br = IOUtils.readLines(new FileReader(cabinet_data_path + filename));
        long time = 0;
        for (int i = (br.size() - 1); i >= 0; i--) {
            if (dataNum > 0) {
                RawDataP rawDataP = parseOneDataP(br.get(i));
                String date = rawDataP.getDate();
                long time2 = dataDateFormat.parse(date).getTime();
                if (time == 0) {
                    time = time2 - 2 * 60 * 1000;
                    list.add(rawDataP);
                    dataNum -= 1;
                } else if (Math.abs(time - time2) <= 1000) {
                    time = time2 - 2 * 60 * 1000;
                    list.add(rawDataP);
                    dataNum -= 1;
                }
                int m = 1;
            } else {
                break;
            }
        }
        return list;
    }
}
