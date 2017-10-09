package com.micropower.manager.controller.admin;

import com.lycheeframework.core.cmp.api.http.GsonData;
import com.lycheeframework.core.cmp.api.http.GsonResponse;
import com.micropower.manager.common.EasyPage;
import com.micropower.manager.controller.BaseController;
import com.micropower.manager.model.po.Warnlog;
import com.micropower.manager.model.po.Warntype;
import com.micropower.manager.service.WarnLogService;
import com.micropower.manager.service.WarnTypeService;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * Created by oliver on 2017/9/5.
 */
@Controller
@RequestMapping("/bjm/warnlog")
public class WarnLogController extends BaseController {
    @Autowired
    private WarnLogService service;

    @Autowired
    private WarnTypeService warnTypeService;

    @ResponseBody
    @RequestMapping("/page")
    public GsonData page(HttpServletRequest request, EasyPage page) {
        Map<String, String> paramesMapMy = getParamesMapMy(request);
        GsonData gsonData = GsonResponse.toData(service.getPages(paramesMapMy, page));
        return gsonData;
    }

    @ResponseBody
    @RequestMapping("/list")
    public GsonData list(HttpServletRequest request, EasyPage page) {
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
        return GsonResponse.toData(service.list(paramesMapMy, page));
    }

    @ResponseBody
    @RequestMapping("/initwarntype")
    public List<Warntype> initwarntype() {
        List<Warntype> list = warnTypeService.list();
        Warntype warntype = new Warntype();
        warntype.setWarntypename("全部类型");
        warntype.setId(-1);
        list.add(0, warntype);
        return list;
    }

    @ResponseBody
    @RequestMapping("/getwarninfo")
    public List<String> getwarninfo(HttpServletRequest request) {
        ServletContext servletContext = request.getServletContext();
        List<String> warninfo = new ArrayList<>();
        String warnFrontGate = (String) servletContext.getAttribute("warnFrontGate");
        if (!StringUtils.isEmpty(warnFrontGate)) {
            warninfo.add(warnFrontGate);
        }
        String warnBackGate = (String) servletContext.getAttribute("warnBackGate");
        if (!StringUtils.isEmpty(warnBackGate)) {
            warninfo.add(warnBackGate);
        }
        String warnSmoke = (String) servletContext.getAttribute("warnSmoke");
        if (!StringUtils.isEmpty(warnSmoke)) {
            warninfo.add(warnSmoke);
        }
        String warnInfrared = (String) servletContext.getAttribute("warnInfrared");
        if (!StringUtils.isEmpty(warnInfrared)) {
            warninfo.add(warnInfrared);
        }
        String warnFlood = (String) servletContext.getAttribute("warnFlood");
        if (!StringUtils.isEmpty(warnFlood)) {
            warninfo.add(warnFlood);
        }
        String warnTemperature = (String) servletContext.getAttribute("xnwdStatus");
        if (!StringUtils.isEmpty(warnTemperature)) {
            warninfo.add(warnTemperature);
        }
        String warnHumidity = (String) servletContext.getAttribute("warnHumiditystatus");
        if (!StringUtils.isEmpty(warnHumidity)) {
            warninfo.add(warnHumidity);
        }
        String ysjOneYj = (String) servletContext.getAttribute("ysjOneStatus");
        if (!StringUtils.isEmpty(ysjOneYj)) {
            warninfo.add(ysjOneYj);
        }
        String ysjTwoYj = (String) servletContext.getAttribute("ysjTwoStatus");
        if (!StringUtils.isEmpty(ysjTwoYj)) {
            warninfo.add(ysjTwoYj);
        }

        String xnwdYj = (String) servletContext.getAttribute("srfjStatus");
        if (!StringUtils.isEmpty(xnwdYj)) {
            warninfo.add(xnwdYj);
        }
        String xnwdGj = (String) servletContext.getAttribute("lxfjOneStatus");
        if (!StringUtils.isEmpty(xnwdGj)) {
            warninfo.add(xnwdGj);
        }
        String hjkzYj = (String) servletContext.getAttribute("lxfjTwoStatus");
        if (!StringUtils.isEmpty(hjkzYj)) {
            warninfo.add(hjkzYj);
        }

        String hjkzGj = (String) servletContext.getAttribute("xhfjStatus");
        if (!StringUtils.isEmpty(hjkzGj)) {
            warninfo.add(hjkzGj);
        }

        String srfjYj = (String) servletContext.getAttribute("hjkzStatus");
        if (!StringUtils.isEmpty(srfjYj)) {
            warninfo.add(srfjYj);
        }
        if (warninfo.size()==0){
            warninfo.add("一切正常");
        }
        return warninfo;
    }

    @ResponseBody
    @RequestMapping("/saveRepair")
    public Integer saveRepair(Warnlog warnlog) {
        Warnlog warnlog1 = service.queryById(warnlog.getId());
        if (warnlog1 != null)
            return service.update(warnlog1);
        else
            return service.create(warnlog1);
    }

    @ResponseBody
    @RequestMapping("/historyWarnlog")
    public List<Warnlog> historyWarnlog() {
        return service.historyWarnlog();
    }

    @ResponseBody
    @RequestMapping("/currentWarnlog")
    public List<Warnlog> currentWarnlog() {
        return service.currentWarnlog();
    }

    @ResponseBody
    @RequestMapping("/getWarnlogById")
    public Warnlog getWarnlogById(Integer id) {
        return service.getWarnlogById(id);
    }

    @ResponseBody
    @RequestMapping("/getWarntype")
    public List<Warntype> getWarntype() {
        return warnTypeService.list();
    }

    @ResponseBody
    @RequestMapping("/updateWarnLogStatus")
    public Integer updateWarnLogStatus(HttpServletRequest request) {
        Map<String, String> paramesMapMy = getParamesMapMy(request);
        if ("4".equals(paramesMapMy.get("warnstate"))){
            SimpleDateFormat dateFormat1 = new SimpleDateFormat("yyyy-MM-dd hh:mm:SS");
            paramesMapMy.put("completeTime",dateFormat1.format(new Date()));
        }
        return service.updateWarnLogStatus(paramesMapMy);
    }

    @ResponseBody
    @RequestMapping("/updateWarnLogOperationDetail")
    public Integer updateWarnLogOperationDetail(HttpServletRequest request) {
        Map<String, String> paramesMapMy = getParamesMapMy(request);
        return service.updateWarnLogOperationDetail(paramesMapMy);
    }

    @ResponseBody
    @RequestMapping("/delete")
    public Integer delete(Integer id) {
        return service.delete(id);
    }

}
