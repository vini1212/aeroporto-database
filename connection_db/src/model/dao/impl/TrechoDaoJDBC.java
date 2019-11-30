package model.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import db.DB;
import db.DbException;
import model.dao.TrechoDao;
import model.entities.Aeroporto;
import model.entities.Trecho;

public class TrechoDaoJDBC implements TrechoDao{
	private Connection conn;

	public TrechoDaoJDBC(Connection conn) {
		this.conn = conn;
	}

	@Override
	public void insert(Trecho obj) {
		PreparedStatement st = null;
		
		try {
			st = conn.prepareStatement( 
					"insert into trecho"
					+ "values "
					+ "(?, ?, ?, ?, ?, ?)",
					Statement.RETURN_GENERATED_KEYS);
			
			st.setInt(1, obj.getIdTrecho());
			st.setInt(2, obj.getnVoo());
			st.setInt(3, obj.getIdA());
			st.setInt(4, obj.getIdP());
			st.setInt(5, obj.getIdC());
			st.setString(6, obj.getIdAero());
			
			int rowsAffected = st.executeUpdate();
			
			if(rowsAffected > 0) {
				ResultSet rs = st.getGeneratedKeys();
				if(rs.next()) {
					int id = rs.getInt(1);
					obj.setIdTrecho(id);
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
	public void update(Trecho obj) {
		PreparedStatement st = null;
		
		try {
			st = conn.prepareStatement(
					"update trecho "
					+ "set NVOO = ?, IDA = ?, IDP = ?, IDC = ?, IDAERO = ? "
					+ "where IDTRECHO = ?");		
			
			st.setInt(1,  obj.getnVoo());
			st.setInt(2, obj.getIdA());
			st.setInt(3,  obj.getIdP());
			st.setInt(4, obj.getIdC());
			st.setString(5, obj.getIdAero());
			st.setInt(6, obj.getIdTrecho());
			
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
			st = conn.prepareStatement("delete from trecho where IDTRECHO = ?");
			
			st.setInt(1, id);
			
			st.executeUpdate();
			
		}catch(SQLException e) {
			throw new DbException(e.getMessage());
		}
		finally {
			DB.closeStatement(st);
		}
	}

	@Override
	public Trecho findById(Integer id) {
		PreparedStatement st = null;
		ResultSet rs = null;
		
		try {
			st = conn.prepareStatement(
						"select aeroporto.NOMEAEROPORTO, trecho.* "
						+ "from trecho inner join aeroporto "
						+ "on trecho.IDAERO = aeroporto.IDAEROPORTO "
						+ "where IDTRECHO = ?");
			
			st.setInt(1, id);
			rs = st.executeQuery();
			
			if(rs.next()) {
				Aeroporto aero = instantiateAeroporto(rs);
				Trecho obj = instantiateTrecho(rs, aero);
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
	
	private Trecho instantiateTrecho (ResultSet rs, Aeroporto aero) throws SQLException{
		Trecho obj = new Trecho();
		obj.setIdTrecho(rs.getInt("IDTRECHO"));
		obj.setnVoo(rs.getInt("NVOO"));
		obj.setIdA(rs.getInt("IDA"));
		obj.setIdP(rs.getInt("IDP"));
		obj.setIdC(rs.getInt("IDC"));
		obj.setIdAero(rs.getString("IDAERO"));
		return obj;
	}
		
	private Aeroporto instantiateAeroporto (ResultSet rs) throws SQLException{
		Aeroporto aero = new Aeroporto();
		aero.setNomeCidade(rs.getString("NOMEAEROPORTO"));
		return aero;
	}

	@Override
	public List<Trecho> findAll() {
		// TODO Auto-generated method stub
		return null;
	}
	
	
}
