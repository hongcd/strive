package com.hongcd.strive.service;

import java.io.Serializable;
import java.util.List;

/**
 * 通用服务接口
 * @param <T>
 * @param <ID>
 */
public interface GenericService<T, ID extends Serializable> {
    /**
     * 列表所有
     * @return
     */
    List<T> listAll();

    /**
     * id获取
     * @param id
     * @return
     */
    T getById(ID id);
}