package org.arunm;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.web.FilterInvocation;
import org.springframework.security.web.access.intercept.FilterInvocationSecurityMetadataSource;

public class MyFilterSecurityMetadataSource implements FilterInvocationSecurityMetadataSource {

public List<ConfigAttribute> getAttributes(Object object) {
    FilterInvocation fi = (FilterInvocation) object;
    String fullRequestUrl = fi.getFullRequestUrl();
    String requestUrl = fi.getRequestUrl();
    String httpMethod = fi.getRequest().getMethod();
    String contextPath = fi.getRequest().getContextPath();
    System.out.println("Full request URL: " + fullRequestUrl);
    System.out.println("Request URL: " + requestUrl);
    System.out.println("HTTP Method: " + httpMethod);
    System.out.println("Context path: " + contextPath);
    List<ConfigAttribute> configAttributes = new ArrayList<ConfigAttribute>(0);
    // Lookup your database (or other source) using this information and populate the
    // list of attributes

    return configAttributes;
}

public Collection<ConfigAttribute> getAllConfigAttributes() {
    return null;
}

public boolean supports(Class<?> clazz) {
    return FilterInvocation.class.isAssignableFrom(clazz);
}
}
