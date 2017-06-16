<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>Education</h1>
<form action="Submit" method ="post">

<input type = "text" name="personId" id="personId" value="${personID_session}" readonly> 
<input type = "text" name="firstName" id="firstName" value="${personFN_session}" readonly> 
<input type = "text" name="lastName" id="lastName" value="${personLN_session}" readonly> 
<input type = "text" name="email" id="email" value="${personEM_session}" readonly> 
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
<input type="submit" name="third" value="Continue to the next page">
<input type="submit" name="forth" value="Add Another Edu Achivment">
</form>
</body>
</html>