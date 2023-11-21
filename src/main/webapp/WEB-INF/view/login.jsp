<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>${webName}</title>
		
		<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-F3w7mX95PdgyTmZZMECAngseQB83DfGTowi0iMjiWaeVhAn4FJkqJByhZMI3AhiU" crossorigin="anonymous">
		<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/js/bootstrap.bundle.min.js" integrity="sha384-/bQdsTh/da6pkI1MST/rWKFNjaCP5gBSY4sEBT38Q/9RBh9AH40zEOg7Hlq2THRZ" crossorigin="anonymous"></script>
		
		<style><%@include file="/WEB-INF/css/default.css"%></style>
		
		<script><%@include file="/WEB-INF/js/login.js"%></script>
	</head>
	
	<body onload="document.getElementById('userID').focus()">
		<jsp:include page="${component}/header.jsp"></jsp:include>
		<br><br>
		<form name="myForm" action="${root}/Login.do?level=${level}" method="post">
			<div style="width: 40%; margin:auto">
				<div class="row">
					<div class="col"><p class="page-title">${level} Login</p></div>
				</div>
				<div class="row">
					<div class="col"><span style="text-align:center;color:red">${error}</span></div>
				</div>
				<div class="row">
					<div class="col"><label for="userID" class="form-label">User ID:</label><span style="color:red;margin-left:20px" id="error1"></span></div>
				</div>
				<div class="row">
					<input type="text" class="form-control" name="userID" id="userID" onkeypress="if (event.keyCode == 13) document.getElementById('password').focus()">
				</div>
				<div class="row">
					<div class="col"><label for="password" class="form-label">Password:</label><span style="color:red;margin-left:20px" id="error2"></span></div>
				</div>
				<div class="row">
					<input type="password" class="form-control" name="password" id="password" onkeypress="if (event.keyCode == 13) submitForm()">
				</div>	
				<br>
				<div class="row">
					<div class="col" style="text-align:right"><button type="button" class="btn btn-primary" style="width:100px" onclick="submitForm()">Login</button></div>
				</div>				
			</div>
		</form>

		<br><br>
		<jsp:include page="${component}/footer.jsp"></jsp:include>
	</body>
</html>