package conexao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class Conexao {
    
    private Connection conn = null;
    private PreparedStatement st = null;
    private CallableStatement cst = null;
    private ResultSet rs = null;
    private String field = null;
    
    public static Connection getConnection() throws SQLException, ClassNotFoundException {
        Connection conn = null;
        try {
            // Carregando o JDBC Driver
            Class.forName("com.mysql.jdbc.Driver");
            
            // Criando a conexão com o Banco de Dados
            String url = "jdbc:mysql://localhost:3306/fluxodecaixa?serverTimezone=UTC";
            String username = "root";
            String password = "root";

            conn = DriverManager.getConnection(url, username, password);

        }catch (SQLException e) {
            //Não está conseguindo se conectar ao banco 
            System.out.println("Não foi possível conectar ao Banco de Dados: "+e.getMessage()); 
        }
        return conn;
    }
}