/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author AllanRamiro
 */
@Entity
@Table(name = "promociones")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Promociones.findAll", query = "SELECT p FROM Promociones p")
    , @NamedQuery(name = "Promociones.findByIdpromocion", query = "SELECT p FROM Promociones p WHERE p.idpromocion = :idpromocion")
    , @NamedQuery(name = "Promociones.findByDescripcion", query = "SELECT p FROM Promociones p WHERE p.descripcion = :descripcion")
    , @NamedQuery(name = "Promociones.findByImporteVenta", query = "SELECT p FROM Promociones p WHERE p.importeVenta = :importeVenta")
    , @NamedQuery(name = "Promociones.findByDia", query = "SELECT p FROM Promociones p WHERE p.dia = :dia")
    , @NamedQuery(name = "Promociones.findBySnActiva", query = "SELECT p FROM Promociones p WHERE p.snActiva = :snActiva")})
public class Promociones implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idpromocion")
    private Short idpromocion;
    @Size(max = 80)
    @Column(name = "descripcion")
    private String descripcion;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "importe_venta")
    private BigDecimal importeVenta;
    @Column(name = "dia")
    private Short dia;
    @Column(name = "sn_activa")
    private Boolean snActiva;

    public Promociones() {
    }

    public Promociones(Short idpromocion) {
        this.idpromocion = idpromocion;
    }

    public Short getIdpromocion() {
        return idpromocion;
    }

    public void setIdpromocion(Short idpromocion) {
        this.idpromocion = idpromocion;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public BigDecimal getImporteVenta() {
        return importeVenta;
    }

    public void setImporteVenta(BigDecimal importeVenta) {
        this.importeVenta = importeVenta;
    }

    public Short getDia() {
        return dia;
    }

    public void setDia(Short dia) {
        this.dia = dia;
    }

    public Boolean getSnActiva() {
        return snActiva;
    }

    public void setSnActiva(Boolean snActiva) {
        this.snActiva = snActiva;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idpromocion != null ? idpromocion.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Promociones)) {
            return false;
        }
        Promociones other = (Promociones) object;
        if ((this.idpromocion == null && other.idpromocion != null) || (this.idpromocion != null && !this.idpromocion.equals(other.idpromocion))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.Promociones[ idpromocion=" + idpromocion + " ]";
    }
    
}
