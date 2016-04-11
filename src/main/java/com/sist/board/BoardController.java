package com.sist.board;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import com.sist.controller.Controller;
import com.sist.controller.RequestMapping;

/*
 * JSP => ¿äÃ» => content.do
 */
@Controller("bc")
public class BoardController {
	@RequestMapping("list.do")
	public String boardListData(HttpServletRequest req){
		String page=req.getParameter("page");
		if(page==null){
			page="1";	
		}
		
		int curpage=Integer.parseInt(page);
		int rowSize=10;
		int start=(curpage*rowSize)-(rowSize-1);
		int end=curpage*rowSize;
		
		Map map=new HashMap();
		map.put("start", start);
		map.put("end", end);
		
		
		
		
		return "freeboard/list.jsp";
	}
}


























