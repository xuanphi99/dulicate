package com.dogoo.poc.pet.internal.search.result.contributor;

import com.dogoo.poc.pet.constant.SearchField;
import com.liferay.portal.kernel.search.Document;
import com.liferay.portal.kernel.search.Field;
import com.liferay.portal.kernel.search.Summary;
import com.liferay.portal.search.spi.model.result.contributor.ModelSummaryContributor;
import org.osgi.service.component.annotations.Component;

import java.util.Locale;

@Component(
        immediate = true,
        property = "indexer.class.name=com.dogoo.poc.pet.model.PetEntry",
        service = ModelSummaryContributor.class
)
public class PetModelSummaryContributor implements ModelSummaryContributor{
    @Override
    public Summary getSummary(
            Document document, Locale locale, String snippet) {

        Summary summary = new Summary(
                document.get(Field.NAME),
                document.get(SearchField.STATUS));

        summary.setMaxContentLength(200);

        return summary;
    }
}
