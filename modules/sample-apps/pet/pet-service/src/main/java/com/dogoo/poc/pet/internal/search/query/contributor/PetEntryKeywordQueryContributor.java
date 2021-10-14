package com.dogoo.poc.pet.internal.search.query.contributor;

import com.dogoo.poc.pet.constant.SearchField;
import com.liferay.portal.kernel.search.BooleanQuery;
import com.liferay.portal.kernel.search.Field;
import com.liferay.portal.kernel.search.SearchContext;
import com.liferay.portal.search.query.QueryHelper;
import com.liferay.portal.search.spi.model.query.contributor.KeywordQueryContributor;
import com.liferay.portal.search.spi.model.query.contributor.helper.KeywordQueryContributorHelper;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

@Component(
        immediate = true,
        property = "indexer.class.name=com.dogoo.poc.pet.model.PetEntry",
        service = KeywordQueryContributor.class
)public class PetEntryKeywordQueryContributor implements KeywordQueryContributor{
    @Override
    public void contribute(String keywords, BooleanQuery booleanQuery, KeywordQueryContributorHelper keywordQueryContributorHelper) {
        SearchContext searchContext =
                keywordQueryContributorHelper.getSearchContext();

        queryHelper.addSearchTerm(
                booleanQuery, searchContext, Field.NAME, true);

        queryHelper.addSearchTerm(
                booleanQuery, searchContext, SearchField.TAG, false);

        queryHelper.addSearchTerm(
                booleanQuery, searchContext, SearchField.STATUS, false);

        queryHelper.addSearchTerm(
                booleanQuery, searchContext, SearchField.STATUS_DATE, false);

        queryHelper.addSearchTerm(
                booleanQuery, searchContext, SearchField.CREATOR_ID, false);

        queryHelper.addSearchTerm(
                booleanQuery, searchContext, SearchField.SCOPE_ORG_ID, false);
    }

    @Reference
    protected QueryHelper queryHelper;
}
