package tn.amiri.kafka.springbootkafkaProducer.ressource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import tn.amiri.kafka.springbootkafkaProducer.model.User;

/**
 * 
 * @author khaled.amiri
 *
 */
@RestController
@RequestMapping("kafka")
public class UserRessource {

	@Autowired
	KafkaTemplate<String, User> kafkaTemplate;

	/**
	 * nom de topic see Readme how to create one
	 */
	private static final String TOPIC = "test2";

	@GetMapping("/publish/{name}")
	public String post(@PathVariable("name") final String name) {

		kafkaTemplate.send(TOPIC, new User(name, "Technology", 12000L));

		return "Published successfully";

	}

}
