package aparencia;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;

import java.awt.Color;


import java.awt.Cursor;
import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.ImageIcon;

import modelo.BDInsert;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.SwingConstants;

public class VeicCadastro extends JInternalFrame {
	BDInsert BDIn = new BDInsert();	
	JTextField jtfRF;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VeicCadastro frame = new VeicCadastro();
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
	public VeicCadastro() {
			getContentPane().setMaximumSize(new Dimension(0, 0));
			getContentPane().setBackground(new Color(247, 247, 247));
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			setBorder(null);
			setBounds(0, 0, 800, 600);
			getContentPane().setLayout(null);
			setLocation(0, 35);
					
			JPanel contentPane = new JPanel();
			contentPane.setBackground(new Color(246, 246, 246));
			contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
			setContentPane(contentPane);
			contentPane.setLayout(null);

			
			final JLabel lblVeiculo = new JLabel("Veiculo:");
			lblVeiculo.setBounds(247, 126, 50, 50);
			contentPane.add(lblVeiculo);
			lblVeiculo.setForeground(Color.BLACK);

			final JTextField jtfVeiculo = new JTextField();
			jtfVeiculo.addKeyListener(new KeyAdapter() {
				@Override
				public void keyTyped(KeyEvent e) {
					jtfVeiculo.setBorder(new LineBorder(new Color(81, 163, 157)));
					
				}
			});
			jtfVeiculo.setBorder(new LineBorder(Color.LIGHT_GRAY));
			jtfVeiculo.setBounds(341, 140, 215, 22);
			contentPane.add(jtfVeiculo);
			jtfVeiculo.setColumns(10);
			
			final JLabel lblPlaca = new JLabel("Placa:");
			lblPlaca.setBounds(247, 187, 61, 22);
			contentPane.add(lblPlaca);
			lblPlaca.setForeground(Color.BLACK);

			final JTextField jtfPlaca = new JTextField();
			jtfPlaca.addKeyListener(new KeyAdapter() {
				@Override
				public void keyTyped(KeyEvent e) {
					jtfPlaca.setBorder(new LineBorder(new Color(81, 163, 157)));
				}
			});
			jtfPlaca.setBorder(new LineBorder(Color.LIGHT_GRAY));
			jtfPlaca.setBounds(341, 183, 107, 22);
			contentPane.add(jtfPlaca);
			jtfPlaca.setColumns(10);

			
			final JLabel lblAno = new JLabel("Ano:");
			lblAno.setBounds(247, 227, 50, 22);
			contentPane.add(lblAno);
			lblAno.setForeground(Color.BLACK);

			final JTextField jtfAno = new JTextField();
			jtfAno.addKeyListener(new KeyAdapter() {
				@Override
				public void keyTyped(KeyEvent e) {
					jtfAno.setBorder(new LineBorder(new Color(81, 163, 157)));
				}
			});
			jtfAno.setBorder(new LineBorder(Color.LIGHT_GRAY));
			jtfAno.setBounds(341, 227, 107, 22);
			contentPane.add(jtfAno);
			jtfAno.setColumns(10);
			
			final JLabel lblMarca = new JLabel("Marca:");
			lblMarca.setBounds(247, 272, 50, 22);
			contentPane.add(lblMarca);
			lblMarca.setForeground(Color.BLACK);

			final JTextField jtfMarca = new JTextField();
			jtfMarca.addKeyListener(new KeyAdapter() {
				@Override
				public void keyTyped(KeyEvent e) {
					jtfMarca.setBorder(new LineBorder(new Color(81, 163, 157)));
				}
			});
			jtfMarca.setBorder(new LineBorder(Color.LIGHT_GRAY));
			jtfMarca.setBounds(341, 272, 215, 22);
			contentPane.add(jtfMarca);
			jtfMarca.setColumns(10);
			
			final JLabel lblModelo = new JLabel("Modelo:");
			lblModelo.setBounds(247, 316, 50, 22);
			contentPane.add(lblModelo);
			lblModelo.setForeground(Color.BLACK);

			final JTextField jtfModelo = new JTextField();
			jtfModelo.addKeyListener(new KeyAdapter() {
				@Override
				public void keyTyped(KeyEvent e) {
					jtfModelo.setBorder(new LineBorder(new Color(81, 163, 157)));
				}
			});
			jtfModelo.setBorder(new LineBorder(Color.LIGHT_GRAY));
			jtfModelo.setBounds(341, 316, 215, 22);
			contentPane.add(jtfModelo);
			jtfModelo.setColumns(10);
			
			final JLabel lblChassi = new JLabel("Chassi:");
			lblChassi.setBounds(247, 361, 50, 22);
			contentPane.add(lblChassi);
			lblChassi.setForeground(Color.BLACK);

			final JTextField jtfChassi = new JTextField();
			jtfChassi.addKeyListener(new KeyAdapter() {
				@Override
				public void keyTyped(KeyEvent e) {
					jtfChassi.setBorder(new LineBorder(new Color(81, 163, 157)));
				}
			});
			jtfChassi.setBorder(new LineBorder(Color.LIGHT_GRAY));
			jtfChassi.setBounds(341, 361, 215, 22);
			contentPane.add(jtfChassi);
			jtfChassi.setColumns(10);
			jtfChassi.setVisible(true);
			
			final JLabel lblQuantidade = new JLabel("Quantidade:");
			lblQuantidade.setBounds(247, 405, 88, 22);
			contentPane.add(lblQuantidade);
			lblQuantidade.setForeground(Color.BLACK);

			final JTextField jtfQuantidade = new JTextField();
			jtfQuantidade.addKeyListener(new KeyAdapter() {
				@Override
				public void keyTyped(KeyEvent e) {
					jtfQuantidade.setBorder(new LineBorder(new Color(81, 163, 157)));
				}
			});
			jtfQuantidade.setBorder(new LineBorder(Color.LIGHT_GRAY));
			jtfQuantidade.setBounds(341, 405, 107, 22);
			contentPane.add(jtfQuantidade);
			jtfQuantidade.setColumns(10);		


			JLabel AcaoCadastrar = new JLabel("");
			AcaoCadastrar.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					String Veiculo = jtfVeiculo.getText();
					String Placa = jtfPlaca.getText();
					String Ano = jtfAno.getText();
					String Marca = jtfMarca.getText();
					String Modelo = jtfModelo.getText();
					String Chassi = jtfChassi.getText();
					String Quantidade = jtfQuantidade.getText();

					String RF = jtfRF.getText();
					// ------------------------------------------------------//
					if (Veiculo.equals("") || Placa.equals("") || Ano.equals("")
							|| Marca.equals("") || Modelo.equals("") || Chassi.equals("")
							|| Quantidade.equals(""))
						{
						// ------------------------------------------------------//
						if (Veiculo.equals("")) {
							jtfVeiculo.setBorder(new LineBorder(Color.RED));
							jtfVeiculo.requestFocus();
						}
						if (Placa.equals("")) {
							jtfPlaca.setBorder(new LineBorder(Color.RED));
							jtfPlaca.requestFocus();
						}
						if (Ano.equals("")) {
							jtfAno.setBorder(new LineBorder(Color.RED));
							jtfAno.requestFocus();
						}
						if (Marca.equals("")) {
							jtfMarca.setBorder(new LineBorder(Color.RED));
							jtfMarca.requestFocus();
						}
						if (Modelo.equals("")) {
							jtfModelo.setBorder(new LineBorder(Color.RED));
							jtfModelo.requestFocus();
						}
						if (Chassi.equals("")) {
							jtfChassi.setBorder(new LineBorder(Color.RED));
							jtfChassi.requestFocus();
						}
						if (Quantidade.equals("")) {
							jtfQuantidade.setBorder(new LineBorder(Color.RED));
							jtfQuantidade.requestFocus();
						}
						return;
					}
						BDIn.InsertVeic(RF, Veiculo, Placa, Ano, Marca, Modelo, Chassi, Quantidade);
						
						jtfVeiculo.requestFocus();
						
						jtfVeiculo.setBorder(new LineBorder(Color.LIGHT_GRAY));
						jtfPlaca.setBorder(new LineBorder(Color.LIGHT_GRAY));
						jtfAno.setBorder(new LineBorder(Color.LIGHT_GRAY));
						jtfMarca.setBorder(new LineBorder(Color.LIGHT_GRAY));
						jtfModelo.setBorder(new LineBorder(Color.LIGHT_GRAY));
						jtfChassi.setBorder(new LineBorder(Color.LIGHT_GRAY));
						jtfQuantidade.setBorder(new LineBorder(Color.LIGHT_GRAY));
						
						jtfVeiculo.setText("");
						jtfPlaca.setText("");
						jtfAno.setText("");
						jtfMarca.setText("");
						jtfModelo.setText("");
						jtfChassi.setText("");
						jtfQuantidade.setText("");
					
				}
			});
			jtfRF = new JTextField();
			jtfRF.setEditable(false);
			jtfRF.setBounds(704, 11, 86, 20);
			contentPane.add(jtfRF);
			jtfRF.setColumns(10);
			AcaoCadastrar.setBounds(202, 488, 402, 34);
			contentPane.add(AcaoCadastrar);
			
			JLabel ActionVoltar = new JLabel("");
			ActionVoltar.setHorizontalAlignment(SwingConstants.LEFT);
			ActionVoltar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			ActionVoltar.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					dispose();
				}
			});
			ActionVoltar.setBounds(5, 8, 20, 21);
			contentPane.add(ActionVoltar);
			
			JLabel Fundo = new JLabel("");
			Fundo.setIcon(new ImageIcon("images/BordVeic.png"));
			Fundo.setBounds(0, 0, 800, 573);
			contentPane.add(Fundo);
	}
		}