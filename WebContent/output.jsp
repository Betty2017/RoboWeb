<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Robo Resume</title>
</head>
<body>
<table  align="center">

	<h3>${personFN_session} ${personLN_session}</h3>
	<p>${personEM_session}</p>
	<br>
	<h4>Education</h4>
	<p>${eduCO_session}</p>
	
		
	<br>
	<h4>Experience</h4>
	<p>${jobCO_session}</p>
	
	<br>
	<h4>Skills</h4>
	<p>${skillCO_session}</p>

</table>
</body>
</html>