package com.micropower.manager.service;

import com.lycheeframework.core.cmp.kit.Pages;
import com.micropower.manager.common.EasyPage;
import com.micropower.manager.model.po.Warnlog;
import com.micropower.manager.model.pojo.WarnlogPojo;

import java.util.List;
import java.util.Map;

/**
 * Created by oliver on 2017/9/5.
 */
public interface WarnLogService extends BaseService<Warnlog>{
    Integer delete(Integer id);

    Pages<List<WarnlogPojo>> list(Map<String, String> paramesMapMy, EasyPage page);

    List<Warnlog> listWarnlog();

    List<Warnlog> historyWarnlog();

    List<Warnlog> currentWarnlog();

    Integer updateWarnLogStatus(Map<String, String> parameter);

    WarnlogPojo queryWarnPojo(Integer id);

    List<Warnlog> getDispacth();

    List<Warnlog> getWarnlogByType(int warntype);

    Integer updateWarnLogOperationDetail(Map<String, String> paramesMapMy);

    Warnlog getWarnlogById(Integer id);

    List<Warnlog> getWarnlogByStatus(Integer warnstate);

    List<Warnlog> getWarnlogDoor();
}
