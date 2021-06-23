/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author klkne
 */
@Entity
@Table(name = "renglones_egresos")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "RenglonesEgresos.findAll", query = "SELECT r FROM RenglonesEgresos r")
    , @NamedQuery(name = "RenglonesEgresos.findById", query = "SELECT r FROM RenglonesEgresos r WHERE r.id = :id")
    , @NamedQuery(name = "RenglonesEgresos.findByDescripcion", query = "SELECT r FROM RenglonesEgresos r WHERE r.descripcion = :descripcion")
    , @NamedQuery(name = "RenglonesEgresos.findByEstado", query = "SELECT r FROM RenglonesEgresos r WHERE r.estado = :estado")})
public class RenglonesEgresos implements Serializable {

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
    @Column(name = "Estado")
    private boolean estado;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idReglonEgreso")
    private Collection<GestionEgresos> gestionEgresosCollection;

    public RenglonesEgresos() {
    }

    public RenglonesEgresos(Integer id) {
        this.id = id;
    }

    public RenglonesEgresos(Integer id, String descripcion, boolean estado) {
        this.id = id;
        this.descripcion = descripcion;
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

    public boolean getEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    @XmlTransient
    public Collection<GestionEgresos> getGestionEgresosCollection() {
        return gestionEgresosCollection;
    }

    public void setGestionEgresosCollection(Collection<GestionEgresos> gestionEgresosCollection) {
        this.gestionEgresosCollection = gestionEgresosCollection;
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
        if (!(object instanceof RenglonesEgresos)) {
            return false;
        }
        RenglonesEgresos other = (RenglonesEgresos) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.RenglonesEgresos[ id=" + id + " ]";
    }
    
}
