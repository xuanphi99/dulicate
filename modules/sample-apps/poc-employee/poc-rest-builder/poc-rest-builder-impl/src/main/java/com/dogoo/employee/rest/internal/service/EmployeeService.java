package com.dogoo.employee.rest.internal.service;

import com.dogoo.employee.rest.dto.v1_0.Employee;
import com.dogoo.employee.rest.internal.mapper.EmployeeMapper;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.vulcan.pagination.Page;
import com.poc.employee.model.EmployeeEntry;
import com.poc.employee.service.EmployeeEntryLocalService;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

@Component(immediate = true,service = com.dogoo.employee.rest.internal.service.EmployeeService.class)
public class EmployeeService {

    public Employee postEmployee(Employee employee, ServiceContext serviceContext) throws Exception{
        EmployeeEntry employeeEntry = employeeEntryLocalService.addEmployee(employee.getName(),employee.getBirthDay(),
                employee.getGender(),employee.getAddress(),employee.getHasAccount(),serviceContext);
        return employeeMapper.mapFromEmployeeEntryToEmployee(employeeEntry);
    }

    public void deleteEmployee(String employeeId)throws Exception{
        employeeEntryLocalService.deleteEmployeeEntry(employeeId);
    }

    public Employee getEmployee(String employeeId) throws  Exception{
        EmployeeEntry employeeEntry = employeeEntryLocalService.getEmployeeEntry(employeeId);

        return employeeMapper.mapFromEmployeeEntryToEmployee(employeeEntry);
    }

    public Employee putEmployee(String employeeId,Employee employee,ServiceContext serviceContext) throws Exception{
        EmployeeEntry employeeEntry = employeeEntryLocalService.
                updateEmployee(employeeId,employee.getName(),employee.getBirthDay(),employee.getGender(),employee.getAddress(),employee.getHasAccount(),serviceContext);

        return employeeMapper.mapFromEmployeeEntryToEmployee(employeeEntry);
    }

    @Reference
    private EmployeeMapper employeeMapper;

    @Reference
    private EmployeeEntryLocalService employeeEntryLocalService;

}
