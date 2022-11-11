/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ServiciosDao;

import ModeloVO.InstructorVO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Objects;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JOptionPane;

/**
 *
 * @author alexa
 */
public class InstructorServiciosDao {
    
    public ArrayList<String> llenarInst(String m, String n, JButton bo) throws SQLException, ClassNotFoundException {

        String mi = "", ni = "";
        ArrayList<String> listaInst = new ArrayList<>();
        String sq1 = "SELECT * FROM Instructor";
        try ( Connection conexion3 = Conexion.getConnection();  Statement declaracion = conexion3.createStatement();  ResultSet rs = declaracion.executeQuery(sq1)) {

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

    public void insertar(Connection conexion2, InstructorVO instructor) {

        try {
            PreparedStatement cons;
            cons = conexion2.prepareStatement("INSERT INTO instructor (cedula, nombre, apellido, telefono,"
                    + "especialidad, jornada, hora) "
                    + "VALUES(?, ?, ?,?,?,?)");
            cons.setInt(1, instructor.getCedula());
            cons.setString(2, instructor.getNombre());
            cons.setString(3, instructor.getApellido());
            cons.setString(4, instructor.getTelefono());
            cons.setString(5, instructor.getEspecialidad());
            cons.setString(6, instructor.getJornada());
            cons.setString(7, instructor.getHora());
            
            cons.executeUpdate();
            JOptionPane.showMessageDialog(null, "se guardo el instructor");

        } catch (SQLException e) {

            JOptionPane.showMessageDialog(null, e.getMessage());

        }

    }

    public boolean buscar(Integer cedula) throws SQLException, ClassNotFoundException {
        boolean esta = false;

        Integer cod2 = 0;

        String sq1 = "SELECT cedula FROM clase WHERE cedula = '" + cedula + "'";

        try ( Connection conexion3 = Conexion.getConnection();  Statement declaracion = conexion3.createStatement();  ResultSet rs = declaracion.executeQuery(sq1)) {

            while (rs.next()) {

                cod2 = rs.getInt("codigo");

            }
            esta = Objects.equals(cod2, cedula);

        } catch (SQLException e) {

            System.err.println(e.getMessage());
        }

        return esta;

    }

    public void llenar(Integer codigo, JTextField nom, JTextField ape, JTextField tel,
            JComboBox jor, JComboBox hora, JComboBox esp) throws SQLException, ClassNotFoundException {

        String hor = "",jorn = "", espe="";        
        String sq1 = "SELECT * FROM instructor WHERE codigo = '" + codigo + "'";

        try ( Connection conexion3 = Conexion.getConnection();  Statement declaracion = conexion3.createStatement();  ResultSet rs = declaracion.executeQuery(sq1)) {

            while (rs.next()) {

                nom.setText(rs.getString("nombre"));
                ape.setText(rs.getString("apellido"));
                tel.setText(rs.getString("telefono"));
                hor = rs.getString("hora");
                jorn = rs.getString("jornada");
                espe = rs.getString("especialidad");
            }
            
            if(espe.equalsIgnoreCase("yoga")){
                esp.setSelectedIndex(1);
            }
            if(espe.equalsIgnoreCase("Aerobics")){
                esp.setSelectedIndex(2);
            }
            if(espe.equalsIgnoreCase("Bailoterapia")){
                esp.setSelectedIndex(3);
            }
            
            
            if(hor.equalsIgnoreCase("3:00 pm - 4:00 pm")){
                hora.setSelectedIndex(5);
            }
            if(hor.equalsIgnoreCase("4:00 pm - 5:00 pm")){
                hora.setSelectedIndex(6);
            }
            if(hor.equalsIgnoreCase("5:00 pm - 6:00 pm")){
                hora.setSelectedIndex(7);
            }
            if(hor.equalsIgnoreCase("5:00 pm - 6:00 pm")){
                hora.setSelectedIndex(8);
            }
            if(hor.equalsIgnoreCase("7:00 pm - 8:00 pm")){
                hora.setSelectedIndex(9);
            }
            if(hor.equalsIgnoreCase("8:00 pm - 9:00 pm")){
                hora.setSelectedIndex(10);
            }
            
            
            

        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }

    }

    public void actualizarIns(InstructorVO cs, Integer codigo) throws SQLException, ClassNotFoundException {

        String sql = "UPDATE instructor SET cedula = '" + cs.getCedula()+ "', nombre = '" + cs.getNombre()
                + "', apellido = '" + cs.getApellido()
                + "', telefono = '" + cs.getTelefono()+"', especialidad = '" + cs.getEspecialidad()
                +"', jornada = '" + cs.getJornada()                
                +"', hora = '" + cs.getHora()+"' WHERE codigo = " + codigo + "'";

        try ( Connection conexion2 = Conexion.getConnection();  PreparedStatement pst = conexion2.prepareStatement(sql)) {

            JOptionPane.showMessageDialog(null, "Se actualizó instructor");
            pst.executeUpdate();

        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }

    }

    public void eliminarIns(Integer cedula, InstructorVO cs) throws SQLException, ClassNotFoundException {

        try ( Connection conexion3 = Conexion.getConnection();  Statement declaracion = conexion3.createStatement()) {

            String sql = "DELETE FROM instructor WHERE cedula = '" + cedula + "'";
            declaracion.execute(sql);

            JOptionPane.showMessageDialog(null, "Se elemino instructor");

        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }

    }
    
}
