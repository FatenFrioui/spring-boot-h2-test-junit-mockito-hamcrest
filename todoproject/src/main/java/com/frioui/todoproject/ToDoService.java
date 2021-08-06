package com.frioui.todoproject;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
class ToDoService {
	public List<ToDo> findAll() {
	    return new ArrayList<>();
	}
}
