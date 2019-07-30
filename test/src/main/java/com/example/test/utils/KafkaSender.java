package com.example.test.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

//@Component
public class KafkaSender {
	@Autowired
	private KafkaTemplate kafkaTemplate;

	/**
	 * 发送消息到kafka,主题为test
	 */
	public void sendTest(){
		kafkaTemplate.send("result_test","hello,key","hello,kafka  "  + LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SSS")));
	}
}
