
package br.com.gestaofuncionarios.service;

import br.com.gestaofuncionarios.model.Funcionario;
import br.com.gestaofuncionarios.repository.FuncionarioRepository;
import br.com.gestaofuncionarios.repository.GeradorId;

import java.math.BigDecimal;
import java.util.List;

public class FuncionarioService {

    private final FuncionarioRepository funcionarioRepository;
    private final GeradorId geradorId;

    public FuncionarioService(
            FuncionarioRepository funcionarioRepository,
            GeradorId geradorId) {
        this.funcionarioRepository = funcionarioRepository;
        this.geradorId = geradorId;
    }

    public Funcionario cadastrar(
            String nome,
            String designacao,
            BigDecimal salario,
            String telefone,
            String endereco) {

        Long id = geradorId.gerar();

        Funcionario funcionario = new Funcionario(
                id,
                nome,
                designacao,
                salario,
                telefone,
                endereco
        );

        return funcionarioRepository.salvar(funcionario);
    }

    public Funcionario buscarPorId(Long id) {
        return funcionarioRepository.buscarPorId(id)
                .orElseThrow(() ->
                        new RuntimeException(
                                "Funcionário não encontrado: " + id));
    }

    public List<Funcionario> listarTodos() {
        return funcionarioRepository.listarTodos();
    }

    public Funcionario atualizar(
            Long id,
            String nome,
            String designacao,
            BigDecimal salario,
            String telefone,
            String endereco) {

        Funcionario funcionario = buscarPorId(id);

        funcionario.atualizarDados(
                nome,
                designacao,
                salario,
                telefone,
                endereco
        );

        return funcionarioRepository.salvar(funcionario);
    }

    public void excluir(Long id) {
        buscarPorId(id);
        funcionarioRepository.excluir(id);
    }
}
