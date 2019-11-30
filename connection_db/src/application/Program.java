package application;

import java.util.List;
import java.util.Scanner;

import model.dao.AeroportoDao;
import model.dao.AviaoDao;
import model.dao.CidadeDao;
import model.dao.ComissarioDao;
import model.dao.CompanhiaAereaDao;
import model.dao.DaoFactory;
import model.dao.FuncionarioDao;
import model.dao.PassageiroDao;
import model.dao.PilotoDao;
import model.dao.TrechoDao;
import model.entities.CompanhiaAerea;

public class Program {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		ComissarioDao comissarioDao = DaoFactory.createComissarioDao();
		FuncionarioDao funcionarioDao = DaoFactory.createFuncionarioDao();		
		AeroportoDao aeroportoDao = DaoFactory.createAeroportoDao();		
		CidadeDao cidadeDao = DaoFactory.createCidadeDao();
		CompanhiaAereaDao companhiaAereaDao = DaoFactory.createCompanhiaAereaDao();
		AviaoDao aviaoDao = DaoFactory.createAviaoDao();
		PassageiroDao passageiroDao = DaoFactory.createPassageiroDao();
		PilotoDao pilotoDao = DaoFactory.createPilotoDao();
		TrechoDao trechoDao = DaoFactory.createTrechoDao();
	
//		System.out.println("=== TESTE1: aeroporto findAll ===");
//		
//		List<Aeroporto> list = aeroportoDao.findAll();
//		
//		for(Aeroporto obj : list) {
//			System.out.println(obj);
//		}
		
		

//		List<Cidade> list = cidadeDao.findAll();
//		for(Cidade obj : list) {
//			System.out.println(obj);
//		}
		
	
//TRAZ TODAS AS OCORRENCIAS DE COMPANHIAS CADASTRADAS		
//		List<CompanhiaAerea> list = companhiaAereaDao.findAll();
//		for(CompanhiaAerea obj : list) {
//			System.out.println(obj);
//		}
//		

		
// TRAZ TODAS AS OCORRENCIAS DE AVIAO		
//		List<Aviao> list = aviaoDao.findAll();
//		
//		for(Aviao obj : list) {
//			System.out.println(obj);
//		}


		
// TRAZ TODAS AS OCORRENCIAS DE PASSAGEIRO NO BANCO		
//		List<Passageiro> list = passageiroDao.findAll();
//		
//		for (Passageiro obj : list) {
//			System.out.println(obj);
//		}
			
//		Comissario newComissario = new Comissario(879, "Vinicius", "R", "Geraldo", "654987321654", "M" , "Comissário", "Português", "01384130", 756821, 879);
//		comissarioDao.insert(newComissario);
//		System.out.println("Inserido! Novo id = " + newComissario.getIdFuncionario());
		
//		Comissario com = comissarioDao.findById(103640);
//		System.out.println(com);

/* INSERE UM NOVO FUNCIONARIO NO BANCO
 * 
 * 		Funcionario newFuncionario = new Funcionario(699, "Alex", "F", "Marston", "123456789987", "M", "Comissário", "Português", "01384130");
				funcionarioDao.insert(newFuncionario);
*/
		
		
// TRAZ TODAS AS OCORRENCIAS DE PILOTO NO MYSQL
//		List<Piloto> list = pilotoDao.findAll();
//		for(Piloto obj : list) {
//			System.out.println(obj);
//		}   


// ENCONTRA UM FUNCIONARIO PELO ID PASSADO
//		Funcionario funcionario = funcionarioDao.findById(132);
//		System.out.println(funcionario);
//		
		
		
		
		sc.close();
	}

}
