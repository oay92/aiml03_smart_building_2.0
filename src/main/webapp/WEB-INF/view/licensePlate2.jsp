<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8" />
		<title>${webName}</title>
		
		<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.2/css/all.min.css">
		<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-F3w7mX95PdgyTmZZMECAngseQB83DfGTowi0iMjiWaeVhAn4FJkqJByhZMI3AhiU" crossorigin="anonymous">
		<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/js/bootstrap.bundle.min.js" integrity="sha384-/bQdsTh/da6pkI1MST/rWKFNjaCP5gBSY4sEBT38Q/9RBh9AH40zEOg7Hlq2THRZ" crossorigin="anonymous"></script>
		
		<style><%@include file="/WEB-INF/css/default.css"%></style>
		<style><%@include file="/WEB-INF/css/licensePlate.css"%></style>
		
		<script>
		function deleteClick(id)
		{
			document.getElementById('myAction').value = 'delete'
			document.getElementById('nID').value = id	
			
			document.forms["myForm"].submit();	
		}
		
		function submitClick(id)
		{
			resetErrorMessage()
			
			var number_plate = document.getElementById('numberPlate').value
			
			var error = false
			if (number_plate == "")
			{
				document.getElementById('error1').innerHTML = "this field is required"	
				error = true
				return false
			}
			
			if (!error)
			{
				hide(id)
				document.getElementById('myAction').value = 'add'					
				document.forms["myForm"].submit();	
			}
		}
		
		function resetErrorMessage()
		{
			document.getElementById('error1').innerHTML = ""	
		}
		
		function addClick(id)
		{
			document.getElementById(id).style.display ="block"
		}
		
		function hide(id)
		{
			document.getElementById(id).style.display ="none"
		}		
		</script>
	</head>
	<body>
		<jsp:include page="${component}/adminHeader.jsp" />
		<br><br>
		<form name="myForm" action="${root}/NumberPlate.do" method="post">			
			<div class="container" style="margin:auto; width:40%">		
				<table class="table table-striped">
					<thead>
						<tr>
							<th scope="col">#</th>
							<th scope="col">&nbsp;</th>
							<th scope="col">License Plate</th>
							<th scope="col">&nbsp;</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${plateList}" var="p" varStatus="status">
							<tr>
								<th scope="row">${status.count}</th>
								<td><i class="fa-solid fa-car"></i></td>
								<td>${p.numberPlate}</td>
								<td><a href="#" onclick="deleteClick('${p.nID}')"><i class="fa-solid fa-trash"></i></a></td>					
							</tr>
						</c:forEach>
					</tbody>
				</table>
				<!-- Add Button -->
				<div class="row">
					<div class="col" style="text-align:right"><button type="button" class="btn btn-primary" style="width:100px" onclick="addClick('popup1')">Add</button></div>
				</div>				
			</div>
			
			
			
			<!-- Popup1 -->
			<div class="popup1" id="popup1" style="display:none;padding:0px">
				<div class="row" style="margin:0px;background-color:#202432">
					<div class="col" style="text-align:right"><a href="#" id="popup-link" onclick="hide('popup1')">X</a></div>
				</div>
				<div class="row" style="margin:0px;background-color:#202432;height:42px">
					<div class="col" style="margin:0px;padding:0px;text-align:center;font-size:32px;color:white">Add a License Plate</div>
				</div>			
				<div class="row" style="margin-top:30px">
					<div class="col"><label for="numberPlate" class="form-label" style="margin-left:30px">License Plate:</label><span style="color:red;margin-left:20px" id="error1"></span></div>
				</div>	
				<div class="row">
					<div class="col" style="margin-left:30px"><input type="text" name="numberPlate" id="numberPlate" style="width:420px"></div>
				</div>					
				<!-- Submit Button -->
				<div class="row" style="margin-top:20px">
					<div class="col"><span style="margin-left:350px"><button type="button" class="btn btn-primary" style="width:100px" onclick="submitClick('popup1')">Submit</button></span></div>
				</div>		
			</div>				
			
			<input type="hidden" name="myAction" id="myAction" value="">
			<input type="hidden" name="nID" id="nID" value="">
		</form>	
	
		<br><br>
		<jsp:include page="${component}/footer.jsp"></jsp:include>
	
	</body>
</html>