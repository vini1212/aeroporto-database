package model.dao;

import java.util.List;

import model.entities.Piloto;

public interface PilotoDao {
	void insert (Piloto obj);
	
	void update(Piloto obj);
	
	void deleteById(Integer id);
	
	Piloto findById(Integer id);
	
	List<Piloto> findAll();
}
