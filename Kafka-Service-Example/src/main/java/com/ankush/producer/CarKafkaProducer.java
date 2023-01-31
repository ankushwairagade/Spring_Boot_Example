package com.ankush.producer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

import com.ankush.entity.Car;

@Component
public class CarKafkaProducer {

	@Autowired
	private KafkaTemplate<String, Car> carTemplate;
	
	public void sendCarToKafka(Car car, String kafkaTopic)
	{	
		carTemplate.send(kafkaTopic, car);
		carTemplate.flush();
	}
}
