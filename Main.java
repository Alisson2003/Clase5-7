package org.example;

import java.awt.event.ActionEvent;
import java.sql.*;

public class Main {
    public static void main(String[] args) {
        //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
        // to see how IntelliJ IDEA suggests fixing it.

        String url="jdbc:mysql://localhost:3306/estudiantes";
        String user="root";
        String password="123456";

        String nombre="Pedro Perez";
        String cedula="17154878";
        Double b1=12.4;
        Double b2=10.4;

        String sql = "INSERT INTO estudiantes (cedula, nombre, b1, b2) VALUES (?, ?, ?, ?)";



        try (Connection connection= DriverManager.getConnection(url,user,password)){
            PreparedStatement cadenaPreparada = connection.prepareStatement(sql);

            cadenaPreparada.setString(1, cedula);
            cadenaPreparada.setString(2, nombre);
            cadenaPreparada.setDouble(3, b1);
            cadenaPreparada.setDouble(4, b2);

            cadenaPreparada.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }}
