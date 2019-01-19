package br.com.taskmanager.ws.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.taskmanager.ws.model.Task;

@Repository
public interface TaskRepository extends JpaRepository<Task, Integer> {

}
