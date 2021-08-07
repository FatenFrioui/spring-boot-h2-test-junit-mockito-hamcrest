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
	 on a saisie cette ligne au début puisque nous avons implémenté les couches Contrôleur, Service tout en suivant TDD.
	 Et après, on doit tester ToDoRepository , c'est pour celà, on doit déplacer par la ligne ci-dessous pour pouvoir implémenter ToDoRepository à l'intérieur.
	*/
    
    /* après la création de lignes ci-dessus et si on exécute le scénario de test, il lèvera une exception disant
     * Failures: java.lang.IllegalStateException: Failed to load ApplicationContext ...
     * C'est parce qu'Hibernate est incapable d'interagir avec notre entité. Pour le faire interagir : créez des constructeurs et des getters-setters 
     * par défaut et paramétrés pour les deux champs. Créez un identifiant de clé primaire qui est généré à chaque fois par le JPA.*/
    
    public List<ToDo> findAll() { return toDoRepository.findAll();  }
	
}

