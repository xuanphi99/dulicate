package com.dogoo.poc.pet.rest.internal.odata.v1_0;

import com.dogoo.poc.pet.constant.SearchField;
import com.liferay.portal.kernel.search.Field;
import com.liferay.portal.odata.entity.EntityField;
import com.liferay.portal.odata.entity.EntityModel;
import com.liferay.portal.odata.entity.StringEntityField;

import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * class PetEntityIndexModel: An important note - in order to support filtering on data or sorting on data,
 * the fields to allow must be listed in this entity model class.
 *
 * You don't need to have every field of your component class listed in here, you just need the ones that
 * will be used for filtering and sorting.
 */
public class PetEntityIndexModel implements EntityModel {

    public PetEntityIndexModel() {
        entityFieldsMap = Stream.of(
                // chemicalNames is a string array of the chemical names of the vitamins/minerals
                /** An example for case index array
                 new CollectionEntityField(
                 new StringEntityField(
                 "chemicalNames", locale -> Field.getSortableFieldName("chemicalNames"))),
                 **/

                // we'll support filtering based upon user creator id.
                //new IntegerEntityField("creatorId", locale -> Field.USER_ID),

                // sorting/filtering on name is okay too
                new StringEntityField(
                        Field.NAME, locale -> Field.getSortableFieldName(Field.NAME)),

                // as is sorting/filtering on tag
                new StringEntityField(
                        SearchField.TAG, locale -> Field.getSortableFieldName(SearchField.TAG_STRING)),

                new StringEntityField(
                        SearchField.STATUS, locale -> Field.getSortableFieldName(SearchField.STATUS_STRING)),

                new StringEntityField(
                        SearchField.STATUS_DATE, locale -> Field.getSortableFieldName(SearchField.STATUS_DATE))
        ).collect(
                Collectors.toMap(EntityField::getName, Function.identity())
        );
    }

    @Override
    public Map<String, EntityField> getEntityFieldsMap() {
        return entityFieldsMap;
    }

    private final Map<String, EntityField> entityFieldsMap;
}
