package com.sap.jnc.marketing;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration.Dynamic;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.concurrent.ConcurrentMapCacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Scope;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.context.request.RequestContextListener;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class SpringStarter extends AbstractAnnotationConfigDispatcherServletInitializer {

	public static final String APP_NAMESPACE = "com.sap.jnc.marketing";

	public static final String WEB_NAMESPACE = "com.sap.jnc.marketing";

	/*
	 * Root Config
	 */

	@Override
	protected Class<?>[] getRootConfigClasses() {
		return new Class[] { SpringAppConfig.class };
	}

	@Configuration
	@ComponentScan(basePackages = SpringStarter.APP_NAMESPACE)
	@EnableTransactionManagement
	@EnableScheduling
	@EnableCaching
	@EnableJpaRepositories(transactionManagerRef = "annotationDrivenTransactionManager")
	public static class SpringAppConfig {

		@Bean
		@Scope(ConfigurableBeanFactory.SCOPE_SINGLETON)
		@Primary
		@Lazy(false)
		public CacheManager cacheManager() {
			return new ConcurrentMapCacheManager();
		}
	}

	/*
	 * Servlet Config
	 */

	@Override
	protected Class<?>[] getServletConfigClasses() {
		return new Class[] { SpringWebConfig.class };
	}

	@Configuration
	@ComponentScan(basePackages = { SpringStarter.WEB_NAMESPACE })
	@EnableWebMvc
	public static class SpringWebConfig extends WebMvcConfigurerAdapter {

	}

	/*
	 * Servlet Mappings
	 */

	@Override
	protected String[] getServletMappings() {
		return new String[] { "/api/*" };
	}

	@Override
	public void onStartup(ServletContext servletContext) throws ServletException {
		servletContext.addListener(RequestContextListener.class);
		super.onStartup(servletContext);
	}

	/**
	 * In a spring 3.2 / servlet 3 environment, you will have some variety of DispatcherServlet initializer class which is the java
	 * equivalent of web.xml; in my case it's the AbstractAnnotationConfigDispatcherServletInitializer. Adding the following code will
	 * enable dispatchOptionsRequest:
	 */
	@Override
	protected void customizeRegistration(Dynamic registration) {
		registration.setInitParameter("dispatchOptionsRequest", "true");
	}
}