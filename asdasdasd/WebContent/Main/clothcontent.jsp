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
     
     <table width="500" cellpadding="3" cellspacing="1" border="1">
	       
			
			<tr>
				<td width="100" bgcolor="2E78ED">
	            <p align="center">
	            <font size="2" color="white"></font>���̵�</td>
				<td width="383" bgcolor="#FFFFFF">${contentview.id}</td>
			</tr>
			<tr>
				<td width="100" bgcolor="2E78ED">
	            <p align="center">
	            <font size="2" color="white"></font>����</td>
				<td width="383" bgcolor="#FFFFFF">${contentview.title}</td>
			</tr>
			<tr>
				<td width="100" bgcolor="2E78ED">
	            <p align="center">
	            <font size="2" color="white"></font>����</td>
				<td width="383" height="500" bgcolor="#FFFFFF">${contentview.content}</td>
				
			</tr>
			<tr>

                <td colspan="2"><img width="100%" height="400" src="${contentview.filename}"></td>
                  
            </tr>

			
		</table>
		
		<a href="clothlist.do">��Ϻ���</a>
		
		<c:if test="${contentview.id eq id }">
		<a href="clothdelete.do?sqnumber=${contentview.sqnumber}">�����ϱ�</a>
		<a href="clothmodifypage.do?sqnumber=${contentview.sqnumber}">�����ϱ�</a>
		</c:if>
	</table>
	
</div>	
        

</body>
</html>