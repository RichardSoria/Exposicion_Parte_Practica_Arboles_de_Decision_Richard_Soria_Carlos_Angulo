/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pruebadesicion;

import java.awt.BorderLayout;
import java.io.IOException;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;

public class Vista extends javax.swing.JFrame {

    public Vista() {
        initComponents();
        setTitle("Arboles de Decisión en Java");
        setLocationRelativeTo(null);
        seleccionRadio();
        desactivarBotones();
        desactivarRaiz();
        desactivarResponder();
        activaAutomatico();
        setResizable(false);
    }
    ArbolDecision ad;
    AbrirArchivo abrirArch;

    private void limpiar() {
        txtRaiz.setText("");
        txtCuerpo.setText("");
        txtRef.setText("");
        txtValor.setText("");
        VALORES.setText("");
        RESULTADO.setText("");
    }

    private void seleccionRadio() {
        grupo.add(radioSI);
        grupo.add(radioNO);
        grupo.add(radioAutomatico);
        grupo.add(radioManual);
    }

    private void desactivarResponder() {
        btnResponder.setVisible(false);
        btnResponderCOPIA.setVisible(false);
    }

    private void activarBotones() {
        if (ad.getRes()) {
            jPanel1.setEnabled(true);
            jc.setVisible(true);
            btnResponder.setEnabled(true);
            btnInsertar.setEnabled(true);
            txtValor.setEnabled(true);
            txtRef.setEnabled(true);
            txtCuerpo.setEnabled(true);
            radioNO.setEnabled(true);
            radioSI.setEnabled(true);
        }
    }

    private void desactivarBotones() {
        jPanel1.setEnabled(false);
        jc.setVisible(false);
        btnResponder.setEnabled(false);
        btnInsertar.setEnabled(false);
        txtValor.setEnabled(false);
        txtRef.setEnabled(false);
        txtCuerpo.setEnabled(false);
        RESULTADO.setEditable(false);
        VALORES.setEditable(false);
        radioNO.setEnabled(false);
        radioSI.setEnabled(false);
    }

    private void activaAutomatico() {
        btnCargarArchivo.setEnabled(false);
        btnNuevo.setEnabled(false);
    }

    private void activaManual() {
        btnCargarArchivo.setEnabled(true);
        btnNuevo.setEnabled(true);
    }

    private void activarRaiz() {
        txtRaiz.setEnabled(true);
        btnRaiz.setEnabled(true);
    }

    private void desactivarRaiz() {
        txtRaiz.setEnabled(false);
        btnRaiz.setEnabled(false);
    }

    private String resultado() {
        String res = "";
        for (int i = 0; i < ad.getMap().size(); i++) {
            res += ad.getMap();
        }
        return res;
    }

    private void cargarEntro(String url) throws IOException {
        VALORES.setText("");
        Lectura l = new Lectura();
        if (l.lectura(url)) {
            String[] nombreAtri = l.getNombreAtri();
            String[][] tabla = l.getTabla();
            Utilidades util = new Utilidades(nombreAtri.length);
            int totalAtributos = nombreAtri.length;
            int posdecision = nombreAtri.length;
            int totalEjemplos = tabla.length;
            int[] noSi = new int[3];
            VALORES.append(util.imprimitTabla(tabla, nombreAtri, totalEjemplos, totalAtributos));
            System.out.println(util.imprimitTabla(tabla, nombreAtri, totalEjemplos, totalAtributos));
            VALORES.append(System.getProperty("line.separator"));
            String atri = "";
            String sal;
            double suma;
            for (int posAtributo = 0; posAtributo < posdecision; posAtributo++) {
                suma = 0;
                util.setIndiceAtri(0);
                System.out.println("Calculo de: " + nombreAtri[posAtributo]);
                VALORES.append("Calculo de: " + nombreAtri[posAtributo]);
                VALORES.append(System.getProperty("line.separator"));
                for (int k = 0; k < totalEjemplos; k++) {
                    atri = tabla[k][posAtributo];
                    if (!util.procesadoAtri(atri)) {
                        noSi = Utilidades.atributoDecision(atri, posAtributo, posdecision, tabla, totalEjemplos);
                        double infor = util.infor((double) noSi[0] / noSi[2], (double) noSi[1] / noSi[2]);
                        System.out.println(atri + " pos (" + noSi[0] + ") nega (" + noSi[1] + ") "
                                + " total (" + noSi[2] + ") total/ejemplos (" + (double) noSi[2] / totalEjemplos
                                + ")-- infor(" + infor + ") total*infor ("
                                + (double) noSi[2] / totalEjemplos * infor + ")");
                        sal = atri + " pos (" + noSi[0] + ") nega (" + noSi[1] + ") "
                                + " total (" + noSi[2] + ") total/ejemplos (" + (double) noSi[2] / totalEjemplos
                                + ")-- infor(" + infor + ") total*infor ("
                                + (double) noSi[2] / totalEjemplos * infor + ")";
                        VALORES.append(sal);
                        VALORES.append(System.getProperty("line.separator"));
                        suma += (double) noSi[2] / totalEjemplos * infor;

                    }
                    util.adicionarAtri(atri);
                }
                System.out.println("******************************");
                VALORES.append("******************************");
                VALORES.append(System.getProperty("line.separator"));
                System.out.println("" + nombreAtri[posAtributo] + "-> " + suma);
                VALORES.append("" + nombreAtri[posAtributo] + "-> " + suma);
                VALORES.append(System.getProperty("line.separator"));
                System.out.println("******************************");
                VALORES.append("******************************");
                VALORES.append(System.getProperty("line.separator"));
                util.adicionarValorAtri(suma);
            }
            util.ordenarV(nombreAtri);
            VALORES.append(util.imprimeV(nombreAtri));
            System.out.println(util.imprimeV(nombreAtri));
        } else {
            JOptionPane.showMessageDialog(null, "Ocurrio un Error", "ERROR", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        grupo = new javax.swing.ButtonGroup();
        PanelEntradas = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtRaiz = new javax.swing.JTextField();
        txtRef = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtValor = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtCuerpo = new javax.swing.JTextField();
        btnInsertar = new javax.swing.JButton();
        btnRaiz = new javax.swing.JButton();
        radioSI = new javax.swing.JRadioButton();
        radioNO = new javax.swing.JRadioButton();
        btnResponder = new javax.swing.JButton();
        btnCargarArchivo = new javax.swing.JButton();
        btnNuevo = new javax.swing.JButton();
        radioManual = new javax.swing.JRadioButton();
        radioAutomatico = new javax.swing.JRadioButton();
        btnAceptar = new javax.swing.JButton();
        btnResponderCOPIA = new javax.swing.JButton();
        PanelSalida = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        RESULTADO = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        VALORES = new javax.swing.JTextArea();
        jPanel1 = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        PanelEntradas.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Entradas"));

        jLabel1.setFont(new java.awt.Font("Times New Roman", 0, 11)); // NOI18N
        jLabel1.setText("Nodo Raiz:");

        jLabel2.setFont(new java.awt.Font("Times New Roman", 0, 11)); // NOI18N
        jLabel2.setText("Referencia:");

        jLabel3.setFont(new java.awt.Font("Times New Roman", 0, 11)); // NOI18N
        jLabel3.setText("Id Nuevo Nodo:");

        jLabel4.setFont(new java.awt.Font("Times New Roman", 0, 11)); // NOI18N
        jLabel4.setText("Cuerpo:");

        btnInsertar.setFont(new java.awt.Font("Times New Roman", 0, 11)); // NOI18N
        btnInsertar.setText("INSERTAR");
        btnInsertar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnInsertarActionPerformed(evt);
            }
        });

        btnRaiz.setFont(new java.awt.Font("Times New Roman", 0, 11)); // NOI18N
        btnRaiz.setText("Crear Raiz");
        btnRaiz.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRaizActionPerformed(evt);
            }
        });

        radioSI.setFont(new java.awt.Font("Times New Roman", 0, 11)); // NOI18N
        radioSI.setText("RAMA SI");

        radioNO.setFont(new java.awt.Font("Times New Roman", 0, 11)); // NOI18N
        radioNO.setText("RAMA NO");

        btnResponder.setFont(new java.awt.Font("Times New Roman", 0, 11)); // NOI18N
        btnResponder.setText("RESPONDER");
        btnResponder.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnResponderActionPerformed(evt);
            }
        });

        btnCargarArchivo.setFont(new java.awt.Font("Times New Roman", 0, 11)); // NOI18N
        btnCargarArchivo.setText("ABRIR ARCHVO");
        btnCargarArchivo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCargarArchivoActionPerformed(evt);
            }
        });

        btnNuevo.setFont(new java.awt.Font("Times New Roman", 0, 11)); // NOI18N
        btnNuevo.setText("NUEVO ARBOL");
        btnNuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNuevoActionPerformed(evt);
            }
        });

        radioManual.setText("MANUAL");

        radioAutomatico.setText("AUTOMATICO");

        btnAceptar.setFont(new java.awt.Font("Times New Roman", 0, 11)); // NOI18N
        btnAceptar.setText("ACEPTAR");
        btnAceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAceptarActionPerformed(evt);
            }
        });

        btnResponderCOPIA.setFont(new java.awt.Font("Times New Roman", 0, 11)); // NOI18N
        btnResponderCOPIA.setText("RESPONDER");
        btnResponderCOPIA.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnResponderCOPIAActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout PanelEntradasLayout = new javax.swing.GroupLayout(PanelEntradas);
        PanelEntradas.setLayout(PanelEntradasLayout);
        PanelEntradasLayout.setHorizontalGroup(
            PanelEntradasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelEntradasLayout.createSequentialGroup()
                .addGroup(PanelEntradasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PanelEntradasLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(PanelEntradasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3))
                        .addGap(13, 13, 13))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelEntradasLayout.createSequentialGroup()
                        .addGap(29, 29, 29)
                        .addGroup(PanelEntradasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)))
                .addGroup(PanelEntradasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtRaiz)
                    .addComponent(txtValor)
                    .addComponent(txtRef, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(txtCuerpo, javax.swing.GroupLayout.Alignment.TRAILING))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelEntradasLayout.createSequentialGroup()
                .addGap(0, 30, Short.MAX_VALUE)
                .addGroup(PanelEntradasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelEntradasLayout.createSequentialGroup()
                        .addComponent(btnRaiz)
                        .addGap(115, 115, 115))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelEntradasLayout.createSequentialGroup()
                        .addGroup(PanelEntradasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(radioManual)
                            .addComponent(btnCargarArchivo)
                            .addComponent(radioSI))
                        .addGap(18, 18, 18)
                        .addGroup(PanelEntradasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelEntradasLayout.createSequentialGroup()
                                .addGroup(PanelEntradasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(btnNuevo)
                                    .addGroup(PanelEntradasLayout.createSequentialGroup()
                                        .addComponent(btnAceptar, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(radioAutomatico)
                                        .addGap(12, 12, 12)))
                                .addContainerGap())
                            .addGroup(PanelEntradasLayout.createSequentialGroup()
                                .addGroup(PanelEntradasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(btnResponder, javax.swing.GroupLayout.DEFAULT_SIZE, 109, Short.MAX_VALUE)
                                    .addComponent(btnInsertar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(btnResponderCOPIA, javax.swing.GroupLayout.DEFAULT_SIZE, 109, Short.MAX_VALUE))
                                .addGap(18, 18, 18)
                                .addComponent(radioNO)
                                .addGap(16, 16, 16))))))
        );
        PanelEntradasLayout.setVerticalGroup(
            PanelEntradasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelEntradasLayout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addGroup(PanelEntradasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtRaiz, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(btnRaiz)
                .addGap(28, 28, 28)
                .addGroup(PanelEntradasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtRef, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(PanelEntradasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtValor, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addGap(18, 18, 18)
                .addGroup(PanelEntradasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtCuerpo, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addGap(28, 28, 28)
                .addGroup(PanelEntradasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnInsertar)
                    .addComponent(radioSI)
                    .addComponent(radioNO))
                .addGap(71, 71, 71)
                .addComponent(btnResponder)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnResponderCOPIA)
                .addGap(43, 43, 43)
                .addGroup(PanelEntradasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCargarArchivo)
                    .addComponent(btnNuevo))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 64, Short.MAX_VALUE)
                .addGroup(PanelEntradasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(radioManual)
                    .addComponent(radioAutomatico)
                    .addComponent(btnAceptar))
                .addGap(55, 55, 55))
        );

        PanelSalida.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Salidas"));

        jLabel5.setFont(new java.awt.Font("Times New Roman", 0, 11)); // NOI18N
        jLabel5.setText("RESULTADO:");

        jLabel6.setFont(new java.awt.Font("Times New Roman", 0, 11)); // NOI18N
        jLabel6.setText("VALORES:");

        VALORES.setColumns(20);
        VALORES.setFont(new java.awt.Font("NSimSun", 0, 13)); // NOI18N
        VALORES.setRows(5);
        jScrollPane2.setViewportView(VALORES);

        javax.swing.GroupLayout PanelSalidaLayout = new javax.swing.GroupLayout(PanelSalida);
        PanelSalida.setLayout(PanelSalidaLayout);
        PanelSalidaLayout.setHorizontalGroup(
            PanelSalidaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelSalidaLayout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addGroup(PanelSalidaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel5)
                    .addComponent(jLabel6))
                .addGap(18, 18, 18)
                .addGroup(PanelSalidaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 672, Short.MAX_VALUE)
                    .addComponent(RESULTADO))
                .addContainerGap())
        );
        PanelSalidaLayout.setVerticalGroup(
            PanelSalidaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelSalidaLayout.createSequentialGroup()
                .addGroup(PanelSalidaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PanelSalidaLayout.createSequentialGroup()
                        .addGap(47, 47, 47)
                        .addComponent(jLabel6))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(PanelSalidaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(RESULTADO, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addContainerGap(27, Short.MAX_VALUE))
        );

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Grafica"));
        jPanel1.setAutoscrolls(true);
        jPanel1.setMaximumSize(new java.awt.Dimension(824, 434));
        jPanel1.setLayout(new java.awt.BorderLayout());

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(PanelSalida, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(PanelEntradas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(PanelEntradas, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(PanelSalida, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
        );

        PanelEntradas.getAccessibleContext().setAccessibleDescription("");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnInsertarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnInsertarActionPerformed
        if (txtCuerpo.getText().length() > 0 && txtRef.getText().length() > 0 && txtValor.getText().length() > 0) {
            if (radioSI.isSelected()) {
                int ref = Integer.parseInt(txtRef.getText());
                int val = Integer.parseInt(txtValor.getText());
                ad.addNodoSI(ref, val, txtCuerpo.getText());
//                ad.grafica("arbol_texto.jpg");
                complementos();
            } else if (radioNO.isSelected()) {
                int ref = Integer.parseInt(txtRef.getText());
                int val = Integer.parseInt(txtValor.getText());
                ad.addNodoNO(ref, val, txtCuerpo.getText());
//                ad.grafica("arbol_texto.jpg");
                complementos();
            } else {
                JOptionPane.showMessageDialog(null, "Seleccione un Rama del NODO- SI o NO", "AVISO", JOptionPane.INFORMATION_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(null, "Llene todos los campos", "AVISO", JOptionPane.INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_btnInsertarActionPerformed

    private void btnRaizActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRaizActionPerformed
        if (txtRaiz.getText().length() > 0) {
            ad = new ArbolDecision();
            ad.crearRaiz(1, txtRaiz.getText());
//            ad.grafica("arbol_texto.jpg");
            complementos();
            desactivarRaiz();
            activarBotones();
        } else {
            JOptionPane.showMessageDialog(null, "Ingrese valor en Nodo Raiz", "AVISO", JOptionPane.INFORMATION_MESSAGE);
        }

    }//GEN-LAST:event_btnRaizActionPerformed

    private void btnResponderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnResponderActionPerformed
        try {
            if (ad.getRes()) {
                ad.grafica("arbol_texto.jpg");
                desactivarBotones();
                ad.consultaArbolBinario();
                RESULTADO.setText(resultado().toUpperCase());
                activarBotones();
                ad.salidaArbolBin();
            }
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, "A ocurrido un error", "ERROR", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnResponderActionPerformed

    private void btnCargarArchivoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCargarArchivoActionPerformed
        try {
            abrirArch = new AbrirArchivo();
            btnCargarArchivo.setEnabled(false);
            cargarEntro(abrirArch.url());
            activarRaiz();
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, "Error al cargar archivo", "ERROR", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnCargarArchivoActionPerformed

    private void btnNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNuevoActionPerformed
        ad = new ArbolDecision();
        limpiar();
        complementos();
        desactivarRaiz();
        desactivarBotones();
        btnCargarArchivo.setEnabled(true);
    }//GEN-LAST:event_btnNuevoActionPerformed

    private void btnAceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAceptarActionPerformed
        if (radioManual.isSelected()) {

            activaManual();
            ad = new ArbolDecision();
            limpiar();
            complementos();
            desactivarRaiz();
            desactivarBotones();
            btnResponderCOPIA.setVisible(false);
            btnResponder.setVisible(true);
        } else if (radioAutomatico.isSelected()) {
            activaAutomatico();
            try {
                auto();
                btnResponder.setVisible(false);
                btnResponderCOPIA.setVisible(true);
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(null, "Error al cargar archivo", "ERROR", JOptionPane.ERROR_MESSAGE);
            }
        }
    }//GEN-LAST:event_btnAceptarActionPerformed

    private void btnResponderCOPIAActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnResponderCOPIAActionPerformed
        if (radioAutomatico.isSelected()) {
            try {
                if (ad.getRes()) {
                    ad.consultaArbolBinario();
                    RESULTADO.setText(resultado().toUpperCase());
                }
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(null, "A ocurrido un error", "ERROR", JOptionPane.ERROR_MESSAGE);
            }
        }
    }//GEN-LAST:event_btnResponderCOPIAActionPerformed

    private void auto() throws IOException {
        abrirArch = new AbrirArchivo();
        ad = new ArbolDecision();
        cargarEntro("archivos/farmaco.csv");
        ad.crearRaiz(1, "Es menor de 20 años?");
        ad.addNodoSI(1, 2, "Es Alergico a farmacos?");
        ad.addNodoNO(1, 3, "Tiene Presion Alta?");
        ad.addNodoSI(2, 4, "NO APLICAR");
        ad.addNodoNO(2, 5, "SI APLICAR");
        ad.addNodoSI(3, 6, "¿Tiene Alergia a los Farmacos?");
        ad.addNodoNO(3, 7, "SI APLICAR");
        ad.addNodoSI(6, 8, "NO APLICAR");
        ad.addNodoNO(6, 9, "SI APLICAR");
        complementos();
        ad.grafica("arbol_texto.jpg");
        ad.salidaArbolBin();
    }

    public void complementos() {
        this.repintarArbol();
    }

    JScrollPane jc = new JScrollPane();

    private void repintarArbol() {
        this.jPanel1.removeAll();
        jc = new JScrollPane(ad.getdibujo());
        jc.setVisible(true);
        System.out.println("tamaño " + ad.getdibujo().getSize());
        this.jPanel1.add(jc, BorderLayout.CENTER);
        this.jPanel1.revalidate();
        this.jPanel1.repaint();
    }

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
            java.util.logging.Logger.getLogger(Vista.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Vista.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Vista.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Vista.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Vista().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel PanelEntradas;
    private javax.swing.JPanel PanelSalida;
    private javax.swing.JTextField RESULTADO;
    private javax.swing.JTextArea VALORES;
    private javax.swing.JButton btnAceptar;
    private javax.swing.JButton btnCargarArchivo;
    private javax.swing.JButton btnInsertar;
    private javax.swing.JButton btnNuevo;
    private javax.swing.JButton btnRaiz;
    private javax.swing.JButton btnResponder;
    private javax.swing.JButton btnResponderCOPIA;
    private javax.swing.ButtonGroup grupo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JRadioButton radioAutomatico;
    private javax.swing.JRadioButton radioManual;
    private javax.swing.JRadioButton radioNO;
    private javax.swing.JRadioButton radioSI;
    private javax.swing.JTextField txtCuerpo;
    private javax.swing.JTextField txtRaiz;
    private javax.swing.JTextField txtRef;
    private javax.swing.JTextField txtValor;
    // End of variables declaration//GEN-END:variables
}
