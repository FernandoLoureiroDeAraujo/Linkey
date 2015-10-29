package modelo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.List;
import javax.swing.table.AbstractTableModel;

import aparencia.FuncPesquisa;

public class Tabela extends AbstractTableModel{
	//constantes p/identificar colunas
    private final int NOME=0;
    private final int RG=1;
    private final int CPF=2;
    private final int SEXO=3;
    private final int TELEFONE=4;
    private final int CELULAR=5;
    private final int EMAIL=6;
    private final int CEP=7;
    private final int ENDERECO=8;
    private final int NUMERO=9;
    private final int COMPLEMENTO=10;
    private final int CIDADE=11;
    private final int BAIRRO=12;
    private final int UF=13;
    private final int ACAO=14;
 
    public final String colunas[]={"Nome:","RG:","CPF:","Sexo:","Telefone :","Celular :","Email :","CEP :","Endereço :","Numero :","Complemento :"
    								,"Cidade :","Bairro :","UF :","ACAO :"};
    public List<FuncCadasGetSet> dados;//usamos como dados uma lista genérica de Empregado
 
    public Tabela(List<FuncCadasGetSet> dados) {
        //seto os dados no construtor
        this.dados=dados;
    
    }
 
    @Override
    public int getColumnCount() {
        //retorna o total de colunas
        return colunas.length;
    }
 
    @Override
    public int getRowCount() {
        //retorna o total de linhas na tabela
        return dados.size();
    }
 
    @Override
    public Class<?> getColumnClass(int columnIndex) {
        //retorna o tipo de dado, para cada coluna
        switch (columnIndex) {
        case NOME:
            return String.class;
        case RG:
            return String.class;
        case CPF:
            return String.class;
        case SEXO:
            return String.class;

        case TELEFONE:
            return String.class;

        case CELULAR:
            return String.class;

        case EMAIL:
            return String.class;

        case CEP:
            return String.class;

        case ENDERECO:
            return String.class;

        case NUMERO:
            return int.class;

        case COMPLEMENTO:
            return String.class;

        case CIDADE:
            return String.class;

        case BAIRRO:
            return String.class;

        case UF:
            return String.class;
        case ACAO:
            return String.class;

        default:       	
            throw new IndexOutOfBoundsException("Coluna Inválida!!!");
        }
    }
 
    @Override
    public String getColumnName(int columnIndex) {
        return colunas[columnIndex];
    }
 
    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        //retorna o valor conforme a coluna e linha
 
        //pega o dados corrente da linha
    	FuncCadasGetSet empregado = dados.get(rowIndex);
 
        //retorna o valor da coluna
        switch (columnIndex) {
        case NOME:
            return empregado.getNome();
        case RG:
        	return empregado.getRG();
        case CPF:
        	return empregado.getCPF();
        case SEXO:
        	return empregado.getSexo();

        case TELEFONE:
        	return empregado.getTelefone();

        case CELULAR:
        	return empregado.getCelular();

        case EMAIL:
        	return empregado.getEmail();

        case CEP:
        	return empregado.getCEP();

        case ENDERECO:
        	return empregado.getEndereco();

        case NUMERO:
        	return empregado.getNumero();

        case COMPLEMENTO:
        	return empregado.getComplemento();
        	
        case CIDADE:
        	return empregado.getCidade();

        case BAIRRO:
        	return empregado.getBairro();

        case UF:
        	return empregado.getUF();
        case ACAO:
        	return empregado.getACAO();
        default:
            throw new IndexOutOfBoundsException("Coluna Inválida!!!");
        }
    }
 
//    @Override
//    public boolean isCellEditable(int rowIndex, int columnIndex) {
//        //metodo identifica qual coluna é editavel
// 
//        //só iremos editar a coluna BENEFICIO, 
//        //que será um checkbox por ser boolean
//        if(columnIndex == BENEFICIO)
//            return true;
// 
//        return false;
//    }
// 
//    @Override
//    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
//        Empregado empregado=dados.get(rowIndex);
// 
//        if(columnIndex == BENEFICIO){
//            empregado.setBeneficio(((boolean)aValue));
//        }
//    }
// 
    //Métodos abaixo são para manipulação de dados
 
    /**
     * retorna o valor da linha indicada
     * @param rowIndex
     * @return
     */
    public FuncCadasGetSet getValue(int rowIndex){
        return dados.get(rowIndex);
    }
 
    /**
     * retorna o indice do objeto
     * @param empregado
     * @return
     */
    public int indexOf(FuncCadasGetSet empregado) {
        return dados.indexOf(empregado);
    }
 
    /**
     * add um empregado á lista
     * @param empregado
     */
    public void onAdd(FuncCadasGetSet empregado) {
        dados.add(empregado);
        fireTableRowsInserted(indexOf(empregado), indexOf(empregado));
    }
 
    /**
     * add uma lista de empregados
     * @param dadosIn
     */
    public void onAddAll(List<FuncCadasGetSet> dadosIn) {
        dados.addAll(dadosIn);
        fireTableDataChanged();
    }
 
    /**
     * remove um registro da lista, através do indice
     * @param rowIndex
     */
    public void onRemove(int rowIndex) {
        dados.remove(rowIndex);
        fireTableRowsDeleted(rowIndex, rowIndex);
    }
 
    /**
     * remove um registro da lista, através do objeto
     * @param empregado
     */
    public void onRemove(FuncCadasGetSet empregado) {
    	FuncPesquisa p = new FuncPesquisa();
//    	int col=p.table.getSelectedColumn();  
//    	int row=p.table.getSelectedRow();
        int indexBefore=indexOf(empregado);//pega o indice antes de apagar
    	//do the update query on this row 
        Connection c=null;
    	   
    	try {  
//    	           Class.forName("com.mysql.jdbc.Driver");  
//    	           String url = "jdbc:mysql://localhost:3306/test?requireSSL=false&useUnicode=true&characterEncoding=utf8";  
//    	           Connection c = DriverManager.getConnection(url, "root", "");  
    	           PreparedStatement ps = c.prepareStatement("UPDATE tbl_dadosfuncionarios SET Nome = ?,RG = ?,CPF = ? WHERE id = "+indexBefore);  
    	           fireTableCellUpdated(indexBefore, indexBefore);
    	            ps.setString(1, (String) p.table.getValueAt(indexBefore, 1));  
    	            ps.setInt(2, (Integer) p.table.getValueAt(indexBefore, 2));  
    	            ps.setInt(3, (Integer) p.table.getValueAt(indexBefore, 3));  
    	   
    	            ps.executeUpdate();   
    	            ps.close();  
    	            c.close();  
    	   
    	        } catch (Exception ex) {  
    	          ex.printStackTrace();  
    	        } 
    	
    	

//        dados.remove(empregado);  
//        fireTableRowsDeleted(indexBefore, indexBefore);
    }
 
    /**
     * remove todos registros da lista
     */
    public void onRemoveAll() {
        dados.clear();
        fireTableDataChanged();
    }
 
}

