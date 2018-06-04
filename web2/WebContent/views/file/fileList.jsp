<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    import="file.model.vo.*"
    import="java.util.*"
    %>
    <%ArrayList<DataFile> list=(ArrayList<DataFile>)request.getAttribute("fileList"); %>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<center>
<h1>나의 파일 목록</h1>
<table border="1px">
	<tr>
		<th>파일이름</th>
		<th>파일사이즈</th>
		<th>업로더</th>
		<th>업로드시간</th>
		<th>다운로드</th>
		<th>삭제</th>
	</tr>
<%for(DataFile df : list){ %>
	<tr>
		<td><%=df.getFileName() %></td>
		<td><%=df.getFileSize() %></td>
		<td><%=df.getFileUser() %></td>
		<td><%=df.getUploadTime() %></td>
		
		<td>
		<form action="/fileDown">
		<input type="submit" value="다운로드">
		<input type="hidden" name="fileName" value="<%=df.getFileName()%>">
		<input type="hidden" name="uploadTime" value="<%=df.getUploadTime()%>">
		</form> 
		</td>
		<td><form action="/fileRemove"><input type="submit" value="파일삭제"></form></td>
		
	</tr>
	
<%} %>

</table>
<a href="/index.jsp">메인 페이지로 이동</a>
</center>
</body>
</html>