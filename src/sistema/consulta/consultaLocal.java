/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistema.consulta;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import sistema.db.conexion;
import sistema.modelo.local;
import sistema.modelo.negocio;

/**
 *
 * @author unson
 */
public class consultaLocal extends conexion{
    
    public ArrayList BuscarNegocio(negocio tnegocio) throws SQLException {
        PreparedStatement ps = null;
        ResultSet rs = null;
        java.sql.Connection con = getConexion();
        //com.mysql.jdbc.Connection con = (com.mysql.jdbc.Connection) getConexion();
        String sql = "SELECT * FROM negocio";
        ArrayList<String> negocio = new ArrayList();
        try {
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                String lsDescripcion = rs.getString("neg_descripcion");
                negocio.add(lsDescripcion);
            }

        } catch (SQLException e) {
            System.err.println(e);
        } finally {

            con.close();

        }
        return negocio;
    }

    
    
    
     
     public ResultSet ObtieneIdNegocio(local loc){
         PreparedStatement ps = null;
         ResultSet rs = null;
         java.sql.Connection con = getConexion();
         String sql = "SELECT neg_codigo from negocio where neg_descripcion like '%" + loc.getNeg_descripcion() + "%';";
         try {
             ps = con.prepareCall(sql);
             rs = ps.executeQuery();
             return rs;
         } catch (SQLException e) {
             System.err.println(e);
             return rs;
         
         }
     
    }
     
     public boolean registrar(local tloc) {
        PreparedStatement ps = null;
        Connection con = getConexion();
        String sql = "INSERT INTO local (loc_codigo, loc_descripcion, neg_codigo) VALUES(?,?,?)";
        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1, tloc.getLoc_codigo());
            ps.setString(2, tloc.getLoc_descripcion());
            ps.setInt(3, tloc.getNeg_codigo());
            ps.execute();
            return true;
        } catch (SQLException e) {
            System.err.println(e);
            return false;
        } finally {
            try {
                con.close();
            } catch (SQLException e) {
                System.err.println(e);
            }
        }
    }
     
     public boolean modificar(local tloc, int id) {
        
        
        PreparedStatement ps = null;
        Connection con = getConexion();
        String sql = "UPDATE local SET loc_codigo=?, loc_descripcion=? WHERE loc_codigo =?";
        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1, tloc.getLoc_codigo());
            ps.setString(2, tloc.getLoc_descripcion());
            ps.setInt(3, id);
            ps.executeUpdate();
            return true;
        } catch (SQLException e) {
            System.err.println(e);
            return false;
        } finally {
            try {
                con.close();
            } catch (SQLException e) {
                System.err.println(e);
            }
        }
    }
     
     public boolean eliminar(local tloc) {
        PreparedStatement ps = null;
        Connection con = getConexion();

        String sql = "DELETE FROM local WHERE loc_codigo = ?";

        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1, tloc.getLoc_codigo());
            ps.executeUpdate();
            return true;
        } catch (SQLException e) {
            System.err.println(e);
            return false;
        } finally {
            try {
                con.close();
            } catch (SQLException e) {
                System.err.println(e);
            }
        }
    }  
    
    
    
    public ArrayList ListaNegocio() {
        ArrayList<String> lista = new ArrayList();
        PreparedStatement ps = null;
        ResultSet rs = null;
        java.sql.Connection con = getConexion();

        String sql = "SELECT * FROM negocio";
        try {
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                String paq = rs.getString("neg_descripcion");
                lista.add(paq);
            }

        } catch (SQLException e) {
            System.err.println(e);
        } finally {
            try {
                con.close();
            } catch (SQLException e) {
                System.err.println(e);
            }
        }
        return lista;
    }
}
