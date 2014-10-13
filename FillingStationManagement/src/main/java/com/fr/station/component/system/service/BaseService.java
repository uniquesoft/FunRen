package com.fr.station.component.system.service;

import java.io.Serializable;
import java.util.List;

public interface BaseService<T> {

	void save(T t);

	void merge(T t);

	void saveOrUpdate(T t);

	void update(T t);

	void delete(T t);

	T get(Serializable id) throws Exception;

	List<T> findAll() throws Exception;

	List<T> findByExample(T t) throws Exception;

	List<T> findByHql(String sql, Object... args)throws Exception;

	List<T> findByHql(String sql)throws Exception;

	List<T> findBySql(String sql, Object... args)throws Exception;

	List<T> findBySql(String sql)throws Exception;

	void setBaseDao(Object t);

}
