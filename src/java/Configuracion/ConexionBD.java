/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Configuracion;

import java.sql.*;

/**
 *
 * @author ULISES.VIEYRA
 */
public class ConexionBD {

    private String login = "root";
    private String password = "";
    private String url = "jdbc:mysql://127.0.0.1:3306/sistemabd";
    Connection conn;

    public ConexionBD() {
        try {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            conn = DriverManager.getConnection(url, login, password);
        } catch (Exception ex) {
            System.out.println(ex);
        }

    }

    public Connection getConnection() {
        return conn;
    }

}
