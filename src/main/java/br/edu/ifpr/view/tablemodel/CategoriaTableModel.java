package br.edu.ifpr.view.tablemodel;

import br.edu.ifpr.bean.Categoria;
import java.util.LinkedList;
import java.util.List;
import java.util.;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Aluno
 */
public class CategoriaTableModel extends AbstractTableModel{

    private List<Categoria> dados = new LinkedList<Categoria>();
    private String[] colunas = {"ID", "Descrição"};
    
    public Categoria get(int linha) {
        return dados.get(linha);
    }
    @Override
    public int getRowCount() {
        return dados.size();
    }

    @Override
    public int getColumnCount() {
        return colunas.length;
    }

    @Override
    public String getColumnName(int coluna) {
        return colunas[coluna];
    }
    
    public void add(Categoria p) {
        this.dados.add(p);
        this.fireTableDataChanged();
        
    }
    
    public void addList(List<Categoria> categorias) {
        this.dados = categorias;
        this.fireTableDataChanged();
    }
    
    public void remove(Categoria p){
        this.dados.remove(p);
        this.fireTableDataChanged();
    }

    @Override
    public Object getValueAt(int linha, int coluna) {
        
        Categoria categoria = dados.get(linha);
        
        switch (coluna) {
            case 0:
                return categoria.getId();
            case 1:
                return categoria.getDescricao();
            default:
                return null;
        }
    }
    
}
