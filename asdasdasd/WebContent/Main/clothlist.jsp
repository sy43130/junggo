<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
<div align="center">
  <table border="0" cellspacing="0" bgcolor="#0C0133" cellpadding="0" width="10">
	  <tr>
	    <td>
		<table border="0" cellpadding="3" cellspacing="1" width="500">
		<tr>
			<td width="30" bgcolor="#2E78ED">
			   <p align="center">
			   <font size="2" color="white">글번호</font>
			</td>
			<td width="50" bgcolor="#2E78ED">
			   <p align="center">
			   <font size="2" color="white">아이디</font>
			</td>
			<td width="150" bgcolor="#2E78ED">
			   <p align="center">
			   <font size="2" color="white">제목</font>
			</td>
			
			
			
		
	    </tr>
		<c:forEach items="${clothlist}" var="clothlist">
		 <tr>
		     <td width="30" bgcolor="#FFFFFF" align="center">${clothlist.sqnumber}</td>
			 <td width="50" bgcolor="#FFFFFF" align="center">${clothlist.id}</td>
		     <td width="150" bgcolor="#FFFFFF"><a href="clothcontent.do?sqnumber=${clothlist.sqnumber}">${clothlist.title }</a></td>
				
		 </tr>
		</c:forEach>
		    
		
		
	
		
		</table>
		
		
		
	</td>
</tr>
		
	</table>
	         
			<a href="clothwrite_view.do">글 올리기</a>
			<a href="main.jsp">메인가기</a>
		  
	
</div>
     </table>
	    

</body>
</html>