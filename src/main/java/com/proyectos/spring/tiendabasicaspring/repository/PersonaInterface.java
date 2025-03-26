package com.proyectos.spring.tiendabasicaspring.repository;

import com.proyectos.spring.tiendabasicaspring.model.Persona;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonaInterface extends JpaRepository<Persona, Long> {
}
