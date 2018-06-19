package programa.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import programa.Statics;
import programa.model.Arduino;

public class ArduinoController {

	public List<Arduino> retornarArduinos(){
		RestTemplate restTemplate = new RestTemplate();
		JsonNode nodes = restTemplate.getForObject(Statics.SERVER+"/auth/arduino/all", JsonNode.class);
		ObjectMapper mapper = new ObjectMapper();
		List<Arduino> arduinos;
		try {
			arduinos = mapper.readValue(mapper.treeAsTokens(nodes), new TypeReference<List<Arduino>>(){});
		} catch (JsonParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		} catch (JsonMappingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
		return arduinos;
	}
}
