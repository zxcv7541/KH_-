<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    import="member.model.service.*"
    %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>ID 중복확인</title>
</head>
<body>
<script>
	function check(){
		var checkId=document.getElementById('checkId').value;
		location.href="idCheck.jsp?checkId="+checkId
	
		
	}
	window.onload=function(){
		<%
			String checkId=request.getParameter("checkId");
			if(checkId!=null)
			{
				boolean result=new MemberService().idCheck(checkId);
				
				if(result==true)
				{
		%>			document.getElementById('message').innerHTML="사용 중인 ID 입니다."
		<%		}
				else
				{
		%>			var useYesNo=window.confirm("사용한 가능한 ID입니다. 사용하시겠습니까?");
					if(useYesNo==true){
						//자신 (팝업)을 호출한 부모의 userId에 ID값을 넣어줌
						opener.document.getElementById('userId').value='<%=checkId%>';
						window.close();//해당 팝업창 종료
					}
					else
					{
						document.getElementById('checkId').value="";	
					}
		<%
				}
			}
		%>
	}
</script>

중복 확인할 ID 입력: <input type="text" id="checkId"/>
<button onclick="check();">중복체크</button><br>
<span id=message></span>


</body>
</html>