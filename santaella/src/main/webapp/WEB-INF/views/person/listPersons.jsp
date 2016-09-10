<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>

<jsp:include page="../navbar.jsp" />

<script>
function test(){
    alert("Hello"); // added sample text
}
function edit2( var1){
    alert("Hello" + var1); // added sample text
}

</script>


<body>
	<div style="width: 95%; margin: 0 auto;">

		<div id="bookDialog" style="display: none;">
			<%@ include file="personForm.jsp"%>
		</div>
		<div id="bookDialog2" style="display: none;">
			<%@ include file="personEditForm.jsp"%>
		</div>
		
		
    </div>

<div class="row" >
		<button type="button" class="btn btn-success btn-lg"
			onclick="addPerson();">Add Person</button>
		</div>
		
		<div class="row">

			<div class="panel panel-primary">
				<div class="panel-heading">
					<h3 class="panel-title">
						Lista Usuarios
						
					</h3>
				</div>
				
		<div class="panel-body">
			<table class="table">
				<thead>
					<tr>
						<th width="4%"></th>
						<th width="20%">Name</th>
						<th width="12%">Dni</th>
						<th width="15%">Email</th>
						<th width="10%">tfo</th>

						<th width="12%">BornDate</th>
						<th width="20%">Description</th>
						<th width="12%"></th>
					</tr>
				</thead>
				<tbody>
					<c:set var="now" value="<%=new java.util.Date()%>" />
					<c:forEach items="${getList}" var="element" varStatus="loopCounter">
						<tr>
							<td><c:out value="${loopCounter.count}" /></td>
							<td><c:out value="${element.name}" /></td>
							<td><c:out value="${element.dni}" /></td>
							<td><c:out value="${element.email}" /></td>
							<td><c:out value="${element.tfo}" /></td>

							<td>${element.bornDate.time}</td>
							<td><c:out value="${element.description}" /></td>





							<td><nobr>

									<button type="button" class="btn btn-info btn-sm"
										onclick="editPerson2('${element.personId}');">Editar</button>


									<a href="delete/${element.personId}"
										class="pure-button pure-button-primary"
										onclick="return confirm('Are you sure you want to delete this Person?');">
										<i class="fa fa-times"></i>Delete
									</a>
								</nobr></td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>

	</div>
	</div>


	<!--  It is advised to put the <script> tags at the end of the document body so that they don't block rendering of the page -->

	<script type="text/javascript"
		src='<c:url value="/web-resources/lib/jquery/jquery-1.10.2.js"/>'></script>
	<script type="text/javascript"
		src='<c:url value="/web-resources/lib/jquery/jquery-ui-1.10.4.custom.js"/>'></script>
	<script type="text/javascript"
		src='<c:url value="/web-resources/lib/jquery/jquery.ui.datepicker.js"/>'></script>
	<script type="text/javascript"
		src='<c:url value="/web-resources/js/js-for-listBooks.js"/>'></script>

<script>

function editPerson2(id) {
	
	$.get("get/" + id, function(result) {

		$("#bookDialog2").html(result);

		$('#bookDialog2').dialog("option", "title", 'Edit Person');

		$("#bookDialog2").dialog('open');

		initializeDatePicker();
	});
}
</script>
	<%=request.getContextPath() %>

</body>
</html>
