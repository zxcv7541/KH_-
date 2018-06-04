<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="member.model.service.*" import="member.model.vo.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
	session=request.getSession(false);
	Member m=(Member)session.getAttribute("user");
	if(m!=null){
		%>
		<script>
		function back()
		{
			window.location.replace(document.referrer);
		}
		
		</script>
		
		<center>
		나의 정보<br>
		<form action="memberUpdate.jsp" method="post">
		ID :<input type="text" name="userId" readonly value=<%=m.getMemberId()%> /><br>
		PW :<input type="password" name="userPwd"  value=<%=m.getMemberPwd()%> /><br>
		PW_re : <input type="password" name="userPwd_re" value=<%=m.getMemberPwd()%> /><br>
		Name : <input type="text" name="userName" readonly value=<%=m.getMemberName()%> /> <br>
		Age : <input type="text" name="userAge" readonly value=<%=m.getMemberAge()%> /><br>
		Addr : <input type="text" name="userAddr" value=<%=m.getMemberAddr()%> /> <br>
		<input type="submit" value="정보수정">
		
		<button onclick="back();">돌아가기</button>
		</form>
		</center>
<%}else{%>
 	로그인후이용
 	<a href="web1/views/member/memberIndex.html">로그인페이지로</a>
 	<%} %>


</body>
</html>
