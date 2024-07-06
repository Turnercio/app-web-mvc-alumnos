package io.keepcoding.app.web.alumnos.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import io.keepcoding.app.web.alumnos.entity.Usuario;
import io.keepcoding.app.web.alumnos.service.UsuarioService;

@Controller
public class UsuarioController {

    // Inyección de dependencias del servicio de usuario
    @Autowired
    private UsuarioService usuarioService;
        
    // Método para manejar la solicitud GET a /usuarios
    // Muestra la lista de usuarios, posiblemente filtrada por un dato buscado
    @GetMapping("/usuarios")
    public String usuariosList(Model modelo, @Param("datoBuscado") String datoBuscado) {
        // Añade la lista de usuarios al modelo para que esté disponible en la vista
        modelo.addAttribute("usuario", usuarioService.listaUsuario(datoBuscado));
        // Devuelve el nombre de la vista "usuario" para mostrar la lista de usuarios
        return "usuario";
    }

    // Método para manejar la solicitud GET a / y /login
    // Muestra la página de login
    @GetMapping({"/", "/login"})
    public String index(Model modelo) {
        // Añade una nueva instancia de Usuario al modelo para el formulario de login
        modelo.addAttribute("usuario", new Usuario());
        // Devuelve el nombre de la vista "login" para mostrar la página de login
        return "login";
    }

    // Método para manejar la solicitud POST a /login
    // Procesa el formulario de login
    @PostMapping("/login")
    public String manejoLogin(@ModelAttribute("usuario") Usuario usuario, Model modelo) {
        // Autentica al usuario llamando al servicio de usuario
        Usuario usuarioAutenticado = usuarioService.autenticarUsuario(usuario.getUsername(), usuario.getPass());
        if (usuarioAutenticado != null) {
            // Redirige a la vista de alumnos si la autenticación es exitosa
            return "redirect:/alumnos";
        } else {
            // Añade el usuario y un mensaje de error al modelo si la autenticación falla
            modelo.addAttribute("usuario", usuario);
            modelo.addAttribute("error", "Nombre de usuario o contraseña incorrectos");
            // Devuelve el nombre de la vista "login" para permanecer en la página de login
            return "login";
        }
    }

    // Método para manejar la solicitud GET a /usuarios/crear_usuario
    // Muestra el formulario para crear un nuevo usuario
    @GetMapping("/usuarios/crear_usuario")
    public String newUsuarioForm(Model modelo) {
        // Crea una nueva instancia de Usuario y la añade al modelo
        Usuario usuario = new Usuario();
        modelo.addAttribute("usuario", usuario);
        // Devuelve el nombre de la vista "crear_usuario" para mostrar el formulario de creación
        return "crear_usuario";
    }

    // Método para manejar la solicitud POST a /usuarios/crear_usuario
    // Guarda un nuevo usuario en la base de datos
    @PostMapping("/usuarios/crear_usuario")
    public String guardarUsuario(@ModelAttribute("usuario") Usuario usuario) {
        // Llama al servicio para guardar el nuevo usuario
        usuarioService.guardarUsuario(usuario);
        // Redirige a la lista de usuarios después de guardar
        return "redirect:/usuarios";
    }

}
