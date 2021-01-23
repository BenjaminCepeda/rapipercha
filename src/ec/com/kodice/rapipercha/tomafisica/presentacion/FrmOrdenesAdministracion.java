/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.com.kodice.rapipercha.tomafisica.presentacion;

import ec.com.kodice.rapipercha.tomafisica.negocio.OrdenBO;
import ec.com.kodice.rapipercha.util.UtilPresentacion;
import ec.com.kodice.rapipercha.administracion.persistencia.EmpleadoVO;
import ec.com.kodice.rapipercha.administracion.persistencia.ProveedorVO;
import ec.com.kodice.rapipercha.util.UtilPresentacion;
import java.time.Clock;
import java.time.LocalDate;
import javax.swing.JOptionPane;
import javax.swing.JTable;

/**
 *
 * Esta clase contiene atributos y métodos del formulario
 * FrmUSuarioAdministracion
 *
 * @author Benjamin Cepeda
 * @version v1.0
 * @date 2020/12/06
 */
public class FrmOrdenesAdministracion extends javax.swing.JFrame {

    private EmpleadoVO empleadoLogueado= null;
    private ProveedorVO proveedorEmpleadoLogueado = null;
    /**
     * Creates new form FrmUsuarioAdministracion
     */
    public FrmOrdenesAdministracion(EmpleadoVO empleadoLogueado, 
            ProveedorVO proveedorEmpleadoLoguedo) {
        initComponents();
        this.empleadoLogueado = empleadoLogueado;
        this.proveedorEmpleadoLogueado=proveedorEmpleadoLoguedo;
        
        this.lblNombreEmpresa.setText(proveedorEmpleadoLogueado.getNombreComercial()
            + " - "+ proveedorEmpleadoLogueado.getRazonSocial());
        
        this.lblNombreEmpleado1.setText(empleadoLogueado.getNombres() + " " +
                empleadoLogueado.getApellidos());       
        
        
        cargarTabla(dtpFecha.getDate());
        this.setLocationRelativeTo(null);
        this.setVisible(true);
               
    }

    private FrmOrdenesAdministracion() {
       // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private void cargarTabla(LocalDate fecha) {
        OrdenBO ordenBo = new OrdenBO();
        try {
            tblOrdenes.setModel(ordenBo.generaModeloDatosTabla(empleadoLogueado.getCodigo(),
                    LocalDate.now(), 
                    new Object[]{"CODIGO", "FECHA A REALIZAR", "C.EXPENDIO",
                        "LOCAL","DIRECCIÓN","GENERADO POR","GENERADO EN","ESTADO"}));
        } catch (Exception e) {
            UtilPresentacion.mostrarMensajeError(this, e.getMessage());
        } finally {
            ordenBo = null;
            btnConsultar.setEnabled(false);
            btnEditar.setEnabled(false);
            btnBorrar.setEnabled(false);
        }

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlContenedor = new javax.swing.JPanel();
        pnlCabecera = new javax.swing.JPanel();
        lblLogoRapipercha = new javax.swing.JLabel();
        lblTitulo = new javax.swing.JLabel();
        lblNombreEmpresa = new javax.swing.JLabel();
        lblTituloEmpresa = new javax.swing.JLabel();
        lblNombreEmpleado = new javax.swing.JLabel();
        lblNombreEmpleado1 = new javax.swing.JLabel();
        pnlDetalle = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblOrdenes = new javax.swing.JTable();
        lblFecha = new javax.swing.JLabel();
        dtpFecha = new com.github.lgooddatepicker.components.DatePicker();
        btnMostrar = new javax.swing.JButton();
        pnlPie = new javax.swing.JPanel();
        btnNuevo = new javax.swing.JButton();
        btnConsultar = new javax.swing.JButton();
        btnEditar = new javax.swing.JButton();
        btnBorrar = new javax.swing.JButton();
        btnSalir = new javax.swing.JButton();
        lblLogoKodice = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(0, 600));
        setResizable(false);

        pnlContenedor.setAlignmentX(0.0F);
        pnlContenedor.setAlignmentY(0.0F);
        pnlContenedor.setPreferredSize(new java.awt.Dimension(800, 600));

        pnlCabecera.setBackground(new java.awt.Color(64, 124, 202));
        pnlCabecera.setAlignmentX(0.0F);
        pnlCabecera.setAlignmentY(0.0F);
        pnlCabecera.setMaximumSize(new java.awt.Dimension(32767, 90));
        pnlCabecera.setMinimumSize(new java.awt.Dimension(0, 90));

        lblLogoRapipercha.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ec/com/kodice/rapipercha/imagenes/logo-rapipercha.png"))); // NOI18N

        lblTitulo.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lblTitulo.setForeground(new java.awt.Color(255, 255, 255));
        lblTitulo.setText("ADMINISTRACIÓN DE ORDENES POR USUARIO");

        lblNombreEmpresa.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lblNombreEmpresa.setForeground(new java.awt.Color(255, 255, 255));
        lblNombreEmpresa.setText("NOMBRE EMPRESA");

        lblTituloEmpresa.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lblTituloEmpresa.setForeground(new java.awt.Color(255, 255, 255));
        lblTituloEmpresa.setText("EMPRESA:");

        lblNombreEmpleado.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lblNombreEmpleado.setForeground(new java.awt.Color(255, 255, 255));
        lblNombreEmpleado.setText("NOMBRE EMPLEADO:");

        lblNombreEmpleado1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lblNombreEmpleado1.setForeground(new java.awt.Color(255, 255, 255));
        lblNombreEmpleado1.setText("NOMBRE EMPLEADO");

        javax.swing.GroupLayout pnlCabeceraLayout = new javax.swing.GroupLayout(pnlCabecera);
        pnlCabecera.setLayout(pnlCabeceraLayout);
        pnlCabeceraLayout.setHorizontalGroup(
            pnlCabeceraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlCabeceraLayout.createSequentialGroup()
                .addComponent(lblLogoRapipercha)
                .addGap(138, 138, 138)
                .addGroup(pnlCabeceraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, 265, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(pnlCabeceraLayout.createSequentialGroup()
                        .addComponent(lblTituloEmpresa)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(lblNombreEmpresa))
                    .addGroup(pnlCabeceraLayout.createSequentialGroup()
                        .addComponent(lblNombreEmpleado)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblNombreEmpleado1, javax.swing.GroupLayout.PREFERRED_SIZE, 234, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        pnlCabeceraLayout.setVerticalGroup(
            pnlCabeceraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlCabeceraLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlCabeceraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlCabeceraLayout.createSequentialGroup()
                        .addComponent(lblTitulo)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(pnlCabeceraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblTituloEmpresa)
                            .addComponent(lblNombreEmpresa))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 15, Short.MAX_VALUE)
                        .addGroup(pnlCabeceraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblNombreEmpleado)
                            .addComponent(lblNombreEmpleado1)))
                    .addGroup(pnlCabeceraLayout.createSequentialGroup()
                        .addComponent(lblLogoRapipercha)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );

        pnlDetalle.setAlignmentX(0.0F);
        pnlDetalle.setAlignmentY(0.0F);
        pnlDetalle.setPreferredSize(new java.awt.Dimension(805, 435));

        tblOrdenes.setModel(new javax.swing.table.DefaultTableModel(
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
        tblOrdenes.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        tblOrdenes.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                tblOrdenesMousePressed(evt);
            }
        });
        jScrollPane1.setViewportView(tblOrdenes);

        lblFecha.setText("Fecha a Buscar:");

        btnMostrar.setText("Mostrar");
        btnMostrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMostrarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlDetalleLayout = new javax.swing.GroupLayout(pnlDetalle);
        pnlDetalle.setLayout(pnlDetalleLayout);
        pnlDetalleLayout.setHorizontalGroup(
            pnlDetalleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 805, Short.MAX_VALUE)
            .addGroup(pnlDetalleLayout.createSequentialGroup()
                .addGap(204, 204, 204)
                .addComponent(lblFecha)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(dtpFecha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnMostrar)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pnlDetalleLayout.setVerticalGroup(
            pnlDetalleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlDetalleLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlDetalleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(dtpFecha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblFecha)
                    .addComponent(btnMostrar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 20, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 381, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pnlPie.setMaximumSize(new java.awt.Dimension(32767, 90));
        pnlPie.setMinimumSize(new java.awt.Dimension(0, 90));
        pnlPie.setPreferredSize(new java.awt.Dimension(780, 90));

        btnNuevo.setBackground(new java.awt.Color(64, 124, 202));
        btnNuevo.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnNuevo.setForeground(new java.awt.Color(255, 255, 255));
        btnNuevo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ec/com/kodice/rapipercha/imagenes/Empty document new.png"))); // NOI18N
        btnNuevo.setText("Nuevo");
        btnNuevo.setToolTipText("");
        btnNuevo.setAlignmentY(0.0F);
        btnNuevo.setBorderPainted(false);
        btnNuevo.setIconTextGap(1);
        btnNuevo.setMaximumSize(new java.awt.Dimension(118, 55));
        btnNuevo.setMinimumSize(new java.awt.Dimension(118, 55));
        btnNuevo.setPreferredSize(new java.awt.Dimension(118, 55));
        btnNuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNuevoActionPerformed(evt);
            }
        });

        btnConsultar.setBackground(new java.awt.Color(64, 124, 202));
        btnConsultar.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnConsultar.setForeground(new java.awt.Color(255, 255, 255));
        btnConsultar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ec/com/kodice/rapipercha/imagenes/Zoom.png"))); // NOI18N
        btnConsultar.setText("Consultar");
        btnConsultar.setToolTipText("");
        btnConsultar.setAlignmentY(0.0F);
        btnConsultar.setBorderPainted(false);
        btnConsultar.setIconTextGap(1);
        btnConsultar.setMaximumSize(new java.awt.Dimension(135, 55));
        btnConsultar.setMinimumSize(new java.awt.Dimension(135, 55));
        btnConsultar.setPreferredSize(new java.awt.Dimension(135, 55));
        btnConsultar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConsultarActionPerformed(evt);
            }
        });

        btnEditar.setBackground(new java.awt.Color(64, 124, 202));
        btnEditar.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnEditar.setForeground(new java.awt.Color(255, 255, 255));
        btnEditar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ec/com/kodice/rapipercha/imagenes/Pencil yellow.png"))); // NOI18N
        btnEditar.setText("Editar");
        btnEditar.setAlignmentY(0.0F);
        btnEditar.setBorderPainted(false);
        btnEditar.setIconTextGap(1);
        btnEditar.setMaximumSize(new java.awt.Dimension(118, 55));
        btnEditar.setMinimumSize(new java.awt.Dimension(118, 55));
        btnEditar.setPreferredSize(new java.awt.Dimension(118, 55));
        btnEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarActionPerformed(evt);
            }
        });

        btnBorrar.setBackground(new java.awt.Color(64, 124, 202));
        btnBorrar.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnBorrar.setForeground(new java.awt.Color(255, 255, 255));
        btnBorrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ec/com/kodice/rapipercha/imagenes/Badge-multiply.png"))); // NOI18N
        btnBorrar.setText("Borrar");
        btnBorrar.setAlignmentY(0.0F);
        btnBorrar.setBorderPainted(false);
        btnBorrar.setIconTextGap(1);
        btnBorrar.setMaximumSize(new java.awt.Dimension(118, 55));
        btnBorrar.setMinimumSize(new java.awt.Dimension(118, 55));
        btnBorrar.setPreferredSize(new java.awt.Dimension(118, 55));
        btnBorrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBorrarActionPerformed(evt);
            }
        });

        btnSalir.setBackground(new java.awt.Color(64, 124, 202));
        btnSalir.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnSalir.setForeground(new java.awt.Color(255, 255, 255));
        btnSalir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ec/com/kodice/rapipercha/imagenes/Badge-cancel.png"))); // NOI18N
        btnSalir.setText("Salir");
        btnSalir.setAlignmentY(0.0F);
        btnSalir.setBorderPainted(false);
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
        lblLogoKodice.setMaximumSize(new java.awt.Dimension(125, 50));
        lblLogoKodice.setMinimumSize(new java.awt.Dimension(125, 50));
        lblLogoKodice.setPreferredSize(new java.awt.Dimension(100, 55));

        javax.swing.GroupLayout pnlPieLayout = new javax.swing.GroupLayout(pnlPie);
        pnlPie.setLayout(pnlPieLayout);
        pnlPieLayout.setHorizontalGroup(
            pnlPieLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlPieLayout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addComponent(btnNuevo, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnConsultar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnEditar, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnBorrar, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnSalir, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(lblLogoKodice, javax.swing.GroupLayout.DEFAULT_SIZE, 140, Short.MAX_VALUE)
                .addContainerGap())
        );
        pnlPieLayout.setVerticalGroup(
            pnlPieLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlPieLayout.createSequentialGroup()
                .addContainerGap(24, Short.MAX_VALUE)
                .addGroup(pnlPieLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlPieLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnNuevo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnConsultar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnEditar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnBorrar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnSalir, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(lblLogoKodice, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        javax.swing.GroupLayout pnlContenedorLayout = new javax.swing.GroupLayout(pnlContenedor);
        pnlContenedor.setLayout(pnlContenedorLayout);
        pnlContenedorLayout.setHorizontalGroup(
            pnlContenedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlDetalle, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(pnlCabecera, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(pnlPie, javax.swing.GroupLayout.DEFAULT_SIZE, 805, Short.MAX_VALUE)
        );
        pnlContenedorLayout.setVerticalGroup(
            pnlContenedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlContenedorLayout.createSequentialGroup()
                .addComponent(pnlCabecera, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pnlDetalle, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pnlPie, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlContenedor, javax.swing.GroupLayout.DEFAULT_SIZE, 805, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(pnlContenedor, javax.swing.GroupLayout.PREFERRED_SIZE, 630, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 11, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNuevoActionPerformed
        FrmOrdenNueva frmOrdenNueva = new FrmOrdenNueva(empleadoLogueado,proveedorEmpleadoLogueado);
        frmOrdenNueva.setVisible(true);
        //cargarModelo();

    }//GEN-LAST:event_btnNuevoActionPerformed

    private void btnBorrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBorrarActionPerformed
        /*String codigoElegido = "";
        String descripcionElegido = "";
        boolean confirmacionBorrado = false;
        int fila = tblOrdenes.getSelectedRow();
        if (fila >= 0) {
            codigoElegido = tblOrdenes.getModel().getValueAt(
                    fila, 0).toString();
            descripcionElegido = tblOrdenes.getModel().getValueAt(
                    fila, 1).toString();
        }
        if (!(codigoElegido.isEmpty() | codigoElegido.isBlank())) {
            confirmacionBorrado = (UtilPresentacion.mostrarMensajeConfirmacion(
                    this, "Desea eliminar el registro:\n" + codigoElegido + " - "
                    + descripcionElegido) == JOptionPane.YES_OPTION);
            if (confirmacionBorrado) {
                UsuarioBO usuarioBO = new UsuarioBO();
                try {
                    usuarioBO.eliminar(Integer.valueOf(codigoElegido));
                } catch (Exception e) {
                    UtilPresentacion.mostrarMensajeError(this, e.getMessage());
                } finally {
                    usuarioBO = null;
                }
            }
            cargarModelo();
        }*/

    }//GEN-LAST:event_btnBorrarActionPerformed

    private void btnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirActionPerformed
        this.setVisible(false);
        this.dispose();
    }//GEN-LAST:event_btnSalirActionPerformed

    private void btnEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarActionPerformed
        String codigoElegido = "";
        int fila = tblOrdenes.getSelectedRow();
        if (fila >= 0) {
            codigoElegido = tblOrdenes.getModel().getValueAt(
                    fila, 0).toString();
        }
        if (!(codigoElegido.isEmpty() | codigoElegido.isBlank())) {
            FrmOrdenNueva frmOrdenNueva = new FrmOrdenNueva(
                    Integer.valueOf(codigoElegido), false);
            frmOrdenNueva.setVisible(true);
       //     cargarModelo();
        }
    }//GEN-LAST:event_btnEditarActionPerformed

    private void tblOrdenesMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblOrdenesMousePressed
        JTable source = (JTable) evt.getSource();
        String codigoElegido = "";
        int fila = source.rowAtPoint(evt.getPoint());
        int column = source.columnAtPoint(evt.getPoint());
        if (fila >= 0) {
            codigoElegido = tblOrdenes.getModel().getValueAt(
                    fila, 0).toString();
            btnConsultar.setEnabled(true);
            btnEditar.setEnabled(true);
            btnBorrar.setEnabled(true);
            if (evt.getClickCount() == 2 && !codigoElegido.isEmpty() && !codigoElegido.isBlank()) {
                FrmOrdenNueva frmOrdenNueva = new FrmOrdenNueva(
                        Integer.valueOf(codigoElegido),true);
                frmOrdenNueva.setVisible(true);
              //  cargarModelo();
            }
        }
    }//GEN-LAST:event_tblOrdenesMousePressed

    private void btnConsultarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConsultarActionPerformed
      
        String codigoElegido = "";
        int fila = tblOrdenes.getSelectedRow();
        if (fila >= 0) {
            codigoElegido = tblOrdenes.getModel().getValueAt(
                    fila, 0).toString();
        }
        if (!(codigoElegido.isEmpty() | codigoElegido.isBlank())) {
            FrmOrdenNueva frmOrdenNueva = new FrmOrdenNueva(
                    Integer.valueOf(codigoElegido), true);
            frmOrdenNueva.setVisible(true);
        //    cargarModelo();
        }
    }//GEN-LAST:event_btnConsultarActionPerformed

    private void btnMostrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMostrarActionPerformed
        cargarTabla(dtpFecha.getDate());
    }//GEN-LAST:event_btnMostrarActionPerformed

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
            java.util.logging.Logger.getLogger(FrmOrdenesAdministracion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmOrdenesAdministracion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmOrdenesAdministracion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmOrdenesAdministracion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrmOrdenesAdministracion().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBorrar;
    private javax.swing.JButton btnConsultar;
    private javax.swing.JButton btnEditar;
    private javax.swing.JButton btnMostrar;
    private javax.swing.JButton btnNuevo;
    private javax.swing.JButton btnSalir;
    private com.github.lgooddatepicker.components.DatePicker dtpFecha;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblFecha;
    private javax.swing.JLabel lblLogoKodice;
    private javax.swing.JLabel lblLogoRapipercha;
    private javax.swing.JLabel lblNombreEmpleado;
    private javax.swing.JLabel lblNombreEmpleado1;
    private javax.swing.JLabel lblNombreEmpresa;
    private javax.swing.JLabel lblTitulo;
    private javax.swing.JLabel lblTituloEmpresa;
    private javax.swing.JPanel pnlCabecera;
    private javax.swing.JPanel pnlContenedor;
    private javax.swing.JPanel pnlDetalle;
    private javax.swing.JPanel pnlPie;
    private javax.swing.JTable tblOrdenes;
    // End of variables declaration//GEN-END:variables

}
