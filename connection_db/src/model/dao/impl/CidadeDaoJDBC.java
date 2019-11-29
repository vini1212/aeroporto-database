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
import model.dao.CidadeDao;
import model.entities.Cidade;

public class CidadeDaoJDBC implements CidadeDao{
	private Connection conn;

	public CidadeDaoJDBC(Connection conn) {
			this.conn = conn;
	}

	@Override
	public void insert(Cidade obj) {
		PreparedStatement st = null;
		
		try {
			st = conn.prepareStatement(
					"insert into cidade "
					+ "(IDCIDADE, PAIS, NOMECIDADE) "
					+ "values "
					+ "(?, ?, ?)",
					Statement.RETURN_GENERATED_KEYS);
			
			st.setInt(1, obj.getIdCidade());
			st.setString(2, obj.getPais());
			st.setString(3, obj.getNomeCidade());
			
			int rowsAffected = st.executeUpdate();
			
			if(rowsAffected > 0) {
				ResultSet rs = st.getGeneratedKeys();
				if(rs.next()) {
					int id = rs.getInt(1);
					obj.setIdCidade(id);
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
	public void update(Cidade obj) {
		PreparedStatement st = null;
		
		try {
			st = conn.prepareStatement(
					"update cidade "
					+"set PAIS = ?, NOMECIDADE = ? "
					+ "where IDCIDADE = ?");
			
			st.setString(1, obj.getPais());
			st.setString(2, obj.getNomeCidade());
			st.setInt(3, obj.getIdCidade());
			
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
	public void deleteById(Integer id) {
		PreparedStatement st = null;
		
		try {
			st = conn.prepareStatement("delete from cidade where IDCIDADE = ?");
			
			st.setInt(1, id);
			
			st.executeUpdate();
		}catch (SQLException e) {
			throw new DbException(e.getMessage());
		}
		finally {
			DB.closeStatement(st);
		}
		
	}

	@Override
	public Cidade findById(Integer id) {
		PreparedStatement st = null;
		ResultSet rs = null;
		
		try {
			st = conn.prepareStatement("select * from cidade where IDCIDADE = ?");
			st.setInt(1, id);
			rs = st.executeQuery();
			
			if(rs.next()) {
				Cidade obj = new Cidade();
				obj.setIdCidade(rs.getInt("IDCIDADE"));
				obj.setPais(rs.getString("PAIS"));
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
	public List<Cidade> findAll() {
		PreparedStatement st = null;
		ResultSet rs = null;
		
		try {
			st = conn.prepareStatement(
					"select * from cidade order by PAIS");
			
			rs = st.executeQuery();
			
			List<Cidade> list = new ArrayList<>();
			
			while(rs.next()) {
				Cidade obj = new Cidade();
				obj.setIdCidade(rs.getInt("IDCIDADE"));
				obj.setPais(rs.getString("PAIS"));
				obj.setNomeCidade(rs.getString("NOMECIDADE"));
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
