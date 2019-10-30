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
		 alert("제목을 입력해주세요.");
		 f.title.focus();
		 return false;
	 }else if(f.content.value==""){
		 alert("내용을 입력해 주세요.");
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
						<font size="2" color="white">글번호</font></td>
				<td width="100" bgcolor="#FFFFFF">
				<input type="hidden" name="sqnumber" value="${contentview.sqnumber}">${contentview.sqnumber}</td>
			    
			</tr>
			
			<tr>
				<td width="100" bgcolor="#2E78ED">
						<p align="center">
						<font size="2" color="white">아이디</font></td>
				<td width="100" bgcolor="#FFFFFF"><input type="hidden" name="id" value="${contentview.id}">${contentview.id}</td>
			</tr>

			<tr>
				<td width="100" bgcolor="#2E78ED">
						<p align="center">
						<font size="2" color="white">제목</font></td>
				<td width="100" bgcolor="#FFFFFF">
			<input type="text" name="title" value="${contentview.title}" id="title" size="59"></td>
			</tr>

			<tr>
				<td width="150" bgcolor="#2E78ED">
						<p align="center">
						<font size="2" color="white">내용</font></td>
			  <td width="383" height="400" bgcolor="#FFFFFF">
			  
	         <input style="height:400px; width:400px" type="text" name="content" value="${contentview.content}" id="content"></td>
			</tr>
			
		
		</table>
		<tr>
				<input type="submit" value="수정"> &nbsp;&nbsp;
				<a href="clothlist.do">목록보기</a>
					
			</tr>	
</table>
</div>
       </form>
</body>
</html>