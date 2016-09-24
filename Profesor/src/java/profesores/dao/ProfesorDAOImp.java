/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package profesores.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import profesores.model.Profesor;
import profesores.util.UtilDB;

/**
 *
 * @author Felipe
 */
public class ProfesorDAOImp implements ProfesorDAO {

    private Connection connection;

    public ProfesorDAOImp() {
        connection = UtilDB.getConnection();

    }

    @Override
    public void agregarProfesor(Profesor profesor) {
        String sql = "INSERT INTO profesores (nombre,experiencia,carrera)"
                + " VALUES (?,?,?)";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, profesor.getNombre());
            ps.setInt(2, profesor.getExperiencia());
            ps.setString(3, profesor.getCarrera());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void borrarProfesor(int id_profesor) {
        String sql = "DELETE FROM profesores WHERE id_profesor=? ";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, id_profesor);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void cambiarProfesor(Profesor profesor) {
        String sql = "UPDATE profesores SET nombre=?, experiencia=?, carrera=?"
                + "WHERE id_profesor=?";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, profesor.getNombre());
            ps.setInt(2, profesor.getExperiencia());
            ps.setString(3, profesor.getCarrera());
            ps.setInt(4, profesor.getIdProfesor());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Profesor> desplegarProfesores() {
        List<Profesor> profesores = new ArrayList<Profesor>();
        try {
            Statement s = connection.createStatement();
            ResultSet rs = s.executeQuery("SELECT * FROM profesores");
            while (rs.next()) {

                Profesor profesor = new Profesor(rs.getInt("id_profesor"),
                        rs.getString("nombre"),
                        rs.getInt("experiencia"),
                        rs.getString("carrera"));
                profesores.add(profesor);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return profesores;

    }

    @Override
    public Profesor elegirProfesor(int idProfesor) {
        Profesor profesor = null;
        try {
            PreparedStatement ps = connection.prepareStatement("SELECT * FROM profesores "
                    + "WHERE id_profesor=?");
            ps.setInt(1, idProfesor);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {

                profesor = new Profesor(
                        rs.getInt("id_profesor"),
                        rs.getString("nombre"),
                        rs.getInt("experiencia"),
                        rs.getString("carrera"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println(profesor);
        return profesor;
    }

}
