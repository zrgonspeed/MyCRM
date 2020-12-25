package com.crm.tools;

import java.util.Map;

import com.opensymphony.xwork2.ActionContext;

public class Scopes {
	/**
	 * ����Session����
	 * @return
	 */
	public static Map<String,Object> getSessionMap(){
		return ActionContext.getContext().getSession();
	}
	/**
	 * ����Application����
	 * @return
	 */
	public static Map<String,Object> getApplicationMap(){
		return ActionContext.getContext().getApplication();
	}
	/**
	 * ����request����
	 * @return
	 */
	public static ActionContext getRequestMap(){
		return ActionContext.getContext();
	}
}
