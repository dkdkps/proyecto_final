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
public class negocio {
    private int pais_codigo;
    private String pais_descripcion;
    private int neg_codigo;
    private String neg_descripcion;
    
    
    public int getPais_codigo() {
        return pais_codigo;
    }

    public void setPais_codigo(int pais_codigo) {
        this.pais_codigo = pais_codigo;
    }

    public String getPais_descripcion() {
        return pais_descripcion;
    }

    public void setPais_descripcion(String pais_descripcion) {
        this.pais_descripcion = pais_descripcion;
    }
    
    public int getNeg_codigo() {
        return neg_codigo;
    }

    public void setNeg_codigo(int neg_codigo) {
        this.neg_codigo = neg_codigo;
    }

    public String getNeg_descripcion() {
        return neg_descripcion;
    }

    public void setNeg_descripcion(String neg_descripcion) {
        this.neg_descripcion = neg_descripcion;
    }
}
