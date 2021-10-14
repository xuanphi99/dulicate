package com.poc.employee.internal.search.indexer.contributor;

import com.liferay.portal.kernel.search.Document;
import com.liferay.portal.kernel.search.Field;
import com.liferay.portal.search.spi.model.index.contributor.ModelDocumentContributor;
import com.poc.employee.constant.SearchField;
import com.poc.employee.model.EmployeeEntry;
import org.osgi.service.component.annotations.Component;

@Component(
        immediate = true,
        property = "indexer.class.name=com.poc.employee.model.EmployeeEntry",
        service = ModelDocumentContributor.class
)
public class EmployeeEntryModelDocumentContributor implements ModelDocumentContributor<EmployeeEntry>{
    @Override
    public void contribute(Document document, EmployeeEntry employeeEntry) {
        document.addText(Field.NAME, employeeEntry.getName());



        document.addDate(SearchField.BIRTHDAY, employeeEntry.getBirthDay());
        document.addDateSortable(SearchField.BIRTHDAY,employeeEntry.getBirthDay());

        document.addNumber(SearchField.GENDER, employeeEntry.getGender());
        document.addNumberSortable(SearchField.GENDER, employeeEntry.getGender());

        document.addText(SearchField.ADDRESS, employeeEntry.getAddress());
        document.addKeywordSortable(SearchField.ADDRESS,employeeEntry.getAddress());

        document.addKeyword(SearchField.HAS_ACCOUNT,employeeEntry.getHasAccount());
        document.addKeywordSortable(SearchField.HAS_ACCOUNT,employeeEntry.getHasAccount());

    }
}
