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
		<b>회원정보</b><br>
			<table border="0" cellspacing="0" bgcolor="#0C0133" cellpadding="0"
				width="10">
				<tr>
					<td>
                        <table border="0" cellpadding="3" cellspacing="1" width="250">
							<tr>
								<td width="150" bgcolor="#2E78ED">
									<p align="center">
									<font size="2" color="white">아이디</font>
								</td>
								<td width="383" bgcolor="#FFFFFF">${idList.id}</td>
							</tr>
							
							<tr>
								<td width="150" bgcolor="#2E78ED">
									<p align="center">
									<font size="2" color="white">비밀번호</font>
								</td>
								<td width="383" bgcolor="#FFFFFF">
								    ${idList.pw}
								</td>
							</tr>
							<tr>
								<td width="150" bgcolor="#2E78ED">
									<p align="center">
									<font size="2" color="white">이름</font>
								</td>
								<td width="383" bgcolor="#FFFFFF">
								    ${idList.name}
								</td>
							</tr>
							<tr>
									<td width="150" bgcolor="#2E78ED">
									<p align="center">
									<font size="2" color="white">연락처</font>
								</td>
								<td width="383" bgcolor="#FFFFFF">
								    ${idList.phone}
								</td>
							</tr>
							<tr>
							
									<td width="150" bgcolor="#2E78ED">
									<p align="center">
									<font size="2" color="white">나이</font>
								</td>
								<td width="383" bgcolor="#FFFFFF">
								   ${idList.age}
								</td>
							</tr>
						    <tr>
							
									<td width="150" bgcolor="#2E78ED">
									<p align="center">
									<font size="2" color="white">도시</font>
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
		                    <a href="main.jsp">메인가기</a>
                            <a href="userdelete.do">삭제</a>
                            <a href="usermodifyPage.do">수정</a>
                            
                            </div>
			             
			 
		</div>
	
	
	
   
   
</body>
</html>