/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.anthonytepach.vistas;

import com.anthonytepach.beans.Usuarios;
import com.anthonytepach.vistas.internos.Cliente_IU;
import com.anthonytepach.vistas.internos.NewProject;
import com.anthonytepach.vistas.internos.V_ConsultaProyecto;
import javax.swing.JOptionPane;

/**
 *
 * @author Anthony Tepach
 */
public class VMenu extends javax.swing.JFrame {

    /**
     * Creates new form VMenu
     */
    private Usuarios usuarioLogeado;

    public VMenu() {
        initComponents();

    }

    public VMenu(Usuarios user) {
        initComponents();
        this.usuarioLogeado = user;

        jm_nameuser.setText("Bienvenido(a): " + usuarioLogeado.getUsername());
        this.setTitle("UUID: " + usuarioLogeado.getUuid());
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenu3 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jdp_principal = new javax.swing.JDesktopPane();
        jMenuBar1 = new javax.swing.JMenuBar();
        jm_nameuser = new javax.swing.JMenu();
        jMenu2 = new javax.swing.JMenu();
        jmi_proyecto = new javax.swing.JMenuItem();
        jmi_cliente = new javax.swing.JMenuItem();
        jM_Consulta = new javax.swing.JMenu();
        jm_Con_Proyecto = new javax.swing.JMenuItem();
        jMenu1 = new javax.swing.JMenu();
        jm_almacen = new javax.swing.JMenu();

        jMenu3.setText("jMenu3");

        jMenuItem1.setText("jMenuItem1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new java.awt.CardLayout());

        javax.swing.GroupLayout jdp_principalLayout = new javax.swing.GroupLayout(jdp_principal);
        jdp_principal.setLayout(jdp_principalLayout);
        jdp_principalLayout.setHorizontalGroup(
            jdp_principalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1257, Short.MAX_VALUE)
        );
        jdp_principalLayout.setVerticalGroup(
            jdp_principalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 598, Short.MAX_VALUE)
        );

        getContentPane().add(jdp_principal, "card2");

        jMenuBar1.setBackground(new java.awt.Color(51, 51, 255));
        jMenuBar1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        jm_nameuser.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/tepach/images/32x32/friendship.png"))); // NOI18N
        jm_nameuser.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jm_nameuser.setFocusable(false);
        jm_nameuser.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N
        jMenuBar1.add(jm_nameuser);

        jMenu2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/tepach/images/24X24/add.png"))); // NOI18N
        jMenu2.setText("Agregar");
        jMenu2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        jmi_proyecto.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_P, java.awt.event.InputEvent.SHIFT_MASK | java.awt.event.InputEvent.CTRL_MASK));
        jmi_proyecto.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/tepach/images/16X16/project-management.png"))); // NOI18N
        jmi_proyecto.setText("Proyecto");
        jmi_proyecto.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jmi_proyecto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmi_proyectoActionPerformed(evt);
            }
        });
        jMenu2.add(jmi_proyecto);

        jmi_cliente.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_C, java.awt.event.InputEvent.SHIFT_MASK | java.awt.event.InputEvent.CTRL_MASK));
        jmi_cliente.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/tepach/images/16X16/customer.png"))); // NOI18N
        jmi_cliente.setText("Cliente");
        jmi_cliente.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jmi_cliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmi_clienteActionPerformed(evt);
            }
        });
        jMenu2.add(jmi_cliente);

        jMenuBar1.add(jMenu2);

        jM_Consulta.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/tepach/images/24X24/search.png"))); // NOI18N
        jM_Consulta.setText("Consulta");
        jM_Consulta.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        jm_Con_Proyecto.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/tepach/images/16X16/project-management.png"))); // NOI18N
        jm_Con_Proyecto.setText("Orden de producción");
        jm_Con_Proyecto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jm_Con_ProyectoActionPerformed(evt);
            }
        });
        jM_Consulta.add(jm_Con_Proyecto);

        jMenuBar1.add(jM_Consulta);

        jMenu1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/tepach/images/24X24/analytics.png"))); // NOI18N
        jMenu1.setText("Produccion");
        jMenu1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jMenuBar1.add(jMenu1);

        jm_almacen.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/tepach/images/24X24/warehouse.png"))); // NOI18N
        jm_almacen.setText("Almacen");
        jm_almacen.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jMenuBar1.add(jm_almacen);

        setJMenuBar(jMenuBar1);

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jmi_clienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmi_clienteActionPerformed
        // TODO add your handling code here:
        if ("Proyectos".equals(usuarioLogeado.getRol()) || "Admin".equals(usuarioLogeado.getRol())) {
            Cliente_IU cu = new Cliente_IU("Registro");
            jdp_principal.add(cu);
            cu.setVisible(true);
        } else {
            JOptionPane.showMessageDialog(rootPane, "Lo sentimos no tienes los permisos necesarios para acceder a esta opcción", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_jmi_clienteActionPerformed

    private void jmi_proyectoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmi_proyectoActionPerformed
        // TODO add your handling code here:
        if ("Proyectos".equals(usuarioLogeado.getRol()) || "Admin".equals(usuarioLogeado.getRol())) {
            NewProject cu = new NewProject("Registro");
            jdp_principal.add(cu);
            cu.setVisible(true);
        } else {
            JOptionPane.showMessageDialog(rootPane, "Lo sentimos no tienes los permisos necesarios para acceder a esta opcción", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_jmi_proyectoActionPerformed

    private void jm_Con_ProyectoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jm_Con_ProyectoActionPerformed

        if ("Proyectos".equals(usuarioLogeado.getRol()) || "Admin".equals(usuarioLogeado.getRol())) {
            V_ConsultaProyecto vcp = new V_ConsultaProyecto();
            jdp_principal.add(vcp);
            vcp.setVisible(true);
        } else {
            JOptionPane.showMessageDialog(rootPane, "Lo sentimos no tienes los permisos necesarios para acceder a esta opcción", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_jm_Con_ProyectoActionPerformed

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenu jM_Consulta;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    public static javax.swing.JDesktopPane jdp_principal;
    private javax.swing.JMenuItem jm_Con_Proyecto;
    private javax.swing.JMenu jm_almacen;
    private javax.swing.JMenu jm_nameuser;
    private javax.swing.JMenuItem jmi_cliente;
    private javax.swing.JMenuItem jmi_proyecto;
    // End of variables declaration//GEN-END:variables
}
