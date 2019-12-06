package model.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
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
		PreparedStatement st = null;
		
		try {
			st = conn.prepareStatement("delete from voo where NUMERO = ?");
			
			st.setInt(1, numeroVoo);
			
			st.executeUpdate();
		}
		catch(SQLException e) {
			throw new DbException(e.getMessage());
		}
		finally {
			DB.closeStatement(st);
		}
	}

	@Override
	public Voo findById(Integer id) {
		PreparedStatement st = null;
		ResultSet rs = null;
		
		try {
			st = conn.prepareStatement("select * from voo where NUMERO = ?");
			
			st.setInt(1, id);
			
			rs = st.executeQuery();
			
			if(rs.next()) {
				Voo obj = new Voo();
				obj.setNumero(rs.getInt("NUMERO"));
				return obj;
			}
			
			return null;
			
		}
		catch(SQLException e) {
			throw new DbException(e.getMessage());
		}
		finally {
			DB.closeResultSet(rs);
			DB.closeStatement(st);
		}
	}

	@Override
	public List<Voo> findAll() {
		PreparedStatement st = null;
		ResultSet rs = null;
		
		try {
			st = conn.prepareStatement("select * from voo");
			
			rs = st.executeQuery();
			
			List<Voo> list = new ArrayList<>();
			
			while(rs.next()) {
				Voo obj = new Voo();
				obj.setNumero(rs.getInt("NUMERO"));
				list.add(obj);
			}
			return list;
		}
		catch(SQLException e) {
			throw new DbException(e.getMessage());
		}
		finally {
			DB.closeStatement(st);
			DB.closeResultSet(rs);
		}
	}
	
	
	
	
}
