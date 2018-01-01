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
	 *servlet ��mvc �Ŀ��Ʋ� �Ǹ�����ȣ�javabean�Ĵ��� ������ã�
	 *���� ��	1 ��ȡ������  ����javabeanд�����ݿ�
	 *		2����javabean��ȡ���ݼ��Ͻ����ݴ���jsp��ͼ��
	 *
	 */
	
	//���Ʋ����ģ�Ͳ�
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
			//Ȼ��������ת������Դ����view��
			//����tableList�Ǿֲ���������Ҫ�봫�ݵ�view�� ��ô��Ҫʹ��jsp ������
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
