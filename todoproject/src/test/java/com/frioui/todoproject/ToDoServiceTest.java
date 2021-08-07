package com.frioui.todoproject;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

/* La deuxieme couche que nous pouvons impl�menter est la couche de service. c'est pour cel� on a Cr�er un fichier 
 * ToDoServiceTest.java dans le dossier de test. */

@SpringBootTest
public class ToDoServiceTest {


	
    /* @MockBean
     * private ToDoRepository toDoRepository;
     * au d�but on a saisie cette notation. Mais sans la cr�ation de classe repository ToDoRepository.java Junit va afficher cette 
     * ERREUR 2: "private ToDoRepository toDoRepository;" pour vous dite que le ToDoRepository n'existe pas
     */
	@Autowired
    private ToDoRepository toDoRepository;
	/* Lors du test de la couche de service, nous nous sommes moqu�s (Mock) de ToDoRepository. Ainsi, nous ne savons pas si les donn�es sont stock�es 
	 * dans la base de donn�es via le r�f�rentiel car nous ne les avons pas test�es r�ellement. Maintenant, nous avons deux d�clarations contradictoires. 
	 * La solution � cel� est la suivante : nous ne simulerons pas le r�f�rentiel pendant le test de la couche de service. De cette fa�on, nous pouvons
	 * nous assurer que les donn�es sont stock�es dans la base de donn�es et nous pouvons nous �chapper du r�f�rentiel de test.
	 * C'est pour cel� on a marquer todoRepository avec @Autowired plut�t que MockBean. */
    
    @Test
    void getAllToDos(){
        ToDo todoSample = new ToDo("Todo Sample 1",true);
        toDoRepository.save(todoSample);
        ToDoService toDoService = new ToDoService(toDoRepository);  /* Avant la cr�ation de constructeur ToDo(String text, boolean completed) cette ligne
                                                                       va affich� cet ERRUER 3: ToDoService toDoService = new ToDoService(toDoRepository); */
        /* List<ToDo> toDoList = toDoService.findAll();
        ToDo lastToDo = toDoList.get(toDoList.size()-1); */
        ToDo lastToDo = toDoService.findAll().get(0);

        assertEquals(todoSample.getText(), lastToDo.getText());
        assertEquals(todoSample.isCompleted(), lastToDo.isCompleted());
        assertEquals(todoSample.getId(), lastToDo.getId());
    }
}
