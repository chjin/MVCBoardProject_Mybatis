package com.sist.controller;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class FileConfig {
	public static List<String> getFileName(String package1){
		
		List<String> list=new ArrayList<>();
		
		try{
			String path="C:\\Users\\cjw\\git\\MVCBoardProject_Mybatis\\src\\main\\java\\";
			path=path+package1.replace('.', '\\');
			
			File directory=new File(path);
			File[] files=directory.listFiles();
			
			for(File file:files){
				if(file.getName().equals("."))
					continue;
				if(file.isFile()){
					String name=file.getName();
					System.out.println(name);
					
					String extend=name.substring(name.lastIndexOf('.'));
					if(extend.equals("java")){
						String file1=package1+"."+name.substring(0, name.lastIndexOf('.'));
						System.out.println(file1);
						
						list.add(file1);
					}
				}
			}
					
		}catch(Exception ex){
			System.out.println(ex.getMessage());
		}
		
		return list;
	}
}


















































