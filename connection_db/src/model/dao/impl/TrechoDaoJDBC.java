package model.dao.impl;

import java.sql.Connection;
import java.util.List;

import model.dao.TrechoDao;
import model.entities.Trecho;

public class TrechoDaoJDBC implements TrechoDao{
	private Connection conn;

	public TrechoDaoJDBC(Connection conn) {
		this.conn = conn;
	}

	@Override
	public void insert(Trecho obj) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(Trecho obj) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteById(Integer id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Trecho findById(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Trecho> findAll() {
		// TODO Auto-generated method stub
		return null;
	}
	
	
}
