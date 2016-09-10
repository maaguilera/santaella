
<hr />
<h3>Request Scope (key==values)</h3>
<%
	java.util.Enumeration<String> reqEnum = request.getAttributeNames();
	while (reqEnum.hasMoreElements()) {
		String s = reqEnum.nextElement();
		out.print(s);
		out.println("==" + request.getAttribute(s));
%><br />
<%
	}
%>


<h3>Session Scope (key==values)</h3>
<%
  java.util.Enumeration<String> sessEnum = request.getSession()
	.getAttributeNames();
  while (sessEnum.hasMoreElements()) {
	String s = sessEnum.nextElement();
	out.print(s);
	out.println("==" + request.getSession().getAttribute(s));
%><br />
<%
  }
%>