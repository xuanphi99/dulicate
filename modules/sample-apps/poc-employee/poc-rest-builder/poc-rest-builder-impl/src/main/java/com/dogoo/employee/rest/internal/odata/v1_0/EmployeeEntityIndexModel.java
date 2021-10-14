package com.dogoo.employee.rest.internal.odata.v1_0;

import com.liferay.portal.kernel.search.Field;
import com.liferay.portal.odata.entity.EntityField;
import com.liferay.portal.odata.entity.EntityModel;
import com.liferay.portal.odata.entity.StringEntityField;
import com.poc.employee.constant.SearchField;

import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class EmployeeEntityIndexModel implements EntityModel {

    public EmployeeEntityIndexModel() {
        entityFieldMap = Stream.of(
                new StringEntityField(
                        Field.NAME, locale -> Field.getSortableFieldName(Field.NAME)),

                new StringEntityField(
                        SearchField.ADDRESS, locale -> Field.getSortableFieldName(SearchField.ADDRESS)
                ),
                new StringEntityField(
                        SearchField.BIRTHDAY, locale -> Field.getSortableFieldName(SearchField.BIRTHDAY)
                ),
                new StringEntityField(
                        SearchField.GENDER, locale -> Field.getSortableFieldName(SearchField.GENDER)
                )
        ).collect(
                Collectors.toMap(EntityField::getName, Function.identity())
        );
    }

    @Override
    public Map<String, EntityField> getEntityFieldsMap() {
        return entityFieldMap;
    }

    private final Map<String, EntityField> entityFieldMap;

}
