/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.io.Serializable;
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
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author AllanRamiro
 */
@Entity
@Table(name = "sucursal")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Sucursal.findAll", query = "SELECT s FROM Sucursal s")
    , @NamedQuery(name = "Sucursal.findByIdsucursal", query = "SELECT s FROM Sucursal s WHERE s.idsucursal = :idsucursal")
    , @NamedQuery(name = "Sucursal.findByDescripcion", query = "SELECT s FROM Sucursal s WHERE s.descripcion = :descripcion")})
public class Sucursal implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idsucursal")
    private Short idsucursal;
    @Size(max = 50)
    @Column(name = "descripcion")
    private String descripcion;
    
    @OneToMany(mappedBy = "idsucursal")
    private List<Salas> salasList;
    
    @OneToMany(mappedBy = "idsucursal")
    private List<Empleados> empleadosList;
    
    @JoinColumn(name = "idpais", referencedColumnName = "paisid")
    @ManyToOne
    @JsonbTransient // Rompe la relacion circular con paises
    private Paises idpais;
    
    @JoinColumn(name = "idsociedad", referencedColumnName = "idsociedad")
    @ManyToOne
    @JsonbTransient // Rompe la relacion circular con sociedades
    private Sociedad idsociedad;

    public Sucursal() {
    }

    public Sucursal(Short idsucursal) {
        this.idsucursal = idsucursal;
    }

    public Short getIdsucursal() {
        return idsucursal;
    }

    public void setIdsucursal(Short idsucursal) {
        this.idsucursal = idsucursal;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @XmlTransient
    public List<Salas> getSalasList() {
        return salasList;
    }

    public void setSalasList(List<Salas> salasList) {
        this.salasList = salasList;
    }

    @XmlTransient
    public List<Empleados> getEmpleadosList() {
        return empleadosList;
    }

    public void setEmpleadosList(List<Empleados> empleadosList) {
        this.empleadosList = empleadosList;
    }

    public Paises getIdpais() {
        return idpais;
    }

    public void setIdpais(Paises idpais) {
        this.idpais = idpais;
    }

    public Sociedad getIdsociedad() {
        return idsociedad;
    }

    public void setIdsociedad(Sociedad idsociedad) {
        this.idsociedad = idsociedad;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idsucursal != null ? idsucursal.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Sucursal)) {
            return false;
        }
        Sucursal other = (Sucursal) object;
        if ((this.idsucursal == null && other.idsucursal != null) || (this.idsucursal != null && !this.idsucursal.equals(other.idsucursal))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.Sucursal[ idsucursal=" + idsucursal + " ]";
    }
    
}
