package com.et.model;

import java.util.List;
import java.util.Map;
/**
 * javabean ��mvc���ģʽ��ģ�Ͳ� model�� ��������
 * @author THINK
 *
 */
public class QueryData2 {
	 public static List getTable(String userName) throws Exception{
		 if(userName==null){
			 userName="";	 
		 }
	
		 List<Map> reuslt = MySqlTools.query("select * from reguser where userName like '%"+userName+"%'");
		 System.out.println(reuslt+"------------");
		 return reuslt;
	 } 
}
