package com.ankush.listner;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

import com.ankush.entity.Car;

@Component
public class CarKafkaListner {

	@KafkaListener(topics = "CAR_OBJECT", containerGroup = "example-kafka-group", containerFactory = "carKafkaListenerFactorys")
	public void consumeEmployeeLeave(@Payload Car car) {
		try {
			System.out.println("object consumed : " + car.toString());
		} catch (Exception e) {

		}
	}

}
