
package br.com.gestaofuncionarios.service;

import br.com.gestaofuncionarios.exception.FuncionarioNaoEncontradoException;
import br.com.gestaofuncionarios.model.Funcionario;
import br.com.gestaofuncionarios.repository.FuncionarioRepositoryMap;
import br.com.gestaofuncionarios.repository.GeradorId;
import br.com.gestaofuncionarios.validation.FuncionarioValidator;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class FuncionarioServiceTest {

    private FuncionarioRepositoryMap repository;
    private GeradorId geradorId;
    private FuncionarioValidator validator;
    private FuncionarioService service;

    @BeforeEach
    void configurar() {
        repository = new FuncionarioRepositoryMap();
        geradorId = new GeradorId();
        validator = new FuncionarioValidator();

        service = new FuncionarioService(
                repository,
                geradorId,
                validator
        );
    }

    @Test
    void deveCadastrarFuncionarioComSucesso() {
        Funcionario funcionario = service.cadastrar(
                "Maria Silva",
                "Desenvolvedora",
                new BigDecimal("4500.00"),
                "74999999999",
                "Rua das Flores, 100"
        );

        assertNotNull(funcionario);
        assertEquals(1L, funcionario.getId());
        assertEquals("Maria Silva", funcionario.getNome());
        assertEquals(1, repository.listarTodos().size());
    }

    @Test
    void naoDeveCadastrarFuncionarioComNomeVazio() {
        assertThrows(
                IllegalArgumentException.class,
                () -> service.cadastrar(
                        "",
                        "Desenvolvedora",
                        new BigDecimal("4500.00"),
                        "74999999999",
                        "Rua das Flores, 100"
                )
        );

        assertEquals(0, repository.listarTodos().size());
    }

    @Test
    void deveBuscarFuncionarioPorId() {
        Funcionario cadastrado = service.cadastrar(
                "Maria Silva",
                "Desenvolvedora",
                new BigDecimal("4500.00"),
                "74999999999",
                "Rua das Flores, 100"
        );

        Funcionario encontrado =
                service.buscarPorId(cadastrado.getId());

        assertNotNull(encontrado);
        assertEquals(cadastrado.getId(), encontrado.getId());
        assertEquals("Maria Silva", encontrado.getNome());
    }

    @Test
    void deveLancarExcecaoAoBuscarFuncionarioInexistente() {
        assertThrows(
                FuncionarioNaoEncontradoException.class,
                () -> service.buscarPorId(999L)
        );
    }

    @Test
    void deveListarTodosOsFuncionarios() {
        service.cadastrar(
                "Maria Silva",
                "Desenvolvedora",
                new BigDecimal("4500.00"),
                "74999999999",
                "Rua das Flores, 100"
        );

        service.cadastrar(
                "João Santos",
                "Analista",
                new BigDecimal("3500.00"),
                "74988888888",
                "Rua Central, 200"
        );

        List<Funcionario> funcionarios = service.listarTodos();

        assertEquals(2, funcionarios.size());
    }

    @Test
    void deveAtualizarFuncionarioSemAlterarId() {
        Funcionario cadastrado = service.cadastrar(
                "Maria Silva",
                "Desenvolvedora",
                new BigDecimal("4500.00"),
                "74999999999",
                "Rua das Flores, 100"
        );

        Long idOriginal = cadastrado.getId();

        Funcionario atualizado = service.atualizar(
                idOriginal,
                "Maria Santos",
                "Desenvolvedora Senior",
                new BigDecimal("6000.00"),
                "74988888888",
                "Rua Central, 200"
        );

        assertEquals(idOriginal, atualizado.getId());
        assertEquals("Maria Santos", atualizado.getNome());
        assertEquals(new BigDecimal("6000.00"), atualizado.getSalario());
    }

    @Test
    void naoDeveAtualizarFuncionarioInexistente() {
        assertThrows(
                FuncionarioNaoEncontradoException.class,
                () -> service.atualizar(
                        999L,
                        "Maria Silva",
                        "Desenvolvedora",
                        new BigDecimal("4500.00"),
                        "74999999999",
                        "Rua das Flores, 100"
                )
        );
    }

    @Test
    void naoDeveAtualizarFuncionarioComSalarioInvalido() {
        Funcionario cadastrado = service.cadastrar(
                "Maria Silva",
                "Desenvolvedora",
                new BigDecimal("4500.00"),
                "74999999999",
                "Rua das Flores, 100"
        );

        assertThrows(
                IllegalArgumentException.class,
                () -> service.atualizar(
                        cadastrado.getId(),
                        "Maria Santos",
                        "Desenvolvedora Senior",
                        BigDecimal.ZERO,
                        "74988888888",
                        "Rua Central, 200"
                )
        );

        assertEquals("Maria Silva", cadastrado.getNome());
        assertEquals(new BigDecimal("4500.00"), cadastrado.getSalario());
    }

    @Test
    void deveExcluirFuncionario() {
        Funcionario cadastrado = service.cadastrar(
                "Maria Silva",
                "Desenvolvedora",
                new BigDecimal("4500.00"),
                "74999999999",
                "Rua das Flores, 100"
        );

        service.excluir(cadastrado.getId());

        assertEquals(0, repository.listarTodos().size());
    }

    @Test
    void naoDeveExcluirFuncionarioInexistente() {
        assertThrows(
                FuncionarioNaoEncontradoException.class,
                () -> service.excluir(999L)
        );
    }
}

