<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="Submit" method ="post">
<div class="form-group">
<label>Enter Job Title</label>
<input type = "text" name="title" id="title"> 
</div>
<div class="form-group">
<label>Enter Company Name</label>
<input type = "text" name="name" id="name"> 
</div>
<div class="form-group">
<label>Enter Duration </label>
<input type = "text" name="duration" id="duration"> 
</div>
<div class="form-group">
<label>Enter Duty1 Description </label>
<input type = "text" name="duty1" id="duty1"> 
</div>
<div class="form-group">
<label>Enter Duty2 Description  </label>
<input type = "text" name="duty2" id="duty2"> 
</div>
<input type="submit" name="first" value="Done">
<input type="submit" name="second" value="Add Another">
</form>
</body>
</html>