/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package SistemasSQL;

import com.mysql.cj.jdbc.ClientPreparedStatement;
import com.mysql.cj.jdbc.ConnectionImpl;
import com.mysql.cj.jdbc.StatementImpl;
import com.mysql.cj.jdbc.result.ResultSetImpl;
import conexãoSql.conexaoSQL;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author 554799103706
 */
public class admin extends javax.swing.JFrame {

    conexaoSQL cc = new conexaoSQL();
    ConnectionImpl ccn = (ConnectionImpl) cc.conectar();
    
    
    public admin() {
        
        initComponents();
        mostrardatosU();
        this.setLocationRelativeTo(null);
        this.getContentPane().setBackground(getBackground());
       
    }

    TrocarS janela = new TrocarS();
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtnome = new javax.swing.JTextField();
        txtcpf = new javax.swing.JTextField();
        txttelefone = new javax.swing.JTextField();
        bntGuardar = new javax.swing.JButton();
        bntEliminar = new javax.swing.JButton();
        bntAtualizar = new javax.swing.JButton();
        bnttrocarsenha = new javax.swing.JButton();
        bntconsultar = new javax.swing.JButton();
        txtemail = new javax.swing.JTextField();
        txtpassword = new javax.swing.JPasswordField();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        txtbuscarusuario = new javax.swing.JTextField();
        txtbuscaradmin = new javax.swing.JTextField();
        jScrollPane3 = new javax.swing.JScrollPane();
        tablausuario = new javax.swing.JTable();
        jScrollPane4 = new javax.swing.JScrollPane();
        tablaadmin = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));

        jPanel1.setBackground(new java.awt.Color(0, 51, 204));
        jPanel1.setForeground(new java.awt.Color(255, 255, 255));

        jLabel1.setText("NOME:");

        jLabel2.setText("CPF:");

        jLabel3.setText("SENHA:");

        jLabel4.setText("E-MAIL:");

        jLabel5.setText("TELEFONE:");

        txttelefone.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txttelefoneActionPerformed(evt);
            }
        });

        bntGuardar.setText("GUARDAR");
        bntGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bntGuardarActionPerformed(evt);
            }
        });

        bntEliminar.setText("ELIMINAR");
        bntEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bntEliminarActionPerformed(evt);
            }
        });

        bntAtualizar.setText("ATUALIZAR");
        bntAtualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bntAtualizarActionPerformed(evt);
            }
        });

        bnttrocarsenha.setText("Trocar senha");
        bnttrocarsenha.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bnttrocarsenhaActionPerformed(evt);
            }
        });

        bntconsultar.setText("Consultar");
        bntconsultar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bntconsultarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(50, 50, 50)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, 91, Short.MAX_VALUE)
                                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                            .addContainerGap()
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(bntGuardar, javax.swing.GroupLayout.Alignment.TRAILING))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(bntEliminar)
                        .addGap(18, 18, 18)
                        .addComponent(bntAtualizar)
                        .addGap(18, 18, 18)
                        .addComponent(bntconsultar)
                        .addGap(0, 49, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(txtnome, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtcpf, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txttelefone, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtemail)
                            .addComponent(txtpassword))
                        .addGap(20, 20, 20)
                        .addComponent(bnttrocarsenha)
                        .addContainerGap())))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(68, 68, 68)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtnome, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtcpf, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtemail, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtpassword)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(bnttrocarsenha)))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txttelefone, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(82, 82, 82)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(bntGuardar)
                    .addComponent(bntEliminar)
                    .addComponent(bntAtualizar)
                    .addComponent(bntconsultar))
                .addGap(16, 16, 16))
        );

        jLabel6.setText("USUARIO");

        jLabel7.setText("ADMIN");

        jLabel8.setText("Busqueda:");

        jLabel9.setText("Busqueda:");

        txtbuscarusuario.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtbuscarusuarioKeyReleased(evt);
            }
        });

        txtbuscaradmin.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtbuscaradminKeyReleased(evt);
            }
        });

        tablausuario.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        tablausuario.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablausuarioMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(tablausuario);

        tablaadmin.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        tablaadmin.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
                tablaadminAncestorAdded(evt);
            }
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
        });
        tablaadmin.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablaadminMouseClicked(evt);
            }
        });
        jScrollPane4.setViewportView(tablaadmin);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtbuscaradmin, javax.swing.GroupLayout.PREFERRED_SIZE, 247, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(26, 26, 26)
                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 70, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 821, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(txtbuscarusuario, javax.swing.GroupLayout.PREFERRED_SIZE, 246, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 827, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(jLabel9)
                    .addComponent(txtbuscaradmin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtbuscarusuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txttelefoneActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txttelefoneActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txttelefoneActionPerformed

    private void bntGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bntGuardarActionPerformed
        insertar();
        mostrardatos();
        limparcajas();
        mostrardatosU();
    }//GEN-LAST:event_bntGuardarActionPerformed

    private void bntAtualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bntAtualizarActionPerformed
        actualizardatos();
    }//GEN-LAST:event_bntAtualizarActionPerformed

    private void bntEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bntEliminarActionPerformed
       eliminarReguistro();
      
       mostrardatos();
       limparcajas();
       eliminarReguistroU();
    }//GEN-LAST:event_bntEliminarActionPerformed

    private void txtbuscaradminKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtbuscaradminKeyReleased
        filtrardatos(txtbuscaradmin.getText());
    }//GEN-LAST:event_txtbuscaradminKeyReleased

    private void txtbuscarusuarioKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtbuscarusuarioKeyReleased
        filtrardatosU(txtbuscarusuario.getText());
    }//GEN-LAST:event_txtbuscarusuarioKeyReleased

    private void bntconsultarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bntconsultarActionPerformed
        consultar();
        consultarU();
    }//GEN-LAST:event_bntconsultarActionPerformed

    private void tablaadminMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaadminMouseClicked
        int filaSelecionada=tablaadmin.rowAtPoint(evt.getPoint());
        txtnome.setText(tablaadmin.getValueAt(filaSelecionada, 1).toString());
        txtcpf.setText(tablaadmin.getValueAt(filaSelecionada, 2).toString());
        txtemail.setText(tablaadmin.getValueAt(filaSelecionada, 3).toString());
        txtemail.setText(tablaadmin.getValueAt(filaSelecionada, 4).toString());
        txttelefone.setText(tablaadmin.getValueAt(filaSelecionada, 5).toString());
    }//GEN-LAST:event_tablaadminMouseClicked

    private void tablausuarioMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablausuarioMouseClicked
        int filaSelecionada=tablausuario.rowAtPoint(evt.getPoint());
        txtnome.setText(tablausuario.getValueAt(filaSelecionada, 1).toString());
        txtcpf.setText(tablausuario.getValueAt(filaSelecionada, 2).toString());
        txtemail.setText(tablausuario.getValueAt(filaSelecionada, 3).toString());
        txtemail.setText(tablausuario.getValueAt(filaSelecionada, 4).toString());
        txttelefone.setText(tablausuario.getValueAt(filaSelecionada, 5).toString());
    }//GEN-LAST:event_tablausuarioMouseClicked

    private void tablaadminAncestorAdded(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_tablaadminAncestorAdded
        // TODO add your handling code here:
    }//GEN-LAST:event_tablaadminAncestorAdded

    private void bnttrocarsenhaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bnttrocarsenhaActionPerformed
         janela = new TrocarS();
        janela.setVisible(true);
        janela.setLocationRelativeTo(null);
    }//GEN-LAST:event_bnttrocarsenhaActionPerformed
 public void insertar(){
    
    try{
        String SQL="insert into admin (Nome, cpf, senha, gmail, telefone) values (?,?,?,?,?)";
        
        ClientPreparedStatement pst = (ClientPreparedStatement) ccn.prepareStatement(SQL);
        
        pst.setString(1, txtnome.getText());
        pst.setString(2, txtcpf.getText());
        pst.setString(4, txtemail.getText());
        pst.setString(5, txttelefone.getText());
        pst.setString(3, txtemail.getText());
        
        pst.execute();
        
        JOptionPane.showMessageDialog(null,"registro completo \n");
        
    }catch(Exception e ){
        JOptionPane.showMessageDialog(null,"error de registro  \n " + e.getMessage());
    }
}
 public void mostrardatos(){
      String[] titulos={"id","nome","cpf","senha","gmail","telefone","ativo"};
      String [] registro=new String[7];
      DefaultTableModel modelo = new DefaultTableModel(null,titulos);
      String SQL="select * from admin";
     try{
          StatementImpl st = (StatementImpl) cc.conectar().createStatement();
          ResultSetImpl rs =(ResultSetImpl) st.executeQuery(SQL);
         while (rs.next()){
             registro[0]=rs.getString("id");
             registro[1]=rs.getString("nome");
             registro[2]=rs.getString("cpf");
             
             registro[4]=rs.getString("gmail");
             registro[5]=rs.getString("telefone");
             registro[6]=rs.getString("ativo");
             modelo.addRow(registro);
         }
         tablaadmin.setModel(modelo);
     }catch(Exception e){
         JOptionPane.showMessageDialog(null,"Error al mostrar datos" +  e.getMessage());
         
     }

}
 public void mostrardatosU(){
      String[] titulos={"id","nome","cpf","senha","gmail","telefone","ativo"};
      String [] registro=new String[7];
      DefaultTableModel modelo = new DefaultTableModel(null,titulos);
      String SQL="select * from usuario";
     try{
          StatementImpl st = (StatementImpl) cc.conectar().createStatement();
          ResultSetImpl rs =(ResultSetImpl) st.executeQuery(SQL);
         while (rs.next()){
             registro[0]=rs.getString("id");
             registro[1]=rs.getString("nome");
             registro[2]=rs.getString("cpf");
           
             registro[4]=rs.getString("gmail");
             registro[5]=rs.getString("telefone");
             registro[6]=rs.getString("ativo");
             modelo.addRow(registro);
         }
         tablausuario.setModel(modelo);
     }catch(Exception e){
         JOptionPane.showMessageDialog(null,"Error al mostrar datos" +  e.getMessage());
         
     }

}
     public void limparcajas(){
    txtnome.setText("");
    txtcpf.setText("");
    txtemail.setText("");
    txttelefone.setText("");
    txtemail.setText("");
    
}
     public void actualizardatos(){
    
    try{
        String SQL=" UPDATE admin SET Nome=?, cpf=?, gmail=?, senha, telefone=? where id=? ";
        int filaSelecionada = tablaadmin.getSelectedRow();
        String dao = (String)tablaadmin.getValueAt(filaSelecionada, 0);
        ClientPreparedStatement pst = (ClientPreparedStatement) ccn.prepareStatement(SQL);
        
        pst.setString(1, txtnome.getText());
        pst.setString(2, txtcpf.getText());
        pst.setString(4, txtemail.getText());
        pst.setString(3, txtemail.getText());
        pst.setString(5, txttelefone.getText());
        
        
        pst.setString(6, dao);
      
        pst.execute();
        
        JOptionPane.showMessageDialog(null,"registro atualizado \n");
        
    }catch(Exception e ){
        JOptionPane.showMessageDialog(null,"error de atualização registro  \n " + e.getMessage());
    }
      }
     
public void consultar(){
    
    try{
        String SQL="select * into admin where gmail=?, senha=?";
        
        ClientPreparedStatement pst = (ClientPreparedStatement) ccn.prepareStatement(SQL);
       
        ResultSetImpl rs =(ResultSetImpl) pst.executeQuery(SQL);
        
        
        while (rs.next()){
        
        pst.setString(3, txtemail.getText());
        pst.setString(4, txtemail.getText());
          
        }
                   
        
    }catch(Exception e){
        JOptionPane.showMessageDialog(null,"error de consulta registro" + e.getMessage());
    }
}

public void consultarU(){
    
    try{
        
        String SQL="select * into usuario where cpf=?, senha=";
        
        ClientPreparedStatement pst = (ClientPreparedStatement) ccn.prepareStatement(SQL);
        ResultSetImpl rs =(ResultSetImpl) pst.executeQuery(SQL);
          
        while (rs.next()){
        
        pst.setString(2, txtcpf.getText());
        pst.setString(3, txtemail.getText());
          
        }
                   
        
    }catch(Exception e){
        JOptionPane.showMessageDialog(null,"error de consulta registro" + e.getMessage());
    }
}
     public void eliminarReguistro(){
         int filaSelecionada = tablausuario.getSelectedRow(); 
         System.out.println(tablausuario.getValueAt(filaSelecionada, 0));
         try {
             String SQL = "delete from usuario where id="+tablausuario.getValueAt(filaSelecionada, 0);
             StatementImpl st=(StatementImpl) ccn.createStatement();
             boolean n=st.execute(SQL);
             if (n==true){
                 JOptionPane.showMessageDialog(null, "Registro eliminado");
             }
         } catch (Exception e) {
             JOptionPane.showMessageDialog(null, "erro ao  eliminar Registro"+e.getMessage());
         }
     }
     public void eliminarReguistroU(){
         int filaSelecionada = tablaadmin.getSelectedRow();
         try {
             String SQL = "delete from admin where id="+tablaadmin.getValueAt(filaSelecionada, 0);
             StatementImpl st=(StatementImpl) ccn.createStatement();
             int n=st.executeUpdate(SQL);
             if (n>=0){
                 JOptionPane.showMessageDialog(null, "Registro eliminado");
             }
         } catch (Exception e) {
             JOptionPane.showMessageDialog(null, "erro ao  eliminar Registro"+e.getMessage());
         }
     }
      public void filtrardatos(String valor){
      String[] titulos={"id","nome","cpf","senha","gmail","telefone","ativo"};
      String [] registro=new String[7];
      DefaultTableModel modelo = new DefaultTableModel(null,titulos);
      String SQL="select * from admin where nome like '%"+valor+"%'";
     try{
          StatementImpl st = (StatementImpl) cc.conectar().createStatement();
          ResultSetImpl rs =(ResultSetImpl) st.executeQuery(SQL);
         while (rs.next()){
             registro[0]=rs.getString("id");
             registro[1]=rs.getString("nome");
             registro[2]=rs.getString("cpf");
             
             registro[4]=rs.getString("gmail");
             registro[5]=rs.getString("telefone");
             registro[6]=rs.getString("ativo");
             modelo.addRow(registro);
         }
         tablaadmin.setModel(modelo);
     }catch(Exception e){
         JOptionPane.showMessageDialog(null,"Error al mostrar datos" +  e.getMessage());
         
     }

}
      public void filtrardatosU(String valor){
      String[] titulos={"id","nome","cpf","senha","gmail","telefone","ativo"};
      String [] registro=new String[7];
      DefaultTableModel modelo = new DefaultTableModel(null,titulos);
      String SQL="select * from usuario where nome like '%"+valor+"%'";
     try{
          StatementImpl st = (StatementImpl) cc.conectar().createStatement();
          ResultSetImpl rs =(ResultSetImpl) st.executeQuery(SQL);
         while (rs.next()){
             registro[0]=rs.getString("id");
             registro[1]=rs.getString("nome");
             registro[2]=rs.getString("cpf");
             
             registro[4]=rs.getString("gmail");
             registro[5]=rs.getString("telefone");
             registro[6]=rs.getString("ativo");
             modelo.addRow(registro);
         }
         tablausuario.setModel(modelo);
     }catch(Exception e){
         JOptionPane.showMessageDialog(null,"Error al mostrar datos" +  e.getMessage());
         
     }

}
     /* public void cripto(String valor) throws NoSuchAlgorithmException{
       
   MessageDigest digest = MessageDigest.getInstance("SHA-256");
byte[] hash = digest.digest(txtsenha.getBytes(StandardCharsets.UTF_8));
String encoded = Base64.getEncoder().encodeToString(hash);
    
}*/
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
            java.util.logging.Logger.getLogger(admin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(admin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(admin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(admin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new admin().setVisible(true);
            }
        });
    }
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bntAtualizar;
    private javax.swing.JButton bntEliminar;
    private javax.swing.JButton bntGuardar;
    private javax.swing.JButton bntconsultar;
    private javax.swing.JButton bnttrocarsenha;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTable tablaadmin;
    private javax.swing.JTable tablausuario;
    private javax.swing.JTextField txtbuscaradmin;
    private javax.swing.JTextField txtbuscarusuario;
    private javax.swing.JTextField txtcpf;
    private javax.swing.JTextField txtemail;
    private javax.swing.JTextField txtnome;
    private javax.swing.JPasswordField txtpassword;
    private javax.swing.JTextField txttelefone;
    // End of variables declaration//GEN-END:variables
}
