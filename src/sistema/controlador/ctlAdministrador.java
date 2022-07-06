/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistema.controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import sistema.consulta.consultaAdministrador;
import sistema.modelo.administrador;
import sistema.vista.frmRegistrar;
/**
 *
 * @author unson
 */
public class ctlAdministrador implements ActionListener {
    
    private administrador tadministrador;
    private consultaAdministrador cadministrador;
    private frmRegistrar frm;
    
    public ctlAdministrador(administrador tadministrador, consultaAdministrador cadministrador, frmRegistrar frm) {
        this.tadministrador = tadministrador;
        this.cadministrador = cadministrador;
        this.frm = frm;
        
        this.frm.btnRegistrar.addActionListener(this);
        this.frm.btnEditar.addActionListener(this);
        this.frm.btnBorrar.addActionListener(this);
        this.frm.btnLimpiar.addActionListener(this);
    }
    
    public void iniciar() {
        // this.deshabilitar_botones();
        frm.setTitle("Administrador");
        frm.setLocationRelativeTo(null);
        frm.txtNombre.setVisible(true);
        frm.txtNombre.setEnabled(true);
        frm.txtNombre.requestFocus();
        frm.txtApellido.setVisible(true);
        frm.txtApellido.setEnabled(true);
        frm.txtUsuario.setVisible(true);
        frm.txtUsuario.setEnabled(true);
        frm.txtPassword.setVisible(true);
        frm.txtPassword.setEnabled(true);
 
    }
    
 
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == frm.btnRegistrar) {
            
            tadministrador.setAdmin_nombre(frm.txtNombre.getText());
            tadministrador.setAdmin_apellido(frm.txtApellido.getText());
            tadministrador.setAdmin_usuario(frm.txtUsuario.getText());
            tadministrador.setAdmin_password(frm.txtPassword.getText());

            if (cadministrador.registrar(tadministrador)) {
                JOptionPane.showMessageDialog(null, "Registrado");
                limpiar();
            } else {
                JOptionPane.showMessageDialog(null, "Error al Guardar");
                limpiar();
            }
        }
        
        if (e.getSource() == frm.btnEditar) {
         
            int id = Integer.parseInt(frm.txtCodigo.getText());
            tadministrador.setAdmin_codigo(Integer.parseInt(frm.txtCodigo.getText()));
            tadministrador.setAdmin_usuario(frm.txtUsuario.getText());
            tadministrador.setAdmin_password(frm.txtPassword.getText());
            tadministrador.setAdmin_nombre(frm.txtNombre.getText());
            tadministrador.setAdmin_apellido(frm.txtApellido.getText());
            if (cadministrador.modificar(tadministrador, id)) {
                JOptionPane.showMessageDialog(null, "Registro Modificado");
                limpiar();
            } else {
                JOptionPane.showMessageDialog(null, "Error al Modificar");
                limpiar();
            }
        }

        if (e.getSource() == frm.btnBorrar) {
            tadministrador.setAdmin_codigo(Integer.parseInt(frm.txtCodigo.getText()));

            if (cadministrador.eliminar(tadministrador)) {
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
        frm.txtUsuario.setText(null);
        frm.txtPassword.setText(null);
    }
    
}
