package br.com.gestaofuncionarios.repository;

import br.com.gestaofuncionarios.model.Funcionario;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

class FuncionarioRepositoryMapTest {

    private FuncionarioRepositoryMap repository;
    private Funcionario funcionario;

    @BeforeEach
    void configurar() {
        repository = new FuncionarioRepositoryMap();

        funcionario = new Funcionario(
                1L,
                "Maria Silva",
                "Desenvolvedora",
                new BigDecimal("4500.00"),
                "74999999999",
                "Rua das Flores, 100"
        );
    }

    @Test
    void deveSalvarFuncionario() {
        Funcionario salvo = repository.salvar(funcionario);

        assertNotNull(salvo);
        assertEquals(1L, salvo.getId());
    }

    @Test
    void deveBuscarFuncionarioPorId() {
        repository.salvar(funcionario);

        Optional<Funcionario> encontrado =
                repository.buscarPorId(1L);

        assertTrue(encontrado.isPresent());
        assertEquals("Maria Silva", encontrado.get().getNome());
    }

    @Test
    void deveRetornarVazioQuandoFuncionarioNaoExistir() {
        Optional<Funcionario> encontrado =
                repository.buscarPorId(999L);

        assertTrue(encontrado.isEmpty());
    }

    @Test
    void deveExcluirFuncionario() {
        repository.salvar(funcionario);

        repository.excluir(1L);

        assertTrue(repository.buscarPorId(1L).isEmpty());
    }
}
