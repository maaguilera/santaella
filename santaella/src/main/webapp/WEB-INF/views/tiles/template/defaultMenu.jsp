	<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

	<header id="pepe">
		<div class="menu_bar">
			<a href="#" class="bt-menu"><span class="icon-list2"></span>Menú <security:authentication property="principal.username"/></a>
		</div>
 
		<nav class="navbar  navbar-inverse navbar-static-top" role="navigation">
			<ul>
				<li><a href='<c:url value="/myHome.html"/>'><span class="icon-house"></span>Inicio</a></li>
				
				<li class="submenu">
					<a href="#"><span class="icon-rocket"></span>Administración<span class="caret icon-arrow-down6"></span></a>
					<ul class="children">
					     <li><a href='<c:url value="/veronica/person/addPerson"/>'>Crear Nuevo Hermano<span class="icon-dot"></span></a></li>
						
						<li><a href='<c:url value="/veronica/person/listPersonsPag"/>'>Consulta de Hermanos<span class="icon-dot"></span></a></li>
						<li><a href='<c:url value="/veronica/quota/listQuotas"/>'>Consulta de Cuotas(Pdfs)<span class="icon-dot"></span></a></li>
						<li><a href='<c:url value="/veronica/vista/listView1"/>'>Generar Quotas / Resumen<span class="icon-dot"></span></a></li>
						
					</ul>
				</li>
			
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