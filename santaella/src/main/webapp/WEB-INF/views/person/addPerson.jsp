<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<c:url var="actionUrl" value="/person/save" />

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


				<form:form id="userForm" modelAttribute="person" commandName="person" method="post"	action="${actionUrl }">
					
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
							<form:input path="email" placeholder="email@email.com"	maxlength="15" />
							<form:errors path="email" cssClass="error" />
						</div>
						<div class="form-group">
							<label for="tfo">Tfo</label>
							<form:input path="tfo" placeholder="666666666" maxlength="10" />
							<form:errors path="tfo" cssClass="error" />
						</div>

						<div class="form-group">
							<label for="dni">DNI</label>
							<form:input path="dni" placeholder="DNI" maxlength="11" />
						</div>

						<div class="form-group">
							<label for="bornDate">Nacimiento</label>
							<form:input path="bornDate" placeholder="YYYY-MM-DD"
								class="datepicker" />
						</div>

						<div class="form-group">
							<label for="isMale">Género</label>
							<form:radiobutton path="isMale" value="true" />	MAsculino
							<form:radiobutton path="isMale" value="false" />Femenino
						</div>

						<div class="form-group">
							<label for="description">Description(s)</label>
							<form:input path="description" placeholder="" />
						</div>
						
						<form:input path="personId" type="hidden" />
					</fieldset>
					
					<div class="modal-footer">
					     <button type="button"  class="btn btn-secondary" data-dismiss="modal">Close</button>
						
						<button type="submit" id="submit" class="btn btn-primary">Send message</button>

			         </div>
				</form:form>
			</div>
			
		</div>

</div>
