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
<link rel="stylesheet" type="text/css" 
href="${pageContext.request.contextPath}/resources/css/add-customer-style.css">
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

<!-- add new button: Add Customer -->

<input type="button" value="Add Customer" 
onclick="window.location.href='showFormForAdd';return false" 
class="add-button"
/>


<!-- add our html table here -->
<hr>
	<table>
	<tr>
	<th>First Name</th>
	<th>Last Name</th>
	<th>Email Name</th>
	<th>Action</th>
	</tr>
	
	<!-- items="${customers} <- customers name from MVC model  -->
		<c:forEach var="tempCustomer" items="${customers}">		
		
			<!-- construct an "update" link with costumer id -->
			<c:url var="updateLink" value="/customer/showFormForUpdate">
			<c:param name="customerId" value="${tempCustomer.id}"/>
			</c:url>
			
			<!-- construct a "delete" link with customer id -->
			<c:url var="delete" value="/customer/delete">
			<c:param name="customerId" value="${tempCustomer.id}"/>
			</c:url>
			
			<tr>
			<!-- will call tempCustomer.getFirstName() -->
			<td>${tempCustomer.firstName}</td>
			
			<!-- will call tempCustomer.getLastName() -->
			<td>${tempCustomer.lastName}</td>
			
			<!-- will call tempCustomer.getEmail() -->
			<td>${tempCustomer.email}</td>
			
			<!-- display the update link -->
			<td><a href="${updateLink}">Update</a>
			|
			<a href="${delete}"
			onclick="if(!(confirm('Are you sure you want to delete this customer?'))) return false"
			>Delete</a></td>
			</tr>		
		</c:forEach>		
	</table>

</div>
</div>

<hr>
<p>List Customers - coming soon....</p>
<hr>
<p>You've another instance of Tomcat already running. You can confirm this by</p> 
<p>going to http://localhost:8080 in your webbrowser and check if you get the</p> 
<p>Tomcat default home page or a Tomcat-specific 404 error page. Both are</p> 
<p>equally valid evidence that Tomcat runs fine; if it didn't, then you would</p>
<p>have gotten a browser specific HTTP connection timeout error message.</p>
<p></p>
<p>You need to shutdown it. Go to /bin subfolder of the Tomcat installation</p> 
<p>folder and execute the shutdown.bat (Windows) or shutdown.sh (Unix) script.</p>
<hr>
<img src="${pageContext.request.contextPath}/resources/images/how spring mvc.jpg">
</div>

</body>
</html>