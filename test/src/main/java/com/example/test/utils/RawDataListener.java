package com.example.test.utils;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import java.io.IOException;

//@Component
public class RawDataListener {

	@KafkaListener(topics = {"${kafka.consumer.topic}"})
	public void listen(ConsumerRecord<?, ?> record) throws IOException {
		String value = (String) record.value();
		System.out.println(value);
	}
}
