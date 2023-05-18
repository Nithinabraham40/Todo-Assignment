package com.geek_todu.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.geek_todu.services.models.Todo;

@Repository
public class TodoDao {
	
	private List<Todo>todoList;
	
	public TodoDao() {
		todoList=new ArrayList<>();
		//todoList.add(new Todo("0","dummy todo",true));
	}

	public List<Todo> getAllTodos() {
		
		return todoList;
	}

	public boolean addMytodo(Todo todo) {
		todoList.add(todo);
		return true;
		
	}

	public void removeById(Todo todu) {
		
		todoList.remove(todu);
		
		
	}

	public void updateInDoa(Todo todo, int i,String status) {
		
		todo.setTodoStatus(status);
		
	
		
		
	}

}
