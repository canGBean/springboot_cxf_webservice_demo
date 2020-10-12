package com.jde.ws.jdebpmws.config;


import com.jde.ws.jdebpmws.service.FooService;
import org.apache.cxf.Bus;
import org.apache.cxf.jaxws.EndpointImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.xml.ws.Endpoint;

@Configuration
public class CxfConfig {

	@Autowired
	private Bus bus;

	@Autowired
	private FooService fooService;

	@Bean
	public Endpoint fooServiceEndpoint() {
		EndpointImpl endpoint = new EndpointImpl(bus, fooService);
		endpoint.publish("/fooService");
		return endpoint;
	}
}
