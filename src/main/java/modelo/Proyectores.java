/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
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
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author AllanRamiro
 */
@Entity
@Table(name = "proyectores")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Proyectores.findAll", query = "SELECT p FROM Proyectores p")
    , @NamedQuery(name = "Proyectores.findByIdproyector", query = "SELECT p FROM Proyectores p WHERE p.idproyector = :idproyector")
    , @NamedQuery(name = "Proyectores.findByDescripcion", query = "SELECT p FROM Proyectores p WHERE p.descripcion = :descripcion")
    , @NamedQuery(name = "Proyectores.findByLimiteHoras", query = "SELECT p FROM Proyectores p WHERE p.limiteHoras = :limiteHoras")
    , @NamedQuery(name = "Proyectores.findByHorasConsumidas", query = "SELECT p FROM Proyectores p WHERE p.horasConsumidas = :horasConsumidas")
    , @NamedQuery(name = "Proyectores.findByPuntoRetorno", query = "SELECT p FROM Proyectores p WHERE p.puntoRetorno = :puntoRetorno")
    , @NamedQuery(name = "Proyectores.findByFecAlta", query = "SELECT p FROM Proyectores p WHERE p.fecAlta = :fecAlta")
    , @NamedQuery(name = "Proyectores.findByFecBaja", query = "SELECT p FROM Proyectores p WHERE p.fecBaja = :fecBaja")
    , @NamedQuery(name = "Proyectores.findByIdmotivo", query = "SELECT p FROM Proyectores p WHERE p.idmotivo = :idmotivo")})
public class Proyectores implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idproyector")
    private Short idproyector;
    @Size(max = 2147483647)
    @Column(name = "descripcion")
    private String descripcion;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "limite_horas")
    private BigDecimal limiteHoras;
    @Column(name = "horas_consumidas")
    private BigDecimal horasConsumidas;
    @Column(name = "punto_retorno")
    private BigDecimal puntoRetorno;
    @Column(name = "fec_alta")
    @Temporal(TemporalType.DATE)
    private Date fecAlta;
    @Column(name = "fec_baja")
    @Temporal(TemporalType.DATE)
    private Date fecBaja;
    @Column(name = "idmotivo")
    private Short idmotivo;
    
    @OneToMany(mappedBy = "idproyector")
    private List<SalasProyector> salasProyectorList;

    public Proyectores() {
    }

    public Proyectores(Short idproyector) {
        this.idproyector = idproyector;
    }

    public Short getIdproyector() {
        return idproyector;
    }

    public void setIdproyector(Short idproyector) {
        this.idproyector = idproyector;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public BigDecimal getLimiteHoras() {
        return limiteHoras;
    }

    public void setLimiteHoras(BigDecimal limiteHoras) {
        this.limiteHoras = limiteHoras;
    }

    public BigDecimal getHorasConsumidas() {
        return horasConsumidas;
    }

    public void setHorasConsumidas(BigDecimal horasConsumidas) {
        this.horasConsumidas = horasConsumidas;
    }

    public BigDecimal getPuntoRetorno() {
        return puntoRetorno;
    }

    public void setPuntoRetorno(BigDecimal puntoRetorno) {
        this.puntoRetorno = puntoRetorno;
    }

    public Date getFecAlta() {
        return fecAlta;
    }

    public void setFecAlta(Date fecAlta) {
        this.fecAlta = fecAlta;
    }

    public Date getFecBaja() {
        return fecBaja;
    }

    public void setFecBaja(Date fecBaja) {
        this.fecBaja = fecBaja;
    }

    public Short getIdmotivo() {
        return idmotivo;
    }

    public void setIdmotivo(Short idmotivo) {
        this.idmotivo = idmotivo;
    }

    @XmlTransient
    public List<SalasProyector> getSalasProyectorList() {
        return salasProyectorList;
    }

    public void setSalasProyectorList(List<SalasProyector> salasProyectorList) {
        this.salasProyectorList = salasProyectorList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idproyector != null ? idproyector.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Proyectores)) {
            return false;
        }
        Proyectores other = (Proyectores) object;
        if ((this.idproyector == null && other.idproyector != null) || (this.idproyector != null && !this.idproyector.equals(other.idproyector))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.Proyectores[ idproyector=" + idproyector + " ]";
    }
    
}
