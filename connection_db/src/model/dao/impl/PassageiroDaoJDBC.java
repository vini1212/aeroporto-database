package model.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import db.DB;
import db.DbException;
import model.dao.PassageiroDao;
import model.entities.Passageiro;
import model.entities.Voo;

public class PassageiroDaoJDBC implements PassageiroDao{
	private Connection conn;

	public PassageiroDaoJDBC(Connection conn) {
		this.conn = conn;
	}

	@Override
	public void insert(Passageiro obj) {
		PreparedStatement st = null;
		
		try {
			st = conn.prepareStatement(
					"insert into passageiro "
					+ "(IDPASSAGEIRO, PNOME, MNOME, SNOME, PASSAPORTE, IDADE, NVOOP) "
					+ "values "
					+ "(?, ?, ?, ?, ?, ?, ?)",
					Statement.RETURN_GENERATED_KEYS);
			
			st.setInt(1, obj.getIdPassageiro());
			st.setString(2, obj.getpNome());
			st.setString(3, obj.getmNome());
			st.setString(4, obj.getsNome());
			st.setString(5, obj.getPassaporte());
			st.setInt(6, obj.getIdade());
			st.setInt(7, obj.getnVooPassageiro().getNumero());
			
			int rowsAffected = st.executeUpdate();
			
			if (rowsAffected > 0) {
				ResultSet rs = st.getGeneratedKeys();
				if(rs.next()) {
					String passaporte = rs.getString(4);
					obj.setPassaporte(passaporte);
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
	public void update(Passageiro obj) {
		PreparedStatement st = null;
		
		try {
			st = conn.prepareStatement(
					"update passageiro "
					+ "PNOME = ?, MNOME = ?, SNOME = ?, PASSAPORTE = ?, IDADE = ?, NVOOP = ? "
					+ "where IDPASSAGEIRO = ?");
			
			st.setString(1, obj.getpNome());
			st.setString(2, obj.getmNome());
			st.setString(3, obj.getsNome());
			st.setString(4, obj.getPassaporte());
			st.setInt(5, obj.getIdade());
			st.setInt(6, obj.getnVooPassageiro().getNumero());
			st.setInt(7, obj.getIdPassageiro());
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
			st = conn.prepareStatement("delete from passageiro where IDPASSAGEIRO = ?");
			
			st.setInt(1, id);
			
			st.executeUpdate();
			
		}
		catch (SQLException e) {
			throw new DbException(e.getMessage());
		}
		finally {
			DB.closeStatement(st);
		}
	}

	@Override
	public Passageiro findById(Integer id) {
		PreparedStatement st = null;
		ResultSet rs = null;
		
		try {
			st = conn.prepareStatement(
					"select passageiro.*, voo.NUMERO as VooPassageiro"
					+ "from passageiro inner join voo " 
					+ "on passageiro.NVOOP = voo.NUMERO" 
					+ "where IDPASSAGEIRO = ?");
			
			st.setInt(1, id);
			rs = st.executeQuery();
			
			if(rs.next()) {
				Voo voo = instantiateVoo(rs);
				Passageiro obj = instantiatePassageiro(rs, voo);
				return obj;
			}
			return null;
		}
		catch (SQLException e) {
			throw new DbException(e.getMessage());
		}
		finally {
			DB.closeResultSet(rs);
			DB.closeStatement(st);
		}
	}
	
	private Passageiro instantiatePassageiro (ResultSet rs, Voo	voo) throws SQLException{
		Passageiro obj = new Passageiro();
		obj.setIdPassageiro(rs.getInt("IDPASSAGEIRO"));
		obj.setpNome(rs.getString("PNOME"));
		obj.setmNome(rs.getString("MNOME"));
		obj.setsNome(rs.getString("SNOME"));
		obj.setPassaporte(rs.getString("PASSAPORTE"));
		obj.setIdade(rs.getInt("IDADE"));
		obj.setnVooPassageiro(voo);
		
		return obj;
	}
	
	private Voo instantiateVoo(ResultSet rs) throws SQLException{
		Voo voo = new Voo();
		voo.setNumero(rs.getInt("NUMERO"));
		
		return voo;
	}

	@Override
	public List<Passageiro> findAll() {
		PreparedStatement st = null;
		ResultSet rs = null;
		
		try {
			st = conn.prepareStatement(
					"select passageiro.*, voo.NUMERO "
					+ "from passageiro inner join voo "
					+ "on passageiro.NVOOP = voo.NUMERO "
					+ "order by NVOOP");
			
			rs = st.executeQuery();
			
			List<Passageiro> list = new ArrayList<>();
			Map<Integer, Voo> map = new HashMap<>();
			
			while (rs.next()) {
				Voo voo = map.get(rs.getInt("NUMERO"));
				
				if (voo == null) {
					voo = instantiateVoo(rs);
					map.put(rs.getInt("NUMERO"), voo);
				}
				
				Passageiro obj = instantiatePassageiro(rs, voo);
				list.add(obj);
			}
			return list;
					
		}catch (SQLException e) {
			throw new DbException(e.getMessage());
		}
		
		finally {
			DB.closeStatement(st);
			DB.closeResultSet(rs);
		}
	}	
}
