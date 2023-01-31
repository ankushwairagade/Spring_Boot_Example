package com.ankush.kafkaservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.ankush.entity.Car;
import com.ankush.producer.CarKafkaProducer;

@SpringBootApplication
public class KafkaServiceApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(KafkaServiceApplication.class, args);
	}

	@Autowired
	CarKafkaProducer carKafkaProducer;

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		Car car = new Car(1, "Tesla X1", "Tesla @Inc ", 80000.78);
		carKafkaProducer.sendCarToKafka(car, "CAR_OBJECT");
	}
}
