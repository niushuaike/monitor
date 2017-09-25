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
import java.util.ArrayList;
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
    public String getwarninfo(HttpServletRequest request) {
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
        String warnTemperature = (String) servletContext.getAttribute("warnTemperature");
        if (!StringUtils.isEmpty(warnTemperature)) {
            warninfo.add(warnTemperature);
        }
        String warnHumidity = (String) servletContext.getAttribute("warnHumidity");
        if (!StringUtils.isEmpty(warnHumidity)) {
            warninfo.add(warnHumidity);
        }
        String ysjOneYj = (String) servletContext.getAttribute("ysjOneYj");
        if (!StringUtils.isEmpty(ysjOneYj)) {
            warninfo.add(ysjOneYj);
        }
        String ysjTwoYj = (String) servletContext.getAttribute("ysjTwoYj");
        if (!StringUtils.isEmpty(ysjTwoYj)) {
            warninfo.add(ysjTwoYj);
        }
        String ysjOneGj = (String) servletContext.getAttribute("ysjOneGj");
        if (!StringUtils.isEmpty(ysjOneGj)) {
            warninfo.add(ysjOneGj);
        }

        String ysjTwoGj = (String) servletContext.getAttribute("ysjTwoGj");
        if (!StringUtils.isEmpty(ysjTwoGj)) {
            warninfo.add(ysjTwoGj);
        }

        String xnwdYj = (String) servletContext.getAttribute("xnwdYj");
        if (!StringUtils.isEmpty(xnwdYj)) {
            warninfo.add(xnwdYj);
        }
        String xnwdGj = (String) servletContext.getAttribute("xnwdGj");
        if (!StringUtils.isEmpty(xnwdGj)) {
            warninfo.add(xnwdGj);
        }
        String hjkzYj = (String) servletContext.getAttribute("hjkzYj");
        if (!StringUtils.isEmpty(hjkzYj)) {
            warninfo.add(hjkzYj);
        }

        String hjkzGj = (String) servletContext.getAttribute("hjkzGj");
        if (!StringUtils.isEmpty(hjkzGj)) {
            warninfo.add(hjkzGj);
        }

        String srfjYj = (String) servletContext.getAttribute("srfjYj");
        if (!StringUtils.isEmpty(srfjYj)) {
            warninfo.add(srfjYj);
        }
        String srfjGj = (String) servletContext.getAttribute("srfjGj");
        if (!StringUtils.isEmpty(srfjGj)) {
            warninfo.add(srfjGj);
        }
        String xhfjYj = (String) servletContext.getAttribute("xhfjYj");
        if (!StringUtils.isEmpty(xhfjYj)) {
            warninfo.add(xhfjYj);
        }

        String xhfjGj = (String) servletContext.getAttribute("xhfjGj");
        if (!StringUtils.isEmpty(xhfjGj)) {
            warninfo.add(xhfjGj);
        }

        String s = warninfo.toString();
        return s;
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
