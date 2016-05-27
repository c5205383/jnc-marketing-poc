package com.sap.jnc.marketing.persistence.context.datasource.hana;

import javax.sql.DataSource;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Scope;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.stereotype.Component;

import com.sap.jnc.marketing.persistence.context.datasource.DataSourceContext;

/**
 * Implementing a simple JPA based persistence sample application for SAP HANA Cloud.
 */

@Component
@Primary
@Scope(ConfigurableBeanFactory.SCOPE_SINGLETON)
public class HanaDataSourceContext implements DataSourceContext {

	protected static DriverManagerDataSource hanaDataSource;

	protected static final String DRIVER_NAME = "com.sap.db.jdbc.Driver";
	protected static final String URL = "jdbc:sap://%s:%s/";
	protected static final String DEFAULT_HOST = "120.76.155.38";
	protected static final String DEFAULT_PORT = "30015";

	@Override
	public synchronized DataSource getDataSource() {
		if (hanaDataSource == null) {
			hanaDataSource = new DriverManagerDataSource();
			// Set properties
			hanaDataSource.setDriverClassName(this.getDriverName());
			hanaDataSource.setUrl(this.getUrl());
			hanaDataSource.setUsername(this.getUsername());
			hanaDataSource.setPassword(this.getPassword());
		}
		return hanaDataSource;
	}

	public String getDriverName() {
		return DRIVER_NAME;
	}

	public String getUrl() {
		return String.format(URL, this.getHost(), this.getPort());
	}

	public String getHost() {
		return DEFAULT_HOST;
	}

	public String getPort() {
		return DEFAULT_PORT;
	}

	public String getUsername() {
		return "XWECHAT";
	}

	public String getPassword() {
		return "Welcome2";
	}

}
