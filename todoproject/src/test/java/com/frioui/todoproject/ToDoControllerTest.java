package com.frioui.todoproject;



import org.junit.jupiter.api.Test;

import org.junit.jupiter.api.extension.ExtendWith;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;

import org.springframework.boot.test.mock.mockito.MockBean;

import org.springframework.test.context.junit.jupiter.SpringExtension;

import org.springframework.test.web.servlet.MockMvc;

import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;



import static org.mockito.Mockito.when;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.MediaType;

import static org.hamcrest.Matchers.*;



@ExtendWith(SpringExtension.class)
@WebMvcTest
class ToDoControllerTest {

    @Autowired
    MockMvc mockMvc;

    @MockBean
    private ToDoService toDoService;
    
    @Test
    void getAllToDos() throws Exception {
    	List<ToDo> toDoList = new ArrayList<ToDo>();
        toDoList.add(new ToDo(1L,"Eat thrice",true));
        toDoList.add(new ToDo(2L,"Sleep Twice",true));
        when(toDoService.findAll()).thenReturn(toDoList);

        mockMvc.perform(MockMvcRequestBuilders.get("/todos")
                .contentType(MediaType.APPLICATION_JSON)
        ).andExpect(jsonPath("$", hasSize(2))).andDo(print());
    } 
    
}



