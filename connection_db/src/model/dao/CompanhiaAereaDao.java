package model.dao;

import java.util.List;

import model.entities.CompanhiaAerea;

public interface CompanhiaAereaDao {
	void insert (CompanhiaAerea obj);
	
	void update(CompanhiaAerea obj);
	
	void deleteById(String id);
	
	CompanhiaAerea findById(String id);
	
	List<CompanhiaAerea> findAll();
	
}
