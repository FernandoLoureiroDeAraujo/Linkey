package aparencia;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collection;
import java.util.List;
import java.util.Random;

import javax.swing.DefaultCellEditor;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;

import modelo.FuncCadasGetSet;
import modelo.Tabela;
import mysql.LoginCon;
import net.proteanit.sql.DbUtils;

@SuppressWarnings("serial")
public class Principal extends JFrame {
	protected static final String cbSexo = null;
	
	JTextField jtfLogin;
	private JPasswordField jpfSenha;
	
	JLabel imgSair;
	JLabel imgMenu;
	JLabel imgMenuOpen;
	JLabel imgInFunc;
	JTextField jtfBusca;
		
	public static JDesktopPane dpPrincipal;
	public JInternalFrame FuncCadastro;
	
	/**
	 * Launch the application.
	 */
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Principal frame = new Principal();
					frame.setVisible(true);
					frame.setLocationRelativeTo(null);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */

	public Principal() {
		setUndecorated(true);
		setResizable(false);
		setTitle("Cadastro");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 600);
		JPanel contentPane = new JPanel();
		contentPane.setBackground(Color.BLACK);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		dpPrincipal = new JDesktopPane();
		dpPrincipal.setBounds(0, 0, 800, 600);
		contentPane.add(dpPrincipal);
		dpPrincipal.setLayout(null);
		
		final JPanel pLogin = new JPanel();
		pLogin.setBackground(Color.WHITE);
		pLogin.setBorder(new LineBorder(new Color(184, 207, 229)));
		pLogin.setBounds(466, 132, 292, 138);
		dpPrincipal.add(pLogin);
		pLogin.setLayout(null);

		final JLabel lblSenha = new JLabel("Senha:");
		lblSenha.setBounds(10, 72, 60, 14);
		pLogin.add(lblSenha);
		lblSenha.setForeground(Color.BLACK);

		jpfSenha = new JPasswordField();
		jpfSenha.setBorder(new LineBorder(Color.LIGHT_GRAY));
		jpfSenha.setBounds(67, 68, 215, 22);
		pLogin.add(jpfSenha);

		final JLabel lblLogin = new JLabel("Login:");
		lblLogin.setBounds(10, 11, 50, 50);
		pLogin.add(lblLogin);
		lblLogin.setForeground(Color.BLACK);

		jtfLogin = new JTextField();
		jtfLogin.setBorder(new LineBorder(Color.LIGHT_GRAY));
		jtfLogin.setBounds(67, 25, 215, 22);
		pLogin.add(jtfLogin);
		jtfLogin.setColumns(10);

		final JButton btnEntrar = new JButton("");
		btnEntrar.setIcon(new ImageIcon("images/entrar.png"));
		btnEntrar.setBounds(177, 104, 105, 23);
		pLogin.add(btnEntrar);

		imgSair = new JLabel("");
		imgSair.setVisible(false);
		imgSair.setEnabled(false);
		imgSair.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		imgSair.setBorder(null);
		imgSair.setBounds(619, 558, 181, 42);
		
		jtfBusca = new JTextField("  Busca:");
		jtfBusca.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {

			}
		});
		jtfBusca.setForeground(new Color(255, 255, 255));
		jtfBusca.setRequestFocusEnabled(false);
		jtfBusca.setVisible(false);
		jtfBusca.setBackground(new Color(67, 151, 145));
		jtfBusca.setBorder(new LineBorder(new Color(255, 255, 255), 1, true));
		jtfBusca.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {				
				jtfBusca.setText("");
				jtfBusca.requestFocus();
			}
		});
			
		jtfBusca.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent arg0) {
								
				if (arg0.getKeyCode() == KeyEvent.VK_ENTER){

				FuncPesquisa fp = new FuncPesquisa();			
				dpPrincipal.add(fp);
				fp.setVisible(true);
				javax.swing.plaf.InternalFrameUI ui = fp.getUI();
				((javax.swing.plaf.basic.BasicInternalFrameUI) ui)
						.setNorthPane(null);

//				Tabela tbl = new Tabela(null);
//				Collection<? extends FuncCadasGetSet> dadosIn = null;
//				tbl.dados.addAll(dadosIn );  
//				tbl.fireTableDataChanged(); 
								
//				fp.getListaEmpregados();
				
		        ResultSet rs = null;
				Connection conn;
				PreparedStatement pst = null;	
				
		        try {	        	

//		        	List<FuncCadasGetSet> empregados=new ArrayList<FuncCadasGetSet>();   
		            Class.forName("com.mysql.jdbc.Driver");    
		            conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1/linkey","root", "");
		            
//					TableColumnModel ACAO = fp.table.setColumnModel(null);
//					.setTableHeader("o");

//		            String ACAO = "A��o";
					String SQL =("SELECT Nome ,RG,CPF,Nascimento AS 'Data de Nascimento',Sexo,Telefone,Celular,Email,CEP,Endereco,"
	            			+ "Numero,Complemento,Cidade,Bairro,UF from tbl_dadosfuncionarios where Nome=?");;
					pst = conn.prepareStatement(SQL);
		            pst.setString(1, jtfBusca.getText()); 
		            
		            rs = pst.executeQuery();
	            	fp.table.setModel(DbUtils.resultSetToTableModel(rs));

	            	
//	    	        fp.table.getColumnModel().getColumn(0).setPreferredWidth(500);
//	            	fp.column.setCellRenderer(colorRenderer);
		            while (rs.next()) {
		            	
		            }
		            rs.close();

		        } catch (ClassNotFoundException | SQLException e) {
		            e.printStackTrace();
		        }   

		        return;
				}
				
			}
		});
		jtfBusca.setBounds(479, 6, 278, 22);
		dpPrincipal.add(jtfBusca);
		jtfBusca.setColumns(10);
		dpPrincipal.add(imgSair);


		imgMenu = new JLabel("");
		imgMenu.setVisible(false);
		imgMenu.setBounds(763, 0, 37, 35);
		dpPrincipal.add(imgMenu);
		imgMenu.setBorder(null);
		imgMenu.setIcon(new ImageIcon("images/menu.png"));

		imgMenuOpen = new JLabel("");
		imgMenuOpen.setVisible(false);

		imgInFunc = new JLabel("");
		imgInFunc.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		imgInFunc.setVisible(false);
		imgInFunc.setEnabled(false);
		
		final JLabel imgInClient = new JLabel("");
		imgInClient.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		imgInClient.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				imgMenuOpen.setVisible(false);
				imgMenuOpen.setVisible(false);
				imgSair.setVisible(false);
				imgInFunc.setVisible(false);
				imgSair.setEnabled(false);
				imgInClient.setVisible(false);
				imgInClient.setEnabled(false);
				
				ClientCadastro cd = new ClientCadastro();
				dpPrincipal.add(cd);
				cd.setVisible(true);
				javax.swing.plaf.InternalFrameUI ui = cd.getUI();
				((javax.swing.plaf.basic.BasicInternalFrameUI) ui)
						.setNorthPane(null);
				
				
			}
		});
		imgInClient.setVisible(false);
		imgInClient.setEnabled(false);
		imgInClient.setBounds(619, 240, 181, 43);
		dpPrincipal.add(imgInClient);
		imgInFunc.setBounds(619, 333, 181, 43);
		dpPrincipal.add(imgInFunc);
		imgInFunc.setBorder(null);
		
		final JLabel imgInVeic = new JLabel("");
		imgInVeic.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		imgInVeic.setVisible(false);
		imgInVeic.setEnabled(false);
		imgInVeic.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				imgMenuOpen.setVisible(false);
				imgMenuOpen.setVisible(false);
				imgSair.setVisible(false);
				imgInFunc.setVisible(false);
				imgSair.setEnabled(false);
				imgInClient.setVisible(false);
				imgInClient.setEnabled(false);
				
				imgMenuOpen.setVisible(false);
				imgMenuOpen.setVisible(false);
				imgSair.setVisible(false);
				imgInFunc.setVisible(false);

				
				VeicCadastro vc = new VeicCadastro();
				dpPrincipal.add(vc);
				vc.setVisible(true);
				javax.swing.plaf.InternalFrameUI ui = vc.getUI();
				((javax.swing.plaf.basic.BasicInternalFrameUI) ui)
						.setNorthPane(null);
				String RF = jtfLogin.getText();
				vc.jtfRF.setText(RF);

				
			}
		});
		imgInVeic.setBounds(619, 286, 181, 43);
		dpPrincipal.add(imgInVeic);
		imgMenuOpen.setIcon(new ImageIcon("images/menu combobox2.png"));
		imgMenuOpen.setBounds(619, 35, 181, 567);
		dpPrincipal.add(imgMenuOpen);
		
		imgInFunc.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				imgMenuOpen.setVisible(false);
				imgMenuOpen.setVisible(false);
				imgSair.setVisible(false);
				imgInFunc.setVisible(false);
				imgSair.setEnabled(false);
				imgInClient.setVisible(false);
				imgInClient.setEnabled(false);
				
				FuncCadastro fc = new FuncCadastro();
				dpPrincipal.add(fc);
				fc.setVisible(true);
				javax.swing.plaf.InternalFrameUI ui = fc.getUI();
				((javax.swing.plaf.basic.BasicInternalFrameUI) ui)
						.setNorthPane(null);
				
				int i;
	        	Random of = new Random();  
	            int jf = 999999;  
	            i = of.nextInt(jf);
	            fc.jtfLogin.setText("RF"+i);
			}
		});

		final JLabel close = new JLabel("");
		final JLabel close_press = new JLabel("");
		close_press.setVisible(false);
		JLabel AcoesClose = new JLabel("");
		AcoesClose.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		AcoesClose.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent arg0) {
				close_press.setVisible(true);
			}

			@Override
			public void mouseExited(MouseEvent e) {
				close_press.setVisible(false);
			}

			@Override
			public void mouseClicked(MouseEvent e) {
				System.exit(0);
			}
		});

		JLabel AcoesMin = new JLabel("");
		AcoesMin.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		AcoesMin.setBounds(28, 4, 25, 25);
		dpPrincipal.add(AcoesMin);

		final JLabel min_press = new JLabel("");
		min_press.setVisible(false);
		min_press.setIcon(new ImageIcon("images/min_press.png"));
		min_press.setBounds(28, 4, 25, 25);
		dpPrincipal.add(min_press);

		JLabel min = new JLabel("");
		min.setIcon(new ImageIcon("images/min.png"));
		min.setBounds(28, 4, 25, 25);
		dpPrincipal.add(min);
		AcoesClose.setBounds(4, 4, 25, 25);
		dpPrincipal.add(AcoesClose);
		close_press.setIcon(new ImageIcon("images/close_press2.png"));
		close_press.setBounds(4, 4, 25, 25);
		dpPrincipal.add(close_press);
		close.setIcon(new ImageIcon("images/close.png"));
		close.setBounds(4, 4, 25, 25);
		dpPrincipal.add(close);

		AcoesMin.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				setState(Principal.ICONIFIED);
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				min_press.setVisible(true);
			}

			@Override
			public void mouseExited(MouseEvent e) {
				min_press.setVisible(false);
			}
		});

		final JLabel imgFundol = new JLabel("");
		imgFundol.setIcon(new ImageIcon("images/fundo.png"));
		imgFundol.setVisible(false);
		
		imgFundol.setBounds(0, 0, 800, 35);
		dpPrincipal.add(imgFundol);

		final JLabel imgFundo = new JLabel("");
		imgFundo.setIcon(new ImageIcon("images/fundo.png"));
		imgFundo.setBounds(0, 0, 800, 188);
		dpPrincipal.add(imgFundo);


		jpfSenha.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent arg0) {				
				if (arg0.getKeyCode() == KeyEvent.VK_ENTER){
					
					LoginCon cl = new LoginCon();
					cl.Acesso(jtfLogin.getText(), jpfSenha.getText());
					if (cl.acesso == true) {
						someTutuLog();
						lblLogin.setVisible(false);
						lblSenha.setVisible(false);
						imgInFunc.setVisible(false);
						btnEntrar.setVisible(false);
						pLogin.setVisible(false);
						imgFundol.setVisible(true);
						imgFundo.setVisible(false);
						imgFundo.setVisible(false);
						jtfBusca.setVisible(true);
						
						imgMenu.setVisible(true);

					}
					if (cl.acesso == false) {
						jtfLogin.setText("");
						jpfSenha.setText("");
						jtfLogin.requestFocus();
					}

					cl.acesso = false;
					
				}
			}
		});
		
		btnEntrar.addActionListener(new ActionListener() {
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent e) {
			
				LoginCon cl = new LoginCon();
				cl.Acesso(jtfLogin.getText(), jpfSenha.getText());
				
				if (cl.acesso == true) {
					someTutuLog();					
					lblLogin.setVisible(false);
					lblSenha.setVisible(false);
					imgInFunc.setVisible(false);
					btnEntrar.setVisible(false);
					pLogin.setVisible(false);
					imgFundol.setVisible(true);
					imgFundo.setVisible(false);
					imgFundo.setVisible(false);
					jtfBusca.setVisible(true);

					imgMenu.setVisible(true);

				}
				if (cl.acesso == false) {
					jtfLogin.setText("");
					jpfSenha.setText("");
					jtfLogin.requestFocus();
				}

				cl.acesso = false;

			}
		});
		
		imgMenu.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent arg0) {
				imgInFunc.setEnabled(true);
				imgInVeic.setEnabled(true);
				imgSair.setEnabled(true);

				imgInClient.setVisible(true);
				imgInClient.setEnabled(true);
				
				imgInVeic.setVisible(true);
				imgMenuOpen.setVisible(true);
				imgSair.setVisible(true);
				imgInFunc.setVisible(true);				
			}
		});
		
		imgMenu.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				imgInFunc.setEnabled(false);
				imgInVeic.setEnabled(false);
				imgSair.setEnabled(false);
				
				imgInClient.setVisible(false);
				imgInClient.setEnabled(false);
				
				imgInVeic.setVisible(false);
				imgMenuOpen.setVisible(false);
				imgSair.setVisible(false);
				imgInFunc.setVisible(false);
				
			}
		});
		
		imgSair.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				apareceuTutuLog();
				lblLogin.setVisible(true);
				lblSenha.setVisible(true);
				imgInFunc.setVisible(true);
				btnEntrar.setVisible(true);
				imgFundol.setVisible(false);
				imgFundo.setVisible(true);				
				jtfBusca.setVisible(false);
				limpaTutuLog();
				
				imgInClient.setVisible(false);
				imgInClient.setEnabled(false);
				
				imgInFunc.setEnabled(false);
				imgInVeic.setEnabled(false);
				imgSair.setEnabled(false);
				
				imgInVeic.setVisible(false);
				imgInFunc.setVisible(false);
				imgSair.setVisible(false);
				imgMenuOpen.setVisible(false);
				pLogin.setVisible(true);
				imgMenu.setVisible(false);
			}
		});		

		contentPane.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				imgMenuOpen.setVisible(false);
				imgInFunc.setVisible(false);
				imgSair.setVisible(false);
				imgSair.setEnabled(false);
				imgInVeic.setVisible(false);
				imgSair.setEnabled(false);
				imgInFunc.setEnabled(false);
				imgInClient.setVisible(false);
				imgInClient.setEnabled(false);
				
				jtfBusca.setText("  Busca:");

			}
		});
		dpPrincipal.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {				
				jtfBusca.setText("  Busca:");
				imgMenuOpen.setVisible(false);
				imgInFunc.setVisible(false);
				imgSair.setVisible(false);
				imgSair.setEnabled(false);
				imgInVeic.setVisible(false);
				imgSair.setEnabled(false);
				imgInFunc.setEnabled(false);
				imgInClient.setVisible(false);
				imgInClient.setEnabled(false);
				
				jtfBusca.setText("  Busca:");

			}
		});
	}

	private static JInternalFrame fc = null; 
	
	public synchronized JInternalFrame getJIFrame(){ 
	
	if (fc == null) {
			
		}else{
		fc.setVisible(false);
//		fc.moveToBack();
			dispose();
		}
	return fc;
	}
	
	private void someTutuLog() {
		jtfLogin.setVisible(false);
		jpfSenha.setVisible(false);
	}

	private void apareceuTutuLog() {
		jtfLogin.setVisible(true);
		jpfSenha.setVisible(true);
	}

	private void limpaTutuLog() {
		jtfLogin.setText("");
		jpfSenha.setText("");
	}
}
