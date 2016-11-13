<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <!-- add jstl tags library  -->
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" type="text/css" 
href="${pageContext.request.contextPath}/resources/css/main.css">
<link rel="stylesheet" type="text/css" 
href="${pageContext.request.contextPath}/resources/css/style.css">
<title>List customers</title>
</head>
<body>
<p><a href="http://c1-kongfly.rhcloud.com/1/">PREVIOUS MAIN</a></p>
<div class="main">
<div id="wrap">
<div id="header">

<h2>CRM - CUSTOMER RELATIONSHIP MANAGER</h2>
</div>
</div>
<div id="container">
<div id="content">
<!-- add out html -->
<hr>
	<table>
	<tr>
	<th>First Name</th>
	<th>Last Name</th>
	<th>Email Name</th>
	</tr>
	
	<!-- items="${customers} <- customers name from MVC model  -->
		<c:forEach var="tempCustomer" items="${customers}">
			<tr>
			<!-- will call tempCustomer.getFirstName() -->
			<td>${tempCustomer.firstName}</td>
			<!-- will call tempCustomer.getLastName() -->
			<td>${tempCustomer.lastName}</td>
			<!-- will call tempCustomer.getEmail() -->
			<td>${tempCustomer.email}</td>
			</tr>		
		</c:forEach>		
	</table>

</div>
</div>

<hr>
<p>List Customers - coming soon....</p>

<hr>
<img src="${pageContext.request.contextPath}/resources/images/how spring mvc.jpg">
</div>

</body>
</html>