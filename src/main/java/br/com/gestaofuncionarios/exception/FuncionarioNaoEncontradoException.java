package br.com.gestaofuncionarios.exception;

public class FuncionarioNaoEncontradoException
        extends RuntimeException {

    public FuncionarioNaoEncontradoException(Long id) {
        super("Funcionário não encontrado com ID: " + id);
    }
}