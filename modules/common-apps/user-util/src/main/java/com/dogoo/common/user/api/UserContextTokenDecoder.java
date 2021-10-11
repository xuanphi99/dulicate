package com.dogoo.common.user.api;

import com.liferay.portal.kernel.json.JSONException;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import org.osgi.service.component.annotations.Component;

import java.util.Base64;

@Component(immediate = true, service = UserContextTokenDecoder.class)
public class UserContextTokenDecoder {
    private static final String USER_ID = "userId";
    private static final String SPLIT_TOKEN_BY = "\\.";
    private static final String ORG_IDS = "orgIds";
    private static final String ROLES = "roles";

    public long getUserId(String token) throws JSONException {
        return parseUserIdFromBody(decodeTokenBody(getEncodedTokenByBody(token)));
    }

    public long getOrgIds(String token) throws JSONException {

        return parseOrgIdsFromBody(decodeTokenBody(getEncodedTokenByBody(token)));
    }

    private long parseOrgIdsFromBody(String body) throws JSONException {

        JSONObject obj = JSONFactoryUtil.createJSONObject(body);

        return obj.getLong(ORG_IDS);
    }

    public String getRoles(String token) throws JSONException {
        return parseStringValueFromBody(decodeTokenBody(getEncodedTokenByBody(token)), ROLES);
    }

    private long parseUserIdFromBody(String body) throws JSONException {

        JSONObject obj = JSONFactoryUtil.createJSONObject(body);

        return obj.getLong(USER_ID);
    }

    private String parseStringValueFromBody(String body, String key) throws JSONException {
        JSONObject obj = JSONFactoryUtil.createJSONObject(body);

        return obj.getString(key);
    }

    private String getEncodedTokenByBody(String token) {
        String[] tokenArray = token.split(SPLIT_TOKEN_BY);

        return tokenArray[1];
    }

    private String decodeTokenBody(String encodedBody) {
        byte[] decodedBytes = Base64.getDecoder().decode(encodedBody);
        String decodedString = new String(decodedBytes);

        return decodedString;
    }

    /*Only for Test, will be remove*/
    public int sumService(int a, int b) {
        return a + b;
    }
}
