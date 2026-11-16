package br.com.gestaofuncionarios.repository;

import br.com.gestaofuncionarios.model.Funcionario;
import java.util.List;
import java.util.Optional;

public interface FuncionarioRepository {

    Funcionario salvar(Funcionario funcionario);

    Optional<Funcionario> buscarPorId(Long id);

    List<Funcionario> listarTodos();

    void excluir(Long id);
}
