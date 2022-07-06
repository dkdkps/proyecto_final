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
public class vendedor {
    
    private int loc_codigo;
    private String loc_descripcion;
    private int ven_codigo;
    private String ven_cedula;
    private String ven_nombre;
    private String ven_apellido;
    private String ven_telefono;
    private String ven_correo;
    
    
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
    
    public String getVen_telefono() {
        return ven_telefono;
    }

    public void setVen_telefono(String ven_telefono) {
        this.ven_telefono = ven_telefono;
    }
    
    public String getVen_correo() {
        return ven_correo;
    }

    public void setVen_correo(String ven_correo) {
        this.ven_correo = ven_correo;
    }
    
    
    public int getLoc_codigo() {
        return loc_codigo;
    }

    public void setLoc_codigo(int loc_codigo) {
        this.loc_codigo = loc_codigo;
    }

    public String getLoc_descripcion() {
        return loc_descripcion;
    }

    public void setLoc_descripcion(String loc_descripcion) {
        this.loc_descripcion = loc_descripcion;
    }
}
