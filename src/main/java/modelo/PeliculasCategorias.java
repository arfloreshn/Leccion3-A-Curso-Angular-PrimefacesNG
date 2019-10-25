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
@Table(name = "peliculas_categorias")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PeliculasCategorias.findAll", query = "SELECT p FROM PeliculasCategorias p")
    , @NamedQuery(name = "PeliculasCategorias.findByIdcategoria", query = "SELECT p FROM PeliculasCategorias p WHERE p.idcategoria = :idcategoria")
    , @NamedQuery(name = "PeliculasCategorias.findByDescripcion", query = "SELECT p FROM PeliculasCategorias p WHERE p.descripcion = :descripcion")})
public class PeliculasCategorias implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "idcategoria")
    private Short idcategoria;
    @Size(max = 2147483647)
    @Column(name = "descripcion")
    private String descripcion;
    
    @OneToMany(mappedBy = "idcategoria")
    @JsonbTransient // Rompe la relacion circular con las peliculas
    private List<Peliculas> peliculasList;

    public PeliculasCategorias() {
    }

    public PeliculasCategorias(Short idcategoria) {
        this.idcategoria = idcategoria;
    }

    public Short getIdcategoria() {
        return idcategoria;
    }

    public void setIdcategoria(Short idcategoria) {
        this.idcategoria = idcategoria;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @XmlTransient
    public List<Peliculas> getPeliculasList() {
        return peliculasList;
    }

    public void setPeliculasList(List<Peliculas> peliculasList) {
        this.peliculasList = peliculasList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idcategoria != null ? idcategoria.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PeliculasCategorias)) {
            return false;
        }
        PeliculasCategorias other = (PeliculasCategorias) object;
        if ((this.idcategoria == null && other.idcategoria != null) || (this.idcategoria != null && !this.idcategoria.equals(other.idcategoria))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.PeliculasCategorias[ idcategoria=" + idcategoria + " ]";
    }
    
}
