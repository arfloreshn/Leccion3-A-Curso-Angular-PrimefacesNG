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
@Table(name = "inventario_doc")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "InventarioDoc.findAll", query = "SELECT i FROM InventarioDoc i")
    , @NamedQuery(name = "InventarioDoc.findByIdmotivo", query = "SELECT i FROM InventarioDoc i WHERE i.idmotivo = :idmotivo")
    , @NamedQuery(name = "InventarioDoc.findByDescripcion", query = "SELECT i FROM InventarioDoc i WHERE i.descripcion = :descripcion")})
public class InventarioDoc implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idmotivo")
    private Short idmotivo;
    @Size(max = 50)
    @Column(name = "descripcion")
    private String descripcion;

    public InventarioDoc() {
    }

    public InventarioDoc(Short idmotivo) {
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

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idmotivo != null ? idmotivo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof InventarioDoc)) {
            return false;
        }
        InventarioDoc other = (InventarioDoc) object;
        if ((this.idmotivo == null && other.idmotivo != null) || (this.idmotivo != null && !this.idmotivo.equals(other.idmotivo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.InventarioDoc[ idmotivo=" + idmotivo + " ]";
    }
    
}
