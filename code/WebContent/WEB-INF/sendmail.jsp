<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Send a mail</title>
</head>
<body>
<h1><a>Send a Mail</a></h1>
		<form  method="post" action="">
					<div class="form_description">
			<p>fill this form to send a message</p>
		</div>						
			<ul >
			
		
	
		<li id="li_2" >
		<label class="description" for="element_2">To </label>
		<div>
			<input id="element_2" name="to" class="element text medium" type="text" maxlength="255" value=""/> 
		</div> 
		</li>		<li id="li_3" >
		<label class="description" for="element_3">Subject</label>
		<div>
			<input id="element_3" name="subject" class="element text medium" type="text" maxlength="255" value=""/> 
		</div> 
		</li>		<li id="li_4" >
		<label class="description" for="element_4">Message </label>
		<div>
			<textarea id="element_4" name="message" class="element textarea medium"></textarea> 
		</div> 
		</li>
			
					<li class="buttons">
			    <input type="hidden" name="form_id" value="15884" />
			    
				<input id="saveForm" class="button_text" type="submit" name="submit" value="Submit" />
		</li>
			</ul>
		</form>	
		<br>
		<a href="Menu"> Go back to menu</a>
</body>
</html>