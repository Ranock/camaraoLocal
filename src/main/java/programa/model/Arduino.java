package programa.model;
 
import com.fasterxml.jackson.annotation.JsonIgnoreType;

import programa.enums.TipoEnum;
@JsonIgnoreType
public class Arduino {

	private Long id;
	
	private String codigo; 
	
	private Tanque tanque;
	
	private TipoEnum tipo;
	
	private String ip;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Tanque getTanque() {
		return tanque;
	}
	public void setTanque(Tanque tanque) {
		this.tanque = tanque;
	}
	
	public TipoEnum getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		for(TipoEnum tip : TipoEnum.values()){
			if(tip.name() == tipo) {
				this.tipo = tip;
			}
		}
		
	}
	public String getCodigo() {
		return codigo;
	}
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	
	public String getIp() {
		return ip;
	}
	public void setIp(String ip) {
		this.ip = ip;
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
		Arduino other = (Arduino) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	
}
