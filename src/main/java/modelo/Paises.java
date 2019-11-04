/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.io.Serializable;
import java.util.Date;
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

/**
 *
 * @author AllanRamiro
 */
@Entity
@Table(name = "paises")
@NamedQueries({
    @NamedQuery(name = "Paises.findAll", query = "SELECT p FROM Paises p")})
public class Paises implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "paisid")
    private Short paisid;
    
    @Size(max = 50)
    @Column(name = "nom_pais")
    private String nomPais;
    
    @Column(name = "idcontinente")
    private int idContinente;
    
    
    @Column(name="fec_creacion")
    private Date fecIndependencia;
    

    @Size(max = 1)
    @Column(name="sn_monarquia")
    private String sn_monarquia;

    
    @OneToMany(mappedBy = "idpais")
    private List<Sociedad> sociedadList;
    
    @OneToMany(mappedBy = "idpais")
    private List<Sucursal> sucursalList;

    public Paises() {
    }

    public Paises(Short paisid) {
        this.paisid = paisid;
    }

    public Short getPaisid() {
        return paisid;
    }

    public void setPaisid(Short paisid) {
        this.paisid = paisid;
    }

    public String getNomPais() {
        return nomPais;
    }

    public void setNomPais(String nomPais) {
        this.nomPais = nomPais;
    }

    public int getIdContinente() {
        return idContinente;
    }

    public void setIdContinente(int idContinente) {
        this.idContinente = idContinente;
    }

    public Date getFecIndependencia() {
        return fecIndependencia;
    }

    public void setFecIndependencia(Date fecIndependencia) {
        this.fecIndependencia = fecIndependencia;
    }

    public String getSn_monarquia() {
        return sn_monarquia;
    }

    public void setSn_monarquia(String sn_monarquia) {
        this.sn_monarquia = sn_monarquia;
    }

    
    @JsonbTransient
    public List<Sociedad> getSociedadList() {
        return sociedadList;
    }

    public void setSociedadList(List<Sociedad> sociedadList) {
        this.sociedadList = sociedadList;
    }
    
    @JsonbTransient
    public List<Sucursal> getSucursalList() {
        return sucursalList;
    }

    public void setSucursalList(List<Sucursal> sucursalList) {
        this.sucursalList = sucursalList;
    }


    
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (paisid != null ? paisid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Paises)) {
            return false;
        }
        Paises other = (Paises) object;
        if ((this.paisid == null && other.paisid != null) || (this.paisid != null && !this.paisid.equals(other.paisid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.Paises[ paisid=" + paisid + " ]";
    }
    
}
