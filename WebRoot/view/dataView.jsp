<!-- 
	jsp 是MVC模式中 的view层
	主要是和用户交互  只允许 出现html标记和 el表达式
 -->

<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<title>dataView</title>
		<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	</head>
	<body>
		<form action="${pageContext.request.contextPath}/servlet/reginfoServlet">
			<input type="text" name="userName"/>
			<input type="submit" value="提交"/>"
		</form>
		 <table>
    	<tr>
    		<th>usreName</th>
    		<th>password</th>
    		<th>sex</th>
    		<th>phone</th>
    		<th>email</th>
    		<th>hobbys</th>
    		<th>regUrl</th>
    		<th>bornDate</th>
    		<th>location</th>	
    	</tr>
	    <c:forEach var="temp" items="${requestScope.tableList}">
	    	<tr>
	    		<td>
	    			${pageScope.temp.usreName}
	    		</td>
	    		<td>
	    			${pageScope.temp.password}
	    		</td>
	    		<td>
	    			${pageScope.temp.sex}
	    		</td>
	    		<td>
	    			${pageScope.temp.phone}
	    		<td>
	    			${pageScope.temp.email}
	    		</td>
	    		<td>
	    			${pageScope.temp.hobbys}
	    		</td>
	    		<td>
	    			${pageScope.temp.regUrl}
	    		</td>
	    		
	    		<td>
	    			${pageScope.temp.bornDate}
	    		</td>
	    		<td>
	    			${pageScope.temp.location}
	    		</td>
	   	   	</tr>
	    </c:forEach>
	  </table>
	</body>
</html>
