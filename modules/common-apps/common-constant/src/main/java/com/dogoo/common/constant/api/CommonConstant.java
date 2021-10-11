package com.dogoo.common.constant.api;

import org.osgi.service.component.annotations.Component;

/**
 * @author khoavu
 */

@Component(immediate = true, service = CommonConstant.class)
public class CommonConstant {
    public static final String TOKEN_HEADER_KEY = "dogoo-x-user-context-request";
}