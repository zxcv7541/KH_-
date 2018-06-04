<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    import ="member.model.vo.*"
    import ="member.model.service.*"
    %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
	String inputPass=request.getParameter("userPwd");
	String sessionPass=((Member)session.getAttribute("user")).getMemberPwd();
	String id=((Member)session.getAttribute("user")).getMemberId();
	if(inputPass.equals(sessionPass))
	{
		int result=new MemberService().delete(id);
		if(result>0)
		{
			out.println("<H1>탈퇴 정상 처리 되었습니다.</H1>");
		}
		else
		{
			out.println("<H1>탈퇴 실패 처리 되었습니다.</H1>");
		}
	}
	else{
		out.println("<H1>비밀번호가 맞이 않습니다,</H1>");
	}
%>






</body>
</html>