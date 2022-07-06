/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistema.controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import sistema.consulta.consultaPais;
import sistema.modelo.pais;
import sistema.vista.frmPais;

/**
 *
 * @author unson
 */
public class ctlPais implements ActionListener{
    
    private pais tpais;
    private consultaPais cPais;
    private frmPais frm;
    
    
    public ctlPais(pais tpais, consultaPais cPais, frmPais frm) {
        this.tpais = tpais;
        this.cPais = cPais;
        this.frm = frm;
        
        this.frm.btnRegistrar.addActionListener(this);
        this.frm.btnEditar.addActionListener(this);
        this.frm.btnBorrar.addActionListener(this);
        this.frm.btnLimpiar.addActionListener(this);
        
    }
    
    public void iniciar() {
        // this.deshabilitar_botones();
        frm.setTitle("Pais");
        frm.setLocationRelativeTo(null);
        frm.txtCodigo.setVisible(true);
        frm.txtCodigo.setEnabled(true);
        frm.txtDescripcion.setVisible(true);
        frm.txtDescripcion.requestFocus();
        frm.jScrollPane1.setVisible(true);

    }
    
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == frm.btnRegistrar) {
            tpais.setPais_descripcion(frm.txtDescripcion.getText());

            if (cPais.registrar(tpais)) {
                JOptionPane.showMessageDialog(null, "Registrado");
                limpiar();
            } else {
                JOptionPane.showMessageDialog(null, "Error al Guardar");
                limpiar();
            }
        }

        if (e.getSource() == frm.btnEditar) {
            
            int id = Integer.parseInt(frm.txtCodigo.getText());
            tpais.setPais_codigo(Integer.parseInt(frm.txtCodigo.getText()));
            tpais.setPais_descripcion(frm.txtDescripcion.getText());
            if (cPais.modificar(tpais, id)) {
                JOptionPane.showMessageDialog(null, "Registro Modificado");
                limpiar();
            } else {
                JOptionPane.showMessageDialog(null, "Error al Modificar");
                limpiar();
            }
        }

        if (e.getSource() == frm.btnBorrar) {
            tpais.setPais_codigo(Integer.parseInt(frm.txtCodigo.getText()));

            if (cPais.eliminar(tpais)) {
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
