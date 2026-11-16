package br.com.gestaofuncionarios.validation;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertThrows;

class FuncionarioValidatorTest {

    private final FuncionarioValidator validator =
            new FuncionarioValidator();

    @Test
    void deveRejeitarNomeVazio() {
        assertThrows(
                IllegalArgumentException.class,
                () -> validator.validarNome("")
        );
    }

    @Test
    void deveAceitarNomeValido() {
        org.junit.jupiter.api.Assertions.assertDoesNotThrow(
                () -> validator.validarNome("Maria Silva")
        );
    }

    @Test
    void deveRejeitarSalarioZero() {
        assertThrows(
                IllegalArgumentException.class,
                () -> validator.validarSalario(BigDecimal.ZERO)
        );
    }

    @Test
    void deveAceitarSalarioValido() {
        org.junit.jupiter.api.Assertions.assertDoesNotThrow(
                () -> validator.validarSalario(new BigDecimal("2500.00"))
        );
    }

    @Test
    void deveRejeitarTelefoneVazio() {
        assertThrows(
                IllegalArgumentException.class,
                () -> validator.validarTelefone("")
        );
    }

    @Test
    void deveAceitarTelefoneValido() {
        org.junit.jupiter.api.Assertions.assertDoesNotThrow(
                () -> validator.validarTelefone("74999999999")
        );
    }

    @Test
    void deveRejeitarEnderecoVazio() {
        assertThrows(
                IllegalArgumentException.class,
                () -> validator.validarEndereco("")
        );
    }

    @Test
    void deveAceitarEnderecoValido() {
        org.junit.jupiter.api.Assertions.assertDoesNotThrow(
                () -> validator.validarEndereco("Rua das Flores, 100")
        );
    }
}
