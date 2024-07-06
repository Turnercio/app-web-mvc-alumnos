package io.keepcoding.app.web.alumnos.service;

import java.util.List;

import io.keepcoding.app.web.alumnos.entity.Usuario;

public interface UsuarioService {

    // Método que devuelve una lista de Usuarios filtrados por un dato
    List<Usuario> listaUsuario(String dato);

    // Método para guardar un nuevo usuario en la base de datos
    Usuario guardarUsuario(Usuario usuario);

    // Método para obtener un usuario por su ID
    Usuario obtenerUsuario(Long id);

    // Método para autenticar un usuario por su username y contraseña
    Usuario autenticarUsuario(String username, String pass);

}
