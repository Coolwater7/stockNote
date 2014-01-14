<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<meta name="viewport" content="width=device-width,initial-scale=1.0,minimum-scale=1.0,maximum-scale=1.0">
<title>Insert title here</title>
<script type="text/javascript" src="/js/jquery-1.9.1.js"></script>
<script type="text/javascript">
	$(function() {
		$("#loginBtn").click(function(e){
			e.preventDefault();
			//form check
			if($("#email").val().indexOf('@') < 0) {
				alert("email을 정확히 넣어주세요.");
				return;
			}
			if($("passwd").val().length < 6) {
				alert("패스워드를 정확히 넣어주세요.");
				return;
			}
			//sign in request
			$("#loginForm").submit();
		});	
	});
</script>
</head>
<body>
<div id="content">
	<form action="login.do" id="loginForm">
		<ul>
			<li>
				ID<input type="text" name="email" id="email"/>
			</li>
			<li>
				Password<input type="password" name="passwd" id="passwd"/>
			</li>
			<li>
				<button id="loginBtn" value="login"></button>
			</li>
			<li>
				<a href="join.jsp">회원가입</a>
			</li>
		</ul>
	</form>
</div>
</body>
</html>