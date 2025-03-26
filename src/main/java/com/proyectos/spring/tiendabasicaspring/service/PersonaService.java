package com.proyectos.spring.tiendabasicaspring.service;

import com.proyectos.spring.tiendabasicaspring.model.Persona;
import com.proyectos.spring.tiendabasicaspring.repository.PersonaInterface;
import org.springframework.stereotype.Service;

import java.time.Period;
import java.util.Collections;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class PersonaService {

    private final PersonaInterface personaInterface;

    public PersonaService(PersonaInterface personaInterface) {
        this.personaInterface = personaInterface;
    }

    public List<Persona> findAllPersona(){
        return Collections.unmodifiableList(personaInterface.findAll());
    }

    public void deletePersona(Long id){
        personaInterface.deleteById(id);
    }

    public void addPersona(Persona persona){
        //TODO: calculando edad
        LocalDate fechaNacimiento = LocalDate.parse(persona.getFechaNacimiento());
        int periodo = Period.between(fechaNacimiento, LocalDate.now()).getYears();
        persona.setEdad(periodo);
        /*TODO: talvez no se entienda porque no hay un metodo para actualizar y solo existe el de
        *  guardar esto tiene respuesta y es porque JPA junto a Spring, razonan sobre si usar INSERT O UPDATE
        *   pero a partir de que deciden eso?, pues si el id del objeto es null, entonces se usara
        *   INSERT pero si el ID es != (diferente) de null, se usara UPDATE*/
        personaInterface.save(persona);
    }

    public Persona findByIdPersona(Long id){
        return personaInterface.findById(id).orElseThrow();
    }
}
