package com.yiboche.common.utils;

import java.io.Serializable;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * 本地Session
 * @author lx
 *
 */
public class HttpSessionProvider implements SessionProvider{

	@Override
	public void setAttribute(HttpServletRequest request,HttpServletResponse response, String name,
			Serializable value) {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();//true    Cookie JSESSIONID
		session.setAttribute(name, value);
	}

	@Override
	public Serializable getAttribute(HttpServletRequest request,HttpServletResponse response, String name) {
		HttpSession session = request.getSession(false);
		if(session != null){
			return (Serializable) session.getAttribute(name);
		}
		return null;
	}

	@Override
	public void logout(HttpServletRequest request,HttpServletResponse response) {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession(false);
		if(session != null){
			session.invalidate();
		}
		//Cookie JSESSIONID 
		
	}

	@Override
	public String getSessionId(HttpServletRequest request,HttpServletResponse response) {
		// TODO Auto-generated method stub
		//request.getRequestedSessionId();  //Http://localhost:8080/html/sfsf.shtml?JESSIONID=ewrqwrq234123412
		return request.getSession().getId();
	}

}
