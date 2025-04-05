<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
<!DOCTYPE html>

<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>

<meta charset="ISO-8859-1">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<title>Report Application</title>
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css"
	integrity="sha384-xOolHFLEh07PJGoPkLv1IbcEPTNtaed2xpHsD9ESMhqIYd0nLMwNLD69Npy4HI+N"
	crossorigin="anonymous">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>

	<div class="container">
			<h3 class="pb-3">Report Application</h3>
		
		<form:form method="POST" action="search"
				modelAttribute="search">

				<table class="table table-borderless ">
					<tr>
						<td><form:label path="planName">PlanName : </form:label> <form:select
								path="planName">
								<form:option value="" >-Select-</form:option>
								<form:options items="${names }" path="planName" />
							</form:select></td>
						<td><form:label path="planStatus">PlanStatus :</form:label> <form:select
								path="planStatus">
								<form:option value="" >-Select-</form:option>
								<form:options items="${status }" path="planStatus" />
							</form:select></td>
						<td><form:label path="gender">Gender</form:label> <form:select
								path="gender">
								<form:option value="" >-Select-</form:option>
								<form:option value="male" path="gender"></form:option>
								<form:option value="female" path="gender"></form:option>
							</form:select></td>
					</tr>
					<tr>
						<td><form:label path="startDate">Start Date :</form:label>
							<form:input type="date" path="startDate" /></td>
						<td><form:label path="endDate">End Date :</form:label>
				    		<form:input	type="date" path="endDate" /></td>
						<td></td>
					</tr>
					<tr>
					    <td><a href="/" class="btn btn-secondary">Reset</a>
						<input type="submit" value="Search"
							class="btn btn-primary" /></td>

						<td></td>
						<td></td>
					</tr>
				</table>
			</form:form>
			
			<hr/>
			
			<table class="table table-striped table-hover">
				<thead>
					<tr>
						<th>Id</th>
						<th>Holder Name</th>
						<th>Gender</th>
						<th>Plan Name</th>
						<th>Plan Status</th>
						<th>Start Date</th>
						<th>End Date</th>
						<th>BenfitAmt</th>
					</tr>
				</thead>
				<tbody>
					
				<c:forEach items="${plans}" var="plan">
                    <tr>
                        <td>${plan.citizenId}</td>
                        <td>${plan.citizenName}</td>
                        <td>${plan.gender}</td>
                		<td>${plan.planName}</td>
                		<td>${plan.planStatus}</td>
                		<td>${plan.startDate}</td>
                		<td>${plan.endDate}</td>
                		<td>${plan.benfitAmt}</td>
                       
                    </tr>
                </c:forEach>

				<tr>
				<c:if test="${empty plans}">
				    	<td colspan="8" style="text-align: center;">No Records Found</td>
				    </c:if>
				</tr>
				</tbody>
			
			</table>
			
			<hr/>
			Export: <a href="excel">Excel</a><a href="pdf">pdf</a>
	</div>
	
	

	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>