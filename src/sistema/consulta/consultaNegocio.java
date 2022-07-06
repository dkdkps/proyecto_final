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
import sistema.modelo.negocio;
import sistema.modelo.pais;

/**
 *
 * @author unson
 */
public class consultaNegocio extends conexion {
    
    public ArrayList BuscarPais(pais tpais) throws SQLException {
        PreparedStatement ps = null;
        ResultSet rs = null;
        java.sql.Connection con = getConexion();
        //com.mysql.jdbc.Connection con = (com.mysql.jdbc.Connection) getConexion();
        String sql = "SELECT * FROM pais";
        ArrayList<String> pais = new ArrayList();
        try {
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                String lsDescripcion = rs.getString("pais_descripcion");
                pais.add(lsDescripcion);
            }

        } catch (SQLException e) {
            System.err.println(e);
        } finally {

            con.close();

        }
        return pais;
    }

    
    
    
     
     public ResultSet ObtieneIdPais(negocio neg){
         PreparedStatement ps = null;
         ResultSet rs = null;
         java.sql.Connection con = getConexion();
         String sql = "SELECT pais_codigo from pais where pais_descripcion like '%" + neg.getPais_descripcion() + "%';";
         try {
             ps = con.prepareCall(sql);
             rs = ps.executeQuery();
             return rs;
         } catch (SQLException e) {
             System.err.println(e);
             return rs;
         
         }
     
    }
     
     public boolean registrar(negocio tnegocio) {
        PreparedStatement ps = null;
        Connection con = getConexion();
        String sql = "INSERT INTO negocio (neg_codigo, neg_descripcion, pais_codigo) VALUES(?,?,?)";
        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1, tnegocio.getNeg_codigo());
            ps.setString(2, tnegocio.getNeg_descripcion());
            ps.setInt(3, tnegocio.getPais_codigo());
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
     
     public boolean modificar(negocio tnegocio, int id) {
        
        
        PreparedStatement ps = null;
        Connection con = getConexion();
        String sql = "UPDATE negocio SET neg_codigo=?, neg_descripcion=? WHERE neg_codigo =?";
        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1, tnegocio.getNeg_codigo());
            ps.setString(2, tnegocio.getNeg_descripcion());
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
     
     public boolean eliminar(negocio tnegocio) {
        PreparedStatement ps = null;
        Connection con = getConexion();

        String sql = "DELETE FROM negocio WHERE neg_codigo = ?";

        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1, tnegocio.getNeg_codigo());
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
    
    
    
    public ArrayList ListaPais() {
        ArrayList<String> lista = new ArrayList();
        PreparedStatement ps = null;
        ResultSet rs = null;
        java.sql.Connection con = getConexion();

        String sql = "SELECT * FROM pais";
        try {
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                String paq = rs.getString("pais_descripcion");
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
