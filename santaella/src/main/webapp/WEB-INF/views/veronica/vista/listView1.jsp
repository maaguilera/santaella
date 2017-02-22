<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<html>



<c:set var="pagePath" scope="session"
	value="Admin > Generar Quotas" />


<body>

	<div class="container">

	
<div class="row">

			<div class="panel panel-primary">
				<div class="panel-heading">
					<h3 class="panel-title">Resumen</h3>
				</div>

				<div class="panel-body">
					<table class="table">
						<thead>
							<tr>
								
								<th width="33%">Tipo de Hermano</th>
								<th width="33%">Numero de Hermanos</th>
								<th width="33%">Total Cuota</th>
								
								
							</tr>
						</thead>
						<tbody>
							
							<c:set var="vView1Group_" value="${vView1Group}" scope="session" />
							<c:forEach items="${vView1Group_}" var="element"
								varStatus="loopCounter">
								<tr>
									
									<td><c:out value="${element.typeName}" /></td>
									<td><c:out value="${element.numero}" /></td>
									<td><c:out value="${element.amount}" /></td>
								
								</tr>
							</c:forEach>
						</tbody>
					</table>
				</div>

			</div>
		</div>


		<div class="row">

			<div class="panel panel-primary">
				<div class="panel-heading">
					<h3 class="panel-title">Quotas a crear -- </h3>
				</div>

				<div class="panel-body">
					<table class="table">
						<thead>
							<tr>
								<th width="4%"></th>
								<th width="20%">DNI</th>
								<th width="12%">Nombre</th>
								<th width="15%">Appellido</th>
								<th width="15%">Fecha Nacimiento</th>

								<th width="12%">Tipo Herm.</th>
								<th width="20%">Importe</th>
								
							</tr>
						</thead>
						<tbody>
							<c:set var="now" value="<%=new java.util.Date()%>" />
							<c:set var="pageListHolder" value="${phonesList}" scope="session" />
							<c:forEach items="${pageListHolder.pageList}" var="element"
								varStatus="loopCounter">
								<tr>
									<td><c:out value="${loopCounter.count}" /></td>
									<td><c:out value="${element.id}" /></td>
									<td><c:out value="${element.name}" /></td>
									<td><c:out value="${element.surname}" /></td>
									<td>${element.bornDate.time}</td>
									<td><c:out value="${element.typeName}" /></td>
									<td><c:out value="${element.amount}" /></td>
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
						<a href='<c:url value="/veronica/vista/listView1/prev"/>'>Prev</a>
					</c:otherwise>
				</c:choose>
			</span> <span> <c:forEach begin="0"
					end="${pageListHolder.pageCount-1}" varStatus="loop">
		    &nbsp;&nbsp;
		    <c:choose>
						<c:when test="${loop.index == pageListHolder.page}">${loop.index+1}</c:when>
						<c:otherwise>
							<a
								href='<c:url value="/veronica/vista/listView1/${loop.index}"/>'>${loop.index+1}</a>
						</c:otherwise>
					</c:choose>
		    &nbsp;&nbsp;
		    </c:forEach>
			</span> <span> <c:choose>
					<c:when test="${pageListHolder.lastPage}">Next</c:when>
					<c:otherwise>
						<a href='<c:url value="/veronica/vista/listView1/next"/>'>Next</a>
					</c:otherwise>
				</c:choose>
			</span>
		</div>

	</div>
	
	

	<!--  It is advised to put the <script> tags at the end of the document body so that they don't block rendering of the page -->



	<script>

	
		$(document).ready(function() {
			
		
			
			
			
		}); //ready

	
		
	</script>

</body>
</html>
