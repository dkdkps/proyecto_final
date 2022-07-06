/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistema.consulta;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import sistema.db.conexion;
import sistema.modelo.pais;
import sistema.vista.frmPais;

/**
 *
 * @author unson
 */
public class consultaPais extends conexion {
    
    
    
    
    public boolean buscar(pais tpais) {
        PreparedStatement ps = null;
        ResultSet rs = null;
        Connection con = getConexion();
        String sql = "SELECT * FROM pais WHERE pais_codigo = ? OR  pais_descripcion = ? ";
        try {
            ps = con.prepareStatement(sql);
            
            
            ps.setInt(1, tpais.getPais_codigo());
            ps.setString(2, tpais.getPais_descripcion());

            rs = ps.executeQuery();
            if (rs.next()) {
                tpais.setPais_codigo(Integer.parseInt(rs.getString("pais_codigo")));
                tpais.setPais_descripcion(rs.getString("pais_descripcion"));
                return true;
            }
            return false;
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
    
    public boolean registrar(pais tpais) {
        PreparedStatement ps = null;
        Connection con = getConexion();
        String sql = "INSERT INTO pais (pais_codigo, pais_descripcion) VALUES(?,?)";
        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1, tpais.getPais_codigo());
            ps.setString(2, tpais.getPais_descripcion());
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
    
    public boolean modificar(pais tpais, int id) {
        
        
        PreparedStatement ps = null;
        Connection con = getConexion();
        String sql = "UPDATE pais SET pais_codigo=?, pais_descripcion=? WHERE pais_codigo =?";
        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1, tpais.getPais_codigo());
            ps.setString(2, tpais.getPais_descripcion());
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
    
    public boolean eliminar(pais tpais) {
        PreparedStatement ps = null;
        Connection con = getConexion();

        String sql = "DELETE FROM pais WHERE pais_codigo = ?";

        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1, tpais.getPais_codigo());
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
