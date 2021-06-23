/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author klkne
 */
@Entity
@Table(name = "gestion_ingresos")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "GestionIngresos.findAll", query = "SELECT g FROM GestionIngresos g")
    , @NamedQuery(name = "GestionIngresos.findById", query = "SELECT g FROM GestionIngresos g WHERE g.id = :id")
    , @NamedQuery(name = "GestionIngresos.findByDescripcion", query = "SELECT g FROM GestionIngresos g WHERE g.descripcion = :descripcion")
    , @NamedQuery(name = "GestionIngresos.findByFuente", query = "SELECT g FROM GestionIngresos g WHERE g.fuente = :fuente")
    , @NamedQuery(name = "GestionIngresos.findByEstado", query = "SELECT g FROM GestionIngresos g WHERE g.estado = :estado")})
public class GestionIngresos implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "Descripcion")
    private String descripcion;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "Fuente")
    private String fuente;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Estado")
    private boolean estado;
    @JoinColumn(name = "idTipo_Ingreso", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private TiposIngresos idTipoIngreso;

    public GestionIngresos() {
    }

    public GestionIngresos(Integer id) {
        this.id = id;
    }

    public GestionIngresos(Integer id, String descripcion, String fuente, boolean estado) {
        this.id = id;
        this.descripcion = descripcion;
        this.fuente = fuente;
        this.estado = estado;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getFuente() {
        return fuente;
    }

    public void setFuente(String fuente) {
        this.fuente = fuente;
    }

    public boolean getEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    public TiposIngresos getIdTipoIngreso() {
        return idTipoIngreso;
    }

    public void setIdTipoIngreso(TiposIngresos idTipoIngreso) {
        this.idTipoIngreso = idTipoIngreso;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof GestionIngresos)) {
            return false;
        }
        GestionIngresos other = (GestionIngresos) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.GestionIngresos[ id=" + id + " ]";
    }
    
}
