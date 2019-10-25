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
 * @author AllanRamiroFlores
 */
@Entity
@Table(name = "actores_interpretacion")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ActoresInterpretacion.findAll", query = "SELECT a FROM ActoresInterpretacion a")
    , @NamedQuery(name = "ActoresInterpretacion.findByIdinterpretacion", query = "SELECT a FROM ActoresInterpretacion a WHERE a.idinterpretacion = :idinterpretacion")
    , @NamedQuery(name = "ActoresInterpretacion.findBySnReparto", query = "SELECT a FROM ActoresInterpretacion a WHERE a.snReparto = :snReparto")
    , @NamedQuery(name = "ActoresInterpretacion.findBySnProtagonista", query = "SELECT a FROM ActoresInterpretacion a WHERE a.snProtagonista = :snProtagonista")})
public class ActoresInterpretacion implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idinterpretacion")
    private Short idinterpretacion;
    @Column(name = "sn_reparto")
    private Boolean snReparto;
    @Column(name = "sn_protagonista")
    private Boolean snProtagonista;
    
    @JoinColumn(name = "idactor", referencedColumnName = "idactor")
    @ManyToOne
    @JsonbTransient // Rompe la relacion circular con los actores
    private Actores idactor;
    
    @JoinColumn(name = "idpelicula", referencedColumnName = "idpelicula")
    @ManyToOne
    @JsonbTransient // Rompe la relacion circular con las peliculas
    private Peliculas idpelicula;

    public ActoresInterpretacion() {
    }

    public ActoresInterpretacion(Short idinterpretacion) {
        this.idinterpretacion = idinterpretacion;
    }

    public Short getIdinterpretacion() {
        return idinterpretacion;
    }

    public void setIdinterpretacion(Short idinterpretacion) {
        this.idinterpretacion = idinterpretacion;
    }

    public Boolean getSnReparto() {
        return snReparto;
    }

    public void setSnReparto(Boolean snReparto) {
        this.snReparto = snReparto;
    }

    public Boolean getSnProtagonista() {
        return snProtagonista;
    }

    public void setSnProtagonista(Boolean snProtagonista) {
        this.snProtagonista = snProtagonista;
    }

    public Actores getIdactor() {
        return idactor;
    }

    public void setIdactor(Actores idactor) {
        this.idactor = idactor;
    }

    public Peliculas getIdpelicula() {
        return idpelicula;
    }

    public void setIdpelicula(Peliculas idpelicula) {
        this.idpelicula = idpelicula;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idinterpretacion != null ? idinterpretacion.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ActoresInterpretacion)) {
            return false;
        }
        ActoresInterpretacion other = (ActoresInterpretacion) object;
        if ((this.idinterpretacion == null && other.idinterpretacion != null) || (this.idinterpretacion != null && !this.idinterpretacion.equals(other.idinterpretacion))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.ActoresInterpretacion[ idinterpretacion=" + idinterpretacion + " ]";
    }
    
}
