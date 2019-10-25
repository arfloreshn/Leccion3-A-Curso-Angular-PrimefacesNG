/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.io.Serializable;
import java.util.List;
import javax.json.bind.annotation.JsonbTransient;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author AllanRamiro
 */
@Entity
@Table(name = "funciones")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Funciones.findAll", query = "SELECT f FROM Funciones f")
    , @NamedQuery(name = "Funciones.findByIdfuncion", query = "SELECT f FROM Funciones f WHERE f.idfuncion = :idfuncion")
    , @NamedQuery(name = "Funciones.findByHorario", query = "SELECT f FROM Funciones f WHERE f.horario = :horario")})
public class Funciones implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "idfuncion")
    private Short idfuncion;
    @Size(max = 80)
    @Column(name = "horario")
    private String horario;
    
    @OneToMany(mappedBy = "idfuncion")
    @JsonbTransient // Rompe la relacion circular con facturas
    private List<Facturas> facturasList;
    
  
    @OneToMany(mappedBy = "idfuncion")
    @JsonbTransient // Rompe la relacion circular con los pases de cortesia
    private List<Pases> pasesList;
    
    @OneToMany(mappedBy = "idfuncion")
    private List<SalasPeliculas> salasPeliculasList;

    public Funciones() {
    }

    public Funciones(Short idfuncion) {
        this.idfuncion = idfuncion;
    }

    public Short getIdfuncion() {
        return idfuncion;
    }

    public void setIdfuncion(Short idfuncion) {
        this.idfuncion = idfuncion;
    }

    public String getHorario() {
        return horario;
    }

    public void setHorario(String horario) {
        this.horario = horario;
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

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idfuncion != null ? idfuncion.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Funciones)) {
            return false;
        }
        Funciones other = (Funciones) object;
        if ((this.idfuncion == null && other.idfuncion != null) || (this.idfuncion != null && !this.idfuncion.equals(other.idfuncion))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.Funciones[ idfuncion=" + idfuncion + " ]";
    }
    
}
