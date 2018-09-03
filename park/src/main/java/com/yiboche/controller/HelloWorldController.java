package com.yiboche.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 搭建环境测试
 * 
 * @author asus2016
 *
 */
@Controller
public class HelloWorldController {
	@RequestMapping(value = "/hello")
	@ResponseBody
	public String sayHello() {
		return "hello";
	}

}
