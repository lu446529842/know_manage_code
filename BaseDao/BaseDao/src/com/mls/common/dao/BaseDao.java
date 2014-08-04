package com.mls.common.dao;

import java.io.Serializable;
import com.mls.common.bean.BaseEntity;

import org.mybatis.spring.support.SqlSessionDaoSupport;


public abstract class BaseDao<T extends Serializable, M extends BaseEntity> extends  SqlSessionDaoSupport implements IDao<T, M>{

}
