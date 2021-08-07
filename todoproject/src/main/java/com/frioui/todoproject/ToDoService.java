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
	
    /* public List<ToDo> findAll() {  return new ArrayList<>();   } 
	 on a saisie cette ligne au d�but puisque nous avons impl�ment� les couches Contr�leur, Service tout en suivant TDD.
	 Et apr�s, on doit tester ToDoRepository , c'est pour cel�, on doit d�placer par la ligne ci-dessous pour pouvoir impl�menter ToDoRepository � l'int�rieur.
	*/
    
    /* apr�s la cr�ation de lignes ci-dessus et si on ex�cute le sc�nario de test, il l�vera une exception disant
     * Failures: java.lang.IllegalStateException: Failed to load ApplicationContext ...
     * C'est parce qu'Hibernate est incapable d'interagir avec notre entit�. Pour le faire interagir : cr�ez des constructeurs et des getters-setters 
     * par d�faut et param�tr�s pour les deux champs. Cr�ez un identifiant de cl� primaire qui est g�n�r� � chaque fois par le JPA.*/
    
    public List<ToDo> findAll() { return toDoRepository.findAll();  }
	
}

