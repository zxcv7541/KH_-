<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<c:forEach begin="0" items="${list}" var="m" varStatus="i">
	${i.count}번째 학생
	이름 : ${m.name}
	나이 : ${m.age}
	주소 : ${m.addr}
</c:forEach>
<c:forEach begin="1" end="10" var="i">
	${i}<br>
</c:forEach>







</body>
</html>