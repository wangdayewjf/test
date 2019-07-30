package com.example.test;

import com.example.test.beans.YunXinRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.kafka.transaction.KafkaTransactionManager;
@SpringBootApplication
@ComponentScan({ "com.example" })
public class TestApplication {

	public static void main(String[] args) {
		try {

			SpringApplication.run(TestApplication.class, args);

			YunXinRequest yunXinRequest = new YunXinRequest();
			yunXinRequest.getCheckSum();

		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

}
