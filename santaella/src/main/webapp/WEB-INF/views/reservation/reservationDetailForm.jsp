<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<c:url var="actionUrl" value="edit" />

<form:form id="reservationDetailForm" commandName="reservation" method="post"
       action="${actionUrl }" class="pure-form pure-form-aligned">

     <fieldset>
            <legend></legend>
          <div class="pure-control-group">
              <label for="reservationId">reservationId</label>
              <form:input path="reservationId" placeholder="reservationId"  readonly="true"/>
          </div>
        
      </fieldset>
</form:form>