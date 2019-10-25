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
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author AllanRamiro
 */
@Entity
@Table(name = "facturas_pagos")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "FacturasPagos.findAll", query = "SELECT f FROM FacturasPagos f")
    , @NamedQuery(name = "FacturasPagos.findByIdpago", query = "SELECT f FROM FacturasPagos f WHERE f.idpago = :idpago")
    , @NamedQuery(name = "FacturasPagos.findByImporteVenta", query = "SELECT f FROM FacturasPagos f WHERE f.importeVenta = :importeVenta")
    , @NamedQuery(name = "FacturasPagos.findByImportePagado", query = "SELECT f FROM FacturasPagos f WHERE f.importePagado = :importePagado")
    , @NamedQuery(name = "FacturasPagos.findByImporteCambio", query = "SELECT f FROM FacturasPagos f WHERE f.importeCambio = :importeCambio")
    , @NamedQuery(name = "FacturasPagos.findByIdmonedapago", query = "SELECT f FROM FacturasPagos f WHERE f.idmonedapago = :idmonedapago")
    , @NamedQuery(name = "FacturasPagos.findByImporteDivisa", query = "SELECT f FROM FacturasPagos f WHERE f.importeDivisa = :importeDivisa")})
public class FacturasPagos implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idpago")
    private Short idpago;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "importe_venta")
    private BigDecimal importeVenta;
    @Column(name = "importe_pagado")
    private BigDecimal importePagado;
    @Column(name = "importe_cambio")
    private BigDecimal importeCambio;
    @Column(name = "idmonedapago")
    private Short idmonedapago;
    @Column(name = "importe_divisa")
    private BigDecimal importeDivisa;
    
    @JoinColumn(name = "idfactura", referencedColumnName = "idfactura")
    @ManyToOne
    @JsonbTransient // Rompe la relacion circular con la facturas
    private Facturas idfactura;
    
    @JoinColumn(name = "idformapago", referencedColumnName = "idformapago")
    @ManyToOne
    @JsonbTransient // Rompe la relacion circular con formas de pagos
    private FormasPago idformapago;

    public FacturasPagos() {
    }

    public FacturasPagos(Short idpago) {
        this.idpago = idpago;
    }

    public Short getIdpago() {
        return idpago;
    }

    public void setIdpago(Short idpago) {
        this.idpago = idpago;
    }

    public BigDecimal getImporteVenta() {
        return importeVenta;
    }

    public void setImporteVenta(BigDecimal importeVenta) {
        this.importeVenta = importeVenta;
    }

    public BigDecimal getImportePagado() {
        return importePagado;
    }

    public void setImportePagado(BigDecimal importePagado) {
        this.importePagado = importePagado;
    }

    public BigDecimal getImporteCambio() {
        return importeCambio;
    }

    public void setImporteCambio(BigDecimal importeCambio) {
        this.importeCambio = importeCambio;
    }

    public Short getIdmonedapago() {
        return idmonedapago;
    }

    public void setIdmonedapago(Short idmonedapago) {
        this.idmonedapago = idmonedapago;
    }

    public BigDecimal getImporteDivisa() {
        return importeDivisa;
    }

    public void setImporteDivisa(BigDecimal importeDivisa) {
        this.importeDivisa = importeDivisa;
    }

    public Facturas getIdfactura() {
        return idfactura;
    }

    public void setIdfactura(Facturas idfactura) {
        this.idfactura = idfactura;
    }

    public FormasPago getIdformapago() {
        return idformapago;
    }

    public void setIdformapago(FormasPago idformapago) {
        this.idformapago = idformapago;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idpago != null ? idpago.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof FacturasPagos)) {
            return false;
        }
        FacturasPagos other = (FacturasPagos) object;
        if ((this.idpago == null && other.idpago != null) || (this.idpago != null && !this.idpago.equals(other.idpago))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.FacturasPagos[ idpago=" + idpago + " ]";
    }
    
}
