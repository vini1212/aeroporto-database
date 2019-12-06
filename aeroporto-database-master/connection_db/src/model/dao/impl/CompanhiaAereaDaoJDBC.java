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
import model.dao.CompanhiaAereaDao;
import model.entities.CompanhiaAerea;

public class CompanhiaAereaDaoJDBC implements CompanhiaAereaDao {

    private Connection conn;

    public CompanhiaAereaDaoJDBC(Connection conn) {
        this.conn = conn;
    }

    @Override
    public void insert(CompanhiaAerea obj) {
        PreparedStatement st = null;

        try {
            st = conn.prepareStatement(
                    "insert into companhiaaerea "
                    + "(IDCOMPANHIA, NOMECOMP, CNPJ, TELEFONE, EMAIL) "
                    + "values"
                    + "(?, ?, ?, ?, ?)",
                    Statement.RETURN_GENERATED_KEYS);

            st.setString(1, obj.getIdCompanhia());
            st.setString(2, obj.getNomeCompanhia());
            st.setString(3, obj.getcNPJ());
            st.setString(4, obj.getTelefone());
            st.setString(5, obj.getEmail());

            int rowsAffected = st.executeUpdate();

            if (rowsAffected > 0) {
                ResultSet rs = st.getGeneratedKeys();
                if (rs.next()) {
                    String id = rs.getString(1);
                    obj.setIdCompanhia(id);
                }
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
    public void update(CompanhiaAerea obj) {
        PreparedStatement st = null;

        try {
            st = conn.prepareStatement(
                    "update companhiaaerea "
                    + "set NOMECOMP = ?, CNPJ = ?, TELEFONE = ?, EMAIL = ? "
                    + "where IDCOMPANHIA = ?");

            st.setString(1, obj.getNomeCompanhia());
            st.setString(2, obj.getcNPJ());
            st.setString(3, obj.getTelefone());
            st.setString(4, obj.getEmail());
            st.setString(5, obj.getIdCompanhia());

            st.executeUpdate();
        } catch (SQLException e) {
            throw new DbException(e.getMessage());
        } finally {
            DB.closeStatement(st);
        }
    }

    @Override
    public void deleteById(String id) {
        PreparedStatement st = null;

        try {
            st = conn.prepareStatement("delete from companhiaaerea where IDCOMPANHIA = ?");

            st.setString(1, id);

            st.executeUpdate();
        } catch (SQLException e) {
            throw new DbException(e.getMessage());
        } finally {
            DB.closeStatement(st);
        }

    }

    @Override
    public CompanhiaAerea findById(String id) {
        PreparedStatement st = null;
        ResultSet rs = null;

        try {
            st = conn.prepareStatement("select * from companhiaaerea where IDCOMPANHIA = ?");

            st.setString(1, id);
            rs = st.executeQuery();

            if (rs.next()) {
                CompanhiaAerea obj = new CompanhiaAerea();
                obj.setIdCompanhia(rs.getString("IDCOMPANHIA"));
                obj.setNomeCompanhia(rs.getString("NOMECOMP"));
                obj.setcNPJ(rs.getString("CNPJ"));
                obj.setTelefone(rs.getString("TELEFONE"));
                obj.setEmail(rs.getString("EMAIL"));
                return obj;
            }

            return null; //caso n�o ache a ocorr�ncia do ID no banco de dados
        } catch (SQLException e) {
            throw new DbException(e.getMessage());
        } finally {
            DB.closeResultSet(rs);
            DB.closeStatement(st);
        }
    }

    @Override
    public List<CompanhiaAerea> findAll() {
        PreparedStatement st = null;
        ResultSet rs = null;

        try {
            st = conn.prepareStatement("select * from companhiaaerea order by NOMECOMP");

            rs = st.executeQuery();

            List<CompanhiaAerea> list = new ArrayList<>();

            while (rs.next()) {
                CompanhiaAerea obj = new CompanhiaAerea();
                obj.setIdCompanhia(rs.getString("IDCOMPANHIA"));
                obj.setNomeCompanhia(rs.getString("NOMECOMP"));
                obj.setcNPJ(rs.getString("CNPJ"));
                obj.setTelefone(rs.getString("TELEFONE"));
                obj.setEmail(rs.getString("EMAIL"));
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
