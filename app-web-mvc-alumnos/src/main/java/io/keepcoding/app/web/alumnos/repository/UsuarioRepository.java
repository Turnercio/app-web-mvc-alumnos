package io.keepcoding.app.web.alumnos.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import io.keepcoding.app.web.alumnos.entity.Usuario;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

    // Consulta personalizada para filtrar usuarios por nombre usando JPQL
    @Query("SELECT u FROM Usuario u WHERE u.nombre LIKE %:nombre%")
    public List<Usuario> filterName(String nombre);
    
    // Método de consulta automática generado por Spring Data JPA para buscar usuarios por nombre
    List<Usuario> findByNombre(String dato);
    
    // Método de consulta automática generado por Spring Data JPA para buscar usuarios por username y contraseña
    List<Usuario> findByUsernameAndPass(String username, String pass);

}
