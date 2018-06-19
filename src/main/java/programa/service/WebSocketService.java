package programa.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import programa.controller.ArduinoController;
import programa.controller.MedicoesController;
import programa.enums.Acoes;
import programa.enums.TipoEnum;
import programa.model.AcaoWebsocket;
import programa.model.Arduino;

@Service
public class WebSocketService {
	
	
	
	public void realizaAcao(AcaoWebsocket acao) {
		ArduinoController arduinoController = new ArduinoController();
		MedicoesController medController = new MedicoesController();
		List<Arduino> arduinos = arduinoController.retornarArduinos();
		if( acao.getAcao().equals(Acoes.REAL.name())) {
			for (Arduino ard : arduinos) {
				if(ard.getTanque().getId() == acao.getIdTanque())
					medController.enviarMedicaoReal(ard.getIp(), acao.getIdTanque());
			}
		}
	}

}
