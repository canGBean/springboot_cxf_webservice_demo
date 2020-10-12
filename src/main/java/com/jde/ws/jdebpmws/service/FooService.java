package com.jde.ws.jdebpmws.service;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;


@WebService(targetNamespace = "http://jdebpmws.ws.jde.com/")
public interface FooService {

	@WebMethod
	String queryFooBean(@WebParam(name = "id") Long id);

	@WebMethod
	String insertFooBean();
}
