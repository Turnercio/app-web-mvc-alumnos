package io.keepcoding.app.web.alumnos.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.keepcoding.app.web.alumnos.entity.Usuario;
import io.keepcoding.app.web.alumnos.repository.UsuarioRepository;
import io.keepcoding.app.web.alumnos.service.UsuarioService;

@Service
public class UsuarioServiceimpl implements UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Override
    public Usuario guardarUsuario(Usuario usuario) {
        // Método para guardar un nuevo usuario en la base de datos
        return usuarioRepository.save(usuario);
    }

    @Override
    public Usuario obtenerUsuario(Long id) {
        // Método para obtener un usuario por su ID
        return usuarioRepository.findById(id).orElse(null);
    }

    @Override
    public List<Usuario> listaUsuario(String dato) {
        // Método que devuelve una lista de usuarios filtrados por nombre o todos si dato es nulo
        if (dato != null) {
            return usuarioRepository.filterName(dato);
        } else {
            return usuarioRepository.findAll();
        }
    }

    @Override
    public Usuario autenticarUsuario(String username, String pass) {
        // Método para autenticar un usuario por su username y contraseña
        List<Usuario> usuarios = usuarioRepository.findByUsernameAndPass(username, pass);
        if (usuarios.isEmpty()) {
            return null; // Retorna null si no se encuentra ningún usuario con las credenciales especificadas
        } else {
            return usuarios.get(0); // Retorna el primer usuario encontrado (asumiendo que los usernames son únicos)
        }
    }
}
