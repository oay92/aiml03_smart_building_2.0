<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>This is Resident information page</title>

<style>
body {
	font-family: Arial, sans-serif;
}

h2 {
	color: #333;
	text-align: center;
}

form {
	width: 50%;
	margin: 0 auto;
}

label {
	display: block;
	margin-bottom: 8px;
}

input {
	width: 100%;
	padding: 8px;
	margin-bottom: 16px;
	box-sizing: border_box;
}

input[type="submit"] {
	background-color: #4CAF50;
	color: #fff;
	cursor: pointer;
}
</style>
</head>
<body>

	<h2>User Registration</h2>

	<form action="ProcessUserRegistration" method="post">
		<label for="name">Name:</label> <input type="text" name="name"
			required="required"> <br> <br> <label for="phone">Phone#:</label>
		<input type="text" name="phone" required="required"> <br>
		<br> <label for="name">Building_num:</label> ${selection1} <br>
		<br> <label for="name">Unit_num:</label> ${selection2} <br> <br>
		<label for="name">E-mail:</label> <input type="text" name="email"
			required="required"> <br> <br> <label for="name">Primary_contact:</label>
		<input type="text" name="Primary_contact" required="required">
		<br> <br> <label for="name">License_plate:</label> <input
			type="text" name="email" required="required"> <br>

	</form>

</body>
</html>