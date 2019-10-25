/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.json.bind.annotation.JsonbTransient;
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
@Table(name = "salas")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Salas.findAll", query = "SELECT s FROM Salas s")
    , @NamedQuery(name = "Salas.findByIdsala", query = "SELECT s FROM Salas s WHERE s.idsala = :idsala")
    , @NamedQuery(name = "Salas.findByNombreSala", query = "SELECT s FROM Salas s WHERE s.nombreSala = :nombreSala")
    , @NamedQuery(name = "Salas.findByNroButacas", query = "SELECT s FROM Salas s WHERE s.nroButacas = :nroButacas")
    , @NamedQuery(name = "Salas.findByFecultmantenimiento", query = "SELECT s FROM Salas s WHERE s.fecultmantenimiento = :fecultmantenimiento")
    , @NamedQuery(name = "Salas.findBySnDisponible", query = "SELECT s FROM Salas s WHERE s.snDisponible = :snDisponible")})
public class Salas implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idsala")
    private Short idsala;
    @Size(max = 50)
    @Column(name = "nombre_sala")
    private String nombreSala;
    @Column(name = "nro_butacas")
    private Short nroButacas;
    @Column(name = "fecultmantenimiento")
    @Temporal(TemporalType.DATE)
    private Date fecultmantenimiento;
    @Column(name = "sn_disponible")
    private Boolean snDisponible;
    
    
    @OneToMany(mappedBy = "idsala")
    private List<Facturas> facturasList;
    
    @OneToMany(mappedBy = "idsala")
    private List<Pases> pasesList;
    
    @JoinColumn(name = "idreposable", referencedColumnName = "idresponsable")
    @ManyToOne
    private Empleados idreposable;
    
    @JoinColumn(name = "idsucursal", referencedColumnName = "idsucursal")
    @ManyToOne
    @JsonbTransient // Rompe la relacion circular con sucursales
    private Sucursal idsucursal;
    
    @OneToMany(mappedBy = "idsala")
    private List<SalasPeliculas> salasPeliculasList;
    
    @OneToMany(mappedBy = "idsala")
    private List<SalasProyector> salasProyectorList;
    
    @OneToMany(mappedBy = "idsala")
    private List<SalasInventario> salasInventarioList;

    public Salas() {
    }

    public Salas(Short idsala) {
        this.idsala = idsala;
    }

    public Short getIdsala() {
        return idsala;
    }

    public void setIdsala(Short idsala) {
        this.idsala = idsala;
    }

    public String getNombreSala() {
        return nombreSala;
    }

    public void setNombreSala(String nombreSala) {
        this.nombreSala = nombreSala;
    }

    public Short getNroButacas() {
        return nroButacas;
    }

    public void setNroButacas(Short nroButacas) {
        this.nroButacas = nroButacas;
    }

    public Date getFecultmantenimiento() {
        return fecultmantenimiento;
    }

    public void setFecultmantenimiento(Date fecultmantenimiento) {
        this.fecultmantenimiento = fecultmantenimiento;
    }

    public Boolean getSnDisponible() {
        return snDisponible;
    }

    public void setSnDisponible(Boolean snDisponible) {
        this.snDisponible = snDisponible;
    }

    @XmlTransient
    public List<Facturas> getFacturasList() {
        return facturasList;
    }

    public void setFacturasList(List<Facturas> facturasList) {
        this.facturasList = facturasList;
    }

    @XmlTransient
    public List<Pases> getPasesList() {
        return pasesList;
    }

    public void setPasesList(List<Pases> pasesList) {
        this.pasesList = pasesList;
    }

    public Empleados getIdreposable() {
        return idreposable;
    }

    public void setIdreposable(Empleados idreposable) {
        this.idreposable = idreposable;
    }

    public Sucursal getIdsucursal() {
        return idsucursal;
    }

    public void setIdsucursal(Sucursal idsucursal) {
        this.idsucursal = idsucursal;
    }

    @XmlTransient
    public List<SalasPeliculas> getSalasPeliculasList() {
        return salasPeliculasList;
    }

    public void setSalasPeliculasList(List<SalasPeliculas> salasPeliculasList) {
        this.salasPeliculasList = salasPeliculasList;
    }

    @XmlTransient
    public List<SalasProyector> getSalasProyectorList() {
        return salasProyectorList;
    }

    public void setSalasProyectorList(List<SalasProyector> salasProyectorList) {
        this.salasProyectorList = salasProyectorList;
    }

    @XmlTransient
    public List<SalasInventario> getSalasInventarioList() {
        return salasInventarioList;
    }

    public void setSalasInventarioList(List<SalasInventario> salasInventarioList) {
        this.salasInventarioList = salasInventarioList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idsala != null ? idsala.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Salas)) {
            return false;
        }
        Salas other = (Salas) object;
        if ((this.idsala == null && other.idsala != null) || (this.idsala != null && !this.idsala.equals(other.idsala))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.Salas[ idsala=" + idsala + " ]";
    }
    
}
