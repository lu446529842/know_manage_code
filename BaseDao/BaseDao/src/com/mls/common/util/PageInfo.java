package com.mls.common.util;

import java.io.Serializable;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

/**
 * 分页控制信息
 * @author yuzhe
 *
 */
public class PageInfo implements Serializable {
	private static final long serialVersionUID = -6736441876926719848L;
	
	public PageInfo() {
		this.startTime = System.currentTimeMillis();
	}

	public PageInfo(int page, int pagesize) {
		if (page < 1)
			page = 1;
		this.page = page;
		this.pageSize = pagesize;
		this.startIndex = ((page - 1) * pagesize);
		this.startTime = System.currentTimeMillis();
	}
	
	private int totalCounts = 0;
	private int allPage = 0;
	private int page = 1;
	private long startTime = 0L;
	private long endTime = 0L;
	private String orderField; //排序字段
	private String orderDirection; //排序方向
	private String orderBySql;
	private int pageSize = 20;
	private String useTime = "0";
	private int startIndex = 0;
	private Integer isPrev = Integer.valueOf(0);
	private Integer isNext = Integer.valueOf(0);
	private List<Integer> listPages = new ArrayList(); //分页数

	public String getOrderBySql() {
		return this.orderBySql;
	}

	public void setOrderBySql(String orderBySql) {
		this.orderBySql = orderBySql;
	}

	public Integer getIsPrev() {
		return this.isPrev;
	}

	public void setIsPrev(Integer isPrev) {
		this.isPrev = isPrev;
	}

	public Integer getIsNext() {
		return this.isNext;
	}

	public void setIsNext(Integer isNext) {
		this.isNext = isNext;
	}

	public List<Integer> getListPages() {
		return this.listPages;
	}

	public void startTime() {
		this.startTime = System.currentTimeMillis();
	}

	public void endTime() {
		this.endTime = System.currentTimeMillis();
		setUseTime(this.endTime - this.startTime);
	}

	public String getUseTime() {
		return this.useTime;
	}

	public void setUseTime(long useTime) {
		DecimalFormat df = new DecimalFormat("0");
		this.useTime = df.format(Float.parseFloat(useTime + "") / 1000.0F);
		df = null;
	}

	public int getTotalCounts() {
		return this.totalCounts;
	}

	public void setTotalCounts(int totalCounts) {
		this.totalCounts = totalCounts;
		executePage();
	}

	public int getAllPage() {
		return this.allPage;
	}

	public void setAllPage(int allPage) {
		this.allPage = allPage;
	}

	public int getPage() {
		return this.page;
	}

	public void setPage(int page) {
		if (page < 1)
			page = 1;
		this.page = page;
		this.startIndex = ((page - 1) * this.pageSize);
	}

	public int getPagesize() {
		return this.pageSize;
	}

	public void setPagesize(int pagesize) {
		this.pageSize = pagesize;
		executePage();
	}

	public int getStartIndex() {
		return this.startIndex;
	}

	public void setStartIndex(int startIndex) {
		this.startIndex = startIndex;
	}

	public long getStartTime() {
		return this.startTime;
	}

	public void setStartTime(long startTime) {
		this.startTime = startTime;
	}

	public long getEndTime() {
		return this.endTime;
	}

	public void setEndTime(long endTime) {
		this.endTime = endTime;
	}

	public void setListPages(List<Integer> listPages) {
		this.listPages = listPages;
	}

	public void setUseTime(String useTime) {
		this.useTime = useTime;
	}

	public String getOrderDirection() {
		return this.orderDirection;
	}

	public void setOrderDirection(String orderDirection) {
		this.orderDirection = orderDirection;
	}

	public String getOrderField() {
		return this.orderField;
	}

	public void setOrderField(String orderField) {
		this.orderField = orderField;
	}
	
	public void executePage() {
		if (this.totalCounts > 0) {
			this.allPage = (this.totalCounts / this.pageSize);
			if (this.totalCounts % this.pageSize != 0){
				this.allPage += 1;
			}
		}
		
		//设定起始页
		int startX = 1;
		if ((this.page > 4) && (this.page <= this.allPage)) {
			startX = this.page - 4;
		}
		
		//计算前后页 和entity
		if ((this.page > 1) && (this.page <= this.allPage)){
			this.isPrev = Integer.valueOf(this.page - 1);
		}
		
		//选取一定的页范围 不超过10页
		for (int i = startX; (i < startX + 10) && (i <= this.allPage); i++) {
			this.listPages.add(Integer.valueOf(i));
		}
		
		if (this.page < this.allPage){
			this.isNext = Integer.valueOf(this.page + 1);
		}
	}
	
	@Override
	public String toString() {
		return "PageInfo [allPage=" + this.allPage + ", endTime="
				+ this.endTime + ", isNext=" + this.isNext + ", isPrev="
				+ this.isPrev + ", listPages=" + this.listPages + ", page="
				+ this.page + ", pagesize=" + this.pageSize + ", startIndex="
				+ this.startIndex + ", startTime=" + this.startTime
				+ ", totalCounts=" + this.totalCounts + ", useTime="
				+ this.useTime + "]";
	}
}