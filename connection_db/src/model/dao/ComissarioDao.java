package model.dao;

import java.util.List;

import model.entities.Comissario;

public interface ComissarioDao {
	void insert (Comissario obj);
	
	Comissario findById(Integer id);
	
	List<Comissario> findAll();
	
}
