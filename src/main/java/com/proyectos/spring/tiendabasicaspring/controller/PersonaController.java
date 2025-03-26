package com.proyectos.spring.tiendabasicaspring.controller;

import com.proyectos.spring.tiendabasicaspring.model.Persona;
import com.proyectos.spring.tiendabasicaspring.service.PersonaService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

@Controller
@RequestMapping("/app/crud/persona")
public class PersonaController {

    private final PersonaService personaService;

    public PersonaController(PersonaService personaService) {
        this.personaService = personaService;
    }

    @GetMapping()
    public String mostrarPersonas(Model model){
        model.addAttribute("personas", personaService.findAllPersona());
        return "personas/lista";
    }

    @GetMapping("/nuevo")
    public String formularioNuevaPersona(Model model) {
        model.addAttribute("persona", new Persona());
        return "personas/formulario";
    }

    @PostMapping("/guardar")
    public String guardar(@ModelAttribute Persona persona, @RequestParam("imagen") MultipartFile file) throws IOException {
        // Si el usuario no subió una nueva imagen, mantener la actual
        if (file.isEmpty() && persona.getId() != null) {
            Persona personaExistente = personaService.findByIdPersona(persona.getId());
            if (personaExistente != null) {
                persona.setImagenUrl(personaExistente.getImagenUrl());
            }
        }
        else if (!file.isEmpty()) {
            // Obtener la ruta base del proyecto
            String baseDir = System.getProperty("user.dir");

            // Definir la carpeta donde se guardarán las imágenes dentro del proyecto
            String uploadDir = baseDir + File.separator + "uploads" + File.separator + "personas";

            //Crear la carpeta donde se guardaran las imagenes
            File uploadFolder = new File(uploadDir);
            if (!uploadFolder.exists()) {
                boolean created = uploadFolder.mkdirs();
                if (!created) {
                    throw new IOException("No se pudo crear el directorio: " + uploadDir);
                }
            }

            // Generar un nombre único para la imagen
            String fileName = System.currentTimeMillis() + "_" + file.getOriginalFilename();
            Path filePath = Paths.get(uploadDir, fileName);

            // Guardar la imagen en la carpeta
            file.transferTo(filePath.toFile());

            // Guardar la ruta relativa en la base de datos
            persona.setImagenUrl("/uploads/personas/" + fileName);
        }

        personaService.addPersona(persona);
        return "redirect:/app/crud/persona";
    }

    @GetMapping("/editar/{id}")
    public String editar(@PathVariable Long id, Model model) {
        model.addAttribute("persona", personaService.findByIdPersona(id));
        return "personas/formulario";
    }

    @GetMapping("/ver/{id}")
    public String buscarPorId(@PathVariable Long id, Model model){
        model.addAttribute("persona", personaService.findByIdPersona(id));
        return "personas/ver";
    }

    @GetMapping("/eliminar/{id}")
    public String eliminar(@PathVariable Long id) {
        //TODO: pongamamonos serios xd, ahora implementemos la logica de eliminar
        //todo: un registro junto la imagen asociada a este mismo :V
        Persona personaEncontrada = personaService.findByIdPersona(id);

        if (personaEncontrada != null){
            //todo Verificamos que la persona tenga una imagen asociada a el ;V
            if (personaEncontrada.getImagenUrl() != null){
                //creamos las rutas necesarias
                String rutaBase = System.getProperty("user.dir");
                Path filePath = Paths.get(rutaBase, personaEncontrada.getImagenUrl());
                //todo Convertimos esta ruta a un archivo 😅
                File file = filePath.toFile();
                if (file.exists()) {
                    file.delete();
                }
            }

            personaService.deletePersona(id);
        }
        return "redirect:/app/crud/persona";
    }
}
