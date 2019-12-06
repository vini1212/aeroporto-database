package model.dao;

import java.util.List;

import model.entities.Piloto;

public interface PilotoDao {
	void insert (Piloto obj);
	
	Piloto findById(Integer id);
	
        void update(Piloto obj);
        
	List<Piloto> findAll();
        
        void deleteById(Integer id);
}
