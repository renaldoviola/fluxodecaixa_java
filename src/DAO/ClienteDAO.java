package DAO;

import Objetos.Cliente;
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
public class ClienteDAO {
    
    private final int cod_cliente;
    private final String nome;
    private final int telefone;
    private final String email;
    private final String observacao;

    public ClienteDAO(int cod_cliente, String nome, int telefone, String email, String observacao) {
        this.cod_cliente = cod_cliente;
        this.nome = nome;
        this.telefone = telefone;
        this.email = email;
        this.observacao = observacao;
    }
    
    public static Cliente getCliente(int codCliente) throws SQLException, ClassNotFoundException {
        Cliente cliente = null;
        Connection conn = Conexao.getConnection();
        String sql = "SELECT * from clientes where cod_cliente = ? ";
        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setInt(1, codCliente);
        ResultSet rs = stmt.executeQuery();
        if(rs.next()){
            cliente = new Cliente();
            
            cliente.setCod_cliente(rs.getInt("cod_cliente"));
            cliente.setNome(rs.getString("nome"));
            cliente.setTelefone(rs.getInt("telefone"));
            cliente.setObservacao(rs.getString("observacao"));
            cliente.setEmail(rs.getString("email"));
            cliente.setObservacao(rs.getString("observacao"));
        }
        rs.close();
        stmt.close();
    
        return cliente;
    }
    
    public static List<Cliente> get() throws SQLException, ClassNotFoundException {
        List<Cliente> clientes = new ArrayList<Cliente>();
        Connection conn = Conexao.getConnection();
        String sql = "SELECT * from clientes ";
        PreparedStatement stmt = conn.prepareStatement(sql);
        ResultSet rs = stmt.executeQuery();
        while(rs.next()){
            Cliente cliente = new Cliente();
            
            cliente.setCod_cliente(rs.getInt("cod_cliente"));
            cliente.setNome(rs.getString("nome"));
            cliente.setTelefone(rs.getInt("telefone"));
            cliente.setObservacao(rs.getString("observacao"));
            cliente.setEmail(rs.getString("email"));
            cliente.setObservacao(rs.getString("observacao"));
            clientes.add(cliente);
        }
        rs.close();
        stmt.close();
    
        return clientes;
    }
    
    public static int inserir(Cliente cliente) throws SQLException, ClassNotFoundException{
        Connection conn = Conexao.getConnection();
        String sql = "INSERT INTO clientes ("
                + " nome, telefone, email, observacao)"
                + " VALUES (?, ?, ?, ?) ";
        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setString(1, cliente.getNome());
        stmt.setInt(2, cliente.getTelefone());
        stmt.setString(3, cliente.getEmail());
        stmt.setString(4, cliente.getObservacao());
        int qtdeAtualizado = stmt.executeUpdate();
        //conn.commit(); Não precisa de commit, está setado auto-commit.
        stmt.close();
        return qtdeAtualizado;
    }
    
    public static int atualizar(Cliente cliente) throws SQLException, ClassNotFoundException{
        Connection conn = Conexao.getConnection();
        
        String sql = "UPDATE clientes "
                + " SET nome = ?, telefone = ?, email = ?, observacao = ? "
                + " WHERE cod_cliente = ? ";
        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setString(1, cliente.getNome());
        stmt.setInt(2, cliente.getTelefone());
        stmt.setString(3, cliente.getEmail());
        stmt.setString(4, cliente.getObservacao());
        stmt.setInt(5, cliente.getCod_cliente());
        int qtdeAtualizado = stmt.executeUpdate();
        //conn.commit(); Não precisa de commit, está setado auto-commit.
        stmt.close();
        return qtdeAtualizado;
    }
    
    public static int excluir(Cliente cliente) throws SQLException, ClassNotFoundException{
        Connection conn = Conexao.getConnection();
        
        String sql = "DELETE from clientes "
                + " WHERE cod_cliente = ? ";
        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setInt(1, cliente.getCod_cliente());
        int qtdeAtualizado = stmt.executeUpdate();
        //conn.commit(); Não precisa de commit, está setado auto-commit.
        stmt.close();
        return qtdeAtualizado;
    }
}
