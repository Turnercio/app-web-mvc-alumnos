package io.keepcoding.app.web.alumnos.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.keepcoding.app.web.alumnos.entity.Alumno;
import io.keepcoding.app.web.alumnos.repository.AlumnoRepository;
import io.keepcoding.app.web.alumnos.service.AlumnoService;

@Service
public class AlumnoServiceimpl implements AlumnoService {

    @Autowired
    private AlumnoRepository alumnoRepository;

    @Override
    public Alumno guardarAlumno(Alumno alumno) {
        // Método para guardar un nuevo alumno en la base de datos
        return alumnoRepository.save(alumno);
    }

    @Override
    public Alumno obtenerAlumno(Long id) {
        // Método para obtener un alumno por su ID
        return alumnoRepository.findById(id).orElse(null);
    }

    @Override
    public List<Alumno> listaAlumno(String dato) {
        // Método que devuelve una lista de alumnos filtrados por nombre o todos si dato es nulo
        if (dato != null) {
            return alumnoRepository.filterName(dato);
        } else {
            return alumnoRepository.findAll();
        }
    }
}
