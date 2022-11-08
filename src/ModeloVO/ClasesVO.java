/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ModeloVO;

/**
 *
 * @author alexa
 */
public class ClasesVO {
    
    private Integer codigo;
    private String clase;
    private String horario;
    private Integer cod_instructor;

    public ClasesVO() {
    }

    public ClasesVO(Integer codigo, String clase, String horario, Integer cod_instructor) {
        this.codigo = codigo;
        this.clase = clase;
        this.horario = horario;
        this.cod_instructor = cod_instructor;
    }

    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    public String getClase() {
        return clase;
    }

    public void setClase(String clase) {
        this.clase = clase;
    }

    public String getHorario() {
        return horario;
    }

    public void setHorario(String horario) {
        this.horario = horario;
    }

    public Integer getCod_instructor() {
        return cod_instructor;
    }

    public void setCod_instructor(Integer cod_instructor) {
        this.cod_instructor = cod_instructor;
    }
    
    
    
}
