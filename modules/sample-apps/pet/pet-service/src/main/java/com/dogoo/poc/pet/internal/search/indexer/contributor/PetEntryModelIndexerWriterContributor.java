package com.dogoo.poc.pet.internal.search.indexer.contributor;

import com.dogoo.poc.pet.model.PetEntry;
import com.dogoo.poc.pet.service.PetEntryLocalService;
import com.liferay.portal.kernel.search.Document;
import com.liferay.portal.search.batch.BatchIndexingActionable;
import com.liferay.portal.search.batch.DynamicQueryBatchIndexingActionableFactory;
import com.liferay.portal.search.spi.model.index.contributor.ModelIndexerWriterContributor;
import com.liferay.portal.search.spi.model.index.contributor.helper.IndexerWriterMode;
import com.liferay.portal.search.spi.model.index.contributor.helper.ModelIndexerWriterDocumentHelper;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

@Component(
        immediate = true,
        property = "indexer.class.name=com.dogoo.poc.pet.model.PetEntry",
        service = ModelIndexerWriterContributor.class
)
public class PetEntryModelIndexerWriterContributor implements ModelIndexerWriterContributor<PetEntry>{
    @Override
    public void customize(BatchIndexingActionable batchIndexingActionable, ModelIndexerWriterDocumentHelper modelIndexerWriterDocumentHelper) {
        // we don't need to customize the batchIndexingActionable guy, just use as is.
        batchIndexingActionable.setPerformActionMethod((PetEntry pet) -> {
            Document document = modelIndexerWriterDocumentHelper.getDocument(pet);

            batchIndexingActionable.addDocuments(document);
        });
    }

    @Override
    public BatchIndexingActionable getBatchIndexingActionable() {
        return _dynamicQueryBatchIndexingActionableFactory.getBatchIndexingActionable(petEntityLocalService.getIndexableActionableDynamicQuery());
    }

    @Override
    public long getCompanyId(PetEntry pet) {
        return pet.getCompanyId();
    }

    @Override
    public IndexerWriterMode getIndexerWriterMode(PetEntry pet) {
        return IndexerWriterMode.UPDATE;
    }

    @Reference
    private PetEntryLocalService petEntityLocalService;

    @Reference
    private DynamicQueryBatchIndexingActionableFactory _dynamicQueryBatchIndexingActionableFactory;

}
