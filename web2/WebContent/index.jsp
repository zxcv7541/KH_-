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


<c:choose>
<c:when test="${empty sessionScope.user}" >

<fieldset style="width:300px; height:100px;">
	<legend>로그인</legend>
<form action="login" method="post" style="display:inline;">
ID :<input type="text" placeholder="ID를 입력하세요" name="userId" /><br>
PW :<input type="password" placeholder="PW를 입력하세요" name="userPwd" /><br>
<input type="submit" value="로그인">
</form>
<a href="/views/member/joinus.html">회원가입</a>
<a href="">ID 찾기</a>
<a href="">PW 찾기</a>

</fieldset>
</c:when>
	
<c:otherwise>	
	<fieldset style="width:300px; height:100px;">

	${user.userId} 님 환영합니다.
	<label onclick="myInfo();" id="infoBtn">마이페이지</label>
	<form action="myInfo" method="post" style="display:none;" id="myInfo">
		<label style="color:red;">비밀번호 입력 :</label>
		<input type="password" name="userPwd" />
			<input type="submit" value="확인" />
	</form>

<a href=/logout>로그아웃</a>
<label onclick="memberDel();" id="delBtn">회원탈퇴</label>

<form action="/delete" method="post" style="display:none;" id="del">
	<label style="color:red;">비밀번호 입력 :</label>
	<input type="password" name="userPwd" />
	<input type="submit" value="확인" />
	
</form>
	
<a href="/views/file/upload.html">업로드</a>
<a href="/fileList">다운로드</a>
<a href="/views/file/upload2.html">업로드2</a>
<a href="/fileList2">다운로드2</a>
<c:choose>
<c:when test="${user.userId eq 'admin' }" >
<a href="/admin">전체회원조회</a>
</c:when>
</c:choose>


	<br>
	<a href="/notice">공지사항</a><br>

</fieldset>
</c:otherwise>
</c:choose>
<style>
	#infoBtn{
		cursor:pointer;
		text-decoration : underline;
		color:blue;
	}
		#delBtn{
		cursor:pointer;
		text-decoration : underline;
		color:blue;
	}
</style>
<script>
function myInfo(){
	document.getElementById("myInfo").style="display:inline";
}
function memberDel(){
	document.getElementById("del").style="display:inline";
}
</script>
</body>
</html>