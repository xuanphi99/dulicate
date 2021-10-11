package com.dogoo.employee.rest.resource.v1_0;

import com.dogoo.employee.rest.dto.v1_0.Employee;

import com.liferay.portal.kernel.service.GroupLocalService;
import com.liferay.portal.kernel.service.RoleLocalService;
import com.liferay.portal.vulcan.accept.language.AcceptLanguage;
import com.liferay.portal.vulcan.pagination.Page;

import java.util.Locale;

import javax.annotation.Generated;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

import org.osgi.annotation.versioning.ProviderType;

/**
 * To access this resource, run:
 *
 *     curl -u your@email.com:yourpassword -D - http://localhost:8080/o/dogoo/employee-rest-builder/v1.0
 *
 * @author longnv
 * @generated
 */
@Generated("")
@ProviderType
public interface EmployeeResource {

	public static Builder builder() {
		return FactoryHolder.factory.create();
	}

	public void deleteEmployee(String employeeId) throws Exception;

	public Response deleteEmployeeBatch(String callbackURL, Object object)
		throws Exception;

	public Employee getEmployee(String employeeId) throws Exception;

	public Employee putEmployee(String employeeId, Employee employee)
		throws Exception;

	public Response putEmployeeBatch(String callbackURL, Object object)
		throws Exception;

	public Page<Employee> getEmployees() throws Exception;

	public Employee addEmployee(Employee employee) throws Exception;

	public default void setContextAcceptLanguage(
		AcceptLanguage contextAcceptLanguage) {
	}

	public void setContextCompany(
		com.liferay.portal.kernel.model.Company contextCompany);

	public default void setContextHttpServletRequest(
		HttpServletRequest contextHttpServletRequest) {
	}

	public default void setContextHttpServletResponse(
		HttpServletResponse contextHttpServletResponse) {
	}

	public default void setContextUriInfo(UriInfo contextUriInfo) {
	}

	public void setContextUser(
		com.liferay.portal.kernel.model.User contextUser);

	public void setGroupLocalService(GroupLocalService groupLocalService);

	public void setRoleLocalService(RoleLocalService roleLocalService);

	public static class FactoryHolder {

		public static volatile Factory factory;

	}

	@ProviderType
	public interface Builder {

		public EmployeeResource build();

		public Builder checkPermissions(boolean checkPermissions);

		public Builder httpServletRequest(
			HttpServletRequest httpServletRequest);

		public Builder preferredLocale(Locale preferredLocale);

		public Builder user(com.liferay.portal.kernel.model.User user);

	}

	@ProviderType
	public interface Factory {

		public Builder create();

	}

}