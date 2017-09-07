package com.micropower.manager.service;

import com.micropower.manager.model.po.Warnlog;

/**
 * Created by oliver on 2017/9/5.
 */
public interface WarnLogService extends BaseService<Warnlog>{
    Integer delete(Integer id);
}
