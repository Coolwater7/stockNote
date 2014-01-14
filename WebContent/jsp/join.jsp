<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
<script type="text/javascript" src="/js/jquery-1.9.1.js"></script>
<script type="text/javascript">
	$(function() {
		$("#submitBtn").click(function(e) {
			e.preventDefault();
			if($("#email").val().indexOf('@') < 1) {
				alert("email을 입력해주세요.");
				return;
			}
			if($("#passwd1").val().length > 0 || $("#passwd2").val().length > 0) {
				alert("패스워드를 입력해주세요.");
				return;	
			}
			if($("#passwd1").val() != $("#passwd2").val()) {
				alert("패스워드가 일치하지 않습니다.");
				return;	
			}
			$.post("account.do", $("joinForm").serialize(), function(data) {
				alert("가입처리 되었습니다.");
				window.location.href = "login.jsp";
			});
		});
	});
</script>
</head>
<body>
<form id="joinForm">
<input type="hidden" name="action" value="join">
<ul>
	<li>
		email <input type="text" name="email">
	</li>
	<li>
		password <input type="password" name="passwd1">
	</li>
	<li>
		password(c) <input type="password" name="passwd2">
	</li>
	<li>
		<button id="submitBtn"></button>
	</li>
</ul>
</form>
</body>
</html>