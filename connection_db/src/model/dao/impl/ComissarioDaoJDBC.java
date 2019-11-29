package model.dao.impl;

import java.sql.Connection;
import java.util.List;

import model.dao.ComissarioDao;
import model.entities.Comissario;

public class ComissarioDaoJDBC implements ComissarioDao{
	private Connection conn;

	public ComissarioDaoJDBC(Connection conn) {
		this.conn = conn;
	}

	@Override
	public void insert(Comissario obj) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(Comissario obj) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteById(Integer id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Comissario findById(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Comissario> findAll() {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	
}
