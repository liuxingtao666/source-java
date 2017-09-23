<%
	Cookie c = new Cookie("userId","01001");
	c.setPath("/web07");
	response.addCookie(c);
%>