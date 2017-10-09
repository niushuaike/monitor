package com.micropower.manager.controller.admin;

import com.lycheeframework.core.cmp.api.http.GsonData;
import com.lycheeframework.core.cmp.api.http.GsonResponse;
import com.micropower.manager.common.EasyPage;
import com.micropower.manager.controller.BaseController;
import com.micropower.manager.model.po.Alarmthreshold;
import com.micropower.manager.model.po.Reportstatus;
import com.micropower.manager.model.pojo.ReportstatusPojo;
import com.micropower.manager.service.AlarmthresholdService;
import com.micropower.manager.service.ReportstatusService;
import com.micropower.manager.utils.JsonUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * Created by niushuaike on 2017/9/16.
 */
@Controller
@RequestMapping("/jm/reportstatus")
public class ReportstatusController extends BaseController {

    @Autowired
    private ReportstatusService reportstatusService;

    @ResponseBody
    @RequestMapping("/initReport")
    public GsonData initReport(HttpServletRequest request, EasyPage page) {
        Map<String, String> paramesMapMy = getParamesMapMy(request);
        String endtime = paramesMapMy.get("endtime");
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date parse = null;
        try {
            parse = simpleDateFormat.parse(endtime);
            long l = parse.getTime() + 24 * 60 * 60 * 1000;
            Date date = new Date(l);
            String format = simpleDateFormat.format(date);
            paramesMapMy.put("endtime", format);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return GsonResponse.toData(reportstatusService.list(paramesMapMy,page));
    }

    @ResponseBody
    @RequestMapping("/getStatusmy")
    public ReportstatusPojo getStatusmy(String statusno) {
        ReportstatusPojo reportstatusPojo = reportstatusService.queryDevicePojosByStatusno(statusno);
        return reportstatusPojo;
    }

    @ResponseBody
    @RequestMapping("/getException")
    public ReportstatusPojo getException(String statusno) {
        ReportstatusPojo reportstatusPojo = reportstatusService.queryDevicePojosByStatusno(statusno);
        return reportstatusPojo;
    }

    @ResponseBody
    @RequestMapping("/deletereportbyid")
    public Integer deletereportbyid(Integer id) {
        return reportstatusService.delete(id);
    }


}
