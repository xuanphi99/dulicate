package com.dogoo.employee.rest.internal.mapper;

import com.dogoo.employee.rest.dto.v1_0.Employee;
import com.liferay.portal.kernel.exception.PortalException;
import com.poc.employee.model.EmployeeEntry;
import org.osgi.service.component.annotations.Component;

@Component(immediate = true, service = com.dogoo.employee.rest.internal.mapper.EmployeeMapper.class)
public class EmployeeMapper {

    public Employee mapFromEmployeeEntryToEmployee(EmployeeEntry from) throws PortalException {
        Employee to = new Employee();

        to.setId(from.getEmployeeId());
        to.setAddress(from.getAddress());
        to.setBirthDay(from.getBirthDay());
        to.setGender(from.getGender());
        to.setName(from.getName());
        to.setHasAccount(from.isHasAccount());
        return to;
    }
}
