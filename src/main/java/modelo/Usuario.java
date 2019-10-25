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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "usuario")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Usuario.findAll", query = "SELECT u FROM Usuario u")
    , @NamedQuery(name = "Usuario.findByUsuarioid", query = "SELECT u FROM Usuario u WHERE u.usuarioid = :usuarioid")
    , @NamedQuery(name = "Usuario.findByNombre", query = "SELECT u FROM Usuario u WHERE u.nombre = :nombre")
    , @NamedQuery(name = "Usuario.findByClave", query = "SELECT u FROM Usuario u WHERE u.clave = :clave")
    , @NamedQuery(name = "Usuario.findByCorreo", query = "SELECT u FROM Usuario u WHERE u.correo = :correo")
    , @NamedQuery(name = "Usuario.findByApodo", query = "SELECT u FROM Usuario u WHERE u.apodo = :apodo")
    , @NamedQuery(name = "Usuario.findBySnActivo", query = "SELECT u FROM Usuario u WHERE u.snActivo = :snActivo")
    , @NamedQuery(name = "Usuario.findByFecAlta", query = "SELECT u FROM Usuario u WHERE u.fecAlta = :fecAlta")})
public class Usuario implements Serializable {

    
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "usuarioid")
    private Short usuarioid;
    @Size(max = 50)
    @Column(name = "nombre")
    private String nombre;
    @Size(max = 20)
    @Column(name = "clave")
    private String clave;
    @Size(max = 50)
    @Column(name = "correo")
    private String correo;
    @Size(max = 20)
    @Column(name = "apodo")
    private String apodo;
    @Column(name = "sn_activo")
    private Boolean snActivo;
    @Column(name = "fec_alta")
    @Temporal(TemporalType.DATE)
    private Date fecAlta;
    
    //Relacion con facturas
    @OneToMany(mappedBy = "idusuario")
    @JsonbTransient // Rompe la relacion circular con facturas
    private List<Facturas> facturasList;
    
    //Relacion con empleados
    @JoinColumn(name = "idresponsable", referencedColumnName = "idresponsable")
    @ManyToOne
    @JsonbTransient // Rompe la relacion circular con empleados
    private Empleados idresponsable;

    public Usuario() {
    }

    public Usuario(Short usuarioid) {
        this.usuarioid = usuarioid;
    }

    public Short getUsuarioid() {
        return usuarioid;
    }

    public void setUsuarioid(Short usuarioid) {
        this.usuarioid = usuarioid;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getApodo() {
        return apodo;
    }

    public void setApodo(String apodo) {
        this.apodo = apodo;
    }

    public Boolean getSnActivo() {
        return snActivo;
    }

    public void setSnActivo(Boolean snActivo) {
        this.snActivo = snActivo;
    }

    public Date getFecAlta() {
        return fecAlta;
    }

    public void setFecAlta(Date fecAlta) {
        this.fecAlta = fecAlta;
    }

    @XmlTransient
    public List<Facturas> getFacturasList() {
        return facturasList;
    }

    public void setFacturasList(List<Facturas> facturasList) {
        this.facturasList = facturasList;
    }

    public Empleados getIdresponsable() {
        return idresponsable;
    }

    public void setIdresponsable(Empleados idresponsable) {
        this.idresponsable = idresponsable;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (usuarioid != null ? usuarioid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Usuario)) {
            return false;
        }
        Usuario other = (Usuario) object;
        if ((this.usuarioid == null && other.usuarioid != null) || (this.usuarioid != null && !this.usuarioid.equals(other.usuarioid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.Usuario[ usuarioid=" + usuarioid + " ]";
    }
    
}
