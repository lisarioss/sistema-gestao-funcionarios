package br.com.gestaofuncionarios.model;

import java.math.BigDecimal;

public class Funcionario {
    
    private Long id;
    private String nome;
    private String designacao;
    private BigDecimal salario;
    private String telefone;
    private String endereco;

    public Funcionario(
            Long id,
            String nome,
            String designacao,
            BigDecimal salario,
            String telefone,
            String endereco) {
        this.id = id;
        this.nome = nome;
        this.designacao = designacao;
        this.salario = salario;
        this.telefone = telefone;
        this.endereco = endereco;

        }

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getDesignacao() {
        return designacao;
    }

    public BigDecimal getSalario() {
        return salario;
    }

    public String getTelefone() {
        return telefone;
    }

    public String getEndereco() {
        return endereco;
    }

    public void atualizarDados(
        
            String nome,
            String designacao,
            BigDecimal salario,
            String telefone,
            String endereco) {
        this.nome = nome;
        this.designacao = designacao;
        this.salario = salario;
        this.telefone = telefone;
        this.endereco = endereco;
        }
}
