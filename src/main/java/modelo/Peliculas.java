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
@Table(name = "peliculas")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Peliculas.findAll", query = "SELECT p FROM Peliculas p")
    , @NamedQuery(name = "Peliculas.findByIdpelicula", query = "SELECT p FROM Peliculas p WHERE p.idpelicula = :idpelicula")
    , @NamedQuery(name = "Peliculas.findByNombrePelicula", query = "SELECT p FROM Peliculas p WHERE p.nombrePelicula = :nombrePelicula")
    , @NamedQuery(name = "Peliculas.findByDuracion", query = "SELECT p FROM Peliculas p WHERE p.duracion = :duracion")
    , @NamedQuery(name = "Peliculas.findByFecCaduciadad", query = "SELECT p FROM Peliculas p WHERE p.fecCaduciadad = :fecCaduciadad")
    , @NamedQuery(name = "Peliculas.findByFecEstreno", query = "SELECT p FROM Peliculas p WHERE p.fecEstreno = :fecEstreno")
    , @NamedQuery(name = "Peliculas.findByIdmedio", query = "SELECT p FROM Peliculas p WHERE p.idmedio = :idmedio")})
public class Peliculas implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idpelicula")
    private Short idpelicula;
    @Size(max = 2147483647)
    @Column(name = "nombre_pelicula")
    private String nombrePelicula;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "duracion")
    private BigDecimal duracion;
    @Column(name = "fec_caduciadad")
    @Temporal(TemporalType.DATE)
    private Date fecCaduciadad;
    @Column(name = "fec_estreno")
    @Temporal(TemporalType.DATE)
    private Date fecEstreno;
    @Column(name = "idmedio")
    private Short idmedio;
    @JoinColumn(name = "idcategoria", referencedColumnName = "idcategoria")
    @ManyToOne
    private PeliculasCategorias idcategoria;
    @OneToMany(mappedBy = "idpelicula")
    private List<Facturas> facturasList;
    @OneToMany(mappedBy = "idpelicula")
    private List<Pases> pasesList;
    @OneToMany(mappedBy = "idpelicula")
    private List<SalasPeliculas> salasPeliculasList;
    @OneToMany(mappedBy = "idpelicula")
    private List<SalasProyector> salasProyectorList;
    @OneToMany(mappedBy = "idpelicula")
    private List<ActoresInterpretacion> actoresInterpretacionList;

    public Peliculas() {
    }

    public Peliculas(Short idpelicula) {
        this.idpelicula = idpelicula;
    }

    public Short getIdpelicula() {
        return idpelicula;
    }

    public void setIdpelicula(Short idpelicula) {
        this.idpelicula = idpelicula;
    }

    public String getNombrePelicula() {
        return nombrePelicula;
    }

    public void setNombrePelicula(String nombrePelicula) {
        this.nombrePelicula = nombrePelicula;
    }

    public BigDecimal getDuracion() {
        return duracion;
    }

    public void setDuracion(BigDecimal duracion) {
        this.duracion = duracion;
    }

    public Date getFecCaduciadad() {
        return fecCaduciadad;
    }

    public void setFecCaduciadad(Date fecCaduciadad) {
        this.fecCaduciadad = fecCaduciadad;
    }

    public Date getFecEstreno() {
        return fecEstreno;
    }

    public void setFecEstreno(Date fecEstreno) {
        this.fecEstreno = fecEstreno;
    }

    public Short getIdmedio() {
        return idmedio;
    }

    public void setIdmedio(Short idmedio) {
        this.idmedio = idmedio;
    }

    public PeliculasCategorias getIdcategoria() {
        return idcategoria;
    }

    public void setIdcategoria(PeliculasCategorias idcategoria) {
        this.idcategoria = idcategoria;
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
    public List<ActoresInterpretacion> getActoresInterpretacionList() {
        return actoresInterpretacionList;
    }

    public void setActoresInterpretacionList(List<ActoresInterpretacion> actoresInterpretacionList) {
        this.actoresInterpretacionList = actoresInterpretacionList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idpelicula != null ? idpelicula.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Peliculas)) {
            return false;
        }
        Peliculas other = (Peliculas) object;
        if ((this.idpelicula == null && other.idpelicula != null) || (this.idpelicula != null && !this.idpelicula.equals(other.idpelicula))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.Peliculas[ idpelicula=" + idpelicula + " ]";
    }
    
}
