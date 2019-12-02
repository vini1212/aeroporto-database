package model.entities;

import java.io.Serializable;

public class Passageiro implements Serializable{
	
	private static final long serialVersionUID = 1L;
	private Integer idPassageiro;
	private String pNome;
	private String mNome;
	private String sNome;
	private Integer idade;
	private String passaporte;
	private Voo nVooPassageiro;
	
	public Passageiro() {
		
	}

	public Passageiro(Integer idPassageiro, String pNome, String mNome, String sNome, Integer idade, String passaporte,
			Voo nVooPassageiro) {
		this.idPassageiro = idPassageiro;
		this.pNome = pNome;
		this.mNome = mNome;
		this.sNome = sNome;
		this.idade = idade;
		this.passaporte = passaporte;
		this.nVooPassageiro = nVooPassageiro;
	}

	public Integer getIdPassageiro() {
		return idPassageiro;
	}

	public void setIdPassageiro(Integer idPassageiro) {
		this.idPassageiro = idPassageiro;
	}

	public String getpNome() {
		return pNome;
	}

	public void setpNome(String pNome) {
		this.pNome = pNome;
	}

	public String getmNome() {
		return mNome;
	}

	public void setmNome(String mNome) {
		this.mNome = mNome;
	}

	public String getsNome() {
		return sNome;
	}

	public void setsNome(String sNome) {
		this.sNome = sNome;
	}

	public Integer getIdade() {
		return idade;
	}

	public void setIdade(Integer idade) {
		this.idade = idade;
	}

	public String getPassaporte() {
		return passaporte;
	}

	public void setPassaporte(String passaporte) {
		this.passaporte = passaporte;
	}

	public Voo getnVooPassageiro() {
		return nVooPassageiro;
	}

	public void setnVooPassageiro(Voo nVooPassageiro) {
		this.nVooPassageiro = nVooPassageiro;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((idPassageiro == null) ? 0 : idPassageiro.hashCode());
		result = prime * result + ((idade == null) ? 0 : idade.hashCode());
		result = prime * result + ((mNome == null) ? 0 : mNome.hashCode());
		result = prime * result + ((nVooPassageiro == null) ? 0 : nVooPassageiro.hashCode());
		result = prime * result + ((pNome == null) ? 0 : pNome.hashCode());
		result = prime * result + ((passaporte == null) ? 0 : passaporte.hashCode());
		result = prime * result + ((sNome == null) ? 0 : sNome.hashCode());
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
		Passageiro other = (Passageiro) obj;
		if (idPassageiro == null) {
			if (other.idPassageiro != null)
				return false;
		} else if (!idPassageiro.equals(other.idPassageiro))
			return false;
		if (idade == null) {
			if (other.idade != null)
				return false;
		} else if (!idade.equals(other.idade))
			return false;
		if (mNome == null) {
			if (other.mNome != null)
				return false;
		} else if (!mNome.equals(other.mNome))
			return false;
		if (nVooPassageiro == null) {
			if (other.nVooPassageiro != null)
				return false;
		} else if (!nVooPassageiro.equals(other.nVooPassageiro))
			return false;
		if (pNome == null) {
			if (other.pNome != null)
				return false;
		} else if (!pNome.equals(other.pNome))
			return false;
		if (passaporte == null) {
			if (other.passaporte != null)
				return false;
		} else if (!passaporte.equals(other.passaporte))
			return false;
		if (sNome == null) {
			if (other.sNome != null)
				return false;
		} else if (!sNome.equals(other.sNome))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Passageiro -> idPassageiro: " + idPassageiro + " - PrimeiroNome: " + pNome + " - NomeMeio: " + mNome + " - Sobrenome: " +
                        sNome + " - Idade: " + idade + " - Passaporte: " + passaporte + " - NumeroVooPassageiro: " + getnVooPassageiro().getNumero();
	}
}
