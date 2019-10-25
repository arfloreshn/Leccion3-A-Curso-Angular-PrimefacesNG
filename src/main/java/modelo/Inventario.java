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
@Table(name = "inventario")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Inventario.findAll", query = "SELECT i FROM Inventario i")
    , @NamedQuery(name = "Inventario.findByIdproducto", query = "SELECT i FROM Inventario i WHERE i.idproducto = :idproducto")
    , @NamedQuery(name = "Inventario.findByCodbarra", query = "SELECT i FROM Inventario i WHERE i.codbarra = :codbarra")
    , @NamedQuery(name = "Inventario.findByDescripcion", query = "SELECT i FROM Inventario i WHERE i.descripcion = :descripcion")
    , @NamedQuery(name = "Inventario.findByExistencia", query = "SELECT i FROM Inventario i WHERE i.existencia = :existencia")
    , @NamedQuery(name = "Inventario.findByCostoUnitario", query = "SELECT i FROM Inventario i WHERE i.costoUnitario = :costoUnitario")
    , @NamedQuery(name = "Inventario.findByPrecioVenta", query = "SELECT i FROM Inventario i WHERE i.precioVenta = :precioVenta")})
public class Inventario implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idproducto")
    private Short idproducto;
    @Size(max = 20)
    @Column(name = "codbarra")
    private String codbarra;
    @Size(max = 80)
    @Column(name = "descripcion")
    private String descripcion;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "existencia")
    private BigDecimal existencia;
    @Column(name = "costo_unitario")
    private BigDecimal costoUnitario;
    @Column(name = "precio_venta")
    private BigDecimal precioVenta;

    public Inventario() {
    }

    public Inventario(Short idproducto) {
        this.idproducto = idproducto;
    }

    public Short getIdproducto() {
        return idproducto;
    }

    public void setIdproducto(Short idproducto) {
        this.idproducto = idproducto;
    }

    public String getCodbarra() {
        return codbarra;
    }

    public void setCodbarra(String codbarra) {
        this.codbarra = codbarra;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public BigDecimal getExistencia() {
        return existencia;
    }

    public void setExistencia(BigDecimal existencia) {
        this.existencia = existencia;
    }

    public BigDecimal getCostoUnitario() {
        return costoUnitario;
    }

    public void setCostoUnitario(BigDecimal costoUnitario) {
        this.costoUnitario = costoUnitario;
    }

    public BigDecimal getPrecioVenta() {
        return precioVenta;
    }

    public void setPrecioVenta(BigDecimal precioVenta) {
        this.precioVenta = precioVenta;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idproducto != null ? idproducto.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Inventario)) {
            return false;
        }
        Inventario other = (Inventario) object;
        if ((this.idproducto == null && other.idproducto != null) || (this.idproducto != null && !this.idproducto.equals(other.idproducto))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.Inventario[ idproducto=" + idproducto + " ]";
    }
    
}
