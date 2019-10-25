/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
@Table(name = "medio_proyeccion")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "MedioProyeccion.findAll", query = "SELECT m FROM MedioProyeccion m")
    , @NamedQuery(name = "MedioProyeccion.findByIdmedio", query = "SELECT m FROM MedioProyeccion m WHERE m.idmedio = :idmedio")
    , @NamedQuery(name = "MedioProyeccion.findByDescripcion", query = "SELECT m FROM MedioProyeccion m WHERE m.descripcion = :descripcion")})
public class MedioProyeccion implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idmedio")
    private Short idmedio;
    @Size(max = 50)
    @Column(name = "descripcion")
    private String descripcion;

    public MedioProyeccion() {
    }

    public MedioProyeccion(Short idmedio) {
        this.idmedio = idmedio;
    }

    public Short getIdmedio() {
        return idmedio;
    }

    public void setIdmedio(Short idmedio) {
        this.idmedio = idmedio;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idmedio != null ? idmedio.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof MedioProyeccion)) {
            return false;
        }
        MedioProyeccion other = (MedioProyeccion) object;
        if ((this.idmedio == null && other.idmedio != null) || (this.idmedio != null && !this.idmedio.equals(other.idmedio))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.MedioProyeccion[ idmedio=" + idmedio + " ]";
    }
    
}
