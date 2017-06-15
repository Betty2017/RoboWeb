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
<label>Enter Degree Name</label>
<input type = "text" name="degree" id="degree"> 
</div>
<div class="form-group">
<label>Enter School Name</label>
<input type = "text" name="school" id="school"> 
</div>
<div class="form-group">
<label>Enter the Year </label>
<input type = "text" name="year" id="year"> 
</div>
<input type="submit" name="first" value="Done">
<input type="submit" name="second" value="Add Another">
</form>
</body>
</html>