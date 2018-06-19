package programa.scheduler;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import programa.controller.MedicoesController;
import programa.enums.TipoEnum;
import programa.service.MedicoesService;
import programa.util.DataUtil;

@Component
@EnableScheduling
public class Registrador {

	@Autowired
	private MedicoesService medicoes;
	
	@Scheduled(cron = "0 0 6,16,22 * * *")
	public void registraSalinidadde() {
		Date data = new Date();
		String dataFormatada  = DataUtil.parseDataHora(data);
		medicoes.fazMedicoes(TipoEnum.SALINIDADE, dataFormatada);
		medicoes.fazMedicoes(TipoEnum.SALINIDADE_FUNDO, dataFormatada);
		System.out.println("teste {" + dataFormatada + "}");
	}
	
	@Scheduled(cron = "0 0 6,16,22 * * *")
	public void registraTemperatura() {
		Date data = new Date();
		String dataFormatada  = DataUtil.parseDataHora(data);
		medicoes.fazMedicoes(TipoEnum.TEMPERATURA, dataFormatada);
		System.out.println("teste {" + dataFormatada + "}");
	}
	
	@Scheduled(cron = "0 0 13 * * *")
	public void registraTransparencia() {
		Date data = new Date();
		String dataFormatada  = DataUtil.parseDataHora(data);
		medicoes.fazMedicoes(TipoEnum.TRANSPARENCIA, dataFormatada);
		System.out.println("teste {" + dataFormatada + "}");
	}
	
	@Scheduled(cron = "0 0 2,5,8,11,14,17,20,23 * * *")
	public void registraOxigenioDissolvido() {
		Date data = new Date();
		String dataFormatada  = DataUtil.parseDataHora(data);
		medicoes.fazMedicoes(TipoEnum.OXIGENIO_DISSOLVIDO, dataFormatada);
		System.out.println("teste {" + dataFormatada + "}");
	}
	
	@Scheduled(cron = "0 0 6,17 * * *")
	public void registraPh() {
		Date data = new Date();
		String dataFormatada  = DataUtil.parseDataHora(data);
		medicoes.fazMedicoes(TipoEnum.PH, dataFormatada);
		System.out.println("teste {" + dataFormatada + "}");
	}
	
	@Scheduled(cron = "0 0 7 * * *")
	public void registraAlcalinidade() {
		Date data = new Date();
		String dataFormatada  = DataUtil.parseDataHora(data);
		medicoes.fazMedicoes(TipoEnum.ALCALINIDADE, dataFormatada);
		System.out.println("teste {" + dataFormatada + "}");
	}
	
	@Scheduled(cron = "0 0 7 * * *")
	public void registraDureza() {
		Date data = new Date();
		String dataFormatada  = DataUtil.parseDataHora(data);
		medicoes.fazMedicoes(TipoEnum.DUREZA, dataFormatada);
		System.out.println("teste {" + dataFormatada + "}");
	}
	
	@Scheduled(cron = "0 0 17 * * *")
	public void registraAmonia() {
		Date data = new Date();
		String dataFormatada  = DataUtil.parseDataHora(data);
		medicoes.fazMedicoes(TipoEnum.AMONIA_TOTAL, dataFormatada);
		System.out.println("teste {" + dataFormatada + "}");
	}
	
	@Scheduled(cron = "0 0 17 * * *")
	public void registraNitrito() {
		Date data = new Date();
		String dataFormatada  = DataUtil.parseDataHora(data);
		medicoes.fazMedicoes(TipoEnum.NITRITO, dataFormatada);
		System.out.println("teste {" + dataFormatada + "}");
	}
	
	@Scheduled(cron = "0 0 17 * * *")
	public void registraNitrato() {
		Date data = new Date();
		String dataFormatada  = DataUtil.parseDataHora(data);
		medicoes.fazMedicoes(TipoEnum.NITRATO, dataFormatada);
		System.out.println("teste {" + dataFormatada + "}");
	}
	
	@Scheduled(cron = "0 0 17 * * *")
	public void registraH2S() {
		Date data = new Date();
		String dataFormatada  = DataUtil.parseDataHora(data);
		medicoes.fazMedicoes(TipoEnum.H2S, dataFormatada);
		System.out.println("teste {" + dataFormatada + "}");
	}
	
	@Scheduled(cron = "0 0 17 * * *")
	public void registraSilicato() {
		Date data = new Date();
		String dataFormatada  = DataUtil.parseDataHora(data);
		medicoes.fazMedicoes(TipoEnum.SILICATO, dataFormatada);
		System.out.println("teste {" + dataFormatada + "}");
	}
	
}
