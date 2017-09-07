package com.micropower.manager.service;

import com.lycheeframework.core.cmp.kit.Pages;
import com.micropower.manager.common.EasyPage;

import java.util.List;
import java.util.Map;

/**
 * Created by oliver on 2017/8/30.
 */
public interface BaseService <T> {

    /**
     * 增加或者保存某个对象
     * @param t
     * @return
     */
    Integer create(T t);


    /**
     * 修改某个对象
     * @param t
     * @return
     */
    Integer update(T t);

    /**
     * 查询表记录数量
     * @return
     */
    Integer count();

    /**
     * 查询单个对象
     * @return
     */
    T queryById(Integer id);

    /**
     * 查询带分页
     * @param page
     * @return
     */
    Pages<List<T>> getPages(Map<String, String> map, EasyPage page);

}
