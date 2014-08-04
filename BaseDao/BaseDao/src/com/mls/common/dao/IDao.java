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
 *
 * @param <T>
 * @param <M>
 */
public interface IDao<T extends Serializable, M extends BaseEntity> {

	public  int insert(M paramM);

	public  int delete(T paramT);

	public  int deleteByEntity(M paramM);

	public  int update(M paramM);

	public  M getEntityById(T paramT);

	public  M getEntityById(T paramT, boolean paramBoolean);

	public List<M> getEntityByIds(List<T> paramList);

	public  List<M> getEntityByIds(List<T> paramList,boolean paramBoolean);

	public  Map<T, M> getEntityByIds(List<T> paramList,String paramString);

	public  Map<T, M> getEntityByIds(List<T> paramList,String paramString, boolean paramBoolean);

	public  M getEntityByObj(M paramM);

	public  M getEntityByObj(M paramM, boolean paramBoolean);

	public  M getEntityByIdUseDB(T paramT);

	public  M getEntityByIdUseDB(T paramT, boolean paramBoolean);

	public  M getEntityByObj(M paramM, String paramString);

	public  M getEntityByObj(M paramM, String paramString,boolean paramBoolean);

	public  int getCountByObj(M paramM);

	public  int getCountByObj(M paramM, boolean paramBoolean);

	public  int getCountByObj(M paramM, String paramString);

	public  int getCountByObj(M paramM, String paramString,boolean paramBoolean);

	public  PagerControl<M> getPagerByObj(M paramM,PageInfo paramPageInfo, String paramString);

	public  PagerControl<M> getPagerByObj(M paramM,PageInfo paramPageInfo, String paramString, boolean paramBoolean);

	public  PagerControl<M> getPagerByObj(M paramM,PageInfo paramPageInfo, String paramString1, String paramString2);

	public  PagerControl<M> getPagerByObj(M paramM,PageInfo paramPageInfo, String paramString1, String paramString2,boolean paramBoolean);

	public  List<M> getAllEntityObj();

	public  List<M> getAllEntityObj(boolean paramBoolean);

	public  List<M> getListByObj(M paramM);

	public  List<M> getListByObj(M paramM, boolean paramBoolean);

	public  List<M> getListByObj(M paramM, String paramString);

	public  List<M> getListByObj(M paramM, String paramString,boolean paramBoolean);

	public  List<M> getListByObj(M paramM, String paramString1,String paramString2);

	public  List<M> getListByObj(M paramM, String paramString1,String paramString2, boolean paramBoolean);

	public  List<M> getListByObj(M paramM, PageInfo paramPageInfo,String paramString);

	public  List<M> getListByObj(M paramM, PageInfo paramPageInfo,String paramString, boolean paramBoolean);

	public  List<M> getListByObj(M paramM, PageInfo paramPageInfo,String paramString1, String paramString2);

	public  List<M> getListByObj(M paramM, PageInfo paramPageInfo,String paramString1, String paramString2, boolean paramBoolean);

	public  List<M> getListByObjSortByMultiField(M paramM,PageInfo paramPageInfo, String paramString1, String paramString2);

	public  List<M> getListByObjSortByMultiField(M paramM,PageInfo paramPageInfo, String paramString1, String paramString2,boolean paramBoolean);

	public  boolean deleteCacheByPk(T paramT);
}
