package com.hongcd.strive.service.impl;

import com.hongcd.strive.service.Service;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;
import java.util.List;

/**
 * 通用服务实现类
 * @author HongD
 * @param <T>
 * @param <ID>
 */
@Transactional(propagation = Propagation.NOT_SUPPORTED, readOnly = true)
public abstract class BaseService<T, ID extends Serializable> implements Service<T, ID> {
    @Override
    public List<T> listAll() {
        return repository().findAll();
    }

    @Override
    public T getById(ID id) {
        return repository().getOne(id);
    }

    /**
     * 获取通用DAO库
     * @return
     */
    protected abstract JpaRepository<T, ID> repository();
}