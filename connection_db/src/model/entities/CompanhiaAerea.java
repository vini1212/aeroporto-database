package model.entities;

import java.io.Serializable;

public class CompanhiaAerea implements Serializable{

	private static final long serialVersionUID = 1L;
	private String idCompanhia;
	private String nomeCompanhia;
	private String cNPJ;
	private String telefone;
	private String email;
	
	public CompanhiaAerea() {
		
	}
	
	public CompanhiaAerea(String idCompanhia, String nomeCompanhia, String cNPJ, String telefone, String email) {
		this.idCompanhia = idCompanhia;
		this.nomeCompanhia = nomeCompanhia;
		this.cNPJ = cNPJ;
		this.telefone = telefone;
		this.email = email;
	}

	public String getIdCompanhia() {
		return idCompanhia;
	}

	public void setIdCompanhia(String idCompanhia) {
		this.idCompanhia = idCompanhia;
	}

	public String getNomeCompanhia() {
		return nomeCompanhia;
	}

	public void setNomeCompanhia(String nomeCompanhia) {
		this.nomeCompanhia = nomeCompanhia;
	}

	public String getcNPJ() {
		return cNPJ;
	}

	public void setcNPJ(String cNPJ) {
		this.cNPJ = cNPJ;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cNPJ == null) ? 0 : cNPJ.hashCode());
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + ((idCompanhia == null) ? 0 : idCompanhia.hashCode());
		result = prime * result + ((nomeCompanhia == null) ? 0 : nomeCompanhia.hashCode());
		result = prime * result + ((telefone == null) ? 0 : telefone.hashCode());
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
		CompanhiaAerea other = (CompanhiaAerea) obj;
		if (cNPJ == null) {
			if (other.cNPJ != null)
				return false;
		} else if (!cNPJ.equals(other.cNPJ))
			return false;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (idCompanhia == null) {
			if (other.idCompanhia != null)
				return false;
		} else if (!idCompanhia.equals(other.idCompanhia))
			return false;
		if (nomeCompanhia == null) {
			if (other.nomeCompanhia != null)
				return false;
		} else if (!nomeCompanhia.equals(other.nomeCompanhia))
			return false;
		if (telefone == null) {
			if (other.telefone != null)
				return false;
		} else if (!telefone.equals(other.telefone))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Companhia_Aerea [idCompanhia=" + idCompanhia + ", nomeCompanhia=" + nomeCompanhia + ", cNPJ=" + cNPJ
				+ ", telefone=" + telefone + ", email=" + email + "]";
	}	
}
