package com.poc.employee.internal.search.indexer.contributor;

import com.liferay.portal.kernel.search.Document;
import com.liferay.portal.search.batch.BatchIndexingActionable;
import com.liferay.portal.search.batch.DynamicQueryBatchIndexingActionableFactory;
import com.liferay.portal.search.spi.model.index.contributor.ModelIndexerWriterContributor;
import com.liferay.portal.search.spi.model.index.contributor.helper.IndexerWriterMode;
import com.liferay.portal.search.spi.model.index.contributor.helper.ModelIndexerWriterDocumentHelper;
import com.poc.employee.model.EmployeeEntry;
import com.poc.employee.service.EmployeeEntryLocalService;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

@Component(
        immediate = true,
        property = "indexer.class.name=com.poc.employee.model.EmployeeEntry",
        service = ModelIndexerWriterContributor.class
)
public class EmployeeEntryModelIndexerWriterContributor implements  ModelIndexerWriterContributor<EmployeeEntry>{
    @Override
    public void customize(BatchIndexingActionable batchIndexingActionable, ModelIndexerWriterDocumentHelper modelIndexerWriterDocumentHelper) {
        batchIndexingActionable.setPerformActionMethod((EmployeeEntry employeeEntry) -> {
            Document document = modelIndexerWriterDocumentHelper.getDocument(employeeEntry);

            batchIndexingActionable.addDocuments(document);
        });
    }

    @Override
    public BatchIndexingActionable getBatchIndexingActionable()
    {

            return _dynamicQueryBatchIndexingActionableFactory.getBatchIndexingActionable(employeeEntityLocalService.getIndexableActionableDynamicQuery());
    }

    @Override
    public long getCompanyId(EmployeeEntry baseModel) {
        return 0;
    }

    @Override
    public IndexerWriterMode getIndexerWriterMode(EmployeeEntry baseModel) {
        return IndexerWriterMode.UPDATE;
    }

    @Override
    public void modelIndexed(EmployeeEntry baseModel) {
        ModelIndexerWriterContributor.super.modelIndexed(baseModel);
    }

    @Reference
    private EmployeeEntryLocalService employeeEntityLocalService;

    @Reference
    private DynamicQueryBatchIndexingActionableFactory _dynamicQueryBatchIndexingActionableFactory;



}
