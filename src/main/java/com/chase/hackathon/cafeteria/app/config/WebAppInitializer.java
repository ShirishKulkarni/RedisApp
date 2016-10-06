package com.chase.hackathon.cafeteria.app.config;

import javax.servlet.FilterRegistration;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

import com.chase.hackathon.cafeteria.app.security.SimpleCORSFilter;

public class WebAppInitializer implements WebApplicationInitializer {

	public void onStartup(ServletContext servletContext) throws ServletException {

		AnnotationConfigWebApplicationContext rootCtx = new AnnotationConfigWebApplicationContext();
		rootCtx.register(AppConfig.class);
		servletContext.addListener(new ContextLoaderListener(rootCtx));

		AnnotationConfigWebApplicationContext dispatcherContext = new AnnotationConfigWebApplicationContext();
		dispatcherContext.register(RestDispatcherServlet.class);
		ServletRegistration.Dynamic dispatcher = servletContext.addServlet("dispatcher",
				new DispatcherServlet(dispatcherContext));
		dispatcher.setLoadOnStartup(1);
		dispatcher.addMapping("/");

		/***
		 * SimpleCORSFilter config
		 */
		FilterRegistration.Dynamic shallowETagFilter = servletContext.addFilter("simpleCORSFilter",
				new SimpleCORSFilter());
		shallowETagFilter.addMappingForUrlPatterns(null, true, "/*");
		shallowETagFilter.setAsyncSupported(true);
	}

}
