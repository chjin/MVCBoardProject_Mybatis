package com.sist.controller;

import java.util.ArrayList;
import java.util.List;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class HandlerMapping extends DefaultHandler{
	
	List<String> list=new ArrayList<>();

	@Override
	public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
		try{
			if(qName.equals("context:component-scan")){
				String package1=attributes.getValue("base-package");
				list.add(package1);
			}
		}catch(Exception ex){
			System.out.println(ex.getMessage());
		}
	}

	
}













































