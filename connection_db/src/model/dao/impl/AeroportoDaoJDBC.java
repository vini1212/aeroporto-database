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
import model.dao.AeroportoDao;
import model.entities.Aeroporto;

public class AeroportoDaoJDBC implements AeroportoDao{
	private Connection conn;

	public AeroportoDaoJDBC(Connection conn) {
		this.conn = conn;
	}

	@Override
	public void insert(Aeroporto obj) {
		PreparedStatement st = null;
		
		try {
			st = conn.prepareStatement(
					"INSERT INTO aeroporto "
					+ "(IDAEROPORTO, NOMEAEROPORTO) "
					+ "VALUES "
					+ "(?, ?)",
					Statement.RETURN_GENERATED_KEYS);
			
			st.setString(1, obj.getId());
			st.setString(2, obj.getNomeCidade());
			
			int rowsAffected = st.executeUpdate();
			
			if(rowsAffected > 0) {
				ResultSet rs = st.getGeneratedKeys();
				if(rs.next()) {
					String id = rs.getString(1);
					obj.setId(id);
				}
				DB.closeResultSet(rs);
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
	public void update(Aeroporto obj) {
		PreparedStatement st = null;
		
		try {
			st = conn.prepareStatement(
					"UPDATE aeroporto "
					+ "SET NOMEAEROPORTO = ? "
					+ "WHERE IDAEROPORTO = ?");		
			
			st.setString(1, obj.getNomeCidade());
			st.setString(2, obj.getId());
			
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
	public void deleteById(String id) {
		PreparedStatement st = null;
		
		try {
			st = conn.prepareStatement("DELETE FROM aeroporto WHERE IDAEROPORTO = ?");
			
			st.setString(1, id);
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
	public Aeroporto findById(String id) {
		PreparedStatement st = null;
		ResultSet rs = null;
		
		try {
			st = conn.prepareStatement(
					"SELECT * FROM aeroporto WHERE IDAEROPORTO = ?"
					);
			
			st.setString(1, id);
			rs = st.executeQuery();
			
			if(rs.next()) {
				Aeroporto obj = new Aeroporto();
				obj.setId(rs.getString("IDAEROPORTO"));
				obj.setNomeCidade(rs.getString("NOMECIDADE"));
				return obj;
			}
		return null;
		
		} 
		catch(SQLException e) {
			throw new DbException(e.getMessage());
		}
		
		finally {
			DB.closeStatement(st);
			DB.closeResultSet(rs);
		}
	}

	@Override
	public List<Aeroporto> findAll() {
		PreparedStatement st = null;
		ResultSet rs = null;
		
		try {
			st = conn.prepareStatement(
					"SELECT * FROM aeroporto ORDER BY NOMEAEROPORTO"
					);
			
			rs = st.executeQuery();
			
			List<Aeroporto> list = new ArrayList<>();
			
			while(rs.next()) {
				Aeroporto obj = new Aeroporto();
				obj.setId(rs.getString("IDAEROPORTO"));
				obj.setNomeCidade(rs.getString("NOMEAEROPORTO"));
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
