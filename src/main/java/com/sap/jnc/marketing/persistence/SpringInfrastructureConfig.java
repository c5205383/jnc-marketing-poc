package com.sap.jnc.marketing.persistence;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

public class SpringInfrastructureConfig {

	public static final String APP_NAMESPACE = "com.sap.moremobile.infrastructure";

	/*
	 * Root Config
	 */

	@Configuration
	@ComponentScan(basePackages = SpringInfrastructureConfig.APP_NAMESPACE)
	@EnableTransactionManagement
	@EnableJpaRepositories(transactionManagerRef = "annotationDrivenTransactionManager")
	public static class SpringAppConfig {
	}
}