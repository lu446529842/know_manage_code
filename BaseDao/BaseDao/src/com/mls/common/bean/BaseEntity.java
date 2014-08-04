package com.mls.common.bean;

import java.io.Serializable;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

public abstract class BaseEntity implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 721880763188525713L;

	public abstract <T extends Serializable> T getId();
	
	public String toString(){
		return ToStringBuilder.reflectionToString(this, ToStringStyle.SHORT_PREFIX_STYLE);
	}
}
