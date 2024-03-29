package model.entities;

import java.io.Serializable;

public class Comissario extends Funcionario implements Serializable{

	private static final long serialVersionUID = 1L;
	private Integer idComissario;
	private Integer idFunc;
	
	public Comissario() {
		
	}

	public Comissario(Integer idComissario, Funcionario func) {
		super(func);
		this.idComissario = idComissario;
		this.idFunc = func.getIdFuncionario();
	}

	public Integer getIdComissario() {
		return idComissario;
	}

	public void setIdComissario(Integer idComissario) {
		this.idComissario = idComissario;
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
		result = prime * result + ((idComissario == null) ? 0 : idComissario.hashCode());
		result = prime * result + ((idFunc == null) ? 0 : idFunc.hashCode());
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
		Comissario other = (Comissario) obj;
		if (idComissario == null) {
			if (other.idComissario != null)
				return false;
		} else if (!idComissario.equals(other.idComissario))
			return false;
		if (idFunc == null) {
			if (other.idFunc != null)
				return false;
		} else if (!idFunc.equals(other.idFunc))
			return false;
		return true;
	}
	
	@Override
	public String toString() {
		return "Comissario ->  ID: " + idComissario + " - ID (Funcionario): " + getIdFuncionario() + " - Nome: " + getpNome() + " - Nome do Meio: " + getmNome() 
                + " - Sobrenome: " + getsNome() + " - Documento: " + getDocumento() + " - Idioma: " + getIdioma() + " - Sexo: " + getSexo() + " - Tipo: " + getTipo() + " - ID Companhia: " + getCompanhia().getIdCompanhia();
	}
	
	
}
