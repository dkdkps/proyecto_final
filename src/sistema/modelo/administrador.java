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
public class administrador {
    private int admin_codigo;
    private String admin_usuario;
    private String admin_password;
    private String admin_nombre;
    private String admin_apellido;
    
    
    public int getAdmin_codigo() {
        return admin_codigo;
    }

    public void setAdmin_codigo(int admin_codigo) {
        this.admin_codigo = admin_codigo;
    }
    
    public String getAdmin_usuario() {
        return admin_usuario;
    }

    public void setAdmin_usuario(String admin_usuario) {
        this.admin_usuario = admin_usuario;
    }
    
    public String getAdmin_password() {
        return admin_password;
    }

    public void setAdmin_password(String admin_password) {
        this.admin_password = admin_password;
    }
    
    public String getAdmin_nombre() {
        return admin_nombre;
    }

    public void setAdmin_nombre(String admin_nombre) {
        this.admin_nombre = admin_nombre;
    }
    
    public String getAdmin_apellido() {
        return admin_apellido;
    }

    public void setAdmin_apellido(String admin_apellido) {
        this.admin_apellido = admin_apellido;
    }
    
}
