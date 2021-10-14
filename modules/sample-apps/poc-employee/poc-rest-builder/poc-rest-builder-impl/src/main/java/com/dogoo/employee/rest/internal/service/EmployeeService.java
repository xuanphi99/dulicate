package com.dogoo.employee.rest.internal.service;

import com.dogoo.employee.rest.dto.v1_0.Employee;
import com.dogoo.employee.rest.internal.mapper.EmployeeMapper;
import com.liferay.portal.kernel.search.Field;
import com.liferay.portal.kernel.search.Sort;
import com.liferay.portal.kernel.search.filter.Filter;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.GetterUtil;

import com.liferay.portal.vulcan.pagination.Page;
import com.liferay.portal.vulcan.pagination.Pagination;
import com.liferay.portal.vulcan.util.SearchUtil;
import com.poc.employee.model.EmployeeEntry;
import com.poc.employee.service.EmployeeEntryLocalService;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import java.util.Collections;

@Component(immediate = true, service = com.dogoo.employee.rest.internal.service.EmployeeService.class)
public class EmployeeService {

    public Page<Employee> getEmployees(String search, Filter filter,
                                       Pagination pagination, Sort[] sorts,
                                       ServiceContext serviceContext) throws Exception {
        return SearchUtil.search(
                Collections.emptyMap(),
                booleanQuery -> {
                },
                filter, EmployeeEntry.class, search, pagination,
                queryConfig -> queryConfig.setSelectedFieldNames(
                        Field.ENTRY_CLASS_PK), searchContext -> searchContext.setCompanyId(
                        serviceContext.getCompanyId()),
                sorts,
                document -> employeeMapper.mapFromEmployeeEntryToEmployee(
                        employeeEntryLocalService.getEmployeeEntry(
                                GetterUtil.getLong(document.get(Field.ENTRY_CLASS_PK)))));
    }

    public Employee postEmployee(Employee employee, ServiceContext serviceContext) throws Exception {
        EmployeeEntry employeeEntry = employeeEntryLocalService.addEmployee(employee.getName(), employee.getBirthDay(),
                employee.getGender(), employee.getAddress(), employee.getHasAccount(), serviceContext);
        return employeeMapper.mapFromEmployeeEntryToEmployee(employeeEntry);
    }

    public void deleteEmployee(long employeeId) throws Exception {
        employeeEntryLocalService.deleteEmployeeEntry(employeeId);
    }

    public Employee getEmployee(long employeeId) throws Exception {
        EmployeeEntry employeeEntry = employeeEntryLocalService.getEmployeeEntry(employeeId);

        return employeeMapper.mapFromEmployeeEntryToEmployee(employeeEntry);
    }

    public Employee putEmployee(long employeeId, Employee employee, ServiceContext serviceContext) throws Exception {
        EmployeeEntry employeeEntry = employeeEntryLocalService.
                updateEmployee(employeeId, employee.getName(), employee.getBirthDay(), employee.getGender(), employee.getAddress(), employee.getHasAccount(), serviceContext);

        return employeeMapper.mapFromEmployeeEntryToEmployee(employeeEntry);
    }

    @Reference
    private EmployeeMapper employeeMapper;

    @Reference
    private EmployeeEntryLocalService employeeEntryLocalService;

}
