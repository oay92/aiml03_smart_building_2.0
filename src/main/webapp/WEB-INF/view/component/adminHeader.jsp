<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<header class="p-3 bg-dark text-white">
	<div class="container">
		<div class="d-flex flex-wrap align-items-center justify-content-center justify-content-lg-start">
			<ul
				class="nav col-12 col-lg-auto me-lg-auto mb-2 justify-content-center mb-md-0">
				<li><a href="/SmartBuilding/" class="nav-link px-2 text-white">Smart Building</a></li>
				<li><a class="nav-link px-2 text-white">|</a></li>
				<li><a href="${root}/account" class="nav-link px-2 text-white">Account REG</a></li>
				<li><a class="nav-link px-2 text-white">|</a></li>
				<li><a href="${root}/buildingUnit" class="nav-link px-2 text-white">Person REG</a></li>
				<li><a class="nav-link px-2 text-white">|</a></li>
				<li><a href="/PetForum/add_pet" class="nav-link px-2 text-white">License Plate REG</a></li>
			</ul>
			<div class="dropdown text-end">

				<c:if test="${loggedInMember==null }">
					<a href="/PetForum/login">
						<button class="btn btn-primary">會員登入</button>
					</a>
				</c:if>

				<c:if test="${loggedInMember!=null }">
					<img src="${loggedInMember.mPhoto }" style="width: 100px">  ${loggedInMember.mName }
					<a href="${root}/Logout.do">
						<button class="btn btn-info">登出</button>
					</a>
				</c:if>  

			</div>
		</div>
	</div>
</header>