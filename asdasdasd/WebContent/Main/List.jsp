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
		<b>ȸ������</b><br>
			<table border="0" cellspacing="0" bgcolor="#0C0133" cellpadding="0"
				width="10">
				<tr>
					<td>
                        <table border="0" cellpadding="3" cellspacing="1" width="250">
							<tr>
								<td width="150" bgcolor="#2E78ED">
									<p align="center">
									<font size="2" color="white">���̵�</font>
								</td>
								<td width="383" bgcolor="#FFFFFF">${idList.id}</td>
							</tr>
							
							<tr>
								<td width="150" bgcolor="#2E78ED">
									<p align="center">
									<font size="2" color="white">��й�ȣ</font>
								</td>
								<td width="383" bgcolor="#FFFFFF">
								    ${idList.pw}
								</td>
							</tr>
							<tr>
								<td width="150" bgcolor="#2E78ED">
									<p align="center">
									<font size="2" color="white">�̸�</font>
								</td>
								<td width="383" bgcolor="#FFFFFF">
								    ${idList.name}
								</td>
							</tr>
							<tr>
									<td width="150" bgcolor="#2E78ED">
									<p align="center">
									<font size="2" color="white">����ó</font>
								</td>
								<td width="383" bgcolor="#FFFFFF">
								    ${idList.phone}
								</td>
							</tr>
							<tr>
							
									<td width="150" bgcolor="#2E78ED">
									<p align="center">
									<font size="2" color="white">����</font>
								</td>
								<td width="383" bgcolor="#FFFFFF">
								   ${idList.age}
								</td>
							</tr>
						    <tr>
							
									<td width="150" bgcolor="#2E78ED">
									<p align="center">
									<font size="2" color="white">����</font>
								</td>
								<td width="383" bgcolor="#FFFFFF">
								   ${idList.city}
								</td>
							</tr>	
						</table>
						</td>
				 </tr>
						 
			</table>
			                <div align="center">
		                    <a href="main.jsp">���ΰ���</a>
                            <a href="userdelete.do">����</a>
                            <a href="usermodifyPage.do">����</a>
                            
                            </div>
			             
			 
		</div>
	
	
	
   
   
</body>
</html>