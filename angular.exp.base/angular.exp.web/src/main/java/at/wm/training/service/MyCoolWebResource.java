package at.wm.training.service;

import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import at.wm.training.model.Person;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

@SuppressWarnings("rawtypes")
@Controller
@RequestMapping("person")
public class MyCoolWebResource {

	private static final Logger LOGGER = LoggerFactory
			.getLogger(MyCoolWebResource.class);

	@Value("#{dbcfg.app.url}")
	private String appUrl;

	@RequestMapping("{id}")
	@ResponseBody
	public ResponseEntity getByKey(@PathVariable String id) {

		LOGGER.debug("'find' obj with id: '{}'", id);

		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		String json = gson.toJson(new Person().setFirstname("hi")
				.setLastname("itsme.").setId(id));

		ResponseEntity<String> response = new ResponseEntity<String>(json,
				HttpStatus.OK);
		return response;
	}

	@ResponseBody
	public ResponseEntity testGet() {

		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		String json = gson.toJson(new Person().setFirstname("hi")
				.setLastname("itsme.").setId(UUID.randomUUID().toString()));

		ResponseEntity<String> response = new ResponseEntity<String>(json,
				HttpStatus.OK);
		return response;
	}

	@RequestMapping("denied")
	public ResponseEntity<String> deny() {
		ResponseEntity<String> response = new ResponseEntity<String>(
				HttpStatus.FORBIDDEN);
		return response;
	}
}