package aparencia;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;

import modelo.BDInsert;
import modelo.BuscaCEP;
import modelo.MascCEP;
import modelo.MascCPF;
import modelo.MascMoeda;
import modelo.MascTel;
import mysql.Conexao;

import javax.swing.ImageIcon;

import com.mysql.jdbc.Statement;
import java.awt.Cursor;

public class ClientCadastro extends JInternalFrame {

	private static JTextField jtfNome;
	private JTextField jtfRG;
	private JTextField jtfDia;
	private JComboBox cbSexo;

	private JTextField jtfTelefone;
	private JTextField jtfCelular;
	private JTextField jtfEmail;

	private JTextField jtfCEP;
	private JTextField jtfEndereco;
	private JTextField jtfComplemento;
	private JTextField jtfUF;
	private JTextField jtfNumero;
	private JTextField jtfBairro;
	private JTextField jtfCidade;
	
	BDInsert BDIn = new BDInsert();
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ClientCadastro frame = new ClientCadastro();
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
	public ClientCadastro() {
		getContentPane().setMaximumSize(new Dimension(0, 0));
		getContentPane().setBackground(new Color(51, 153, 153));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBorder(null);
		setBounds(0, 0, 800, 600);
		getContentPane().setLayout(null);
		setLocation(0, 35);

		JPanel panel = new JPanel();
		panel.setBackground(new Color(246, 246, 246));
		panel.setBorder(null);
		panel.setBounds(0, 0, 800, 573);
		getContentPane().add(panel);
		panel.setLayout(null);

		JLabel lblCadastrar = new JLabel("");
		lblCadastrar.setBounds(31, 488, 738, 33);
		panel.add(lblCadastrar);

		JLabel lblNome = new JLabel("Nome:");
		lblNome.setBounds(35, 98, 58, 30);
		panel.add(lblNome);

		jtfNome = new JTextField();
		jtfNome.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				jtfNome.setBorder(new LineBorder(new Color(81, 163, 157)));

			}
		});
		jtfNome.setBorder(new LineBorder(Color.LIGHT_GRAY));
		jtfNome.setBounds(129, 102, 299, 22);
		panel.add(jtfNome);
		jtfNome.setColumns(10);

		JLabel lblRg = new JLabel("RG:");
		lblRg.setBounds(35, 136, 46, 14);
		panel.add(lblRg);

		final JTextField jtfRG = new JTextField();
		jtfRG.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				jtfRG.setBorder(new LineBorder(new Color(81, 163, 157)));
			}
		});
		jtfRG.setBorder(new LineBorder(Color.LIGHT_GRAY));
		jtfRG.setBackground(Color.WHITE);
		jtfRG.setBounds(129, 133, 111, 20);
		panel.add(jtfRG);

		JLabel lblCpf = new JLabel("CPF:");
		lblCpf.setBounds(35, 164, 46, 14);
		panel.add(lblCpf);

		final JTextField jtfCPF = new JTextField();
		jtfCPF.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				jtfCPF.setBorder(new LineBorder(new Color(81, 163, 157)));
			}
		});
		jtfCPF.setBorder(new LineBorder(Color.LIGHT_GRAY));
		jtfCPF.setBounds(129, 161, 111, 20);
		panel.add(jtfCPF);

		JLabel lblDataDeNascimento = new JLabel("Data de Nascimento:");
		lblDataDeNascimento.setBounds(505, 98, 135, 30);
		panel.add(lblDataDeNascimento);

		final JTextField jtfDia = new JTextField();
		jtfDia.setActionCommand("");
		jtfDia.setBounds(648, 102, 28, 22);
		panel.add(jtfDia);
		jtfDia.setBorder(new LineBorder(Color.LIGHT_GRAY));
		jtfDia.setText("");

		final JTextField jtfMes = new JTextField();
		jtfMes.setBorder(new LineBorder(Color.LIGHT_GRAY));
		jtfMes.setActionCommand("");
		jtfMes.setBounds(685, 102, 28, 22);
		panel.add(jtfMes);

		final JTextField jtfAno = new JTextField();
		jtfAno.setText("");
		jtfAno.setBorder(new LineBorder(Color.LIGHT_GRAY));
		jtfAno.setActionCommand("");
		jtfAno.setBounds(723, 102, 44, 22);
		panel.add(jtfAno);
		
		jtfDia.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent arg0) {
	               if (arg0.getKeyCode() == KeyEvent.VK_TAB) {
	                    if (	                    	jtfDia.equals(2)) {
	                        jtfMes.transferFocus();}

//	                    } else {
//	                    	jtfMes.transferFocus();
//	                    }
			}
		}});
        
		final JComboBox cbSexo = new JComboBox();
		cbSexo.setBorder(null);
		cbSexo.setBounds(646, 133, 121, 20);
		panel.add(cbSexo);
		cbSexo.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				if (cbSexo.getSelectedItem().equals("<Selecione>")) {

				} else {
					cbSexo.setBorder(new LineBorder(new Color(81, 163, 157)));
				}
			}
		});

		JLabel lblSexo = new JLabel("Sexo:");
		lblSexo.setBounds(505, 136, 46, 14);
		panel.add(lblSexo);
		cbSexo.setModel(new DefaultComboBoxModel(new String[] { "<Selecione>",
				"Masculino", "Feminino" }));

		JLabel lblTelefone = new JLabel("Telefone:");
		lblTelefone.setBounds(35, 213, 69, 14);
		panel.add(lblTelefone);

		final JTextField jtfTelefone = new JTextField();
		jtfTelefone.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				jtfTelefone.setBorder(new LineBorder(new Color(81, 163, 157)));
			}
		});
		jtfTelefone.setBorder(new LineBorder(Color.LIGHT_GRAY));
		jtfTelefone.setBounds(128, 210, 111, 20);
		panel.add(jtfTelefone);

		JLabel lblCelular = new JLabel("Celular:");
		lblCelular.setBounds(505, 213, 46, 14);
		panel.add(lblCelular);

		final JTextField jtfCelular = new JTextField();
		jtfCelular.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				jtfCelular.setBorder(new LineBorder(new Color(81, 163, 157)));
			}
		});
		jtfCelular.setBorder(new LineBorder(Color.LIGHT_GRAY));
		jtfCelular.setBounds(648, 210, 111, 20);
		panel.add(jtfCelular);

		JLabel lblEmail = new JLabel("E-mail:");
		lblEmail.setBounds(35, 245, 46, 14);
		panel.add(lblEmail);

		jtfEmail = new JTextField();
		jtfEmail.setBorder(new LineBorder(Color.LIGHT_GRAY));
		jtfEmail.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				jtfEmail.setBorder(new LineBorder(new Color(81, 163, 157)));
			}
		});
		jtfEmail.setBounds(129, 242, 272, 20);
		panel.add(jtfEmail);
		jtfEmail.setColumns(10);

		JLabel lblCep = new JLabel("CEP:");
		lblCep.setBounds(35, 297, 46, 14);
		panel.add(lblCep);

		jtfCEP = new JTextField();
		jtfCEP.setBorder(new LineBorder(Color.LIGHT_GRAY));
		jtfCEP.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {

			}
		});
		jtfCEP.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				BuscaCEP bc = new BuscaCEP();
				String CEP = jtfCEP.getText();

				try {

					if (CEP.length() >= 8) {

						jtfCEP.setBorder(new LineBorder(new Color(81, 163, 157)));
						jtfEndereco.setText(bc.getEndereco(CEP));
						jtfEndereco.setBorder(new LineBorder(new Color(81, 163,
								157)));
						jtfBairro.setText(bc.getBairro(CEP));
						jtfBairro.setBorder(new LineBorder(new Color(81, 163,
								157)));
						jtfCidade.setText(bc.getCidade(CEP));
						jtfCidade.setBorder(new LineBorder(new Color(81, 163,
								157)));
						jtfUF.setText(bc.getUF(CEP));
						jtfUF.setBorder(new LineBorder(new Color(81, 163, 157)));
						jtfEndereco.setEnabled(true);
						jtfBairro.setEnabled(true);
						jtfCidade.setEnabled(true);
						jtfUF.setEnabled(true);
						jtfComplemento.setEnabled(true);
						jtfNumero.setEnabled(true);
						
						jtfEndereco.setEditable(true);
						jtfBairro.setEditable(true);
						jtfCidade.setEditable(true);
						jtfUF.setEditable(true);
						jtfComplemento.setEditable(true);
						jtfNumero.setEditable(true);
					}

				}

				catch (IOException e1) {
					e1.printStackTrace();
				}

			}
		});

		jtfCEP.setBounds(129, 294, 110, 20);
		panel.add(jtfCEP);
		jtfCEP.setColumns(10);

		JLabel lblEndereo = new JLabel("Endere\u00E7o:");
		lblEndereo.setBounds(35, 329, 58, 14);
		panel.add(lblEndereo);

		jtfEndereco = new JTextField();
		jtfEndereco.setEditable(false);
		jtfEndereco.setEnabled(false);
		jtfEndereco.setBorder(new LineBorder(Color.LIGHT_GRAY));
		jtfEndereco.setBounds(129, 326, 272, 20);
		panel.add(jtfEndereco);
		jtfEndereco.setColumns(10);

		JLabel lblComplemento = new JLabel("Complemento:");
		lblComplemento.setBounds(35, 363, 87, 14);
		panel.add(lblComplemento);

		jtfComplemento = new JTextField();
		jtfComplemento.setEditable(false);
		jtfComplemento.setEnabled(false);
		jtfComplemento.setBorder(new LineBorder(Color.LIGHT_GRAY));
		jtfComplemento.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				jtfComplemento
						.setBorder(new LineBorder(new Color(81, 163, 157)));
			}
		});
		jtfComplemento.setBounds(129, 360, 272, 20);
		panel.add(jtfComplemento);
		jtfComplemento.setColumns(10);

		JLabel lblUf = new JLabel("UF:");
		lblUf.setBounds(505, 397, 46, 14);
		panel.add(lblUf);

		jtfUF = new JTextField();
		jtfUF.setEditable(false);
		jtfUF.setEnabled(false);
		jtfUF.setBorder(new LineBorder(Color.LIGHT_GRAY));
		jtfUF.setBounds(627, 392, 86, 20);
		panel.add(jtfUF);
		jtfUF.setColumns(10);

		JLabel lblNumero = new JLabel("Numero:");
		lblNumero.setBounds(505, 329, 56, 14);
		panel.add(lblNumero);

		jtfNumero = new JTextField();
		jtfNumero.setEditable(false);
		jtfNumero.setEnabled(false);
		jtfNumero.setBorder(new LineBorder(Color.LIGHT_GRAY));
		jtfNumero.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				jtfNumero.setBorder(new LineBorder(new Color(81, 163, 157)));
			}
		});
		jtfNumero.setBounds(627, 326, 131, 20);
		panel.add(jtfNumero);
		jtfNumero.setColumns(10);

		JLabel lblBairro = new JLabel("Bairro:");
		lblBairro.setBounds(35, 397, 46, 14);
		panel.add(lblBairro);

		jtfBairro = new JTextField();
		jtfBairro.setEditable(false);
		jtfBairro.setEnabled(false);
		jtfBairro.setBorder(new LineBorder(Color.LIGHT_GRAY));
		jtfBairro.setBounds(129, 392, 272, 20);
		panel.add(jtfBairro);
		jtfBairro.setColumns(10);

		JLabel lblCidade = new JLabel("Cidade:");
		lblCidade.setBounds(505, 363, 46, 14);
		panel.add(lblCidade);

		jtfCidade = new JTextField();
		jtfCidade.setEditable(false);
		jtfCidade.setEnabled(false);
		jtfCidade.setBorder(new LineBorder(Color.LIGHT_GRAY));
		jtfCidade.setBounds(627, 360, 131, 20);
		panel.add(jtfCidade);
		jtfCidade.setColumns(10);
		
		JLabel ActionVoltar = new JLabel("");
		ActionVoltar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		ActionVoltar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				dispose();
			}
		});
		ActionVoltar.setBounds(5, 8, 20, 21);
		panel.add(ActionVoltar);
		
		JLabel imgFundo = new JLabel("");
		imgFundo.setIcon(new ImageIcon("images/BordClient2.png"));
		imgFundo.setBounds(0, 0, 800, 573);
		panel.add(imgFundo);
		
		//Mascaras
		jtfCPF.setDocument(new MascCPF());
		jtfTelefone.setDocument(new MascTel());
		jtfCelular.setDocument(new MascTel());
		jtfCEP.setDocument(new MascCEP());
		
		lblCadastrar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				String Nome = jtfNome.getText();
				String RG = jtfRG.getText();
				String CPF = jtfCPF.getText();
				String Dia = jtfDia.getText();
				String Mes = jtfMes.getText();
				String Ano = jtfAno.getText();
				String Sexo = (String) cbSexo.getSelectedItem();

				String Telefone = jtfTelefone.getText();
				String Celular = jtfCelular.getText();
				String Email = jtfEmail.getText();

				String CEP = jtfCEP.getText();
				String Endereco = jtfEndereco.getText();
				String Numero = jtfNumero.getText();
				String Complemento = jtfComplemento.getText();
				String Cidade = jtfCidade.getText();
				String Bairro = jtfBairro.getText();
				String UF = jtfUF.getText();
				String DataNascimento = Dia + "/" + Mes + "/" + Ano;
	
				// ------------------------------------------------------//

				if (Nome.equals("") || RG.equals("") || CPF.equals("")
						|| Dia.equals("") || Mes.equals("") || Ano.equals("")
						|| cbSexo.getSelectedItem().equals("<Selecione>")
						|| Telefone.equals("") 
						|| Email.equals("") || CEP.equals("")
						|| Endereco.equals("") || Numero.equals("")
						|| Complemento.equals("") || Cidade.equals("")
						|| Bairro.equals("") || UF.equals(""))
						{
					// ------------------------------------------------------//
					if (Nome.equals("")) {
						jtfNome.setBorder(new LineBorder(Color.RED));
						jtfNome.requestFocus();
					}
					if (RG.equals("")) {
						jtfRG.setBorder(new LineBorder(Color.RED));
						jtfRG.requestFocus();
					}
					if (CPF.equals("")) {
						jtfCPF.setBorder(new LineBorder(Color.RED));
					}
					if (Dia.equals("") || Mes.equals("") || Ano.equals("")) {
						jtfDia.setBorder(new LineBorder(Color.RED));
						jtfMes.setBorder(new LineBorder(Color.RED));
						jtfAno.setBorder(new LineBorder(Color.RED));
						jtfDia.requestFocus();
						jtfMes.requestFocus();
						jtfAno.requestFocus();
					}
					if (cbSexo.getSelectedItem().equals("<Selecione>")) {
						cbSexo.setBorder(new LineBorder(Color.RED));
						cbSexo.requestFocus();
					}
					// ------------------------------------------------------//
					if (Telefone.equals("")) {
						jtfTelefone.setBorder(new LineBorder(Color.RED));
						jtfTelefone.requestFocus();
					}
//					if (Celular.equals("")) {
//						jtfCelular.setBorder(new LineBorder(Color.RED));
//						jtfCelular.requestFocus();
//					}
					if (Email.equals("")) {
						jtfEmail.setBorder(new LineBorder(Color.RED));
						jtfEmail.requestFocus();
					}
					// ------------------------------------------------------//
					if (CEP.equals("")) {
						jtfCEP.setBorder(new LineBorder(Color.RED));
						jtfCEP.requestFocus();
					}
					if (Endereco.equals("")) {
						jtfEndereco.setBorder(new LineBorder(Color.RED));
						jtfEndereco.requestFocus();
					}
					if (Numero.equals("")) {
						jtfNumero.setBorder(new LineBorder(Color.RED));
						jtfNumero.requestFocus();
					}
					if (Complemento.equals("")) {
						jtfComplemento.setBorder(new LineBorder(Color.RED));
						jtfComplemento.requestFocus();
					}
					if (Cidade.equals("")) {
						jtfCidade.setBorder(new LineBorder(Color.RED));
						jtfCidade.requestFocus();
					}
					if (Bairro.equals("")) {
						jtfBairro.setBorder(new LineBorder(Color.RED));
						jtfBairro.requestFocus();
					}
					if (UF.equals("")) {
						jtfUF.setBorder(new LineBorder(Color.RED));
						jtfUF.requestFocus();
					}				
					return;
				}
				
				try {
					
					BDIn.InsertClient(Nome, RG, CPF, DataNascimento, Sexo, 
							Telefone, Celular, Email, 
							CEP, Endereco, Numero, Complemento, Cidade, Bairro, UF);
					
				} catch (Exception e) {
					JOptionPane.showMessageDialog(null,
							"Os dados n�o poderam ser inseridos2!" + e.getMessage());
				}	
				
				jtfNome.requestFocus();
				
				jtfNome.setBorder(new LineBorder(Color.LIGHT_GRAY));
				jtfRG.setBorder(new LineBorder(Color.LIGHT_GRAY));
				jtfCPF.setBorder(new LineBorder(Color.LIGHT_GRAY));
				jtfDia.setBorder(new LineBorder(Color.LIGHT_GRAY));
				jtfMes.setBorder(new LineBorder(Color.LIGHT_GRAY));
				jtfAno.setBorder(new LineBorder(Color.LIGHT_GRAY));
				cbSexo.setBorder(new LineBorder(Color.LIGHT_GRAY));
				
				jtfTelefone.setBorder(new LineBorder(Color.LIGHT_GRAY));
				jtfCelular.setBorder(new LineBorder(Color.LIGHT_GRAY));
				jtfEmail.setBorder(new LineBorder(Color.LIGHT_GRAY));
				
				jtfCEP.setBorder(new LineBorder(Color.LIGHT_GRAY));
				jtfEndereco.setBorder(new LineBorder(Color.LIGHT_GRAY));
				jtfNumero.setBorder(new LineBorder(Color.LIGHT_GRAY));
				jtfComplemento.setBorder(new LineBorder(Color.LIGHT_GRAY));
				jtfCidade.setBorder(new LineBorder(Color.LIGHT_GRAY));
				jtfBairro.setBorder(new LineBorder(Color.LIGHT_GRAY));
				jtfUF.setBorder(new LineBorder(Color.LIGHT_GRAY));
				
				jtfNome.setText("");
				jtfRG.setText("");
				jtfCPF.setText("");
				jtfDia.setText("");
				jtfMes.setText("");
				jtfAno.setText("");
				cbSexo.setSelectedItem("<Selecione>");

				jtfTelefone.setText("");
				jtfCelular.setText("");
				jtfEmail.setText("");

				jtfCEP.setText("");
				jtfEndereco.setText("");
				jtfNumero.setText("");
				jtfComplemento.setText("");
				jtfCidade.setText("");
				jtfBairro.setText("");
				jtfUF.setText("");
				
				
				
			}
		});
		


	}
}
