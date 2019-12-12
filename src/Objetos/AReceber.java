package Objetos;

import java.sql.Date;

/**
 *
 * @author Renaldo
 */
public class AReceber {
    
    private int cod_a_receber;
    private String descricao;
    private Date data_recebimento;
    private double valor;
    private String observacao;
    private int cod_categoria;
    private int cod_cliente;

    public int getCod_a_receber() {
        return cod_a_receber;
    }

    public void setCod_a_receber(int cod_a_receber) {
        this.cod_a_receber = cod_a_receber;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Date getData_recebimento() {
        return data_recebimento;
    }

    public void setData_recebimento(Date data_recebimento) {
        this.data_recebimento = data_recebimento;
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

    public int getCod_cliente() {
        return cod_cliente;
    }

    public void setCod_cliente(int cod_cliente) {
        this.cod_cliente = cod_cliente;
    }
    
    
}
