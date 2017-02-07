<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<head>
	<meta charset="UTF-8">
	<title>Menu</title>
	<meta name="viewport" content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">

<link rel="stylesheet"	href='<c:url value="/web-resources/lib/bootstrap-3.3.6/css/bootstrap.min.css"/>'>
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datepicker/1.5.0/css/bootstrap-datepicker.min.css" />

<link rel="stylesheet"	href='<c:url value="/web-resources/lib/jquery/jquery-ui-1.10.4.custom.css"/>'>

	<link rel="stylesheet"	href='<c:url value="/web-resources/css/fonts/style.css"/>'>
	<link rel="stylesheet"	href='<c:url value="/web-resources/css/miestilos.css"/>'>

<style type="text/css">
th {
	text-align: left
}
.derecha   { float: right; }
.izquierda { float: left;  }

.error {
        color: red; font-weight: bold;
    }

</style>
	
	<script src="http://code.jquery.com/jquery-latest.js"></script>
	
	  <script type="text/javascript"  src='<c:url value="/web-resources/js/main.js"/>'></script>     
</head>



	<header>
		<div class="menu_bar">
			<a href="#" class="bt-menu"><span class="icon-list2"></span>Men� <security:authentication property="principal.username"/></a>
		</div>
 
		<nav class="navbar  navbar-inverse navbar-static-top" role="navigation">
			<ul>
				<li><a href='<c:url value="/myHome.html"/>'><span class="icon-house"></span>Inicio</a></li>
				
				
				<li class="submenu">
					<a href="#"><span class="icon-suitcase"></span>Reservas<span class="caret icon-arrow-down6"></span></a>
					<ul class="children">
						<li><a href='<c:url value="/reservation/reservationByDay"/>'>Pista Padel 1 <span class="icon-dot"></span></a></li>
						<li><a href='<c:url value="/person/listPersons"/>'>Pista Padel 2 <span class="icon-dot"></span></a></li>
						<li><a href='<c:url value="/person/listPersons"/>'>Pista Tenis   <span class="icon-dot"></span></a></li>									
						<li><a href="${pageContext.request.contextPath}/sec/moderation.html">Moderation<span class="icon-dot"></span></a></li>
					</ul>
				</li>
				<li class="submenu">
					<a href="#"><span class="icon-rocket"></span>Admin<span class="caret icon-arrow-down6"></span></a>
					<ul class="children">
						<li><a href='<c:url value="/person/listPersons"/>'>Listas Utilizadores <span class="icon-dot"></span></a></li>
						<li><a href="#">Reservas <span class="icon-house"></span></a></li>
						<li><a href="#">Reservas Utilizador <span class="icon-dot"></span></a></li>
						<li><a href="${pageContext.request.contextPath}/admin/first.html">First <span class="icon-house"></span></a></li>
						<li><a href="${pageContext.request.contextPath}/admin/second.html">Second<span class="icon-dot"></span></a></li>
					</ul>
				</li>
				<li><a href="#"><span class="icon-earth"></span>Mapa</a></li>
				<li><a href="#"><span class="icon-mail"></span>Contacto</a></li>
				
				<sec:authorize access="!isAuthenticated()"> 
				<li><a href="<c:url value="/user-login" />"><span class="icon-log-int"></span>    Login</a></li>
				</sec:authorize>
				
				<sec:authorize access="isAuthenticated()"> 
				<li><a href='<c:url value="/j_spring_security_logout" />'><span class="icon-log-out"></span>    Logout</a></li>
				</sec:authorize>
				
			</ul>
		</nav>
	</header>