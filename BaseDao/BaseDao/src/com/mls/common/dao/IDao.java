package com.mls.common.dao;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import com.mls.common.util.PageInfo;
import com.mls.common.util.PagerControl;
import com.mls.common.bean.BaseEntity;

/**
 * 丰富有的抽象base dao
 * @author yuzhe
 * @param <T> stand for pk
 * @param <M>
 */
public interface IDao<T extends Serializable, M extends BaseEntity> {

	public  int insert(M entity);

	public  int delete(T pk);

	public  int deleteByEntity(M entity);
	
	public  int deleteByEntity(M entity,String whereSql);
	
	public  int update(M entity);

	public  M getEntityById(T pk);

	public List<M> getEntityByIds(List<T> paramList);

	public  M getEntityByObj(M entity);

	public  M getEntityByObj(M entity, String whereSql);

	public  int getCountByObj(M entity);

	public  int getCountByObj(M entity, String whereSql);

	public  PagerControl<M> getPagerByObj(M entity,PageInfo pageInfo, String whereSql);

	public  PagerControl<M> getPagerByObj(M entity,PageInfo pageInfo, String whereSql, String orderBySql);

	public  List<M> getAllEntityObj();

	public  List<M> getListByObj(M entity);

	public  List<M> getListByObj(M entity, String whereSql);

	public  List<M> getListByObj(M entity, String whereSql,String orderBySql);

	public  List<M> getListByObj(M entity, PageInfo pageInfo,String whereSql);

	public  List<M> getListByObj(M entity, PageInfo pageInfo,String whereSql, String orderBySql);
}
