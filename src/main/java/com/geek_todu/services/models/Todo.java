package com.geek_todu.services.models;

import lombok.Data;


public class Todo {
	
	
	private String id;
	private String todoName;
	private String todoStatus;
	
	public Todo(String id, String todoName, String todoStatus) {
		super();
		this.id = id;
		this.todoName = todoName;
		this.todoStatus = todoStatus;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getTodoName() {
		return todoName;
	}

	public void setTodoName(String todoName) {
		this.todoName = todoName;
	}

	public String getTodoStatus() {
		return todoStatus;
	}

	public void setTodoStatus(String todoStatus) {
		this.todoStatus = todoStatus;
	}
	
	
	
	
	
	
	

}
