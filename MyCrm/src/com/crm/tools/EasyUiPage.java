package com.crm.tools;

import java.util.HashMap;
import java.util.Map;

import org.apache.struts2.json.JSONException;
import org.apache.struts2.json.JSONUtil;

import com.crm.vobj.PageInfo;

public class EasyUiPage {
	
	public static PageInfo createEasyuiPage(String page,String rows){
		int pageSize,pageIndex;
		 //��ǰҳ  
		pageIndex = Integer.parseInt((page == null || page == "0") ? "1":page);  
        //ÿҳ��ʾ����  
        pageSize = Integer.parseInt((rows == null || rows == "0") ? "5":rows);  
        //ÿҳ�Ŀ�ʼ��¼  ��һҳΪ1  �ڶ�ҳΪnumber +1
        
		PageInfo pi=new PageInfo(pageSize, pageIndex);
		
		return pi;
	}
	
	public static String getJsonString(int recordcount,Object list){
		Map<String, Object> jsonMap = new HashMap<String, Object>();	//����map  
		jsonMap.put("total", recordcount);	//total�� ����ܼ�¼���������  	
        jsonMap.put("rows", list);//rows�� ���ÿҳ��¼ list 	
        
		try {
			String result = JSONUtil.serialize(jsonMap);//��ʽ��result
			return result;
		} catch (JSONException e) {
			e.printStackTrace();
			return "{}";
		}
	}
}
