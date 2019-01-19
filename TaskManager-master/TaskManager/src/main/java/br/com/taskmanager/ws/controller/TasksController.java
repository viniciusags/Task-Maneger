package br.com.taskmanager.ws.controller;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.taskmanager.ws.model.Task;
import br.com.taskmanager.ws.service.TaskService;

@RestController
public class TasksController {
	
	@Autowired
	TaskService taskService;


	//end points
	
	@RequestMapping(method=RequestMethod.POST, value="/tasks", consumes=MediaType.APPLICATION_JSON_VALUE) 	
	public ResponseEntity<Task> registerTask(@RequestBody Task task) {
		
		Task taskregister =  taskService.register(task);
		
		return new ResponseEntity<>(taskregister, HttpStatus.CREATED);
	}
	
	@RequestMapping(method=RequestMethod.GET, value="/tasks", produces=MediaType.APPLICATION_JSON_VALUE) 	
	public ResponseEntity<Collection<Task>> searchallTask() {
		
		Collection<Task> tasksfound = taskService.searchall();
		
		return new ResponseEntity<>(tasksfound, HttpStatus.OK);
	}
	
	@RequestMapping(method=RequestMethod.DELETE, value="/tasks/{id}") 	
	public ResponseEntity<Task> deleteTask(@PathVariable Integer id) {
		
		Task foundTask = taskService.searchforId(id);
		
		if(foundTask==null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		
		taskService.deleteTask(foundTask);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	@RequestMapping(method=RequestMethod.PUT, value="/tasks", consumes=MediaType.APPLICATION_JSON_VALUE) 	
	public ResponseEntity<Task> change(@RequestBody Task task) {
		
		Task alteredTask =  taskService.changeTask(task);
		
		return new ResponseEntity<>(alteredTask, HttpStatus.OK);
	}

	

}
