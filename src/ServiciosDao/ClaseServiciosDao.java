/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ServiciosDao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import java.util.ArrayList;
import java.util.Objects;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JComboBox;
//import modeloVo.ClaseVo;

public class ClaseServiciosDao {

    public ArrayList<String> llenarInst(String m, String n, JButton bo){
        
        String mi = "", ni = "";
        ArrayList<String> listaInst = new ArrayList<>();
        String sq1 = "SELECT * FROM Instructor";
        try ( Connection conexion3 = Conexion.getConnection();
                Statement declaracion = conexion3.createStatement();
                ResultSet rs = declaracion.executeQuery(sq1)) {

            listaInst.add("Seleccione Instructor");

            while (rs.next()) {
                mi = rs.getString("especialidad");
                ni = rs.getString("hora");
                if (mi.equals(m) && n.equals(ni)) {
                    listaInst.add(rs.getString("codigo"));
                    bo.setEnabled(true);
                }
            }

        } catch (SQLException e) {

            System.err.print(e.getMessage());

        }
        return listaInst;

    }

}
