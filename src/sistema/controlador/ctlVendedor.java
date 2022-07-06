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
import sistema.consulta.consultaLocal;
import sistema.consulta.consultaVendedor;
import sistema.modelo.local;
import sistema.modelo.vendedor;
import sistema.vista.frmLocal;
import sistema.vista.frmVendedor;

/**
 *
 * @author unson
 */
public class ctlVendedor implements ActionListener {
    
    private local tlocal;
    private vendedor tvendedor;
    private consultaVendedor cVendedor;
    private frmVendedor frm;
    
    public ctlVendedor(vendedor tvendedor, consultaVendedor cVendedor, frmVendedor frm) {
        this.tvendedor = tvendedor;
        this.cVendedor = cVendedor;
        this.frm = frm;
        
        this.frm.btnRegistrar.addActionListener(this);
        this.frm.btnEditar.addActionListener(this);
        this.frm.btnBorrar.addActionListener(this);
        this.frm.btnLimpiar.addActionListener(this);
        CargarLocal();
    }
    
    public void iniciar(){
        frm.setTitle("Vendedor");
        frm.setLocationRelativeTo(null);
        frm.txtNombre.requestFocus();
    }
    
    public void CargarLocal() {
        local tlocal = new local();
        ArrayList locales = null;
        try {
            locales = cVendedor.BuscarLocal(tlocal);
        } catch (SQLException ex) {
            Logger.getLogger(ctlNegocio.class.getName()).log(Level.SEVERE, null, ex);
        }
        Iterator<String> i = locales.iterator();
        while (i.hasNext()) {
            frm.cboLocal.addItem(i.next());
        }
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == frm.btnRegistrar) {
            vendedor ven = new vendedor();
            ven.setLoc_descripcion(frm.cboLocal.getSelectedItem().toString());
            
            ven.setVen_cedula(frm.txtCedula.getText());
            ven.setVen_nombre(frm.txtNombre.getText());
            ven.setVen_apellido(frm.txtApellido.getText());
            ven.setVen_telefono(frm.txtTelefono.getText());
            ven.setVen_correo(frm.txtCorreo.getText());
            ResultSet rs = cVendedor.ObtieneIdLocal(ven);

            try {
                while (rs.next()) {
                    ven.setLoc_codigo(rs.getInt("loc_codigo"));
                }
            } catch (SQLException ex) {
                Logger.getLogger(ctlNegocio.class.getName()).log(Level.SEVERE, null, ex);
            }

            if (cVendedor.registrar(ven)) {
                JOptionPane.showMessageDialog(null, "Registrado");
                //limpiar();
            } else {
                JOptionPane.showMessageDialog(null, "Error al Guardar");
                //limpiar();
            }
        }
        
        if (e.getSource() == frm.btnEditar) {
            
            int id = Integer.parseInt(frm.txtCodigo.getText());
            tvendedor.setVen_codigo(Integer.parseInt(frm.txtCodigo.getText()));
            tvendedor.setVen_cedula(frm.txtCedula.getText());
            tvendedor.setVen_nombre(frm.txtNombre.getText());
            tvendedor.setVen_apellido(frm.txtApellido.getText());
            tvendedor.setVen_telefono(frm.txtTelefono.getText());
            tvendedor.setVen_correo(frm.txtCorreo.getText());
            
            if (cVendedor.modificar(tvendedor, id)) {
                JOptionPane.showMessageDialog(null, "Registro Modificado");
                limpiar();
            } else {
                JOptionPane.showMessageDialog(null, "Error al Modificar");
                limpiar();
            }
        }

        if (e.getSource() == frm.btnBorrar) {
            tvendedor.setVen_codigo(Integer.parseInt(frm.txtCodigo.getText()));

            if (cVendedor.eliminar(tvendedor)) {
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
        frm.txtCedula.setText(null);
        frm.txtNombre.setText(null);
        frm.txtApellido.setText(null);
        frm.txtTelefono.setText(null);
        frm.txtCorreo.setText(null);
        
    }
}
