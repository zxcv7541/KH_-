<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    import="member.model.vo.*"
    import="java.util.*"
    %>
     <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title></title>
</head>
<body>



<table>
<tr>
	<th>1</th>
	<th>2</th>
	<th>3</th>
	<th>4</th>
	<th>5</th>
	<th>6</th>
	<th>7</th>
	<th>8</th>
	<th>9</th>
	<th>10</th>
</tr>
<c:forEach items="${memberAll}" var="m">
<tr>
	<td>${m.userId}</td>
	<td>${m.userName}</td>
	<td>${m.age}</td>
	<td>${m.email}</td>
	<td>${m.phone}</td>
	<td>${m.addr}</td>
	<td>${m.gender}</td>
	<td>${m.hobby}</td>
	<td>${m.enrolldate}</td>
	<form action="/activation" method="post">
	<td><input type="submit" value="${m.activation}">
		<input type="hidden" value="${m.activation}" name="active">
		<input type="hidden" value="${m.userId}" name="userid"></td>
		</form>
		 
</tr>
</c:forEach>
</table>

<script>
function back(){
	location.href="/index.jsp";
}
</script>
<button onclick="back();">이전 페이지로</button>
</body>
</html>