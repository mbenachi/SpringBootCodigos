package com.codeinnova.BorradorSpringBoot.Controllers;

import com.codeinnova.BorradorSpringBoot.Entities.Codigo;
import com.codeinnova.BorradorSpringBoot.Repository.CodigoRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class CodigoController { // se debe crear un método que posteriormente se va a volver un JSON

        /*
        Lo que se está haciendo desde "private CodigoRepository codigoRepository;"
        hasta "public List<Codigo> findAll(){" es añadir la dependencia "codigoRepository" como un atributo a la
        clase CodigoController para poder acceder a el.
         */

    //Atributo
    private CodigoRepository codigoRepository;

    //Constructor

    public CodigoController(CodigoRepository codigoRepository) {
        this.codigoRepository = codigoRepository;
    }


    //CRUD DE LA ENTIDAD CODIGO:

    //1. Buscar todos los cogigos en DB (lista de codigos)

    @GetMapping("/api/codigos")
    public List<Codigo> findAll(){
        //Recuperar y devolver los codigos de la DB
        return codigoRepository.findAll();

    }

    //2. Buscar un cogigo en DB segun su ID

    @GetMapping("/api/codigos/{id}") // "id" es un parametro que varia

            // (Opción 1 --> no devuelve error "not found")
    /*
    public Codigo findOneById(@PathVariable Long id){ // @PathVariable vincula el parametro "id" que está posterior a "Long", con el parametro "id" del @GetMapping

        Optional<Codigo> codigoOptional = codigoRepository.findById(id);   //Se filtra el id devolviendo un objeto optional

        //Con el optional se puede verificar si existe el codigo o no:

            //Opción 1 (Se deja comentada para pder probar la opción 2):

//        if(codigoOptional.isPresent())
//            return codigoOptional.get();
//        else
//            return null;

            //Opcion 2:

        return codigoOptional.orElse(null);

    }
    }
     */

            //2.1 Opcion 2 de buscar un cogigo en DB segun su ID pero para que cuando se busque un codigo que no exista devuelva un error de "not found"

    public ResponseEntity<Codigo> findOneById(@PathVariable Long id) {
        //"ResponseEntity<>" es un tipo especial de dato framework para devolver respuestas HTTP
        Optional<Codigo> codigoOptional = codigoRepository.findById(id);

        if (codigoOptional.isPresent())
            return ResponseEntity.ok(codigoOptional.get());
        else
            return ResponseEntity.notFound().build();
    }

    //3. Crear un nuevo código en DB:

    @PostMapping("/api/codigos")
    public Codigo create(@RequestBody Codigo codigo){
        //Guardar el libro recibido por parametro en la base de datos
        return codigoRepository.save(codigo);

    }
    //4. Actualizar un codigo existente en DB
    //5. Borrar un libro en DB

}
