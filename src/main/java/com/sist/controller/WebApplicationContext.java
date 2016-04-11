package com.sist.controller;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

//IOC 컨테이너 역할.
public class WebApplicationContext {

	List<String> list=new ArrayList<String>();
	
	public WebApplicationContext(String path){
		try{
			SAXParserFactory saxParserFactory=
					SAXParserFactory.newInstance();
			SAXParser saxParser=
					saxParserFactory.newSAXParser();
			
			HandlerMapping handlerMapping=new HandlerMapping();
			saxParser.parse(new File(path), handlerMapping);
			
			list=handlerMapping.list;
		}catch(Exception ex){
			System.out.println(ex.getMessage());
		}
	}
	
	public List<String> getFileName(){
		List<String> packageList=new ArrayList<String>();
		
		for(String package1:packageList){
			List<String> fileList=FileConfig.getFileName(package1);
			
			for(String str:fileList){
				packageList.add(str);
			}
		}
		
		return packageList;
	}
}


















































