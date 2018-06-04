<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    import="member.model.vo.*"
    import="member.model.service.*"
    %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>


<%
	request.setCharacterEncoding("UTF-8");
	Member m=new Member();


	m.setMemberId(request.getParameter("userId"));
	m.setMemberPwd(request.getParameter("userPwd"));
	m.setMemberName(request.getParameter("userName"));
	m.setMemberAddr(request.getParameter("userAddr"));
	m.setMemberAge(Integer.parseInt(request.getParameter("userAge")));
	
	int result=new MemberService().insert(m);
	
	if(result>0){
	%><h1>회원가입 성공</h1>
<% 	}else{ %>
		<h1>가입 실패</h1>
<%
}
	

%>
<a href="/web1/views/member/memberIndex.html">로그인 페이지로 이동</a>


</body>
</html>