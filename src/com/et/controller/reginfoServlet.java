package com.et.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.et.model.QueryData2;

public class reginfoServlet extends HttpServlet {

	/**
	 *servlet 是mvc 的控制层 是负责调度（javabean的创建 服务调用）
	 *例子 ：	1 获取表单数据  调用javabean写入数据库
	 *		2调用javabean获取数据集合将数据传递jsp视图中
	 *
	 */
	
	//控制层调用模型层
	QueryData2 qu = new QueryData2();
	
	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		
		try {
			String name=request.getParameter("dame");
			String curPage =request.getParameter("curPage");
			Integer curPageInt=1;
			if(curPage!=null){
				curPageInt=Integer.parseInt(curPage);
			}
			List<Map> tableList =  qu.getTable(name);
			//然后用请求转发将资源传到view层
			//由于tableList是局部变量所以要想传递到view层 那么就要使用jsp 作用域
			request.setAttribute("tableList", tableList);
			request.getRequestDispatcher("/view/dataView.jsp").forward(request, response);
		
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}


	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doGet(request, response);
	}

}
