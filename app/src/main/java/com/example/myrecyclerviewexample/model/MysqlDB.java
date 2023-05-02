package com.example.myrecyclerviewexample.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class MysqlDB {

    private Connection getConnection() throws SQLException{
        try{
            Class.forName("com.mysql.jdbc.Driver");
        }catch (ClassNotFoundException e){
            throw new RuntimeException(e);
        }

        return DriverManager.getConnection("jdbc:mysql://10.13.0.3:3306/java", "iperez", "1111");
    }

    public List<Usuario> getAllUsers(){
        List<Usuario> usuarios = new ArrayList<>();
        try{
            Class.forName("com.mysql.jdbc.Driver");
        }catch (ClassNotFoundException e){
            throw new RuntimeException(e);
        }

        try(Connection connection = getConnection();
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM Usuario")
        ){
            int id,oficio;
            String nombre,apellidos;
            while(rs.next()){
                id=rs.getInt("idUsuario");
                nombre = rs.getString("nombre");
                apellidos= rs.getString("apellidos");
                oficio = rs.getInt("Oficio_idOficio");
                usuarios.add(new Usuario(id,nombre,apellidos,oficio));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return usuarios;
    }

    public List<Oficio> getAllOcupations(){
        List<Oficio> oficios = new ArrayList<>();
        try{
            Class.forName("com.mysql.jdbc.Driver");
        }catch (ClassNotFoundException e){
            throw new RuntimeException(e);
        }

        try(Connection connection = getConnection();
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM Oficio")
        ){
            int idOficio;
            String descripcion;
            while(rs.next()){
                idOficio=rs.getInt("idOficio");
                descripcion = rs.getString("descripcion");
                oficios.add(new Oficio(idOficio,descripcion));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return oficios;
    }

}
