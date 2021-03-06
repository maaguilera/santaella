<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

	    <c:url var="actionUrlEdit1" value="/veronica/person/edit" />        
						<form:form id="formModalEdit" modelAttribute="vperson" commandName="vperson" method="post"	action="${actionUrlEdit1 }">
							
							<form:errors path="*" cssClass="errorblock" element="div"/>
		
						<fieldset>
								<legend></legend>
		
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
									<label for="isWoman">G�nero</label>
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
									<label for="address">Direcci�n</label>
									<form:input path="address" placeholder="direcci�n" maxlength="45" />
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
								
								<!--  div class="form-group">
        							<div class="col-xs-6 col-xs-offset-3"><button type="button"  class="btn btn-secondary"	data-dismiss="modal">Close</button></div>
        					    	<div class="col-xs-6 col-xs-offset-6"><button type="submit" id="submitEdit1" class="btn btn-default">Save</button></div>
				
    							</div-->
					
				
								
								
							</fieldset>
						</form:form>
