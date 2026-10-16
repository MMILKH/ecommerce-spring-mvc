package com.ecommercespring.config;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class AppInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

    @Override
    protected Class<?>[] getRootConfigClasses() {

        try {
            return new Class<?>[] { AppConfig.class };
        } catch (Throwable t) {
            t.printStackTrace();
            throw t;
        }
    }

    @Override
    protected Class<?>[] getServletConfigClasses() {

        return new Class<?>[] { WebMvcConfig.class };
    }

    @Override
    protected String[] getServletMappings() {
        return new String[] { "/" };
    }
}