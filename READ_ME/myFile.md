# Welcome to readme-md-generator &#x1F44B; 
![example workflow](https://img.shields.io/badge/Eclipse-Version%3A%202022--09%20(4.25.0)-orange)
![example workflow](https://img.shields.io/badge/SpringBoot-2.2.1-yellowgreen)
![example workflow](https://img.shields.io/badge/Java-8-yellowgreen)
![example workflow](https://img.shields.io/badge/Postman-v10.13-orange)
![example workflow](https://img.shields.io/badge/Documentation-Yes-green)
![example workflow](https://img.shields.io/badge/Manitained%3F-Yes-green)
 >CLI that generate beautiful **ReadME**.md files

  :house:  <b><span style="color: blue;">Homepage</span></b>
  


 # Prerequisties

 - **Eclipse >=4.55.0**
 - **Postman >=10.13**
 


# Install
```
Maven Install
SpringTool Install
```
 # Framework And Language

 - **Framework :  SpringBoot**
 - **Language :  Java**

 # Dependencies Required

 
 - **spring-boot-starter-web**
 - **spring-boot-devtools**
 
 - **spring-boot-starter-test**
 


# Model


```

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
	
	
```


#  Controller


```
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
	
```

#  Service


```

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
	
```


#  Repository


```
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


	
	
	


	
```

	
	


  


	







	



# DataStructure Used

<details>
<summary><b><span style="color: white;">Clickme</span></b> &#x1F4F2; </summary>

*ArrayList*



</details>



  




# Summary

 Spring boot todo project using arraylist us data structure .
These project will have the following features
**Post todo**,
**get todo**,
**update todo status**,
**get todo by id**,
**delete todo by id**
.






# :handshake:  Contributing
  Contributions,issues and features request are welcome! 
  

  #


  This *README* was generated with &#x2764;&#xFE0F; by <b><span style="color: blue;">readme-md-generator</span></b> 










   
  
  

