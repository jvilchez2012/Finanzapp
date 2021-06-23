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
@Table(name = "tipos_ingresos")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TiposIngresos.findAll", query = "SELECT t FROM TiposIngresos t")
    , @NamedQuery(name = "TiposIngresos.findById", query = "SELECT t FROM TiposIngresos t WHERE t.id = :id")
    , @NamedQuery(name = "TiposIngresos.findByDescripcion", query = "SELECT t FROM TiposIngresos t WHERE t.descripcion = :descripcion")
    , @NamedQuery(name = "TiposIngresos.findByEstado", query = "SELECT t FROM TiposIngresos t WHERE t.estado = :estado")})
public class TiposIngresos implements Serializable {

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
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idTipoIngreso")
    private Collection<GestionIngresos> gestionIngresosCollection;

    public TiposIngresos() {
    }

    public TiposIngresos(Integer id) {
        this.id = id;
    }

    public TiposIngresos(Integer id, String descripcion, boolean estado) {
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
    public Collection<GestionIngresos> getGestionIngresosCollection() {
        return gestionIngresosCollection;
    }

    public void setGestionIngresosCollection(Collection<GestionIngresos> gestionIngresosCollection) {
        this.gestionIngresosCollection = gestionIngresosCollection;
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
        if (!(object instanceof TiposIngresos)) {
            return false;
        }
        TiposIngresos other = (TiposIngresos) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.TiposIngresos[ id=" + id + " ]";
    }
    
}
