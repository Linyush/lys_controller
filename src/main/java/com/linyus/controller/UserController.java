package com.linyus.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.linyus.response.RspBean;

/**
 * create by eason on 2018年5月16日
 */
@RestController
@RequestMapping("/user")
public class UserController {
	
	private Logger logger = LoggerFactory.getLogger(getClass());

	@GetMapping("/index")
	public RspBean<String> index() {
		logger.info("index");
		return RspBean.success("index");
	}
}
