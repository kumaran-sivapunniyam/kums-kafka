package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class KafkaSenderService {
	
	@Autowired
	private KafkaSender kafkaSender;
	
	@GetMapping("/sendMessage")
	public String sendMessageToKafka(@RequestParam int count) {
		
		System.out.println("KafkaSenderService.sendMessageToKafka");
		for(int i=0; i<count; i++ )
			kafkaSender.send("deepatopic2", "Hello: " + i);
		
		return "Message sent...";
	}
	
//	@KafkaListener(topics = "kumstopic")
//	public void onMessage(ConsumerRecord<String, String> consumerRecord) {
//		
//		String key = consumerRecord.key();
//		String value = consumerRecord.value();
//		
//		System.out.println(consumerRecord.toString());
//		
//	}
}
