/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package profesores.dao;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import profesores.model.Viaticos;
import profesores.util.UtilDB;

/**
 *
 * @author Jazmin Salmeron
 */
public class ViaticosDAOI implements ViaticosDAO {

    public Connection connection;

    public ViaticosDAOI() {
        connection = UtilDB.getConnection();

    }

    @Override
    public void agregarViaticos(Viaticos viatico) {
        String sql = "INSERT INTO viaticos (montoSolicitado, montoOtorgado, montoComprobado, "
                + "comprobacionValida)"
                + " VALUES(?,?,?,?)";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, viatico.getMontoSolicitado());
            ps.setInt(2, viatico.getMontoOtorgado());
            ps.setInt(3, viatico.getMontoComprobado());
            ps.setString(4, viatico.getComprobacionValida());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void borrarViaticos(int id_viaticos) {
        String sql = "DELETE FROM viaticos WHERE id_viaticos=?";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, id_viaticos);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void cambiarViaticos(Viaticos viatico) {
        String sql = "UPDATE viaticos SET montoSolicitado=?, montoOtorgado=?, montoComprobado=?"
                + " comprobacionValida=?"
                + " WHERE id_viaticos=?";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, viatico.getMontoSolicitado());
            ps.setInt(2, viatico.getMontoOtorgado());
            ps.setInt(3, viatico.getMontoComprobado());
            ps.setString(4, viatico.getComprobacionValida());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Viaticos> desplegarViaticos() {
        List<Viaticos> viaticos = new ArrayList<Viaticos>();
        try {
            Statement s = connection.createStatement();
            ResultSet rs = s.executeQuery("SELECT * FROM viaticos");
            while (rs.next()) {

                Viaticos viatico = new Viaticos(rs.getInt("id_viaticos"),
                        
                        rs.getInt("montoSolicitado"),
                        rs.getInt("montoOtorgado"),
                        rs.getInt("montoComprobado"),
                        rs.getString("comprobacionValida"));
                viaticos.add(viatico);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return viaticos;

    }

    @Override
    public Viaticos elegirViaticos(int idViaticos) {
        Viaticos viaticos = null;
        try {
            PreparedStatement ps = connection.prepareStatement("SELECT * FROM viaticos "
                    + "WHERE id_viaticos=?");
            ps.setInt(1, idViaticos);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {

                viaticos = new Viaticos(
                        rs.getInt("id_viaticos"),
                        rs.getInt("montoSolicitado"),
                        rs.getInt("montoOtorgado"),
                        rs.getInt("montoComprobado"),
                        rs.getString("comprobacionValida"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println(viaticos);
        return viaticos;
    }

}
