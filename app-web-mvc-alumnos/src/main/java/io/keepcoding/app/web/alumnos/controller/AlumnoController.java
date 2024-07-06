package io.keepcoding.app.web.alumnos.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import io.keepcoding.app.web.alumnos.entity.Alumno;
import io.keepcoding.app.web.alumnos.service.AlumnoService;

@Controller
public class AlumnoController {

    // Inyección de dependencias del servicio de alumno
    @Autowired
    private AlumnoService alumnoService;
    
    // Método para manejar la solicitud GET a /alumnos
    // Muestra la lista de alumnos, posiblemente filtrada por un dato buscado
    @GetMapping("/alumnos")
    public String alumnosList(Model modelo, @Param("datoBuscado") String datoBuscado) {
        // Añade la lista de alumnos al modelo para que esté disponible en la vista
        modelo.addAttribute("alumno", alumnoService.listaAlumno(datoBuscado));
        // Devuelve el nombre de la vista "alumno" para mostrar la lista de alumnos
        return "alumno";
    }
    
    // Método para manejar la solicitud GET a /alumnos/crear_alumno
    // Muestra el formulario para crear un nuevo alumno
    @GetMapping("/alumnos/crear_alumno")
    public String newAlumnoForm(Model modelo) {
        // Crea una nueva instancia de Alumno y la añade al modelo
        Alumno alumno = new Alumno();
        modelo.addAttribute("alumno", alumno);
        // Devuelve el nombre de la vista "crear_alumno" para mostrar el formulario de creación
        return "crear_alumno";
    }
    
    // Método para manejar la solicitud POST a /alumnos
    // Guarda un nuevo alumno en la base de datos
    @PostMapping("/alumnos")
    public String saveAlumno(@ModelAttribute("alumno") Alumno alumno) {
        // Llama al servicio para guardar el nuevo alumno
        alumnoService.guardarAlumno(alumno);
        // Redirige a la lista de alumnos después de guardar
        return "redirect:/alumnos";
    }
    
}

