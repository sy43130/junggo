<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
<script type="text/javascript">
 function check(){ 
	 if(f.title.value==""){
		 alert("������ �Է����ּ���.");
		 f.title.focus();
		 return false;
	 }else if(f.content.value==""){
		 alert("������ �Է��� �ּ���.");
		 f.content.focus();
		 return false;
	 }else{
		 return true;
	 }
 }
</script>
</head>
<body>
   <form action="clothmodify.do" method="post" onSubmit="return check()" name="f">
  <div align="center">
   <table border="0" cellspacing="0" bgcolor="#0C0133" cellpadding="0" width="10">
	   <table width="500" cellpadding="3" cellspacing="0" border="1">
			<tr>
			    <td width="100" bgcolor="#2E78ED">
						<p align="center">
						<font size="2" color="white">�۹�ȣ</font></td>
				<td width="100" bgcolor="#FFFFFF">
				<input type="hidden" name="sqnumber" value="${contentview.sqnumber}">${contentview.sqnumber}</td>
			    
			</tr>
			
			<tr>
				<td width="100" bgcolor="#2E78ED">
						<p align="center">
						<font size="2" color="white">���̵�</font></td>
				<td width="100" bgcolor="#FFFFFF"><input type="hidden" name="id" value="${contentview.id}">${contentview.id}</td>
			</tr>

			<tr>
				<td width="100" bgcolor="#2E78ED">
						<p align="center">
						<font size="2" color="white">����</font></td>
				<td width="100" bgcolor="#FFFFFF">
			<input type="text" name="title" value="${contentview.title}" id="title" size="59"></td>
			</tr>

			<tr>
				<td width="150" bgcolor="#2E78ED">
						<p align="center">
						<font size="2" color="white">����</font></td>
			  <td width="383" height="400" bgcolor="#FFFFFF">
			  
	         <input style="height:400px; width:400px" type="text" name="content" value="${contentview.content}" id="content"></td>
			</tr>
			
		
		</table>
		<tr>
				<input type="submit" value="����"> &nbsp;&nbsp;
				<a href="clothlist.do">��Ϻ���</a>
					
			</tr>	
</table>
</div>
       </form>
</body>
</html>