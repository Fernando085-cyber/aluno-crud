package Controller;

import Model.Aluno;
import Service.AlunoService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
//@RequestMapping("/alunos")
@RequestMapping
public class AlunoController {

    private final AlunoService service;

    public AlunoController(AlunoService service) {
        this.service = service;
    }

    @GetMapping
    public List<Aluno> listar() {
        return service.listarTodos();
    }

    @PostMapping
    public Aluno criar(@RequestBody Aluno aluno) {
        return service.salvar(aluno);
    }

    @GetMapping("/{id}")
    public Aluno buscar(@PathVariable Long id) {
        return service.buscarPorId(id);
    }

    @PutMapping("/{id}")
    public Aluno atualizar(@PathVariable Long id, @RequestBody Aluno novoAluno) {
        Aluno alunoExistente = service.buscarPorId(id);
        if (alunoExistente == null) return null;

        alunoExistente.setNome(novoAluno.getNome());
        alunoExistente.setEmail(novoAluno.getEmail());
        alunoExistente.setTelefone(novoAluno.getTelefone());
        return service.salvar(alunoExistente);
    }

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id) {
        service.deletar(id);
    }
}
