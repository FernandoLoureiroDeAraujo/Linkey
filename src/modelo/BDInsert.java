package modelo;

import java.sql.ResultSet;

import javax.swing.JOptionPane;

import mysql.Conexao;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;

public class BDInsert {
	//Insere dados na tabela Financeiro
	public boolean InsertFinan(String RF, String Cargo, String Salario,
			String DataAdmissao, String DataDemissao, String ID_Func) {
		Conexao conectaMoss = new Conexao();
		String sSQL;
		int result;
		try {

			Connection ExConn = (Connection) conectaMoss.abrirBDCoon();
			Statement st = (Statement) ExConn.createStatement();
			sSQL = "INSERT INTO tbl_financeiro VALUES ('" + RF + "','"
					+ Cargo + "','" + Salario + "','" + DataAdmissao + "','"
					+ DataDemissao + "','"+ ID_Func + "');";
			result = conectaMoss.inserir(sSQL);
//			JOptionPane.showMessageDialog(null, "Dados inseridos!");
			System.out.println(sSQL);
			st.close();
			conectaMoss.fecharBDCoon();
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null,
					"Os dados não poderam ser inseridos!" + e.getMessage());
		}
		return false;
	}
	
	//Insere dados na tabela Login
	public boolean InsertLogin(String Senha, String RF) {
		Conexao conectaMoss = new Conexao();
		String sSQL;
		int result;
		try {

			Connection ExConn = (Connection) conectaMoss.abrirBDCoon();
			Statement st = (Statement) ExConn.createStatement();
			sSQL = "INSERT INTO tbl_loginfuncionarios VALUES (null,'" +Senha+ "','"+ RF+"');";
			result = conectaMoss.inserir(sSQL);
			JOptionPane.showMessageDialog(null, "Cadastro efetuado!");
			System.out.println(sSQL);
			st.close();
			conectaMoss.fecharBDCoon();
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null,
					"Os dados não poderam ser inseridos!" + e.getMessage());
		}
		return false;
	}
	
	//Insere dados na tabela Funcionario
	public boolean InsertFunc(String Nome, String RG, String CPF, String DataNascimento, String Sexo, 
			String Telefone, String Celular, String Email,
			String CEP, String Endereco, String Numero, String Complemento,String Cidade, String Bairro, String UF) {
		
				Conexao conectaMoss = new Conexao();
				String SQLInsert;
				int result;
			    ResultSet rs;
			    
			 try {
	
				Connection ExConn = (Connection) conectaMoss.abrirBDCoon();
				Statement st = (Statement) ExConn.createStatement();
				SQLInsert = "INSERT INTO tbl_dadosfuncionarios VALUES (null,'" +Nome+ "','"+RG+ "','" +CPF+ "','" +DataNascimento+ "','"+Sexo+ "',"+
													"'" +Telefone+ "','" +Celular+ "','"+Email+ "',"+
													"'" +CEP+ "','" +Endereco+ "','" +Numero+ "','"+Complemento+"','"+Cidade+ "','" +Bairro+ "','"+UF+"');";
				result = conectaMoss.inserir(SQLInsert);
				//JOptionPane.showMessageDialog(null, "Dados inseridos!");
				System.out.println(SQLInsert);
				st.close();
				conectaMoss.fecharBDCoon();
			} catch (Exception e) {
				JOptionPane.showMessageDialog(null,
					"Os dados não poderam ser inseridos!" + e.getMessage());
				}
				return false;
	}
	
	//Insere dados na tabela Cliente
	public boolean InsertClient(String Nome, String RG, String CPF, String DataNascimento, String Sexo, 
			String Telefone, String Celular, String Email,
			String CEP, String Endereco, String Numero, String Complemento,String Cidade, String Bairro, String UF) {
		
				Conexao conectaMoss = new Conexao();
				String SQLInsert;
				int result;
			    ResultSet rs;
			    
			 try {
	
				Connection ExConn = (Connection) conectaMoss.abrirBDCoon();
				Statement st = (Statement) ExConn.createStatement();
				SQLInsert = "INSERT INTO tbl_clientes VALUES (null,'" +Nome+ "','"+RG+ "','" +CPF+ "','" +DataNascimento+ "','"+Sexo+ "',"+
													"'" +Telefone+ "','" +Celular+ "','"+Email+ "',"+
													"'" +CEP+ "','" +Endereco+ "','" +Numero+ "','"+Complemento+"','"+Cidade+ "','" +Bairro+ "','"+UF+"');";
				result = conectaMoss.inserir(SQLInsert);
				JOptionPane.showMessageDialog(null, "Cadastro efetuado!");
				System.out.println(SQLInsert);
				st.close();
				conectaMoss.fecharBDCoon();
			} catch (Exception e) {
				JOptionPane.showMessageDialog(null,
					"Os dados não poderam ser inseridos!" + e.getMessage());
				}
				return false;
	}
	
	//Insere dados na tabela Veiculos
	public boolean InsertVeic(String RF, String Veiculo, String Placa, String Ano, String Marca, String Modelo, 
			String Chassi, String Quantidade) {
		
				Conexao conectaMoss = new Conexao();
				String SQLInsert;
				int result;
			    ResultSet rs;
			    
			 try {
	
				Connection ExConn = (Connection) conectaMoss.abrirBDCoon();
				Statement st = (Statement) ExConn.createStatement();
				SQLInsert = "INSERT INTO tbl_Veiculos VALUES (null,'" +RF+ "','"+Veiculo+ "','" +Placa+ "','" +Ano+ "','"+Marca+ "',"+
													"'" +Modelo+ "','" +Chassi+ "','"+Quantidade+"');";
				result = conectaMoss.inserir(SQLInsert);
				JOptionPane.showMessageDialog(null, "Cadastro efetuado!");
				System.out.println(SQLInsert);
				st.close();
				conectaMoss.fecharBDCoon();
			} catch (Exception e) {
				JOptionPane.showMessageDialog(null,
					"Os dados não poderam ser inseridos!" + e.getMessage());
				}
				return false;
	}
}
