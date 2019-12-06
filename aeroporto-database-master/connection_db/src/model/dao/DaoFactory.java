package model.dao;

import db.DB;
import model.dao.impl.AeroportoDaoJDBC;
import model.dao.impl.AviaoDaoJDBC;
import model.dao.impl.CidadeDaoJDBC;
import model.dao.impl.ComissarioDaoJDBC;
import model.dao.impl.CompanhiaAereaDaoJDBC;
import model.dao.impl.FuncionarioDaoJDBC;
import model.dao.impl.PassageiroDaoJDBC;
import model.dao.impl.PilotoDaoJDBC;
import model.dao.impl.TrechoDaoJDBC;
import model.dao.impl.VooDaoJDBC;

//Classe para declaração das interfaces das tabelas que desejo implementar do meu banco de dados
public class DaoFactory {
	public static AeroportoDao createAeroportoDao() {
		return new AeroportoDaoJDBC(DB.getConnection());
	}
	
	public static AviaoDao createAviaoDao() {
		return new AviaoDaoJDBC(DB.getConnection());
	}
	
	public static CidadeDao createCidadeDao() {
		return new CidadeDaoJDBC(DB.getConnection());
	}
	
	public static ComissarioDao createComissarioDao() {
		return new ComissarioDaoJDBC(DB.getConnection());
	}
	
	public static CompanhiaAereaDao createCompanhiaAereaDao() {
		return new CompanhiaAereaDaoJDBC(DB.getConnection());
	}
	
	public static FuncionarioDao createFuncionarioDao() {
		return new FuncionarioDaoJDBC(DB.getConnection());		
	}
	
	public static PassageiroDao createPassageiroDao() {
		return new PassageiroDaoJDBC(DB.getConnection());
	}
	
	public static PilotoDao createPilotoDao() {
		return new PilotoDaoJDBC(DB.getConnection());
	}
	
	public static TrechoDao createTrechoDao() {
		return new TrechoDaoJDBC(DB.getConnection());
	}
	
	public static VooDao createVooDao() {
		return new VooDaoJDBC(DB.getConnection());
	}
}
