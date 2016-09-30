/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Store;
import util.UtilDB;

/**

 */
public class StoreDAOImp implements StoreDAO {

    private Connection connection;

    public StoreDAOImp() {
        connection = UtilDB.getConnection();

    }

    @Override
    public void insertarStore(Store store) {
        String sql = "INSERT INTO store (state,type,version,du)"
                + " VALUES (?,?,?,?)";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, store.getState());
            ps.setString(2, store.getType());
            ps.setInt(3, store.getVersion());
            ps.setString(4, store.getDu());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void borrarStore(int idPidBo) {
        String sql = "DELETE FROM store WHERE id_pid=? ";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, idPidBo);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void cambiarStore(Store store) {
        String sql = "UPDATE store SET state=?, type=?, version=?, du=?"
                + " WHERE id_pid=?";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, store.getState());
            ps.setString(2, store.getType());
            ps.setInt(3, store.getVersion());
            ps.setString(4, store.getDu());
            ps.setInt(5, store.getIdPid());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Store> desplegarStore() {
        List<Store> stores = new ArrayList<Store>();
        try {
            Statement s = connection.createStatement();
            ResultSet rs = s.executeQuery("SELECT * FROM store");
            while (rs.next()) {

                Store store = new Store
                        (rs.getInt("id_pid"),
                        rs.getString("state"),
                        rs.getString("type"),
                        rs.getInt("version"),
                        rs.getString("du")
                );
                stores.add(store);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return stores;

    }

    @Override
    public Store elegirStore(int idPidEle) {
        Store store = new Store();
        try {
            PreparedStatement ps = connection.prepareStatement("SELECT * FROM store "
                    + " WHERE id_pid=?");
            ps.setInt(1, idPidEle);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {

                store = new Store(
                        rs.getInt("id_pid"),
                        rs.getString("state"),
                        rs.getString("type"),
                        rs.getInt("version"),
                        rs.getString("du")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println(store);
        return store;
    }

}
