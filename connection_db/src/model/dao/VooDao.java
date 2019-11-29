package model.dao;

import java.util.List;

import model.entities.Voo;

public interface VooDao {
	void insert (Voo obj);

	void deleteByNumero(Integer numeroVoo);
	
	Voo findById(Integer id);
	
	List<Voo> findAll();
}
