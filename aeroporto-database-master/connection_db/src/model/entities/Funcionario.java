package model.entities;

import java.io.Serializable;

public class Funcionario implements Serializable{
	
	private static final long serialVersionUID = 1L;
	private Integer idFuncionario;
	private String pNome;
	private String mNome;
	private String sNome;
	private String documento;
	private String sexo;
	private String tipo;
	private String idioma;
	private CompanhiaAerea companhia;
	
	public Funcionario() {
		
	}

        public Funcionario(Funcionario f) {
		this.idFuncionario = f.idFuncionario;
		this.pNome = f.pNome;
		this.mNome = f.mNome;
		this.sNome = f.sNome;
		this.documento = f.documento;
		this.sexo = f.sexo;
		this.tipo = f.tipo;
		this.idioma = f.idioma;
		this.companhia = f.companhia;
	}
        
	public Funcionario(Integer idFuncionario, String pNome, String mNome, String sNome, String documento, String idioma, String sexo,
			String tipo, CompanhiaAerea companhia) {
		this.idFuncionario = idFuncionario;
		this.pNome = pNome;
		this.mNome = mNome;
		this.sNome = sNome;
		this.documento = documento;
		this.sexo = sexo;
		this.tipo = tipo;
		this.idioma = idioma;
		this.companhia = companhia;
	}

	public Integer getIdFuncionario() {
		return idFuncionario;
	}

	public void setIdFuncionario(Integer idFuncionario) {
		this.idFuncionario = idFuncionario;
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

	public String getDocumento() {
		return documento;
	}

	public void setDocumento(String documento) {
		this.documento = documento;
	}

	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getIdioma() {
		return idioma;
	}

	public void setIdioma(String idioma) {
		this.idioma = idioma;
	}

	public CompanhiaAerea getCompanhia() {
		return companhia;
	}

	public void setCompanhia(CompanhiaAerea companhia) {
		this.companhia = companhia;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((companhia == null) ? 0 : companhia.hashCode());
		result = prime * result + ((documento == null) ? 0 : documento.hashCode());
		result = prime * result + ((idFuncionario == null) ? 0 : idFuncionario.hashCode());
		result = prime * result + ((idioma == null) ? 0 : idioma.hashCode());
		result = prime * result + ((mNome == null) ? 0 : mNome.hashCode());
		result = prime * result + ((pNome == null) ? 0 : pNome.hashCode());
		result = prime * result + ((sNome == null) ? 0 : sNome.hashCode());
		result = prime * result + ((sexo == null) ? 0 : sexo.hashCode());
		result = prime * result + ((tipo == null) ? 0 : tipo.hashCode());
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
		Funcionario other = (Funcionario) obj;
		if (companhia == null) {
			if (other.companhia != null)
				return false;
		} else if (!companhia.equals(other.companhia))
			return false;
		if (documento == null) {
			if (other.documento != null)
				return false;
		} else if (!documento.equals(other.documento))
			return false;
		if (idFuncionario == null) {
			if (other.idFuncionario != null)
				return false;
		} else if (!idFuncionario.equals(other.idFuncionario))
			return false;
		if (idioma == null) {
			if (other.idioma != null)
				return false;
		} else if (!idioma.equals(other.idioma))
			return false;
		if (mNome == null) {
			if (other.mNome != null)
				return false;
		} else if (!mNome.equals(other.mNome))
			return false;
		if (pNome == null) {
			if (other.pNome != null)
				return false;
		} else if (!pNome.equals(other.pNome))
			return false;
		if (sNome == null) {
			if (other.sNome != null)
				return false;
		} else if (!sNome.equals(other.sNome))
			return false;
		if (sexo == null) {
			if (other.sexo != null)
				return false;
		} else if (!sexo.equals(other.sexo))
			return false;
		if (tipo == null) {
			if (other.tipo != null)
				return false;
		} else if (!tipo.equals(other.tipo))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Funcionario -> ID: " + idFuncionario + " - Nome: " + pNome + " - Nome do Meio: " + mNome + " - Sobrenome: " + sNome + " - Documento: "
				+ documento + " - Idioma: " + idioma + " - Sexo: " + sexo + " - Tipo: " + tipo + " - ID Companhia: " + getCompanhia().getIdCompanhia() + " - Nome Companhia: " + getCompanhia().getNomeCompanhia();
	}		
}
