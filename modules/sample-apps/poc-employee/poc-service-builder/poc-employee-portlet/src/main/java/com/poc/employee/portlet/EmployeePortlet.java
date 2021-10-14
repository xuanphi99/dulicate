package com.poc.employee.portlet;

import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.poc.employee.constants.EmployeePortletKeys;

import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;

import javax.portlet.*;

import com.poc.employee.model.EmployeeEntry;
import com.poc.employee.service.EmployeeEntryLocalService;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * @author phidx
 */
@Component(
	immediate = true,
	property = {
		"com.liferay.portlet.display-category=category.sample",
		"com.liferay.portlet.instanceable=true",
		"javax.portlet.init-param.template-path=/",
		"javax.portlet.init-param.view-template=/view.jsp",
		"javax.portlet.name=" + EmployeePortletKeys.Employee,
		"javax.portlet.resource-bundle=content.Language",
		"javax.portlet.security-role-ref=power-user,user"
	},
	service = Portlet.class
)
public class EmployeePortlet extends MVCPortlet {

	@Reference
	EmployeeEntryLocalService employeeEntryLocalService;

	@Override
	public void render(RenderRequest renderRequest, RenderResponse renderResponse) throws IOException, PortletException {
		List<EmployeeEntry> studentList = employeeEntryLocalService.getEmployeeEntries(QueryUtil.ALL_POS, QueryUtil.ALL_POS);


		renderRequest.setAttribute("employeeList", studentList);

		super.render(renderRequest, renderResponse);
	}


	@ProcessAction(name = "addEmployee")
	public void addStudent(ActionRequest actionRequest, ActionResponse actionResponse) {
		String pattern = "yyyy-MM-dd hh:mm:ss";

		String name = ParamUtil.getString(actionRequest, "name");
		Date birthDay = ParamUtil.getDate(actionRequest, "birthDay", new SimpleDateFormat(pattern));
		String gender = ParamUtil.getString(actionRequest, "gender");
		String address = ParamUtil.getString(actionRequest, "address");
		String hasAccount = ParamUtil.getString(actionRequest, "hasAccount");

		employeeEntryLocalService.addEmployee(
				name,
				birthDay,
				gender.equals("male") ? 0 : 1,
				address,
				!hasAccount.equals(""),
				getContext());


	}

	private ServiceContext getContext() {
		ServiceContext serviceContext = new ServiceContext();

		serviceContext.setCompanyId(serviceContext.getCompanyId());
		serviceContext.setUserId(serviceContext.getUserId());
		serviceContext.setScopeGroupId(serviceContext.getScopeGroupId());
		return serviceContext;
	}


	@ProcessAction(name = "deleteStudent")
	public void deleteEmployee(ActionRequest actionRequest, ActionResponse actionResponse) throws PortalException {
		long employeeId = ParamUtil.getLong(actionRequest, "employeeId", GetterUtil.DEFAULT_LONG);

			employeeEntryLocalService.deleteEmployeeEntry(employeeId);

	}


	@ProcessAction(name = "updateEmployee")
	public void updateStudent(ActionRequest actionRequest, ActionResponse actionResponse) throws PortalException {
		String name = ParamUtil.getString(actionRequest, "name",GetterUtil.DEFAULT_STRING);
		Date birthDay = ParamUtil.getDate(actionRequest, "birthDay", new SimpleDateFormat("yyyy-MM-dd") {
		});
		String gender = ParamUtil.getString(actionRequest, "gender",GetterUtil.DEFAULT_STRING);
		String address = ParamUtil.getString(actionRequest, "address",GetterUtil.DEFAULT_STRING);
		String hasAccount = ParamUtil.getString(actionRequest, "hasAccount",GetterUtil.DEFAULT_STRING);

		employeeEntryLocalService.updateEmployee(
				ParamUtil.getLong(actionRequest, "employeeId", GetterUtil.DEFAULT_LONG),
				name,
				birthDay,
				gender.equals("male") ? 0 : 1,
				address,
				!hasAccount.equals(""),
				getContext());


	}

}