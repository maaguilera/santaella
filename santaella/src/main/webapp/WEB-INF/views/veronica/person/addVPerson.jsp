<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<c:url var="actionUrl" value="/veronica/person/save" />

<div class="nav2">
		<div class="modal-content">
			<div class="modal-header">
				
				<h4 class="modal-title" id="exampleModalLabel">A�adir Hermano</h4>
			</div>
			<div class="modal-body">


				<form:form class="form-horizontal" style="margin:0 auto" id="userForm" modelAttribute="vperson" commandName="vperson" method="post"	action="${actionUrl }">
					
					<form:errors path="*" cssClass="errorblock" element="div"/>

					<fieldset>
						
						
						<div class="form-group">
							<label class="col-sm-offset-0 col-sm-3 control-label" for="id">DNI</label>
							<div class="col-sm-9">
								<form:input path="id" placeholder="DNI" maxlength="10" />
								<form:errors path="id" cssClass="error" />
							</div>
						</div>

						<div class="form-group">
							<label class="col-sm-offset-0 col-sm-3 control-label" for="name">Name</label>
							<div class="col-sm-9">
							<form:input path="name" placeholder="nombre" />
							<form:errors path="name" cssClass="error" />
							</div>
							
						</div>
						<div class="form-group">
							<label  class="col-sm-offset-0 col-sm-3 control-label" for="surname">Apellidos</label>
							<div class="col-sm-9">
							<form:input path="surname" placeholder="apellidos" />
							<form:errors path="surname" cssClass="error" />
							</div>
						</div>
						<div class="form-group">
							<label  class="col-sm-offset-0 col-sm-3 control-label" for="bornDate">Fecha Nacimiento</label>
						<div class="col-sm-9">
							<form:input path="bornDate" placeholder="YYYY-MM-DD"
								class="datepicker" />
								<form:errors path="bornDate" cssClass="error" />
								</div>
						</div>
						<div class="form-group">
							<label  class="col-sm-offset-0 col-sm-3 control-label" for="isWoman">G�nero</label>
							<div class="col-sm-9">
							<form:radiobutton path="isWoman" value="false" />Masculino
							<form:radiobutton path="isWoman" value="true" />Femenino
							</div>
						</div>
						<div class="form-group">
							<label  class="col-sm-offset-0 col-sm-3 control-label" for="joinDate" >Fecha alta Hermano</label>
							<div class="col-sm-9">
							<form:input path="joinDate" placeholder="YYYY-MM-DD" class="datepicker2" />
							<form:errors path="joinDate" cssClass="error" />
							</div>
						</div>
						<div class="form-group">
							<label  class="col-sm-offset-0 col-sm-3 control-label" for="tfo">Tfo</label>
							<div class="col-sm-9">
							<form:input path="tfo" placeholder="111111111"	maxlength="13" />
							<form:errors path="tfo" cssClass="error" />
							</div>
						</div>
						<div class="form-group">
							<label  class="col-sm-offset-0 col-sm-3 control-label" for="email">Email</label>
							<div class="col-sm-9">
							<form:input path="email" placeholder="email@email.com"	maxlength="15" />
							<form:errors path="email" cssClass="error" />
							</div>
						</div>
						<div class="form-group">
							<label  class="col-sm-offset-0 col-sm-3 control-label" for="city">Ciudad</label>
							<div class="col-sm-9">
							<form:input path="city" placeholder="ciudad" maxlength="20" />
							<form:errors path="city" cssClass="error" />
							</div>
						</div>
						<div class="form-group">
							<label  class="col-sm-offset-0 col-sm-3 control-label" for="cp">CP</label>
							<div class="col-sm-9">
							<form:input path="cp" placeholder="CP" maxlength="8" />
							<form:errors path="cp" cssClass="error" />
							</div>
						</div>
						<div class="form-group">
							<label  class="col-sm-offset-0 col-sm-3 control-label" for="address">Direcci�n</label>
							<div class="col-sm-9">
							<form:input path="address" placeholder="direcci�n" maxlength="45" />
							<form:errors path="address" cssClass="error" />
							</div>
						</div>
						<div class="form-group">
							<label  class="col-sm-offset-0 col-sm-3 control-label" for="vType">Tipo hermano</label>
							<div class="col-sm-9">
								<form:select path="vType">
								 	<form:option value="NONE" label="Select"/>
					                 <form:options items="${vTypes}" itemLabel="name" itemValue="id" />
					            </form:select>
					            </div>
						</div>
						<div class="form-group">
							<label  class="col-sm-offset-0 col-sm-3 control-label" for="description">Description</label>
							<div class="col-sm-9">
							<form:input path="description" placeholder="" size="80" maxlength="80" />
							</div>
						</div>
						
						
					</fieldset>
					
					<div class="modal-footer">
					    
						
						<button type="submit" id="submit" class="btn btn-primary">Submitir</button>

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
