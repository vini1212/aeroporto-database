package model.dao;

import java.util.List;

import model.entities.Aeroporto;

public interface AeroportoDao {
	
	void insert(Aeroporto obj);
	
	void update(Aeroporto obj);
	
	void deleteById(String id);
	
	Aeroporto findById(String id); //Vai ser responsável em pegar um id passado como parâmetro que busca no banco de dados
	
	List<Aeroporto> findAll();
}
