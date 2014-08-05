package com.mls.common.dao;

import java.io.Serializable;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.google.common.base.Strings;
import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import com.mls.common.bean.BaseEntity;
import com.mls.common.util.PageInfo;
import com.mls.common.util.PagerControl;

import org.mybatis.spring.support.SqlSessionDaoSupport;


public abstract class BaseDao<T extends Serializable, M extends BaseEntity> extends  SqlSessionDaoSupport implements IDao<T, M>{

	private Set<String> entityFields = new HashSet();
	public Map<String, Object> getMapParams(M entity, PageInfo pageInfo, String whereSql, String orderBySql) {
	    Map map = new HashMap();
	    if (null != entity) map.put("entity", entity);
	    if (null != pageInfo) map.put("pageInfo", pageInfo);
	    if (null != whereSql) map.put("whereSql", whereSql);
	    if (null != orderBySql) map.put("orderBy", orderBySql);
	    return map;
	}
	
	public String getOrderBySql(PageInfo pageInfo) {
	    if (pageInfo == null) return null;
	    StringBuilder sb = new StringBuilder();
	    if ((!Strings.isNullOrEmpty(pageInfo.getOrderField())) && (this.entityFields.contains(pageInfo.getOrderField()))) {
	      sb.append("order by ").append(pageInfo.getOrderField()).append(" ").append("desc".equals(pageInfo.getOrderDirection()) ? "desc" : "asc");
	    }
	    
	    return sb.toString();
	}


	@Override
	public int insert(M entity) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int delete(T pk) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteByEntity(M entity) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int update(M entity) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public M getEntityById(T pk) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<M> getEntityByIds(List<T> paramList) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Map<T, M> getEntityByIds(List<T> paramList, String whereSql) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public M getEntityByObj(M entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public M getEntityByIdUseDB(T pk) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public M getEntityByObj(M entity, String whereSql) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getCountByObj(M entity) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getCountByObj(M entity, String whereSql) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public PagerControl<M> getPagerByObj(M entity, PageInfo pageInfo,
			String whereSql) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public PagerControl<M> getPagerByObj(M entity, PageInfo pageInfo,
			String whereSql, String orderBySql) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<M> getAllEntityObj() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<M> getListByObj(M entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<M> getListByObj(M entity, String whereSql) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<M> getListByObj(M entity, String whereSql, String orderBySql) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<M> getListByObj(M entity, PageInfo pageInfo, String whereSql) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<M> getListByObj(M entity, PageInfo pageInfo, String whereSql,
			String orderBySql) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<M> getListByObjSortByMultiField(M entity, PageInfo pageInfo,
			String whereSql, String orderBySql) {
		// TODO Auto-generated method stub
		return null;
	}

}
