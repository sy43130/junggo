<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
	
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
<style type="text/css">
input{
    border:none;
}

textarea{
  border:none;
}


</style>

</head>
<body>
<form action="write.do" method="post" enctype="multipart/form-data" >
	
   <div align="center">
   <b>글올리기</b><br>
	        <table border="0" cellspacing="0" bgcolor="#0C0133" cellpadding="0" width="10">
		           <table width="500" cellpadding="3" cellspacing="0" border="1">
		    <tr>
				<td width="100" bgcolor="#2E78ED"><font color="white">아이디</font></td>
				<p align="center">
				<td width="383" bgcolor="#FFFFFF"><%=session.getAttribute("id") %>
				<input type="hidden" name="id" value="<%=session.getAttribute("id") %>">
				</td>
			</tr>
		
			<tr>
				<td width="50" bgcolor="#2E78ED">
				<p align="center">
				<font size="2" color="white">제목</font></td>
				<td width="100" bgcolor="#FFFFFF"><input type="text" name="title" size="60" placeholder="제목을 입력하세요"></td>
			</tr>
			
			<tr>
				<td width="383" bgcolor="#2E78ED">
				<p align="center">
				<font size="2" color="white">내용</font></td>
				<td width="383" height="500" bgcolor="#FFFFFF"><textarea name="content" rows="33" cols="55" placeholder="연락처필수"></textarea></td>
			</tr>
			
			<tr>
			
			<tr>
				<td width="100" bgcolor="#2E78ED">
				<p align="center">
				<font size="2" color="white">사진</font></td>
				<td width="45" height="45" bgcolor="#FFFFFF"><input type="file" name="photo"><br></td>
			</tr>
			
			
		
		</table>
		       
		        <input type="submit" value="올리기">
		        
		</table>
    </div>
		
	</form>
</body>
</html>