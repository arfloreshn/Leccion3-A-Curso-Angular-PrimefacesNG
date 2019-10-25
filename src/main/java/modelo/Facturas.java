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
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author AllanRamiro
 */
@Entity
@Table(name = "facturas")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Facturas.findAll", query = "SELECT f FROM Facturas f")
    , @NamedQuery(name = "Facturas.findByIdfactura", query = "SELECT f FROM Facturas f WHERE f.idfactura = :idfactura")
    , @NamedQuery(name = "Facturas.findByNroFila", query = "SELECT f FROM Facturas f WHERE f.nroFila = :nroFila")
    , @NamedQuery(name = "Facturas.findByNroButaca", query = "SELECT f FROM Facturas f WHERE f.nroButaca = :nroButaca")
    , @NamedQuery(name = "Facturas.findByImporteBoleto", query = "SELECT f FROM Facturas f WHERE f.importeBoleto = :importeBoleto")
    , @NamedQuery(name = "Facturas.findByImporteDescuento", query = "SELECT f FROM Facturas f WHERE f.importeDescuento = :importeDescuento")
    , @NamedQuery(name = "Facturas.findByImportePagado", query = "SELECT f FROM Facturas f WHERE f.importePagado = :importePagado")
    , @NamedQuery(name = "Facturas.findBySnPreciooferta", query = "SELECT f FROM Facturas f WHERE f.snPreciooferta = :snPreciooferta")
    , @NamedQuery(name = "Facturas.findByIdoferta", query = "SELECT f FROM Facturas f WHERE f.idoferta = :idoferta")
    , @NamedQuery(name = "Facturas.findByFechaVenta", query = "SELECT f FROM Facturas f WHERE f.fechaVenta = :fechaVenta")
    , @NamedQuery(name = "Facturas.findByFechaAnulacion", query = "SELECT f FROM Facturas f WHERE f.fechaAnulacion = :fechaAnulacion")
    , @NamedQuery(name = "Facturas.findByIdmotivoanulacion", query = "SELECT f FROM Facturas f WHERE f.idmotivoanulacion = :idmotivoanulacion")})
public class Facturas implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idfactura")
    private Short idfactura;
    @Column(name = "nro_fila")
    private Short nroFila;
    @Column(name = "nro_butaca")
    private Short nroButaca;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "importe_boleto")
    private BigDecimal importeBoleto;
    @Column(name = "importe_descuento")
    private BigDecimal importeDescuento;
    @Column(name = "importe_pagado")
    private BigDecimal importePagado;
    @Column(name = "sn_preciooferta")
    private Boolean snPreciooferta;
    @Column(name = "idoferta")
    private Short idoferta;
    @Column(name = "fecha_venta")
    @Temporal(TemporalType.DATE)
    private Date fechaVenta;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fecha_anulacion")
    @Temporal(TemporalType.DATE)
    private Date fechaAnulacion;
    @Column(name = "idmotivoanulacion")
    private Short idmotivoanulacion;
    
    
    @JoinColumn(name = "idcanal_vta", referencedColumnName = "idcanal")
    @ManyToOne
    private CanalVenta idcanalVta;
  
    @JoinColumn(name = "idfuncion", referencedColumnName = "idfuncion")
    @ManyToOne
    private Funciones idfuncion;
    
    @JoinColumn(name = "idpelicula", referencedColumnName = "idpelicula")
    @ManyToOne
    private Peliculas idpelicula;
    
    @JoinColumn(name = "idprecio", referencedColumnName = "idprecio")
    @ManyToOne
     private PreciosVta idprecio;
    
    
    @JoinColumn(name = "idsala", referencedColumnName = "idsala")
    @ManyToOne
    @JsonbTransient // Rompe la relacion circular con salas
    private Salas idsala;
   
    @JoinColumn(name = "idusuario", referencedColumnName = "usuarioid")
    @ManyToOne
    @JsonbTransient // Rompe la relacion circular con usuarios
    private Usuario idusuario;
    
    
    @OneToMany(mappedBy = "idfactura")
    private List<FacturasPagos> facturasPagosList;

    public Facturas() {
    }

    public Facturas(Short idfactura) {
        this.idfactura = idfactura;
    }

    public Facturas(Short idfactura, Date fechaAnulacion) {
        this.idfactura = idfactura;
        this.fechaAnulacion = fechaAnulacion;
    }

    public Short getIdfactura() {
        return idfactura;
    }

    public void setIdfactura(Short idfactura) {
        this.idfactura = idfactura;
    }

    public Short getNroFila() {
        return nroFila;
    }

    public void setNroFila(Short nroFila) {
        this.nroFila = nroFila;
    }

    public Short getNroButaca() {
        return nroButaca;
    }

    public void setNroButaca(Short nroButaca) {
        this.nroButaca = nroButaca;
    }

    public BigDecimal getImporteBoleto() {
        return importeBoleto;
    }

    public void setImporteBoleto(BigDecimal importeBoleto) {
        this.importeBoleto = importeBoleto;
    }

    public BigDecimal getImporteDescuento() {
        return importeDescuento;
    }

    public void setImporteDescuento(BigDecimal importeDescuento) {
        this.importeDescuento = importeDescuento;
    }

    public BigDecimal getImportePagado() {
        return importePagado;
    }

    public void setImportePagado(BigDecimal importePagado) {
        this.importePagado = importePagado;
    }

    public Boolean getSnPreciooferta() {
        return snPreciooferta;
    }

    public void setSnPreciooferta(Boolean snPreciooferta) {
        this.snPreciooferta = snPreciooferta;
    }

    public Short getIdoferta() {
        return idoferta;
    }

    public void setIdoferta(Short idoferta) {
        this.idoferta = idoferta;
    }

    public Date getFechaVenta() {
        return fechaVenta;
    }

    public void setFechaVenta(Date fechaVenta) {
        this.fechaVenta = fechaVenta;
    }

    public Date getFechaAnulacion() {
        return fechaAnulacion;
    }

    public void setFechaAnulacion(Date fechaAnulacion) {
        this.fechaAnulacion = fechaAnulacion;
    }

    public Short getIdmotivoanulacion() {
        return idmotivoanulacion;
    }

    public void setIdmotivoanulacion(Short idmotivoanulacion) {
        this.idmotivoanulacion = idmotivoanulacion;
    }

    public CanalVenta getIdcanalVta() {
        return idcanalVta;
    }

    public void setIdcanalVta(CanalVenta idcanalVta) {
        this.idcanalVta = idcanalVta;
    }

    public Funciones getIdfuncion() {
        return idfuncion;
    }

    public void setIdfuncion(Funciones idfuncion) {
        this.idfuncion = idfuncion;
    }

    public Peliculas getIdpelicula() {
        return idpelicula;
    }

    public void setIdpelicula(Peliculas idpelicula) {
        this.idpelicula = idpelicula;
    }

    public PreciosVta getIdprecio() {
        return idprecio;
    }

    public void setIdprecio(PreciosVta idprecio) {
        this.idprecio = idprecio;
    }

    public Salas getIdsala() {
        return idsala;
    }

    public void setIdsala(Salas idsala) {
        this.idsala = idsala;
    }

    public Usuario getIdusuario() {
        return idusuario;
    }

    public void setIdusuario(Usuario idusuario) {
        this.idusuario = idusuario;
    }

    @XmlTransient
    public List<FacturasPagos> getFacturasPagosList() {
        return facturasPagosList;
    }

    public void setFacturasPagosList(List<FacturasPagos> facturasPagosList) {
        this.facturasPagosList = facturasPagosList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idfactura != null ? idfactura.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Facturas)) {
            return false;
        }
        Facturas other = (Facturas) object;
        if ((this.idfactura == null && other.idfactura != null) || (this.idfactura != null && !this.idfactura.equals(other.idfactura))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.Facturas[ idfactura=" + idfactura + " ]";
    }
    
}
