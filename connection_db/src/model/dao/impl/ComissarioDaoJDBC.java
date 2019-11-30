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
import model.dao.ComissarioDao;
import model.entities.Comissario;
import model.entities.CompanhiaAerea;

public class ComissarioDaoJDBC implements ComissarioDao{
	private Connection conn;

	public ComissarioDaoJDBC(Connection conn) {
		this.conn = conn;
	}

	@Override
	public void insert(Comissario obj) {
		PreparedStatement st = null;
		PreparedStatement st1 = null;
		try {
			st = conn.prepareStatement(
					"insert into funcionario "
					+ "values "
					+ "(?, ?, ?, ?, ?, ?, ?, ?, ?)",									
					Statement.RETURN_GENERATED_KEYS);
			
			st.setInt(1, obj.getIdFuncionario());
			st.setString(2, obj.getpNome());
			st.setString(3, obj.getmNome());
			st.setString(4, obj.getsNome());
			st.setString(5, obj.getDocumento());
			st.setString(6, obj.getIdioma());
			st.setString(7, obj.getSexo());
			st.setString(8, obj.getTipo());
			st.setString(9, obj.getCompanhia().getIdCompanhia());
			
			st1 = conn.prepareStatement( 
					"insert into comissario "
					+ "values "
					+ "(?, ?)",
					Statement.RETURN_GENERATED_KEYS);
			
			st1.setInt(1, obj.getIdComissario());
			st1.setInt(2, obj.getIdFunc());
			
			int rowsAffected = st.executeUpdate();
			int rowsAffected2 = st1.executeUpdate();
			
			if(rowsAffected > 0 && rowsAffected2 > 0) {
				ResultSet rs = st.getGeneratedKeys();
				if(rs.next()) {
					int id = rs.getInt(1);
					obj.setIdComissario(id);
				}
				DB.closeResultSet(rs);
			}
			else {
				throw new DbException("Unexpected error! No rows affected!");
			}
		}
		catch (SQLException e){
			throw new DbException(e.getMessage());
		}
		finally {
			DB.closeStatement(st);
			DB.closeStatement(st1);
		}
	}

	@Override
	public Comissario findById(Integer id) {
		PreparedStatement st = null;
		ResultSet rs = null;
		try {
			st = conn.prepareStatement(
					"select comissario.IDCOMISSARIO, funcionario.* "
					+ "from comissario inner join funcionario "
					+ "on comissario.IDFUNC = funcionario.IDFUNCIONARIO "
					+ "where IDCOMISSARIO = ?"					
					);
			
			st.setInt(1, id);
			rs = st.executeQuery();
			
			if(rs.next()) {
				CompanhiaAerea comp = instantiateCompanhia(rs);
				Comissario obj = instantiateComissario(rs, comp);
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
	
	private Comissario instantiateComissario(ResultSet rs, CompanhiaAerea comp) throws SQLException{
		Comissario obj = new Comissario();
		obj.setIdComissario(rs.getInt("IDCOMISSARIO"));
		obj.setIdFuncionario(rs.getInt("IDFUNCIONARIO"));
		obj.setpNome(rs.getString("PNOME"));
		obj.setmNome(rs.getString("MNOME"));
		obj.setsNome(rs.getString("SNOME"));
		obj.setDocumento(rs.getString("DOCUMENTO"));
		obj.setIdioma(rs.getString("IDIOMA"));
		obj.setSexo(rs.getString("SEXO"));
		obj.setTipo(rs.getString("TIPO"));
		obj.setCompanhia(comp);
		return obj;
	}
	
	private CompanhiaAerea instantiateCompanhia(ResultSet rs) throws SQLException{
		CompanhiaAerea comp = new CompanhiaAerea();
		comp.setIdCompanhia(rs.getString("COMPANHIA"));
		return comp;
	}

	@Override
	public List<Comissario> findAll() {
		PreparedStatement st = null;
		ResultSet rs = null;
		
		try {
			st = conn.prepareStatement( 
					"select comissario.IDCOMPANHIA, funcionario.* "
					+ "from comissario inner join funcionario "
					+ "on comissario.IDFUNC = funcionario.IDFUNCIONARIO "
					+ "order by PNOME");
			
			rs = st.executeQuery();
			
			List<Comissario> list = new ArrayList<>();
			Map<String, CompanhiaAerea> map = new HashMap<>();
			
			while(rs.next()) {
				
				CompanhiaAerea comp = map.get(rs.getString("COMPANHIA"));
				
				if (comp == null) {
					comp = instantiateCompanhia(rs);
					map.put(rs.getString("COMPANHIA"), comp);
				}
				
				Comissario obj = instantiateComissario(rs, comp);
				list.add(obj);
			}
			return list;
		}
		catch (SQLException e) {
			throw new DbException(e.getMessage());
		}
		finally {
			DB.closeResultSet(rs);
			DB.closeStatement(st);
		}
	}
}
