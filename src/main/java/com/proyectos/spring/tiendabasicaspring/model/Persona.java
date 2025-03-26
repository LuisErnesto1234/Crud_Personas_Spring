package com.proyectos.spring.tiendabasicaspring.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "persona")
@Getter
@Setter
public class Persona {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;
    private String apellido;
    private String correo;
    @Column(name = "fecha_nacimiento")
    private String fechaNacimiento;
    private int edad;
    @Column(name = "imagen_url") // Se almacena la ruta de la imagen
    private String imagenUrl;
}
