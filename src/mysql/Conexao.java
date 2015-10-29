package mysql;

import java.sql.*;

public class Conexao {
	Connection con;
	 Statement st;
	 public ResultSet rs;
	
	public Conexao(){
	}
	
	public Connection abrirBDCoon(){
		try{
			Class.forName("com.mysql.jdbc.Driver");
			String url = "jdbc:mysql://127.0.0.1/linkey";
			con = DriverManager.getConnection(url, "root", "" );
			System.out.println("Conectado! ");
			return con;
	}
		catch(Exception e){
			System.out.println("Erro ");
			e.printStackTrace();
			return null;
		}
	}
	
	public void fecharBDCoon(){
		try{
			con.close();
			System.out.println("Conex�o finalizada ");
		}catch (Exception e){
			System.out.println("Erro ao encerrar conex�o " + e.getMessage());
		}
	}
//	
//	public void executaSQL(String sql){
//		try{
//		st = con.createStatement(rs.TYPE_SCROLL_INSENSITIVE, rs.CONCUR_READ_ONLY);
//		rs = st.executeQuery(sql);
//		}catch (SQLException ex){
//			System.out.println("Erro de SQL " + ex.getMessage());
//		}
//				
//	}	

public int inserir( String query ) {
   
    int result = -1;
    
    try {
        st = this.con.createStatement();
        result = st.executeUpdate(query);
    } catch ( SQLException e ) {
        e.printStackTrace();
    }
    
    return result;
}
}
