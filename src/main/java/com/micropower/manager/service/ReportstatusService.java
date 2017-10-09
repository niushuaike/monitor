package com.micropower.manager.service;

import com.lycheeframework.core.cmp.kit.Pages;
import com.micropower.manager.common.EasyPage;
import com.micropower.manager.model.po.Reportstatus;
import com.micropower.manager.model.pojo.ReportstatusPojo;

import java.util.List;
import java.util.Map;

/**
 * Created by oliver on 2017/9/4.
 */
public interface ReportstatusService extends BaseService<Reportstatus> {
    Integer addStatus(Map<String, String> deviceStatus);

    Pages<List<Reportstatus>> list(Map<String, String> paramesMapMy, EasyPage page);

    Reportstatus queryByStatusno(String statusno);
    ReportstatusPojo queryPojoByStatusno(String statusno);

    ReportstatusPojo queryDevicePojosByStatusno(String statusno);

    Integer delete(Integer id);
}
