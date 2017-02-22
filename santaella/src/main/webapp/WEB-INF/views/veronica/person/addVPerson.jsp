<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<c:url var="actionUrl" value="/veronica/person/save" />

<div class="nav2">
		<div class="modal-content">
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal"
					aria-label="Close">
					<span aria-hidden="true">&times;</span>
				</button>
				<h4 class="modal-title" id="exampleModalLabel">Nuevo Utilizador</h4>
			</div>
			<div class="modal-body">


				<form:form class="form-horizontal" style="margin:0 auto" id="userForm" modelAttribute="vperson" commandName="vperson" method="post"	action="${actionUrl }">
					
					<form:errors path="*" cssClass="errorblock" element="div"/>

					<fieldset>
						<legend>Soy leyenda</legend>
						
						<div class="form-group">
							<label for="id">DNI</label>
							<form:input path="id" placeholder="DNI" maxlength="10" />
							<form:errors path="id" cssClass="error" />
						</div>

						<div class="form-group">
							<label for="name" class="form-control-label">Name</label>
							<form:input path="name" placeholder="nombre" />
							<form:errors path="name" cssClass="error" />
						</div>
						<div class="form-group">
							<label for="surname" class="form-control-label">Apellidos</label>
							<form:input path="surname" placeholder="apellidos" />
							<form:errors path="surname" cssClass="error" />
						</div>
						<div class="form-group">
							<label for="bornDate">Fecha Nacimiento</label>
						
							<form:input path="bornDate" placeholder="YYYY-MM-DD"
								class="datepicker" />
								<form:errors path="bornDate" cssClass="error" />
						</div>
						<div class="form-group">
							<label for="isWoman">Género</label>
							<form:radiobutton path="isWoman" value="false" />Masculino
							<form:radiobutton path="isWoman" value="true" />Femenino
						</div>
						<div class="form-group">
							<label for="joinDate" class="form-control-label">Fecha alta Hermano</label>
							<form:input path="joinDate" placeholder="YYYY-MM-DD" class="datepicker2" />
							<form:errors path="joinDate" cssClass="error" />
						</div>
						<div class="form-group">
							<label for="tfo">Tfo</label>
							<form:input path="tfo" placeholder="111111111"	maxlength="13" />
							<form:errors path="tfo" cssClass="error" />
						</div>
						<div class="form-group">
							<label for="email">Email</label>
							<form:input path="email" placeholder="email@email.com"	maxlength="15" />
							<form:errors path="email" cssClass="error" />
						</div>
						<div class="form-group">
							<label for="city">Ciudad</label>
							<form:input path="city" placeholder="ciudad" maxlength="20" />
							<form:errors path="city" cssClass="error" />
						</div>
						<div class="form-group">
							<label for="cp">CP</label>
							<form:input path="cp" placeholder="CP" maxlength="8" />
							<form:errors path="cp" cssClass="error" />
						</div>
						<div class="form-group">
							<label for="address">Dirección</label>
							<form:input path="address" placeholder="dirección" maxlength="45" />
							<form:errors path="address" cssClass="error" />
						</div>
						<div class="form-group">
							<label for="vType">Tipo hermano</label>
								<form:select path="vType">
					                 <form:options items="${vTypes}" itemLabel="name" itemValue="id" />
					            </form:select>
						</div>
						<div class="form-group">
							<label for="description">Description</label>
							<form:input path="description" placeholder="" size="80" maxlength="80" />
						</div>
						
						
					</fieldset>
					
					<div class="modal-footer">
					     <button type="button"  class="btn btn-secondary" data-dismiss="modal">Close</button>
						
						<button type="submit" id="submit" class="btn btn-primary">Send message</button>

			         </div>
				</form:form>
			</div>
			
		</div>

</div>
<script>
$(document).ready(function() {
			
	$(".datepicker").datepicker({
		format: "yyyy-mm-dd",
		changeMonth : true,
		changeYear : true,
		showButtonPanel : true
	});



	$(".datepicker2").datepicker({
		format: "yyyy-mm-dd",
		changeMonth : true,
		changeYear : true,
		showButtonPanel : true
	});


		
		});
		</script>
