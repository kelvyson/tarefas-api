package com.kelvyson.tarefas_api.repository;

import com.kelvyson.tarefas_api.model.Tarefa;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TarefaRepository extends JpaRepository<Tarefa, Long> {
}