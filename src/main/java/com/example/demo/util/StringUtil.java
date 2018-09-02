package com.example.demo.util;

import java.io.UnsupportedEncodingException;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.UUID;

/**
 * 字符串工具类
 * @author celin
 *
 */
public class StringUtil {
	
	/**
	 * 判断是否为空
	 * @param str
	 * @return
	 */
	public static boolean isEmpty(String str){
		return str==null||"".equals(str.trim())?true:false;
	}
	
	/**
	 * 判断是否不为空
	 * @param str
	 * @return
	 */
	public static boolean isNotEmpty(String str){
		return str==null||"".equals(str.trim())?false:true;
	}
	
	/**
	 * 格式化字符串，如果是null，返回空字符串
	 * @param obj
	 * @return
	 */
	public static String formatStr(Object obj){
		return obj==null?"":obj.toString();
	}
	
	/**
	 * 字符串编码集转换(ISO=>UTF-8)
	 * @param obj
	 * @return
	 * @throws UnsupportedEncodingException 
	 */
	public static String strISOToUTF8(Object obj) throws UnsupportedEncodingException{
		return obj==null?"":strISOToUTF8(obj.toString());
	}
	
	/**
	 * 字符串编码集转换(UTF-8=>ISO)
	 * @param obj
	 * @return
	 * @throws UnsupportedEncodingException 
	 */
	public static String strUTF8ToISO(String str) throws UnsupportedEncodingException{
			return new String(str.getBytes() ,"ISO8859-1");
    }
	
	/**
	 * 字符串编码集转换(UTF-8=>ISO)
	 * @param obj
	 * @return
	 * @throws UnsupportedEncodingException 
	 */
	public static String strUTF8ToISO(Object obj) throws UnsupportedEncodingException{
		return obj==null?"":strUTF8ToISO(obj.toString());
	}
	
	/**
	 * 字符串编码集转换(ISO=>UTF-8)
	 * @param obj
	 * @return
	 * @throws UnsupportedEncodingException 
	 */
	public static String strISOToUTF8(String str) throws UnsupportedEncodingException{
			return new String(str.getBytes() ,"UTF-8");
    }

	/**
	 * 将字符串的命名转换成为驼峰命名。<br>
	 * 例如：user_name 转换后userName; 注意只是下划线分割的字符串。将原来的字符串全部转化成为小写了。
	 * 
	 * @param arg
	 * @return
	 */
	public static String toTuoFeng(String arg) {
		if (arg == null) {
			return null;
		}
		String result = "";

		String[] temp = arg.toLowerCase().split("_"); // 下划线分割
		int LEN = temp.length;
		for (int i = 0; i < LEN; i++) {
			if (i != 0) {
				result = result + capFirst(temp[i]);
			} else {
				result = result + temp[i];
			}
		}
		
		return result;
	}
	
	/**
	 * 将字符串的命名转换成为下划线命名。<br>
	 * 例如：userName 转换后USER_NAME。
	 * @param code
	 * @return
	 * @throws Exception
	 */
	public static String toXiaHuaXian(String code) {
		if(!isEmpty(code)){
			for(int i=0;i<code.length();i++){
				char c = code.charAt(i);
				if(Character.isUpperCase(c)){
					code = code.replaceAll(String.valueOf(c), "_"+String.valueOf(c).toLowerCase());
				}
			}
			return code.toUpperCase();
		}
		return "";
	}
	
	/**
	 * 将第一个字母大写；
	 * 
	 * @param s
	 * @return
	 */
	public static String capFirst(String s) {
		int i = 0;
		int ln = s.length();
		while (i < ln && Character.isWhitespace(s.charAt(i))) {
			i++;
		}
		if (i < ln) {
			StringBuffer b = new StringBuffer(s);
			b.setCharAt(i, Character.toUpperCase(s.charAt(i)));
			s = b.toString();
		}
		return s;
	}
	
	/**
	 * 将List转化成JSON
	 * @param list 存Map类型
	 * @return
	 */
	public static String generateJSON(List list){
		StringBuffer json2 = new StringBuffer();
		json2.append("[");
		for (int i=0;i<list.size();i++){
			Map map = (Map)list.get(i);
			Set set = map.entrySet();
			Iterator it = set.iterator();
			int count = 0;
			json2.append("{");
			while (it.hasNext()){
				Map.Entry entry = (Map.Entry)it.next();
				String key = entry.getKey().toString().toUpperCase();
				json2.append("\"").append(key).append("\"").append(":").append("\"").append(entry.getValue()==null?"":entry.getValue()).append("\"");
				if (count<set.size()-1)
					json2.append(",");
				count++;
				
			}
			json2.append("}");
			if (i<list.size()-1)
				json2.append(",");
		}
		json2.append("]");
		return json2.toString();
	}
	
	/**
	 * 将Map转化成JSON
	 * @param map
	 * @return
	 */
	public static String generateJSON2(Map  map){
		StringBuffer json2 = new StringBuffer();
		json2.append("[");
		Set set = map.entrySet();
		Iterator it = set.iterator();
		int count = 0;
		json2.append("{");
		while (it.hasNext()){
			Map.Entry entry = (Map.Entry)it.next();
			json2.append("\"").append(entry.getKey()).append("\"").append(":").append("\"").append(entry.getValue()).append("\"");
			if (count<set.size()-1)
				json2.append(",");
			count++;
			
		}
		json2.append("}");
		json2.append("]");
		return json2.toString();
	}
	
	/**
	  * Title: getUUID 
	  * Description: 生成32位UUID号
	  * Param @return
	  * Return String
	  * Modify: ChengLin 2013-4-15下午4:19:20  创建
	 */
	public static String getUUID(){
		
		return UUID.randomUUID().toString().replaceAll("-", "").toUpperCase();
	}
}
