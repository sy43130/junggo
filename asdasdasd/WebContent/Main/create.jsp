<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
<script>
	function check() {
		var input = document.getElementsByTagName("input");
		// 모든 inpt 
		for (var i = 0; i < 6; i++) {
			if (input[i].value === "") { // id 칸 
				alert(i + "번째 칸을 채워"); // 채워 
				return false;
			}
		}
		return true;
	}
</script>
<style type="text/css">
input{
   border:none;
  
}

</style>
</head>

<body style="font-family: 돋움;">

	<center>
		<b>회원가입</b><br>
		
		<form action="join.do" method="post" onSubmit="return check()">
		
			<div align="center">
				<table border="0" cellspacing="0" bgcolor="#0C0133" cellpadding="0" width="10">
					<tr>
						<td>
							<table border="0" cellpadding="4" cellspacing="1" width="400">
								<tr>
									<td width="97" bgcolor="#2E78ED">
										<p align="center">
											<font size="2" color="white">아이디</font>
									</td>
									<td width="383" bgcolor="#FFFFFF"><input type="text"
										name="id" maxlength="15" size="15"></td>
								</tr>
								<tr>
									<td width="97" bgcolor="#2E78ED">
										<p align="center">
											<font size="2" color="white">패스워드</font>
									</td>
									<td width="383" bgcolor="#FFFFFF">
									<input type="text" name="pw" maxlength="15" size="15"></td>
								</tr>
								<tr>
									<td width="97" bgcolor="#2E78ED">
										<p align="center">
										<font size="2" color="white">이름</font>
									</td>
									<td width="383" bgcolor="#FFFFFF">
									<input type="text" name="name" maxlength="15" size="15"></td>
								</tr>
								<tr>
									<td width="97" bgcolor="#2E78ED">
										<p align="center">
										<font size="2" color="white">연락처</font>
									</td>
									<td width="383" bgcolor="#FFFFFF"><font size="2"> 
									<input type="text" name="phone" mexlength="15" size="15"></td>
								</tr>
								<tr>
									<td width="97" bgcolor="#2E78ED">
										<p align="center">
										<font size="2" color="white">나이</font>
									</td>
									<td width="383" bgcolor="#FFFFFF"><font size="2"> 
									<input type="text" name="age" mexlength="15" size="15"></td>
								</tr>
								<tr>
									<td width="97" bgcolor="#2E78ED">
										<p align="center">
										<font size="2" color="white">지역</font>
									</td>
									<td width="383" bgcolor="#FFFFFF"><font size="2">
									<input type="text" name="city" mexlength="15" size="15"></font>
									</td>
								</tr>

							</table>

						</td>
					</tr>

				</table>

				                   <input type="submit" value="가입하기">

			</div>

		</form>
	</center>

</body>
</html>