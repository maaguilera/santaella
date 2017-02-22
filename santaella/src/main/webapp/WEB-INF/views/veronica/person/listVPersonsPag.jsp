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



		<!-- %@ include file="vpersonForm.jsp"%-->

		<%@ include file="vpersonEditForm.jsp"%>




	</div>


	<div class="container">

		<div class="row">
			<div class='col-md-12'>

				<form class="form-horizontal"
					action="${pageContext.request.contextPath}/veronica/person/listPersonsPag/"
					name="formularioFiltro" method="get">
					<fieldset>
						<legend class="text-center">Filtros para realizar
							busquedas</legend>

						<div class="form-group">
							<div class="col-sm-4">
								<label>Nombre:</label>
								<div>
									<input type="text" id="name" name="name" size="50"
										value="<c:out value="${name}" />" />
								</div>
							</div>
							<div class="col-sm-2">
								<label>DNI:</label>
								<div>
									<input type="text" id="id" name="id"
										value="<c:out value="${dni}" />" />
								</div>
							</div>
							<div class="col-sm-3">
								<label>Fecha Inicio:</label>
								<div class="input-group date" id='datetimepickerme'>



									<input type="text" class="form-control" name="dateMe"
										id='dateMe' value="<c:out value="${dateMe}" />" />
									<div class="input-group-addon">
										<span class="glyphicon glyphicon-th"></span>
									</div>

								</div>
							</div>
							<div class="col-sm-3">
								<label>Fecha Fim:</label>
								<div class="input-group date" id='datetimepickerma'>

									<input type="text" class="form-control" name="dateMa"
										id='dateMa' value="<c:out value="${dateMa}" />" />
									<div class="input-group-addon">
										<span class="glyphicon glyphicon-th"></span>
									</div>

								</div>
							</div>

						</div>

						<div class="form-group">
							<div class="col-sm-11"></div>
							<div class="col-sm-1">
								<button type="button" class="btn btn-success btn-lg"
									id='buttonFiltro' value="click;">Busqueda</button>
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
									<td><c:out value="${element.id}" /></td>
									<td><c:out value="${element.email}" /></td>
									<td><c:out value="${element.tfo}" /></td>

									<td>${element.bornDate.time}</td>
									<td><c:out value="${element.description}" /></td>





									<td><button type="button" class="btn btn-default editButton" data-id="${element.id}">Editar</button></td>
												<!--   onclick="editPerson('${element.id}');">Editar</button> -->

									<td><a href='<c:url value="/veronica/delete/${element.id}"/>'
												class="pure-button pure-button-primary"
												onclick="return confirm('Are you sure you want to delete this Person?');">
												<i class="fa fa-times"></i>Delete
											</a>
										</td>
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
						<a href='<c:url value="/veronica/person/listPersonsPag/prev"/>'>Prev</a>
					</c:otherwise>
				</c:choose>
			</span> <span> <c:forEach begin="0"
					end="${pageListHolder.pageCount-1}" varStatus="loop">
		    &nbsp;&nbsp;
		    <c:choose>
						<c:when test="${loop.index == pageListHolder.page}">${loop.index+1}</c:when>
						<c:otherwise>
							<a
								href='<c:url value="/veronica/person/listPersonsPag/${loop.index}"/>'>${loop.index+1}</a>
						</c:otherwise>
					</c:choose>
		    &nbsp;&nbsp;
		    </c:forEach>
			</span> <span> <c:choose>
					<c:when test="${pageListHolder.lastPage}">Next</c:when>
					<c:otherwise>
						<a href='<c:url value="/veronica/person/listPersonsPag/next"/>'>Next</a>
					</c:otherwise>
				</c:choose>
			</span>
		</div>

	</div>
	
	

	<!--  It is advised to put the <script> tags at the end of the document body so that they don't block rendering of the page -->


	<c:url var="actionUrl" value="save" />
	<c:url var="editUrl" value="edit" />

	<script>



		function editPerson2(id) {

			//$.get('<c:url value="/veronica/person/getPerson"/>' + "/" + id, function(result) {

				//$("#exampleModalEdit").html(result);

				$("#exampleModalEdit").modal();


			//});
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


			 <c:choose>
			    <c:when test="${showFormEdit=='2'}">
			       $('#exampleModalEdit1').modal();
			    </c:when>    
			    <c:otherwise>
			
			    </c:otherwise>
			</c:choose>


			 $('#exampleModalEdit').bootstrapValidator({
		            framework: 'bootstrap',
		            icon: {
		                valid: 'glyphicon glyphicon-ok',
		                invalid: 'glyphicon glyphicon-remove',
		                validating: 'glyphicon glyphicon-refresh'
		            },
		           //excluded: [':disabled'],
		            fields: {
		                name: {
		                    validators: {
		                        notEmpty: {
		                            message: 'The full name is required'
		                        },
		                        regexp: {
		                            regexp: /^[a-zA-Z\s]+$/,
		                            message: 'The full name can only consist of alphabetical characters'
		                        }
		                    }
		                },
		                email: {
		                    validators: {
		                        notEmpty: {
		                            message: 'The email address is required'
		                        },
		                        emailAddress: {
		                            message: 'The email address is not valid'
		                        }
		                    }
		                }
		                /*website: {
		                    validators: {
		                        notEmpty: {
		                            message: 'The website address is required'
		                        },
		                        uri: {
		                            allowEmptyProtocol: true,
		                            message: 'The website address is not valid'
		                        }
		                    }
		                }*/
		            }
		        })
		        .on('success.form.fv', function(e) {
		            // Save the form data via an Ajax request
		            e.preventDefault();

		            var $form = $(e.target),
		                id    = $form.find('[name="id"]').val();

		            // The url and method might be different in your application
		            $.ajax({
		                url: '${actionUrlEdit}',
		                method: 'POST',
		                //data: $form.serialize()
		            }).success(function(response) {
		                // Get the cells
		                var $button = $('button[data-id="' + id + '"]'),
		                    $tr     = $button.closest('tr'),
		                    $cells  = $tr.find('td');

		                // Update the cell data
		                $cells
		                    .eq(1).html(response.name).end()
		                    .eq(2).html(response.id).end()
		                    .eq(3).html(response.email).end();

		                // Hide the dialog
		                $form.parents('.bootbox').modal('hide');

		                // You can inform the user that the data is updated successfully
		                // by highlighting the row or showing a message box
		                bootbox.alert('The user profile is updated');
		            });
		        });
		        
					
			 $('.editButton').on('click', function() {
			        // Get the record's ID via attribute
			        var id = $(this).attr('data-id');

			        $("#exampleModalEdit1").on('hidden.bs.modal', '.modal', function () {
			            $(this).find('.modal-body').empty();
			        });
			        
			        $.ajax({
			            url: '<c:url value="/veronica/person/getPerson"/>' + "/" + id,
			            method: 'GET'
			        }).success(function(response) {
			        	 $("#exampleModalEdit1").
			        	 $("#exampleModalEdit1").html(response);
			            // Populate the form fields with the data returned from server
			          /*  $('#exampleModalEdit')
			                .find('[name="name""]').val(response.name).end()
			                .find('[name="surname"]').val(response.surname).end()
			                .find('[name="email"]').val(response.email).end()
			                .find('[name="description"]').val(response.description).end();*/
			             
			            // Show the dialog
			            bootbox
			                .dialog({
			                    title: 'Edit the user profile',
			                    message: $('#exampleModalEdit'),
			                    show: false // We will show it manually later
			                })
			                .on('shown.bs.modal', function() {
			                    $('#exampleModalEdit')
			                        .show()                             // Show the login form
			                        .bootstrapValidator('resetForm',true);// Reset form
			                })
			                .on('hide.bs.modal', function(e) {
			                    // Bootbox will remove the modal (including the body which contains the login form)
			                    // after hiding the modal
			                    // Therefor, we need to backup the form
			                    $('#exampleModalEdit').hide().appendTo('body');
			                })
			                .modal('show');
			        });
			    });
			
			
			
		}); //ready

	
		
	</script>
	<%=request.getContextPath()%>
	_test=${pageListHolder.firstPage}_






</body>
</html>
