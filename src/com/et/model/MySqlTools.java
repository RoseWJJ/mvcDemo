package com.et.model;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Properties;

public class MySqlTools {
	static Properties p = new Properties();
	
	static{
	
		InputStream is = MySqlTools.class.getResourceAsStream("/mysqtool.properties");
																
		try {
			p.load(is);
		} catch (IOException e) {
	
			e.printStackTrace();
		}
	}

	public  static Connection getConnection() throws Exception{
		String url = p.getProperty("url");
		System.out.println(url);
		String DriverClass = p.getProperty("DriverClass");
		System.out.println(DriverClass);
		String user = p.getProperty("user");
		String password = p.getProperty("password");
		Class.forName("com.mysql.jdbc.Driver");
		Connection conn = DriverManager.getConnection(url, user, password);
		System.out.println(conn);
		return conn;
		
	}
	public static List<Map> query(String sql) throws Exception{
		Connection conn = getConnection();
		PreparedStatement pre = conn.prepareStatement(sql);
		ResultSet rs = pre.executeQuery();
		ResultSetMetaData rsmd = rs.getMetaData();
		List list = new ArrayList();
		int count = rsmd.getColumnCount();
		System.out.println(count);
		while(rs.next()){
			Map map = new HashMap();
			for (int i = 1; i <= count; i++) {
				String colName = rsmd.getColumnName(i);
				String cvalue = rs.getString(i);
				map.put(colName, cvalue);
			}
			list.add(map);
			
		}
		return list;
	}

}
