/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sv.rentacar.api.entity;

import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

/**
 *
 * @author elioh
 */
@Entity
public class AuditRenta implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Column(name="id_audit_renta")
    @GeneratedValue(strategy = javax.persistence.GenerationType.IDENTITY)
    private Integer id;

    @JoinColumn(name = "id_automovil", referencedColumnName = "id_automovil")
    @ManyToOne
    private Automovil idAutomovil;

    @JoinColumn(name = "id_usuario", referencedColumnName = "id_usuario")
    @ManyToOne
    private Usuario idUsuario;

    @Column(name = "fecha_creacion", updatable = false)
    @Temporal(TemporalType.TIMESTAMP)
    @CreationTimestamp
    private Date fechaCreacion;

    public AuditRenta() {
    }

    public AuditRenta(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Automovil getIdAutomovil() {
        return idAutomovil;
    }

    public void setIdAutomovil(Automovil idAutomovil) {
        this.idAutomovil = idAutomovil;
    }

    public Usuario getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Usuario idUsuario) {
        this.idUsuario = idUsuario;
    }

    public Date getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(Date fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof AuditRenta)) return false;
        AuditRenta that = (AuditRenta) o;
        return id.equals(that.id) && idAutomovil.equals(that.idAutomovil) && idUsuario.equals(that.idUsuario);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, idAutomovil, idUsuario);
    }

    @Override
    public String toString() {
        return "AuditRenta{" +
                "id=" + id +
                ", idAutomovil=" + idAutomovil +
                ", idUsuario=" + idUsuario +
                ", fechaCreacion=" + fechaCreacion +
                '}';
    }
}
