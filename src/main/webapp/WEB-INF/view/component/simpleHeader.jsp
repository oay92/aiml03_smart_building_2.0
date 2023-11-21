<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<header class="p-3 bg-dark text-white">
	<div class="container">
		<div class="d-flex flex-wrap align-items-center justify-content-center justify-content-lg-start">
			<ul
				class="nav col-12 col-lg-auto me-lg-auto mb-2 justify-content-center mb-md-0">
				<li><a href="/SmartBuilding/" class="nav-link px-2 text-white">Smart Building</a></li>

			</ul>
			
			
			<c:if test="${account != null}">
				<div class="dropdown text-end">
					Welcome, ${account.userID}&nbsp;
					<a href="${root}/Logout.do"><button type="button" class="btn btn-outline-light me-2">Logout</button></a>
				</div>
			</c:if>
		</div>
	</div>
</header>