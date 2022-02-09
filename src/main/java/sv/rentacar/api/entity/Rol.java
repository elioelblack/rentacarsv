/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sv.rentacar.api.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.Objects;

/**
 *
 * @author elioh
 */
@Entity
public class Rol implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Column(name="id_rol")
    @GeneratedValue(strategy = javax.persistence.GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "nombre")
    @NotNull
    @Size(max = 50)
    private String nombre;

    @Column(name = "descripcion")
    private String descripcion;

    public Rol() {
    }

    public Rol(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Rol)) return false;
        Rol rol = (Rol) o;
        return id.equals(rol.id) && nombre.equals(rol.nombre);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nombre);
    }

    @Override
    public String toString() {
        return "Rol{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                '}';
    }
}
