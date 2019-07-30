package com.example.test.controllers;


import com.example.test.utils.KafkaSender;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/chat")
@Api(value = "AdminUserController ")
public class TestUrlController {
	//@Autowired
	private KafkaSender kafkaSender;
	@ApiOperation(value = "测试")
	@ApiImplicitParams({@ApiImplicitParam(name = "userName", value = "用户名", required = true, dataType = "String"),
			@ApiImplicitParam(name = "password", value = "密码", required = true, dataType = "String")})
	@RequestMapping(value = "/poll-status", method = RequestMethod.GET)
	public String pollStatus() {
		return "测试测试poll-status";
	}

	@RequestMapping("/send")
	public String send(){
		kafkaSender.sendTest();
		return "已调用";
	}
}
