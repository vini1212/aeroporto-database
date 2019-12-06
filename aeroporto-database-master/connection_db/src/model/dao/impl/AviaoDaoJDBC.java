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
import model.dao.AviaoDao;
import model.entities.Aviao;
import model.entities.Voo;

public class AviaoDaoJDBC implements AviaoDao {

    private Connection conn;

    public AviaoDaoJDBC(Connection conn) {
        this.conn = conn;
    }

    @Override
    public void insert(Aviao obj) {
        PreparedStatement st = null;

        try {
            st = conn.prepareStatement(
                    "insert into aviao "
                    + "(IDAVIAO, TIPOAVIAO, NUMEROASSENTOS, NUMEROVOO) "
                    + "values "
                    + "(?, ?, ?, ?)",
                    Statement.RETURN_GENERATED_KEYS);

            st.setInt(1, obj.getIdAviao());
            st.setString(2, obj.getTipoAviao());
            st.setInt(3, obj.getNumeroAssentos());
            st.setInt(4, obj.getNumeroVoo().getNumero());

            int rowsAffected = st.executeUpdate();

            if (rowsAffected > 0) {
                ResultSet rs = st.getGeneratedKeys();
                if (rs.next()) {
                    int id = rs.getInt(1);
                    obj.setIdAviao(id);
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
    public void update(Aviao obj) {
        PreparedStatement st = null;

        try {
            st = conn.prepareStatement(
                    "update aviao, voo "
                    + "set TIPOAVIAO = ?, NUMEROASSENTOS = ? "
                    + "where IDAVIAO = ?");

            st.setString(1, obj.getTipoAviao());
            st.setInt(2, obj.getNumeroAssentos());
            st.setInt(3, obj.getIdAviao());

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
            st = conn.prepareStatement("delete from aviao where IDAVIAO = ?");

            st.setInt(1, id);

            st.executeUpdate();
        } catch (SQLException e) {
            throw new DbException(e.getMessage());
        } finally {
            DB.closeStatement(st);
        }
    }

    @Override
    public Aviao findById(Integer id) {
        PreparedStatement st = null;
        ResultSet rs = null;

        try {
            st = conn.prepareStatement(
                    "select aviao.*, voo.NUMERO "
                    + "from aviao inner join voo "
                    + "on aviao.NUMEROVOO = voo.NUMERO "
                    + "where aviao.IDAVIAO = ?");

            st.setInt(1, id);
            rs = st.executeQuery();

            if (rs.next()) {
                Voo voo = instantiateVoo(rs);
                Aviao obj = instantiateAviao(rs, voo);
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

    private Aviao instantiateAviao(ResultSet rs, Voo voo) throws SQLException {
        Aviao obj = new Aviao();
        obj.setIdAviao(rs.getInt("IDAVIAO"));
        obj.setTipoAviao(rs.getString("TIPOAVIAO"));
        obj.setNumeroAssentos(rs.getInt("NUMEROASSENTOS"));
        obj.setNumeroVoo(voo);
        return obj;
    }

    private Voo instantiateVoo(ResultSet rs) throws SQLException {
        Voo voo = new Voo();
        voo.setNumero(rs.getInt("NUMERO"));

        return voo;
    }

    @Override
    public List<Aviao> findAll() {
        PreparedStatement st = null;
        ResultSet rs = null;

        try {
            st = conn.prepareStatement(
                    "select aviao.*, voo.NUMERO "
                    + "from aviao inner join voo "
                    + "on aviao.NUMEROVOO = voo.NUMERO "
                    + "order by NUMERO");

            rs = st.executeQuery();

            List<Aviao> list = new ArrayList<>();
            Map<Integer, Voo> map = new HashMap<>();

            while (rs.next()) {
                Voo voo = map.get(rs.getInt("NUMERO"));

                if (voo == null) {
                    voo = instantiateVoo(rs);
                    map.put(rs.getInt("NUMERO"), voo);
                }

                Aviao obj = instantiateAviao(rs, voo);
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
