package com.frioui.todoproject;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class ToDoService {

	private ToDoRepository toDoRepository;

    public ToDoService(ToDoRepository toDoRepository) {
        this.toDoRepository = toDoRepository;
    }
	
    
    public List<ToDo> findAll() {
        return toDoRepository.findAll();
    }
	/* public List<ToDo> findAll() {
	    return new ArrayList<>();  //vide
	} */
}

