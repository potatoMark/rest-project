package com.fujitsu.cn.iot.console.common.dto.impl;

import com.fujitsu.cn.iot.console.common.dto.Dto;
import com.fujitsu.cn.iot.console.common.dto.TypeCaseHelper;

import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Date;
import java.sql.Timestamp;
import java.util.HashMap;
import java.util.List;



/**
 * 数据传输对象(DateTransferObject)<br>
 * 建议在参数传递过程中尽量使用Dto来传递<br>
 *
 * @author OSWorks-XC
 * @since 2009-06-23
 * @see Dto
 * @see Serializable
 */
public class BaseDto extends HashMap<Object, Object> implements Dto, Serializable {

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;

	public BaseDto(){}

	public BaseDto(String key, Object value){
		put(key, value);
	}

	public BaseDto(Boolean success){
		setSuccess(success);
	}


	/**
	 * 以BigDecimal类型返回键值
	 *
	 * @param key
	 *            键名
	 * @return BigDecimal 键值
	 */
	public BigDecimal getAsBigDecimal(String key) {
		Object obj = TypeCaseHelper.convert(get(key), "BigDecimal", null);
		if (obj != null)
			return (BigDecimal) obj;
		else
			return null;
	}

	/**
	 * 以Date类型返回键值
	 *
	 * @param key
	 *            键名
	 * @return Date 键值
	 */
	public Date getAsDate(String key) {
		Object obj = TypeCaseHelper.convert(get(key), "Date", "yyyy-MM-dd");
		if (obj != null)
			return (Date) obj;
		else
			return null;
	}

	/**
	 * 以Integer类型返回键值
	 *
	 * @param key
	 *            键名
	 * @return Integer 键值
	 */
	public Integer getAsInteger(String key) {
		Object obj = TypeCaseHelper.convert(get(key), "Integer", null);
		if (obj != null)
			return (Integer) obj;
		else
			return null;
	}

	/**
	 * 以Long类型返回键值
	 *
	 * @param key
	 *            键名
	 * @return Long 键值
	 */
	public Long getAsLong(String key) {
		Object obj = TypeCaseHelper.convert(get(key), "Long", null);
		if (obj != null)
			return (Long) obj;
		else
			return null;
	}

	/**
	 * 以String类型返回键值
	 *
	 * @param key
	 *            键名
	 * @return String 键值
	 */
	public String getAsString(String key) {
		Object obj = TypeCaseHelper.convert(get(key), "String", null);
		if (obj != null)
			return (String) obj;
		else
			return "";
	}

	/**
	 * 以List类型返回键值
	 *
	 * @param key
	 *            键名
	 * @return List 键值
	 */
	public List<?> getAsList(String key){
		return (List<?>)get(key);
	}

	/**
	 * 以Timestamp类型返回键值
	 *
	 * @param key
	 *            键名
	 * @return Timestamp 键值
	 */
	public Timestamp getAsTimestamp(String key) {
		Object obj = TypeCaseHelper.convert(get(key), "Timestamp", "yyyy-MM-dd HH:mm:ss");
		if (obj != null)
			return (Timestamp) obj;
		else
			return null;
	}

	/**
	 * 以Boolean类型返回键值
	 *
	 * @param key
	 *            键名
	 * @return Timestamp 键值
	 */
	public Boolean getAsBoolean(String key){
		Object obj = TypeCaseHelper.convert(get(key), "Boolean", null);
		if (obj != null)
			return (Boolean) obj;
		else
			return null;
	}


    /**
     * 给Dto压入一个默认的Json格式字符串
     * @param jsonString
     */
	public void setDefaultJson(String jsonString){
    	put("defaultJsonString", jsonString);
    }

    /**
     * 获取默认的Json格式字符串
     * @return
     */
    public String getDefaultJson(){
    	return getAsString("defaultJsonString");
    }


	/**
	 * 设置交易状态
	 *
	 * @param pSuccess
	 */
	public void setSuccess(Boolean pSuccess){
		put("success", pSuccess);
		if (pSuccess) {
			//put("bflag", "1");
		}else {
			//put("bflag", "0");
		}

	}

	/**
	 * 打印DTO对象
	 *
	 */
	public void println(){
		System.out.println(this);
	}

}
