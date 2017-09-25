package com.micropower.manager.utils;

import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.List;

public abstract class Common {
	/**
	 * 把数字转化为大写汉字数字
	 * @param showDecimalFlag 是否显示"X角X分"
	 */
	public static String convertDoubleToCNMoney(BigDecimal temp, boolean showDecimalFlag) {
		DecimalFormat format = new DecimalFormat("0.00");
		String[] tmpArr = format.format(temp).split("\\.");
		String cnStr = changeNumToCN(tmpArr[0] + (showDecimalFlag ? tmpArr[1] : ""));
		String[] chArr = { "分", "角", "元", "拾", "佰", "仟", "万", "拾", "佰", "仟", "亿", "拾", "佰", "仟"};
		String tmp = "";
		char[] chArr2 = cnStr.toCharArray();
		for(int i=0;i<chArr2.length;i++)
			tmp += chArr2[i] + chArr[chArr2.length-i+(showDecimalFlag?-1:1)];
		return tmp;
	}
	/**
	 * 把数字转化为大写汉字数字
	 * @param showDecimalFlag 是否显示"X角X分"
	 */
	public static String convertDoubleToCNMoney(Double temp, boolean showDecimalFlag) {
		DecimalFormat format = new DecimalFormat("0.00");
		String[] tmpArr = format.format(temp).split("\\.");
		String cnStr = changeNumToCN(tmpArr[0] + (showDecimalFlag ? tmpArr[1] : ""));
		String[] chArr = { "分", "角", "元", "拾", "佰", "仟", "万", "拾", "佰", "仟", "亿", "拾", "佰", "仟"};
		String tmp = "";
		char[] chArr2 = cnStr.toCharArray();
		for(int i=0;i<chArr2.length;i++)
			tmp += chArr2[i] + chArr[chArr2.length-i+(showDecimalFlag?-1:1)];
		return tmp;
	}
	
	private static String changeNumToCN(String str) {
		char[] chCharArr = "零壹贰叁肆伍陆柒捌玖".toCharArray();
		String tmp = "";
		char[] charArr = str.toCharArray();
		for(int i=0;i<charArr.length;i++)
			tmp += chCharArr[Integer.parseInt(""+charArr[i])];
		return tmp;
	}
	
	/**
	 * 判断字符串是否为空
	 */
	public static boolean isEmpty(String s) {
		if (null == s || "".equals(s.trim()))
			return true;
		return false;
	}
	
	/**
	 * 判断字符串是否非空
	 */
	public static boolean isNotEmpty(String s) {
		if (null == s || "".equals(s.trim()))
			return false;
		return true;
	}
	
	/**
	 * 把属性值转赋给自己指定的对象
	 */
	public static void setFieldValue(Object value, String field, Object entity)
			throws Exception {
		SimpleDateFormat   df   =   new   SimpleDateFormat("yyyy-MM-dd");
			if (null == value)
				return;
			String fieldValue = value.toString();
			// 字段类型与简单名称
			Class fieldClass;
			try {
				fieldClass= entity.getClass().getDeclaredField(field)
						.getType();
			} catch (Exception e) {
				fieldClass=entity.getClass().getMethod("get"+field.substring(0,1).toUpperCase()+field.substring(1)).getReturnType();
			}
			String typeName = fieldClass.getSimpleName();
			// 属性setter方法名
			String sMetodName = "set" + field.substring(0, 1).toUpperCase()
					+ field.substring(1);

			// 为了Long,Short,Boolean做的
			typeName = typeName.substring(0, 1).toUpperCase()
					+ typeName.substring(1);

			if (typeName.equals("String"))
				invokeMethod(entity, sMetodName, fieldValue);
			else {
				if ("".equals(fieldValue))
					return;
				if (typeName.equals("Date"))
					invokeMethod(entity, sMetodName, df.parse(fieldValue));
				else if (typeName.equals("Integer") || typeName.equals("Int"))
					invokeMethod(entity, sMetodName, Integer
							.parseInt(fieldValue));
				else if (typeName.equals("BigDecimal"))
					invokeMethod(entity, sMetodName, new BigDecimal(fieldValue));
				else {
					try {
						invokeMethod(entity, sMetodName, invokeStaticMethod(
								fieldClass, "parse" + typeName, fieldValue));
					} catch (Exception e) {
						Object o = getInstanceBy(fieldClass.getName(), Long
								.parseLong(fieldValue));
						invokeMethod(entity, sMetodName, o);
					}
				}
			} 
	}
	
	/**
	 * 通过构造器取得实例
	 * 
	 * @param className
	 *            类的全限定名
	 * @param intArgs
	 *            构造函数的参数值
	 * 
	 * @return Object
	 */
	public static Object getInstanceBy(String className, Object... intArgs)
			throws Exception {
		Class[] cs = new Class[intArgs.length];
		int index = 0;
		for (Object o : intArgs)
			cs[index++] = o.getClass();
		Object returnObj = null;

			Class classType = Class.forName(className);
			Constructor constructor = classType.getDeclaredConstructor(cs); // 找到指定的构造方法 
			constructor.setAccessible(true);// 设置安全检查，访问私有构造函数必须
			returnObj = constructor.newInstance(intArgs);
		return returnObj;
	}
	
	/**
	 * 通过类名、方法名、参数去调用静态方法
	 * 
	 * @param c
	 *            类的class
	 * @param methodName
	 *            方法名
	 * @param param
	 *            参数列表
	 * @throws Exception
	 */
	public static Object invokeStaticMethod(Class c, String methodName,
			Object... params) throws Exception {
			return invokeMethod(true, c, methodName, params);
	}

	/**
	 * 通过类名、方法名、参数去调用静态方法
	 * 
	 * @param className
	 *            类 名
	 * @param methodName
	 *            方法名
	 * @param param
	 *            参数列表
	 * @throws Exception
	 */
	public static Object invokeStaticMethod(String className,
			String methodName, Object... params) throws Exception {
			return invokeMethod(Class.forName(className), methodName, params);
	}
	
	/**
	 * 通过Object、方法名、参数去调用方法
	 * 
	 * @param flag
	 *            是否是静态
	 */
	private static Object invokeMethod(Boolean flag, Object entity,
			String methodName, Object... params) throws Exception {
			Object obj = entity;
			Class cls;
			if (flag)
				cls = (Class) obj;
			else
				cls = obj.getClass();
			Class[] classArgs = new Class[params.length];
			for (int i = 0; i < classArgs.length; i++) {
				classArgs[i] = params[i].getClass();
			}
			Method method ;
			try {
				method= cls.getDeclaredMethod(methodName, classArgs);// 包含privare方法
			} catch (Exception e) {
				method=cls.getMethod(methodName, classArgs);
			}
			Object result = method.invoke(flag ? null : obj, params);
			return result; 
	}

	/**
	 * 通过Object、方法名、参数去调用非静态方法
	 * 
	 * @param obj
	 *            类
	 * @param methodName
	 *            方法名
	 * @param param
	 *            参数列表
	 * @throws Exception
	 */
	public static Object invokeMethod(Object entity, String methodName,
			Object... params) throws Exception {

			return invokeMethod(false, entity, methodName, params);
	}

	/**
	 * 通过Object、方法名、参数去调用非静态方法
	 * 
	 * @param obj
	 *            类
	 * @param methodName
	 *            方法名
	 * @param param
	 *            参数列表
	 * @throws Exception
	 */
	public static Object invokeMethod(String className, String methodName,
			Object... params) throws Exception {

			Object obj = Class.forName(className).newInstance();
			return invokeMethod(obj, methodName, params);
	}
	
	public static String getObjectXmlData(Object bean){
		StringBuilder sb = new StringBuilder("");
		PropertyDescriptor[] props = null;
		try {
			props = Introspector.getBeanInfo(bean.getClass(), Object.class).getPropertyDescriptors();
		} catch (IntrospectionException e) {
			System.out.println(e.getMessage());
		}
		if (props != null) {
			for (int i = 0; i < props.length; i++) {
				try {
					//String name = objectToJson(props[i].getName());
					String name = props[i].getName();
					Object obj = props[i].getReadMethod().invoke(bean);
					sb.append("<"+name+">"+obj.toString()+"</"+name+">\n");
				} catch (Exception e) {
					System.out.println(e.getMessage());
				}
			}
		}
		return sb.toString();
	}
	
	public static String getListXmlData(List list){
		StringBuilder sb = new StringBuilder("");
		sb.append("<?xml version=\"1.0\" encoding=\"UTF-8\"?\">\n");
		sb.append("<DataRoot>\n");
		for(Object r:list){
			sb.append("<Record>\n");
			sb.append(getObjectXmlData(r));
			sb.append("</Record>\n");
		}
		sb.append("</DataRoot>\n");
		return sb.toString();
	}
}
