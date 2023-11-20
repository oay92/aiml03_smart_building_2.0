<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>${webName}</title>
		
		<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-F3w7mX95PdgyTmZZMECAngseQB83DfGTowi0iMjiWaeVhAn4FJkqJByhZMI3AhiU" crossorigin="anonymous">
		<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/js/bootstrap.bundle.min.js" integrity="sha384-/bQdsTh/da6pkI1MST/rWKFNjaCP5gBSY4sEBT38Q/9RBh9AH40zEOg7Hlq2THRZ" crossorigin="anonymous"></script>
		
		<style><%@include file="/WEB-INF/css/default.css"%></style>
		<style><%@include file="/WEB-INF/css/account.css"%></style>
		
		<script><%@include file="/WEB-INF/js/account.js"%></script>		
	</head>
	<body>
		<jsp:include page="${component}/adminHeader.jsp"></jsp:include>
		<br><br>		
		<form name="myForm" action="${root}/Account.do" method="post">
			<div style="width:40%;margin:auto">
				<div class="row">
					<div class="col"><p class="page-title">Account Registration</p></div>
				</div>
				
				<div class="row">
					<div class="col">
						<label for="userID" class="form-label" style="margin-right:10px">Level:</label>

						<div class="form-check form-check-inline">
							<input class="form-check-input" type="radio" name="level" id="inlineRadio1" value="admin" onchange="document.getElementById('userID').focus()">
						  	<label class="form-check-label" for="inlineRadio1">Admin</label>
						</div>
						<div class="form-check form-check-inline">
						  	<input class="form-check-input" type="radio" name="level" id="inlineRadio2" value="user" onchange="document.getElementById('userID').focus()">
						  	<label class="form-check-label" for="inlineRadio2">User</label>
						</div>	
						<span style="color:red;margin-left:20px" id="error1"></span>					
					</div>				  
				</div>				
				
				<br>
				
				<div class="row">
					<div class="col"><label for="userID" class="form-label">User ID:</label><span style="color:red;margin-left:20px" id="error2"></span></div>					
				</div>
				<div class="row">
					<input type="text" class="form-control" name="userID" id="userID" onkeypress="if (event.keyCode == 13) document.getElementById('password').focus()">				
				</div>
				<div class="row">
					<div class="col"><label for="password" class="form-label">Password:</label><span style="color:red;margin-left:20px" id="error3"></span></div>					
				</div>
				<div class="row">
					<input type="text" class="form-control" name="password" id="password" onkeypress="if (event.keyCode == 13) submitForm()">				
				</div>	
				<br>
				<div class="row">
					<div class="col" style="text-align:right"><button type="button" class="btn btn-primary" style="width:100px" onclick="submitForm()">Submit</button></div>
				</div>											
			</div>	
			
			<!-- Popup 1 -->
			<div class="popup1" id="popup1" style="display:${display1};padding:0px">
				<div class="row" style="margin:0px;background-color:#202432">
					<div class="col" style="text-align:right"><a href="#" id="popup-link" onclick="hide('popup1')">X</a></div>
				</div>
				<div class="row" style="margin:0px;background-color:#202432;height:42px">
					<div class="col" style="margin:0px;padding:0px;text-align:center;font-size:32px;color:white">Error</div>
				</div>			
				<div class="row">
					<div class="col" style="padding:30px">Account already exists</div>
				</div>			
			</div>	
		
			<!-- Popup 2 -->
			<div class="popup2" id="popup2" style="display:${display2};padding:0px">
				<div class="row" style="margin:0px;background-color:#202432">
					<div class="col" style="text-align:right"><a href="#" id="popup-link" onclick="hide('popup2')">X</a></div>
				</div>
				<div class="row" style="margin:0px;background-color:#202432;height:42px">
					<div class="col" style="margin:0px;padding:0px;text-align:center;font-size:32px;color:white">Congratulations!</div>
				</div>			
				<div class="row">
					<div class="col" style="padding:30px">Your account has been successfully created.</div>
				</div>			
			</div>				
		</form>
		

	</body>
</html>