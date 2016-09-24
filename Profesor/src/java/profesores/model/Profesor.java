/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package profesores.model;

/**
 *
 * @author Felipe
 */
public class Profesor {
    private int idProfesor;
    private String nombre;
    private int experiencia;
    private String carrera;

    public Profesor(int idProfesor, String nombre, int experiencia, String carrera) {
        this.idProfesor = idProfesor;
        this.nombre = nombre;
        this.experiencia = experiencia;
        this.carrera = carrera;
    }
    
    public Profesor(){
        this(0,"",0,"");
    }

    public void setCarrera(String carrera) {
        this.carrera = carrera;
    }

    public void setExperiencia(int experiencia) {
        this.experiencia = experiencia;
    }

    public void setIdProfesor(int idProfesor) {
        this.idProfesor = idProfesor;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCarrera() {
        return carrera;
    }

    public int getExperiencia() {
        return experiencia;
    }

    public int getIdProfesor() {
        return idProfesor;
    }

    public String getNombre() {
        return nombre;
    }

    @Override
    public String toString() {
        return "Profesor{" + "idProfesor=" + idProfesor + ", nombre=" + nombre + ", experiencia=" + experiencia + ", carrera=" + carrera + '}';
    }
 
    
}
