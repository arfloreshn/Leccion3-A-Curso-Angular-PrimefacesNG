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
 * @author AllanRamiro
 */
@Entity
@Table(name = "canal_venta")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CanalVenta.findAll", query = "SELECT c FROM CanalVenta c")
    , @NamedQuery(name = "CanalVenta.findByIdcanal", query = "SELECT c FROM CanalVenta c WHERE c.idcanal = :idcanal")
    , @NamedQuery(name = "CanalVenta.findByDescripcion", query = "SELECT c FROM CanalVenta c WHERE c.descripcion = :descripcion")})
public class CanalVenta implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "idcanal")
    private Short idcanal;
    @Size(max = 50)
    @Column(name = "descripcion")
    private String descripcion;
    
    @OneToMany(mappedBy = "idcanalVta")
    @JsonbTransient // Rompe la relacion circular con facturas
    private List<Facturas> facturasList;

    public CanalVenta() {
    }

    public CanalVenta(Short idcanal) {
        this.idcanal = idcanal;
    }

    public Short getIdcanal() {
        return idcanal;
    }

    public void setIdcanal(Short idcanal) {
        this.idcanal = idcanal;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @XmlTransient
    public List<Facturas> getFacturasList() {
        return facturasList;
    }

    public void setFacturasList(List<Facturas> facturasList) {
        this.facturasList = facturasList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idcanal != null ? idcanal.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CanalVenta)) {
            return false;
        }
        CanalVenta other = (CanalVenta) object;
        if ((this.idcanal == null && other.idcanal != null) || (this.idcanal != null && !this.idcanal.equals(other.idcanal))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.CanalVenta[ idcanal=" + idcanal + " ]";
    }
    
}
