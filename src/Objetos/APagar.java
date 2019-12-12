
package Objetos;

import java.sql.Date;

/**
 *
 * @author Renaldo
 */
public class APagar {
    
    private int cod_a_pagar;
    private String descricao;
    private Date data_vencimento;
    private double valor;
    private String observacao;
    private int cod_categoria;
    private int cod_fornecedor;

    public int getCod_a_pagar() {
        return cod_a_pagar;
    }

    public void setCod_a_pagar(int cod_a_pagar) {
        this.cod_a_pagar = cod_a_pagar;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Date getData_vencimento() {
        return data_vencimento;
    }

    public void setData_vencimento(Date data_vencimento) {
        this.data_vencimento = data_vencimento;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public String getObservacao() {
        return observacao;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }

    public int getCod_categoria() {
        return cod_categoria;
    }

    public void setCod_categoria(int cod_categoria) {
        this.cod_categoria = cod_categoria;
    }

    public int getCod_fornecedor() {
        return cod_fornecedor;
    }

    public void setCod_fornecedor(int cod_fornecedor) {
        this.cod_fornecedor = cod_fornecedor;
    }
    
    
}
