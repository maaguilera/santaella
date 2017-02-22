<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<c:url var="actionUrl1" value="/veronica/person/save" />

<div class="modal fade" id="exampleModal" tabindex="-1" role="dialog"
	aria-labelledby="exampleModalLabel" aria-hidden="true">
	<div class="modal-dialog" role="document">
		<div class="modal-content">
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal"
					aria-label="Close">
					<span aria-hidden="true">&times;</span>
				</button>
				<h4 class="modal-title" id="exampleModalLabel">Nuevo Utilizador</h4>
			</div>
			<div class="modal-body">


				<form:form id="userForm" modelAttribute="vperson" commandName="vperson" method="post"
					action="${actionUrl1 }">
					
					<form:errors path="*" cssClass="errorblock" element="div"/>

					<fieldset>
						<legend></legend>

						<div class="form-group">
							<label for="name" class="form-control-label">Name</label>
							<form:input path="name" placeholder="nombre" />
							<form:errors path="name" cssClass="error" />
						</div>
						<div class="form-group">
							<label for="email">Email</label>
							<form:input path="email" placeholder="email@email.com"
								maxlength="15" />
							<form:errors path="email" cssClass="error" />
						</div>
						<div class="form-group">
							<label for="tfo">Tfo</label>
							<form:input path="tfo" placeholder="666666666" maxlength="10" />
							<form:errors path="tfo" cssClass="error" />
						</div>

						<div class="form-group">
							<label for="id">DNI</label>
							<form:input path="id" placeholder="DNI" maxlength="10" />
						</div>

						<div class="form-group">
							<label for="bornDate">Nacimiento</label>
							<form:input path="bornDate" placeholder="YYYY-MM-DD"
								class="datepicker" />
						</div>

						<div class="form-group">
							<label for="isMale">Género</label>
							<form:radiobutton path="isWoman" value="false" />
							MAsculino
							<form:radiobutton path="isWoman" value="true" />
							Femenino
						</div>

						<div class="form-group">
							<label for="description">Description(s)</label>
							<form:input path="description" placeholder="" />
						</div>
						
				
					</fieldset>
				</form:form>
			</div>
			<div class="modal-footer">
				<button type="button"  class="btn btn-secondary"
					data-dismiss="modal">Close</button>
					
					<button type="button" id="submit" class="btn btn-primary">Send
							message</button>

			</div>
		</div>
	</div>
</div>



<script>


	$("#submit").click (function() {
		   $("#userForm").attr("action", "${actionUrl1}");
		   $('#userForm').submit();
        });


</script>

