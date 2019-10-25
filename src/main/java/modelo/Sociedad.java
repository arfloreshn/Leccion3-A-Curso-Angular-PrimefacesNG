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
@Table(name = "sociedad")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Sociedad.findAll", query = "SELECT s FROM Sociedad s")
    , @NamedQuery(name = "Sociedad.findByIdsociedad", query = "SELECT s FROM Sociedad s WHERE s.idsociedad = :idsociedad")
    , @NamedQuery(name = "Sociedad.findByDescripcion", query = "SELECT s FROM Sociedad s WHERE s.descripcion = :descripcion")})
public class Sociedad implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idsociedad")
    private Short idsociedad;
    @Size(max = 50)
    @Column(name = "descripcion")
    private String descripcion;
    
    @JoinColumn(name = "idpais", referencedColumnName = "paisid")
    @ManyToOne
    @JsonbTransient // Rompe la relacion circular con paises
    private Paises idpais;
    
    @OneToMany(mappedBy = "idsociedad")    //Estas son relaciones hijas
    private List<Empleados> empleadosList;
    
    @OneToMany(mappedBy = "idsociedad")   //Estas son relaciones hijas
    private List<Sucursal> sucursalList;

    public Sociedad() {
    }

    public Sociedad(Short idsociedad) {
        this.idsociedad = idsociedad;
    }

    public Short getIdsociedad() {
        return idsociedad;
    }

    public void setIdsociedad(Short idsociedad) {
        this.idsociedad = idsociedad;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Paises getIdpais() {
        return idpais;
    }

    public void setIdpais(Paises idpais) {
        this.idpais = idpais;
    }

    @XmlTransient
    public List<Empleados> getEmpleadosList() {
        return empleadosList;
    }

    public void setEmpleadosList(List<Empleados> empleadosList) {
        this.empleadosList = empleadosList;
    }

    @XmlTransient
    public List<Sucursal> getSucursalList() {
        return sucursalList;
    }

    public void setSucursalList(List<Sucursal> sucursalList) {
        this.sucursalList = sucursalList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idsociedad != null ? idsociedad.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Sociedad)) {
            return false;
        }
        Sociedad other = (Sociedad) object;
        if ((this.idsociedad == null && other.idsociedad != null) || (this.idsociedad != null && !this.idsociedad.equals(other.idsociedad))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.Sociedad[ idsociedad=" + idsociedad + " ]";
    }
    
}
