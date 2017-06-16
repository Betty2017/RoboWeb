<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Robo Resume </title>
</head>
<body>
<h1>Skills with Rating</h1>
<form action="Skills" method ="post">
<div class="form-group">
<label>Person ID</label>
<input type = "text" name="personId" id="personId" value="${personID_session}" readonly> 
</div>
<div class="form-group">
<label>Enter Skill Name</label>
<input type = "text" name="skillName" id="skillName"> 
</div>
<div class="form-group">
<label>Enter Proficency</label>
<input type = "text" name="proficency" id="proficency"> 
</div>
<input type="submit" name="first" value="Display">
<input type="submit" name="second" value="Add Another Skill">
</form>
</body>
</html>