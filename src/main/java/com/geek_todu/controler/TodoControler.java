package com.geek_todu.controler;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
//import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.geek_todu.services.TodoServices;
import com.geek_todu.services.models.Todo;

import jakarta.websocket.server.PathParam;

@RestController
public class TodoControler {

	@Autowired
	TodoServices todoServices; 
	
	
	
	//get me all the tudo in my present todolist
	
	@GetMapping(value="/getAllTodos")
	
	public List<Todo>getAlltodos(){
		
		return todoServices.getAllTodos();
		
	}
	
	@PostMapping( value="/addTodo")
	
	public String addTodo(@RequestBody Todo todo) {
		return todoServices.addMyTodo(todo);
		
	}
	
	
	@RequestMapping(value="/getById",method=RequestMethod.GET)
	
	public Todo getTodoById(@PathVariable String id) {
		
		return todoServices.getTodoBasedonId(id);
		
	}
	
	@DeleteMapping(value="/deleteTodoById/{id}")
	
	public String deleteById(@PathVariable String id) {
		
		return todoServices.removeTodoId(id);
		
		
	}
	
	@PutMapping(value="/updateById/{id}/{status}")
	
	public String updateById(@PathVariable String id ,@PathVariable String status) {
		
		return todoServices.updatebyId(id,status);
		
	}
	
	
	
	
}
