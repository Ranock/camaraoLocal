package programa.model;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;

public class AcaoWebsocket {
	private String acao;
	private Long idTanque;
	
	public AcaoWebsocket(String acao, Long idTanque) {
		this.acao = acao;
		this.idTanque = idTanque;
	}
	
	public AcaoWebsocket() {
		
	}

	public String getAcao() {
		return acao;
	}
	public void setAcao(String acao) {
		this.acao = acao;
	}
	public Long getIdTanque() {
		return idTanque;
	}
	public void setIdTanque(Long idTanque) {
		this.idTanque = idTanque;
	}
	
}
