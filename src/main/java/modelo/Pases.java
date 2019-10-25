/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.io.Serializable;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author AllanRamiro
 */
@Entity
@Table(name = "pases")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Pases.findAll", query = "SELECT p FROM Pases p")
    , @NamedQuery(name = "Pases.findByIdpases", query = "SELECT p FROM Pases p WHERE p.idpases = :idpases")
    , @NamedQuery(name = "Pases.findByNroFila", query = "SELECT p FROM Pases p WHERE p.nroFila = :nroFila")
    , @NamedQuery(name = "Pases.findByNroButaca", query = "SELECT p FROM Pases p WHERE p.nroButaca = :nroButaca")
    , @NamedQuery(name = "Pases.findByFecVigDesde", query = "SELECT p FROM Pases p WHERE p.fecVigDesde = :fecVigDesde")
    , @NamedQuery(name = "Pases.findByFecVigHasta", query = "SELECT p FROM Pases p WHERE p.fecVigHasta = :fecVigHasta")})
public class Pases implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idpases")
    private Short idpases;
    @Column(name = "nro_fila")
    private Short nroFila;
    @Column(name = "nro_butaca")
    private Short nroButaca;
    @Column(name = "fec_vig_desde")
    @Temporal(TemporalType.DATE)
    private Date fecVigDesde;
    @Column(name = "fec_vig_hasta")
    @Temporal(TemporalType.DATE)
    private Date fecVigHasta;
    
    @JoinColumn(name = "idfuncion", referencedColumnName = "idfuncion")
    @ManyToOne
    @JsonbTransient // Rompe la relacion circular con funciones
    private Funciones idfuncion;
    
    @JoinColumn(name = "idmotivo", referencedColumnName = "idmotivo")
    @ManyToOne
    private MotivosCortesia idmotivo;
    
    @JoinColumn(name = "idpelicula", referencedColumnName = "idpelicula")
    @ManyToOne
    @JsonbTransient // Rompe la relacion circular con las peliculas
    private Peliculas idpelicula;
    
    @JoinColumn(name = "idsala", referencedColumnName = "idsala")
    @ManyToOne
    @JsonbTransient // Rompe la relacion circular con las salas
    private Salas idsala;

    public Pases() {
    }

    public Pases(Short idpases) {
        this.idpases = idpases;
    }

    public Short getIdpases() {
        return idpases;
    }

    public void setIdpases(Short idpases) {
        this.idpases = idpases;
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

    public Date getFecVigDesde() {
        return fecVigDesde;
    }

    public void setFecVigDesde(Date fecVigDesde) {
        this.fecVigDesde = fecVigDesde;
    }

    public Date getFecVigHasta() {
        return fecVigHasta;
    }

    public void setFecVigHasta(Date fecVigHasta) {
        this.fecVigHasta = fecVigHasta;
    }

    public Funciones getIdfuncion() {
        return idfuncion;
    }

    public void setIdfuncion(Funciones idfuncion) {
        this.idfuncion = idfuncion;
    }

    public MotivosCortesia getIdmotivo() {
        return idmotivo;
    }

    public void setIdmotivo(MotivosCortesia idmotivo) {
        this.idmotivo = idmotivo;
    }

    public Peliculas getIdpelicula() {
        return idpelicula;
    }

    public void setIdpelicula(Peliculas idpelicula) {
        this.idpelicula = idpelicula;
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
        hash += (idpases != null ? idpases.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Pases)) {
            return false;
        }
        Pases other = (Pases) object;
        if ((this.idpases == null && other.idpases != null) || (this.idpases != null && !this.idpases.equals(other.idpases))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.Pases[ idpases=" + idpases + " ]";
    }
    
}
