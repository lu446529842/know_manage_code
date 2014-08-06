package com.mls.common.dao;

import java.io.Serializable;
import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.google.common.base.Strings;
import com.mls.common.bean.BaseEntity;
import com.mls.common.util.PageInfo;
import com.mls.common.util.PagerControl;

import org.mybatis.spring.support.SqlSessionDaoSupport;


public abstract class BaseDao<T extends Serializable, M extends BaseEntity> extends  SqlSessionDaoSupport implements IDao<T, M>{
	public static final String insertSelective = ".insertSelective";
	public static final String updateSelective = ".updateByPrimaryKeySelective";
	public static final String selectByPrimaryKey = ".selectByPrimaryKey";
	public static final String selectByPrimaryKeys = ".selectByPrimaryKeys";
	public static final String getListByEntityAndPageInfo = ".getListByEntityAndPageInfo";
	public static final String getTotalByEntity = ".getTotalByEntity";
	public static final String deleteByPrimaryKey = ".deleteByPrimaryKey";
	public static final String deleteByEntity = ".deleteByEntity";
	private Set<String> entityFields = new HashSet<String>();
	
	public BaseDao(){
	 if ((getClass().getGenericSuperclass() instanceof ParameterizedType)) {
	      Class entiry = (Class)((ParameterizedType)getClass().getGenericSuperclass()).getActualTypeArguments()[1];

	      for (Field field : entiry.getDeclaredFields())
	        if (!"serialVersionUID".equals(field.getName())) {
	          this.entityFields.add(field.getName());
	        }
	    }
	}
	
	public abstract String getMapperNameSpace(); 
	
	public Map<String, Object> getMapParams(M entity, PageInfo pageInfo, String whereSql, String orderBySql) {
	    Map<String,Object> map = new HashMap<String,Object>();
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
		return getSqlSession().insert(getMapperNameSpace()+insertSelective, entity);
	}

	@Override
	public int delete(T pk) {
		return getSqlSession().delete(getMapperNameSpace()+deleteByPrimaryKey, pk);
	}

	@Override
	public int deleteByEntity(M entity) {
		return getSqlSession().delete(getMapperNameSpace()+deleteByEntity, entity);
	}

	@Override
	public int update(M entity) {
		return getSqlSession().update(getMapperNameSpace()+updateSelective, entity);
	}

	@Override
	public M getEntityById(T pk) {
		return getSqlSession().selectOne(getMapperNameSpace()+selectByPrimaryKey, pk);
	}

	@Override
	public List<M> getEntityByIds(List<T> pks) {
		return getSqlSession().selectList(getMapperNameSpace()+selectByPrimaryKeys, pks);
	}


	@Override
	public M getEntityByObj(M entity) {
		return getEntityByObj(entity, null);
	}

	@Override
	public M getEntityByObj(M entity, String whereSql) {
		return getSqlSession().selectOne(getMapperNameSpace()+getListByEntityAndPageInfo, getMapParams(entity, null, whereSql, null));
	}

	@Override
	public int getCountByObj(M entity) {
		
		return getCountByObj(entity, null);
	}

	@Override
	public int getCountByObj(M entity, String whereSql) {
		Object object = getSqlSession().selectOne(getMapperNameSpace()+getTotalByEntity, getMapParams(entity, null, whereSql, null));
		if (object == null) {
			return 0;
		}
		
		return ((Integer)object).intValue();
	}

	@Override
	public PagerControl<M> getPagerByObj(M entity, PageInfo pageInfo,String whereSql) {
		return getPagerByObj(entity, pageInfo, whereSql, null);
	}

	@Override
	public PagerControl<M> getPagerByObj(M entity, PageInfo pageInfo,String whereSql, String orderBySql) {
		int totalCount = 0 ;
		List<M> list = new ArrayList<M>();
		PagerControl<M> pagerControl = new PagerControl<M>();
		
		pageInfo.startTime();
		totalCount = getCountByObj(entity, whereSql);
		if (totalCount > 0) {
			list = getListByObj(entity, pageInfo, whereSql, orderBySql);
		}
		
		pageInfo.endTime();
		pageInfo.setTotalCounts(totalCount);
		pagerControl.setPageInfo(pageInfo);
		if (list !=null) {
			pagerControl.setEntityList(list);
		}
		
		return pagerControl;
	}

	@Override
	public List<M> getAllEntityObj() {
		return getListByObj(null);
	}

	@Override
	public List<M> getListByObj(M entity) {
		return getListByObj(entity, null);
	}

	@Override
	public List<M> getListByObj(M entity, String whereSql) {
		return getListByObj(entity, null, whereSql, null);
	}

	@Override
	public List<M> getListByObj(M entity, String whereSql, String orderBySql) {
		return getListByObj(entity, null, whereSql, orderBySql);
	}

	@Override
	public List<M> getListByObj(M entity, PageInfo pageInfo, String whereSql) {
		return getListByObj(entity, pageInfo, whereSql, null);
	}

	@Override
	public List<M> getListByObj(M entity, PageInfo pageInfo, String whereSql,String orderBySql) {
		return getSqlSession().selectList(getMapperNameSpace()+getListByEntityAndPageInfo, getMapParams(entity, pageInfo, whereSql, orderBySql));
	}

	@Deprecated
	@Override
	public List<M> getListByObjSortByMultiField(M entity, PageInfo pageInfo,String whereSql, String orderBySql) {
		return null;
	}

}
