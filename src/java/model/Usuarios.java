/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Collection;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author klkne
 */
@Entity
@Table(name = "usuarios")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Usuarios.findAll", query = "SELECT u FROM Usuarios u")
    , @NamedQuery(name = "Usuarios.findById", query = "SELECT u FROM Usuarios u WHERE u.id = :id")
    , @NamedQuery(name = "Usuarios.findByNombre", query = "SELECT u FROM Usuarios u WHERE u.nombre = :nombre")
    , @NamedQuery(name = "Usuarios.findByIdentificacion", query = "SELECT u FROM Usuarios u WHERE u.identificacion = :identificacion")
    , @NamedQuery(name = "Usuarios.findByLimiteEgresos", query = "SELECT u FROM Usuarios u WHERE u.limiteEgresos = :limiteEgresos")
    , @NamedQuery(name = "Usuarios.findByTipoPersona", query = "SELECT u FROM Usuarios u WHERE u.tipoPersona = :tipoPersona")
    , @NamedQuery(name = "Usuarios.findByFechaCorte", query = "SELECT u FROM Usuarios u WHERE u.fechaCorte = :fechaCorte")
    , @NamedQuery(name = "Usuarios.findByEstado", query = "SELECT u FROM Usuarios u WHERE u.estado = :estado")})
public class Usuarios implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "Nombre")
    private String nombre;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "Identificacion")
    private String identificacion;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Column(name = "Limite_Egresos")
    private BigDecimal limiteEgresos;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "Tipo_Persona")
    private String tipoPersona;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Fecha_Corte")
    @Temporal(TemporalType.DATE)
    private Date fechaCorte;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Estado")
    private boolean estado;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idUsuario")
    private Collection<RegistroTransacciones> registroTransaccionesCollection;

    public Usuarios() {
    }

    public Usuarios(Integer id) {
        this.id = id;
    }

    public Usuarios(Integer id, String nombre, String identificacion, BigDecimal limiteEgresos, String tipoPersona, Date fechaCorte, boolean estado) {
        this.id = id;
        this.nombre = nombre;
        this.identificacion = identificacion;
        this.limiteEgresos = limiteEgresos;
        this.tipoPersona = tipoPersona;
        this.fechaCorte = fechaCorte;
        this.estado = estado;
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

    public String getIdentificacion() {
        return identificacion;
    }

    public void setIdentificacion(String identificacion) {
        this.identificacion = identificacion;
    }

    public BigDecimal getLimiteEgresos() {
        return limiteEgresos;
    }

    public void setLimiteEgresos(BigDecimal limiteEgresos) {
        this.limiteEgresos = limiteEgresos;
    }

    public String getTipoPersona() {
        return tipoPersona;
    }

    public void setTipoPersona(String tipoPersona) {
        this.tipoPersona = tipoPersona;
    }

    public Date getFechaCorte() {
        return fechaCorte;
    }

    public void setFechaCorte(Date fechaCorte) {
        this.fechaCorte = fechaCorte;
    }

    public boolean getEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    @XmlTransient
    public Collection<RegistroTransacciones> getRegistroTransaccionesCollection() {
        return registroTransaccionesCollection;
    }

    public void setRegistroTransaccionesCollection(Collection<RegistroTransacciones> registroTransaccionesCollection) {
        this.registroTransaccionesCollection = registroTransaccionesCollection;
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
        if (!(object instanceof Usuarios)) {
            return false;
        }
        Usuarios other = (Usuarios) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Usuarios[ id=" + id + " ]";
    }
    
}
