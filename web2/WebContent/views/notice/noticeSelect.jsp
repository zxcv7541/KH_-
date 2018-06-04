<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    import="notice.model.vo.*"
    import="member.model.vo.*"
    import="java.util.*" 
     %>
   
    <%Notice n=(Notice)request.getAttribute("notice"); %>
    <%Member m=(Member)session.getAttribute("user"); %>
    <%ArrayList<NoticeComment> list=(ArrayList<NoticeComment>)request.getAttribute("comment"); %>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>공지사항 내용</title>
</head>
<body>

글번호 :<%=n.getNoticeNo() %><br>
글쓴이:<%=n.getUserId() %><br>
작성일:<%=n.getRegDate() %><br>
글제목:<%=n.getSubject() %><br>
<textarea rows="20" cols="100" readonly style="resize:none;"><%=n.getContents()%></textarea>
<br>
<script>
	function back(){
		location.href="/notice";
	}
</script>
<%if(m!=null && m.getUserId().equals("admin")){ %>

<button onclick="back()">목록</button>
<form action="noticeUpdateReady" style="display:inline;">
<input type="hidden" name="noticeNo" value=<%=n.getNoticeNo()%> >
<input type="submit" value="수정">

</form>
<form action="/noticeDelete" style="display:inline;">
<input type="hidden" name="noticeNo" value=<%=n.getNoticeNo()%> >
<input type="submit" value="삭제">

</form>

<form action="/views/notice/noticeWriteReady.jsp" style="display:inline;">
<input type="submit" value="글쓰기">

</form>
<%}else{%>
<button onclick="back()">목록</button>
<%} %>

<h1>댓글</h1>

<form action="replyWrite">
<%if(((Member)session.getAttribute("user"))==null){%>
<textarea rows="5" cols="100" name="comment" readonly placeholder="로그인한 사용자만 이용가능" style="resize:none;" onclick="login();"></textarea>
<%}else{%>
<textarea rows="5" cols="100" name="comment" placeholder="댓글을 작성하세요" style="resize:none;"></textarea>
<input type="hidden" name="noticeNo" value=<%=n.getNoticeNo()%> >
<input type="hidden" name="userId" value=<%=m.getUserId() %> >
<br>
<input type="submit" value="댓글작성" />
<%} %>

</form>
<script>
	function conf(){
		var ch=confirm("삭제하시겠습니가?");
		
		if(ch==true){
			return true;
		}else{
			return false;
		}
	}

	function login(){
		alert("로그인을 먼저 진행해주세요");
		window.open("/views/member/login_popup.html","_blank","width=400px,height=200px");
	}
	function update(id){

	document.getElementById("form"+id).style.display="inline";
	document.getElementById("btn"+id).style.display="none";
	document.getElementById(id).style.display="none";
	
	}
	function re(id){
		document.getElementById("form"+id).style.display="none";
		document.getElementById("btn"+id).style.display="inline";
		document.getElementById(id).style.display="inline";
	}
</script>

<%for(NoticeComment nc : list){%>
	<br>
	작성자 : <%=nc.getUserId()%> / 작성일 <%=nc.getRegDate() %><br>
	<label id="<%=nc.getCommentNo() %>"><%=nc.getContent() %></label>
	<%if(m!=null && nc.getUserId().equals(m.getUserId())) {%>
		
		
		<form action="/updateComment" style="display:none" id="form<%=nc.getCommentNo()%>">
		<input type="text" name="content"  value="<%=nc.getContent() %>" >
		<input type="hidden" name="Comment" value="<%=nc.getCommentNo() %>" >
		<input type="hidden" name="noticeNo" value="<%=n.getNoticeNo() %>" >
		<input type="submit" value="수정">
		<button id=re"<%=nc.getCommentNo()%>" onclick="re(<%=nc.getCommentNo()%>)" >취소</button>
		</form>

		<button id="btn<%=nc.getCommentNo()%>" onclick="update(<%=nc.getCommentNo()%>)">수정</button>
		<form  action="/deleteComment" style="display:inline" onsubmit="return conf()">
		<input type="submit" value="삭제" >
		<input type="hidden" name="commentNo" value=<%=nc.getCommentNo()%> >
		<input type="hidden" name="noticeNo" value="<%=n.getNoticeNo() %>" >
		</form>
		<br>
	<%}else{ %>
	
	<%} %>
	
<%} %>




</body>
</html>