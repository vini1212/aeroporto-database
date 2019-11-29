package model.dao;

import java.util.List;

import model.entities.Trecho;

public interface TrechoDao {
	void insert (Trecho obj);
	
	void update(Trecho obj);
	
	void deleteById(Integer id);
	
	Trecho findById(Integer id);
	
	List<Trecho> findAll();
}
