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
		
		<script>
		function submitForm()
		{        
			document.forms["myForm"].submit();				
		}		
		</script>			
	</head>
	<body>
		<jsp:include page="${component}/adminHeader.jsp"></jsp:include>
		<br><br>
		<form name="myForm" action="${root}/editTakePhoto" method="post">
			<div style="margin:auto;min-height:100vh;width:40%">
				<div class="row">
					<div class="col"><p class="page-title">User Registration</p></div>
				</div>			
			
				<div class="row default-height">
					<div class="col">Building #:<span style="margin-left:10px;color:#0000FF">${person.buildingNum}</span></div>
				</div>
			
				<div class="row default-height">
					<div class="col">Unit #:<span style="margin-left:10px;color:#0000FF">${person.unitNum}</span></div>
				</div>
				<!-- Primary Contact-->				
				<div class="form-check default-height">
					<c:if test="${person.primaryContact == 1}">
						<input class="form-check-input" type="checkbox" value="1" name="primaryContact" id="primaryContact" checked>
					</c:if>
					<c:if test="${person.primaryContact != 1}">
						<input class="form-check-input" type="checkbox" value="1" name="primaryContact" id="primaryContact">
					</c:if>					
					<label class="form-check-label" for="primaryContact"> Primary Contact</label>
				</div>				
				
				<!-- Name -->
				<div class="row">
					<div class="col"><label for="userName" class="form-label">Name:</label><span style="color:red;margin-left:20px" id="error1"></span></div>					
				</div>
				<div class="row default-height">
					<div class="col"><input type="text" class="form-control" name="userName" id="userName" value="${person.name}" onkeypress="if (event.keyCode == 13) document.getElementById('userEmail').focus()"></div>									
				</div>
			
				<!-- Email -->
				<div class="row">
					<div class="col"><label for="userEmail" class="form-label">Email:</label><span style="color:red;margin-left:20px" id="error2"></span></div>					
				</div>
				<div class="row default-height">
					<div class="col"><input type="text" class="form-control" name="userEmail" id="userEmail" value="${person.email}" onkeypress="if (event.keyCode == 13) document.getElementById('userPhone').focus()"></div>									
				</div>				

				<!-- Phone -->
				<div class="row">
					<div class="col"><label for="userPhone" class="form-label">Phone:</label><span style="color:red;margin-left:20px" id="error3"></span></div>					
				</div>
				<div class="row">
					<div class="col"><input type="text" class="form-control" name="userPhone" id="userPhone" value="${person.phone}" onkeypress="if (event.keyCode == 13) submitForm('photo', '${buildingNum}', '${unitNum}')"></div>									
				</div>
				
				<br>
				<div class="row">
					<div class="col" style="text-align:right">
						<a href="${root}/userRegisterResult?buildingNum=${person.buildingNum}&unitNum=${person.unitNum}"><button type="button" class="btn btn-primary" style="width:100px">Close</button></a>
						<button type="button" class="btn btn-primary" style="width:100px" onclick="submitForm()">Next</button>
					</div>
				</div>
			</div>	
			
			<input type="hidden" name="buildingNum" value="${person.buildingNum}">
			<input type="hidden" name="unitNum" value="${person.unitNum}">
			<input type="hidden" name="pID" value="${person.pID}">
		</form>
		
		<br><br>
		<jsp:include page="${component}/footer.jsp"></jsp:include>		
	</body>
</html>