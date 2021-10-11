package com.dogoo.employee.rest.internal.mapper;

import com.dogoo.employee.rest.dto.v1_0.Employee;
import com.liferay.portal.kernel.exception.PortalException;
import com.poc.employee.model.EmployeeEntry;
import org.osgi.service.component.annotations.Component;
import java.text.SimpleDateFormat;

@Component(immediate = true, service = com.dogoo.employee.rest.internal.mapper.EmployeeMapper.class)
public class EmployeeMapper {
    private static final String PATTERN = "MM-dd-yyyy HH:mm:ss.SSSZ";


    public Employee mapFromEmployeeEntryToEmployee(EmployeeEntry from) throws PortalException {
        Employee to = new Employee();

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(PATTERN);
        to.setId(from.getEmployeeId());
        to.setAddress(from.getAddress());
        to.setBirthDay(from.getBirthDay());
        to.setGender(from.getGender());
        to.setName(from.getName());
        to.setHasAccount(from.isHasAccount());
        return to;
    }
}
