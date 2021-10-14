package com.dogoo.poc.pet.service.impl.test;

import com.dogoo.poc.pet.model.PetEntry;
import com.dogoo.poc.pet.service.PetEntryLocalService;
import com.liferay.arquillian.extension.junit.bridge.junit.Arquillian;
import com.liferay.portal.kernel.model.Group;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.test.rule.AggregateTestRule;
import com.liferay.portal.kernel.test.rule.DataGuard;
import com.liferay.portal.kernel.test.rule.DeleteAfterTestRun;
import com.liferay.portal.kernel.test.util.GroupTestUtil;
import com.liferay.portal.kernel.test.util.RandomTestUtil;
import com.liferay.portal.kernel.test.util.ServiceContextTestUtil;
import com.liferay.portal.kernel.test.util.TestPropsValues;
import com.liferay.portal.test.rule.Inject;
import com.liferay.portal.test.rule.LiferayIntegrationTestRule;
import org.junit.Assert;
import org.junit.Before;
import org.junit.ClassRule;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

@DataGuard(scope = DataGuard.Scope.METHOD)
@RunWith(Arquillian.class)
public class PetEntryLocalServiceTest {
    @ClassRule
    @Rule
    public static final AggregateTestRule aggregateTestRule =
            new LiferayIntegrationTestRule();

    @Before
    public void setUp() throws Exception {
        _group = GroupTestUtil.addGroup();
        _user = TestPropsValues.getUser();

        serviceContext =
                ServiceContextTestUtil.getServiceContext(
                        _group.getGroupId(), _user.getUserId());
    }


    @Test
    public void testAddPetEntry() throws Exception {
        int initialCount = _petLocalService.getPetEntriesCount();

        addPetEntry(_user.getUserId());

        int actualCount = _petLocalService.getPetEntriesCount();

        Assert.assertEquals(initialCount + 1, actualCount);
    }

    @Test
    public void testUpdatePet() throws Exception {
        PetEntry petEntry = addPetEntry(_user.getUserId());

        String petName = RandomTestUtil.randomString();
        String petTag = RandomTestUtil.randomString();

        PetEntry petEntryUpdated = _petLocalService.updatePet(petEntry.getPetId(),
                petName, petTag, "APPROVED", serviceContext);

        Assert.assertEquals(petName, petEntryUpdated.getName());
        Assert.assertEquals(petTag, petEntryUpdated.getTag());
        Assert.assertEquals("APPROVED", petEntryUpdated.getStatus());
        Assert.assertNotNull(petEntryUpdated.getStatusDate());
    }


    @Test
    public void testPathPet() throws Exception {
        PetEntry petEntry = addPetEntry(_user.getUserId());

        String petName = RandomTestUtil.randomString();
        String petTag = RandomTestUtil.randomString();

        PetEntry petEntryUpdated = _petLocalService.patchPet(petEntry.getPetId(),
                petName, petTag, "APPROVED", serviceContext);

        Assert.assertEquals(petName, petEntryUpdated.getName());
        Assert.assertEquals(petTag, petEntryUpdated.getTag());
        Assert.assertEquals("APPROVED", petEntryUpdated.getStatus());
        Assert.assertNotNull(petEntryUpdated.getStatusDate());
    }


    protected PetEntry addPetEntry(long userId)
            throws Exception {
        ServiceContext serviceContext =
                ServiceContextTestUtil.getServiceContext(
                        _group.getGroupId(), userId);

        return _petLocalService.addPet(RandomTestUtil.randomString(), RandomTestUtil.randomString(),
                RandomTestUtil.randomLong(), RandomTestUtil.randomLong(), serviceContext);

    }

    @DeleteAfterTestRun
    private Group _group;

    @Inject
    private PetEntryLocalService _petLocalService;

    private User _user;

    private  ServiceContext serviceContext;
}
