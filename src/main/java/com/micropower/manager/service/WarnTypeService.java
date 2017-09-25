package com.micropower.manager.service;

import com.micropower.manager.model.po.Warntype;

import java.util.List;

/**
 * Created by niushuaike on 2017/9/7.
 */
public interface WarnTypeService extends BaseService<Warntype> {
    List<Warntype> list();
}
