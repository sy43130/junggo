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
		// ��� inpt 
		for (var i = 0; i < 6; i++) {
			if (input[i].value === "") { // id ĭ 
				alert(i + "��° ĭ�� ä��"); // ä�� 
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

<body style="font-family: ����;">

	<center>
		<b>ȸ������</b><br>
		
		<form action="join.do" method="post" onSubmit="return check()">
		
			<div align="center">
				<table border="0" cellspacing="0" bgcolor="#0C0133" cellpadding="0" width="10">
					<tr>
						<td>
							<table border="0" cellpadding="4" cellspacing="1" width="400">
								<tr>
									<td width="97" bgcolor="#2E78ED">
										<p align="center">
											<font size="2" color="white">���̵�</font>
									</td>
									<td width="383" bgcolor="#FFFFFF"><input type="text"
										name="id" maxlength="15" size="15"></td>
								</tr>
								<tr>
									<td width="97" bgcolor="#2E78ED">
										<p align="center">
											<font size="2" color="white">�н�����</font>
									</td>
									<td width="383" bgcolor="#FFFFFF">
									<input type="text" name="pw" maxlength="15" size="15"></td>
								</tr>
								<tr>
									<td width="97" bgcolor="#2E78ED">
										<p align="center">
										<font size="2" color="white">�̸�</font>
									</td>
									<td width="383" bgcolor="#FFFFFF">
									<input type="text" name="name" maxlength="15" size="15"></td>
								</tr>
								<tr>
									<td width="97" bgcolor="#2E78ED">
										<p align="center">
										<font size="2" color="white">����ó</font>
									</td>
									<td width="383" bgcolor="#FFFFFF"><font size="2"> 
									<input type="text" name="phone" mexlength="15" size="15"></td>
								</tr>
								<tr>
									<td width="97" bgcolor="#2E78ED">
										<p align="center">
										<font size="2" color="white">����</font>
									</td>
									<td width="383" bgcolor="#FFFFFF"><font size="2"> 
									<input type="text" name="age" mexlength="15" size="15"></td>
								</tr>
								<tr>
									<td width="97" bgcolor="#2E78ED">
										<p align="center">
										<font size="2" color="white">����</font>
									</td>
									<td width="383" bgcolor="#FFFFFF"><font size="2">
									<input type="text" name="city" mexlength="15" size="15"></font>
									</td>
								</tr>

							</table>

						</td>
					</tr>

				</table>

				                   <input type="submit" value="�����ϱ�">

			</div>

		</form>
	</center>

</body>
</html>