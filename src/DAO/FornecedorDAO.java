package DAO;

import Objetos.Fornecedor;
import conexao.Conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Renaldo
 */
public class FornecedorDAO {
    
    private final int cod_fornecedor;
    private final String nome;
    private final int telefone;
    private final String email;
    private final String observacao;

    public FornecedorDAO(int cod_fornecedor, String nome, int telefone, String email, String observacao) {
        this.cod_fornecedor = cod_fornecedor;
        this.nome = nome;
        this.telefone = telefone;
        this.email = email;
        this.observacao = observacao;
    }
    
    
    public static List<Fornecedor> get() throws SQLException, ClassNotFoundException {
        List<Fornecedor> fornecedores = new ArrayList<Fornecedor>();
        Connection conn = Conexao.getConnection();
        String sql = "SELECT * from fornecedores ";
        PreparedStatement stmt = conn.prepareStatement(sql);
        ResultSet rs = stmt.executeQuery();
        while(rs.next()){
            Fornecedor fornecedor = new Fornecedor();
            
            fornecedor.setCod_fornecedor(rs.getInt("cod_fornecedor"));
            fornecedor.setNome(rs.getString("nome"));
            fornecedor.setTelefone(rs.getInt("telefone"));
            fornecedor.setObservacao(rs.getString("observacao"));
            fornecedor.setEmail(rs.getString("email"));
            fornecedor.setObservacao(rs.getString("observacao"));
            fornecedores.add(fornecedor);
        }
        rs.close();
        stmt.close();
    
        return fornecedores;
    }
    
    public static int inserir(Fornecedor fornecedor) throws SQLException, ClassNotFoundException{
        Connection conn = Conexao.getConnection();
        String sql = "INSERT INTO fornecedores ("
                + " nome, telefone, email, observacao)"
                + " VALUES (?, ?, ?, ?) ";
        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setString(1, fornecedor.getNome());
        stmt.setInt(2, fornecedor.getTelefone());
        stmt.setString(3, fornecedor.getEmail());
        stmt.setString(4, fornecedor.getObservacao());
        int qtdeAtualizado = stmt.executeUpdate();
        stmt.close();
        return qtdeAtualizado;
    }
    
    public static int atualizar(Fornecedor fornecedor) throws SQLException, ClassNotFoundException{
        Connection conn = Conexao.getConnection();
        
        String sql = "UPDATE fornecedores "
                + " SET nome = ?, telefone = ?, email = ?, observacao = ? "
                + " WHERE cod_fornecedor = ? ";
        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setString(1, fornecedor.getNome());
        stmt.setInt(2, fornecedor.getTelefone());
        stmt.setString(4, fornecedor.getEmail());
        stmt.setString(5, fornecedor.getObservacao());
        stmt.setInt(6, fornecedor.getCod_fornecedor());
        int qtdeAtualizado = stmt.executeUpdate();
        stmt.close();
        return qtdeAtualizado;
    }
    
    public static int excluir(Fornecedor fornecedor) throws SQLException, ClassNotFoundException{
        Connection conn = Conexao.getConnection();
        
        String sql = "DELETE from fornecedores "
                + " WHERE cod_fornecedor = ? ";
        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setInt(1, fornecedor.getCod_fornecedor());
        int qtdeAtualizado = stmt.executeUpdate();
        stmt.close();
        return qtdeAtualizado;
    }
}
