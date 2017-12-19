/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package simulator;

import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;

/**
 *
 * @author jonatas-melo
 */
public class InterfaceComputerSimulator extends javax.swing.JFrame {
    
    //criando uma instancia da classe computador
    Computador comp = new Computador();
    
    String instrucaoC[] = new String[2];
    String instrucao = null;
    
    DefaultListModel listaRegis = new DefaultListModel();
    DefaultListModel listaPilha = new DefaultListModel();
    
    DefaultListModel listaInstru = new DefaultListModel();
    DefaultListModel listaDados = new DefaultListModel();
    
    int indiceMemIns ;
    int indiceMemDados ;
    int indiceRegis ;
    int indicePilha ;
    
    void imprimirRegis(){
        listaRegis.removeAllElements();
        for (int i = 0; i < comp.getRegistrador().length; i++) {
            if (comp.getRegistrador()[i] == null) {
                listaRegis.addElement(i + " -> ");
            } else {
                listaRegis.addElement(i + " -> "+comp.getRegistrador()[i]);
            }
        }
    }
    
    void imprimirPilha(){
        listaPilha.removeAllElements();
        for (int i = 0; i < comp.getPilha().length; i++) {
            if (comp.getPilha()[i] == null) {
                listaPilha.addElement("  ");
            } else {
                listaPilha.addElement(comp.getPilha()[i]);
            }
        }
    }
    
    void imprimirMInstru(){
        listaInstru.removeAllElements();
        for (int i = 0; i < comp.getMinstrucao().length; i++) {
            if (comp.getMinstrucao()[i] == null) {
                listaInstru.addElement("  ");
            } else {
                listaInstru.addElement(comp.getMinstrucao()[i]);
            }
        }
    }
    
    void imprimirMDados(){
        listaDados.removeAllElements();
        for (int i = 0; i < comp.getMdados().length; i++) {
            if (comp.getMdados()[i] == null) {
                listaDados.addElement("  ");
            } else {
                listaDados.addElement(comp.getMdados()[i]);
            }
        }
    }
    
    void listar(){
        imprimirRegis();
        imprimirPilha();
        imprimirMInstru();
        imprimirMDados();
    }
    
    public boolean validarInstrucao(String instrucao){
        String instru[] = new String[2];
        if (instrucao.length() >= 5) {
            instru = instrucao.toUpperCase().split(" ");
            if (!instru[1].matches("^[0-9]*$")) {
               JOptionPane.showMessageDialog(rootPane, "Registrador não existe!!");
               return false;
            }else if(Integer.parseInt(instru[1]) > 9 || Integer.parseInt(instru[1]) < 0){
                JOptionPane.showMessageDialog(rootPane, "Registrador não encontrado!");
                return false;
            }else if(instrucao.length() < 1){
                return false;
            }
        }
        return true;
    }
    
    public boolean adicionar(String intrucao){
        if (instrucao.length() >= 5) {
            instrucaoC = instrucao.toUpperCase().split(" ");
            return true;
        } else if(instrucao.length() < 5){
            instrucaoC[0] = intrucao.trim().toUpperCase();
            instrucaoC[1] = "0";
            return true;
        }
        return false;
    }
    
    public void conferir(){
        String execultar;
        if (comp.getMinstrucao()[9] == null) {
            execultar = "  ";
            adicionar(execultar);
            lblInstrucao.setText("  ");
        }else{
            execultar = comp.getMinstrucao()[comp.getMi()+1];
            lblInstrucao.setText(execultar);
            adicionar(execultar);
            lblInstrucao.setText(execultar);
        }
    }

    /**
     * Creates new form InterfaceComputerSimulator
     */
    public InterfaceComputerSimulator() {
        initComponents();
        listar();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        listaDeRegistradores = new javax.swing.JList<>();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        listaDePilha = new javax.swing.JList<>();
        textoDeIntrucao = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        botaoAdicionar = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        listaDeIntrucao = new javax.swing.JList<>();
        jLabel6 = new javax.swing.JLabel();
        contDePrograma = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        lblInstrucao = new javax.swing.JLabel();
        botaoExecultar = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        jList1 = new javax.swing.JList<>();
        txtValor = new javax.swing.JSpinner();
        btnMov = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Computer Simulator");

        jLabel1.setFont(new java.awt.Font("Ubuntu", 1, 15)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("REGISTRADORES");

        listaDeRegistradores.setFont(new java.awt.Font("Ubuntu", 1, 15)); // NOI18N
        listaDeRegistradores.setModel(listaRegis);
        listaDeRegistradores.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                listaDeRegistradoresMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(listaDeRegistradores);

        jLabel2.setFont(new java.awt.Font("Ubuntu", 1, 15)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("PILHA");

        listaDePilha.setFont(new java.awt.Font("Ubuntu", 1, 15)); // NOI18N
        listaDePilha.setModel(listaPilha);
        jScrollPane2.setViewportView(listaDePilha);

        textoDeIntrucao.setFont(new java.awt.Font("Ubuntu", 1, 15)); // NOI18N

        jLabel3.setFont(new java.awt.Font("Ubuntu", 1, 15)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("INSTRUÇÃO:");

        botaoAdicionar.setBackground(new java.awt.Color(21, 87, 242));
        botaoAdicionar.setFont(new java.awt.Font("Ubuntu", 1, 15)); // NOI18N
        botaoAdicionar.setText("ADICIONAR");
        botaoAdicionar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoAdicionarActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Ubuntu", 1, 15)); // NOI18N
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("MEMÓRIA");

        jLabel5.setFont(new java.awt.Font("Ubuntu", 1, 15)); // NOI18N
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("DADO");

        listaDeIntrucao.setFont(new java.awt.Font("Ubuntu", 1, 15)); // NOI18N
        listaDeIntrucao.setModel(listaInstru);
        jScrollPane3.setViewportView(listaDeIntrucao);

        jLabel6.setFont(new java.awt.Font("Ubuntu", 1, 15)); // NOI18N
        jLabel6.setText("PC");

        contDePrograma.setFont(new java.awt.Font("Ubuntu", 1, 15)); // NOI18N
        contDePrograma.setText("0");

        jLabel8.setFont(new java.awt.Font("Ubuntu", 1, 15)); // NOI18N
        jLabel8.setText("IR");

        lblInstrucao.setFont(new java.awt.Font("Ubuntu", 1, 15)); // NOI18N
        lblInstrucao.setText("instrução");

        botaoExecultar.setBackground(new java.awt.Color(73, 167, 39));
        botaoExecultar.setFont(new java.awt.Font("Ubuntu", 1, 15)); // NOI18N
        botaoExecultar.setText("EXECULTAR");
        botaoExecultar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoExecultarActionPerformed(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Ubuntu", 1, 15)); // NOI18N
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setText("INSTRUÇÃO");

        jList1.setFont(new java.awt.Font("Ubuntu", 1, 15)); // NOI18N
        jList1.setModel(listaDados);
        jScrollPane4.setViewportView(jList1);

        btnMov.setText("MOV");
        btnMov.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMovActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtValor)
                            .addComponent(btnMov, javax.swing.GroupLayout.DEFAULT_SIZE, 92, Short.MAX_VALUE)))
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 30, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(botaoAdicionar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(textoDeIntrucao)
                    .addComponent(botaoExecultar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblInstrucao, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(contDePrograma, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 217, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel5))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jScrollPane4)
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(29, 29, 29)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(jLabel1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jScrollPane1)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 231, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(txtValor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnMov))))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel3)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(29, 29, 29)
                                .addComponent(textoDeIntrucao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(botaoAdicionar)))
                        .addGap(12, 12, 12)
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(contDePrograma)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblInstrucao)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(botaoExecultar)
                        .addGap(25, 25, 25)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void botaoAdicionarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoAdicionarActionPerformed
        // TODO add your handling code here:
        instrucao = textoDeIntrucao.getText();
        
        if(validarInstrucao(instrucao)){
            //adicionar(instrucao);
            comp.adicionarMI(instrucao);
            contDePrograma.setText(Integer.toString(comp.getPc()));
            lblInstrucao.setText(comp.getMinstrucao()[comp.getMi()+1]);
            textoDeIntrucao.setText("");
            
            conferir();
            
            //String execultar = comp.getMinstrucao()[comp.getMi()+1];
        
            //adicionar(execultar);
            listar();
        }
        
    }//GEN-LAST:event_botaoAdicionarActionPerformed

    private void botaoExecultarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoExecultarActionPerformed
        // TODO add your handling code here:
        
        switch(instrucaoC[0]){
            case "POP":
                if (!comp.pop(Integer.parseInt(instrucaoC[1]))) {
                    JOptionPane.showMessageDialog(rootPane, "Impossivel, a pilha está vasia!");
                }
                comp.removerMI();
                contDePrograma.setText(Integer.toString(comp.getPc()));
                listar();
                break;
            case "PUSH":
                if (!comp.push(Integer.parseInt(instrucaoC[1]))) {
                    JOptionPane.showMessageDialog(rootPane, "Area Stack Pointer está cheia!\n Ou É imposivel adicionar um valor null na pilha!");
                }
                comp.removerMI();
                contDePrograma.setText(Integer.toString(comp.getPc()));
                listar();
                break;
            case "ADD":
                if (!comp.add()) {
                    JOptionPane.showMessageDialog(rootPane, "Impossivel, execultar a instrução!");
                }
                comp.removerMI();
                contDePrograma.setText(Integer.toString(comp.getPc()));
                listar();
                break;
            case "SUB":
                if (!comp.sub()) {
                    JOptionPane.showMessageDialog(rootPane, "Impossivel, execultar a instrução!");
                }
                comp.removerMI();
                contDePrograma.setText(Integer.toString(comp.getPc()));
                listar();
                break;
            case "MULT":
                if (!comp.mult()) {
                    JOptionPane.showMessageDialog(rootPane, "Impossivel, execultar a instrução!");
                }
                comp.removerMI();
                contDePrograma.setText(Integer.toString(comp.getPc()));
                listar();
                break;
            case "DIV":
                if (!comp.div()) {
                    JOptionPane.showMessageDialog(rootPane, "Impossivel, execultar a instrução!");
                }
                comp.removerMI();
                contDePrograma.setText(Integer.toString(comp.getPc()));
                listar();
                break;
            case "AND":
                if (!comp.and()) {
                    JOptionPane.showMessageDialog(rootPane, "Impossivel, execultar a instrução!");
                }
                comp.removerMI();
                contDePrograma.setText(Integer.toString(comp.getPc()));
                listar();
                break;
            case "NOT":
                if (!comp.not()) {
                    JOptionPane.showMessageDialog(rootPane, "Impossivel, execultar a instrução!");
                }
                comp.removerMI();
                contDePrograma.setText(Integer.toString(comp.getPc()));
                listar();
                break;
            default:
                JOptionPane.showMessageDialog(rootPane, "Instrução não reconhacida!");
                comp.removerMI();
                contDePrograma.setText(Integer.toString(comp.getPc()));
                listar();
                break;
        }
        
        conferir();
    }//GEN-LAST:event_botaoExecultarActionPerformed

    private void listaDeRegistradoresMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_listaDeRegistradoresMouseClicked
        // TODO add your handling code here:
        indiceRegis = listaDeRegistradores.getSelectedIndex();
    }//GEN-LAST:event_listaDeRegistradoresMouseClicked

    private void btnMovActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMovActionPerformed
        // TODO add your handling code here:
        int valor = Integer.parseInt(txtValor.getValue().toString());
        comp.mov(indiceRegis, valor);
        listar();
    }//GEN-LAST:event_btnMovActionPerformed

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
            java.util.logging.Logger.getLogger(InterfaceComputerSimulator.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(InterfaceComputerSimulator.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(InterfaceComputerSimulator.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(InterfaceComputerSimulator.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new InterfaceComputerSimulator().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botaoAdicionar;
    private javax.swing.JButton botaoExecultar;
    private javax.swing.JButton btnMov;
    private javax.swing.JLabel contDePrograma;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JList<String> jList1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JLabel lblInstrucao;
    private javax.swing.JList<String> listaDeIntrucao;
    private javax.swing.JList<String> listaDePilha;
    private javax.swing.JList<String> listaDeRegistradores;
    private javax.swing.JTextField textoDeIntrucao;
    private javax.swing.JSpinner txtValor;
    // End of variables declaration//GEN-END:variables
}