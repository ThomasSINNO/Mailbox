<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form  method="post" action="">
		<label class="description" for="element_1">Login </label>
		<div>
			<input id="element_1" name="login" class="element text medium" type="text" maxlength="255" value=""/> 
		</div> 
		<br>
		<label class="description" for="element_2">Password </label>
		<div>
			<input id="element_2" name="password" class="element text medium" type="text" maxlength="255" value=""/> 
		</div> 
		<br>
		<input id="saveForm" class="button_text" type="submit" name="submit" value="Submit" />
		<br>
	</form>
</body>
</html>