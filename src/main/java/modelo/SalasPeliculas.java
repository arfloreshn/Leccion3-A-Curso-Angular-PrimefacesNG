/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.io.Serializable;
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
@Table(name = "salas_peliculas")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "SalasPeliculas.findAll", query = "SELECT s FROM SalasPeliculas s")
    , @NamedQuery(name = "SalasPeliculas.findByIdrow", query = "SELECT s FROM SalasPeliculas s WHERE s.idrow = :idrow")})
public class SalasPeliculas implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idrow")
    private Short idrow;
    
    @JoinColumn(name = "idfuncion", referencedColumnName = "idfuncion")
    @ManyToOne
    @JsonbTransient // Rompe la relacion circular con funciones
    private Funciones idfuncion;
    
    @JoinColumn(name = "idpelicula", referencedColumnName = "idpelicula")
    @ManyToOne
    @JsonbTransient // Rompe la relacion circular con las peliculas
    private Peliculas idpelicula;
    
    @JoinColumn(name = "idsala", referencedColumnName = "idsala")
    @ManyToOne
    @JsonbTransient // Rompe la relacion circular con las salas
    private Salas idsala;

    public SalasPeliculas() {
    }

    public SalasPeliculas(Short idrow) {
        this.idrow = idrow;
    }

    public Short getIdrow() {
        return idrow;
    }

    public void setIdrow(Short idrow) {
        this.idrow = idrow;
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

    public Salas getIdsala() {
        return idsala;
    }

    public void setIdsala(Salas idsala) {
        this.idsala = idsala;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idrow != null ? idrow.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SalasPeliculas)) {
            return false;
        }
        SalasPeliculas other = (SalasPeliculas) object;
        if ((this.idrow == null && other.idrow != null) || (this.idrow != null && !this.idrow.equals(other.idrow))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.SalasPeliculas[ idrow=" + idrow + " ]";
    }
    
}
