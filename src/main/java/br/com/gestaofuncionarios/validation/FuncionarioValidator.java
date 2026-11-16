package br.com.gestaofuncionarios.validation;

import java.math.BigDecimal;

public class FuncionarioValidator {

    public void validarNome(String nome) {
        if (nome == null || nome.isBlank()) {
            throw new IllegalArgumentException(
                    "O nome do funcionário é obrigatório."
            );
        }
    }

    public void validarSalario(BigDecimal salario) {
        if (salario == null ||
                salario.compareTo(BigDecimal.ZERO) <= 0) {
            throw new IllegalArgumentException(
                    "O salário deve ser maior que zero."
            );
        }
    }

    public void validarTelefone(String telefone) {
        if (telefone == null || telefone.isBlank()) {
            throw new IllegalArgumentException(
                    "O telefone do funcionário é obrigatório."
            );
        }
    }

    public void validarEndereco(String endereco) {
        if (endereco == null || endereco.isBlank()) {
            throw new IllegalArgumentException(
                    "O endereço do funcionário é obrigatório."
            );
        }
    }
}
