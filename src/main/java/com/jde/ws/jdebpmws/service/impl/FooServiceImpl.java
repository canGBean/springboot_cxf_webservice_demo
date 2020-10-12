package com.jde.ws.jdebpmws.service.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.jde.ws.jdebpmws.Foo;
import com.jde.ws.jdebpmws.FooDao;
import com.jde.ws.jdebpmws.service.FooService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.jws.WebService;


@WebService(serviceName = "fooService"
		, targetNamespace = "http://jdebpmws.ws.jde.com/"
		, endpointInterface = "com.jde.ws.jdebpmws.service.FooService")
@Service
@Slf4j
public class FooServiceImpl implements FooService {

	@Autowired
	private FooDao fooDao;


	@Override
	public String queryFooBean(Long id) {
		ObjectMapper mapper = new ObjectMapper();
		Foo foo = fooDao.queryFooBean(id);
		String resJson = "{\"code\":\"%s\", \"data\":%s}";
		if (null != foo) {
			try {
				String fooJson = mapper.writeValueAsString(foo);
				resJson = String.format(resJson, "200", fooJson);
			} catch (Exception e) {
				resJson = String.format(resJson, "0", e.toString());
				e.printStackTrace();
				log.error(e.toString());
			}
		} else {
			resJson = String.format(resJson, "0", "");
		}
		return resJson;
	}


	@Override
	public String insertFooBean() {
		fooDao.insertData();
		return "OK";
	}
}
