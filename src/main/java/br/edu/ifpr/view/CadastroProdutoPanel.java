/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package br.edu.ifpr.view;

import br.edu.ifpr.bean.Categoria;
import br.edu.ifpr.bean.Produto;
import br.edu.ifpr.dao.CategoriaDAO;
import br.edu.ifpr.dao.ProdutoDAO;
import br.edu.ifpr.util.ConnectionFactory;
import br.edu.ifpr.view.tablemodel.CBCategoriaMoldel;
import br.edu.ifpr.view.tablemodel.ProdutoTableModel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import javax.swing.ComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author Aluno
 */
public class CadastroProdutoPanel extends JPanel {

    private ProdutoTableModel tbm;
    private CBCategoriaMoldel cbm;
    private Produto produtoSelecionado = null;
    
    /**
     * Creates new form CadastroProduto
     */
    public CadastroProdutoPanel() {
        initComponents();
        tfID.setEditable(false);
        tbm = new ProdutoTableModel();
        tblProduto.setModel(tbm);
      
        cbm = new CBCategoriaMoldel();
        cbCategoria.setModel(cbm);
        
        popula();
        
        tblProduto.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int linha = tblProduto.getSelectedRow();
                produtoSelecionado = tbm.get(linha);
                populaForm(produtoSelecionado);
            }
            
        });
    }
    
    private void populaForm(Produto produto){
        tfID.setText(String.valueOf(produto.getId()));
        tfDescricao.setText(produto.getDescricao());
        //cbCategoria.setSelectedItem(produto.getCategoria());
        cbm.setSelectedItem(produto.getCategoria());
        
        /*
        Categoria catEletroCB = cbm.getElementAt(1);
        Categoria catEletroProdJt = produto.getCategoria();
        
        System.out.println("catEletroCB: " + catEletroCB + " Descricao: " + catEletroCB.getDescricao());
        System.out.println("catEletroProdJt:" + catEletroProdJt + " Descricao: " + catEletroProdJt.getDescricao());
        */
    }
    
    
    private void popula() {
        
        Connection con = ConnectionFactory.createConnectionToMySQL();
        
        ProdutoDAO dao = new ProdutoDAO(con);
        tbm.addList(dao.findALL());
        
        CategoriaDAO daoCat = new CategoriaDAO(con);
        cbm.addAll(daoCat.findALL());

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblID = new javax.swing.JLabel();
        tfID = new javax.swing.JTextField();
        lblDescricao = new javax.swing.JLabel();
        tfDescricao = new javax.swing.JTextField();
        lblCategoria = new javax.swing.JLabel();
        cbCategoria = new javax.swing.JComboBox<>();
        spProduto = new javax.swing.JScrollPane();
        tblProduto = new javax.swing.JTable();
        lblProduto = new javax.swing.JLabel();
        btnCadastrar = new javax.swing.JButton();
        btnEditar = new javax.swing.JButton();
        btnExluir = new javax.swing.JButton();
        btnAddCat = new javax.swing.JButton();

        lblID.setText("ID");

        lblDescricao.setText("Descrição");

        lblCategoria.setText("Categoria");

        tblProduto.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        spProduto.setViewportView(tblProduto);

        lblProduto.setText("Produto");

        btnCadastrar.setText("Cadastrar");
        btnCadastrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCadastrarActionPerformed(evt);
            }
        });

        btnEditar.setText("Editar");
        btnEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarActionPerformed(evt);
            }
        });

        btnExluir.setText("Excluir");
        btnExluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExluirActionPerformed(evt);
            }
        });

        btnAddCat.setText("...");
        btnAddCat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddCatActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(spProduto, javax.swing.GroupLayout.DEFAULT_SIZE, 390, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblDescricao)
                            .addComponent(lblID))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(tfID, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(tfDescricao)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnExluir)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnEditar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnCadastrar))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblProduto)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblCategoria)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cbCategoria, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnAddCat)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblID)
                    .addComponent(tfID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblDescricao)
                    .addComponent(tfDescricao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblCategoria)
                    .addComponent(btnAddCat))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCadastrar)
                    .addComponent(btnEditar)
                    .addComponent(btnExluir))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 9, Short.MAX_VALUE)
                .addComponent(lblProduto)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(spProduto, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnCadastrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCadastrarActionPerformed
        Produto produto = new Produto();
        produto.setDescricao(tfDescricao.getText());
        produto.setCategoria(cbm.getSelectedItem());
               
        ProdutoDAO dao = new ProdutoDAO(ConnectionFactory.createConnectionToMySQL());
        dao.create(produto);
        
        tbm.add(produto);
        
        limpaTela();
    }//GEN-LAST:event_btnCadastrarActionPerformed

    private void btnEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarActionPerformed
        if (produtoSelecionado == null) {
            JOptionPane.showMessageDialog(this, "Selecione um produto na tabela");
        } else {
            produtoSelecionado.setDescricao(tfDescricao.getText());
            produtoSelecionado.setCategoria(cbm.getSelectedItem());
            
            ProdutoDAO dao = new ProdutoDAO(ConnectionFactory.createConnectionToMySQL());
            dao.update(produtoSelecionado);
            tbm.fireTableDataChanged();
            limpaTela();
            produtoSelecionado = null;
        }
    }//GEN-LAST:event_btnEditarActionPerformed

    private void btnExluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExluirActionPerformed
        Produto produtoSelecionado = tbm.get(tblProduto.getSelectedRow());
        ProdutoDAO dao = new ProdutoDAO(ConnectionFactory.createConnectionToMySQL());
        dao.delete(produtoSelecionado.getId());
        System.out.println(produtoSelecionado);
        tbm.remove(produtoSelecionado);
        limpaTela();
        produtoSelecionado = null;
    }//GEN-LAST:event_btnExluirActionPerformed

    private void btnAddCatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddCatActionPerformed
        CadastroCategoria telaCad = new CadastroCategoria();
        telaCad.setVisible(true);
    }//GEN-LAST:event_btnAddCatActionPerformed

    
    private void limpaTela() {
        tfID.setText("");
        tfDescricao.setText("");
        cbCategoria.setSelectedIndex(-1);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAddCat;
    private javax.swing.JButton btnCadastrar;
    private javax.swing.JButton btnEditar;
    private javax.swing.JButton btnExluir;
    private javax.swing.JComboBox<Categoria> cbCategoria;
    private javax.swing.JLabel lblCategoria;
    private javax.swing.JLabel lblDescricao;
    private javax.swing.JLabel lblID;
    private javax.swing.JLabel lblProduto;
    private javax.swing.JScrollPane spProduto;
    private javax.swing.JTable tblProduto;
    private javax.swing.JTextField tfDescricao;
    private javax.swing.JTextField tfID;
    // End of variables declaration//GEN-END:variables

    public static void main(String[] args) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new CadastroProdutoPanel().setVisible(true);
            }
            
        });
    }
}


