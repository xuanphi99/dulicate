package com.dogoo.poc.pet.internal.search.indexer.contributor;

import com.dogoo.poc.pet.constant.SearchField;
import com.dogoo.poc.pet.model.PetEntry;
import com.liferay.portal.kernel.search.Document;
import com.liferay.portal.kernel.search.Field;
import com.liferay.portal.search.spi.model.index.contributor.ModelDocumentContributor;
import org.osgi.service.component.annotations.Component;

@Component(
        immediate = true,
        property = "indexer.class.name=com.dogoo.poc.pet.model.PetEntry",
        service = ModelDocumentContributor.class
)public class PetEntryModelDocumentContributor implements ModelDocumentContributor<PetEntry>{
    @Override
    public void contribute(Document document, PetEntry pet) {
        document.addText(Field.NAME, pet.getName());

        document.addText(SearchField.TAG, pet.getTag());
        document.addKeywordSortable(SearchField.TAG, pet.getTag());

        document.addText(SearchField.STATUS, pet.getStatus());
        document.addKeywordSortable(SearchField.STATUS, pet.getStatus());

        document.addDate(SearchField.STATUS_DATE, pet.getStatusDate());
        document.addDateSortable(SearchField.STATUS_DATE, pet.getStatusDate());

        document.addKeyword(SearchField.CREATOR_ID, pet.getCreatorId());
        document.addKeyword(SearchField.SCOPE_ORG_ID, pet.getScopeOrgId());

    }
}
