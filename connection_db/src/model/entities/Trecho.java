package model.entities;

import java.io.Serializable;

public class Trecho implements Serializable{

	private static final long serialVersionUID = 1L;
	private Integer idTrecho;
	private Integer nVoo;
	private Integer idA; //idAviao
	private Integer idP; //idPassageiro
	private Integer idC; //idComissario
	private String idAero;
	
	public Trecho() {
		
	}
	
	public Trecho(Integer idTrecho, Integer nVoo, Integer idA, Integer idP, Integer idC, String idAero) {
		this.idTrecho = idTrecho;
		this.nVoo = nVoo;
		this.idA = idA;
		this.idP = idP;
		this.idC = idC;
		this.idAero = idAero;
	}

	public Integer getIdTrecho() {
		return idTrecho;
	}

	public void setIdTrecho(Integer idTrecho) {
		this.idTrecho = idTrecho;
	}

	public Integer getnVoo() {
		return nVoo;
	}

	public void setnVoo(Integer nVoo) {
		this.nVoo = nVoo;
	}

	public Integer getIdA() {
		return idA;
	}

	public void setIdA(Integer idA) {
		this.idA = idA;
	}

	public Integer getIdP() {
		return idP;
	}

	public void setIdP(Integer idP) {
		this.idP = idP;
	}

	public Integer getIdC() {
		return idC;
	}

	public void setIdC(Integer idC) {
		this.idC = idC;
	}

	public String getIdAero() {
		return idAero;
	}

	public void setIdAero(String idAero) {
		this.idAero = idAero;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((idA == null) ? 0 : idA.hashCode());
		result = prime * result + ((idAero == null) ? 0 : idAero.hashCode());
		result = prime * result + ((idC == null) ? 0 : idC.hashCode());
		result = prime * result + ((idP == null) ? 0 : idP.hashCode());
		result = prime * result + ((idTrecho == null) ? 0 : idTrecho.hashCode());
		result = prime * result + ((nVoo == null) ? 0 : nVoo.hashCode());
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
		Trecho other = (Trecho) obj;
		if (idA == null) {
			if (other.idA != null)
				return false;
		} else if (!idA.equals(other.idA))
			return false;
		if (idAero == null) {
			if (other.idAero != null)
				return false;
		} else if (!idAero.equals(other.idAero))
			return false;
		if (idC == null) {
			if (other.idC != null)
				return false;
		} else if (!idC.equals(other.idC))
			return false;
		if (idP == null) {
			if (other.idP != null)
				return false;
		} else if (!idP.equals(other.idP))
			return false;
		if (idTrecho == null) {
			if (other.idTrecho != null)
				return false;
		} else if (!idTrecho.equals(other.idTrecho))
			return false;
		if (nVoo == null) {
			if (other.nVoo != null)
				return false;
		} else if (!nVoo.equals(other.nVoo))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Trecho [idTrecho=" + idTrecho + ", nVoo=" + nVoo + ", idA=" + idA + ", idP=" + idP + ", idC=" + idC
				+ ", idAero=" + idAero + "]";
	}
}
