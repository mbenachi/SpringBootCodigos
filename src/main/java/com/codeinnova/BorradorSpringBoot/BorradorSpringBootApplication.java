package com.codeinnova.BorradorSpringBoot;

import com.codeinnova.BorradorSpringBoot.Entities.Codigo;
import com.codeinnova.BorradorSpringBoot.Repository.CodigoRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.time.LocalDate;

@SpringBootApplication
public class BorradorSpringBootApplication {

	public static void main(String[] args) {

		ApplicationContext contex = SpringApplication.run(BorradorSpringBootApplication.class, args);
		CodigoRepository repository = contex.getBean(CodigoRepository.class);

	// CRUD

	// Crear un codigo

		Codigo codigo1 = new Codigo(null, "Codigo Penal", "Publico",500, 22.90, LocalDate.of(2024, 05, 01), true);
		Codigo codigo2 = new Codigo(null, "Codigo Laboral", "Publico",398, 22.90, LocalDate.of(2024, 05, 01), true);

	// Almacenar un codigo en al base de datos

		System.out.println("Numero de codigos en la base de datos: " + repository.findAll().size());

		repository.save(codigo1);
		repository.save(codigo2);

	// Recuperar todos los codigos

		System.out.println("Numero de codigos en la base de datos: " + repository.findAll().size());

	// Borrar un codigo

		//repository.deleteById(1L); //borrando el codigo 1
		//System.out.println("Numero de codigos en la base de datos: " + repository.findAll().size());
	}
}
