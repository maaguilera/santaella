<%@ include file="/WEB-INF/views/include.jsp" %>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
        <link rel="stylesheet"
            href="//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css">
        <title>Welcome</title>
    </head>
    <body>
        <section>
            <div class="jumbotron">
                <div class="container">
                    <h1> ${greeting} </h1>
                    <p>  ${tagline} </p>
                    <p>Greetings, it is now <c:out value="${now}"/></p>
                    
                     <h3>Reservations</h3>
    <c:forEach items="${model.reservations}" var="prod">
      <c:out value="${prod.reservationId}"/> <i>$<c:out value="${prod.reservationPrice}"/></i><br><br>
    </c:forEach>
    
                </div>
                
                
            </div>
            
            <div>
            <br>
    	<a href="<c:url value="priceincrease.htm"/>">Increase Prices</a>
    	<br>
            </div>
        </section>
    </body>
</html>