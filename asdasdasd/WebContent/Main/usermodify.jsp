<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
<script type="text/javascript">
function check(){
	 if(f.pw.value==""){
		 alert("비밀번호 입력하세요");
		 f.pw.focus();
		 return false;
	 }else if(f.name.value==""){
		 alert("이름을 입력하세요");
		 f.name.focus();
		 return false;
	 }else if(f.phone.value==""){
		 alert("연락처를 입력하세요");
		 f.phone.focus();
		 return false;
	 }else if(f.age.value==""){
		 alert("나이를 입력하세요");
		 f.age.focus();
		 return false;
	 }else if(f.city.value==""){
		 alert("지역을 입력하세요");
		 f.city.focus();
		 return false;
	 }else{
		 return true;
	 }
	 
}
</script>
</head>
<body>
<b>회원정보 수정</b><br>
<form action="usermodify.do" method="post" name="f" onSubmit="return check()">
	<div align="center">
		<table border="0" cellspacing="0" bgcolor="#0C0133" cellpadding="0" width="10">
		  
		     <table width="500" cellpadding="3" cellspacing="1" border="1">
		   
	         <tr>
				<td width="150" bgcolor="#2E78ED">
						<p align="center">
						<font size="2" color="white">아이디</font></td>
				<td width="383" bgcolor="#FFFFFF">
				<input name="id" value="${idList.id}"></td>
			</tr>

			<tr>
				<td width="150" bgcolor="#2E78ED">
						<p align="center">
						<font size="2" color="white">비밀번호</font></td>
				<td width="383" bgcolor="#FFFFFF">
				<input type="text" name="pw" value="${idList.pw}"></td>
			</tr>

			<tr>
				<td width="150" bgcolor="#2E78ED">
						<p align="center">
						<font size="2" color="white">이름</font></td>
				<td width="383" bgcolor="#FFFFFF">
				<input type="text" name="name" value="${idList.name}"></td>
			</tr>

			<tr>
				 <td width="150" bgcolor="#2E78ED">
						<p align="center">
						<font size="2" color="white">연락처</font></td>
				<td width="383" bgcolor="#FFFFFF">
				<input type="text" name="phone" value="${idList.phone}"></td>
			</tr>

			<tr>
				<td width="150" bgcolor="#2E78ED">
						<p align="center">
						<font size="2" color="white">나이</font></td>
				<td width="383" bgcolor="#FFFFFF">
				<input type="text" name="age" value="${idList.age}"></td>
			</tr>

			<tr>
				<td width="150" bgcolor="#2E78ED">
						<p align="center">
						<font size="2" color="white">지역</font></td>
				<td width="383" bgcolor="#FFFFFF">
				<input type="text" name="city" value="${idList.city}"></td>
			</tr>


            
            <tr>
				    <td colspan="2"><input type="submit" value="수정">&nbsp;&nbsp;
					<a href="userlist.do">목록보기</a></td>
			</tr>
			
        
            </table>
            
       
	    </table>
		
	   </div>
	</form>





</body>
</html>