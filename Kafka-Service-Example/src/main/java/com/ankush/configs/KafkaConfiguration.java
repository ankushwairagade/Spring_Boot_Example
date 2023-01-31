package com.ankush.configs;

import java.util.HashMap;
import java.util.Map;

import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.apache.kafka.common.serialization.StringSerializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;
import org.springframework.kafka.core.DefaultKafkaProducerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.core.ProducerFactory;
import org.springframework.kafka.support.serializer.JsonDeserializer;
import org.springframework.kafka.support.serializer.JsonSerializer;

import com.ankush.entity.Car;

@EnableKafka
@Configuration
public class KafkaConfiguration {

	String kafkaserverIp = "localhost:9092";
	String consumerName = "example-kafka-group";
	String securityProtocol = "PLAINTEXT";
	String saslMechanism = "PLAIN";
	String jaasConfig = null;

	
	// Producers
	
	@Bean
	public ProducerFactory<String, Car> carProducerFactory() {
		Map<String, Object> config = new HashMap<>();

		config.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, kafkaserverIp);
		config.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
		config.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, JsonSerializer.class);
		config.put("security.protocol", securityProtocol);
		config.put("sasl.mechanism", saslMechanism);
		config.put("sasl.jaas.config", jaasConfig);
		return new DefaultKafkaProducerFactory<>(config);
	}

	@Bean
	public KafkaTemplate<String, Car> carTemplate() {
		return new KafkaTemplate<>(carProducerFactory());
	}
	

	
	//  Consumer 
	
	@Bean
	public ConsumerFactory<String, Car> carConsumerFactorys() {
		Map<String, Object> config = new HashMap<>();
		config.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, kafkaserverIp);
		config.put(ConsumerConfig.GROUP_ID_CONFIG, consumerName);
		config.put(ConsumerConfig.ENABLE_AUTO_COMMIT_CONFIG, "true");
		config.put(ConsumerConfig.AUTO_COMMIT_INTERVAL_MS_CONFIG, "1000");
		config.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
		config.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, JsonDeserializer.class);
		config.put("security.protocol", securityProtocol);
		config.put("sasl.mechanism", saslMechanism);
		config.put("sasl.jaas.config", jaasConfig);
		return new DefaultKafkaConsumerFactory<>(config, new StringDeserializer(),
				new JsonDeserializer<>(Car.class, false));
	}

	@Bean
	public ConcurrentKafkaListenerContainerFactory<String, Car> carKafkaListenerFactorys() {
		ConcurrentKafkaListenerContainerFactory<String, Car> factory = new ConcurrentKafkaListenerContainerFactory<>();
		factory.setConsumerFactory(carConsumerFactorys());
		return factory;
	}
}