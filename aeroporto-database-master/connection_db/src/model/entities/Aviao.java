package model.entities;

import java.io.Serializable;

public class Aviao implements Serializable{
	
	private static final long serialVersionUID = 1L;
	private Integer idAviao;
	private String tipoAviao;
	private Integer numeroAssentos;
	private Voo numeroVoo;
	
	public Aviao() {
		
	}

	public Aviao(Integer idAviao, String tipoAviao, Integer numeroAssentos, Voo numeroVoo) {
		this.idAviao = idAviao;
		this.tipoAviao = tipoAviao;
		this.numeroAssentos = numeroAssentos;
		this.numeroVoo = numeroVoo;
	}

	public Integer getIdAviao() {
		return idAviao;
	}

	public void setIdAviao(Integer idAviao) {
		this.idAviao = idAviao;
	}

	public String getTipoAviao() {
		return tipoAviao;
	}

	public void setTipoAviao(String tipoAviao) {
		this.tipoAviao = tipoAviao;
	}

	public Integer getNumeroAssentos() {
		return numeroAssentos;
	}

	public void setNumeroAssentos(Integer numeroAssentos) {
		this.numeroAssentos = numeroAssentos;
	}

	public Voo getNumeroVoo() {
		return numeroVoo;
	}

	public void setNumeroVoo(Voo numeroVoo) {
		this.numeroVoo = numeroVoo;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((idAviao == null) ? 0 : idAviao.hashCode());
		result = prime * result + ((numeroAssentos == null) ? 0 : numeroAssentos.hashCode());
		result = prime * result + ((numeroVoo == null) ? 0 : numeroVoo.hashCode());
		result = prime * result + ((tipoAviao == null) ? 0 : tipoAviao.hashCode());
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
		Aviao other = (Aviao) obj;
		if (idAviao == null) {
			if (other.idAviao != null)
				return false;
		} else if (!idAviao.equals(other.idAviao))
			return false;
		if (numeroAssentos == null) {
			if (other.numeroAssentos != null)
				return false;
		} else if (!numeroAssentos.equals(other.numeroAssentos))
			return false;
		if (numeroVoo == null) {
			if (other.numeroVoo != null)
				return false;
		} else if (!numeroVoo.equals(other.numeroVoo))
			return false;
		if (tipoAviao == null) {
			if (other.tipoAviao != null)
				return false;
		} else if (!tipoAviao.equals(other.tipoAviao))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Aviao -> ID: " + idAviao + " - Tipo: " + tipoAviao + " - Numero de Assentos: " + numeroAssentos
				+ " - Numero do Voo: " + numeroVoo;
	}

	
}
