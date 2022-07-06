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
import sistema.modelo.vendedor;

/**
 *
 * @author unson
 */
public class consultaVendedor extends conexion{
    public ArrayList BuscarLocal(local tlocal) throws SQLException {
        PreparedStatement ps = null;
        ResultSet rs = null;
        java.sql.Connection con = getConexion();
        //com.mysql.jdbc.Connection con = (com.mysql.jdbc.Connection) getConexion();
        String sql = "SELECT * FROM local";
        ArrayList<String> local = new ArrayList();
        try {
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                String lsDescripcion = rs.getString("loc_descripcion");
                local.add(lsDescripcion);
            }

        } catch (SQLException e) {
            System.err.println(e);
        } finally {

            con.close();

        }
        return local;
    }

    
    
    
     
     public ResultSet ObtieneIdLocal(vendedor ven){
         PreparedStatement ps = null;
         ResultSet rs = null;
         java.sql.Connection con = getConexion();
         String sql = "SELECT loc_codigo from local where loc_descripcion like '%" + ven.getLoc_descripcion() + "%';";
         try {
             ps = con.prepareCall(sql);
             rs = ps.executeQuery();
             return rs;
         } catch (SQLException e) {
             System.err.println(e);
             return rs;
         
         }
     
    }
     
     public boolean registrar(vendedor tven) {
        PreparedStatement ps = null;
        Connection con = getConexion();
        String sql = "INSERT INTO vendedor (ven_codigo, ven_cedula, ven_nombre, ven_apellido, ven_telefono, ven_correo, loc_codigo) VALUES(?,?,?,?,?,?,?)";
        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1, tven.getVen_codigo());
            ps.setString(2, tven.getVen_cedula());
            ps.setString(3, tven.getVen_nombre());
            ps.setString(4, tven.getVen_apellido());
            ps.setString(5, tven.getVen_telefono());
            ps.setString(6, tven.getVen_correo());
            ps.setInt(7, tven.getLoc_codigo());
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
     
     public boolean modificar(vendedor tven, int id) {
        
        
        PreparedStatement ps = null;
        Connection con = getConexion();
        String sql = "UPDATE vendedor SET ven_codigo=?, ven_cedula=?, ven_nombre=?, ven_apellido=?, ven_telefono=?, ven_correo=? WHERE ven_codigo =?";
        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1, tven.getVen_codigo());
            ps.setString(2, tven.getVen_cedula());
            ps.setString(3, tven.getVen_nombre());
            ps.setString(4, tven.getVen_apellido());
            ps.setString(5, tven.getVen_telefono());
            ps.setString(6, tven.getVen_correo());
            ps.setInt(7, id);
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
     
     public boolean eliminar(vendedor tven) {
        PreparedStatement ps = null;
        Connection con = getConexion();

        String sql = "DELETE FROM vendedor WHERE ven_codigo = ?";

        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1, tven.getVen_codigo());
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
    
    
    
    public ArrayList ListaLocal() {
        ArrayList<String> lista = new ArrayList();
        PreparedStatement ps = null;
        ResultSet rs = null;
        java.sql.Connection con = getConexion();

        String sql = "SELECT * FROM local";
        try {
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                String paq = rs.getString("loc_descripcion");
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
