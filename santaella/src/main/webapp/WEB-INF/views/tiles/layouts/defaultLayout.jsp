<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>

<html>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title><tiles:getAsString name="title" /></title>
		<!--  ink href="<c:url value='/static/css/bootstrap.css' />" rel="stylesheet"></link>
		<link href="<c:url value='/static/css/app.css' />" rel="stylesheet"></link-->
		
			
		<link rel="stylesheet"	href='<c:url value="/web-resources/lib/jquery/jquery-ui-1.10.4.custom.css"/>'>
		<link rel="stylesheet"	href='<c:url value="/web-resources/lib/bootstrap-3.3.6/css/bootstrap.min.css"/>'>
		<link rel="stylesheet"	href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datepicker/1.5.0/css/bootstrap-datepicker.min.css" />
		
        <link rel="stylesheet"	href='<c:url value="/web-resources/css/fonts/style.css"/>'>
		<link rel="stylesheet"	href='<c:url value="/web-resources/css/miestilos.css"/>'>
		
		<style type="text/css">
		th {
			text-align: left
		}
		
		.derecha {
			float: right;
		}
		
		.izquierda {
			float: left;
		}
		
		.error {
			color: red;
			font-weight: bold;
		}
		
		.errorblock {
			color: #000;
			background-color: #ffEEEE;
			border: 3px solid #ff0000;
			padding: 8px;
			margin: 16px;
		}
		</style>
		
		<script src="http://code.jquery.com/jquery-latest.js"></script>
		
<script type="text/javascript" src='<c:url value="/web-resources/js/main.js"/>'></script>
		
	
       
       	
		

		
	
		

		
		
</head>

<body>
<section id="sidemenu">
		<tiles:insertAttribute name="menu" />
	</section>
	<header id="header">
		<tiles:insertAttribute name="header" />
	</header>

	

	<section id="site-content">
		<tiles:insertAttribute name="body" />
	</section>

	<footer id="footer">
		<tiles:insertAttribute name="footer" />
	</footer>
</body>
</html>