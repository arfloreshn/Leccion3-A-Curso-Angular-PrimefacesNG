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
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author AllanRamiro
 */
@Entity
@Table(name = "motivos_cortesia")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "MotivosCortesia.findAll", query = "SELECT m FROM MotivosCortesia m")
    , @NamedQuery(name = "MotivosCortesia.findByIdmotivo", query = "SELECT m FROM MotivosCortesia m WHERE m.idmotivo = :idmotivo")
    , @NamedQuery(name = "MotivosCortesia.findByDescripcion", query = "SELECT m FROM MotivosCortesia m WHERE m.descripcion = :descripcion")})
public class MotivosCortesia implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idmotivo")
    private Short idmotivo;
    @Size(max = 50)
    @Column(name = "descripcion")
    private String descripcion;
    
    @OneToMany(mappedBy = "idmotivo")
    @JsonbTransient // Rompe la relacion circular con los pases de cortesia
    private List<Pases> pasesList;

    public MotivosCortesia() {
    }

    public MotivosCortesia(Short idmotivo) {
        this.idmotivo = idmotivo;
    }

    public Short getIdmotivo() {
        return idmotivo;
    }

    public void setIdmotivo(Short idmotivo) {
        this.idmotivo = idmotivo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @XmlTransient
    public List<Pases> getPasesList() {
        return pasesList;
    }

    public void setPasesList(List<Pases> pasesList) {
        this.pasesList = pasesList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idmotivo != null ? idmotivo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof MotivosCortesia)) {
            return false;
        }
        MotivosCortesia other = (MotivosCortesia) object;
        if ((this.idmotivo == null && other.idmotivo != null) || (this.idmotivo != null && !this.idmotivo.equals(other.idmotivo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.MotivosCortesia[ idmotivo=" + idmotivo + " ]";
    }
    
}
