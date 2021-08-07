package com.frioui.todoproject;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class TodoprojectApplication {

	public static void main(String[] args) {
		SpringApplication.run(TodoprojectApplication.class, args);
		}
		/* on a ajouter les lignes de code ci-dessous pour initialiser notre base de données (H2) avec des exemples de données en utilisant l'interface 
		 * CommandLineRunner. Il est utilisé pour exécuter des morceaux de code spécifiques lorsqu'une application est complètement démarrée. 
		@Bean
		   public CommandLineRunner setup(ToDoRepository toDoRepository) {
		      return (args) -> {
		         toDoRepository.save(new ToDo("Premiere ligne de bdd", true));
		         toDoRepository.save(new ToDo("Deuxieme ligne de bdd", true));
		         toDoRepository.save(new ToDo("Troisieme ligne de bdd", false));
		      };
		       
		}*/

}
