
<%@ include file="init.jsp"%>
<portlet:defineObjects />

<portlet:actionURL name="addEmployee" var="addEmployeeActionURL"/>


<h2>Add Employee Form here !</h2>

<aui:form action="<%= addEmployeeActionURL %>" name="studentForm" method="POST">
    <aui:input name="name" >
        <aui:validator name="required"/>
        <aui:validator name="string"/>
    </aui:input>

<%--    <aui:input name="birthDay" >--%>
<%--        <aui:validator name="required"/>--%>
<%--        <aui:validator name="date"/>--%>
<%--    </aui:input>--%>

    <input type="date"  name="<portlet:namespace/>birthDay">birthDay<br>


    <b>Gender</b><br/>
    <input type="radio" name="<portlet:namespace/>gender" value="male">Male<br>
    <input type="radio" name="<portlet:namespace/>gender" value="female">Female<br/>

    <aui:input name="address" >
        <aui:validator name="required"/>
        <aui:validator name="string"/>
    </aui:input>

<%--    <aui:input name="hasAccount">--%>
<%--        <aui:validator name="required"/>--%>
<%--        <aui:validator name="custom"/>--%>
<%--    </aui:input>--%>
    <input type="checkbox"  name="<portlet:namespace/>hasAccount" value="true">HasAccount<br>

    <aui:button type="submit" name="" value="Submit"></aui:button>
</aui:form>