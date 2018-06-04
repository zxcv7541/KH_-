<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    import="member.model.vo.*"
    import="member.model.service.*"
    %>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>회원 정보 수정</title>
</head>
<body>
<%
	Member m=new Member();
	request.setCharacterEncoding("UTF-8");
	m.setMemberId(request.getParameter("userId"));
	m.setMemberPwd(request.getParameter("userPwd"));
	m.setMemberAddr(request.getParameter("userAddr"));

	int result=new MemberService().updateMember(m);
	
	if(result>0){
		m=new MemberService().selectMember(request.getParameter("userId"),request.getParameter("userPwd"));
		session.setAttribute("user",m);
		%>
		<h1>정보 변경 완료</h1>
	<%}else{%>
	
	<h1>실패</h1>
	<%} %>
	
<a href="/web1/views/member/myinfo.jsp">마이페이지로 이동</a>
<a href="/web1/views/member/memberIndex.html">로그인페이지로 이동</a>
</body>
</html>