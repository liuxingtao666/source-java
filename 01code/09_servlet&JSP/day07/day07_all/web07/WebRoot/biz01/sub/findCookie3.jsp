<%
	Cookie[] cookies = 
	request.getCookies();
	if(cookies != null){
		for(int i=0;i<cookies.length;i++){
			Cookie c = cookies[i];
			out.println(c.getName() + " " 
			+ c.getValue() + "<br/>");
		}
	}
%>