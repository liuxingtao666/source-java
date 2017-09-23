<%@page pageEncoding="utf-8" 
contentType="text/html;charset=utf-8" 
import="bean.*"%>
<html>
	<head></head>
	<body style="font-size:30px;font-style:italic;">
		<%
			User user = new User();
			user.setName("sally");
			user.setAge(22);
			user.setInterest(
			new String[]{"cooking","fishing"});
			Card card = new Card();
			card.setCardNo("11111");
			user.setCard(card);
			request.setAttribute("user",user);
		 %>
		 name:${user["name"]}<br/>
		 <%
		 	request.setAttribute("propname",
		 	"age");
		  %>
		  name:${user[propname]}<br/>
		  interest:${user.interest[0]}<br/>
		  cardNo:${user.card.cardNo}
	</body>
</html>