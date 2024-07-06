package io.keepcoding.app.web.alumnos.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import io.keepcoding.app.web.alumnos.entity.Alumno;

@Repository
public interface AlumnoRepository extends JpaRepository<Alumno, Long> {

    // Consulta personalizada para filtrar alumnos por nombre usando JPQL
    @Query("SELECT a FROM Alumno a WHERE a.nombre LIKE %:nombre%")
    public List<Alumno> filterName(String nombre);
    
    // Método de consulta automática generado por Spring Data JPA para buscar alumnos por nombre
    List<Alumno> findByNombre(String dato);

}
