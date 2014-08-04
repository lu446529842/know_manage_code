package com.mls.common.util;

import java.util.List;
import java.io.Serializable;

/**
 * 分页控制
 * @author yuzhe
 *
 * @param <T>
 */
public class PagerControl<T> implements Serializable {
	private static final long serialVersionUID = 8226458551598788989L;
	private List<T> entityList;
	private PageInfo pageInfo;

	public PageInfo getPageInfo() {
		return this.pageInfo;
	}

	public void setPageInfo(PageInfo pageInfo) {
		this.pageInfo = pageInfo;
	}

	public List<T> getEntityList() {
		return this.entityList;
	}

	public void setEntityList(List<T> entityList) {
		this.entityList = entityList;
	}

	public String toString() {
		return "PagerControl [entityList=" + this.entityList + ", pageInfo="
				+ this.pageInfo + "]";
	}
}