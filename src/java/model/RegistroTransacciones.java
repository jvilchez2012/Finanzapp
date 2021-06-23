/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author klkne
 */
@Entity
@Table(name = "registro_transacciones")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "RegistroTransacciones.findAll", query = "SELECT r FROM RegistroTransacciones r")
    , @NamedQuery(name = "RegistroTransacciones.findById", query = "SELECT r FROM RegistroTransacciones r WHERE r.id = :id")
    , @NamedQuery(name = "RegistroTransacciones.findByTipoTransaccion", query = "SELECT r FROM RegistroTransacciones r WHERE r.tipoTransaccion = :tipoTransaccion")
    , @NamedQuery(name = "RegistroTransacciones.findByFechaTransaccion", query = "SELECT r FROM RegistroTransacciones r WHERE r.fechaTransaccion = :fechaTransaccion")
    , @NamedQuery(name = "RegistroTransacciones.findByFechaRegistro", query = "SELECT r FROM RegistroTransacciones r WHERE r.fechaRegistro = :fechaRegistro")
    , @NamedQuery(name = "RegistroTransacciones.findByMontoTransaccion", query = "SELECT r FROM RegistroTransacciones r WHERE r.montoTransaccion = :montoTransaccion")
    , @NamedQuery(name = "RegistroTransacciones.findByNoTDC", query = "SELECT r FROM RegistroTransacciones r WHERE r.noTDC = :noTDC")
    , @NamedQuery(name = "RegistroTransacciones.findByComentario", query = "SELECT r FROM RegistroTransacciones r WHERE r.comentario = :comentario")
    , @NamedQuery(name = "RegistroTransacciones.findByEstado", query = "SELECT r FROM RegistroTransacciones r WHERE r.estado = :estado")})
public class RegistroTransacciones implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "Tipo_Transaccion")
    private String tipoTransaccion;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Fecha_Transaccion")
    @Temporal(TemporalType.DATE)
    private Date fechaTransaccion;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Fecha_Registro")
    @Temporal(TemporalType.DATE)
    private Date fechaRegistro;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Column(name = "Monto_Transaccion")
    private BigDecimal montoTransaccion;
    @Column(name = "No_TDC")
    private Integer noTDC;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "Comentario")
    private String comentario;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Estado")
    private boolean estado;
    @JoinColumn(name = "idTipo_Pago", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private TiposPagos idTipoPago;
    @JoinColumn(name = "idUsuario", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Usuarios idUsuario;

    public RegistroTransacciones() {
    }

    public RegistroTransacciones(Integer id) {
        this.id = id;
    }

    public RegistroTransacciones(Integer id, String tipoTransaccion, Date fechaTransaccion, Date fechaRegistro, BigDecimal montoTransaccion, String comentario, boolean estado) {
        this.id = id;
        this.tipoTransaccion = tipoTransaccion;
        this.fechaTransaccion = fechaTransaccion;
        this.fechaRegistro = fechaRegistro;
        this.montoTransaccion = montoTransaccion;
        this.comentario = comentario;
        this.estado = estado;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTipoTransaccion() {
        return tipoTransaccion;
    }

    public void setTipoTransaccion(String tipoTransaccion) {
        this.tipoTransaccion = tipoTransaccion;
    }

    public Date getFechaTransaccion() {
        return fechaTransaccion;
    }

    public void setFechaTransaccion(Date fechaTransaccion) {
        this.fechaTransaccion = fechaTransaccion;
    }

    public Date getFechaRegistro() {
        return fechaRegistro;
    }

    public void setFechaRegistro(Date fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }

    public BigDecimal getMontoTransaccion() {
        return montoTransaccion;
    }

    public void setMontoTransaccion(BigDecimal montoTransaccion) {
        this.montoTransaccion = montoTransaccion;
    }

    public Integer getNoTDC() {
        return noTDC;
    }

    public void setNoTDC(Integer noTDC) {
        this.noTDC = noTDC;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    public boolean getEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    public TiposPagos getIdTipoPago() {
        return idTipoPago;
    }

    public void setIdTipoPago(TiposPagos idTipoPago) {
        this.idTipoPago = idTipoPago;
    }

    public Usuarios getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Usuarios idUsuario) {
        this.idUsuario = idUsuario;
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
        if (!(object instanceof RegistroTransacciones)) {
            return false;
        }
        RegistroTransacciones other = (RegistroTransacciones) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.RegistroTransacciones[ id=" + id + " ]";
    }
    
}
