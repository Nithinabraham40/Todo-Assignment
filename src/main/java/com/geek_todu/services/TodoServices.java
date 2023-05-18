package com.geek_todu.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.geek_todu.repository.TodoDao;
import com.geek_todu.services.models.Todo;

@Service
public class TodoServices {
	
	@Autowired
	TodoDao todoDao;

	public List<Todo> getAllTodos() {
		
		return todoDao.getAllTodos();
	}

	public String addMyTodo(Todo todo) {
		boolean insertionStatus=todoDao.addMytodo(todo);
		if(insertionStatus) {
			return "Todo added sucessfully";
		}
		return "Failed!!Not Possible";
	}

	public Todo getTodoBasedonId(String id) {
		// TODO Auto-generated method stub
		List <Todo>todorightNow=getAllTodos();
		for(Todo todo:todorightNow) {
			
			if(todo.getId().equals(id)) {
				return todo;
			}
		}return null;
	}

//	public String removeTodoId(String id) {
//		boolean response=false;
//		String status;
//		if(id!=null) {
//			List<Todo>todoRightNow=todoDao.getAllTodos();
//			for(Todo todo:todoRightNow) {
//				if(todo.getId().equals(id)) {
//					
//					todoDao.removeById(todo);
//					if(response) {
//						return status="todo eith id"+id+" "+"deleted";
//					}
//				}
//			}return status="Not found todo with id"+" "+id;
//		}return "id is null";
//	}

	public String removeTodoId(String id) {
		boolean response=false;
		String status;
		if(id!=null) {
			List<Todo>todoRightNow=todoDao.getAllTodos();
			for(Todo todo:todoRightNow) {
				if(todo.getId().equals(id)) {
					
					todoDao.removeById(todo);
					if(response) {
						return status="todo eith id"+id+" "+"deleted";
					}
				}
			}return status="Not found todo with id"+" "+id;
		}return "id is null";
	}

	public String updatebyId(String id,String status) {
		
		if(id!=null) {
			
			List<Todo>current=todoDao.getAllTodos();
			
			for(int i=0;i<current.size();i++) {
				
				if(current.get(i).getId().equals(id)) {
					
					todoDao.updateInDoa(current.get(i),i,status);
					return "update happend";
				}
				
			}return "id not found";
			
			
		}else {
			
			return "id is null";
		}
	}

}
