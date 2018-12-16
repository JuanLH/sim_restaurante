/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.juanlhiciano.sim_restaurante;

import Enumeradores.EstadoCliente;
import Enumeradores.EstadoOrden;
import com.juanlhiciano.clases.Cliente;
import com.juanlhiciano.clases.ListaLlegada;
import com.juanlhiciano.clases.ListaOrdenBbq;
import com.juanlhiciano.clases.ListaOrdenHd;
import com.juanlhiciano.clases.ListaOrden;
import com.juanlhiciano.clases.ListaOrdenYaroa;
import com.juanlhiciano.clases.ListaParados;
import com.juanlhiciano.clases.ListaSentados;
import com.juanlhiciano.entidades.Dia;
import com.juanlhiciano.entidades.Orden;
import com.juanlhiciano.entidades.Producto;
import com.juanlhiciano.entidades.Tanda;
import com.juanlhiciano.utilidades.Utilities;
import com.sun.xml.internal.ws.policy.privateutil.PolicyUtils;
import static com.sun.xml.internal.ws.spi.db.BindingContextFactory.LOGGER;
import java.awt.Rectangle;
import static java.lang.Thread.sleep;
import java.sql.SQLException;
import java.sql.Time;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Vector;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.SwingWorker;
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
    //Sentados y parados en orden de llegada
    //Esta lista sera la que los cocineros consultaran
    List<Cliente> espera; 
    
    ListaOrden ordenesPlancha;
    ListaOrden ordenesHd;
    ListaOrden ordenesYaroa;
    ListaOrden ordenesBbq;
    
    LocalTime hora_abrir;
    LocalTime hora_cerrar;
    LocalTime time;
    int denominador_tiempo;
    Tanda tanda;
    Producto productos;
    
    //*********************Generar Tiempo***************************************
     List<Cliente> clientesG;
     List<Orden>[] ordenesPlanchaG;
     List<Orden>[] ordenesHdG;
     List<Orden>[] ordenesYaroaG;
     List<Orden>[] ordenesBbqG;
    //**************************************************************************
    
    ArrayList<Producto> listaProductos;
    public frm_principal() {
        initComponents();
        
        
        
        denominador_tiempo = 1024;
        listaLlegada= new ArrayList<>();
        llegadas = new ListaLlegada(panelCliLlegando);
        sentados = new ListaSentados(panelCliSentados);
        parados = new ListaParados(panelCliParados);
        espera = new CopyOnWriteArrayList<>();
        
        ordenesPlancha = new ListaOrden(PlanchaPanel);  
        //ordenesPlancha = new ListaOrden(PlanchaPanel);
        ordenesHd = new ListaOrden(HdPanel);
        ordenesYaroa = new ListaOrden(YaroaPanel);
        ordenesBbq = new ListaOrden(BbqPanel);
        
        hora_abrir = new LocalTime(7, 0, 0);
        hora_cerrar = new LocalTime(12, 0, 0);
        
        
        productos = new Producto();
        try {
            listaProductos = productos.getListado();
        } catch (SQLException ex) {
            Logger.getLogger(frm_principal.class.getName()).log(Level.SEVERE, null, ex);
        }
        time = new LocalTime(7,0,0);//Apertura
        try {
            ArrayList<Dia> dias = Dia.getDias();
            
            
            cmbDias.removeAllItems();
            for(Dia dia : dias){
                cmbDias.addItem(dia.toString());
            }
        } catch (SQLException ex) {
            Logger.getLogger(frm_principal.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        //generarTiempos();
    }

    synchronized private Cliente getCliente(Orden orden){
        for(Cliente clie: espera){
            for(Orden or : clie.getOrdenes()){

                if(or == orden){
                    return clie;
                }

            }
        }
        return null;
    }
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelCliLlegando = new javax.swing.JPanel();
        panelCliSentados = new javax.swing.JPanel();
        panelCliParados = new javax.swing.JPanel();
        panelCocina = new javax.swing.JPanel();
        PlanchaPanel = new javax.swing.JPanel();
        HdPanel = new javax.swing.JPanel();
        YaroaPanel = new javax.swing.JPanel();
        BbqPanel = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        lblCantPlancha = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        lblCantHd = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        lblCantYaroa = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        lblCantBbq = new javax.swing.JLabel();
        lblTiempo = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        cmbDias = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtPlancha = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtHd = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txtYaroa = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        txtBbq = new javax.swing.JTextField();
        btnIniciarSim = new javax.swing.JButton();
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
            .addGap(0, 1300, Short.MAX_VALUE)
        );
        panelCliLlegandoLayout.setVerticalGroup(
            panelCliLlegandoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 22, Short.MAX_VALUE)
        );

        panelCliSentados.setBackground(new java.awt.Color(204, 204, 0));
        panelCliSentados.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "CLIENTES SENTADOS", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 14))); // NOI18N

        javax.swing.GroupLayout panelCliSentadosLayout = new javax.swing.GroupLayout(panelCliSentados);
        panelCliSentados.setLayout(panelCliSentadosLayout);
        panelCliSentadosLayout.setHorizontalGroup(
            panelCliSentadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 671, Short.MAX_VALUE)
        );
        panelCliSentadosLayout.setVerticalGroup(
            panelCliSentadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 91, Short.MAX_VALUE)
        );

        panelCliParados.setBackground(new java.awt.Color(0, 153, 153));
        panelCliParados.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "CLIENTES PARADOS", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 14))); // NOI18N

        javax.swing.GroupLayout panelCliParadosLayout = new javax.swing.GroupLayout(panelCliParados);
        panelCliParados.setLayout(panelCliParadosLayout);
        panelCliParadosLayout.setHorizontalGroup(
            panelCliParadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 479, Short.MAX_VALUE)
        );
        panelCliParadosLayout.setVerticalGroup(
            panelCliParadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        panelCocina.setBackground(new java.awt.Color(204, 204, 204));
        panelCocina.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "COCINA", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 14))); // NOI18N

        PlanchaPanel.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Plancha", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 14))); // NOI18N

        javax.swing.GroupLayout PlanchaPanelLayout = new javax.swing.GroupLayout(PlanchaPanel);
        PlanchaPanel.setLayout(PlanchaPanelLayout);
        PlanchaPanelLayout.setHorizontalGroup(
            PlanchaPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1278, Short.MAX_VALUE)
        );
        PlanchaPanelLayout.setVerticalGroup(
            PlanchaPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 34, Short.MAX_VALUE)
        );

        HdPanel.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Hot Dogs", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 14))); // NOI18N

        javax.swing.GroupLayout HdPanelLayout = new javax.swing.GroupLayout(HdPanel);
        HdPanel.setLayout(HdPanelLayout);
        HdPanelLayout.setHorizontalGroup(
            HdPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1278, Short.MAX_VALUE)
        );
        HdPanelLayout.setVerticalGroup(
            HdPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 34, Short.MAX_VALUE)
        );

        YaroaPanel.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Yaroas y demas", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 14))); // NOI18N

        javax.swing.GroupLayout YaroaPanelLayout = new javax.swing.GroupLayout(YaroaPanel);
        YaroaPanel.setLayout(YaroaPanelLayout);
        YaroaPanelLayout.setHorizontalGroup(
            YaroaPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1278, Short.MAX_VALUE)
        );
        YaroaPanelLayout.setVerticalGroup(
            YaroaPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 34, Short.MAX_VALUE)
        );

        BbqPanel.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "BBQ", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 14))); // NOI18N

        javax.swing.GroupLayout BbqPanelLayout = new javax.swing.GroupLayout(BbqPanel);
        BbqPanel.setLayout(BbqPanelLayout);
        BbqPanelLayout.setHorizontalGroup(
            BbqPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1278, Short.MAX_VALUE)
        );
        BbqPanelLayout.setVerticalGroup(
            BbqPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 34, Short.MAX_VALUE)
        );

        jLabel1.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel1.setText("CANTIDAD DE COCINEROS:");

        lblCantPlancha.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        lblCantPlancha.setText("#");

        jLabel8.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel8.setText("CANTIDAD DE COCINEROS:");

        lblCantHd.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        lblCantHd.setText("#");

        jLabel10.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel10.setText("CANTIDAD DE COCINEROS:");

        lblCantYaroa.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        lblCantYaroa.setText("#");

        jLabel12.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel12.setText("CANTIDAD DE COCINEROS:");

        lblCantBbq.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        lblCantBbq.setText("#");

        lblTiempo.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        lblTiempo.setText("TIEMPO SIMULADO");

        javax.swing.GroupLayout panelCocinaLayout = new javax.swing.GroupLayout(panelCocina);
        panelCocina.setLayout(panelCocinaLayout);
        panelCocinaLayout.setHorizontalGroup(
            panelCocinaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelCocinaLayout.createSequentialGroup()
                .addGroup(panelCocinaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(PlanchaPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(HdPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(YaroaPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(BbqPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(panelCocinaLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(panelCocinaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panelCocinaLayout.createSequentialGroup()
                                .addComponent(jLabel8)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lblCantHd))
                            .addGroup(panelCocinaLayout.createSequentialGroup()
                                .addComponent(jLabel10)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lblCantYaroa))
                            .addGroup(panelCocinaLayout.createSequentialGroup()
                                .addComponent(jLabel12)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lblCantBbq))
                            .addGroup(panelCocinaLayout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lblCantPlancha)
                                .addGap(373, 373, 373)
                                .addComponent(lblTiempo, javax.swing.GroupLayout.PREFERRED_SIZE, 328, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        panelCocinaLayout.setVerticalGroup(
            panelCocinaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelCocinaLayout.createSequentialGroup()
                .addGroup(panelCocinaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelCocinaLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(panelCocinaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(lblCantPlancha)))
                    .addComponent(lblTiempo))
                .addGap(2, 2, 2)
                .addComponent(PlanchaPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panelCocinaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(lblCantHd))
                .addGap(5, 5, 5)
                .addComponent(HdPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panelCocinaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(lblCantYaroa))
                .addGap(3, 3, 3)
                .addComponent(YaroaPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(16, 16, 16)
                .addGroup(panelCocinaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12)
                    .addComponent(lblCantBbq))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(BbqPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel1.setBackground(new java.awt.Color(0, 153, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "CONFIGURACION", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 14))); // NOI18N

        cmbDias.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        cmbDias.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setText("DIA:");

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel3.setText("COCINEROS PLANCHA:");

        txtPlancha.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel4.setText("COCINEROS HOT DOGS:");

        txtHd.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel5.setText("COCINEROS YAROAS:");

        txtYaroa.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel6.setText("COCINEROS BBQ:");

        txtBbq.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N

        btnIniciarSim.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnIniciarSim.setText("INICIAR");
        btnIniciarSim.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnIniciarSimActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(7, 7, 7)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cmbDias, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtPlancha, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtHd, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtYaroa, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtBbq, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31)
                .addComponent(btnIniciarSim)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cmbDias, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3)
                    .addComponent(txtPlancha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4)
                    .addComponent(txtHd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5)
                    .addComponent(txtYaroa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6)
                    .addComponent(txtBbq, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnIniciarSim, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panelCocina, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(panelCliSentados, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(panelCliParados, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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

    private void btnIniciarSimActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIniciarSimActionPerformed
        
        //*********************Generar Tiempo***********************************
        clientesG = new ArrayList<>();
        ordenesPlanchaG = new ArrayList[Integer.parseInt(txtPlancha.getText())];
        ordenesHdG = new ArrayList[Integer.parseInt(txtHd.getText())];
        ordenesYaroaG = new ArrayList[Integer.parseInt(txtYaroa.getText())];
        ordenesBbqG = new ArrayList[Integer.parseInt(txtBbq.getText())];     
        
        for(int x=0;x<ordenesPlanchaG.length;x++){
            ordenesPlanchaG[x] = new ArrayList<>();
        }
        
        for(int x=0;x<ordenesHdG.length;x++){
            ordenesHdG[x] = new ArrayList<>();
        }
        
        for(int x=0;x<ordenesYaroaG.length;x++){
            ordenesYaroaG[x] = new ArrayList<>();
        }
        
        for(int x=0;x<ordenesBbqG.length;x++){
            ordenesBbqG[x] = new ArrayList<>();
        }
        
        generarTiempos();
        //**********************************************************************
        
        /*Thread[] coc_plancha = new Thread[Integer.parseInt(txtPlancha.getText())];
        Thread[] coc_hd = new Thread[Integer.parseInt(txtHd.getText())];
        Thread[] coc_yaroa = new Thread[Integer.parseInt(txtYaroa.getText())];
        Thread[] coc_bbq = new Thread[Integer.parseInt(txtBbq.getText())];
        
        
        for(int x=0;x<coc_bbq.length;x++){
            coc_bbq[x] = new Thread(new HiloCocinero(ordenesBbq));
            coc_bbq[x].setName("COCINEROBBQ - "+x);
            coc_bbq[x].start();
        }
        
        for(int x=0;x<coc_plancha.length;x++){
            coc_plancha[x] = new Thread(new HiloCocinero(ordenesPlancha));
            coc_plancha[x].setName("COCINERO PLANCHA - "+x);
            coc_plancha[x].start();
        }
        
        for(int x=0;x<coc_hd.length;x++){
            coc_hd[x] = new Thread(new HiloCocinero(ordenesHd));
            coc_hd[x].setName("COCINERO HD - "+x);
            coc_hd[x].start();
        }
        
        for(int x=0;x<coc_yaroa.length;x++){
            coc_yaroa[x] = new Thread(new HiloCocinero(ordenesYaroa));
            coc_yaroa[x].setName("COCINERO YAROA - "+x);
            coc_yaroa[x].start();
        }
        /*
        HiloCocineroWorker[] coc_plancha = new HiloCocineroWorker[Integer.parseInt(txtPlancha.getText())];
        HiloCocineroWorker[] coc_hd = new HiloCocineroWorker[Integer.parseInt(txtHd.getText())];
        HiloCocineroWorker[] coc_yaroa = new HiloCocineroWorker[Integer.parseInt(txtYaroa.getText())];
        HiloCocineroWorker[] coc_bbq = new HiloCocineroWorker[Integer.parseInt(txtBbq.getText())];
        
        
        for(int x=0;x<coc_bbq.length;x++){
            coc_bbq[x] = new HiloCocineroWorker(ordenesBbq);
            coc_bbq[x].execute();
        }
        
        for(int x=0;x<coc_plancha.length;x++){
            coc_plancha[x] = new HiloCocineroWorker(ordenesPlancha);
            coc_plancha[x].execute();
        }
        
        for(int x=0;x<coc_hd.length;x++){
            coc_hd[x] = new HiloCocineroWorker(ordenesHd);
            coc_hd[x].execute();
        }
        
        for(int x=0;x<coc_yaroa.length;x++){
            coc_yaroa[x] = new HiloCocineroWorker(ordenesYaroa);
            coc_yaroa[x].execute();
        }
        */
        /*
        Reloj reloj = new Reloj();
        Thread hilo_llegadas = new Thread(new HiloLlegada());
        hilo_llegadas.setName("LLEGADAS");
        Thread hilo_mesero = new Thread(new HiloMesero());
        hilo_mesero.setName("MESERO");
     
        
        hilo_mesero.start();
        hilo_llegadas.start();
        reloj.execute();
      
        
        SwingWorker sw = new SwingWorker() {
            @Override
            protected Object doInBackground() throws Exception {
                while(coc_plancha[0].isAlive()){
                    sleep(2000);
                }
                return null;
            }
            
            @Override
            protected void done() {
                System.err.println("Hey due");
                revisionClientes();
            }
        };
        sw.execute();
        
        */
        
    }//GEN-LAST:event_btnIniciarSimActionPerformed

    //*************************Generar Tiempos*********************************
    
    
    private void generarTiempos(){
        LocalTime clock = new LocalTime(7, 0, 0);
        HiloMesero mesero = new HiloMesero();
        
        if(clientesG.isEmpty()){
            Cliente cli = new Cliente(new Time(clock.getHourOfDay(),clock.getMinuteOfHour(),clock.getSecondOfMinute()));
            int tiempo_orden = Utilities.intRand(2,8);
            clock = clock.plusMinutes(tiempo_orden);
            cli.getVisita().setHora_orden(new Time(clock.getHourOfDay(),clock.getMinuteOfHour(),clock.getSecondOfMinute()));
            int cant_ordenes = mesero.buscarCantOrdenes(Utilities.floatRand(0, 1));
            AgregarOrdenes(cli,cant_ordenes,clock);
            
            Time hEntrega = getMaxTimeEntrega(cli);
            clock = new LocalTime(hEntrega.getTime());
            cli.getVisita().setHora_entrega(hEntrega);
            int tiempoComer = Utilities.intRand(5, 12);
            clock = clock.plusMinutes(tiempoComer);
            cli.getVisita().setHora_fin_comer(new Time(clock.getHourOfDay(),clock.getMinuteOfHour(),clock.getSecondOfMinute()));
            
            //Distribucion exponencial para el tiempo de salida
            Double rand = Utilities.doubleRand(0, 1);
            Double miu = 4.8;
            Double tiempo = -miu * Math.log(rand);
            clock = clock.plusMillis((int) (tiempo * 60000));
            cli.getVisita().setHora_salida(new Time(clock.getHourOfDay(),clock.getMinuteOfHour(),clock.getSecondOfMinute()));
            clientesG.add(cli);
        }
        else{
        
        }
        
        System.out.println("Cliente \n"
                + "Hora llegada = "+clientesG.get(0).getVisita().getHora_llegada()+"\n"
                + "Hora orden = "+clientesG.get(0).getVisita().getHora_orden()+"\n"
                + "Hora Entrega = "+clientesG.get(0).getVisita().getHora_entrega()+"\n"
                + "Hora termino comida = "+clientesG.get(0).getVisita().getHora_fin_comer()+"\n"
                + "Hora Salida = "+clientesG.get(0).getVisita().getHora_salida()+"\n");
        for(Orden orden : clientesG.get(0).getOrdenes()){
            System.out.println(orden.getProducto().getNombre()+"\n"
                    + "inicio cola = "+orden.getT_inicio_cola()+""
                    + "fin cola ="+orden.getT_fin_cola()+""
                    + "entrega ="+orden.getT_entrega());
        }
        
    }
    
    public void AgregarOrdenes(Cliente cli,int cant_ordenes,LocalTime clock){
        for(int x=0;x<cant_ordenes;x++){
            float rand2 = Utilities.floatRand(0, 1);
            Producto prod = productos.findProducto(listaProductos, rand2);
            Orden or = new Orden(prod,new Time(clock.getHourOfDay(),clock.getMinuteOfHour(),clock.getSecondOfMinute()));


            if(or.getProducto() != null){
                int minPreparacion = Utilities.intRand(
                        or.getProducto().getTiempo_min_prep(),
                        or.getProducto().getTiempo_max_prep());
                LocalTime cocinaClock = new LocalTime(clock);
                System.out.println("Tiempo original -->"+clock);
                System.out.println("Tiempo copiado -->"+cocinaClock);
                switch(or.getProducto().getId_tipo_producto()){
                    case 1://Plancha
                        List<Orden> orPlancha = ListaConMenorCola(1);
                        if(!orPlancha.isEmpty()){
                            //El tiempo de fin de cola es el tiempo de entrega del ultimo producto de la cola
                            Time finCola = orPlancha.get(orPlancha.size()-1).getT_entrega();
                            or.setT_fin_cola(finCola);
                            cocinaClock = new LocalTime(finCola.getTime());
                            cocinaClock = cocinaClock.plusMinutes(minPreparacion);
                            or.setT_entrega(new Time(cocinaClock.getHourOfDay(),cocinaClock.getMinuteOfHour(),cocinaClock.getSecondOfMinute()));
                            orPlancha.add(or);
                        }
                        else{
                            //Como la cola esta vacia el tiempo de inicio y fin son iguales
                            or.setT_fin_cola(new Time(cocinaClock.getHourOfDay(),cocinaClock.getMinuteOfHour(),cocinaClock.getSecondOfMinute()));
                            cocinaClock = cocinaClock.plusMinutes(minPreparacion);
                            or.setT_entrega(new Time(cocinaClock.getHourOfDay(),cocinaClock.getMinuteOfHour(),cocinaClock.getSecondOfMinute()));
                            orPlancha.add(or);
                        }
                    break;
                    case 2://Hot Dog
                        List<Orden> orHd = ListaConMenorCola(2);
                        if(!orHd.isEmpty()){
                            //El tiempo de fin de cola es el tiempo de entrega del ultimo producto de la cola
                            Time finCola = orHd.get(orHd.size()-1).getT_entrega();
                            or.setT_fin_cola(finCola);
                            cocinaClock = new LocalTime(finCola.getTime());
                            cocinaClock = cocinaClock.plusMinutes(minPreparacion);
                            or.setT_entrega(new Time(cocinaClock.getHourOfDay(),cocinaClock.getMinuteOfHour(),cocinaClock.getSecondOfMinute()));
                            orHd.add(or);
                        }
                        else{
                            //Como la cola esta vacia el tiempo de inicio y fin son iguales
                            or.setT_fin_cola(new Time(cocinaClock.getHourOfDay(),cocinaClock.getMinuteOfHour(),cocinaClock.getSecondOfMinute()));
                            cocinaClock = cocinaClock.plusMinutes(minPreparacion);
                            or.setT_entrega(new Time(cocinaClock.getHourOfDay(),cocinaClock.getMinuteOfHour(),cocinaClock.getSecondOfMinute()));
                            orHd.add(or);
                        }
                    break;
                    case 3://Yaroa
                        List<Orden> orYaroa = ListaConMenorCola(3);
                        if(!orYaroa.isEmpty()){
                            //El tiempo de fin de cola es el tiempo de entrega del ultimo producto de la cola
                            Time finCola = orYaroa.get(orYaroa.size()-1).getT_entrega();
                            or.setT_fin_cola(finCola);
                            cocinaClock = new LocalTime(finCola.getTime());
                            cocinaClock = cocinaClock.plusMinutes(minPreparacion);
                            or.setT_entrega(new Time(cocinaClock.getHourOfDay(),cocinaClock.getMinuteOfHour(),cocinaClock.getSecondOfMinute()));
                            orYaroa.add(or);
                        }
                        else{
                            //Como la cola esta vacia el tiempo de inicio y fin son iguales
                            or.setT_fin_cola(new Time(cocinaClock.getHourOfDay(),cocinaClock.getMinuteOfHour(),cocinaClock.getSecondOfMinute()));
                            cocinaClock = cocinaClock.plusMinutes(minPreparacion);
                            or.setT_entrega(new Time(cocinaClock.getHourOfDay(),cocinaClock.getMinuteOfHour(),cocinaClock.getSecondOfMinute()));
                            orYaroa.add(or);
                        }
                    break;
                    case 4://BBQ 
                        List<Orden> orBbq = ListaConMenorCola(4);
                        if(!orBbq.isEmpty()){
                            //El tiempo de fin de cola es el tiempo de entrega del ultimo producto de la cola
                            Time finCola = orBbq.get(orBbq.size()-1).getT_entrega();
                            or.setT_fin_cola(finCola);
                            cocinaClock = new LocalTime(finCola.getTime());
                            cocinaClock = cocinaClock.plusMinutes(minPreparacion);
                            or.setT_entrega(new Time(cocinaClock.getHourOfDay(),cocinaClock.getMinuteOfHour(),cocinaClock.getSecondOfMinute()));
                            orBbq.add(or);
                        }
                        else{
                            //Como la cola esta vacia el tiempo de inicio y fin son iguales
                            or.setT_fin_cola(new Time(cocinaClock.getHourOfDay(),cocinaClock.getMinuteOfHour(),cocinaClock.getSecondOfMinute()));
                            cocinaClock = cocinaClock.plusMinutes(minPreparacion);
                            or.setT_entrega(new Time(cocinaClock.getHourOfDay(),cocinaClock.getMinuteOfHour(),cocinaClock.getSecondOfMinute()));
                            orBbq.add(or);
                        }
                    break;    
                }
                //------------

                cli.getOrdenes().add(or);
            }
            else
                System.err.println("Se creo el producto de una orden nula----------------------------------------------------");
        }
    }
    
    public List<Orden> ListaConMenorCola(int tipo_producto){
        
        switch (tipo_producto){
            case 1:
                return MenorCola(ordenesPlanchaG);
            
            case 2:
                return MenorCola(ordenesHdG);
            
            case 3:
                return MenorCola(ordenesYaroaG);
            
            case 4:
                return MenorCola(ordenesBbqG);
            
        }
        return null;
    }
    
    public List<Orden> MenorCola(List<Orden>[] listas){
        List<Orden> menorCola = null;
        LocalTime timeMin = new LocalTime(hora_cerrar);
        for(int x=0;x<listas.length;x++){
            if(listas[x].isEmpty())
                return listas[x];
            else{
                Orden ultima = listas[x].get(listas[x].size()-1);
                LocalTime tmp = new LocalTime(ultima.getT_entrega().getTime());
                if(tmp.getHourOfDay()<timeMin.getHourOfDay()){
                    timeMin=tmp;
                    menorCola = listas[x];
                }
                else{
                    if(tmp.getHourOfDay() == timeMin.getHourOfDay()){
                        if(tmp.getMinuteOfHour()<timeMin.getMinuteOfHour()){
                            timeMin = tmp;
                            menorCola = listas[x];
                        }
                        else{
                            if(tmp.getMinuteOfHour() == timeMin.getMinuteOfHour()){
                                if(tmp.getSecondOfMinute() <= timeMin.getSecondOfMinute()){
                                    timeMin = tmp;
                                    menorCola = listas[x];
                                }
                            }
                        }
                    }
                    else
                        continue;
                }
                
            }
            
        }
        return menorCola;
    }
    //*************************************************************************
    private Time getMaxTimeEntrega(Cliente cliente){
        LocalTime timeMax = new LocalTime(0,0,0);
        for(Orden or:cliente.getOrdenes()){
            LocalTime tmp = new LocalTime(or.getT_entrega().getTime());
            if(tmp.getHourOfDay()>timeMax.getHourOfDay())
                timeMax=tmp;
            else{
                if(tmp.getHourOfDay() == timeMax.getHourOfDay()){
                    if(tmp.getMinuteOfHour()>timeMax.getMinuteOfHour())
                        timeMax = tmp;
                    else{
                        if(tmp.getMinuteOfHour() == timeMax.getMinuteOfHour()){
                            if(tmp.getSecondOfMinute() >= timeMax.getSecondOfMinute())
                                timeMax = tmp;
                        }
                    }
                }
                else
                    continue;
            }
        }
        return new Time(timeMax.getHourOfDay(), timeMax.getMinuteOfHour(), timeMax.getSecondOfMinute());
    }
    
    private void revisionClientes(){
        for(Cliente cli : espera){
            if(cli.getEstado() != EstadoCliente.COMIENDO){
                for(Orden or : cli.getOrdenes()){
                    
                    if(or.getEstado() == EstadoOrden.COLA){
                        Time t = or.getT_inicio_cola();
                        LocalTime lt = new LocalTime(t.getTime());
                        lt.plusMinutes(6);//Tiempo promedio de duracion en cola
                        or.setT_fin_cola(new Time(lt.getHourOfDay(), lt.getMinuteOfHour(), lt.getSecondOfMinute()));
                        lt.plusMinutes(or.getProducto().getTiempo_max_prep());
                        or.setT_entrega(new Time(lt.getHourOfDay(), lt.getMinuteOfHour(), lt.getSecondOfMinute()));
                        or.setEstado(EstadoOrden.LISTA);
                        System.out.println("Se entrego una orden ");
                    }
                    or.setEstado(EstadoOrden.ENTREGADO);
                    
                }
                LocalTime lt = new LocalTime(getMaxTimeEntrega(cli).getTime());
                cli.getVisita().setHora_entrega(getMaxTimeEntrega(cli));
                cli.setEstado(EstadoCliente.CONORDEN);
                //Aqui se decide si es para llevar o no
                cli.setEstado(EstadoCliente.COMIENDO);
                //Para este tiempo se puede aplicar una dist. Exponencial dependiendo la cantidad de ordenes que tiene
                lt = lt.plusMinutes(Utilities.intRand(5, 30));
                cli.getVisita().setHora_fin_comer(new Time(lt.getHourOfDay(),lt.getMinuteOfHour(),lt.getSecondOfMinute()));
                System.out.println("Cliente comiendo ");
                for(Cliente clie2 :parados){
                    if(clie2 == cli){
                        parados.changeStatus(EstadoCliente.COMIENDO, clie2);
                        System.out.println("pintado");
                        
                    }
                }

                for(Cliente clie2 :sentados){
                    if(clie2 == cli){
                        sentados.changeStatus(EstadoCliente.COMIENDO, clie2);
                        System.out.println("Pintado");
      
                    }
                }
            }
        }
    }
    private class HiloLlegada implements Runnable{
        @Override
        public void run() 
        { 
           while(time.getHourOfDay()<12){
               Double rand = Utilities.doubleRand(0, 1);
               Double miu = 3.8;
               Double tiempo = -miu * Math.log(rand);
               System.out.println("Random  "+rand+"  tiempo ="+tiempo+" Hora ="+time.toString());
               int milis = (int)(tiempo * 60000);
               //time = time.plusMillis(milis);
               int escala = milis / denominador_tiempo;
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
        
        String[][] prodXorden;
        
        public HiloMesero(){
            llenarMatrizCantOrdenes();
            
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
            prodXorden[8][1] = "0.9881";
            prodXorden[8][2] = "0.9890";

            prodXorden[9][0] = "10";
            prodXorden[9][1] = "0.9891";
            prodXorden[9][2] = "1.0000";
        }

        public int buscarCantOrdenes(float random){
            DecimalFormat df = new DecimalFormat("#.####");
            random = Float.parseFloat(df.format(random));
            for(int x=0;x<10;x++){
                float inicio = Float.parseFloat(prodXorden[x][1]);
                float fin = Float.parseFloat(prodXorden[x][2]);
                if(random>=inicio && random<=fin){
                   return Integer.parseInt(prodXorden[x][0]);
                }
            }
            LOGGER.info(random+" Ordenes 0");
            return 0;
        }
        //Distribuir ordenes a los cocineros
        public void repartirOrdenes(Cliente cliente){
            for(Orden or : cliente.getOrdenes()){
                //System.out.println("Orden  ---- "+or.getProducto().getNombre()+" tipo ---- "+or.getProducto().getId_tipo_producto());
                try{
                    if(or.getProducto().getId_tipo_producto() == 1){
                        ordenesPlancha.add(or);
                    }
                    else if(or.getProducto().getId_tipo_producto() == 2){
                        ordenesHd.add(or);
                    }
                    else if(or.getProducto().getId_tipo_producto() == 3){
                       ordenesYaroa.add(or);
                    }
                    else if(or.getProducto().getId_tipo_producto() == 4){
                        ordenesBbq.add(or);
                    }
                    else{
                        System.err.println("+++++++++++++++++++++++++++++++++++++++Error, cant Ordenes = "+cliente.getOrdenes().size());
                    }
                }
                catch(NullPointerException ex){
                    System.err.println(" +++++++++++++++++++++++++++Null pointer ex =="+ex.getMessage());
                }
                
            }
        }
        
        @Override
        public void run() {
            int countSalida =0;
            for(;;){
                if(!llegadas.isEmpty()){
                    countSalida=0;
                    Cliente cliente = llegadas.get(0);
                    cliente.getVisita().setHora_orden(new Time(time.getHourOfDay(),time.getMinuteOfHour(),time.getSecondOfMinute()));
                    float rand = Utilities.floatRand(0, 1);
                    int cantidad_ordenes = buscarCantOrdenes(rand);
                    for(int x=0;x<cantidad_ordenes;x++){
                        try {
                            sleep(12000/denominador_tiempo);
                        } catch (InterruptedException ex) {
                            Logger.getLogger(frm_principal.class.getName()).log(Level.SEVERE, null, ex);
                        }
                        float rand2 = Utilities.floatRand(0, 1);
                        Producto prod = productos.findProducto(listaProductos, rand2);
                        Orden or = new Orden(prod,new Time(time.getHourOfDay(), time.getMinuteOfHour(), time.getSecondOfMinute()));
                        if(or.getProducto() != null)
                            cliente.getOrdenes().add(or);
                        else
                            System.err.println("Se creo el producto de una orden nula----------------------------------------------------");
                    } 
                        
                    repartirOrdenes(cliente);
                    
                    if(rand<=0.7200)
                        sentados.add(cliente);
                    else
                        parados.add(cliente);
                    
                    espera.add(cliente);
                    llegadas.remove(0);
                    try {
                        sleep(1500/denominador_tiempo);
                    } catch (InterruptedException ex) {
                        Logger.getLogger(frm_principal.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                else
                {
                    try {
                        sleep(240000/denominador_tiempo);
                    } catch (InterruptedException ex) {
                        Logger.getLogger(frm_principal.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    if(countSalida==20){
                        LOGGER.info("Se fue el mesero ---------------------------------"+countSalida);
                        return;
                    }
                    else
                        countSalida++;
                }
            }
        }
    
    }
    
    public class HiloCocinero implements Runnable{

        ListaOrden ordenes_pendientes;
        ArrayList<Orden> ordenes_entregadas;

        HiloCocinero(ListaOrden lista){
            ordenes_pendientes = lista;
        }
        
        synchronized public void buscarCliente(Orden orden) throws InterruptedException {
            
            Cliente clie = getCliente(orden);
                    
            if(clie != null){//Se encontro la orden que se preparo
                orden.setEstado(EstadoOrden.LISTA);
                ordenes_pendientes.remove();

                boolean todoListo = true;
                for(Orden or2 : clie.getOrdenes()){
                    if(!(or2.getEstado()== EstadoOrden.LISTA))
                        todoListo = false;
                }
                if(todoListo){
                    for(Orden or2 : clie.getOrdenes()){
                        or2.setEstado(EstadoOrden.ENTREGADO);
                    }
                    clie.getVisita().setHora_entrega(new Time(time.getHourOfDay(),time.getMinuteOfHour(),time.getSecondOfMinute()));
                    //Aqui se decide si es para llevar o comer aqui..
                    clie.setEstado(EstadoCliente.COMIENDO);
                    
                    //Para este tiempo se puede aplicar una dist. Exponencial dependiendo la cantidad de ordenes que tiene
                    LocalTime lt = time.plusMinutes(Utilities.intRand(5, 30));
                    clie.getVisita().setHora_fin_comer(new Time(lt.getHourOfDay(),lt.getMinuteOfHour(),lt.getSecondOfMinute()));
                    
                    for(Cliente clie2 :parados){
                        if(clie2 == clie){
                            parados.changeStatus(EstadoCliente.COMIENDO, clie2);
                            return ;
                        }
                    }

                    for(Cliente clie2 :sentados){
                        if(clie2 == clie){
                            sentados.changeStatus(EstadoCliente.COMIENDO, clie2);
                            return ;
                        }
                    }
                }
            }
                
            
        }
        
        @Override
        public void run() {
           int countSalida=0;
           for(;;){
               
               if(!ordenes_pendientes.isEmpty()){
                    countSalida=0;
                    Orden orden = ordenes_pendientes.get(0);
                    orden.setT_fin_cola(new Time(time.getHourOfDay(), time.getMinuteOfHour(), time.getSecondOfMinute()));
                    int minPreparacion = Utilities.intRand(
                            orden.getProducto().getTiempo_min_prep(),
                            orden.getProducto().getTiempo_max_prep());
                    LocalTime tiempoEntrega = time.plusMinutes(minPreparacion);
                    LocalTime lt = time.plusMinutes(minPreparacion);
                    orden.setT_entrega(new Time(lt.getHourOfDay(), lt.getMinuteOfHour(), lt.getSecondOfMinute()));
                    long milis = (minPreparacion * 60000)/denominador_tiempo ;
                   
                    try {
                       /*System.out.println("Minutos Min = "+orden.getProducto().getTiempo_min_prep()+" Min Max= "+orden.getProducto().getTiempo_max_prep());
                       System.out.println("Minutos prepa = "+minPreparacion);
                       System.out.println("Milis = "+milis);*/
                       //System.out.println("Plato Preparado = " +orden.getProducto().getNombre());
                    
                       sleep(milis);
                       buscarCliente(orden);
                   } catch (InterruptedException ex) {
                       Logger.getLogger(frm_principal.class.getName()).log(Level.SEVERE, null, ex);
                   }
                   
                    
                    
               }
               else{
                   try {
                       sleep(240000 / denominador_tiempo);
                   } catch (InterruptedException ex) {
                       Logger.getLogger(frm_principal.class.getName()).log(Level.SEVERE, null, ex);
                   }
                   
                   if(countSalida == 20){
                       LOGGER.info("Se fue el cocinero -----------------------");
                       return;
                   }
                   else
                       countSalida++;
               }
            }
        }

        public ListaOrden getOrdenes_pendientes() {
            return ordenes_pendientes;
        }

        public void setOrdenes_pendientes(ListaOrden ordenes_pendientes) {
            this.ordenes_pendientes = ordenes_pendientes;
        }

        public ArrayList<Orden> getOrdenes_entregadas() {
            return ordenes_entregadas;
        }

        public void setOrdenes_entregadas(ArrayList<Orden> ordenes_entregadas) {
            this.ordenes_entregadas = ordenes_entregadas;
        }
        
    
    
    }
    
    private class HiloCocineroWorker extends SwingWorker<Cliente, Cliente>{
        ListaOrden ordenes_pendientes;
        ArrayList<Orden> ordenes_entregadas;

        HiloCocineroWorker(ListaOrden lista){
            ordenes_pendientes = lista;
        }

        @Override
        protected Cliente doInBackground() throws Exception {
            for(;;){
                //System.out.println("Hello"+this.toString());
               if(!ordenes_pendientes.isEmpty()){
                    Orden orden = ordenes_pendientes.get(0);
                    //System.out.println("Plato Preparado = " +orden.getProducto().getNombre());    
                    int minPreparacion = Utilities.intRand(
                            orden.getProducto().getTiempo_min_prep(),
                            orden.getProducto().getTiempo_max_prep());
                    long milis = (minPreparacion * 60000)/denominador_tiempo ;
                   
                    Cliente clie = getCliente(orden);
                    orden.setEstado(EstadoOrden.LISTA);
                    ordenes_pendientes.remove();
                    if(clie != null)
                        publish(clie);
                    
                    
                    try {
                        sleep(milis);
                    } catch (InterruptedException ex) {
                        Logger.getLogger(frm_principal.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    
               }
               else{
                   try {
                       sleep(30000 / denominador_tiempo);
                   } catch (InterruptedException ex) {
                       Logger.getLogger(frm_principal.class.getName()).log(Level.SEVERE, null, ex);
                   }
               }
            }
        }
        
        synchronized public void CambiarEstado(Cliente clie) {
            
            
                    
                    if(clie != null){//Se encontro la orden que se preparo
                     
                        boolean todoListo = true;
                        for(Orden or2 : clie.getOrdenes()){
                            if(!(or2.getEstado()== EstadoOrden.LISTA))
                                todoListo = false;
                        }
                        if(todoListo){
                            for(Orden or2 : clie.getOrdenes()){
                                or2.setEstado(EstadoOrden.ENTREGADO);
                            }
                            clie.setEstado(EstadoCliente.COMIENDO);
                           
                            for(Cliente clie2 :parados){
                                if(clie2 == clie){
                                    parados.changeStatus(EstadoCliente.COMIENDO, clie2);
                                    return ;
                                }
                            }
                            
                            for(Cliente clie2 :sentados){
                                if(clie2 == clie){
                                    sentados.changeStatus(EstadoCliente.COMIENDO, clie2);
                                    return ;
                                }
                            }
                        }
                    }
                
            
        }
        
        @Override
        protected void process(List<Cliente> clie){    
            
            CambiarEstado(clie.get(0));       
        }
        
    }
    
    private class Reloj extends SwingWorker<Object, Integer>{
        
        //LocalTime timeReloj;
        
        Reloj(){
            time = new LocalTime(7,0,0);//Apertura
        }
 

        @Override
        protected Object doInBackground() throws Exception {
            while(time.getHourOfDay()<12){
                int milis= 1000/denominador_tiempo;
                
                sleep(milis, 0);
                publish(milis);
            }
            return null;
        }
        
        @Override
        protected void process(List<Integer> chunk){
            time = time.plusMillis(150000);//Medio minito
            lblTiempo.setText(time.getHourOfDay()+":"+time.getMinuteOfHour()+":"+time.getSecondOfMinute());
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
    private javax.swing.JPanel BbqPanel;
    private javax.swing.JPanel HdPanel;
    private javax.swing.JPanel PlanchaPanel;
    private javax.swing.JPanel YaroaPanel;
    private javax.swing.JButton btnIniciarSim;
    private javax.swing.JComboBox<String> cmbDias;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lblCantBbq;
    private javax.swing.JLabel lblCantHd;
    private javax.swing.JLabel lblCantPlancha;
    private javax.swing.JLabel lblCantYaroa;
    private javax.swing.JLabel lblTiempo;
    private javax.swing.JPanel panelCliLlegando;
    private javax.swing.JPanel panelCliParados;
    private javax.swing.JPanel panelCliSentados;
    private javax.swing.JPanel panelCocina;
    private javax.swing.JTextField txtBbq;
    private javax.swing.JTextField txtHd;
    private javax.swing.JTextField txtPlancha;
    private javax.swing.JTextField txtYaroa;
    // End of variables declaration//GEN-END:variables
}
