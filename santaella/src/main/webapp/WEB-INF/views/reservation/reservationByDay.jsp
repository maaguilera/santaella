<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<c:set var="pagePath" scope="session" value="Reservas > Pasta Padel 1" />

<!--  jsp:include page="../navbar.jsp" /-->




<body>


	<div id="bookDialog3" style="display: none;">
		<%@ include file="reservationDetailForm.jsp"%>
	</div>



	<div class="container">

		
		<div class="row">
			<div class='col-md-6 col-md-offset-3'>
				<div class="form-group">
					<form class="form-horizontal" action="" name="formulario"
						method="get">
						<fieldset>
							<legend class="text-center">Seleccione un dia para
								mostrar reservas</legend>
							<div class='input-group date' id='datetimepicker1'>
								<input type='text' name="day" id='day1' class="form-control" value="<c:out value="${day}" />" /> 
								<span
									class="input-group-addon"> <span
									class="glyphicon glyphicon-calendar"></span>

								</span> 
								<span class="input-group-addon">
									<button type="button" class="btn btn-info btn-sm" id='button1' value="click;">Mostrar Reservas</button>
								</span>
							</div>
						</fieldset>
					</form>
				</div>

			</div>

		</div>
		<form class="form-horizontal"
			action="${pageContext.request.contextPath}/reservation/saveReservations"
			name="formulario1" modelAttribute="reservationForm" method="post">

			<div class="row">

				<div class="panel panel-primary">
					<div class="panel-heading">
						<h3 class="panel-title">
							Reservas dia:
							<c:out value="${day}" />
						</h3>
					</div>



					<div class="panel-body">
						<table class="table">
							<thead>
								<tr>

									<th width="5%">Hora</th>
									<th width="5%">Reser</th>
									<th width="20%">Nombre</th>

									<th width="5%">Hora</th>
									<th width="5%">Reser</th>
									<th width="20%">Nombre</th>

									<th width="5%">Hora</th>
									<th width="5%">Reser</th>
									<th width="20%">Nombre</th>

								</tr>
							</thead>
							<tbody>
								<c:set var="temp" value="0" />
								<c:forEach items="${reservationForm.reservations}" var="element"
									varStatus="status">

									<c:choose>
										<c:when test="${element.reservated ==true }">
											<c:set var="temp3" value="checked='checked'" />
										</c:when>

										<c:otherwise>
											<c:set var="temp3" value="" />
										</c:otherwise>
									</c:choose>
									<c:if test="${temp ==0 }">
										<tr>
									</c:if>

									<input name="reservations[${status.index}].person.name"
										type="hidden" value="<c:out value="${element.person.name}" />">
									<input name="reservations[${status.index}].person.personId"
										type="hidden"
										value="<c:out value="${element.person.personId}" />">
									<input name="reservations[${status.index}].reservationId"
										type="hidden"
										value="<c:out value="${element.reservationId}" />">
									<input name="reservations[${status.index}].day" type="hidden"
										value="<c:out value="${element.day}" />">
									<input name="reservations[${status.index}].reservationStart"
										type="hidden" value="${element.reservationStart}">
									<input name="reservations[${status.index}].reservationDay"
										type="hidden" value="<c:out value="${day1}" />">
									<input name="reservations[${status.index}].reservatedOri"
										type="hidden"
										value="<c:out value="${element.reservatedOri}" />">
									<input name="reservations[${status.index}].recintoId"
										type="hidden" value="<c:out value="${recinto}" />">

									<td><c:out value="${element.day}" /></td>
									<td><input name="reservations[${status.index}].reservated"
										id="checkbox" type="checkbox" <c:out value="${temp3}" />></td>
									<td><a href="" class="pure-button pure-button-primary"
										onclick="detail('${element.reservationId}');">
											${element.person.name} </a></td>



									<c:set var="temp1" value="0" />
									<c:set var="temp" value="${temp +1}" />
									<c:if test="${temp > 2}">
										</tr>
										<c:set var="temp" value="0" />
										<c:set var="temp1" value="1" />
									</c:if>



								</c:forEach>
								<c:if test="${temp1 ==0 }">
									</tr>

								</c:if>
							</tbody>
						</table>
					</div>
				</div>


			</div>

			<div class="row">
				<span class="derecha">
					<button type="button" class="btn btn-info btn-sm" id='button2'
						value="click;">Guardar Cambios</button>
				</span>
			</div>
			</form>
	</div>
	

	<!--  It is advised to put the <script> tags at the end of the document body so that they don't block rendering of the page -->

	

	<script>
		function test() {
			alert("Hello"); // added sample text
		}
		function edit2(var1) {
			alert("Hello" + var1); // added sample text
		}

		$(function() {
			$('#datetimepicker1').datepicker({
				todayBtn : "linked",
				language : "es",
				autoclose : true,
				todayHighlight : true,
				format : 'yyyy-mm-dd'
			});
		});

		$(document).ready(function() {
			var day = $('#day1');
			var kk = $('#button1');

			kk.click(function() {
				//alert(day.val());
				document.formulario.submit()
			});
		});

		$(document).ready(function() {

			var kk = $('#button2');

			kk.click(function() {
				//alert("Pepe");
				document.formulario1.submit()
			});
		});
	</script>

	<script>
		function detail(id) {

			$.get("get/" + id, function(result) {

				$("#bookDialog3").html(result);

				$('#bookDialog3').dialog("option", "title", 'Detalle Reserva');

				$("#bookDialog3").dialog('open');

			});
		}

		$('#bookDialog3').dialog({

			autoOpen : false,
			position : 'center',
			modal : true,
			resizable : false,
			width : 440,
			buttons : {

				"Cancel" : function() {
					$(this).dialog('close');
				}
			},
			close : function() {

				$(this).dialog('close');
			}
		});
	</script>

</body>
</html>
