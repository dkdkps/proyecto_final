/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistema.controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import sistema.consulta.consultaCliente;
import sistema.consulta.consultaVendedor;
import sistema.modelo.cliente;
import sistema.modelo.vendedor;
import sistema.vista.frmCliente;
import sistema.vista.frmVendedor;

/**
 *
 * @author unson
 */
public class ctlCliente implements ActionListener{
    
    private vendedor tvendedor;
    private cliente tcliente;
    private consultaCliente cCliente;
    private frmCliente frm;
    
    public ctlCliente(cliente tcliente, consultaCliente cCliente, frmCliente frm) {
        this.tcliente = tcliente;
        this.cCliente = cCliente;
        this.frm = frm;
        
        this.frm.btnRegistrar.addActionListener(this);
        this.frm.btnEditar.addActionListener(this);
        this.frm.btnBorrar.addActionListener(this);
        this.frm.btnLimpiar.addActionListener(this);
        CargarVendedor();
    }
    
    public void iniciar(){
        frm.setTitle("Cliente");
        frm.setLocationRelativeTo(null);
        frm.txtNombre.requestFocus();
    }
    
    public void CargarVendedor() {
        vendedor tvendedor = new vendedor();
        ArrayList vendedores = null;
        try {
            vendedores = cCliente.BuscarVendedor(tvendedor);
        } catch (SQLException ex) {
            Logger.getLogger(ctlNegocio.class.getName()).log(Level.SEVERE, null, ex);
        }
        Iterator<String> i = vendedores.iterator();
        while (i.hasNext()) {
            frm.cboVendedor.addItem(i.next());
        }
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == frm.btnRegistrar) {
            cliente cli = new cliente();
            cli.setVen_nombre(frm.cboVendedor.getSelectedItem().toString());
            
            cli.setCli_nombre(frm.txtNombre.getText());
            cli.setCli_apellido(frm.txtApellido.getText());
            cli.setCli_telefono(frm.txtTelefono.getText());
            cli.setCli_correo(frm.txtCorreo.getText());
            ResultSet rs = cCliente.ObtieneIdVendedor(cli);

            try {
                while (rs.next()) {
                    cli.setVen_codigo(rs.getInt("ven_codigo"));
                }
            } catch (SQLException ex) {
                Logger.getLogger(ctlNegocio.class.getName()).log(Level.SEVERE, null, ex);
            }

            if (cCliente.registrar(cli)) {
                JOptionPane.showMessageDialog(null, "Registrado");
                //limpiar();
            } else {
                JOptionPane.showMessageDialog(null, "Error al Guardar");
                //limpiar();
            }
        }
        
        if (e.getSource() == frm.btnEditar) {
            
            int id = Integer.parseInt(frm.txtCodigo.getText());
            tcliente.setCli_codigo(Integer.parseInt(frm.txtCodigo.getText()));
            
            tcliente.setCli_nombre(frm.txtNombre.getText());
            tcliente.setCli_apellido(frm.txtApellido.getText());
            tcliente.setCli_telefono(frm.txtTelefono.getText());
            tcliente.setCli_correo(frm.txtCorreo.getText());
            
            if (cCliente.modificar(tcliente, id)) {
                JOptionPane.showMessageDialog(null, "Registro Modificado");
                limpiar();
            } else {
                JOptionPane.showMessageDialog(null, "Error al Modificar");
                limpiar();
            }
        }

        if (e.getSource() == frm.btnBorrar) {
            tcliente.setCli_codigo(Integer.parseInt(frm.txtCodigo.getText()));

            if (cCliente.eliminar(tcliente)) {
                JOptionPane.showMessageDialog(null, "Registro Eliminado");
                limpiar();
            } else {
                JOptionPane.showMessageDialog(null, "Error al Eliminar");
                limpiar();
            }
        }
        
        if (e.getSource() == frm.btnLimpiar) {
            limpiar();
        }
    }
    
    public void limpiar() {
        frm.txtCodigo.setText(null);
        frm.txtNombre.setText(null);
        frm.txtApellido.setText(null);
        frm.txtTelefono.setText(null);
        frm.txtCorreo.setText(null);
        
    }
}
