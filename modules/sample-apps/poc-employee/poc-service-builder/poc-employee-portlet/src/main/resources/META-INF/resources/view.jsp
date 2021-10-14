<%@ page import="com.poc.employee.model.EmployeeEntry" %>

<%@ include file="/init.jsp" %>

<p>
	<b><liferay-ui:message key="employee.caption"/></b>
<h2>Add Student Form here !</h2>
<%@ include file="init.jsp"%>
<portlet:defineObjects />

<%  List<EmployeeEntry> studentList = (List<EmployeeEntry>)request.getAttribute("employeeList"); %>
<portlet:renderURL var="addEmployeeRenderURL">
	<portlet:param name="mvcPath" value="/AddEmployee.jsp"/>
</portlet:renderURL>

<div class="mb-5">
	<a href="<%= addEmployeeRenderURL %>" class="btn  btn-primary btn-default">
		<i class="glyphicon glyphicon-plus"></i> Add Student
	</a>
</div>
<table class="table table-striped">
	<tr >
		<th>Employee Id</th>
		<th>Employee Name</th>
		<th>Address</th>
		<th>BirthDay </th>
		<th>Gender </th>
		<th>hasAccount</th>
		<th colspan="2" style="width: 100px">Action</th>
	</tr>
	<c:forEach items="${employeeList}" var="employee">

		<portlet:renderURL var="updateEmployeeRenderURL">
			<portlet:param name="mvcPath" value="/update-employee.jsp"/>
			<portlet:param name="employeeId" value="${employee.employeeId}"/>
			<portlet:param name="name" value="${employee.name}"/>
			<portlet:param name="birthDay" value="${employee.birthDay}"/>
			<portlet:param name="gender" value="${employee.gender}"/>
			<portlet:param name="address" value="${employee.address}"/>
			<portlet:param name="hasAccount" value="${employee.hasAccount}"/>
		</portlet:renderURL>

		<portlet:actionURL name="deleteEmployee" var="deleteEmployeeActionURL">
			<portlet:param name="employeeId" value="${employee.getEmployeeId()}"/>
		</portlet:actionURL>

		<tr>
			<td>${employee.getEmployeeId()}</td>
			<td>${employee.getName()}</td>
			<td>${employee.getAddress()}</td>
			<td>${employee.getBirthDay()}</td>
			<td>${employee.getGender() == 0 ? "Nam" : "Nu" }</td>
			<td>${employee.getHasAccount()}</td>
			<td class="text-center" style="width: 50px">
				<a href="<%=updateEmployeeRenderURL%>" class="btn  btn-primary btn-default btn-sm px-2 py-1" >
					<i class ="glyphicon glyphicon-edit"> Update </i>
				</a>
			</td>
			<td class="text-center" style="width:50px">
				<a href="<%=deleteEmployeeActionURL%>"
				   class="btn  btn-primary btn-default btn-sm px-2 py-1"
				   onclick="return confirm('Are you sure you want to delete this item?');">
					<i class ="glyphicon glyphicon-remove"> Delete </i>
				</a>
			</td>
		</tr>
	</c:forEach>
</table>