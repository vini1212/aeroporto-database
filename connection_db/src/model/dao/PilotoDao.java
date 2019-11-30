package model.dao;

import java.util.List;

import model.entities.Piloto;

public interface PilotoDao {
	void insert (Piloto obj);
	
	Piloto findById(Integer id);
	
	List<Piloto> findAll();
}
