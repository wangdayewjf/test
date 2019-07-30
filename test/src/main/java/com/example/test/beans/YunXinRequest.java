package com.example.test.beans;


import com.example.test.utils.CheckSumBuilder;
import lombok.Data;
import org.springframework.context.annotation.Configuration;
import org.testng.annotations.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.Properties;

import static java.lang.System.currentTimeMillis;

@Data
public class YunXinRequest {
	private static String appKey;
	private static String appSecret;
	private  Long  nonce = currentTimeMillis();
	private String curTime = String.valueOf((new Date()).getTime() / 1000L);
	private String checkSum;


	static {
		Properties prop = new Properties();
		InputStream in = Object.class.getResourceAsStream("/application.properties");
		try {
			prop.load(in);
			appKey = prop.getProperty("yunxin.appKey").trim();
			appSecret = prop.getProperty("yunxin.appSecret").trim();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	/*
	注：此对象会有线程安全问题
	 */

	public static String getAppKey() {
		return appKey;
	}

	public static String getAppSecret() {
		return appSecret;
	}


	public  String getCheckSum() {
		String tem = CheckSumBuilder.getCheckSum(appSecret,nonce+"",this.curTime+"");
		return tem;
	}


}
