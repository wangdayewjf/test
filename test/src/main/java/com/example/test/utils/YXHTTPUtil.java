package com.example.test.utils;

import com.alibaba.fastjson.JSON;
import com.example.test.beans.YXTestShareMessage;
import com.example.test.beans.YunXinRequest;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Component
public class YXHTTPUtil {

	public  String post(String url, YunXinRequest yxRequest,List<NameValuePair> dataList) throws IOException {

		HttpClient httpClient = HttpClientBuilder.create().build();
		HttpPost httpPost = new HttpPost(url);

		String appKey = yxRequest.getAppKey();
		String nonce =  yxRequest.getNonce()+"";
		String curTime = yxRequest.getCurTime()+"";
		String checkSum = yxRequest.getCheckSum();

		// 设置请求的header
		httpPost.addHeader("AppKey", appKey);
		httpPost.addHeader("Nonce", nonce);
		httpPost.addHeader("CurTime", curTime);
		httpPost.addHeader("CheckSum", checkSum);
		httpPost.addHeader("Content-Type", "application/x-www-form-urlencoded;charset=utf-8");

		// 设置请求的参数
		httpPost.setEntity(new UrlEncodedFormEntity(dataList, "utf-8"));

		// 执行请求
		HttpResponse response = httpClient.execute(httpPost);

		// 打印执行结果
		return EntityUtils.toString(response.getEntity(), "utf-8");

	}

	public String YXQueryMessage(String url,Long beginTime,Long endTime,String from,String to) throws IOException {
		List<NameValuePair> dataList = new ArrayList<>();
		dataList.add(new BasicNameValuePair("begintime",beginTime+""));
		dataList.add(new BasicNameValuePair("endtime",endTime+""));
		dataList.add(new BasicNameValuePair("from",from));
		dataList.add(new BasicNameValuePair("to",to));
		dataList.add(new BasicNameValuePair("limit",10+""));
		return  post(url,new YunXinRequest(),dataList);
	}

	public String YXSendMessage(String url, String from, String to, YXTestShareMessage message) throws IOException {
		List<NameValuePair> dataList = new ArrayList<>();
		dataList.add(new BasicNameValuePair("from",from));
		dataList.add(new BasicNameValuePair("to",to));
		dataList.add(new BasicNameValuePair("type","100"));
		dataList.add(new BasicNameValuePair("body", JSON.toJSONString(message) ));
		dataList.add(new BasicNameValuePair("ope","0"));
		return post(url,new YunXinRequest(),dataList);
	}

//	public String YXBatchSendMessage(String url,){
//
//	}
}
