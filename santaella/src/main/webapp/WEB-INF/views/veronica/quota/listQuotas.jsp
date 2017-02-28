<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>



<c:set var="pagePath" scope="session"
	value="Admin > Lista de Quotas" />

<!--  jsp:include page="../navbar.jsp" /-->


<body>
	

	<div class="container">

		<div class="row">
			<div class='col-md-12'>

				<form class="form-horizontal"
					action="${pageContext.request.contextPath}/veronica/quota/listQuotas/"
					name="formularioFiltro" method="get">
					<fieldset>
						<legend class="text-center">Filtros para realizar
							busquedas</legend>

						<div class="form-group">
							<div class="col-sm-4">
								<label>Año</label>
								<div>
									<input type="text" id="ano" name="ano" size="50"
										value="<c:out value="${ano}" />" />
								</div>
							</div>
							<div class="col-sm-4">
								<label>Tipo Herm.:</label>
								<div>
									<input type="text" id="typeName" name="typeName" size="50"
										value="<c:out value="${typeName}" />" />
								</div>
							</div>
							<div class="col-sm-2">
								<label>DNI:</label>
								<div>
									<input type="text" id="id" name="id"
										value="<c:out value="${dni}" />" />
								</div>
							</div>
							

						</div>

						<div class="form-group">
							<div class="col-sm-11"><button type="button" class="btn btn-success btn-lg"
									id='buttonFiltro' value="click;">Busqueda</button>
									</div>
							<div class="col-sm-1">
								
							</div>
						</div>
					</fieldset>
				</form>


			</div>

		</div>
		


		<div class="row">

			<div class="panel panel-primary">
				<div class="panel-heading">
					<h3 class="panel-title">Lista Usuarios</h3>
				</div>

				<div class="panel-body">
					<table class="table">
						<thead>
							<tr>
								<th width="4%"></th>
								<th width="20%">Nombre</th>
								<th width="12%">Concepto</th>
								<th width="15%">Importe</th>
								<th width="20%">ano</th>
								<th width="20%">token</th>
								

							</tr>
						</thead>
						<tbody>
							<c:set var="now" value="<%=new java.util.Date()%>" />
							<c:set var="pageListHolder" value="${phonesList}" scope="session" />
							<c:forEach items="${pageListHolder.pageList}" var="element"
								varStatus="loopCounter">
								<tr>
									<td><c:out value="${loopCounter.count}" /></td>
									<td><c:out value="${element.name}" /></td>
									<td><c:out value="${element.concept}" /></td>
									<td><c:out value="${element.amount}" /></td>
									<td><c:out value="${element.ano}" /></td>
									<td><c:out value="${element.token}" /></td>
								</tr>
							</c:forEach>
						</tbody>
					</table>
				</div>

			</div>
		</div>

		<div class="row">
			<span style="float: left;"> <c:choose>
					<c:when test="${pageListHolder.firstPage}">Prev</c:when>
					<c:otherwise>
						<a href='<c:url value="/veronica/quota/listQuotas/prev"/>'>Prev</a>
					</c:otherwise>
				</c:choose>
			</span> <span> <c:forEach begin="0"
					end="${pageListHolder.pageCount-1}" varStatus="loop">
		    &nbsp;&nbsp;
		    <c:choose>
						<c:when test="${loop.index == pageListHolder.page}">${loop.index+1}</c:when>
						<c:otherwise>
							<a
								href='<c:url value="/veronica/quota/ListQuotas/${loop.index}"/>'>${loop.index+1}</a>
						</c:otherwise>
					</c:choose>
		    &nbsp;&nbsp;
		    </c:forEach>
			</span> <span> <c:choose>
					<c:when test="${pageListHolder.lastPage}">Next</c:when>
					<c:otherwise>
						<a href='<c:url value="/veronica/quota/ListQuotas/next"/>'>Next</a>
					</c:otherwise>
				</c:choose>
			</span>
		</div>
		
		<div class="row">

			<div class="panel panel-primary">
				<div class="panel-heading">
					<h3 class="panel-title">Pdfs Quotas</h3>
				</div>

				<div class="panel-body">
					<table class="table">
						<thead>
							<tr>
								<th width="4%"></th>
								<th width="20%">Nombre Pdf</th>
								
							</tr>
						</thead>
						<tbody>
							
							
							<c:forEach items="${pdfs}" var="pdf"
								varStatus="loopCounter">
								<tr>
									<td><c:out value="${loopCounter.count}" /></td>
									<td><a href="${pageContext.request.contextPath}/web-resources/pdf/<c:out value="${pdf}" />"><c:out value="${pdf}" /></a></td>
								
								</tr>
							</c:forEach>
						</tbody>
					</table>
				</div>

			</div>
		</div>

	</div>
	
	

	<!--  It is advised to put the <script> tags at the end of the document body so that they don't block rendering of the page -->

	<script>




		$(document).ready(function() {
			
			
			
			
			
			
			var kk = $('#buttonFiltro');

			kk.click(function() {
				//alert(day.val());
				document.formularioFiltro.submit()
			});


			


			
			
			
		}); //ready

	
		
	</script>







</body>
</html>
