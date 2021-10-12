package com.poc.employee.internal.search.query.contributor;

import com.liferay.portal.kernel.search.BooleanQuery;
import com.liferay.portal.kernel.search.Field;
import com.liferay.portal.kernel.search.SearchContext;
import com.liferay.portal.search.query.QueryHelper;
import com.liferay.portal.search.spi.model.query.contributor.KeywordQueryContributor;
import com.liferay.portal.search.spi.model.query.contributor.helper.KeywordQueryContributorHelper;
import com.poc.employee.constant.SearchField;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

@Component(
        immediate = true,
        property = "indexer.class.name=com.poc.employee.model.EmployeeEntry",
        service = KeywordQueryContributor.class
)
public class EmployeeEntryKeywordQueryContributor implements KeywordQueryContributor{

    @Reference
    protected QueryHelper queryHelper;

    @Override
    public void contribute(String keywords, BooleanQuery booleanQuery, KeywordQueryContributorHelper keywordQueryContributorHelper) {
        SearchContext searchContext =
                keywordQueryContributorHelper.getSearchContext();
        queryHelper.addSearchTerm(
                booleanQuery, searchContext, Field.NAME, true);
        queryHelper.addSearchTerm(
                booleanQuery, searchContext, SearchField.GENDER, true);
        queryHelper.addSearchTerm(
                booleanQuery, searchContext, SearchField.ADDRESS, false);
        queryHelper.addSearchTerm(
                booleanQuery, searchContext, SearchField.BIRTHDAY, false);
        queryHelper.addSearchTerm(
                booleanQuery, searchContext, SearchField.HAS_ACCOUNT, true);
    }
}
