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
		<style><%@include file="/WEB-INF/css/changePassword.css"%></style>

		<script><%@include file="/WEB-INF/js/changePassword.js"%></script>			
	</head>
	<body onload="document.getElementById('password1').focus()">
		<br><br>
		<form name="myForm" action="${root}/ChangePassword.do" method="post">
			<div style="width:40%;margin:auto">			
				<div class="row">
					<div class="col"><p class="page-title">Change Password</p></div>
				</div>
				
				<div class="row">
					<div class="col"><label for="password1" class="form-label">Create New Password:</label><span style="color:red;margin-left:20px" id="error1"></span></div>					
				</div>
				<div class="row">
					<input type="password" class="form-control" name="password1" id="password1" onkeypress="if (event.keyCode == 13) document.getElementById('password2').focus()">				
				</div>
				<div class="row">
					<div class="col"><label for="password2" class="form-label">Confirm New Password:</label><span style="color:red;margin-left:20px" id="error2"></span></div>					
				</div>
				<div class="row">
					<input type="password" class="form-control" name="password2" id="password2" onkeypress="if (event.keyCode == 13) submitForm()">				
				</div>	
				<br>
				<div class="row">
					<div class="col" style="text-align:right"><button type="button" class="btn btn-primary" style="width:100px" onclick="submitForm()">Submit</button></div>
				</div>								
			</div>	
			
			<!-- Popup1 -->
			<div class="popup1" id="popup1" style="display:${display};padding:0px">
				<div class="row" style="margin:0px;background-color:#202432">
					<div class="col" style="text-align:right"><a href="#" id="popup-link" onclick="hide('popup1')">X</a></div>
				</div>
				<div class="row" style="margin:0px;background-color:#202432;height:42px">
					<div class="col" style="margin:0px;padding:0px;text-align:center;font-size:32px;color:white">Password Updated!</div>
				</div>			
				<div class="row">
					<div class="col" style="padding:30px">Your password has been changed successfully.<br>Use your new password to login.</div>
				</div>			
			</div>			
		</form>

		<br><br>
		<jsp:include page="${component}/footer.jsp"></jsp:include>
	</body>
</html>