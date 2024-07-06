package io.keepcoding.app.web.alumnos.entity;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="alumno")
public class Alumno implements Serializable{

    // Identificador único para cada alumno, autogenerado
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    
    // Columna no nula con longitud máxima de 25 caracteres para el nombre del alumno
    @Column(nullable = false, length = 25)
    private String nombre;
    
    // Columna no nula con longitud máxima de 25 caracteres para el apellido del alumno
    @Column(nullable = false, length = 25)
    private String apellido;
    
    // Columna no nula con longitud máxima de 20 caracteres para el teléfono del alumno
    @Column(nullable = false, length = 20)
    private int telefono;
    
    // Columna para el email del alumno
    private String email;
    
    // Columna no nula con longitud máxima de 25 caracteres para el DNI del alumno
    @Column(nullable = false, length = 25)
    private String dni;
    
    // Columna para la fecha de nacimiento del alumno
    private String fecha_nac;
    
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
    public String getApellido() {
        return apellido;
    }
    public void setApellido(String apellido) {
        this.apellido = apellido;
    }
    public int getTelefono() {
        return telefono;
    }
    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getDni() {
        return dni;
    }
    public void setDni(String dni) {
        this.dni = dni;
    }
    public String getFecha_nac() {
        return fecha_nac;
    }
    public void setFecha_nac(String fecha_nac) {
        this.fecha_nac = fecha_nac;
    }
    
    // Identificador de serialización
    private static final long serialVersionUID = 1L;
}
