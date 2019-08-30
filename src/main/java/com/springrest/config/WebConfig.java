package com.springrest.config;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class WebConfig extends AbstractAnnotationConfigDispatcherServletInitializer {
	
    protected Class<?>[] getRootConfigClasses() {
        return new Class[] { Config.class };
    }
  
    
    protected Class<?>[] getServletConfigClasses() {
        return null;
    }
  
    protected String[] getServletMappings() {
        return new String[] { "/" };
    }
}
