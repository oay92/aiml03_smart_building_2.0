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
		
		<script>		
		function submitClick(id, user_action)
		{			
			document.getElementById("nID").value = id;
			document.getElementById('action').value = user_action	
						
			document.forms["myForm"].submit();	
		}
		</script>
	</head>
	<body>
		<jsp:include page="${component}/adminHeader.jsp" />
		<br><br>
		<form name="myForm" action="${root}/numberPlateResult.do" method="post">			
			<div class="container" style="margin:auto;min-height:100vh;width:40%">	
				<!-- Add Button -->
				<div class="row">
					<div class="col" style="text-align:right"><button type="button" class="btn btn-primary" style="width:100px" onclick="submitClick('0', 'add')">Add</button></div>
				</div>				
				
				<table class="table table-striped">
					<thead>
						<tr>
							<th scope="col">#</th>
							<th scope="col">&nbsp;</th>
							<th scope="col">License Plate</th>
							<th scope="col">Building #</th>
							<th scope="col">Unit #</th>							
							<th scope="col">&nbsp;</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${plateList}" var="p" varStatus="status">
							<tr>
								<th scope="row">${status.count}</th>
								<td><i class="fa-solid fa-car"></i></td>
								<td>${p.numberPlate}</td>
								<td>${p.buildingNum}</td>
								<td>${p.unitNum}</td>
								<td>
									<a href="#" onclick="submitClick('${p.nID}', 'delete')"><i class="fa-solid fa-trash"></i></a>
								</td>											
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>
						
			<input type="hidden" name="nID" id="nID" value="">			
			<input type="hidden" name="action" id="action" value="">
			<input type="hidden" name="buildingNum" value="${buildingNum}">
			<input type="hidden" name="unitNum" value="${unitNum}">
		</form>	
	
		<br><br>
		<jsp:include page="${component}/footer.jsp"></jsp:include>
	
	</body>
</html>