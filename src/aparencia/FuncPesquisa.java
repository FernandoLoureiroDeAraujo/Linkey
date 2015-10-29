package aparencia;

import java.awt.Component;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List; 

import javax.swing.DefaultCellEditor;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;

import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.Statement;

import modelo.ButtonColumn;
import modelo.FuncCadasGetSet;
import modelo.Tabela;
import mysql.Conexao;

import javax.swing.border.LineBorder;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;
import javax.swing.table.TableModel;

import java.awt.Color;

import javax.swing.JTextField;

public class FuncPesquisa extends JInternalFrame {
	
    protected static final String FuncPesquisa = null;
	public JTable table = new JTable();
    Tabela tableModel;
    private JButton btnRem=new JButton("Remover Linha");

    DefaultTableCellRenderer colorRenderer = new DefaultTableCellRenderer() {   
        public void setValue(Object value) {   
          setBackground(Color.BLUE);  
          setForeground(Color.YELLOW);  
          super.setValue(value);   
        }  
    };
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FuncPesquisa frame = new FuncPesquisa();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public FuncPesquisa() {
		getContentPane().setBackground(new Color(246, 246, 246));		
		setBackground(Color.WHITE);
		setForeground(Color.WHITE);
		setBorder(null);
			setBorder(null);
			setBounds(0, 0, 800, 600);
	        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			setLocation(0, 35);

	        tableModel=new Tabela(getListaEmpregados());

	        getContentPane().setLayout(null);
	        table.setBorder(null);
	        table.setSelectionBackground(new Color(81, 163, 157));
	        table.setForeground(Color.BLACK);
	        table.setGridColor(Color.WHITE);
	        table.setBackground(Color.WHITE);
	        table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
	        table.getTableHeader().setReorderingAllowed(false);
     
//	        table.setc
	        
	        //modelo
	        table.setModel(tableModel);
	        //barra de rolagem
	        table.setPreferredScrollableViewportSize(new Dimension(500,300));
	        //auto ajuste na altura da tabela
//	        table.setFillsViewportHeight(true);
	        //selecionar somente uma linha
	        table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
	        
	        ButtonColumn be = new ButtonColumn(table, 14); 	        
  
	 
	        //add a table ao scroll pane
	        JScrollPane scrollPane=new JScrollPane(table);
	        scrollPane.setForeground(Color.WHITE);
	        scrollPane.setBackground(Color.WHITE);
	        scrollPane.setBorder(null);
	        scrollPane.setBounds(10, 30, 780, 534);
	        getContentPane().add(scrollPane);
	        btnRem.setVisible(false);
	        btnRem.setBounds(792, 550, 8, 23);
	        btnRem.addActionListener(btnRemListener);
	        getContentPane().add(btnRem);
	        
	        textField = new JTextField();
	        textField.setVisible(false);
	        textField.addActionListener(new ActionListener() {
	        	public void actionPerformed(ActionEvent arg0) {
	   
	        		
	        	}
	        });
	        textField.setBounds(0, 551, 8, 20);
	        getContentPane().add(textField);
	        textField.setColumns(10);
	        
			JLabel ActionVoltar = new JLabel("");
			ActionVoltar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			ActionVoltar.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					dispose();
				}
			});
			ActionVoltar.setBounds(5, 8, 20, 21);
			getContentPane().add(ActionVoltar);
			
			JLabel imgVoltar = new JLabel("");
			imgVoltar.setIcon(new ImageIcon("images/btnvoltar.png"));
			imgVoltar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			imgVoltar.setBounds(5, 8, 20, 21);
			getContentPane().add(imgVoltar);
	        
	    }
	 
	    /**
	     * retorna uma lista de empregados
	     * @return {@link List} {@link Empregado}
	     */

	 
	    /*
	     * Eventos do bot�es, poderia ser criado classes que fossem "extends ActionListener"
	     * mas como se trata de um exemplo, vamos simplificar <span class="wp-smiley emoji emoji-wink" title=";)">;)</span>
	     * */
	 
	    //evento p/adicionar um registro � tabela
	    private ActionListener btnAddListener=new ActionListener() {
	        @Override
	        public void actionPerformed(ActionEvent e) {
	            //sorteia um indice do tamanho da lista para baixo
	            //exemplo se a lista tiver o tamanho 10 , ent�o vai de 0 at� 9
	            int randomIndex=(int)(Math.random()* (tableModel.getRowCount()-1));
	            FuncCadasGetSet empregado=tableModel.getValue(randomIndex);
	            tableModel.onAdd(empregado);
	        }
	    };
	 
	    //evento p/remover um registro da tabela
	    private ActionListener btnRemListener=new ActionListener() {
	        @Override
	        public void actionPerformed(ActionEvent e) {
	        	String sql="delete from tbl_dadosfuncionarios where Id_Func=?";
	        	
	        	try{
	        		Connection conn = null;
	        		PreparedStatement pst;
	        		
					pst = (PreparedStatement) conn.prepareStatement(sql);
	        		pst.setString(1, sql);
					pst.execute();
	        		
	        	}catch (Exception a){
	        	System.out.println(a);
	        	}
	        	
//	            if(table.getSelectedRow() != -1 && table.getSelectedRow() < tableModel.getRowCount()){
//	                tableModel.onRemove(table.getSelectedRow());
//	            }else
//	                JOptionPane.showMessageDialog(null, "Selecione um registro da tabela!");
	        }
	    };
	 
	    //evento p/adicionar um v�rios registros � tabela
	    private ActionListener btnAddAllListener=new ActionListener() {
	        @Override
	        public void actionPerformed(ActionEvent e) {
	            tableModel.onAddAll(getListaEmpregados());
	        }
	    };
	 
	    //evento p/remover v�rios registros � tabela
	    private ActionListener btnRemAllListener=new ActionListener() {
	        @Override
	        public void actionPerformed(ActionEvent e) {
	            tableModel.onRemoveAll();
	        }
	    };
	    private JTextField textField;
	    
		 public  List<FuncCadasGetSet> getListaEmpregados(){
		    	List<FuncCadasGetSet> empregados=new ArrayList<FuncCadasGetSet>();    
		        ResultSet rs;
				Connection conn = null;
				Statement st = null;
		        
		        try {
		            Class.forName("com.mysql.jdbc.Driver");    
		            conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1/linkey","root", "");    
		            st = (Statement) conn.createStatement();    
		            rs = st.executeQuery("SELECT * from tbl_dadosfuncionarios"); 

		            while (rs.next()) {
		            	FuncCadasGetSet emp1=new FuncCadasGetSet();  
		                emp1.setNome(rs.getNString("Nome"));
		                emp1.setRG(rs.getNString("RG")); 
		                emp1.setCPF(rs.getNString("CPF"));
		                emp1.setSexo(rs.getNString("Sexo")); 
		                emp1.setTelefone(rs.getNString("Telefone"));
		                emp1.setCelular(rs.getNString("Celular")); 
		                emp1.setEmail(rs.getNString("Email"));
		                emp1.setCEP(rs.getNString("CEP")); 
		                emp1.setEndereco(rs.getNString("Endere�o"));                
		                emp1.setNumero(rs.getInt("Numero")); 
		                emp1.setComplemento(rs.getNString("Complemento"));
		                emp1.setCidade(rs.getNString("Cidade")); 
		                emp1.setBairro(rs.getNString("Bairro"));
		                emp1.setUF(rs.getNString("UF"));
		                empregados.add(emp1);
		            }
		            rs.close();

		        } catch (ClassNotFoundException | SQLException e) {
		            e.printStackTrace();
		        }   

		        return empregados;
		    }
	}