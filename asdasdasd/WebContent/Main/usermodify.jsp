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
		 alert("��й�ȣ �Է��ϼ���");
		 f.pw.focus();
		 return false;
	 }else if(f.name.value==""){
		 alert("�̸��� �Է��ϼ���");
		 f.name.focus();
		 return false;
	 }else if(f.phone.value==""){
		 alert("����ó�� �Է��ϼ���");
		 f.phone.focus();
		 return false;
	 }else if(f.age.value==""){
		 alert("���̸� �Է��ϼ���");
		 f.age.focus();
		 return false;
	 }else if(f.city.value==""){
		 alert("������ �Է��ϼ���");
		 f.city.focus();
		 return false;
	 }else{
		 return true;
	 }
	 
}
</script>
</head>
<body>
<b>ȸ������ ����</b><br>
<form action="usermodify.do" method="post" name="f" onSubmit="return check()">
	<div align="center">
		<table border="0" cellspacing="0" bgcolor="#0C0133" cellpadding="0" width="10">
		  
		     <table width="500" cellpadding="3" cellspacing="1" border="1">
		   
	         <tr>
				<td width="150" bgcolor="#2E78ED">
						<p align="center">
						<font size="2" color="white">���̵�</font></td>
				<td width="383" bgcolor="#FFFFFF">
				<input name="id" value="${idList.id}"></td>
			</tr>

			<tr>
				<td width="150" bgcolor="#2E78ED">
						<p align="center">
						<font size="2" color="white">��й�ȣ</font></td>
				<td width="383" bgcolor="#FFFFFF">
				<input type="text" name="pw" value="${idList.pw}"></td>
			</tr>

			<tr>
				<td width="150" bgcolor="#2E78ED">
						<p align="center">
						<font size="2" color="white">�̸�</font></td>
				<td width="383" bgcolor="#FFFFFF">
				<input type="text" name="name" value="${idList.name}"></td>
			</tr>

			<tr>
				 <td width="150" bgcolor="#2E78ED">
						<p align="center">
						<font size="2" color="white">����ó</font></td>
				<td width="383" bgcolor="#FFFFFF">
				<input type="text" name="phone" value="${idList.phone}"></td>
			</tr>

			<tr>
				<td width="150" bgcolor="#2E78ED">
						<p align="center">
						<font size="2" color="white">����</font></td>
				<td width="383" bgcolor="#FFFFFF">
				<input type="text" name="age" value="${idList.age}"></td>
			</tr>

			<tr>
				<td width="150" bgcolor="#2E78ED">
						<p align="center">
						<font size="2" color="white">����</font></td>
				<td width="383" bgcolor="#FFFFFF">
				<input type="text" name="city" value="${idList.city}"></td>
			</tr>


            
            <tr>
				    <td colspan="2"><input type="submit" value="����">&nbsp;&nbsp;
					<a href="userlist.do">��Ϻ���</a></td>
			</tr>
			
        
            </table>
            
       
	    </table>
		
	   </div>
	</form>





</body>
</html>