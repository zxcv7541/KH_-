<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    import="member.model.vo.*"
    %>
     <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
   
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<center>
<h1>회원 가입 정보</h1>
<form action="/update" method="post">
아이디 : <input type="text" value="${info.userId }" readonly name="userId"><br>
패스워드 : <input type="text" value="${info.userPwd }" name="pwd" ><br>
이름 : <input type="text" value="${info.userName }" ><br>
나이 : <input type="text" value="${info.age }"><br>
이메일 : <input type="text" value="${info.email }" name="email"><br>
휴대폰 : <input type="text" value="${info.phone }" name="phone"><br>
주소 : <input type="text" value="${info.addr }" name="addr"><br>


<c:set var="gender" value="${info.gender}" />
<c:choose>
	<c:when test="${gender eq 'M'}">
	성별  : <input type="radio" value="남" checked="checked">남<input type="radio" disabled value="여">여<br>
	</c:when>
	<c:when test="${gender eq 'F'}">
	성별 : <input type="radio" disabled value="남" >남<input type="radio" value="여" checked="checked">여<br>
	</c:when>
</c:choose>

취미 : <input type="text" value="${member.hobby }"><br>
<input type="submit" value="수정하기">
<input type="button" value="취소" onclick="back();"><br>

<a href="/index.jsp">메인페이지로 이동하기</a>
</form>
</center>
<script>
function back(){
	location.href="/index.jsp";
}

</script>

</body>
</html>