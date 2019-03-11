package com.loyality.configuration;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.apache.camel.CamelContext;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.spring.javaconfig.CamelConfiguration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

/**
 * @author amrmalaj
 *
 */
@Configuration
public class LoyalityCamelConfiguration extends CamelConfiguration {

	@Autowired
	private CamelContext camelContext;

	@PostConstruct
	public void init() {
		if (null != camelContext && null != camelContext.getManagementStrategy()) {
			if (null != camelContext.getManagementStrategy().getManagementAgent()) {
				camelContext.getManagementStrategy().getManagementAgent().setCreateConnector(false);
			}
		}
	}

	@Override
	public List<RouteBuilder> routes() {
		List<RouteBuilder> routeBuilders = new ArrayList<>();

		return routeBuilders;
	}
}
