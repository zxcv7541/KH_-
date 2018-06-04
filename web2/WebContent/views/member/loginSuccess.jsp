<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    import="member.model.vo.*"
    %>
    
<%Member m=(Member)session.getAttribute("user"); %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

<script>
	window.onload=function(){
		if(opener!=null){ //자신이 팝업창 일때
			
			opener.location.reload();
			window.close();
		}
		
		
	}
</script>

<%if(m.getUserId().equals("admin")){
	%><a href="/myInfo">마이페이지</a>
<a href="/logout">로그아웃</a>
<a href="/delete">회원탈퇴</a>
<a href="/admin">전체회원조회</a>
<a href="/notice">공지사항</a>
<% }else{%>
<%=m.getUserName()%>성공
<a href="/index.jsp">메인페이지</a>
<%} %>
</body>
</html>