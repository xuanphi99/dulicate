package com.dogoo.authz.rest.jwt;

import com.dogoo.authz.constant.ClaimsKeys;
import com.liferay.petra.string.StringPool;
import com.liferay.portal.kernel.model.Role;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.service.UserLocalService;
import com.liferay.portal.kernel.util.Accessor;
import com.liferay.portal.kernel.util.ListUtil;
import io.jsonwebtoken.Claims;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

@Component(immediate = true, service = ClaimsUtils.class)
public class ClaimsUtils {

    public Claims buildClaims(long companyId, String userName, Claims claims) {
        User user = userLocalService.fetchUserByScreenName(companyId, userName);

        claims.put(ClaimsKeys.USER_ID, user.getUserId());
        claims.put(ClaimsKeys.USER_SCR_NAME, user.getScreenName());
        claims.put(ClaimsKeys.USER_EMAIL, user.getEmailAddress());
        claims.put(ClaimsKeys.USER_ROLES, ListUtil.toString(user.getRoles(), ROLE_VALUE_ACCESSOR, StringPool.COMMA));

        return claims;
    }

    protected static final Accessor<Role, String> ROLE_VALUE_ACCESSOR = new Accessor<Role, String>() {
        @Override
        public String get(Role role) {
            return role.getName();
        }
        @Override
        public Class<String> getAttributeClass() {
            return String.class;
        }
        @Override
        public Class<Role> getTypeClass() {
            return Role.class;
        }
    };


    @Reference
    private UserLocalService userLocalService;
}
