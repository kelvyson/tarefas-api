package com.kelvyson.tarefas_api.controller;

import com.kelvyson.tarefas_api.model.Tarefa;
import com.kelvyson.tarefas_api.repository.TarefaRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tarefas")
public class TarefaController {

    private final TarefaRepository repository;

    public TarefaController(TarefaRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    public List<Tarefa> listar() {
        return repository.findAll();
    }

    @PostMapping
    public Tarefa criar(@RequestBody Tarefa tarefa) {
        return repository.save(tarefa);
    }

    @PutMapping("/{id}")
        public Tarefa atualizar(@PathVariable Long id, @RequestBody Tarefa novaTarefa) {
            return repository.findById(id)
             .map(tarefa -> {
                tarefa.setTitulo(novaTarefa.getTitulo());
                tarefa.setDescricao(novaTarefa.getDescricao());
                tarefa.setConcluida(novaTarefa.isConcluida());
                return repository.save(tarefa);
             })
            .orElseThrow();
}  @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id) {
        repository.deleteById(id);
}
}