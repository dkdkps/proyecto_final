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
import sistema.modelo.cliente;
import sistema.modelo.vendedor;

/**
 *
 * @author unson
 */
public class consultaCliente extends conexion {
    public ArrayList BuscarVendedor(vendedor tvendedor) throws SQLException {
        PreparedStatement ps = null;
        ResultSet rs = null;
        java.sql.Connection con = getConexion();
        //com.mysql.jdbc.Connection con = (com.mysql.jdbc.Connection) getConexion();
        String sql = "SELECT * FROM vendedor";
        ArrayList<String> vendedor = new ArrayList();
        try {
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                String lsDescripcion = rs.getString("ven_nombre");
                vendedor.add(lsDescripcion);
            }

        } catch (SQLException e) {
            System.err.println(e);
        } finally {

            con.close();

        }
        return vendedor;
    }

    
    
    
     
     public ResultSet ObtieneIdVendedor(cliente cli){
         PreparedStatement ps = null;
         ResultSet rs = null;
         java.sql.Connection con = getConexion();
         String sql = "SELECT ven_codigo from vendedor where ven_nombre like '%" + cli.getVen_nombre() + "%';";
         try {
             ps = con.prepareCall(sql);
             rs = ps.executeQuery();
             return rs;
         } catch (SQLException e) {
             System.err.println(e);
             return rs;
         
         }
     
    }
     
     public boolean registrar(cliente tcli) {
        PreparedStatement ps = null;
        Connection con = getConexion();
        String sql = "INSERT INTO cliente (cli_codigo, cli_nombre, cli_apellido, cli_telefono, cli_correo, ven_codigo) VALUES(?,?,?,?,?,?)";
        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1, tcli.getCli_codigo());
            ps.setString(2, tcli.getCli_nombre());
            ps.setString(3, tcli.getCli_apellido());
            ps.setString(4, tcli.getCli_telefono());
            ps.setString(5, tcli.getCli_correo());
            ps.setInt(6, tcli.getVen_codigo());
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
     
     public boolean modificar(cliente tcli, int id) {
        
        
        PreparedStatement ps = null;
        Connection con = getConexion();
        String sql = "UPDATE cliente SET cli_codigo=?, cli_nombre=?, cli_apellido=?, cli_telefono=?, cli_correo=? WHERE cli_codigo =?";
        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1, tcli.getCli_codigo());
            ps.setString(2, tcli.getCli_nombre());
            ps.setString(3, tcli.getCli_apellido());
            ps.setString(4, tcli.getCli_telefono());
            ps.setString(5, tcli.getCli_correo());
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
     
     public boolean eliminar(cliente tcli) {
        PreparedStatement ps = null;
        Connection con = getConexion();

        String sql = "DELETE FROM cliente WHERE cli_codigo = ?";

        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1, tcli.getCli_codigo());
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
    
    
    
    public ArrayList ListaVendedor() {
        ArrayList<String> lista = new ArrayList();
        PreparedStatement ps = null;
        ResultSet rs = null;
        java.sql.Connection con = getConexion();

        String sql = "SELECT * FROM vendedor";
        try {
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                String paq = rs.getString("ven_nombre");
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
