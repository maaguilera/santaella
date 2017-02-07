<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>


<body>
<h2>Application Error, please contact support. error page</h2>

<h3>Debug Information:</h3>

error:<br>
<c:forEach items="${errors}" var="ste1">
	${ste1}<br>
</c:forEach>
<br>
Requested URL= ${url}<br><br>

Exception= ${exception.message}<br><br>

<strong>Exception Stack Trace</strong><br>
<c:forEach items="${exception.stackTrace}" var="ste">
	${ste}
</c:forEach>

</body>
