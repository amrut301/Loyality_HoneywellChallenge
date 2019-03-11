package com.nec.demo.service;

import org.springframework.beans.factory.annotation.Autowired;

import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * @author amrmalaj
 *
 */
public abstract class AbstractBaseService {
	@Autowired
	protected ObjectMapper mapper;
//	@Autowired
//	protected BeanUtils beanUtil;
}
