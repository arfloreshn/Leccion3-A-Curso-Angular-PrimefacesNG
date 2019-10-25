/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;
import javax.json.bind.annotation.JsonbTransient;
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
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author AllanRamiro
 */
@Entity
@Table(name = "precios_vta")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PreciosVta.findAll", query = "SELECT p FROM PreciosVta p")
    , @NamedQuery(name = "PreciosVta.findByIdprecio", query = "SELECT p FROM PreciosVta p WHERE p.idprecio = :idprecio")
    , @NamedQuery(name = "PreciosVta.findByDescripcion", query = "SELECT p FROM PreciosVta p WHERE p.descripcion = :descripcion")
    , @NamedQuery(name = "PreciosVta.findByPrecioVenta", query = "SELECT p FROM PreciosVta p WHERE p.precioVenta = :precioVenta")})
public class PreciosVta implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idprecio")
    private Short idprecio;
    @Size(max = 2147483647)
    @Column(name = "descripcion")
    private String descripcion;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "precio_venta")
    private BigDecimal precioVenta;
    
    @OneToMany(mappedBy = "idprecio")
    @JsonbTransient // Rompe la relacion circular con la factura
    private List<Facturas> facturasList;

    public PreciosVta() {
    }

    public PreciosVta(Short idprecio) {
        this.idprecio = idprecio;
    }

    public Short getIdprecio() {
        return idprecio;
    }

    public void setIdprecio(Short idprecio) {
        this.idprecio = idprecio;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public BigDecimal getPrecioVenta() {
        return precioVenta;
    }

    public void setPrecioVenta(BigDecimal precioVenta) {
        this.precioVenta = precioVenta;
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
        hash += (idprecio != null ? idprecio.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PreciosVta)) {
            return false;
        }
        PreciosVta other = (PreciosVta) object;
        if ((this.idprecio == null && other.idprecio != null) || (this.idprecio != null && !this.idprecio.equals(other.idprecio))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.PreciosVta[ idprecio=" + idprecio + " ]";
    }
    
}
