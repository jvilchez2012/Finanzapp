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
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author klkne
 */
@Entity
@Table(name = "proceso_corte")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ProcesoCorte.findAll", query = "SELECT p FROM ProcesoCorte p")
    , @NamedQuery(name = "ProcesoCorte.findById", query = "SELECT p FROM ProcesoCorte p WHERE p.id = :id")
    , @NamedQuery(name = "ProcesoCorte.findByYear", query = "SELECT p FROM ProcesoCorte p WHERE p.year = :year")
    , @NamedQuery(name = "ProcesoCorte.findByMes", query = "SELECT p FROM ProcesoCorte p WHERE p.mes = :mes")
    , @NamedQuery(name = "ProcesoCorte.findByFechaCorte", query = "SELECT p FROM ProcesoCorte p WHERE p.fechaCorte = :fechaCorte")
    , @NamedQuery(name = "ProcesoCorte.findByBalanceInicial", query = "SELECT p FROM ProcesoCorte p WHERE p.balanceInicial = :balanceInicial")
    , @NamedQuery(name = "ProcesoCorte.findByTotalIngresos", query = "SELECT p FROM ProcesoCorte p WHERE p.totalIngresos = :totalIngresos")
    , @NamedQuery(name = "ProcesoCorte.findByTotalEgresos", query = "SELECT p FROM ProcesoCorte p WHERE p.totalEgresos = :totalEgresos")
    , @NamedQuery(name = "ProcesoCorte.findByBalanceCorte", query = "SELECT p FROM ProcesoCorte p WHERE p.balanceCorte = :balanceCorte")})
public class ProcesoCorte implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Year")
    private int year;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Mes")
    private int mes;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Fecha_Corte")
    @Temporal(TemporalType.DATE)
    private Date fechaCorte;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Column(name = "Balance_Inicial")
    private BigDecimal balanceInicial;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Total_Ingresos")
    private BigDecimal totalIngresos;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Total_Egresos")
    private BigDecimal totalEgresos;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Balance_Corte")
    private BigDecimal balanceCorte;

    public ProcesoCorte() {
    }

    public ProcesoCorte(Integer id) {
        this.id = id;
    }

    public ProcesoCorte(Integer id, int year, int mes, Date fechaCorte, BigDecimal balanceInicial, BigDecimal totalIngresos, BigDecimal totalEgresos, BigDecimal balanceCorte) {
        this.id = id;
        this.year = year;
        this.mes = mes;
        this.fechaCorte = fechaCorte;
        this.balanceInicial = balanceInicial;
        this.totalIngresos = totalIngresos;
        this.totalEgresos = totalEgresos;
        this.balanceCorte = balanceCorte;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getMes() {
        return mes;
    }

    public void setMes(int mes) {
        this.mes = mes;
    }

    public Date getFechaCorte() {
        return fechaCorte;
    }

    public void setFechaCorte(Date fechaCorte) {
        this.fechaCorte = fechaCorte;
    }

    public BigDecimal getBalanceInicial() {
        return balanceInicial;
    }

    public void setBalanceInicial(BigDecimal balanceInicial) {
        this.balanceInicial = balanceInicial;
    }

    public BigDecimal getTotalIngresos() {
        return totalIngresos;
    }

    public void setTotalIngresos(BigDecimal totalIngresos) {
        this.totalIngresos = totalIngresos;
    }

    public BigDecimal getTotalEgresos() {
        return totalEgresos;
    }

    public void setTotalEgresos(BigDecimal totalEgresos) {
        this.totalEgresos = totalEgresos;
    }

    public BigDecimal getBalanceCorte() {
        return balanceCorte;
    }

    public void setBalanceCorte(BigDecimal balanceCorte) {
        this.balanceCorte = balanceCorte;
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
        if (!(object instanceof ProcesoCorte)) {
            return false;
        }
        ProcesoCorte other = (ProcesoCorte) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.ProcesoCorte[ id=" + id + " ]";
    }
    
}
