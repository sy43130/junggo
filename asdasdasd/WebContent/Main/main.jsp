<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
<style type="text/css">

#whole{
   margin-right:100px;
   margin-left:100px;

}
#a{
background-color:gray;
margin-right:50px;
margin-top:50px;
text-align:right;
height:100px;
}
#b{
  background-color:red;
  text-align:center;
}

#c{
width:200px;
height:400px;
background-color:yellow;
float:left;
margin:5px;

   text-align:right;

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
                �߰���
       </div >
     
       
       <%
       if(session.getAttribute("id")!=null){
    	   
       %>
       <a href="userlogout.do">�α׾ƿ�</a>
       <a href="userlist.do">ȸ������</a>
       <%
       }else{
    	 %>
         <a href="./login.jsp">�α��� </a>&nbsp;
         <a href="./create.jsp">ȸ������</a>
         <%
    	   
         }%>
     </div>
     
     
     <div id="c">
          
          <br>
          <a href="clothlist.do"><span>�Ƿ�</span></a><br><br>
          <a href="../Content/book.jsp"><span>����</span></a><br><br>
          <a href="../Content/Elo.jsp"><span>������ǰ</span></a><br><br>
         
     
     </div>
     <div id="d">
        
     
     </div>
     
     </div>
     
     
      

</body>
</html>