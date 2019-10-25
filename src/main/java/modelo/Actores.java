/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author AllanRamiro
 */
@Entity
@Table(name = "actores")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Actores.findAll", query = "SELECT a FROM Actores a")
    , @NamedQuery(name = "Actores.findByIdactor", query = "SELECT a FROM Actores a WHERE a.idactor = :idactor")
    , @NamedQuery(name = "Actores.findByNombre", query = "SELECT a FROM Actores a WHERE a.nombre = :nombre")
    , @NamedQuery(name = "Actores.findByFechaNacimiento", query = "SELECT a FROM Actores a WHERE a.fechaNacimiento = :fechaNacimiento")
    , @NamedQuery(name = "Actores.findBySalario", query = "SELECT a FROM Actores a WHERE a.salario = :salario")
    , @NamedQuery(name = "Actores.findBySexo", query = "SELECT a FROM Actores a WHERE a.sexo = :sexo")
    , @NamedQuery(name = "Actores.findBySnActivo", query = "SELECT a FROM Actores a WHERE a.snActivo = :snActivo")
    , @NamedQuery(name = "Actores.findBySnGanoOscar", query = "SELECT a FROM Actores a WHERE a.snGanoOscar = :snGanoOscar")
    , @NamedQuery(name = "Actores.findByFecMuerte", query = "SELECT a FROM Actores a WHERE a.fecMuerte = :fecMuerte")})
public class Actores implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idactor")
    private Short idactor;
    @Size(max = 60)
    @Column(name = "nombre")
    private String nombre;
    @Column(name = "fecha_nacimiento")
    @Temporal(TemporalType.DATE)
    private Date fechaNacimiento;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "salario")
    private BigDecimal salario;
    @Size(max = 2147483647)
    @Column(name = "sexo")
    private String sexo;
    @Column(name = "sn_activo")
    private Boolean snActivo;
    @Column(name = "sn_gano_oscar")
    private Character snGanoOscar;
    @Column(name = "fec_muerte")
    @Temporal(TemporalType.DATE)
    private Date fecMuerte;
    
    @OneToMany(mappedBy = "idactor")
    private List<ActoresInterpretacion> actoresInterpretacionList;

    public Actores() {
    }

    public Actores(Short idactor) {
        this.idactor = idactor;
    }

    public Short getIdactor() {
        return idactor;
    }

    public void setIdactor(Short idactor) {
        this.idactor = idactor;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public BigDecimal getSalario() {
        return salario;
    }

    public void setSalario(BigDecimal salario) {
        this.salario = salario;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public Boolean getSnActivo() {
        return snActivo;
    }

    public void setSnActivo(Boolean snActivo) {
        this.snActivo = snActivo;
    }

    public Character getSnGanoOscar() {
        return snGanoOscar;
    }

    public void setSnGanoOscar(Character snGanoOscar) {
        this.snGanoOscar = snGanoOscar;
    }

    public Date getFecMuerte() {
        return fecMuerte;
    }

    public void setFecMuerte(Date fecMuerte) {
        this.fecMuerte = fecMuerte;
    }

    @XmlTransient
    public List<ActoresInterpretacion> getActoresInterpretacionList() {
        return actoresInterpretacionList;
    }

    public void setActoresInterpretacionList(List<ActoresInterpretacion> actoresInterpretacionList) {
        this.actoresInterpretacionList = actoresInterpretacionList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idactor != null ? idactor.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Actores)) {
            return false;
        }
        Actores other = (Actores) object;
        if ((this.idactor == null && other.idactor != null) || (this.idactor != null && !this.idactor.equals(other.idactor))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.Actores[ idactor=" + idactor + " ]";
    }
    
}
