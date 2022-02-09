/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sv.rentacar.api.entity;

import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;
import java.util.Objects;

/**
 *
 * @author elioh
 */
@Entity
public class Automovil {

    @Id
    @Column(name = "id_automovil")
    @GeneratedValue(strategy = javax.persistence.GenerationType.IDENTITY)
    private Integer id;

    @Column
    @NotNull
    @Size(max = 50)
    private String nombre;

    @Column
    private Integer tipo;

    @JoinColumn(name = "id_modelo", referencedColumnName = "id_modelo")
    @ManyToOne(optional = false)
    private Modelo idModelo;

    @Column
    private Integer anio;

    @Column(name = "url_imagen")
    private String url;

    @Column
    private Double precioRenta;

    @Column
    private boolean disponible;

    @Column
    private boolean activo;

    @Column(name = "fecha_creacion", updatable = false)
    @Temporal(TemporalType.TIMESTAMP)
    @CreationTimestamp
    private Date fechaCreacion;

    @Column(name = "last_user")
    @Size(max = 30)
    private String lastUser;

    public Automovil() {
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

    public Integer getTipo() {
        return tipo;
    }

    public void setTipo(Integer tipo) {
        this.tipo = tipo;
    }

    public Modelo getIdModelo() {
        return idModelo;
    }

    public void setIdModelo(Modelo idModelo) {
        this.idModelo = idModelo;
    }

    public Integer getAnio() {
        return anio;
    }

    public void setAnio(Integer anio) {
        this.anio = anio;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Double getPrecioRenta() {
        return precioRenta;
    }

    public void setPrecioRenta(Double precioRenta) {
        this.precioRenta = precioRenta;
    }

    public boolean isDisponible() {
        return disponible;
    }

    public void setDisponible(boolean disponible) {
        this.disponible = disponible;
    }

    public boolean isActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }

    public Date getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(Date fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public String getLastUser() {
        return lastUser;
    }

    public void setLastUser(String lastUser) {
        this.lastUser = lastUser;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Automovil)) return false;
        Automovil automovil = (Automovil) o;
        return id.equals(automovil.id) && nombre.equals(automovil.nombre) && tipo.equals(automovil.tipo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nombre, tipo);
    }

    @Override
    public String toString() {
        return "Automovil{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", tipo=" + tipo +
                '}';
    }
}