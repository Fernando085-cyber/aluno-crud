package com.seuprojeto.aluno_crud.Interface;

import com.seuprojeto.aluno_crud.Model.Aluno;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AlunoRepository extends JpaRepository<Aluno, Long> {
}
