package com.frioui.todoproject;

import java.util.ArrayList;
import java.util.List;

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
import org.springframework.http.MediaType;
import static org.hamcrest.Matchers.*;

@ExtendWith(SpringExtension.class)
@WebMvcTest
class ToDoControllerTest {

	
    @Autowired   
    MockMvc mockMvc;
    /* Nous avons besoin d'un objet mockMvc.
     * et Spring a une annotation magique appel�e Autowired. Fondamentalement,Spring a un ApplicationContext o� il stocke d�j�
     * les objets des classes qui sont marqu�s d'annotations telles que Service, Component, etc. Chaque fois que vous avez
     * besoin d'objets de ces classes, utilisez Autowired, il vous les donnera.*/

    
    @MockBean
    private ToDoService toDoService;
    /* Dans les tests unitaires, nous voulons que chaque module soit test� ind�pendamment. 
     * Mais, notre contr�leur d�pend de la couche Service. �tant donn� que nous nous concentrons uniquement sur le code
     *  du contr�leur, il est naturel de se MOCK du code de la couche Service pour nos tests unitaires. */
    
    @Test
    void getAllToDos() throws Exception {
        List<ToDo> toDoList = new ArrayList<ToDo>();
        toDoList.add(new ToDo(1L,"Eat thrice",true));
        toDoList.add(new ToDo(2L,"Sleep Twice",true));
        when(toDoService.findAll()).thenReturn(toDoList); // si on appel todoservice findall() alors il appel les 2 todolist de test

        mockMvc.perform(MockMvcRequestBuilders.get("/todos")
                .contentType(MediaType.APPLICATION_JSON)  //return erreur 500
        ).andExpect(jsonPath("$", hasSize(2))).andDo(print()); // 2 car au simulation on a fait 2 champs, erreur faillures
    }
    
    /*ERREUR1: sans la cr�ation de la classe ToDoController.java , le test va affich� cette erreur:
     * java.lang.AssertionError: No value at JSON path �$�  */
}

/* 
 * Commen�ons par la premi�re couche, c'est-�-dire le contr�leur. Cr�ez un ToDoControllerTest.java dans le dossier de test.
 *  N'oubliez pas TDD ! Nous devons commencer par un test. Nous devons enregistrer cette classe en tant que classe de test 
 *  de Spring qui teste un contr�leur MVC. Pour cela, nous devons marquer cette classe avec deux annotations 
 *  Extendwith et WebMVCTest.
 * */
