<% 
	Boolean result = (Boolean)request.getAttribute("show_result");
	String errorMsg = (String)request.getAttribute("errorMsg");
%>

<html>
	<body>
		<h1>Result page</h1>
		<p style="color:red;padding: 10px;">${errorMsg}</p>
		<form method="POST" action="HomeController">
			
			<label>Your name: </label> 
			<input type="text" name="name">
			
			<br>
			
			<label>Your age: </label>
			<input type="text" name="age">
			
			<input type="submit" value="Send">
			
		</form>
			
		  <%
		 	if(result != null){  %>
			<!--  Result -->
			<p>
				<b>Your name: <%= request.getParameter("name") %></b>
				<b>Your age:  <%= request.getParameter("age") %></b>
			</p>
		  <% } %> 
	</body>
</html>

