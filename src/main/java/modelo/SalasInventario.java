/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.io.Serializable;
import java.math.BigDecimal;
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
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author AllanRamiro
 */
@Entity
@Table(name = "salas_inventario")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "SalasInventario.findAll", query = "SELECT s FROM SalasInventario s")
    , @NamedQuery(name = "SalasInventario.findByIdproducto", query = "SELECT s FROM SalasInventario s WHERE s.idproducto = :idproducto")
    , @NamedQuery(name = "SalasInventario.findByDescripcion", query = "SELECT s FROM SalasInventario s WHERE s.descripcion = :descripcion")
    , @NamedQuery(name = "SalasInventario.findByCantidad", query = "SELECT s FROM SalasInventario s WHERE s.cantidad = :cantidad")
    , @NamedQuery(name = "SalasInventario.findByCostoNeto", query = "SELECT s FROM SalasInventario s WHERE s.costoNeto = :costoNeto")
    , @NamedQuery(name = "SalasInventario.findBySnActivo", query = "SELECT s FROM SalasInventario s WHERE s.snActivo = :snActivo")
    , @NamedQuery(name = "SalasInventario.findBySnDepreciado", query = "SELECT s FROM SalasInventario s WHERE s.snDepreciado = :snDepreciado")
    , @NamedQuery(name = "SalasInventario.findByCodbarra", query = "SELECT s FROM SalasInventario s WHERE s.codbarra = :codbarra")})
public class SalasInventario implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idproducto")
    private Short idproducto;
    @Size(max = 2147483647)
    @Column(name = "descripcion")
    private String descripcion;
    @Column(name = "cantidad")
    private Short cantidad;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "costo_neto")
    private BigDecimal costoNeto;
    @Column(name = "sn_activo")
    private Short snActivo;
    @Column(name = "sn_depreciado")
    private Short snDepreciado;
    @Size(max = 20)
    @Column(name = "codbarra")
    private String codbarra;
    
    @JoinColumn(name = "idsala", referencedColumnName = "idsala")
    @ManyToOne
    @JsonbTransient // Rompe la relacion circular con la sala
    private Salas idsala;

    public SalasInventario() {
    }

    public SalasInventario(Short idproducto) {
        this.idproducto = idproducto;
    }

    public Short getIdproducto() {
        return idproducto;
    }

    public void setIdproducto(Short idproducto) {
        this.idproducto = idproducto;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Short getCantidad() {
        return cantidad;
    }

    public void setCantidad(Short cantidad) {
        this.cantidad = cantidad;
    }

    public BigDecimal getCostoNeto() {
        return costoNeto;
    }

    public void setCostoNeto(BigDecimal costoNeto) {
        this.costoNeto = costoNeto;
    }

    public Short getSnActivo() {
        return snActivo;
    }

    public void setSnActivo(Short snActivo) {
        this.snActivo = snActivo;
    }

    public Short getSnDepreciado() {
        return snDepreciado;
    }

    public void setSnDepreciado(Short snDepreciado) {
        this.snDepreciado = snDepreciado;
    }

    public String getCodbarra() {
        return codbarra;
    }

    public void setCodbarra(String codbarra) {
        this.codbarra = codbarra;
    }

    public Salas getIdsala() {
        return idsala;
    }

    public void setIdsala(Salas idsala) {
        this.idsala = idsala;
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
        if (!(object instanceof SalasInventario)) {
            return false;
        }
        SalasInventario other = (SalasInventario) object;
        if ((this.idproducto == null && other.idproducto != null) || (this.idproducto != null && !this.idproducto.equals(other.idproducto))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.SalasInventario[ idproducto=" + idproducto + " ]";
    }
    
}
