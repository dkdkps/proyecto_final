/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistema.modelo;

/**
 *
 * @author unson
 */
public class cliente {
   
    private int ven_codigo;
    private String ven_cedula;
    private String ven_nombre;
    private String ven_apellido;
    
    
    private int cli_codigo;
    private String cli_nombre;
    private String cli_apellido;
    private String cli_telefono;
    private String cli_correo;
    
    
    public int getCli_codigo() {
        return ven_codigo;
    }

    public void setCli_codigo(int cli_codigo) {
        this.cli_codigo = cli_codigo;
    }
    
    public String getCli_nombre() {
        return cli_nombre;
    }

    public void setCli_nombre(String cli_nombre) {
        this.cli_nombre = cli_nombre;
    }
    
    public String getCli_apellido() {
        return cli_apellido;
    }

    public void setCli_apellido(String cli_apellido) {
        this.cli_apellido = cli_apellido;
    }
    
    public String getCli_telefono() {
        return cli_telefono;
    }

    public void setCli_telefono(String cli_telefono) {
        this.cli_telefono = cli_telefono;
    }
    
    public String getCli_correo() {
        return cli_correo;
    }

    public void setCli_correo(String cli_correo) {
        this.cli_correo = cli_correo;
    }
    
    
    
    public int getVen_codigo() {
        return ven_codigo;
    }

    public void setVen_codigo(int ven_codigo) {
        this.ven_codigo = ven_codigo;
    }

    public String getVen_cedula() {
        return ven_cedula;
    }

    public void setVen_cedula(String ven_cedula) {
        this.ven_cedula = ven_cedula;
    }
    
    public String getVen_nombre() {
        return ven_nombre;
    }

    public void setVen_nombre(String ven_nombre) {
        this.ven_nombre = ven_nombre;
    }
    
    public String getVen_apellido() {
        return ven_apellido;
    }

    public void setVen_apellido(String ven_apellido) {
        this.ven_apellido = ven_apellido;
    }
    
    
    
    
    
}
