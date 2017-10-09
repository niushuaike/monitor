package com.micropower.manager.service.impl;

import com.lycheeframework.core.cmp.kit.Pages;
import com.micropower.manager.common.EasyPage;
import com.micropower.manager.model.po.Warnlog;
import com.micropower.manager.model.po.Warntype;
import com.micropower.manager.model.pojo.WarnlogPojo;
import com.micropower.manager.service.WarnLogService;
import com.micropower.manager.service.WarnTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by oliver on 2017/9/5.
 */
@Service
public class WarnLogServiceImpl extends BaseServiceImpl<Warnlog> implements WarnLogService {
    @Autowired
    private WarnTypeService warnTypeService;

    @Override
    public Integer delete(Integer id) {
        return manager.deleteByID(namespace+"delete",id);
    }

    @Override
    public Pages<List<WarnlogPojo>> list(Map<String, String> paramesMapMy, EasyPage page) {
        Pages<List<WarnlogPojo>> pages = new Pages<>();
        Pages<List<Warnlog>> pages2 = getPages(paramesMapMy, page);
        pages.setTotal(pages2.getTotal());
        List<Warnlog> list = pages2.getRows();
        List<WarnlogPojo> listwarnlogpojo = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            Warnlog warnlog = list.get(i);
            Warntype warntype = warnTypeService.queryById(warnlog.getWarnType());
            WarnlogPojo warnlogPojo = new WarnlogPojo();
            warnlogPojo.setWarnlog(warnlog);
            warnlogPojo.setWarntype(warntype);
            listwarnlogpojo.add(warnlogPojo);
        }
        pages.setRows(listwarnlogpojo);
        return pages;
    }

    @Override
    public List<Warnlog> listWarnlog() {
        return (List<Warnlog>) manager.list(namespace+"list");
    }

    @Override
    public List<Warnlog> historyWarnlog() {
        return (List<Warnlog>) manager.list(namespace+"historyWarnlog");
    }

    @Override
    public List<Warnlog> currentWarnlog() {
        return (List<Warnlog>) manager.list(namespace+"currentWarnlog");
    }

    @Override
    public Integer updateWarnLogStatus(Map<String, String> parameter) {
        return manager.getSqlSessionTemplate().update(namespace+"updateWarnLogStatus", parameter);
    }

    @Override
    public WarnlogPojo queryWarnPojo(Integer id) {
        Warnlog warnlog = queryById(id);
        Warntype warntype = warnTypeService.queryById(warnlog.getWarnType());
        WarnlogPojo warnlogPojo = new WarnlogPojo();
        warnlogPojo.setWarnlog(warnlog);
        warnlogPojo.setWarntype(warntype);
        return warnlogPojo;
    }

    @Override
    public List<Warnlog> getDispacth() {
        return (List<Warnlog>) manager.list(namespace+"getDispacth");
    }

    @Override
    public List<Warnlog> getWarnlogByType(int warntype) {
        return (List<Warnlog>) manager.list(namespace+"getWarnlogByType",warntype);
    }

    @Override
    public Integer updateWarnLogOperationDetail(Map<String, String> paramesMapMy) {
        return manager.getSqlSessionTemplate().update(namespace+"updateWarnLogOperationDetail", paramesMapMy);
    }

    @Override
    public Warnlog getWarnlogById(Integer id) {
        return queryById(id);
    }

    @Override
    public List<Warnlog> getWarnlogByStatus(Integer warnstate) {
        return (List<Warnlog>) manager.list(namespace+"getWarnlogByStatus",warnstate);
    }

    @Override
    public List<Warnlog> getWarnlogDoor() {
        return (List<Warnlog>) manager.list(namespace+"getWarnlogDoor");
    }
}
