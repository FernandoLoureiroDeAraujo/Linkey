package mysql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import com.mysql.jdbc.Statement;

public class LoginCon {
	public boolean acesso;

	public void Acesso(String RF, String Senha) {
		Connection conn = null;
		Statement consulta = null;
		ResultSet tabela = null;

		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1/linkey","root", "");
			consulta = (Statement) conn.createStatement();
			tabela = consulta
					.executeQuery("SELECT RF, Senha from tbl_loginfuncionarios where RF='"+RF+"'and Senha='" +Senha+ "'");
			if (tabela.next()) {
				acesso = true;
			} else {
				JOptionPane.showMessageDialog(null,
						"Usuario ou Senha Incorretos");
				acesso = false;
			}

		} catch (ClassNotFoundException | SQLException e) {

		}
	}
}
