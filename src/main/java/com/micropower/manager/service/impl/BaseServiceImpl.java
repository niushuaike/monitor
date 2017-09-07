package com.micropower.manager.service.impl;

import com.lycheeframework.core.cmp.kit.Pages;
import com.lycheeframework.core.model.IPO;
import com.lycheeframework.core.support.sql.SQLManager;
import com.micropower.manager.common.EasyPage;
import com.micropower.manager.service.BaseService;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;

import java.lang.reflect.ParameterizedType;
import java.util.List;
import java.util.Map;

/**
 * Created by oliver on 2017/8/30.
 */
public abstract class BaseServiceImpl<T> implements BaseService<T> {

    @Autowired
    protected SQLManager manager;
    protected Class<T> clazz;

    protected String namespace;

    public BaseServiceImpl() {
        // 通过反射获取T的真实类型
        ParameterizedType pt = (ParameterizedType) this.getClass().getGenericSuperclass();
        this.clazz = (Class<T>) pt.getActualTypeArguments()[0];
        namespace = StringUtils.lowerCase(clazz.getSimpleName())+".";

        System.out.println("---> clazz = " + clazz);
    }

    @Override
    public Integer create(T t) {
        IPO ipo;
        if (t instanceof IPO){
            ipo = (IPO) t;
            return manager.insert(namespace + "create", ipo);
        }
        return -1;
    }

    @Override
    public Integer update(T t) {
        IPO ipo;
        if (t instanceof IPO){
            ipo = (IPO) t;
            return manager.insert(namespace + "update", ipo);
        }
        return -1;
    }

    @Override
    public Integer count() {
        return manager.count(namespace + "count", null);
    }

    @Override
    public T queryById(Integer id) {
        return (T) manager.query(namespace + "query", id);
    }

    @Override
    public Pages<List<T>> getPages(Map<String,String> map,EasyPage page) {
        Pages<List<T>> pages = (Pages<List<T>>) manager.pages(namespace + "page", map, page);
        return pages;
    }
}
