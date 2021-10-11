package com.dogoo.employee.rest.internal.resource.v1_0;

import com.dogoo.employee.rest.dto.v1_0.Employee;
import com.dogoo.employee.rest.internal.service.EmployeeService;
import com.dogoo.employee.rest.internal.validator.EmployeeValidator;
import com.dogoo.employee.rest.resource.v1_0.EmployeeResource;

import com.liferay.portal.kernel.service.ServiceContext;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;
import org.osgi.service.component.annotations.ServiceScope;

import javax.validation.constraints.NotNull;

/**
 * @author longnv
 */
@Component(
	properties = "OSGI-INF/liferay/rest/v1_0/employee.properties",
	scope = ServiceScope.PROTOTYPE, service = EmployeeResource.class
)
public class EmployeeResourceImpl extends BaseEmployeeResourceImpl {

	@Override
	public void deleteEmployee(@NotNull String employeeId) throws Exception{
		employeeValidator.validatorEmployeeIsExists(employeeId);

		employeeService.deleteEmployee(employeeId);
	}

	@Override
	public Employee addEmployee(Employee employee) throws Exception{
		employeeValidator.valiadatorForAddEmployee(employee);

		return employeeService.postEmployee(employee, getServiceContext());
	}

	@Override
	public Employee getEmployee(@NotNull String employeeId) throws Exception{
		employeeValidator.validatorEmployeeIsExists(employeeId);

		return employeeService.getEmployee(employeeId);
	}

	@Override
	public Employee putEmployee(@NotNull String employeeId,Employee employee)throws Exception{
		employeeValidator.validatorForUpdateEmployee(employeeId,employee);

		return employeeService.putEmployee(employeeId,employee,getServiceContext());
	}

	public ServiceContext getServiceContext(){
		ServiceContext serviceContext = new ServiceContext();

		serviceContext.setCompanyId(contextCompany.getCompanyId());
		serviceContext.setUserId(contextUser.getUserId());
		serviceContext.setScopeGroupId(contextUser.getGroupId());

		return serviceContext;
	}

	@Reference
	private EmployeeService employeeService;

	@Reference
	private EmployeeValidator employeeValidator;
}