package com.hongcd.strive.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import javax.persistence.MappedSuperclass;
import java.io.Serializable;

@MappedSuperclass
public interface GenericRepository<T, ID extends Serializable> extends JpaRepository<T, ID> {
    
}