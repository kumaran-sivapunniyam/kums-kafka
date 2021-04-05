package com.example.demo;

import java.util.HashMap;
import java.util.Map;

import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.apache.kafka.common.serialization.StringSerializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.config.KafkaListenerContainerFactory;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;
import org.springframework.kafka.core.DefaultKafkaProducerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.core.ProducerFactory;
import org.springframework.kafka.listener.ConcurrentMessageListenerContainer;

@Configuration
//@EnableKafka
public class KafkaContextConfiguration {

//	@Bean
//	public Map<String, Object> producerConfig() {
//		final Map<String, Object> props = new HashMap<String, Object>();
//
//		props.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092");
//		props.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
//		props.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
//		props.put(ProducerConfig.CLIENT_ID_CONFIG, "KumsClientId");
//
//		return props;
//	}

//	@Bean
//	public ProducerFactory<String, String> producerFactory() {
//		final Map<String, Object> props = new HashMap<String, Object>();
//
//		props.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092");
//		props.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
//		props.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
//		props.put(ProducerConfig.CLIENT_ID_CONFIG, "KumsClientId");
//
//
//		return new DefaultKafkaProducerFactory<>(props);
//	}

	@Bean
	public KafkaTemplate<String, String> kafkaTemplate() {
		
		final Map<String, Object> props = new HashMap<String, Object>();
		props.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092");
		props.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
		props.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
		props.put(ProducerConfig.CLIENT_ID_CONFIG, "KumsClientId");
		ProducerFactory<String, String> producerFactory = new DefaultKafkaProducerFactory<>(props);

		return new KafkaTemplate<>(producerFactory);
	}
	
	@Bean
	public KafkaSender sender() {
		return new KafkaSender();
	}
	
	
	//--Kafka Consumer Config
//	@Bean
//	public Map<String, Object> consumerConfig() {
//		final Map<String, Object> props = new HashMap<String, Object>();
//
//		props.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092");
//		props.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
//		props.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
//		props.put(ConsumerConfig.GROUP_ID_CONFIG, "KumsGroupId");
//		props.put(ConsumerConfig.AUTO_OFFSET_RESET_CONFIG, "latest");
//		props.put(ConsumerConfig.ENABLE_AUTO_COMMIT_CONFIG, false);
//
//		return props;
//	}
//	
//	@Bean
//	public ConsumerFactory<String, String> consumerFactory() {
//		return new DefaultKafkaConsumerFactory<>(consumerConfig());
//	}
	
//	@Bean()
//	public KafkaListenerContainerFactory<ConcurrentMessageListenerContainer<String, String>> kafkaListenerContainerFactory() {
//		final ConcurrentKafkaListenerContainerFactory<String, String> factory = new ConcurrentKafkaListenerContainerFactory<>();
//		factory.setConsumerFactory(consumerFactory());
//		factory.setConcurrency(4);
//		return factory;
//	}
 
}
