package io.keepcoding.app.web.alumnos.entity;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="usuario")
public class Usuario implements Serializable {

    // Identificador único para cada usuario, autogenerado
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    
    // Columna no nula con longitud máxima de 60 caracteres para el nombre del usuario
    @Column(nullable = false, length = 60)
    private String nombre;
    
    // Columna para el email del usuario
    private String email;
    
    // Columna no nula con longitud máxima de 60 caracteres para el nombre de usuario
    @Column(nullable = false, length = 60)
    private String username;
    
    // Columna no nula con longitud máxima de 60 caracteres para la contraseña del usuario
    @Column(nullable = false, length = 60)
    private String pass;
    
    // Columna no nula para indicar si el usuario está activo, por defecto es true
    @Column(nullable = false)
    private Boolean activo = true;
    
    // Métodos getters y setters
    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }
    public String getPass() {
        return pass;
    }
    public void setPass(String pass) {
        this.pass = pass;
    }
    public Boolean getActivo() {
        return activo;
    }
    public void setActivo(Boolean activo) {
        this.activo = activo;
    }

    // Identificador de serialización
    private static final long serialVersionUID = 1L;
}
