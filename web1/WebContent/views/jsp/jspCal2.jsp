<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

<%
	int num1=Integer.parseInt(request.getParameter("val1"));
	int num2=Integer.parseInt(request.getParameter("val2"));
	String op=request.getParameter("yun");
	int result=0;

%>

<%if(op.equals("+")){ 
	result=num1+num2;
}else if(op.equals("-")){
	result=num1-num2;
}else if(op.equals("*")){
	result=num1*num2;
}else if(op.equals("/")){
	result=num1/num2;
}%>
 	입력한 첫번째 값 :<%=num1 %><br>
	입력한 연산자 :<%=op %><br>
	입력한 두번째 값 :<%=num2 %><br>
	결과<br>
	<%=num1+op+num2+"="+result %>

</body>
</html>