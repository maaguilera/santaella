<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<c:url var="actionUrl" value="edit" />

<form:form id="personEditForm" commandName="person" method="post"
       action="${actionUrl }" class="pure-form pure-form-aligned">

     <fieldset>
            <legend></legend>
          <div class="pure-control-group">
              <label for="dni">DNI</label>
              <form:input path="dni" placeholder="DNI"  maxlength="10" readonly="true"/>
          </div>
        
          <div class="pure-control-group">
              <label for="name">Name</label>
              <form:input path="name" placeholder="nombre" />
          </div>
          <div class="pure-control-group">
               <label for="email">Email</label>
               <form:input path="email" placeholder="email@email.com" maxlength="15" />
          </div>
          <div class="pure-control-group">
              <label for="tfo">Tfo</label>
              <form:input path="tfo" placeholder="666666666" maxlength="10" />
          </div>
        
          <div class="pure-control-group">
              <label for="bornDate">Nacimiento</label>
              <form:input path="bornDate" placeholder="YYYY-MM-DD" class="datepicker" />
          </div>
          
          <div class="pure-control-group">
              <label for="isMale">Género</label>
              <form:radiobutton path="isMale" value="true"  />MAsculino
              <form:radiobutton path="isMale" value="false" />Femenino
          </div>
          
          <div class="pure-control-group">
              <label for="description">Description(s)</label>
              <form:input path="description" placeholder="" />
          </div>

          <form:input path="personId" type="hidden" />
      </fieldset>
</form:form>