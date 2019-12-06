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
import model.dao.PilotoDao;
import model.entities.CompanhiaAerea;
import model.entities.Piloto;

public class PilotoDaoJDBC implements PilotoDao {

    private Connection conn;

    public PilotoDaoJDBC(Connection conn) {
        this.conn = conn;
    }

    @Override
    public void insert(Piloto obj) {
        PreparedStatement st = null;
        PreparedStatement st1 = null;

        try {
            /*st = conn.prepareStatement(
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
             */
            st1 = conn.prepareStatement(
                    "insert into piloto "
                    + "values "
                    + "(?, ?, ?)",
                    Statement.RETURN_GENERATED_KEYS);

            st1.setInt(1, obj.getIdPiloto());
            st1.setInt(2, obj.getHoras());
            st1.setInt(3, obj.getIdFunc());

            st1.executeUpdate();

        } catch (SQLException e) {
            throw new DbException(e.getMessage());
        } finally {
            DB.closeStatement(st);
            DB.closeStatement(st1);
        }
    }

    @Override
    public void update(Piloto obj) {
        PreparedStatement st = null;
        try {
            st = conn.prepareStatement(
                    "update piloto "
                    + "set HORASVOO = ? "
                    + "where IDPILOTO = ?");

            st.setInt(1, obj.getHoras());
            st.setInt(2, obj.getIdPiloto());

            st.executeUpdate();
        } catch (SQLException e) {
            throw new DbException(e.getMessage());
        } finally {
            DB.closeStatement(st);
        }
    }

    @Override
    public Piloto findById(Integer id) {
        PreparedStatement st = null;
        ResultSet rs = null;

        try {
            st = conn.prepareStatement(
                    "select piloto.IDPILOTO, piloto.HORASVOO, funcionario.* "
                    + "from piloto inner join funcionario "
                    + "on piloto.IDFUNC = funcionario.IDFUNCIONARIO "
                    + "where IDPILOTO = ?");

            st.setInt(1, id);
            rs = st.executeQuery();

            if (rs.next()) {
                CompanhiaAerea comp = instantiateCompanhia(rs);
                Piloto obj = instantiatePiloto(rs, comp);
                return obj;
            }
            return null;
        } catch (SQLException e) {
            throw new DbException(e.getMessage());
        } finally {
            DB.closeResultSet(rs);
            DB.closeStatement(st);
        }
    }

    @Override
    public void deleteById(Integer id) {
        PreparedStatement st = null;
        try {
            st = conn.prepareStatement("delete from piloto where IDPILOTO = ?");

            st.setInt(1, id);

            st.executeQuery();
        } catch (SQLException e) {
            throw new DbException(e.getMessage());
        } finally {
            DB.closeStatement(st);
        }
    }

    private Piloto instantiatePiloto(ResultSet rs, CompanhiaAerea comp) throws SQLException {
        Piloto obj = new Piloto();
        obj.setIdPiloto(rs.getInt("IDPILOTO"));
        obj.setHoras(rs.getInt("HORASVOO"));
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

    private CompanhiaAerea instantiateCompanhia(ResultSet rs) throws SQLException {
        CompanhiaAerea comp = new CompanhiaAerea();
        comp.setIdCompanhia(rs.getString("COMPANHIA"));
        return comp;
    }

    @Override
    public List<Piloto> findAll() {
        PreparedStatement st = null;
        ResultSet rs = null;

        try {
            st = conn.prepareStatement(
                    "select piloto.IDPILOTO, piloto.HORASVOO, funcionario.* "
                    + "from piloto inner join funcionario "
                    + "on piloto.IDFUNC = funcionario.IDFUNCIONARIO "
                    + "order by PNOME");

            rs = st.executeQuery();

            List<Piloto> list = new ArrayList<>();
            Map<String, CompanhiaAerea> map = new HashMap<>();

            while (rs.next()) {
                CompanhiaAerea comp = map.get(rs.getString("COMPANHIA"));

                if (comp == null) {
                    comp = instantiateCompanhia(rs);
                    map.put(rs.getString("COMPANHIA"), comp);
                }

                Piloto obj = instantiatePiloto(rs, comp);
                list.add(obj);
            }
            return list;
        } catch (SQLException e) {
            throw new DbException(e.getMessage());
        } finally {
            DB.closeResultSet(rs);
            DB.closeStatement(st);
        }
    }
}
