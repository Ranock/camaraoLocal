package programa.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import programa.Statics;
import programa.enums.TipoEnum;
import programa.model.Medicao;


public class MedicoesController {

	public void realizarMedicao(TipoEnum tipoMedicao, String CodArduino, String ipArduino, String datahora) {
		RestTemplate restTemplate = new RestTemplate();
		String uri = "http://"+ipArduino+":80/medida?tipo="+tipoMedicao.getValor();
		JsonNode nodes = restTemplate.getForObject(uri, JsonNode.class);
		ObjectMapper mapper = new ObjectMapper();
		Medicao medicao;
		try {
			medicao = mapper.readValue(mapper.treeAsTokens(nodes), new TypeReference<Medicao>(){});
			medicao.setDataMedicao(datahora);
			restTemplate.postForObject(Statics.SERVER+"/auth/medicao/arduino"+ CodArduino, medicao, Medicao.class);
		} catch (JsonParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JsonMappingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			
			
		}
	
	public void enviarMedicaoReal(String ipArduino, Long idTanque) {
		RestTemplate restTemplate = new RestTemplate();
		JsonNode nodes;
		ObjectMapper mapper = new ObjectMapper();
		Medicao medicao;
			
			
		List<Medicao> medicoes = new ArrayList<>();
		try {
		for(TipoEnum tipo : TipoEnum.values()) {		
			
				nodes = restTemplate.getForObject("http://"+ipArduino+"/medida?tipo="+tipo.getValor(), JsonNode.class);
				medicao = mapper.readValue(mapper.treeAsTokens(nodes), new TypeReference<Medicao>(){});
				medicao.setDataMedicao(" ");		
				medicoes.add(medicao);
			}
		restTemplate.postForObject(Statics.SERVER+"/auth/medicao/tanque/"+String.valueOf(idTanque)+"/real", medicoes, ArrayList.class);
		} catch (JsonParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JsonMappingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
		
	
}
