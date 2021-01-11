/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ec.com.kodice.rapipercha.tomafisica.presentacion;

import ec.com.kodice.rapipercha.tomafisica.negocio.OrdenBO;
import ec.com.kodice.rapipercha.administracion.persistencia.EmpleadoVO;
import ec.com.kodice.rapipercha.administracion.persistencia.ProveedorVO;
import ec.com.kodice.rapipercha.administracion.presentacion.FrmProveedorNuevo;
import ec.com.kodice.rapipercha.tomafisica.persistencia.OrdenVO;
import ec.com.kodice.rapipercha.util.UtilPresentacion;
import java.time.format.DateTimeFormatter;
import javax.swing.JFrame;
import javax.swing.JTable;

/**
 *
 * Esta clase contiene atributos y métodos del formulario FrmPerfilAdministracion
 * @author Benjamin Cepeda
 * @version v1.0
 * @date 2020/12/06
 */
public class FrmTomaFisicaNuevo extends JFrame {
    private EmpleadoVO empleadoLogueado= null;
    private ProveedorVO proveedorEmpleadoLogueado = null;
    private int codigoOrdenActual = 0;

    /** Creates new form FrmPerfilAdministracion */
    public FrmTomaFisicaNuevo() {
        initComponents();
        this.setLocationRelativeTo(null);
    }
    public FrmTomaFisicaNuevo(EmpleadoVO empleadoLogueado, 
            ProveedorVO proveedorEmpleadoLoguedo, int codigoOrdenActual) {
        this.empleadoLogueado = empleadoLogueado;
        this.proveedorEmpleadoLogueado = proveedorEmpleadoLoguedo;
        this.codigoOrdenActual = codigoOrdenActual;
        OrdenBO ordenBO = new OrdenBO();
        OrdenVO ordenVO = new OrdenVO();
        lblNombreEmpresa.setText(proveedorEmpleadoLogueado.getNombreComercial()
            + " - "+ proveedorEmpleadoLogueado.getRazonSocial());
        lblNombreEmpleado.setText(empleadoLogueado.getNombres() + " " +
                empleadoLogueado.getApellidos());        
        try {
            ordenVO = ordenBO.buscar(codigoOrdenActual);
            lblCodigoOrden.setText(String.valueOf(ordenVO.getCodigo()));
            lblFechaOrden.setText(ordenVO.getFechaARealizar().format(DateTimeFormatter.ISO_DATE));            
        }
        catch ( Exception e) {
            UtilPresentacion.mostrarMensajeError(this, e.getMessage());
        }
        finally{
            ordenBO = null;   
        }
        initComponents();
        cargarModelo();
        this.setLocationRelativeTo(null);
    }

    private void cargarModelo(){        
        OrdenBO ordenBO = new OrdenBO();        
        try {
            tblDetalleOrden.setModel(ordenBO.generaModeloDatosTabla( 
                    empleadoLogueado.getUsuario().getCodigo(), fecha,
                new Object[]{
                    "CODIGO", "A REALIZAR", "RAZON SOCIAL", "LOCAL", "DIRECCION",
                    "GENERADO POR", "GENERADA EN"}));
        }
        catch ( Exception e) {
            UtilPresentacion.mostrarMensajeError(this, e.getMessage());
        }
        finally{
            ordenBO = null;   
        }
            
    }
    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlContenedor = new javax.swing.JPanel();
        pnlCabecera = new javax.swing.JPanel();
        lblLogoRapipercha = new javax.swing.JLabel();
        lblTituloEmpleado = new javax.swing.JLabel();
        lblNombreEmpleado = new javax.swing.JLabel();
        lblTituloEmpresa = new javax.swing.JLabel();
        lblNombreEmpresa = new javax.swing.JLabel();
        lblTituloOrden = new javax.swing.JLabel();
        lblCodigoOrden = new javax.swing.JLabel();
        lblTituloFecha = new javax.swing.JLabel();
        lblFechaOrden = new javax.swing.JLabel();
        pnlDetalle = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblDetalleOrden = new javax.swing.JTable();
        pnlPie = new javax.swing.JPanel();
        btnGrabar = new javax.swing.JButton();
        btnSalir = new javax.swing.JButton();
        lblLogoKodice = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);

        pnlContenedor.setAlignmentX(0.0F);
        pnlContenedor.setAlignmentY(0.0F);
        pnlContenedor.setPreferredSize(new java.awt.Dimension(800, 650));

        pnlCabecera.setAlignmentX(0.0F);
        pnlCabecera.setAlignmentY(0.0F);
        pnlCabecera.setBackground(new java.awt.Color(64, 124, 202));
        pnlCabecera.setMaximumSize(new java.awt.Dimension(32767, 90));
        pnlCabecera.setMinimumSize(new java.awt.Dimension(0, 90));
        pnlCabecera.setPreferredSize(new java.awt.Dimension(445, 90));

        lblLogoRapipercha.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ec/com/kodice/rapipercha/imagenes/logo-rapipercha.png"))); // NOI18N

        lblTituloEmpleado.setText("ORDENE ASIGNADA A:");
        lblTituloEmpleado.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lblTituloEmpleado.setForeground(new java.awt.Color(255, 255, 255));

        lblNombreEmpleado.setText("NOMBRE EMPLEADO");
        lblNombreEmpleado.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lblNombreEmpleado.setForeground(new java.awt.Color(255, 255, 255));

        lblTituloEmpresa.setText("EMPRESA:");
        lblTituloEmpresa.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lblTituloEmpresa.setForeground(new java.awt.Color(255, 255, 255));

        lblNombreEmpresa.setText("NOMBRE EMPRESA");
        lblNombreEmpresa.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lblNombreEmpresa.setForeground(new java.awt.Color(255, 255, 255));

        lblTituloOrden.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lblTituloOrden.setForeground(new java.awt.Color(255, 255, 255));
        lblTituloOrden.setText("ORDEN No:");

        lblCodigoOrden.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lblCodigoOrden.setForeground(new java.awt.Color(255, 255, 255));
        lblCodigoOrden.setText("# orden");

        lblTituloFecha.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lblTituloFecha.setForeground(new java.awt.Color(255, 255, 255));
        lblTituloFecha.setText("FECHA-HORA:");

        lblFechaOrden.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lblFechaOrden.setForeground(new java.awt.Color(255, 255, 255));
        lblFechaOrden.setText("2021-01-01:00");

        javax.swing.GroupLayout pnlCabeceraLayout = new javax.swing.GroupLayout(pnlCabecera);
        pnlCabecera.setLayout(pnlCabeceraLayout);
        pnlCabeceraLayout.setHorizontalGroup(
            pnlCabeceraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlCabeceraLayout.createSequentialGroup()
                .addComponent(lblLogoRapipercha)
                .addGroup(pnlCabeceraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlCabeceraLayout.createSequentialGroup()
                        .addGap(129, 129, 129)
                        .addGroup(pnlCabeceraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pnlCabeceraLayout.createSequentialGroup()
                                .addComponent(lblTituloEmpleado)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(lblNombreEmpleado, javax.swing.GroupLayout.PREFERRED_SIZE, 234, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(pnlCabeceraLayout.createSequentialGroup()
                                .addComponent(lblTituloEmpresa)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lblNombreEmpresa, javax.swing.GroupLayout.PREFERRED_SIZE, 234, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(pnlCabeceraLayout.createSequentialGroup()
                        .addGap(86, 86, 86)
                        .addComponent(lblTituloOrden)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(lblCodigoOrden, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(33, 33, 33)
                        .addComponent(lblTituloFecha)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(lblFechaOrden, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 178, Short.MAX_VALUE))
        );
        pnlCabeceraLayout.setVerticalGroup(
            pnlCabeceraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlCabeceraLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblLogoRapipercha)
                .addContainerGap(20, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlCabeceraLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(pnlCabeceraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblTituloEmpresa)
                    .addComponent(lblNombreEmpresa))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlCabeceraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblTituloEmpleado)
                    .addComponent(lblNombreEmpleado))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlCabeceraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlCabeceraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(lblTituloFecha)
                        .addComponent(lblFechaOrden)
                        .addComponent(lblCodigoOrden))
                    .addGroup(pnlCabeceraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(lblTituloOrden)))
                .addContainerGap())
        );

        pnlDetalle.setAlignmentX(0.0F);
        pnlDetalle.setAlignmentY(0.0F);

        tblDetalleOrden.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null}
            },
            new String [] {
                "Codigo", "Nombre"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblDetalleOrden.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        tblDetalleOrden.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        tblDetalleOrden.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                tblDetalleOrdenMousePressed(evt);
            }
        });
        jScrollPane1.setViewportView(tblDetalleOrden);

        pnlPie.setMaximumSize(new java.awt.Dimension(32767, 90));
        pnlPie.setMinimumSize(new java.awt.Dimension(0, 90));
        pnlPie.setPreferredSize(new java.awt.Dimension(780, 90));

        btnGrabar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ec/com/kodice/rapipercha/imagenes/Empty document new.png"))); // NOI18N
        btnGrabar.setText("Nuevo");
        btnGrabar.setAlignmentY(0.0F);
        btnGrabar.setBackground(new java.awt.Color(64, 124, 202));
        btnGrabar.setBorderPainted(false);
        btnGrabar.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnGrabar.setForeground(new java.awt.Color(255, 255, 255));
        btnGrabar.setIconTextGap(1);
        btnGrabar.setMaximumSize(new java.awt.Dimension(118, 55));
        btnGrabar.setMinimumSize(new java.awt.Dimension(118, 55));
        btnGrabar.setPreferredSize(new java.awt.Dimension(118, 55));
        btnGrabar.setToolTipText("");
        btnGrabar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGrabarActionPerformed(evt);
            }
        });

        btnSalir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ec/com/kodice/rapipercha/imagenes/Badge-cancel.png"))); // NOI18N
        btnSalir.setText("Salir");
        btnSalir.setAlignmentY(0.0F);
        btnSalir.setBackground(new java.awt.Color(64, 124, 202));
        btnSalir.setBorderPainted(false);
        btnSalir.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnSalir.setForeground(new java.awt.Color(255, 255, 255));
        btnSalir.setIconTextGap(1);
        btnSalir.setMaximumSize(new java.awt.Dimension(118, 55));
        btnSalir.setMinimumSize(new java.awt.Dimension(118, 55));
        btnSalir.setPreferredSize(new java.awt.Dimension(118, 55));
        btnSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalirActionPerformed(evt);
            }
        });

        lblLogoKodice.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ec/com/kodice/rapipercha/imagenes/logo-kodice.png"))); // NOI18N
        lblLogoKodice.setMaximumSize(new java.awt.Dimension(125, 55));
        lblLogoKodice.setMinimumSize(new java.awt.Dimension(125, 55));
        lblLogoKodice.setPreferredSize(new java.awt.Dimension(125, 55));

        javax.swing.GroupLayout pnlPieLayout = new javax.swing.GroupLayout(pnlPie);
        pnlPie.setLayout(pnlPieLayout);
        pnlPieLayout.setHorizontalGroup(
            pnlPieLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlPieLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnGrabar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnSalir, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblLogoKodice, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(16, 16, 16))
        );
        pnlPieLayout.setVerticalGroup(
            pnlPieLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlPieLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlPieLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblLogoKodice, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(pnlPieLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnGrabar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnSalir, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(24, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout pnlDetalleLayout = new javax.swing.GroupLayout(pnlDetalle);
        pnlDetalle.setLayout(pnlDetalleLayout);
        pnlDetalleLayout.setHorizontalGroup(
            pnlDetalleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1)
            .addComponent(pnlPie, javax.swing.GroupLayout.DEFAULT_SIZE, 800, Short.MAX_VALUE)
        );
        pnlDetalleLayout.setVerticalGroup(
            pnlDetalleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlDetalleLayout.createSequentialGroup()
                .addGap(45, 45, 45)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 402, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pnlPie, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout pnlContenedorLayout = new javax.swing.GroupLayout(pnlContenedor);
        pnlContenedor.setLayout(pnlContenedorLayout);
        pnlContenedorLayout.setHorizontalGroup(
            pnlContenedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlCabecera, javax.swing.GroupLayout.DEFAULT_SIZE, 800, Short.MAX_VALUE)
            .addComponent(pnlDetalle, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        pnlContenedorLayout.setVerticalGroup(
            pnlContenedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlContenedorLayout.createSequentialGroup()
                .addComponent(pnlCabecera, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pnlDetalle, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlContenedor, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlContenedor, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnGrabarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGrabarActionPerformed
        FrmProveedorNuevo frmProveedorNuevo = new FrmProveedorNuevo();
        frmProveedorNuevo.setVisible(true);  
        cargarModelo();
    }//GEN-LAST:event_btnGrabarActionPerformed

    private void btnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirActionPerformed
        this.setVisible(false);
        this.dispose();
    }//GEN-LAST:event_btnSalirActionPerformed

    private void tblDetalleOrdenMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblDetalleOrdenMousePressed
        JTable source = (JTable) evt.getSource();
        String codigoElegido = "";
        int fila = source.rowAtPoint(evt.getPoint());
        //int column = source.columnAtPoint(evt.getPoint());
        if (fila >= 0) {
            codigoElegido = tblDetalleOrden.getModel().getValueAt(
                    fila, 0).toString();
            if (evt.getClickCount() == 2 && !codigoElegido.isEmpty() && !codigoElegido.isBlank()) {
                FrmProveedorNuevo frmProveedorNuevo = new FrmProveedorNuevo(
                        Integer.valueOf(codigoElegido),true);
                frmProveedorNuevo.setVisible(true);
                cargarModelo();
            }
        }
    }//GEN-LAST:event_tblDetalleOrdenMousePressed

    /**
     * @param args the command line arguments
     */
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
            java.util.logging.Logger.getLogger(FrmTomaFisicaNuevo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmTomaFisicaNuevo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmTomaFisicaNuevo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmTomaFisicaNuevo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrmTomaFisicaNuevo().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnGrabar;
    private javax.swing.JButton btnSalir;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblCodigoOrden;
    private javax.swing.JLabel lblFechaOrden;
    private javax.swing.JLabel lblLogoKodice;
    private javax.swing.JLabel lblLogoRapipercha;
    private javax.swing.JLabel lblNombreEmpleado;
    private javax.swing.JLabel lblNombreEmpresa;
    private javax.swing.JLabel lblTituloEmpleado;
    private javax.swing.JLabel lblTituloEmpresa;
    private javax.swing.JLabel lblTituloFecha;
    private javax.swing.JLabel lblTituloOrden;
    private javax.swing.JPanel pnlCabecera;
    private javax.swing.JPanel pnlContenedor;
    private javax.swing.JPanel pnlDetalle;
    private javax.swing.JPanel pnlPie;
    private javax.swing.JTable tblDetalleOrden;
    // End of variables declaration//GEN-END:variables

}
