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
import sistema.db.conexion;
import sistema.modelo.administrador;
/**
 *
 * @author unson
 */
public class consultaAdministrador extends conexion {
    public boolean registrar(administrador tadministrador) {
        PreparedStatement ps = null;
        Connection con = getConexion();
        String sql = "INSERT INTO administrador (admin_codigo, admin_usuario, admin_password, admin_nombre, admin_apellido) VALUES(?,?,?,?,?)";
        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1, tadministrador.getAdmin_codigo());
            ps.setString(2, tadministrador.getAdmin_usuario());
            ps.setString(3, tadministrador.getAdmin_password());
            ps.setString(4, tadministrador.getAdmin_nombre());
            ps.setString(5, tadministrador.getAdmin_apellido());
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
    
    public boolean modificar(administrador tadministrador, int id) {
        
     
        PreparedStatement ps = null;
        Connection con = getConexion();
        String sql = "UPDATE administrador SET admin_codigo=?, admin_usuario=?, admin_password=?, admin_nombre=?, admin_apellido=? WHERE admin_codigo =?";
        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1, tadministrador.getAdmin_codigo());
            ps.setString(2, tadministrador.getAdmin_usuario());
            ps.setString(3, tadministrador.getAdmin_password());
            ps.setString(4, tadministrador.getAdmin_nombre());
            ps.setString(5, tadministrador.getAdmin_apellido());
            ps.setInt(6, id);
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
    
    
    public boolean eliminar(administrador tadministrador) {
        PreparedStatement ps = null;
        Connection con = getConexion();

        String sql = "DELETE FROM administrador WHERE admin_codigo = ?";

        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1, tadministrador.getAdmin_codigo());
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
    
    
}