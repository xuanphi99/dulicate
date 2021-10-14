<%@ page import="java.util.Date" %>
<%@ page import="java.text.ParseException" %>
<%@ include file="init.jsp"%>
<portlet:defineObjects />
<h2>Update Employee Form here !</h2>

<portlet:actionURL name="updateEmployee" var="updateEmployeeActionURL"/>

<%
    String employeeId = renderRequest.getParameter("employeeId");
    String birthDay =  renderRequest.getParameter("birthDay");
    String gender = renderRequest.getParameter("gender");
    String address = renderRequest.getParameter("address");
    String hasAccount = renderRequest.getParameter("hasAccount");
    String name = renderRequest.getParameter("name");
    System.out.println(birthDay );
    Date date1= null;


%>

<aui:form action="<%= updateEmployeeActionURL %>" name="employeeForm" method="POST">


    <aui:input name="employeeId" type="hidden" value="<%=employeeId%>" >
        <aui:validator name="number"/>
    </aui:input>

    <aui:input name="name"  >
        <aui:validator name="required"  />
        <aui:validator name="string" />
    </aui:input>




    <input type="date" value="<%= date1%>" name="<portlet:namespace/>birthDay">birthDay<br>


    <b>Gender</b><br/>
    <input type="radio"
           <%if(gender.contains("0")){%>
           checked="checked"
            <%}%>
           name="<portlet:namespace/>gender" value="male">Male<br>
    <input type="radio"  <%if(gender.contains("1")){%>checked="checked"<%}%>  name="<portlet:namespace/>gender" value="female">Female<br/>

    <aui:input name="address"  >
        <aui:validator name="required"  />
        <aui:validator name="string" />
    </aui:input>



    <input type="checkbox"
           <%if
           (hasAccount.equals("true")){
            %>
           checked
            <%}%>
           name="<portlet:namespace/>hasAccount" value="true">HasAccount<br>


    <aui:button type="submit" name="" value="Submit"></aui:button>
</aui:form>