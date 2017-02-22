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
	
	       
	       
			<%@ include file="vpersonForm.jsp"  %>
			
			<%@ include file="vpersonEditForm.jsp"  %>
		
			
		

	</div>
	

 
 
  
	
		

	<div class="container">
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
							<c:forEach items="${getList}" var="element"
								varStatus="loopCounter">
								<tr>
									<td><c:out value="${loopCounter.count}" /></td>
									<td><c:out value="${element.name}" /></td>
									<td><c:out value="${element.id}" /></td>
									<td><c:out value="${element.email}" /></td>
									<td><c:out value="${element.tfo}" /></td>

									<td>${element.bornDate.time}</td>
									<td><c:out value="${element.description}" /></td>





									<td><nobr>

											<button type="button" class="btn btn-info btn-sm"
												onclick="editPerson('${element.id}');">Editar</button>


											<a href="delete/${element.id}"
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
	</div>

	<!--  It is advised to put the <script> tags at the end of the document body so that they don't block rendering of the page -->


<c:url var="actionUrl" value="save" />
<c:url var="editUrl" value="edit" />

	<script>
	
	
	function addPerson() {

		//$('#exampleModal').dialog("option", "title", 'Add Person');
		$('#exampleModal').modal();
		
		
		
		initializeDatePicker()
	}

	
     function editPerson(id) {
		
		
		//$.get("getPerson/" + id, function(result) {
		
		//	$("#exampleModal").html(result);

			$("#exampleModal").modal();

			initializeDatePicker();
		//});
	}

	function initializeDatePicker() {
		$(".datepicker").datepicker({
			dateFormat : "yy-mm-dd",
			changeMonth : true,
			changeYear : true,
			showButtonPanel : true
		});
	}

	function resetDialog(form) {

		form.find("input").val("");
	}


		
		
		 
		 
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
		 
		 
		 $('#exampleModal').on('show.bs.modal', function (event) {
			 alert("I want this to appear after the modal has opened!");
			  var button = $(event.relatedTarget) // Button that triggered the modal
			  var recipient = button.data('whatever') // Extract info from data-* attributes
			  // If necessary, you could initiate an AJAX request here (and then do the updating in a callback).
			  // Update the modal's content. We'll use jQuery here, but you could use a data binding library or other methods instead.
			  var modal = $(this)
			  modal.find('.modal-title').text('New message to ffffff ' + recipient)
			  modal.find('.modal-body input').val(recipient)
			})
	</script>
	<%=request.getContextPath()%>
	
	
	
	
	

</body>
</html>
