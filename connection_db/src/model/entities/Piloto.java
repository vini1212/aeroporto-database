package model.entities;

import java.io.Serializable;

public class Piloto extends Funcionario implements Serializable{

	private static final long serialVersionUID = 1L;
	private Integer idPiloto;
	private Integer horas;
	private Integer idFunc;
	
	public Piloto() {
		
	}

	public Piloto(Integer idFuncionario, String pNome, String mNome, String sNome, String documento, String sexo,
			String tipo, String idioma, CompanhiaAerea companhia, Integer idPiloto, Integer horas, Integer idFunc) {
		super(idFuncionario, pNome, mNome, sNome, documento, sexo, tipo, idioma, companhia);
		this.idPiloto = idPiloto;
		this.horas = horas;
		this.idFunc = idFunc;
	}

	public Integer getIdPiloto() {
		return idPiloto;
	}

	public void setIdPiloto(Integer idPiloto) {
		this.idPiloto = idPiloto;
	}

	public Integer getHoras() {
		return horas;
	}

	public void setHoras(Integer horas) {
		this.horas = horas;
	}

	public Integer getIdFunc() {
		return idFunc;
	}

	public void setIdFunc(Integer idFunc) {
		this.idFunc = idFunc;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((horas == null) ? 0 : horas.hashCode());
		result = prime * result + ((idFunc == null) ? 0 : idFunc.hashCode());
		result = prime * result + ((idPiloto == null) ? 0 : idPiloto.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Piloto other = (Piloto) obj;
		if (horas == null) {
			if (other.horas != null)
				return false;
		} else if (!horas.equals(other.horas))
			return false;
		if (idFunc == null) {
			if (other.idFunc != null)
				return false;
		} else if (!idFunc.equals(other.idFunc))
			return false;
		if (idPiloto == null) {
			if (other.idPiloto != null)
				return false;
		} else if (!idPiloto.equals(other.idPiloto))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Piloto -> IdPiloto: " + idPiloto + " / HorasVoo: " + horas + " / idFuncionario: " + getIdFuncionario() + " / PrimeiroNome: " +
				getpNome() + " / NomeMeio: " + getmNome() + " / Sobrenome: " + getsNome() + " / Documento: " + getDocumento() + " / Idioma: " + getIdioma() +
				" / Sexo: " + getSexo() + " / Tipo: " + getTipo() + " / Companhia: " + getCompanhia().getIdCompanhia();
	}
	
}
