package com.example.test.controllers;


import com.example.test.beans.YXTestShareMessage;
import com.example.test.beans.YunXinRequest;
import com.example.test.utils.KafkaSender;
import com.example.test.utils.YXHTTPUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.Calendar;
import java.util.Date;

@RestController
@RequestMapping("/chat")
@Api(value = "AdminUserController ")
public class TestUrlController {
	//@Autowired
	private KafkaSender kafkaSender;
	@Autowired
	private YXHTTPUtil yXHTTPUtil;
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

	@RequestMapping("/account")
	public String CreateAcount(){
		YunXinRequest yunXinRequest = new YunXinRequest();
		yunXinRequest.getCheckSum();

		return "重新获取";
	}

	@RequestMapping("/oldmessage")
	public String getOldMessage(){
		String url = "https://api.netease.im/nimserver/history/querySessionMsg.action";

		Date nowDate=new Date();
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(nowDate);
		calendar.add(Calendar.DAY_OF_MONTH, -1);
		Date beforeDate = calendar.getTime();
		Long begainTime =beforeDate.getTime();
		Long endTime = nowDate.getTime();
		try {
			return yXHTTPUtil.YXQueryMessage(url,begainTime,endTime,"zhangsan","wjf");
		} catch (IOException e) {
			 e.printStackTrace();
			 return  e.getMessage();
		}
	}

	@RequestMapping("/yXSendMessage")
	public String YXSendMessage(){
		String url = "https://api.netease.im/nimserver/msg/sendMsg.action";
		YXTestShareMessage selfMessage = new YXTestShareMessage();
		selfMessage.setContent("内容内容");
		selfMessage.setTitle("标题标题");
		selfMessage.setArticleUrl("www.baidu.com");
		selfMessage.setMinImgUrl("www.baidu.com");
		try {
			return yXHTTPUtil.YXSendMessage(url,"zhangsan","wjf",selfMessage);
		} catch (IOException e) {
			e.printStackTrace();
			return  e.getMessage();
		}
	}


}
