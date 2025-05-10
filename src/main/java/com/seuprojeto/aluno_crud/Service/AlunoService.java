package com.seuprojeto.aluno_crud.Service;

import com.seuprojeto.aluno_crud.Interface.AlunoRepository;
import com.seuprojeto.aluno_crud.Model.Aluno;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AlunoService {

    private final AlunoRepository repository;

    public AlunoService(AlunoRepository repository) {
        this.repository = repository;
    }

    public List<Aluno> listarTodos() {
        return repository.findAll();
    }

    public Aluno salvar(Aluno aluno) {
        return repository.save(aluno);
    }

    public void deletar(Long id) {
        repository.deleteById(id);
    }

    public Aluno buscarPorId(Long id) {
        return repository.findById(id).orElse(null);
    }
}