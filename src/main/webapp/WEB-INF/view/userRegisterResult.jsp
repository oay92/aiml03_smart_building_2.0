<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>${webName}</title>
		
		<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.2/css/all.min.css">
		<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-F3w7mX95PdgyTmZZMECAngseQB83DfGTowi0iMjiWaeVhAn4FJkqJByhZMI3AhiU" crossorigin="anonymous">
		<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/js/bootstrap.bundle.min.js" integrity="sha384-/bQdsTh/da6pkI1MST/rWKFNjaCP5gBSY4sEBT38Q/9RBh9AH40zEOg7Hlq2THRZ" crossorigin="anonymous"></script>
		<style><%@include file="/WEB-INF/css/default.css"%></style>
		
		<script>
		function submitClick(id, user_action)
		{        
			document.getElementById("pID").value = id;
			document.getElementById("action").value = user_action;
			
			document.forms["myForm"].submit();				
		}		
		</script>	
	</head>
	<body>
		<jsp:include page="${component}/adminHeader.jsp"></jsp:include>
		<br><br>
		<form name="myForm" action="${root}/UserRegisterResult.do" method="post">		
			<div class="container" style="margin:auto;min-height:100vh;width:70%">	
				<!-- Add Button -->
				<div class="row">
					<div class="col" style="text-align:right"><button type="button" class="btn btn-primary" style="width:100px" onclick="submitClick('0', 'add')">Add</button></div>
				</div>	
					
				<table class="table table-striped">
					<thead>
						<tr>
							<th scope="col">#</th>
							<th scope="col">Photo</th>
							<th scope="col">Name</th>
							<th scope="col">Email</th>
							<th scope="col">Phone</th>
							<th scope="col">Primary</th>
							<th scope="col">&nbsp;</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${personList}" var="p" varStatus="status">
							<tr>
								<th scope="row">${status.count}</th>
								<td><img src="${p.photo}" style="width:100px"/></td>
								<td>${p.name}</td>
								<td>${p.email}</td>
								<td>${p.phone}</td>
								<c:if test="${p.primaryContact == 1}">
									<td>Yes</td>
								</c:if>
								<c:if test="${p.primaryContact != 1}">
									<td>&nbsp;</td>
								</c:if>	
								<td>
									<a href="#" onclick="submitClick('${p.pID}', 'edit')"><i class="fa-solid fa-user-pen"></i></a>
									<br>
									<a href="#" onclick="submitClick('${p.pID}', 'delete')"><i class="fa-solid fa-trash"></i></a>
								</td>								
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>
			
			<input type="hidden" name="pID" id="pID">
			<input type="hidden" name="action" id="action">
			<input type="hidden" name="buildingNum" value="${buildingNum}">
			<input type="hidden" name="unitNum" value="${unitNum}">
		</form>
		
		<br><br>
		<jsp:include page="${component}/footer.jsp"></jsp:include>		
	</body>
</html>