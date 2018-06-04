<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<%int num1=Integer.parseInt(request.getParameter("firstValue"));
int num2=Integer.parseInt(request.getParameter("secondValue"));
String op=request.getParameter("choice"); 

String result ="";
switch(op){
case "+":
	result=(num1+num2)+"";break;
case "-":
	result=(num1-num2)+"";break;
case "*":
	result=(num1*num2)+"";break;
case "/":
	result=((double)num1/num2)+"";break;
	} %>
<%=num1+op+num2+"="+result %>
</body>
</html>