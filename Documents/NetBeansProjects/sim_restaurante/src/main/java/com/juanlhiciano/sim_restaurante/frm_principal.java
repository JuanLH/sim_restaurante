/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.juanlhiciano.sim_restaurante;

import com.juanlhiciano.clases.Cliente;
import com.juanlhiciano.clases.ListaLlegada;
import com.juanlhiciano.clases.ListaParados;
import com.juanlhiciano.clases.ListaSentados;
import com.juanlhiciano.entidades.Producto;
import com.juanlhiciano.utilidades.Utilities;
import java.awt.Rectangle;
import static java.lang.Thread.sleep;
import java.sql.Time;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import org.joda.time.LocalTime;

/**
 *
 * @author JLHiciano
 */
public class frm_principal extends javax.swing.JFrame {

    
    ArrayList<JButton> listaLlegada;
    ListaLlegada llegadas;
    ListaSentados sentados;
    ListaParados parados;
    LocalTime time;
    String[][] prodXorden;
    Producto productos;
    public frm_principal() {
        initComponents();
        listaLlegada= new ArrayList<>();
        llegadas = new ListaLlegada(panelCliLlegando);
        sentados = new ListaSentados(panelCliSentados);
        parados = new ListaParados(panelCliParados);
        productos = new Producto();
        time = new LocalTime(7,0,0);//Apertura
        llenarMatrizCantOrdenes();
        
        System.out.println("Boton sentados = "+btnClienteSentado.getBounds());
        System.out.println("Boton parados = "+btnClienteParado.getBounds());
    }

    private void llenarMatrizCantOrdenes(){
        prodXorden = new String[10][3];
        prodXorden[0][0] = "1";
        prodXorden[0][1] = "0.0000";
        prodXorden[0][2] = "0.5000";
        
        prodXorden[1][0] = "2";
        prodXorden[1][1] = "0.5001";
        prodXorden[1][2] = "0.7000";
        
        prodXorden[2][0] = "3";
        prodXorden[2][1] = "0.7001";
        prodXorden[2][2] = "0.8000";
        
        prodXorden[3][0] = "4";
        prodXorden[3][1] = "0.8001";
        prodXorden[3][2] = "0.9000";
        
        prodXorden[4][0] = "5";
        prodXorden[4][1] = "0.9001";
        prodXorden[4][2] = "0.9500";
    
        prodXorden[5][0] = "6";
        prodXorden[5][1] = "0.9501";
        prodXorden[5][2] = "0.9700";
        
        prodXorden[6][0] = "7";
        prodXorden[6][1] = "0.9701";
        prodXorden[6][2] = "0.9800";
        
        prodXorden[7][0] = "8";
        prodXorden[7][1] = "0.9801";
        prodXorden[7][2] = "0.9880";
        
        prodXorden[8][0] = "9";
        prodXorden[8][1] = "0.9801";
        prodXorden[8][2] = "0.9880";
        
        prodXorden[9][0] = "10";
        prodXorden[9][1] = "0.9881";
        prodXorden[9][2] = "1.0000";
    }
    
    private int buscarCant(float random){
        for(int x=0;x<10;x++){
            float inicio = Float.parseFloat(prodXorden[x][1]);
            float fin = Float.parseFloat(prodXorden[x][2]);
            if(random>=inicio && random<=fin){
               return Integer.parseInt(prodXorden[x][0]);
            }
        }
        return 0;
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelCliLlegando = new javax.swing.JPanel();
        panelCliSentados = new javax.swing.JPanel();
        btnClienteSentado = new javax.swing.JButton();
        btnClienteParado = new javax.swing.JButton();
        panelCliParados = new javax.swing.JPanel();
        panelCocina = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jComboBox1 = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jTextField2 = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jTextField3 = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jTextField4 = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        panelCliLlegando.setBackground(new java.awt.Color(255, 102, 102));
        panelCliLlegando.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "CLIENTES LLEGANDO", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.BOTTOM, new java.awt.Font("Tahoma", 1, 14))); // NOI18N
        panelCliLlegando.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                panelCliLlegandoMousePressed(evt);
            }
        });

        javax.swing.GroupLayout panelCliLlegandoLayout = new javax.swing.GroupLayout(panelCliLlegando);
        panelCliLlegando.setLayout(panelCliLlegandoLayout);
        panelCliLlegandoLayout.setHorizontalGroup(
            panelCliLlegandoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1334, Short.MAX_VALUE)
        );
        panelCliLlegandoLayout.setVerticalGroup(
            panelCliLlegandoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 59, Short.MAX_VALUE)
        );

        panelCliSentados.setBackground(new java.awt.Color(204, 204, 0));
        panelCliSentados.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "CLIENTES SENTADOS", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 14))); // NOI18N

        btnClienteSentado.setText("jButton4");

        btnClienteParado.setText("jButton4");

        javax.swing.GroupLayout panelCliSentadosLayout = new javax.swing.GroupLayout(panelCliSentados);
        panelCliSentados.setLayout(panelCliSentadosLayout);
        panelCliSentadosLayout.setHorizontalGroup(
            panelCliSentadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelCliSentadosLayout.createSequentialGroup()
                .addContainerGap(632, Short.MAX_VALUE)
                .addGroup(panelCliSentadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnClienteParado, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnClienteSentado, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        panelCliSentadosLayout.setVerticalGroup(
            panelCliSentadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelCliSentadosLayout.createSequentialGroup()
                .addComponent(btnClienteParado)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnClienteSentado)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        panelCliParados.setBackground(new java.awt.Color(0, 153, 153));
        panelCliParados.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "CLIENTES PARADOS", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 14))); // NOI18N

        javax.swing.GroupLayout panelCliParadosLayout = new javax.swing.GroupLayout(panelCliParados);
        panelCliParados.setLayout(panelCliParadosLayout);
        panelCliParadosLayout.setHorizontalGroup(
            panelCliParadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 513, Short.MAX_VALUE)
        );
        panelCliParadosLayout.setVerticalGroup(
            panelCliParadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        panelCocina.setBackground(new java.awt.Color(204, 204, 204));
        panelCocina.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "COCINA", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 14))); // NOI18N

        javax.swing.GroupLayout panelCocinaLayout = new javax.swing.GroupLayout(panelCocina);
        panelCocina.setLayout(panelCocinaLayout);
        panelCocinaLayout.setHorizontalGroup(
            panelCocinaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        panelCocinaLayout.setVerticalGroup(
            panelCocinaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 378, Short.MAX_VALUE)
        );

        jPanel1.setBackground(new java.awt.Color(0, 153, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "CONFIGURACION", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 14))); // NOI18N

        jComboBox1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setText("DIA:");

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel3.setText("CANTIDAD CT1:");

        jTextField1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel4.setText("CANTIDAD CT2:");

        jTextField2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel5.setText("CANTIDAD CT3:");

        jTextField3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel6.setText("CANTIDAD CT4:");

        jTextField4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N

        jButton1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton1.setText("INICIAR");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton2.setText("PAUSAR");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(7, 7, 7)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31)
                .addComponent(jButton1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton2)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4)
                    .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5)
                    .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6)
                    .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, 29, Short.MAX_VALUE))
                .addContainerGap(17, Short.MAX_VALUE))
        );

        jButton3.setText("MESERO");
        jButton3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton3MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(panelCliLlegando, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(panelCliSentados, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(panelCliParados, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(panelCocina, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(panelCocina, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(panelCliParados, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(panelCliSentados, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panelCliLlegando, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void panelCliLlegandoMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panelCliLlegandoMousePressed
       
        
    }//GEN-LAST:event_panelCliLlegandoMousePressed

    private void jButton3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton3MouseClicked
        llegadas.remove();
    }//GEN-LAST:event_jButton3MouseClicked

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        
        Thread hilo_llegadas = new Thread(new HiloLlegada());
        Thread hilo_mesero = new Thread(new HiloMesero());
        hilo_llegadas.start();
        hilo_mesero.start();
        
    }//GEN-LAST:event_jButton1ActionPerformed

    private class HiloLlegada implements Runnable{
        @Override
        public void run() 
        { 
           for(;;){
               Double rand = Utilities.doubleRand(0, 1);
               Double miu = 3.8;
               Double tiempo = -miu * Math.log(rand);
               System.out.println("Random  "+rand+"  tiempo ="+tiempo+" Hora ="+time.toString());
               long milis = (long) (tiempo * 60000);
               time = time.plusMillis((int) milis);
               long escala = milis / 256;
               try {
                   sleep(escala);
               } catch (InterruptedException ex) {
                   Logger.getLogger(frm_principal.class.getName()).log(Level.SEVERE, null, ex);
               }
               llegadas.add(new Time(time.getHourOfDay(), time.getMinuteOfHour(), time.getSecondOfMinute()));
               //System.out.println("Tiempo de llegada ="+llegadas.get(llegadas.size()-1).getVisita().getHora_llegada());
           }
        }
    }
    
    private class HiloMesero implements Runnable{

        @Override
        public void run() {
            for(;;){
                if(!llegadas.isEmpty()){
                    Cliente cliente = llegadas.get(0);
                    llegadas.remove(0);
                    Double rand = Utilities.doubleRand(0, 1);
                    if(rand<0.5)
                        sentados.add(cliente);
                    else
                        parados.add(cliente);
                    
                    try {
                        sleep(500);
                    } catch (InterruptedException ex) {
                        Logger.getLogger(frm_principal.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                else
                {
                    try {
                        sleep(1000);
                    } catch (InterruptedException ex) {
                        Logger.getLogger(frm_principal.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
        }
    
    }
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(frm_principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frm_principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frm_principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frm_principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frm_principal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnClienteParado;
    private javax.swing.JButton btnClienteSentado;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JPanel panelCliLlegando;
    private javax.swing.JPanel panelCliParados;
    private javax.swing.JPanel panelCliSentados;
    private javax.swing.JPanel panelCocina;
    // End of variables declaration//GEN-END:variables
}
