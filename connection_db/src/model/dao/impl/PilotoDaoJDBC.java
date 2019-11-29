package model.dao.impl;

import java.sql.Connection;
import java.util.List;

import model.dao.PilotoDao;
import model.entities.Piloto;

public class PilotoDaoJDBC implements PilotoDao{
	private Connection conn;

	public PilotoDaoJDBC(Connection conn) {
		this.conn = conn;
	}

	@Override
	public void insert(Piloto obj) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(Piloto obj) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteById(Integer id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Piloto findById(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Piloto> findAll() {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	
	
}
