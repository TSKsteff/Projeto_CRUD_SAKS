package br.saks.register_services;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

import br.saks.register_services.events.KanbanFxMainApplication;
import javafx.application.Application;


@EnableScheduling
@SpringBootApplication
public class RegisterServicesApplication{

	public static void main(String[] args) {
		 Application.launch(KanbanFxMainApplication.class, args);
	}

}
