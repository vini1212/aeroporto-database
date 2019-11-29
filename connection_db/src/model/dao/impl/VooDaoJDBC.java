package model.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import db.DB;
import db.DbException;
import model.dao.VooDao;
import model.entities.Voo;

public class VooDaoJDBC implements VooDao{
	private Connection conn;

	public VooDaoJDBC(Connection conn) {
		this.conn = conn;
	}

	@Override
	public void insert(Voo obj) {
		PreparedStatement st = null;
		
		try {
			st = conn.prepareStatement(
					"insert into voo "
					+ "(NUMERO) "
					+ "values "
					+ "(?)",
					Statement.RETURN_GENERATED_KEYS);
			
			st.setInt(1, obj.getNumero());
			
			int rowsAffected = st.executeUpdate();
			
			if(rowsAffected > 0) {
				ResultSet rs = st.getGeneratedKeys();
				if(rs.next()) {
					int id = rs.getInt(1);
					obj.setNumero(id);
				}
			}
		
			else {
			throw new DbException("Unexpected error! No rows affected!");
			}
		}
		catch(SQLException e) {
			throw new DbException(e.getMessage());
		}
		finally {
			DB.closeStatement(st);
		}
	}

	@Override
	public void deleteByNumero(Integer numeroVoo) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Voo findById(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Voo> findAll() {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	
	
}
