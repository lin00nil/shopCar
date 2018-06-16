<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<form action=register method=post >
		<h3>注册</h3>
		姓名<input type=text name=userName /><br>
		密码<input type='password' name=pwd /><br>
		确认密码<input type='password' name=comfirmPwd /><br>
		地址<input type='text' name=address /><br>
		电话<input type='text' name=phone /><br>
		<input type=submit value=提交/>
	</form>
</body>
</html>