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
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author AllanRamiro
 */
@Entity
@Table(name = "salas_proyector")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "SalasProyector.findAll", query = "SELECT s FROM SalasProyector s")
    , @NamedQuery(name = "SalasProyector.findByIdsalaproyector", query = "SELECT s FROM SalasProyector s WHERE s.idsalaproyector = :idsalaproyector")
    , @NamedQuery(name = "SalasProyector.findByIdanuncios", query = "SELECT s FROM SalasProyector s WHERE s.idanuncios = :idanuncios")})
public class SalasProyector implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "idsalaproyector")
    private Short idsalaproyector;
    @Column(name = "idanuncios")
    private Short idanuncios;
    
    @JoinColumn(name = "idpelicula", referencedColumnName = "idpelicula")
    @ManyToOne
    @JsonbTransient // Rompe la relacion circular con peliculas
    private Peliculas idpelicula;
    
    @JoinColumn(name = "idproyector", referencedColumnName = "idproyector")
    @ManyToOne
    @JsonbTransient // Rompe la relacion circular con los proyectores
    private Proyectores idproyector;
    
    @JoinColumn(name = "idsala", referencedColumnName = "idsala")
    @ManyToOne
    @JsonbTransient // Rompe la relacion circular con las salas
    private Salas idsala;

    public SalasProyector() {
    }

    public SalasProyector(Short idsalaproyector) {
        this.idsalaproyector = idsalaproyector;
    }

    public Short getIdsalaproyector() {
        return idsalaproyector;
    }

    public void setIdsalaproyector(Short idsalaproyector) {
        this.idsalaproyector = idsalaproyector;
    }

    public Short getIdanuncios() {
        return idanuncios;
    }

    public void setIdanuncios(Short idanuncios) {
        this.idanuncios = idanuncios;
    }

    public Peliculas getIdpelicula() {
        return idpelicula;
    }

    public void setIdpelicula(Peliculas idpelicula) {
        this.idpelicula = idpelicula;
    }

    public Proyectores getIdproyector() {
        return idproyector;
    }

    public void setIdproyector(Proyectores idproyector) {
        this.idproyector = idproyector;
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
        hash += (idsalaproyector != null ? idsalaproyector.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SalasProyector)) {
            return false;
        }
        SalasProyector other = (SalasProyector) object;
        if ((this.idsalaproyector == null && other.idsalaproyector != null) || (this.idsalaproyector != null && !this.idsalaproyector.equals(other.idsalaproyector))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.SalasProyector[ idsalaproyector=" + idsalaproyector + " ]";
    }
    
}
