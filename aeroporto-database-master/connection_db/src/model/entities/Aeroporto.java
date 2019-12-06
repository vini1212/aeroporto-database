package model.entities;

import java.io.Serializable;

public class Aeroporto implements Serializable{

	private static final long serialVersionUID = 1L;
	private String id;
	private String nomeCidade;
	
	public Aeroporto() {
		
	}
	
	public Aeroporto(String id, String nomeCidade) {
		this.id = id;
		this.nomeCidade = nomeCidade;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getNomeCidade() {
		return nomeCidade;
	}

	public void setNomeCidade(String nomeCidade) {
		this.nomeCidade = nomeCidade;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((nomeCidade == null) ? 0 : nomeCidade.hashCode());
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
		Aeroporto other = (Aeroporto) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (nomeCidade == null) {
			if (other.nomeCidade != null)
				return false;
		} else if (!nomeCidade.equals(other.nomeCidade))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Aeroporto -> ID: " + id + " - Cidade: " + nomeCidade;
	}
}
