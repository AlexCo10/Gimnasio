/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ServiciosDao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class Conexion {

    private static final String URL = "jdbc:mysql://localhost/gimnasio";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "";

    //private static Connection cnx = null;
    public static Connection getConnection() throws SQLException, ClassNotFoundException {
        Connection conecction = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conecction = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            System.out.println("conexion realizada con exito");
        } catch (ClassNotFoundException | SQLException e) {
            JOptionPane.showMessageDialog(null, e);
            JOptionPane.showMessageDialog(null, "conexion fallida");
        }

        return conecction;

    }

}
