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
import model.dao.FuncionarioDao;
import model.entities.CompanhiaAerea;
import model.entities.Funcionario;

public class FuncionarioDaoJDBC implements FuncionarioDao {

    private Connection conn;

    public FuncionarioDaoJDBC(Connection conn) {
        this.conn = conn;
    }

    @Override
    public void insert(Funcionario obj) {
        PreparedStatement st = null;
        try {
            st = conn.prepareStatement(
                    "insert into funcionario "
                    + "values "
                    + "(?, ?, ?, ?, ?, ?, ?, ?, ?)", Statement.RETURN_GENERATED_KEYS);

            st.setInt(1, obj.getIdFuncionario());
            st.setString(2, obj.getpNome());
            st.setString(3, obj.getmNome());
            st.setString(4, obj.getsNome());
            st.setString(5, obj.getDocumento());
            st.setString(6, obj.getIdioma());
            st.setString(7, obj.getSexo());
            st.setString(8, obj.getTipo());
            st.setString(9, obj.getCompanhia().getIdCompanhia());

            int rowsAffected = st.executeUpdate();

            if (rowsAffected > 0) {
                ResultSet rs = st.getGeneratedKeys();
                if (rs.next()) {
                    int id = rs.getInt(1);
                    obj.setIdFuncionario(id);
                }
                DB.closeResultSet(rs);
            } else {
                throw new DbException("Unexpected error! No rows affected!");
            }
        } catch (SQLException e) {
            throw new DbException(e.getMessage());
        } finally {
            DB.closeStatement(st);
        }
    }

    @Override
    public void update(Funcionario obj) {
        PreparedStatement st = null;

        try {
            st = conn.prepareStatement(
                    "update funcionario "
                    + "set PNOME = ?, MNOME = ?, SNOME = ?, DOCUMENTO = ?, IDIOMA = ?, SEXO = ?, TIPO = ? "
                    + "where IDFUNCIONARIO = ?");

            st.setString(1, obj.getpNome());
            st.setString(2, obj.getmNome());
            st.setString(3, obj.getsNome());
            st.setString(4, obj.getDocumento());
            st.setString(5, obj.getIdioma());
            st.setString(6, obj.getSexo());
            st.setString(7, obj.getTipo());
            st.setInt(8, obj.getIdFuncionario());

            st.executeUpdate();
        } catch (SQLException e) {
            throw new DbException(e.getMessage());
        } finally {
            DB.closeStatement(st);
        }
    }

    @Override
    public void deleteById(Integer id) {
        PreparedStatement st = null;

        try {
            st = conn.prepareStatement("delete from funcionario where IDFUNCIONARIO = ?");

            st.setInt(1, id);

            st.executeUpdate();
        } catch (SQLException e) {
            throw new DbException(e.getMessage());
        } finally {
            DB.closeStatement(st);
        }
    }

    @Override
    public Funcionario findById(Integer id) {
        PreparedStatement st = null;
        ResultSet rs = null;

        try {
            st = conn.prepareStatement(
                    "select funcionario.*, companhiaaerea.NOMECOMP "
                    + "from funcionario inner join companhiaaerea "
                    + "on funcionario.COMPANHIA = companhiaaerea.IDCOMPANHIA "
                    + "where funcionario.IDFUNCIONARIO = ?");

            st.setInt(1, id);
            rs = st.executeQuery();

            if (rs.next()) {
                CompanhiaAerea comp = instantiateCompanhia(rs);
                Funcionario obj = instantiateFuncionario(rs, comp);
                return obj;
            }
            return null;
        } catch (SQLException e) {
            throw new DbException(e.getMessage());
        } finally {
            DB.closeStatement(st);
            DB.closeResultSet(rs);
        }
    }

    private Funcionario instantiateFuncionario(ResultSet rs, CompanhiaAerea comp) throws SQLException {
        Funcionario obj = new Funcionario();
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
        comp.setNomeCompanhia(rs.getString("NOMECOMP"));
        return comp;
    }

    @Override
    public List<Funcionario> findAll() {
        PreparedStatement st = null;
        ResultSet rs = null;

        try {
            st = conn.prepareStatement(
                    "select funcionario.*, companhiaaerea.NOMECOMP "
                    + "from funcionario inner join companhiaaerea "
                    + "on funcionario.COMPANHIA = companhiaaerea.IDCOMPANHIA "
                    + "order by PNOME");

            rs = st.executeQuery();

            List<Funcionario> list = new ArrayList<>();
            Map<String, CompanhiaAerea> map = new HashMap<>();

            while (rs.next()) {
                CompanhiaAerea comp = map.get(rs.getString("NOMECOMP"));
                if (comp == null) {
                    comp = instantiateCompanhia(rs);
                    map.put(rs.getString("NOMECOMP"), comp);
                }

                Funcionario obj = instantiateFuncionario(rs, comp);
                list.add(obj);
            }

            return list;
        } catch (SQLException e) {
            throw new DbException(e.getMessage());
        } finally {
            DB.closeStatement(st);
            DB.closeResultSet(rs);
        }
    }
}
