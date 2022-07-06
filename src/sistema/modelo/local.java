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
public class local {
    
    private int neg_codigo;
    private String neg_descripcion;
    private int loc_codigo;
    private String loc_descripcion;
    
    
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
