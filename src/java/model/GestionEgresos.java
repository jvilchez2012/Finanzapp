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
@Table(name = "gestion_egresos")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "GestionEgresos.findAll", query = "SELECT g FROM GestionEgresos g")
    , @NamedQuery(name = "GestionEgresos.findById", query = "SELECT g FROM GestionEgresos g WHERE g.id = :id")
    , @NamedQuery(name = "GestionEgresos.findByDescripcion", query = "SELECT g FROM GestionEgresos g WHERE g.descripcion = :descripcion")
    , @NamedQuery(name = "GestionEgresos.findByEstado", query = "SELECT g FROM GestionEgresos g WHERE g.estado = :estado")})
public class GestionEgresos implements Serializable {

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
    @JoinColumn(name = "idReglon_Egreso", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private RenglonesEgresos idReglonEgreso;
    @JoinColumn(name = "idTipo_Egreso", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private TiposEgresos idTipoEgreso;
    @JoinColumn(name = "idTipo_Pago", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private TiposPagos idTipoPago;

    public GestionEgresos() {
    }

    public GestionEgresos(Integer id) {
        this.id = id;
    }

    public GestionEgresos(Integer id, String descripcion, boolean estado) {
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

    public RenglonesEgresos getIdReglonEgreso() {
        return idReglonEgreso;
    }

    public void setIdReglonEgreso(RenglonesEgresos idReglonEgreso) {
        this.idReglonEgreso = idReglonEgreso;
    }

    public TiposEgresos getIdTipoEgreso() {
        return idTipoEgreso;
    }

    public void setIdTipoEgreso(TiposEgresos idTipoEgreso) {
        this.idTipoEgreso = idTipoEgreso;
    }

    public TiposPagos getIdTipoPago() {
        return idTipoPago;
    }

    public void setIdTipoPago(TiposPagos idTipoPago) {
        this.idTipoPago = idTipoPago;
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
        if (!(object instanceof GestionEgresos)) {
            return false;
        }
        GestionEgresos other = (GestionEgresos) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.GestionEgresos[ id=" + id + " ]";
    }
    
}
