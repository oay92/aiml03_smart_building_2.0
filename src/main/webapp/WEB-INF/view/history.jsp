<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Timestamp History</title>
    <jsp:include page="${component}/common_dependencies.jsp" />
	<style><%@include file="/WEB-INF/css/userprofile.css"%></style>
	<script><%@include file="/WEB-INF/js/userprofile.js"%></script>

</head>
<body>
	<jsp:include page="${component}/header.jsp" />
	<jsp:useBean id="timestampData"
		class="com.aiml03.project.model.bean.Timestamp" scope="request" />
	<jsp:setProperty name="timestampData" property="*" />
	<main>
		<h1>Timestamp History</h1>
		<h2>個人進出紀錄</h2>

		<table border="1">
			<tr>
				<th>Face Timestamp</th>
				<th>License Plate Timestamp</th>
			</tr>

			<c:forEach var="faceTimestamp" items="${faceTimestamps}"
				varStatus="loop">
				<tr>
					<td>${faceTimestamp}</td>
					<td>${plateTimestamps[loop.index]}</td>
				</tr>
			</c:forEach>
		</table>
		<jsp:include page="${component}/footer.jsp" />
	</main>
</body>

</html>
