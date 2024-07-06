package io.keepcoding.app.web.alumnos.service;

import java.util.List;

import io.keepcoding.app.web.alumnos.entity.Alumno;

public interface AlumnoService {

    // Método que devuelve una lista de Alumnos filtrados por un dato
    List<Alumno> listaAlumno(String dato);

    // Método para guardar un nuevo alumno en la base de datos
    Alumno guardarAlumno(Alumno alumno);

    // Método para obtener un alumno por su ID
    Alumno obtenerAlumno(Long id);

}
