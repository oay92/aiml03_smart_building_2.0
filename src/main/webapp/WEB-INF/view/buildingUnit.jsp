<%@ page language="java" contentType="text/html; charset=BIG5"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Choose the building unit you living here</title>
</head>
<body>

	<form action="${root }/ToUserRegister" method="post">
		<label for="dropdown">Choose the building you living here:</label> <select name="selectedOption1"
			id="dropdown">
			<option value="A">Building A</option>
			<option value="B">Building B</option>
			<option value="C">Building C</option>
		</select> 
		
		<label for="dropdown">Choose the unit number you living here:</label> <select name="selectedOption2"
			id="dropdown">
			<option value="1">Unit 1</option>
			<option value="2">Unit 2</option>
			<option value="3">Unit 3</option>
		</select> <br> <input type="submit" value="submit">
	</form>

</body>
</html>