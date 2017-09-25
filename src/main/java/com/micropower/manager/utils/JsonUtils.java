package com.micropower.manager.utils;

import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.dom4j.Attribute;
import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;

public class JsonUtils {
	
	public static String nullToJson() {
		return "";
	}
	
	public static String numberToJson(Number number) {
		if (number.toString().equals("0") || number.toString().equals("0.0")) {
			return "\"\"";
		}
		return number.toString();
	}
	
	public static String booleanToJson(Boolean bool) {
		return bool.toString();
	}
	
	public static String stringToJson(String s) {
		if (s == null) {
			return nullToJson();
		}
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < s.length(); i++) {
			char ch = s.charAt(i);
			switch (ch) {
			case '"':
				sb.append("\\\"");
				break;
			case '\\':
				sb.append("\\\\");
				break;
			case '\b':
				sb.append("\\b");
				break;
			case '\f':
				sb.append("\\f");
				break;
			case '\n':
				sb.append("\\n");
				break;
			case '\r':
				sb.append("\\r");
				break;
			case '\t':
				sb.append("\\t");
				break;
			case '/':
				sb.append("\\/");
				break;
			default:
				if (ch >= '\u0000' && ch <= '\u001F') {
					String ss = Integer.toHexString(ch);
					sb.append("\\u");
					for (int k = 0; k < 4 - ss.length(); k++) {
						sb.append('0');
					}
					sb.append(ss.toUpperCase());
				} else {
					sb.append(ch);
				}
			}
		}
		return sb.toString();
	}
	
	private static String arrayToJson(Object[] array) {
		StringBuilder json = new StringBuilder();
		json.append("[");
		if (array != null && array.length > 0) {
			for (Object obj : array) {
				json.append(objectToJson(obj));
				json.append(",");
			}
			json.setCharAt(json.length() - 1, ']');
		} else {
			json.append("]");
		}
		return json.toString();
	}
	
	public static String setToJson(Set<?> set) {
		StringBuilder json = new StringBuilder();
		json.append("{");
		if (set != null && set.size() > 0) {
			for (Object obj : set) {
				json.append(objectToJson(obj));
				json.append(",");
			}
			json.setCharAt(json.length() - 1, '}');
		} else {
			json.append("}");
		}
		return json.toString();
	}
	
	public static String date18ToJson(Date date) {
		String dateFormatString = "";
		SimpleDateFormat sdf = null;
		sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		dateFormatString = sdf.format(date);
		return dateFormatString;
	}
	
	public static String objectToJson(Object obj) {
		StringBuilder json = new StringBuilder();
		if (obj == null) {
			json.append("\"\"");
		} else if (obj instanceof Number) {
			json.append(numberToJson((Number) obj));
		} else if (obj instanceof Boolean) {
			json.append(booleanToJson((Boolean) obj));
		} else if (obj instanceof String) {
			json.append("\"").append(stringToJson(obj.toString())).append("\"");
		} else if (obj instanceof Object[]) {
			json.append(arrayToJson((Object[]) obj));
		} else if (obj instanceof List) {
			json.append(listToJson(null, (List<?>) obj));
		} else if (obj instanceof Map) {
			json.append(mapToJson((Map<?, ?>) obj));
		} else if (obj instanceof Set) {
			json.append(setToJson((Set<?>) obj));
		} else if (obj instanceof Date) {
			json.append("\"").append(date18ToJson((Date) obj)).append("\"");
		} else {
			json.append(beanToJson(obj));
		}
		return json.toString();
	}
	
	public static String beanToJson(Object bean) {
		StringBuilder json = new StringBuilder();
		json.append("{");
		PropertyDescriptor[] props = null;
		try {
			props = Introspector.getBeanInfo(bean.getClass(), Object.class)
					.getPropertyDescriptors();
		} catch (IntrospectionException e) {
		}
		if (props != null) {
			for (int i = 0; i < props.length; i++) {
				try {
					String name = objectToJson(props[i].getName());
					String value = objectToJson(props[i].getReadMethod()
							.invoke(bean));
					json.append(name);
					json.append(":");
					json.append(value);
					json.append(",");
				} catch (Exception e) {
				}
			}
			json.setCharAt(json.length() - 1, '}');
		} else {
			json.append("}");
		}
		return json.toString();
	}
	
	public static String listToJson(String key, List<?> list) {
		StringBuilder json = new StringBuilder();
		json.append("{success:true,totalCount:"+((list==null||list.isEmpty())?0:list.size())+",total:"+((list==null||list.isEmpty())?0:list.size())+",\"" + key + "\":[");
		if (list != null && list.size() > 0) {
			for (Object obj : list) {
				json.append(objectToJson(obj));
				json.append(",");
			}
			json.setCharAt(json.length() - 1, ']');
		} else {
			json.append("]");
		}
		json.append("}");
		return json.toString();
	}
	
	public static String listToJson(List<?> list){
		StringBuilder json = new StringBuilder();
		json.append("[");
		if (list != null && list.size() > 0) {
			for (Object obj : list) {
				json.append(objectToJson(obj));
				json.append(",");
			}
			json.setCharAt(json.length() - 1, ']');
		} else {
			json.append("]");
		}
		return json.toString();
	}
	
	public static String mapToJson(Map<?, ?> map,String key_json,String value_json) {
		StringBuilder json = new StringBuilder();
		json.append("[");
		if (map != null && map.size() > 0) {
			for (Object key : map.keySet()) {
				json.append("{"+key_json+":"+objectToJson(key));
				json.append(",");
				json.append(value_json+":"+objectToJson(map.get(key)));
				json.append("}");
			}
		} else {
			json.append("]");
		}
		return json.toString();
	}
	
	public static String mapToJson(Map<?, ?> map) {
		StringBuilder json = new StringBuilder();
		json.append("{");
		if (map != null && map.size() > 0) {
			for (Object key : map.keySet()) {
				json.append(objectToJson(key));
				json.append(":");
				json.append(objectToJson(map.get(key)));
				json.append(",");
			}
			json.setCharAt(json.length() - 1, '}');
		} else {
			json.append("}");
		}
		return json.toString();
	}
	
	/**
	 * 从json转换成指定的类型对象
	 * @param c ->要转换到的类型
	 * @param values ->前台来的json格式字符串数组,数组中每个元素是一个对象的属性集合如{"id":"2","name":"zhangsan"}
	 * @return c的对象
	 */
	public static Object jsonToObject(Class c,String ejson){
		try {
			if(Common.isEmpty(ejson))
				return null;
			ejson = ejson.substring(ejson.indexOf("{")+1);
			ejson = (ejson.lastIndexOf("}") == -1) ? ejson : ejson.substring(0,ejson.lastIndexOf("}"));
			String[] os = ejson.split(",\"");
			Object o = c.getConstructor().newInstance();
			for(String key : os){ 
				try{
					String field = key.substring(0,key.indexOf(":"));//属性名
					if(0 == field.indexOf("\""))
						field = field.substring(field.indexOf("\"")+1);//去前双引号(如果有)
					field = (field.lastIndexOf("\"") == -1) ? field : field.substring(0,field.lastIndexOf("\""));//去后双引号(如果有)
					String fieldValue = key.substring(key.indexOf(":")+1);//属性值
					if(fieldValue.indexOf("\"") == 0)
						fieldValue = fieldValue.substring(fieldValue.indexOf("\"")+1);
					fieldValue = (fieldValue.lastIndexOf("\"")==-1)?fieldValue:fieldValue.substring(0,fieldValue.lastIndexOf("\""));
					Common.setFieldValue(fieldValue, field, o);
				} catch (Exception e) {
					System.err.println("类名："+c.getName()+";"+key+"这个属性在指定的类中不存在或值类型不正确!或外键类变量'" + key + "'必须有一个Long型参数的构造方法(public Example(Long id){})");
//					e.printStackTrace();
				}
			}
			return o;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	/**
	 * 从json转换成指定的类型 集合
	 * @param c ->要转换到的类型
	 * @param values ->前台来的json格式字符串数组,数组中每个元素是一个对象的属性集合如{"id":"2","name":"zhangsan"}
	 * @return c的集合
	 */
	public static List jsonToList(Class c,String[] values) {
		List list=new ArrayList();
		try{
			if(null != values && values.length>0){
				for(String ejson : values){
					if(null == ejson)
						continue;
					Object o = jsonToObject(c,ejson);
					if(null == o)
						continue;
					list.add(o);
				}
			}
		} catch (Exception e){
			e.printStackTrace();
		}
		return list;
	}
	/*
	 * default 2
	 */
	public static Map<String, List> getSupcanTreeListForm(String xml,Class c,String keyField) {
		List nlist = new ArrayList();
		List mlist = new ArrayList();
		List dlist = new ArrayList();
		
		if(null!=xml&&xml.trim().length()>0){
			Document doc = null;
			try {
				doc = DocumentHelper.parseText(xml);
				Element rootElt = doc.getRootElement(); // 获取根节点
				
				Iterator itermAdd = rootElt.elementIterator("newRow");
				if(itermAdd.hasNext()){
					Element recordnew = (Element)itermAdd.next();
					Iterator iterrow = recordnew.elementIterator("row");
					while(iterrow.hasNext()){
						Element recordnewData = (Element)iterrow.next();
						Iterator ia = recordnewData.elementIterator();
						Object o = c.getConstructor().newInstance();
						while(ia.hasNext()){
							Element recordnsx = (Element)ia.next();
							String field = recordnsx.getName();
							String fieldValue = null;
							try {
								fieldValue = recordnsx.getData().toString();
							} catch (Exception e) {
								fieldValue = null;
							}
							try{
								Common.setFieldValue(fieldValue, field, o);
							}catch(Exception e){
								continue;
							}
						}
						nlist.add(o);
					}
				}
				
				Iterator itermModify = rootElt.elementIterator("modifiedRow");
				if(itermModify.hasNext()){
					Element recordnew = (Element)itermModify.next();
					Iterator iterrow = recordnew.elementIterator("row");
					while(iterrow.hasNext()){
						Element recordnewData = (Element)iterrow.next();
						Iterator ia = recordnewData.elementIterator();
						Object o = c.getConstructor().newInstance();
						while(ia.hasNext()){
							Element recordnsx = (Element)ia.next();
							String field = recordnsx.getName();
							String fieldValue = null;
							try {
								fieldValue = recordnsx.getData().toString();
							} catch (Exception e) {
								fieldValue = null;
							}
							try{
								Common.setFieldValue(fieldValue, field, o);
							}catch(Exception e){
								continue;
							}
						}
						mlist.add(o);
					}
				}
				Iterator itermDelete = rootElt.elementIterator("deletedRow");
				if(itermDelete.hasNext()){
					Element recordnew = (Element)itermDelete.next();
					Iterator iterrow = recordnew.elementIterator("row");
					while(iterrow.hasNext()){
						Element recordnewData = (Element)iterrow.next();
						Attribute dkk = recordnewData.attribute("key");
						Object o = c.getConstructor().newInstance();
						Object keys = dkk.getData();
						String keyName = null;
						String[] keyArr = null;
						if(keys!=null){
							keyArr = keys.toString().split(",");
							if(0==keyArr.length||null==keyArr[0]||keyArr[0].trim().isEmpty()){
								keyName = "nid";
							}else{
								keyName = keyArr[0].trim();
							}
						}
						try{
							Common.setFieldValue(keyName, keyField, o);
						}catch(Exception e){
							
						} 
						dlist.add(o);
					}
				}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		Map<String,List> r = new HashMap<String,List>();
		r.put("add", nlist);
		r.put("modify", mlist);
		r.put("delete", dlist);
		return r;
	}
	
	public static Map<String, List> getSupcanTreeListForm3(String xml,Class c,String keyField) {
		List nlist = new ArrayList();
		List mlist = new ArrayList();
		List dlist = new ArrayList();
		List olist = new ArrayList();
		
		if(null!=xml&&xml.trim().length()>0){
			Document doc = null;
			try {
				doc = DocumentHelper.parseText(xml);
				Element rootElt = doc.getRootElement(); // 获取根节点
				
				Iterator itermAdd = rootElt.elementIterator("newRow");
				if(itermAdd.hasNext()){
					Element recordnew = (Element)itermAdd.next();
					Iterator iterrow = recordnew.elementIterator("row");
					while(iterrow.hasNext()){
						Element recordnewData = (Element)iterrow.next();
						Iterator ia = recordnewData.elementIterator();
						Object o = c.getConstructor().newInstance();
						while(ia.hasNext()){
							Element recordnsx = (Element)ia.next();
							String field = recordnsx.getName();
							String fieldValue = null;
							try {
								fieldValue = recordnsx.getData().toString();
							} catch (Exception e) {
								fieldValue = null;
							}
							try{
								Common.setFieldValue(fieldValue, field, o);
							}catch(Exception e){
								continue;
							}
						}
						nlist.add(o);
					}
				}
				
				Iterator itermModify = rootElt.elementIterator("modifiedRow");
				if(itermModify.hasNext()){
					Element recordnew = (Element)itermModify.next();
					Iterator iterrow = recordnew.elementIterator("row");
					while(iterrow.hasNext()){
						Element recordnewData = (Element)iterrow.next();
						Iterator ia = recordnewData.elementIterator();
						Object o = c.getConstructor().newInstance();
						while(ia.hasNext()){
							Element recordnsx = (Element)ia.next();
							String field = recordnsx.getName();
							String fieldValue = null;
							try {
								fieldValue = recordnsx.getData().toString();
							} catch (Exception e) {
								fieldValue = null;
							}
							try{
								Common.setFieldValue(fieldValue, field, o);
							}catch(Exception e){
								continue;
							}
						}
						mlist.add(o);
					}
				}
				Iterator itermDelete = rootElt.elementIterator("deletedRow");
				if(itermDelete.hasNext()){
					Element recordnew = (Element)itermDelete.next();
					Iterator iterrow = recordnew.elementIterator("row");
					while(iterrow.hasNext()){
						Element recordnewData = (Element)iterrow.next();
						Attribute dkk = recordnewData.attribute("key");
						Object o = c.getConstructor().newInstance();
						Object keys = dkk.getData();
						String keyName = null;
						String[] keyArr = null;
						if(keys!=null){
							keyArr = keys.toString().split(",");
							if(0==keyArr.length||null==keyArr[0]||keyArr[0].trim().isEmpty()){
								keyName = "nid";
							}else{
								keyName = keyArr[0].trim();
							}
						}
						try{
							Common.setFieldValue(keyName, keyField, o);
						}catch(Exception e){
							
						}
						dlist.add(o);
					}
				}
				
				
				Iterator itermNotModified = rootElt.elementIterator("notModifiedRow");
				if(itermNotModified.hasNext()){
					Element recordnew = (Element)itermNotModified.next();
					Iterator iterrow = recordnew.elementIterator("row");
					while(iterrow.hasNext()){
						Element recordnewData = (Element)iterrow.next();
						Iterator ia = recordnewData.elementIterator();
						Object o = c.getConstructor().newInstance();
						while(ia.hasNext()){
							Element recordnsx = (Element)ia.next();
							String field = recordnsx.getName();
							String fieldValue = null;
							try {
								fieldValue = recordnsx.getData().toString();
							} catch (Exception e) {
								fieldValue = null;
							}
							try{
								Common.setFieldValue(fieldValue, field, o);
							}catch(Exception e){
								continue;
							}
						}
						olist.add(o);
					}
				}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		Map<String,List> r = new HashMap<String,List>();
		r.put("add", nlist);
		r.put("modify", mlist);
		r.put("delete", dlist);
		r.put("normal", olist);
		return r;
	}
	
	public static List getSupcanTreeListFormByLevel0(String xml,
			Class c) {
		List list = new ArrayList();
		if(null!=xml&&xml.trim().length()>0){
			Document doc = null;
			try{
				doc = DocumentHelper.parseText(xml);
				Element rootElt = doc.getRootElement(); // 获取根节点
				Iterator itermRow = rootElt.elementIterator("row");
				while(itermRow.hasNext()){
					Element recordr = (Element)itermRow.next();
					Iterator ia = recordr.elementIterator();
					Object o = c.getConstructor().newInstance();
					while(ia.hasNext()){
						Element recordnsx = (Element)ia.next();
						String field = recordnsx.getName();
						String fieldValue = null;
						try {
							fieldValue = recordnsx.getData().toString();
						} catch (Exception e) {
							fieldValue = null;
						}
						try{Common.setFieldValue(fieldValue, field, o);}catch(Exception e){e.printStackTrace();}
					}
					list.add(o);
				}
			}catch (Exception e) {
				e.printStackTrace();
			}
		}
		return list;
	}
}
