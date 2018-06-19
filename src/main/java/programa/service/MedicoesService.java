package programa.service;

import java.io.IOException;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import programa.Statics;
import programa.controller.ArduinoController;
import programa.controller.MedicoesController;
import programa.enums.TipoEnum;
import programa.model.Arduino;
import programa.model.Medicao;

@Service
public class MedicoesService {
	public void fazMedicoes(TipoEnum tipoMedicao, String data) {
		ArduinoController arduinoController = new ArduinoController();
		MedicoesController medController = new MedicoesController();
		List<Arduino> arduinos = arduinoController.retornarArduinos();

		for (Arduino ard : arduinos) {
			medController.realizarMedicao(tipoMedicao, ard.getCodigo(), ard.getIp(), data);
		}

	}
}
