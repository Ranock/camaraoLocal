package programa.model;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonIgnore;

import programa.enums.TipoEnum;

public class Medicao {

	private Long id;
	private String dataMedicao;
	private Long tanque;
	private String registro;
	private Integer tipo;
	private Long usuario;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Long getTanque() {
		return tanque;
	}
	public void setTanque(Long tanque) {
		this.tanque = tanque;
	}
	public Integer getTipo() {
		return tipo;
	}
	public void setTipo(Integer tipo) {
	
		this.tipo = tipo;	
		
	}
	public Long getUsuario() {
		return usuario;
	}
	public void setUsuario(Long usuario) {
		this.usuario = usuario;
	}
	public String getDataMedicao() {
		return dataMedicao;
	}
	public void setDataMedicao(String dataMedicao) {
		this.dataMedicao = dataMedicao;
	}
	public String getRegistro() {
		return registro;
	}
	public void setRegistro(String registro) {
		this.registro = registro;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Medicao other = (Medicao) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}


	
	
	
}
