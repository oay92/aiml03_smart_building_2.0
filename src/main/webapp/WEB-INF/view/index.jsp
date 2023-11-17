<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>${webName}</title>
		
		<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-F3w7mX95PdgyTmZZMECAngseQB83DfGTowi0iMjiWaeVhAn4FJkqJByhZMI3AhiU" crossorigin="anonymous">
		<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/js/bootstrap.bundle.min.js" integrity="sha384-/bQdsTh/da6pkI1MST/rWKFNjaCP5gBSY4sEBT38Q/9RBh9AH40zEOg7Hlq2THRZ" crossorigin="anonymous"></script>
		
		<style><%@include file="/WEB-INF/css/default.css"%></style>
		
		<script><%@include file="/WEB-INF/js/index.js"%></script>			
	</head>
	<body>
		<form name="myForm" action="${root}/Index.do" method="post">
			<ul class="nav justify-content-end">
			  <li class="nav-item">
			    <a class="nav-link active" aria-current="page" href="#" onclick="submitForm('user')">User</a>
			  </li>
			  <li class="nav-item">
			    <a class="nav-link" href="#" onclick="submitForm('admin')">Admin</a>
			  </li>
			</ul>
			<br><br>
			<h1 style="text-align:center">Smart Building</h1>
			
			<input type="hidden" name="accountLevel" id="accountLevel">
		</form>		
	</body>
</html>