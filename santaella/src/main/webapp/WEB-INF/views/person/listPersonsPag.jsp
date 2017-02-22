<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>



<c:set var="pagePath" scope="session"
	value="Admin > Lista de Utilizadores" />

<!--  jsp:include page="../navbar.jsp" /-->

<script>
	function test() {
		alert("Hello"); // added sample text
	}
	function edit2(var1) {
		alert("Hello" + var1); // added sample text
	}
	
	
</script>


<body>
	<div style="width: 95%; margin: 0 auto;">

		<c:choose>
			<c:when test="${showForm=='1'}">
				<c:set var="pepe" value="true" />
			</c:when>
			<c:otherwise>
				<c:set var="pepe" value="false" />
				<br />
			</c:otherwise>
		</c:choose>



		<%@ include file="personForm.jsp"%>

		<%@ include file="personEditForm.jsp"%>




	</div>








	<div class="container">

		<div class="row">
			<div class='col-md-12'>
				
					<form class="form-horizontal" action="${pageContext.request.contextPath}/person/listPersonsPag/" name="formularioFiltro"
						method="get">
						<fieldset>
							<legend class="text-center">Filtros para realizar
								busquedas</legend>
							 
							<div class="form-group">
									<div class="col-sm-4">
											<label>Nombre:</label> 
											<div>
											<input type="text" id="name" name="name" size="50" value="<c:out value="${name}" />" /> 
											</div>
									</div>
									<div class="col-sm-2">
											<label>DNI:</label> 
											<div>
												<input type="text" id="dni" name="dni"value="<c:out value="${dni}" />" />  
											</div>
									</div>
								 <div class="col-sm-3">
								     <label >Fecha Inicio:</label> 
									 <div class="input-group date" id='datetimepickerme'>
										
											
											   
												<input type="text" class="form-control" name="dateMe" id='dateMe' value="<c:out value="${dateMe}" />" />
												<div class="input-group-addon">
													<span class="glyphicon glyphicon-th"></span>
												</div>
										
									</div>	
								</div>
								<div class="col-sm-3">
									<label >Fecha Fim:</label> 
									<div class="input-group date" id='datetimepickerma'>
										    
											<input type="text" class="form-control" name="dateMa" id='dateMa' value="<c:out value="${dateMa}" />" />
											<div class="input-group-addon">
													<span class="glyphicon glyphicon-th"></span>
											</div>
										
									</div>
								</div>
								
							</div>
							
							<div class="form-group">
								<div class="col-sm-11">
								</div>
								<div class="col-sm-1">
										<button type="button" class="btn btn-success btn-lg" id='buttonFiltro'	value="click;">Busqueda</button>
								</div>
							</div>
						</fieldset>
					</form>
				

			</div>

		</div>
		<div class="row">
			<button type="button" class="btn btn-success btn-lg"
				onclick="addPerson();">Add Person</button>
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
							<c:set var="pageListHolder" value="${phonesList}" scope="session" />
							<c:forEach items="${pageListHolder.pageList}" var="element"
								varStatus="loopCounter">
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
												onclick="editPerson('${element.personId}');">Editar</button>


											<a href='<c:url value="/delete/${element.personId}"/>'
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

		<div class="row">
			<span style="float: left;"> <c:choose>
					<c:when test="${pageListHolder.firstPage}">Prev</c:when>
					<c:otherwise>
						<a href='<c:url value="/person/listPersonsPag/prev"/>'>Prev</a>
					</c:otherwise>
				</c:choose>
			</span> <span> <c:forEach begin="0"
					end="${pageListHolder.pageCount-1}" varStatus="loop">
		    &nbsp;&nbsp;
		    <c:choose>
						<c:when test="${loop.index == pageListHolder.page}">${loop.index+1}</c:when>
						<c:otherwise>
							<a href='<c:url value="/person/listPersonsPag/${loop.index}"/>'>${loop.index+1}</a>
						</c:otherwise>
					</c:choose>
		    &nbsp;&nbsp;
		    </c:forEach>
			</span> <span> <c:choose>
					<c:when test="${pageListHolder.lastPage}">Next</c:when>
					<c:otherwise>
						<a href='<c:url value="/person/listPersonsPag/next"/>'>Next</a>
					</c:otherwise>
				</c:choose>
			</span>
		</div>

	</div>

	<!--  It is advised to put the <script> tags at the end of the document body so that they don't block rendering of the page -->


	<c:url var="actionUrl" value="save" />
	<c:url var="editUrl" value="edit" />

	<script>
	
	function initializeDatePicker() {
		$(".datepicker").datepicker({
			dateFormat : "yy-mm-dd",
			changeMonth : true,
			changeYear : true,
			showButtonPanel : true
		});
	}
	
		function addPerson() {

			//$('#exampleModal').dialog("option", "title", 'Add Person');
			$('#exampleModal').modal();

			initializeDatePicker()
		}

		function editPerson(id) {

			$.get('<c:url value="/person/getPerson"/>' + "/" + id, function(
					result) {

				$("#exampleModalEdit").html(result);

				$("#exampleModalEdit").modal();

				initializeDatePicker();
			});
		}

		

		function resetDialog(form) {

			form.find("input").val("");
		}



		$(document).ready(function() {
			
			$("#datetimepickerme").datepicker({
				changeMonth: true,
				changeYear: true,
				format: "yyyy-mm-dd",
				yearRange: "1930:2100",
				onSelect: function(dateText, inst) { 
				$("#dateMe").val(dateText);
			  	}
			});




			$("#datetimepickerma").datepicker({
				changeMonth: true,
				changeYear: true,
				format: "yyyy-mm-dd",
				yearRange: "1930:2100",
				onSelect: function(dateText, inst) { 
				$("#dateMa").val(dateText);
				}
			});

			
			$("#dateMe").on("change", function () {
		        var fromdate = $(this).val();
		        //alert(fromdate);
		    });
			$("#dateMa").on("change", function () {
		        var fromdate = $(this).val();
		       // alert(fromdate);
		    });
			
			
			
			var day = $('#dateIg');
			var kk = $('#buttonFiltro');

			kk.click(function() {
				//alert(day.val());
				document.formularioFiltro.submit()
			});
		});

		$(document).ready(function() {

			<c:choose>
			<c:when test="${showForm=='1'}">
			$('#exampleModal').modal();
			</c:when>
			<c:otherwise>
			//pepepepe
			</c:otherwise>
			</c:choose>
			/*
			 <c:choose>
			    <c:when test="${showFormEdit=='2'}">
			       $('#exampleModalEdit').modal();
			    </c:when>    
			    <c:otherwise>
			
			    </c:otherwise>
			</c:choose>
			 */

		});

		$('#exampleModal').on(
				'show.bs.modal',
				function(event) {
					alert("I want this to appear after the modal has opened!");
					var button = $(event.relatedTarget) // Button that triggered the modal
					var recipient = button.data('whatever') // Extract info from data-* attributes
					// If necessary, you could initiate an AJAX request here (and then do the updating in a callback).
					// Update the modal's content. We'll use jQuery here, but you could use a data binding library or other methods instead.
					var modal = $(this)
					modal.find('.modal-title').text(
							'New message to ffffff ' + recipient)
					modal.find('.modal-body input').val(recipient)
				})
	</script>
	<%=request.getContextPath()%>
	_test=${pageListHolder.firstPage}_






</body>
</html>
