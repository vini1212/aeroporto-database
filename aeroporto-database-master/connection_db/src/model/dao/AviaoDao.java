package model.dao;

import java.util.List;

import model.entities.Aviao;

public interface AviaoDao {
	void insert (Aviao obj);
	
	void update(Aviao obj);
	
	void deleteById(Integer id);
	
	Aviao findById(Integer id);
	
	List<Aviao> findAll();
	
}
