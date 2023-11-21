<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>${webName}</title>
		
		<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-F3w7mX95PdgyTmZZMECAngseQB83DfGTowi0iMjiWaeVhAn4FJkqJByhZMI3AhiU" crossorigin="anonymous">
		<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/js/bootstrap.bundle.min.js" integrity="sha384-/bQdsTh/da6pkI1MST/rWKFNjaCP5gBSY4sEBT38Q/9RBh9AH40zEOg7Hlq2THRZ" crossorigin="anonymous"></script>
	</head>
	<body>
		<jsp:include page="${component}/adminHeader.jsp"></jsp:include>
		<br><br>
		<form name="myForm">		
			<div class="container" style="margin:auto; width:70%">			
				<table class="table table-striped">
					<thead>
						<tr>
							<th scope="col">#</th>
							<th scope="col">Photo</th>
							<th scope="col">Name</th>
							<th scope="col">Email</th>
							<th scope="col">Phone</th>
							<th scope="col">Primary</th>
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
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>
		</form>
		
		<br><br>
		<jsp:include page="${component}/footer.jsp"></jsp:include>		
	</body>
</html>