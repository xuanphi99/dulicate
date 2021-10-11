package com.dogoo.common.user.api;

import com.dogoo.common.user.model.CreatorModel;
import com.liferay.petra.string.StringPool;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.model.Group;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.service.UserLocalService;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.Portal;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

/**
 * @author khoavu
 */

@Component(immediate = true, service = UserUtil.class)
public class UserUtil {
    public CreatorModel getCreatorModel(String tokenContext) throws PortalException {

        CreatorModel creator = new CreatorModel();

        long userId = tokenDecoder.getUserId(tokenContext);

        User user = userLocalService.getUser(userId);

        creator.setScopeOrgIds(tokenDecoder.getOrgIds(tokenContext));
        creator.setRoles(tokenDecoder.getRoles(tokenContext));

        creator.setAdditionalName(user.getMiddleName());
        creator.setFamilyName(user.getLastName());
        creator.setGivenName(user.getFirstName());
        creator.setId(user.getUserId());
        creator.setName(user.getFullName());
        creator.setImage(getUserImage(portal, user));
        creator.setProfileURL(getProfileURL(user));

        return creator;
    }

    private String getUserImage(Portal portal, User user) throws PortalException {
        if (user.getPortraitId() == 0) {
            return null;
        }

        ThemeDisplay themeDisplay = new ThemeDisplay();
        themeDisplay.setPathImage(portal.getPathImage());

        return user.getPortraitURL(themeDisplay);
    }

    private static String getProfileURL(User user) {
        Group group = user.getGroup();

        ThemeDisplay themeDisplay = new ThemeDisplay();
        themeDisplay.setPortalURL(StringPool.BLANK);
        themeDisplay.setSiteGroupId(group.getGroupId());

        return group.getDisplayURL(themeDisplay);
    }

    @Reference
    private Portal portal;

    @Reference
    private UserLocalService userLocalService;

    @Reference
    private UserContextTokenDecoder tokenDecoder;
}