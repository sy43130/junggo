<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
<style type="text/css">

#whole{
   margin-right:200px;
   margin-left:220px;

}
#a{
background-color:white;
margin-right:50px;
margin-top:50px;
text-align:right;
height:100px;
}

#b{
  background-color:white;
  text-align:center;
}

#c{
width:200px;
height:400px;
background-color:white;
float:left;
margin:5px;
text-align:right;

}
#c a{
  text-decoration:none;
  background-color:#333333;
  color:white;
  padding:3px 8px;
  

}

#d{
  margin:5px;
  float:left;
  width:700px;
  height:400px;

}
#a a{
  text-decoration:none;
  background-color:#333333;
  color:white;
  padding:3px 8px;


}
</style>
</head>
<body>
   <div id="whole">
   
     <div id="a">
        <div id="b">
              
       </div >
     
       
       <%
       if(session.getAttribute("id")!=null){
    	   
       %>
       <a href="userlogout.do">로그아웃</a>
       <a href="userlist.do">회원정보</a>
       <%
       }else{
    	 %>
         <a href="./login.jsp">로그인 </a>&nbsp;
         <a href="./create.jsp">회원가입</a>
         <%
    	   
         }%>
     </div>
     
     
     <div id="c">
          
          <br>
          <a href="clothlist.do"><span>의류</span></a><br><br>
          <a href="../Content/book.jsp"><span>도서</span></a><br><br>
          <a href="../Content/Elo.jsp"><span>전자제품</span></a><br><br>
         
     
     </div>
     <div id="d">
         <div style="width: 100%; text-align: center"  >

         <img src="img/main1.jpg" style="width: 100%; max-width: 900px; vertical-align: middle">

       </div>

     </div>
     
     </div>
     
     
      

</body>
</html>