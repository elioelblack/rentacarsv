/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sv.rentacar.api.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

/**
 *
 * @author elioh
 */
@Entity
public class Modelo implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Column(name="id_modelo")
    @GeneratedValue(strategy = javax.persistence.GenerationType.IDENTITY)
    private Integer id;

    @Column(name="modeldesc")
    private String decripcion;

    @JoinColumn(name = "id_marca", referencedColumnName = "id_marca")
    @ManyToOne(optional = false)
    private Marca idMarca;

    public Modelo(Integer id) {
        this.id = id;
    }

    public Modelo() {

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDecripcion() {
        return decripcion;
    }

    public void setDecripcion(String decripcion) {
        this.decripcion = decripcion;
    }

    public Marca getIdMarca() {
        return idMarca;
    }

    public void setIdMarca(Marca idMarca) {
        this.idMarca = idMarca;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Modelo)) return false;
        Modelo modelo = (Modelo) o;
        return id.equals(modelo.id) && Objects.equals(decripcion, modelo.decripcion);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, decripcion);
    }

    @Override
    public String toString() {
        return "Modelo{" +
                "id=" + id +
                ", decripcion='" + decripcion + '\'' +
                '}';
    }
}
