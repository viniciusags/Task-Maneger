package br.com.taskmanager.ws.service;

import java.util.Collection;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.taskmanager.ws.model.Task;
import br.com.taskmanager.ws.repository.TaskRepository;

@Service
public class TaskService {
	
	@Autowired
	TaskRepository taskRepository;
	
	
	
	//methods
	public Task register(Task task) {
	
		return taskRepository.save(task);
	}
	
	public Collection<Task> searchall(){
		return taskRepository.findAll();
	}
	
	public void deleteTask(Task task){
		taskRepository.delete(task);
	}
	
	public Task searchforId(Integer id) {
		return taskRepository.findOne(id);
	}
	
	public Task changeTask(Task task) {
		return taskRepository.save(task);
	}
}
