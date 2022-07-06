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
import sistema.consulta.consultaNegocio;
import sistema.modelo.local;
import sistema.modelo.negocio;
import sistema.vista.frmLocal;
import sistema.vista.frmNegocio;

/**
 *
 * @author unson
 */
public class ctlLocal implements ActionListener{
    
    private negocio tnegocio;
    private local tlocal;
    private consultaLocal cLocal;
    private frmLocal frm;
    
    public ctlLocal(local tlocal, consultaLocal cLocal, frmLocal frm) {
        this.tlocal = tlocal;
        this.cLocal = cLocal;
        this.frm = frm;
        
        this.frm.btnRegistrar.addActionListener(this);
        this.frm.btnEditar.addActionListener(this);
        this.frm.btnBorrar.addActionListener(this);
        this.frm.btnLimpiar.addActionListener(this);
        CargarNegocio();
    }
    
    public void iniciar(){
        frm.setTitle("Local");
        frm.setLocationRelativeTo(null);
        frm.txtDescripcion.requestFocus();
    }
    
    public void CargarNegocio() {
        negocio tnegocio = new negocio();
        ArrayList negocios = null;
        try {
            negocios = cLocal.BuscarNegocio(tnegocio);
        } catch (SQLException ex) {
            Logger.getLogger(ctlNegocio.class.getName()).log(Level.SEVERE, null, ex);
        }
        Iterator<String> i = negocios.iterator();
        while (i.hasNext()) {
            frm.cboNegocio.addItem(i.next());
        }
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == frm.btnRegistrar) {
            local loc = new local();
            loc.setNeg_descripcion(frm.cboNegocio.getSelectedItem().toString());
            loc.setLoc_descripcion(frm.txtDescripcion.getText());
            ResultSet rs = cLocal.ObtieneIdNegocio(loc);

            try {
                while (rs.next()) {
                    loc.setNeg_codigo(rs.getInt("neg_codigo"));
                }
            } catch (SQLException ex) {
                Logger.getLogger(ctlNegocio.class.getName()).log(Level.SEVERE, null, ex);
            }

            if (cLocal.registrar(loc)) {
                JOptionPane.showMessageDialog(null, "Registrado");
                //limpiar();
            } else {
                JOptionPane.showMessageDialog(null, "Error al Guardar");
                //limpiar();
            }
        }
        
        if (e.getSource() == frm.btnEditar) {
            
            int id = Integer.parseInt(frm.txtCodigo.getText());
            tlocal.setLoc_codigo(Integer.parseInt(frm.txtCodigo.getText()));
            tlocal.setLoc_descripcion(frm.txtDescripcion.getText());
            if (cLocal.modificar(tlocal, id)) {
                JOptionPane.showMessageDialog(null, "Registro Modificado");
                limpiar();
            } else {
                JOptionPane.showMessageDialog(null, "Error al Modificar");
                limpiar();
            }
        }

        if (e.getSource() == frm.btnBorrar) {
            tlocal.setLoc_codigo(Integer.parseInt(frm.txtCodigo.getText()));

            if (cLocal.eliminar(tlocal)) {
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
        frm.txtDescripcion.setText(null);
    }
}
