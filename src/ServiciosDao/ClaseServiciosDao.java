/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ServiciosDao;

import ModeloVO.ClasesVO;
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

    public void insertar(Connection conexion2, ClasesVO clase) {

        try {
            PreparedStatement cons;
            cons = conexion2.prepareStatement("INSERT INTO clase (codigo, clase, horario, cod_instructor) "
                    + "VALUES(?, ?, ?,?)");
            cons.setInt(1, clase.getCodigo());
            cons.setString(2, clase.getClase());
            cons.setString(3, clase.getHorario());
            cons.setInt(4, clase.getCod_instructor());
            cons.executeUpdate();
            JOptionPane.showMessageDialog(null, "se guardo la clase");

        } catch (SQLException e) {

            JOptionPane.showMessageDialog(null, e.getMessage());

        }

    }

    public boolean buscar(Integer codigo) throws SQLException, ClassNotFoundException {
        boolean esta = false;

        Integer cod2 = 0;

        String sq1 = "SELECT codigo FROM clase WHERE codigo = '" + codigo + "'";

        try ( Connection conexion3 = Conexion.getConnection();  Statement declaracion = conexion3.createStatement();  ResultSet rs = declaracion.executeQuery(sq1)) {

            while (rs.next()) {

                cod2 = rs.getInt("codigo");

            }
            esta = Objects.equals(cod2, codigo);

        } catch (SQLException e) {

            System.err.println(e.getMessage());
        }

        return esta;

    }

    public void llenar(Integer codigo, JComboBox clase, JComboBox hora, JComboBox instructor) throws SQLException, ClassNotFoundException {

        String sq1 = "SELECT * FROM clase WHERE codigo = '" + codigo + "'";

        try ( Connection conexion3 = Conexion.getConnection();  Statement declaracion = conexion3.createStatement();  ResultSet rs = declaracion.executeQuery(sq1)) {

            while (rs.next()) {

                clase.setSelectedItem(rs.getString("clase"));
                hora.setSelectedItem(rs.getString("horario"));
                instructor.setSelectedItem("cod_instructor");

            }

        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }

    }

    public void actualizarIns(ClasesVO cs, Integer codigo) throws SQLException, ClassNotFoundException {

        String sql = "UPDATE clase SET codigo= '" + cs.getCodigo() + "', clase = '" + cs.getClase()
                + "', horario = '" + cs.getHorario()
                + "', cod_instructor = '" + cs.getCod_instructor() + "' WHERE codigo = " + codigo + "'";

        try ( Connection conexion2 = Conexion.getConnection();  PreparedStatement pst = conexion2.prepareStatement(sql)) {

            JOptionPane.showMessageDialog(null, "Se actualizó clase");
            pst.executeUpdate();

        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }

    }

    public void eliminarIns(Integer codigo, ClasesVO cs) throws SQLException, ClassNotFoundException {

        try ( Connection conexion3 = Conexion.getConnection();  Statement declaracion = conexion3.createStatement()) {

            String sql = "DELETE FROM clase WHERE codigo = '" + codigo + "'";
            declaracion.execute(sql);

            JOptionPane.showMessageDialog(null, "Se elemino clase");

        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }

    }

}
