package com.dogoo.employee.rest.internal.validator;

import com.dogoo.employee.rest.dto.v1_0.Employee;
import com.liferay.portal.vulcan.pagination.Pagination;
import com.poc.employee.model.EmployeeEntry;
import com.poc.employee.service.EmployeeEntryLocalService;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import javax.ws.rs.BadRequestException;
import javax.ws.rs.NotFoundException;

@Component(immediate = true, service = com.dogoo.employee.rest.internal.validator.EmployeeValidator.class)
public class EmployeeValidator {
    private static final String EMPLOYEE_NOT_FOUND = "Not found Employee";
    private static final String NAME_REQUEST = "Employee Name is requested";
    private static final String BIRTHDAY_REQUEST = "Birthday is requested";
    private static final String GENDER_REQUEST = "Gender is requested";
    private static final String ADDRESS_REQUEST = "Address is requested";
    private static final String HAS_ACCOUNT_REQUEST = "Has account is requested";
    private static final String FIELDS_FOR_PATCH_REQUEST = "Fields for patch is requested";
    private static final String PAGE_SIZE_MAX = "page-size-is-greater-than-x";

    public void validatorForSearch(Pagination pagination) {
        if (pagination.getPageSize() > 250) {
            throw new BadRequestException(String.format(PAGE_SIZE_MAX, 250));
        }

    }

    public void valiadatorForAddEmployee(Employee employee) {
        checkRequiredField(employee.getName(),NAME_REQUEST);
        checkRequiredField(employee.getAddress(),ADDRESS_REQUEST);
        checkRequiredField(employee.getBirthDay().toString(),BIRTHDAY_REQUEST);
        checkRequiredField(employee.getGender().toString(),GENDER_REQUEST);
        checkRequiredField(employee.getHasAccount().toString(), HAS_ACCOUNT_REQUEST);
    }

    public void validatorForUpdateEmployee(String employeeId, Employee employee){
        validatorEmployeeIsExists(employeeId);

        checkRequiredField(employee.getName(),NAME_REQUEST);
        checkRequiredField(employee.getAddress(),ADDRESS_REQUEST);
        checkRequiredField(employee.getBirthDay().toString(),BIRTHDAY_REQUEST);
        checkRequiredField(employee.getGender().toString(),GENDER_REQUEST);
        checkRequiredField(employee.getHasAccount().toString(), HAS_ACCOUNT_REQUEST);
    }

    public void validatorEmployeeIsExists(String employeeId){
        EmployeeEntry employeeEntry = employeeEntryLocalService.fetchEmployeeEntry(employeeId);

        if(employeeEntry != null){
            return;
        }

        throw  new NotFoundException(EMPLOYEE_NOT_FOUND);
    }

    private void checkRequiredField(String value, String errorMsg) {
        if (null == value || value.trim().isEmpty()) {
            throw new BadRequestException(errorMsg);
        }
    }

    @Reference
    private EmployeeEntryLocalService employeeEntryLocalService;
}
