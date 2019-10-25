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
@Table(name = "cafeteria")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Cafeteria.findAll", query = "SELECT c FROM Cafeteria c")
    , @NamedQuery(name = "Cafeteria.findByIdcafeteria", query = "SELECT c FROM Cafeteria c WHERE c.idcafeteria = :idcafeteria")
    , @NamedQuery(name = "Cafeteria.findByDescripcion", query = "SELECT c FROM Cafeteria c WHERE c.descripcion = :descripcion")
    , @NamedQuery(name = "Cafeteria.findByIdsucusal", query = "SELECT c FROM Cafeteria c WHERE c.idsucusal = :idsucusal")})
public class Cafeteria implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idcafeteria")
    private Short idcafeteria;
    @Size(max = 2147483647)
    @Column(name = "descripcion")
    private String descripcion;
    @Column(name = "idsucusal")
    private Short idsucusal;

    public Cafeteria() {
    }

    public Cafeteria(Short idcafeteria) {
        this.idcafeteria = idcafeteria;
    }

    public Short getIdcafeteria() {
        return idcafeteria;
    }

    public void setIdcafeteria(Short idcafeteria) {
        this.idcafeteria = idcafeteria;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Short getIdsucusal() {
        return idsucusal;
    }

    public void setIdsucusal(Short idsucusal) {
        this.idsucusal = idsucusal;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idcafeteria != null ? idcafeteria.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Cafeteria)) {
            return false;
        }
        Cafeteria other = (Cafeteria) object;
        if ((this.idcafeteria == null && other.idcafeteria != null) || (this.idcafeteria != null && !this.idcafeteria.equals(other.idcafeteria))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.Cafeteria[ idcafeteria=" + idcafeteria + " ]";
    }
    
}
