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
import sistema.consulta.consultaNegocio;
import sistema.modelo.negocio;
import sistema.modelo.pais;
import sistema.vista.frmNegocio;

/**
 *
 * @author unson
 */
public class ctlNegocio implements ActionListener{
    
    private pais tpais;
    private negocio tnegocio;
    private consultaNegocio cNegocio;
    private frmNegocio frm;
    
    public ctlNegocio(negocio tnegocio, consultaNegocio cNegocio, frmNegocio frm) {
        this.tnegocio = tnegocio;
        this.cNegocio = cNegocio;
        this.frm = frm;
        
        this.frm.btnRegistrar.addActionListener(this);
        this.frm.btnEditar.addActionListener(this);
        this.frm.btnBorrar.addActionListener(this);
        this.frm.btnLimpiar.addActionListener(this);
        CargarPais();
    }
    
    public void iniciar(){
        frm.setTitle("Negocio");
        frm.setLocationRelativeTo(null);
        frm.txtDescripcion.requestFocus();
    }
    
    public void CargarPais() {
        pais tpais = new pais();
        ArrayList paises = null;
        try {
            paises = cNegocio.BuscarPais(tpais);
        } catch (SQLException ex) {
            Logger.getLogger(ctlNegocio.class.getName()).log(Level.SEVERE, null, ex);
        }
        Iterator<String> i = paises.iterator();
        while (i.hasNext()) {
            frm.cboPais.addItem(i.next());
        }
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == frm.btnRegistrar) {
            negocio nego = new negocio();
            nego.setPais_descripcion(frm.cboPais.getSelectedItem().toString());
            nego.setNeg_descripcion(frm.txtDescripcion.getText());
            ResultSet rs = cNegocio.ObtieneIdPais(nego);

            try {
                while (rs.next()) {
                    nego.setPais_codigo(rs.getInt("pais_codigo"));
//                    nego.setPais_descripcion(rs.getString("pais_descripcion"));
                }
            } catch (SQLException ex) {
                Logger.getLogger(ctlNegocio.class.getName()).log(Level.SEVERE, null, ex);
            }

            if (cNegocio.registrar(nego)) {
                JOptionPane.showMessageDialog(null, "Registrado");
                //limpiar();
            } else {
                JOptionPane.showMessageDialog(null, "Error al Guardar");
                //limpiar();
            }
        }
            if (e.getSource() == frm.btnEditar) {
            
            int id = Integer.parseInt(frm.txtCodigo.getText());
            tnegocio.setNeg_codigo(Integer.parseInt(frm.txtCodigo.getText()));
            tnegocio.setNeg_descripcion(frm.txtDescripcion.getText());
            if (cNegocio.modificar(tnegocio, id)) {
                JOptionPane.showMessageDialog(null, "Registro Modificado");
                limpiar();
            } else {
                JOptionPane.showMessageDialog(null, "Error al Modificar");
                limpiar();
            }
        }

        if (e.getSource() == frm.btnBorrar) {
            tnegocio.setNeg_codigo(Integer.parseInt(frm.txtCodigo.getText()));

            if (cNegocio.eliminar(tnegocio)) {
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
