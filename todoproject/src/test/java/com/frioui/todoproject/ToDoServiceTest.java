package com.frioui.todoproject;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

/* La deuxieme couche que nous pouvons implémenter est la couche de service. c'est pour celà on a Créer un fichier 
 * ToDoServiceTest.java dans le dossier de test. */

@SpringBootTest
public class ToDoServiceTest {


	
    /* @MockBean
     * private ToDoRepository toDoRepository;
     * au début on a saisie cette notation. Mais sans la création de classe repository ToDoRepository.java Junit va afficher cette 
     * ERREUR 2: "private ToDoRepository toDoRepository;" pour vous dite que le ToDoRepository n'existe pas
     */
	@Autowired
    private ToDoRepository toDoRepository;
	/* Lors du test de la couche de service, nous nous sommes moqués (Mock) de ToDoRepository. Ainsi, nous ne savons pas si les données sont stockées 
	 * dans la base de données via le référentiel car nous ne les avons pas testées réellement. Maintenant, nous avons deux déclarations contradictoires. 
	 * La solution à celà est la suivante : nous ne simulerons pas le référentiel pendant le test de la couche de service. De cette façon, nous pouvons
	 * nous assurer que les données sont stockées dans la base de données et nous pouvons nous échapper du référentiel de test.
	 * C'est pour celà on a marquer todoRepository avec @Autowired plutôt que MockBean. */
    
    @Test
    void getAllToDos(){
        ToDo todoSample = new ToDo("Todo Sample 1",true);
        toDoRepository.save(todoSample);
        ToDoService toDoService = new ToDoService(toDoRepository);  /* Avant la création de constructeur ToDo(String text, boolean completed) cette ligne
                                                                       va affiché cet ERRUER 3: ToDoService toDoService = new ToDoService(toDoRepository); */
        /* List<ToDo> toDoList = toDoService.findAll();
        ToDo lastToDo = toDoList.get(toDoList.size()-1); */
        ToDo lastToDo = toDoService.findAll().get(0);

        assertEquals(todoSample.getText(), lastToDo.getText());
        assertEquals(todoSample.isCompleted(), lastToDo.isCompleted());
        assertEquals(todoSample.getId(), lastToDo.getId());
    }
}
