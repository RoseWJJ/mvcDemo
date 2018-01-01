package com.et.model;

import java.util.List;
import java.util.Map;
/**
 * javabean 是mvc设计模式的模型层 model层 操作数据
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
