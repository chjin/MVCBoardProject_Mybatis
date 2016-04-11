package com.sist.controller;

import java.io.IOException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DispatcherServlet extends HttpServlet{

	private WebApplicationContext webApplicationContext;
	private List<String> list=new ArrayList<>();
	@Override
	public void init(ServletConfig config) throws ServletException {
		String path=config.getInitParameter("contextConfigLocation");

		//IOC 컨테이너
		webApplicationContext=new WebApplicationContext(path);
		list=webApplicationContext.getFileName();
	}
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try{
			
			String cmd=request.getRequestURI();
			
			cmd=cmd.substring(request.getContextPath().length()+1);
			
			for(String strClazz:list){
				Class clazzName=Class.forName(strClazz);
				
				if(clazzName.isAnnotationPresent(Controller.class)==false)
					continue;
				Object object= clazzName.newInstance();	
				
				Method[] methods=clazzName.getDeclaredMethods();
				for(Method method:methods){
					RequestMapping requestMapping=method.getAnnotation(RequestMapping.class);
					if(requestMapping.value().equals(cmd)){
						String jsp=(String)method.invoke(object, request);
						
						RequestDispatcher requestDispatcher=request.getRequestDispatcher(jsp);
						requestDispatcher.forward(request, response);
						return;
					}
				}
				
				
			}
		}catch(Exception ex){
			System.out.println(ex.getMessage());
		}
	}
	
	
	
	
	
}


























































