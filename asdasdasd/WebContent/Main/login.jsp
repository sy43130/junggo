<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>

	<form action="joincheck.do" method="post">
        
		<div align="center" float="auto">
		  <b>로그인</b><br>
			<table border="0" cellspacing="0" bgcolor="#0C0133" cellpadding="0" width="10">
				<tr>
					<td>

						<table border="0" cellpadding="3" cellspacing="1" width="250">
							<tr>
								<td width="150" bgcolor="#2E78ED">
									<p align="center">
									<font size="2" color="white">아이디</font>
								</td>
								<td width="383" bgcolor="#FFFFFF"><input type="text"
									name="id" maxlength="15" size="10"></td>
							</tr>
							<tr>
								<td width="150" bgcolor="#2E78ED">
									<p align="center">
										<font size="2" color="white">비밀번호</font>
								</td>
								<td width="383" bgcolor="#FFFFFF">
								<input type="password" name="pw" maxlength="15" size="10"></td>
							</tr>
							
						</table>
						
			</table>
				
			
			     <input type="submit" value="로그인" >
		</div>
		                
	
	</form>




</body>
</html>