package br.com.gestaofuncionarios.repository;

import br.com.gestaofuncionarios.model.Funcionario;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public class FuncionarioRepositoryMap implements FuncionarioRepository {

    private final Map<Long, Funcionario> funcionarios = new HashMap<>();

    @Override
    public Funcionario salvar(Funcionario funcionario) {
        funcionarios.put(funcionario.getId(), funcionario);
        return funcionario;
    }

    @Override
    public Optional<Funcionario> buscarPorId(Long id) {
        return Optional.ofNullable(funcionarios.get(id));
    }

    @Override
    public List<Funcionario> listarTodos() {
        return new ArrayList<>(funcionarios.values());
    }

    @Override
    public void excluir(Long id) {
        funcionarios.remove(id);
    }
}
